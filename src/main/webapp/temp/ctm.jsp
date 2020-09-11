
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的客户管理</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script src="../js/jquery-3.4.1.min.js"></script>
    <style>
        *{
            margin:0;
            padding:0;
            box-sizing: border-box;
            text-decoration: none;
            list-style: none;
            font-family: 'Open Sans', sans-serif;
        }
        .wrapper{
            margin-top: 50px;
            width:100%;
            height:100vh;
            padding-left: 50px;
        }
        .slider-top{
            margin:0;
            padding:0;
            width:100%;
            display: flex;
            justify-content: flex-start;
        }
        .layui-inline p{
            font-size: 22px;
            color:#ccc;
        }
        .layui-input-block input{
            padding:0;
            margin: 0;
            width:200px;
            height:40px;
        }
        .slider-right{
            width:100%;
            height:100%;
            display: flex;
            justify-content: flex-start;
        }
        .slider-right .layui-inline{
           padding:0 !important;

        }
        .slider-right .layui-inline{
            text-align: center;
            margin-top: 25px;
            margin-right: 25px;
        }
        .slider-right .content{
            margin-top: 34px;
            width:262px;
            height:500px;
            border: 1px solid #ccc;
        }
        .content .layui-card-header{
            font-size: 22px;
            font-weight: 500;
            background-color: #4E5465;
            color:#fff;
        }
        .content .layui-card-body{
            width:100%;
            padding:0;
            margin: 0;
        }
        .content .layui-card-body ul li a{
            display: block;
            width:100%;
            line-height: 45px;
            text-align: center;
            border-bottom: 1px solid #ccc ;

        }
        .content .layui-card-body ul li:hover a{
            background-color: #009E94;
            color: #fff;
        }
        .content{
            display: inline-block;
            margin-top: 15px;
        }


    </style>
</head>
<body>
<div class="wrapper">

    <div class="slider-top">
        <div class="layui-inline"><p><i class="layui-icon layui-icon-group"></i>客户管理</p></div>
        <form id="form"  class="layui-form" method="">
        <div class="layui-inline">
            <div class="layui-input-block">
                <select name="clienteleId"  id="select">

                </select>
            </div>
        </div>
        <div class="layui-inline">
            <div class="layui-input-block">
                <input type="text" name="clienteleName" required  placeholder="请输入关键字查询" autocomplete="off" class="layui-input">
            </div>
        </div>
            <div class="layui-inline">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo1"><i class="layui-icon layui-icon-search"></i>查找</button>
                    <button class="layui-btn" id="newAdd" lay-filter="formDemo2"><i class="layui-icon layui-icon-add-1"></i>新增客户</button>
                    <button type="button" class="layui-btn layui-btn-primary" onclick="flush()"><i class="layui-icon layui-icon-refresh-3"></i>刷新</button>
                </div>
            </div>
        </form>
    </div>

<div class="slider-right">
    <div class="layui-inline content">
        <div class="layui-card">
            <div class="layui-card-header">分类</div>
            <div class="layui-card-body">
                <ul class="menu">
                </ul>
            </div>
        </div>
    </div>
    <div class="layui-inline">
        <table id="demo" lay-filter="test"></table>
    </div>

</div>
</div>
<script type="text/html" id="clientname">
    <a href="javascript:void(0);"  lay-event="cditclient" class="layui-table-link">{{d.clienteleName}}</a>
</script>

<script type="text/html" id="bus">
    <a href="javascript:void(0);" lay-event="busEdit" class="layui-table-link"><i  class="layui-icon layui-icon-gift"></i>{{d.busNum}}</a>
</script>

<%--合同数--%>

<script type="text/html" id="const">
    <a href="javascript:void(0);" lay-event="const" class="layui-table-link"><i  class="layui-icon layui-icon-gift"></i>{{d.consNum}}</a>
</script>

<%--售后服务数--%>
<script type="text/html" id="aftersales">
    <a href="javascript:void(0);" lay-event="afterSales" class="layui-table-link"><i  class="layui-icon layui-icon-gift"></i>{{d.salesNum}}</a>
</script>

<script src="../layui/layui.js"></script>
<script>
    function flush(){
        window.location.reload();
    }

    layui.use(['table','form','layer','jquery'], function() {
        var table = layui.table;
        var form = layui.form;
        var layer = layui.layer;/*弹出层*/
        var $ = layui.jquery;
        var laytpl=layui.laytpl;

        $(function () {
            $.ajax({
                url: "/crm/crm/clientele/selecAllClientName.do",
                type: "get",
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    var html = "";
                    for (let i = 0; i < data.length; i++) {
                        if (i == 0) html += "<option value=''>请选择</option>";
                        html += "<option value=" + data[i].clienteleId + ">" + data[i].clienteleName + "</option>";
                    }
                    $("#select").append(html);
                    form.render();
                }

            });

            $.getJSON("../json/clientClazz.json", function (json) {
                var res = json;
                var html = "";
                $.each(res.data, function (i, ele) {
                    html += "<li><a href='#'><i class=''></i>" + ele.clazz + "</a></li>"
                })
                $(".menu").append(html);

            })

        });

        //加载客户管理详情实例
      var reloadTable  =table.render({
            elem: '#demo'
            , height: 400
            , width: 1000
            , url: '/crm/crm/clientele/select.do' //数据接口
            , page: true
            , limit: 5
            , cols: [[ //表头
                //复选框，fixed为固定位置，即该复选框永远在表格最左侧，同理下面的行内工具栏永远在最右侧
                {type: 'checkbox', fixed: 'left'}
                , {type: 'numbers', title: '序号', width: 80, sort: true, fixed: 'center'}
                , {field: 'clienteleName', title: '客户名称', width: 120, templet: "#clientname"}
                , {field: 'busNum', title: '商机数', width: 120, sort: true, templet: "#bus"}
                , {field: 'estimatedAmount', title: '预计成交金额', width: 150}
                , {field: 'consNum', title: '合同数', width: 135, templet: "#const"}
                , {field: 'contractSum', title: '合同金额', width: 120, sort: true}
                , {field: 'backmoney', title: '汇款额', width: 120, sort: true}
                , {field: 'salesNum', title: '售后服务数', width: 120, templet: "#aftersales"}
                , {field: 'serviceScore', title: '服务均分', width: 135, sort: true}

            ]]
        });
        //提交所有的数据查询
        form.on('submit(formDemo1)', function (data) {

            table.reload('demo', {
                url: "/crm/crm/clientele/select.do",
                where: {
                    clienteleId: data.field.clienteleId,
                    clienteleName: data.field.clienteleName
                },
                page: {
                    curr: 1
                }

            })
            return false;
        });

        /*tool行工具条监听事件*/
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
            if(layEvent === 'cditclient'){ //修改员工
                var index=layer.open({
                    type:2,
                    title:"客户编辑信息",
                    area:['1400px','100vh'],
                    content:"/crm/crm/clientele/findById.do?id="+obj.data.aid,
                    end:function(){//关闭页面回调函数
                        //销毁后回调
                        setTimeout(function(){
                            //表单重载
                            reloadTable.reload({
                                elem:'#demo'
                            })
                        },1000)

                    }
                })
            } else if(layEvent === 'busEdit'){ //商机数
                layer.open({
                    type:2,
                    title:"商机列表",
                    area:['1400px','100vh'],
                    content:"/crm/temp/bus.jsp?id="+obj.data.aid

                })


            } else if(layEvent === 'const'){ //合同数
                layer.open({
                    type:2,
                    title:"编辑员工资料",
                    area:['700px','500px'],
                    content:'/test/LayuiSelectById.do?id='+obj.data.empid
                })
            } else {//查看服务数


            }
        });

        $(document).on("click","#newAdd",function(){
            layer.open({
                type:2,
                title:"添加员工",
                area:['1400px','100vh'],
                content:"/crm/temp/client.html",
                end:function () {
                    window.parent.jump.msg('添加成功');
                    table.reload('demo',{
                        url:"/test/testLayuiPaging.do",
                        page:{
                            curr:1
                        }
                    });
                    return false;
                }
            })

        })


    })
</script>

</body>
</html>
