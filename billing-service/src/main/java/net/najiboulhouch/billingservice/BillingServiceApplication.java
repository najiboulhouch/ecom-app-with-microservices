package net.najiboulhouch.billingservice;

import net.najiboulhouch.billingservice.entity.Bill;
import net.najiboulhouch.billingservice.entity.ProductItem;
import net.najiboulhouch.billingservice.model.Customer;
import net.najiboulhouch.billingservice.model.Product;
import net.najiboulhouch.billingservice.repository.BillRepository;
import net.najiboulhouch.billingservice.repository.ProductItemRepository;
import net.najiboulhouch.billingservice.service.CustomerRestClient;
import net.najiboulhouch.billingservice.service.ProductRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner start(BillRepository  billRepository ,
                                   ProductItemRepository productItemRepository,
                                   CustomerRestClient customerRestClient,
                                   ProductRestClient productRestClient){
        return args -> {
            List<Product>  products = productRestClient.allProducts().getContent().stream().toList();
            Long customerId = 1L;
            Customer customer = customerRestClient.findCustomerById(customerId);
            if(customer == null ){
                throw  new RuntimeException("Customer not found");
            }

            Bill bill = new Bill();
            bill.setBillDate(new Date());
            bill.setCustomerId(customerId);
            Bill savedBill = billRepository.save(bill);

            products.forEach(product -> {
                ProductItem productItem = new ProductItem();
                productItem.setBill(savedBill);
                productItem.setQuantity(new Random().nextInt(10) );
                productItem.setPrice(product.getPrice());
                productItem.setDiscount(Math.random());
                productItem.setProductId(product.getId());
                productItemRepository.save(productItem);
            });
        };
    }

}
