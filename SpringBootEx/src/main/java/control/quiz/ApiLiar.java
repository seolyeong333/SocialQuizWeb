package control.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("quiz/apiliar")
public class ApiLiar {
	@GetMapping
	public String apiLiar() {
		return "quiz/apiLiar";
	}
}
