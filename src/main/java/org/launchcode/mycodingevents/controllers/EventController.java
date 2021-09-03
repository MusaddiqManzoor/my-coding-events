package org.launchcode.mycodingevents.controllers;

import org.launchcode.mycodingevents.controllers.models.Event;
import org.launchcode.mycodingevents.data.EventData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {


    @GetMapping
    public String displayAllEvents(Model model) {

        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@ModelAttribute Event newEvent) {
        EventData.add(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for(int id: eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("/edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        // controller code will go here
        Event selectedEvent = EventData.getById(eventId);
       model.addAttribute("event",selectedEvent);
//       String title = "Edit Event" + selectedEvent.getName() + "(id=" + selectedEvent.getId() + ")";
//       model.addAttribute("title", title);
       return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description) {
        // controller code will go here
        Event selectedEvent = EventData.getById(eventId);
        selectedEvent.setName(name);
        selectedEvent.setDescription(description);
        return "redirect:";
    }
}
