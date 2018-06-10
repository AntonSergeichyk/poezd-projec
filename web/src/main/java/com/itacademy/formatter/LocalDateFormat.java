package com.itacademy.formatter;

import com.itacademy.util.StringUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LocalDateFormat {

    private static final String PATTERN = "yyyy-MM-dd HH.mm";
    private static final Pattern PATTERNP = Pattern.compile("(?<yyyy>\\d{4})-(?<MM>\\d{2})-(?<dd>\\d{2})[T](?<HH>\\d{2}):(?<mm>\\d{2})");
    private static final String PATTERN_YEAR = "yyyy";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);
    private static final DateTimeFormatter FORMATTER_YEAR = DateTimeFormatter.ofPattern(PATTERN_YEAR);

    public static LocalDateTime format(String value) {
        Matcher matcher = PATTERNP.matcher(value);
        String format = "%s-%s-%s %s.%s";
        String formattedNumber = null;

        while (matcher.find()) {
            String yyyy = matcher.group("yyyy");
            String MM = matcher.group("MM");
            String dd = matcher.group("dd");
            String HH = matcher.group("HH");
            String mm = matcher.group("mm");
            formattedNumber = String.format(format, yyyy, MM, dd, HH, mm);
        }
        LocalDateTime localDate = null;
        if (!StringUtil.isEmpty(value)) {
            try {
                localDate = LocalDateTime.parse(formattedNumber, FORMATTER);
            } catch (DateTimeParseException e) {
            }
        }

        return localDate;
    }

    public static String format(LocalDate value) {
        String formattedValue = null;
        if (value != null) {
            formattedValue = FORMATTER.format(value);
        }

        return formattedValue;
    }

    public static String formatYear(LocalDate value) {
        String formattedValue = null;
        if (value != null) {
            formattedValue = FORMATTER_YEAR.format(value);
        }

        return formattedValue;
    }
}
