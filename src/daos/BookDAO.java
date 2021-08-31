package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Book;
import utils.ConnectionUtil;

public class BookDAO {
	private Connection con;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public ArrayList<Book> getListBooks() {
		ArrayList<Book> listBooks = new ArrayList<>();
		final String sql = "SELECT * FROM book";
		con = ConnectionUtil.getConnection();

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Book objBook = new Book(rs.getInt("bookId"), rs.getString("title"), rs.getString("description"),
						rs.getString("detail"), rs.getBoolean("status"));
				listBooks.add(objBook);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, st, con);
		}

		return listBooks;
	}

	public Book getBook(int bookId) {
		final String sql = "SELECT * FROM book WHERE bookId = ?";
		con = ConnectionUtil.getConnection();
		Book objBook = null;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, bookId);
			rs = pst.executeQuery();
			if (rs.next()) {
				objBook = new Book(rs.getInt("bookId"), rs.getString("title"), rs.getString("description"),
						rs.getString("detail"), rs.getBoolean("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}

		return objBook;
	}

	public int delBook(int bookId) {
		final String sql = "DELETE FROM book WHERE bookId = ?";
		con = ConnectionUtil.getConnection();
		int result = 0;
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, bookId);
			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}

		return result;
	}

	public int editBook(Book objBook) {
		final String sql = "UPDATE book SET title = ?, description = ?, detail = ?, status = ? WHERE bookId = ?";
		con = ConnectionUtil.getConnection();
		int result = 0;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, objBook.getTitle());
			pst.setString(2, objBook.getDescription());
			pst.setString(3, objBook.getDetail());
			pst.setBoolean(4, objBook.isStatus());
			pst.setInt(5, objBook.getBookId());

			result = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, con);
		}

		return result;
	}

}
