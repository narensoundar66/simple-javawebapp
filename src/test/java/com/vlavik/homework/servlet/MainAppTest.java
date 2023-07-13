package com.vlavik.homework.servlet;

import com.vlavik.homework.data.ObjectContainer;
import com.vlavik.homework.data.impl.LanguagesContainer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class MainAppTest extends Mockito {

    private ObjectContainer collection;
    private MainApp servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        servlet = new MainApp();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        collection = new LanguagesContainer(10);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void doGet() {
        when(request.getAttribute("listSize")).thenReturn(collection.getSize());
        new MainApp().doPost(request, response);

        assertTrue(request.getAttribute("listSize").equals(10));

    }

    @Test
    public void doGetWithParam() {
        given().
                param("update", "true").
        when().
                get("/").
        then().
                statusCode(200);
    }

    @Test
    public void doPost() {
        given().
        when().
                post("/").
        then().
                statusCode(200);
    }

    @Test
    public void doPut() {
        given().
        when().
                put("/").
        then().
                statusCode(200);
    }

    @Test
    public void doDelete() {
        given().
        when().
                delete("/").
        then().
                statusCode(200);
    }
}