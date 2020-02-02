package email.example.email.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import email.example.email.entities.User;
import email.example.email.services.IServiceUser;
import email.example.email.services.MailService;


@CrossOrigin(origins = "*")
@RestController
public class UserController {

	@Autowired
    private IServiceUser userService;
	@Autowired
	private MailService mailService;
    @GetMapping(value="/users")
    public List<User> listUser(){
        return userService.getAll();
    }
    @PostMapping(value="/add")
    public ResponseEntity<?> addUser(@RequestBody User u ){
         userService.register(u);
         return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/users/{id}")
    public User getOne(@PathVariable(value = "id") int id){
        return userService.findById(id);
    }

    @PostMapping("send-mail/{id}")
	public String send(@PathVariable("id") int id) {
    	User user = userService.findById(id);
		try {
			mailService.sendEmail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}
}
