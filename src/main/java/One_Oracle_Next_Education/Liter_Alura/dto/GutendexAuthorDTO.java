package One_Oracle_Next_Education.Liter_Alura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GutendexAuthorDTO {
    @JsonProperty("name")
    private String nome;

    @JsonProperty("birth_year")
    private Integer anoNascimento;

    @JsonProperty("death_year")
    private Integer anoFalecimento;
}
