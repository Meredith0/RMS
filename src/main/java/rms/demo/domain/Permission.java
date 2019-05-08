package rms.demo.domain;

import javax.persistence.Table;
import lombok.Data;

/**
 * @author : Meredith
 * @date : 2019-05-07 12:20
 * @description :
 */
@Data
@Table(name="permission")
public class Permission {

    private String permissionId;
    private String permissionName;
    private String permissionInfo;
}
