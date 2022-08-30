-- sungjukmgmt.sql
create database sungjukmgmt;

create user 'student'@'%' identified by 'javamysql';
grant all privileges on sungjukmgmt.* to 'student'@'%';
flush privileges;

CREATE Table Student
(
	hakbun CHAR(6) PRIMARY KEY,
	irum VARCHAR(20) NOT NULL,
	kor TINYINT NOT NULL,
	eng TINYINT NOT NULL,
	math TINYINT NOT NULL,
	tot SMALLINT,
	avg DECIMAL(5,2),
	grade CHAR(1),
	CONSTRAINT student_grade_ck CHECK(grade IN('A','B','C','D','F'))
);

-- create procedure sp_student_select();

DELIMITER // 
create procedure sp_student_selectAll()
BEGIN
	SELECT hakbun, irum, kor, eng, math, tot, avg, grade
    FROM student
    order by tot desc;
END //
DELIMITER ;


DELIMITER //
create procedure sp_student_insert
(
	IN	v_hakbun	char(6),
    IN	v_irum	varchar(20),
    IN	v_kor     tinyint,
    IN	v_eng     tinyint,
    IN	v_math    tinyint,
    IN 	v_tot	    smallint,
    IN	v_avg     decimal(5,2),
    IN  v_grade   char(1)
)
BEGIN
	INSERT INTO Student 
    VALUES(v_hakbun, v_irum, v_kor, v_eng, v_math, v_tot, v_avg, v_grade);
    COMMIT;
END //
DELIMITER ;
-- create procedure sp_student_update();

-- create procedure sp_student_delete();

