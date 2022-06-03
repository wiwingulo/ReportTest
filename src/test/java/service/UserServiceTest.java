package service;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import model.User;

public class UserServiceTest {
	
	UserService userService;
	String firstname,lastname,email,password,repeatPassword,id;

	@BeforeEach
	public void init() {
		userService = new UserServiceImpl();
		firstname = "Antoni";
		lastname = "Kurniawan";
		email = "antoni@email.com";
		password = "rahasia";
		repeatPassword = "rahasia";
		
	}
	
	@DisplayName("User object is created")
	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void testCreaterUser_WhenDetailsProvide_ReturnUserObject() {
		//Arrange
		
		//Act
		User user = userService.createUser(firstname, lastname, email, password, repeatPassword);
		
//		try {
//			Thread.sleep(2000);
//			
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}
		
		assertTimeout(Duration.ofMillis(500),()->{
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		//assert
		assertNotNull(user,"if createuser success should not return null");
		assertEquals(firstname, user.getFirstName(),"User firstname is incorrect");
		assertEquals(lastname,user.getLastName(),"User lastname is incorrect");
		assertEquals(email,user.getEmail(),"User email is incorrect");
		assertNotNull(user.getId(),"User id cannot null");
	}
	//red test
	@DisplayName("Empty first name cause exception")
	@Test
	public void testCreateUser_WhenFirstNameIsEmpty_ThrowsIllegalException() {
		
		firstname = "";
		String expectedExceptionMessage = "User firstName is empty";
		
		//act
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,()->{
			userService.createUser(firstname, lastname, email, password, repeatPassword);
		},"Empty first name cause Illegal Argument Exception");
	
		assertEquals(expectedExceptionMessage,thrown.getMessage());
	}
	@DisplayName("Empty last name cause exception")
	@Test
	public void testCreateUser_WhenLastNameIsEmpty_ThrowsIllegalException() {
		
		lastname = "";
		String expectedExceptionMessage = "User lastName is empty";
		
		//act
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class,()->{
			userService.createUser(firstname, lastname, email, password, repeatPassword);
		},"Empty last name cause Illegal Argument Exception");
	
		assertEquals(expectedExceptionMessage,thrown.getMessage());
	}
	
//	
//	test
//	compile
//	clean
//	install	
//	surefire-report:report
//	clean install test surefire-report:report
}
