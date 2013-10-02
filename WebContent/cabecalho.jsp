<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Bruno Eustáquio">
    <title>Blog Pronatec</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/estilo.css" rel="stylesheet">
    
    <script type="text/javascript" src="js/jquery-2.0.3.js" /></script>
    <script type="text/javascript" src="js/script.js" /></script>
    <script type="text/javascript" src="ckeditor/ckeditor.js" /></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
  </head>
  
   <body> 
	<c:if test="${pageContext.request.servletPath eq '/index.jsp'}"><c:set var="ind" value="active" /></c:if>
	<c:if test="${pageContext.request.servletPath eq '/cadastrar.jsp'}"><c:set var="cad" value="active" /></c:if>
	<c:if test="${pageContext.request.servletPath eq '/sobre.jsp'}"><c:set var="sob" value="active" /></c:if>
	<c:if test="${pageContext.request.servletPath eq '/contato.jsp'}"><c:set var="con" value="active" /></c:if>

    <div class="container">
      <div class="header">
        <ul class="nav nav-pills pull-right">
          <li class="${ind}"><a href="home">Home</a></li>
          <li class="${cad}"><a href="cadastrar.jsp">Novo artigo</a></li>
          <li class="${sob}"><a href="sobre.jsp">Sobre</a></li>
          <li class="${con}"><a href="contato.jsp">Contato</a></li>
        </ul>
        <h3 class="text-muted">Blog Pronatec</h3>
      </div>
      
      <c:if test="${not empty mensagem}">
      <div class="alert alert-success"><b>\o/</b> ${mensagem}</div>
      </c:if>
	
      