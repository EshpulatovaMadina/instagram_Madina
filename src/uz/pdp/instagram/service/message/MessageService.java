package uz.pdp.instagram.service.message;

import uz.pdp.instagram.domain.model.Message;
import uz.pdp.instagram.service.BaseService;

import java.util.ArrayList;
import java.util.UUID;

public interface MessageService extends BaseService<Message,Message> {
    ArrayList<Message> getMessages(UUID uuid, UUID uuid1);

}
