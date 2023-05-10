/**
 * 
 */
package com.basalt.challenge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.basalt.challenge.beans.Login;
import com.basalt.challenge.entity.TransactionEntity;
import com.basalt.challenge.service.TransactionServiceImpl;


@Controller
@RequestMapping("/")
public class TransactionController 
{
	@Autowired
	TransactionServiceImpl service;
	
	 @GetMapping("/")
	    public String viewLoginPage() {
	       return "login";
	    }
	 
	 @PostMapping("/login")
	 public String login(@ModelAttribute(name="loginForm") Login login, Model m) {
	  String uname = login.getUsername();
	  String pass = login.getPassword();
	  if(uname.equals("username") && pass.equals("password")) {
	   m.addAttribute("uname", uname);
	   m.addAttribute("pass", pass);
	   return "homepage";
	  }
	  m.addAttribute("error", "Incorrect Username & Password");
	  return "login";
	  
	 }
	
	@RequestMapping("/getAll")
	public String getAll(Model model) 
	{
		List<TransactionEntity> list = service.getAll();

		model.addAttribute("services", list);
		return "list-services";
	}
	
	@RequestMapping("/getType")
	public String getType(Model model) 
	{
        Integer balance = service.getType();
        Integer credit = service.getCreditType();
        Integer debit = service.getDebitType();
		model.addAttribute("balance",balance );
		model.addAttribute("credit",credit );
		model.addAttribute("debit",debit );
		return "balance";
	}
	
	@RequestMapping(path = "/addtransaction", method = RequestMethod.POST)
	public String createOrUpdate(TransactionEntity trans) 
	{
		service.createOrUpdate(trans);
		return "redirect:/getAll";
	}
	

	@RequestMapping(path = "/delete/{id}")
	public String deleteById(Model model, @PathVariable("id") Long id) throws Exception{
		service.deleteById(id);
		return "redirect:/getAll";
	}
	
	}
