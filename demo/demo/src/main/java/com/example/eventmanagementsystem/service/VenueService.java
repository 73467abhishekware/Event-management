package com.example.eventmanagementsystem.service;

import com.example.eventmanagementsystem.entity.Venue;
import com.example.eventmanagementsystem.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {
    @Autowired
    private VenueRepository venueRepository;

    public Venue createVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    public Venue getVenueById(Long id) {
        return venueRepository.findById(id).orElse(null);
    }

    public Venue updateVenue(Long id, Venue venue) {
        venue.setId(id);
        return venueRepository.save(venue);
    }

    public void deleteVenue(Long id) {
        venueRepository.deleteById(id);
    }
}
