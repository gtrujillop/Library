--
-- PostgreSQL database dump
--

-- Dumped from database version 9.0.10
-- Dumped by pg_dump version 9.0.10
-- Started on 2014-10-06 21:58:16

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 482 (class 2612 OID 11574)
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: postgres
--

CREATE OR REPLACE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO postgres;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 143 (class 1259 OID 16398)
-- Dependencies: 1817 5
-- Name: autores; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE autores (
    id_autor integer NOT NULL,
    first_name character varying(100),
    last_name character varying(100) DEFAULT 'Anonymous'::character varying NOT NULL,
    birthdate date NOT NULL,
    deathdate date NOT NULL
);


ALTER TABLE public.autores OWNER TO postgres;

--
-- TOC entry 142 (class 1259 OID 16396)
-- Dependencies: 143 5
-- Name: autores_id_autor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE autores_id_autor_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.autores_id_autor_seq OWNER TO postgres;

--
-- TOC entry 1865 (class 0 OID 0)
-- Dependencies: 142
-- Name: autores_id_autor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE autores_id_autor_seq OWNED BY autores.id_autor;


--
-- TOC entry 1866 (class 0 OID 0)
-- Dependencies: 142
-- Name: autores_id_autor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('autores_id_autor_seq', 1, false);


--
-- TOC entry 151 (class 1259 OID 16457)
-- Dependencies: 1823 1824 5
-- Name: copias; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE copias (
    id_copia integer NOT NULL,
    id_edicion integer NOT NULL,
    num_copias integer DEFAULT 0 NOT NULL,
    valor_multa double precision DEFAULT 0.0 NOT NULL
);


ALTER TABLE public.copias OWNER TO postgres;

--
-- TOC entry 150 (class 1259 OID 16455)
-- Dependencies: 5 151
-- Name: copias_id_copia_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE copias_id_copia_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.copias_id_copia_seq OWNER TO postgres;

--
-- TOC entry 1867 (class 0 OID 0)
-- Dependencies: 150
-- Name: copias_id_copia_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE copias_id_copia_seq OWNED BY copias.id_copia;


--
-- TOC entry 1868 (class 0 OID 0)
-- Dependencies: 150
-- Name: copias_id_copia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('copias_id_copia_seq', 1, false);


--
-- TOC entry 149 (class 1259 OID 16433)
-- Dependencies: 1821 5
-- Name: edicion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE edicion (
    id_edicion integer NOT NULL,
    isbn character varying(13) NOT NULL,
    anno date NOT NULL,
    paginas integer,
    id_libro integer,
    CONSTRAINT edicion_paginas_check CHECK ((paginas > 0))
);


ALTER TABLE public.edicion OWNER TO postgres;

--
-- TOC entry 148 (class 1259 OID 16431)
-- Dependencies: 149 5
-- Name: edicion_id_edicion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE edicion_id_edicion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.edicion_id_edicion_seq OWNER TO postgres;

--
-- TOC entry 1869 (class 0 OID 0)
-- Dependencies: 148
-- Name: edicion_id_edicion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE edicion_id_edicion_seq OWNED BY edicion.id_edicion;


--
-- TOC entry 1870 (class 0 OID 0)
-- Dependencies: 148
-- Name: edicion_id_edicion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('edicion_id_edicion_seq', 1, false);


--
-- TOC entry 145 (class 1259 OID 16407)
-- Dependencies: 5
-- Name: libros; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE libros (
    id_libro integer NOT NULL,
    nombre_libro character varying(100) NOT NULL
);


ALTER TABLE public.libros OWNER TO postgres;

--
-- TOC entry 144 (class 1259 OID 16405)
-- Dependencies: 145 5
-- Name: libros_id_libro_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE libros_id_libro_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.libros_id_libro_seq OWNER TO postgres;

--
-- TOC entry 1871 (class 0 OID 0)
-- Dependencies: 144
-- Name: libros_id_libro_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE libros_id_libro_seq OWNED BY libros.id_libro;


--
-- TOC entry 1872 (class 0 OID 0)
-- Dependencies: 144
-- Name: libros_id_libro_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('libros_id_libro_seq', 1, false);


--
-- TOC entry 155 (class 1259 OID 16486)
-- Dependencies: 5
-- Name: prestamos; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE prestamos (
    id_prestamo integer NOT NULL,
    fecha_entrega date NOT NULL,
    fecha_devolucion date,
    fecha_real_entrega date,
    id_copia integer,
    id_edicion integer,
    id_usuario integer
);


ALTER TABLE public.prestamos OWNER TO postgres;

--
-- TOC entry 154 (class 1259 OID 16484)
-- Dependencies: 155 5
-- Name: prestamos_id_prestamo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE prestamos_id_prestamo_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.prestamos_id_prestamo_seq OWNER TO postgres;

--
-- TOC entry 1873 (class 0 OID 0)
-- Dependencies: 154
-- Name: prestamos_id_prestamo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE prestamos_id_prestamo_seq OWNED BY prestamos.id_prestamo;


--
-- TOC entry 1874 (class 0 OID 0)
-- Dependencies: 154
-- Name: prestamos_id_prestamo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('prestamos_id_prestamo_seq', 1, false);


--
-- TOC entry 147 (class 1259 OID 16415)
-- Dependencies: 5
-- Name: publicaciones; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE publicaciones (
    id_publicacion integer NOT NULL,
    id_autor integer,
    id_libro integer
);


ALTER TABLE public.publicaciones OWNER TO postgres;

--
-- TOC entry 146 (class 1259 OID 16413)
-- Dependencies: 5 147
-- Name: publicaciones_id_publicacion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE publicaciones_id_publicacion_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.publicaciones_id_publicacion_seq OWNER TO postgres;

--
-- TOC entry 1875 (class 0 OID 0)
-- Dependencies: 146
-- Name: publicaciones_id_publicacion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE publicaciones_id_publicacion_seq OWNED BY publicaciones.id_publicacion;


--
-- TOC entry 1876 (class 0 OID 0)
-- Dependencies: 146
-- Name: publicaciones_id_publicacion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('publicaciones_id_publicacion_seq', 1, false);


--
-- TOC entry 153 (class 1259 OID 16472)
-- Dependencies: 5
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usuarios (
    id_usuario integer NOT NULL,
    codigo integer NOT NULL,
    email character varying(100) NOT NULL,
    telefono character varying(20) NOT NULL,
    password character varying(10) NOT NULL
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- TOC entry 152 (class 1259 OID 16470)
-- Dependencies: 153 5
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE usuarios_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuarios_id_usuario_seq OWNER TO postgres;

--
-- TOC entry 1877 (class 0 OID 0)
-- Dependencies: 152
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE usuarios_id_usuario_seq OWNED BY usuarios.id_usuario;


--
-- TOC entry 1878 (class 0 OID 0)
-- Dependencies: 152
-- Name: usuarios_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('usuarios_id_usuario_seq', 1, false);


--
-- TOC entry 1816 (class 2604 OID 16401)
-- Dependencies: 143 142 143
-- Name: id_autor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY autores ALTER COLUMN id_autor SET DEFAULT nextval('autores_id_autor_seq'::regclass);


--
-- TOC entry 1822 (class 2604 OID 16460)
-- Dependencies: 151 150 151
-- Name: id_copia; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY copias ALTER COLUMN id_copia SET DEFAULT nextval('copias_id_copia_seq'::regclass);


--
-- TOC entry 1820 (class 2604 OID 16436)
-- Dependencies: 149 148 149
-- Name: id_edicion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY edicion ALTER COLUMN id_edicion SET DEFAULT nextval('edicion_id_edicion_seq'::regclass);


--
-- TOC entry 1818 (class 2604 OID 16410)
-- Dependencies: 145 144 145
-- Name: id_libro; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY libros ALTER COLUMN id_libro SET DEFAULT nextval('libros_id_libro_seq'::regclass);


--
-- TOC entry 1826 (class 2604 OID 16489)
-- Dependencies: 154 155 155
-- Name: id_prestamo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prestamos ALTER COLUMN id_prestamo SET DEFAULT nextval('prestamos_id_prestamo_seq'::regclass);


--
-- TOC entry 1819 (class 2604 OID 16418)
-- Dependencies: 146 147 147
-- Name: id_publicacion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY publicaciones ALTER COLUMN id_publicacion SET DEFAULT nextval('publicaciones_id_publicacion_seq'::regclass);


--
-- TOC entry 1825 (class 2604 OID 16475)
-- Dependencies: 153 152 153
-- Name: id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuarios ALTER COLUMN id_usuario SET DEFAULT nextval('usuarios_id_usuario_seq'::regclass);


--
-- TOC entry 1853 (class 0 OID 16398)
-- Dependencies: 143
-- Data for Name: autores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY autores (id_autor, first_name, last_name, birthdate, deathdate) FROM stdin;
\.


--
-- TOC entry 1857 (class 0 OID 16457)
-- Dependencies: 151
-- Data for Name: copias; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY copias (id_copia, id_edicion, num_copias, valor_multa) FROM stdin;
\.


--
-- TOC entry 1856 (class 0 OID 16433)
-- Dependencies: 149
-- Data for Name: edicion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY edicion (id_edicion, isbn, anno, paginas, id_libro) FROM stdin;
\.


--
-- TOC entry 1854 (class 0 OID 16407)
-- Dependencies: 145
-- Data for Name: libros; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY libros (id_libro, nombre_libro) FROM stdin;
\.


--
-- TOC entry 1859 (class 0 OID 16486)
-- Dependencies: 155
-- Data for Name: prestamos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY prestamos (id_prestamo, fecha_entrega, fecha_devolucion, fecha_real_entrega, id_copia, id_edicion, id_usuario) FROM stdin;
\.


--
-- TOC entry 1855 (class 0 OID 16415)
-- Dependencies: 147
-- Data for Name: publicaciones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY publicaciones (id_publicacion, id_autor, id_libro) FROM stdin;
\.


--
-- TOC entry 1858 (class 0 OID 16472)
-- Dependencies: 153
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuarios (id_usuario, codigo, email, telefono, password) FROM stdin;
\.


--
-- TOC entry 1828 (class 2606 OID 16404)
-- Dependencies: 143 143
-- Name: id_autor_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY autores
    ADD CONSTRAINT id_autor_pk PRIMARY KEY (id_autor);


--
-- TOC entry 1836 (class 2606 OID 16464)
-- Dependencies: 151 151 151
-- Name: id_copia_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY copias
    ADD CONSTRAINT id_copia_pk PRIMARY KEY (id_copia, id_edicion);


--
-- TOC entry 1834 (class 2606 OID 16439)
-- Dependencies: 149 149
-- Name: id_edicion_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY edicion
    ADD CONSTRAINT id_edicion_pk PRIMARY KEY (id_edicion);


--
-- TOC entry 1830 (class 2606 OID 16412)
-- Dependencies: 145 145
-- Name: id_libro_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY libros
    ADD CONSTRAINT id_libro_pk PRIMARY KEY (id_libro);


--
-- TOC entry 1846 (class 2606 OID 16491)
-- Dependencies: 155 155
-- Name: id_prestamo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY prestamos
    ADD CONSTRAINT id_prestamo_pk PRIMARY KEY (id_prestamo);


--
-- TOC entry 1832 (class 2606 OID 16420)
-- Dependencies: 147 147
-- Name: id_publicacion_fk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY publicaciones
    ADD CONSTRAINT id_publicacion_fk PRIMARY KEY (id_publicacion);


--
-- TOC entry 1838 (class 2606 OID 16477)
-- Dependencies: 153 153
-- Name: id_usuario_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT id_usuario_pk PRIMARY KEY (id_usuario);


--
-- TOC entry 1840 (class 2606 OID 16479)
-- Dependencies: 153 153
-- Name: usuarios_codigo_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT usuarios_codigo_key UNIQUE (codigo);


--
-- TOC entry 1842 (class 2606 OID 16481)
-- Dependencies: 153 153
-- Name: usuarios_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT usuarios_email_key UNIQUE (email);


--
-- TOC entry 1844 (class 2606 OID 16483)
-- Dependencies: 153 153
-- Name: usuarios_telefono_key; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT usuarios_telefono_key UNIQUE (telefono);


--
-- TOC entry 1847 (class 2606 OID 16421)
-- Dependencies: 1827 147 143
-- Name: id_autor_fk_autores; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY publicaciones
    ADD CONSTRAINT id_autor_fk_autores FOREIGN KEY (id_autor) REFERENCES autores(id_autor);


--
-- TOC entry 1851 (class 2606 OID 16492)
-- Dependencies: 151 1835 151 155 155
-- Name: id_copia_edicion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prestamos
    ADD CONSTRAINT id_copia_edicion_fk FOREIGN KEY (id_copia, id_edicion) REFERENCES copias(id_copia, id_edicion);


--
-- TOC entry 1850 (class 2606 OID 16465)
-- Dependencies: 151 149 1833
-- Name: id_edicion_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY copias
    ADD CONSTRAINT id_edicion_fk FOREIGN KEY (id_edicion) REFERENCES edicion(id_edicion);


--
-- TOC entry 1848 (class 2606 OID 16426)
-- Dependencies: 147 1829 145
-- Name: id_libro_fk_libro; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY publicaciones
    ADD CONSTRAINT id_libro_fk_libro FOREIGN KEY (id_libro) REFERENCES libros(id_libro);


--
-- TOC entry 1849 (class 2606 OID 16440)
-- Dependencies: 149 1829 145
-- Name: id_libro_fk_libros; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY edicion
    ADD CONSTRAINT id_libro_fk_libros FOREIGN KEY (id_libro) REFERENCES libros(id_libro);


--
-- TOC entry 1852 (class 2606 OID 16497)
-- Dependencies: 153 155 1837
-- Name: id_usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY prestamos
    ADD CONSTRAINT id_usuario_fk FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario);


--
-- TOC entry 1864 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2014-10-06 21:58:16

--
-- PostgreSQL database dump complete
--


