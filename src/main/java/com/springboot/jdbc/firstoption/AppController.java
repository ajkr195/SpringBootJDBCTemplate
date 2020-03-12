package com.springboot.jdbc.firstoption;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@Autowired
	private AppUserDAO dao;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<AppUser> listAppUser = dao.list();
		model.addAttribute("listAppUser", listAppUser);
	    return "index";
	}
	
	@RequestMapping("/new")
	public String showNewForm(Model model) {
	    AppUser appuser = new AppUser();
	    model.addAttribute("appuser", appuser);
	     
	    return "new_form";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("appuser") AppUser appuser) {
	    dao.save(appuser);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_form");
	    AppUser appuser = dao.get(id);
	    mav.addObject("appuser", appuser);
	     
	    return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("appuser") AppUser appuser) {
	    dao.update(appuser);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") int id) {
	    dao.delete(id);
	    return "redirect:/";       
	}	
}
