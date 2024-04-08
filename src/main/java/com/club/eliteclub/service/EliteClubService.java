package com.club.eliteclub.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.eliteclub.dao.EliteClubRepository;
import com.club.eliteclub.entity.EliteClub;
import com.club.eliteclub.model.ClubDTO;

@Service
public class EliteClubService {

	@Autowired
	EliteClubRepository eliteClubRepository;
	
	public List<ClubDTO> getAll(){
		return eliteClubRepository.findAll().stream().map(c -> new ClubDTO(c.getClubName())).collect(Collectors.toList());
		
	}
	
	public void addClub(String... clubNames) {
		for(String clubName : clubNames) {
			EliteClub eliteCLub = new EliteClub();
			eliteCLub.setClubName(clubName);
			eliteClubRepository.save(eliteCLub);
		}
	}
	
	public List<ClubDTO> searchClub(String searchParam){
		return eliteClubRepository.findClubs(searchParam).stream().map(club -> new ClubDTO(club.getClubName())).collect(Collectors.toList());
		
	}
	
}
