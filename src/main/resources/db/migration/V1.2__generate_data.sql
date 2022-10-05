insert into advisors (id, username, email, role, first_name, last_name)
values (nextval('hibernate_sequence'), 'associate_advisor', 'assosiate@mail.com', 'ASSOCIATE', 'Associate',
        'Associative'),
       (nextval('hibernate_sequence'), 'partner_advisor', 'partner@mail.com', 'PARTNER', 'Partner', 'Partnership'),
       (nextval('hibernate_sequence'), 'senior_advisor', 'senior@mail.com', 'SENIOR', 'Senior', 'Seniorov');

insert into applicants (id, username, email, first_name, last_name, ssn, city, street, number, zip, apt)
VALUES (nextval('hibernate_sequence'), 'poor_applicant', 'poor@mail.com', 'John', 'Zoidberg', '12345', 'New York', 'Main', 1, 12456, 1),
(nextval('hibernate_sequence'), 'rich_applicant', 'rich@mail.com', 'John', 'Bush', '54321', 'Washington', 'Main', 5, 654321, 55);

insert into applicant_phones (applicant_id, phone_number, phone_type)
VALUES ((select id from applicants where username = 'poor_applicant'), '123456789', 'MOBILE'),
       ((select id from applicants where username = 'poor_applicant'), '12-456-456', 'HOME'),
       ((select id from applicants where username = 'rich_applicant'), '987654321', 'MOBILE'),
       ((select id from applicants where username = 'rich_applicant'), '98-789-32456', 'WORK');

insert into applications (id, amount, assigned_at, resolved_at, advisor_id, applicant_id)
VALUES (nextval('hibernate_sequence'), 5000, null, null, null,
        (select id from applicants where username = 'poor_applicant')),
       (nextval('hibernate_sequence'), 15000, null, null, null,
        (select id from applicants where username = 'poor_applicant')),
       (nextval('hibernate_sequence'), 25000, null, null, null,
        (select id from applicants where username = 'rich_applicant')),
       (nextval('hibernate_sequence'), 100000, null, null, null,
        (select id from applicants where username = 'rich_applicant'))

