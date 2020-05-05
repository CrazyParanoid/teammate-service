CREATE TABLE TEAMMATES(
  ID                          bigserial PRIMARY KEY     NOT NULL ,
  TEAMMATE_ID                 VARCHAR (200)             NOT NULL ,
  NAME                        TEXT                      NOT NULL ,
  SUR_NAME                    TEXT                      NOT NULL ,
  PATRONYMIC                  TEXT                      NULL ,
  LOGIN                       VARCHAR (100)             NOT NULL ,
  PASSWORD                    VARCHAR (200)             NOT NULL ,
  EMAIL                       VARCHAR (200)             NOT NULL ,
  PHONE_NUMBER                VARCHAR (200)             NOT NULL ,
  CREATE_DATE                 DATE                      NOT NULL ,
  ROLE                        VARCHAR (100)             NOT NULL
);

CREATE INDEX TEAMMATES_ID_INDEX
  ON TEAMMATES(ID);
