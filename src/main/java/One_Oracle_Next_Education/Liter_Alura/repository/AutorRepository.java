package One_Oracle_Next_Education.Liter_Alura.repository;

import One_Oracle_Next_Education.Liter_Alura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNome(String nome);

    List<Autor> findByAnoNascimentoLessThanEqualAndAnoFalecimentoGreaterThanEqual(int anoNascimento, int anoFalecimento);
}
