SELECT course.course_id, course.title, instructor.ID, instructor.name
FROM
instructor NATURAL JOIN teaches
NATURAL JOIN course

WHERE
instructor.dept_name = "Comp. Sci." AND
course.dept_name     = "Civil"      AND
teaches.year         = 2009

ORDER BY instructor.name ASC;

INSERT INTO course
VALUES
('CS-333','NNDL', 'Comp. Sci.', 6),
('CS-303','AIML', 'Comp. Sci.', 6);

INSERT INTO prereq
VALUES
('CS-333','CS-303');

UPDATE instructor
SET instructor.salary = instructor.salary*1.1
WHERE instructor.dept_name IN (SELECT department.dept_name FROM department WHERE department.budget > 900000.00);


SELECT course.course_id, course.title, COUNT(takes.ID) As 'No. of Students'
FROM
takes NATURAL JOIN course

WHERE
course.dept_name = 'Comp. Sci.' AND
takes.semester   = 'Fall' AND
takes.year       = 2007
GROUP BY course.course_id
HAVING 'No. of Students' > 15
ORDER BY course.course_id ASC;