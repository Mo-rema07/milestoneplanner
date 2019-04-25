CREATE TABLE IF NOT EXISTS user
(
    pk_user_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS project
(
    pk_project_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    owner VARCHAR(255),
    email VARCHAR(255),
    fk_user_id   INTEGER FOREIGN KEY REFERENCES user(pk_user_id)

);

CREATE TABLE IF NOT EXISTS milestone
(
    pk_milestone_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    isComplete INTEGER,
    hasStarted INTEGER,
    dueDate text,
    completionDate text,
    name VARCHAR(255),
    fk_project_id   INTEGER FOREIGN KEY REFERENCES user(pk_milestone_id)
);