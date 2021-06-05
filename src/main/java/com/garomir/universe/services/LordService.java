package com.garomir.universe.services;

import com.garomir.universe.entities.Lord;

import java.util.List;
import java.util.Optional;

public interface LordService {
    Lord addLord(Lord lord);
    List<Lord> getFreeLords();
    List<Lord> getTop10Lords();
    List<Lord> getAllLords();
    boolean isLordExists(int id);
}