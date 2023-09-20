<%@page import = "java.util.ArrayList"%>
<%@page import = "com.Searchcode.HistoryResult"%>


<html>
    <head>
    <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>

        <h2>A Simple Search Engine</h2>
        <!--on submit it will go on "search" servlet-->
        <form action="Search">
            <input name="keyword" type="text">
            <button type="submit">Search</button>
        </form>

        <form action="History">
            <button type="submit">History</button>
        </form>

        <table border = 2 class="resultTable">
            <tr>
                <th>Keyword</th>
                <th>Link</th>
            </tr>
            <%
                ArrayList<HistoryResult> results = (ArrayList<HistoryResult>)request.getAttribute("results");
                for(HistoryResult result : results){
            %>
            <tr>
                <td><% out.println(result.getKeyword()); %></td>
                <td><a href="<% out.println(result.getLink()); %>"><% out.println(result.getLink()); %></a></td>
            </tr>
            <% } %>
        </table>
    </body>
</html>