# Spring MultiModule

- 필요한 기능별로 module을 생성
- 레고를 조립하듯 필요한 module 조립
- **N개의 module이 조립**되어 있는 프로젝트를 Multi Module 프로젝트라 함
- ex) 로그인 모듈, 인증 모듈, db entity 모듈 등

### 📌 멀티모듈을 사용하는 이유

api 서버에도 db entity가 필요하고, batch 서버에서도 동일한 entity가 필요하다면

중복된 entity를 module화 시켜 사용하기 위해 multi module 프로젝트 사용!

- 만약 독립적으로 관리한다면 중복해서 관리해야 하므로 risk 증가

### ✅ Exception 핸들링

- 언어 혹은 프레임워크에서 발생한 Exception은 **반드시 custom하게 wrapping해서 처리**
- @RestControllerAdvice 어노테이션을 사용해서 모든 예외를 해당 클래스에서 **클라이언트와 사전에 정의한 값으로 재정의**
- ex) null point exception의 경우 Error Code를 4001로 내린다.

### 💡 Multi Module 구조에서 Gradle을 사용한 배포

- multi module 구조에서는 원하는 모듈을 골라서 빌드&배포 가능
- 빌드 툴로는 gradle 혹은 maven존재, 요새는 gradle


### ❓ profile이 필요한 이유

- 실제 회사에서 개발할땐 n개의 profile 설정
    - ex) local, dev, test, prod
    - profile을 나누는 이유는 환경별로 설정하는 property 값이 다르기 때문!
    ![image](https://github.com/zeunxx/fastcampus-10Project-6-SpringMultiModule/assets/81572478/d689028f-5e8d-4aea-a8af-5b4e3b68a68b)


<Br>

- intelliJ에서 MultiModule 생성 방법
  
  https://www.notion.so/3-Spring-Module-in-intelliJ-f753113679384a4c82d1192a65d57350?pvs=4
