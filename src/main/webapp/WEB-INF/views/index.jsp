<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ToDo List Application</title>
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
</head>
<body>
    <h1>Welcome to the ToDo List Application</h1>
    <p>This is a simple ToDo list application using Spring Boot and JSP.</p>

    <form action="${pageContext.request.contextPath}/addTodo" method="post">
        <label for="task">New Task:</label>
        <input type="text" id="task" name="task" required>
        <button type="submit">Add Task</button>
    </form>

    <h2>ToDo List:</h2>
    <ul>
        <c:forEach var="todo" items="${todos}">
            <li>${todo.task}</li>
        </c:forEach>
    </ul>
</body>
</html>
