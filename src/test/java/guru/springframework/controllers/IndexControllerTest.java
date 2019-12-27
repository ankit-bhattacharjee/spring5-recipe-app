package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import guru.springframework.services.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class IndexControllerTest {

    private IndexController indexController;
    @Mock
    private RecipeServiceImpl recipeService;
    @Mock
    private Model model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {
        String indexPage = indexController.getIndexPage(model);
        assertEquals("index", indexPage);
        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
        verify(recipeService, times(1)).getRecipes();
    }
}