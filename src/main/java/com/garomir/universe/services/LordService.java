package com.garomir.universe.services;

import com.garomir.universe.entities.Lord;

import java.util.List;

public interface LordService {
    Lord addLord(Lord lord);
    List<Lord> getFreeLords();
    List<Lord> getTop10Lords();
}