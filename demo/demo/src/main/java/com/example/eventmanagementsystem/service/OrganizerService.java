package com.example.eventmanagementsystem.service;

import com.example.eventmanagementsystem.entity.Organizer;
import com.example.eventmanagementsystem.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRepository organizerRepository;

    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public Organizer getOrganizerById(Long id) {
        return organizerRepository.findById(id).orElse(null);
    }

    public Organizer updateOrganizer(Long id, Organizer organizer) {
        organizer.setId(id);
        return organizerRepository.save(organizer);
    }

    public void deleteOrganizer(Long id) {
        organizerRepository.deleteById(id);
    }
}
