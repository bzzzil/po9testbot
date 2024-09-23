package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi tba = new TelegramBotsApi(DefaultBotSession.class);
            Po9TestBot bot = new Po9TestBot("8081372711:AAHSneAfjZ4VY3cSX5dPSQ4AzXbpd6WOVMc");
            tba.registerBot(bot);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}