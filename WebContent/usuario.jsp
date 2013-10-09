<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 <jsp:include page="cabecalho.jsp" />
 
      <form class="form-signin" action="usuario" method="post">
        <h2 class="form-signin-heading">Seja bem vindo</h2>
        <input type="text" name="nome" class="form-control top" placeholder="Nome" autofocus>
        <input type="text" name="sobrenome" class="form-control center" placeholder="Sobrenome">
        <input type="text" name="login" class="form-control bottom" placeholder="Email">
        <input type="password" name="senha" class="form-control top" style="margin-top: 20px;" placeholder="Senha">
        <input type="password" name="confirmasenha" class="form-control bottom" placeholder="Confirme a senha">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Cadastrar</button>
        <p style="margin-top: 10px;">Já posui cadastro? <a href="login.jsp">Faça login!</a></p>
      </form>

 <jsp:include page="rodape.jsp" />
