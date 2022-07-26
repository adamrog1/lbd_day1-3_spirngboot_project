package com.example.database_day2.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;

@Service
public class NBPService {

    public List<Object> getExchangeTable(){
        String url="http://api.nbp.pl/api/exchangerates/tables/A";
        RestTemplate restTemplate =new RestTemplate();
        Object[] exchanges=restTemplate.getForObject(url,Object[].class);
        assert exchanges != null;
        return List.of(exchanges);
    }

    public List<Object> getExchangeTableFromYesterday(){
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        String url="http://api.nbp.pl/api/exchangerates/tables/A/"+yesterday+"/";
        RestTemplate restTemplate =new RestTemplate();
        Object[] exchanges=restTemplate.getForObject(url,Object[].class);
        assert exchanges != null;
        return List.of(exchanges);
    }

    public Object getUSDExchangeFromLast10Days() throws ParseException, JsonProcessingException {
        LocalDate today=LocalDate.now();
        LocalDate tenDaysAgo=today.minusDays(10);
        String url="http://api.nbp.pl/api/exchangerates/rates/A/USD/"+tenDaysAgo+"/"+today+"/";
        RestTemplate restTemplate =new RestTemplate();
        return restTemplate.getForObject(url,Object.class);
    }
}
