DELETE FROM [3K3_G13_TPT].dbo.vino

DBCC CHECKIDENT ('[3K3_G13_TPT].dbo.vino', RESEED, 0);


INSERT INTO [3K3_G13_TPT].[dbo].[vino]
    (nombre, añada, imagen_etiqueta, nota_de_cata_bodega, precio_ars, bodega_id, maridaje_id, varietal_id)
VALUES 
    ('Vino Tinto Noble', 2018, 'imagenNueva11', 'Intensos aromas a grosella negra y ciruela, con notas de pimienta negra y roble tostado. Final largo y elegante.', 35059, 1, 1, 6),
    ('Vino Espumante Estrella', 2019, 'imagenNueva4', 'Refrescante con aromas de manzana verde y cítricos, toques de vainilla y una textura cremosa. Equilibrado y suave.', 32560, 1, 3, 8),
    ('Vino Tinto Ocaso', 2020, 'imagenNueva13', 'Suave con toques de ciruela y vainilla.', 30000, 2, 1, 9),
    ('Vino Blanco del Sol', 2018, 'imagenNueva2', 'Aromas cítricos y florales.', 28000, 2, 2, 10),
    ('Vino Blanco Elegancia', 2016, 'imagenNueva16', 'Aromas de flores blancas y miel.', 31000, 3, 6, 11),
    ('Vino Blanco Ámbar', 2017, 'imagenNueva6', 'Aromas de durazno y miel.', 27000, 3, 3, 12),
    ('Vino Tinto Roble Viejo', 2014, 'imagenNuevaVinoCreado', 'Notas de vainilla y especias.', 34000, 1, 1, 21),
    ('Vino Tinto Tradicional', 2017, 'imagenNueva10', 'Frutos rojos y especias.', 33000, 1, 2, 22),
    ('Vino Rubio del Sol', 2018, 'imagenNueva2', 'Aromas cítricos y florales.', 28000, 3, 2, 25),
    ('Vino Tinto Reserva', 2015, 'imagenNueva5', 'Cuerpo completo con notas de cereza y roble.', 32000, 3, 2, 26),
    ('Vino Rosado del Valle', 2021, 'imagenNueva8', 'Fresco con toques de cítricos.', 26000, 3, 2, 27),
    ('Vino Tinto Gran Enemigo', 2016, 'imagenNueva12', 'Intensos aromas a grosella negra y ciruela, con notas de pimienta negra y roble tostado. Final largo y elegante.', 42210, 1, 1, 28);
    
UPDATE [3K3_G13_TPT].dbo.bodega
	SET ultima_actualizacion='2024-06-27 19:45:28.131'
	WHERE id=1;
UPDATE [3K3_G13_TPT].dbo.bodega
	SET ultima_actualizacion='2024-03-27 19:41:13.752'
	WHERE id=3;
