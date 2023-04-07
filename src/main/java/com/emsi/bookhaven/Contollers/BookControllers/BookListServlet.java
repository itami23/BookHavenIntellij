package com.emsi.bookhaven.Contollers.BookControllers;

import com.emsi.bookhaven.DAO.BookDAO;
import com.emsi.bookhaven.Models.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookListServlet", value = "/booklist")
public class BookListServlet extends HttpServlet {
    private BookDAO bookDAO;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //RETRIEVE THE PERSISTENCE PARAMETERS
        EntityManagerFactory emf =(EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        /////

        ///CREATE AN INSTANCE OF THE BOOKDAO OBJECT
        bookDAO = new BookDAO(em,emf);
        /////////

        ///RETRIEVE DATA FROM THE DATABASE
        List<Book> bookList = bookDAO.getAllBooks();
        ///////

        request.setAttribute("bookList",bookList);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Views/Book/list-book.jsp");
        view.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
