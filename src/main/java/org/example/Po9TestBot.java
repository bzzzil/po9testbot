package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

public class Po9TestBot extends TelegramLongPollingBot {
    @Override
    public void clearWebhook() throws TelegramApiRequestException {
        super.clearWebhook();
    }

    public Po9TestBot(String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            String userName = update.getMessage().getChat().getFirstName() + " "
                    + update.getMessage().getChat().getLastName();

            switch (text) {
                case "/start":
                    break;
                case "/hello":
                    sendMessage(chatId, "Привет, " + userName);
                    break;
                default:
                    System.out.println(userName + " " + text);
                    break;
            }

        }
    }

    @Override
    public String getBotUsername() {
        return "po9testbot";
    }

    protected void sendMessage(long chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
