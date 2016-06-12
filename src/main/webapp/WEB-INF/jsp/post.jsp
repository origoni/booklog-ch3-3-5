<%@ page pageEncoding="UTF-8"%> <!-- ① -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- ① -->
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<title>${post.bookTitle}</title>
</head>
<body>
	<section class="container">
		<article>
			<h2>${post.bookTitle}</h2>
			<hr />
			<div>${post.content}</div>
			<div><fmt:formatDate value="${post.createdAt}" type="both"/></div>
		</article>	
		<a href="/post/list">
			<button type="button" class="btn btn-info"><fmt:message key="common.List"/></button>
		</a>
		<a href="/post/${post.id}/edit">
			<button type="button" class="btn btn-warning"><fmt:message key="common.Edit"/></button>
		</a>
		<a href="/post/${post.id}/delete" id="delete">
			<button type="button" class="btn btn-danger"><fmt:message key="common.Delete"/></button>
		</a>
	</section>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
	<script type="text/javascript" src="/js/post.js"></script>
</body>
</html>
