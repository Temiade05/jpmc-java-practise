package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {
    // Empty! Spring Boot implements this for us automatically.
    // It gives us methods like .save(), .findAll(), .delete() for free.
}
