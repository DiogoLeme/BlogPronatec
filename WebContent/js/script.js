$(document).ready(function(){
	$("#publicar").click(function(){
		$("#acao").val("publicar");
		$("#formPost").submit();
	});
	$("#salvar").click(function(){
		$("#acao").val("salvar");
		$("#formPost").submit();
	});
	
	$(".deletar").click(function(){
		var postid = $(this).data("postid");
		var location = "post?acao=deletar&id=" + postid;
		if(confirm("Tem certeza que deseja deletar o artigo?")){
			window.location = location;
		}
	});
	
});