<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>${Title}</title>
  </head>
  <body>
  <p>${test}</p>
  <p>${project.name}</p>
  <p>WELCOME</p>
      <c:forEach var="project" items="${ProjectList}">
          <c:out value="${project.name}" />
          <p>Hi</p>
      </c:forEach>
  </body>

</html>
