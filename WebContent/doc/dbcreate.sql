/* users */
DROP TABLE member_info 
   CASCADE CONSTRAINTS;

/* users2 */
DROP TABLE member_detail_info 
   CASCADE CONSTRAINTS;

/* users6 */
DROP TABLE board 
   CASCADE CONSTRAINTS;

/* users7 */
DROP TABLE noticeboard 
   CASCADE CONSTRAINTS;

/* users8 */
DROP TABLE faqboard 
   CASCADE CONSTRAINTS;

/* users9 */
DROP TABLE qnaboard 
   CASCADE CONSTRAINTS;

/* users10 */
DROP TABLE board_list 
   CASCADE CONSTRAINTS;

/* users11 */
DROP TABLE category 
   CASCADE CONSTRAINTS;

/* users12 */
DROP TABLE board_type 
   CASCADE CONSTRAINTS;

/* users13 */
DROP TABLE position_info 
   CASCADE CONSTRAINTS;

/* users14 */
DROP TABLE project 
   CASCADE CONSTRAINTS;

/* users15 */
DROP TABLE commute 
   CASCADE CONSTRAINTS;

/* users16 */
DROP TABLE standard_commute 
   CASCADE CONSTRAINTS;

/* users17 */
DROP TABLE schedule 
   CASCADE CONSTRAINTS;

/* users18 */
DROP TABLE document_info 
   CASCADE CONSTRAINTS;

/* users19 */
DROP TABLE holiday_paper 
   CASCADE CONSTRAINTS;

/* users20 */
DROP TABLE order_paper 
   CASCADE CONSTRAINTS;

/* users21 */
DROP TABLE spending_paper 
   CASCADE CONSTRAINTS;

/* users22 */
DROP TABLE draft_paper 
   CASCADE CONSTRAINTS;

/* users23 */
DROP TABLE document_type_info 
   CASCADE CONSTRAINTS;

/* users24 */
DROP TABLE dept_info 
   CASCADE CONSTRAINTS;

/* users */
CREATE TABLE member_info (
   emp_num VARCHAR2(10) NOT NULL, /* 새 컬럼 */
   dept_num NUMBER NOT NULL, /* 새 컬럼8 */
   position_num VARCHAR2(10) NOT NULL, /* 새 컬럼7 */
   id VARCHAR2(10) NOT NULL, /* 새 컬럼3 */
   pass VARCHAR2(10) NOT NULL, /* 새 컬럼6 */
   name VARCHAR2(10) NOT NULL, /* 새 컬럼9 */
   gender VARCHAR2(10) NOT NULL, /* 새 컬럼10 */
   email1 VARCHAR2(40) NOT NULL, /* 새 컬럼2 */
   email2 VARCHAR2(40) NOT NULL, /* 새 컬럼11 */
   tel1 VARCHAR2(3) NOT NULL, /* 새 컬럼5 */
   tel2 VARCHAR2(4) NOT NULL, /* 새 컬럼4 */
   tel3 VARCHAR2(4) NOT NULL, /* 새 컬럼12 */
   picture VARCHAR2(30) /* 새 컬럼13 */
);

CREATE UNIQUE INDEX PK_member_info
   ON member_info (
      emp_num ASC
   );

/* users2 */
CREATE TABLE member_detail_info (
   emp_num VARCHAR2(10) NOT NULL, /* 새 컬럼 */
   year VARCHAR2(10) NOT NULL, /* 새 컬럼8 */
   month VARCHAR2(10) NOT NULL, /* 새 컬럼2 */
   day VARCHAR2(10) NOT NULL, /* 새 컬럼4 */
   marriage VARCHAR2(10) NOT NULL, /* 새 컬럼7 */
   hire_date VARCHAR2(10) NOT NULL, /* 새 컬럼3 */
   out_date VARCHAR2(10) /* 새 컬럼6 */
);

CREATE UNIQUE INDEX PK_member_detail_info
   ON member_detail_info (
      emp_num ASC
   );

/* users6 */
CREATE TABLE board (
   seq NUMBER NOT NULL, /* 새 컬럼 */
   emp_num VARCHAR2(10) NOT NULL, /* 새 컬럼2 */
   subject VARCHAR2(100) NOT NULL, /* 새 컬럼3 */
   content CLOB NOT NULL, /* 새 컬럼4 */
   hit NUMBER, /* 새 컬럼5 */
   logtime DATE NOT NULL, /* 새 컬럼6 */
   bcode NUMBER NOT NULL /* 새 컬럼7 */
);

CREATE UNIQUE INDEX PK_board
   ON board (
      seq ASC
   );

/* users7 */
CREATE TABLE noticeboard (
   nseq NUMBER NOT NULL, /* 새 컬럼 */
   seq NUMBER NOT NULL /* 새 컬럼2 */
);

CREATE UNIQUE INDEX PK_noticeboard
   ON noticeboard (
      nseq ASC
   );

/* users8 */
CREATE TABLE faqboard (
   mseq VARCHAR2(10) NOT NULL, /* 새 컬럼 */
   seq NUMBER NOT NULL /* 새 컬럼2 */
);

CREATE UNIQUE INDEX PK_faqboard
   ON faqboard (
      mseq ASC
   );

/* users9 */
CREATE TABLE qnaboard (
   nseq NUMBER NOT NULL, /* 새 컬럼 */
   seq NUMBER NOT NULL, /* 새 컬럼2 */
   ref NUMBER, /* 새 컬럼3 */
   lev NUMBER, /* 새 컬럼4 */
   step NUMBER, /* 새 컬럼5 */
   pseq NUMBER, /* 새 컬럼6 */
   reply NUMBER /* 새 컬럼7 */
);

CREATE UNIQUE INDEX PK_qnaboard
   ON qnaboard (
      nseq ASC
   );

/* users10 */
CREATE TABLE board_list (
   bcode NUMBER NOT NULL, /* 새 컬럼 */
   bname VARCHAR2(100) NOT NULL, /* 새 컬럼2 */
   btype NUMBER NOT NULL, /* 새 컬럼3 */
   ccode NUMBER NOT NULL /* 새 컬럼4 */
);

CREATE UNIQUE INDEX PK_board_list
   ON board_list (
      bcode ASC
   );

/* users11 */
CREATE TABLE category (
   ccode NUMBER NOT NULL, /* 새 컬럼 */
   cname VARCHAR2(100) NOT NULL /* 새 컬럼2 */
);

CREATE UNIQUE INDEX PK_category
   ON category (
      ccode ASC
   );

/* users12 */
CREATE TABLE board_type (
   btype NUMBER NOT NULL, /* 새 컬럼 */
   btype_name VARCHAR2(100) NOT NULL /* 새 컬럼2 */
);

CREATE UNIQUE INDEX PK_board_type
   ON board_type (
      btype ASC
   );

/* users13 */
CREATE TABLE position_info (
   position_num VARCHAR2(10) NOT NULL, /* 새 컬럼 */
   position_name VARCHAR2(10) NOT NULL /* 새 컬럼2 */
);

CREATE UNIQUE INDEX PK_position_info
   ON position_info (
      position_num ASC
   );

/* users14 */
CREATE TABLE project (
   content_num NUMBER NOT NULL, /* 새 컬럼 */
   project_content CLOB, /* 새 컬럼2 */
   project_progress VARCHAR2(10), /* 새 컬럼3 */
   project_num NUMBER(10), /* 새 컬럼4 */
   project_name VARCHAR2(50), /* 새 컬럼5 */
   dept_num VARCHAR2(10), /* 새 컬럼6 */
   emp_num VARCHAR2(10) /* 새 컬럼7 */
);

CREATE UNIQUE INDEX PK_project
   ON project (
      content_num ASC
   );

/* users15 */
CREATE TABLE commute (
   emp_num VARCHAR2(10) NOT NULL, /* 새 컬럼 */
   commute_date VARCHAR2(10), /* 새 컬럼2 */
   checkin VARCHAR2(10), /* 새 컬럼3 */
   checkout VARCHAR2(10), /* 새 컬럼4 */
   commute_divsion VARCHAR2(10) /* 새 컬럼5 */
);

CREATE UNIQUE INDEX PK_commute
   ON commute (
      emp_num ASC
   );

/* users16 */
CREATE TABLE standard_commute (
   standard_checkin VARCHAR2(10) NOT NULL, /* 새 컬럼 */
   standard_checkout VARCHAR2(10) /* 새 컬럼2 */
);

CREATE UNIQUE INDEX PK_standard_commute
   ON standard_commute (
      standard_checkin ASC
   );

/* users17 */
CREATE TABLE schedule (
   emp_num VARCHAR2(10) NOT NULL, /* 새 컬럼 */
   schedule_subject VARCHAR2(24), /* 새 컬럼2 */
   schedule_content VARCHAR2(100), /* 새 컬럼3 */
   schedule_start VARCHAR2(10), /* 새 컬럼4 */
   schedule_start_time VARCHAR2(10), /* 새 컬럼5 */
   schedule_end VARCHAR2(10), /* 새 컬럼6 */
   schedule_end_time VARCHAR2(10), /* 새 컬럼7 */
   schedule_division VARCHAR2(10) /* 새 컬럼8 */
);

CREATE UNIQUE INDEX PK_schedule
   ON schedule (
      emp_num ASC
   );

/* users18 */
CREATE TABLE document_info (
   doc_num VARCHAR2(10) NOT NULL, /* 새 컬럼 */
   emp_num VARCHAR2(10) NOT NULL, /* 새 컬럼8 */
   doc_type_num VARCHAR2(10) NOT NULL, /* 새 컬럼7 */
   doc_name VARCHAR2(50) NOT NULL, /* 새 컬럼3 */
   doc_state VARCHAR2(10) NOT NULL, /* 새 컬럼6 */
   doc_subject VARCHAR2(100) NOT NULL, /* 새 컬럼9 */
   draft_date VARCHAR2(10) NOT NULL, /* 새 컬럼10 */
   receive_dept VARCHAR2(20) NOT NULL, /* 새 컬럼2 */
   confirm_line_1 VARCHAR2(20), /* 새 컬럼11 */
   confirm_line_2 VARCHAR2(20), /* 새 컬럼5 */
   confirm_line_3 VARCHAR2(20), /* 새 컬럼4 */
   confirm_line_1_ok VARCHAR2(2), /* 새 컬럼12 */
   confirm_line_2_ok VARCHAR2(2), /* 새 컬럼13 */
   confirm_line_3_ok VARCHAR2(2), /* 새 컬럼14 */
   attachment_path VARCHAR2(50) /* 새 컬럼15 */
);

CREATE UNIQUE INDEX PK_document_info
   ON document_info (
      doc_num ASC
   );

/* users19 */
CREATE TABLE holiday_paper (
   doc_num VARCHAR2(10) NOT NULL, /* 새 컬럼 */
   holiday_start VARCHAR2(10) NOT NULL, /* 새 컬럼2 */
   holiday_end VARCHAR2(10) NOT NULL, /* 새 컬럼3 */
   holiday_type VARCHAR2(20) NOT NULL, /* 새 컬럼4 */
   holliday_reason CLOB /* 새 컬럼5 */
);

CREATE UNIQUE INDEX PK_holiday_paper
   ON holiday_paper (
      doc_num ASC
   );

/* users20 */
CREATE TABLE order_paper (
   doc_num VARCHAR2(10) NOT NULL, /* 새 컬럼 */
   order_content CLOB NOT NULL /* 새 컬럼2 */
);

CREATE UNIQUE INDEX PK_order_paper
   ON order_paper (
      doc_num ASC
   );

/* users21 */
CREATE TABLE spending_paper (
   doc_num VARCHAR2(10) NOT NULL, /* 새 컬럼 */
   spending_content CLOB NOT NULL /* 새 컬럼2 */
);

CREATE UNIQUE INDEX PK_spending_paper
   ON spending_paper (
      doc_num ASC
   );

/* users22 */
CREATE TABLE draft_paper (
   doc_num VARCHAR2(10) NOT NULL, /* 새 컬럼 */
   draft_content CLOB NOT NULL /* 새 컬럼2 */
);

CREATE UNIQUE INDEX PK_draft_paper
   ON draft_paper (
      doc_num ASC
   );

/* users23 */
CREATE TABLE document_type_info (
   doc_type_num VARCHAR2(10) NOT NULL, /* 새 컬럼 */
   doc_type VARCHAR2(20) /* 새 컬럼2 */
);

CREATE UNIQUE INDEX PK_document_type_info
   ON document_type_info (
      doc_type_num ASC
   );

/* users24 */
CREATE TABLE dept_info (
   dept_num NUMBER NOT NULL, /* 새 컬럼 */
   dept_name VARCHAR2(50) NOT NULL /* 새 컬럼2 */
);

CREATE UNIQUE INDEX PK_dept_info
   ON dept_info (
      dept_num ASC);

create sequence EMP_NUM start with 1 increment BY 1;

create sequence schedule_seq start with 1 increment by 1;

drop table schedule;

create table schedule (
seq number,
emp_num varchar2(20),
schedule_subject varchar2(50),
schedule_content varchar2(2000),
schedule_startdate date,
schedule_enddate date
);


