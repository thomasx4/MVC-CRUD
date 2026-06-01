CREATE DATABASE IF NOT EXISTS crud_productos;
USE crud_productos;

CREATE TABLE IF NOT EXISTS productos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL CHECK (precio >= 0),
    cantidad INT NOT NULL CHECK (cantidad >= 0),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO productos (nombre, precio, cantidad) VALUES
('Laptop HP', 899.99, 10),
('Mouse Logitech', 25.50, 50),
('Teclado Mecánico', 75.00, 30),
('Monitor Samsung 24"', 199.99, 15),
('Disco SSD 1TB', 120.00, 25);

SELECT * FROM productos;

