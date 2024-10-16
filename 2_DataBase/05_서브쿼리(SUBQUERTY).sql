/*
    *��������
    - �ϳ��� SQL�� �ȿ� ���Ե� �� �ٸ� SELECT ��
    - ���� SQL���� ���� ���� ������ �ϴ� ���� 
*/

-- ���ö ����� ���� �μ��� ���� ����� ��ȸ

SELECT EMP_NAME FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- ���ö����� ��μ��ϱ� ?
SELECT DEPT_CODE FROM EMPLOYEE 
WHERE EMP_NAME = '���ö';

-- ���� �� ������ �ϳ��� ������ ��������
SELECT EMP_NAME FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE FROM EMPLOYEE 
                   WHERE EMP_NAME = '���ö');

-- �������� ����2)
-- �� ������ ��ձ޿����� �� ���� �޿��� �޴� ������� ���, �̸�, �����ڵ�, �޿���ȸ
-- 1) �� ������ ��ձ޿�
SELECT AVG(SALARY) FROM EMPLOYEE;

-- 2) 3047663 �� ���� �޿��� ���� ������� ���, �̸�, �����ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE
WHERE SALARY >= 3046623;

-- �� ������ �ϳ��� ���غ���.
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE
WHERE SALARY >= (SELECT AVG(SALARY) FROM EMPLOYEE);

/*
    ? ���������� ����
    ���������� ������ ��� ���� ���� ��� �������Ŀ� ���� �з�
    
    -- ������ �������� : ���������� ��ȸ ��� ���� ������ 1���� ��
    -- ������ �������� : ���������� ��ȸ ��� ���� ���� ���� �� (���� �� �� ��)
    -- ���߿� �������� : ���������� ��ȸ ��� ���� �� �������� �÷��� ���� ���϶�
    -- ���� �� ���� �� ���� ���� : ���������� ��ȸ ��� ���� ���� �� ���� �÷� �� ��
    
    >> ���������� ��� ���� ���� �������� �� �ʿ� �����ڰ� �޶�����.
*/

/*
    1. ������ ��������
    ���������� ��ȸ ��� ���� ������ 1���� �� (���� �ѿ�)
    �Ϲ� �񱳿����� ��밡��
    = != > <= ...
*/

-- 1.1) �� ������ ��� �޿����� �޿��� �� ���Թ޴� ������� ��� ��, �����ڵ�, �޿���ȸ
SELECT EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE
WHERE SALARY < (SELECT AVG(SALARY) FROM EMPLOYEE);

-- 1.2) �����޿��� �޴� ����� ���, �̸�, �޿�, �Ի� �� ��ȸ
SELECT EMP_ID, EMP_ID, SALARY, HIRE_DATE FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY FROM EMPLOYEE);


-- 1.3) ���ö ����� �޿����� ���� �޴� ������� ���, �̸�, �μ��ڵ�, �޿���ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME = '���ö');


-- 1.4) ���ö ����� �޿����� ���� �޴� ������� ���, �̸�, �μ���, �޿���ȸ
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_ID = DEPT_CODE)
WHERE SALARY > (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME = '���ö');

-- 1.5) �μ��� �޿����� ���� ū �μ��� �μ��ڵ� �޿� ��
    -- 1.5.1)�μ��� �޿� �� ���� ū �μ�
    SELECT MAX(SUM(SALARY)) FROM EMPLOYEE GROUP BY DEPT_CODE;
    -- 1.5.2) �޿����� 17700000 ���� �μ��ڵ�, �޿� ��
    SELECT DEPT_CODE, SUM(SALARY) FROM EMPLOYEE GROUP BY DEPT_CODE HAVING SUM(SALRY) = 17700000;
    
    -- 1.5.3) �� ���� ��ġ��
    SELECT DEPT_CODE, SUM(SALARY) FROM EMPLOYEE
    GROUP BY DEPT_CODE HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY)) FROM EMPLOYEE GROUP BY DEPT_CODE);

-- 1.6) '������'����� ���� �μ��� ������� ���, ��� ��, ��ȭ��ȣ, �Ի���, �μ��� ��ȸ (��, ��������� ����)
SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE, DEPT_TITLE FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE DEPT_CODE = (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME = '������')
AND EMP_NAME != '������';

--=============================================================================
--------------- �� -----------------*--- .�� -------'----------------------------
--=============================================================================
/*
    2. ������ ��������
        ���������� ������ ��� ���� ���� ���� �� (�÷��� �� ��)
    IN(��������) : ���� ���� ��� �� �߿��� �� ���� ��ġ�ϴ� ���� �ִٸ� ��ȸ
    > ANY (��������) : ���� ���� ��� �� �߿��� �� ���� Ŭ ��� ��ȸ
    < ANY (��������) : ���� ���� ��� �� �߿��� �� ���� ���� ��� ��ȸ
       �񱳴�� > ANY (���������� ��� �� -> ��1, ��2, ��3 ...)
       
    > ALL(��������) : ���� ���� ��� ��� ���麸�� Ŭ ��� ��ȸ
    < ALL(��������) : ���� ���� ��� ��� ���麸�� ���� ��� ��ȸ
*/

-- 2.1) ����� �Ǵ� ������ ����� ���� ������ ������� ���, ��� ��, �����ڵ�, �޿� ��ȸ
-- 2.1.1)����� �Ǵ� ������ ����� ����
SELECT JOB_CODE FROM EMPLOYEE
WHERE EMP_NAME IN ('�����', '������');

-- 2.1.2) ������ J3, J7�� ������� ���, ��� ��, �����ڵ�, �޿���ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE
WHERE JOB_CODE IN ('J3','J7');

-- 2.1.3 ) �� ���� ��ġ��
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE
WHERE JOB_CODE IN (SELECT JOB_CODE FROM EMPLOYEE WHERE EMP_NAME IN ('�����', '������'));


-- 2.2) �븮�����ӿ��� ���� ���� �޿��� �� �ּ� �޿����� ���� �޴� ������� ���, �̸�, ����, �޿���ȸ
-- 2.2.1) ���� ���� �޿�
SELECT SALARY FROM EMPLOYEE 
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '����';

-- 2.2.2) �븮�����̸鼭 ���� ��� ������ �ϳ��� ū ���
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '�븮' AND SALARY > ANY(3760000, 2200000, 2500000);

-- 2.2.3) �� ���� ��ġ��
SELECT EMP_ID, EMP_NAME, SALARY FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '�븮' AND  SALARY > ANY(SELECT SALARY FROM EMPLOYEE 
                                         JOIN JOB USING(JOB_CODE)
                                         WHERE JOB_NAME = '����');

--=============================================================================
--------------- �� -----------------*--- .�� -------'----------------------------
--=============================================================================
/*
    3. ���� �� ���� ����
    ��� ���� �� �������� ������ �÷� ���� ���� ���� ���
*/

-- 3.1) ������ ����� ���� �μ��ڵ�, ���� �����ڵ忡 �ش��ϴ� ����� ��ȸ(��� ��, �μ��ڵ�, �����ڵ�, �Ի���)

-- 3.1.1) ������ ��������
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME = '������')
    AND JOB_CODE = (SELECT JOB_CODE FROM EMPLOYEE WHERE EMP_NAME = '������');

-- 3.1.2) ���߿� ��������
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE FROM EMPLOYEE
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE FROM EMPLOYEE WHERE EMP_NAME = '������');


-- 3.2) �ڳ��� ����� ���� �����ڵ�, ���� ����� ������ �ִ� ������� ���, ��� ��, �����ڵ�, �����ȣ
SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID FROM EMPLOYEE
WHERE (JOB_CODE, MANAGER_ID) = (SELECT JOB_CODE, MANAGER_ID FROM EMPLOYEE WHERE EMP_NAME ='�ڳ���')
AND EMP_NAME != '�ڳ���';

--=============================================================================
--------------- �� -----------------*--- .�� -------'----------------------------
--=============================================================================

/*
    4. ������ ���߿� ��������
    ���������� ��ȸ ������� ���� �� ���� ���� ���
*/

-- 4.1) �� ���� �� �ּ� �޿��� �޴� ��� ��ȸ (���, ��� ��, �����ڵ�, �޿�)
-- 4.1.1) �� ���޺� �ּ� �޿�
SELECT JOB_CODE, MIN(SALARY) FROM EMPLOYEE
GROUP BY JOB_CODE;

-- 4.1.2) �� ���޺� �ּ� �޿��� �޴� ��� ��ȸ (���, ��� ��, �����ڵ�, �޿�)
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE
WHERE JOB_CODE = 'J2' AND SALARY = 3700000
    OR JOB_CODE = 'J7' AND SALARY = 1380000
    OR JOB_CODE = 'J3' AND SALARY = 3400000
    OR JOB_CODE = 'J6' AND SALARY = 2000000
    OR JOB_CODE = 'J5' AND SALARY = 2200000
    OR JOB_CODE = 'J1' AND SALARY = 8000000
    OR JOB_CODE = 'J4' AND SALARY = 1550000;

-- 4.1.3) �������� �̿�
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, MIN(SALARY) FROM EMPLOYEE
                             GROUP BY JOB_CODE);
                             
-- 5.1) �� �μ��� �ְ� �޿��� �޴� ������� ���, ��� ��, �μ��ڵ�, �޿�
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY FROM EMPLOYEE
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, MAX(SALARY) FROM EMPLOYEE   
                              GROUP BY DEPT_CODE);

--=============================================================================
--------------- �� -----------------*--- .�� -------'----------------------------
--=============================================================================

--1. �μ� �� �޿� �հ谡 ��ü �޿� �� ���� 20%���� ���� �μ��� �μ� ��, �μ� �� �޿� �հ� ��ȸ
SELECT DEPT_TITLE, SUM(SALARY) FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) > (SELECT SUM(SALARY) * 0.2 FROM EMPLOYEE);

--2. ���� �� ���� ������ ��� �ڵ�, ��� ��, ����, �μ� ��, ���� �� ��ȸ
SELECT EMP_ID, EMP_NAME, 
    EXTRACT (YEAR FROM SYSDATE) -
    CASE
        WHEN SUBSTR(EMP_NO,1,2) <= TO_CHAR(SYSDATE, 'YY')
            THEN (2000 + SUBSTR(EMP_NO,1,2))
        ELSE 
            (1900 + SUBSTR(EMP_NO,1,2))
    END + 1 AS "����"
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
--------------- �� -----------------*--- .�� -------'----------------------------
--=============================================================================
/*
    5. �ζ��� ��
    FROM ���� ���������� �ۼ��ϴ� ��
    ���������� ������ ����� ��ġ ���̺�ó�� ���
*/

-- 5.1 ������� ���, �̸�, ���ʽ� ���� ����, �μ��ڵ� ��ȸ
-- ��, ���ʽ� ���� ������ NULL�� �Ǹ� �ȵȴ�.
-- ��, ���ʽ� ���� ������ 3000���� �̻��� ����鸸 ��ȸ

/* ROWNUM : ����Ŭ���� �����ϴ� �÷�, ��ȸ�� ������� 1���� ������ �ο��Ѵ�.*/
SELECT EMP_ID, EMP_NAME, (SALARY + (SALARY * NVL(BONUS,0))) * 12  ����, DEPT_CODE FROM EMPLOYEE
WHERE (SALARY + (SALARY * NVL(BONUS,0))) * 12  >= 30000000
ORDER BY ���� DESC;

-- 5.2 �� ���� �� �޿��� ���� ���� 5�� ��ȸ
SELECT ROWNUM, EMP_ID, EMP_NAME, (SALARY + (SALARY * NVL(BONUS,0))) * 12 FROM EMPLOYEE
WHERE ROWNUM <= 5
ORDER BY SALARY DESC;

/* �ζ��κ並 �ַ� ����ϴ� ��>> TOP-N �м� : ���� �� ���� ��ȸ
    ORDER BY���� ����� ����� ������ ROWNUM�ο� -> ���� 5�� ��ȸ */
-- 5.3 ORDER BY���� ����� ����� ������ ROWNUM�ο� -> ���� 5�� ��ȸ
SELECT ROWNUM, EMP_NAME, SALARY FROM(SELECT EMP_NAME, SALARY FROM EMPLOYEE ORDER BY SALARY DESC)
WHERE ROWNUM <= 5;

-- 5.4 ���� �ֱٿ� �Ի��� ��� 5�� ��ȸ (��� ��, �޿�, �Ի���)
SELECT ROWNUM, EMP_NAME, SALARY ,HIRE_DATE FROM(SELECT EMP_NAME, SALARY, HIRE_DATE FROM EMPLOYEE
                                         ORDER BY HIRE_DATE DESC)
WHERE ROWNUM <=5;

-- �μ� �� ��� �޿��� ���� 3���� �μ� ��ȸ
SELECT ROWNUM,DEPT_CODE ,AVG(SALARY) AS "��ձ޿�"
FROM (SELECT DEPT_CODE, AVG(SALARY) 
        FROM EMPLOYEE 
        GROUP BY DEPT_CODE ORDER BY AVG(SALARY) DESC)
WHERE ROWNUM <=3;

/*
    * ������ �ű�� �Լ� (WINDOW FUNCTION)
    RANK() OVER(���ı���) | DENSE_RANK() OVER(���ı���)
    RANK() OVER(���ı���) : ������ ���� ������ ����� ������ �ο� ����ŭ �ǳʶٰ� �������
    DANSE_RANK() OVER(���ı���) : ������ ������ �ִٰ� �ص� �� ���� ����� ������ 1�� ����
*/

-- �޿��� ���� ������� ������ �Űܼ� ��ȸ
SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC ) AS "����" FROM EMPLOYEE;

SELECT EMP_NAME, SALARY, DENSE_RANK() OVER(ORDER BY SALARY DESC) AS "����" FROM EMPLOYEE;

SELECT * FROM (SELECT EMP_NAME, SALARY, RANK() OVEr(ORDER BY SALARY DESC) AS "����" FROM EMPLOYEE) 
WHERE ���� <=5;













