package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventData {
    //need a place to put the Events
    private static final Map<Integer, Event>eventMap = new HashMap<>();

    //get all events
    public static Collection<Event> getAll(){
        return eventMap.values();
    }

    //get a single event
    public static Event getById(int id){
        return eventMap.get(id);
    }

    //add an event
    public static void add(Event event){
        eventMap.put(event.getId(), event);
    }

    //remove an event
    public static void remove(int id){
        eventMap.remove(id);
    }
}
