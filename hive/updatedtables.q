DROP TABLE newmovie;

CREATE TABLE newmovie (id INT,
name STRING,
year INT,
numratings INT,
avgrating FLOAT);

INSERT OVERWRITE TABLE newmovie
SELECT id, name, year, COUNT(1), AVG(rating)
FROM movie JOIN movierating
ON movie.id = movierating.movieid
GROUP BY id, name, year;
