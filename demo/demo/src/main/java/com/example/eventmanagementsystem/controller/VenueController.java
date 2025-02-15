package com.example.eventmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.eventmanagementsystem.entity.Venue;
import com.example.eventmanagementsystem.exception.ResourceNotFoundException;
import com.example.eventmanagementsystem.repository.VenueRepository;

import java.util.List;

@RestController
@RequestMapping("/api/venues")
public class VenueController {
	
	public VenueController() {
		// TODO Auto-generated constructor stub
	}

    @Autowired
    private VenueRepository venueRepository;

    // GET all venues
    @GetMapping
    public ResponseEntity<List<Venue>> getAllVenues() {
        List<Venue> venues = venueRepository.findAll();
        return ResponseEntity.ok(venues);
    }

    // GET venue by ID
    @GetMapping("/{id}")
    public ResponseEntity<Venue> getVenueById(@PathVariable Long id) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venue not found with id " + id));
        return ResponseEntity.ok(venue);
    }

    // POST create a new venue
    @PostMapping
    public ResponseEntity<Venue> createVenue(@RequestBody Venue venue) {
        try {
            Venue savedVenue = venueRepository.save(venue);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedVenue);
        } catch (Exception e) {
            // Log the exception (optional) and return an error response
            e.printStackTrace(); // For debugging purposes, replace with proper logging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(null);
        }
    }
}
