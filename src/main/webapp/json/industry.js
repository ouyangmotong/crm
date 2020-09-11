//定义模块
layui.define(['form','jquery'],function(exports){
    //do something
    var form = layui.form;
    var $=layui.jquery;
    var arg2= {
        code:2000,
        msg:"行业分类 ",
        count: 3,
        data2: [{
            value:200,
            clazz: "IT|互联网|通信|电子"
            },{
             value: 201,
            clazz: "金融|银行|保险"
            },{
                value: 202,
             clazz: "房产|建筑建设|物业"
            }
            ,{
                value: 203,
                clazz: "广告|传媒|印刷出版"
             },{
                 value: 204,
                clazz: "销售零售|贸易|交通物流"
                },{
                value: 205,
                clazz: "加工制造|仪表设备"
                },{
                value: 206,
                 clazz: "管理咨询|教育科研|中介服务"
            },{
                value: 207,
                clazz: "医疗生物|医疗保健"
                },{
                value: 208,
                clazz: "酒店旅游"
             },{
                value: 209,
                clazz: "能源矿产|石油化工"
            },{
                value: 210,
                clazz: "政府|非盈利机构|科研"
            },{
                value: 2011,
                clazz: "其他"
            }]

    };
    exports("industry",arg2);//输出模块
});