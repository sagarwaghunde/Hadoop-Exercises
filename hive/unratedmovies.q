SELECT name, year
FROM movie LEFT OUTER JOIN movierating
ON movie.id = movierating.movieid
WHERE movieid IS NULL;
