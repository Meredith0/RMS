package rms.demo.enums;
/**
 * @author : Meredith
 * @date : 2019-07-26 09:28
 * @description : 用户角色的枚举
 */
public enum RoleEnum {

    ADMIN("管理员","admin"),
    EMPLOYEE("员工","employee"),
    DEPT_MANAGER("部门经理", "dept");

    String auth;
    String dbAuth;

    RoleEnum (String auth, String dbAuth) {
        this.auth = auth;
        this.dbAuth = dbAuth;
    }


}
