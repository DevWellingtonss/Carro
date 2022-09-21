package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class CarroServiceTest {
    @Test
    public void testeVelocidadeNaoPodeSerNegativa() {
        CarroService carroService = new CarroServiceImpl();

        // Given
        Carro carro1 =
                new Carro("prata", "GM", "2012", "Celta");

        // When
        carroService.acelerar(carro1, 20);
        carroService.frear(carro1, 20);
        carroService.frear(carro1, 20);

        // Then
        Assert.assertTrue(carro1.getVelocidadeAtual() == 0);
    }

    @Test
    public void testeDeveAcelerarCorretamente() {
        CarroService carroService = new CarroServiceImpl();

        Carro carro1 =
                new Carro("prata", "GM", "2012", "Celta");
        Carro carro2 =
                new Carro("prata", "GM", "2012", "Celta");
        Carro carro3 =
                 null;
        
        carroService.ligar(carro1);
        carroService.acelerar(carro1, 20);

        carroService.ligar(carro2);
        carroService.acelerar(carro2, 20);

        Assert.assertTrue(carro1.isLigado());

        Assert.assertFalse(carro1.getVelocidadeAtual()==10);

        Assert.assertEquals(20,carro1.getVelocidadeAtual());

        Assert.assertEquals(carro1,carro2);

        Assert.assertNotEquals(30,carro1.getVelocidadeAtual());

        Assert.assertSame(carro1.getVelocidadeAtual(),carro2.getVelocidadeAtual());

        Assert.assertSame(carro1,carro1);

        Assert.assertNull(carro3);

        Assert.assertThat(carro1.getVelocidadeAtual(), is(equalTo(20)));

        Assert.assertThat(carro1.getVelocidadeAtual(), is(not(10)));

    }

    @Test
    public void testeNaoDeveAcelerarDesligado() {
        CarroService carroService = new CarroServiceImpl();

        // Given
        Carro carro1 =
                new Carro("prata", "GM", "2012", "Celta");

        // When
        carroService.acelerar(carro1, 20);

        // Then
        Assert.assertTrue(carro1.getVelocidadeAtual() == 0);
    }
}
