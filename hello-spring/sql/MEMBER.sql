DROP TABLE IF EXISTS MEMBER CASCADE;
CREATE TABLE MEMBER (
 ID BIGINT GENERATED BY DEFAULT AS IDENTITY,
 NAME VARCHAR(255) PRIMARY KEY
);

INSERT INTO MEMBER(NAME) VALUES('홈런볼');
INSERT INTO MEMBER(NAME) VALUES('꼬깔콘');