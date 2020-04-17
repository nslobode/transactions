package org.transfer.transactions.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.transfer.transactions.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
