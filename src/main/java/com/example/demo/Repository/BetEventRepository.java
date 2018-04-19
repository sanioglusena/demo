package com.example.demo.Repository;

import com.example.demo.Entity.BetEvent;
import com.example.demo.Entity.BetEventIdentity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by senasanioglu on 4/18/18.
 */
public interface BetEventRepository extends CrudRepository <BetEvent, Integer> {
    List<BetEvent> findAll();
    List<BetEvent> findByBetEventIdentityBetId(int betId);
}

