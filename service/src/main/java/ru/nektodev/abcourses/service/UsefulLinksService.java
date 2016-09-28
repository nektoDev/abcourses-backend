package ru.nektodev.abcourses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.abcourses.repository.UsefulLinksRepository;
import ru.nektodev.abcouses.model.UsefulLink;

import java.util.List;

/**
 * @author nektodev
 * @date 28/09/2016
 */
@Service
public class UsefulLinksService {
    @Autowired
    private UsefulLinksRepository repository;

    public List<UsefulLink> listUsefulLinks() {
        return repository.findAll();
    }

    public List<UsefulLink> saveLinks(List<UsefulLink> links) {
        return repository.save(links);
    }
}
