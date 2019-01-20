package com.example.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.entity.FreeTime;
import com.example.user.repository.FreeTimeRepository;

@Service
public class FreeTimeService {
    @Autowired
    private UserService userService;
    @Autowired
    private FreeTimeRepository freeTimeRepository;

    public List<FreeTime> findAll() {
        return freeTimeRepository.findAll();
    }

    public  Optional<FreeTime> findOne(Long id) {
        return freeTimeRepository.findById(id);
    }

    public void save(FreeTime freeTime) {
    		Long userId = userService.getMaxUserId();
    		freeTime.setUserId(userId);
        freeTimeRepository.save(freeTime);
    }

    public void delete(Long id) {
        freeTimeRepository.deleteById(id);
    }
}
