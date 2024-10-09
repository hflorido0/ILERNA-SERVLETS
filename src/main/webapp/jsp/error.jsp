<%@page import="java.util.ArrayList"%>
<html>
<%@include file="/jsp/nav.jsp"%>
    <body>
        <%= new java.util.Date() %>
        <%
            String error = (String) request.getAttribute("error");
            ArrayList<String> array = new ArrayList<>();
            array.add("hola");
            array.add("hello");
            array.add("bye");
        %>

        <p><%=error%></p>

        <%for (String s : array) { %>
            <h2><%=s%></h2>
        <% } %>

        <%@include file="/jsp/nav.jsp"%>
    </body>
</html>