package StevenAlvaradoCS490.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import StevenAlvaradoCS490.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
