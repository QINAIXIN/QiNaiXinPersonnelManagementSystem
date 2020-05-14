package org.javaboy.vhr.service.impl;

import org.javaboy.vhr.mapper.EmployeeecMapper;
import org.javaboy.vhr.model.Appraise;
import org.javaboy.vhr.model.Employeeec;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.model.util.DateUtil;
import org.javaboy.vhr.model.vo.EmployeeecListReqVo;
import org.javaboy.vhr.model.vo.EmployeeecRespVo;
import org.javaboy.vhr.service.EmployeeecService;
import org.javaboy.vhr.model.vo.EmployeeecReqVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
@Service
public class EmployeeecServiceImpl implements EmployeeecService {

    @Autowired
    private EmployeeecMapper employeeecMapper;


    @Override
    public RespPageBean list(Integer page,Integer size) {
        List<EmployeeecRespVo> respVoList = new ArrayList<>();
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employeeec> list = employeeecMapper.getPage(page, size);
        list.forEach(item->{
            EmployeeecRespVo respVo = new EmployeeecRespVo();
            BeanUtils.copyProperties(item,respVo);
            respVo.setEcdate(DateUtil.formatDate(item.getEcdate(),"yyyy-MM-dd"));
            respVoList.add(respVo);
        });
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(respVoList);
        respPageBean.setTotal(employeeecMapper.getTotal());
        return respPageBean;
    }


    @Override
    public void add(EmployeeecReqVo employeeecReqVo) {
        Employeeec employeeec = new Employeeec();
        BeanUtils.copyProperties(employeeecReqVo,employeeec);
        employeeecMapper.insertSelective(employeeec);
    }

    @Override
    public void update(EmployeeecReqVo employeeecReqVo) {
        Employeeec employeeec = new Employeeec();
        BeanUtils.copyProperties(employeeecReqVo,employeeec);
        employeeecMapper.updateByPrimaryKeySelective(employeeec);
    }

    @Override
    public void delete(Integer id) {
        employeeecMapper.deleteByPrimaryKey(id);
    }


}
