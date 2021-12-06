package by.hospital.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.hospital.command.CommandFactory;
import by.hospital.command.ICommand;
import by.hospital.db.ConnectionPool;

public class Controller extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		ICommand command = CommandFactory.getCommand(action);
		String page = command.execute(request, response);
		getServletContext().getRequestDispatcher(page).forward(request, response);

	}

	@Override
	public void destroy() {
		try {
			ConnectionPool.getInstance().destroy();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		super.destroy();
	}
}