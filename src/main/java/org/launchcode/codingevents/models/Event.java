package org.launchcode.codingevents.models;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Event {
    private int id;
    private static int nextId = 1;


    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private  String eventName;

    @NotBlank(message = "Description required")
    @Size(max = 500,message = "Description too long")
    private String eventDescription;

    @NotBlank(message = "Address required!")
    private String eventAddress;

    @NotBlank(message = "Email is required!")
    @Email(message = "invalid email. Try again.")
    private String contactEmail;
    private EventType type;

    public int getId() {
        return id;
    }



    public Event(String eventName,String eventDescription,String eventAddress,String contactEmail,EventType type) {
        this();
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventAddress = eventAddress;
        this.contactEmail = contactEmail;
        this.type = type;

    }

    public Event(){
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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
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
