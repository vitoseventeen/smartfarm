package cz.cvut.fel.omo.smartfarm.chainOfResponsibility;

import java.util.*;

public class Event {
    private final EventType type;
    private final String description;

    public Event(EventType type, String description) {
        this.type = type;
        this.description = description;
    }

    public EventType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public static Event createRandomEvent() {
        Random random = new Random();
        EventType type = EventType.values()[random.nextInt(EventType.values().length)];
        String description = "Random event description";
        return new Event(type, description);
    }

    public static List<Event> createRandomEvents(int count) {
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            events.add(createRandomEvent());
        }
        return events;
    }

    @Override
    public String toString() {
        return "Event{" +
                "type=" + type +
                ", description='" + description + '\'' +
                '}';
    }
}
