package net.najiboulhouch.billingservice.repository;

import net.najiboulhouch.billingservice.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductItemRepository extends JpaRepository<ProductItem , Long> {
}
