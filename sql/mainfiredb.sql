--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

-- Started on 2024-07-09 22:03:09

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 228 (class 1259 OID 16881)
-- Name: cars; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cars (
    id bigint NOT NULL,
    name character varying(100) NOT NULL,
    number_car character varying(50) NOT NULL,
    fire_station_id bigint NOT NULL,
    team_id bigint
);


ALTER TABLE public.cars OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 16880)
-- Name: cars_fire_station_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cars_fire_station_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cars_fire_station_id_seq OWNER TO postgres;

--
-- TOC entry 4842 (class 0 OID 0)
-- Dependencies: 227
-- Name: cars_fire_station_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cars_fire_station_id_seq OWNED BY public.cars.fire_station_id;


--
-- TOC entry 226 (class 1259 OID 16879)
-- Name: cars_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cars_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cars_id_seq OWNER TO postgres;

--
-- TOC entry 4843 (class 0 OID 0)
-- Dependencies: 226
-- Name: cars_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cars_id_seq OWNED BY public.cars.id;


--
-- TOC entry 218 (class 1259 OID 16419)
-- Name: fire_stations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fire_stations (
    id bigint NOT NULL,
    number_station integer NOT NULL,
    name character varying(250) NOT NULL,
    short_name character varying(100) NOT NULL,
    location character varying(150) NOT NULL
);


ALTER TABLE public.fire_stations OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16418)
-- Name: fire_stations_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.fire_stations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.fire_stations_id_seq OWNER TO postgres;

--
-- TOC entry 4845 (class 0 OID 0)
-- Dependencies: 217
-- Name: fire_stations_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.fire_stations_id_seq OWNED BY public.fire_stations.id;


--
-- TOC entry 220 (class 1259 OID 16682)
-- Name: firefighters; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.firefighters (
    id bigint NOT NULL,
    first_name character varying(150) NOT NULL,
    mid_name character varying(150),
    last_name character varying(150) NOT NULL,
    short_name character varying(150) NOT NULL,
    rank character varying(100) NOT NULL,
    position_id bigint NOT NULL,
    fire_station_id bigint NOT NULL,
    team_id bigint
);


ALTER TABLE public.firefighters OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16792)
-- Name: firefighters_fire_station_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.firefighters_fire_station_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.firefighters_fire_station_id_seq OWNER TO postgres;

--
-- TOC entry 4848 (class 0 OID 0)
-- Dependencies: 222
-- Name: firefighters_fire_station_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.firefighters_fire_station_id_seq OWNED BY public.firefighters.fire_station_id;


--
-- TOC entry 219 (class 1259 OID 16681)
-- Name: firefighters_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.firefighters_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.firefighters_id_seq OWNER TO postgres;

--
-- TOC entry 4850 (class 0 OID 0)
-- Dependencies: 219
-- Name: firefighters_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.firefighters_id_seq OWNED BY public.firefighters.id;


--
-- TOC entry 221 (class 1259 OID 16756)
-- Name: firefighters_position_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.firefighters_position_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.firefighters_position_id_seq OWNER TO postgres;

--
-- TOC entry 4852 (class 0 OID 0)
-- Dependencies: 221
-- Name: firefighters_position_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.firefighters_position_id_seq OWNED BY public.firefighters.position_id;


--
-- TOC entry 225 (class 1259 OID 16825)
-- Name: firefighters_team_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.firefighters_team_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.firefighters_team_id_seq OWNER TO postgres;

--
-- TOC entry 4854 (class 0 OID 0)
-- Dependencies: 225
-- Name: firefighters_team_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.firefighters_team_id_seq OWNED BY public.firefighters.team_id;


--
-- TOC entry 216 (class 1259 OID 16412)
-- Name: positions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.positions (
    id bigint NOT NULL,
    name character varying(150) NOT NULL
);


ALTER TABLE public.positions OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16411)
-- Name: positions_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.positions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.positions_id_seq OWNER TO postgres;

--
-- TOC entry 4856 (class 0 OID 0)
-- Dependencies: 215
-- Name: positions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.positions_id_seq OWNED BY public.positions.id;


--
-- TOC entry 224 (class 1259 OID 16819)
-- Name: teams; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.teams (
    id bigint NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.teams OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16818)
-- Name: teams_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.teams_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.teams_id_seq OWNER TO postgres;

--
-- TOC entry 4859 (class 0 OID 0)
-- Dependencies: 223
-- Name: teams_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.teams_id_seq OWNED BY public.teams.id;


--
-- TOC entry 4665 (class 2604 OID 16884)
-- Name: cars id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cars ALTER COLUMN id SET DEFAULT nextval('public.cars_id_seq'::regclass);


--
-- TOC entry 4666 (class 2604 OID 16885)
-- Name: cars fire_station_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cars ALTER COLUMN fire_station_id SET DEFAULT nextval('public.cars_fire_station_id_seq'::regclass);


--
-- TOC entry 4659 (class 2604 OID 16422)
-- Name: fire_stations id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fire_stations ALTER COLUMN id SET DEFAULT nextval('public.fire_stations_id_seq'::regclass);


--
-- TOC entry 4660 (class 2604 OID 16685)
-- Name: firefighters id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN id SET DEFAULT nextval('public.firefighters_id_seq'::regclass);


--
-- TOC entry 4661 (class 2604 OID 16757)
-- Name: firefighters position_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN position_id SET DEFAULT nextval('public.firefighters_position_id_seq'::regclass);


--
-- TOC entry 4662 (class 2604 OID 16793)
-- Name: firefighters fire_station_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN fire_station_id SET DEFAULT nextval('public.firefighters_fire_station_id_seq'::regclass);


--
-- TOC entry 4663 (class 2604 OID 16826)
-- Name: firefighters team_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN team_id SET DEFAULT nextval('public.firefighters_team_id_seq'::regclass);


--
-- TOC entry 4658 (class 2604 OID 16415)
-- Name: positions id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.positions ALTER COLUMN id SET DEFAULT nextval('public.positions_id_seq'::regclass);


--
-- TOC entry 4664 (class 2604 OID 16822)
-- Name: teams id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teams ALTER COLUMN id SET DEFAULT nextval('public.teams_id_seq'::regclass);


--
-- TOC entry 4835 (class 0 OID 16881)
-- Dependencies: 228
-- Data for Name: cars; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cars (id, name, number_car, fire_station_id, team_id) VALUES (1, 'АЦ 4.0 40', 'П478АМ60', 1, 1);
INSERT INTO public.cars (id, name, number_car, fire_station_id, team_id) VALUES (2, 'АЦ 3.2 40', 'Х010МТ60', 3, 1);
INSERT INTO public.cars (id, name, number_car, fire_station_id, team_id) VALUES (3, 'АЦ 5.0 40', 'Н372ТА60', 1, 2);


--
-- TOC entry 4825 (class 0 OID 16419)
-- Dependencies: 218
-- Data for Name: fire_stations; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.fire_stations (id, number_station, name, short_name, location) VALUES (1, 1, '1 пожарно-спасательная часть', 'П 01', 'ул. Коммунальная, 62');
INSERT INTO public.fire_stations (id, number_station, name, short_name, location) VALUES (2, 11, 'Отдельный пост 1 пожарно-спасательной части', 'П 011', 'Максима Горького, 16');
INSERT INTO public.fire_stations (id, number_station, name, short_name, location) VALUES (3, 2, '2 пожарно-спасательная часть', 'П 02', 'Вокзальная, 12а');
INSERT INTO public.fire_stations (id, number_station, name, short_name, location) VALUES (4, 3, '3 пожарно-спасательная часть', 'П 03', 'Инженерная, 5');
INSERT INTO public.fire_stations (id, number_station, name, short_name, location) VALUES (5, 31, 'Отдельный пост 3 пожарно-спасательной части', 'П 031', 'Инженерная, 92');


--
-- TOC entry 4827 (class 0 OID 16682)
-- Dependencies: 220
-- Data for Name: firefighters; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.firefighters (id, first_name, mid_name, last_name, short_name, rank, position_id, fire_station_id, team_id) VALUES (15, 'Сергей', 'Васильевич', 'Иванов', 'С. В. Иванов', 'Сержант', 12, 3, NULL);
INSERT INTO public.firefighters (id, first_name, mid_name, last_name, short_name, rank, position_id, fire_station_id, team_id) VALUES (16, 'Сергей', 'Константинович', 'Андреев', 'С. К. Андреев', 'Сержант', 12, 3, NULL);
INSERT INTO public.firefighters (id, first_name, mid_name, last_name, short_name, rank, position_id, fire_station_id, team_id) VALUES (17, 'Андрей', 'Семенович', 'Васильев', 'А. С. Васильев', 'Сержант', 12, 3, NULL);
INSERT INTO public.firefighters (id, first_name, mid_name, last_name, short_name, rank, position_id, fire_station_id, team_id) VALUES (18, 'Сергей', 'Сергеевич', 'Андреев', 'С. С. Андреев', 'Сержант', 12, 3, NULL);
INSERT INTO public.firefighters (id, first_name, mid_name, last_name, short_name, rank, position_id, fire_station_id, team_id) VALUES (9, 'Сергей', 'Васильевич', 'Иванов', 'С. В. Иванов', 'Сержант', 13, 1, 1);
INSERT INTO public.firefighters (id, first_name, mid_name, last_name, short_name, rank, position_id, fire_station_id, team_id) VALUES (11, 'Сергей', 'Анатольевич', 'Иванов', 'С. А. Иванов', 'Сержант', 12, 1, 2);


--
-- TOC entry 4823 (class 0 OID 16412)
-- Dependencies: 216
-- Data for Name: positions; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.positions (id, name) VALUES (12, 'Пожарный');
INSERT INTO public.positions (id, name) VALUES (13, 'Старший пожарный');


--
-- TOC entry 4831 (class 0 OID 16819)
-- Dependencies: 224
-- Data for Name: teams; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.teams (id, name) VALUES (3, '3 ход');
INSERT INTO public.teams (id, name) VALUES (2, '2 ход');
INSERT INTO public.teams (id, name) VALUES (1, '1 ход');


--
-- TOC entry 4860 (class 0 OID 0)
-- Dependencies: 227
-- Name: cars_fire_station_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cars_fire_station_id_seq', 1, false);


--
-- TOC entry 4861 (class 0 OID 0)
-- Dependencies: 226
-- Name: cars_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cars_id_seq', 3, true);


--
-- TOC entry 4862 (class 0 OID 0)
-- Dependencies: 217
-- Name: fire_stations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.fire_stations_id_seq', 6, true);


--
-- TOC entry 4863 (class 0 OID 0)
-- Dependencies: 222
-- Name: firefighters_fire_station_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.firefighters_fire_station_id_seq', 1, true);


--
-- TOC entry 4864 (class 0 OID 0)
-- Dependencies: 219
-- Name: firefighters_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.firefighters_id_seq', 18, true);


--
-- TOC entry 4865 (class 0 OID 0)
-- Dependencies: 221
-- Name: firefighters_position_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.firefighters_position_id_seq', 1, true);


--
-- TOC entry 4866 (class 0 OID 0)
-- Dependencies: 225
-- Name: firefighters_team_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.firefighters_team_id_seq', 6, true);


--
-- TOC entry 4867 (class 0 OID 0)
-- Dependencies: 215
-- Name: positions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.positions_id_seq', 13, true);


--
-- TOC entry 4868 (class 0 OID 0)
-- Dependencies: 223
-- Name: teams_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.teams_id_seq', 3, true);


--
-- TOC entry 4676 (class 2606 OID 16887)
-- Name: cars cars_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cars
    ADD CONSTRAINT cars_pkey PRIMARY KEY (id);


--
-- TOC entry 4670 (class 2606 OID 16426)
-- Name: fire_stations fire_stations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fire_stations
    ADD CONSTRAINT fire_stations_pkey PRIMARY KEY (id);


--
-- TOC entry 4672 (class 2606 OID 16689)
-- Name: firefighters firefighters_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.firefighters
    ADD CONSTRAINT firefighters_pkey PRIMARY KEY (id);


--
-- TOC entry 4668 (class 2606 OID 16417)
-- Name: positions positions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.positions
    ADD CONSTRAINT positions_pkey PRIMARY KEY (id);


--
-- TOC entry 4674 (class 2606 OID 16824)
-- Name: teams teams_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teams
    ADD CONSTRAINT teams_pkey PRIMARY KEY (id);


--
-- TOC entry 4677 (class 2606 OID 16888)
-- Name: cars cars_fire_station_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cars
    ADD CONSTRAINT cars_fire_station_id_fkey FOREIGN KEY (fire_station_id) REFERENCES public.fire_stations(id);


--
-- TOC entry 4678 (class 2606 OID 16903)
-- Name: cars cars_team_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cars
    ADD CONSTRAINT cars_team_id_fkey FOREIGN KEY (team_id) REFERENCES public.teams(id);


--
-- TOC entry 4841 (class 0 OID 0)
-- Dependencies: 228
-- Name: TABLE cars; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.cars TO adminfire;


--
-- TOC entry 4844 (class 0 OID 0)
-- Dependencies: 218
-- Name: TABLE fire_stations; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.fire_stations TO adminfire;


--
-- TOC entry 4846 (class 0 OID 0)
-- Dependencies: 217
-- Name: SEQUENCE fire_stations_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.fire_stations_id_seq TO adminfire;


--
-- TOC entry 4847 (class 0 OID 0)
-- Dependencies: 220
-- Name: TABLE firefighters; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.firefighters TO adminfire;


--
-- TOC entry 4849 (class 0 OID 0)
-- Dependencies: 222
-- Name: SEQUENCE firefighters_fire_station_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.firefighters_fire_station_id_seq TO adminfire;


--
-- TOC entry 4851 (class 0 OID 0)
-- Dependencies: 219
-- Name: SEQUENCE firefighters_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.firefighters_id_seq TO adminfire;


--
-- TOC entry 4853 (class 0 OID 0)
-- Dependencies: 221
-- Name: SEQUENCE firefighters_position_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.firefighters_position_id_seq TO adminfire;


--
-- TOC entry 4855 (class 0 OID 0)
-- Dependencies: 216
-- Name: TABLE positions; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.positions TO adminfire;


--
-- TOC entry 4857 (class 0 OID 0)
-- Dependencies: 215
-- Name: SEQUENCE positions_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,USAGE ON SEQUENCE public.positions_id_seq TO adminfire;


--
-- TOC entry 4858 (class 0 OID 0)
-- Dependencies: 224
-- Name: TABLE teams; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.teams TO adminfire;


-- Completed on 2024-07-09 22:03:10

--
-- PostgreSQL database dump complete
--

