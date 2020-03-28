package pl.coderslab.beans;

public class MessageSender {

    // atrybut z interfejsu
    private MessageService messageService;

    // konstruktor z instancję interfejsu
    public MessageSender(MessageService messageService) {
        this.messageService = messageService;
    }

    // metoda wyświetlająca metodę z interfejsu
    public void sendMessage(){
        messageService.send();
    }
}
