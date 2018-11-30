<!DOCTYPE html>
<html lang="en" href="style.css" href="//fonts.googleapis.com/css?family=Play">
<head>
    <link href="style.css" rel="stylesheet" type="text/css" media="all">
    <link href="accountPageStyle.css" rel="stylesheet" type="text/css" media="all">
    <meta charset="UTF-8">
    <title>Cinema</title>
</head>
<script>
function validate()
{
    var firstName = document.form.firstName.value;
    var lastName = document.form.lastName.value;
    var email = document.form.email.value;
    var password = document.form.password.value;
    var birthdate = document.form.email.value;
    var phonenumber = document.form.phonenumber;
    var street = document.form.street;
    var city = document.form.city;
    var state = document.form.state;
    var zipcode = document.form.zipcode;
    var promoOpt = document.form.promoOpt;
    var address = street + " " + city + " " + state + " " + zipcode;

}
</script>

<body>
<!-Link map for header-->
<map name="header-links">
    <area target="" alt="browse" title="browse" href="Browse.jsp" coords="227,204,347,237" shape="rect">
    <area target="" alt="account" title="account" href="Authentication"  coords="353,203,473,237" shape="rect">
    <area target="" alt="home" title="home" href="index.jsp" coords="154,79,532,168" shape="rect">
</map>

<div id="wrapper">
    <div class="header">
        <div id="header-img"><img usemap="#header-links" src="Images/retroheader3.png"/></div>
    </div>

    <div class="content content-text">
        <div class="contentBox">
            <p>Already have an account? <a href="signin.jsp">Sign in!</a></p>
            <div id="signupwrapper">
                <form action="RegisterServlet" method="post">
                    <p>First Name
                        <input type="text" name="firstName" required/>
                    </p>
                    <p>Last Name
                        <input type="text" name="lastName" required/>
                    </p>
                    <p>Email Address
                        <input type="text" name="email" required/>
                    </p>
                    <p>Password
                        <input type="password" name="password" required/>
                    </p>

                    <p>Date of Birth
                        <input type="date" name="birthdate" required/>
                    </p>
                    <p>Phone Number
                        <input type="text" name="phonenumber" required/>
                    </p>
                    <p>Address:
                        <script></script>
                        <p>Street
                            <input type="text" name="street" required/>
                        </p>
                        <p>City
                            <input type="text" name="city" required/>
                        </p>
                        <p>State
                            <input type="text" name="state" required/>
                        </p>
                        <p>Zip code
                            <input type="text" name="zipcode" required/>
                        </p>
                    </p>
                    <p>
                    <p>Card Type
                        <select name="type">
                            <option value="MasterCard">MasterCard</option>
                            <option value="Visa">Visa</option>
                            <option value="AmericanExpress">American Express</option>
                        </select>
                    </p>
                    <p>Name on Card.
                        <input type="text" name="ownername" required/>
                    </p>
                    <p>Card Number
                        <input type="text" name="cardnumber" required/>
                    </p>
                    <p>Expiration Date
                        <input type="text" name="expiration" required/>
                    </p>

                    <p>Security Code
                        <input type="date" name="csc" required/>
                    </p>
                    </p>
                    <p>
                        Would you like to receive promotions for discounted movie tickets?
                        <input type="checkbox" name="promoSub" value="1">
                    </p>
                    <p style="font-size: 10pt; color: indianred">All fields require input</p>
                    <p>
                        <input type="submit" value="register">
                    </p>
                </form>
            </div>
        </div>
    </div>

    <div id="footer">

    </div>
</div>
</body>
</html>