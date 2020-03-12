package com.springboot.jdbc.secondoption;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.jdbc.firstoption.AppUser;

@Controller
public class SecondAppController {
	
	@Autowired
	private AppUserServiceImpl appUserServiceImpl;
	
	@RequestMapping("/secondoption")
	public String viewHomePage(Model model) {
		List<AppUser> listAppUser = appUserServiceImpl.getAllAppUsers();
		model.addAttribute("listAppUser", listAppUser);
	    return "index2";
	}
	
	@RequestMapping("/new2")
	public String showNewForm(Model model) {
	    AppUser appuser = new AppUser();
	    model.addAttribute("appuser", appuser);
	     
	    return "new_form2";
	}
	
	@RequestMapping(value = "/save2", method = RequestMethod.POST)
	public String save(@ModelAttribute("appuser") AppUser appuser) {
		appUserServiceImpl.addAppUser(appuser);
	     
	    return "redirect:/secondoption";
	}
	
	@RequestMapping("/edit2/{id}")
	public ModelAndView showEditForm(@PathVariable(name = "id") Long id) {
	    ModelAndView mav = new ModelAndView("edit_form2");
	    AppUser appuser = appUserServiceImpl.findeAppUserById(id);
	    mav.addObject("appuser", appuser);
	     
	    return mav;
	}
	
	@RequestMapping(value = "/update2", method = RequestMethod.POST)
	public String update(@ModelAttribute("appuser") AppUser appuser) {
		appUserServiceImpl.updateAppUser(appuser);
	     
	    return "redirect:/secondoption";
	}
	
	@RequestMapping("/delete2/{id}")
	public String delete(@PathVariable(name = "id") Long id) {
		appUserServiceImpl.deleteAppUser(id);
	    return "redirect:/secondoption";       
	}	
}
