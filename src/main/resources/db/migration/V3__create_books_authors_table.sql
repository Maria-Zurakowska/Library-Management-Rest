-- Table: public.books_authors

-- DROP TABLE IF EXISTS public.books_authors;

CREATE TABLE IF NOT EXISTS public.books_authors
(
    book_id integer REFERENCES public.books (id),
    author_id integer REFERENCES public.authors (id),
    PRIMARY KEY (book_id, author_id)
);
