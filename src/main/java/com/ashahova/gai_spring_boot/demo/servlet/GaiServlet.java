package com.ashahova.gai_spring_boot.demo.servlet;

import com.ashahova.gai_spring_boot.demo.service.NumberGenerationService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class GaiServlet extends HttpServlet{
    @Autowired
    NumberGenerationService genNum;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        synchronized (this) {

            if (request.getRequestURI().equals("/gai/number/random"))
                writer.write(genNum.addRandom());
            else if (request.getRequestURI().equals("/gai/number/next"))
                writer.write(genNum.addNext());
        }
    }
}

