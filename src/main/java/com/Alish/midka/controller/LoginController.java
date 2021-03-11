package com.Alish.midka.controller;

import com.Alish.midka.Dao.product.ProductDao;
import com.Alish.midka.Dao.user.UserDao;
import com.Alish.midka.event.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class LoginController  implements ApplicationEventPublisherAware {
    private static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    private final UserDao userDao;
    private  Long userId;
    private final ProductDao productDao;
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    public LoginController(UserDao userDao, ProductDao productDao) {
        this.userDao = userDao;
        this.productDao = productDao;
    }


    public boolean adminLogin() throws IOException {
        System.out.println("NAME:");
        String adminName = read.readLine();
        System.out.println("PASSWORD:");
        String adminPassword = read.readLine();


        if (userDao.checkAdmin(adminName, adminPassword) != null)

            return true;
        else
            return false;

    }

    public void buyProduct() throws IOException {
        System.out.println("Enter id of the product");
        Long productId = Long.valueOf(read.readLine());

        productDao.createOrder(userId, productId);

       this.eventPublisher.publishEvent(new UserEvent(this, userId));

    }


    public boolean userLogin() throws IOException {
        System.out.println("NAME:");
        String userName = read.readLine();
        System.out.println("PASSWORD:");
        String userPassword = read.readLine();



        if(userDao.checkUser(userName, userPassword) != null) {
            userId = userDao.checkUser(userName, userPassword).getId();
            return true;
        }else {
            return false;

        }
    }


    public void userRegister() throws IOException {
        System.out.println("NAME:");
        String userName = read.readLine();
        System.out.println("PASSWORD:");
        String userPassword = read.readLine();

        userDao.registerUser(userName, userPassword);

        System.out.println("User Successfully registered");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

}
