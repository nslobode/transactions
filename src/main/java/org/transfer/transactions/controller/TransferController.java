package org.transfer.transactions.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.transfer.transactions.service.TransferService;

@RestController
@RequiredArgsConstructor
public class TransferController {

	private final TransferService transferService;

	@PostMapping("/transfer")
	public void performTransaction(Long source, Long target, Long amount) {
		transferService.transfer(source, target, amount);
	}
}
