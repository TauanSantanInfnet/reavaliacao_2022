package com.example.TP1.App;

import com.example.TP1.Domain.Endereco;
import com.example.TP1.Infra.EnderecoService;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name= "EnderecoController", value = "/EnderecoController")
public class EnderecoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cep = request.getParameter("cep");
        if(StringUtils.isNotBlank(cep)){
            EnderecoService es = new EnderecoService();
            Endereco endereco = es.obterPorCep(cep);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(new Gson().toJson(endereco));
            out.flush();
        }
        else
        {
            request .setAttribute("erro", "CEP inválido");
        }
    }
}
