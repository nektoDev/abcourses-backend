package ru.nektodev.abcouses.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author nektodev
 * @date 21/09/2016
 */
public class Homework implements Serializable{
    @Id
    private String id;
    private String studentId;
    private Date date;
    private String fileHash;
    private List<HomeworkWord> vocabulary;
    private List<HomeworkWord> pronunciation;
}
