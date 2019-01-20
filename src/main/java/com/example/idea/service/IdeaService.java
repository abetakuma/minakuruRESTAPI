package com.example.idea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.idea.entity.Idea;
import com.example.idea.repository.IdeaRepository;

@Service
public class IdeaService {
    @Autowired
    private IdeaRepository ideaRepository;

    public List<Idea> findAll() {
        return ideaRepository.findAll();
    }

    public List<Idea> getNewIdeas() {
        return ideaRepository.getOrderByUpdatedAt(new PageRequest(0,5));
    }

    public List<Idea> getRecommendedIdeas() {
    		//todo ロジックを修正
        return ideaRepository.getOrderByUpdatedAt(new PageRequest(0,5));
    }

    public  Optional<Idea> findOne(Long id) {
        return ideaRepository.findById(id);
    }

    public void save(Idea idea) {
        ideaRepository.save(idea);
    }

    public void delete(Long id) {
        ideaRepository.deleteById(id);
    }
}
