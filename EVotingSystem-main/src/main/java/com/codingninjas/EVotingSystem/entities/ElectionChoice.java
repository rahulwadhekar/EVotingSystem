package com.codingninjas.EVotingSystem.entities;

import jakarta.persistence.*;

import java.util.List;

import org.springframework.data.repository.cdi.Eager;


@Entity
@Table(name = "election_choice")
public class ElectionChoice {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private long id;
	@Column
	private String name;

	@ManyToOne
	
	private Election election;
	
	

	public long getId() {
		return id;
	}

	

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
	}
}
