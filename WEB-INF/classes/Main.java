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
        pw.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">");
        pw.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\" crossorigin=\"anonymous\"></script>");
        pw.println("<title>Details</title>");
        pw.println("<style>");   
        pw.println(".main {");
        pw.println("height: fit-content;");
        pw.println("width: 90%;");
        pw.println("border: 5px solid black;");
        pw.println("margin: 0 auto;");
        pw.println("background-color: rgb(232, 229, 229);");
        pw.println("}");
        pw.println(".karthik {width:30%; padding-top:3%; display:flex;}");
        pw.println(".fill {margin-top:3%; }");
        pw.println(".submit {margin-bottom:3%; background-color:white; text-style:bold;}");
        pw.println(".row {display: flex; flex-direction: column; }");
        pw.println("</style>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<form action=\"/Quick Resume/resume\" method=\"POST\">");
        pw.println("<center>");
        pw.println("<div class=\"main\">");
        pw.println("<h1 class=\"fill\">RESUME DETAILS</h1>");
        pw.println("<div class=\"mb-3 karthik\"><h3>Name  </h3> <input name=\"name\" type=\"text\" id=\"name\" class=\"form-control\"/></div>");
        pw.println("<div class=\"mb-3 karthik\"><h3>Role  </h3>  <input name=\"role\" type=\"text\" id=\"role\" class=\"form-control\"/></div>");
        pw.println("<div class=\"mb-3 karthik\"><h3>Contact  </h3> <input name=\"contact\" type=\"text\" id=\"pno\" class=\"form-control\"/></div>");
        pw.println("<div class=\"mb-3 karthik\"><h3>Email  </h3>   <input name=\"email\" type=\"text\" id=\"mail\" class=\"form-control\"/></div>");
        pw.println("<div class=\"mb-3 karthik\"><h3>State  </h3>  <input name=\"state\" type=\"text\" id=\"state\" class=\"form-control\"/></div>");
        pw.println("<div class=\"mb-3 karthik\"><h3>Github  </h3> <input name=\"github\" class=\"leftarrange form-control\"/></div>");
        pw.println("<div class=\"mb-3 karthik\"><h3>Linkedin  </h3> <input name=\"linkedin\" class=\"rightarrange form-control\"/></div>");
        pw.println("<div class=\"form-floating karthik\"><h3>About Me </h3>   <textarea"); 
        pw.println("id=\"about1\" name=\"about\"");
        pw.println("placeholder=\"enter here....\" class=\"form-control\" ");
        pw.println("></textarea></div>");
        pw.println("<h3>Education </h3>");
        pw.println("<div class\"row\" style=\"display: flex; flex-direction: row; justify-content:center;\"><div class=\"mb-3 karthik\"><h3>Secondary Education </h3>  <input name=\"sec_edu\" type=\"text\" id=\"scl\" class=\"form-control\"/></div>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        pw.println("<div class=\"form-floating karthik\"><h3>Year and Qualification  </h3>  <textarea"); 
        pw.println("id=\"scl1\" name=\"year_qualify1\"");
        pw.println("placeholder=\"enter here....\" class=\"form-control\"");
        pw.println("></textarea></div></div> ");
        pw.println("<div class\"row\" style=\"display: flex; flex-direction: row; justify-content:center;\"><div class=\"mb-3 karthik\"><h3>Intermediate/Diploma </h3> <input name=\"intermediate\" type=\"text\" id=\"int\" class=\"form-control\"/></div>   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        pw.println("<div class=\"form-floating karthik\"><h3>Year and Qualification </h3>  <textarea");
        pw.println("id=\"int1\" name=\"year_qualify2\"");
        pw.println("placeholder=\"enter here....\"");
        pw.println("class=\"form-control\"></textarea></div></div>");
        pw.println("<div class\"row\" style=\"display: flex; flex-direction: row; justify-content:center;\"><div class=\"mb-3 karthik\"><h3>Graduation </h3>  <input name=\"graduation\" type=\"text\" id=\"btech\" class=\"form-control\"/></div>   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        pw.println("<div class=\"form-floating karthik\"><h3>Year and Qualification </h3>   <textarea ");
        pw.println("id=\"btech1\" name=\"year_qualify3\"");
        pw.println("placeholder=\"enter here....\"");
        pw.println("class=\"form-control\"/></textarea></div></div>");
        pw.println("<div class=\"mb-3 karthik\"><h3>Skills</h3>");
        pw.println("<input type=\"text\"");
        pw.println("id=\"ski\" name=\"skills\"");
        pw.println("placeholder=\"enter here....\"");
        pw.println("class=\"form-control\"></input></div>");
        pw.println("<h3>Projects</h3>");
        pw.println("<div class\"row\" style=\"display: flex; flex-direction: row; justify-content:center;\"><div class=\"mb-3 karthik\"><h3>Title </h3> <input name=\"title1\" type=\"text\" id=\"p1\" class=\"form-control\"/></div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        pw.println("<div class=\"form-floating karthik\"><h3>Description </h3><textarea");
        pw.println("id=\"p11\" name=\"des1\"");
        pw.println("placeholder=\"enter here....\"");
        pw.println("class=\"form-control\"></textarea></div></div>");
        pw.println("<div class\"row\" style=\"display: flex; flex-direction: row; justify-content:center;\"><div class=\"mb-3 karthik\"><h3>Title </h3> <input name=\"title2\" type=\"text\" id=\"p2\" class=\"form-control\"/></div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        pw.println("<div class=\"form-floating karthik\"><h3>Description </h3> <textarea ");
        pw.println("id=\"p22\" name=\"des2\"");
        pw.println("placeholder=\"enter here....\"");
        pw.println("class=\"form-control\"></textarea></div></div>");
        pw.println("<div class\"row\" style=\"display: flex; flex-direction: row; justify-content:center;\"><div class=\"mb-3 karthik\"><h3>Title </h3> <input name=\"title3\" type=\"text\" id=\"p3\" class=\"form-control\"/></div> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        pw.println("<div class=\"form-floating karthik\"><h3>Description </h3> <textarea");
        pw.println("id=\"p33\" name=\"des3\"");
        pw.println("placeholder=\"enter here....\"");
        pw.println("class=\"form-control\"></textarea></div></div></br></br>");
        pw.println("<div class=\"form-floating karthik\"><h3>Achievements</h3>");
        pw.println("<textarea name=\"achievements\"");
        pw.println("class=\"achievements\"");
        pw.println("placeholder=\"enter here....\"");
        pw.println("class=\"form-control\"></textarea></div></br></br></h3>");
        pw.println("<input class=\"submit btn btn-outline\" type=\"submit\" value=\"submit\" name=\"submit\"/>");
        pw.println("</center></div></form></body> </html>");
        
        
    }
	
}