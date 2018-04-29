package by.itacademy.servlet;

import by.itacademy.service.GenreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/genreServlet")
public class GenreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("genre", GenreService.getInstance().getGenre());
        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/genre.jsp")
                .forward(req, resp);
    }
}
