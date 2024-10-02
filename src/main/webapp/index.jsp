<%@ page import="java.util.ArrayList" %>
<html>
<body>
<h2>Hello World!</h2>
<%
    ArrayList<String> platosArray = (ArrayList<String>) request.getAttribute("platos");
%>
<h4>Cantidad: <%=platosArray.size()%></h4>
<b><%=platosArray.get(0)%></b>
</body>
</html>
