package com.bridgeit.controll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.model.User;
import com.bridgeit.service.UserService;

@Controller 
public class RegistrationController {
	@Autowired
	public UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) 
	{
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		return mav;
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("user") User user)
	{
		ModelAndView mav;
		mav = userService.validateUser(user);
		if(mav != null) {//invalid user details
			mav.setViewName("register");
			return mav;
		}
		mav = new ModelAndView();
		int result = -1;
		result = userService.register(user);
		if( result == 0) {
			mav.setViewName("regSuccess");
			mav.addObject("email",user.getEmail());
			mav.addObject("password",user.getPassword());
		}
		else 
		{
			mav.setViewName("register");
			mav.addObject("message", "Registration unsuccessfull...!");
		}
		return mav;
	}
}