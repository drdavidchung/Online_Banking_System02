<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Banking Backend Management</title>
	<link rel="stylesheet" type="text/css" href="css/admin_login.css"/>
    
</head>
<body>
<div class="admin_login_wrap">
    <h1>Backend Management</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="AdminLogin" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="user">Username :</label>
                        <input type="text" name="userName" value="" id="user" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <label for="pwd">Password :</label>
                        <input type="password" name="passWord" value="" id="pwd" size="40" class="admin_input_style" />
                    </li>
                    <li>
                        <input type="submit" tabindex="3" value="submit" class="btn btn-primary" />
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <p class="admin_copyright"><a tabindex="5" href="#" target="_blank">Back to Home</a> &copy; 2014 Powered by David：<a href="http://www.lmonkey.com/" target="_blank">JSP</a></p>
</div>
</body>
</html>