CREATE TABLE TEAMMATE_TASKS  (
    ID                          bigserial PRIMARY KEY        NOT NULL ,
    TASK_ID                     VARCHAR (100)                NULL ,
    TEAMMATE_ID                 bigint                       NULL ,
    FOREIGN KEY (TEAMMATE_ID) REFERENCES TEAMMATES
);

CREATE INDEX TEAMMATE_TASKS_ID_INDEX
  ON TEAMMATE_TASKS(ID);