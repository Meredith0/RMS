package rms.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rms.demo.dao.CheckworkMapper;
import rms.demo.domain.Checkwork;

@Service("checkworkService")
public class CheckworkServiceImpl {
    @Autowired
    private CheckworkMapper checkworkMapper;
    //查找所有

    public List<Checkwork> selectCheckWorkAll(){
        List<Checkwork> checkworks = checkworkMapper.selectCheckWorkAll();
        if (checkworks != null) {
            return checkworks;
        }
        return null;
    }
    //插入

    public boolean insertCheckwork(Checkwork checkwork){
        int count = checkworkMapper.insertCheckwork(checkwork);
        if(count >0 ){
            return true;
        }
        return false;
    }
    //删除

    public boolean delCheckwork(String cid){
        int count = checkworkMapper.delCheckwork(cid);
        if (count > 0) {
            return true;
        }
        return false;
    }
    //修改

    public boolean updateCheckwork(Checkwork checkwork){
        int count = checkworkMapper.updateCheckwork(checkwork);
        if (count > 0) {
            return true;
        }
        return false;
    }
    //查找单个

    public Checkwork selectByCid(String cid){
        Checkwork checkwork = checkworkMapper.selectByCid(cid);
        if (checkwork != null) {
            return checkwork;
        }
        return null;
    }

    //模糊多条件查询
    public List<Checkwork> search(Checkwork checkwork){
        List<Checkwork> checkworks = checkworkMapper.search(checkwork);
        if (checkworks != null) {
            return checkworks;
        }
        return null;
    }
}
