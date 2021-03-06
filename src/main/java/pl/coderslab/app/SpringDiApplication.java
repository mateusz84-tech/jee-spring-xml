package pl.coderslab.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.coderslab.beans.EmailService;
import pl.coderslab.beans.HelloWorld;
import pl.coderslab.beans.MessageSender;

public class SpringDiApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml"); // instancja kontextu, pobierze konfiguracje z pliku xml

        // pobranie ziarna klasy HelloWorld

        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.printMessage();

        // pobranie ziarna klasy EmailService implementującej interface MessageService

        EmailService emailService = (EmailService) context.getBean("emailService");
        emailService.send();

        // pobranie ziarna MessageSender

        MessageSender messageSender = context.getBean("messageSender",MessageSender.class);
        messageSender.sendMessage();
        context.close();// ważne aby zamknąć konteks
    }
}
