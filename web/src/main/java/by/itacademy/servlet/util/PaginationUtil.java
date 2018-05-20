package by.itacademy.servlet.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PaginationUtil {

    public static final int DEFAULT = 1;
    public static final int ONE = 1;

    public static Integer getLimit(Integer numberPages, Integer countElements) {
        Integer limit = DEFAULT;
        if (numberPages != null && countElements != null) {
            limit = (int) Math.pow(countElements, numberPages);
        }

        return limit;
    }

    public static Integer getOffset(Integer numberPages, Integer countElements) {
        Integer offset = DEFAULT;
        if (numberPages != null && countElements != null) {
            offset = ONE + (int) Math.pow(countElements, numberPages - ONE);
        }

        return offset;
    }
}
