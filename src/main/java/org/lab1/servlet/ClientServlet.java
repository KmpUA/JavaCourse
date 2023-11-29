package org.lab1.servlet;

import org.lab1.entity.Client;
import org.lab1.service.ClientService;
import org.lab1.service.impl.ClientServiceImplementation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.UUID;

@WebServlet(name = "myapp", urlPatterns = "/index")
public class ClientServlet extends HttpServlet {
	private ClientService clientService;

	public void init() {
		try {
			clientService = new ClientServiceImplementation();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("clients", clientService.findAll());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action != null) {
			switch (action) {
				case "add": {
					String firstName = request.getParameter("firstName");
					String lastName = request.getParameter("lastName");
					String birthdateStr = request.getParameter("birthdate");

					try {
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDateTime birthdate = LocalDate.parse(birthdateStr, formatter).atStartOfDay();

						Client.Builder builder = new Client.Builder(firstName, lastName, birthdate)
								.setAddress(request.getParameter("address"))
								.setPhoneNumber(request.getParameter("phoneNumber"))
								.setEmail(request.getParameter("email"));

						clientService.addClient(builder.build());
					} catch (DateTimeParseException | IllegalArgumentException e) {
						response.sendRedirect(request.getContextPath() + "/error.jsp");
						return;
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
					break;
				}
				case "update":
					String clientIdToUpdate = request.getParameter("clientId");
					String firstName = request.getParameter("firstName");
					String lastName = request.getParameter("lastName");
					LocalDateTime birthdate = LocalDateTime.parse(request.getParameter("birthdate"));

					try {
						Client.Builder builder = new Client.Builder(firstName, lastName, birthdate)
								.setAddress(request.getParameter("address"))
								.setPhoneNumber(request.getParameter("phoneNumber"))
								.setEmail(request.getParameter("email"));

						Client updatedClient = builder.build();
						updatedClient.setId(UUID.fromString(clientIdToUpdate)); // Set the ID for the existing client

						clientService.updateClient(updatedClient, UUID.fromString(clientIdToUpdate));
					} catch (IllegalArgumentException e) {
						response.sendRedirect(request.getContextPath() + "/error.jsp");
						return;
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
					break;
				case "delete":
					String clientId = request.getParameter("clientId");
					try {
						clientService.deleteClient(UUID.fromString(clientId));
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
					break;
			}
		}

		response.sendRedirect(request.getContextPath() + "/index");
	}
}
