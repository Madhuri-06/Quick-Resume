import java.io.*;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class Sign extends HttpServlet  
{
	
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        res.setContentType("text/html");        
        String email=req.getParameter("email");
        String password=req.getParameter("Password");
        try
        {
             Driver d=new oracle.jdbc.driver.OracleDriver();
			 DriverManager.registerDriver(d);
             Connection c=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","madhuri");
            
			 Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("select * from validation");
            while(rs.next())
            {
                if((rs.getString("email").equals(email))&&(rs.getString("password").equals(password)))
                {
                   RequestDispatcher rd = req.getRequestDispatcher("/final");
                   rd.forward(req,res);
   
                }
            }
			
            
               pw.println("<script>alert('Invalid username or password!')</script>");
               res.setHeader("refresh", "1;url=http://localhost:8081/pla/index.html");
               
         
             pw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
	
}