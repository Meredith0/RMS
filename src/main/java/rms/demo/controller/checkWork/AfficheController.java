package rms.demo.controller.checkWork;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import rms.demo.domain.Affiche;
import rms.demo.service.AfficheServiceImpl;

@Controller
@RequestMapping ("/affiche")
@PreAuthorize ("hasAnyAuthority('admin')")
public class AfficheController {
    @Autowired
    private AfficheServiceImpl afficheService;
    //查找所有公告
    @RequestMapping("/affiches")
    @ResponseBody
    public Msg doListAffJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        int pageSize = 5;//每页显示多少条数据
        //在查询之前需要调用startPage方法，传入页码，每页显示的记录
        PageHelper.startPage(pn, pageSize);
        //在startPage后紧跟着一个查询，此查询一个分页查询
        List<Affiche> affs = afficheService.selectAfficheAll();
        //使用PageInfo包装查询后的结果，只需要将pageInfo交给前台页面就行了
        //pageInfo封装了详细的分页信息，包括我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(affs, 5);
        return Msg.success().add("pageInfo", page);
    }

    //根据aid查找
    @RequestMapping(value = "/aff/{aid}", method = RequestMethod.GET)
    @ResponseBody
    public Msg doGetAffByAid(@PathVariable("aid") String aid) {
        Affiche affiche = afficheService.selectByAid(aid);
        return Msg.success().add("affiche", affiche);
    }
    //保存新增数据
    @RequestMapping(value = "/addAff", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveAddAff(Affiche affiche) {
        affiche.setAdate(getDate());
        if (afficheService.insertAffiche(affiche)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    //保存编辑数据
    @RequestMapping(value = "/editAff/{aid}", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEditAff(Affiche affiche) {
        affiche.setAdate(getDate());
        if (afficheService.updateAffiche(affiche)) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
    @RequestMapping(value = "/delAff/{aids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg doDeleteCsAll(@PathVariable("aids") String aids) {
        if (aids.contains(",")) {
            String[] str_aids = aids.split(",");
            //组装id的集合
            for (String str_aid : str_aids) {
                afficheService.delAffiche(str_aid);
            }
        } else {
            afficheService.delAffiche(aids);
        }
        return Msg.success();
    }

    private String getDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String date = df.format(new Date());
        return date;
    }

    //查询数据
    @RequestMapping(value = "/searchAff/{pn}", method = RequestMethod.POST)
    @ResponseBody
    public Msg doSearchCksJson(@PathVariable("pn") Integer pn,Affiche aff) {
        int pageSize = 5;//每页显示多少条数据
        //在查询之前需要调用startPage方法，传入页码，每页显示的记录
        PageHelper.startPage(pn, pageSize);
        //在startPage后紧跟着一个查询，此查询一个分页查询
        List<Affiche> affs = afficheService.search(aff);
        PageInfo page = new PageInfo(affs, 5);
        return Msg.success().add("pageInfo", page);
    }
}
