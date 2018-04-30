<%@ tag language="java" pageEncoding="UTF-8"%>
<%@tag import="java.text.DateFormat"%>
<%@tag import="java.util.Date"%>

<%
Date date = new Date();
DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
String formattedDate = df.format(date);

%>
<p style="background-color: red"><%=formattedDate %></p>