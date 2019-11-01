package com.AlgoChess.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void multiply2and3is6()
    {
		App app = new App();
        assertEquals(app.multiply(2,3), 6);
    }
}
