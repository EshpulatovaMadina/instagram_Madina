package uz.pdp.instagram.service.message;

import uz.pdp.instagram.domain.DTO.BaseResponce;
import uz.pdp.instagram.domain.model.Message;
import uz.pdp.instagram.reposiitory.message.MessageRepository;
import uz.pdp.instagram.reposiitory.message.MessageRepositroyImpl;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class MessageServiceImpl implements MessageService{
    MessageRepository messageRepository = MessageRepositroyImpl.getInstance();


    @Override
    public ArrayList<Message> getMessages(UUID uuid, UUID uuid1) {
        ArrayList<Message> messages = new ArrayList<>();
        for (Message message : messageRepository.getAll()) {
            if(Objects.equals(message.getSenderId(),uuid) && Objects.equals(message.getReceiverId(),uuid1) ||
            Objects.equals(message.getSenderId(),uuid1) && Objects.equals(message.getReceiverId(),uuid)){
                messages.add(message);
            }
        }
        return messages;
    }

    @Override
    public BaseResponce add(Message message) {
        messageRepository.save(message);
        return new BaseResponce("ok",200);
    }

    @Override
    public int remove(Message message) {
        return 0;
    }

    @Override
    public void remove(UUID uuid) {

    }
}
