# Study
백기선님의 인프런 강의 <a href="https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-JPA-%EC%9B%B9%EC%95%B1">스프링과 JPA 기반 웹 애플리케이션 개발</a>을 수강하여 작성한 코드입니다. 강의에서는 Maven과 PostgreSQL을 사용하였지만, 여기서는 Gradle과 MySQL을 사용하였습니다.

# 주로 습득한 내용
- Spring Boot, MVC, Thymeleaf, Security, Data JPA 등의 실제 서비스 구현에서의 사용법
- 가입 시/패스워드 분실시 이메일을 전송하는 기능의 구현
- Tagify, Moment 등 여러 유용한 프론트엔드용 자바스크립트 라이브러리
- QueryDSL의 사용법

# 시행착오
- QueryDSL을 Gradle에서 가져오는 데 어려움을 겪었다. <a href="https://n1tjrgns.tistory.com/275">이 링크</a>를 사용하여 해결.
- (미해결) frontend-maven-plugin은 maven 전용이라 gradle에서는 사용이 힘들다. <a href="https://github.com/siouan/frontend-gradle-plugin">frontend-gradle-plugin</a>이라는 대체제가 있지만, 동일한 방법으로 어떻게 사용하는지 아직 모르겠다.
- (미해결) 테스트에서 MySQL을 적용하면 에러가 발생한다. 윈도우 환경에서 해서 그런것인지, 관련 자료를 찾는데 조금 어려움이 있음.

# 더 공부가 필요한 부분
- 스프링 시큐리티 관련. 아직도 이해가 부족.

# 수강 후기
시간이 많지 않아 조금 빠르게 들었는데, 실용적으로 도움이 되는 내용이 많은 강의였습니다.
