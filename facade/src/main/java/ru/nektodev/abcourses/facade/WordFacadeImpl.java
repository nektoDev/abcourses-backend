package ru.nektodev.abcourses.facade;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.abcourses.api.WordFacade;
import ru.nektodev.abcourses.service.WordService;
import ru.nektodev.abcouses.model.Word;

import java.util.List;

/**
 * @author nektodev
 * @date 09/10/2016
 */
@Service
@AutoJsonRpcServiceImpl
public class WordFacadeImpl implements WordFacade {

    @Autowired
    private WordService wordService;

    @Override
    public Word get(String id) {
        return wordService.get(id);
    }

    @Override
    public List<Word> list() {
        return wordService.list();
    }

    @Override
    public List<Word> merge(List<Word> words) {
        return wordService.merge(words);
    }

    @Override
    public List<Word> save(List<Word> words) {
        return wordService.save(words);
    }

    @Override
    public void delete(List<String> wordIds) {
        wordService.delete(wordIds);
    }
}
