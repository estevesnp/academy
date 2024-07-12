CREATE EXTENSION IF NOT EXISTS pgcrypto;

DROP TYPE IF EXISTS STATUS CASCADE;
DROP TYPE IF EXISTS DEFAULT_LOCATION CASCADE;

CREATE TYPE STATUS as ENUM ('AVAILABLE', 'BOOKED', 'UNAVAILABLE');
CREATE TYPE DEFAULT_LOCATION as ENUM ('LISBON', 'PORTO', 'BRAGA');

DROP TABLE IF EXISTS t_team CASCADE;
DROP TABLE IF EXISTS t_team_member CASCADE;
DROP TABLE IF EXISTS t_rack_asset CASCADE;
DROP TABLE IF EXISTS t_rack CASCADE;
DROP TABLE IF EXISTS t_booking CASCADE;

CREATE TABLE IF NOT EXISTS t_team
(
    id uuid DEFAULT gen_random_uuid() NOT NULL,
    name VARCHAR(20) NOT NULL,
    product VARCHAR(20) NOT NULL,
    default_location DEFAULT_LOCATION NOT NULL,
    created_at TIMESTAMP DEFAULT now() NOT NULL,
    modified_at TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS t_team_member
(
    id uuid DEFAULT gen_random_uuid() NOT NULL,
    team_id uuid DEFAULT gen_random_uuid() NOT NULL,
    ctw_id VARCHAR(20) NOT NULL,
    name VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT now() NOT NULL,
    modified_at TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (team_id) REFERENCES t_team (id)
);

CREATE TABLE IF NOT EXISTS t_rack
(
    id uuid DEFAULT gen_random_uuid() NOT NULL,
    serial_number VARCHAR(20) NOT NULL UNIQUE,
    status STATUS DEFAULT 'AVAILABLE' NOT NULL,
    team_id uuid,
    default_location DEFAULT_LOCATION NOT NULL,
    created_at TIMESTAMP DEFAULT now() NOT NULL,
    modified_at TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (team_id) REFERENCES t_team (id)
);

CREATE TABLE IF NOT EXISTS t_rack_asset
(
    id uuid DEFAULT gen_random_uuid() NOT NULL,
    asset_tag VARCHAR(10) NOT NULL,
    rack_id uuid NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (rack_id) REFERENCES t_rack (id)
);

CREATE TABLE IF NOT EXISTS t_booking
(
    id uuid DEFAULT gen_random_uuid() NOT NULL,
    rack_id uuid NOT NULL,
    requester_id uuid NOT NULL,
    book_from TIMESTAMP DEFAULT now() NOT NULL,
    book_to TIMESTAMP DEFAULT now() NOT NULL,
    created_at TIMESTAMP DEFAULT now() NOT NULL,
    modified_at TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (rack_id) REFERENCES t_rack (id),
    FOREIGN KEY (requester_id) REFERENCES t_team_member (id)
);