package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("events")
public class EventController {
    private static List<String> events = new ArrayList<>();
    private static Map<String,String> eventsMap = new HashMap<>();
    private static List<Event> eventObjects = new ArrayList<>();


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
        model.addAttribute("events",eventObjects);
        return "events/index";
    }

    //lives at events/create
    @GetMapping("create")
    public String displayCreateEventForm() {
        return "events/create";
    }

    //lives at events/create
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName,@RequestParam String eventDescription,@RequestParam String eventAddress){
        System.out.println("eventName");
      //  events.add(eventName);
        Event event = new Event();
        event.setEventName(eventName);
        event.setEventDescription(eventDescription);
        event.setEventAddress(eventAddress);
        eventObjects.add(event);
        eventsMap.put(eventName,eventDescription);

        return "redirect: ";
    }


}
