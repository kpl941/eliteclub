package com.club.eliteclub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.club.eliteclub.service.EliteClubService;

@SpringBootApplication
public class EliteclubApplication implements ApplicationRunner {

	@Autowired
	EliteClubService eliteClubService;
	
	public static void main(String[] args) {
		SpringApplication.run(EliteclubApplication.class, args);
	}
	
	@Override
	public void run(ApplicationArguments run) {
		eliteClubService.addClub("billionares","miliionaires","Soccers");
		System.out.print("************************************");
		System.out.print("*****-----"+eliteClubService.searchClub("Soccers").size() + " -----*****");
	}

}
