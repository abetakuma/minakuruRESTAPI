package com.example.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.security.entity.UserLoginInfo;
import com.example.security.repository.UserLoginInfoRepository;

@Service
public class UserLoginInfoService {
    @Autowired
    private UserLoginInfoRepository userLoginInfoRepository;

    public List<UserLoginInfo> findAll() {
        return userLoginInfoRepository.findAll();
    }

    public  Optional<UserLoginInfo> findOne(Long userId) {
        return userLoginInfoRepository.findById((userId));
    }

    public void save(UserLoginInfo userLoginInfo) {
        userLoginInfoRepository.save(userLoginInfo);
    }
}
