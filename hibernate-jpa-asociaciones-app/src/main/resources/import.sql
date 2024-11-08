INSERT INTO clientes (id, nombre, apellido, forma_pago, creado_en, editado_en) VALUES (1,'Andres','Guzman','debito',NULL,NULL),(2,'Jhon','Doe','credito',NULL,NULL),(4,'Pepa','Martinez','debito',NULL,NULL),(5,'Luci','Martinez','credito',NULL,NULL),(6,'Luna','Garcia','debito',NULL,NULL),(9,'Jhon','Roe','paypal',NULL,NULL),(10,'Lou','Loe','paypal',NULL,NULL),(11,'Lalo','Mena','webpay',NULL,NULL),(12,'Pia','Perez','paypal plus',NULL,NULL);
INSERT InTO alumnos (id, nombre, apellido) VALUES(1, 'Johana','Doe');
INSERT InTO alumnos (id, nombre, apellido) VALUES(2, 'PePe','Gon');
INSERT INTO cursos (id, titulo, profesor) VALUES(1, 'Curso Spring', 'Andres');
INSERT INTO cursos (id, titulo, profesor) VALUES(2, 'Curso JavaEE 9', 'Andres');
Insert into direcciones(calle, numero) values ('vaticano',123);
Insert into direcciones(calle, numero) values ('colon',456);
Insert into tbl_clientes_direcciones (id_cliente, id_direccion) values (1,1);
Insert into tbl_clientes_direcciones (id_cliente, id_direccion) values (1,2);
Insert into clientes_detalles (prime, puntos_acumulados, cliente_detalle_id) values (1,8000,1);
Insert into tbl_alumnos_cursos (alumno_id, curso_id) values(1, 1);
Insert into tbl_alumnos_cursos (alumno_id, curso_id) values(1, 2);
Insert into facturas (descripcion, total, id_cliente) values ('oficina',4000,1);
Insert into facturas (descripcion, total, id_cliente) values ('casa',2000,1);
Insert into facturas (descripcion, total, id_cliente) values ('deporte',3000,1);
Insert into facturas (descripcion, total, id_cliente) values ('computacion',7000,2);

