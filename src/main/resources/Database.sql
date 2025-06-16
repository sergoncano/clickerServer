-- Database
CREATE DATABASE 'clickerdb';
USE 'clickerdb';

-- Unique table
CREATE TABLE Users (
	UUID VARCHAR(255) PRIMARY KEY,
	username VARCHAR(255) NOT NULL,
	score INT NOT NULL
);


INSERT INTO Users 
VALUES ('241286d7-e2a1-44e6-a898-783793bca8c0', "Sergio", 10);

