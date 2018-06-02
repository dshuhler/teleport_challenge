package com.shuhler.teleport.query;

import com.shuhler.teleport.network.TeleportNet;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoopQueryTests {

    private TeleportNet mockTeleportNet = mock(TeleportNet.class);

    @Test
    public void testOneWordCity() {
        LoopQuery query = new LoopQuery("loop possible: Oakland");
        when(mockTeleportNet.hasLoop("Oakland")).thenReturn(true);
        assertThat(query.query(mockTeleportNet)).isEqualTo("Loop possible from Oakland: true");
    }

    @Test
    public void testMultiWordCity() {
        LoopQuery query = new LoopQuery("loop possible: Las Vegas");
        when(mockTeleportNet.hasLoop("Las Vegas")).thenReturn(false);
        assertThat(query.query(mockTeleportNet)).isEqualTo("Loop possible from Las Vegas: false");
    }
}
