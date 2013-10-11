<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

 <jsp:include page="cabecalho.jsp" />

	<div class="row marketing">
		<div class="col-6">
			<h2>Últimos artigos</h2>
			
			<c:forEach items="${lista}" var="post">
			<c:if test="${(post.status eq 1) or (not empty sessionScope.user)}">
			<h4>
				<a href="home?acao=exibir&id=${post.id}">${post.titulo}</a>
			</h4>
			<h5><fmt:formatDate value="${post.data}" pattern="E, d MMM yyyy HH:mm"/> - ${post.autor}</h5>
			<p>
				${post.resumo} 
				<a href="home?acao=exibir&id=${post.id}">Leia mais</a>
				<c:if test="${not empty sessionScope.user}">
					 - <a href="post?acao=editar&id=${post.id}"><span class="glyphicon glyphicon-pencil"></span></a>  
					<a href="javascript:void(0);" class="deletar" data-postid="${post.id}"><span class="glyphicon glyphicon-trash"></span></a>
					<a href="#"><span class="glyphicon glyphicon-check"></span></a>
				</c:if>
			</p>
			</c:if>
			</c:forEach>
			
		</div>
	</div>

<jsp:include page="rodape.jsp" />