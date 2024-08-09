package com.example.eventmanagementsystem.repository;

import com.example.eventmanagementsystem.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}
