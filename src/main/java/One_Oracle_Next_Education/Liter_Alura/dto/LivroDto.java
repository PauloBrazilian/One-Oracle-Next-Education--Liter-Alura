package One_Oracle_Next_Education.Liter_Alura.dto;

import lombok.Data;

@Data
public class LivroDto {

    private String titulo;
    private String autor;
    private String idioma;
    private int numeroDownloads;
}