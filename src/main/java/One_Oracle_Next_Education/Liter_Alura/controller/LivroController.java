package One_Oracle_Next_Education.Liter_Alura.controller;

import One_Oracle_Next_Education.Liter_Alura.model.Livro;
import One_Oracle_Next_Education.Liter_Alura.service.LivroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/livros")
public class LivroController {

    private LivroService livroService;

    @PostMapping("/buscar")
    public Livro salvarLivroPorTitulo(@RequestParam String titulo) {
        return livroService.salvarLivroPorTitulo(titulo);
    }


}