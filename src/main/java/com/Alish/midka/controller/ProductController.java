package com.Alish.midka.controller;

import com.Alish.midka.Dao.product.ProductDao;
import com.Alish.midka.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Controller
public class ProductController {
    private static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    private final ProductDao productDao;


    @Autowired
    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }


    public void showAll(){
        for (Product product : productDao.index())
            System.out.println(product.getId() + "," + product.getName() + "," + product.getDescription() + "," + product.getPrice());
    }

    public void showOne() throws IOException {
        System.out.println("Enter id of the product");
        Long id = Long.valueOf(read.readLine());
        System.out.println("id: " + productDao.selectProduct(id).getId());
        System.out.println("name: " + productDao.selectProduct(id).getName());
        System.out.println("description: " + productDao.selectProduct(id).getDescription());
        System.out.println("price: " + productDao.selectProduct(id).getPrice());
    }

    public void updateProduct() throws IOException {
        System.out.println("Enter id of the product");
        Long productId = Long.valueOf(read.readLine());
        System.out.println("id: " + productDao.selectProduct(productId).getId());

        System.out.println("current productName is" + productDao.selectProduct(productId).getName());
        System.out.println("Enter new:");
        String productName = read.readLine();


        System.out.println("current product description is" + productDao.selectProduct(productId).getDescription());
        System.out.println("Enter new:");
        String productDesc = read.readLine();


        System.out.println("current product price is:" + productDao.selectProduct(productId).getPrice());
        System.out.println("Enter new:");
        double productPrice = Double.parseDouble(read.readLine());


        Product product = new Product(productName, productDesc, productPrice);

        productDao.update(productId, product);
        System.out.println("Updated");
    }

    public void addProduct() throws IOException {
        System.out.println("Enter product Name");
        String newProductName = read.readLine();
        System.out.println("Enter product Description");
        String newProductDesc = read.readLine();
        System.out.println("Enter product price");
        double newProductPrice = Double.parseDouble(read.readLine());

        Product newProduct = new Product(newProductName, newProductDesc, newProductPrice);

        productDao.insertProduct(newProduct);
    }

    public void deleteProduct() throws IOException {
        System.out.println("Enter product id");
        Long deleteProductById = Long.valueOf(read.readLine());

        productDao.delete(deleteProductById);
        System.out.println("DELETED");
    }

    public void butProduct(Long userId) throws IOException {
        System.out.println("Enter id of the product");
        Long productId = Long.valueOf(read.readLine());

        productDao.createOrder(userId, productId);
        System.out.println("THX");
    }
}


















