package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.EmployeeMapper;
import org.javaboy.vhr.mapper.NationMapper;
import org.javaboy.vhr.model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NationService {

    @Autowired
    NationMapper nationMapper;


    @Autowired
    private EmployeeMapper employeeMapper;


    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }

    public List<Nation> getAllEmpNos() {
        return employeeMapper.getEmployeeAll();
    }
}
