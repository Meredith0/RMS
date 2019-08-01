package rms.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rms.demo.dao.CheckstateMapper;
import rms.demo.domain.Checkstate;

@Service("checkstateService")
public class CheckstateServiceImpl  {
    @Autowired
    private CheckstateMapper checkstateMapper;
    //查找所有

    public List<Checkstate> selectCheckstateAll(){
        List<Checkstate> checkworks = checkstateMapper.selectCheckstateAll();
        if (checkworks != null) {
            return checkworks;
        }
        return null;
    }
    //插入

    public boolean insertCheckstate(Checkstate checkstate){
        int count = checkstateMapper.insertCheckstate(checkstate);
        if(count > 0){
            return true;
        }
        return false;
    }
    //删除

    public boolean delCheckstate(String id){
        int count = checkstateMapper.delCheckstate(id);
        if (count > 0) {
            return true;
        }
        return false;
    }
    //修改

    public boolean updateCheckstate(Checkstate checkstate){
        int count = checkstateMapper.updateCheckstate(checkstate);
        if (count > 0) {
            return true;
        }
        return false;
    }
    //查找单个

    public Checkstate selectById(String id){
        Checkstate checkstate = checkstateMapper.selectById(id);
        if (checkstate != null) {
            return checkstate;
        }
        return null;
    }

    //模糊多条件查询
    public List<Checkstate> search(Checkstate checkstate){
        List<Checkstate> checkstates = checkstateMapper.search(checkstate);
        if (checkstates != null) {
            return checkstates;
        }
        return null;
    }
}
