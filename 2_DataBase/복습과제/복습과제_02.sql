/*
    Additional SELECT
*/

-- 1. ������а� (�а��ڵ� 002) �л����� �й��� �̸�, ���г⵵�� ���г⵵�� ���������� ǥ��
-- (�� ����� "�й�", "�̸�', "���г⵵"�� ǥ�� )

SELECT STUDENT_NO "�й�", STUDENT_NAME "�̸�", TO_CHAR(ENTRANCE_DATE, 'YYYY"-"MM"-"DD') "���г⵵"
FROM TB_STUDENT
WHERE DEPARTMENT_NO = '002'
ORDER BY ���г⵵ ASC;


-- 2. �� ������б��� ���� �� �̸��� �����ڰ� �ƴ� ������ �� ���� �ִٰ� �Ѵ�.
-- �� ������ �̸��� �ֹ� ��ȣ�� ȭ�鿡 ���
SELECT PROFESSORT_NAME, PROFESSOR_SSN
FROM TB_PROFESSOR
WHERE PROFESSORT_NAME NOT LIKE '___\%' ESCAPE '\';

-- 3. �� ������б��� ���� �������� �̸��� ���̸� ����ϴ� SQL���� �ۼ�
-- ��, �̶� ���̰� ���� ������� ���� ��� ������ ȭ�鿡 ��µǵ��� ����ÿ�.
-- (��, ���� �� 2000�� ���� ����ڴ� ������ ��� ����� "�����̸�", "����"�� �Ѵ�. 
-- ���̴� '��'���� ����Ѵ�.

SELECT PROFESSOR_NAME AS "�����̸�",
       EXTRACT(YEAR FROM SYSDATE)- 
       (1900 + TO_NUMBER(SUBSTR(PROFESSOR_SSN, 1, 2)))        
       AS "����"
FROM TB_PROFESSOR
ORDER BY ���� ASC;

-- 4. �������� �̸� �� ���� ������ �̸��� ����ϵ��� �ۼ�
-- ��� ����� "�̸�" ���� �����Ѵ�. (���� 2������ ���� ���ٰ� ����)
SELECT PROFESSOR_NAME
FROM TB_PROFESSOR
;

-- 5. �� ������б��� ����� �����ڸ� ���Ϸ��� �Ѵ�. �̶�, 19�쿡 �����ϸ� ����� ���� ���������� ���� //2008�� ����.
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
GROUP BY 
TO_NUMBER(SUBSTR(STUDENT_SSN, 1, 2));


-- 6. 2020�� ũ���������� ���� �����ΰ� ?
SELECT TO_CHAR(TO_DATE('20201225', 'YYYYMMDD'),'YYYY-MM-DD DAY') 
AS "2020�� ũ�������� ����" 
FROM DUAL;


-- 7.1 TO_DATE('99/10/11', 'YY/MM/DD'), TO_DATE('49/10/11', 'YY/MM/DD') �� ���� �� �� �� �� �� ���� �ǹ��ұ� ?
--            1999�� 10�� 11��           1949�� 10�� 11�� �� ��Ÿ����
SELECT TO_CHAR(TO_DATE('99/10/11', 'YY/MM/DD'))FROM DUAL;

-- 7.2 TO_DATE('99/10/11', 'RR/MM/DD') TO_DATE('49/10/11', 'RR/MM/DD')�� ���� �� �� �� �� �� �� �� �ǹ��ұ� ?
--
SELECT TO_CHAR(TO_DATE('49/10/11', 'RR/MM/DD'))FROM DUAL;



-- 8. �� ������б��� 2000�⵵ ���� �����ڵ��� �й��� A�� �����ϰ� �Ǿ��ִ�. 2000�⵵ ���� �й��� ���� �л����� �й��� �̸��� �����ְ� �ۼ�
SELECT * FROM TB_DRPARTMENT;


-- 9. �й��� A517178�� �ѾƸ� �л��� ���� �� ������ ���� �� �ִ� ������ �ۼ��Ͻÿ�.
-- ��, �̶� ��� ȭ���� ����� "����" �̶�� ������ �ϰ�, ������ �ݿø� �Ͽ� �Ҽ��� ���� ���ڸ����� ǥ��


-- 10. �а��� �л� ���� ���Ͽ� "�а���ȣ", "�л���(��)"�� ���·� ���� ����� ��� ���� ��µǵ��� �Ͻÿ�.

