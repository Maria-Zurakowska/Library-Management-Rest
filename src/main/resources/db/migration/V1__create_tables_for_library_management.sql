-- DROP TABLE IF EXISTS public.languages

CREATE TABLE IF NOT EXISTS public.languages
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS public.publishers
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    website VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(20),
    address VARCHAR(255),
    city VARCHAR(100),
    country VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS public.books
(
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    publisher_id INTEGER NOT NULL,
    language_id INTEGER NOT NULL,
    ISBN VARCHAR(20) NOT NULL,
    pages_number INTEGER NOT NULL,
    publication_year INTEGER NOT NULL,
    edition VARCHAR(50) NOT NULL,
    quantity_available INTEGER NOT NULL,
    description VARCHAR(255),
    cover_image_url VARCHAR(255),
    is_available BOOLEAN NOT NULL,
    rating DECIMAL(3, 2),
    created_at DATE,
    FOREIGN KEY (language_id) REFERENCES languages (id),
    FOREIGN KEY (publisher_id) REFERENCES publishers (id)
);

CREATE TABLE IF NOT EXISTS public.authors
(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    publisher_id INTEGER NOT NULL,
    FOREIGN KEY (publisher_id) REFERENCES publishers (id)
);

CREATE TABLE IF NOT EXISTS public.books_authors
(
    book_id INTEGER NOT NULL,
    author_id INTEGER NOT NULL,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES books (id),
    FOREIGN KEY (author_id) REFERENCES authors (id)
);

CREATE TABLE IF NOT EXISTS public.ebooks
(
    id SERIAL PRIMARY KEY,
    book_id INTEGER NOT NULL,
    language_id INTEGER NOT NULL,
    publisher_id INTEGER NOT NULL,
    format VARCHAR NOT NULL,
    FOREIGN KEY (book_id) REFERENCES books (id),
    FOREIGN KEY (publisher_id) REFERENCES publishers (id),
    FOREIGN KEY (language_id) REFERENCES languages (id)
);

CREATE TABLE IF NOT EXISTS public.genres
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS public.books_genres
(
    book_id INTEGER NOT NULL,
    genre_id INTEGER NOT NULL,
    PRIMARY KEY (book_id, genre_id),
    FOREIGN KEY (book_id) REFERENCES books (id),
    FOREIGN KEY (genre_id) REFERENCES genres (id)
);

CREATE TABLE IF NOT EXISTS public.ebooks_genres
(
    ebook_id INTEGER NOT NULL,
    genre_id INTEGER NOT NULL,
    PRIMARY KEY (ebook_id, genre_id),
    FOREIGN KEY (ebook_id) REFERENCES ebooks (id),
    FOREIGN KEY (genre_id) REFERENCES genres (id)
);

CREATE TABLE IF NOT EXISTS public.users
(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    username VARCHAR(255) UNIQUE,
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    date_of_birth DATE,
    gender VARCHAR(10),
    street_address VARCHAR(255),
    city VARCHAR(100),
    zip_code VARCHAR(20),
    phone_number VARCHAR(20),
    profile_picture VARCHAR(255),
    registration_date DATE DEFAULT CURRENT_DATE,
    status VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS public.copies
(
    id SERIAL PRIMARY KEY,
    book_id INTEGER NOT NULL,
    status VARCHAR(20) DEFAULT 'AVAILABLE',
    location VARCHAR(100),
    condition VARCHAR(50),
    added_date DATE,
    FOREIGN KEY (book_id) REFERENCES books (id)
);

CREATE TABLE IF NOT EXISTS public.borrowings
(
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    copy_id INTEGER NOT NULL,
    borrowed_date DATE NOT NULL,
    due_date DATE NOT NULL,
    return_date DATE,
    fine_amount DECIMAL(10, 2),
    is_returned BOOLEAN DEFAULT FALSE,
    created_at DATE,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (copy_id) REFERENCES copies (id)
);

CREATE TABLE IF NOT EXISTS public.logins
(
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL UNIQUE,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255) NOT NULL,
    last_login TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

