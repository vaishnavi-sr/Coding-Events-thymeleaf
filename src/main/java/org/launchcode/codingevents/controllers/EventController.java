package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("events")
public class EventController {
//    private static List<String> events = new ArrayList<>();
    private static Map<String,String> eventsMap = new HashMap<>();
//    private static List<Event> events = new ArrayList<>();


//    @GetMapping
//    public String displayAllEvents(Model model) {
//        model.addAttribute("events", events);
//        return "events/index";
//    }

    @GetMapping
    public String displayAllEvents(Model model){
       // Map<String,String> eventsMap=new HashMap<>();

     /*   for (String event:events) {
            eventsMap.put(event,event+" saint louis");
        }
        */

   //     eventsMap.put("Menteaship","A fun meetup for connecting with mentors");
      //  eventsMap.put("Code With Pride","A fun meetup sponsored by LaunchCode");
      //  eventsMap.put("Javascripty", "An imaginary meetup for Javascript developers");
//        model.addAttribute("events",eventsMap);
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    //lives at events/create
    @GetMapping("create")
    public String displayCreateEventForm() {
        return "events/create";
    }

    //lives at events/create
    @PostMapping("create")
    public String createEvent(@ModelAttribute Event newEvent){
        System.out.println("eventName");
      //  events.add(eventName);
        Event event = new Event();
        EventData.add(newEvent);
//        event.setEventName(eventName);
//        event.setEventDescription(eventDescription);
//        event.setEventAddress(eventAddress);
//        EventData.add(event);
//        eventsMap.put(eventName,eventDescription);

        return "redirect: ";
    }
    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title","Delete Events");
        model.addAttribute("events",EventData.getAll());
        return "events/delete";
    }
    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {

        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }

        return "redirect:";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId){
        Event eventToEdit = EventData.getById(eventId);
        model.addAttribute("event", eventToEdit);
        String title = "Edit Event " + eventToEdit.getEventName() + " (id=" + eventToEdit.getId() + ")" + eventToEdit.getEventAddress();
        model.addAttribute("title", title );
        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description, String address) {
        Event eventToEdit = EventData.getById(eventId);
        eventToEdit.setEventName(name);
        eventToEdit.setEventDescription(description);
        eventToEdit.setEventAddress(address);
        EventData.add(eventToEdit);

        return "redirect:";

    }
}
