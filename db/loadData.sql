-- Insertar datos en la Tabla Usuario
INSERT INTO Users (username, password) VALUES
('user1', 'pass1'),
('user2', 'pass2'),
('user3', 'pass3');

-- Insertar datos en la Tabla Tareas
INSERT INTO Tasks (title, description, due_date, status, user_id) VALUES
('Task A', 'Esto es una tarea', '2024-05-01', 'pending', 1),
('Task B', 'Esto también es una tarea', '2024-06-01', 'completed', 2),
('Task C', 'Esto también es otra tarea', '2024-06-01', 'completed', 3);
