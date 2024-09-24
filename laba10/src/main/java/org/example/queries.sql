
SELECT s.name, p.grade
FROM students s
         JOIN progress p ON s.id = p.student_id
         JOIN subjects sub ON p.subject_id = sub.id
WHERE p.grade > 3 AND sub.subject_name = 'Математика';

SELECT AVG(grade) AS avg_grade
FROM progress
WHERE subject_id = (SELECT id FROM subjects WHERE subject_name = 'Математика');


SELECT AVG(grade) AS avg_grade
FROM progress
WHERE student_id = 1;

SELECT
    sub.subject_name,
    COUNT(DISTINCT p.student_id) AS student_count
FROM
    progress p
        JOIN
    subjects sub ON p.subject_id = sub.id
GROUP BY
    sub.subject_name
ORDER BY
    student_count DESC;
