package com.itacademy.controller;

import com.itacademy.entity.TimeTable;
import com.itacademy.entity.Train;
import com.itacademy.service.interfaces.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("timeTable")
public class TimeTableController {

    @Autowired
    private TimeTableService timeTableService;

    @GetMapping("/timeTable")
    public String showTimeTable(Model model, TimeTable timeTable) {
        List<TimeTable> timeTables = timeTableService.findAllByStationStartIdAndStationFinishIdAndTimeStartOrderByTimeStart(
                timeTable.getStationStart().getId(), timeTable.getStationFinish().getId(), timeTable.getTimeStart(), PageRequest.of(0, 2));
        model.addAttribute("tableTables", timeTables);
        model.addAttribute("train", new Train());
        model.addAttribute("timeTable", timeTable);
        return "timeTable";
    }

    @PostMapping("/timeTable")
    public String showTrain(Model model, Train train){
        System.out.println();
        return "train";
    }
}
