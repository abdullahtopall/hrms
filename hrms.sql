CREATE TABLE public.users (
	id serial NOT NULL,
	email CHARACTER VARYING(320) NOT NULL,
	password CHARACTER VARYING(25) NOT NULL,
	CONSTRAINT pk_users PRIMARY KEY(id),
	CONSTRAINT uk_users_email UNIQUE(email)
);

CREATE TABLE public.employees (
	id INTEGER NOT Null,
	first_name CHARACTER VARYING(35) NOT NULL,
	last_name CHARACTER VARYING(35) NOT NULL,
	CONSTRAINT pk_employees PRIMARY KEY(id),
	CONSTRAINT fk_employees_users FOREIGN KEY(id) REFERENCES public.users(id)
	
);

CREATE TABLE public.candidates (
	id INTEGER NOT NULL,
	first_name CHARACTER VARYING(35) NOT NULL,
	last_name CHARACTER VARYING(35) NOT NULL,
	identity_number CHARACTER VARYING(11) NOT NULL,
	birth_year INTEGER NOT NULL,
	CONSTRAINT pk_candidates PRIMARY KEY(id),
	CONSTRAINT fk_candidates_users FOREIGN KEY(id) REFERENCES public.users(id),
	CONSTRAINT uk_candidates_identity_number UNIQUE (identity_number)
);

CREATE TABLE public.employers (
	id INTEGER NOT NULL,
	company_name CHARACTER VARYING(320) NOT NULL,
	web_adress CHARACTER VARYING(50) NOT NULL,
	phone_number CHARACTER VARYING (12) NOT NULL,
	CONSTRAINT pk_employers PRIMARY KEY(id),
	CONSTRAINT fk_employers_users FOREIGN KEY(id) REFERENCES public.users(id)
);

CREATE TABLE public.verification_codes (
	id serial NOT NULL,
	code CHARACTER VARYING (38) NOT NULL,
	is_verified BOOLEAN NOT NULL,
	verified_date DATE,
	CONSTRAINT pk_verification_codes PRIMARY KEY(id),
	CONSTRAINT uk_verification_codes UNIQUE(code)
);

CREATE TABLE public.verification_code_candidates (
	id INTEGER NOT NULL,
	candidate_id INTEGER NOT NULL,
	CONSTRAINT pk_verification_code_candidates PRIMARY KEY(id),
	CONSTRAINT fk_verification_code_candidates_verification_codes 
	FOREIGN KEY(id) REFERENCES public.verification_codes(id),
	CONSTRAINT fk_verification_code_candidates_candidates
	FOREIGN KEY(candidate_id) REFERENCES public.candidates(id)
);

CREATE TABLE public.verification_code_employers (
	id INTEGER NOT NULL,
	employer_id INTEGER NOT NULL,
	CONSTRAINT pk_verification_code_employers PRIMARY KEY(id),
	CONSTRAINT fk_verification_code_employers_employers FOREIGN KEY(employer_id)
	REFERENCES public.employers(id)
);

CREATE TABLE public.employee_confirms (
	id serial NOT NULL,
	employee_id INTEGER NOT NULL,
	is_confirmed BOOLEAN NOT NULL,
	confirm_date DATE,
	CONSTRAINT pk_employee_confirms PRIMARY KEY(id),
	CONSTRAINT fk_employee_confirms_employee_id FOREIGN KEY(employee_id)
	REFERENCES public.employees(id)
);

CREATE TABLE public.employee_confirm_employers (
	id INTEGER NOT NULL,
	employer_id INTEGER NOT NULL,
	CONSTRAINT pk_employee_confirm_employers PRIMARY KEY(id),
	CONSTRAINT fk_employee_confirm_employers_employee_confirms 
	FOREIGN KEY(id) REFERENCES public.employee_confirms(id), 
	CONSTRAINT fk_employee_confirm_employers_employers
	FOREIGN KEY(employer_id) REFERENCES public.employers(id)
);

CREATE TABLE public.job_titles (
	id serial NOT NULL,
	title CHARACTER VARYING(255),
	CONSTRAINT pk_job_titles PRIMARY KEY(id),
	CONSTRAINT uk_job_titles_title UNIQUE(title)
);



