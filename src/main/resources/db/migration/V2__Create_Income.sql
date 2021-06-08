CREATE TABLE income
  (
     id           UUID NOT NULL,
     year_income  INT NOT NULL,
     month_income INT NOT NULL,
     amount       DECIMAL NOT NULL,
     owner_id     UUID NOT NULL,
     PRIMARY KEY (id),
     CONSTRAINT fk_owner
           FOREIGN KEY(owner_id)
     	  REFERENCES account_owner(id)
  );