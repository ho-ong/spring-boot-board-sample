# spring-boot-board-sample
> Spring Boot Board Sample.

<br>

## Development Environment
<div style="display: inline-block">
    <img src="https://img.shields.io/badge/IntelliJ%20IDEA-000000?style=flat&logo=IntelliJIDEA&logoColor=white" />
    <img src="https://img.shields.io/badge/HTML-E34F26?style=flat&logo=HTML5&logoColor=white" />
    <img src="https://img.shields.io/badge/CSS-1572B6?style=flat&logo=CSS3&logoColor=white" />
    <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat&logo=JavaScript&logoColor=white" />
    <img src="https://img.shields.io/badge/jQuery-0769AD?style=flat&logo=jQuery&logoColor=white" />
    <img src="https://img.shields.io/badge/Java-007396?style=flat&logo=coffeescript&logoColor=white" />
    <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat&logo=SpringBoot&logoColor=white" />
    <img src="https://img.shields.io/badge/Gradle-02303A?style=flat&logo=Gradle&logoColor=white" />
    <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=MySQL&logoColor=white" />
</div>

<br>

- IDE : IntelliJ IDEA
- Language : HTML5, CSS3, JavaScript (ES6), JAVA 11 (JDK 11.0.18)
- Library : jQuery 3.6.3
- Framework : Spring Boot 2.7.8
- Build Tool : Gradle 7.6
- DBMS : MySQL 8.0.31 for Linux

<br>

## Main Function
- 회원(Member)
    - 로그인(Login) : /member/login
    - 로그아웃(Logout) : /member/logout
    - 회원가입(Join) : /member/join
    - 회원목록(List) : /member/
    - 회원정보 조회(Detail) : /member/{id}
    - 회원정보 수정(Update) : /member/update
    - 회원정보 삭제(Delete) : /member/delete/{id}

- 게시판(Board)
    - 게시글 작성(Write) : /board/write
    - 게시글 목록(List) : /board/
    - 게시글 조회(Detail) : /board/{id}
    - 게시글 수정(Update) : /board/update/{id}
    - 게시글 삭제(Delete) : /board/delete/{id}
    - 게시글 페이징(Paging) : /board/paging
        - /board/paging?page=1
    - 파일 첨부(File Upload) : /board/write, /board/detail
        - 단일 파일 첨부, 다중 파일 첨부

<br>

## Add Function
- 회원(Member)
    - Ajax 이메일 중복체크 : /member/email-check

- 게시판(Board)
    - Ajax 댓글 작성 : /comment/write

<br>

## Create MySQL Database
```SQL
create database springboot_board;
create hoong@localhost identified by '8888';
grant all privileges on springboot_board.* to hoong@localhost;
```

<br>

## MySQL Database Table
```SQL
/* 회원 */
drop table if exists springboot_board.member;

create table springboot_board.member (
    id              bigint primary key not null auto_increment,
    member_email    varchar(255) unique null,
    member_name     varchar(255) null,
    member_password varchar(255) null
);


/* 게시판 */
drop table if exists springboot_board.board;

create table springboot_board.board (
    id             bigint primary key not null auto_increment,
    created_time   datetime default now() null,
    updated_time   datetime               null,
    board_writer   varchar(20)            not null,
    board_password varchar(255)           null,
    board_title    varchar(255)           null,
    board_contents varchar(500)           null,
    board_hits     int default 0          null,
    file_attached  int default 0          null
);


/* 게시판 파일 */
drop table if exists springboot_board.board_file;

create table springboot_board.board_file (
    id                 bigint primary key not null auto_increment,
    created_time       datetime default now() null,
    updated_time       datetime               null,
    original_file_name varchar(255)           null,
    stored_file_name   varchar(255)           null,
    board_id           bigint                 null,
    constraint fk_board_file foreign key (board_id) references board (id) on delete cascade
);


/* 댓글 */
drop table if exists springboot_board.comment;

create table springboot_board.comment (
    id               bigint primary key not null auto_increment,
    created_time     datetime default now() null,
    updated_time     datetime               null,
    comment_writer   varchar(20)            not null,
    comment_contents varchar(255)           null,
    board_id         bigint                 null,
    constraint fk_comment foreign key (board_id) references board (id) on delete cascade
);
```

<br>

## View
###### Index
<kbd><img src="image/page/img_page_index.png" /></kbd>

###### Member - Main (After Login) & Update
<kbd><img src="image/page/img_page_main.png" /></kbd>
<kbd><img src="image/page/member/img_page_member_update.png" /></kbd>

###### Member - Login
<kbd><img src="image/page/member/img_page_member_login.png" /></kbd>

###### Member - Join
<kbd><img src="image/page/member/img_page_member_join.png" /></kbd>

###### Member - List & Detail
<kbd><img src="image/page/member/img_page_member_list.png" /></kbd>
<kbd><img src="image/page/member/img_page_member_detail.png" /></kbd>

###### Board - Write & Update
<kbd><img src="image/page/board/img_page_board_write.png" /></kbd>
<kbd><img src="image/page/board/img_page_board_update.png" /></kbd>

###### Board - List & Paging & Detail
<kbd><img src="image/page/board/img_page_board_list.png" /></kbd>
<kbd><img src="image/page/board/img_page_board_paging.png" /></kbd>
<kbd><img src="image/page/board/img_page_board_detail.png" /></kbd>
