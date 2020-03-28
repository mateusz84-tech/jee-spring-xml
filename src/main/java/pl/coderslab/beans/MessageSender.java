package pl.coderslab.beans;

public class MessageSender {

    final MessageService messageService;

    MessageSender(MessageService messageService){
        this.messageService = messageService;
    }

    public void sendMessage(){
        messageService.send();
    }
}
