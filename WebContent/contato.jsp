<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<jsp:include page="cabecalho.jsp" />

<div class="row marketing">
	<div class="col-6">
		<h2>Fale conosco</h2>
		<p>Mussum ipsum cacilds, vidis litro abertis. Consetis adipiscings elitis. Pra lá , depois divoltis porris, paradis. Paisis, filhis, espiritis santis. Mé faiz elementum girarzis, nisi eros vermeio,</p>
		<form role="form" action="enviar">
			<div class="row">
				<div class="col-lg-6">
					<div class="form-group">
						<label for="nome">Nome</label>
						<input type="nome" class="form-control" id="nome" name="nome" placeholder="Seu nome" required="required">
					</div>
				</div>
				<div class="col-lg-6">
					<div class="form-group">
						<label for="email">Email</label>
						<input type="email" class="form-control" id="email" name="email"  placeholder="abc@exemplo.com" required="required">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="assunto">Assunto</label>
				<input type="text" class="form-control" id="assunto" name="assunto" placeholder="Seja direto" required="required">
			</div>
			<div class="form-group">
				<label for="mensagem">Mensagem</label>
				<textarea class="form-control" id="mensagem" rows="6" name="mensagem" placeholder="Seja claro" required="required"></textarea>
			</div>
			<button type="submit" class="btn btn-default">Enviar</button>
		</form>
	</div>
</div>

<jsp:include page="rodape.jsp" />