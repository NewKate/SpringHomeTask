package vtb.spring.service;

import org.springframework.stereotype.Service;
import vtb.spring.model.Event;
import vtb.spring.model.Opera;
import vtb.spring.model.Ticket;

import java.util.Date;
import java.util.HashMap;

@Service
public class OperaService {

    private HashMap<String, Opera> operasMap = new HashMap<>();
    private HashMap<String, Event> eventsMap = new HashMap<>();

    public Opera getOperaByName(String name){
        System.out.println("Получаем оперу по названию " + name);
        return operasMap.get(name);
    }

    public HashMap<String, Opera> getOperaList(){
        System.out.println("Получаем список всех опер");
        return operasMap;
    }

    public HashMap<String, Event> getEventList(){
        System.out.println("Получаем список всех опер");
        return eventsMap;
    }

    public void delOpera(String name){
        System.out.println("Удалить оперу по имени : " + name);
        operasMap.remove(name);
    }

    public void addOpera(String name){
        System.out.println("Добавить оперу по имени : " + name);
        Opera opera = new Opera(name, 12, "Постоянный репертуар");
        operasMap.put(name, opera);
    }

    public void addOpera(String name, Integer age, String type){
        System.out.println("Добавить оперу по имени + доп данным: " + name);
        Opera opera = new Opera(name, age,  type);
        operasMap.put(name, opera);
    }

    public void addEvent(Opera opera, Date dt, Integer total, Integer available){
        System.out.println("Добавить событие по имени : " + opera.getLabel() + " на дату " + dt);
        Event event = new Event(opera, dt, total, available);
        eventsMap.put(opera.getLabel() + dt.toString(), event);
    }

    public void delEvent(Opera opera, Date dt){
        System.out.println("Добавить событие по имени : " + opera.getLabel() + " на дату " + dt);
        eventsMap.remove(opera.getLabel() + dt.toString());
    }

    public Ticket buyTicket(Event event, Date date, Integer row, Integer place){
        System.out.println("Покупка билета на : " + event.getOpera().getLabel() +
                        " дата " + event.getEventDate());
        Ticket ticket = new Ticket(event, 1000, row, place);
        event.setAvailable(event.getAvailable() - 1);
        return ticket;
    }

    public void returnTicket(Ticket ticket){
        System.out.println("Возврат билета на : " + ticket.getEvent().getOpera().getLabel() + " дата " + ticket.getEvent().getEventDate());
        ticket.getEvent().setAvailable(ticket.getEvent().getAvailable() + 1);
    }

    public HashMap<String, Opera> getPrimeOpera(){
        System.out.println("Получаем список премьер");
        HashMap<String, Opera> primeOperasMap = new HashMap<>();
        for(Opera opera : operasMap.values()){
            if(opera.getType().equals("Премьера"))
            primeOperasMap.put(opera.getLabel(), opera);
        }
        return primeOperasMap;
    }

}
