package com.example.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.user.entity.User;
import com.example.user.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> getNewUsers() {
        return userRepository.getOrderByUpdatedAt(new PageRequest(0,5));
    }

    public Long getMaxUserId() {
        return userRepository.getMaxUserId();
    }

    public List<User> getRecommendedUsers() {
    		//todo ロジックを修正
        return userRepository.getOrderByUpdatedAt(new PageRequest(0,5));
    }

    public  Optional<User> findOne(Long id) {
        return userRepository.findById(id);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
