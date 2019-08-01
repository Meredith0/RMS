package rms.demo.utils;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import rms.demo.enums.GenderEnum;

/**
 * @author : Meredith
 * @date : 2019-07-31 21:18
 * @description : 性别枚举处理
 */
public class GenderEnumUtil extends BaseTypeHandler<String> {


    @Override
    public void setNonNullParameter (PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
        throws SQLException {

    }

    @Override
    public String getNullableResult (ResultSet rs, String columnName) throws SQLException {
        return rs.wasNull()? null: GenderEnum.genderOf(rs.getInt(columnName));
    }

    @Override
    public String getNullableResult (ResultSet rs, int columnIndex) throws SQLException {
        return rs.wasNull()? null: GenderEnum.genderOf(rs.getInt(columnIndex));

    }

    @Override
    public String getNullableResult (CallableStatement cs, int columnIndex) throws SQLException {
        return cs.wasNull()? null: GenderEnum.genderOf(cs.getInt(columnIndex));

    }

}
