package org.javaboy.vhr.service;

import org.javaboy.vhr.model.Employeetrain;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.model.vo.EmployeeTrainListReqVo;
import org.javaboy.vhr.model.vo.EmployeeTrainReqVo;

public interface EmployeeTrainService {

    void delete(Integer id);

    void add(Employeetrain employeetrain);

    void update(EmployeeTrainReqVo employeeTrainReqVo);

    RespPageBean list(Integer page,Integer size);
}
