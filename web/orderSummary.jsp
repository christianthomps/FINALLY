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
        <h1>Order Summary:</h1>
        <table>
            <tr>
                <td>Movie Title</td>
                <td>Movie Time</td>
            </tr>
            <tr>
                <td>Number of tickets</td>
                <td>
                    <p>1</p>
                </td>
            </tr>
            <tr>
                <td>Senior</td>
                <td>1</td>
            </tr>
            <tr>
                <td>Adult</td>
                <td>1</td>
            </tr>
            <tr>
                <td>Under 18</td>
                <td>1</td>
            </tr>
            <tr>
                <td>Total:</td>
                <td>$$$</td>
            </tr>
        </table>
        <p><a href="moviePage.jsp">Update Order</a></p>



        <p>
            <input type="submit"/>
            <button>Cancel</button>
        </p>

    </div>

    <div id="footer">

    </div>
</div>
</body>
</html>