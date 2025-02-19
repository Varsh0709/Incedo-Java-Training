<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <style>
        /* General Styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #eef2f3; /* Light pleasant background */
            text-align: center;
            padding: 50px;
        }
        .dashboard-container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.15);
            display: inline-block;
            width: 65%;
        }

        /* Admin Dashboard Title */
        h1 {
            color: #2c3e50;
            font-size: 34px;
            font-weight: bold;
            text-transform: uppercase;
            letter-spacing: 2px;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2);
        }

        /* Dashboard Buttons */
        .dashboard-buttons {
            display: flex;
            justify-content: center;
            gap: 40px;
            margin-top: 20px;
        }
        .dashboard-item {
            text-align: center;
            width: 220px;
        }
        .dashboard-item img {
            width: 160px;
            height: 160px;
            border-radius: 10px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
        }

        /* Updated Button Colors */
        .dashboard-item button {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-weight: bold;
            margin-top: 12px;
            transition: 0.3s;
        }
        .manage-users { background-color: #79addc; color: white; } /* Blue */
        .manage-instructors { background-color: #ffc09f; color: black; } /* Peach */
        .manage-courses { background-color: #ffee93; color: black; } /* Light Yellow */

        /* Hover Effect */
        .dashboard-item button:hover {
            opacity: 0.85;
            transform: scale(1.05);
        }
    </style>
</head>
<body>

    <div class="dashboard-container">
        <h1>Admin Dashboard</h1>

        <div class="dashboard-buttons">
            <div class="dashboard-item">
                <img src="${pageContext.request.contextPath}/resources/images/users.png" alt="Manage Users">
                <a href="${pageContext.request.contextPath}/users/user-list">
                    <button class="manage-users">Manage Users</button>
                </a>
            </div>
            <div class="dashboard-item">
                <img src="${pageContext.request.contextPath}/resources/images/instructors.png" alt="Manage Instructors">
                <a href="${pageContext.request.contextPath}/instructors/instructor-list">
                    <button class="manage-instructors">Manage Instructors</button>
                </a>
            </div>
            <div class="dashboard-item">
                <img src="${pageContext.request.contextPath}/resources/images/courses.png" alt="Manage Courses">
                <a href="course-list.jsp">
                    <button class="manage-courses">Manage Courses</button>
                </a>
            </div>
        </div>
    </div>

</body>
</html>
