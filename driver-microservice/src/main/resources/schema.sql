CREATE TABLE IF NOT EXISTS driver (
  id                BIGINT AUTO_INCREMENT,
  first_name        CHAR(24),
  last_name         CHAR(24),
  phone_number      varchar(40),
  vehicle_id        BIGINT,
  PRIMARY KEY (id)
);
