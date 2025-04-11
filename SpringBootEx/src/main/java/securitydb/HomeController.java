package securitydb;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping( "/home" )
public class HomeController {
	@GetMapping
	public String main( Model model, HttpSession session, HttpServletRequest request ) {
		String memId = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("[/home] memId : "+memId);
		
		if(memId == "anonymousUser")
			memId = null;
		
		String rememberedId = "";									// 여기 get매핑은 링크로 이동하는 곳이니까 여기에다가  
	    Cookie[] cookies = request.getCookies();				// 쿠키 통으로 가져옴
	    if (cookies != null) {
	        for (Cookie cookie : cookies) {						// 쿠키 끝까지 반복문
	            if ("rememberId".equals(cookie.getName())) {	// rememberId에 저장해놨으니까 이거 가져와
	                rememberedId = cookie.getValue();			// 값에다가 넣고 rememberedId
	                break;
	            }
	        }
	    }

	    model.addAttribute("rememberedId", rememberedId);		// 값에다가 넣고 rememberedId		
		System.out.println("[/home] rememberedId : "+rememberedId);
		
		
		
		
		session.setAttribute("memId", memId);
		model.addAttribute( "result", "메인페이지 입니다." );
		return "home/home";
	}	
}