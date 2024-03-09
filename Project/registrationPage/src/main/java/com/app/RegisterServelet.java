package com.app;
import java.util.Random;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID; // Import UUID class
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServelet")
public class RegisterServelet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServelet() {
        super();
    }

    @SuppressWarnings("resource")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String emailid = request.getParameter("emailid");
        String password = request.getParameter("password");
        String position = request.getParameter("position");

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/authorizeinfo", "root", "root");

            String query = "INSERT INTO signupauth VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, emailid);
            pstmt.setString(3, password);
            pstmt.setString(4, position);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                out.println("User registered successfully.");
                String uid = generateRandomUID();

                // Insert into loginauth table
                String loginDbQuery = "INSERT INTO loginauth (uid, username, password, position) VALUES (?, ?, ?, ?)";
                pstmt = conn.prepareStatement(loginDbQuery);
                pstmt.setString(1, uid);
                pstmt.setString(2, username);
                pstmt.setString(3, password);
                pstmt.setString(4, position);

                int loginRowsInserted = pstmt.executeUpdate();
                
                try {
                	Thread.sleep(5000);
                	if (loginRowsInserted > 0) {
                   	 response.sendRedirect("http://localhost:7750/registrationPage/redirectLogin.html");
//                       out.println("User registered successfully in login database.");
                   } else {
                       out.println("Failed to register user in login database.");
                   }
                }catch(Exception e) {
                	response.sendRedirect("/pageNotFound.html");
                }
                
            } else {
                out.println("Failed to register user.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect("/pageNotFound.html");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendRedirect("/pageNotFound.html");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    // Method to generate a random UID
    private String generateRandomUID() {
        String characters = "0123456789";

        Random random = new Random();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());

            stringBuilder.append(characters.charAt(index));
        }

        return stringBuilder.toString();
    }
}
