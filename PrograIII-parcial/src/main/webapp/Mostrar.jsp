<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" 
src="http://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	$('#cargar').click(function(event){
		
	
	  var btn =$('#cargar').val();
		$.post('ControladorLogin',{

		}, function (respose) {
			var datos = JSON.parse(respose);
			var tablaDatos = document.getElementById('tablaDatos')
			for (var item of datos) {
				tablaDatos.innerHTML += 
`
<tr>
					<td>${item[0]}</td>
					<td>${item[1]}</td>
					<td>${item[2]}</td>
					<td> <a href="ControladorRegistros?btn=ELIMINAR$id=${item[2]}"
					class="btn btn-info">Eliminar</a>	
					 <a href="ControladorRegistros?btn=ELIMINAR$id=${item[2]}"
							class="btn btn-danger">Actualizar</a>	
                    </td>
					
</tr>
`	
}
		});
});
});
</script>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<%
HttpSession s = (HttpSession) request.getSession();
String usuario = (String)s.getAttribute("usuario");
if(usuario==null){
response.sendRedirect("Mostrar.jsp");
}
%>
<body>
<from action="ControladorRegistros">
<input type="hidden" name="id" >
<a href="index.jsp"class="btn btn-info">Iniciar Seccion</a>
<input type="submit" value="mostrar" name="btn" id="cargar">
</from>

<table class="table table-dark" id="tablaDatos">
	<thead ><b><H2 align="CENTER">Usuarios</H2></b></thead>
	<thead>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>ID</th>
	</thead>

	<tbody>
		
	</tbody>
</table>
</body>
</html>