/*
    Additional SELECT
*/

-- 1. 영어영문학과 (학과코드 002) 학생들의 학번과 이름, 입학년도를 입학년도가 빠른순으로 표시
-- (단 헤더는 "학번", "이름', "입학년도"로 표시 )

SELECT STUDENT_NO "학번", STUDENT_NAME "이름", TO_CHAR(ENTRANCE_DATE, 'YYYY"-"MM"-"DD') "입학년도"
FROM TB_STUDENT
WHERE DEPARTMENT_NO = '002'
ORDER BY 입학년도 ASC;


-- 2. 춘 기술대학교의 교수 중 이름이 세글자가 아닌 교수가 한 명이 있다고 한다.
-- 그 교수의 이름과 주민 번호를 화면에 출력
SELECT PROFESSORT_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR
WHERE PROFESSORT_NAME NOT LIKE '___\%' ESCAPE '\';

-- 3. 춘 기술대학교의 남자 교수들의 이름과 나이를 출력하는 SQL문장 작성
-- 단, 이때 나이가 적은 사람에서 많은 사람 순서로 화면에 출력되도록 만드시오.
-- (단, 교수 중 2000년 이후 출생자는 없으며 출력 헤더는 "교수이름", "나이"로 한다. 
-- 나이는 '만'으로 계산한다.

SELECT PROFESSOR_NAME AS "교수이름",
       EXTRACT(YEAR FROM SYSDATE)- 
       (1900 + TO_NUMBER(SUBSTR(PROFESSOR_SSN, 1, 2)))        
       AS "나이"
FROM TB_PROFESSOR
ORDER BY 나이 ASC;

-- 4. 교수들의 이름 중 성을 제외한 이름만 출력하도록 작성
-- 출력 헤더는 "이름" 으로 설정한다. (성이 2글자인 경우는 없다고 가정)
SELECT PROFESSOR_NAME
FROM TB_PROFESSOR
;

-- 5. 춘 기술대학교의 재수생 입학자를 구하려고 한다. 이때, 19살에 입학하면 재수를 하지 않은것으로 간주 //2008년 기준.
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
GROUP BY 
TO_NUMBER(SUBSTR(STUDENT_SSN, 1, 2));


-- 6. 2020년 크리스마스는 무슨 요일인가 ?
SELECT TO_CHAR(TO_DATE('20201225', 'YYYYMMDD'),'YYYY-MM-DD DAY') 
AS "2020년 크리스마스 요일" 
FROM DUAL;


-- 7.1 TO_DATE('99/10/11', 'YY/MM/DD'), TO_DATE('49/10/11', 'YY/MM/DD') 은 각각 몇 년 몇 월 몇 일을 의미할까 ?
--            1999년 10월 11일           1949년 10월 11일 을 나타낸다
SELECT TO_CHAR(TO_DATE('99/10/11', 'YY/MM/DD'))FROM DUAL;

-- 7.2 TO_DATE('99/10/11', 'RR/MM/DD') TO_DATE('49/10/11', 'RR/MM/DD')은 각각 몇 년 몇 월 몇 일 을 의미할까 ?
--
SELECT TO_CHAR(TO_DATE('49/10/11', 'RR/MM/DD'))FROM DUAL;



-- 8. 춘 기술대학교의 2000년도 이후 입학자들은 학번이 A로 시작하게 되어있다. 2000년도 이전 학번을 받은 학생들의 학번과 이름을 보여주게 작성
SELECT * FROM TB_DRPARTMENT;


-- 9. 학번이 A517178인 한아름 학생의 학점 총 평점을 구할 수 있는 문장을 작성하시오.
-- 단, 이때 출력 화면의 헤더는 "평점" 이라고 찍히게 하고, 점수는 반올림 하여 소수점 이하 한자리까지 표시


-- 10. 학과별 학생 수를 구하여 "학과번호", "학생수(명)"의 형태로 헤어들 만들어 결과 값이 출력되도록 하시오.

