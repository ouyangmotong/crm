<%--
  Created by IntelliJ IDEA.
  User: kw
  Date: 2020/8/29
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看商机列表</title>
    <link rel="stylesheet" href="/fontawesome/css/font-awesome.css">
    <link rel="stylesheet" href="/layui/css/layui.css">
</head>
<style>
    *{
        margin:0;
        paddding:0;
        box-sizing: border-box;
        text-decoration: none;
    }
    .business{
        width:65%;
        height:100vh;
        margin:0px auto;
    }
    .business .title{
        width:100%;
        height:75px;
    }
    .business .title ul li{
        display: inline-block;

    }
    .business .title ul li:nth-of-type(2),
    .business .title ul li:nth-of-type(3){
        float:right;
        text-align: center;
    }
    .business .title ul li:nth-of-type(1) a{
        display: inline-block;
        font-size: 18px;
        margin-top: 30px;
    }
    .business .title ul li:nth-of-type(3):hover a{
        background: #20bf6b;
    }
    .business .title ul li:nth-of-type(2) a{
            background: #ccc;
        }
    .business .title ul li:nth-of-type(2):hover a{
        background: #9F9F9F;
    }
    .business .title ul li:nth-of-type(3) a{
        background: #0be881
    }
    .business .title ul li:nth-of-type(2) a,
    .business .title ul li:nth-of-type(3) a{
        display: inline-block;
        color:#fff;
        width:89px;
        line-height:38px;
        margin: 20px 10px;
        border-radius: 5px;

    }
    .business .line{
        width:100%;
        height:1px;
        background: #ccc;
    }

    .business .content{
       width:100%;
        height:auto;
        margin-top: 10px;
    }
    .content .ctx-item input{
        width:120px;
        height:38px;
    }


</style>
<body>
    <div class="business">
        <div class="title">
            <ul>
                <li class="item"><a href="#">商机列表</a></li>
                <li class="item"><a href="#"><i class="fa fa-chevron-left" aria-hidden="true"></i>返回</a></li>
                <li class="item"><a href="#"><i class="layui-icon layui-icon-refresh"></i>刷新</a></li>
            </ul>
        </div>
        <div class="line"></div>
        <div class="content">
            <div class="item">
                <form id="">
                <span class="ctx-item">
                    <label>商机名称</label>
                    <input type="text" required placeholder="请输入">
                </span>
                <span class="ctx-item">
                    <label>商机阶段</label>
                    <input type="text" required placeholder="请输入">
                </span>
                <span class="ctx-item">
                    <label>商机负责人</label>
                    <input type="text" required placeholder="请输入">
                </span>
                <span class="ctx-item">
                    <label>所属部门</label>
                    <input type="text" required placeholder="请输入">
                </span>
                <span class="ctx-item">
                    <label>预交成交金额</label>
                    <input type="text" required placeholder="请输入">
                </span>
                <span class="ctx-item">
                    <label>预计结单日期</label>
                    <input type="date" required>
                </span>
                  <span class="ctx-itemd">
                      <button type="button" class="data-btn-search">查询商机</button>
                      <button type="submit">重置</button>
                  </span>
                </form>
            </div>
            <div class="data-tab">
                <table>
                    <thead></thead>
                    <tbody></tbody>
                </table>


            </div>


        </div>

    </div>

</body>
</html>
