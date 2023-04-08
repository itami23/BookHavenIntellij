package com.emsi.bookhaven.Contollers.BookControllers;

import com.emsi.bookhaven.DAO.BookDAO;
import com.emsi.bookhaven.Models.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateBookServlet", value = "/updatebook")
public class UpdateBookServlet extends HttpServlet {
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

        /////GET THE BOOK DETAILS FROM THE DATABASE
        Book book = bookDAO.findBook(Long.parseLong(request.getParameter("book_id")));
        /////

        ///HANDLING THE VIEW
        request.setAttribute("book",book);
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Views/Book/update-book.jsp");
        view.forward(request,response);
        //////

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

        /////GET THE BOOK DETAILS FROM THE DATABASE
        Book book = bookDAO.findBook(Long.parseLong(request.getParameter("book_id")));
        /////

        ///UPDATING THE BOOK
        book.setAuthor(request.getParameter("author"));
        book.setGenre(request.getParameter("genre"));
        book.setLength(Integer.parseInt(request.getParameter("length")));
        book.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        book.setSummary(request.getParameter("summary"));
        book.setTitle(request.getParameter("title"));
        book.setPrice(Integer.parseInt(request.getParameter("price")));
        ///


        ///SAVING THE BOOK INFO
        bookDAO.updateBook(book);
        ///

        ///REDIRECTING TO BOOKLIST
        response.sendRedirect("booklist");
        ////
    }
}
