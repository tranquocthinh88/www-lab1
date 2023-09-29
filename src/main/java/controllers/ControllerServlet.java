package controllers;

import com.example.week01_lab_tranquocthinh_20067241.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ServicesAccount;

import java.awt.datatransfer.DataFlavor;
import java.io.IOException;

@WebServlet(urlPatterns = "/controllServlet")
public class ControllerServlet extends HttpServlet {
    private final ServicesAccount account = new ServicesAccount();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        resp.getWriter().println(account.getAll());
    }
}
