package com.example.database_day2.Services;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.bytebuddy.asm.Advice;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Wrapper;
import java.time.LocalDate;
import java.util.Date;
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

    public JsonObject getUSDExchangeFromLast10Days() throws ParseException {
        LocalDate today=LocalDate.now();
        LocalDate tenDaysAgo=today.minusDays(10);
        String url="http://api.nbp.pl/api/exchangerates/rates/A/USD/"+tenDaysAgo+"/"+today+"/";
        RestTemplate restTemplate =new RestTemplate();
//        Wrapper data;
//        data = new ObjectMapper()
//                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
//                .readValue(, Wrapper.class);
//TODO
        String exchanges=restTemplate.getForObject(url,String.class);
        JsonObject convertedObject = new Gson().fromJson(exchanges, JsonObject.class);
        return convertedObject;

    }
}
