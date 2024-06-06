package ru.bot.multifunctionaltelegramapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.bot.multifunctionaltelegramapplication.bot.MultifunctionalBot;

@Configuration
public class MultifunctionalBotConfiguration {

    @Bean
    public TelegramBotsApi telegramBotsApi(MultifunctionalBot multifunctionalBot) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(multifunctionalBot);
        return telegramBotsApi;
    }
}
