package ru.nektodev.abcourses.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.abcourses.repository.WordRepository;
import ru.nektodev.abcouses.model.Word;

import java.util.List;

/**
 * @author nektodev
 * @date 22/09/2016
 */
@Service
public class WordService {

    private static final Logger LOG = Logger.getLogger(WordService.class);
    @Autowired
    private WordRepository wordRepository;

    public List<Word> save(List<Word> words) {
        LOG.debug("Save words: " + words);
        return wordRepository.save(words);
    }

    public Word save(Word word) {
        LOG.debug("Save word: " + word);
        return wordRepository.save(word);
    }

    public Word get(String id) {
        return wordRepository.findOne(id);
    }

    public List<Word> list() {
        return wordRepository.findAll();
    }
}
