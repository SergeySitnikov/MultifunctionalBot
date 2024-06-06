package ru.bot.multifunctionaltelegramapplication.service;

import org.springframework.stereotype.Service;

@Service
public class RandomLetterService {

    public Character getRandomLetter() {
       return ServiceConstant.RUSSIAN_LETTERS.get((int)(Math.random() * ServiceConstant.RUSSIAN_LETTERS.size()));
    }
}
