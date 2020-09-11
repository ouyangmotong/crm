package com.hy.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hy.crm.entity.Business;
import com.hy.crm.entity.Contract;
import com.hy.crm.entity.Emp;
import com.hy.crm.service.IBusinessService;
import com.hy.crm.service.IClienteleService;
import com.hy.crm.service.IContractService;
import com.hy.crm.util.ImgUtils;
import com.hy.crm.util.LayUIData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 合同表 前端控制器
 * </p>
 *
 * @author Jackson
 * @since 2020-08-28
 */
@Controller
@RequestMapping("/crm/contract")
public class ContractController {

    /**
     * 注入合同servlet
     */
    @Autowired
    private IContractService contractService;
    @Autowired
    private IBusinessService businessService;
    @Autowired
    private IClienteleService clienteleService;

    /**
     * 根据状态查询合同
     * 只查询合同签约成功的
     * 状态为1001的
     */
    @ResponseBody
    @GetMapping("/queryAllByStatic.do")
    public List<Contract> queryAllByStatic(){
        UpdateWrapper<Contract> updateWrapper = new UpdateWrapper();
        updateWrapper.eq("contract_static","1001");
        List<Contract> list=contractService.list(updateWrapper);
        return list;
    }

    /**
     * 根据合同id查询合同编号
     * @param id 合同id
     */
    @ResponseBody
    @RequestMapping("/queryContractNo.do")
    public String queryContractNo(int id){
        QueryWrapper<Contract> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("contractId",id);
        Contract contract = contractService.getOne(queryWrapper);
        //获得合同编号
        return contract.getContractNo();
    }

    /**
     * 根据条件查询所有合同
     * @param session
     * @param page 当前页
     * @param limit 每页显示条数
     * @param classify 类型(1001本周新增,1002上周新增,1003本月新增,1004上月新增,1005本季度新增,1006上季度新增)
     * @param type 类型(1001按合同名称,1002按客户名称,1003按商机,1004按签约日期)
     * @param typeValue 类型的值
     * @return
     */
    @ResponseBody
    @GetMapping("/queryAllContract.do")
    public LayUIData queryAllContract(HttpSession session,Integer page, Integer limit,Integer classify,Integer type,String typeValue){
        Emp emp = new Emp();
        //emp = (Emp) session.getAttribute("emp");
        emp.setEmpId(1001);
        return contractService.queryContract(page,limit,emp,classify,type,typeValue,1001);//1001查询全部 1002查询我的跟单
    }

    /**
     * 根据条件查询我的合同
     * @param session
     * @param page 当前页
     * @param limit 每页显示条数
     * @param classify 类型(1001本周新增,1002上周新增,1003本月新增,1004上月新增,1005本季度新增,1006上季度新增)
     * @param type 类型(1001按合同名称,1002按客户名称,1003按商机,1004按签约日期)
     * @param typeValue 类型的值
     * @return
     */
    @ResponseBody
    @GetMapping("/queryMyContract.do")
    public LayUIData queryMyContract(HttpSession session,Integer page, Integer limit,Integer classify,Integer type,String typeValue){
        Emp emp = new Emp();
        //emp = (Emp) session.getAttribute("emp");
        emp.setEmpId(1001);
        return contractService.queryContract(page,limit,emp,classify,type,typeValue,1002);//1001查询全部 1002查询我的跟单
    }

    /**
     * 新增合同前查询可新增的商机
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/queryBusinessContract.do")
    public String queryBusinessContract(Model model, HttpSession session){
        Emp emp = new Emp();
        //emp = (Emp) session.getAttribute("emp");//当前用户
        emp.setEmpId(1001);//写死
        emp.setEmpName("admin");
        model.addAttribute("blist",contractService.queryBusinessContract());//商机信息
        model.addAttribute("emp", emp);//当前用户
        return "wry/saveContract.html";
    }

    /**
     * 添加合同
     * @param contract
     * @param businessId
     * @param session
     * @return
     */
    @RequestMapping("/saveNewContract.do")
    public String saveNewContract(Contract contract, Integer businessId, HttpSession session) {
        Emp emp = new Emp();
        //emp = (Emp) session.getAttribute("emp");//当前用户
        emp.setEmpId(1001);//写死
        emp.setDeptId(1001);
        emp.setEmpName("admin");

        contractService.saveNewContract(contract,businessId,emp);
        return "redirect:../../wry/queryContract.html";
    }

    /**
     * 修改前查询
     * @param model
     * @param session
     * @param contractId
     * @return
     */
    @RequestMapping("/queryByContract.do")
    public String queryByContract(Model model, HttpSession session,Integer contractId){
        Emp emp = new Emp();
        //emp = (Emp) session.getAttribute("emp");//当前用户
        emp.setEmpId(1001);//写死
        emp.setEmpName("admin");

        Contract contract = contractService.getById(contractId);
        Business business = businessService.getById(contract.getBusinessId());

        model.addAttribute("contract",contract);//合同信息
        model.addAttribute("emp", emp);//当前用户
        return "wry/updateContract.html";
    }

    /**
     * 修改
     * @param model
     * @param session
     * @param contract
     * @return
     */
    @RequestMapping("/updateContract.do")
    public String updateContract(Model model, HttpSession session,Contract contract){

        Contract c = contractService.getById(contract.getContractId());
        contract.setPriorityId(c.getPriorityId());//优先级(1001高,1002中,1003低)
        contract.setBusinessId(c.getBusinessId());//商机id
        contract.setClienteleId(c.getClienteleId());//客户信息id
        contract.setContractNo(c.getContractNo());//合同编号
        contract.setFile(c.getFile());//相关附件
        contract.setDeptId(c.getDeptId());//合同所属部门id
        contract.setEmpId(c.getEmpId());//关联人员
        contract.setContractStatic(c.getContractStatic());//状态(1001完成,1002撤除,1003搁置)

        contractService.updateById(contract);

        return "redirect:../../wry/queryContract.html";
    }

    /**
     * 文件上传
     * @param pictureFile
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/fileUpload.do")
    @ResponseBody
    public ImgUtils fileUpload(@RequestParam("file") MultipartFile pictureFile, HttpServletRequest request) throws IOException {
        System.out.println("进fileupload----");
        // 图片上传设置图片名称，不能重复，可以使用uuid
        String picName = UUID.randomUUID().toString();
        // 获取文件名
        String oriName = pictureFile.getOriginalFilename();
        // 获取图片后缀
        String extName = oriName.substring(oriName.lastIndexOf("."));

        String webpath = request.getServletContext().getRealPath("/");
        webpath = webpath.substring(0, webpath.lastIndexOf("\\"));
        webpath = webpath.substring(0, webpath.lastIndexOf("\\"));
        File rootFile = new File(webpath);
        File uploadFile = new File(rootFile, "upload");
        if (!uploadFile.exists()) {
            uploadFile.mkdir();
        }
        System.out.println("开始上传");
        // 开始上传
        pictureFile.transferTo(new File(webpath + File.separator + "upload" + File.separator + picName + extName));
        String imgName=File.separator + "upload" + File.separator + picName + extName;
        System.out.println("上传成功");
        ImgUtils imgUtils=new ImgUtils();
        imgUtils.setCode(0);
        imgUtils.setMsg("文件上传成功");
        imgUtils.setData(imgName);
        return imgUtils;
    }

}
