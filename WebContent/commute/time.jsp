<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.Date,java.text.*"%>
<%
DateFormat df = new SimpleDateFormat("yyyy.MM.dd '����ð�' HH:mm:ss");
%>
<font color="black" size="5"><%=df.format(new Date())%></font>
