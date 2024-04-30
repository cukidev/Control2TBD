-- Insertar datos en la Tabla Usuario
INSERT INTO Users (username, password) VALUES
('user1', 'pass1'),
('user2', 'pass2'),
('user3', 'pass3'),
('user4', 'pass4'),
('user5', 'pass5'),
('user6', 'pass6'),
('user7', 'pass7'),
('user8', 'pass8'),
('user9', 'pass9'),
('user10', 'pass10');

-- Insertar datos en la Tabla Tareas
INSERT INTO Tasks (title, description, due_date, status, user_id) VALUES
('Task A', 'Esto es una tarea', '2024-05-01', 'pending', 1),
('Task B', 'Esto también es una tarea', '2024-06-01', 'completed', 2),
('Task C', 'Esto también es otra tarea', '2024-06-01', 'completed', 3),
('Task D', 'Esto también es otra tarea', '2024-06-01', 'pending', 4),
('Task E', 'Esto también es otra tarea', '2024-06-01', 'completed', 5),
('Task F', 'Esto también es otra tarea', '2024-06-01', 'pending', 6),
('Task G', 'Esto también es otra tarea', '2024-06-01', 'completed', 7),
('Task H', 'Esto también es otra tarea', '2024-06-01', 'pending', 8),
('Task I', 'Esto también es otra tarea', '2024-06-01', 'completed', 9),
('Task J', 'Esto también es otra tarea', '2024-06-01', 'pending', 2);



-- Insertar datos en la tabla Notificaciones
INSERT INTO notifications (user_id, task_id, message, notification_date) VALUES
(1, 1, 'Tienes una nueva tarea asignada.', '2024-12-01T08:00:00'),
(1, 2, 'Tu tarea ha sido completada.', '2024-12-02T09:00:00'),
(2, 3, 'Recuerda completar tu tarea.', '2024-12-03T10:00:00'),
(3, 4, 'Recuerda completar tu tarea.', '2024-12-03T10:00:00'),
(4, 5, 'Recuerda completar tu tarea.', '2024-12-03T10:00:00'),
(5, 6, 'Recuerda completar tu tarea.', '2024-12-03T10:00:00'),
(6, 7, 'Recuerda completar tu tarea.', '2024-12-03T10:00:00'),
(7, 8, 'Recuerda completar tu tarea.', '2024-12-03T10:00:00'),
(8, 9, 'Recuerda completar tu tarea.', '2024-12-03T10:00:00'),
(9, 10, 'Recuerda completar tu tarea.', '2024-12-03T10:00:00');
