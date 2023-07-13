package com.vlavik.homework.servlet;

import com.vlavik.homework.data.ObjectContainer;
import com.vlavik.homework.data.impl.LanguagesContainer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Objects.isNull;

public class MainApp extends HttpServlet {

    private final ObjectContainer collection;
    private AtomicInteger totalHits = new AtomicInteger(0);

    public MainApp() {
        int collectionSize = 10;
        this.collection = new LanguagesContainer(collectionSize);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        increaseHits(req, resp);
        req.setAttribute("collection", "true".equals(req.getParameter("update"))
                ? collection.getOne()
                : collection.getList());
        req.setAttribute("listSize", collection.getSize());
        req.setAttribute("hits", totalHits);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        collection.postOne();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        collection.putOne();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        collection.deleteOne();
    }

    private void increaseHits(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();

        if (isNull(cookies)) {
            addCookie(response, totalHits.getAndIncrement());
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("HITS")) {
                int hits = Integer.parseInt(cookie.getValue());
                if (totalHits.get() < hits) {
                    totalHits.getAndAdd(hits + 1);
                } else {
                    cookie.setValue(String.valueOf(totalHits.getAndIncrement()));
                    response.addCookie(cookie);
                }
            }
        }
    }

    private void addCookie(HttpServletResponse response, int totalHits) {
        Cookie cookie = new Cookie("HITS", String.valueOf(totalHits));
        cookie.setMaxAge(60 * 60 * 24); // expire in 1 day.
        response.addCookie(cookie);
    }
}
