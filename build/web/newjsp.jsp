<%-- 
    Document   : newjsp
    Created on : 06-28-2013, 12:19:15 AM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <title>jQuery UI Button - Default functionality</title>
  <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
  <script>
  $(function() {
    $( "input[type=submit], a, button" )
      .button()
      .click(function( event ) {
        $.ajax({
                    url: 'lightaction.jsp',
                    type: 'GET',
                    data:  "id=1"
        });
      });
  });
  </script>
</head>
<body>
 
<button>A button element</button>
 
<input type="submit" value="A submit button" />
 
<a href="#">An anchor</a>
 
 
</body>