/*
    Basic SELECT
*/


-- 1. �� ������б��� �а� �̸��� �迭�� ǥ���Ͻÿ�. ��, ��� ����� "�а� ��", "�迭" ���� ǥ���ϵ��� �Ѵ�.

SELECT DEPARTMENT_NAME AS "�а� ��", 
       CATEGORY AS "�迭" 
FROM TB_DEPARTMENT;

-- 2. �а��� �а� ������ ������ ���� ���·� ȭ�鿡 ����Ѵ�.

SELECT DEPARTMENT_NAME || '�� ������ ' || CAPACITY || '�� �Դϴ�.' "�а��� ����" 
FROM TB_DEPARTMENT;


-- 3. "������а�"�� �ٴϴ� ���л� �� ���� �������� ���л��� ã�ƴ޶�� ��û�� ���Դ�.
-- �����ΰ� ? ( �����а��� '�а��ڵ�' �� �а� ���̺� (TB_DEPARTMENT)�� ��ȸ�ؼ� ã�� ������ ����)
SELECT DEPARTMENT_NO, DEPARTMENT_NAME FROM TB_DEPARTMENT
WHERE DEPARTMENT_NAME = '������а�';

SELECT STUDENT_NAME
FROM TB_DEPARTMENT
JOIN TB_STUDENT USING (DEPARTMENT_NO)
WHERE DEPARTMENT_NO = '001'
  AND ABSENCE_YN = 'Y'
  AND SUBSTR(STUDENT_SSN, 8, 1) = 2 OR SUBSTR(STUDENT_SSN, 8, 1) = 4;


-- 4. ���������� ���� ���� ��� ��ü�� ���� ã�� �̸��� �Խ��ϰ��� �Ѵ�. 

-- ?? �̰� �����

-- 5. ���������� 20�� �̻� 30�� ������ �а����� �а� �̸��� �迭�� ����Ͻÿ�.
SELECT DEPARTMENT_NAME, CATEGORY 
FROM TB_DEPARTMENT
WHERE CAPACITY BETWEEN 20 AND 30;


-- 6. �� ������б��� ������ �����ϰ� ��� �������� �Ҽ� �а��� ������ �ִ�.
-- �׷� �� ������б� ������ �̸��� �˾Ƴ� �� �ִ� SQL������ �ۼ��Ͻÿ�.
SELECT PROFESSOR_NAME 
FROM TB_PROFESSOR
WHERE DEPARTMENT_NO IS NULL;

-- 7. Ȥ�� ������� ������ �а��� �����Ǿ� ���� ���� �л��� �ִ��� Ȯ���ϰ��� �Ѵ�.
-- ��� SQL ������ ����ϸ� �� ������ �ۼ��Ͻÿ�.
SELECT STUDENT_NAME, DEPARTMENT_NO
FROM TB_STUDENT
;
--?

-- 8. ������û�� �Ϸ����Ѵ�. �������� ���θ� Ȯ���ؾ� �ϴµ�, ���������� �����ϴ� �������
-- � �������� �����ȣ�� ��ȸ�غ��ÿ�.
SELECT CLASS_NO 
FROM TB_CLASS
WHERE PREATTENDING_CLASS_NO IS NOT NULL;


-- 9. �� ���п��� � �迭(CATEGORY)���� �ִ��� ��ȸ�غ��ÿ�.
SELECT CATEGORY FROM TB_DEPARTMENT
GROUP BY CATEGORY;


-- 10. 02�й� ���� ���ֵ��� ������ ������� �Ѵ�. ������ ������� ������
-- �������� �л����� �й�, �̸�, �ֹι�ȣ�� ����ϴ� ������ �ۼ��Ͻÿ�.
SELECT STUDENT_NO, STUDENT_NAME, STUDENT_SSN
FROM TB_STUDENT
WHERE ABSENCE_YN = 'Y'
      AND STUDENT_ADDRESS LIKE '%����%';









