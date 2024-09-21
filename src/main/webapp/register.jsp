<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<form action="register" method="post">
 <c:if test="${alert != null}">
    <h3 class="alert alert-danger">${alert}</h3>
 </c:if>
 <div class="container">
    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <label for="confirmPassword"><b>Confirm Password</b></label>
    <input type="password" placeholder="Confirm Password" name="confirmPassword" required>

    <button type="submit">Register</button>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn" onclick="window.location.href='login'">Cancel</button>
    <span class="psw">Already have an account? <a href="login">Login here</a></span>
  </div>
</form>
</body>
</html>