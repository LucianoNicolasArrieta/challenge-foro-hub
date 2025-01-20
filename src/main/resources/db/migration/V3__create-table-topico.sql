CREATE TABLE topico (
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje text not null,
    fecha_creacion datetime not null,
    status varchar(10) not null,
    autor_id bigint not null,
    curso_id bigint not null,

    primary key(id),
    constraint fk_topico_autor_id foreign key(autor_id) references usuario(id),
    constraint fk_topico_curso_id foreign key(curso_id) references curso(id)
);