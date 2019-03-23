package com.bridgeit.controll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.bridgeit.model.LoginInfo;
import com.bridgeit.service.UserService;


@Controller
public class Logincontroller 
{
	@Autowired
	UserService userService;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLoginPage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new LoginInfo());
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") LoginInfo loginInfo) 
	{
		ModelAndView mav;
		mav = userService.validateLoginInfo(loginInfo);
		if(mav != null) {
			mav.setViewName("login");
			return mav;
		}
		boolean user = userService.login(loginInfo);
		if (user != false) {
			mav = new ModelAndView("success");
			//mav.addObject("emailid", user.getEmail());
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "email or Password is wrong...!");
		}
		return mav;
	}
}