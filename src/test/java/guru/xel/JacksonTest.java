package guru.xel;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.xel.jsonClasses.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;


public class JacksonTest {
    
    String jsonFile = "onlineShop.json";

    @DisplayName("Json check value")
    @Test
    void jsonCheckValueTest() throws Exception {
        File file = new File("src/test/resources/"+ jsonFile);
        ObjectMapper objectMapper = new ObjectMapper();
        Product product = objectMapper.readValue(file, Product.class);
        assertThat(product.id).isEqualTo(777);
        assertThat(product.category).isEqualTo("dresses");
        assertThat(product.name).isEqualTo("black dress");
        assertThat(product.available).isEqualTo(true);
        assertThat(product.tags[0]).isEqualTo("black");
        assertThat(product.characteristics.get("euSize")).isEqualTo(55);
    }


}