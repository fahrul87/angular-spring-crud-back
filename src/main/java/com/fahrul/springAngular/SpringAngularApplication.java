package com.fahrul.springAngular;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fahrul.springAngular.dao.UserRepository;
import com.fahrul.springAngular.model.User;

@SpringBootApplication
@RestController
@CrossOrigin(origins="*")
public class SpringAngularApplication {
	
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		repository.save(user);
		return "Hi" + user.getName() + " your Registration process successfully completed";
	}
	
	@GetMapping("/getAllUsers")
	public List<User> findAllUser(){
		return repository.findAll();
	}
	
	@GetMapping("/findUser/{email}")
	public List<User> findUser(@PathVariable String email){
		return repository.findByEmail(email);
	}
	
	@DeleteMapping("/cancel/{id}")
	public List<User> cancelRegistrasion(@PathVariable int id){
		repository.deleteById(id);
		return repository.findAll();
	}
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringAngularApplication.class, args);
		
	}

}
