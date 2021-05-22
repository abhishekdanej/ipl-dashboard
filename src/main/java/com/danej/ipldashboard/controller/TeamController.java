package com.danej.ipldashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.danej.ipldashboard.model.Team;
import com.danej.ipldashboard.repository.MatchRepository;
import com.danej.ipldashboard.repository.TeamRepository;

@RestController
public class TeamController {
	
	private TeamRepository teamRepository;
	
	@Autowired
	private MatchRepository matchRepository;
	
	public TeamController(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	@GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable String teamName) {
		Team team = this.teamRepository.findByTeamName(teamName);
//		Pageable pageable = PageRequest.of(0, 4);
//		team.setMatches(matchRepository.getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, pageable));
		
		team.setMatches(matchRepository.findLatestMatchesByTeam(teamName, 4));
		
		return team;
	}
}
