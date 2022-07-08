
CREATE TABLE Sprints(
    id int primary key not null ,
    name varchar(30),
    start_date date,
    end_date date,
    description_of_aim text(250),
    status enum('Pending', 'In_progress', 'Finished', 'Canceled'),
    user_stories text(1000)
);

CREATE TABLE UserStories(
    id int primary key not null,
    name varchar(30),
    description text(250),
    attachments varbinary(16),
    story_points int,
    status enum('To_do', 'In_progress', 'Review', 'Done'),
    sprints text(1000)

)