import calculadora.Calculadora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {

    private Calculadora calc;

    @BeforeEach
    public void inicializa() {
        calc = new Calculadora();
    }

    @DisplayName("Testa a soma de dois numeros")
    @Test
    public void testSomaDoisNumeros() {
        int soma = calc.soma(4, 5);
        assertEquals(9, soma);
    }

    @DisplayName("Testa a divisao de dois numeros")
    @Test
    public void testDivisaoDoisNumeros() {
        int divisao = calc.divisao(8, 4);
        assertEquals(2, divisao);
    }

    @DisplayName("Testa a divisao por zero")
    @Test
    public void testDivisaoPorZero() {
        try {
            int divisao = calc.divisao(8, 0);
            fail("Exceção não lançada");
        }catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }
    }

    @DisplayName("Testa a divisao por zero com assertThrows")
    @Test
    public void testDivisaoPorZeroComAssertThrows() {
        assertThrows(ArithmeticException.class,
                () -> calc.divisao(8, 0));
    }

    @DisplayName("Testa a soma de dois numeros")
    @Test
    public void testSubtracaoComDoisNumeros() {
        int subtracao = calc.subtracao(6, 5);
        assertEquals(1, subtracao);
    }

    @DisplayName("Testa a subtração de dois numeros")
    @Test
    public void testSubtracaoComDoisNumerosComResultadoNegativo() {
        int subtracao = calc.subtracao(6, 7);
        assertEquals(-1, subtracao);
    }

    @DisplayName("Testa a multiplicacao de dois numeros")
    @Test
    public void testMultiplicacaoComDoisNumeros() {
        int multiplicacao = calc.multiplicacao(3, 5);
        assertEquals(15, multiplicacao);
    }

    @DisplayName("Testa a multiplicacao com numero zero")
    @Test
    public void multiplicacaoComZeroDeveRetornarZero() {
        int multiplicacao = calc.multiplicacao(3, 0);
        assertEquals(0, multiplicacao);
    }

    @DisplayName("Testa a somatoria de varios numeros")
    @Test
    public void testSomatoria() {
        int somatoria = calc.somatoria(5);
        assertEquals(15, somatoria);
    }

    @DisplayName("Testa se numero é positivo")
    @Test
    public void testNumeroPositivo() {
        boolean positivo = calc.ehPositivo(5);
        assertTrue(positivo);
    }

    @DisplayName("Testa se numero é positivo")
    @Test
    public void testNumeroNegativo() {
        boolean positivo = calc.ehPositivo(-8);
        assertFalse(positivo);
    }

    @DisplayName("Testa a comparação do maior numero")
    @Test
    public void testComparacaoNumeroMenor() {
        int comparacao = calc.compara(3, 5);
        assertEquals(-1, comparacao);
    }

    @DisplayName("Testa a comparação do menor numero")
    @Test
    public void testComparacaoNumeroMaior() {
        int comparacao = calc.compara(5, 3);
        assertEquals(1, comparacao);
    }

    @DisplayName("Testa a comparação de igualdade")
    @Test
    public void testComparacaoIguais() {
        int comparacao = calc.compara(3, 3);
        assertEquals(0, comparacao);
    }

}


