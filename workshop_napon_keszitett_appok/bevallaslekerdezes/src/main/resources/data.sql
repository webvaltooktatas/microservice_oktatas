
INSERT INTO maganember(id, nev, cim_id, adoszam, adokulcs) VALUES ("1","Adam", NULL, "123456789", "0.27");
INSERT INTO maganember(id, nev, cim_id, adoszam, adokulcs) VALUES ("2","Marta", NULL, "987654321", "0.27");

INSERT INTO ceg(id, nev, cim_id, adoszam, adokulcs, maganember_id) VALUES ("1","Dohanybolt", NULL, "32987654", "0.35", "1");
INSERT INTO ceg(id, nev, cim_id, adoszam, adokulcs, maganember_id) VALUES ("2","Kisbolt", NULL, "123456789", "0.35", "2");