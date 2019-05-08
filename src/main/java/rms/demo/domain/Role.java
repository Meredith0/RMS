package rms.demo.domain;

import javax.persistence.Table;
import lombok.Data;

/**
 * @author : Meredith
 * @date : 2019-05-07 12:12
 * @description :
 */
@Data
@Table(name="role")
public class Role {
    private Integer userId;
    private Integer roleId;

}
