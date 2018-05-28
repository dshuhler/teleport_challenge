package com.shuhler.teleport.query;

import com.shuhler.teleport.model.TeleportNet;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CitiesByJumpsQueryTests {

    TeleportNet mockTeleportNet = mock(TeleportNet.class);


    @Test
    public void test() {

        String queryString = "cities from Seattle in 2 jumps";
        when(mockTeleportNet.findLinkedCities("Seattle", 2)).thenReturn()
        


    }

}
