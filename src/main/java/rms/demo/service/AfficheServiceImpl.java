package rms.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rms.demo.dao.AfficheMapper;
import rms.demo.domain.Affiche;

@Service("afficheService")
public class AfficheServiceImpl {
    @Autowired
    private AfficheMapper afficheMapper;


    //查找所有
    public List<Affiche> selectAfficheAll(){
        List<Affiche> affiches = afficheMapper.selectAfficheAll();
        if (affiches != null) {
            return affiches;
        }
        return null;
    }

    //插入
    public boolean insertAffiche(Affiche affiche){
        int count = afficheMapper.insertAffiche(affiche);
        if(count > 0){
            return true;
        }
        return false;
    }

    //删除
    public boolean delAffiche(String aid){
        int count = afficheMapper.delAffiche(aid);
        if (count > 0) {
            return true;
        }
        return false;
    }

    //修改
    public boolean updateAffiche(Affiche affiche){
        int count = afficheMapper.updateAffiche(affiche);
        if (count > 0) {
            return true;
        }
        return false;
    }

    //查找单个
    public Affiche selectByAid(String aid){
        Affiche affiche = afficheMapper.selectByAid(aid);
        if (affiche != null) {
            return affiche;
        }
        return null;
    }

    //模糊多条件查询
    public List<Affiche> search(Affiche affiche){
        List<Affiche> affiches = afficheMapper.search(affiche);
        if (affiches != null) {
            return affiches;
        }
        return null;
    }
}
