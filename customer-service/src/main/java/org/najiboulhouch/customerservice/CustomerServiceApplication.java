package org.najiboulhouch.customerservice;

import org.najiboulhouch.customerservice.entities.Customer;
import org.najiboulhouch.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository , RepositoryRestConfiguration repositoryRestConfiguration){
        return args -> {
                repositoryRestConfiguration.exposeIdsFor(Customer.class);
                customerRepository.saveAll(
                        List.of(
                                Customer.builder().name("najib").email("najib@gmail.com").build(),
                                Customer.builder().name("ali").email("ali@gmail.com").build(),
                                Customer.builder().name("karim").email("karim@gmail.com").build()
                )
                );

                customerRepository.findAll().forEach(System.out::println);
        };
    }

}
