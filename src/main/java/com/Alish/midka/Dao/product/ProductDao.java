package com.Alish.midka.Dao.product;

import com.Alish.midka.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {
    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> index(){
        return jdbcTemplate.query("SELECT * FROM Product ORDER  BY id asc", new ProductRowMapper());

    }

    public Product selectProduct(Long id){
        return jdbcTemplate.query("SELECT * FROM Product WHERE id=?", new Object[]{id}, new ProductRowMapper())
                .stream().findAny().orElse(null);
    }

    public void insertProduct(Product product){
        jdbcTemplate.update("INSERT INTO Product(name, description, price) VALUES (?, ?, ?)", product.getName(),
                product.getDescription(), product.getPrice());
    }

    public void update(Long id, Product updatedProduct){
        jdbcTemplate.update("UPDATE Product SET name=?, description=?, price=? WHERE id=?", updatedProduct.getName(),
                updatedProduct.getDescription(), updatedProduct.getPrice(), id);
    }

    public void delete(Long id){
        jdbcTemplate.update("DELETE FROM Product WHERE id=?", id);
    }


    public void createOrder(Long userId, Long productId){
        jdbcTemplate.update("INSERT INTO Ord(registration_id, product_id) VALUES (?, ?)", userId, productId);
    }
}

