package com.shuhler.teleport.query;

import com.shuhler.teleport.model.TeleportNet;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CitiesByJumpsQueryTests {

    private TeleportNet mockTeleportNet = mock(TeleportNet.class);


    @Test
    public void testOneWordCities() {
        CitiesByJumpsQuery query = new CitiesByJumpsQuery("cities from Seattle in 2 jumps");
        when(mockTeleportNet.findLinkedCities("Seattle", 2)).thenReturn(Set.of("Vegas", "Portland"));

        String result = query.query(mockTeleportNet);
        assertEquals("cities from Seattle in 2 jumps: Portland, Vegas", result);
    }

    @Test
    public void testMultiWordCities() {
        CitiesByJumpsQuery query = new CitiesByJumpsQuery("cities from San Fransisco in 2 jumps");
        when(mockTeleportNet.findLinkedCities("Seattle", 2)).thenReturn(Set.of("Las Vegas", "A A A"));

        String result = query.query(mockTeleportNet);
        assertEquals("cities from San Fransisco in 2 jumps: Portland, Vegas", result);
    }

}
