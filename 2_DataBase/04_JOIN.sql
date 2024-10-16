/*
    <JOIN>
    두 개 이상의 테이블에서 데이터를 조회하고자 할 때 사용되는 구문
    조회 결과는 하나의 결과(RESULT SET)를 반환한다.
    
    관계형 데이터베이스에서는 최소한의 데이터를 각각의 테이블에 담고있다.
    (무작정 다 조회해 오는게 아니라 각 테이블간 연결고리(외래키)를 통해 데이터를 매칭시켜 조회해야한다)
    
    JOIN은 크게 "오라클 전용구문" "ANSI 구문"
    
    [용어정리]
    
                오라클 전용구문              |            ANSI 구문    
    ---------------------------------------------------------------------------
                   등가조인                 |             내부조인
                (EQUAL JOIN)               |    (INDER JOIN → JOIN JSING/ON)
    ---------------------------------------------------------------------------
                   포괄조인                 |             외부조인
                LEFT, RIGHT                |        LEFT, RIGHT, FULL
    ---------------------------------------------------------------------------
                   자체조인                 |             JOIN ON
                 비 증가 조인               |
*/

-- 전체 사원들의 사번, 사원 명, 부서코드 , 부서명
SELECT EMP_ID, EMP_NAME, DEPT_CODE FROM EMPLOYEE;

SELECT DEPT_ID, DEPT_CODE FROM DEPARTMENT;

/*
    1. 등가조인(EQUAL JOIN) / 내부조인(INNER JOIN)
     연결 시키는 컬럼의 값이 일치하는 행들만 조회(일치하는 값이 없는 행은 조회 제외)
*/

-----> ANSI 구문
-- FROM 절에 기준이 되는 테이블 하나 기술
-- JOIN절에 같이 조인하고자 하는 테이블 기술 + 매칭시킬 컬럼에 대한 조건
-- JOING USING / JOIN ON

-- 1. 연결할 두 컬럼 명이 다른 경우(EMPLOYEE : DEPT_CODE / DEPARTMENT : DEPT_ID)
-- JOIN ON
-- 전체 사원들의 사번, 사원 명, 부서코드 , 부서명
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);


-- 1. 연결할 두 컬럼명이 동일한 경우
-- 전체 사원들의 사번, 사원 명, 직급코드, 직급명
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E JOIN JOB J  ON (E.JOB_CODE = J.JOB_CODE);

--JOIN USING (연결하는 컬럼명이 같은 경우에만 가능)
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE JOIN JOB USING (JOB_CODE);

--> 오라클 전용구문
-- FROM 절에 조회하고자 하는 테이블들 나열(, 로 구분)
-- WHERE 절에 매칭 시킬 컬럼에 대한 조건을 제시
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;

SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE E,JOB J
WHERE E.JOB_CODE = J.JOB_CODE;

-- 추가적인 조건 제시
-- 직급이 대리인 사원의 사번, 사원 명, 직급 명, 급여 조회
-- 오라클
SELECT EMP_ID, EMP_NAME, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE
AND JOB_NAME = '대리';


-- ANSI
SELECT EMP_ID, EMP_NAME, JOB_NAME
FROM EMPLOYEE JOIN JOB USING(JOB_CODE)
WHERE J.JOB_NAME = '대리';

--=================================실습==================================
-- 1. 부서가 인사관리부인 사원들의 사번, 이름, 보너스 조회
SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE = '인사관리부';


-- 2. DEPARTMENT 와 LOCATION 테이블을 참고하여 전체 부서의 부서코드, 부서명, 지역코드, 지역명 조회
SELECT DEPT_ID, DEPT_TITLE, LOCAL_CODE, LOCAL_NAME  
FROM DEPARTMENT JOIN location ON(LOCATION_ID = LOCAL_CODE);

-- 3. 보너스를 받는 사원들의 사번, 사원 명, 보너스, 부서 명 조회
SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE BONUS IS NOT NULL;


-- 4. 부서가 총무부가아닌 사원들의 사원 명, 급여 조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE != '총무부';

--=============================================================================
-------?-------- · -----------------*--- .· -------'----------------------------
--=============================================================================
/*
    2. 포괄조인 / 외부조인(OUTER JOIN)
    두 테이블 간의 JOIN시 일치하지 않는 행도 포함시켜 조회 가능
    단, 반드시 LEFT/RIGHT 를 지정해야한다. (어떤 테이블이 기준인지 @)
*/

-- 외부조인과 비교할만한 내부조인
-- 사원 명, 부서 명, 급여, 연봉
-- 부서배치를 받지 않은 2명의 사원 정보 누락 됨

-- 1) LEFT [OUTER] JOIN : 두 테이블 중 왼편에 기술된 테이블을 기준으로 JOIN
-- ANSI 
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY*12 FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

-- 오라클
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY*12 FROM EMPLOYEE
WHERE DEPT_CODE = DEPT_ID(+);


-- 2) RIGHT [OUTER] JOIN : 두 테이블 중 오른편에 기술된 테이블을 기준으로 JOIN
-- ANSI
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12 FROM EMPLOYEE
RIGHT JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE);

-- 오라클 
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY*12 FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;


-- 3) FULL [OUTER] JOIN : 두 테이블이 가진 모든 행을 조회할 수 있다.
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY*12
FROM EMPLOYEE
FULL JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

--=============================================================================
-------?-------- · -----------------*--- .· -------'----------------------------
--=============================================================================

/*
    3. 등가조인
    매칭시킬 컬럼에 대한 조건 자것잇 '=' 를 사용하지 않는 조인문
    ANSI 구문 사용 시 JOIN ON만 사용가능
*/

-- 사원 명, 급여, 급여 레벨 조회
-- ANSI
SELECT EMP_NAME, SALARY, SAL_LEVEL FROM EMPLOYEE 
JOIN SAL_GRADE ON (SALARY >= MIN_SAL AND SALARY <=MAX_SAL);

-- 오라클
SELECT EMP_NAME, SALARY, SAL_LEVEL FROM EMPLOYEE, SAL_GRADE
WHERE SALARY BETWEEN MIN_SAL AND MAX_SAL;

--=============================================================================
-------?-------- · -----------------*--- .· -------'----------------------------
--=============================================================================

/*
    4. 자체조인
    같은 테이블을 다시 한번 조인하는 경우
*/

-- 전체 사원의 사원 사번, 사원 명, 사원부서코드 ?→ EMPLOYEE E
--            사수 사번, 사수 명, 사수부서코드 ?→ EMPLOYEE M
-- ANSI
SELECT E.EMP_ID, E.EMP_NAME, E.DEPT_CODE,
       M._EMP_ID, M.EMP_NAME, M.DEPT_CODE
FROM EMPLOYEE E
LEFT JOIN EMPLOYEE M ON (E.MANAGER_ID = M.EMP_ID);

-- 오라클
SELECT E.EMP_ID, E.EMP_NAME, E.DEPT_CODE,
       M._EMP_ID, M.EMP_NAME, M.DEPT_CODE
FROM EMPLOYEE E, EMPLOYEE M
WHERE E.MANAGR_ID = M.EMP_ID;

--=============================================================================
-------?-------- · -----------------*--- .· -------'----------------------------
--=============================================================================
/*
    <다중조인>
    2개 이상의 테이블을 가지고 JOIN 할 수 있다.
*/

-- 사번, 사원 명, 직급명
--ANSI
SELECT EMP_ID, EMP_NAME, DEPT_CODE ,JOB_NAME FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE);

-- ORACLE
SELECT EMP_ID, EMP_NAME, DEPT_CODE ,JOB_NAME FROM EMPLOYEE E, DEPARTMENT, JOB J
WHERE E.DEPT_CODE = DEPT_ID
AND E.JOB_CODE = J.JOB_CODE;

-- 사번, 사원 명, 부서 명, 지역 명 조회
SELECT * FROM EMPLOYEE; -- DEPT_CODE
SELECT * FROM DEPARTMENT; --DEPT_ID     LOCATION_ID
SELECT * FROM LOCATION;               -- LOCAL_CODE

-- ANSI
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATKON_ID = LOCA_LODE);

--=================================실습==========================================
-- 1. 사번 , 사원 명, 부서 명, 지역 명, 국가 명 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);


-- 2. 사번 , 사원 명 , 부서 명, 직급 명 , 지역 명, 국가 명, 급여등급 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, LOCAL_NAME, NATIONAL_NAME, SAL_LEVEL FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
JOIN LOCATION ON (LOCAL_CODE = LOCATION_ID)
JOIN NATIONAL USING (NATIONAL_CODE)
JOIN SAL_GRADE ON (SALARY BETWEEN MIN_SAL AND MAX_SAL);










