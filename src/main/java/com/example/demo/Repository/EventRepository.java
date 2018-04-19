package com.example.demo.Repository;

import com.example.demo.Entity.Event;
import com.example.demo.Entity.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by senasanioglu on 4/18/18.
 */
public interface EventRepository extends CrudRepository <Event, Integer> {
    List<Event> findAll();
}

