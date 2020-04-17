package org.transfer.transactions.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.transfer.transactions.exceptions.DBException;
import org.transfer.transactions.exceptions.MoneyException;
import org.transfer.transactions.model.User;
import org.transfer.transactions.repo.UserRepository;

import java.sql.SQLException;

@Component
@RequiredArgsConstructor
@Slf4j
public class TransferService {

	private final UserRepository repository;

	@Async
	public void transfer(Long source, Long target, Long amount) {
		User sourceDB = getSource(source);
		User targetDB = getTarget(target);
		if (sourceDB.getMoney() - amount >= 0) {
			sourceDB.setMoney(sourceDB.getMoney() - amount);
			targetDB.setMoney(targetDB.getMoney() + amount);

			repository.save(sourceDB);
			repository.save(targetDB);
		} else {
			throw new MoneyException("Source user doesn't have enough money");
		}
	}

	private User getSource(long source) {
		try {
			return repository.findById(source).orElseThrow(SQLException::new);
		} catch (SQLException e) {
			log.error("Can't find source user {}", source);
			throw new DBException("Can't find source user");
		}
	}

	private User getTarget(long target) {
		try {
			return repository.findById(target).orElseThrow(SQLException::new);
		} catch (SQLException e) {
			log.error("Can't find source user {}", target);
			throw new DBException("Can't find source user");
		}
	}
}
