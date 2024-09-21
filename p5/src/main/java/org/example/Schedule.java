package org.example;
import java.util.*;
class Schedule {
    private final Map<String, List<String>> schedule = new LinkedHashMap<>();
    public void add(String day, String event) {
        if (!schedule.containsKey(day)) {
            schedule.put(day, new ArrayList<>());
        }

        for (Map.Entry<String, List<String>> entry : schedule.entrySet()) {
            if (entry.getValue().contains(event)) {
                System.out.println("Мероприятие '" + event + "' уже добавлено в день: " + entry.getKey());
                break;
            }
        }
        schedule.get(day).add(event);
    }
    public void printSchedule() {
        for (Map.Entry<String, List<String>> entry : schedule.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}