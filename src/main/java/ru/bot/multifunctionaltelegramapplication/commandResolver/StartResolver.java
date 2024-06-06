package ru.bot.multifunctionaltelegramapplication.commandResolver;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class StartResolver implements CommandResolver{

    @Override
    public boolean isSupport(Command command) {
        return Command.START == command;
    }

    @Override
    public String getResultText(Message message) {
        String text = """
                Добро пожаловать в бот, %s.
                
                Здесь можно получать различную помощь
                
                Доступные команды
                /rndLet - получение случайной буквы русского алфавита
                /uniqRndLet - получение случайной буквы русского алфавита без повторений
                """;
        return String.format(text, message.getChat().getUserName());
    }
}
