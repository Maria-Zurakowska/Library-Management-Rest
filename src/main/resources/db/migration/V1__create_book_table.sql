-- Table: public.book

-- DROP TABLE IF EXISTS public.book;

CREATE TABLE IF NOT EXISTS public.books
(
    id SERIAL PRIMARY KEY,
    title character varying(255) COLLATE pg_catalog."default" NOT NULL,
    author_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    author_last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    publishing_house character varying(255) COLLATE pg_catalog."default",
    publication_year integer,
    language_id integer,
    pages_number integer,
    isbn character varying(20) COLLATE pg_catalog."default"
    )


