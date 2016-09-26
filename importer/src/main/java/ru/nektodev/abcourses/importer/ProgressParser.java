package ru.nektodev.abcourses.importer;

import ru.nektodev.abcouses.model.ParsedProgressData;

import java.io.File;

/**
 * @author nektodev
 * @date 26/09/2016
 */
public interface ProgressParser {

    ParsedProgressData doParse(File file);
}
