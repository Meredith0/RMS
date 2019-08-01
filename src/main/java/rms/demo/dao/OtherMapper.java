package rms.demo.dao;
import java.util.List;
import org.apache.ibatis.annotations.Select;

public interface OtherMapper {

    int insertUser_Role (String userid, String roleid);

    int updateUser_Role (String userid, String roleid);

    int deleteUser_RoleByUserid (String id);

    int deleteTest (int id);

    List<String> ageReport ();

    int atworkCount ();

    @Select ("SELECT count(*) FROM checkstate WHERE late=1;")
    int lateCount ();

    @Select ("SELECT count(*) FROM checkstate WHERE early=1;")
    int earlyCount ();

    int noAtWorkReport ();

}
