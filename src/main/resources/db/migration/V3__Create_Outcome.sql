CREATE TABLE outcome
  (
     id           UUID NOT NULL,
     year_outcome  INT NOT NULL,
     month_outcome INT NOT NULL,
     amount       DECIMAL NOT NULL,
     owner_id     UUID NOT NULL,
     PRIMARY KEY (id),
     CONSTRAINT fk_owner_outcome
           FOREIGN KEY(owner_id)
     	  REFERENCES account_owner(id)
  );