package hello.board.repository;

import hello.board.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DepartmentMapper {

    int getTotalDepartmentCount();

    List<Map<String, Object>> getAllDeptListOrderByNoDesc();

    List<FindEmployeeDeptByNoDTO> findEmployeeDeptByNo(int empno);

    List<FindAllEmpDeptListDTO> findAllEmpDeptList();

    List<FindAllEmpDeptListOuterJoinDTO> findAllEmpDeptListOuterJoin();

    List<GetEmpGroupByDeptnoDTO> getEmpGroupByDeptno();

    List<GetSalGroupByLocDTO> getSalGroupByLoc();

    List<GetEmpGroupByDeptnoDTO2> getEmpGroupByDeptno2();
}
