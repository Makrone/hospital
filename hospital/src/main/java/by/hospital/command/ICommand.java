package by.hospital.command;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {

	String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException;

	default void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
			throws ServletException, IOException {
		String page = handleRequest(request, response);
		postRequestHandling(request, response, page, servletContext);
	}

	default void postRequestHandling(HttpServletRequest request, HttpServletResponse response, String page,
			ServletContext servletContext) throws ServletException, IOException {

		servletContext.getRequestDispatcher(page).forward(request, response);

	}

}
