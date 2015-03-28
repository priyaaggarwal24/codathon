package web.codathon.repository;

import org.springframework.stereotype.Repository;
import web.codathon.domain.Product;

import java.util.List;

public interface IProductRepository {

    List<Product> getProducts();

    void add(Product product);

    void remove(Product product);
}
