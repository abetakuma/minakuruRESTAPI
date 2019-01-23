package com.example.user.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select u from User u order by u.updatedAt DESC")
	List<User> getOrderByUpdatedAt(Pageable pageable);

	@Query("select max(u.userId) from User u")
	Long getMaxUserId();

}