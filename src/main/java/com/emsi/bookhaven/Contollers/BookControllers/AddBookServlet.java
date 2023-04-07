package com.emsi.bookhaven.Contollers.BookControllers;

import com.emsi.bookhaven.DAO.BookDAO;
import com.emsi.bookhaven.Models.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddBookServlet", value = "/addbook")
public class AddBookServlet extends HttpServlet {

    private BookDAO bookDAO;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Views/Book/add-book.jsp");
        view.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //RETRIEVE THE PERSISTENCE PARAMETERS
        EntityManagerFactory emf =(EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        /////

        ///CREATE AN INSTANCE OF THE BOOKDAO OBJECT
        bookDAO = new BookDAO(em,emf);
        /////////

        ///RETRIEVE THE DATA FROM THE JSP FORM
        String title=request.getParameter("title");
        String author = request.getParameter("author");
        int length = Integer.parseInt(request.getParameter("length"));
        String genre = request.getParameter("genre");
        String summary = request.getParameter("summary");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int price = Integer.parseInt(request.getParameter("price"));
        //////

        ///SAVING THE BOOK O THE DATABASE
        try{
            Book book = new Book(title,author,length,genre,summary,price,quantity);
            bookDAO.createBook(book);
            response.sendRedirect("/booklist");
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
        }
        /////

    }
}
