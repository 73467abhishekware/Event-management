package com.example.eventmanagementsystem.controller;

import com.example.eventmanagementsystem.entity.Organizer;
import com.example.eventmanagementsystem.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organizers")
public class OrganizerController {
    @Autowired
    private OrganizerService organizerService;

    @PostMapping
    public Organizer createOrganizer(@RequestBody Organizer organizer) {
        return organizerService.createOrganizer(organizer);
    }

    @GetMapping("/{id}")
    public Organizer getOrganizerById(@PathVariable Long id) {
        return organizerService.getOrganizerById(id);
    }

    @PutMapping("/{id}")
    public Organizer updateOrganizer(@PathVariable Long id, @RequestBody Organizer organizer) {
        return organizerService.updateOrganizer(id, organizer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable Long id) {
        organizerService.deleteOrganizer(id);
        return ResponseEntity.ok().build();
    }
}