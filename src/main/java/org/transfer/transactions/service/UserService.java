package org.transfer.transactions.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.transfer.transactions.exceptions.DBException;
import org.transfer.transactions.model.User;
import org.transfer.transactions.repo.UserRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repository;

	@Async
	public CompletableFuture<List<User>> getAllUsers() {
		return CompletableFuture.completedFuture(repository.findAll());
	}

	@Async
	public CompletableFuture<Long> getAmount(long id) {
		return CompletableFuture.completedFuture(repository.findById(id)
				.orElseThrow(() -> new DBException("Can't find user with id " + id))
				.getMoney());
	}
}
