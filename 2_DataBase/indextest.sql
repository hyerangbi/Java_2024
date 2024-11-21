/*
    <INDEX>
    - 인덱스 : 데이터를 빠르게 검색하기 위한 데이터의 정렬과 
            탐색과 같은 DMBS 의 성능 향을 목적으로 생성하는 객체
            검색 속도가 향상된다. 
            단, 모든 경우에 향상 되는 것은 아니다.
            데이터 변경이 빈번한 컬럼을 기준으로 생성시 오히려 성능이 저하될 수 있다.
*/

-- 전체 데이터 확인
select * 
from user_mock_data;

-- user_mock_data 를 복사해서 새로 만듬
create table user_index_data
as select * from user_mock_data;

-- 제약조건 pk 추가 
alter table user_index_data
add constraint pk_user_index_id primary key(id);

-- 제약조건 uq 추가
alter table user_index_data
add constraint uq_user_index_id unique(email);

select * from user_indexes;

-- 인덱스 설정 안된 테이블(user_mock_data)
/*
------------------------------------------------------------------------------------
| Id  | Operation         | Name           | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------------
|   0 | SELECT STATEMENT  |                |     5 |   665 |   136   (0)| 00:00:02 |
|*  1 |  TABLE ACCESS FULL| USER_MOCK_DATA |     5 |   665 |   136   (0)| 00:00:02 |
------------------------------------------------------------------------------------

cost : 실행 예상 비용

row(cardinality) : 실행 계획에서 acess 된 row 수 

bytes : 실행 계획에서 access 된 bytes 수 

TABLE ACCESS FULL : 전체 테이블을 탐색하여 결과를 도출하게 될 것이다.
*/
explain plan for
select * from user_mock_data where id = 30000;

select * from table(dbms_xplan.display);

-- 인덱스 설정된 테이블(user_index_data)
/*
------------------------------------------------------------------------------------------------
| Id  | Operation                   | Name             | Rows  | Bytes | Cost (%CPU)| Time     |
------------------------------------------------------------------------------------------------
|   0 | SELECT STATEMENT            |                  |     1 |   133 |     2   (0)| 00:00:01 |
|   1 |  TABLE ACCESS BY INDEX ROWID| USER_INDEX_DATA  |     1 |   133 |     2   (0)| 00:00:01 |
|*  2 |   INDEX UNIQUE SCAN         | PK_USER_INDEX_ID |     1 |       |     1   (0)| 00:00:01 |
------------------------------------------------------------------------------------------------

INDEX (UNIQUE) SCAN : 인덱스 객체를 참조하여 탐색 후 결과를 도출하게 될 것을 예상한다.
TABLE ACCESS (BY INDEX ROWID) : 인덱스 객체로 참조한 INDEX ROWID 로 탐색하여 
                                결과를 도출하게 될 것을 예상한다.
*/
explain plan for
select * from user_index_data where id = 30000;

select * from table(dbms_xplan.display);

-- 인덱스 생성
CREATE INDEX USER_INDEX_FIRST_NAME ON USER_INDEX_DATA(FRIST_NAME);

-- 두 컬럼으로 조회
explain plan for
SELECT * 
FROM USER_MOCK_DATA
WHERE ID = 49977
AND FIRST_NAME = "Gaston';












