package rms.demo.dao;

import java.util.List;
import rms.demo.domain.Checkstate;

public interface CheckstateMapper {
    //查找所有
    List<Checkstate> selectCheckstateAll ();
    //插入
    int insertCheckstate (Checkstate checkstate);
    //删除
    int delCheckstate (String id);
    //修改
    int updateCheckstate (Checkstate checkstate);
    //查找单个
    Checkstate selectById (String id);
    //模糊多条件查询
    List<Checkstate> search (Checkstate checkstate);
}
