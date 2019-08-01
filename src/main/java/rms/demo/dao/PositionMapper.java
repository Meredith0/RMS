package rms.demo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import rms.demo.domain.Position;
import rms.demo.domain.PositionExample;

public interface PositionMapper {

    @Select("SELECT count(*) FROM position WHERE pid=#{pid}")
    int validatePid (int pid);

    int countByExample (PositionExample example);

    int deleteByExample (PositionExample example);

    int deleteByPrimaryKey (Integer pid);

    int insert (Position record);

    int insertSelective (Position record);

    List<Position> selectByExample (PositionExample example);

    Position selectByPrimaryKey (Integer pid);

    int updateByExampleSelective (@Param ("record") Position record, @Param ("example") PositionExample example);

    int updateByExample (@Param ("record") Position record, @Param ("example") PositionExample example);

    int updateByPrimaryKeySelective (Position record);

    int updateByPrimaryKey (Position record);

}
