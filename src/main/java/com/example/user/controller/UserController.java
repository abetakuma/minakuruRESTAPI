package com.example.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

import com.example.user.Form.UserForm;
import com.example.user.entity.FreeTime;
import com.example.user.entity.User;
import com.example.user.service.FreeTimeService;
import com.example.user.service.UserService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("api/users")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private FreeTimeService freeTimeService;

    @GetMapping
    public List<User> getAll() {
        List<User> users = userService.findAll();
        return users;
    }

    @GetMapping("{id}")
    public Optional<UserForm> show(@PathVariable Long id) {
        Optional<User> user = userService.findOne(id);
        Optional<FreeTime> freeTime = freeTimeService.findOne(id);

        UserForm userForm = new UserForm();

		BeanUtils.copyProperties(user.get(), userForm);
		BeanUtils.copyProperties(freeTime.get(), userForm);

        Optional<UserForm> userFormOptional = Optional.of(userForm);

        return userFormOptional;
    }

    @GetMapping("updatedAt")
    public List<User> getNewUsers() {
        List<User> users = userService.getNewUsers();
        return users;
    }


    @GetMapping("recommended")
    public List<User> getRecommendedUsers() {
        List<User> users = userService.getRecommendedUsers();
        return users;
    }

    @PostMapping
    @Transactional
    public void save(@RequestBody UserForm userForm) {
    		User user = new User();
    		FreeTime freeTime = new FreeTime();

    		BeanUtils.copyProperties(userForm, user);
    		BeanUtils.copyProperties(userForm, freeTime);

        userService.save(user);
        freeTimeService.save(freeTime);
    }

    @GetMapping("new")
    public String newUser(Model model) {
        return "users/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) { // ⑤
        Optional<User> user = userService.findOne(id);
        return "users/edit";
    }

    @PutMapping("{userId}")
    @Transactional
    public void update(@PathVariable Long userId, @RequestBody UserForm userForm) {
		User user = new User();
		FreeTime freeTime = new FreeTime();

		BeanUtils.copyProperties(userForm, user);
		user.setUserId(userId);

		BeanUtils.copyProperties(userForm, freeTime);

	    userService.save(user);
	    freeTimeService.save(freeTime);
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
