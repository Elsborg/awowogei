package com.martinelsborg.awowogei.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.martinelsborg.awowogei.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
   Player findByUsername(String username);
}
