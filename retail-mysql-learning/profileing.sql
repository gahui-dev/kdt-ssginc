SET @@profiling = 0;
SET @@profiling_history_size = 0;
SET @@profiling_history_size = 100; 
SET @@profiling = 1;

show profiles;

-- starting: 쿼리 실행을 시작하기 전의 초기화 단계입니다.
-- Executing hook on transaction: 트랜잭션에 관련된 후크(hook)를 실행하는 단계입니다.
-- checking permissions: 사용자의 권한 확인 단계입니다. 사용자가 해당 쿼리를 실행할 권한이 있는지 확인합니다.
-- Opening tables: 필요한 테이블들을 여는 단계입니다.
-- init: 초기화 단계입니다.
-- System lock: 시스템 레벨의 잠금을 처리하는 단계입니다.
-- optimizing: 쿼리 최적화 단계로, 어떻게 효율적으로 쿼리를 실행할지 계획을 세우는 단계입니다.
-- statistics: 테이블의 통계 정보를 수집하는 단계입니다.
-- preparing: 쿼리 준비 단계로, 쿼리 실행을 위한 최종 계획을 세우는 단계입니다.
-- executing: 쿼리를 실행하는 단계입니다.
-- end: 쿼리 실행을 마치는 단계입니다.
-- query end: 쿼리 종료 단계입니다.
-- waiting for handler commit: 핸들러가 커밋을 완료하기를 기다리는 단계입니다.
-- closing tables: 열려 있던 테이블들을 닫는 단계입니다.
-- freeing items: 사용했던 리소스나 메모리 등을 해제하는 단계입니다.
-- cleaning up: 정리 작업을 하는 단계입니다.

SHOW profile CPU FOR QUERY 69;
SHOW profile CPU FOR QUERY 70;