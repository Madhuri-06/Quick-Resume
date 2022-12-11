import java.io.*;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class Signup extends HttpServlet  
{
	
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        res.setContentType("text/html");        
        String email=req.getParameter("email");   
        String fullname=req.getParameter("fullName");
        String password=req.getParameter("Password");
        int valid=0;
        try
        {
             valid=0;
             Driver d=new oracle.jdbc.driver.OracleDriver();
			 DriverManager.registerDriver(d);
             Connection c=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","madhuri");
             
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("select * from validation");
           
             while(rs.next())
             {
                //pw.println("exectued");

                if((rs.getString("email").equals(email)))
                {
                    
                    valid=1;
                }
                pw.println(valid);
            } 
           
            if(valid==0)
            {
              PreparedStatement ps = c.prepareStatement("insert into validation values(?,?,?)");
                ps.setString(1, email);
                ps.setString(2, fullname);
                ps.setString(3, password);
                
                int i = ps.executeUpdate();
                pw.println(i);
                if (i > 0) {
                        st.executeQuery("commit");
                        RequestDispatcher rd = req.getRequestDispatcher("/main");
                        rd.forward(req,res);
                    }
                   
                }     
              else{
                    pw.println("<script>alert('User already exists!')</script>");
                    res.setHeader("refresh", "1;url=http://localhost:8081/Quick Resume/index.html");
   
              }      
                       
                       
                   
                pw.close();
            }
        catch (Exception e){
            e.printStackTrace();
        }

    }
	
}