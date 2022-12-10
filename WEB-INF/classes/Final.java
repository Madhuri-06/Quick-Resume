import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
public class Final extends HttpServlet  
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
        PrintWriter pw=res.getWriter();
        res.setContentType("text/html"); 
        try
        {
             Driver d=new oracle.jdbc.driver.OracleDriver();
			 DriverManager.registerDriver(d);
             Connection c=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","madhuri");
            
			 Statement st = c.createStatement();
             
             String email=req.getParameter("email");
             pw.println("<html>");
        pw.println("<head>");
        
        pw.println("<title>Resume</title>");

        pw.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">");
        pw.println("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">");
        pw.println("<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">");
        pw.println("<style>");
        pw.println("#heads{ background-color: rgb(232, 229, 229);");
        pw.println("height:50px;");
        pw.println("align-items: center;");
        pw.println("display: flex;");
        pw.println("flex-direction: row;");
        pw.println("}");
        pw.println("#second {");
        pw.println("height: fit-content;");
        pw.println("width: 50%;");
        pw.println("display: flex;");
        pw.println("flex-direction: column;");
        pw.println("background-color:  rgb(232, 229, 229);");
        pw.println("padding-bottom: 0.7%;");
        pw.println("font-size: large;");
        pw.println("right: 5.5%;");
        pw.println("position: absolute;");
        pw.println("padding-left:2%;}");
        pw.println(".columnarrange{");
        pw.println("display: flex;");
        pw.println("flex-direction: row;");
        pw.println("margin-top: 2%; }");
        pw.println("#resume{");
        pw.println("height: fit-content;");
        pw.println("width: 90%;");
        pw.println("border: 2px solid black;");
        pw.println("margin: 0 auto;}");
        pw.println(".firstcolumn{");
        pw.println("width: 40%;");
        pw.println("padding-left: 2%;}");
        pw.println(".rightarrange{");
        pw.println("padding-left: 60%;}");
        pw.println(".leftarrange{");
        pw.println("padding-left: 5%;}");
        pw.println(".header{");
        pw.println("display: flex;");
        pw.println("flex-direction: row;");
        pw.println("margin-left: 2%;");
        pw.println("height: 150px;");
        pw.println("color: rgb(68, 68, 174);}");
        pw.println(".corner{");
        pw.println("position: absolute;");
        pw.println("right: 8%; }");
        pw.println(".achievements{");
        pw.println("display: flex;");
        pw.println("flex-direction: column;}");
        pw.println("#about{");
        pw.println("color: rgb(68, 68, 174);}");
        pw.println("#edu{");
        pw.println("color: rgb(68, 68, 174); }");
        pw.println("#skill{");
        pw.println("color: rgb(68, 68, 174); }");
        pw.println("#pro{");
        pw.println("color: rgb(68, 68, 174);}");
        pw.println("#achi{");
        pw.println("color: rgb(68, 68, 174);}");
        pw.println("</style><script>console.log(\"madhu\"); </script></head><body>");
        pw.println("");  
        pw.println("<form onsubmit=\"preventDefault()\" id=\"madhu\" method=\"post\" action=\"resume\">");
        pw.println("<div id=\"resume\">");
        pw.println("<div class=\"header\">");
        pw.println("<div>");
            
            
        ResultSet rs = st.executeQuery("select * from resume1");
            while(rs.next())
            {
                if((rs.getString("email").equals(email)))
                {
                    pw.println("<h2 id=\"name\">"+rs.getString("name")+"</h2>");
                    pw.println("<h3 id=\"role\">"+rs.getString("role")+"</h3>");
                    pw.println("</div>");
                    pw.println("<div class=\"corner\">");
                    pw.println("<p id=\"pno\">"+rs.getInt("contact")+" <i style=\"font-size:24px\" class=\"fa\">&#xf095;</i></p>");
                    pw.println("<p id=\"mail\">"+rs.getString("email")+" <i style=\"font-size:24px\" class=\"fa\">&#xf0e0;</i> </p>");
                    pw.println("<p id=\"state\">"+rs.getString("state")+" <i class=\"material-icons\">&#xe55f;</i></p>");
   
                }
            }
             rs = st.executeQuery("select * from resume2");	   
            while(rs.next())
            {
                if((rs.getString("email").equals(email)))
                {
                    pw.println("</div></div><div id=\"heads\">");
                    pw.println("<p class=\"leftarrange\"> Github:  "+rs.getString("github")+"");
                    pw.println("<p class=\"rightarrange\">Linkedin:  "+rs.getString("linkedin")+"</p></div>");
                    pw.println("<div class=\"columnarrange\">");
                    pw.println("<div class=\"firstcolumn\">");
                    pw.println("<h2 id=\"about\">About Me</h2>");
                    pw.println("<p id=\"about1\"> "+rs.getString("about")+"");
                    //pw.println("To work in a globally competitive environment");
                    //pw.println("on challenging assignments that shall contribute");
                    //pw.println("to the organizations growth and enhance my skills."); 
                    //pw.println("Adapting new learnings everyday and work hard to");
                    //pw.println("complete things I am focusing on.</p></br>");
                    pw.println("<h2 id=\"edu\">Education</h2>");
                    pw.println("<h4 id=\"scl\">"+rs.getString("sec_edu")+"</h4>");
   
                }
            } 
        
             rs = st.executeQuery("select * from resume3");	   
            while(rs.next())
            {
                if((rs.getString("email").equals(email)))
                {
                    pw.println("<p id=\"scl1\"><pre>"+rs.getString("year_qualify1")+"");
                    //pw.println("2005 - Present");
                    //pw.println("Other Qualification-SSC");
                    pw.println("</pre></p>"); 
                    pw.println("<h4 id=\"int\">"+rs.getString("intermediate")+"</h4>");
                    pw.println("<p id=\"int1\">"+rs.getString("year_qualify2")+"");
                    //pw.println("2018 - Present");
                    //pw.println("Other Qualification-MPC");
                    pw.println("</p><h4 id=\"btech\">"+rs.getString("graduation")+"</h4>");
                    
                }
            } 
        
            
             rs = st.executeQuery("select * from resume4");	   
            while(rs.next())
            {
                if((rs.getString("email").equals(email)))
                {
                    pw.println("<p id=\"btech1\">"+rs.getString("year_qualify3")+"");
                    //pw.println("2020 - Present");
                    //pw.println("Other Qualification-Information Technology");
                   
 
                    }
                    pw.println("</p></br><h2 id=\"skill\">Skills"+rs.getString("skills")+"</h2></br> ");
                    //pw.println("<div id=\"ski\"><h4 id=\"1\">Python</h4>");
                    //pw.println("<h4 id=\"2\">Java</h4>");
                    //pw.println("<h4 id=\"3\">Java Applets</h4>");
                    //pw.println("<h4 id=\"4\">Java AWT</h4>");
                    //pw.println("<h4 id=\"5\">HTML5</h4>");
                    //pw.println("<h4 id=\"6\">Data Structures</h4>");
                    //pw.println("<h4 id=\"7\">Java Script</h4>");
                    //pw.println("<h4 id=\"8\">Web Development</h4>");
                    //pw.println("<h4 id=\"9\">Problem Solving</h4>");
                    //pw.println("<h4 id=\"10\">Database Management System</h4></div>");
                    pw.println("</div><div id=\"second\">");
                    pw.println("<h2 id=\"pro\">Projects</h2>");
                    pw.println("<h4 id=\"p1\">"+rs.getString("title1")+"</h4>");
                    pw.println("<p id=\"p11\">"+rs.getString("des1")+"");
                    //pw.println("Dynamic Web page contains the entire details regarding Relief Riders");
                    //pw.println("which include relief riders logo that can spin using Css characteristics");
                    //pw.println("a link to visit that site and also login and sign up buttons are provided.</p>");
                }
            
            rs = st.executeQuery("select * from resume5");	   
            while(rs.next())
            {
                if((rs.getString("email").equals(email)))
                {
                    pw.println("<h4 id=\"p2\">"+rs.getString("title2")+"</h4>");
                    pw.println("<p id=\"p22\">"+rs.getString("des2")+"");
                    //pw.println("Web page which shows the popular shopping site Meesho its features");
                    //pw.println("details regarding buyings in the site and a video containing entire"); 
                    //pw.println("description about site .</p>");
                    pw.println("<h4 id=\"p3\">"+rs.getString("title3")+"</h4>");
                    pw.println("<p id=\"p33\">"+rs.getString("des3")+"");
                    //pw.println("Dynamic Webpage contains an filled cone and whenever the cone is");
                    //pw.println("emptied we can refill the cone which is done using javascript.</p></br>");
                    pw.println("<h2 id=\"achi\">Achievements</h2>");
                    pw.println("<div class=\"achievements\">"+rs.getString("achievements")+"");
                    //pw.println("<span>Achieved certification by FREE CODE CAMP on Html ,"); 
                    //pw.println("Css and ORACLE on Java Fundamentals</span>");
                    //pw.println("<span>Achieved certification by INFOSYS SPRINGBOARD on Python</span>");
                    //pw.println("<span>Achieved certification by CELONIS ACADEMY on Process Mining</span>");
                    //pw.println("<span>Worked as Volunteer for AWS drive conducted in our college</span></p>");
                    pw.println("</div></div></div></div></form></body></html>");    
                }
            }
       
    }
    catch (Exception e){
        e.printStackTrace();
    }
    pw.close();
    }
}