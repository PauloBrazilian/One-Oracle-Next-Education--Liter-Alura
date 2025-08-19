package One_Oracle_Next_Education.Liter_Alura.client;

import One_Oracle_Next_Education.Liter_Alura.dto.GutendexBookDTO;
import One_Oracle_Next_Education.Liter_Alura.dto.LivroDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class GutendexClient {

    private static final String BASE_URL = "https://gutendex.com/books/";

    public Optional<LivroDto> buscarLivroPorTitulo(String titulo) {
        try {
            // Monta a URL com query
            String url = BASE_URL + "?search=" + URLEncoder.encode(titulo, StandardCharsets.UTF_8);

            // Cria o cliente HTTP
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            // Executa a requisição
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Mapeia o JSON
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());

            JsonNode results = root.get("results");
            if (results != null && results.size() > 0) {
                // Pega o primeiro livro
                GutendexBookDTO gutendexBook = mapper.treeToValue(results.get(0), GutendexBookDTO.class);

                // Pega o primeiro autor
                LivroDto dto = getLivroDto(gutendexBook);

                return Optional.of(dto);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private static LivroDto getLivroDto(GutendexBookDTO gutendexBook) {
        String nomeAutor = gutendexBook.getAuthors() != null && !gutendexBook.getAuthors().isEmpty()
                ? gutendexBook.getAuthors().get(0).getNome()
                : "Autor Desconhecido";

        // Pega o idioma principal
        String idioma = gutendexBook.getLanguages() != null && !gutendexBook.getLanguages().isEmpty()
                ? gutendexBook.getLanguages().get(0)
                : "desconhecido";

        // Cria e retorna o DTO
        LivroDto dto = new LivroDto();
        dto.setTitulo(gutendexBook.getTitle());
        dto.setAutor(nomeAutor);
        dto.setIdioma(idioma);
        dto.setNumeroDownloads(gutendexBook.getDownloadCount() != null ? gutendexBook.getDownloadCount() : 0);
        return dto;
    }
}