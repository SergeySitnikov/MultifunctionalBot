package ru.bot.multifunctionaltelegramapplication.commandResolver;

import org.telegram.telegrambots.meta.api.objects.Message;

public interface CommandResolver {
    boolean isSupport(Command command);
    String getResultText(Message message);
}
