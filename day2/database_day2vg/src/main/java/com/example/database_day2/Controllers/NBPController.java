package com.example.database_day2.Controllers;

import com.example.database_day2.Services.NBPService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NBPController {

    @Autowired
    NBPService nbpService;

    @GetMapping("/getExchanges")
    public List<Object> getAllExchanges(){
        return nbpService.getExchangeTable();
    }

    @GetMapping("/getExchangesFromYesterday")
    public List<Object> getAllExchangesFromYesterday(){
        return nbpService.getExchangeTableFromYesterday();
    }

    @GetMapping("/getUSDExchangeFromLast10Days")
    public JsonObject getUSDExchangeFromLast10Days() throws  ParseException {
        return nbpService.getUSDExchangeFromLast10Days();
    }
}
