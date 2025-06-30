import br.vsi_brasil.consulting.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class AnagramGeneratorTest {

    @Test
    void testGenerateAnagramsWithThreeLetters() {
        char[] input = {'a', 'b', 'c'};
        List<String> result = Main.anagramsGenerator(input);

        assertEquals(6, result.size());
        assertTrue(result.contains("abc"));
        assertTrue(result.contains("acb"));
        assertTrue(result.contains("bac"));
        assertTrue(result.contains("bca"));
        assertTrue(result.contains("cab"));
        assertTrue(result.contains("cba"));
    }

    @Test
    void testGenerateAnagramsWithSingleLetter() {
        char[] input = {'x'};
        List<String> result = Main.anagramsGenerator(input);

        assertEquals(1, result.size());
        assertEquals("x", result.get(0));
    }

    @Test
    void testGenerateAnagramsWithEmptyInput() {
        char[] input = {};
        assertThrows(IllegalArgumentException.class, () -> {
            Main.anagramsGenerator(input);
        });
    }

    @Test
    void testGenerateAnagramsWithNonLetterInput() {
        char[] input = {'a', '1', 'c'};
        assertThrows(IllegalArgumentException.class, () -> {
            Main.anagramsGenerator(input);
        });
    }

    @Test
    void testGenerateAnagramsWithNullInput() {
        assertThrows(IllegalArgumentException.class, () -> {
            Main.anagramsGenerator(null);
        });
    }
}