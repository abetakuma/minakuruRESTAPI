package com.example.idea.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.idea.Entity.Idea;
import com.example.idea.service.IdeaService;

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

    @GetMapping("{id}")
    public Optional<Idea> show(@PathVariable Long id) {
        Optional<Idea> idea = ideaService.findOne(id);

        return idea;
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


    @PostMapping
    public String create(@ModelAttribute Idea idea) { // ⑥
        ideaService.save(idea);
        return "redirect:/ideas"; // ⑦
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Idea idea) {
//        idea.setId(id);
//        ideaService.save(idea);
        return "redirect:/ideas";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        ideaService.delete(id);
        return "redirect:/ideas";
    }
}
