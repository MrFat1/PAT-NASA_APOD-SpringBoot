package com2.pat.p4pat.controler;

import com2.pat.p4pat.services.DailyIMG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DailyIMGControler {

    @Autowired
    private DailyIMG dimg;

    @GetMapping("/dailyIMG")
    public Object apiCall() {

        return dimg.getData();
    }

}
