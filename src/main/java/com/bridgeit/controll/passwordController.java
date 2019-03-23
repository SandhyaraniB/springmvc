package com.bridgeit.controll;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.bridgeit.model.PasswordInfo;
import com.bridgeit.model.User;
import com.bridgeit.service.UserService;
@Controller
public class passwordController 
{
	@Autowired
	public UserService userService;

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) 
	{
		ModelAndView mav = new ModelAndView("forgotpassword");
		mav.addObject("user", new User());
		return mav;
	}

	@RequestMapping(value = "/forgotprocess", method = RequestMethod.POST)
	public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("forgotpassword") User user)
	{
		ModelAndView mav;
		mav = userService.validateUser(user);
		if(mav != null) {//invalid user details
			mav.setViewName("forgotpassword");
			return mav;
		}
		mav = new ModelAndView();
		boolean result = true;
		PasswordInfo passwordInfo = null;
		result = userService.forgot(passwordInfo);
		if( result) {
			mav.setViewName("fetched");
			mav.addObject("email",user.getEmail());
			mav.addObject("email",user.getPassword());
			
		}
		else 
		{
			mav.setViewName("forgotpassword");
			mav.addObject("message", "Registration unsuccessfull...!");
		}
		return mav;
	}
	
}
