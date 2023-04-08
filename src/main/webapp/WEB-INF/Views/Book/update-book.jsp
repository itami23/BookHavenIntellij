<%--
  Created by IntelliJ IDEA.
  User: Yassine
  Date: 4/8/2023
  Time: 8:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Update A Book</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Update A Book</h2>
    <form method="post" action="${pageContext.request.contextPath}/updatebook">
        <input type="hidden" name="book_id" value="${book.id}" />
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" class="form-control" id="title" name="title" required value="${book.title}">
        </div>
        <div class="form-group">
            <label for="summary">summary:</label>
            <textarea class="form-control" id="summary" name="summary" rows="3" required >${book.summary}</textarea>
        </div>
        <div class="form-group">
            <label for="author">author:</label>
            <input class="form-control" id="author" name="author" rows="3" required type="text" value="${book.author}">
        </div>
        <div class="form-group">
            <label for="genre">genre:</label>
            <input class="form-control" id="genre" name="genre" rows="3" required type="text" value="${book.genre}">
        </div>
        <div class="form-group">
            <label for="length">length:</label>
            <input type="number" class="form-control" id="length" name="length" step="0.01" min="0" required value="${book.length}">
        </div>
        <div class="form-group">
            <label for="price">price:</label>
            <input type="number" class="form-control" id="price" name="price" step="0.01" min="0" required value="${book.price}">
        </div>
        <div class="form-group">
            <label for="quantity">quantity:</label>
            <input type="number" class="form-control" id="quantity" name="quantity" step="0.01" min="0" required value="${book.quantity}">
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>

</body>
</html>