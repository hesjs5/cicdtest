package hello.board.repository;

import hello.board.dto.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentMapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    @DisplayName("전체 부서 수 확인")
    void getTotalDepartmentCountTest() {
        // given
        int expected = 3;

        // when
        int actual = departmentMapper.getTotalDepartmentCount();

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("모든 부서 번호순으로 내림차순 조회")
    void getALlDeptListOrderByNoDescTest() {
        // given
        List<Map<String, Object>> expected = Arrays.asList(
                new HashMap<String, Object>() {{
                    put("loc", "판교");
                    put("dname", "공공사업");
                    put("deptno", 30L);
                }},
                new HashMap<String, Object>() {{
                    put("loc", "부산");
                    put("dname", "해양수산");
                    put("deptno", 20L);
                }},
                new HashMap<String, Object>() {{
                    put("loc", "판교");
                    put("dname", "전략기획");
                    put("deptno", 10L);
                }}
        );

        // when
        List<Map<String, Object>> actual = departmentMapper.getAllDeptListOrderByNoDesc();
        System.out.println("actual = " + actual);

        // then
        assertThat(actual)
                .hasSize(3)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("사원 번호로 사원 정보와 부서 정보 조회")
    void findEmployeeDeptByNoTest() {
        // given
        List<FindEmployeeDeptByNoDTO> expected = Collections.singletonList(
                FindEmployeeDeptByNoDTO.builder()
                        .loc("판교")
                        .ename("제임슨")
                        .dname("전략기획")
                        .build());
        int empno = 1;

        // when
        List<FindEmployeeDeptByNoDTO> actual = departmentMapper.findEmployeeDeptByNo(empno);
        System.out.println("actual = " + actual);

        // then
        assertThat(actual)
                .hasSize(1)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("사원 정보가 있는 모든 부서 정보와 사원 정보를 조회")
    void findAllEmpDeptListTest() {
        // given
        List<FindAllEmpDeptListDTO> expected = Arrays.asList(
                FindAllEmpDeptListDTO.builder()
                        .loc("판교")
                        .ename("제임슨")
                        .empno(1L)
                        .dname("전략기획")
                        .deptno(10L)
                        .build(),
                FindAllEmpDeptListDTO.builder()
                        .loc("판교")
                        .ename("앨리사")
                        .empno(2L)
                        .dname("전략기획")
                        .deptno(10L)
                        .build(),
                FindAllEmpDeptListDTO.builder()
                        .loc("부산")
                        .ename("크림슨")
                        .empno(3L)
                        .dname("해양수산")
                        .deptno(20L)
                        .build());

        // when
        List<FindAllEmpDeptListDTO> actual = departmentMapper.findAllEmpDeptList();
        System.out.println("actual = " + actual);

        // then
        assertThat(actual)
                .hasSize(3)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("사원 정보가 없는 모든 부서 정보와 사원 정보 조회")
    void findAllEmpDeptListOuterJoinTest() {
        // given
        List<FindAllEmpDeptListOuterJoinDTO> expected = Arrays.asList(
                FindAllEmpDeptListOuterJoinDTO.builder()
                        .loc("판교")
                        .ename("앨리사")
                        .empno(2L)
                        .dname("전략기획")
                        .deptno(10L)
                        .build(),
                FindAllEmpDeptListOuterJoinDTO.builder()
                        .loc("판교")
                        .ename("제임슨")
                        .empno(1L)
                        .dname("전략기획")
                        .deptno(10L)
                        .build(),
                FindAllEmpDeptListOuterJoinDTO.builder()
                        .loc("부산")
                        .ename("크림슨")
                        .empno(3L)
                        .dname("해양수산")
                        .deptno(20L)
                        .build(),
                FindAllEmpDeptListOuterJoinDTO.builder()
                        .loc("판교")
                        .ename(null)
                        .empno(null)
                        .dname("공공사업")
                        .deptno(30L)
                        .build());

        // when
        List<FindAllEmpDeptListOuterJoinDTO> actual = departmentMapper.findAllEmpDeptListOuterJoin();
        System.out.println("actual = " + actual);

        // then
        assertThat(actual)
                .hasSize(4)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("부서별 사원 수 조회")
    void getEmpGroupByDeptnoTest() {
        // given
        List<GetEmpGroupByDeptnoDTO> expected = Arrays.asList(
                GetEmpGroupByDeptnoDTO.builder()
                        .deptno(10L)
                        .empCount(2L)
                        .build(),
                GetEmpGroupByDeptnoDTO.builder()
                        .deptno(20L)
                        .empCount(1L)
                        .build());

        // when
        List<GetEmpGroupByDeptnoDTO> actual = departmentMapper.getEmpGroupByDeptno();
        System.out.println("actual = " + actual);

        // then
        assertThat(actual)
                .hasSize(2)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("근무 지역별 평균 연봉 조회")
    void getSalGroupByLocTest() {
        // given
        List<GetSalGroupByLocDTO> expected = Arrays.asList(
                GetSalGroupByLocDTO.builder()
                        .loc("판교")
                        .avgSal(new BigDecimal("400.0000"))
                        .build(),
                GetSalGroupByLocDTO.builder()
                        .loc("부산")
                        .avgSal(new BigDecimal("400.0000"))
                        .build());

        // when
        List<GetSalGroupByLocDTO> actual = departmentMapper.getSalGroupByLoc();
        System.out.println("actual = " + actual);

        // then
        assertThat(actual)
                .hasSize(2)
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("부서별 사원 수와 이름 조회")
    void getEmpGroupByDeptnoTest2() {
        // given
        List<GetEmpGroupByDeptnoDTO2> expected = Arrays.asList(
                GetEmpGroupByDeptnoDTO2.builder()
                        .empCount(2L)
                        .dname("전략기획")
                        .deptno(10L)
                        .build(),
                GetEmpGroupByDeptnoDTO2.builder()
                        .empCount(1L)
                        .dname("해양수산")
                        .deptno(20L)
                        .build());

        // when
        List<GetEmpGroupByDeptnoDTO2> actual = departmentMapper.getEmpGroupByDeptno2();
        System.out.println("actual = " + actual);

        // then
        assertThat(actual)
                .hasSize(2)
                .isEqualTo(expected);
    }
}