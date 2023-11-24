INSERT INTO categories (id, description, url_image) VALUES ('1', 'Concierto', 'https://golden-ticket.s3.amazonaws.com/categorias/1.png');
INSERT INTO categories (id, description, url_image) VALUES ('2', 'Teatro', 'https://golden-ticket.s3.amazonaws.com/categorias/2.jpg');
INSERT INTO categories (id, description, url_image) VALUES ('3', 'Evento Deportivo', 'https://golden-ticket.s3.amazonaws.com/categorias/3.jpg');

INSERT INTO venues(id, venue, country, city, address) VALUES (1, 'River Plate', 'Argentina', 'Buenos Aires', 'Av. Pres. Figueroa Alcorta 7597');
INSERT INTO venues(id, venue, country, city, address) VALUES (2, 'Estadio Unico de La Plata', 'Argentina', 'La Plata', 'Av. 25');
INSERT INTO venues(id, venue, country, city, address) VALUES (3, 'Estadio Boca Juniors', 'Argentina', 'Buenos Aires', 'Brandsen 805');
INSERT INTO venues(id, venue, country, city, address) VALUES (4, 'Teatro Vorterix', 'Argentina', 'Buenos Aires', 'Federico Lacroze 3455');
INSERT INTO venues(id, venue, country, city, address) VALUES (5, 'La Trastienda', 'Argentina', 'Buenos Aires', 'Balcarce 460');
INSERT INTO venues(id, venue, country, city, address) VALUES (6, 'Teatro Maipo', 'Argentina', 'Buenos Aires', 'Esmeralda 443');
INSERT INTO venues(id, venue, country, city, address) VALUES (7, 'Hipodromo de San Isidro', 'Argentina', 'San Isidro', 'Av. Bernabé Márquez 700');
INSERT INTO venues(id, venue, country, city, address) VALUES (8, 'Estadio Eva Perón', 'Argentina', 'Junin', 'Necochea 25');
INSERT INTO venues(id, venue, country, city, address) VALUES (9, 'Estadio José María Minella', 'Argentina', 'Mar del Plata', 'Av. de las Olimpiadas 760');

INSERT INTO events (id, name, mini_image_url, banner_image_url, detail_image_url, description_title, description, id_category, id_venue) VALUES ('1', 'Taylor Swift', 'https://golden-ticket.s3.amazonaws.com/miniIMG/mini-1.png', 'https://golden-ticket.s3.amazonaws.com/bannerIMG/banner-1.png', 'https://golden-ticket.s3.amazonaws.com/detailIMG/detail-1.png', 'Taylor vuelve a la argentina', 'La cantante estadounidense debutará en Argentina este jueves 9 de noviembre y volverá a presentarse el viernes 10 y sábado 11 en el Monumental.', '1', '1');
INSERT INTO events (id, name, mini_image_url, banner_image_url, detail_image_url, description_title, description, id_category, id_venue) VALUES ('2', 'Red Hot Chilli Peppers', 'https://golden-ticket.s3.amazonaws.com/miniIMG/mini-2.png', 'https://golden-ticket.s3.amazonaws.com/bannerIMG/banner-2.png', 'https://golden-ticket.s3.amazonaws.com/detailIMG/detail-2.png', 'La icónica banda vendrá con su formación más clásica', 'Integrada por Anthony Kiedis, Flea, Chad Smith y el eximio guitarrista John Frusciante, que volvió a sumarse después de 10 años, para brindar dos presentaciones en Argentina los días 24 y 26 de noviembre en el Estadio River Plate.', '1', '2');
INSERT INTO events (id, name, mini_image_url, banner_image_url, detail_image_url, description_title, description, id_category, id_venue) VALUES ('3', 'Kevin Johansen + The Nada + Liniers', 'https://golden-ticket.s3.amazonaws.com/miniIMG/mini-3.png', 'https://golden-ticket.s3.amazonaws.com/bannerIMG/banner-3.png', 'https://golden-ticket.s3.amazonaws.com/detailIMG/detail-3.png', 'Kevin Johansen + The Nada + Liniers', 'KEVIN JOHANSEN, junto a su banda The Nada y a Liniers, se presentarán ilustrando sus canciones en vivo con imágenes proyectadas en una gran pantalla de fondo. Música, dibujos, arte y humor se mezclan en este espectáculo único.', '2', '6');
INSERT INTO events (id, name, mini_image_url, banner_image_url, detail_image_url, description_title, description, id_category, id_venue) VALUES ('4', 'Argentina vs Uruguay', 'https://golden-ticket.s3.amazonaws.com/miniIMG/mini-4.png', 'https://golden-ticket.s3.amazonaws.com/bannerIMG/banner-4.png', 'https://golden-ticket.s3.amazonaws.com/detailIMG/detail-4.png', 'Eliminatorias Sudamericanas – Copa Mundial de la FIFA 2026', 'El seleccionado campeón del mundo recibe en La Bombonera al uruguayo por la quinta jornada y promete ser un duelo apasionante', '3', '3');
INSERT INTO events (id, name, mini_image_url, banner_image_url, detail_image_url, description_title, description, id_category, id_venue) VALUES ('5', 'The Weeknd', 'https://golden-ticket.s3.amazonaws.com/miniIMG/mini-5.png', 'https://golden-ticket.s3.amazonaws.com/bannerIMG/banner-5.png', 'https://golden-ticket.s3.amazonaws.com/detailIMG/detail-5.png', 'The Weeknd vuelve nuevamente a la Argentina con su tour After Hours Till Dawn', 'Con una puesta en escena distópica y futurística, Abel Tesfaye demostrará por qué es el artista masculino numero uno del mundo.', '1', '1');
INSERT INTO events (id, name, mini_image_url, banner_image_url, detail_image_url, description_title, description, id_category, id_venue) VALUES ('6', 'Lollapalooza Argentina', 'https://golden-ticket.s3.amazonaws.com/miniIMG/mini-6.png', 'https://golden-ticket.s3.amazonaws.com/bannerIMG/banner-6.png', 'https://golden-ticket.s3.amazonaws.com/detailIMG/detail-6.png', 'El festival más importante de argentina anuncia una grilla histórica para su novena edición', '#LollaAr confirmó uno de los lineups más potentes de su historia para su novena edición a realizarse entre el 15 y el 17 de marzo. Con artistas que vendrán por primera vez a Argentina como Blink-182 y SZA, grandes figuras internacionales', '1', '7');
INSERT INTO events (id, name, mini_image_url, banner_image_url, detail_image_url, description_title, description, id_category, id_venue) VALUES ('7', 'Tan Bionica', 'https://golden-ticket.s3.amazonaws.com/miniIMG/mini-7.png', 'https://golden-ticket.s3.amazonaws.com/bannerIMG/banner-7.png', 'https://golden-ticket.s3.amazonaws.com/detailIMG/detail-7.png', 'La banda récord continuará si Tour despues de 5 noches magicas en estadios.', 'La banda se encontraba en un impasse que duró siete años hasta que Chano anunció en marzo la vuelta de Tan Biónica en Lollapalooza y allí aparecieron Bambi, Seby y Diega sobre el escenario para confirmar un show de despedida en un estadio. Sin embargo, la euforia de los fans llevó a que se agoten en tiempo récord 5 shows en 3 estadios distintos.', '1', '9');
INSERT INTO events (id, name, mini_image_url, banner_image_url, detail_image_url, description_title, description, id_category, id_venue) VALUES ('8', 'Veléz vs. Belgrano', 'https://golden-ticket.s3.amazonaws.com/miniIMG/mini-8.png', 'https://golden-ticket.s3.amazonaws.com/bannerIMG/banner-8.png', 'https://golden-ticket.s3.amazonaws.com/detailIMG/detail-8.png', 'Copa Proyección: Veléz vs Belgrano', 'Comenzaron a disputarse los Cuartos de Final de la Copa Proyección Sur Finanzas, con los ocho mejores equipos de la competencia.', '3', '8');
INSERT INTO events (id, name, mini_image_url, banner_image_url, detail_image_url, description_title, description, id_category, id_venue) VALUES ('9', 'Talleres vs San Lorenzo', 'https://golden-ticket.s3.amazonaws.com/miniIMG/mini-9.png', 'https://golden-ticket.s3.amazonaws.com/bannerIMG/banner-9.png', 'https://golden-ticket.s3.amazonaws.com/detailIMG/detail-9.png', 'Copa Proyección: Talleres vs San Lorenzo', 'Comenzaron a disputarse los Cuartos de Final de la Copa Proyección Sur Finanzas, con los ocho mejores equipos de la competencia.', '3', '8');

INSERT INTO dates (id, date_time, event_id, capacity) VALUES ('1', '2024-10-10 20:00:00', '1', '70000');
INSERT INTO dates (id, date_time, event_id, capacity) VALUES ('2', '2024-10-11 20:00:00', '1', '70000');
INSERT INTO dates (id, date_time, event_id, capacity) VALUES ('3', '2024-12-24 20:00:00', '2', '70000');
INSERT INTO dates (id, date_time, event_id, capacity) VALUES ('4', '2024-03-02 20:00:00', '3', '70000');
INSERT INTO dates (id, date_time, event_id, capacity) VALUES ('5', '2024-11-16 20:00:00', '4', '70000');
INSERT INTO dates (id, date_time, event_id, capacity) VALUES ('6', '2024-10-18 20:00:00', '5', '70000');
INSERT INTO dates (id, date_time, event_id, capacity) VALUES ('7', '2024-10-19 20:00:00', '5', '70000');
INSERT INTO dates (id, date_time, event_id, capacity) VALUES ('8', '2024-03-15 20:00:00', '6', '70000');
INSERT INTO dates (id, date_time, event_id, capacity) VALUES ('9', '2024-03-16 20:00:00', '6', '70000');
INSERT INTO dates (id, date_time, event_id, capacity) VALUES ('10', '2024-03-17 20:00:00', '6', '70000');
INSERT INTO dates (id, date_time, event_id, capacity) VALUES ('11', '2024-01-20 20:00:00', '7', '70000');
INSERT INTO dates (id, date_time, event_id, capacity) VALUES ('12', '2024-01-15 20:00:00', '8', '70000');
INSERT INTO dates (id, date_time, event_id, capacity) VALUES ('13', '2024-01-15 20:00:00', '9', '70000');

INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('1', 'Campo Trasero', '10000', '20000', '1', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('2', 'Campo Delantero', '20000', '30000', '1', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('3', 'Platea San Martin Alta', '20000', '5000', '1', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('4', 'Platea San Martin Baja', '45000', '5000', '1', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('5', 'Platea Belgrano Alta', '20000', '5000', '1', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('6', 'Platea Belgrano Baja', '45000', '5000', '1', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('7', 'Campo Trasero', '10000', '20000', '2', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('8', 'Campo Delantero', '20000', '30000', '2', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('9', 'Platea San Martin Alta', '20000', '5000', '2', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('10', 'Platea San Martin Baja', '45000', '5000', '2', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('11', 'Platea Belgrano Alta', '20000', '5000', '2', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('12', 'Platea Belgrano Baja', '45000', '5000', '2', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('13', 'Campo Trasero', '10000', '20000', '3', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('14', 'Campo Delantero', '20000', '30000', '3', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('15', 'Platea San Martin Alta', '20000', '5000', '3', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('16', 'Platea San Martin Baja', '45000', '5000', '3', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('17', 'Platea Belgrano Alta', '20000', '5000', '3', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('18', 'Platea Belgrano Baja', '45000', '5000', '3', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('19', 'General', '10000', '20000', '4', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('20', 'Platea', '20000', '5000', '4', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('21', 'Platea Alta', '45000', '15000', '5', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('22', 'Platea Baja', '75000', '10000', '5', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('23', 'Plate Alta Lateral', '100000', '10000', '5', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('24', 'Platea Baja Lateral', '150000', '7000', '5', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('25', 'Campo Trasero', '10000', '20000', '6', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('26', 'Campo Delantero', '20000', '30000', '6', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('27', 'Platea San Martin Alta', '20000', '5000', '6', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('28', 'Platea San Martin Baja', '45000', '5000', '6', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('29', 'Platea Belgrano Alta', '20000', '5000', '6', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('30', 'Platea Belgrano Baja', '45000', '5000', '6', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('31', 'Campo Trasero', '10000', '20000', '7', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('32', 'Campo Delantero', '20000', '30000', '7', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('33', 'Platea San Martin Alta', '20000', '5000', '7', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('34', 'Platea San Martin Baja', '45000', '5000', '7', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('35', 'Platea Belgrano Alta', '20000', '5000', '7', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('36', 'Platea Belgrano Baja', '45000', '5000', '7', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('37', '3 Days Pass - General', '100000', '100000', '8', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('38', '3 Days Pass - VIP', '200000', '100000', '8', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('39', '4 Days Pass - General', '100000', '100000', '9', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('40', '4 Days Pass - VIP', '200000', '100000', '9', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('41', '5 Days Pass - General', '100000', '100000', '10', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('42', '5 Days Pass - VIP', '200000', '100000', '10', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('43', 'Popular', '35000', '20000', '12', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('44', 'Visitante', '35000', '20000', '12', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('45', 'Popular', '35000', '20000', '13', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('46', 'Visitante', '35000', '20000', '13', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('47', 'Campo Trasero', '50000', '20000', '11', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
INSERT INTO ticket_types (id, name, Price, stock, date_time_id, url_image) VALUES ('48', 'Campo Delantero', '100000', '30000', '11', 'https://pbs.twimg.com/media/DtfwYtlWwAAnUfi?format=jpg&name=900x900');
