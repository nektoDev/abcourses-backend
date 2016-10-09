package ru.nektodev.abcourses.api;

import com.googlecode.jsonrpc4j.JsonRpcService;
import ru.nektodev.abcouses.model.Word;

import java.util.List;

/**
 * @author nektodev
 * @date 09/10/2016
 */
@JsonRpcService("/word")
public interface WordFacade extends BaseFacade<Word> {
    @Override
    Word get(String id);

    @Override
    List<Word> list();

    @Override
    List<Word> merge(List<Word> words);

    @Override
    List<Word> save(List<Word> words);

    @Override
    void delete(List<String> tList);

    List<Word> addWordsToStudent(List<Word> words, String studentId);
}
