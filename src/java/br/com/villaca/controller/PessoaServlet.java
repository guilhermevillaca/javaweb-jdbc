package br.com.villaca.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import br.com.villaca.dao.PessoaDAO;
import br.com.villaca.model.Pessoa;

@WebServlet("/pessoa")
public class PessoaServlet extends HttpServlet {
    private PessoaDAO pessoaDAO = new PessoaDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");

        Pessoa pessoa = new Pessoa(nome, email, telefone);
        pessoaDAO.salvar(pessoa);

        response.sendRedirect("index.jsp");
    }
}
