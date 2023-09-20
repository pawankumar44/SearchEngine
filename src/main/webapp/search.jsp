<%@page import = "java.util.ArrayList"%>
<%@page import = "com.Searchcode.SearchResult"%>

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

    <table border=2 class="resultTable">
        <tr>
            <th>Title</th>
            <th>Link</th>
        </tr>
<!--        jsp code -->
        <%
            ArrayList<SearchResult> results = (ArrayList<SearchResult>)request.getAttribute("results");
            for(SearchResult result:results){
        %>
        <tr>
            <td><% out.println(result.getTitle()); %></td>
            <td><a href="<% out.println(result.getLink()); %>"><% out.println(result.getLink()); %></a></td>
        </tr>
        <% } %>

    </table>
</body>
</html>