package rms.demo.controller.checkWork;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import rms.demo.common.Msg;
import rms.demo.domain.Checkstate;
import rms.demo.service.CheckstateServiceImpl;

@Controller
@RequestMapping ("/checkState")
@PreAuthorize ("hasAnyAuthority('admin','dept','employee')")
public class CheckstateController {
    @Autowired
    private CheckstateServiceImpl checkstateService;

    //返回考勤信息
    @RequestMapping("/css")
    @ResponseBody
    public Msg doListCssJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        int pageSize = 5;//每页显示多少条数据
        //在查询之前需要调用startPage方法，传入页码，每页显示的记录
        PageHelper.startPage(pn, pageSize);
        //在startPage后紧跟着一个查询，此查询一个分页查询
        List<Checkstate> css = checkstateService.selectCheckstateAll();
        //使用PageInfo包装查询后的结果，只需要将pageInfo交给前台页面就行了
        //pageInfo封装了详细的分页信息，包括我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(css, 5);
        return Msg.success().add("pageInfo", page);
    }

    //根据cid查找
    @RequestMapping(value = "/cs/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg doGetCsById(@PathVariable("id") String id) {
        Checkstate checkstate = checkstateService.selectById(id);
        return Msg.success().add("checkstate", checkstate);
    }

    //保存新增数据
    @RequestMapping (value = "/addCs", method = RequestMethod.POST)
    @ResponseBody
    //eid=123&cyear=1945&cmonth=2&atwork=0&late=0&early=0
    public Msg saveAddCs (@RequestParam(name = "eid") String eid, @RequestParam(name = "cyear") String cyear,
                          @RequestParam(name = "cmonth") String cmonth,@RequestParam(name = "atwork")  String atwork,
                          @RequestParam(name = "late") String late,@RequestParam(name = "early") String early) {

        var checkstate = new Checkstate();
        checkstate.setEid(eid);
        checkstate.setCyear(Integer.parseInt(cyear));
        checkstate.setCmonth(Integer.parseInt(cmonth));
        checkstate.setAtwork(Integer.parseInt(atwork));
        checkstate.setLate(Integer.parseInt(late));
        checkstate.setEarly(Integer.parseInt(early));
        if (checkstateService.insertCheckstate(checkstate)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    //保存编辑数据
    @RequestMapping(value = "/editCs/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEditCs(Checkstate checkstate) {
        if (checkstateService.updateCheckstate(checkstate)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    @RequestMapping(value = "/delCs/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg doDeleteCsAll(@PathVariable("ids") String ids) {
        if (ids.contains(",")) {
            String[] str_cid = ids.split(",");
            //组装id的集合
            for (String ckid : str_cid) {
                checkstateService.delCheckstate(ckid);
            }
        } else {
            checkstateService.delCheckstate(ids);
        }
        return Msg.success();
    }
    //查询数据
    @RequestMapping(value = "/searchCs/{pn}", method = RequestMethod.POST)
    @ResponseBody
    public Msg doSearchCssJson(@PathVariable("pn") Integer pn,Checkstate cs) {
        int pageSize = 5;//每页显示多少条数据
        //在查询之前需要调用startPage方法，传入页码，每页显示的记录
        PageHelper.startPage(pn, pageSize);
        //在startPage后紧跟着一个查询，此查询一个分页查询
        List<Checkstate> css = checkstateService.search(cs);
        PageInfo page = new PageInfo(css, 5);
        return Msg.success().add("pageInfo", page);
    }
}
