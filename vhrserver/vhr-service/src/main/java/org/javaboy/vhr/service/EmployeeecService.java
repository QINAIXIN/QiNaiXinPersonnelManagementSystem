package org.javaboy.vhr.service;

import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.model.vo.EmployeeecListReqVo;
import org.javaboy.vhr.model.vo.EmployeeecReqVo;

public interface EmployeeecService {
    void add(EmployeeecReqVo employeeecReqVo);

    void update(EmployeeecReqVo employeeecReqVo);

    void delete(Integer id);

    RespPageBean list(Integer page,Integer size);
}
