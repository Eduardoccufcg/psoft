package Aplicacao;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(name, saudacao());
	}

	@RequestMapping("/stime")
	public Time timing() {
		return new Time(horaAtual());
	}

	private String horaAtual() {

		SimpleDateFormat d = new SimpleDateFormat("HH:mm:ss");
		return d.format(new Date());

	}

	private String saudacao() {
		int hour = LocalDateTime.now().getHour();
		String out = "";
		if (hour < 12) {
			out = "Bom dia";
		} else {
			if (hour <= 18) {
				out = "Boa tarde";
			} else {
				out = "Boa noite";
			}
		}

		return out;
	}

}
