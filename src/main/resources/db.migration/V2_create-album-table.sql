CREATE TABLE album(
    id TEXT PRIMARY KEY UNIQUE NOT NULL ,
    spotify_id TEXT NOT NULL,
    name TEXT NOT NULL,
    coverImage TEXT NOT NULL,
)