package CinemaDetectiveV1.Objects;

import javafx.application.Platform;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.function.Consumer;

// CDMS is the Cinema Detective Mail System

public class CDMS {

    private static CDMS instance;

    private final Path toRMailbox;
    private final Path fromRMailbox;
    private boolean watching = false;


    // Image hand off

    private Consumer<File> imageCallback;

    public void setImageCallback(Consumer<File> callback) {
        this.imageCallback = callback;
    }

    // Verify Image is actualy loaded

    private void notifyImageReady(File imageFile) {
        if (imageCallback != null) {
            imageCallback.accept(imageFile);
        }
    }

    private CDMS(Path toRMailbox, Path fromRMailbox) {
        this.toRMailbox = toRMailbox;
        this.fromRMailbox = fromRMailbox;
    }

    public static CDMS getInstance(Path toRMailbox, Path fromRMailbox) {
        if (instance == null) {
            instance = new CDMS(toRMailbox, fromRMailbox);
        }
        return instance;
    }

    public Path getToRMailbox() {
        return toRMailbox;
    }

    public Path getFromRMailbox() {
        return fromRMailbox;
    }

    /** Send CSV dataset to R mailbox as JSON */
    public void sendDataset(File csvFile) throws IOException {
        JsonConverter converter = new JsonConverter();
        String jsonOut = converter.convertCsvToJson(csvFile);

        if (!Files.exists(toRMailbox)) Files.createDirectories(toRMailbox);

        //String fileName = "data_set_" + System.currentTimeMillis() + ".json";
        Path jsonFile = toRMailbox.resolve("dataset.json");

        Files.writeString(jsonFile, jsonOut);
        System.out.println("Dataset sent to R mailbox: " + jsonFile);
    }

    /** Watch mailbox from R for new files */
    public void watchFromRMailbox() throws IOException {
        if (watching) return; // prevent multiple threads
        watching = true;

        if (!Files.exists(fromRMailbox)) Files.createDirectories(fromRMailbox);

        WatchService watchService = FileSystems.getDefault().newWatchService();
        fromRMailbox.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        System.out.println("Watching R mailbox: " + fromRMailbox);

        new Thread(() -> {
            while (true) {
                WatchKey key;
                try {
                    key = watchService.take();
                } catch (InterruptedException e) {
                    return;
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() != StandardWatchEventKinds.ENTRY_CREATE) continue;

                    Path fileName = (Path) event.context();
                    Path fullPath = fromRMailbox.resolve(fileName);

                    System.out.println("New file from R: " + fullPath);

                    // Only react to PNG images
                    if (fullPath.toString().toLowerCase().endsWith(".png")) {
                        Platform.runLater(() -> {
                            notifyImageReady(fullPath.toFile());
                        });
                    }
                }


                key.reset();
            }
        }, "R-Mailbox-Watcher").start();
    }
    public void runRScript(Path rScriptPath) throws IOException {

        ProcessBuilder pb = new ProcessBuilder(
                "C:/Program Files/R/R-4.4.2/bin/x64/Rscript.exe",
                "--vanilla",
                rScriptPath.toAbsolutePath().toString()
        );

        pb.directory(rScriptPath.getParent().toFile());
        pb.redirectErrorStream(true);

        var env = pb.environment();

        // 🔑 CRITICAL FIX
        String rHome = "C:/Program Files/R/R-4.4.2";
        env.put("R_HOME", rHome);
        env.put("PATH", rHome + "/bin/x64;" + env.getOrDefault("PATH", ""));

        // Mailbox vars
        env.put("R_MAILBOX_IN", toRMailbox.toAbsolutePath().toString());
        env.put("R_MAILBOX_OUT", fromRMailbox.toAbsolutePath().toString());



        System.out.println(">>> Launching Rscript with:");
        System.out.println(">>> Script: " + rScriptPath.toAbsolutePath());
        System.out.println(">>> R_HOME: " + env.get("R_HOME"));

        // Launching this way avoids a thread block on the UI

        Process process = pb.start();

        Thread readerThread = new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("[R] " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        readerThread.start();

        try {
            int exitCode = process.waitFor();
            readerThread.join();
            System.out.println(">>> R process exited with code: " + exitCode);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }









}


