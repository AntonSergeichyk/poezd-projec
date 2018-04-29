package by.itacademy.dao;

import by.itacademy.entity.Genre;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GenreDao {

    private static final GenreDao INSTANCE = new GenreDao();

    public Genre getGenre() {
        return new Genre(1L, "Боевик");
    }

    public static GenreDao getInstance() {
        return INSTANCE;
    }
}
