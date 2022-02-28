package vtb.spring.service;

import org.springframework.stereotype.Service;
import vtb.spring.model.Event;
import vtb.spring.model.Opera;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Service
public class OperaService {

    HashMap<String, Opera> operasMap = new HashMap<>();
    HashMap<String, Event> eventsMap = new HashMap<>();

    public Opera getOperaByName(String name){
        System.out.println("Получаем оперу по названию " + name);
        return new Opera(name);
    }

    public HashMap<String, Opera> getOperaList(){
        System.out.println("Получаем список всех опер");
        HashMap<String, Opera> oMap= new HashMap<>();
        return oMap;
    }

    public void delOpera(String name){
        System.out.println("Удалить оперу по имени : " + name);
    }

    public void addOpera(String name){
        System.out.println("Добавить оперу по имени : " + name);
    }

    public void addEvent(Opera opera, Date dt){
        System.out.println("Добавить событие по имени : " + opera.getLabel() + " на дату " + dt);
    }

    public void delEvent(Opera opera, Date dt){
        System.out.println("Добавить событие по имени : " + opera.getLabel() + " на дату " + dt);
    }

    public void buyTicket(Event event){
        System.out.println("Покупка билета на : " + event.getOpera().getLabel() + " дата " + event.getEventDate());
    }

    public void returnTicket(Event event){
        System.out.println("Возврат билета на : " + event.getOpera().getLabel() + " дата " + event.getEventDate());
    }
}
