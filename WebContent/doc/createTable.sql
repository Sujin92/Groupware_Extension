DROP TABLE orgDB
   CASCADE CONSTRAINTS;

CREATE TABLE orgDB (
   emp_num VARCHAR2(40) NOT NULL, /* 게시판번호 */
   dept_num VARCHAR2(40),
   position_num VARCHAR2(40),
   id  VARCHAR2(40),
   pass  VARCHAR2(40),
   name  VARCHAR2(40),
   gender  VARCHAR2(40),
   email1  VARCHAR2(40),
   email2 VARCHAR2(40),
   tel1 VARCHAR2(40),
   tel2 VARCHAR2(40),
   tel3 VARCHAR2(40),
   picture VARCHAR2(40)
);

INSERT INTO orgDB 
VALUES (1,1,1,1,1,1,1,1,1,1,1,1,1);

INSERT INTO orgDB 
VALUES (1,2,3,4,5,6,7,8,9,10,11,12,13);

INSERT INTO orgDB 
VALUES (123,123,123,123,123,123,123,123,123,123,123,123,123);

INSERT INTO orgDB 
VALUES (132,132,132,132,132,132,132,132,132,132,132,132,132);

INSERT INTO orgDB 
VALUES (test,test,test,test,test,test,test,test,test,test,test,test,test);

INSERT INTO orgDB 
VALUES (test1,test1,test1,test1,test1,test1,test1,test1,test1,test1,test1,test1,test1);

INSERT INTO orgDB 
VALUES (1test,1test,1test,1test,1test,1test,1test,1test,1test,1test,1test,1test,1test);
commit;


emp_num;
dept_num;
position_num;
id;
pass;
name;
gender;
email1;
email2;
tel1;
tel2;
tel3;
picture;
