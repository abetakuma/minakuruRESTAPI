package com.example.idea.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.idea.entity.Idea;
import com.example.idea.service.IdeaService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("api/ideas")
public class IdeaController {
	@Autowired
	private IdeaService ideaService;

    @GetMapping
    public List<Idea> getAll() {
        List<Idea> ideas = ideaService.findAll();
        return ideas;
    }

    @GetMapping("updatedAt")
    public List<Idea> getNewIdeas() {
        List<Idea> ideas = ideaService.getNewIdeas();
        return ideas;
    }


    @GetMapping("recommended")
    public List<Idea> getRecommendedIdeas() {
        List<Idea> ideas = ideaService.getRecommendedIdeas();
        return ideas;
    }

    @GetMapping("{id}")
    public Optional<Idea> show(@PathVariable Long id) {
        Optional<Idea> idea = ideaService.findOne(id);

        return idea;
    }

    @PostMapping
    public void save(@RequestBody Idea idea) {
        ideaService.save(idea);
    }

    @GetMapping("new")
    public String newIdea(Model model) {
        return "ideas/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) { // ⑤
        Optional<Idea> idea = ideaService.findOne(id);
        return "ideas/edit";
    }

    @PutMapping("{ideaId}")
    public void update(@PathVariable Long ideaId, @RequestBody Idea idea) {
		idea.setIdeaId(ideaId);

        ideaService.save(idea);
    }

    @DeleteMapping("{id}")
    public void destroy(@PathVariable Long id) {
        ideaService.delete(id);
    }
}
