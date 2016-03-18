<!DOCTYPE html>
<%
   String contextPath = getServletContext().getContextPath();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Host Page Template</title>

<link href="<%=contextPath%>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=contextPath%>/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link href="<%=contextPath%>/bootstrap/css/main.css" rel="stylesheet">

<script type="text/javascript" src="<%=contextPath%>/DigitAlgo/DigitAlgo.nocache.js"></script>

</head>
<body>
  <div id="rootPanel"></div>
  <iframe src="javascript:''" id="__gwt_historyFrame" style="width: 0; height: 0; border: 0"></iframe>
  
  <script type="text/javascript" src="<%=contextPath%>/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</body>
</html>
