<!DOCTYPE html>
<html lang="en" href="style.css" href="//fonts.googleapis.com/css?family=Play">
<head>
    <link href="style.css" rel="stylesheet" type="text/css" media="all">
    <link href="selectSeatsStyle.css" rel="stylesheet" type="text/css" media="all">
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

    <script>


    </script>
<form onsubmit="processTicketServlet" method="post">
    <div class="content">
        <div class="theatre">
            <h1>Please select a seat for ${title}</h1>
              <form>
                  <input id="" type="radio" value="">
                  <label for=""></label>
              </form>
        </div>
        <p>
            <button type="submit" value="selectSeats">Pay Now</button>
        </p>
    </div>
</form>
    <div id="footer">

    </div>
</div>
</body>
</html>