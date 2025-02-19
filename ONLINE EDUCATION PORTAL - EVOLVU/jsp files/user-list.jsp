<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List and Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eaf6ff; /* Very light shade of #79addc */
            padding: 20px;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            width: 50%;
            margin: 20px auto;
        }
        .form-container input, .form-container select {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            border: 1px solid #ddd;
        }
        .form-container button {
            background-color: #79addc;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            font-weight: bold;
        }
        .form-container button:hover {
            background-color: #5d98c7;
        }
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
            background-color: white;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #79addc;
            color: white;
        }
        td {
            background-color: #f9f9f9;
        }
        .alert {
            color: red;
            text-align: center;
        }
        .action-buttons {
            display: flex;
            justify-content: center;
            gap: 10px;
        }
        .action-buttons a {
            text-decoration: none;
        }
        .action-buttons button {
            padding: 8px 12px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
        .update-btn {
            background-color: #34eb9b;
            color: white;
        }
        .update-btn:hover {
            background-color: #2acb86;
        }
        .delete-btn {
            background-color: #f01842;
            color: white;
        }
        .delete-btn:hover {
            background-color: #d01438;
        }
    </style>
</head>
<body>
    <h1>User List</h1>

    <div class="alert">
        ${message != null ? message : ""}
    </div>

    <div class="form-container">
        <form action="/users/submitUser" method="post">
            <h2>Add User</h2>

            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <label for="phoneNumber">Phone Number:</label>
            <input type="tel" id="phoneNumber" name="phoneNumber" pattern="^[0-9]{10}$" title="Please enter a valid phone number" required>

            <label for="education">Education:</label>
            <select id="education" name="education" required>
                <option value="High School">High School</option>
                <option value="Bachelor's Degree">Bachelor's Degree</option>
                <option value="Master's Degree">Master's Degree</option>
                <option value="Doctorate">Doctorate</option>
            </select>

            <button type="submit">Add User</button>
        </form>
    </div>

    <h2>User Details</h2>
    <table>
        <thead>
            <tr>
                <th>User ID</th>
                <th>Name</th>
                <th>Email ID</th>
                <th>Password</th>
                <th>Phone Number</th>
                <th>Education</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.getUserID()}</td>
                    <td>${user.getName()}</td>
                    <td>${user.getEmailId()}</td>
                    <td>${user.getPassword()}</td>
                    <td>${user.getPhoneno()}</td>
                    <td>${user.getEducation()}</td>
                    <td class="action-buttons">
                        <a href="/users/update/${user.userID}">
                            <button type="button" class="update-btn">Update</button>
                        </a>
                        <a href="/users/delete/${user.userID}" onclick="return confirm('Are you sure you want to delete this user?')">
                            <button type="button" class="delete-btn">Delete</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
