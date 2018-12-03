<!DOCTYPE html>
<html lang="en" href="style.css" href="//fonts.googleapis.com/css?family=Play">
<head>
    <link href="style.css" rel="stylesheet" type="text/css" media="all">
    <link href="accountPageStyle.css" rel="stylesheet" type="text/css" media="all">
    <meta charset="UTF-8">
    <title>Cinema</title>
</head>

<body>
<!-Link map for header-->
<map name="header-links">
    <area target="" alt="browse" title="browse" href="Browse.jsp" coords="227,204,347,237" shape="rect">
    <area target="" alt="account" title="account" href="Authentication" coords="353,203,473,237" shape="rect">
    <area target="" alt="home" title="home" href="index.jsp" coords="154,79,532,168" shape="rect">
</map>

<div id="wrapper">
    <div class="header">
        <div id="header-img"><img usemap="#header-links" src="Images/retroheader3.png"/></div>
    </div>
    <div class="content content-text">
        <div class="contentBox">
            <form method="post" action="updateAccountServlet">
            <table>
                <tr>
                    <td>First Name <input type="text"/></td>
                </tr>
                <tr>
                    <td>Last Name <input type="text"/></td>
                </tr>
                <tr>
                    <td>Email Address <input type="text"/></td>
                </tr>
                <tr>
                    <td>Date of Birth <input type="date"/></td>
                </tr>
                <tr>
                    <td>Phone Number <input type="text"/></td>
                </tr>
                <tr>
                    <td>Address</td>
                </tr>

                <tr>
                    <td>Street <input type="text"/></td>
                </tr>
                <tr>
                    <td>City <input type="text"/></td>
                </tr>
                <tr>
                    <td>State <input type="text"/></td>
                </tr>
                <tr>
                    <td>Zip code <input type="text"/></td>
                </tr>
            </table>
            <button type="submit">Update</button>
            <button>Cancel</button>
            </form>
        </div>
    </div>
    <div id="footer">

    </div>
</div>
</body>
</html>