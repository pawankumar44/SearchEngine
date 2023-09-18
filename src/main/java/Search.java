import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Search")//route
public class Search extends HttpServlet {
    //whenever the Search servlet triggered this doGet will be called
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        String keyword = request.getParameter("keyword");
        System.out.println(keyword);
    }
}
