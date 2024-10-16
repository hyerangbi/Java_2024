/*
    *서브쿼리
    - 하나의 SQL문 안에 포함된 또 다른 SELECT 문
    - 메인 SQL문을 위해 보조 역할을 하는 쿼리 
*/

-- 노옹철 사원과 같은 부서에 속한 사원들 조회

SELECT EMP_NAME FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- 노옹철사원은 어떤부서일까 ?
SELECT DEPT_CODE FROM EMPLOYEE 
WHERE EMP_NAME = '노옹철';

-- 위에 두 쿼리를 하나의 쿼리로 변경하자
SELECT EMP_NAME FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE FROM EMPLOYEE 
                   WHERE EMP_NAME = '노옹철');

-- 서브쿼리 예시2)
-- 전 직원의 평균급여보다 더 많은 급여를 받는 사원들의 사번, 이름, 직급코드, 급여조회
-- 1) 전 직원의 평균급여
SELECT AVG(SALARY) FROM EMPLOYEE;

-- 2) 3047663 원 보다 급여가 많은 사람들의 사번, 이름, 직급코드, 급여 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE
WHERE SALARY >= 3046623;

-- 두 쿼리를 하나로 합해보자.
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE
WHERE SALARY >= (SELECT AVG(SALARY) FROM EMPLOYEE);

/*
    ? 서브쿼리의 구분
    서브쿼리를 수행한 결과 값이 몇행 몇열로 나오느냐에 따라서 분류
    
    -- 단일행 서브쿼리 : 서브쿼리의 조회 결과 값이 오로지 1개일 때
    -- 다중행 서브쿼리 : 서브쿼리의 조회 결과 값이 여러 행일 때 (여러 행 한 열)
    -- 다중열 서브쿼리 : 서브쿼리의 조회 결과 값이 한 행이지만 컬럼이 여러 개일때
    -- 다중 행 다중 열 서브 쿼리 : 서브쿼리의 조회 결과 값이 여러 행 여러 컬럼 일 때
    
    >> 서브쿼리의 결과 값에 따라서 서브쿼리 앞 쪽에 연산자가 달라진다.
*/

/*
    1. 단일행 서브쿼리
    서브쿼리의 조회 결과 값이 오로지 1개일 때 (한행 한열)
    일반 비교연산자 사용가능
    = != > <= ...
*/

-- 1.1) 전 직원의 평균 급여보다 급여를 더 적게받는 사원들의 사원 명, 직급코드, 급여조회
SELECT EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE
WHERE SALARY < (SELECT AVG(SALARY) FROM EMPLOYEE);

-- 1.2) 최저급여를 받는 사원의 사번, 이름, 급여, 입사 일 조회
SELECT EMP_ID, EMP_ID, SALARY, HIRE_DATE FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY FROM EMPLOYEE);


-- 1.3) 노옹철 사원의 급여보다 많이 받는 사원들의 사번, 이름, 부서코드, 급여조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME = '노옹철');


-- 1.4) 노옹철 사원의 급여보다 많이 받는 사원들의 사번, 이름, 부서명, 급여조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
WHERE SALARY > (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME = '노옹철');

-- 1.5) 부서별 급여합이 가장 큰 부서의 부서코드 급여 합
    -- 1.5.1)부서별 급여 합 가장 큰 부서
    SELECT MAX(SUM(SALARY)) FROM EMPLOYEE GROUP BY DEPT_CODE;
    -- 1.5.2) 급여합이 17700000 원인 부서코드, 급여 합
    SELECT DEPT_CODE, SUM(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE HAVING SUM(SALRY) = 17700000;
    
    -- 1.5.3) 두 쿼리 합치기
    SELECT DEPT_CODE, SUM(SALARY) FROM EMPLOYEE
    GROUP BY DEPT_CODE HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY)) FROM EMPLOYEE GROUP BY DEPT_CODE);

-- 1.6) '전지연'사원과 같은 부서의 사람들의 사번, 사원 명, 전화번호, 입사일, 부서명 조회 (단, 전지연사원 제외)
SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE, DEPT_TITLE FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE DEPT_CODE = (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME = '전지연')
AND EMP_NAME != '전지연';

--=============================================================================
--------------- · -----------------*--- .· -------'----------------------------
--=============================================================================
/*
    2. 다중행 서브쿼리
        서브쿼리를 수행한 결과 값이 여러 행일 때 (컬럼은 한 개)
    IN(서브쿼리) : 여러 개의 결과 값 중에서 한 개라도 일치하는 값이 있다면 조회
    > ANY (서브쿼리) : 여러 개의 결과 값 중에서 한 개라도 클 경우 조회
    < ANY (서브쿼리) : 여러 개의 결과 값 중에서 한 개라도 작을 경우 조회
       비교대상 > ANY (서브쿼리의 결과 값 -> 값1, 값2, 값3 ...)
       
    > ALL(서브쿼리) : 여러 개의 모든 결과 값들보다 클 경우 조회
    < ALL(서브쿼리) : 여러 개의 모든 결과 값들보다 작을 경우 조회
*/

-- 2.1) 유재식 또는 윤은해 사원과 같은 직급인 사원들의 사번, 사원 명, 직급코드, 급여 조회
-- 2.1.1)유재식 또는 윤은해 사원의 직급
SELECT JOB_CODE FROM EMPLOYEE
WHERE EMP_NAME IN ('유재식', '윤은해');

-- 2.1.2) 직급이 J3, J7인 사원들의 사번, 사원 명, 직급코드, 급여조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE
WHERE JOB_CODE IN ('J3','J7');

-- 2.1.3 ) 두 쿼리 합치기
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE
WHERE JOB_CODE IN (SELECT JOB_CODE FROM EMPLOYEE WHERE EMP_NAME IN ('유재식', '윤은해'));


-- 2.2) 대리직급임에도 과장 직급 급여들 중 최소 급여보다 많이 받는 사원들의 사번, 이름, 직급, 급여조회
-- 2.2.1) 과장 직급 급여
SELECT SALARY FROM EMPLOYEE 
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장';

-- 2.2.2) 대리직급이면서 위의 결과 값보다 하나라도 큰 사원
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리' AND SALARY > ANY(3760000, 2200000, 2500000);

-- 2.2.3) 두 쿼리 합치기
SELECT EMP_ID, EMP_NAME, SALARY FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리' AND  SALARY > ANY(SELECT SALARY FROM EMPLOYEE 
                                         JOIN JOB USING(JOB_CODE)
                                         WHERE JOB_NAME = '과장');

--=============================================================================
--------------- · -----------------*--- .· -------'----------------------------
--=============================================================================
/*
    3. 다중 열 서브 쿼리
    결과 값은 한 행이지만 나열된 컬럼 수가 여러 개일 경우
*/

-- 3.1) 하이유 사원과 같은 부서코드, 같은 직급코드에 해당하는 사원들 조회(사원 명, 부서코드, 직급코드, 입사일)

-- 3.1.1) 단일행 서브쿼리
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME = '하이유')
    AND JOB_CODE = (SELECT JOB_CODE FROM EMPLOYEE WHERE EMP_NAME = '하이유');

-- 3.1.2) 다중열 서브쿼리
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE WHERE EMP_NAME = '하이유');


-- 3.2) 박나라 사원과 같은 직급코드, 같은 사수를 가지고 있는 사원들의 사번, 사원 명, 직급코드, 사수번호
SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID FROM EMPLOYEE
WHERE (JOB_CODE, MANAGER_ID) = (SELECT JOB_CODE, MANAGER_ID FROM EMPLOYEE WHERE EMP_NAME ='박나라')
AND EMP_NAME != '박나라';

--=============================================================================
--------------- · -----------------*--- .· -------'----------------------------
--=============================================================================

/*
    4. 다중행 다중열 서브쿼리
    서브쿼리의 조회 결과값이 여러 행 여러 열일 경우
*/

-- 4.1) 각 직급 별 최소 급여를 받는 사원 조회 (사번, 사원 명, 직급코드, 급여)
-- 4.1.1) 각 직급별 최소 급여
SELECT JOB_CODE, MIN(SALARY) FROM EMPLOYEE
GROUP BY JOB_CODE;

-- 4.1.2) 각 직급별 최소 급여를 받는 사원 조회 (사번, 사원 명, 직급코드, 급여)
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE
WHERE JOB_CODE = 'J2' AND SALARY = 3700000
    OR JOB_CODE = 'J7' AND SALARY = 1380000
    OR JOB_CODE = 'J3' AND SALARY = 3400000
    OR JOB_CODE = 'J6' AND SALARY = 2000000
    OR JOB_CODE = 'J5' AND SALARY = 2200000
    OR JOB_CODE = 'J1' AND SALARY = 8000000
    OR JOB_CODE = 'J4' AND SALARY = 1550000;

-- 4.1.3) 서브쿼리 이용
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, MIN(SALARY) FROM EMPLOYEE
                             GROUP BY JOB_CODE);
                             
-- 5.1) 각 부서별 최고 급여를 받는 사원들의 사번, 사원 명, 부서코드, 급여
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY FROM EMPLOYEE
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, MAX(SALARY) FROM EMPLOYEE   
                              GROUP BY DEPT_CODE);

--=============================================================================
--------------- · -----------------*--- .· -------'----------------------------
--=============================================================================

--1. 부서 별 급여 합계가 전체 급여 총 합의 20%보다 많은 부서의 부서 명, 부서 별 급여 합계 조회
SELECT DEPT_TITLE, SUM(SALARY) FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) > (SELECT SUM(SALARY) * 0.2 FROM EMPLOYEE);

--2. 나이 상 가장 막내의 사원 코드, 사원 명, 나이, 부서 명, 직급 명 조회
SELECT EMP_ID, EMP_NAME, 
    EXTRACT (YEAR FROM SYSDATE) -
    CASE
        WHEN SUBSTR(EMP_NO,1,2) <= TO_CHAR(SYSDATE, 'YY')
            THEN (2000 + SUBSTR(EMP_NO,1,2))
        ELSE 
            (1900 + SUBSTR(EMP_NO,1,2))
    END + 1 AS "나이"
, DEPT_TITLE, JOB_NAME FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
JOIN JOB USING (JOB_CODE)
WHERE EXTRACT(YEAR FROM SYSDATE) -
    CASE
        WHEN SUBSTR(EMP_NO,1,2) <= TO_CHAR(SYSDATE, 'YY')
            THEN (2000 + SUBSTR(EMP_NO,1,2))
        ELSE 
            (1900 + SUBSTR(EMP_NO,1,2))
    END  = (SELECT MIN(EXTRACT(YEAR FROM SYSDATE) -
                            CASE 
                                WHEN SUBSTR(EMP_NO,1,2) <= TO_CHAR(SYSDATE, 'YY')
                                    THEN (2000 + SUBSTR(EMP_NO,1,2))
                                ELSE 
                                (1900 + SUBSTR(EMP_NO,1,2))
                            END) FROM EMPLOYEE);

--=============================================================================
--------------- · -----------------*--- .· -------'----------------------------
--=============================================================================
/*
    5. 인라인 뷰
    FROM 절에 서브쿼리를 작성하는 것
    서브쿼리를 수행한 결과를 마치 테이블처럼 사용
*/

-- 5.1 사원들의 사번, 이름, 보너스 포함 연봉, 부서코드 조회
-- 단, 보너스 포함 연봉은 NULL이 되면 안된다.
-- 단, 보너스 포함 연봉이 3000만원 이상인 사원들만 조회

/* ROWNUM : 오라클에서 제공하는 컬럼, 조회된 순서대로 1부터 순번을 부여한다.*/
SELECT EMP_ID, EMP_NAME, (SALARY + (SALARY * NVL(BONUS,0))) * 12  연봉, DEPT_CODE FROM EMPLOYEE
WHERE (SALARY + (SALARY * NVL(BONUS,0))) * 12  >= 30000000
ORDER BY 연봉 DESC;

-- 5.2 전 직원 중 급여가 가장 높은 5명만 조회
SELECT ROWNUM, EMP_ID, EMP_NAME, (SALARY + (SALARY * NVL(BONUS,0))) * 12 FROM EMPLOYEE
WHERE ROWNUM <= 5
ORDER BY SALARY DESC;

/* 인라인뷰를 주로 사용하는 예>> TOP-N 분석 : 상위 몇 개만 조회
    ORDER BY절이 수행된 결과를 가지고 ROWNUM부여 -> 상위 5명 조회 */
-- 5.3 ORDER BY절이 수행된 결과를 가지고 ROWNUM부여 -> 상위 5명 조회
SELECT ROWNUM, EMP_NAME, SALARY FROM(SELECT EMP_NAME, SALARY FROM EMPLOYEE ORDER BY SALARY DESC)
WHERE ROWNUM <= 5;

-- 5.4 가장 최근에 입사한 사원 5명 조회 (사원 명, 급여, 입사일)
SELECT ROWNUM, EMP_NAME, SALARY ,HIRE_DATE FROM(SELECT EMP_NAME, SALARY, HIRE_DATE FROM EMPLOYEE
                                         ORDER BY HIRE_DATE DESC)
WHERE ROWNUM <=5;

-- 부서 별 평균 급여가 높은 3개의 부서 조회
SELECT ROWNUM,DEPT_CODE ,AVG(SALARY) AS "평균급여"
FROM (SELECT DEPT_CODE, AVG(SALARY) 
        FROM EMPLOYEE 
        GROUP BY DEPT_CODE ORDER BY AVG(SALARY) DESC)
WHERE ROWNUM <=3;

/*
    * 순위를 매기는 함수 (WINDOW FUNCTION)
    RANK() OVER(정렬기준) | DENSE_RANK() OVER(정렬기준)
    RANK() OVER(정렬기준) : 동일한 순위 이후의 등수를 동일한 인원 수만큼 건너뛰고 순위계산
    DANSE_RANK() OVER(정렬기준) : 동일한 순위가 있다고 해도 그 다음 등수를 무조건 1씩 증가
*/

-- 급여가 높은 순서대로 순위를 매겨서 조회
SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC ) AS "순위" FROM EMPLOYEE;

SELECT EMP_NAME, SALARY, DENSE_RANK() OVER(ORDER BY SALARY DESC) AS "순위" FROM EMPLOYEE;

SELECT * FROM (SELECT EMP_NAME, SALARY, RANK() OVEr(ORDER BY SALARY DESC) AS "순위" FROM EMPLOYEE) 
WHERE 순위 <=5;













