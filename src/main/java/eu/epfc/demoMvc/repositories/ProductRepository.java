package eu.epfc.demoMvc.repositories;

import eu.epfc.demoMvc.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
