package tutorial.mapper;

import java.util.List;

import tutorial.model.User;

public interface UserMapper {
	public List<User> select();

	public User selectOne(String username);

	public User selectByUser(User user);
}
