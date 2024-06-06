package ru.bot.multifunctionaltelegramapplication.serviceTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.bot.multifunctionaltelegramapplication.service.ServiceConstant;
import ru.bot.multifunctionaltelegramapplication.service.UniqueRandomLetterService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueRandomLetterTest {

    @Test
    public void testUniqueAllRussianLetter() {
        UniqueRandomLetterService uniqueRandomLetterService = new UniqueRandomLetterService();
        List<Character> actual = new ArrayList<>();
        for (int i = 0; i < ServiceConstant.RUSSIAN_LETTERS.size(); i++) {
            actual.add(uniqueRandomLetterService.getUniqueLetter(1L));
        }
        Assertions.assertEquals(ServiceConstant.RUSSIAN_LETTERS.size(), actual.size());
        Set<Character> uniqueLetters = new HashSet<>(actual);
        Assertions.assertEquals(ServiceConstant.RUSSIAN_LETTERS.size(), uniqueLetters.size());
    }
}
