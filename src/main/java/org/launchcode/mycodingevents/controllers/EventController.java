package org.launchcode.mycodingevents.controllers;

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

    private static Map<String, String> events = new HashMap<>();

    @GetMapping
    public String displayAllEvents(Model model) {

//        model.addAttribute("events", events);
//        return "events/index";
        events.put("Apple WWDC", "Apple world web developer conference");
        events.put("SpringOne platform", "Spring one meetup of java developers");
        events.put("Strange Loop", "This is an event in STL");

        model.addAttribute("events", events);
        return "events/index";
    }

//    @GetMapping("create")
//    public String renderCreateEventForm() {
//        return "events/create";
//    }
//
//    @PostMapping("create")
//    public String createEvent(@RequestParam String eventName) {
//        events.add(eventName);
//        return "redirect:";
//    }
}
