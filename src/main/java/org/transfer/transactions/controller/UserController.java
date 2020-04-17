package org.transfer.transactions.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.transfer.transactions.model.User;
import org.transfer.transactions.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers().join();
	}

	@GetMapping("/users/{id}")
	public long getAmount(@PathVariable long id) {
		return userService.getAmount(id).join();
	}
}
