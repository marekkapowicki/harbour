INSERT INTO User(id, login_id, password, role) VALUES (1, 'ashish.jain@ing.com', 'somePassword', 'customer');
INSERT INTO Client(id, name, email) VALUES (1, 'ashish', 'ashish.jain@ing.com');

INSERT INTO STATUS(id, name, description, duration_in_days) VALUES (1, 'sea', 'on ship now', 3);
INSERT INTO STATUS(id, name, description, duration_in_days) VALUES (2, 'carrier', 'landings', 1);
INSERT INTO STATUS(id, name, description, duration_in_days) VALUES (3, 'terminal', 'on terminal', 1);
INSERT INTO STATUS(id, name, description, duration_in_days) VALUES (4, 'forwarder', 'on the track', 0);
INSERT INTO STATUS(id, name, description, duration_in_days) VALUES (5, 'warehouse', 'on the track', 0);