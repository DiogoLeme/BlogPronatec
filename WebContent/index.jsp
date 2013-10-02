<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <jsp:include page="cabecalho.jsp" />

	<div class="row marketing">
		<div class="col-6">
			<h2>Últimos artigos</h2>
			
			<c:forEach items="${lista}" var="post">
			<h4>
				<a href="post?acao=exibir&id=${post.id}">${post.titulo}</a>
			</h4>
			<h5>${post.data} - ${post.autor}</h5>
			<p>
				${post.resumo} <a href="post?acao=exibir&id=${post.id}">Leia mais</a>
			</p>
			</c:forEach>
			
		</div>
	</div>

<jsp:include page="rodape.jsp" />