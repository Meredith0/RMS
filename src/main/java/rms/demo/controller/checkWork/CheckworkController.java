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
import rms.demo.domain.Checkwork;
import rms.demo.service.CheckworkServiceImpl;

@Controller
@RequestMapping ("/checkWork")
@PreAuthorize ("hasAnyAuthority('admin','dept')")
public class CheckworkController {
    @Autowired
    private CheckworkServiceImpl checkworkService;

    //返回考勤信息
    @RequestMapping("/cks")
    @ResponseBody
    public Msg doListCksJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        int pageSize = 5;//每页显示多少条数据
        //在查询之前需要调用startPage方法，传入页码，每页显示的记录
        PageHelper.startPage(pn, pageSize);
        //在startPage后紧跟着一个查询，此查询一个分页查询
        List<Checkwork> cks = checkworkService.selectCheckWorkAll();
        //使用PageInfo包装查询后的结果，只需要将pageInfo交给前台页面就行了
        //pageInfo封装了详细的分页信息，包括我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(cks, 5);
        return Msg.success().add("pageInfo", page);
    }

    //根据cid查找
    @RequestMapping(value = "/ck/{cid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg doGetCkByCid(@PathVariable("cid") String cid) {
        Checkwork checkwork = checkworkService.selectByCid(cid);
        return Msg.success().add("checkwork", checkwork);
    }

    //保存新增数据
    @RequestMapping(value = "/addCk", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveAddCk(Checkwork checkwork) {
        if (checkworkService.insertCheckwork(checkwork)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    //保存编辑数据
    @RequestMapping(value = "/editCk/{cid}", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEditCk(Checkwork checkwork) {
        if (checkworkService.updateCheckwork(checkwork)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    //删除数据
    @RequestMapping(value = "/delCk/{cids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg doDeleteCkAll(@PathVariable("cids") String cids) {
        if (cids.contains(",")) {
            String[] str_cid = cids.split(",");
            //组装id的集合
            for (String ckid : str_cid) {
                checkworkService.delCheckwork(ckid);
            }
        } else {
            checkworkService.delCheckwork(cids);
        }
        return Msg.success();
    }
    //查询数据
    @RequestMapping(value = "/search/{pn}", method = RequestMethod.POST)
    @ResponseBody
    public Msg doSearchCksJson(@PathVariable("pn") Integer pn,Checkwork ck) {
        int pageSize = 5;//每页显示多少条数据
        //在查询之前需要调用startPage方法，传入页码，每页显示的记录
        PageHelper.startPage(pn, pageSize);
        //在startPage后紧跟着一个查询，此查询一个分页查询
        List<Checkwork> cks = checkworkService.search(ck);
        PageInfo page = new PageInfo(cks, 5);
        return Msg.success().add("pageInfo", page);
    }
}
