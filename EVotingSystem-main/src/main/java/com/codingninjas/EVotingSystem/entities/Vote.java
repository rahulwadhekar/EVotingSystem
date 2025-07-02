package com.codingninjas.EVotingSystem.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="vote")
public class Vote {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column
	long id;

	@OneToOne(cascade=CascadeType.ALL)
    private User user;
	
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name ="election_id")
    
    private Election election; 

    @ManyToOne(cascade=CascadeType.ALL )
    @JoinColumn(name ="election_choice_id")
       
    private ElectionChoice electionChoice ;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
	}

	public ElectionChoice getElectionChoice() {
		return electionChoice;
	}

	public void setElectionChoice(ElectionChoice electionChoice) {
		this.electionChoice = electionChoice;
	}

}
