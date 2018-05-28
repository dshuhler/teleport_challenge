package com.shuhler.teleport.query;

import com.shuhler.teleport.model.TeleportNet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConnectedCitiesQueryTests {

    private TeleportNet mockTeleportNet = mock(TeleportNet.class);

    @Test
    public void canHandleOneWordCities() {
        ConnectedCitiesQuery query = new ConnectedCitiesQuery("teleport between: Oakland, Atlanta");
        when(mockTeleportNet.areConnected("Oakland", "Atlanta"))
                .thenReturn(true);

        String result = query.query(mockTeleportNet);
        assertEquals("Can I teleport from Oakland to Atlanta: true", result);
    }

    @Test
    public void canHandleMultiWordCities() {
        ConnectedCitiesQuery query = new ConnectedCitiesQuery("teleport between: New York, A A A");
        when(mockTeleportNet.areConnected("New York", "A A A"))
                .thenReturn(false);

        String result = query.query(mockTeleportNet);
        assertEquals("Can I teleport from New York to A A A: false", result);
    }
}
