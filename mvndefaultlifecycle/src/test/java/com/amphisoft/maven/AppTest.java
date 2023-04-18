package com.amphisoft.maven;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest  {
	
	@Test
    public void testApp() {
        assertEquals(App.obtainWelcomeString(), "Hello Karthick. Welcome to maven!!!");
    }
    
}
