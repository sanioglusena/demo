package com.example.demo.Controller;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by senasanioglu on 4/18/18.
 */

@Controller
@RequestMapping("/myBet")
public class MyBetController {

    private final BetRepository betRepository;
    private final BetEventRepository betEventRepository;
    private final EventRateRepository eventRateRepository;
    private final EventRepository eventRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public MyBetController(BetRepository betRepository, BetEventRepository betEventRepository, EventRateRepository eventRateRepository,
                            EventRepository eventRepository, TeamRepository teamRepository) {
        this.betRepository = betRepository;
        this.betEventRepository = betEventRepository;
        this.eventRateRepository = eventRateRepository;
        this.eventRepository = eventRepository;
        this.teamRepository = teamRepository;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<MyBet> list(@RequestParam(value = "userId") int userId) {
        List<Bet> bets = betRepository.findByUserId(userId);

        List<MyBet> mybets = new ArrayList<>();

        for (Bet bet : bets) {
            MyBet myBet = new MyBet();
            myBet.setUserId(bet.getUser_id());
            myBet.setTimeStampofBet(bet.getTimestamp());
            List<BetEvent> betEvents = betEventRepository.findByBetEventIdentityBetId(bet.getBetId());
            myBet.setEventCount(betEvents.size());
            myBet.setAmount(bet.getAmount());
            myBet.setParentId(bet.getParent_bet());
            myBet.setShared(bet.getIs_shared());

            double rateSum = 1;
            for(BetEvent betEvent: betEvents){
                rateSum *= eventRateRepository.findByRateId(betEvent.getBetEventIdentity().getRate_id()).getRate();
            }
            myBet.setRateSum(rateSum);

            mybets.add(myBet);
        }

        return  mybets;
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<EventDetail> details(@RequestParam(value = "betId") int betId) {
        List<BetEvent> betEvents = betEventRepository.findByBetEventIdentityBetId(betId);

        List<EventDetail> events = new ArrayList<>();

        for (BetEvent betEvent : betEvents) {
            EventDetail event = new EventDetail();
            EventRate eventRate = eventRateRepository.findByRateId(betEvent.getBetEventIdentity().getRate_id());
            event.setEventId(eventRate.getEvent_id());
            Optional<Event> e = eventRepository.findById(eventRate.getEvent_id());
            event.setRate(eventRate.getRate());
            event.setTimeStampofBet(e.get().getTime());
            Optional<Team> t1 = teamRepository.findById(e.get().getHome_team());
            Optional<Team> t2 = teamRepository.findById(e.get().getAway_team());
            event.setTeam1(t1.get().getTeam_name());
            event.setTeam2(t2.get().getTeam_name());
            event.setResultType(eventRate.getResult_type());
            events.add(event);
        }

        return  events;
    }
    @RequestMapping(value = "/update", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<String> setShared(@RequestParam(value = "betId") int betId) {
        Bet bet = betRepository.findByBetId(betId);

        bet.setIs_shared(1);
        betRepository.save(bet);

        return  new ArrayList<String>();
    }
}
