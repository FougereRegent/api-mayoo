INSERT INTO `pictogram` (`description`, `enum_danger_type`, `name`) VALUES
                                                                              (	'Pictogram halal',	'WARNING',	'halal'),
                                                                              (	'Pictogram gluten',	'DANGER',	'gluten'),
                                                                              (	'Pictogram arachide',	'DANGER',	'arachide'),
                                                                              (	'Pictograme vegan',	'NORMAL',	'vegan'),
                                                                              (	'Pictograme',	'NORMAL',	'porc'),
                                                                              (	'Pictogramme Halal',	'WARNING',	'Halal'),
                                                                              (	'Pictogramme Gluten',	'DANGER',	'Gluten'),
                                                                              (	'Pictogramme Arachide',	'DANGER',	'Arachide'),
                                                                              (	'Pictogramme Végétarien',	'NORMAL',	'Végétarien'),
                                                                              (	'Pictogramme Vegan',	'NORMAL',	'Vegan');

INSERT INTO `flat` (`description`, `flat_type`, `name`) VALUES
                                                            ('Oeuf Mimosa maison',	'DESSERT',	'Oeuf Mimosa'),
                                                            ('Mouse au chocolat maison',	'DESSERT',	'Mouse Au chocolat'),
                                                            ('Frite',	'FLAT',	'Frite'),
                                                            ('Boeuf Bougignon',	'FLAT',	'Boeuf Bourgignon'),
                                                            ('Porc Caramel',	'FLAT',	'Port Caramel'),
                                                            ('Pizza',	'STARTER',	'Pizza');

INSERT INTO `flat_pictogram_entities` (`flat_entity_id`, `pictogram_entities_id`) VALUES
                                                                                      (1,	9),
                                                                                      (2,	9),
                                                                                      (2,	8),
                                                                                      (4,	1),
                                                                                      (4,	8),
                                                                                      (5,	5),
                                                                                      (6,	2),
                                                                                      (6,	6);

INSERT INTO `menue` (`menue_date`) VALUES
                                             ('2023-06-22 20:53:36.000000'),
                                             ('2023-06-23 20:53:42.000000'),
                                             ('2023-06-26 20:53:48.000000'),
                                             ('2023-06-27 20:54:00.000000'),
                                             ('2023-06-28 20:54:14.000000'),
                                             ('2023-06-29 20:54:20.000000'),
                                             ('2023-06-30 20:54:26.000000');

INSERT INTO `menue_flats` (`flats_id`, `menue_entity_id`) VALUES
                                                              (1,	1),
                                                              (3,	1),
                                                              (2,	1),
                                                              (5,	2),
                                                              (3,	2),
                                                              (6,	2),
                                                              (4,	3),
                                                              (5,	3),
                                                              (2,	3),
                                                              (1,	4),
                                                              (6,	4),
                                                              (4,	4),
                                                              (4,	5),
                                                              (3,	5),
                                                              (1,	5),
                                                              (2,	5),
                                                              (6,	6),
                                                              (5,	6),
                                                              (1,	6),
                                                              (3,	7),
                                                              (1,	7),
                                                              (2,	7);


