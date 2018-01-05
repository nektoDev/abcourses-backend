package ru.nektodev.abcourses.importer.impl;

import org.jopendocument.model.OpenDocument;
import org.jopendocument.model.table.TableTableCell;
import org.jopendocument.model.table.TableTableRow;
import org.springframework.data.util.Pair;
import ru.nektodev.abcouses.model.ParsedProgressData;
import ru.nektodev.abcouses.model.ProgressImportParams;

import java.io.File;
import java.text.ParseException;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author nektodev
 * @date 26/09/2016
 */
public class ODSProgressParser extends AbstractProgressParser {
    public ODSProgressParser(ProgressImportParams importParams) {
        super(importParams);
    }

    @Override
    public ParsedProgressData doParse(File file) {
        final OpenDocument doc = new OpenDocument();
        doc.loadFrom(file);

        List<TableTableRow> rows = doc.getBody().getOfficeSpreadsheets().get(0).getTables().get(0).getRows();
        Pair range = getRange(params);
        ParsedProgressData result = new ParsedProgressData();

        for (TableTableRow row : rows) {
            TableTableCell[] cells = row.getCellsInRange((int) range.getFirst(), (int) range.getSecond());

            Date date;
            try {
                date = parseDate(cells[params.getDateColumn()].getFullText());

                if (cells.length >= params.getVocabularyColumn() + 1)
                    result.addVocabularyIfNotNull(getProgressData(date, cells[params.getVocabularyColumn()].getFullText()));

                if (cells.length >= params.getPronunciationColumn() + 1)
                    result.addPronunciationIfNotNull(getProgressData(date, cells[params.getPronunciationColumn()].getFullText()));

                if (cells.length >= params.getTestColumn() + 1)
                    result.addTestIfNotNull(getProgressData(date, cells[params.getTestColumn()].getFullText()));

                if (cells.length >= params.getGrammarColumn() + 1)
                    result.addGrammarIfNotNull(getProgressData(date, cells[params.getGrammarColumn()].getFullText()));
            } catch (ParseException ignored) {
            }
        }

        return result;
    }

    private Pair<Integer, Integer> getRange(ProgressImportParams params) {
        Stream<Integer> columns = Stream.of(params.getDateColumn(), params.getPronunciationColumn(), params.getVocabularyColumn(), params.getTestColumn());
        return Pair.of(columns.min(Comparator.comparingInt(value -> value)).get(), columns.max(Comparator.comparingInt(value -> value)).get());
    }
}
