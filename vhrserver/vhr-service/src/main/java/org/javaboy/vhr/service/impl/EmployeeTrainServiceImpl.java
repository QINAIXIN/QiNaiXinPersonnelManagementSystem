package org.javaboy.vhr.service.impl;

import org.javaboy.vhr.mapper.EmployeetrainMapper;
import org.javaboy.vhr.model.Employeetrain;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.model.util.DateUtil;
import org.javaboy.vhr.model.vo.EmployeeTrainReqVo;
import org.javaboy.vhr.model.vo.EmployeeTrainRespVo;
import org.javaboy.vhr.service.EmployeeTrainService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
@Service
public class EmployeeTrainServiceImpl implements EmployeeTrainService {

    @Autowired
    private EmployeetrainMapper employeetrainMapper;


    @Override
    public RespPageBean list(Integer page,Integer size) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<EmployeeTrainRespVo> resultList = new ArrayList();
        List<Employeetrain> list = employeetrainMapper.getPage(page, size);
        list.forEach(item->{
            EmployeeTrainRespVo respVo = new EmployeeTrainRespVo();
            BeanUtils.copyProperties(item,respVo);
            respVo.setTraindate(DateUtil.formatDate(item.getTraindate(),"yyyy-MM-dd"));
            resultList.add(respVo);
        });
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(resultList);
        respPageBean.setTotal(employeetrainMapper.getTotal());
        return respPageBean;
    }

    @Override
    public void delete(Integer id) {
        employeetrainMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void add(Employeetrain employeetrain) {
        employeetrainMapper.insertSelective(employeetrain);
    }

    @Override
    public void update(EmployeeTrainReqVo employeeTrainReqVo) {
        Employeetrain employeetrain = new Employeetrain();
        BeanUtils.copyProperties(employeeTrainReqVo,employeetrain);
        employeetrainMapper.updateByPrimaryKeySelective(employeetrain);
    }



}
