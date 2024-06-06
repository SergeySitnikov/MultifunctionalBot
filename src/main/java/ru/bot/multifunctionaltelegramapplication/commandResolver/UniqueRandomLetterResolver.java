package ru.bot.multifunctionaltelegramapplication.commandResolver;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.bot.multifunctionaltelegramapplication.service.UniqueRandomLetterService;

@Component
@RequiredArgsConstructor
public class UniqueRandomLetterResolver implements CommandResolver {

    private final UniqueRandomLetterService uniqueRandomLetterService;
    @Override
    public boolean isSupport(Command command) {
        return Command.UNIQUE_RANDOM_LETTER == command;
    }

    @Override
    public String getResultText(Message message) {
        return String.valueOf(uniqueRandomLetterService.getUniqueLetter(message.getChatId()));
    }
}
