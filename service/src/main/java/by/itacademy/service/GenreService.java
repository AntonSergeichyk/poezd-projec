package by.itacademy.service;

import by.itacademy.dao.GenreDao;
import by.itacademy.entity.Genre;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GenreService {

    private static final GenreService INSTANCE = new GenreService();

    public Genre getGenre() {
        return GenreDao.getInstance().getGenre();
    }

    public static GenreService getInstance() {
        return INSTANCE;
    }
}
