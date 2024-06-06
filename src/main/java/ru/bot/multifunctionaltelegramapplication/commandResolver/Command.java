package ru.bot.multifunctionaltelegramapplication.commandResolver;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Command {
    START("/start"),
    RANDOM_LETTER("/rndLet"),
    UNIQUE_RANDOM_LETTER("/uniqRndLet");

    private final String commandValue;

    Command(String command) {
        this.commandValue = command;
    }

    public static Command of(String commandValue) {
        return Arrays.stream(Command.values())
                .filter(command -> command.commandValue.equals(commandValue))
                .findFirst()
                .orElseThrow(UnsupportedOperationException::new);
    }
}
