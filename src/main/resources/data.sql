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
