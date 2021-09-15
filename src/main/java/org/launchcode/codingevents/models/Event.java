package org.launchcode.codingevents.models;

import java.util.Objects;

public class Event {
    private String eventName;
    private String eventDescription;
    private String eventAddress;
    private static int nextId = 1;

    public int getId() {
        return id;
    }

    private int id;

    public Event(String eventName,String eventDescription,String eventAddress) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventAddress = eventAddress;
        this.id = nextId;
        nextId++;
    }



    public Event() {
        this.eventName=getEventName();
        this.eventDescription = getEventDescription();
        this.eventAddress = getEventAddress();
        this.id = nextId;
        nextId++;
    }


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }
    @Override
    public String toString() {
        return eventName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
