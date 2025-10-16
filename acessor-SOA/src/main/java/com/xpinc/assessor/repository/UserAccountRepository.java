package com.xpinc.assessor.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.xpinc.assessor.domain.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
	Optional<UserAccount> findByUsername(String username);

	boolean existsByUsername(String username);
}
