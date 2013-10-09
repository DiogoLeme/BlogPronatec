<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 <jsp:include page="cabecalho.jsp" />
 
      <form class="form-signin" action="login" method="post">
        <h2 class="form-signin-heading">Seja bem vindo</h2>
        <input type="text" name="login" class="form-control top" placeholder="Email" autofocus>
        <input type="password" name="senha" class="form-control bottom" placeholder="Senha">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
        <p style="margin-top: 10px;">É novo por aqui? <a href="usuario.jsp">Cadastre-se!</a></p>
      </form>

 <jsp:include page="rodape.jsp" />
