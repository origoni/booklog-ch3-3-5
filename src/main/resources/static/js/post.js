
		
		$("#delete").click(function() { <!-- ② -->
			if (!confirm($.i18n.prop("post.delete.btn.msg"))) {
				return false;
			}
		});