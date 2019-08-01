package rms.demo.dao;

import java.util.List;
import rms.demo.domain.Affiche;

public interface AfficheMapper {
    //查找所有
    List<Affiche> selectAfficheAll ();
    //插入
    int insertAffiche (Affiche affiche);
    //删除
    int delAffiche (String aid);
    //修改
    int updateAffiche (Affiche affiche);
    //查找单个
    Affiche selectByAid (String aid);
    //模糊多条件查询
    List<Affiche> search (Affiche affiche);
}
