package vtb.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import vtb.spring.model.Event;
import vtb.spring.model.Opera;
import vtb.spring.model.Ticket;
import vtb.spring.service.OperaService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@SpringBootApplication
public class OperaSalesApplication {

    public static void main(String[] args) throws ParseException {

        final ConfigurableApplicationContext ctx = SpringApplication.run(OperaSalesApplication.class, args);


        ctx.getBean(OperaService.class).addOpera("Валькирия");
        ctx.getBean(OperaService.class).addOpera("Борис Годунов");
        ctx.getBean(OperaService.class).addOpera("Кармен", 12, "Постоянный репертуар");
        ctx.getBean(OperaService.class).addOpera("Травиата", 12, "Премьера");
        ctx.getBean(OperaService.class).addOpera("Князь Игорь", 12, "Премьера");

        Opera opera = ctx.getBean(OperaService.class).getOperaByName("Князь Игорь");
        printOpera(opera);
        opera = ctx.getBean(OperaService.class).getOperaByName("Кармен");
        printOpera(opera);

        HashMap<String, Opera> operaList = ctx.getBean(OperaService.class).getOperaList();
        for (Opera operaFromList : operaList.values()) {
            printOpera(operaFromList);
        }

        ctx.getBean(OperaService.class).delOpera("Валькирия");
        ctx.getBean(OperaService.class).delOpera("Кармен");

        operaList = ctx.getBean(OperaService.class).getOperaList();
        for (Opera operaFromList : operaList.values()) {
            printOpera(operaFromList);
        }

        operaList = ctx.getBean(OperaService.class).getPrimeOpera();
        for (Opera operaFromList : operaList.values()) {
            printOpera(operaFromList);
        }

        String date_s = " 2022-01-01 19:00";
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm");
        Date date = dt.parse(date_s);

        printOpera(operaList.get("Травиата"));

        ctx.getBean(OperaService.class).addEvent(operaList.get("Травиата"), date, 350, 350);

        date_s = " 2022-02-02 19:00";
        date = dt.parse(date_s);

        printOpera(operaList.get("Князь Игорь"));

        ctx.getBean(OperaService.class).addEvent(operaList.get("Князь Игорь"), date, 500, 500);

        HashMap<String, Event> eventList = ctx.getBean(OperaService.class).getEventList();
        for (Event event : eventList.values()) {
            printEvent(event);
        }

        printEvent(eventList.get("Князь Игорь" + date.toString()));

        Ticket t = ctx.getBean(OperaService.class).buyTicket(eventList.get("Князь Игорь" + date.toString()), date, 1, 1);
        printTicket(t);

        t = ctx.getBean(OperaService.class).buyTicket(eventList.get("Князь Игорь" + date.toString()), date, 1, 2);
        t = ctx.getBean(OperaService.class).buyTicket(eventList.get("Князь Игорь" + date.toString()), date, 1, 3);

        printEvent(eventList.get("Князь Игорь" + date.toString()));

        ctx.getBean(OperaService.class).returnTicket(t);

        printEvent(eventList.get("Князь Игорь" + date.toString()));


    }

    public static void printOpera(Opera opera) {
        System.out.println(opera.getType() + " " + opera.getLabel() + " " + opera.getAge() + "+");
    }

    public static void printEvent(Event event) {
        printOpera(event.getOpera());
        System.out.println(event.getOpera().getLabel() + " " +
                event.getEventDate() +
                " Кол-во доступных билетов: " + event.getAvailable());
    }

    public static void printTicket(Ticket ticket) {
        System.out.println(ticket.getEvent().getOpera().getLabel() + " " + ticket.getEvent().getEventDate() +
                " стоимость: " + ticket.getPrice() + " ряд: " + ticket.getRow() + " место: " + ticket.getPlace());
    }
}
