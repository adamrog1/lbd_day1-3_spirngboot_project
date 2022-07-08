CREATE TABLE Sprints(
    sprints_id int primary key not null auto_increment,
    name varchar(30),
    start_date date,
    end_date date,
    description_of_aim text(250),
    status enum('Pending', 'In_progress', 'Finished', 'Canceled')
);

CREATE TABLE UserStories(
    user_stories_id int primary key auto_increment not null,
    name varchar(30),
    description text(250),
    attachments varbinary(16),
    story_points int,
    status enum('To_do', 'In_progress', 'Review', 'Done')
);

CREATE TABLE References(
    user_stories_id int,
    foreign key (user_stories_id) references UserStories(user_stories_id),
    sprints_id int,
    foreign key (sprints_id) references Sprints(sprints_id)
)