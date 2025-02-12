--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

-- Started on 2025-02-11 18:08:29

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

--
-- TOC entry 4928 (class 1262 OID 25439)
-- Name: mainfiredb; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE mainfiredb WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';


ALTER DATABASE mainfiredb OWNER TO postgres;

\connect mainfiredb

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
-- TOC entry 4930 (class 0 OID 0)
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
-- TOC entry 4931 (class 0 OID 0)
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
-- TOC entry 4932 (class 0 OID 0)
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
-- TOC entry 4933 (class 0 OID 0)
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
-- TOC entry 4934 (class 0 OID 0)
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
-- TOC entry 4935 (class 0 OID 0)
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
-- TOC entry 4936 (class 0 OID 0)
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
-- TOC entry 4937 (class 0 OID 0)
-- Dependencies: 225
-- Name: firefighters_team_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.firefighters_team_id_seq OWNED BY public.firefighters.team_id;


--
-- TOC entry 241 (class 1259 OID 25655)
-- Name: permissions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.permissions (
    id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.permissions OWNER TO postgres;

--
-- TOC entry 240 (class 1259 OID 25654)
-- Name: permissions_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.permissions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.permissions_id_seq OWNER TO postgres;

--
-- TOC entry 4939 (class 0 OID 0)
-- Dependencies: 240
-- Name: permissions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.permissions_id_seq OWNED BY public.permissions.id;


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
-- TOC entry 4941 (class 0 OID 0)
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
-- TOC entry 4942 (class 0 OID 0)
-- Dependencies: 229
-- Name: ranks_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.ranks_id_seq OWNED BY public.ranks.id;


--
-- TOC entry 239 (class 1259 OID 25587)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    role_name character varying(50) NOT NULL
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- TOC entry 238 (class 1259 OID 25586)
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.roles_id_seq OWNER TO postgres;

--
-- TOC entry 4944 (class 0 OID 0)
-- Dependencies: 238
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;


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
    name character varying(50) NOT NULL
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
-- TOC entry 4947 (class 0 OID 0)
-- Dependencies: 231
-- Name: teams_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: adminfire
--

ALTER SEQUENCE public.teams_id_seq OWNED BY public.teams.id;


--
-- TOC entry 237 (class 1259 OID 25550)
-- Name: teams_of_fire_stations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.teams_of_fire_stations (
    id bigint NOT NULL,
    fire_station_id bigint NOT NULL,
    team_id bigint NOT NULL,
    status_id bigint NOT NULL
);


ALTER TABLE public.teams_of_fire_stations OWNER TO postgres;

--
-- TOC entry 234 (class 1259 OID 25547)
-- Name: teams_of_fire_stations_fire_station_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.teams_of_fire_stations_fire_station_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.teams_of_fire_stations_fire_station_id_seq OWNER TO postgres;

--
-- TOC entry 4949 (class 0 OID 0)
-- Dependencies: 234
-- Name: teams_of_fire_stations_fire_station_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.teams_of_fire_stations_fire_station_id_seq OWNED BY public.teams_of_fire_stations.fire_station_id;


--
-- TOC entry 233 (class 1259 OID 25546)
-- Name: teams_of_fire_stations_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.teams_of_fire_stations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.teams_of_fire_stations_id_seq OWNER TO postgres;

--
-- TOC entry 4950 (class 0 OID 0)
-- Dependencies: 233
-- Name: teams_of_fire_stations_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.teams_of_fire_stations_id_seq OWNED BY public.teams_of_fire_stations.id;


--
-- TOC entry 236 (class 1259 OID 25549)
-- Name: teams_of_fire_stations_status_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.teams_of_fire_stations_status_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.teams_of_fire_stations_status_id_seq OWNER TO postgres;

--
-- TOC entry 4951 (class 0 OID 0)
-- Dependencies: 236
-- Name: teams_of_fire_stations_status_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.teams_of_fire_stations_status_id_seq OWNED BY public.teams_of_fire_stations.status_id;


--
-- TOC entry 235 (class 1259 OID 25548)
-- Name: teams_of_fire_stations_team_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.teams_of_fire_stations_team_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.teams_of_fire_stations_team_id_seq OWNER TO postgres;

--
-- TOC entry 4952 (class 0 OID 0)
-- Dependencies: 235
-- Name: teams_of_fire_stations_team_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.teams_of_fire_stations_team_id_seq OWNED BY public.teams_of_fire_stations.team_id;


--
-- TOC entry 245 (class 1259 OID 25666)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    username character varying(100) NOT NULL,
    password character varying(255) NOT NULL,
    role_id bigint NOT NULL,
    permission_id bigint NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 242 (class 1259 OID 25663)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 4954 (class 0 OID 0)
-- Dependencies: 242
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 244 (class 1259 OID 25665)
-- Name: users_permission_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_permission_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_permission_id_seq OWNER TO postgres;

--
-- TOC entry 4956 (class 0 OID 0)
-- Dependencies: 244
-- Name: users_permission_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_permission_id_seq OWNED BY public.users.permission_id;


--
-- TOC entry 243 (class 1259 OID 25664)
-- Name: users_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.users_role_id_seq OWNER TO postgres;

--
-- TOC entry 4957 (class 0 OID 0)
-- Dependencies: 243
-- Name: users_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_role_id_seq OWNED BY public.users.role_id;


--
-- TOC entry 4693 (class 2604 OID 25473)
-- Name: cars id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.cars ALTER COLUMN id SET DEFAULT nextval('public.cars_id_seq'::regclass);


--
-- TOC entry 4694 (class 2604 OID 25474)
-- Name: cars fire_station_id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.cars ALTER COLUMN fire_station_id SET DEFAULT nextval('public.cars_fire_station_id_seq'::regclass);


--
-- TOC entry 4695 (class 2604 OID 25475)
-- Name: fire_stations id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.fire_stations ALTER COLUMN id SET DEFAULT nextval('public.fire_stations_id_seq'::regclass);


--
-- TOC entry 4696 (class 2604 OID 25476)
-- Name: firefighters id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN id SET DEFAULT nextval('public.firefighters_id_seq'::regclass);


--
-- TOC entry 4697 (class 2604 OID 25477)
-- Name: firefighters position_id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN position_id SET DEFAULT nextval('public.firefighters_position_id_seq'::regclass);


--
-- TOC entry 4698 (class 2604 OID 25478)
-- Name: firefighters fire_station_id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN fire_station_id SET DEFAULT nextval('public.firefighters_fire_station_id_seq'::regclass);


--
-- TOC entry 4699 (class 2604 OID 25479)
-- Name: firefighters team_id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN team_id SET DEFAULT nextval('public.firefighters_team_id_seq'::regclass);


--
-- TOC entry 4700 (class 2604 OID 25480)
-- Name: firefighters rank_id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters ALTER COLUMN rank_id SET DEFAULT nextval('public.firefighters_rank_id_seq'::regclass);


--
-- TOC entry 4709 (class 2604 OID 25658)
-- Name: permissions id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permissions ALTER COLUMN id SET DEFAULT nextval('public.permissions_id_seq'::regclass);


--
-- TOC entry 4701 (class 2604 OID 25481)
-- Name: positions id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.positions ALTER COLUMN id SET DEFAULT nextval('public.positions_id_seq'::regclass);


--
-- TOC entry 4702 (class 2604 OID 25482)
-- Name: ranks id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.ranks ALTER COLUMN id SET DEFAULT nextval('public.ranks_id_seq'::regclass);


--
-- TOC entry 4708 (class 2604 OID 25590)
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


--
-- TOC entry 4703 (class 2604 OID 25483)
-- Name: teams id; Type: DEFAULT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.teams ALTER COLUMN id SET DEFAULT nextval('public.teams_id_seq'::regclass);


--
-- TOC entry 4704 (class 2604 OID 25553)
-- Name: teams_of_fire_stations id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teams_of_fire_stations ALTER COLUMN id SET DEFAULT nextval('public.teams_of_fire_stations_id_seq'::regclass);


--
-- TOC entry 4705 (class 2604 OID 25554)
-- Name: teams_of_fire_stations fire_station_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teams_of_fire_stations ALTER COLUMN fire_station_id SET DEFAULT nextval('public.teams_of_fire_stations_fire_station_id_seq'::regclass);


--
-- TOC entry 4706 (class 2604 OID 25555)
-- Name: teams_of_fire_stations team_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teams_of_fire_stations ALTER COLUMN team_id SET DEFAULT nextval('public.teams_of_fire_stations_team_id_seq'::regclass);


--
-- TOC entry 4707 (class 2604 OID 25556)
-- Name: teams_of_fire_stations status_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teams_of_fire_stations ALTER COLUMN status_id SET DEFAULT nextval('public.teams_of_fire_stations_status_id_seq'::regclass);


--
-- TOC entry 4710 (class 2604 OID 25669)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 4711 (class 2604 OID 25670)
-- Name: users role_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN role_id SET DEFAULT nextval('public.users_role_id_seq'::regclass);


--
-- TOC entry 4712 (class 2604 OID 25671)
-- Name: users permission_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN permission_id SET DEFAULT nextval('public.users_permission_id_seq'::regclass);


--
-- TOC entry 4892 (class 0 OID 25440)
-- Dependencies: 215
-- Data for Name: cars; Type: TABLE DATA; Schema: public; Owner: adminfire
--

INSERT INTO public.cars VALUES (2, 'АЦ 3.2 40', 'Х010МТ60', 3, 1);
INSERT INTO public.cars VALUES (7, 'АЦ 5.0 40', 'М178АА51', 1, 2);
INSERT INTO public.cars VALUES (6, 'АЦ 3.2 2/40', 'П222МТ60', 1, 1);
INSERT INTO public.cars VALUES (9, 'АЛ-30', 'М162РН060', 1, 3);


--
-- TOC entry 4895 (class 0 OID 25445)
-- Dependencies: 218
-- Data for Name: fire_stations; Type: TABLE DATA; Schema: public; Owner: adminfire
--

INSERT INTO public.fire_stations VALUES (1, 1, '1 пожарно-спасательная часть', 'П 01', 'ул. Коммунальная, 62');
INSERT INTO public.fire_stations VALUES (2, 11, 'Отдельный пост 1 пожарно-спасательной части', 'П 011', 'Максима Горького, 16');
INSERT INTO public.fire_stations VALUES (3, 2, '2 пожарно-спасательная часть', 'П 02', 'Вокзальная, 12а');
INSERT INTO public.fire_stations VALUES (4, 3, '3 пожарно-спасательная часть', 'П 03', 'Инженерная, 5');
INSERT INTO public.fire_stations VALUES (5, 31, 'Отдельный пост 3 пожарно-спасательной части', 'П 031', 'Инженерная, 92');


--
-- TOC entry 4897 (class 0 OID 25451)
-- Dependencies: 220
-- Data for Name: firefighters; Type: TABLE DATA; Schema: public; Owner: adminfire
--

INSERT INTO public.firefighters VALUES (15, 'Сергей', 'Васильевич', 'Иванов', 'С. В. Иванов', 12, 3, NULL, 1);
INSERT INTO public.firefighters VALUES (16, 'Сергей', 'Константинович', 'Андреев', 'С. К. Андреев', 12, 3, NULL, 1);
INSERT INTO public.firefighters VALUES (17, 'Андрей', 'Семенович', 'Васильев', 'А. С. Васильев', 12, 3, NULL, 1);
INSERT INTO public.firefighters VALUES (18, 'Сергей', 'Сергеевич', 'Андреев', 'С. С. Андреев', 12, 3, NULL, 1);
INSERT INTO public.firefighters VALUES (20, 'Валентин', 'Анатольевич', 'Михайлов', 'В. А. Михайлов', 13, 3, 1, 4);
INSERT INTO public.firefighters VALUES (11, 'Сергей', 'Анатольевич', 'Иванов', 'С. А. Иванов', 13, 1, 2, 4);
INSERT INTO public.firefighters VALUES (21, 'Валентин', 'Сергеевич', 'Михайлов', 'В. С. Михайлов', 14, 1, 1, 1);
INSERT INTO public.firefighters VALUES (19, 'Петр', 'Михайлович', 'Валентинов', 'П. М. Валентинов', 12, 1, 3, 4);


--
-- TOC entry 4918 (class 0 OID 25655)
-- Dependencies: 241
-- Data for Name: permissions; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.permissions VALUES (2, 'DISPATCHER');
INSERT INTO public.permissions VALUES (3, 'FIRESTATION_1');
INSERT INTO public.permissions VALUES (1, 'ADMIN');
INSERT INTO public.permissions VALUES (4, 'COMANDER_1');
INSERT INTO public.permissions VALUES (5, 'SQUARE_S1_T1');
INSERT INTO public.permissions VALUES (6, 'SQUARE_S1_T2');
INSERT INTO public.permissions VALUES (7, 'SQUARE_S1_T3');


--
-- TOC entry 4903 (class 0 OID 25461)
-- Dependencies: 226
-- Data for Name: positions; Type: TABLE DATA; Schema: public; Owner: adminfire
--

INSERT INTO public.positions VALUES (12, 'Пожарный');
INSERT INTO public.positions VALUES (13, 'Старший пожарный');
INSERT INTO public.positions VALUES (14, 'Начальник караула');


--
-- TOC entry 4905 (class 0 OID 25465)
-- Dependencies: 228
-- Data for Name: ranks; Type: TABLE DATA; Schema: public; Owner: adminfire
--

INSERT INTO public.ranks VALUES (1, 'Вольнонаемный');
INSERT INTO public.ranks VALUES (4, 'Мл. Сержант');


--
-- TOC entry 4916 (class 0 OID 25587)
-- Dependencies: 239
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.roles VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.roles VALUES (2, 'ROLE_DISPATCHER');
INSERT INTO public.roles VALUES (3, 'ROLE_COMANDER');
INSERT INTO public.roles VALUES (4, 'ROLE_CAR');
INSERT INTO public.roles VALUES (5, 'ROLE_FIRESTATION');


--
-- TOC entry 4909 (class 0 OID 25511)
-- Dependencies: 232
-- Data for Name: status; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.status VALUES (1, 'calm', 'в части');
INSERT INTO public.status VALUES (2, 'on_the_way', 'в пути');
INSERT INTO public.status VALUES (3, 'on_the_destination', 'на месте вызова');


--
-- TOC entry 4907 (class 0 OID 25469)
-- Dependencies: 230
-- Data for Name: teams; Type: TABLE DATA; Schema: public; Owner: adminfire
--

INSERT INTO public.teams VALUES (3, '3 ход');
INSERT INTO public.teams VALUES (2, '2 ход');
INSERT INTO public.teams VALUES (1, '1 ход');


--
-- TOC entry 4914 (class 0 OID 25550)
-- Dependencies: 237
-- Data for Name: teams_of_fire_stations; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.teams_of_fire_stations VALUES (4, 3, 1, 2);
INSERT INTO public.teams_of_fire_stations VALUES (3, 1, 3, 3);
INSERT INTO public.teams_of_fire_stations VALUES (1, 1, 1, 1);
INSERT INTO public.teams_of_fire_stations VALUES (2, 1, 2, 2);


--
-- TOC entry 4922 (class 0 OID 25666)
-- Dependencies: 245
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users VALUES (2, 'admin', '$2a$10$DPDY/6dHf1jR9H/TlO0hMu5EUYLv2VPu1PmEX/SatCQtzUKLQdiZi', 1, 1);
INSERT INTO public.users VALUES (3, 'FireStation_1', '$2a$10$sgP9RnZnxNDTEZB/gHaDnuOtM4OLwy4jEyZ7uCJHp/jEzGEWLXPp.', 5, 3);


--
-- TOC entry 4958 (class 0 OID 0)
-- Dependencies: 216
-- Name: cars_fire_station_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.cars_fire_station_id_seq', 1, false);


--
-- TOC entry 4959 (class 0 OID 0)
-- Dependencies: 217
-- Name: cars_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.cars_id_seq', 9, true);


--
-- TOC entry 4960 (class 0 OID 0)
-- Dependencies: 219
-- Name: fire_stations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.fire_stations_id_seq', 6, true);


--
-- TOC entry 4961 (class 0 OID 0)
-- Dependencies: 221
-- Name: firefighters_fire_station_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.firefighters_fire_station_id_seq', 1, true);


--
-- TOC entry 4962 (class 0 OID 0)
-- Dependencies: 222
-- Name: firefighters_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.firefighters_id_seq', 22, true);


--
-- TOC entry 4963 (class 0 OID 0)
-- Dependencies: 223
-- Name: firefighters_position_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.firefighters_position_id_seq', 1, true);


--
-- TOC entry 4964 (class 0 OID 0)
-- Dependencies: 224
-- Name: firefighters_rank_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.firefighters_rank_id_seq', 7, true);


--
-- TOC entry 4965 (class 0 OID 0)
-- Dependencies: 225
-- Name: firefighters_team_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.firefighters_team_id_seq', 6, true);


--
-- TOC entry 4966 (class 0 OID 0)
-- Dependencies: 240
-- Name: permissions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.permissions_id_seq', 7, true);


--
-- TOC entry 4967 (class 0 OID 0)
-- Dependencies: 227
-- Name: positions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.positions_id_seq', 14, true);


--
-- TOC entry 4968 (class 0 OID 0)
-- Dependencies: 229
-- Name: ranks_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.ranks_id_seq', 4, true);


--
-- TOC entry 4969 (class 0 OID 0)
-- Dependencies: 238
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_id_seq', 5, true);


--
-- TOC entry 4970 (class 0 OID 0)
-- Dependencies: 231
-- Name: teams_id_seq; Type: SEQUENCE SET; Schema: public; Owner: adminfire
--

SELECT pg_catalog.setval('public.teams_id_seq', 3, true);


--
-- TOC entry 4971 (class 0 OID 0)
-- Dependencies: 234
-- Name: teams_of_fire_stations_fire_station_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.teams_of_fire_stations_fire_station_id_seq', 1, false);


--
-- TOC entry 4972 (class 0 OID 0)
-- Dependencies: 233
-- Name: teams_of_fire_stations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.teams_of_fire_stations_id_seq', 1, false);


--
-- TOC entry 4973 (class 0 OID 0)
-- Dependencies: 236
-- Name: teams_of_fire_stations_status_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.teams_of_fire_stations_status_id_seq', 1, false);


--
-- TOC entry 4974 (class 0 OID 0)
-- Dependencies: 235
-- Name: teams_of_fire_stations_team_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.teams_of_fire_stations_team_id_seq', 1, false);


--
-- TOC entry 4975 (class 0 OID 0)
-- Dependencies: 242
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 3, true);


--
-- TOC entry 4976 (class 0 OID 0)
-- Dependencies: 244
-- Name: users_permission_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_permission_id_seq', 1, false);


--
-- TOC entry 4977 (class 0 OID 0)
-- Dependencies: 243
-- Name: users_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_role_id_seq', 1, false);


--
-- TOC entry 4714 (class 2606 OID 25485)
-- Name: cars cars_pkey; Type: CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.cars
    ADD CONSTRAINT cars_pkey PRIMARY KEY (id);


--
-- TOC entry 4716 (class 2606 OID 25487)
-- Name: fire_stations fire_stations_pkey; Type: CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.fire_stations
    ADD CONSTRAINT fire_stations_pkey PRIMARY KEY (id);


--
-- TOC entry 4718 (class 2606 OID 25489)
-- Name: firefighters firefighters_pkey; Type: CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters
    ADD CONSTRAINT firefighters_pkey PRIMARY KEY (id);


--
-- TOC entry 4734 (class 2606 OID 25662)
-- Name: permissions permissions_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permissions
    ADD CONSTRAINT permissions_name_key UNIQUE (name);


--
-- TOC entry 4736 (class 2606 OID 25660)
-- Name: permissions permissions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permissions
    ADD CONSTRAINT permissions_pkey PRIMARY KEY (id);


--
-- TOC entry 4720 (class 2606 OID 25491)
-- Name: positions positions_pkey; Type: CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.positions
    ADD CONSTRAINT positions_pkey PRIMARY KEY (id);


--
-- TOC entry 4722 (class 2606 OID 25493)
-- Name: ranks ranks_pkey; Type: CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.ranks
    ADD CONSTRAINT ranks_pkey PRIMARY KEY (id);


--
-- TOC entry 4730 (class 2606 OID 25592)
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- TOC entry 4732 (class 2606 OID 25594)
-- Name: roles roles_role_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_role_name_key UNIQUE (role_name);


--
-- TOC entry 4726 (class 2606 OID 25515)
-- Name: status status_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.status
    ADD CONSTRAINT status_pkey PRIMARY KEY (id);


--
-- TOC entry 4728 (class 2606 OID 25558)
-- Name: teams_of_fire_stations teams_of_fire_stations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teams_of_fire_stations
    ADD CONSTRAINT teams_of_fire_stations_pkey PRIMARY KEY (id);


--
-- TOC entry 4724 (class 2606 OID 25495)
-- Name: teams teams_pkey; Type: CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.teams
    ADD CONSTRAINT teams_pkey PRIMARY KEY (id);


--
-- TOC entry 4738 (class 2606 OID 25673)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 4740 (class 2606 OID 25675)
-- Name: users users_username_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_username_key UNIQUE (username);


--
-- TOC entry 4741 (class 2606 OID 25496)
-- Name: cars cars_fire_station_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.cars
    ADD CONSTRAINT cars_fire_station_id_fkey FOREIGN KEY (fire_station_id) REFERENCES public.fire_stations(id);


--
-- TOC entry 4742 (class 2606 OID 25501)
-- Name: cars cars_team_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.cars
    ADD CONSTRAINT cars_team_id_fkey FOREIGN KEY (team_id) REFERENCES public.teams(id);


--
-- TOC entry 4743 (class 2606 OID 25506)
-- Name: firefighters firefighters_rank_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: adminfire
--

ALTER TABLE ONLY public.firefighters
    ADD CONSTRAINT firefighters_rank_id_fkey FOREIGN KEY (rank_id) REFERENCES public.ranks(id);


--
-- TOC entry 4744 (class 2606 OID 25559)
-- Name: teams_of_fire_stations teams_of_fire_stations_fire_station_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teams_of_fire_stations
    ADD CONSTRAINT teams_of_fire_stations_fire_station_id_fkey FOREIGN KEY (fire_station_id) REFERENCES public.fire_stations(id);


--
-- TOC entry 4745 (class 2606 OID 25569)
-- Name: teams_of_fire_stations teams_of_fire_stations_status_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teams_of_fire_stations
    ADD CONSTRAINT teams_of_fire_stations_status_id_fkey FOREIGN KEY (status_id) REFERENCES public.status(id);


--
-- TOC entry 4746 (class 2606 OID 25564)
-- Name: teams_of_fire_stations teams_of_fire_stations_team_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.teams_of_fire_stations
    ADD CONSTRAINT teams_of_fire_stations_team_id_fkey FOREIGN KEY (team_id) REFERENCES public.teams(id);


--
-- TOC entry 4747 (class 2606 OID 25681)
-- Name: users users_permission_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_permission_id_fkey FOREIGN KEY (permission_id) REFERENCES public.permissions(id);


--
-- TOC entry 4748 (class 2606 OID 25676)
-- Name: users users_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_role_id_fkey FOREIGN KEY (role_id) REFERENCES public.roles(id);


--
-- TOC entry 4929 (class 0 OID 0)
-- Dependencies: 4928
-- Name: DATABASE mainfiredb; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON DATABASE mainfiredb TO adminfire;


--
-- TOC entry 4938 (class 0 OID 0)
-- Dependencies: 241
-- Name: TABLE permissions; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.permissions TO adminfire;


--
-- TOC entry 4940 (class 0 OID 0)
-- Dependencies: 240
-- Name: SEQUENCE permissions_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.permissions_id_seq TO adminfire;


--
-- TOC entry 4943 (class 0 OID 0)
-- Dependencies: 239
-- Name: TABLE roles; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.roles TO adminfire;


--
-- TOC entry 4945 (class 0 OID 0)
-- Dependencies: 238
-- Name: SEQUENCE roles_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.roles_id_seq TO adminfire;


--
-- TOC entry 4946 (class 0 OID 0)
-- Dependencies: 232
-- Name: TABLE status; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.status TO adminfire;


--
-- TOC entry 4948 (class 0 OID 0)
-- Dependencies: 237
-- Name: TABLE teams_of_fire_stations; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public.teams_of_fire_stations TO adminfire;


--
-- TOC entry 4953 (class 0 OID 0)
-- Dependencies: 245
-- Name: TABLE users; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.users TO adminfire;


--
-- TOC entry 4955 (class 0 OID 0)
-- Dependencies: 242
-- Name: SEQUENCE users_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.users_id_seq TO adminfire;


-- Completed on 2025-02-11 18:08:29

--
-- PostgreSQL database dump complete
--

