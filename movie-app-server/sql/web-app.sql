CREATE TABLE role (
 id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
 created TIMESTAMP NULL DEFAULT NULL,
 modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 name varchar(255) CHARACTER SET utf8 COLLATE utf8_bin,
 abbr varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
 deleted int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE UNIQUE INDEX role_idx0 ON role (abbr);
CREATE INDEX role_idx1 ON role (name);
CREATE INDEX role_idx2 ON role (deleted);
INSERT INTO role (created, name, abbr)
VALUES (NOW(), 'Administrator', 'ADMIN'), (NOW(), 'Użytkownik', 'USER');

CREATE TABLE user_account (
 id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
 created TIMESTAMP NULL DEFAULT NULL,
 modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 email varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
 pass_hash varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
 pass_salt varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
 deleted int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE UNIQUE INDEX user_account_idx0 ON user_account (email);
CREATE INDEX user_account_idx1 ON user_account (deleted);

CREATE TABLE user_account_role (
 id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
 created TIMESTAMP NULL DEFAULT NULL,
 modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 user_account_id INT UNSIGNED NOT NULL,
 role_id INT UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE UNIQUE INDEX user_account_role_idx0 ON user_account_role (user_account_id,
role_id);
ALTER TABLE user_account_role ADD CONSTRAINT user_account_role_fk0 FOREIGN KEY
(user_account_id) REFERENCES user_account (id);
ALTER TABLE user_account_role ADD CONSTRAINT user_account_role_fk1 FOREIGN KEY (role_id)
REFERENCES role (id);

CREATE TABLE api_token (
 id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
 created TIMESTAMP NULL DEFAULT NULL,
 modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 user_account_id INT UNSIGNED NOT NULL,
 access_token varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
 refresh_token varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
 valid_to TIMESTAMP NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE UNIQUE INDEX api_token_idx0 ON api_token (access_token);
CREATE INDEX api_token_idx1 ON api_token (created);
CREATE INDEX api_token_idx2 ON api_token (valid_to);
ALTER TABLE api_token ADD CONSTRAINT api_token_fk0 FOREIGN KEY (user_account_id)
REFERENCES user_account (id);

CREATE TABLE actor (
 id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
 created TIMESTAMP NULL DEFAULT NULL,
 modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 first_name varchar(255) CHARACTER SET utf8 COLLATE utf8_bin,
 last_name varchar(255) CHARACTER SET utf8 COLLATE utf8_bin,
 deleted int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE INDEX actor_idx0 ON actor (last_name);
CREATE INDEX actor_idx1 ON actor (deleted);

CREATE TABLE director (
 id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
 created TIMESTAMP NULL DEFAULT NULL,
 modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 first_name varchar(255) CHARACTER SET utf8 COLLATE utf8_bin,
 last_name varchar(255) CHARACTER SET utf8 COLLATE utf8_bin,
 deleted int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE INDEX director_idx0 ON director (last_name);
CREATE INDEX director_idx1 ON director (deleted);

CREATE TABLE movie_genre (
 id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
 created TIMESTAMP NULL DEFAULT NULL,
 modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 name varchar(255) CHARACTER SET utf8 COLLATE utf8_bin,
 abbr varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
 deleted int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE UNIQUE INDEX movie_genre_idx0 ON movie_genre (abbr);
CREATE INDEX movie_genre_idx1 ON movie_genre (name);
CREATE INDEX movie_genre_idx2 ON movie_genre (deleted);

CREATE TABLE movie (
 id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
 created TIMESTAMP NULL DEFAULT NULL,
 modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 genre_id INT UNSIGNED,
 director_id INT UNSIGNED,
 title varchar(255) CHARACTER SET utf8 COLLATE utf8_bin,
 release_year varchar(80) CHARACTER SET utf8 COLLATE utf8_bin,
 deleted int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE INDEX movie_idx0 ON movie (title);
CREATE INDEX movie_idx1 ON movie (release_year);
ALTER TABLE movie ADD CONSTRAINT movie_fk0 FOREIGN KEY (genre_id) REFERENCES movie_genre
(id);
ALTER TABLE movie ADD CONSTRAINT movie_fk1 FOREIGN KEY (director_id) REFERENCES director
(id);

CREATE TABLE movie_actor (
 id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
 created TIMESTAMP NULL DEFAULT NULL,
 modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 movie_id INT UNSIGNED NOT NULL,
 actor_id INT UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE UNIQUE INDEX movie_actor_idx0 ON movie_actor (movie_id, actor_id);
ALTER TABLE movie_actor ADD CONSTRAINT movie_actor_fk0 FOREIGN KEY (movie_id) REFERENCES
movie (id);
ALTER TABLE movie_actor ADD CONSTRAINT movie_actor_fk1 FOREIGN KEY (actor_id) REFERENCES
actor (id);

CREATE TABLE movie_rating (
 id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
 created TIMESTAMP NULL DEFAULT NULL,
 modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 movie_id INT UNSIGNED NOT NULL,
 user_account_id INT UNSIGNED NOT NULL,
 rate TINYINT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE UNIQUE INDEX movie_rating_idx0 ON movie_rating (movie_id, user_account_id);
ALTER TABLE movie_rating ADD CONSTRAINT movie_rating_fk0 FOREIGN KEY (movie_id) REFERENCES
movie (id);
ALTER TABLE movie_rating ADD CONSTRAINT movie_rating_fk1 FOREIGN KEY (user_account_id)
REFERENCES user_account (id);

CREATE TABLE movie_library_status (
 id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
 created TIMESTAMP NULL DEFAULT NULL,
 modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 name varchar(255) CHARACTER SET utf8 COLLATE utf8_bin,
 abbr varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
 deleted int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE UNIQUE INDEX movie_library_status_idx0 ON movie_library_status (abbr);
CREATE INDEX movie_library_status_idx1 ON movie_library_status (name);
CREATE INDEX movie_library_status_idx2 ON movie_library_status (deleted);

CREATE TABLE movie_library (
 id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
 created TIMESTAMP NULL DEFAULT NULL,
 modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 movie_id INT UNSIGNED NOT NULL,
 user_account_id INT UNSIGNED NOT NULL,
 movie_library_status_id INT UNSIGNED
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE UNIQUE INDEX movie_library_idx0 ON movie_library (movie_id, user_account_id);
ALTER TABLE movie_library ADD CONSTRAINT movie_library_fk0 FOREIGN KEY (movie_id)
REFERENCES movie (id);
ALTER TABLE movie_library ADD CONSTRAINT movie_library_fk1 FOREIGN KEY (user_account_id)
REFERENCES user_account (id);
ALTER TABLE movie_library ADD CONSTRAINT movie_library_fk2 FOREIGN KEY
(movie_library_status_id) REFERENCES movie_library_status (id);

CREATE TABLE movie_request_status (
 id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
 created TIMESTAMP NULL DEFAULT NULL,
 modified TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 name varchar(255) CHARACTER SET utf8 COLLATE utf8_bin,
 abbr varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
 deleted int(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
CREATE UNIQUE INDEX movie_request_status_idx0 ON movie_request_status (abbr);
CREATE INDEX movie_request_status_idx1 ON movie_request_status (name);
CREATE INDEX movie_request_status_idx2 ON movie_request_status (deleted);

ALTER TABLE movie ADD request_status_id INT UNSIGNED AFTER modified;
ALTER TABLE movie ADD CONSTRAINT movie_fk2 FOREIGN KEY (request_status_id) REFERENCES
movie_request_status (id);