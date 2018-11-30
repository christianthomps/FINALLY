<!DOCTYPE html>
<html lang="en" href="style.css" href="//fonts.googleapis.com/css?family=Play">
<head>
    <link href="style.css" rel="stylesheet" type="text/css" media="all">
    <meta charset="UTF-8">
    <title>Cinema</title>
</head>

<body>
<!-Link map for header-->
<map name="header-links">
    <area target="" alt="browse" title="browse" href="Browse.jsp" coords="227,204,347,237" shape="rect">
    <area target="" alt="account" title="account" href="signin.jsp" coords="353,203,473,237" shape="rect">
    <area target="" alt="home" title="home" href="index.jsp" coords="154,79,532,168" shape="rect">
</map>
<div id="wrapper">
    <div class="header">
        <div id="header-img"><img usemap="#header-links" src="Images/retroheader3.png"/></div>
    </div>

    <div class="content">
        <div class="content-text">
            <div class="contentBox">
                <h2>Lost Password</h2>
                <form id="forgotPassword" action="forgotPassServlet" method="post">
                    <br>
                    <input type="text" placeholder="Enter email address" name="email">
                <p><button type="submit">Recover Password</button></p>

                </form>
            </div>
        </div>


    </div>
</div>

</body>
</html>