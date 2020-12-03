START TRANSACTION;
INSERT INTO transaction VALUES(null,"127.0.0.1", 1, now());
COMMIT;

-- delivery
START TRANSACTION;
INSERT INTO delivery VALUES(null, 1, 1, 1, last_insert_id(), "127.0.0.1", 1, now());
COMMIT;