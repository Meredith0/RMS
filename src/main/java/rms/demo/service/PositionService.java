package rms.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rms.demo.dao.PositionMapper;
import rms.demo.domain.Position;
import rms.demo.domain.PositionExample;

/**
 * @author : Meredith
 * @date : 2019-07-29 08:46
 * @description :
 */

@Service
public class PositionService {

    @Autowired
    private PositionMapper positionMapper;

    //添加职位
    public boolean addPosition(Position po)
    {
        int result = positionMapper.insert(po);
        if (result > 0)
        {
            return true;
        } else
        {
            return false;
        }
    }


    public List<Position> findPositionAll()
    {
        PositionExample po=new PositionExample();
        List<Position> list = positionMapper.selectByExample(po);
        if (list != null)
        {
            return list;
        } else
        {
            return null;
        }
    }


    public List<Position> findPositionByName(String name)
    {
        PositionExample example = new PositionExample();
        PositionExample.Criteria criteria = example.createCriteria();
        criteria.andPnameLike("%"+name+"%");
        List<Position> list = positionMapper.selectByExample(example);
        if (list != null)
        {
            return list;
        }
        return null;
    }


    public boolean deletePositon(Integer id)
    {
        int result = positionMapper.deleteByPrimaryKey(id);
        if (result > 0)
        {
            return true;
        }
        return false;
    }


    public boolean updatePosition(Position po)
    {
        int result = positionMapper.updateByPrimaryKey(po);
        if (result > 0)
        {
            return true;
        } else
            return false;
    }
}
