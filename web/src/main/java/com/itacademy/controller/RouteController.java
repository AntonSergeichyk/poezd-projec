package com.itacademy.controller;

import com.itacademy.entity.Station;
import com.itacademy.entity.TimeTable;
import com.itacademy.formatter.LocalDateFormat;
import com.itacademy.service.interfaces.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@Controller
@SessionAttributes("timeTable")
public class RouteController {

    @Autowired
    private StationService stationService;


    @ModelAttribute("allStations")
    public List<Station> stations() {
        return stationService.findAll();
    }

    @GetMapping("/routing")
    public String showRoutingPage(Model model, TimeTable timeTable) {
        model.addAttribute("calendarFormatter", Calendar.getInstance());
        model.addAttribute("timeTable", new TimeTable());

        return "routing";
    }

    @PostMapping("/routing")
    public String showTimeTable(Model model, TimeTable timeTable, String date) {
        timeTable.setTimeStart(LocalDateFormat.format(date));
        model.addAttribute("timeTable", timeTable);

        return "redirect:/timeTable";
    }
}
