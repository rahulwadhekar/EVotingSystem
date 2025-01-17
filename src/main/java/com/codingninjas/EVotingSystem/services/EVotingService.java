package com.codingninjas.EVotingSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;
import com.codingninjas.EVotingSystem.repositories.UserRepository;
import com.codingninjas.EVotingSystem.repositories.VoteRepository;

@Service
public class EVotingService {

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ElectionRepository electionRepository;

    @Autowired
    ElectionChoiceRepository electionChoiceRepository;

    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public void addUser(User user) {
    	userRepository.save(user);
    }

    public List<User> getAllUsers() {
     return userRepository.findAll();
    }

    public void addVote(Long userId, Long electionId, Long electionChoiceId) {
    	
    	if (AlreadyGivenVote(userId, electionId)) {
    	    throw new IllegalArgumentException("You have already given your vote");
    	}

    		
    	
    	Vote vote = new Vote();
    	User user = userRepository.findById(userId).get();
    	vote.setUser(user);
    	Election election = electionRepository.findById(electionId).get();
    	vote.setElection(election);
    	ElectionChoice  elctionChoice = electionChoiceRepository.findById(electionChoiceId).get();
    	vote.setElectionChoice(elctionChoice);
    	
    	
    	voteRepository.save(vote);
    	
    
    }

    public void addElection(Election election) {
    	electionRepository.save(election);
    }

    public boolean AlreadyGivenVote(Long userId, Long electionId) {
    	
    	User user = userRepository.findById(userId).get();
    	Election election = electionRepository.findById(electionId).get();

        return voteRepository.existsByUserAndElection(user,election);
    }

    public List<Election> getAllElections() {
    	return electionRepository.findAll();
    }

    public void addElectionChoice(ElectionChoice electionChoice) {
    	
    	electionChoiceRepository.save(electionChoice);
    }

    public List<ElectionChoice> getAllElectionChoices() {
        return electionChoiceRepository.findAll();
    }

    public Election findElectionByName(String electionName) {
    	return electionRepository.findElectionByName(electionName).get();
    }

    public long countTotalVotes() {
       return voteRepository.findAll().size();
    }

    public long countVotesByElectionName(String electionName) {
       
    	
    	
        return voteRepository.countVotesByElectionName(electionName);
    }

    public long choicesByElection(Long electionId) {
    	Election election = electionRepository.findById(electionId).get();
    	
    	return electionChoiceRepository.countElectionChoicesByElection(election);

    }

	public ElectionChoice findElectionWinner(String electionName) {
		Election election = findElectionByName(electionName);
		
		return electionChoiceRepository.findElectionChoiceWithMaxVotes(election.getId());
		
   
	}

	
}
