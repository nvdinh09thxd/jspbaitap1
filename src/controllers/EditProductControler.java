package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.BookDAO;
import models.Book;

@WebServlet("/EditProduct")
public class EditProductControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditProductControler() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		BookDAO bookDAO = new BookDAO();
		Book objBook = bookDAO.getBook(bookId);
		request.setAttribute("objBook", objBook);
		request.getRequestDispatcher("/edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String detail = request.getParameter("detail");
		int enabled = Integer.parseInt(request.getParameter("enabled"));

		Book objBook = new Book(bookId, title, description, detail, enabled);
		BookDAO bookDAO = new BookDAO();

		if (bookDAO.editBook(objBook) > 0) {
			response.sendRedirect(request.getContextPath() + "/IndexController");
			return;
		}
	}

}
