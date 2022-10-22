package com.travel.app.server;


import java.io.IOException;

import com.travel.app.server.Service.DocumentCategorizerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DocumentCategorizerModelTest {

    @InjectMocks
    DocumentCategorizerService documentCategorizerService;


    @Test
    public void testGetCategory() throws IOException {
        //data - clean rooms
        String category = documentCategorizerService.getCategory("clean rooms");
        assertEquals("Good", category);
    }

    @Test
    public void testGetCategoryLongWords() throws IOException {
        //data - Deputy Prime Minister
        String category = documentCategorizerService.getCategory("I visit cinnamon habarana hotel. Thair room service is worst");
        assertEquals("NotRecommend", category);
    }

    @Test
    public void testGetCategoryForBad() throws IOException {
        //data - not happy with the service
        String category = documentCategorizerService.getCategory("not happy with the service");
        assertEquals("NotRecommend", category);
    }
}
