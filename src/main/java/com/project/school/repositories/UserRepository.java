package com.project.school.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.school.entities.User;
import com.project.school.enums.UserRole;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByRole(UserRole userRole);

	Optional<User> findFirstByEmail(String email);
}
