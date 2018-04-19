package com.example.demo.Controller;

import com.example.demo.Entity.*;
import com.example.demo.Repository.BetEventRepository;
import com.example.demo.Repository.BetRepository;
import com.example.demo.Repository.EventRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senasanioglu on 4/18/18.
 */

@Controller
@RequestMapping("/myBet")
public class MyBetController {

    private final BetRepository betRepository;
    private final BetEventRepository betEventRepository;
    private final EventRateRepository eventRateRepository;

    @Autowired
    public MyBetController(BetRepository betRepository, BetEventRepository betEventRepository, EventRateRepository eventRateRepository) {
        this.betRepository = betRepository;
        this.betEventRepository = betEventRepository;
        this.eventRateRepository = eventRateRepository;
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
            List<BetEvent> betEvents = betEventRepository.findByBetId(bet.getBet_id());
            myBet.setEventCount(betEvents.size());
            myBet.setAmount(bet.getAmount());

            double rateSum = 1;
            for(BetEvent betEvent: betEvents){
                rateSum *= eventRateRepository.findByRateId(betEvent.getBetId()).getRate();
            }
            myBet.setRateSum(rateSum);

            mybets.add(myBet);
        }

        return  mybets;
    }
}
