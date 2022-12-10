import java.io.*;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class Main extends HttpServlet  
{
	
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        res.setContentType("text/html");        
        String name=req.getParameter("Username");   
        String password=req.getParameter("Password");
        String email=req.getParameter("email");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Details</title>");
        pw.println("<style>");   
        pw.println(".main {");
        pw.println("height: fit-content;");
        pw.println("width: 90%;");
        pw.println("border: 5px solid black;");
        pw.println("margin: 0 auto;");
        pw.println("background-color: rgb(232, 229, 229);");
        pw.println("}");
        pw.println("</style>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<form action=\"/pla/resume\" method=\"POST\">");
        pw.println("<center>");
        pw.println("<div class=\"main\">");
        pw.println("<h3>Name: <input name=\"name\" type=\"text\" id=\"name\"/></h3></br></br>");
        pw.println("<h3>Role:  <input name=\"role\" type=\"text\" id=\"role\"/></h3></br></br>");
        pw.println("<h3>Contact No:  <input name=\"contact\" type=\"text\" id=\"pno\"/></h3></br></br>");
        pw.println("<h3>Email:   <input name=\"email\" type=\"text\" id=\"mail\"/></h3></br></br>");
        pw.println("<h3>State:   <input name=\"state\" type=\"text\" id=\"state\"/></h3></br></br>");
        pw.println("<h3>Github: <input name=\"github\" class=\"leftarrange\"/></h3></br></br>");
        pw.println("<h3>Linkedin:  <input name=\"linkedin\" class=\"rightarrange\"/></h3></br></br>");
        pw.println("<h3>About Me:   <textarea"); 
        pw.println("id=\"about1\" name=\"about\"");
        pw.println("placeholder=\"enter here....\"");
        pw.println("></textarea></br></br>");
        pw.println("<h3>Education: </br></br>");
        pw.println("Secondary Education:   <input name=\"sec_edu\" type=\"text\" id=\"scl\"/>   &nbsp;&nbsp;&nbsp;");
        pw.println("Year and Qualification:   <textarea"); 
        pw.println("id=\"scl1\" name=\"year_qualify1\"");
        pw.println("placeholder=\"enter here....\"");
        pw.println("></textarea></br></br>");
        pw.println("Intermediate/Diploma:   <input name=\"intermediate\" type=\"text\" id=\"int\"/>   &nbsp;&nbsp;&nbsp;");
        pw.println("Year and Qualification:   <textarea");
        pw.println("id=\"int1\" name=\"year_qualify2\"");
        pw.println("placeholder=\"enter here....\"");
        pw.println("></textarea></br></br>");
        pw.println("Graduation:   <input name=\"graduation\" type=\"text\" id=\"btech\"/>   &nbsp;&nbsp;&nbsp;");
        pw.println("Year and Qualification:   <textarea ");
        pw.println("id=\"btech1\" name=\"year_qualify3\"");
        pw.println("placeholder=\"enter here....\"");
        pw.println("></textarea></br></br>");
        pw.println("<h3>Skills:");
        pw.println("<input type=\"text\"");
        pw.println("id=\"ski\" name=\"skills\"");
        pw.println("placeholder=\"enter here....\"");
        pw.println("></input></br></br>");
        pw.println("Projects:</br></br>");
        pw.println("Title: <input name=\"title1\" type=\"text\" id=\"p1\"/> &nbsp;&nbsp;&nbsp;");
        pw.println("Description: <textarea");
        pw.println("id=\"p11\" name=\"des1\"");
        pw.println("placeholder=\"enter here....\"");
        pw.println("></textarea></br></br>");
        pw.println("Title: <input name=\"title2\" type=\"text\" id=\"p2\"/> &nbsp;&nbsp;&nbsp;");
        pw.println("Description: <textarea ");
        pw.println("id=\"p22\" name=\"des2\"");
        pw.println("placeholder=\"enter here....\"");
        pw.println("></textarea></br></br>");
        pw.println("Title: <input name=\"title3\" type=\"text\" id=\"p3\"/> &nbsp;&nbsp;&nbsp;");
        pw.println("Description: <textarea");
        pw.println("id=\"p33\" name=\"des3\"");
        pw.println("placeholder=\"enter here....\"");
        pw.println("></textarea></br></br>");
        pw.println("<h3>Achievements:");
        pw.println("<textarea name=\"achievements\"");
        pw.println("class=\"achievements\"");
        pw.println("placeholder=\"enter here....\"");
        pw.println("></textarea></br></br></h3>");
        pw.println("<input type=\"submit\" value=\"submit\" name=\"submit\"/>");
        pw.println("</center></div></form></body> </html>");
       
        
    }
	
}