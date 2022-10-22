package com.travel.app.server;


import java.io.IOException;

import com.travel.app.server.Service.DocumentCategorizerService;
import com.travel.app.server.Service.LocationFinder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LocationModelTest {

    @InjectMocks
    DocumentCategorizerService documentCategorizerService;


    @Test
    public void testfindLocation() throws IOException {
        //data - I visit Cinnamon Habarana
        String place = LocationFinder.findLocation("I visit Cinnamon Habarana");
        assertEquals("Hotel", place);
    }

    @Test
    public void testfindLocationWithLongParagraph() throws IOException {
        //data - Marble beach is amazing place to view evening sunset.And Food Also Awsome in Streetshops
        String place = LocationFinder.findLocation("Marble beach is amazing place to view evening sunset.And Food Also Awsome in Streetshops");
        assertEquals("Beach", place);
    }

    @Test
    public void testfindLocationWithMultipleLocations() throws IOException {
        //data - I stay in Cinnamon habarana and hikkaduwa both. But the most beautiful and cleanest one is Oynice cabin
        String place = LocationFinder.findLocation("I stay in Cinnamon habarana and hikkaduwa both. But the most beautiful and cleanest one is Oynice cabin");
        assertEquals("Hotel", place);
    }
}
