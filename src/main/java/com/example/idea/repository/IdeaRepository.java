package com.example.idea.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.idea.entity.Idea;

@Repository
public interface IdeaRepository extends JpaRepository<Idea, Long> {
	@Query("select i from Idea i order by i.updatedAt DESC")
	List<Idea> getOrderByUpdatedAt(Pageable pageable);
}