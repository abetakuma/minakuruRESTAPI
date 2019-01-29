package com.example.idea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.idea.entity.RelationIdeasUsers;
import com.example.idea.repository.RelationIdeasUsersRepository;

@Service
public class RelationIdeasUsersService {
    @Autowired
    private RelationIdeasUsersRepository relationIdeasUsersRepository;

    public List<RelationIdeasUsers> findAll() {
        return relationIdeasUsersRepository.findAll();
    }

    public  Optional<RelationIdeasUsers> findOne(Long id) {
        return relationIdeasUsersRepository.findById(id);
    }

    public void save(RelationIdeasUsers relationIdeasUsers) {
        relationIdeasUsersRepository.save(relationIdeasUsers);
    }

    public void delete(Long id) {
        relationIdeasUsersRepository.deleteById(id);
    }
}
