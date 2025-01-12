package cz.cvut.fel.omo.smartfarm.chainOfResponsibility;

import java.util.*;

/**
 * Represents an event within the smart farm system.
 * An event is characterized by its type and a descriptive text.
 */
public class Event {
    private final EventType type;
    private final String description;

    /**
     * Constructs a new event with the specified type and description.
     *
     * @param type The type of the event, defined in the EventType enum.
     * @param description A descriptive text for the event.
     */
    public Event(EventType type, String description) {
        this.type = type;
        this.description = description;
    }

    /**
     * Returns the type of this event.
     *
     * @return The EventType of this event.
     */
    public EventType getType() {
        return type;
    }

    /**
     * Returns the description of this event.
     *
     * @return A string representing the description of this event.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Creates a random event with a predefined description.
     * The type of event is randomly selected from the EventType enum.
     *
     * @return A new random Event instance.
     */
    public static Event createRandomEvent() {
        Random random = new Random();
        EventType type = EventType.values()[random.nextInt(EventType.values().length)];
        String description = "Random event description";
        return new Event(type, description);
    }

    /**
     * Generates a list of random events.
     *
     * @param count The number of random events to generate.
     * @return A list of random Event instances.
     */
    public static List<Event> createRandomEvents(int count) {
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            events.add(createRandomEvent());
        }
        return events;
    }

    /**
     * Provides a string representation of the event, including its type and description.
     *
     * @return A string representation of this event.
     */
    @Override
    public String toString() {
        return "Event{" +
                "type=" + type +
                ", description='" + description + '\'' +
                '}';
    }
}
