package com.example.eventmanagementsystem.repository;

import com.example.eventmanagementsystem.entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}
