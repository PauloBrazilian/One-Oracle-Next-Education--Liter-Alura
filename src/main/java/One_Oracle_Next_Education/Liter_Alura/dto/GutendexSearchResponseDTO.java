package One_Oracle_Next_Education.Liter_Alura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GutendexSearchResponseDTO {
    private Integer count;
    private String next;
    private String previous;
    private List<GutendexBookDTO> results;
}
