package CinemaDetectiveV1.Objects;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.scene.control.CheckBox;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class SelectionPasser {

    // Map each enum type to a CheckBox → Enum mapping
    private final Map<Class<? extends Enum<?>>, Map<CheckBox, ? extends Enum<?>>> enumMaps = new HashMap<>();

    // Stores selections per enum class
    private final Map<Class<? extends Enum<?>>, List<? extends Enum<?>>> selections = new HashMap<>();


    // Store slider-based numeric selections
    private final Map<String, Long> numericSelections = new HashMap<>();


    private GraphType selectedGraphType;

    // Register a new checkbox → enum map
    public <E extends Enum<E>> void registerEnumMap(Class<E> enumClass , Map<CheckBox, E> map) {
        enumMaps.put(enumClass , map);
        selections.put(enumClass , new ArrayList<>());
    }


    public static class Range {
        public long getMin() {
            return min;
        }

        public long getMax() {
            return max;
        }

        public final long min;
        public final long max;

        public Range(long min , long max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public String toString() {
            return "(" + min + " – " + max + ")";
        }

    }



    private final Map<String, Long> sliderValues = new HashMap<>();


    public void setSliderValue(String key, long value) {
        sliderValues.put(key, value);
    }

    public long getSliderValue(String key) {
        return sliderValues.getOrDefault(key, 0L);
    }


public GraphType getSelectedGraphType(){
        return selectedGraphType;
}

public void setSelectedGraphType(GraphType selectedGraphType){
        this.selectedGraphType = selectedGraphType;
}













    // Collect selections for a specific enum type
    public <E extends Enum<E>> List<E> populateSelections(Class<E> enumClass) {
        Map<CheckBox, E> map = (Map<CheckBox, E>) enumMaps.get(enumClass);
        if (map == null) {
            System.err.println("⚠ No map registered for " + enumClass.getSimpleName());
            return Collections.emptyList();
        }

        List<E> selected = new ArrayList<>();

        for (Map.Entry<CheckBox, E> entry : map.entrySet()) {
            if (entry.getKey().isSelected()) {
                selected.add(entry.getValue());
            }
        }

        // Handle ALL option if present
        if (selected.stream().anyMatch(e -> e.name().equals("ALL"))) {
            selected.clear();
            selected.add(Enum.valueOf(enumClass, "ALL"));
        }

        selections.put(enumClass, selected);
        return selected;
    }

    // One call to populate everything
    public void applyAllSelections() {
        for (Class<? extends Enum<?>> enumClass : enumMaps.keySet()) {
            populateSelections((Class) enumClass);
        }
    }

    // Retrieve selections
    public <E extends Enum<E>> List<E> getSelections(Class<E> enumClass) {
        return (List<E>) selections.getOrDefault(enumClass, List.of());
    }

    // Debug helper
    public void printSelections() {
        for (var entry : selections.entrySet()) {
            System.out.println(entry.getKey().getSimpleName() + " = " + entry.getValue());
        }
    }

    public void printAll() {
        System.out.println("=== GRAPH TYPE ===");
        System.out.println(
                selectedGraphType != null
                        ? selectedGraphType.name()
                        : "NULL"
        );

        System.out.println("=== ENUM SELECTIONS ===");
        printSelections();

        System.out.println("=== NUMERIC RANGES ===");
        numericSelections.forEach((k, v) -> System.out.println(k + " = " + v));
    }


    public void setNumericSelection(String key, long value) {
        numericSelections.put(key, value);
    }

    public Map<String, Long> getNumericSelections() {
        return numericSelections;
    }


    public void exportSelectionsToJson(String filePath) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();

        // Add graph type selection

        GraphType gt = getSelectedGraphType();
        if (gt != null) {
            ArrayNode graphTypeArray = root.putArray("GraphType");
            graphTypeArray.add(gt.name());
        }
        // Add enum selections
        selections.forEach((enumClass, enumList) -> {
            ArrayNode arrayNode = mapper.createArrayNode();
            for (Enum<?> e : enumList) {
                arrayNode.add(e.name());
            }
            root.set(enumClass.getSimpleName(), arrayNode);
        });

        // Add numeric selections
        ObjectNode sliderNode = mapper.createObjectNode();
        numericSelections.forEach(sliderNode::put);
        root.set("Sliders", sliderNode);



        // Write JSON to file
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), root);
            System.out.println("JSON export successful: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }











}
