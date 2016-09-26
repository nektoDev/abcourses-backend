package ru.nektodev.abcourses.importer;

import ru.nektodev.abcourses.importer.impl.ODSProgressParser;
import ru.nektodev.abcourses.importer.impl.PDFProgressParser;
import ru.nektodev.abcouses.model.ProgressImportParams;
import ru.nektodev.abcouses.model.ProgressType;

/**
 * @author nektodev
 * @date 26/09/2016
 */
public class ProgressParserFactory {

    public ProgressParser getParser(ProgressImportParams params) {
        if (ProgressType.ODS.equals(params.getType())) {
            return new ODSProgressParser(params);
        }

        if (ProgressType.PDF.equals(params.getType())) {
            return new PDFProgressParser(params);
        }

        return null;
    }

}