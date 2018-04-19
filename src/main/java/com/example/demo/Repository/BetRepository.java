package com.example.demo.Repository;

import com.example.demo.Entity.Bet;
import com.example.demo.Entity.MyBet;
import com.example.demo.Entity.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by senasanioglu on 4/18/18.
 */
public interface BetRepository extends CrudRepository <Bet, Integer> {
    List<Bet> findAll();
    List<Bet> findByUserId(int UserId);
    Bet findByBetId(int betId);

}

