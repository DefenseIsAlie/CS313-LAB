use Library;

CREATE TABLE book
    (
        book_id     INT,
        tittle      VARCHAR(50) NOT NULL,
        category    VARCHAR(20) NOT NULL,
        author      VARCHAR(50) NOT NULL,

        PRIMARY KEY(book_id)
    );

CREATE TABLE student
    (
        student_id  INT,
        name        VARCHAR(50) NOT NULL,
        dept_name   VARCHAR(10) NOT NULL,
        year        VARCHAR(2) check (year in 
                                        ('1', '2', '3', '4')),
        semester    varchar (6) check (semester in
                                        ('Fall', 'Winter', 'Spring', 'Summer')),

        PRIMARY KEY(student_id)
    );

CREATE TABLE issue
    (
        student_id  INT,
        book_id     INT,
        issue_date  DATE NOT NULL,
        return_date DATE NOT NULL,

        check (issue_date < return_date),
        FOREIGN KEY(student_id) REFERENCES student(student_id),
        FOREIGN KEY(book_id) REFERENCES book(book_id)
    );
    
CREATE TABLE user
    (
       id VARCHAR(5),
       password VARCHAR(10) NOT NULL,
       
       PRIMARY KEY(id)
    );
