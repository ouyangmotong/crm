
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商机管理信息</title>
    <link rel="stylesheet" href="../fontawesome/css/font-awesome.css">
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script src="../js/jquery-3.4.1.min.js"></script>
    <style>
        *{
            margin:0;
            padding:0;
            font-family: 'Open Sans', sans-serif;
            text-decoration: none;
            list-style: none;
            box-sizing: border-box;
        }
        .wrapper{
            width:100%;
            height: 75px;
            margin: 0;
           background:#393D49;
        }
        .title{
            width:100%;
            line-height: 75px;
            color: #fff;
            box-sizing: border-box;
        }
        .title ol{
            width:100%;
            height:100%;
            box-sizing: border-box;
        }
        .title ol li:nth-of-type(1) a{
            display: inline-block;
            font-size: 22px;
            font-weight: 500;
            color: #fff;
            padding-left: 25px;

        }
        .title ol li{
            display: inline-block;
            position: relative;
        }
        .title ol li:nth-of-type(3){
            background:#ccc;
        }
        .title ol li:nth-of-type(2){
            background:#009688;
        }
        .title ol li:nth-of-type(2):hover{
            background:#1dd1a1;
        }
        .title ol li:nth-of-type(3):hover{
            background:#999999;
        }
        .title ol li:nth-of-type(2),.title ol li:nth-of-type(3){
            box-sizing: border-box;
            width:100px;
            line-height:40px;
            text-align: center;
            border-radius: 5px;
            float: right;
            margin: 20px 10px;

        }

        .title ol li:nth-of-type(2) a,.title ol li:nth-of-type(3) a{
            color: #fff;

        }
        .content{
            width:100%;
            height:auto;
            position: relative;
            display: flex;
            justify-content:flex-start;
            border-radius: 5px;
        }
        .content .layui{
            box-sizing: border-box;
            margin-top:-2px;
            padding: 0;
            width:17%;
            height:auto;
            background: #4E5465;
        }
        .content .content-header{
            width:100%;
            line-height: 60px;
            font-size: 18px;
            padding-left: 30px;
            color:#fff;
            border-bottom: 1px solid #2F4056;
        }
        .content .body ul{
            width:100%;
            position: relative;
        }

        .content .body ul li a{
            display: block;
            width:100%;
            padding-left: 30px;
            line-height: 55px;
            color: #fff;
        }
        .content .body ul li:hover a{
            background:#009688;
            color:#fff;
            border-radius: 3px;
        }
        .content .body ul:nth-of-type(1){
            width:100%;
            border-bottom: 1px solid #130f40;
        }
        .content .body ul:nth-of-type(2){
            width:100%;
            border-bottom: 1px solid #130f40;
        }
        .left-content{
            width: 100%;
            height:100vh;
            padding-left:20px ;
        }
        .right-head-part{
            margin-top: 10px;

        }
        .right-head-part .layui-inline{
            margin: 10px 5px;
        }
        .right-head-part .layui-inline input{
            width:170px;
            height:40px;
        }
        .line{
            width:100%;
            height:1px;
            background: #ccc;
            display: block;
        }

    </style>
</head>
<body>
    <div class="wrapper">
        <div class="title">
            <ol>
                <li><a href="#"><i class="layui-icon layui-icon-group"></i>商机管理</a></li>
                <li><a href="#" class="btn-add-busy"><i class="layui-icon layui-icon-add-1"></i>新增商机</a></li>
                <li><a href="javascript:void(0);" type="reset" onclick="goFlush()"><i class="layui-icon layui-icon-refresh-1"></i>刷新</a></li>
            </ol>

        </div>
        <div class="content">
        <div class="layui">
                <div class="content-header"><i class="fa fa-folder-open" aria-hidden="true"></i>商机所有分类</div>
                <div class="body">
                   <ul>
                       <li><a href="#"><i class="fa fa-folder-open" aria-hidden="true"></i>我负责的商机<span class="layui-badge layui-bg-blue">6</span></a></li>
                       <li><a href="#"><i class="fa fa-folder-open" aria-hidden="true"></i>我参与的商机<span class="layui-badge layui-bg-blue">6</span></a></li>
                       <li><a href="#"><i class="fa fa-folder-open" aria-hidden="true"></i>我关注的商机<span class="layui-badge layui-bg-blue">6</span></a></li>
                       <li><a href="#"><i class="fa fa-folder-open" aria-hidden="true"></i>7天未跟单<span class="layui-badge layui-bg-blue">6</span></a></li>
                       <li><a href="#"><i class="fa fa-folder-open" aria-hidden="true"></i>30天未跟单<span class="layui-badge layui-bg-blue">6</span></a></li>
                       <li><a href="#"><i class="fa fa-folder-open" aria-hidden="true"></i>90天未跟单<span class="layui-badge layui-bg-blue">6</span></a></li>
                   </ul>
                    <ul>
                        <li><a href="#"><i class="fa fa-folder-open" aria-hidden="true"></i>本周新增<span class="layui-badge layui-bg-blue">6</span></a></li>
                        <li><a href="#"><i class="fa fa-folder-open" aria-hidden="true"></i>上周新增<span class="layui-badge layui-bg-blue">6</span></a></li>
                        <li><a href="#"><i class="fa fa-folder-open" aria-hidden="true"></i>本月新增<span class="layui-badge layui-bg-blue">6</span></a></li>
                        <li><a href="#"><i class="fa fa-folder-open" aria-hidden="true"></i>上月新增<span class="layui-badge layui-bg-blue">6</span></a></li>
                        <li><a href="#"><i class="fa fa-folder-open" aria-hidden="true"></i>本季度新增<span class="layui-badge layui-bg-blue">6</span></a></li>
                        <li><a href="#"><i class="fa fa-folder-open" aria-hidden="true"></i>上季度新增<span class="layui-badge layui-bg-blue">6</span></a></li>
                    </ul>
                    <ul>
                        <li><a href="#"><i class="fa fa-folder-open" aria-hidden="true"></i>已成交的商机<span class="layui-badge layui-bg-blue">6</span></a></li>
                        <li><a href="#"><i class="fa fa-folder-open" aria-hidden="true"></i>已丢失的商机<span class="layui-badge layui-bg-blue">6</span></a></li>
                        <li><a href="#"><i class="fa fa-folder-open" aria-hidden="true"></i>已搁置的商机<span class="layui-badge layui-bg-blue">6</span></a></li>
                    </ul>

                </div>
            </div>

            <div class="left-content">
                <div class="right-head-part">
                    <form  id="form" class="layui-form" action="" method="">
                    <div class="layui-inline">
                        <label>商机全称</label>
                        <input type="text" autofocus required placeholder="请输入" name="businessName">
                    </div>
                    <div class="layui-inline">
                        <label>商机阶段</label>
                        <input type="text" autofocus required placeholder="请输入" name="name">
                    </div>

                    <div class="layui-inline">
                        <label>商机负责人</label>
                        <input type="text" autofocus required placeholder="请输入" name="empname">
                    </div>

                    <div class="layui-inline">
                        <label>所属部门</label>
                        <input type="text" autofocus required placeholder="请输入" name="dept">
                    </div>

                    <div class="layui-inline">
                        <label>预计成交金额</label>
                        <input type="text" autofocus required placeholder="请输入" name="estimatedAmount">
                    </div>

                    <div class="layui-inline">
                        <label>预计结单日期</label>
                        <input type="date" required autofocus placeholder="请输入" name="estimateDdate">
                    </div>
                        <div class="layui-inline">
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>
                        </div>
                    </form>
                </div>
                <div class="line"></div>
                <div class="right-body-part">
                    <table id="demo" lay-filter="test"></table>
                </div>
            </div>
        </div>
        </div>
    </div>
    <%--修改商机--%>
    <script type="text/html" id="businessName">
        <a href="javascript:void(0);"  lay-event="businessName" class="layui-table-link">{{d.businessName}}</a>
    </script>
    <%--查看跟单详情--%>

    <script type="text/html" id="documentary">
        <a href="javascript:void(0);"  lay-event="documentary" class="layui-table-link"><i class="layui-icon layui-icon-time"></i>{{d.documentarydate}}</a>
    </script>
    <%--讨论帖子--%>

    <script type="text/html" id="num">
        <a href="javascript:void(0);"  lay-event="num" class="layui-table-link"><i class="layui-icon layui-icon-list"></i>{{d.num}}</a>
    </script>

<script src="../layui/layui.js"></script>
<script>
    function goFlush(){
        document.getElementById("form").reset();
        window.location.reload();
    }
    layui.use(['form','layer','jquery','table'],function(){
        var table=layui.table;
        var layer=layui.layer;
        var $=layui.jquery;
        var table=layui.table;
        var form=layui.form;

        //加载商机管理详情实例
        var  reloadTable=table.render({
            elem: '#demo'
            ,height:"auto"
            ,width:1000
            ,url: '/crm/crm/business/findAll.do'
            ,page:true
            ,limit:5
            ,cols: [[ //表头
                //复选框，fixed为固定位置，即该复选框永远在表格最左侧，同理下面的行内工具栏永远在最右侧
                {type: 'checkbox',fixed: 'left'}
                ,{field: 'businessName',title: '客户全称', width:200,templet:"#businessName"}
                ,{field: 'name',title: '商机阶段', width:120}
                ,{field: 'estimatedAmount', title: '预计成交金额', width:200, sort: true}
                ,{field: 'empname', title: '负责人', width:120}
                ,{field: 'documentarydate', title: '最后跟单', width: 135,templet: "#documentary"}
                ,{field: 'num', title: '讨论版', width:120, sort: true,templet:"#num"}

            ]]
        });


        /*tool行工具条监听事件*/
     table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）
            if(layEvent === 'businessName'){ //修改员工
                var index=layer.open({
                    type:2,
                    title:"商机编辑信息",
                    area:['1400px','100vh'],
                    content:"/crm/crm/business/select.do?id="+obj.data.businessId,
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
            } else if(layEvent === 'documentary'){ //商机数
                layer.open({
                    type:2,
                    title:"商机列表",
                    area:['1400px','100vh'],
                    content:"/crm/temp/bus.jsp?id="+obj.data.aid

                })


            } else{ //合同数
                layer.open({
                    type:2,
                    title:"编辑员工资料",
                    area:['700px','500px'],
                    content:'/test/LayuiSelectById.do?id='+obj.data.empid
                })
            }
        });







        //提交表单查询
        form.on('submit(formDemo)',function(data){
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
                },

            })
            return false;


        })



        $(document).on("click",".btn-add-busy",function(){
            layer.open({
                    type:2,
                    title:"新增商机",
                    area:['1400px','100vh'],
                    content:"/crm/temp/bAdd.html",
                    end:function(){
                        setTimeout(function(){
                            //表单重载
                            reloadTable.reload({
                                elem:'#demo'
                            })
                        },1000)
                    }

            })


        })





    })




</script>


</body>
</html>
