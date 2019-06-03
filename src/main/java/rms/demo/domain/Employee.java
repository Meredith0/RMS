package rms.demo.domain;

import java.sql.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private Integer id;

    private String name;

    private Date date;

    private String address;

}