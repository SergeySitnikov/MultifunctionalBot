package ru.bot.multifunctionaltelegramapplication.commandResolver;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.bot.multifunctionaltelegramapplication.service.RandomLetterService;

@Component
public record RandomLetterResolver(RandomLetterService randomLetterService) implements CommandResolver {

    @Override
    public boolean isSupport(Command command) {
        return Command.RANDOM_LETTER == command;
    }

    @Override
    public String getResultText(Message message) {
        return String.valueOf(randomLetterService.getRandomLetter());
    }
}
