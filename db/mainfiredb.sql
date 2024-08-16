--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

-- Started on 2024-08-16 18:16:28

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
-- TOC entry 228 (class 1259 OID 16881)
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
-- TOC entry 227 (class 1259 OID 16880)
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
-- TOC entry 4856 (class 0 OID 0)
-- Dependencies: 227
-- Name: cars_fire_station_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.cars_fire_station_id_seq OWNED BY public.cars.fire_station_id;


--
-- TOC entry 226 (class 1259 OID 16879)
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
-- TOC entry 4857 (class 0 OID 0)
-- Dependencies: 226
-- Name: cars_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.cars_id_seq OWNED BY public.cars.id;


--
-- TOC entry 218 (class 1259 OID 16419)
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
-- TOC entry 217 (class 1259 OID 16418)
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
-- TOC entry 4860 (class 0 OID 0)
-- Dependencies: 217
-- Name: fire_stations_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.fire_stations_id_seq OWNED BY public.fire_stations.id;


--
-- TOC entry 220 (class 1259 OID 16682)
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
-- TOC entry 222 (class 1259 OID 16792)
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
-- TOC entry 4863 (class 0 OID 0)
-- Dependencies: 222
-- Name: firefighters_fire_station_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.firefighters_fire_station_id_seq OWNED BY public.firefighters.fire_station_id;


--
-- TOC entry 219 (class 1259 OID 16681)
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
-- TOC entry 4865 (class 0 OID 0)
-- Dependencies: 219
-- Name: firefighters_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.firefighters_id_seq OWNED BY public.firefighters.id;


--
-- TOC entry 221 (class 1259 OID 16756)
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
-- Dependencies: 221
-- Name: firefighters_position_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.firefighters_position_id_seq OWNED BY public.firefighters.position_id;


--
-- TOC entry 231 (class 1259 OID 25092)
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
-- TOC entry 4869 (class 0 OID 0)
-- Dependencies: 231
-- Name: firefighters_rank_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.firefighters_rank_id_seq OWNED BY public.firefighters.rank_id;


--
-- TOC entry 225 (class 1259 OID 16825)
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
-- TOC entry 4870 (class 0 OID 0)
-- Dependencies: 225
-- Name: firefighters_team_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.firefighters_team_id_seq OWNED BY public.firefighters.team_id;


--
-- TOC entry 216 (class 1259 OID 16412)
-- Name: positions; Type: TABLE; Schema: public; Owner: adminfire
--

CREATE TABLE public.positions (
    id bigint NOT NULL,
    name character varying(150) NOT NULL
);


ALTER TABLE public.positions OWNER TO adminfire;

--
-- TOC entry 215 (class 1259 OID 16411)
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
-- TOC entry 4872 (class 0 OID 0)
-- Dependencies: 215
-- Name: positions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.positions_id_seq OWNED BY public.positions.id;


--
-- TOC entry 230 (class 1259 OID 25086)
-- Name: ranks; Type: TABLE; Schema: public; Owner: adminfire
--

CREATE TABLE public.ranks (
    id bigint NOT NULL,
    name character varying(150) NOT NULL
);


ALTER TABLE public.ranks OWNER TO adminfire;

--
-- TOC entry 229 (class 1259 OID 25085)
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
-- TOC entry 4875 (class 0 OID 0)
-- Dependencies: 229
-- Name: ranks_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.ranks_id_seq OWNED BY public.ranks.id;


--
-- TOC entry 224 (class 1259 OID 16819)
-- Name: teams; Type: TABLE; Schema: public; Owner: adminfire
--

CREATE TABLE public.teams (
    id bigint NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.teams OWNER TO adminfire;

--
-- TOC entry 223 (class 1259 OID 16818)
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
-- TOC entry 4878 (class 0 OID 0)
-- Dependencies: 223
-- Name: teams_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.teams_id_seq OWNED BY public.teams.id;


--
-- TOC entry 4672 (class 2604 OID 16884)
-- Name: cars id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.cars ALTER COLUMN id SET DEFAULT nextval('public.cars_id_seq'::regclass);


--
-- TOC entry 4673 (class 2604 OID 16885)
-- Name: cars fire_station_id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.cars ALTER COLUMN fire_station_id SET DEFAULT nextval('public.cars_fire_station_id_seq'::regclass);


--
-- TOC entry 4665 (class 2604 OID 16422)
-- Name: fire_stations id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.fire_stations ALTER COLUMN id SET DEFAULT nextval('public.fire_stations_id_seq'::regclass);


--
-- TOC entry 4666 (class 2604 OID 16685)
-- Name: firefighters id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN id SET DEFAULT nextval('public.firefighters_id_seq'::regclass);


--
-- TOC entry 4667 (class 2604 OID 16757)
-- Name: firefighters position_id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN position_id SET DEFAULT nextval('public.firefighters_position_id_seq'::regclass);


--
-- TOC entry 4668 (class 2604 OID 16793)
-- Name: firefighters fire_station_id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN fire_station_id SET DEFAULT nextval('public.firefighters_fire_station_id_seq'::regclass);


--
-- TOC entry 4669 (class 2604 OID 16826)
-- Name: firefighters team_id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN team_id SET DEFAULT nextval('public.firefighters_team_id_seq'::regclass);


--
-- TOC entry 4670 (class 2604 OID 25093)
-- Name: firefighters rank_id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN rank_id SET DEFAULT nextval('public.firefighters_rank_id_seq'::regclass);


--
-- TOC entry 4664 (class 2604 OID 16415)
-- Name: positions id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.positions ALTER COLUMN id SET DEFAULT nextval('public.positions_id_seq'::regclass);


--
-- TOC entry 4674 (class 2604 OID 25089)
-- Name: ranks id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.ranks ALTER COLUMN id SET DEFAULT nextval('public.ranks_id_seq'::regclass);


--
-- TOC entry 4671 (class 2604 OID 16822)
-- Name: teams id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.teams ALTER COLUMN id SET DEFAULT nextval('public.teams_id_seq'::regclass);


--
-- TOC entry 4846 (class 0 OID 16881)
-- Dependencies: 228
-- Data for Name: cars; Type: TABLE DATA; Schema: public; Owner: adminfire
--

INSERT INTO public.cars VALUES (2, 'АЦ 3.2 40', 'Х010МТ60', 3, 1);
INSERT INTO public.cars VALUES (7, 'АЦ 5.0 40', 'М178АА51', 1, 2);
INSERT INTO public.cars VALUES (6, 'АЦ 3.2 2/40', 'П222МТ60', 1, 1);


--
-- TOC entry 4836 (class 0 OID 16419)
-- Dependencies: 218
-- Data for Name: fire_stations; Type: TABLE DATA; Schema: public; Owner: adminfire
--

INSERT INTO public.fire_stations VALUES (1, 1, '1 пожарно-спасательная часть', 'П 01', 'ул. Коммунальная, 62');
INSERT INTO public.fire_stations VALUES (2, 11, 'Отдельный пост 1 пожарно-спасательной части', 'П 011', 'Максима Горького, 16');
INSERT INTO public.fire_stations VALUES (3, 2, '2 пожарно-спасательная часть', 'П 02', 'Вокзальная, 12а');
INSERT INTO public.fire_stations VALUES (4, 3, '3 пожарно-спасательная часть', 'П 03', 'Инженерная, 5');
INSERT INTO public.fire_stations VALUES (5, 31, 'Отдельный пост 3 пожарно-спасательной части', 'П 031', 'Инженерная, 92');


--
-- TOC entry 4838 (class 0 OID 16682)
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
-- TOC entry 4834 (class 0 OID 16412)
-- Dependencies: 216
-- Data for Name: positions; Type: TABLE DATA; Schema: public; Owner: adminfire
--

INSERT INTO public.positions VALUES (12, 'Пожарный');
INSERT INTO public.positions VALUES (13, 'Старший пожарный');
INSERT INTO public.positions VALUES (14, 'Начальник караула');


--
-- TOC entry 4848 (class 0 OID 25086)
-- Dependencies: 230
-- Data for Name: ranks; Type: TABLE DATA; Schema: public; Owner: adminfire
--

INSERT INTO public.ranks VALUES (1, 'Вольнонаемный');
INSERT INTO public.ranks VALUES (4, 'Мл. Сержант');


--
-- TOC entry 4842 (class 0 OID 16819)
-- Dependencies: 224
-- Data for Name: teams; Type: TABLE DATA; Schema: public; Owner: adminfire
--

INSERT INTO public.teams VALUES (3, '3 ход');
INSERT INTO public.teams VALUES (2, '2 ход');
INSERT INTO public.teams VALUES (1, '1 ход');


--
-- TOC entry 4879 (class 0 OID 0)
-- Dependencies: 227
-- Name: cars_fire_station_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.cars_fire_station_id_seq', 1, false);


--
-- TOC entry 4880 (class 0 OID 0)
-- Dependencies: 226
-- Name: cars_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.cars_id_seq', 7, true);


--
-- TOC entry 4881 (class 0 OID 0)
-- Dependencies: 217
-- Name: fire_stations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.fire_stations_id_seq', 6, true);


--
-- TOC entry 4882 (class 0 OID 0)
-- Dependencies: 222
-- Name: firefighters_fire_station_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.firefighters_fire_station_id_seq', 1, true);


--
-- TOC entry 4883 (class 0 OID 0)
-- Dependencies: 219
-- Name: firefighters_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.firefighters_id_seq', 22, true);


--
-- TOC entry 4884 (class 0 OID 0)
-- Dependencies: 221
-- Name: firefighters_position_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.firefighters_position_id_seq', 1, true);


--
-- TOC entry 4885 (class 0 OID 0)
-- Dependencies: 231
-- Name: firefighters_rank_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.firefighters_rank_id_seq', 7, true);


--
-- TOC entry 4886 (class 0 OID 0)
-- Dependencies: 225
-- Name: firefighters_team_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.firefighters_team_id_seq', 6, true);


--
-- TOC entry 4887 (class 0 OID 0)
-- Dependencies: 215
-- Name: positions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.positions_id_seq', 14, true);


--
-- TOC entry 4888 (class 0 OID 0)
-- Dependencies: 229
-- Name: ranks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.ranks_id_seq', 4, true);


--
-- TOC entry 4889 (class 0 OID 0)
-- Dependencies: 223
-- Name: teams_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.teams_id_seq', 3, true);


--
-- TOC entry 4684 (class 2606 OID 16887)
-- Name: cars cars_pkey; Type: CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.cars
    ADD CONSTRAINT cars_pkey PRIMARY KEY (id);


--
-- TOC entry 4678 (class 2606 OID 16426)
-- Name: fire_stations fire_stations_pkey; Type: CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.fire_stations
    ADD CONSTRAINT fire_stations_pkey PRIMARY KEY (id);


--
-- TOC entry 4680 (class 2606 OID 16689)
-- Name: firefighters firefighters_pkey; Type: CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters
    ADD CONSTRAINT firefighters_pkey PRIMARY KEY (id);


--
-- TOC entry 4676 (class 2606 OID 16417)
-- Name: positions positions_pkey; Type: CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.positions
    ADD CONSTRAINT positions_pkey PRIMARY KEY (id);


--
-- TOC entry 4686 (class 2606 OID 25091)
-- Name: ranks ranks_pkey; Type: CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.ranks
    ADD CONSTRAINT ranks_pkey PRIMARY KEY (id);


--
-- TOC entry 4682 (class 2606 OID 16824)
-- Name: teams teams_pkey; Type: CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.teams
    ADD CONSTRAINT teams_pkey PRIMARY KEY (id);


--
-- TOC entry 4688 (class 2606 OID 16888)
-- Name: cars cars_fire_station_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.cars
    ADD CONSTRAINT cars_fire_station_id_fkey FOREIGN KEY (fire_station_id) REFERENCES public.fire_stations(id);


--
-- TOC entry 4689 (class 2606 OID 16903)
-- Name: cars cars_team_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.cars
    ADD CONSTRAINT cars_team_id_fkey FOREIGN KEY (team_id) REFERENCES public.teams(id);


--
-- TOC entry 4687 (class 2606 OID 25110)
-- Name: firefighters firefighters_rank_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters
    ADD CONSTRAINT firefighters_rank_id_fkey FOREIGN KEY (rank_id) REFERENCES public.ranks(id);


--
-- TOC entry 4855 (class 0 OID 0)
-- Dependencies: 228
-- Name: TABLE cars; Type: ACL; Schema: public; Owner: adminfire
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.cars TO adminfire;


--
-- TOC entry 4858 (class 0 OID 0)
-- Dependencies: 226
-- Name: SEQUENCE cars_id_seq; Type: ACL; Schema: public; Owner: adminfire
--

GRANT ALL ON SEQUENCE public.cars_id_seq TO adminfire;


--
-- TOC entry 4859 (class 0 OID 0)
-- Dependencies: 218
-- Name: TABLE fire_stations; Type: ACL; Schema: public; Owner: adminfire
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.fire_stations TO adminfire;


--
-- TOC entry 4861 (class 0 OID 0)
-- Dependencies: 217
-- Name: SEQUENCE fire_stations_id_seq; Type: ACL; Schema: public; Owner: adminfire
--

GRANT SELECT,USAGE ON SEQUENCE public.fire_stations_id_seq TO adminfire;


--
-- TOC entry 4862 (class 0 OID 0)
-- Dependencies: 220
-- Name: TABLE firefighters; Type: ACL; Schema: public; Owner: adminfire
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.firefighters TO adminfire;


--
-- TOC entry 4864 (class 0 OID 0)
-- Dependencies: 222
-- Name: SEQUENCE firefighters_fire_station_id_seq; Type: ACL; Schema: public; Owner: adminfire
--

GRANT SELECT,USAGE ON SEQUENCE public.firefighters_fire_station_id_seq TO adminfire;


--
-- TOC entry 4866 (class 0 OID 0)
-- Dependencies: 219
-- Name: SEQUENCE firefighters_id_seq; Type: ACL; Schema: public; Owner: adminfire
--

GRANT SELECT,USAGE ON SEQUENCE public.firefighters_id_seq TO adminfire;


--
-- TOC entry 4868 (class 0 OID 0)
-- Dependencies: 221
-- Name: SEQUENCE firefighters_position_id_seq; Type: ACL; Schema: public; Owner: adminfire
--

GRANT SELECT,USAGE ON SEQUENCE public.firefighters_position_id_seq TO adminfire;


--
-- TOC entry 4871 (class 0 OID 0)
-- Dependencies: 216
-- Name: TABLE positions; Type: ACL; Schema: public; Owner: adminfire
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.positions TO adminfire;


--
-- TOC entry 4873 (class 0 OID 0)
-- Dependencies: 215
-- Name: SEQUENCE positions_id_seq; Type: ACL; Schema: public; Owner: adminfire
--

GRANT SELECT,USAGE ON SEQUENCE public.positions_id_seq TO adminfire;


--
-- TOC entry 4874 (class 0 OID 0)
-- Dependencies: 230
-- Name: TABLE ranks; Type: ACL; Schema: public; Owner: adminfire
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.ranks TO adminfire;


--
-- TOC entry 4876 (class 0 OID 0)
-- Dependencies: 229
-- Name: SEQUENCE ranks_id_seq; Type: ACL; Schema: public; Owner: adminfire
--

GRANT ALL ON SEQUENCE public.ranks_id_seq TO adminfire;


--
-- TOC entry 4877 (class 0 OID 0)
-- Dependencies: 224
-- Name: TABLE teams; Type: ACL; Schema: public; Owner: adminfire
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.teams TO adminfire;


-- Completed on 2024-08-16 18:16:28

--
-- PostgreSQL database dump complete
--

