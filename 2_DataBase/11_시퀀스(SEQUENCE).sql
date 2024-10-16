/*
    <������ SEQUENCE>
    �ڵ����� ��ȣ�� �߻������ִ� ������ �ϴ� ��ü
    ���� ���� ���������� �����ϰ� ������Ű�鼭 �������ش�.
    
    EX) ȸ����ȣ, �����ȣ, �Խñ۹�ȣ ...
*/

/*
    1. ������ ��ü ����
    
    [ǥ����]
    CREATE SEQUENCE ��������
    [START WITH ���ۼ���]           -> ó�� �߻���ų ���� �� ���� ( �⺻ �� 1 )
    [INCREMENT BY ����]            -> �� �� ���� ��ų ������ ( �⺻ �� 1)
    [MAXVALUE ���� ]               -> �ִ� �� ���� ( �⺻ �� �ſ� ũ�� )
    [MINVALUE ����]                -> �ּ� �� ���� ( �⺻ �� 1 )
    [CYCLE | NOCYCLE]              -> �� ��ȯ ���� (�⺻ �� NOCYCLE)
    [CACHE | NOCACHE]              -> ĳ�ø޸� �Ҵ� ( �⺻ �� CACHE 20 )
    
    * ĳ�ø޸� : �̸� �߻��� ������ �����ؼ� �����صδ� ����
                 �Ź� ȣ��� ������ ���ο� ��ȣ�� �����ϴ°� �ƴ϶�
                 ĳ�ø޸𸮰����� �̷� ������ ������ ������ �� �� �ִ�. (�ӵ��� ��������)
                 
    ���̺�� : TB_
    ��� : VW_
    ������ : SEQ_
    Ʈ���� : TRG_
*/

CREATE SEQUENCE SEQ_TEST;

-- [����] ���� ������ ������ ���������� ������ ������� ��
SELECT * FROM USER_SEQUENCES;

CREATE SEQUENCE SEQ_EMPNO
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCYCLE
NOCACHE;

/*
    2. ������ ���
    
    ��������.CURRVAL : ���� ������ ��(���������� ������ NEXTVAL�� ���ప)
    ��������.NEXTVAL : ������ ���� ������ ���� �������� �߻��� �� 
                      ���� ������ ���� INCREMENT BY ����ŭ ������ ��
*/

SELECT * FROM USER_SEQUENCES;

SELECT SEQ_EMPNO.CURRVAL FROM DUAL;
--> NEXTVAL�� �� ���� �������� ���� �̻� CURRVAL�� �� �� ����.
--> �ֳ��ϸ� CURRVAL�� ���������� ������ NEXTVAL�� ���� �����ؼ� �����ִ� �ӽ� ���̴�
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; --300
SELECT SEQ_EMPNO.CURRVAL FROM DUAL; --300
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; --305
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; --310

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL; -- 315 �� �ִ� �� 310�� �Ѿ���

/*
    3. �������� ���� ����
    
    ALTER SEQUENCE ������
    [INCREMENT BY ����]
    [MAXVALUE ����]
    [MINVALUE ����]
    [CYCLE | NOCYCLE]
    [CACHE | NOCACHE]
    [CACHE ����Ʈ ũ�� | NOCACHE]
    
    *START WITH�� ���� �Ұ�
*/

ALTER SEQUENCE SEQ_EMPNO
INCREAMENT BY 10
MAXVALUE 400;

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL;

-- 4. ������ ����
DROP SEQUENCE SEQ_EMPNO;
--------------------------------------------------------------------------
-- �����ȣ�� ����� ������
CREATE SEQUENCE SEQ_EID
START WITH 400
NOCACHE;

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, HIRE_DATE)
        VALUES(SEQ_EID.NEXTVAL, '�踶��', '111111-2111111', 'J6', SYSDATE);
        
SELECT * FROM EMPLOYEE;

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, HIRE_DATE)
        VALUES(SEQ_EID.NEXTVAL, '��¡��', '111111-2111111', 'J6', SYSDATE);