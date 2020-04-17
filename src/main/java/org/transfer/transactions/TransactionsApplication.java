package org.transfer.transactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class TransactionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionsApplication.class, args);
	}

}
