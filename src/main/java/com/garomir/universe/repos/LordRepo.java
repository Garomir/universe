package com.garomir.universe.repos;

import com.garomir.universe.entities.Lord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LordRepo extends JpaRepository<Lord, Integer> {
}
