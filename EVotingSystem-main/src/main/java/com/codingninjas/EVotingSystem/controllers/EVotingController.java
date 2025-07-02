package com.codingninjas.EVotingSystem.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.services.EVotingService;

@RestController
public class EVotingController {
	
	@Autowired
	EVotingService EVotingService;

	// User

	@PostMapping("/add/user")
	public void addUser(@RequestBody User user) {
		EVotingService.addUser(user);
	}

	@GetMapping("/get/users")
	public List<User> getAllUsers(){
return EVotingService.getAllUsers();
		
	}

	// Election

	@PostMapping("/add/election")
	public void addElection(@RequestBody Election election) {
		EVotingService.addElection(election);
	}

	@GetMapping("/get/elections")
	public List<Election> getAllElections(){
		return EVotingService.getAllElections();
	}

	// ElectionChoice

	@PostMapping("/add/electionChoice")
	public void addElectionChoice(@RequestBody ElectionChoice electionChoice) {
		EVotingService.addElectionChoice(electionChoice);
	}

	@GetMapping("/get/electionChoices")
	public List<ElectionChoice> getAllElectionChoices() {
		return EVotingService.getAllElectionChoices();
	}

	@GetMapping("/count/{electionId}")
	public long getCountByElectionId(@PathVariable Long electionId){
		return EVotingService.choicesByElection(electionId);
	}

	// Vote
	
	@PostMapping("/add/vote")
	public void addVote(@RequestParam Long userId,@RequestParam Long electionId,@RequestParam Long electionChoiceId) {
		EVotingService.addVote(userId, electionId, electionChoiceId);
	}
	
	@GetMapping("/get/votes")
	public List<Vote> getAllVotes(){
		return EVotingService.getAllVotes();
	}
	
	@GetMapping("/count/votes")
	public long totalVotes() {
		return EVotingService.countTotalVotes();
	}
	
	@GetMapping("/count/votes/{electionName}")
	public long totalVotesByName(@PathVariable String electionName) {
		return EVotingService.countVotesByElectionName(electionName);
	}




	// Result
	@GetMapping("/winner/election/{electionName}")
	public ElectionChoice winnerOfElection(@PathVariable String electionName) {
		return EVotingService.findElectionWinner(electionName);
	}


}
