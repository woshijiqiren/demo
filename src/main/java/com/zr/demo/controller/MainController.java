package com.zr.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zr.demo.producer.IMessageProducerService;
import com.zr.demo.producer.mail;
import com.zr.demo.service.UserService;
import com.zr.model.User;
@RestController
public class MainController {
	
	@Autowired  
    private UserService  userService;
	
	@RequestMapping(value = "/abc")
	public User home() {
		return userService.selectUserById(1);
	}
	
	@Autowired
    private IMessageProducerService messageProducer;
	@RequestMapping(value = "/")
	public void testSend() throws Exception {
        for (int x = 0; x < 10; x++) {
            this.messageProducer.sendMessage("study - " + x);
        }
    }
	@Autowired
	 private mail mail1;
	@RequestMapping(value = "/mail")
	public void sendMail() throws Exception {
		 mail1.testSendMail();
    }
	@RequestMapping(value = "/all")
	public List<User> selectAll() throws Exception {
		return  userService.selectAll();
   }
}
