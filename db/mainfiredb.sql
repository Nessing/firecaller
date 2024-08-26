--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

-- Started on 2024-08-26 18:25:07

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

GRANT ALL PRIVILEGES ON DATABASE mainfiredb TO adminfire;

--
-- TOC entry 215 (class 1259 OID 25440)
-- Name: cars; Type: TABLE; Schema: public; Owner: adminfire
--

CREATE TABLE public.cars (
    id bigint NOT NULL,
    name character varying(100) NOT NULL,
    number_car character varying(50) NOT NULL,
    fire_station_id bigint NOT NULL,
    team_id bigint
);


ALTER TABLE public.cars OWNER TO adminfire;

--
-- TOC entry 216 (class 1259 OID 25443)
-- Name: cars_fire_station_id_seq; Type: SEQUENCE; Schema: public; Owner: adminfire
--

CREATE SEQUENCE public.cars_fire_station_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cars_fire_station_id_seq OWNER TO adminfire;

--
-- TOC entry 4862 (class 0 OID 0)
-- Dependencies: 216
-- Name: cars_fire_station_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.cars_fire_station_id_seq OWNED BY public.cars.fire_station_id;


--
-- TOC entry 217 (class 1259 OID 25444)
-- Name: cars_id_seq; Type: SEQUENCE; Schema: public; Owner: adminfire
--

CREATE SEQUENCE public.cars_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cars_id_seq OWNER TO adminfire;

--
-- TOC entry 4863 (class 0 OID 0)
-- Dependencies: 217
-- Name: cars_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.cars_id_seq OWNED BY public.cars.id;


--
-- TOC entry 218 (class 1259 OID 25445)
-- Name: fire_stations; Type: TABLE; Schema: public; Owner: adminfire
--

CREATE TABLE public.fire_stations (
    id bigint NOT NULL,
    number_station integer NOT NULL,
    name character varying(250) NOT NULL,
    short_name character varying(100) NOT NULL,
    location character varying(150) NOT NULL
);


ALTER TABLE public.fire_stations OWNER TO adminfire;

--
-- TOC entry 219 (class 1259 OID 25450)
-- Name: fire_stations_id_seq; Type: SEQUENCE; Schema: public; Owner: adminfire
--

CREATE SEQUENCE public.fire_stations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.fire_stations_id_seq OWNER TO adminfire;

--
-- TOC entry 4864 (class 0 OID 0)
-- Dependencies: 219
-- Name: fire_stations_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.fire_stations_id_seq OWNED BY public.fire_stations.id;


--
-- TOC entry 220 (class 1259 OID 25451)
-- Name: firefighters; Type: TABLE; Schema: public; Owner: adminfire
--

CREATE TABLE public.firefighters (
    id bigint NOT NULL,
    first_name character varying(150) NOT NULL,
    mid_name character varying(150),
    last_name character varying(150) NOT NULL,
    short_name character varying(150) NOT NULL,
    position_id bigint NOT NULL,
    fire_station_id bigint NOT NULL,
    team_id bigint,
    rank_id bigint NOT NULL
);


ALTER TABLE public.firefighters OWNER TO adminfire;

--
-- TOC entry 221 (class 1259 OID 25456)
-- Name: firefighters_fire_station_id_seq; Type: SEQUENCE; Schema: public; Owner: adminfire
--

CREATE SEQUENCE public.firefighters_fire_station_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.firefighters_fire_station_id_seq OWNER TO adminfire;

--
-- TOC entry 4865 (class 0 OID 0)
-- Dependencies: 221
-- Name: firefighters_fire_station_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.firefighters_fire_station_id_seq OWNED BY public.firefighters.fire_station_id;


--
-- TOC entry 222 (class 1259 OID 25457)
-- Name: firefighters_id_seq; Type: SEQUENCE; Schema: public; Owner: adminfire
--

CREATE SEQUENCE public.firefighters_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.firefighters_id_seq OWNER TO adminfire;

--
-- TOC entry 4866 (class 0 OID 0)
-- Dependencies: 222
-- Name: firefighters_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.firefighters_id_seq OWNED BY public.firefighters.id;


--
-- TOC entry 223 (class 1259 OID 25458)
-- Name: firefighters_position_id_seq; Type: SEQUENCE; Schema: public; Owner: adminfire
--

CREATE SEQUENCE public.firefighters_position_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.firefighters_position_id_seq OWNER TO adminfire;

--
-- TOC entry 4867 (class 0 OID 0)
-- Dependencies: 223
-- Name: firefighters_position_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.firefighters_position_id_seq OWNED BY public.firefighters.position_id;


--
-- TOC entry 224 (class 1259 OID 25459)
-- Name: firefighters_rank_id_seq; Type: SEQUENCE; Schema: public; Owner: adminfire
--

CREATE SEQUENCE public.firefighters_rank_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.firefighters_rank_id_seq OWNER TO adminfire;

--
-- TOC entry 4868 (class 0 OID 0)
-- Dependencies: 224
-- Name: firefighters_rank_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.firefighters_rank_id_seq OWNED BY public.firefighters.rank_id;


--
-- TOC entry 225 (class 1259 OID 25460)
-- Name: firefighters_team_id_seq; Type: SEQUENCE; Schema: public; Owner: adminfire
--

CREATE SEQUENCE public.firefighters_team_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.firefighters_team_id_seq OWNER TO adminfire;

--
-- TOC entry 4869 (class 0 OID 0)
-- Dependencies: 225
-- Name: firefighters_team_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.firefighters_team_id_seq OWNED BY public.firefighters.team_id;


--
-- TOC entry 226 (class 1259 OID 25461)
-- Name: positions; Type: TABLE; Schema: public; Owner: adminfire
--

CREATE TABLE public.positions (
    id bigint NOT NULL,
    name character varying(150) NOT NULL
);


ALTER TABLE public.positions OWNER TO adminfire;

--
-- TOC entry 227 (class 1259 OID 25464)
-- Name: positions_id_seq; Type: SEQUENCE; Schema: public; Owner: adminfire
--

CREATE SEQUENCE public.positions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.positions_id_seq OWNER TO adminfire;

--
-- TOC entry 4870 (class 0 OID 0)
-- Dependencies: 227
-- Name: positions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.positions_id_seq OWNED BY public.positions.id;


--
-- TOC entry 228 (class 1259 OID 25465)
-- Name: ranks; Type: TABLE; Schema: public; Owner: adminfire
--

CREATE TABLE public.ranks (
    id bigint NOT NULL,
    name character varying(150) NOT NULL
);


ALTER TABLE public.ranks OWNER TO adminfire;

--
-- TOC entry 229 (class 1259 OID 25468)
-- Name: ranks_id_seq; Type: SEQUENCE; Schema: public; Owner: adminfire
--

CREATE SEQUENCE public.ranks_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.ranks_id_seq OWNER TO adminfire;

--
-- TOC entry 4871 (class 0 OID 0)
-- Dependencies: 229
-- Name: ranks_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.ranks_id_seq OWNED BY public.ranks.id;


--
-- TOC entry 232 (class 1259 OID 25511)
-- Name: status; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.status (
    id bigint NOT NULL,
    name character varying(50) NOT NULL,
    title character varying(50) NOT NULL
);


ALTER TABLE public.status OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 25469)
-- Name: teams; Type: TABLE; Schema: public; Owner: adminfire
--

CREATE TABLE public.teams (
    id bigint NOT NULL,
    name character varying(50) NOT NULL,
    status_id bigint NOT NULL
);


ALTER TABLE public.teams OWNER TO adminfire;

--
-- TOC entry 231 (class 1259 OID 25472)
-- Name: teams_id_seq; Type: SEQUENCE; Schema: public; Owner: adminfire
--

CREATE SEQUENCE public.teams_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.teams_id_seq OWNER TO adminfire;

--
-- TOC entry 4873 (class 0 OID 0)
-- Dependencies: 231
-- Name: teams_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.teams_id_seq OWNED BY public.teams.id;


--
-- TOC entry 4668 (class 2604 OID 25473)
-- Name: cars id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.cars ALTER COLUMN id SET DEFAULT nextval('public.cars_id_seq'::regclass);


--
-- TOC entry 4669 (class 2604 OID 25474)
-- Name: cars fire_station_id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.cars ALTER COLUMN fire_station_id SET DEFAULT nextval('public.cars_fire_station_id_seq'::regclass);


--
-- TOC entry 4670 (class 2604 OID 25475)
-- Name: fire_stations id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.fire_stations ALTER COLUMN id SET DEFAULT nextval('public.fire_stations_id_seq'::regclass);


--
-- TOC entry 4671 (class 2604 OID 25476)
-- Name: firefighters id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN id SET DEFAULT nextval('public.firefighters_id_seq'::regclass);


--
-- TOC entry 4672 (class 2604 OID 25477)
-- Name: firefighters position_id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN position_id SET DEFAULT nextval('public.firefighters_position_id_seq'::regclass);


--
-- TOC entry 4673 (class 2604 OID 25478)
-- Name: firefighters fire_station_id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN fire_station_id SET DEFAULT nextval('public.firefighters_fire_station_id_seq'::regclass);


--
-- TOC entry 4674 (class 2604 OID 25479)
-- Name: firefighters team_id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN team_id SET DEFAULT nextval('public.firefighters_team_id_seq'::regclass);


--
-- TOC entry 4675 (class 2604 OID 25480)
-- Name: firefighters rank_id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN rank_id SET DEFAULT nextval('public.firefighters_rank_id_seq'::regclass);


--
-- TOC entry 4676 (class 2604 OID 25481)
-- Name: positions id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.positions ALTER COLUMN id SET DEFAULT nextval('public.positions_id_seq'::regclass);


--
-- TOC entry 4677 (class 2604 OID 25482)
-- Name: ranks id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.ranks ALTER COLUMN id SET DEFAULT nextval('public.ranks_id_seq'::regclass);


--
-- TOC entry 4678 (class 2604 OID 25483)
-- Name: teams id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.teams ALTER COLUMN id SET DEFAULT nextval('public.teams_id_seq'::regclass);


--
-- TOC entry 4839 (class 0 OID 25440)
-- Dependencies: 215
-- Data for Name: cars; Type: TABLE DATA; Schema: public; Owner: adminfire
--

INSERT INTO public.cars VALUES (2, 'АЦ 3.2 40', 'Х010МТ60', 3, 1);
INSERT INTO public.cars VALUES (7, 'АЦ 5.0 40', 'М178АА51', 1, 2);
INSERT INTO public.cars VALUES (6, 'АЦ 3.2 2/40', 'П222МТ60', 1, 1);
INSERT INTO public.cars VALUES (9, 'АЛ-30', 'М162РН060', 1, 3);


--
-- TOC entry 4842 (class 0 OID 25445)
-- Dependencies: 218
-- Data for Name: fire_stations; Type: TABLE DATA; Schema: public; Owner: adminfire
--

INSERT INTO public.fire_stations VALUES (1, 1, '1 пожарно-спасательная часть', 'П 01', 'ул. Коммунальная, 62');
INSERT INTO public.fire_stations VALUES (2, 11, 'Отдельный пост 1 пожарно-спасательной части', 'П 011', 'Максима Горького, 16');
INSERT INTO public.fire_stations VALUES (3, 2, '2 пожарно-спасательная часть', 'П 02', 'Вокзальная, 12а');
INSERT INTO public.fire_stations VALUES (4, 3, '3 пожарно-спасательная часть', 'П 03', 'Инженерная, 5');
INSERT INTO public.fire_stations VALUES (5, 31, 'Отдельный пост 3 пожарно-спасательной части', 'П 031', 'Инженерная, 92');


--
-- TOC entry 4844 (class 0 OID 25451)
-- Dependencies: 220
-- Data for Name: firefighters; Type: TABLE DATA; Schema: public; Owner: adminfire
--

INSERT INTO public.firefighters VALUES (15, 'Сергей', 'Васильевич', 'Иванов', 'С. В. Иванов', 12, 3, NULL, 1);
INSERT INTO public.firefighters VALUES (16, 'Сергей', 'Константинович', 'Андреев', 'С. К. Андреев', 12, 3, NULL, 1);
INSERT INTO public.firefighters VALUES (17, 'Андрей', 'Семенович', 'Васильев', 'А. С. Васильев', 12, 3, NULL, 1);
INSERT INTO public.firefighters VALUES (18, 'Сергей', 'Сергеевич', 'Андреев', 'С. С. Андреев', 12, 3, NULL, 1);
INSERT INTO public.firefighters VALUES (20, 'Валентин', 'Анатольевич', 'Михайлов', 'В. А. Михайлов', 13, 3, 1, 4);
INSERT INTO public.firefighters VALUES (11, 'Сергей', 'Анатольевич', 'Иванов', 'С. А. Иванов', 14, 1, 2, 4);
INSERT INTO public.firefighters VALUES (19, 'Петр', 'Михайлович', 'Валентинов', 'П. М. Валентинов', 13, 1, 1, 1);
INSERT INTO public.firefighters VALUES (21, 'Валентин', 'Сергеевич', 'Михайлов', 'В. С. Михайлов', 14, 1, 1, 1);


--
-- TOC entry 4850 (class 0 OID 25461)
-- Dependencies: 226
-- Data for Name: positions; Type: TABLE DATA; Schema: public; Owner: adminfire
--

INSERT INTO public.positions VALUES (12, 'Пожарный');
INSERT INTO public.positions VALUES (13, 'Старший пожарный');
INSERT INTO public.positions VALUES (14, 'Начальник караула');


--
-- TOC entry 4852 (class 0 OID 25465)
-- Dependencies: 228
-- Data for Name: ranks; Type: TABLE DATA; Schema: public; Owner: adminfire
--

INSERT INTO public.ranks VALUES (1, 'Вольнонаемный');
INSERT INTO public.ranks VALUES (4, 'Мл. Сержант');


--
-- TOC entry 4856 (class 0 OID 25511)
-- Dependencies: 232
-- Data for Name: status; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.status VALUES (1, 'calm', 'в части');
INSERT INTO public.status VALUES (2, 'on_the_way', 'в пути');
INSERT INTO public.status VALUES (3, 'on_the_destination', 'на месте вызова');


--
-- TOC entry 4854 (class 0 OID 25469)
-- Dependencies: 230
-- Data for Name: teams; Type: TABLE DATA; Schema: public; Owner: adminfire
--

INSERT INTO public.teams VALUES (3, '3 ход', 1);
INSERT INTO public.teams VALUES (2, '2 ход', 2);
INSERT INTO public.teams VALUES (1, '1 ход', 3);


--
-- TOC entry 4874 (class 0 OID 0)
-- Dependencies: 216
-- Name: cars_fire_station_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.cars_fire_station_id_seq', 1, false);


--
-- TOC entry 4875 (class 0 OID 0)
-- Dependencies: 217
-- Name: cars_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.cars_id_seq', 9, true);


--
-- TOC entry 4876 (class 0 OID 0)
-- Dependencies: 219
-- Name: fire_stations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.fire_stations_id_seq', 6, true);


--
-- TOC entry 4877 (class 0 OID 0)
-- Dependencies: 221
-- Name: firefighters_fire_station_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.firefighters_fire_station_id_seq', 1, true);


--
-- TOC entry 4878 (class 0 OID 0)
-- Dependencies: 222
-- Name: firefighters_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.firefighters_id_seq', 22, true);


--
-- TOC entry 4879 (class 0 OID 0)
-- Dependencies: 223
-- Name: firefighters_position_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.firefighters_position_id_seq', 1, true);


--
-- TOC entry 4880 (class 0 OID 0)
-- Dependencies: 224
-- Name: firefighters_rank_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.firefighters_rank_id_seq', 7, true);


--
-- TOC entry 4881 (class 0 OID 0)
-- Dependencies: 225
-- Name: firefighters_team_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.firefighters_team_id_seq', 6, true);


--
-- TOC entry 4882 (class 0 OID 0)
-- Dependencies: 227
-- Name: positions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.positions_id_seq', 14, true);


--
-- TOC entry 4883 (class 0 OID 0)
-- Dependencies: 229
-- Name: ranks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.ranks_id_seq', 4, true);


--
-- TOC entry 4884 (class 0 OID 0)
-- Dependencies: 231
-- Name: teams_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.teams_id_seq', 3, true);


--
-- TOC entry 4680 (class 2606 OID 25485)
-- Name: cars cars_pkey; Type: CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.cars
    ADD CONSTRAINT cars_pkey PRIMARY KEY (id);


--
-- TOC entry 4682 (class 2606 OID 25487)
-- Name: fire_stations fire_stations_pkey; Type: CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.fire_stations
    ADD CONSTRAINT fire_stations_pkey PRIMARY KEY (id);


--
-- TOC entry 4684 (class 2606 OID 25489)
-- Name: firefighters firefighters_pkey; Type: CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters
    ADD CONSTRAINT firefighters_pkey PRIMARY KEY (id);


--
-- TOC entry 4686 (class 2606 OID 25491)
-- Name: positions positions_pkey; Type: CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.positions
    ADD CONSTRAINT positions_pkey PRIMARY KEY (id);


--
-- TOC entry 4688 (class 2606 OID 25493)
-- Name: ranks ranks_pkey; Type: CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.ranks
    ADD CONSTRAINT ranks_pkey PRIMARY KEY (id);


--
-- TOC entry 4692 (class 2606 OID 25515)
-- Name: status status_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.status
    ADD CONSTRAINT status_pkey PRIMARY KEY (id);


--
-- TOC entry 4690 (class 2606 OID 25495)
-- Name: teams teams_pkey; Type: CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.teams
    ADD CONSTRAINT teams_pkey PRIMARY KEY (id);


--
-- TOC entry 4693 (class 2606 OID 25496)
-- Name: cars cars_fire_station_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.cars
    ADD CONSTRAINT cars_fire_station_id_fkey FOREIGN KEY (fire_station_id) REFERENCES public.fire_stations(id);


--
-- TOC entry 4694 (class 2606 OID 25501)
-- Name: cars cars_team_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.cars
    ADD CONSTRAINT cars_team_id_fkey FOREIGN KEY (team_id) REFERENCES public.teams(id);


--
-- TOC entry 4695 (class 2606 OID 25506)
-- Name: firefighters firefighters_rank_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters
    ADD CONSTRAINT firefighters_rank_id_fkey FOREIGN KEY (rank_id) REFERENCES public.ranks(id);


--
-- TOC entry 4872 (class 0 OID 0)
-- Dependencies: 232
-- Name: TABLE status; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.status TO adminfire;


-- Completed on 2024-08-26 18:25:08

--
-- PostgreSQL database dump complete
--

