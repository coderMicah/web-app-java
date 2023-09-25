package com.Micah.webapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	private AuthenticationService authenticationService;

	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

//	@RequestMapping("/login")
//	public String goToLoginPage(@RequestParam String name, ModelMap model) {
//		model.put("name", name);
//		return "login";
//	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String goToLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String goWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {

		if (authenticationService.authenticate(name, password)) {
			model.put("name", name);
			return "welcome";
		}
		model.put("errorMessage","Invalid credentials Please try again");
		return "login";
	}
}
