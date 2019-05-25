package Aplicacao;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		model.addAttribute("periodo", getPeriodo());
		return "c";
	}

	@GetMapping("/time")
	public String serverTime(Model model) {
		model.addAttribute("hour", time());
		return "hora";

	}

	private String time() {
		SimpleDateFormat d = new SimpleDateFormat("HH:mm:ss");
		return d.format(new Date());
	}

	private String getPeriodo() {
		int hour = LocalDateTime.now().getHour();
		String out = "";
		if (hour < 12) {
			out = "bom dia";
		} else {
			if (hour <= 18) {
				out = "boa tarde";
			} else {
				out = "boa noite";
			}
		}

		return out;

	}

}
