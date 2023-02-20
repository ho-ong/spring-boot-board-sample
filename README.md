# spring-boot-board-sample
> Spring Boot를 사용한 게시판 기능 구현 샘플.

<br>

## 버전(Version)
- Language: JAVA 11 (JDK 11.0.18)
- Framework: Spring Boot 2.7.8 (Spring Dependency Management 1.0.15)
- Build Tool: Gradle 7.6
- DBMS: MySQL 8.0.31 for Linux
- Dependencies :
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
  - 회원조회(detail) : /member/detail
  - 회원수정(update) : /member/update
  - 회원삭제(delete) : /member/delete
  - 추가기능 : ajax 이메일(아이디) 중복체크

- 게시판(board)
  - 글작성(write) : /board/write
  - 글목록(list) : /board/list
  - 글조회(detail) : /board/detail
  - 글수정(update) : /board/update
  - 글삭제(delete) : /board/delete
  - 페이징 처리(paging)
  - 파일(이미지) 첨부
  - 추가기능 : ajax 댓글 처리
