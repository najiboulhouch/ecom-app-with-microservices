package net.najiboulhouch.billingservice.repository;

import net.najiboulhouch.billingservice.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BillRepository extends JpaRepository<Bill, Long> {
}
