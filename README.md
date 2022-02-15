## SelfJoin 동작을 테스트 하기 위한 코드

1. localhost:8099로 접속
2. [localhost:8099/create]() 접속으로 parent, child 카테고리 생성
3. [localhost:8099/get]() 접속 후 콘솔로 Self Join 여부 확인

---
### @JoinColumn
- name 속성에는 매핑할 외래키 이름을 지정한다.
- referecedColumnName 속성에는 외래키가 참조하는 테이블의 기본키 컬럼명을 적는다.