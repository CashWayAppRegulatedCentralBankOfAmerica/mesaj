package com.example.chat;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/chat")
public class MessageServlet extends HttpServlet {
    private static final ArrayList<Message> messages = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sender = request.getParameter("sender");
        String content = request.getParameter("content");
        if (sender != null && content != null && !content.isEmpty()) {
            messages.add(new Message(sender, content));
        }
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
