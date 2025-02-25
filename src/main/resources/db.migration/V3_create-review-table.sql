CREATE TABLE review (
     id UUID PRIMARY KEY,
     user_id UUID REFERENCES user(id),
     album_id UUID,
     rating DECIMAL(3, 1),
     comment TEXT
);