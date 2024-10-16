/*
    DDL : ������ ���Ǿ� 
    
    ��ü�� ����(CREATE), ����(ALTER), ����(DROP)�ϴ� ����
    
    <ALTER>
    ��ü�� �����ϴ� ����
    
    [ǥ����]
    ALTER TABLE ���̺�� �����ҳ���
    
    *�����ҳ��� 
    1) �÷� �߰�/����/����
    2) �������� �߰�/���� -> ������ �Ұ� (���� �� �߰� �ؾ��Ѵ�.)
    3) �÷���/�������Ǹ�/���̺�� ����    
*/

-- 1) �÷� �߰�/����/����
-- DEPT_TABLE �� CNAME �÷� �߰�

ALTER TABLE DEPT_TABLE ADD CNAME VARCHAR2(20);

-- LNAME �÷� �߰� (�⺻�� -> �ѱ�)
ALTER TABLE DEPT_TABLE ADD LNAME VARCHAR2(20) DEFAULT '�ѱ�'; 

SELECT * FROM DEPT_TABLE;
-- 1_2) �÷� ����(MODIFY)
-- ������Ÿ�� ���� : MODIFY �÷��� �ٲٰ����ϴ� ������Ÿ��
-- DEFAULT �� ���� : MODIFY �÷��� DEFAULT ������ �⺻ ��

ALTER TABLE DEPT_TABLE MODIFY DEPT_ID CHAR(5);
-- ALTER TABLE DEPT_TABLE MODIFY DEPT_ID NUMBER; -- ���� ���� �߻�

-- DEPT_TITLE �÷��� VARCHAR2(40)
ALTER TABLE DEPT_TABLE MODIFY DEPT_TITLE VARCHAR2(40);

-- LNAME �÷��� �⺻ ���� '�̱�' ���� ����
ALTER TABLE DEPT_TABLE MODIFY LNAME DEFAULT '�̱�';

-- ���ߺ��氡��  (�Ʒ�ó�� �� ���� �� �� �ִ�.)
ALTER TABLE DEPT_TABLE 
         MODIFY DEPT_TITLE VARCHAR2(40)
         MODIFY LNAME DEFAULT '�̱�';

-- 1_3) �÷� ����( DROP COLUMN ) ������ ���ְų� �ٲ� �� DROP ��� /������ �����ؼ� ������ ���� DELETE 
--                             : DROP COLUMN �����ϰ��� �ϴ� �÷�

CREATE TABLE DEPT_COPY
AS (SELECT * FROM DEPT_TABLE);

SELECT * FROM DEPT_COPY;

ALTER TABLE DEPT_COPY DROP COLUMN DEPT_ID;
ALTER TABLE DEPT_COPY DROP COLUMN CNAME;
ALTER TABLE DEPT_COPY DROP COLUMN LNAME;
ALTER TABLE DEPT_COPY DROP COLUMN DEPT_TITLE;

ALTER TABLE DEPT_COPY DROP COLUMN LOCATION_ID; -- ���̺��� �ּ� �ϳ� �̻��� �÷��� �ʿ��ϴ�.

--=============================================================================
--------------- �� -----------------*--- .�� -------'----------------------------
--=============================================================================
-- 2) �������� �߰�/���� (������ �����ϰ� �ٽ� �߰��ϸ� �ȴ�.)

/*
    2_1)
    -PRIMARY KEY : ALTER TABLE ���̺�� ADD PRIMARY KEY(�÷���);
    -FOREIGN KEY : ALTER TABLE ���̺�� ADD FOREIGN KEY(�÷���) REFERENCES ������ ���̺��[�÷���];
    -UNIQUE : ALTER TABLE ���̺�� ADD UNIQUE(�÷���);
    -CHECK : ALTER TABLE ���̺�� ADD CHECK(�÷������� ���ǽ�);
    -NOT NULL : ALTER TABLE ���̺�� MODIFY �÷��� NOT NULL;
*/

ALTER TABLE DEPT_TABLE
        ADD CONSTRAINT DTABLE_PK PRIMARY KEY(DEPT_ID)
        ADD CONSTRAINT DEABLE_UQ UNIQUE(DEPT_TITLE)
        MODIFY LNAME CONSTRAINT DTABLE_NN NOU NULL;
        
-- 2_2) �������� ���� : DROP CONSTRAINT �������Ǹ� / NOT NULL( �� �����ȵ� )
ALTER TABLE DEPT_TABLE DROP CONSTRAINT DTABLE_PK;

ALTER TABLE DEPT_TABLE 
        DROP CONSTRAINT DTABLE_UQ
        MODIFY LNAME NULL;

--=============================================================================
--------------- �� -----------------*--- .�� -------'----------------------------
--=============================================================================
--���̺� ����
DROP TABLE DEPT_TABLE;
/*
     ������ �ȵǴ� �� 
   ��� ���� �ǰ��ִ� �θ����̺��� �Ժη� ������ �����ʴ´�.
   
        ���� ������� �Ѵٸ�
    1. �ڽ����̺��� ���� ���� ����
    2. �׳� �θ����̺� �����ϴµ� �������Ǳ��� �����ϴ� ���
    DROP TABLE ���̺�� CASCADE CONSTRAINT;
*/

--=============================================================================
--------------- �� -----------------*--- .�� -------'----------------------------
--=============================================================================
-- 3) �÷��� / �������Ǹ� / ���̺�� ����
-- 3_1) �÷��� ���� : RENAME COLUMN �����÷��� TO �ٲ� �÷���

CREATE TABLE DEPT_TABLE
AS (SELECT * FROM DEPARTMENT);

SELECT * FROM DEPT_TABLE;

-- DEPT_TITLE -> DEPT_NAME ���� ����
ALTER TABLE DEPT_TABLE RENAME COLUMN DEPT_TITLE TO DEPT_NAME;

-- 3_2) �������Ǹ� ���� : RENAME CONSTRAINT �����������Ǹ� TO �ٲ��������Ǹ�
ALTER TABLE DEPT_TABLE RENAME CONSTRAINT SYS_C007151 TO DTABLE_ID_NN;

-- 3_3) ���̺�� ���� : RENAME TO �ٲ����̺��
ALTER TABLE DEPT_TABLE RENAME TO DEPT_TEST;

--=============================================================================
--------------- �� -----------------*--- .�� -------'----------------------------
--=============================================================================
--TRUNCATE : ���̺� �ʱ�ȭ
TRUNCATE TABLE DEPT_TEST;
