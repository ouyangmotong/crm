//定义模块
layui.define(['form','jquery'],function(exports){
    //do something
    var form = layui.form;
    var $=layui.jquery;
    var arg0= {
        code:3000,
        msg:"客户分类 ",
        count: 3,
        data0: [
            {
                value: 100,
                clazz: "客户分类一"
            },{
                value: 101,
                clazz: "客户分类二"
             },{
                value: 102,
                clazz: "客户分类三"
            }]

    };
    exports("clientClazz",arg0);//输出模块
});