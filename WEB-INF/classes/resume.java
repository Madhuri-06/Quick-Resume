import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class resume extends HttpServlet  
{
	
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        res.setContentType("text/html");  
        String name=req.getParameter("name");
        String role=req.getParameter("role");
        String contact=req.getParameter("contact");   
        String email=req.getParameter("email");   
        String state=req.getParameter("state");
        String github=req.getParameter("github");
        String linkedin=req.getParameter("linkedin");
        String about=req.getParameter("about");
        String sec_edu=req.getParameter("sec_edu");
        String year_qualify1=req.getParameter("year_qualify1");
        String intermediate=req.getParameter("intermediate");
        String year_qualify2=req.getParameter("year_qualify2");
        String graduation=req.getParameter("graduation");
        String year_qualify3=req.getParameter("year_qualify3");
        String skills=req.getParameter("skills");
        String title1=req.getParameter("title1");
        String des1=req.getParameter("des1");
        String title2=req.getParameter("title2");
        String des2=req.getParameter("des2");
        String title3=req.getParameter("title3");
        String des3=req.getParameter("des3");
        String achievements=req.getParameter("achievements");
        
        
        
        int valid=0;
        try
        {
             valid=0;
             Driver d=new oracle.jdbc.driver.OracleDriver();
			 DriverManager.registerDriver(d);
             Connection c=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","madhuri");
             Statement st = c.createStatement();
             

           
              PreparedStatement ps = c.prepareStatement("insert into resume1 values(?,?,?,?,?)");
                ps.setString(1, email);
                ps.setString(2, name);
                ps.setString(3, role);
                ps.setString(4, contact);
                ps.setString(5, state);
                int i = ps.executeUpdate();
                
                   
               
                ps = c.prepareStatement("insert into resume2 values(?,?,?,?,?)");
                ps.setString(1, email);
                ps.setString(2, github);
                ps.setString(3, linkedin);
                ps.setString(4, about);
                ps.setString(5, sec_edu);
                i = ps.executeUpdate();
                
                   
             
                ps = c.prepareStatement("insert into resume3 values(?,?,?,?,?)");
                ps.setString(1, email);
                ps.setString(2, year_qualify1);
                ps.setString(3, intermediate);
                ps.setString(4, year_qualify2);
                ps.setString(5, graduation);
                 i = ps.executeUpdate();
               
                   
                
                ps = c.prepareStatement("insert into resume4 values(?,?,?,?,?)");
                ps.setString(1, email);
                ps.setString(2, year_qualify3);
                ps.setString(3, skills);
                ps.setString(4, title1);
                ps.setString(5, des1);
                i = ps.executeUpdate();
               
                
                ps = c.prepareStatement("insert into resume5 values(?,?,?,?,?,?)");
                ps.setString(1, email);
                ps.setString(2, title2);
                ps.setString(3, des2);
                ps.setString(4, title3);
                ps.setString(5, des3);
                ps.setString(6, achievements);   
                i = ps.executeUpdate();
               
                RequestDispatcher rd = req.getRequestDispatcher("/final");
                rd.forward(req,res);
            
            }
        catch (Exception e){
            e.printStackTrace();
        }
        
    }   
	
}