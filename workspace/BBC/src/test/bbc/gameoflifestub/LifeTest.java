package test.bbc.gameoflifestub;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bbc.gameoflifestub.Cell;
import bbc.gameoflifestub.Life;

import static org.junit.Assert.*;
	
public class LifeTest {

	protected ArrayList<ArrayList<Cell>> cells;
	protected Life life;
	
	@Before
	public void setUp() {

    }
	
	@Test
	public void testInitialisation() {

	}

    @Test
    public void testUnderpopulation() {
    	
        assertFalse(life.cellShouldSurvive(0));
        assertFalse(life.cellShouldSurvive(1));
        assertTrue(life.cellShouldSurvive(2));
        assertTrue(life.cellShouldSurvive(3));
    }
}
