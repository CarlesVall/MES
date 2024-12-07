package pruebas;

import logica.Coche;
import logica.Categoria;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


public class CategoriaTests {

    private Categoria categoria;

    @Before
    public void setUp() {
        categoria = new Categoria("SUV", 100.0, 50.0, 20.0, 15.0, 10.0, "economy");
    }

    @Test
    public void testGetNombre() {
        assertEquals("SUV", categoria.getNombre());
    }

    @Test
    public void testSetNombre() {
        categoria.setNombre("Deportivo");
        assertEquals("Deportivo", categoria.getNombre());
    }

    @Test
    public void testGetPrecioModIlimitada() {
        assertEquals(100.0, categoria.getPrecioModIlimitada(), 0.0);
    }

    @Test
    public void testSetPrecioModIlimitada() {
        categoria.setPrecioModIlimitada(120.0);
        assertEquals(120.0, categoria.getPrecioModIlimitada(), 0.0);
    }

    @Test
    public void testGetPrecioModKms() {
        assertEquals(50.0, categoria.getPrecioModKms(), 0.0);
    }

    @Test
    public void testSetPrecioModKms() {
        categoria.setPrecioModKms(60.0);
        assertEquals(60.0, categoria.getPrecioModKms(), 0.0);
    }

    @Test
    public void testGetPrecioKmModKms() {
        assertEquals(10.0, categoria.getPrecioKmModKms(), 0.0);
    }

    @Test
    public void testSetPrecioKmModKms() {
        categoria.setPrecioKmModKms(15.0);
        assertEquals(15.0, categoria.getPrecioKmModKms(), 0.0);
    }

    @Test
    public void testGetPrecioSeguroTRiesgo() {
        assertEquals(20.0, categoria.getPrecioSeguroTRiesgo(), 0.0);
    }

    @Test
    public void testSetPrecioSeguroTRiesgo() {
        categoria.setPrecioSeguroTRiesgo(25.0);
        assertEquals(25.0, categoria.getPrecioSeguroTRiesgo(), 0.0);
    }

    @Test
    public void testGetPrecioSeguroTerceros() {
        assertEquals(15.0, categoria.getPrecioSeguroTerceros(), 0.0);
    }

    @Test
    public void testSetPrecioSeguroTerceros() {
        categoria.setPrecioSeguroTerceros(18.0);
        assertEquals(18.0, categoria.getPrecioSeguroTerceros(), 0.0);
    }

    @Test
    public void testGetSuperior() {
        assertEquals("economy", categoria.getSuperior());
    }

    @Test
    public void testSetSuperior() {
        categoria.setSuperior("luxury");
        assertEquals("luxury", categoria.getSuperior());
    }

    @Test
    public void testGetListaCoches() {
        assertNull(categoria.getListaCoches());
    }

    @Test
    public void testSetListaCoches() {
        List<Coche> coches = new ArrayList<>();
        categoria.setListaCoches(coches);
        assertEquals(coches, categoria.getListaCoches());
    }
}