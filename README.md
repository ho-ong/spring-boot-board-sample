# spring-boot-board-sample
> Spring Boot를 사용한 게시판 기능 구현 샘플.

<br>

## 버전(Version)
- Language: JAVA 11 (JDK 11.0.18)
- Framework: Spring Boot 2.7.8 (Spring Dependency Management 1.0.15)
- Build Tool: Gradle 7.6
- DBMS: MySQL 8.0.31 for Linux
- Dependencies
  - Spring Data JPA
  - Thymeleaf
  - Lombok
  - Gradle
  - MySQL

<br>

## 기능(Function)
- 회원(member)
  - 로그인(login) : /member/login
  - 로그아웃(logout) : /member/logout
  - 회원가입(join) : /member/join
  - 회원목록(list) : /member/list
  - 회원정보 조회(detail) : /member/detail
  - 회원정보 수정(update) : /member/update
  - 회원정보 삭제(delete) : /member/delete
  - 추가 기능 - ajax 이메일 중복체크 : /member/email-check

- 게시판(board)
  - 게시글 작성(write) : /board/write
  - 게시글 목록(list) : /board/list
  - 게시글 조회(detail) : /board/detail
  - 게시글 수정(update) : /board/update
  - 게시글 삭제(delete) : /board/delete
  - 게시글 페이징(paging) : /board/paging
    - /board/paging?page=1
  - 파일 첨부(file upload)
    - 단일 파일 첨부
  - 추가 기능 - ajax 댓글 처리
