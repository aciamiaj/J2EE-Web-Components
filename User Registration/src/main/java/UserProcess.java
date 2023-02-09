import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserProcess
 */
@
WebServlet("/registration")
public class UserProcess extends HttpServlet {

    public void init() throws ServletException {
        System.out.println("Init method has been called...");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // TODO Auto-generated method stub

        res.setContentType("text/html");

        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String email = req.getParameter("email");
        String zip = req.getParameter("zip");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirm = req.getParameter("confirm");
        String music[] = req.getParameterValues("music");
        String notification = req.getParameter("notification");

        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<link rel='stylesheet' href='style.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='row'>");
        out.println("<div class='col-md-12'>");
        out.println("<form action='registration' method='post'>");

        if (!(first_name.isEmpty() || last_name.isEmpty() || email.isEmpty() || zip.isEmpty() || username.isEmpty() || password.isEmpty() || confirm.isEmpty()))
            out.println("<h1>" + "Thank you for joining our mailing list" + "</h1>");
        else
            out.println("<h1>" + "*Please check required fields." + "</h1>");

        out.print("<fieldset>");
        out.println("<legend>" + "Here is the information that you entered:" + "</legend>");

        if (first_name.isEmpty())
            out.print("<label for=\"name\">" + "First Name* " + "</label>" +
                "<input type=\"text\"  name=\"first_name\" value=\"First Name is required\">");
        else
            out.print("<label>" + "First Name*  " + "</label>" + "<input type='text' name='first_name' value='" + first_name + "'>");

        if (last_name.isEmpty())
            out.print("<label for=\"name\">" + "Last Name* " + "</label>" +
                "<input type=\"text\"  name=\"last_name\" value=\"Last Name is required\">");
        else
            out.print("<label>" + "Last Name*  " + "</label>" + "<input type='text' name='last_name' value='" + last_name + "'>");

        if (email.isEmpty())
            out.print("<label for=\"email\">" + "Email* " + "</label>" +
                "<input type=\"text\"  name=\"email\" value=\"Email is required\">");
        else
            out.print("<label>" + "Email*  " + "</label>" + "<input type='text' name='email' value='" + email + "'>");

        if (zip.isEmpty())
            out.print("<label for=\"zip\">" + "Zip Code* " + "</label>" +
                "<input type=\"text\"  name=\"zip\" value=\"Zip Code is required\">");
        else
            out.print("<label>" + "Zip Code*  " + "</label>" + "<input type='text' name='zip' value='" + zip + "'>");

        if (username.isEmpty())
            out.print("<label for=\"username\">" + "User Name* " + "</label>" +
                "<input type=\"text\"  name=\"username\" value=\"User Name is required\">");
        else
            out.print("<label>" + "User Name*  " + "</label>" + "<input type='text' name='username' value='" + username + "'>");

        if (password.isEmpty())
            out.print("<label for=\"password\">" + "Password* " + "</label>" +
                "<input type=\"text\"  name=\"password\" value=\"Password is required\">");
        else
            out.print("<label>" + "Password*  " + "</label>" + "<input type='password' name='password' value='" + password + "'>");

        if (confirm.isEmpty())
            out.print("<label for=\"confirm\">" + "Confirm Password* " + "</label>" +
                "<input type=\"text\"  name=\"confirm\" value=\"Password does not match\">");
        else
            out.print("<label>" + "Confirm Password*  " + "</label>" + "<input type='password' name='confirm' value='" + confirm + "'>");

        String musicString = "";
        for (int i = 0; i < music.length; i++) {
            musicString += music[i] + ", ";
        }

        if (musicString.isEmpty())
            out.print("<label for=\"music\">" + "Music" + "</label>" +
                "<input type=\"text\"  name=\"music\" value=\" \">");
        else
            out.print("<label>" + "Music: " + "</label>" + "<input type='text' name='music' value='" + musicString + "'>");

        if (notification.isEmpty())
            out.print("<label for=\"notification\">" + "Receive special sale notification: " + "</label>" +
                "<input type=\"text\"  name=\"notification\" value=\" \">");
        else
            out.print("<label>" + "Receive special sale notification: " + "</label>" + "<input type='text' name='notification' value='" + notification + "'>");

        out.print("</fieldset>");
        out.print("<button type=\"submit\" name=\"submit\">Sign Up</button>" + "<button type=\"reset\" name=\"reset\">Reset</button>");
        out.println("</form>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

    }

    public void destroy() {
        System.out.println("Destroy method has been called...");
    }

}