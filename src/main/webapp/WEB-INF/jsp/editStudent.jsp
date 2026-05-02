<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Student</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

<div class="container" style="max-width: 600px;">
    <h2>Edit Student Details</h2>

    <c:if test="${not empty error}">
        <div style="background: #fee2e2; color: #ef4444; padding: 1rem; border-radius: 8px; margin-bottom: 1.5rem; border: 1px solid #f87171;">
            ${error}
        </div>
    </c:if>

    <form action="/updateStudent" method="post">
        <input type="hidden" name="id" value="${student.id}"/>

        <div class="form-group">
            <label for="name">Full Name</label>
            <input type="text" id="name" name="name" value="${student.name}" class="form-control" required/>
        </div>
        
        <div class="form-group">
            <label for="email">Email Address</label>
            <input type="email" id="email" name="email" value="${student.email}" class="form-control" required/>
        </div>

        <div class="form-group">
            <label for="course">Assigned Course</label>
            <select id="course" name="course.id" class="form-control" required>
                <c:forEach var="c" items="${courses}">
                    <option value="${c.id}" ${c.id == student.course.id ? 'selected' : ''}>${c.courseName}</option>
                </c:forEach>
            </select>
        </div>

        <div style="margin-top: 2rem; display: flex; gap: 1rem;">
            <button type="submit" class="btn" style="flex: 1;">Update Student</button>
            <a href="/students" class="btn" style="background: #e2e8f0; color: #475569; box-shadow: none; text-align: center; flex: 1;">Cancel</a>
        </div>
    </form>
</div>

</body>
</html>
