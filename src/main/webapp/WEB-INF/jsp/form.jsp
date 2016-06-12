<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<title>Post Form</title>
</head>
<body>
	<section class="container">
		<h2><fmt:message key="common.Write"/></h2>
		<hr />
		<form method="post"
			action="${requestScope['javax.servlet.forward.servlet_path']}">
			<fieldset class="form-group">
				<label for="formBookTitle"><fmt:message key="common.BookTitle"/></label>
				<input id="formBookTitle" type="text" class="form-control"
					name="bookTitle" value="${post.bookTitle}"
					placeholder="Title input" /> 
			</fieldset>
			<fieldset class="form-group">
				<label for="formContent"><fmt:message key="common.Content"/></label>
				<textarea id="formContent" class="form-control" name="content"
					rows="3">${post.content}</textarea>
			</fieldset>
			<input type="submit" class="btn btn-primary" value="<fmt:message key="common.Save"/>" />
		</form>
	</section>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
	<script type="text/javascript"> <!-- ②  -->
		$('form').submit(function(event) { <!-- ③ -->
			$('form input:text, textarea').each(function() { <!-- ④ -->
				if (!($.trim($(this).val())).length) { <!-- ⑤ -->
					alert('<fmt:message key="form.write.check.btn.msg"/>');
					event.preventDefault();
					return false;
				}
			});
		});
	</script>
</body>
</html>
