package pl.coderslab.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.coderslab.beans.EmailService;
import pl.coderslab.beans.HelloWorld;
import pl.coderslab.beans.MessageSender;

public class SpringDiApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml"); // instancja kontextu, pobierze konfiguracje z pliku xml

        // działania na kontekście
        HelloWorld helloWorld = context.getBean("helloWorld",HelloWorld.class); // unikanie
        System.out.println(helloWorld.getMessage());
        // zadanie 3
        EmailService emailService = context.getBean("emailService",EmailService.class);
        emailService.send();

        MessageSender messageSender = context.getBean("messageSender",MessageSender.class);
        messageSender.sendMessage();

        context.close();// ważne aby zamknąć konteks
    }
}
