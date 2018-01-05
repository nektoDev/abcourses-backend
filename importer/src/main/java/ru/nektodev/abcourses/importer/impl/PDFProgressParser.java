package ru.nektodev.abcourses.importer.impl;

import org.apache.log4j.Logger;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import ru.nektodev.abcouses.model.ParsedProgressData;
import ru.nektodev.abcouses.model.ProgressImportParams;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * @author nektodev
 * @date 26/09/2016
 */
public class PDFProgressParser extends AbstractProgressParser {

    private static final Logger LOG = Logger.getLogger(PDFProgressParser.class);

    public PDFProgressParser(ProgressImportParams importParams) {
        super(importParams);
    }

    @Override
    public ParsedProgressData doParse(File file) {

        PDFTextStripper pdfStripper;
        PDDocument pdDoc;
        COSDocument cosDoc;
        PDFParser parser = null;

        ParsedProgressData result = new ParsedProgressData();

        try {
            parser = new PDFParser(new RandomAccessFile(file, "r"));
            parser.parse();
            cosDoc = parser.getDocument();
            pdfStripper = new PDFTextStripper();
            pdDoc = new PDDocument(cosDoc);
            String parsedText = pdfStripper.getText(pdDoc);

            for (String row : parsedText.split("\\n")) {
                String[] elements = row.split(" ");

                if (elements.length > 1) {
                    Date date;
                    try {
                        date = parseDate(elements[params.getDateColumn()]);

                        if (elements.length >= params.getVocabularyColumn() + 1)
                            result.addVocabularyIfNotNull(getProgressData(date, elements[params.getVocabularyColumn()]));

                        if (elements.length >= params.getPronunciationColumn() + 1)
                            result.addPronunciationIfNotNull(getProgressData(date, elements[params.getPronunciationColumn()]));

                        if (elements.length >= params.getTestColumn() + 1)
                            result.addTestIfNotNull(getProgressData(date, elements[params.getTestColumn()]));

                        if (elements.length >= params.getGrammarColumn() + 1)
                            result.addGrammarIfNotNull(getProgressData(date, elements[params.getGrammarColumn()]));
                    } catch (ParseException ignored) {
                    }
                }
            }

        } catch (IOException e) {
            LOG.error(e);
        } finally {
            try {
                if (parser != null) {
                    parser.getPDDocument().close();
                }
            } catch (IOException e) {
                LOG.error(e);
            }
        }

        return result;
    }
}