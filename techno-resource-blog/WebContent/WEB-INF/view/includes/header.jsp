  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Blog Home - Techno Resources</title>

    <!-- Bootstrap core CSS -->
    
    <link type = "text/css" rel = "stylesheet"
		  href = "${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />

    <!-- Custom styles for this template -->
    <!-- reference our style sheet  -->
	<link type = "text/css" rel = "stylesheet"
		  href = "${pageContext.request.contextPath}/resources/css/blog-home.css" />
		  
	<link type = "text/css" rel = "stylesheet"
		  href = "${pageContext.request.contextPath}/resources/css/drop-down-style.css" />
		  
	<!-- reference of vendor bootstrap style sheet  -->		  
	<link rel="stylesheet" href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
		
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

 </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Techno Resource</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            
            <!-- Code for dynamic dropdown  -->
			<div class="dropdown nav-link">
						Categories				  
  				<div class="dropdown-content">
	  				<c:forEach var ="category" items="${categories}">   
						<a href="/category/${category.categoryName}">${category.categoryName}</a>
	  				</c:forEach>
  				</div>
			</div>
			
            <li class="nav-item">
              <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>