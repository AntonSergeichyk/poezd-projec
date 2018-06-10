package com.itacademy.servlet;

import com.itacademy.entity.Station;
import com.itacademy.entity.TimeTable;
import com.itacademy.formatter.LocalDateFormat;
import com.itacademy.service.interfaces.StationService;
import com.itacademy.service.interfaces.TimeTableService;
import com.itacademy.utill.BeanUtill;
import org.springframework.data.domain.PageRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/timeTableServlet")
public class TimeTableServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Station> stations = BeanUtill.getBean(StationService.class).findAll();
        req.setAttribute("stations", stations);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/timeTable.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long stationStart = Long.valueOf(req.getParameter("stationStart"));
        Long stationFinish = Long.valueOf(req.getParameter("stationFinish"));
        LocalDate date = LocalDateFormat.format(req.getParameter("date"));
        Integer page = Integer.valueOf(req.getParameter("page"));
        Integer size = Integer.valueOf(req.getParameter("size"));
        List<TimeTable> timeTables = BeanUtill.getBean(TimeTableService.class)
                .findAllByStationStartIdAndStationFinishIdAndTimeStartOrderByTimeStart(
                        stationStart, stationFinish, date, PageRequest.of(page, size));

        req.setAttribute("timeTables", timeTables);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/timeTable.jsp")
                .forward(req, resp);
    }
}
