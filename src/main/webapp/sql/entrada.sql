
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


--
-- Base de datos: `ausiasyield`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrada`
--

CREATE TABLE IF NOT EXISTS `entrada` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contenido` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_hilo` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Creada por José Grancha' AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `entrada`
--

INSERT INTO `entrada` (`id`, `titulo`, `contenido`, `id_usuario`, `id_hilo`, `fecha`) VALUES
(1, 'Modificacion clase Java(Pojo1.class)', 'Hay errores en la clase', 1, 1, '2013-11-03'),
(2, 'Creación clase mysql', 'Crear completamente la clase', 2, 2, '2013-10-10'),
(3, 'Clase DAO Entrada', 'Modificar método getPages()', 3, 3, '2013-11-28'),
(4, 'Optimizar Funcionamiento Programa', 'Realizar mejoras en el código', 4, 4, '2013-11-05'),
(5, 'Error entrada form login', 'Da una excepción al intentar entrar', 5, 5, '2013-09-19'),
(6, 'Problemas con listados', 'Un campo no aparece', 6, 6, '2013-11-23'),
(7, 'Borrado y edit NO funcionan en Empresa', 'Solucionar el problema', 7, 7, '2013-10-16'),
(8, 'Depuración código', 'Depurar código y hacer pruebas', 8, 8, '2013-09-23'),
(9, 'Listado Usuarios no está disponible', 'Arreglar', 9, 9, '2013-10-09'),
(10, 'Realizar mantenimiento clases DAO', 'Probar y optimizar', 10, 10, '2013-11-20');


