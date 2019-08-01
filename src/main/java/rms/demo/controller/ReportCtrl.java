package rms.demo.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rms.demo.dao.OtherMapper;

/**
 * @author : Meredith
 * @date : 2019-07-26 23:23
 * @description :
 */
@RestController
@RequestMapping ("/report")
@PreAuthorize ("hasAnyAuthority('admin')")
public class ReportCtrl {

    @Autowired
    OtherMapper mapper;

    @RequestMapping (value = "/ageReport", method = RequestMethod.GET)
    public Object ageReport () {

        List<String> maps = mapper.ageReport();
        return maps;
    }

    @RequestMapping (value = "workReport", method = RequestMethod.GET)
    public List<Integer> workReport () {
        int atWork = mapper.atworkCount();
        int late = mapper.lateCount();
        int early = mapper.earlyCount();
        int notAtWork = mapper.noAtWorkReport();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(atWork);
        list.add(late);
        list.add(early);
        list.add(notAtWork);
        return list;
    }
}
