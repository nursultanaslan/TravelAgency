--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

-- Started on 2022-04-14 14:04:55

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
-- TOC entry 215 (class 1259 OID 16591)
-- Name: ilceler; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.ilceler (
    ilce_id smallint NOT NULL,
    ilce_adi character varying,
    sehir_id smallint
);


ALTER TABLE public.ilceler OWNER TO root;

--
-- TOC entry 216 (class 1259 OID 16594)
-- Name: ilceler_ilce_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

ALTER TABLE public.ilceler ALTER COLUMN ilce_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.ilceler_ilce_id_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 221 (class 1259 OID 16618)
-- Name: odalar; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.odalar (
    oda_id integer NOT NULL,
    oda_adi character varying,
    oda_url character varying,
    oda_durum boolean,
    oda_tur smallint,
    otel_id integer
);


ALTER TABLE public.odalar OWNER TO root;

--
-- TOC entry 222 (class 1259 OID 16621)
-- Name: odalar_oda_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

ALTER TABLE public.odalar ALTER COLUMN oda_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.odalar_oda_id_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 223 (class 1259 OID 16627)
-- Name: otel_rezervasyon; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.otel_rezervasyon (
    rezervasyon_id integer NOT NULL,
    musteri_adi character varying,
    musteri_tel character varying,
    musteri_email character varying,
    tarih date,
    otel_id integer
);


ALTER TABLE public.otel_rezervasyon OWNER TO root;

--
-- TOC entry 224 (class 1259 OID 16630)
-- Name: otel_rezervasyon_rezervasyon_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

ALTER TABLE public.otel_rezervasyon ALTER COLUMN rezervasyon_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.otel_rezervasyon_rezervasyon_id_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 219 (class 1259 OID 16609)
-- Name: oteller; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.oteller (
    otel_id integer NOT NULL,
    otel_adi character varying,
    otel_url character varying,
    ilce_id smallint,
    otel_detay character varying
);


ALTER TABLE public.oteller OWNER TO root;

--
-- TOC entry 220 (class 1259 OID 16612)
-- Name: oteller_otel_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

ALTER TABLE public.oteller ALTER COLUMN otel_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.oteller_otel_id_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 213 (class 1259 OID 16585)
-- Name: sehirler; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.sehirler (
    sehir_id smallint NOT NULL,
    sehir_adi character varying
);


ALTER TABLE public.sehirler OWNER TO root;

--
-- TOC entry 214 (class 1259 OID 16588)
-- Name: sehirler_sehir_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

ALTER TABLE public.sehirler ALTER COLUMN sehir_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.sehirler_sehir_id_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 211 (class 1259 OID 16576)
-- Name: sezonlar; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.sezonlar (
    sezon_id smallint NOT NULL,
    sezon_adi character varying,
    sezon_baslangic date,
    sezon_bitis date
);


ALTER TABLE public.sezonlar OWNER TO root;

--
-- TOC entry 212 (class 1259 OID 16579)
-- Name: sezonlar_sezon_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

ALTER TABLE public.sezonlar ALTER COLUMN sezon_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.sezonlar_sezon_id_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 217 (class 1259 OID 16600)
-- Name: tur_rezervasyon; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.tur_rezervasyon (
    rezervasyon_id integer NOT NULL,
    musteri_adi character varying,
    musteri_tel character varying,
    tarih date,
    musteri_email character varying,
    tur_id integer,
    kisi_sayisi smallint
);


ALTER TABLE public.tur_rezervasyon OWNER TO root;

--
-- TOC entry 218 (class 1259 OID 16603)
-- Name: tur_rezervasyon_rezervasyon_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

ALTER TABLE public.tur_rezervasyon ALTER COLUMN rezervasyon_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.tur_rezervasyon_rezervasyon_id_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 209 (class 1259 OID 16567)
-- Name: turlar; Type: TABLE; Schema: public; Owner: root
--

CREATE TABLE public.turlar (
    tur_id integer NOT NULL,
    tur_adi character varying,
    tur_detayi character varying,
    tur_ucreti character varying,
    tur_ulasim character varying,
    tur_url character varying,
    ilce_id smallint,
    sezon_id smallint
);


ALTER TABLE public.turlar OWNER TO root;

--
-- TOC entry 210 (class 1259 OID 16570)
-- Name: turlar_id_seq; Type: SEQUENCE; Schema: public; Owner: root
--

ALTER TABLE public.turlar ALTER COLUMN tur_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.turlar_id_seq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3367 (class 0 OID 16591)
-- Dependencies: 215
-- Data for Name: ilceler; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 3373 (class 0 OID 16618)
-- Dependencies: 221
-- Data for Name: odalar; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 3375 (class 0 OID 16627)
-- Dependencies: 223
-- Data for Name: otel_rezervasyon; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 3371 (class 0 OID 16609)
-- Dependencies: 219
-- Data for Name: oteller; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 3365 (class 0 OID 16585)
-- Dependencies: 213
-- Data for Name: sehirler; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 3363 (class 0 OID 16576)
-- Dependencies: 211
-- Data for Name: sezonlar; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 3369 (class 0 OID 16600)
-- Dependencies: 217
-- Data for Name: tur_rezervasyon; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 3361 (class 0 OID 16567)
-- Dependencies: 209
-- Data for Name: turlar; Type: TABLE DATA; Schema: public; Owner: root
--



--
-- TOC entry 3382 (class 0 OID 0)
-- Dependencies: 216
-- Name: ilceler_ilce_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.ilceler_ilce_id_seq', 0, false);


--
-- TOC entry 3383 (class 0 OID 0)
-- Dependencies: 222
-- Name: odalar_oda_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.odalar_oda_id_seq', 0, false);


--
-- TOC entry 3384 (class 0 OID 0)
-- Dependencies: 224
-- Name: otel_rezervasyon_rezervasyon_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.otel_rezervasyon_rezervasyon_id_seq', 0, false);


--
-- TOC entry 3385 (class 0 OID 0)
-- Dependencies: 220
-- Name: oteller_otel_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.oteller_otel_id_seq', 0, false);


--
-- TOC entry 3386 (class 0 OID 0)
-- Dependencies: 214
-- Name: sehirler_sehir_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.sehirler_sehir_id_seq', 0, false);


--
-- TOC entry 3387 (class 0 OID 0)
-- Dependencies: 212
-- Name: sezonlar_sezon_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.sezonlar_sezon_id_seq', 0, false);


--
-- TOC entry 3388 (class 0 OID 0)
-- Dependencies: 218
-- Name: tur_rezervasyon_rezervasyon_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.tur_rezervasyon_rezervasyon_id_seq', 0, false);


--
-- TOC entry 3389 (class 0 OID 0)
-- Dependencies: 210
-- Name: turlar_id_seq; Type: SEQUENCE SET; Schema: public; Owner: root
--

SELECT pg_catalog.setval('public.turlar_id_seq', 0, false);


--
-- TOC entry 3206 (class 2606 OID 16638)
-- Name: ilceler ilceler_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.ilceler
    ADD CONSTRAINT ilceler_pkey PRIMARY KEY (ilce_id);


--
-- TOC entry 3212 (class 2606 OID 16640)
-- Name: odalar odalar_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.odalar
    ADD CONSTRAINT odalar_pkey PRIMARY KEY (oda_id);


--
-- TOC entry 3214 (class 2606 OID 16642)
-- Name: otel_rezervasyon otel_rezervasyon_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.otel_rezervasyon
    ADD CONSTRAINT otel_rezervasyon_pkey PRIMARY KEY (rezervasyon_id);


--
-- TOC entry 3210 (class 2606 OID 16644)
-- Name: oteller oteller_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.oteller
    ADD CONSTRAINT oteller_pkey PRIMARY KEY (otel_id);


--
-- TOC entry 3204 (class 2606 OID 16646)
-- Name: sehirler sehirler_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.sehirler
    ADD CONSTRAINT sehirler_pkey PRIMARY KEY (sehir_id);


--
-- TOC entry 3202 (class 2606 OID 16648)
-- Name: sezonlar sezonlar_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.sezonlar
    ADD CONSTRAINT sezonlar_pkey PRIMARY KEY (sezon_id);


--
-- TOC entry 3208 (class 2606 OID 16650)
-- Name: tur_rezervasyon tur_rezervasyon_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tur_rezervasyon
    ADD CONSTRAINT tur_rezervasyon_pkey PRIMARY KEY (rezervasyon_id);


--
-- TOC entry 3200 (class 2606 OID 16652)
-- Name: turlar turlar_pkey; Type: CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.turlar
    ADD CONSTRAINT turlar_pkey PRIMARY KEY (tur_id);


--
-- TOC entry 3217 (class 2606 OID 16653)
-- Name: ilceler ilceler_sehir_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.ilceler
    ADD CONSTRAINT ilceler_sehir_id_fkey FOREIGN KEY (sehir_id) REFERENCES public.sehirler(sehir_id) NOT VALID;


--
-- TOC entry 3220 (class 2606 OID 16658)
-- Name: odalar odalar_otel_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.odalar
    ADD CONSTRAINT odalar_otel_id_fkey FOREIGN KEY (otel_id) REFERENCES public.oteller(otel_id) NOT VALID;


--
-- TOC entry 3221 (class 2606 OID 16663)
-- Name: otel_rezervasyon otel_rezervasyon_otel_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.otel_rezervasyon
    ADD CONSTRAINT otel_rezervasyon_otel_id_fkey FOREIGN KEY (otel_id) REFERENCES public.oteller(otel_id) NOT VALID;


--
-- TOC entry 3219 (class 2606 OID 16668)
-- Name: oteller oteller_ilce_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.oteller
    ADD CONSTRAINT oteller_ilce_id_fkey FOREIGN KEY (ilce_id) REFERENCES public.ilceler(ilce_id) NOT VALID;


--
-- TOC entry 3218 (class 2606 OID 16673)
-- Name: tur_rezervasyon tur_rezervasyon_tur_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.tur_rezervasyon
    ADD CONSTRAINT tur_rezervasyon_tur_id_fkey FOREIGN KEY (tur_id) REFERENCES public.turlar(tur_id) NOT VALID;


--
-- TOC entry 3215 (class 2606 OID 16678)
-- Name: turlar turlar_ilce_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.turlar
    ADD CONSTRAINT turlar_ilce_id_fkey FOREIGN KEY (ilce_id) REFERENCES public.ilceler(ilce_id) NOT VALID;


--
-- TOC entry 3216 (class 2606 OID 16683)
-- Name: turlar turlar_sezon_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: root
--

ALTER TABLE ONLY public.turlar
    ADD CONSTRAINT turlar_sezon_id_fkey FOREIGN KEY (sezon_id) REFERENCES public.sezonlar(sezon_id) NOT VALID;


-- Completed on 2022-04-14 14:04:55

--
-- PostgreSQL database dump complete
--

