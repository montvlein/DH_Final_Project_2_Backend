INSERT INTO categories( description, url_image) VALUES('Concierto','https://www.tuentrada.com/images/64ef2a94a573c.webp');
INSERT INTO categories( description, url_image) VALUES( 'Teatro','https://www.tuentrada.com/images/64ef2a94a573c.webp');

INSERT INTO venues(venue, country, city, address) VALUES ('Ferrocarril Oeste', 'Argentina', 'Buenos Aires', 'Av. Avellaneda 1240, Caballito')
INSERT INTO venues(venue, country, city, address) VALUES ('Club Atlético River Plate', 'Argentina', 'Buenos Aires', 'Av. Pres. Figueroa Alcorta 7597')


INSERT INTO events(description, mini_image_url, banner_image_url, detail_image_url, name, id_venue, id_category) VALUES('Bad Religion', "imagen mini", "imagen banner", 'imagen detalle', 'Bad Religion', 1, 2);
INSERT INTO events(description, mini_image_url, banner_image_url, detail_image_url, name, id_venue, id_category) VALUES('Bad Religion', "imagen mini", "imagen banner", 'imagen detalle', 'Bad Religion', 2, 1);
INSERT INTO events(description, mini_image_url, banner_image_url, detail_image_url, name, id_venue, id_category) VALUES('Bad Religion', "imagen mini", "imagen banner", 'imagen detalle', 'Bad Religion', 1, 2);
INSERT INTO events(description, mini_image_url, banner_image_url, detail_image_url, name, id_venue, id_category) VALUES('Bad Religion', "imagen mini", "imagen banner", 'imagen detalle', 'Bad Religion', 2, 1);


INSERT INTO dates(date_time, event_id) VALUES('2024-12-12T11:00:00',1);
INSERT INTO dates(date_time, event_id) VALUES('2024-12-12T10:00:00',1);
INSERT INTO dates(date_time, event_id) VALUES('2024-12-12T09:00:00',1);

