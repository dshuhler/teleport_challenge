package com.shuhler.teleport.query;

import com.shuhler.teleport.network.TeleportNet;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CitiesByJumpsQueryTests {

    private TeleportNet mockTeleportNet = mock(TeleportNet.class);

    @Test
    public void testOneWordCities() {
        CitiesByJumpsQuery query = new CitiesByJumpsQuery("cities in jumps: Seattle, 1");
        when(mockTeleportNet.findLinkedCities("Seattle", 1)).thenReturn(Set.of("Vegas", "Portland"));
        assertThat(query.query(mockTeleportNet)).isEqualTo("Cities from Seattle in 1 jumps: Portland, Vegas");
    }

    @Test
    public void testMultiWordCities() {
        CitiesByJumpsQuery query = new CitiesByJumpsQuery("cities in jumps: San Fransisco, 2");
        when(mockTeleportNet.findLinkedCities("San Fransisco", 2)).thenReturn(Set.of("Las Vegas", "A A A"));
        assertThat(query.query(mockTeleportNet)).isEqualTo("Cities from San Fransisco in 2 jumps: A A A, Las Vegas");
    }
}
