package uz.pdp.instagram.reposiitory.message;

import uz.pdp.instagram.domain.model.Message;

import java.util.ArrayList;
import java.util.UUID;

public class MessageRepositroyImpl implements MessageRepository{
    private final ArrayList<Message> MESSAGES = new ArrayList<>();

  private static final MessageRepositroyImpl instance = new MessageRepositroyImpl();
    public static MessageRepositroyImpl getInstance() {
        return instance;
    }

    @Override
    public ArrayList<Message> getAll() {
        return MESSAGES;
    }

    @Override
    public int save(Message message) {
        MESSAGES.add(message);
        return 1;
    }

    @Override
    public Message getById(UUID uuid) {
        return null;
    }

    @Override
    public void remove(UUID uuid) {

    }

    @Override
    public void remove(Message message) {

    }

    @Override
    public ArrayList<Message> getArrayById(UUID uuid) {
        return null;
    }
}
