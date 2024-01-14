package com.learning.technology;

import com.learning.technology.model.User;
import com.learning.technology.repository.UserRepository;
import com.learning.technology.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class TechnologyApplicationTests {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	public void getUserTest(){
		when(userRepository.findAll())
				.thenReturn(Stream.of(new User(376,"Daniel",31,"USA"), new User(958,"Huy", 35, "UK")).collect(Collectors.toList()));
		assertEquals(2, userService.getUsers().size());
	}

	@Test
	public void getUserByAddressTest(){
		String address = "Bangalore";
		when(userRepository.findByAddress(address)).thenReturn(Stream
				.of(new User(376,"Daniel",31,"USA")).collect(Collectors.toList()));
		assertEquals(1, userService.getUserByAddress(address).size());
	}

	@Test
	public void saveUserTest(){
		User user = new User(4,"Arvind",35,"Witham");
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user,userService.addUser(user));
	}

	@Test
	public void deleteUserTest(){
		User user1 = new User(4,"Arvind",35,"Witham");
		userService.deleteUser(user1);
		verify(userRepository,times(1)).delete(user1);
	}

	@Test
	void contextLoads() {
	}

}
