package rms.demo.dao;

import java.util.List;
import rms.demo.domain.Checkwork;

public interface CheckworkMapper {
    //查找所有
    List<Checkwork> selectCheckWorkAll ();
    //插入
    int insertCheckwork (Checkwork checkwork);
    //删除
    int delCheckwork (String cid);
    //修改
    int updateCheckwork (Checkwork checkwork);
    //查找单个
    Checkwork selectByCid (String cid);
    //模糊多条件查询
    List<Checkwork> search (Checkwork checkwork);
}