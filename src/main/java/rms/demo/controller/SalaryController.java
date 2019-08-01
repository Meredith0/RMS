package rms.demo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import rms.demo.domain.MsgEs;
import rms.demo.domain.Salary;
import rms.demo.service.SalaryServiceimpl;

/**
 * Description: SSM01
 *
 * @author CM
 * Created by Administrator on 2019/7/26 10:24
 */
@Controller
@RequestMapping ("/salary")
@PreAuthorize ("hasAnyAuthority('admin','dept','employee')")
public class SalaryController {
    @Autowired
    private SalaryServiceimpl salaryService;

    /**
     * 前后端分离
     */
    @RequestMapping("/manageSalary")
    public String doListSalary(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        /**
         * 这不是一个分页查询；
         * 引入PageHelper分页插件
         * 在查询之前只需要调用，传入页码，以及每页的大小
         */
        PageHelper.startPage(pn,6);
        /**
         * startPage后面紧跟的这个查询就是一个分页查询
         */
        List<Salary> salaries = salaryService.findSalaryAll();
        /**
         * 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
         * 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
         */
        PageInfo page = new PageInfo(salaries,6);
        model.addAttribute("pageInfo",page);
        return "/salaryManage.jsp";
    }
    /**
     * 工资保存
     */
    @RequestMapping("/addSalary")
    public void doSaveSalary(Salary salary, HttpServletResponse response)throws IOException{
        System.out.println("**"+ salary);
        PrintWriter out = response.getWriter();
        if (salaryService.addSalary(salary)) {
            out.print("1");
        }else {
            out.print("0");
        }
        out.close();
    }
    /**
     * 前后端分离
     */
    @RequestMapping("/salaries")
    @ResponseBody
    public MsgEs diListSalaryJson(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        /**
         * 每页最多显示5条数据
         */
        int pageSize = 5;
        /**
         * 在查询前需要使用startpage方法，传入页码，每页显示记录
         */
        PageHelper.startPage(pn,pageSize);
        /**
         * 在startPage后紧跟着一个查询，此查询一个分页查询
         */
        List<Salary> salaries = salaryService.findSalaryAll();
        /**
         * 使用PageInfo包装查询后的结果，只需要将pageInfo交给前台页面就行了
         * pageInfo封装了详细的分页信息，包括我们查询出来的数据，传入连续显示的页数
         */
        PageInfo page = new PageInfo(salaries,5);
        return MsgEs.success().add("pageInfo",page);
    }
    /**
     * 工资保存
     */
    @RequestMapping(value = "/salary",method = RequestMethod.POST)
    @ResponseBody
    public MsgEs saveSalary(Salary salary){
        if (salaryService.addSalary(salary)){
            return MsgEs.success();
        }else {
            return MsgEs.fail();
        }
    }
    /**
     * 根据薪资单号查找员工工资
     */
    @RequestMapping(value = "/salary/{sid}",method = RequestMethod.GET)
    @ResponseBody
    public MsgEs doGetSalarySid(@PathVariable("sid")String sid){
        Salary salary = salaryService.selectBySalary(sid);
        return MsgEs.success().add("salary",salary);
    }
    /**
     * 修改员工信息
     */
    @RequestMapping(value = "/salary/{sid}",method = RequestMethod.PUT)
    @ResponseBody
    public MsgEs doUpdateSalarySid(Salary salary){
        if (salaryService.modifySalary(salary)){
            return MsgEs.success();
        }else {
            return MsgEs.fail();
        }
    }
    /**单个、批量删除二合一
     *  批量删除：1,2,3
     * 单个删除：1
     *
     * */
    @RequestMapping(value = "/salary/{sids}", method = RequestMethod.DELETE)
    @ResponseBody
    public MsgEs doDeleteEmpAll(@PathVariable("sids") String sids) {
        if (sids.contains(",")) {
            List<Integer> del_ids = new ArrayList<>();
            String[] str_Nos = sids.split(",");
            //组装id的集合
            for (String sid : str_Nos) {
                salaryService.removeSalary(sid);
            }
        } else {
            salaryService.removeSalary(sids);
        }
        return MsgEs.success();
    }


    @RequestMapping("/finds")
    @ResponseBody
    public MsgEs findsalaries(@RequestParam(value = "pn", defaultValue = "1") Integer pn, String sid){
//        每页显示多少条数据
        int pageSize = 5;
       //在查询之前需要调用startPage方法，传入页码，每页显示的记录
        PageHelper.startPage(pn, pageSize);

        List<Salary> salary=salaryService.selectBySalary1(sid);

        PageInfo page = new PageInfo(salary, 5);

       return  MsgEs.success().add("pageInfo", page);
    }

    //查询数据
    @RequestMapping(value = "/search/{pn}",method = RequestMethod.POST)
    @ResponseBody
    public MsgEs doSearch(@PathVariable("pn")Integer pn,Salary salary){
        int pageSize = 5;//每页显示多少条数据
        //在查询之前需要调用startPage方法，传入页码，每页显示的记录
        PageHelper.startPage(pn, pageSize);
        //在startPage后紧跟着一个查询，此查询一个分页查询
        List<Salary> salaries = salaryService.selectBySalaryAll(salary);
        PageInfo page = new PageInfo(salaries, 5);
        return MsgEs.success().add("pageInfo", page);
    }
}
