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

    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/estilo.css" rel="stylesheet">
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
    
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
	<c:if test="${pageContext.request.servletPath eq '/login.jsp'}"><c:set var="log" value="active" /></c:if>

    <div class="container">
      <div class="header">
        <ul class="nav nav-pills pull-right">
          <li class="${ind}"><a href="home">Home</a></li>
          <c:if test="${not empty sessionScope.user}">
          <li class="${cad}"><a href="post">Novo artigo</a></li>
          </c:if>
          <li class="${sob}"><a href="sobre.jsp">Sobre</a></li>
          <li class="${con}"><a href="contato.jsp">Contato</a></li>
          <c:if test="${empty sessionScope.user}">
          	<li class="${log}"><a href="login.jsp">Entrar</a></li>
          </c:if>
          <c:if test="${not empty sessionScope.user}">
          	<li><a href="login?sair=1">Sair</a></li>
          </c:if>
          
        </ul>
        <h3 class="text-muted">Blog Pronatec</h3>
      </div>
      
      <c:if test="${not empty mensagem}">
      <div class="alert alert-success"><b>\o/</b> ${mensagem}</div>
      </c:if>
	
      