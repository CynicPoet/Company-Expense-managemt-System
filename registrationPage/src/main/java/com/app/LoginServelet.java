package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServelet")
public class LoginServelet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServelet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String position = request.getParameter("position");
        String password = request.getParameter("password");

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/authorizeinfo", "root", "root");

            String query = "SELECT * FROM loginauth WHERE username = ? AND position = ? AND password = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, position);
            pstmt.setString(3, password);

            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                // Credentials matched, you can redirect to a dashboard page or show a success message
            	Thread.sleep(2000);
                out.println("Welcome " + username);
                response.sendRedirect("eDashboard.jsp");
            } else {
                // Credentials did not match
                out.println("Invalid credentials");
                response.sendRedirect("pageNotFound.html");
            }

        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions
            e.printStackTrace();
        } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            // Close resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
