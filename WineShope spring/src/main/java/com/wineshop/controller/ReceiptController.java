package com.wineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wineshop.model.Receipt;
import com.wineshop.repository.ReceiptRepository;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/receipt")
public class ReceiptController {

    @Autowired
    private ReceiptRepository receiptRepository;

    @GetMapping("/generate")
    public String generateBill(Model model) {
    	
    	Receipt receipt = new Receipt();
       
        receiptRepository.save(receipt);

        model.addAttribute("receipt", receipt);

        return "receipt"; 
    }
}
