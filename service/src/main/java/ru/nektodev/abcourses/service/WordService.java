package ru.nektodev.abcourses.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.abcourses.repository.WordRepository;
import ru.nektodev.abcouses.model.Student;
import ru.nektodev.abcouses.model.Word;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author nektodev
 * @date 22/09/2016
 */
@Service
public class WordService {

    private static final Logger LOG = Logger.getLogger(WordService.class);
    @Autowired
    private WordRepository wordRepository;
    @Autowired
    private StudentService studentService;

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

    public List<Word> merge(List<Word> words) {
        return wordRepository.save(words);
    }

    public void delete(List<String> wordIds) {
        for (String wordId : wordIds) {
            wordRepository.delete(wordId);
        }
    }

    public List<Word> addWordsToStudent(List<Word> words, String studentId) {
        List<Word> toSave = new ArrayList<>();
        for (Word word : words) {
            Word repoWord = getOrCreateWord(word.getId(), studentId, new Date());
            if (repoWord.getCountUses().get(studentId) > 1) {
                repoWord.getCountUses().put(studentId, repoWord.getCountUses().get(studentId)-1);
            }
            repoWord.getTranslations().addAll(word.getTranslations());
            toSave.add(repoWord);
        }

        Student student = studentService.get(studentId);
        student.getWords().addAll(toSave.stream().map(Word::getId).collect(Collectors.toList()));
        studentService.save(student);

        return wordRepository.save(toSave);
    }

    public Word getOrCreateWord(String id, String studentId, Date date) {
        id = id.trim();
        Word word = get(id);
        if (word == null) {
            word = new Word(studentId, id);
        }

        word.getFirstAppeared().putIfAbsent(studentId, date);
        word.getCountUses().put(studentId, word.getCountUses().getOrDefault(studentId, 0)+1);
        word.getLastUsed().put(studentId, date);

        return word;
    }

    public List<Word> getWordsByStudent(String studentId) {
        return wordRepository.findAll().stream().filter(w -> w.getCountUses().containsKey(studentId)).collect(Collectors.toList());
    }
}
