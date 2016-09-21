package ru.nektodev.abcouses.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author nektodev
 * @date 21/09/2016
 */
public class HomeworkWord implements Serializable {
    @Id
    private Integer id;
    private String question;
    private String answer;
    private String wordId;
}
