package rms.demo.dao;
public interface OtherMapper {

    int insertUser_Role (String userid,String roleid);

    int updateUser_Role (String userid, String roleid);

    int deleteUser_RoleByUserid (String id);
}
