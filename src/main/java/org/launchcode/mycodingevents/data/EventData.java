package org.launchcode.mycodingevents.data;

import org.launchcode.mycodingevents.controllers.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {
    private static Map<Integer, Event> events = new HashMap<>();


    public static Collection<Event> getAll() {
        return events.values();
    }

    public static void add(Event event) {
        events.put(event.getId(), event);
    }

    public static Event getById(Integer Id) {
        return events.get(Id);
    }

    public static void remove(Integer id) {
        if (events.containsKey(id))
            events.remove(id);
    }
}
