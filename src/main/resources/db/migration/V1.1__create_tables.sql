CREATE TABLE advisors (
    id BIGINT PRIMARY KEY,
    username TEXT NOT NULL UNIQUE,
    email TEXT NOT NULL UNIQUE,
    role text,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL
);

CREATE TABLE applicants
(
    id         BIGINT PRIMARY KEY,
    username   TEXT NOT NULL UNIQUE,
    email      TEXT NOT NULL UNIQUE,
    first_name TEXT NOT NULL,
    last_name  TEXT NOT NULL,
    ssn        TEXT,
    city       text NOT NULL,
    street     text NOT NULL,
    number     int  NOT NULL,
    zip        int,
    apt        int
);

CREATE TABLE applicant_phones(
    applicant_id BIGINT NOT NULL,
    phone_number TEXT NOT NULL UNIQUE,
    phone_type TEXT NOT NULL,

    constraint FK_phones_applicants_applicant_id foreign key (applicant_id) references applicants(id)
);

CREATE TABLE applications(
    id BIGINT PRIMARY KEY,
    amount DECIMAL NOT NULL,
    application_status TEXT default 'NEW',
    created_at TIMESTAMP NOT NULL default NOW(),
    assigned_at TIMESTAMP,
    resolved_at TIMESTAMP,
    advisor_id BIGINT,
    applicant_id BIGINT NOT NULL,

    constraint FK_applications_applicants_applicant_id foreign key (applicant_id) references applicants(id),
    constraint FK_applications_advisors_advisor_id foreign key (advisor_id) references advisors(id)
);

CREATE SEQUENCE hibernate_sequence start 1 increment 1;