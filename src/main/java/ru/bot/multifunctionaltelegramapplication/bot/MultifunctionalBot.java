package ru.bot.multifunctionaltelegramapplication.bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.bot.multifunctionaltelegramapplication.commandResolver.Command;
import ru.bot.multifunctionaltelegramapplication.commandResolver.CommandResolver;

import java.util.List;

@Component
@Slf4j
public class MultifunctionalBot extends TelegramLongPollingBot {

    List<CommandResolver> resolvers;

    public MultifunctionalBot(@Value("${bot.token}") String botToken, List<CommandResolver> resolvers) {
        super(botToken);
        this.resolvers = resolvers;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (!update.hasMessage() || !message.hasText()) {
            return;
        }
        String text = message.getText();
        Long chatId = message.getChatId();
        switch (Command.of(text)) {
            case START:
                sendMessage(chatId,  findResolver(Command.START).getResultText(message));
                break;
            case RANDOM_LETTER:
                sendMessage(chatId, findResolver(Command.RANDOM_LETTER).getResultText(message));
                break;
            case UNIQUE_RANDOM_LETTER:
                sendMessage(chatId, findResolver(Command.UNIQUE_RANDOM_LETTER).getResultText(message));
                break;
            default:
                throw new UnsupportedOperationException("default");
        }

    }

    @Override
    public String getBotUsername() {
        return "Multifunctional_Game_bot";
    }

    private void sendMessage(Long chatId, String text) {
        SendMessage sendMessage = new SendMessage(String.valueOf(chatId), text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error("Failed to send message to {}", chatId, e);
        }
    }

    private CommandResolver findResolver(Command command) {
        return this.resolvers.stream()
                .filter(commandResolver -> commandResolver.isSupport(command))
                .findFirst()
                .orElseThrow(UnsupportedOperationException::new);
    }
}
