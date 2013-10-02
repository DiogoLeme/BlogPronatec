<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<jsp:include page="cabecalho.jsp" />







      <div class="row content">
        <div class="col-6">
          <h2>${post.titulo}</h2>
    	  <h5>${post.data} - ${post.autor}</h5>
          ${post.texto}
        </div>
      </div>

<jsp:include page="rodape.jsp" />
