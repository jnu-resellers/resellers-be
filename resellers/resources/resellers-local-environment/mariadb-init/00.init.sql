CREATE
    USER 'resellers-local'@'localhost' IDENTIFIED BY 'resellers-local';
CREATE
    USER 'resellers-local'@'%' IDENTIFIED BY 'resellers-local';

GRANT ALL PRIVILEGES ON *.* TO
    'resellers-local'@'localhost';
GRANT ALL PRIVILEGES ON *.* TO
    'resellers-local'@'%';

CREATE
DATABASE resellers DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
