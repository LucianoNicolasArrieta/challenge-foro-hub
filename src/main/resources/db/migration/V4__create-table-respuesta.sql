CREATE TABLE respuesta (
    id bigint not null auto_increment,
    mensaje text not null,
    topico_id bigint not null,
    fecha_creacion datetime not null,
    autor_id bigint not null,
    solucion tinyint not null,

    primary key(id),
    constraint fk_respuesta_topico_id foreign key(topico_id) references topico(id),
    constraint fk_respuesta_autor_id foreign key(autor_id) references usuario(id)
);