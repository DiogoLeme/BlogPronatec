<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

 <jsp:include page="cabecalho.jsp" />

<div class="row marketing">
	<div class="col-6">
		<h2>Cadastrar novo artigo</h2>
		<form role="form" action="post" method="post">
			<input type="hidden" name="acao" value="salvar">
			<div class="form-group">
				<label for="nome">Título</label>
				<input type="nome" class="form-control" id="titulo" name="titulo" placeholder="Título" required="required">
			</div>
			<div class="form-group">
				<label for="post">Post</label>
				<textarea class="form-control" id="texto" name="texto" rows="18" placeholder="Boa sorte com o texto ;)" required="required"></textarea>
			</div>
			<div class="form-group">
				<label for="email">Resumo</label>
				<textarea class="form-control" id="resumo" name="resumo" rows="2" placeholder="Escreva um breve resumo" required="required"></textarea>
			</div>
			<div class="form-group">
				<label for="assunto">Autor</label>
				<input type="text" class="form-control" id="autor" name="autor" placeholder="Quem é o autor do texto?" required="required">
			</div>
			<button type="submit" class="btn btn-primary btn-lg">Publicar</button>
			<button type="submit" class="btn btn-success btn-lg">Salvar como rascunho</button>
		</form>
	</div>
</div>

<jsp:include page="rodape.jsp" />