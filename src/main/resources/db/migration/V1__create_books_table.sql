-- Table: public.books

-- DROP TABLE IF EXISTS public.books;

CREATE TABLE IF NOT EXISTS public.books
(
    id SERIAL PRIMARY KEY,
    title character varying(255) NOT NULL,
    genre_id integer NOT NULL,
    publisher_id integer NOT NULL,
    language_id integer NOT NULL,
    ISBN character varying(20) NOT NULL,
    pages_number integer NOT NULL,
    publication_year integer NOT NULL,
    edition character varying(50) NOT NULL,
    quantity_available integer NOT NULL,
    description text,
    cover_image_url character varying(255),
    is_available boolean NOT NULL,
    rating decimal(3, 2),
    created_at timestamp DEFAULT CURRENT_TIMESTAMP
);


