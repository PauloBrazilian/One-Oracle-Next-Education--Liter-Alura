package One_Oracle_Next_Education.Liter_Alura.repository;

import One_Oracle_Next_Education.Liter_Alura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByIdiomaIgnoreCase(String idioma);
    long countByIdiomaIgnoreCase(String idioma);
}