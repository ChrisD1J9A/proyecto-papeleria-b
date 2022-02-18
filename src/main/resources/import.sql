INSERT INTO unidad (descripcion, estatus) VALUES ('Caja', 1);
INSERT INTO unidad (descripcion, estatus) VALUES ('Paquete', 1);
INSERT INTO unidad (descripcion, estatus) VALUES ('Pieza', 1);
INSERT INTO unidad (descripcion, estatus) VALUES ('Caja 2', 1);
INSERT INTO unidad (descripcion, estatus) VALUES ('Caja 3', 0);


INSERT INTO productos (descripcion, precio_iva, precio_subtotal, precio_total, estatus, observaciones, id_unidad) VALUES('BOLIGRAFO BIC PUNTO MEDIANO AZUL CAJA C/12', 15.90, 15.99, 16.0,1, 'Producto de prueba', 1);
INSERT INTO productos (descripcion, precio_iva, precio_subtotal, precio_total, estatus, observaciones, id_unidad) VALUES('BOLIGRAFO BIC PUNTO MEDIANO NEGRO CAJA C/12', 29.90, 17.99, 18.0,1, 'Producto 2', 1);
INSERT INTO productos (descripcion, precio_iva, precio_subtotal, precio_total, estatus, observaciones, id_unidad) VALUES('ENGRAPADORA BOSTITCH B600 MEDIA TIRA NEGRO', 29.90, 17.99, 18.0,1, 'Producto 2', 3);
INSERT INTO productos (descripcion, precio_iva, precio_subtotal, precio_total, estatus, observaciones, id_unidad) VALUES('MARCATEXTO VISION AZOR COLOR AMARILLO C/2', 29.90, 17.99, 18.0,1, 'Producto 2', 2);
INSERT INTO productos (descripcion, precio_iva, precio_subtotal, precio_total, estatus, observaciones, id_unidad) VALUES('MARCADOR ESTERBROOK NEGRO BLISTER C/1 PIEZA BEROL', 29.90, 17.99, 18.0,1, 'Producto 2', 3);
INSERT INTO productos (descripcion, precio_iva, precio_subtotal, precio_total, estatus, observaciones, id_unidad) VALUES('MARCADOR PARA PIZARRON BLANCO BIC C/4 + BORRADOR', 29.90, 17.99, 18.0,1, 'Producto 2', 2);


INSERT INTO proveedores (nombre, direccion, telefono, rfc, estatus) VALUES ('Office Deapot', 'Plaza del valle', '9512598298', 'OFLAMSN', 1);
INSERT INTO proveedores (nombre, direccion, telefono, rfc, estatus) VALUES ('Proveedora escolar', 'Centro Oaxaca de Juarez', '9512398498', 'PERASHF123', 1);

INSERT INTO solicitudes (id_usuario_aprob, id_sucursal, nombre_usuario, fecha_solicitud, fecha_rechazo, fecha_aprobacion, fecha_abastecimiento, fecha_cancelacion, observacion_solicitud, observacion_aprobacion_rechazo, estatus) VALUES (1, 1, 'Diego', '2021-12-16', '2021-12-17', '2022-01-16', '2022-01-23', '2022-01-24', 'Se solicita los siguientes productos para poder cubrir las necesidades de la oficina', 'Para adquisiciones los productos solicitados suenan razonables y no hay problema, procedan con la adquisicion de productos', 'Aceptada');
INSERT INTO solicitudes (id_usuario_aprob, id_sucursal, nombre_usuario, fecha_solicitud, fecha_rechazo, fecha_aprobacion, fecha_abastecimiento, fecha_cancelacion, observacion_solicitud, observacion_aprobacion_rechazo, estatus) VALUES (1, 1, 'Diego', '2021-12-16', '2021-12-17', '2022-01-16', '2022-01-23', '2022-01-24', 'Se solicita los siguientes productos para poder cubrir las necesidades de la oficina', 'Muchos de los productos se consideran  innecesarios y otros exceden del presupuesto establecido para la sucursal', 'Rechazada');
INSERT INTO solicitudes (id_usuario_aprob, id_sucursal, nombre_usuario, fecha_solicitud, fecha_rechazo, fecha_aprobacion, fecha_abastecimiento, fecha_cancelacion, observacion_solicitud, observacion_aprobacion_rechazo, estatus) VALUES (1, 1, 'Diego', '2021-12-16', '2021-12-17', '2022-01-16', '2022-01-23', '2022-01-24', 'Se solicita los siguientes productos para poder cubrir las necesidades de la oficina', '...', 'Pendiente');

INSERT INTO detalle_solicitud (cant_existente, cant_solicitada, cant_autorizada, id_solicitud, id_producto) VALUES (12, 20, 10, 1, 1);
INSERT INTO detalle_solicitud (cant_existente, cant_solicitada, cant_autorizada, id_solicitud, id_producto) VALUES (12, 20, 10, 1, 2);
INSERT INTO detalle_solicitud (cant_existente, cant_solicitada, cant_autorizada, id_solicitud, id_producto) VALUES (12, 20, 10, 1, 3);
INSERT INTO detalle_solicitud (cant_existente, cant_solicitada, cant_autorizada, id_solicitud, id_producto) VALUES (12, 20, 10, 1, 4);
INSERT INTO detalle_solicitud (cant_existente, cant_solicitada, cant_autorizada, id_solicitud, id_producto) VALUES (12, 20, 10, 2, 1);
INSERT INTO detalle_solicitud (cant_existente, cant_solicitada, cant_autorizada, id_solicitud, id_producto) VALUES (12, 20, 10, 2, 2);	
INSERT INTO detalle_solicitud (cant_existente, cant_solicitada, cant_autorizada, id_solicitud, id_producto) VALUES (12, 20, 10, 2, 3);
INSERT INTO detalle_solicitud (cant_existente, cant_solicitada, cant_autorizada, id_solicitud, id_producto) VALUES (12, 20, 10, 2, 4);
INSERT INTO detalle_solicitud (cant_existente, cant_solicitada, cant_autorizada, id_solicitud, id_producto) VALUES (12, 20, 10, 3, 1);
INSERT INTO detalle_solicitud (cant_existente, cant_solicitada, cant_autorizada, id_solicitud, id_producto) VALUES (12, 20, 10, 3, 2);
INSERT INTO detalle_solicitud (cant_existente, cant_solicitada, cant_autorizada, id_solicitud, id_producto) VALUES (12, 20, 10, 3, 3);
INSERT INTO detalle_solicitud (cant_existente, cant_solicitada, cant_autorizada, id_solicitud, id_producto) VALUES (12, 20, 10, 3, 4);

INSERT INTO compras (usuario, fecha_creacion, gasto_total, ticket, observaciones, id_solicitud, id_proveedor, estatus) VALUES (1, '2022-02-16', 5000, 'C:', 'La compra se efectuo cuidadosamente', 1, 1, 'En proceso');
INSERT INTO detalle_compra (cant_existente, cant_solicitada, cant_autorizada, cant_comprada, precio_unitario, precio_total, id_compra, id_producto) VALUES (12, 20, 10, 10, 16.0, 16.0, 1 , 1);
INSERT INTO detalle_compra (cant_existente, cant_solicitada, cant_autorizada, cant_comprada, precio_unitario, precio_total, id_compra, id_producto) VALUES (12, 20, 10, 10, 18.0, 18.0, 1 , 2);
INSERT INTO detalle_compra (cant_existente, cant_solicitada, cant_autorizada, cant_comprada, precio_unitario, precio_total, id_compra, id_producto) VALUES (12, 20, 10, 10, 18.0, 18.0, 1 , 3);
INSERT INTO detalle_compra (cant_existente, cant_solicitada, cant_autorizada, cant_comprada, precio_unitario, precio_total, id_compra, id_producto) VALUES (12, 20, 10, 10, 18.0, 18.0, 1 , 4);



