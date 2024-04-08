package com.club.eliteclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.club.eliteclub.model.ClubDTO;
import com.club.eliteclub.service.EliteClubService;

@RestController
public class EliteClubController {

	@Autowired
	EliteClubService eliteClubService;

	@GetMapping(path = "/clubs", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClubDTO> clubs() {
		return eliteClubService.getAll();
	}

	@PostMapping(path = "/clubs", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createNewClub(@RequestBody ClubDTO clubDTO) {
		eliteClubService.addClub(clubDTO.getCLubName());
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	@GetMapping(path="/clubs/search" , produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClubDTO> searchClub(@RequestParam String clubName){
		return eliteClubService.searchClub(clubName);
	}
	
	@GetMapping(path="/clubs/{id}")
	public ClubDTO clubwithId(@PathVariable long id) {
		//return eliteClubService.getByID(id);
		return null;
	}
	
	@DeleteMapping(path="/clubs/{id}")
	public ClubDTO deleteClub(@PathVariable long id) {
		//return eliteClubService.deleteClub(id);
		return null;
	}
	
	public ClubDTO updateClub(@PathVariable long id, @RequestBody ClubDTO clubDTO) {
		//return eliteClubService.updateClub(clubDTO);
		return null;
	}

}
