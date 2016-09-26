package ru.nektodev.abcourses.importer.impl;

import org.apache.log4j.Logger;
import ru.nektodev.abcourses.importer.ProgressParser;
import ru.nektodev.abcouses.model.ProgressData;
import ru.nektodev.abcouses.model.ProgressImportParams;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author nektodev
 * @date 26/09/2016
 */
public abstract class AbstractProgressParser implements ProgressParser {
    private static final Logger LOG = Logger.getLogger(AbstractProgressParser.class);

    protected static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    protected static SimpleDateFormat sdf_for_unformatted = new SimpleDateFormat("dd.MM.yy");
    protected ProgressImportParams params;

    public AbstractProgressParser(ProgressImportParams importParams) {
        this.params = importParams;
    }

    protected ProgressData getProgressData(Date date, String value) {
        if (!value.matches("\\d.*%")) {
            return null;
        }

        ProgressData result = new ProgressData();
        result.setDate(date);
        result.setValue(Integer.valueOf(value.replace("%", "")));

        return result;
    }

    protected Date parseDate(String dateString) throws ParseException {
        if (dateString.length() == 10) {
            return sdf.parse(dateString);
        }
        if (dateString.length() == 8) {
            return sdf_for_unformatted.parse(dateString);
        }
        LOG.error("Unknown date format in progress: " + dateString);

        return new Date(0);
    }

}
