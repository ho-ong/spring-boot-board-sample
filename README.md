# spring-boot-board-sample
> Spring Boot를 사용한 게시판 기능 구현 샘플.

## 개발 환경(Development Environment)
- IDE : IntelliJ IDEA Community Edition
- Language : JAVA 11 (JDK 11.0.18)
- Framework : Spring Boot 2.7.8
- Build Tool : Gradle 7.6
- DBMS : MySQL 8.0.31 for Linux

## 주요 기능(Main Function)
- 회원(member)
  - 로그인(login) : /member/login
  - 로그아웃(logout) : /member/logout
  - 회원가입(join) : /member/join
  - 회원목록(list) : /member/
  - 회원정보 조회(detail) : /member/{id}
  - 회원정보 수정(update) : /member/update
  - 회원정보 삭제(delete) : /member/delete/{id}

- 게시판(board)
  - 게시글 작성(write) : /board/write
  - 게시글 목록(list) : /board/
  - 게시글 조회(detail) : /board/{id}
  - 게시글 수정(update) : /board/update/{id}
  - 게시글 삭제(delete) : /board/delete/{id}
  - 게시글 페이징(paging) : /board/paging
    - /board/paging?page=1
  - 파일 첨부(file upload) : /board/write
    - 단일 파일 첨부, 다중 파일 첨부

## 추가 기능(Add Function)
- 회원(member)
  - ajax 이메일 중복체크 : /member/email-check

- 게시판(board)
  - ajax 댓글 작성 : /comment/write

## MySQL DataBase 테이블
```SQL
create table board (
    id             bigint auto_increment primary key,
    created_time   datetime     null,
    updated_time   datetime     null,
    board_contents varchar(500) null,
    board_hits     int          null,
    board_pass     varchar(255) null,
    board_title    varchar(255) null,
    board_writer   varchar(20)  not null,
    file_attached  int          null
);

create table board_file (
    id                 bigint auto_increment primary key,
    created_time       datetime     null,
    updated_time       datetime     null,
    original_file_name varchar(255) null,
    stored_file_name   varchar(255) null,
    board_id           bigint       null,
    constraint FK_BOARD_ID foreign key (board_id) references board (id) on delete cascade
);
```

## MySQL DataBase 계정 생성 및 권한 부여
```SQL
create database springboot_board;
create hoong@localhost identified by '8888';
grant all privileges on springboot_board.* to hoong@localhost;
```
