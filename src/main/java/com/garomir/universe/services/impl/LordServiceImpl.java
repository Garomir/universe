package com.garomir.universe.services.impl;

import com.garomir.universe.entities.Lord;
import com.garomir.universe.repos.LordRepo;
import com.garomir.universe.services.LordService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LordServiceImpl implements LordService {

    private LordRepo lordRepo;

    public LordServiceImpl(LordRepo lordRepo) {
        this.lordRepo = lordRepo;
    }

    @Override
    public Lord addLord(Lord lord) {
        return lordRepo.save(lord);
    }

    @Override
    public List<Lord> getFreeLords() {
        List<Lord> lords = lordRepo.findAll();
        List<Lord> freeLords = lordRepo.findAll();
        for (Lord l: lords) {
            if (l.getPlanets().size() < 1){
                freeLords.add(l);
            }
        }
        return freeLords;
    }

    @Override
    public List<Lord> getTop10Lords() {
        List<Lord> lords = lordRepo.findAll().stream()
                .sorted(Lord::compareTo)
                .collect(Collectors.toList());
        List<Lord> top10Lords = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            top10Lords.add(lords.get(i));
        }
        return top10Lords;
    }
}
