package StevenAlvaradoCS490.repository;

import StevenAlvaradoCS490.entity.Film;
import StevenAlvaradoCS490.entity.Language;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
