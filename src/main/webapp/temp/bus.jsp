
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商机列表</title>
    <link rel="stylesheet" href="../fontawesome/css/font-awesome.css">
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script src="../js/jquery-3.4.1.min.js"></script>
    <style>
        *{
            margin:0;
            padding:0;
            text-decoration: none;
            list-style: none;
            box-sizing: border-box;
        }
        .container{
            width:75%;
            height:100vh;
            margin-left: 100px;
        }
        .nav ul{
            width:100%;
            height:75px;
            margin: 0;
            padding:0;

        }
        .nav ul li {
            line-height: 75px;
            display: inline-block;
        }
        .nav ul .item{
            line-height: 75px;
            margin: 20px;
            float: right;
        }
        .nav ul li:nth-of-type(1) a{
          display: inline-block;
            font-size: 22px;
            color: #ccc;

        }
        .nav ul .item a{
            line-height: 35px;
            color: #fff;
            text-align: center;
            display: block;
            width:90px;
            border-radius: 5px;

        }
        .nav ul li:nth-of-type(2) a{
            background: #0be881;
        }

        .nav ul li:nth-of-type(3) a{
            background: #2F4056;
        }
        .data-input-index {
            border-top: 1px solid #ccc;
            width:100%;
            display: inline-flex;
            border-bottom: 1px solid #ccc;

        }
        .layui-inline input[type="text"]{
            width:170px;
            height:40px;
            margin: 10px 10px;
            padding-left: 5px;

        }
        .layui-inline input[type='date']{
            width:170px;
            height:40px;
            margin: 10px 10px;
            padding-left: 5px;
        }
        .layui-inline .layui-form-item{
            float:right;
        }
        .content{
            width:100%;
            height:auto;
        }
        #select{
            display: inline-block;
            width:170px;
            height: 40px;
        }
        .layui-form-select{
            display: none !important;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="nav">
            <ul>
                <li ><a href="#">商机列表</a></li>
                <li class="item btn-flush"><a href="#" onclick="flush()"><i class="layui-icon layui-icon-refresh"></i>刷新</a></li>
                <li class="item btn-back"><a href="#"><i class="fa fa-chevron-left" aria-hidden="true"></i>返回</a></li>
            </ul>
        </div>
        <div class="line"></div>
        <div class="data-input-index">
            <form id="form"  class="layui-form" action="" method="">
                <div class="layui-inline">
                    <label>商机全称</label>
                    <input type="text" autofocus required placeholder="请输入" name="businessName">
                </div>
                <div class="layui-inline">

                    <label>商机阶段</label>
                    <input type="text"  required placeholder="请输入" name="name">

                </div>
                <div class="layui-inline">
                    <label>商机商机负责人</label>
                    <input type="text"  required placeholder="请输入" name="empname">
                </div>
                <div class="layui-inline">
                        <label>部门</label>
                    <select id="select" name="dept"></select>
                </div>
                <div class="layui-inline">
                    <label>预计成交额</label>
                    <input type="text"  required placeholder="请输入" name="estimatedAmount">
                </div>
                <div class="layui-inline">
                    <label>预计结单日期</label>
                    <input type="date"  required placeholder="请输入" name="estimateDdate">
                </div>
                <div class="layui-inline">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">查找商机</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
                </div>
            </form>
        </div>

        <div class="content">
            <table id="demo" lay-filter="test"></table>
        </div>

    </div>
    <script src="../layui/layui.js"></script>
<script>
    var search = window.location.search;
    search=(search.substr(search.length-1,1));
    //刷新页面
    function flush(){
        window.location.reload();
    }
    //第一个实例
    layui.use(['form','layer','jquery','table'],function(){
        var form=layui.form,layer=layui.layer,$=layui.jquery,table=layui.table;


        //加载所有部门
        $(function(){
            $.getJSON("../json/dept.json",function(json){
                var res = json;
                for(let i=0;i<res.data.length;i++){
                    var option=new Option();
                    if(i===0){
                        option.value =res.data[i].value;
                        option.text =res.data[i].clazz;
                    }else{
                        option.value = res.data[i].clazz;
                        option.text = res.data[i].clazz;
                    }
                    $("#select").append(option);
                }
                form.render();

            })

        });
        table.render({
            elem: '#demo'
            ,height:"auto"
            ,width:1000
            ,url: '/crm/crm/business/findById.do?id='+search //数据接口
            ,page:true
            ,limit:5
            ,cols: [[ //表头
                //复选框，fixed为固定位置，即该复选框永远在表格最左侧，同理下面的行内工具栏永远在最右侧
                {type: 'checkbox',fixed: 'left'}
                ,{field: 'businessName',title: '客户全称', width:200}
                ,{field: 'name',title: '商机阶段', width:120}
                ,{field: 'estimatedAmount', title: '预计成交金额', width:200, sort: true}
                ,{field: 'empname', title: '负责人', width:120}
                ,{field: 'documentarydate', title: '最后跟单', width: 135}
                ,{field: 'num', title: '讨论版', width:120, sort: true}

            ]]
        });

    //提交所有的数据查询
        form.on('submit(formDemo)', function (data) {
            //表单数据重载
            table.reload('demo', {
                url: "/crm/crm/business/findAll.do",
                where: {
                    businessName: data.field.businessName,
                    name: data.field.name,
                    empname:data.field.empname,
                    deptId:data.field.deptId,
                    estimatedAmount:data.field.estimatedAmount,
                    documentarydata:data.field.documentarydate
                }

            })
            return false;
        });

        //返回主页面
        $(document).on("click",".btn-back",function(){
            window.top.location.href="/crm/temp/ctm.jsp";
        });

        form.render();

    })


</script>

</body>
</html>
