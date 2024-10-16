/*
    <GROUP BY절>
     그룹기준을 제시할 수 있는 구문(해당 그룹 기준 별로 여러 그룹으로 묶을 수 있음)
     여러 개의 값들을 하나의 그룹으로 묶어서 처리하는 목적으로 사용
*/

SELECT SUM(SALARY) FROM EMPLOYEE;  -- 전체 사원을 하나의 그룹으로 묶어서 총 합을 구한 것

-- 각 부서별로 급여 총 합
-- 각 부서들이 전부 그룹
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 각 부서별 사원 수
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT DEPT_CODE, COUNT(*), SUM(SALARY)     -- 3
FROM EMPLOYEE                               -- 1
GROUP BY DEPT_CODE                          -- 2
ORDER BY DEPT_CODE;                         -- 4 ORDER BY 무조건 마지막실행
                                            --   → 정렬은 마지막애 해주는 것이 아니면 의미 X
-- 각 직급별 총 사원 수, 보너스를 받는 사람 수, 급여 합, 평균 급여, 최저 급여, 최고 급엽, ( 정렬 ⇒ 오름차순)
SELECT JOB_CODE AS "직급",
       COUNT(*) AS "사원 수", 
       COUNT(BONUS) AS "보너스를 받는 사람",
       SUM(SALARY) AS "급여 합",
       ROUND (AVG(SALARY)) AS "급여 평균",
       MIN (SALARY) AS "최저 급여",
       MAX (SALARY) AS "최고 급여"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;


-- GROUP BY 절에 함수 식 사용 가능
SELECT DECODE(SUBSTR(EMP_NO, 8,1), '1','남','2','여'), COUNT(*)
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO, 8, 1);

-- GROUP BY절에 여러 컬럼을 기술할 수 있다
SELECT DEPT_CODE, JOB_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE;

--=============================================================================
-------?-------- · -----------------*--- .· -------'----------------------------
--=============================================================================

/*
    [HAVING 절]
     그룹에 대한 조건을 제시할 때 사용되는 구문 (주로 그룹함수식을 가지고 조건을 만든다)
*/

-- 각 부서별 평균 급여(부서코드, 평균급여)
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 각 부서별 평균 급여가 300만원 이상인 부서들만 조회(부서코드 평균급여)
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
WHERE AVG(SALARY) >= 3000000
GROUP BY DEPT_CODE;

SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY) >= 3000000;


-- 직급별 직급코드, 총 급여합(단, 직급별 급여 합이 1000만원 이상인 직급만 조회)
SELECT JOB_CODE, SUM(SALARY) FROM EMPLOYEE GROUP BY JOB_CODE HAVING SUM(SALARY) >= 10000000;

-- 부서별 보너스를 받는 사원이 없는 부서의 부서코드
SELECT DEPT_CODE, COUNT(BONUS) FROM EMPLOYEE GROUP BY DEPT_CODE HAVING COUNT(BONUS) = 0;

/*
    SELECT * | 조회하고 싶은 컬럼들 | 함수식 | 산술연산                     --  5
    FROM 조회하고 싶은 테이블 | DUAL                                      --  1
    WHERE 조건식                                                        --  2
    GROUP BY 그룹의 기준이 되는 컬럼 | 함수식                              --  3
    HAVING 조건식                                                       --  4
    ORDER BY 컬럼 | 별칭 | 순서 [ASC|DESC] [NULLS FRIST | NULLS LAST]    --  6
*/

--=============================================================================
-------?-------- · -----------------*--- .· -------'----------------------------
--=============================================================================

/*
    집합연산자
    여러 개의 쿼리문을 하나의 쿼리문으로 만드는 연산자
    
    - UNION : OR | 합집합(두 쿼리문 수행한 결과 값을 더한다)
    - INTERSECT : AND | 교집합 (두 쿼리문 수행한결과 값에 중복된 결과 값)
    - UNION ALL : 합집합 + 교집합 (중복되는 거 상관 않고 전부 더한 결과 값)
    - MINUS : 차집합(선생결과값에 후행결과값을 뺀 나머지)
*/

-- 1. UNION
-- 1.1 부서코드가 D5인 사원 또는 급여가 300만원 초과인 사원들의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR SALARY > 3000000;


-- 1.2 부서코드가 D5인 사원들의 이름, 부서코드 , 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-- 1.3 급여가 300만원 초과인 사원들의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000; 

-- 1.4 UNION 사용해서 합치기
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-- 2. INTERSECT ( 교집합 )
-- 2.1 부서코드가 D5이면서 급여도 300만원 초과인 사원들의 이름, 부서코드 , 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' AND SALARY > 3000000;

-- 2.2 INTERSECT 사용하기
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000
INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-- !! 집합 연산 사용 시 주의사항
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000
ORDER BY EMP_ID;
-- 컬럼의 개수가 동일해야한다.
-- 컬럼자리마다 동일한 타입으로 기술해야한다.
-- 정렬하고 싶다면 ORDER BY는 마지막에 기술한다.

-- 3. UNION ALL : 여러 개의 쿼리결과 값을 무조건 다 더한다 (중복 상관X)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000
ORDER BY EMP_ID;

-- 4. MINUS : 선행 SELECT 결과에서 후행 SELECT 결과를 뺀 나머지
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000
ORDER BY EMP_ID;





