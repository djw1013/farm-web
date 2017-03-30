<script type="text/javascript" src="common/js/jquery.min.js"></script>

<script type="text/javascript">
    function test(){
        //使用ajax请求
        $.ajax({
            type:'post',
            url:'test/test.do',
        	contentType:'application/json;charset=utf-8',
            data:JSON.stringify({"name":"djw","age":28}),
            success:function(data){
            	var ajaxobj=eval("("+data+")");
                alert(ajaxobj.name);
                alert(ajaxobj.age);
            }

        });

    }

</script>
<%@ page contentType="text/html; charset=utf-8" %>
<title>测试</title>
</head>
<body>
<input type="button" value="测试" onclick="test()"><br/>
</body>