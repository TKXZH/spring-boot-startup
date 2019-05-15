package com.liujin.springbootstartup.service;

import com.liujin.springbootstartup.dao.UserRepository;
import com.liujin.springbootstartup.domain.Product;
import com.liujin.springbootstartup.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean login(User user) {
        return (userRepository.findByIdAndPassword(user.getId(), user.getPassword()) != null);
    }

    public boolean addUser(User user) {
        int hasNumber = 0;
        int hasLetter = 0;

        if(user.getId() == null || user.getName()== null || user.getPassword() == null || user.getEmail() == null) {
            return false;
        } else if(user.getPassword().length() < 8) {
            return false;
        } else {
            for (int i = 0; i < user.getPassword().length(); i++) {
                if(Character.isDigit(user.getPassword().charAt(i))) {
                    hasNumber = 1;
                    break;
                }

            }

            for (int i = 0; i < user.getPassword().length(); i++) {
                if(Character.isLetter(user.getPassword().charAt(i))) {
                    hasLetter = 1;
                    break;
                }
            }
        }
        int hasNumAndLet = hasNumber + hasLetter;
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userRepository.save(user);
        return (hasNumAndLet == 2);
    }

    @PostConstruct
    public void test() {
        Product product = new Product(12L, "tea", "test", 12L);
        User user = new User(23L, null, null, "二狗子", null, "tea", "tea", null, "tea", "tea", Arrays.asList(product));
        userRepository.save(user);
    }
}
