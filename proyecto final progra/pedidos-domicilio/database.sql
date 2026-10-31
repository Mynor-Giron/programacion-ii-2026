
CREATE TABLE zona_entrega (
                              id SERIAL PRIMARY KEY,
                              nombre VARCHAR(100) NOT NULL,
                              costo DECIMAL(10,2) NOT NULL CHECK (costo >= 0)
);

CREATE TABLE pedido (
                        id SERIAL PRIMARY KEY,
                        cliente VARCHAR(100) NOT NULL,
                        direccion VARCHAR(200) NOT NULL,
                        fecha_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        total_pedido DECIMAL(10,2) NOT NULL CHECK (total_pedido >= 0),
                        costo_envio DECIMAL(10,2) NOT NULL CHECK (costo_envio >= 0),
                        total_final DECIMAL(10,2) NOT NULL,
                        estado VARCHAR(20) DEFAULT 'RECIBIDO',
                        zona_entrega_id INT NOT NULL,
                        CONSTRAINT fk_zona FOREIGN KEY (zona_entrega_id) REFERENCES zona_entrega(id)
);

INSERT INTO zona_entrega (nombre, costo) VALUES
                                             ('Zona Norte', 15.00),
                                             ('Zona Sur', 25.00),
                                             ('Zona Centro', 10.00);


INSERT INTO pedido (cliente, direccion, total_pedido, costo_envio, total_final, estado, zona_entrega_id) VALUES
                                                                                                             ('Luis Torres', 'Calle 1 #10-20', 50.00, 15.00, 65.00, 'RECIBIDO', 1),
                                                                                                             ('Sofia Martinez', 'Av. Principal #5-40', 30.00, 25.00, 55.00, 'EN_RUTA', 2),
                                                                                                             ('Pedro Ramirez', 'Calle 3 #12-15', 80.00, 10.00, 90.00, 'ENTREGADO', 3);