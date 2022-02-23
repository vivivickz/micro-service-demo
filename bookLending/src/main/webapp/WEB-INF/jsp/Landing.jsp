<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>
        Landing page
    </title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/common.css">
</head>

<body>
    <h1 class="display-4">Message : ${message}</h1>
    <br />
    <h1 class="display-3">Available books </h1>
    <table class="table">
        <thead class="thead-dark">
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Name</th>
              <th scope="col">Author</th>
              <th scope="col">Date of Insertion</th>
              <th scope="col">Status</th>
            </tr>
        </thead>
        <c:forEach items="${books}" var="book">
            <tr>
                <th scope="row"><c:out value="${book.id}"/></th>
                <td><c:out value="${book.bookName}"/></td>
                <td><c:out value="${book.authorName}"/></td>
                <td><c:out value="${book.doa}"/></td>
                <td><c:out value="${book.status}"/></td>
                </book>
            </tr>
        </c:forEach>
    </table>
</body>

</html>