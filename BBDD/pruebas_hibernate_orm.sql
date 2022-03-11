-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 11-03-2022 a las 09:04:57
-- Versión del servidor: 5.7.36
-- Versión de PHP: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pruebas_hibernate_orm`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DETALLE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `nombre`, `apellido`, `direccion`) VALUES
(5, 'Paco', 'Gómez', 'Princesa'),
(7, 'Manuel', 'Ramirez', 'Princesa'),
(8, 'Manuel', 'Ramirez', 'Princesa'),
(9, 'Carmen', 'Gutierrez', 'Gran Vía');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles_cliente`
--

DROP TABLE IF EXISTS `detalles_cliente`;
CREATE TABLE IF NOT EXISTS `detalles_cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `web` varchar(128) DEFAULT NULL,
  `telf` varchar(128) DEFAULT NULL,
  `comentario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `detalles_cliente`
--

INSERT INTO `detalles_cliente` (`id`, `web`, `telf`, `comentario`) VALUES
(5, 'www.gomez.com', '633223344', 'Informática'),
(7, 'www.ramirez.com', '633234532', 'Bolsa'),
(8, 'www.ramirez.com', '633234532', 'Bolsa'),
(9, 'www.ramirez.com', '633234532', 'Bolsa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE IF NOT EXISTS `pedido` (
  `ID` int(3) NOT NULL AUTO_INCREMENT,
  `FECHA` date DEFAULT NULL,
  `FORMA_PAGO` varchar(15) DEFAULT NULL,
  `CLIENTE_ID` int(3) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CLIENTE_ID` (`CLIENTE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`ID`, `FECHA`, `FORMA_PAGO`, `CLIENTE_ID`) VALUES
(1, '2020-07-04', NULL, 7),
(2, '2020-06-03', NULL, 7),
(3, '2020-08-02', NULL, 7),
(4, '2022-07-04', NULL, 7),
(5, '2022-06-03', NULL, 7),
(6, '2022-08-02', NULL, 7),
(7, '2022-07-04', NULL, 8),
(8, '2022-06-03', NULL, 8),
(9, '2022-08-02', NULL, 8);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `FK_DETALLE` FOREIGN KEY (`id`) REFERENCES `detalles_cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `CLIENTE_ID` FOREIGN KEY (`CLIENTE_ID`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
