package One_Oracle_Next_Education.Liter_Alura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GutendexBookDTO {
    private String title;

    private List<String> languages;

    @JsonAlias({"download_count", "downloads"})
    private Integer downloadCount;

    private List<GutendexAuthorDTO> authors;
}