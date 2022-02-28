package vtb.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import vtb.spring.model.Event;
import vtb.spring.model.Opera;
import vtb.spring.service.OperaService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class OperaSalesApplication {

	public static void main(String[] args) throws ParseException {

		final ConfigurableApplicationContext ctx = SpringApplication.run(OperaSalesApplication.class, args);

		ctx.getBean(OperaService.class).addOpera("Валькирия");
		ctx.getBean(OperaService.class).getOperaByName("Валькирия");
		ctx.getBean(OperaService.class).getOperaList();
		ctx.getBean(OperaService.class).delOpera("Валькирия");

		String date_s = " 2022-01-01 19:00";
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm");
		Date date = dt.parse(date_s);

		ctx.getBean(OperaService.class).addEvent(new Opera("Валькирия"), date);
		ctx.getBean(OperaService.class).delEvent(new Opera("Валькирия"), date);

		ctx.getBean(OperaService.class).buyTicket(new Event(new Opera("Новая опера"), date));
		ctx.getBean(OperaService.class).returnTicket(new Event(new Opera("Новая опера"), date));


	}

}
