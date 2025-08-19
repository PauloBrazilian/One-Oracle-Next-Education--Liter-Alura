package One_Oracle_Next_Education.Liter_Alura.controller;

import One_Oracle_Next_Education.Liter_Alura.model.Autor;
import One_Oracle_Next_Education.Liter_Alura.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> listarTodos() {
        return autorService.listarTodos();
    }

    @GetMapping("/vivos/{ano}")
    public List<Autor> listarVivos(@PathVariable int ano) {
        return autorService.listarAutoresVivos(ano);
    }
}
