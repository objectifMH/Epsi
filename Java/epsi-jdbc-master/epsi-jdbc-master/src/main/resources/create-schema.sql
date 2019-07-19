CREATE TABLE public.type_pokemon
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    label character varying(50) NOT NULL,
    CONSTRAINT type_pokemon_pkey PRIMARY KEY (id) 
);

CREATE TABLE public.dresseur
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    name_ character varying(50) NOT NULL,
    ville character varying(100) NOT NULL,
    CONSTRAINT dresseur_pkey PRIMARY KEY (id)
);

CREATE TABLE public.pokemon
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY,
    number_ integer NOT NULL,
    name_ character varying(50) NOT NULL,
    health_points integer NOT NULL,
    evolution bigint,
    CONSTRAINT pk_pokemon PRIMARY KEY (id),
    CONSTRAINT pokemon_evolution_fkey FOREIGN KEY (evolution)
        REFERENCES pokemon (id)
);

CREATE TABLE public.pokemon_est_de_type
(
    pokemon_id bigint NOT NULL,
    type_id bigint NOT NULL,
    CONSTRAINT pokemon_est_de_type_pkey PRIMARY KEY (pokemon_id, type_id),
    CONSTRAINT pokemon_est_de_type_pokemon_id_fkey FOREIGN KEY (pokemon_id)
        REFERENCES public.pokemon (id),
    CONSTRAINT pokemon_est_de_type_type_id_fkey FOREIGN KEY (type_id)
        REFERENCES public.type_pokemon (id)
);

CREATE TABLE public.pokemon_dresse
(
    pokemon_id bigint NOT NULL,
    dresseur_id bigint NOT NULL,
    nickname character varying(50),
    CONSTRAINT pokemon_dresse_pkey PRIMARY KEY (pokemon_id, dresseur_id),
    CONSTRAINT pokemon_dresse_pokemon_fkey FOREIGN KEY (pokemon_id)
        REFERENCES pokemon (id),
    CONSTRAINT pokemon_dresse_dresseur_fkey FOREIGN KEY (dresseur_id)
        REFERENCES dresseur (id)
);
