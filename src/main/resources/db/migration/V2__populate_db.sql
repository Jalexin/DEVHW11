INSERT INTO client (name)
VALUES
    ('John'),
    ('Bate'),
    ('Mark'),
    ('Andrew'),
    ('Lumberg'),
    ('John'),
    ('Manny'),
    ('Kelly'),
    ('Max'),
    ('Maria');

INSERT INTO planet (id, name)
VALUES
    ('MARS', 'Mars'),
    ('VEN', 'Venus'),
    ('EAR', 'Earth'),
    ('SAT', 'Saturn'),
    ('NEPT', 'Neptune');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id)
VALUES
    (1, 'VEN', 'MARS' ),
    (2, 'EAR', 'VEN' ),
    (3, 'NEPT', 'EAR' ),
    (4, 'MARS', 'VEN' ),
    (5, 'VEN', 'SAT' ),
    (6, 'SAT', 'MARS' ),
    (7, 'EAR', 'MARS' ),
    (8, 'MARS', 'EAR' ),
    (9, 'NEPT', 'MARS' ),
    (10, 'VEN', 'NEPT' );