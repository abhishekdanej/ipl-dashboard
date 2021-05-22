package com.danej.ipldashboard.repository;

import org.springframework.data.repository.CrudRepository;

import com.danej.ipldashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long>{

	Team findByTeamName(String teamName);
}
