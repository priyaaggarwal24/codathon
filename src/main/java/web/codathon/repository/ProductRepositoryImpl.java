package web.codathon.repository;

import org.springframework.stereotype.Repository;
import web.codathon.domain.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    private static List<Product> productList = new ArrayList<Product>();

    // create a list of products here
    static{
        Product p1 = new Product();
        p1.setName("Mobile");
        p1.setPrice(20000);
        productList.add(p1);

        Product p5 = new Product();
        p5.setName("TV");
        p5.setPrice(15000);
        productList.add(p5);

        Product p2 = new Product();
        p2.setName("Fridge");
        p2.setPrice(18000);
        productList.add(p2);

        Product p3 = new Product();
        p3.setName("Telephone");
        p3.setPrice(400);
        productList.add(p3);

        Product p4 = new Product();
        p4.setName("laptop");
        p4.setPrice(34000);
        productList.add(p4);
    }

    @Override
    public List<Product> getProducts() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void remove(Product product) {
        productList.remove(product);
    }
}
