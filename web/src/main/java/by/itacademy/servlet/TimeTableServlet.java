package by.itacademy.servlet;

import by.itacademy.entity.Station;
import by.itacademy.entity.TimeTable;
import by.itacademy.service.StationService;
import by.itacademy.service.TimeTableService;
import by.itacademy.servlet.formatter.LocalDateFormat;
import by.itacademy.servlet.util.PaginationUtil;
import by.itacademy.servlet.util.StringUtil;

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
        List<Station> stations = StationService.getInstance().findAll();
        req.setAttribute("stations", stations);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/timeTable.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long startStationId = Long.valueOf(req.getParameter("stationStart"));
        Long finishStationId = Long.valueOf(req.getParameter("stationFinish"));
        LocalDate date = LocalDateFormat.format(req.getParameter("date"));
        Integer numberPages = null;
        Integer countElements = null;
        if (!StringUtil.isEmpty(req.getParameter("numberPages")) && !StringUtil.isEmpty(req.getParameter("countElements"))) {
            numberPages = Integer.valueOf(req.getParameter("numberPages"));
            countElements = Integer.valueOf(req.getParameter("countElements"));
        }

        List<Station> stations = StationService.getInstance().findAll();
        List<TimeTable> timeTables = TimeTableService.getInstance()
                .findByStationsAndDate(startStationId, finishStationId, date,
                        PaginationUtil.getLimit(numberPages, countElements), PaginationUtil.getOffset(numberPages, countElements));

        req.setAttribute("timeTables", timeTables);
        req.setAttribute("stations", stations);
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/timeTable.jsp")
                .forward(req, resp);
    }
}
