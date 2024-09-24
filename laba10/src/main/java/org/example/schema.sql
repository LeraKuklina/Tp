CREATE TABLE IF NOT EXISTS students (
                                        id SERIAL PRIMARY KEY,
                                        name VARCHAR(100) NOT NULL,
    passport_series SMALLINT NOT NULL,
    passport_number INTEGER NOT NULL,
    UNIQUE (passport_series, passport_number)
    );

CREATE TABLE IF NOT EXISTS subjects (
                                        id SERIAL PRIMARY KEY,
                                        name VARCHAR(100) NOT NULL
    );

CREATE TABLE IF NOT EXISTS progress (
                                        id SERIAL PRIMARY KEY,
                                        student_id INTEGER REFERENCES students(id),
    subject_id INTEGER REFERENCES subjects(id),
    grade INTEGER CHECK (grade >= 2 AND grade <= 5)
    );

