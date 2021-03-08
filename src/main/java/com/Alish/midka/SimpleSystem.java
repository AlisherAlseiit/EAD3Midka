package com.Alish.midka;

import com.Alish.midka.Dao.product.ProductDao;
import com.Alish.midka.Dao.user.UserDao;
import com.Alish.midka.config.SpringConfig;
import com.Alish.midka.controller.ProductController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleSystem {
    private static Boolean bool = true;
    private static Boolean userBool = true;
    private static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class
        );

        ProductDao productDao = context.getBean("productDao", ProductDao.class);
        UserDao userDao = context.getBean("userDao", UserDao.class);
        ProductController productController = context.getBean("productController", ProductController.class);

        System.out.println("WELCOME TO MY APPLICATION");
        System.out.println("1. To Login as a ADMIN");
        System.out.println("2. To Login as an User");
        System.out.println("3. To Register as an User");
        String adminOrUser = read.readLine();


        if (adminOrUser.equals("1")) {

            System.out.println("NAME:");
            String adminName = read.readLine();
            System.out.println("PASSWORD:");
            String adminPassword = read.readLine();

            if (userDao.checkAdmin(adminName, adminPassword) != null) {

                System.out.println("WELCOME BACK ADMIN:");

                while (bool) {
                    System.out.println("1. To Return all Products");
                    System.out.println("2. To return 1 Product ");
                    System.out.println("3. To update product");
                    System.out.println("4. to Add new product");
                    System.out.println("5. To delete product");
                    System.out.println("0. To Quit");
                    String choice = read.readLine();

                    switch (choice) {
                        case "1":
                            productController.showAll();
                            break;
                        case "2":
                            productController.showOne();
                            break;
                        case "3":
                            productController.updateProduct();
                            break;
                        case "4":
                            productController.addProduct();
                            break;
                        case "5":
                            productController.deleteProduct();
                            break;
                        default:
                            bool = false;


                    }
                }
            } else
                System.out.println("WRONG NAME OR PASSWORD");

        } else if (adminOrUser.equals("2")) {
            System.out.println("NAME:");
            String userName = read.readLine();
            System.out.println("PASSWORD:");
            String userPassword = read.readLine();

            if (userDao.checkUser(userName, userPassword) != null) {

                System.out.println("HELLO USER");

                while (userBool) {
                    System.out.println("1. To Return all Products");
                    System.out.println("2. To Buy product");
                    System.out.println("0. To Quit");
                    String choice = read.readLine();

                    switch (choice) {
                        case "1":
                            productController.showAll();
                            break;
                        case "2":
                            Long userId = userDao.checkUser(userName, userPassword).getId();
                            productController.butProduct(userId);
                            break;
                        default:
                            userBool = false;

                    }


                }

            } else
                System.out.println("WRONG NAME OR PASSWORD");

        } else if (adminOrUser.equals("3")) {
            System.out.println("NAME:");
            String userName = read.readLine();
            System.out.println("PASSWORD:");
            String userPassword = read.readLine();

            userDao.registerUser(userName, userPassword);

            System.out.println("User Successfully registered");

        } else
            System.out.println("exit");
        return;


    }
}
