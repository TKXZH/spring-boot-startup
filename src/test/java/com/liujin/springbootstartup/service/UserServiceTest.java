package com.liujin.springbootstartup.service;

import com.liujin.springbootstartup.dao.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;

    @Before
    public void setUp() {
        when(userRepository.save(any())).thenReturn(null);
    }

    @Test
    public void testLogin() {
    }

    @Test
    public void testAddUser() {
        //        User user1 = User.builder().
        //        User invalidUser1 = new User(null,"","","","","");
        //        User invalidUser2 = new User(1L,"aa","aa","aa","aa","12331a");
        //        User invalidUser6 = new User(1L,"aa","aa","aa","aa","12331");
        //        User invalidUser3 = new User(1L,"aa","aa","aa","aa","123456789");
        //        User invalidUser4 = new User(1L,"aa","aa","aa","aa","aaaaa4");
        //        assertFalse(userService.addUser(invalidUser1));
        //        assertFalse(userService.addUser(invalidUser2));
        //        assertFalse(userService.addUser(invalidUser3));
        //        assertFalse(userService.addUser(invalidUser4));
        //        assertFalse(userService.addUser(invalidUser6));
        //
        //        User validUser = new User(1L,"aa","aa","aa","aa","aaaaaaaaaaaaaaaaa5");
        //        assertTrue(userService.addUser(validUser));
        //        verify(userRepository, times(1)).save(validUser);
    }
}