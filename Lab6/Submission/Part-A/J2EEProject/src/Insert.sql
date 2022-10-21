use Library;

INSERT INTO book 
    VALUES
        (1, 'Pattern Recognition', 'Comp. Sci.', 'Murphy'),
        (2, 'Database Systems', 'Comp. Sci.', 'Henry'),
        (3, 'Introduction to Biology', 'Biology', 'Campbell'),
        (4, 'Digital Signal Processing', 'EE', 'Oppenheim'),
        (5, 'Mechanical Vibrations', 'MMAE', 'S. Rao');

INSERT INTO student
    VALUES
        (1, 'Abhishek', 'Comp. Sci.', '3', 'Fall'),
        (2, 'Karthik', 'Biology','4', 'Summer'),
        (3, 'Keshav', 'EE', '2', 'Winter'),
        (4, 'Prakash', 'Comp. Sci.', '1', 'Spring'),
        (5, 'Sri Ram', 'MMAE', '3', 'Winter');


INSERT INTO issue 
    VALUES
        (1,1,'2021-11-25','2022-2-28'),
        (1,2,'2021-11-25','2022-2-28'),
        (2,3,'2021-11-12','2022-2-13'),
        (2,4,'2021-11-12','2022-2-13'),
        (3,5,'2021-11-15','2022-2-16'),
        (3,1,'2021-11-15','2022-2-16'),
        (4,3,'2021-11-30','2022-2-15'),
        (4,5,'2021-11-30','2022-2-15'),
        (5,5,'2021-11-13','2022-2-24'),
        (5,1,'2021-11-13','2022-2-24');