package email.example.email.services;

import java.util.List;
import email.example.email.entities.User;


public interface IServiceUser {

	public void register(User u);
	public List<User> getAll();
	public void delete(int id);
    public User findById(int id);
}
