package com.club.eliteclub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.club.eliteclub.entity.EliteClub;

public interface EliteClubRepository extends JpaRepository<EliteClub,Long>{
	
	@Query("SELECT x FROM EliteClub x WHERE x.clubName = :searchTerm order by x.clubName asc")
	List<EliteClub> findClubs(@Param("searchTerm") String searchTerm);

}
