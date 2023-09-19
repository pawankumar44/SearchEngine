package com.Searchcode;

import com.Searchcode.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Search")//route
public class Search extends HttpServlet {
    //whenever the com.Searchcode.Search servlet triggered this doGet will be called
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        String keyword = request.getParameter("keyword");
//        System.out.println(keyword);
        Connection connection = DatabaseConnection.getConnection();
        try {
            ResultSet resultSet = connection.createStatement().executeQuery("select pagetitle,pagelink, (length(lower(pagetext))-length(replace(lower(pagetext),'" + keyword.toLowerCase() + "','')))/length('" + keyword.toLowerCase() + "') as countoccur from pages order by countoccur desc limit 30;");
            //save from resultEst
            ArrayList<SearchResult> results = new ArrayList<SearchResult>();
            while (resultSet.next()) {
                SearchResult searchResult = new SearchResult();
                searchResult.setTitle(resultSet.getString("pageTitle"));
                searchResult.setLink(resultSet.getString("pageLink"));
                results.add(searchResult);
            }
            for(SearchResult result : results){
                System.out.println(result.getTitle()+"\n"+result.getLink());
            }
//        generate html response
            //send response to frontend
            request.setAttribute("results",results);//this request will be forwarded to the frontend
            request.getRequestDispatcher("search.jsp").forward(request,response);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
//        out.println("<h3>This is the keyword you have entered "+keyword+"</h3>");
        }
        catch (SQLException | ServletException sqlException){
            sqlException.printStackTrace();
        }
    }
}
