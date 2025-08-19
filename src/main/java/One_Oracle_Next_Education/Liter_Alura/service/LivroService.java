package One_Oracle_Next_Education.Liter_Alura.service;

import One_Oracle_Next_Education.Liter_Alura.client.GutendexClient;
import One_Oracle_Next_Education.Liter_Alura.dto.LivroDto;
import One_Oracle_Next_Education.Liter_Alura.model.Autor;
import One_Oracle_Next_Education.Liter_Alura.model.Livro;
import One_Oracle_Next_Education.Liter_Alura.repository.AutorRepository;
import One_Oracle_Next_Education.Liter_Alura.repository.LivroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LivroService {

    private LivroRepository livroRepository;
    private AutorRepository autorRepository;
    private GutendexClient gutendexClient;

    public Livro salvarLivroPorTitulo(String titulo) {
        LivroDto dto = gutendexClient.buscarLivroPorTitulo(titulo)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado na API"));

        Autor autor = autorRepository.findByNome(dto.getAutor())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado na API"));

        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setIdioma(dto.getIdioma());
        livro.setDownloads(dto.getNumeroDownloads());
        livro.setAutor(autor);

        return livroRepository.save(livro);
    }
}