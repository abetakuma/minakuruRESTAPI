package com.example.idea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.idea.entity.RelationIdeasUsers;

@Repository
public interface RelationIdeasUsersRepository extends JpaRepository<RelationIdeasUsers, Long> {
}