package com.seedit.valid;

import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("logger Test");
		return "home";
	}	
	@ResponseBody
	@RequestMapping(value="check", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public String validCheck(@ModelAttribute @Valid validVo vv, BindingResult br) {
		if(br.hasErrors()) {
			String error = "";
			java.util.List<ObjectError> errorList = br.getAllErrors();
			for(ObjectError e : errorList) {
				error += "error : "+e.getDefaultMessage()+". ";
			}
			return new Gson().toJson(error);
		}
		else
			return new Gson().toJson("success");
	}
	
	/*@ExceptionHandler(Exception.class)
	public String exHandler(Exception e) {
		return new Gson().toJson("에러명 : "+e.getClass().getSimpleName()+", 메세지 : "+e.getMessage());
	}
	*/
	
}
