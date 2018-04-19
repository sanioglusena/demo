package com.example.demo.Repository;

import com.example.demo.Entity.EventRate;
import com.example.demo.Entity.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by senasanioglu on 4/18/18.
 */
public interface EventRateRepository extends CrudRepository <EventRate, Integer> {
    List<EventRate> findAll();
    EventRate findByRateId(int rate_id);
}

