package test;

import mb.CreateBeans;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logon.LogonDBBean;

@Controller
//@RequestMapping( "/logonlogin")
public class LogonLogin {

    private final CreateBeans createBeans;
	@Resource
	private LogonDBBean logonDao;

    LogonLogin(CreateBeans createBeans) {
        this.createBeans = createBeans;
    }
	
	@GetMapping
	public String loginForm(HttpServletRequest request, Model model) throws Exception {
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
		return "member/loginForm";
	}	
	
	@PostMapping
	public String loginPro( @RequestParam String userId, @RequestParam String passwd,
			 @RequestParam(required = false) String rememberId, Model model,		// required = false가 꼭 안가져와도 된다는거임 
			 HttpSession session, HttpServletResponse response) throws Exception {		
		int result = logonDao.check( userId, passwd );
		if( result == 1 ) {
			
			session.setAttribute( "memId", userId );	
			if (rememberId != null) {	 
	            Cookie cookie = new Cookie("rememberId", userId);	// 아이디 저장 체크하면 아이디
	            cookie.setMaxAge(60 * 60 * 24 * 30); 				// 저장시간 보통 초단위라서 1분 1시간 24시간 30일 요느낌임
	            cookie.setPath("/"); 								// 아무데서나 가져가기 가능
	            response.addCookie(cookie);	// cookie는 model로 못해서 response로 한대요 
			} else { 
	            Cookie cookie = new Cookie("rememberId", null);
	            cookie.setMaxAge(0);								// 아이디 저장 안했으면 이전 쿠키 지워야 되니까 일케함 
	            cookie.setPath("/");
	            response.addCookie(cookie);	
	        }
		}
		model.addAttribute( "result", result );				
		return "member/loginPro";
	}
}
