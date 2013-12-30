package br.com.willianantunes.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.willianantunes.model.User;
import br.com.willianantunes.service.UserService;

@Controller
public class UserController 
{
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/")
	public ModelAndView list()
	{
		ModelAndView modelAndView = new ModelAndView("user/list");
		
		List<User> users = (List<User>) userService.list();
		
		logger.info(String.format("Listando %s usuários", userService.totalRecords("id")));
		
		modelAndView.addObject("users", users);//userService.list());
		
		return modelAndView;
	}	
	
	@RequestMapping(value="/users/{id}")
	public ModelAndView view(@PathVariable Long id)
	{
		ModelAndView modelAndView = new ModelAndView("user/view");
		
		User user = userService.find(id);
		
		logger.info(String.format("User id: %s", user.getId()));
		logger.info(String.format("User name: %s", user.getName()));
		logger.info(String.format("User birth day year: %s", user.getBirthDate().toString("yyyy")));
		
		modelAndView.addObject("user", user);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute User user)
	{
		ModelAndView modelAndView = new ModelAndView("forward:/");
		
		userService.save(user);
		
		modelAndView.addObject("message", "Usuário cadastrado com sucesso");		
		return modelAndView;
	}	
	
	@RequestMapping(value="/users", method=RequestMethod.PUT)
	public ModelAndView edit(@ModelAttribute User user)
	{
		ModelAndView modelAndView = new ModelAndView("forward:/");
		
		userService.update(user);
		
		modelAndView.addObject("message", "Usuário alterado com sucesso");		
		return modelAndView;
	}	
	
	@RequestMapping(value="/users/delete/{id}")
	public ModelAndView delete(@PathVariable Long id)
	{
		ModelAndView modelAndView = new ModelAndView("forward:/");
		
		User user = new User();
		user.setId(id);
		userService.remove(user);
		
		modelAndView.addObject("message", "Usuário excluído com sucesso");		
		return modelAndView;
	}	
	
}
