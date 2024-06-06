package ru.bot.multifunctionaltelegramapplication.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class UniqueRandomLetterService {

    private static final HashMap<Long, List<Character>> LETTER_FOR_MEMBER = new HashMap<>();

    public Character getUniqueLetter(Long memberId) {
        List<Character> allowedLetter;
        allowedLetter = LETTER_FOR_MEMBER.getOrDefault(memberId, copyConstantList(ServiceConstant.RUSSIAN_LETTERS));
        int letterPosition = (int) (Math.random() * allowedLetter.size());
        Character result = allowedLetter.get(letterPosition);
        allowedLetter.remove(letterPosition);
        if (allowedLetter.isEmpty()) {
            allowedLetter = copyConstantList(ServiceConstant.RUSSIAN_LETTERS);
        }
        LETTER_FOR_MEMBER.put(memberId, copyConstantList(allowedLetter));
        log.info("MemberId {}, allowed letters {}", memberId, allowedLetter);
        return result;
    }

    private List<Character> copyConstantList(List<Character> letters) {
        return new ArrayList<>(letters);
    }
}
