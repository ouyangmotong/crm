//定义模块
layui.define(['form','jquery'],function(exports){
    //do something
    var form = layui.form;
    var $=layui.jquery;
    var arg1= {
        code:1000,
        msg:"客户来源 ",
        count: 3,
        data1:[
            {
            value: 1000,
            clazz: "老客户"
         },{
            value: 1001,
            clazz: "代理商"
         },{
            value: 1002,
            clazz: "互联网"
            },{
            value: 1003,
            clazz: "独立开发"
            },{
            value: 1004,
            clazz: "客户介绍"
             },{
            value: 1005,
            clazz: "合作伙伴"
                },{
            value: 1006,
            clazz: "促销活动"
        },{
            value: 1007,
            clazz: "媒体宣传"
        },{
            value: 1008,
            clazz: "电话访问"
        },{
            value: 1009,
            clazz: "客户来电"
        },{
            value: 1010,
            clazz: "二次促销"
        },{
            value: 1011,
            clazz: "公开招标"
        },
        {
            value: 1012,
            clazz: "研讨会和展会"
        },{
            value: 1013,
            clazz: "其他"
        }

    ]
    };
    exports("clientSource",arg1);//输出模块
});