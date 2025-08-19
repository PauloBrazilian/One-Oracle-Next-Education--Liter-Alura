package One_Oracle_Next_Education.Liter_Alura.service;

import One_Oracle_Next_Education.Liter_Alura.model.Autor;
import One_Oracle_Next_Education.Liter_Alura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public List<Autor> listarAutoresVivos(int ano) {
        return autorRepository.findByAnoNascimentoLessThanEqualAndAnoFalecimentoGreaterThanEqual(ano, ano)
                .stream()
                .distinct()
                .toList();
    }

    public Autor salvarSeNaoExistir(Autor autor) {
        return autorRepository.findByNome(autor.getNome())
                .orElseGet(() -> autorRepository.save(autor));
    }
}
