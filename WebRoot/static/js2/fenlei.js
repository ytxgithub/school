/* 所属平台 */
	$(document).ready(function(){
		$.ajax({
			url:"/appinfosystem/data/list",
			dataType:"json",
			success:function(data){
				$.each(data,function(i){
					$("#flatformid").append("<option value="+data[i].valueid+">"+data[i].valuename+"</option>")
				});
			}
		});
		/* 一级分类 */
		$.ajax({
			url:"/appinfosystem/category/l1",
			dataType:"json",
			success:function(data){
				$("#categoryLevel1").append("<option value='0'>一级分类</option>");
				$("#categoryLevel2").append("<option value='0'>二级分类</option>");
				$("#categoryLevel3").append("<option value='0'>三级分类</option>");
				$.each(data,function(i){
					$("#categoryLevel1").append("<option value="+data[i].id+">"+data[i].categoryname+"</option>")
				});
			}
		});
		/* 二级分类   选择一级分类的时候 二级三级分类清空*/
		$("#categoryLevel1").change(function() {
			if ($(this).val() != 0) {
				$.ajax({
					url : "/appinfosystem/category/l2",
					type : "post",
					dataType : "json",
					data : {
						parentId : $(this).val()
					},
					success : function(data) {
						$("#categoryLevel2").html("");
						$("#categoryLevel2").append("<option value='0'>二级分类</option>");
						$("#categoryLevel3").html("");
						$("#categoryLevel3").append("<option value='0'>三级分类</option>");
						$.each(data, function(i) {
							$("#categoryLevel2").append("<option value=" + data[i].id + ">" + data[i].categoryname + "</option>");
						});
					}
				});
			} else {
				$("#categoryLevel2").html("");
				$("#categoryLevel2").append("<option value='0'>二级分类</option>");
				$("#categoryLevel3").html("");
				$("#categoryLevel3").append("<option value='0'>三级分类</option>");
			}

		});

		/* 三级分类  选择二级分类 三级分类清空*/
		$("#categoryLevel2").change(function() {
			if ($(this).val() != 0) {
				$.ajax({
					url : "/appinfosystem/category/l3",
					type : "post",
					dataType : "json",
					data : {
						parentId : $(this).val()
					},
					success : function(data) {
						$("#categoryLevel3").html("");
						$("#categoryLevel3").append("<option value='0'>三级分类</option>");
						$.each(data, function(i) {
							$("#categoryLevel3").append("<option value=" + data[i].id + ">" + data[i].categoryname + "</option>");
						});
					}
				});
			} else {
				$("#categoryLevel3").html("");
				$("#categoryLevel3").append("<option value='0'>三级分类</option>");
			}
		});
		
	});