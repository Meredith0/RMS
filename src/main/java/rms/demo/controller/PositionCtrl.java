package rms.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rms.demo.domain.Position;
import rms.demo.exception.BaseException;
import rms.demo.service.PositionService;

/**
 * @author : Meredith
 * @date : 2019-07-26 23:21
 * @description : 职位管理模块 需要dept权限
 */
@RestController
@RequestMapping ("/position")
@PreAuthorize ("hasAnyAuthority('admin','dept')")
public class PositionCtrl {


    @Autowired
    private PositionService positionService;

    //状态码
    @ResponseStatus(HttpStatus.NO_CONTENT) //204
    @RequestMapping(value = "/position", method = RequestMethod.POST)
    //增加职位
    public void addPosition(Position position) throws Exception
    {
        if (!positionService.addPosition(position))
        {
            throw new Exception("insert into Position fail");
        }
    }
    //查询所有职位

    @RequestMapping (value = "/position", method = RequestMethod.GET)
    //@ResponseBody
    public List<Position> selectALL () throws Exception {

        if (positionService.findPositionAll() != null) {
            return positionService.findPositionAll();
        } else {
            throw new BaseException(500, "select position failed");
        }
    }
    //按职位名称模糊查询
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public List<Position> selectChoose(String name) throws Exception
    {
        if (positionService.findPositionAll() != null)

            return positionService.findPositionByName(name);
        else {
            throw new BaseException(500, "select position failed");
        }

    }
    //删除职位
    //状态码
    @ResponseStatus(HttpStatus.NO_CONTENT) //204
    @RequestMapping(value = "/position", method = RequestMethod.DELETE)
    public void deletePosition(int id) throws Exception
    {
        if (!positionService.deletePositon(id))
        {
            throw new Exception("delete Position fail");
        }
    }

    //修改职位
    //状态码
    @ResponseStatus (HttpStatus.NO_CONTENT) //204
    @RequestMapping(value = "/position", method = RequestMethod.PUT)
    //增加职位
    public void updatePosition(Position position) throws Exception
    {
        if (!positionService.updatePosition(position))
        {
            throw new Exception("update Position fail");
        }

    }

}
