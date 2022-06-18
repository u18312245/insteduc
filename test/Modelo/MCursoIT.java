/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidad.Curso;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jose
 */
public class MCursoIT {

    public MCursoIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of InsertaCurso method, of class MCurso.
    
    @Test
    public void testInsertaCurso() {
        System.out.println("InsertaCurso");
        Curso obj = new Curso();
        obj.setNomCurso("EDUCACION FISICA");
        obj.setDescripCurso("CURSO DE DEPORTES PARA LOS ALUMNOS");
        int expResult = 1;
        MCurso instance = new MCurso();
        int result = instance.InsertaCurso(obj);
        System.out.println("Resultado: " + result);
        assertEquals(expResult, result);
    }
 */
    /**
     * Test of BuscarCurso method, of class MCurso.
   
    @Test
    public void testBuscarCurso() {
        System.out.println("BuscarCurso");
        int idCurso = 1;
        MCurso instance = new MCurso();
        Curso expResult = new Curso();
        expResult.setIdCurso(1);
        expResult.setNomCurso("COMUNICACION INTEGRAL");
        expResult.setDescripCurso("CURSO DE COMUNICACION");
        Curso result = instance.BuscarCurso(idCurso);
        int id = expResult.getIdCurso();
        int id1 = result.getIdCurso();
        assertEquals(id, id1);
    }
*/
    /**
     * Test of actualizarCurso method, of class MCurso.

    @Test
    public void testActualizarCurso() {
        System.out.println("actualizarCurso");
        Curso obj = new Curso();
        MCurso instance = new MCurso();
        obj.setIdCurso(1);
        obj.setNomCurso("COMUNICACION INTEGRAL Y REDACION DE TEXTOS");
        obj.setDescripCurso("CURSO DE COMUNICACION INTEGRAL Y TEXTOS");
        int expResult = 1;
        int result = instance.actualizarCurso(obj);
        assertEquals(expResult, result);
    }
    */
    /**
     * Test of eliminarCurso method, of class MCurso.
      */
    @Test
    public void testEliminarCurso() {
        System.out.println("eliminarCurso");
        int idCurso = 16;
        MCurso instance = new MCurso();
        int expResult = 1;
        int result = instance.eliminarCurso(idCurso);
        assertEquals(expResult, result);
    }

}
