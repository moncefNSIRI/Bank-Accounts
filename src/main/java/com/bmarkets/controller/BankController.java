package com.bmarkets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bmarkets.BankAccountsApplication;
import com.bmarkets.entities.Account;
import com.bmarkets.entities.Operation;
import com.bmarkets.services.IBankServices;

@Controller
public class BankController {

	
	@Autowired
	IBankServices bankServices;
	
	@RequestMapping("/operations")
	public String index() {
		//return "accounts";
		return "accountsOperations";
	}
	
	@RequestMapping("/viewAccount")
	public String viewAccount(Model model,String accountCode,
			@RequestParam(name = "page",defaultValue = "0")int  page,@RequestParam(name = "size",defaultValue ="5" ) int size) {
		model.addAttribute("accountCode",accountCode);
		
		try {
			Account ac1 =bankServices.retreiveAccount(accountCode);
			Page<Operation> pageOperations = bankServices.listOperation(accountCode, page, size);
			model.addAttribute("operations", pageOperations.getContent());
			int[] pages=new int[pageOperations.getTotalPages()];
			model.addAttribute("pages",pages);
			model.addAttribute("account",ac1);
		} catch (Exception e) {
			model.addAttribute("account",null);
			model.addAttribute("exception",e);
		}
		return "accountsOperations";
	}
	
	
	@RequestMapping(value = "/saveOperation",method = RequestMethod.POST)
	public String saveOperation(Model model,
			String operationType,String accountCode, double amount) {
		System.out.println("welcome in saveOperation "+operationType);
		try {
			if(operationType.equals("DEPO")) {
				bankServices.DepositAccount(accountCode, amount);
				System.out.println("deposit made with success");
			}
			else {
				bankServices.WithdrawalAccount(accountCode, amount);
				System.out.println("withdrawal made with success");
			}
		} catch (Exception e) {
			model.addAttribute("error",e);
			return "redirect:/viewAccount?accountCode="+accountCode+"&error="+e.getMessage();
		}
		
		return "redirect:/viewAccount?accountCode="+accountCode;
	}
	
	
}
