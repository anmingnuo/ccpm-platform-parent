package edu.zut.chz.system.mapper;

import java.util.List;
import edu.zut.chz.system.domain.Direction;
import edu.zut.chz.system.domain.Major;

/**
 * 专业方向Mapper接口
 * 
 * @author anmingnuo
 * @date 2024-05-02
 */
public interface DirectionMapper 
{
    /**
     * 查询专业方向
     * 
     * @param id 专业方向主键
     * @return 专业方向
     */
    public Direction selectDirectionById(Long id);

    /**
     * 查询专业方向列表
     * 
     * @param direction 专业方向
     * @return 专业方向集合
     */
    public List<Direction> selectDirectionList(Direction direction);

    /**
     * 新增专业方向
     * 
     * @param direction 专业方向
     * @return 结果
     */
    public int insertDirection(Direction direction);

    /**
     * 修改专业方向
     * 
     * @param direction 专业方向
     * @return 结果
     */
    public int updateDirection(Direction direction);

    /**
     * 删除专业方向
     * 
     * @param id 专业方向主键
     * @return 结果
     */
    public int deleteDirectionById(Long id);

    /**
     * 批量删除专业方向
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDirectionByIds(Long[] ids);



}
