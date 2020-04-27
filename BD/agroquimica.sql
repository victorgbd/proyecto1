-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 27, 2020 at 10:53 PM
-- Server version: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `agroquimica`
--
CREATE DATABASE IF NOT EXISTS `agroquimica` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `agroquimica`;

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `sp_actualizar_disponibilidad`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_disponibilidad` (IN `_disponible` INT, IN `_codemp` INT)  BEGIN
	#Routine body goes here...
	UPDATE empleado set disponibilidad = `_disponible` where codemp = `_codemp`;
END$$

DROP PROCEDURE IF EXISTS `sp_cobro_credito`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_cobro_credito` (`_numfact` INT, `_num_pago` INT, `_pago` DOUBLE)  BEGIN
Insert into recibo VALUES (_numfact,_num_pago,_pago,NOW());
UPDATE factura f SET f.balance = (balance - _pago) WHERE f.numfact = numfact;
END$$

DROP PROCEDURE IF EXISTS `sp_composicio_producto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_composicio_producto` (IN `_cod1` INT, IN `_cod2` INT, IN `_cantidad` INT, IN `_cod3` INT, IN `_cod_pro` INT, IN `cant_exi` INT)  BEGIN
	#Routine body goes here...
	INSERT INTO composicion_producto
	VALUES(_cod1,_cod2,_cantidad,_cod3);
	UPDATE materia_prima SET cantext= (cantext - _cantidad) WHERE codmateriap = _cod2;
	UPDATE productovsunidad set cantext = (cantext - `cant_exi`) Where codproducto = `_cod_pro` AND coduni = _cod3;
END$$

DROP PROCEDURE IF EXISTS `sp_cuota`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_cuota` (IN `_numfact` INT, IN `_total` DOUBLE, IN `_meses` INT)  BEGIN
	#Routine body goes here...
	INSERT INTO cuota(numfact,cuota,fecha_vencimiento,cantidad_cuotas)
	select numfact, _total ,DATE_ADD(fecha,INTERVAL _meses MONTH),_meses
from factura
Where numfact = _numfact;
END$$

DROP PROCEDURE IF EXISTS `sp_detallefactura`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_detallefactura` (IN `_numfact` INT, IN `_codproducto` INT, IN `_cantvent` INT, IN `_precvent` DOUBLE, IN `_coduni` INT)  begin
	IF (select count(*) from detalle_factura where numfact=`_numfact` and codprod=`_codproducto`)<=0 THEN		
		insert into detalle_factura(numfact,codprod,cantvent,precvent,coduni)values(`_numfact`,`_codproducto`,`_cantvent`,`_precvent`,`_coduni`); 
		update productovsunidad set cantext=cantext-`_cantvent` where codproducto=`_codproducto` and coduni=`_coduni`;
    ELSE
		update detalle_factura set cantvent=cantvent+`_cantvent`,precvent=`_precvent` where numfact=`_numfact` and codprod=`_codproducto`;
    END IF; 
	select `_numfact` as numfact;
end$$

DROP PROCEDURE IF EXISTS `sp_direccion`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_direccion` (IN `_direccion` VARCHAR(100))  BEGIN
	#Routine body goes here...
	INSERT INTO direccion(descripcion) VALUES(_direccion);
	select max(coddir) from direccion;
END$$

DROP PROCEDURE IF EXISTS `sp_direccion_pedido`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_direccion_pedido` (IN `_referencia` VARCHAR(99), IN `_region` INT, IN `_provincia` INT, IN `_municipio` INT, IN `_sector` INT, IN `_calle` INT)  BEGIN
	#Routine body goes here...
	INSERT INTO direccion(Descripcion,codreg,codprovi,codmuni,codsec,codcalle)
 Values(`_referencia` ,`_region`,`_provincia`,`_municipio`,`_sector`,`_calle`);
	SELECT MAX(coddir) from direccion;
END$$

DROP PROCEDURE IF EXISTS `sp_documento`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_documento` (IN `_numeracion` VARCHAR(50), IN `_tipo` VARCHAR(50))  BEGIN
	#Routine body goes here...
insert into documento(numeracion,tipo)	VALUES(`_numeracion` ,`_tipo` );
select max(coddocu) from documento;
END$$

DROP PROCEDURE IF EXISTS `sp_empleado`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_empleado` (IN `_correo` VARCHAR(70), IN `_tipo_empl` INT, IN `_persona` INT, IN `_usuario` INT, IN `_telefono` INT, IN `_horario` INT)  BEGIN
	#Routine body goes here...
INSERT INTO empleado(correo,codtipoemp,codper,codusuario,codtel,horario)
VALUES(`_correo` ,`_tipo_empl` ,`_persona` ,`_usuario` ,`_telefono` ,`_horario`);
END$$

DROP PROCEDURE IF EXISTS `sp_factura`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_factura` (IN `_codcli` INT, IN `_estado` INT, IN `_tipfac` INT, IN `_codemp` INT, IN `_balance` DOUBLE, IN `_total` DOUBLE)  begin
	insert into factura(codcli,estado,tipfac,fecha,codemp,balance,total)values(_codcli,_estado,_tipfac,now(),_codemp,_balance,_total);
	select max(numfact) from factura;
end$$

DROP PROCEDURE IF EXISTS `sp_pedido`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_pedido` (IN `_numfact` INT, IN `_codemp` INT, IN `_codvehi` INT, IN `_coddirec` INT)  BEGIN
	#Routine body goes here...
	
	insert into pedido (numfact,codemp,codvehiculo,coddir,estado) values(`_numfact`,`_codemp`,`_codvehi`,`_coddirec`,0);
	IF (select count(*) from pedido where estado=0 and codemp=`_codemp` )>3 THEN	
		update vehiculo set disponibilidad=1 where codvehiculo=`_codvehi`;
		update empleado set disponibilidad=1 where codemp=`_codemp`;
	end if;
END$$

DROP PROCEDURE IF EXISTS `sp_persona`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_persona` (IN `_nombre` VARCHAR(50), IN `_apellido` VARCHAR(50), IN `_direccion` INT, IN `_docu` INT)  BEGIN
	#Routine body goes here...
		INSERT INTO persona(nombre,apellido,coddir,coddocu) VALUES(`_nombre` ,`_apellido` ,`_direccion` ,`_docu` );
	SELECT MAX(codper) from persona;
END$$

DROP PROCEDURE IF EXISTS `sp_produccion`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_produccion` (IN `_inicio` DATETIME, IN `_codprodu` INT, IN `_cantidad` INT, IN `_fin` DATETIME, IN `_unidad` INT)  BEGIN
	#Routine body goes here...
	INSERT INTO produccion(fecha_inicio,codprod,cantidad_prod,fecha_fin,cod_uni)
VALUES(`_inicio` ,_codprodu,_cantidad,_fin,_unidad);

END$$

DROP PROCEDURE IF EXISTS `sp_producto`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_producto` (IN `_descripcion` VARCHAR(50), IN `_tipo_prod` INT, IN `_estado` TINYINT, IN `_cod_provee` INT)  BEGIN
	#Routine body goes here...
	INSERT INTO producto(descripcion,tipoprod,estado,codprov)
	VALUES(`_descripcion`,`_tipo_prod`,`_estado` ,`_cod_provee`);
END$$

DROP PROCEDURE IF EXISTS `sp_telefono`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_telefono` (IN `_numero` VARCHAR(15), IN `_tipo` INT)  BEGIN
	#Routine body goes here...
		insert into telefono(numero,codtipotel)	VALUES(`_numero` ,_tipo);
select max(codtel) from telefono;
END$$

DROP PROCEDURE IF EXISTS `sp_triple_versus`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_triple_versus` (IN `_actividad` INT, IN `_produccion` INT, IN `_empleado` INT)  BEGIN
	#Routine body goes here...
	IF (select count(*) from actividadvsproduccionvsempleado where codactiv=`_actividad` and codproduccion=`_produccion`)<=0 
		THEN
		INSERT INTO actividadvsproduccionvsempleado VALUES(`_actividad` ,`_produccion` ,`_empleado` );
UPDATE empleado set disponibilidad = 1 where codemp = `_empleado`; 
	ELSE
		update actividadvsproduccionvsempleado set codemp=`_empleado` 
	where codactiv=`_actividad` and codproduccion=`_produccion`;
UPDATE empleado set disponibilidad = 1 where codemp = `_empleado`; 
    END IF;

END$$

DROP PROCEDURE IF EXISTS `sp_ver_trabajos_asignados_produccion`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ver_trabajos_asignados_produccion` (IN `_cod_produccion` INT)  BEGIN
	#Routine body goes here...
select CONCAT(per.nombre," ",per.apellido) as Empleado, a.descripcion as Tarea
 
from actividadvsproduccionvsempleado vs
INNER JOIN actividad a on vs.codactiv = a.codactiv
INNER JOIN produccion pr on vs.codproduccion = pr.codproduccion
INNER JOIN empleado e on vs.codemp = e.codemp
INNER JOIN producto p on pr.codprod = p.codproducto
INNER JOIN persona per on e.codper = per.codper
Where vs.codproduccion = _cod_produccion;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
CREATE TABLE IF NOT EXISTS `actividad` (
  `codactiv` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`codactiv`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `actividad`
--

INSERT INTO `actividad` (`codactiv`, `descripcion`) VALUES
(1, 'Ninguna'),
(2, 'Limpiar productos terminados'),
(3, 'Mantenimiento de equipos agronomos'),
(4, 'Empacar productos'),
(5, 'Etiquetar productos'),
(6, 'Rellenar productos'),
(7, 'Verificar estado de producto'),
(8, 'Supervisar calidad de produccion');

-- --------------------------------------------------------

--
-- Table structure for table `actividadvsproduccionvsempleado`
--

DROP TABLE IF EXISTS `actividadvsproduccionvsempleado`;
CREATE TABLE IF NOT EXISTS `actividadvsproduccionvsempleado` (
  `codactiv` int(11) NOT NULL,
  `codproduccion` int(11) NOT NULL,
  `codemp` int(11) NOT NULL,
  KEY `codacti` (`codactiv`),
  KEY `codproduccion` (`codproduccion`),
  KEY `actividadvsproduccion_ibfk_3` (`codemp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `actividadvsproduccionvsempleado`
--

INSERT INTO `actividadvsproduccionvsempleado` (`codactiv`, `codproduccion`, `codemp`) VALUES
(2, 1, 2),
(4, 1, 2),
(4, 2, 11),
(5, 2, 10),
(8, 2, 11),
(4, 4, 10),
(2, 4, 11);

-- --------------------------------------------------------

--
-- Table structure for table `actividadvstipoempleado`
--

DROP TABLE IF EXISTS `actividadvstipoempleado`;
CREATE TABLE IF NOT EXISTS `actividadvstipoempleado` (
  `codtipoemp` int(11) NOT NULL,
  `codacti` int(11) NOT NULL,
  KEY `codacti` (`codacti`),
  KEY `codtipoemp` (`codtipoemp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `actividadvstipoempleado`
--

INSERT INTO `actividadvstipoempleado` (`codtipoemp`, `codacti`) VALUES
(1, 2),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8);

-- --------------------------------------------------------

--
-- Table structure for table `calle`
--

DROP TABLE IF EXISTS `calle`;
CREATE TABLE IF NOT EXISTS `calle` (
  `codcalle` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(40) NOT NULL,
  `codsec` int(11) NOT NULL,
  PRIMARY KEY (`codcalle`),
  KEY `codsec` (`codsec`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `calle`
--

INSERT INTO `calle` (`codcalle`, `descripcion`, `codsec`) VALUES
(1, 'Carretera Luperon', 2),
(2, 'Avenida Hispanoamericana', 3),
(3, 'Avenida san luis', 4),
(4, 'Avenida las carreras', 4),
(5, 'Avenida 27 de febrero', 6),
(6, 'Calle Real', 5),
(7, 'Avenida presidente vazques', 5),
(8, 'Avenida Hermanas mirabal', 13),
(9, 'Avenida Nuñes de Caceres', 12);

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `codclie` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(30) NOT NULL,
  `codper` int(8) NOT NULL,
  `codtel` int(8) NOT NULL,
  PRIMARY KEY (`codclie`),
  KEY `codper` (`codper`,`codtel`),
  KEY `codtel` (`codtel`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`codclie`, `correo`, `codper`, `codtel`) VALUES
(1, 'nose@tuttutu.com', 1, 1),
(2, 'felixartiles97@gmail.com', 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `composicion_producto`
--

DROP TABLE IF EXISTS `composicion_producto`;
CREATE TABLE IF NOT EXISTS `composicion_producto` (
  `codproduccion` int(11) NOT NULL,
  `codmateriap` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `coduni` int(11) NOT NULL,
  KEY `fk_composicion_materiaprima` (`codmateriap`),
  KEY `fk_composicion_unidad` (`coduni`),
  KEY `codproduccion` (`codproduccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `composicion_producto`
--

INSERT INTO `composicion_producto` (`codproduccion`, `codmateriap`, `cantidad`, `coduni`) VALUES
(4, 1, 1, 8),
(4, 2, 1, 6),
(4, 1, 1, 8);

-- --------------------------------------------------------

--
-- Table structure for table `cuota`
--

DROP TABLE IF EXISTS `cuota`;
CREATE TABLE IF NOT EXISTS `cuota` (
  `numfact` int(11) NOT NULL,
  `cuota` double NOT NULL,
  `fecha_vencimiento` datetime(6) NOT NULL,
  `cantidad_cuotas` int(11) NOT NULL,
  KEY `numfact` (`numfact`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cuota`
--

INSERT INTO `cuota` (`numfact`, `cuota`, `fecha_vencimiento`, `cantidad_cuotas`) VALUES
(15, 64.7, '2020-06-12 23:15:36.000000', 6),
(16, 4287.71, '2021-06-13 00:52:19.000000', 18),
(18, 64.7, '2020-06-13 19:06:11.000000', 6),
(20, 9.23, '2020-06-13 19:26:23.000000', 6),
(23, 64.7, '2020-06-13 19:39:08.000000', 6),
(24, 83.15, '2020-06-13 19:52:23.000000', 6),
(25, 73.93, '2020-06-13 19:57:05.000000', 6),
(26, 39.55, '2020-12-13 19:58:51.000000', 12),
(30, 9.23, '2020-06-13 20:19:07.000000', 6),
(33, 64.7, '2020-06-13 20:31:01.000000', 6),
(36, 1353.91, '2020-12-17 17:29:15.000000', 12);

-- --------------------------------------------------------

--
-- Table structure for table `detalle_factura`
--

DROP TABLE IF EXISTS `detalle_factura`;
CREATE TABLE IF NOT EXISTS `detalle_factura` (
  `numfact` int(11) NOT NULL,
  `codprod` int(11) NOT NULL,
  `cantvent` int(11) NOT NULL,
  `precvent` double NOT NULL,
  `coduni` int(11) NOT NULL,
  PRIMARY KEY (`numfact`,`codprod`),
  KEY `fk_detallefac_producto` (`codprod`),
  KEY `fk_detallefac_unidad` (`coduni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `detalle_factura`
--

INSERT INTO `detalle_factura` (`numfact`, `codprod`, `cantvent`, `precvent`, `coduni`) VALUES
(2, 2, 1, 350.5, 2),
(3, 2, 3, 350.5, 2),
(4, 2, 1, 350.5, 2),
(5, 2, 1, 350.5, 2),
(6, 3, 2, 49.98, 1),
(7, 2, 4, 350.5, 2),
(7, 3, 3, 49.98, 1),
(7, 4, 2, 650, 2),
(8, 4, 2, 650, 2),
(9, 4, 12, 650, 2),
(10, 2, 2, 350.5, 2),
(11, 2, 2, 350.5, 2),
(12, 4, 1, 650, 2),
(13, 3, 1, 49.98, 1),
(14, 4, 8, 650, 2),
(15, 2, 1, 350.5, 2),
(16, 2, 143, 350.5, 2),
(17, 2, 1, 350.5, 2),
(18, 2, 1, 350.5, 2),
(19, 3, 1, 49.98, 1),
(20, 3, 1, 49.98, 1),
(21, 3, 1, 49.98, 1),
(22, 2, 1, 350.5, 2),
(23, 2, 1, 350.5, 2),
(24, 2, 1, 350.5, 2),
(24, 3, 2, 49.98, 1),
(25, 2, 1, 350.5, 2),
(25, 3, 1, 49.98, 1),
(26, 2, 1, 350.5, 2),
(27, 3, 1, 49.98, 1),
(28, 3, 1, 49.98, 1),
(29, 3, 1, 49.98, 1),
(30, 3, 1, 49.98, 1),
(31, 3, 1, 49.98, 1),
(32, 3, 1, 49.98, 1),
(33, 2, 1, 350.5, 2),
(34, 2, 1, 350.5, 2),
(35, 2, 1, 350.5, 2),
(36, 7, 20, 600, 4),
(37, 2, 1, 350.5, 2),
(38, 2, 1, 350.5, 2),
(39, 2, 1, 350.5, 2),
(40, 2, 1, 350.5, 2),
(41, 2, 1, 350.5, 2),
(42, 2, 1, 350.5, 2),
(43, 2, 1, 350.5, 2),
(44, 2, 1, 350.5, 2);

-- --------------------------------------------------------

--
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
CREATE TABLE IF NOT EXISTS `direccion` (
  `coddir` int(10) NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(100) NOT NULL,
  `codreg` int(11) NOT NULL,
  `codprovi` int(11) NOT NULL,
  `codmuni` int(11) NOT NULL,
  `codsec` int(11) NOT NULL,
  `codcalle` int(11) NOT NULL,
  PRIMARY KEY (`coddir`),
  KEY `codreg` (`codreg`),
  KEY `codprovi` (`codprovi`),
  KEY `codmuni` (`codmuni`),
  KEY `codsec` (`codsec`),
  KEY `codcalle` (`codcalle`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `direccion`
--

INSERT INTO `direccion` (`coddir`, `Descripcion`, `codreg`, `codprovi`, `codmuni`, `codsec`, `codcalle`) VALUES
(1, 'En el supermercado el encanto', 1, 1, 29, 4, 3),
(2, 'Donde viven los riquitos', 3, 22, 36, 12, 9),
(3, 'Cerca de la Victoria', 3, 22, 35, 13, 8),
(4, 'Por cecomsa', 1, 1, 29, 2, 1),
(5, 'al lado de la banca doris', 1, 1, 29, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `documento`
--

DROP TABLE IF EXISTS `documento`;
CREATE TABLE IF NOT EXISTS `documento` (
  `coddocu` int(10) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL,
  `numeracion` varchar(50) NOT NULL,
  PRIMARY KEY (`coddocu`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `documento`
--

INSERT INTO `documento` (`coddocu`, `tipo`, `numeracion`) VALUES
(1, 'CEDULA', '054-0043239-1'),
(2, 'Pasaporte', '123456789'),
(3, '1', '401-2558963-1'),
(4, '1', '174582693-2'),
(5, 'CEDULA', '402-4025987-2'),
(6, 'CEDULA', '402-4025987-2'),
(7, 'CEDULA', '402-4025987-2'),
(8, 'CEDULA', '231546789'),
(9, 'CEDULA', '123-456-789'),
(10, 'CEDULA', '2131231');

-- --------------------------------------------------------

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
CREATE TABLE IF NOT EXISTS `empleado` (
  `codemp` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(30) NOT NULL,
  `codtipoemp` int(11) NOT NULL,
  `codper` int(11) NOT NULL,
  `codusuario` int(11) NOT NULL,
  `codtel` int(11) NOT NULL,
  `horario` int(11) NOT NULL,
  `disponibilidad` int(11) NOT NULL,
  PRIMARY KEY (`codemp`),
  KEY `fk_empleado_tipemp` (`codtipoemp`),
  KEY `fk_empleado_usuario` (`codusuario`),
  KEY `fk_empleado_telefono` (`codtel`),
  KEY `fk_empleado_horario` (`horario`),
  KEY `codper` (`codper`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `empleado`
--

INSERT INTO `empleado` (`codemp`, `correo`, `codtipoemp`, `codper`, `codusuario`, `codtel`, `horario`, `disponibilidad`) VALUES
(1, 'felix_artiles@agrodroga.com', 1, 2, 2, 2, 1, 1),
(2, 'feminazi@agrodroga.com', 2, 4, 3, 1, 2, 1),
(3, 'quemaldito_nombre@agrodroga.co', 3, 3, 1, 2, 3, 0),
(10, 'nose24@tuttutu.com', 1, 5, 6, 6, 1, 0),
(11, 'nombre@agrodroga.com', 4, 11, 3, 8, 2, 0),
(12, 'Esther@agroquimica.com', 9, 8, 6, 7, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `enfermedad`
--

DROP TABLE IF EXISTS `enfermedad`;
CREATE TABLE IF NOT EXISTS `enfermedad` (
  `codenfer` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`codenfer`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `enfermedad`
--

INSERT INTO `enfermedad` (`codenfer`, `descripcion`) VALUES
(1, 'Sarna_del_Manzano(Venturia_inaequalis)'),
(2, 'Podredumbre_Negra(Botryosphaeria obtusa)'),
(3, 'Gymnosporangium juniperi-virginianae'),
(4, 'Saludable'),
(5, 'Podosphaera_pannosa'),
(6, 'Mancha_gris(Cercospora_zeae-maydis)'),
(7, 'Roya_común(Puccinia_sorghi)'),
(8, 'Tizón_de_la_hoja(Exserohilum_turcicum)'),
(9, 'Podredumbre_Negra(Guignardia_bidwellii)'),
(10, 'Phaeomoniella_aleophilum'),
(11, 'Tizón(Pseudocercospora_vitis)'),
(12, 'Huanglongbing'),
(13, 'Xanthomonas_campestris'),
(14, 'Tizón_temprano(Alternaria_solani)'),
(15, 'Tizón_tardío(Phytophthora_infestans)'),
(16, 'Oídio(Erysiphe_cichoracearum)'),
(17, 'Diplocarpon_earlianum'),
(18, 'Cladosporiosis(Fulvia_fulva)'),
(19, 'Mancha_de_hoja(Septoria_lycopersici)'),
(20, 'Ácaro_rojo(Tetranychus_urticae)'),
(21, 'Mancha_anillada(Corynespora_cassiicola)'),
(22, 'TYLCV(Yellow_Leaf_Curl_Virus)'),
(23, 'Virus_del_Mosaico');

-- --------------------------------------------------------

--
-- Table structure for table `especie`
--

DROP TABLE IF EXISTS `especie`;
CREATE TABLE IF NOT EXISTS `especie` (
  `codespecie` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(300) NOT NULL,
  `codplant` int(11) NOT NULL,
  PRIMARY KEY (`codespecie`),
  KEY `fk_planta_especie` (`codplant`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `especie`
--

INSERT INTO `especie` (`codespecie`, `descripcion`, `codplant`) VALUES
(1, 'Solanum_lycopersicum', 1),
(2, 'Barcelo', 1),
(3, 'Malus_domestica', 6),
(4, 'Vaccinium_corymbosum', 7),
(5, 'Rainer', 5),
(6, 'Zea_mays', 4),
(7, 'Vitis_rotundifolia', 3),
(8, 'Citrus_sinensis', 2),
(9, 'Pyrus_communis', 8),
(10, 'Capsicum_annuum', 9),
(11, 'Solanum_tuberosum', 10),
(12, 'Rubus_idaeus', 11),
(13, 'Glycine_max', 12),
(14, 'Cucurbita_ficifolia', 13),
(15, 'Fragaria_vesca', 14);

-- --------------------------------------------------------

--
-- Table structure for table `especievsenfermedad`
--

DROP TABLE IF EXISTS `especievsenfermedad`;
CREATE TABLE IF NOT EXISTS `especievsenfermedad` (
  `codenfer` int(11) NOT NULL,
  `codespecie` int(11) NOT NULL,
  KEY `fk_especievsenfer_enfer` (`codenfer`),
  KEY `fk_especievsenfer_especie` (`codespecie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `especievsenfermedad`
--

INSERT INTO `especievsenfermedad` (`codenfer`, `codespecie`) VALUES
(1, 3),
(2, 3),
(3, 3),
(5, 5),
(6, 6),
(7, 6),
(8, 6),
(9, 7),
(10, 7),
(11, 7),
(12, 8),
(13, 9),
(13, 10),
(14, 11),
(15, 11),
(16, 14),
(17, 15),
(13, 1),
(14, 1),
(15, 1),
(18, 1),
(19, 1),
(20, 1),
(21, 1),
(22, 1),
(23, 1);

-- --------------------------------------------------------

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
CREATE TABLE IF NOT EXISTS `factura` (
  `numfact` int(11) NOT NULL AUTO_INCREMENT,
  `codcli` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `tipfac` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `codemp` int(11) NOT NULL,
  `balance` double NOT NULL,
  `total` double NOT NULL,
  PRIMARY KEY (`numfact`),
  KEY `fk_factura_cliente` (`codcli`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `factura`
--

INSERT INTO `factura` (`numfact`, `codcli`, `estado`, `tipfac`, `fecha`, `codemp`, `balance`, `total`) VALUES
(2, 1, 1, 1, '2019-12-02 03:01:02', 1, -12992.529999999999, 10),
(3, 2, 1, 1, '2019-12-02 03:19:16', 1, -12992.529999999999, 1051.5),
(4, 1, 1, 0, '2019-12-02 03:24:54', 1, -12992.529999999999, 350.5),
(5, 1, 0, 1, '2019-12-02 03:25:02', 1, -12817.279999999999, 350.5),
(6, 1, 1, 0, '2019-12-07 20:20:25', 2, -12992.529999999999, 99.96),
(7, 2, 0, 1, '2019-12-08 16:16:02', 2, -11566.560000000001, 2851.94),
(8, 2, 0, 1, '2019-12-12 18:17:14', 2, -11692.529999999999, 1300),
(9, 2, 0, 1, '2019-12-12 18:18:35', 2, -5192.53, 7800),
(10, 1, 0, 1, '2019-12-12 18:21:26', 2, -12291.529999999999, 701),
(11, 2, 0, 1, '2019-12-12 18:22:33', 2, -12291.529999999999, 701),
(12, 1, 0, 1, '2019-12-12 18:24:32', 2, -12342.529999999999, 650),
(13, 1, 0, 1, '2019-12-12 18:28:09', 2, -12942.55, 49.98),
(14, 1, 0, 1, '2019-12-12 19:16:21', 2, -7792.53, 5200),
(15, 1, 0, 1, '2019-12-12 23:15:36', 2, -12642.029999999999, 350.5),
(16, 1, 0, 1, '2019-12-13 00:52:19', 2, 37258.37, 50121.5),
(17, 1, 0, 1, '2019-12-13 19:05:18', 2, -8224.92, 350.5),
(18, 1, 0, 1, '2019-12-13 19:06:11', 2, -8224.92, 350.5),
(19, 1, 0, 1, '2019-12-13 19:10:51', 2, 49.98, 49.98),
(20, 1, 0, 1, '2019-12-13 19:26:23', 2, 49.98, 49.98),
(21, 1, 0, 1, '2019-12-13 19:31:15', 2, 49.98, 49.98),
(22, 1, 0, 1, '2019-12-13 19:32:50', 2, 350.5, 350.5),
(23, 1, 0, 1, '2019-12-13 19:39:08', 2, 350.5, 350.5),
(24, 1, 0, 1, '2019-12-13 19:52:23', 2, 450.46, 450.46),
(25, 1, 0, 1, '2019-12-13 19:57:05', 2, 400.48, 400.48),
(26, 2, 0, 1, '2019-12-13 19:58:51', 2, 350.5, 350.5),
(27, 2, 1, 0, '2019-12-13 20:00:00', 2, 0, 49.98),
(28, 2, 1, 0, '2019-12-13 20:05:58', 2, 0, 49.98),
(29, 2, 1, 0, '2019-12-13 20:08:05', 2, 0, 49.98),
(30, 1, 0, 1, '2019-12-13 20:19:07', 2, 49.98, 49.98),
(31, 1, 0, 1, '2019-12-13 20:25:29', 2, 49.98, 49.98),
(32, 1, 0, 1, '2019-12-13 20:25:43', 2, 49.98, 49.98),
(33, 1, 0, 1, '2019-12-13 20:31:01', 2, 350.5, 350.5),
(34, 2, 1, 0, '2019-12-13 20:33:18', 2, 0, 350.5),
(35, 1, 1, 0, '2019-12-16 19:34:38', 2, 0, 350.5),
(36, 1, 0, 1, '2019-12-17 17:29:15', 2, 12000, 12000),
(37, 1, 1, 0, '2019-12-18 23:58:56', 2, 0, 350.5),
(38, 1, 1, 0, '2019-12-19 00:03:06', 2, 0, 350.5),
(39, 2, 1, 0, '2019-12-19 00:03:25', 2, 0, 450.5),
(40, 1, 1, 0, '2019-12-19 02:50:21', 2, 0, 450.5),
(41, 1, 1, 0, '2019-12-19 10:40:49', 2, 0, 350.5),
(42, 1, 1, 0, '2019-12-19 10:41:56', 2, 0, 350.5),
(43, 1, 1, 0, '2019-12-19 10:44:02', 2, 0, 450.5),
(44, 1, 1, 0, '2019-12-19 17:08:25', 2, 0, 450.5);

-- --------------------------------------------------------

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
CREATE TABLE IF NOT EXISTS `horario` (
  `codhorario` int(11) NOT NULL AUTO_INCREMENT,
  `entrada` time NOT NULL,
  `salida` time NOT NULL,
  `tipo_horario` int(11) NOT NULL,
  PRIMARY KEY (`codhorario`),
  KEY `codhorario` (`codhorario`),
  KEY `tipo_horario` (`tipo_horario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `horario`
--

INSERT INTO `horario` (`codhorario`, `entrada`, `salida`, `tipo_horario`) VALUES
(1, '08:00:00', '17:00:00', 1),
(2, '06:00:00', '16:00:00', 2),
(3, '08:30:00', '22:00:00', 2);

-- --------------------------------------------------------

--
-- Table structure for table `materiaprimavsunidad`
--

DROP TABLE IF EXISTS `materiaprimavsunidad`;
CREATE TABLE IF NOT EXISTS `materiaprimavsunidad` (
  `coduni` int(11) NOT NULL,
  `codmateria` int(11) NOT NULL,
  `preciocomp` double NOT NULL,
  `cantext` int(11) NOT NULL,
  KEY `fk_materiapvsuni_unidad` (`coduni`),
  KEY `fk_materiapvsuni_materia` (`codmateria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `materiaprimavsunidad`
--

INSERT INTO `materiaprimavsunidad` (`coduni`, `codmateria`, `preciocomp`, `cantext`) VALUES
(8, 1, 90, 10),
(6, 2, 95, 12),
(2, 4, 80, 200),
(2, 5, 20, 200);

-- --------------------------------------------------------

--
-- Table structure for table `materia_prima`
--

DROP TABLE IF EXISTS `materia_prima`;
CREATE TABLE IF NOT EXISTS `materia_prima` (
  `codmateriap` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  `codprov` int(11) NOT NULL,
  PRIMARY KEY (`codmateriap`),
  KEY `fk_materiaprima_proveedor` (`codprov`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `materia_prima`
--

INSERT INTO `materia_prima` (`codmateriap`, `descripcion`, `codprov`) VALUES
(1, 'Cloruro de Potasio', 1),
(2, 'Texapon', 1),
(4, 'Extracto de Ajo', 1),
(5, 'Cebo', 1);

-- --------------------------------------------------------

--
-- Table structure for table `municipio`
--

DROP TABLE IF EXISTS `municipio`;
CREATE TABLE IF NOT EXISTS `municipio` (
  `codmuni` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `codprovi` int(11) NOT NULL,
  PRIMARY KEY (`codmuni`),
  KEY `codprovi` (`codprovi`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `municipio`
--

INSERT INTO `municipio` (`codmuni`, `descripcion`, `codprovi`) VALUES
(1, 'Azua de Compostela', 32),
(2, 'Neiba', 31),
(3, 'Santa Cruz de Barahona', 30),
(4, 'Dajabón', 14),
(5, 'Santo Domingo', 15),
(6, 'San Francisco de Macorís', 13),
(7, 'Comendador', 29),
(8, 'Santa Cruz de El Seibo', 16),
(9, 'Moca', 12),
(10, 'Hato Mayor del Rey', 17),
(11, 'Salcedo', 11),
(12, 'Jimaní', 28),
(13, 'Salvaleón de Higüey', 18),
(14, 'La Romana', 19),
(15, 'La vega', 10),
(16, 'Nagua', 9),
(17, 'Bonao', 8),
(18, 'San Fernando de Monte Cristi', 7),
(19, 'Monte Plata', 20),
(20, 'Pedernales', 27),
(21, 'Bani', 26),
(22, 'San Felipe de Puerto Plata', 6),
(23, 'Santa Bárbara de Samaná', 5),
(24, 'San Cristóbal', 25),
(25, 'San José de Ocoa', 24),
(26, 'San Juan de la Maguana', 23),
(27, 'San Pedro de Macorís', 21),
(28, 'Cotuí', 4),
(29, 'Santiago de los Caballeros', 1),
(30, 'San Ignacio de Sabaneta', 3),
(31, 'Santo Domingo Este', 22),
(32, 'Santa Cruz de Mao', 2),
(33, 'Los Alcarrizos', 22),
(34, 'Boca chica', 22),
(35, 'Santo Domingo Norte', 22),
(36, 'Santo Domingo Oeste', 22),
(37, 'Janico', 1),
(38, 'Licey al medio', 1),
(39, 'Tamboril', 1),
(40, 'Villa Gonzales', 1),
(41, 'Villa bisonó', 1),
(42, 'San Jose de las Matas', 1),
(43, 'San victor', 12),
(44, 'Gaspar Hernandez', 12),
(45, 'Jamao Al Norte', 12),
(46, 'Yásica Arriba', 6),
(47, 'Maimon', 6);

-- --------------------------------------------------------

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE IF NOT EXISTS `pedido` (
  `numfact` int(11) NOT NULL,
  `coddir` int(11) NOT NULL,
  `codemp` int(11) NOT NULL,
  `codvehiculo` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  KEY `fk_pedido_factura` (`numfact`),
  KEY `fk_pedido_empleado` (`codemp`),
  KEY `fk_pedido_vehiculo` (`codvehiculo`),
  KEY `fk_pedido_direccion` (`coddir`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pedido`
--

INSERT INTO `pedido` (`numfact`, `coddir`, `codemp`, `codvehiculo`, `estado`) VALUES
(3, 2, 2, 2, 0),
(3, 2, 2, 2, 0),
(3, 3, 2, 2, 0),
(2, 1, 1, 1, 0),
(44, 5, 11, 4, 0);

-- --------------------------------------------------------

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
CREATE TABLE IF NOT EXISTS `persona` (
  `codper` int(8) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `coddir` int(8) NOT NULL,
  `coddocu` int(11) NOT NULL,
  PRIMARY KEY (`codper`),
  KEY `coddocu` (`coddocu`),
  KEY `coddir` (`coddir`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `persona`
--

INSERT INTO `persona` (`codper`, `nombre`, `apellido`, `coddir`, `coddocu`) VALUES
(1, 'Ramon Jose', 'Perez', 1, 1),
(2, 'Felix miguel', 'Artiles Acosta', 2, 1),
(3, 'Uvuvwevwevwe Onyetenyevwe', 'Ugwemuhwem Osas', 3, 2),
(4, 'Maria Estefany', 'Polanco Valdez', 1, 1),
(5, 'Juan Manuel', 'Jimenez', 2, 1),
(6, 'Laura Sophia', 'Carvajal', 3, 1),
(7, 'Juan Jose', 'Martinez Sierra', 1, 1),
(8, 'Esther', 'Henriquez Perez', 2, 2),
(11, 'Manaury', 'Fleury', 3, 4),
(16, 'fulano', 'del fulanaso', 1, 9),
(17, 'fulano', 'activo', 2, 10);

-- --------------------------------------------------------

--
-- Table structure for table `planta`
--

DROP TABLE IF EXISTS `planta`;
CREATE TABLE IF NOT EXISTS `planta` (
  `codplant` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`codplant`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `planta`
--

INSERT INTO `planta` (`codplant`, `descripcion`) VALUES
(1, 'Tomate'),
(2, 'Naranja'),
(3, 'Uva'),
(4, 'Maíz'),
(5, 'Cereza'),
(6, 'Manzana'),
(7, 'Arándano'),
(8, 'Pera'),
(9, 'Ají'),
(10, 'Papa'),
(11, 'Frambuesa'),
(12, 'Soja'),
(13, 'Calabaza'),
(14, 'Fresa');

-- --------------------------------------------------------

--
-- Table structure for table `produccion`
--

DROP TABLE IF EXISTS `produccion`;
CREATE TABLE IF NOT EXISTS `produccion` (
  `codproduccion` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_inicio` datetime NOT NULL,
  `codprod` int(11) NOT NULL,
  `cantidad_prod` int(11) NOT NULL,
  `fecha_fin` datetime NOT NULL,
  `cod_uni` int(11) NOT NULL,
  PRIMARY KEY (`codproduccion`),
  KEY `fk_producto_produccion` (`codprod`),
  KEY `fk_uni_pro` (`cod_uni`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `produccion`
--

INSERT INTO `produccion` (`codproduccion`, `fecha_inicio`, `codprod`, `cantidad_prod`, `fecha_fin`, `cod_uni`) VALUES
(1, '2019-12-17 08:39:30', 2, 100, '2019-12-21 08:39:34', 1),
(2, '2019-12-17 10:56:13', 4, 33, '2019-12-20 10:56:16', 5),
(3, '2019-12-17 10:56:13', 3, 105, '2019-12-20 10:56:16', 4),
(4, '2019-12-17 05:20:26', 2, 12, '2019-12-19 05:20:30', 2);

-- --------------------------------------------------------

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `codproducto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  `tipoprod` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `codprov` int(11) NOT NULL,
  PRIMARY KEY (`codproducto`),
  KEY `fk_producto_tipoprod` (`tipoprod`),
  KEY `fk_producto_proveedor` (`codprov`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `producto`
--

INSERT INTO `producto` (`codproducto`, `descripcion`, `tipoprod`, `estado`, `codprov`) VALUES
(2, 'Jabon Potasico', 1, 1, 1),
(3, 'Copper Sulphate Pentahydrate', 4, 1, 1),
(4, 'Azoxystrobin', 4, 1, 1),
(5, 'Difenoconazole+Propconazole', 4, 1, 1),
(6, 'Azufre', 4, 1, 1),
(7, 'Clofentezina', 5, 1, 1),
(8, 'Cimoxanil+Mancozeb-oxicloruro de cobre', 4, 1, 1),
(9, 'Tetraconazol', 4, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `productovsefermedad`
--

DROP TABLE IF EXISTS `productovsefermedad`;
CREATE TABLE IF NOT EXISTS `productovsefermedad` (
  `codenfer` int(11) NOT NULL,
  `codprod` int(11) NOT NULL,
  `coduni` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `codsuelo` int(11) NOT NULL,
  `clima` tinyint(1) NOT NULL,
  `codespecie` int(11) NOT NULL,
  `codplant` int(11) NOT NULL,
  KEY `fk_producto_prodvsenfer` (`codprod`),
  KEY `fk_enfermedad_prodvsenfer` (`codenfer`),
  KEY `fk_prodvsenfer_tipsuelo` (`codsuelo`),
  KEY `fk_prodvsenfer_unidad` (`coduni`),
  KEY `fk_prodvsenfer_planta` (`codplant`),
  KEY `fk_prodvsenfer_especie` (`codespecie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `productovsefermedad`
--

INSERT INTO `productovsefermedad` (`codenfer`, `codprod`, `coduni`, `cantidad`, `codsuelo`, `clima`, `codespecie`, `codplant`) VALUES
(14, 5, 4, 1, 1, 0, 1, 1),
(14, 5, 4, 1, 1, 0, 11, 10),
(16, 5, 4, 1, 1, 0, 14, 13),
(19, 4, 5, 1, 1, 0, 1, 1),
(14, 4, 5, 1, 1, 0, 11, 10),
(14, 4, 5, 1, 1, 0, 1, 1),
(13, 3, 4, 1, 1, 0, 1, 1),
(15, 3, 4, 1, 1, 0, 1, 1),
(14, 3, 4, 1, 1, 0, 1, 1),
(15, 3, 4, 1, 1, 0, 11, 10),
(14, 3, 4, 1, 1, 0, 11, 10),
(13, 3, 4, 1, 4, 0, 10, 9),
(20, 7, 4, 1, 1, 0, 1, 1),
(15, 8, 6, 1, 1, 0, 11, 10),
(15, 8, 6, 1, 1, 0, 1, 1),
(13, 3, 4, 1, 1, 0, 9, 8),
(1, 9, 4, 1, 1, 0, 3, 6),
(5, 4, 5, 1, 1, 0, 5, 5),
(7, 4, 5, 1, 1, 0, 6, 4);

-- --------------------------------------------------------

--
-- Table structure for table `productovsunidad`
--

DROP TABLE IF EXISTS `productovsunidad`;
CREATE TABLE IF NOT EXISTS `productovsunidad` (
  `codproducto` int(11) NOT NULL,
  `coduni` int(11) NOT NULL,
  `preciocomp` double NOT NULL,
  `precioventa` double NOT NULL,
  `cantext` int(11) NOT NULL,
  KEY `fk_prodvsuni_unidad` (`coduni`),
  KEY `fk_prodvsuni_producto` (`codproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `productovsunidad`
--

INSERT INTO `productovsunidad` (`codproducto`, `coduni`, `preciocomp`, `precioventa`, `cantext`) VALUES
(2, 2, 290, 350.5, 38),
(4, 5, 479.95, 650, 492),
(3, 4, 239.66, 49.98, 182),
(5, 4, 300, 400, 200),
(6, 4, 375, 400, 24),
(7, 4, 550, 600, 4),
(8, 6, 375, 450, 12),
(9, 4, 375, 450, 12);

-- --------------------------------------------------------

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE IF NOT EXISTS `proveedor` (
  `codproveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_empresa` varchar(100) NOT NULL,
  `codtelefono` int(11) NOT NULL,
  `correo` varchar(20) NOT NULL,
  `codper` int(11) NOT NULL,
  PRIMARY KEY (`codproveedor`),
  KEY `fk_proveedor_persona` (`codper`),
  KEY `fk_proveedor_telefono` (`codtelefono`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `proveedor`
--

INSERT INTO `proveedor` (`codproveedor`, `nombre_empresa`, `codtelefono`, `correo`, `codper`) VALUES
(1, 'AGROINPESA CxA', 1, 'ramoncito@gmail.com', 1),
(2, 'Aqui no vendemos droga', 2, 'felixartiles97@gmail', 2);

-- --------------------------------------------------------

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
CREATE TABLE IF NOT EXISTS `provincia` (
  `codprovi` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `codreg` int(11) NOT NULL,
  PRIMARY KEY (`codprovi`),
  KEY `codreg` (`codreg`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `provincia`
--

INSERT INTO `provincia` (`codprovi`, `descripcion`, `codreg`) VALUES
(1, 'Santiago', 1),
(2, 'Valverde', 1),
(3, 'Santiago Rodriguez', 1),
(4, 'Sánchez Ramirez', 1),
(5, 'Samana', 1),
(6, 'Puerto Plata', 1),
(7, 'Monte Cristi', 1),
(8, 'Monseñor nouel', 1),
(9, 'Maria Trinidad Sánchez', 1),
(10, 'La vega', 1),
(11, 'Hermanas mirabal', 1),
(12, 'Espaillat', 1),
(13, 'Duarte', 1),
(14, 'Dajabon', 1),
(15, 'Distrito Nacional', 2),
(16, 'El Seibo', 2),
(17, 'Hato Mayor', 2),
(18, 'La altagracia', 2),
(19, 'La Romana', 2),
(20, 'Monte Plata', 2),
(21, 'San Pedro de Macoris', 2),
(22, 'Santo Domingo', 2),
(23, 'San Juan', 3),
(24, 'San Jose de Ocoa', 3),
(25, 'San Cristobal', 3),
(26, 'Peravia', 3),
(27, 'Pedernales', 3),
(28, 'Independencia', 3),
(29, 'Elias Piña', 3),
(30, 'Barahona', 3),
(31, 'Bahoruco', 3),
(32, 'Azua', 3);

-- --------------------------------------------------------

--
-- Table structure for table `recibo`
--

DROP TABLE IF EXISTS `recibo`;
CREATE TABLE IF NOT EXISTS `recibo` (
  `numfact` int(11) NOT NULL,
  `num_pago` int(11) NOT NULL,
  `monto_pagado` double NOT NULL,
  `fecha_de_recibo` datetime NOT NULL,
  KEY `fk_recibo_factura` (`numfact`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `recibo`
--

INSERT INTO `recibo` (`numfact`, `num_pago`, `monto_pagado`, `fecha_de_recibo`) VALUES
(15, 1, 64.7, '2019-12-13 00:36:03'),
(15, 2, 64.7, '2019-12-13 00:36:13'),
(16, 1, 4287.71, '2019-12-13 01:04:36'),
(16, 2, 4287.71, '2019-12-13 19:07:09'),
(16, 2, 4287.71, '2019-12-13 19:07:19');

-- --------------------------------------------------------

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
CREATE TABLE IF NOT EXISTS `region` (
  `codreg` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(20) NOT NULL,
  PRIMARY KEY (`codreg`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `region`
--

INSERT INTO `region` (`codreg`, `descripcion`) VALUES
(1, 'Cibao'),
(2, 'Este'),
(3, 'Sur');

-- --------------------------------------------------------

--
-- Table structure for table `sector`
--

DROP TABLE IF EXISTS `sector`;
CREATE TABLE IF NOT EXISTS `sector` (
  `codsec` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `codmuni` int(11) NOT NULL,
  PRIMARY KEY (`codsec`),
  KEY `codmuni` (`codmuni`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sector`
--

INSERT INTO `sector` (`codsec`, `descripcion`, `codmuni`) VALUES
(1, 'Pontezuela', 29),
(2, 'Gurabo', 29),
(3, 'Matanza', 29),
(4, 'Centro Ciudad', 29),
(5, 'Tamboril', 39),
(6, 'Canca la piedra', 39),
(7, 'El Higüerito', 9),
(8, 'Las lagunas', 9),
(9, 'Veragua', 9),
(10, 'Monte de la Jagua', 9),
(11, 'San victor', 43),
(12, 'Los Prados', 36),
(13, 'Villa Mella', 35);

-- --------------------------------------------------------

--
-- Table structure for table `telefono`
--

DROP TABLE IF EXISTS `telefono`;
CREATE TABLE IF NOT EXISTS `telefono` (
  `codtel` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(50) NOT NULL,
  `codtipotel` int(11) NOT NULL,
  PRIMARY KEY (`codtel`),
  KEY `codtipotel` (`codtipotel`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `telefono`
--

INSERT INTO `telefono` (`codtel`, `numero`, `codtipotel`) VALUES
(1, '809-345-2112', 1),
(2, '829-805-5560', 2),
(3, '809-489-9164', 2),
(4, '829-876-9901', 2),
(5, '123456789', 1),
(6, '829-582-5569', 2),
(7, '809-971-5555', 2),
(8, '809-971-5555', 2),
(9, '809-971-5555', 2),
(10, '123-456-7890', 1),
(11, '123456789-', 1),
(12, '123456789-', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tipo_de_empleado`
--

DROP TABLE IF EXISTS `tipo_de_empleado`;
CREATE TABLE IF NOT EXISTS `tipo_de_empleado` (
  `codtipoemp` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`codtipoemp`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipo_de_empleado`
--

INSERT INTO `tipo_de_empleado` (`codtipoemp`, `descripcion`) VALUES
(1, 'Operario'),
(2, 'Caja'),
(3, 'Seguridad'),
(4, 'Transporte'),
(5, 'Tecnico agronomo'),
(6, 'Ingeniero Agronomo'),
(7, 'Brechador'),
(8, 'Limpieza'),
(9, 'Chofer');

-- --------------------------------------------------------

--
-- Table structure for table `tipo_de_producto`
--

DROP TABLE IF EXISTS `tipo_de_producto`;
CREATE TABLE IF NOT EXISTS `tipo_de_producto` (
  `codtipopro` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`codtipopro`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipo_de_producto`
--

INSERT INTO `tipo_de_producto` (`codtipopro`, `descripcion`) VALUES
(1, 'Herbicida'),
(2, 'Insecticida'),
(3, 'Pesticida'),
(4, 'Fungicida'),
(5, 'Acaricida');

-- --------------------------------------------------------

--
-- Table structure for table `tipo_de_suelo`
--

DROP TABLE IF EXISTS `tipo_de_suelo`;
CREATE TABLE IF NOT EXISTS `tipo_de_suelo` (
  `codsuelo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`codsuelo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipo_de_suelo`
--

INSERT INTO `tipo_de_suelo` (`codsuelo`, `descripcion`) VALUES
(1, 'Tierra negra(Humíferos)'),
(2, 'Calizos'),
(3, 'Limosos'),
(4, 'Arcillosos'),
(5, 'Pedregosos'),
(6, 'Turba'),
(7, 'Salinos');

-- --------------------------------------------------------

--
-- Table structure for table `tipo_de_vehiculo`
--

DROP TABLE IF EXISTS `tipo_de_vehiculo`;
CREATE TABLE IF NOT EXISTS `tipo_de_vehiculo` (
  `codtipvehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(30) NOT NULL,
  `capacidad` int(11) NOT NULL,
  PRIMARY KEY (`codtipvehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_de_vehiculo`
--

INSERT INTO `tipo_de_vehiculo` (`codtipvehiculo`, `descripcion`, `capacidad`) VALUES
(1, 'Camioneta', 5),
(2, 'Motor', 2),
(3, 'Pasola', 2),
(4, 'Camión', 3);

-- --------------------------------------------------------

--
-- Table structure for table `tipo_horario`
--

DROP TABLE IF EXISTS `tipo_horario`;
CREATE TABLE IF NOT EXISTS `tipo_horario` (
  `codtipohor` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(150) NOT NULL,
  PRIMARY KEY (`codtipohor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipo_horario`
--

INSERT INTO `tipo_horario` (`codtipohor`, `descripcion`) VALUES
(1, 'Lunes a viernes'),
(2, 'Lunes a sabados'),
(3, 'domingo a jueves');

-- --------------------------------------------------------

--
-- Table structure for table `tipo_telefono`
--

DROP TABLE IF EXISTS `tipo_telefono`;
CREATE TABLE IF NOT EXISTS `tipo_telefono` (
  `cod_tipo_tel` int(10) NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`cod_tipo_tel`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipo_telefono`
--

INSERT INTO `tipo_telefono` (`cod_tipo_tel`, `Descripcion`) VALUES
(1, 'EMPRESA'),
(2, 'Celular');

-- --------------------------------------------------------

--
-- Table structure for table `unidad`
--

DROP TABLE IF EXISTS `unidad`;
CREATE TABLE IF NOT EXISTS `unidad` (
  `coduni` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`coduni`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `unidad`
--

INSERT INTO `unidad` (`coduni`, `descripcion`) VALUES
(1, 'Botella'),
(2, 'Galón'),
(3, 'Ml'),
(4, 'Litro'),
(5, '500g'),
(6, 'Kg'),
(7, 'Saco'),
(8, 'Libras');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `nickname` varchar(20) NOT NULL,
  `contrasena` varchar(20) NOT NULL,
  `tipoacceso` int(11) NOT NULL,
  `codusuario` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`codusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`nickname`, `contrasena`, `tipoacceso`, `codusuario`) VALUES
('admin', '1234', 0, 1),
('felix', '123', 1, 2),
('lacuero95', '69', 0, 3),
('rodolfo22', '123456', 0, 5),
('rodolfo', '1234', 0, 6);

-- --------------------------------------------------------

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
CREATE TABLE IF NOT EXISTS `vehiculo` (
  `codvehiculo` int(11) NOT NULL AUTO_INCREMENT,
  `tipovehiculo` int(11) NOT NULL,
  `disponibilidad` tinyint(1) NOT NULL,
  `matricula` varchar(8) NOT NULL,
  PRIMARY KEY (`codvehiculo`),
  KEY `fk_vehiculo_tipvehi` (`tipovehiculo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehiculo`
--

INSERT INTO `vehiculo` (`codvehiculo`, `tipovehiculo`, `disponibilidad`, `matricula`) VALUES
(1, 1, 1, 'GB3455'),
(2, 2, 1, 'CD3243'),
(3, 2, 1, 'CD3245'),
(4, 4, 0, 'IS3455');

-- --------------------------------------------------------

--
-- Stand-in structure for view `ver_direccion`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `ver_direccion`;
CREATE TABLE IF NOT EXISTS `ver_direccion` (
`Codigo` int(10)
,`Region` varchar(20)
,`Provincia` varchar(50)
,`Municipio` varchar(50)
,`Sector` varchar(50)
,`Calle` varchar(40)
,`referencia` varchar(100)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `ver_puesto_actividad`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `ver_puesto_actividad`;
CREATE TABLE IF NOT EXISTS `ver_puesto_actividad` (
`puesto` varchar(100)
,`Actividad` varchar(100)
);

-- --------------------------------------------------------

--
-- Structure for view `ver_direccion`
--
DROP TABLE IF EXISTS `ver_direccion`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `ver_direccion`  AS  select `d`.`coddir` AS `Codigo`,`r`.`descripcion` AS `Region`,`p`.`descripcion` AS `Provincia`,`m`.`descripcion` AS `Municipio`,`s`.`descripcion` AS `Sector`,`c`.`descripcion` AS `Calle`,`d`.`Descripcion` AS `referencia` from (((((`direccion` `d` join `region` `r` on((`d`.`codreg` = `r`.`codreg`))) join `provincia` `p` on((`d`.`codprovi` = `p`.`codprovi`))) join `municipio` `m` on((`d`.`codmuni` = `m`.`codmuni`))) join `sector` `s` on((`d`.`codsec` = `s`.`codsec`))) join `calle` `c` on((`d`.`codcalle` = `c`.`codcalle`))) ;

-- --------------------------------------------------------

--
-- Structure for view `ver_puesto_actividad`
--
DROP TABLE IF EXISTS `ver_puesto_actividad`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `ver_puesto_actividad`  AS  select `tp`.`descripcion` AS `puesto`,`a`.`descripcion` AS `Actividad` from ((`actividadvstipoempleado` `vs` join `actividad` `a` on((`vs`.`codacti` = `a`.`codactiv`))) join `tipo_de_empleado` `tp` on((`vs`.`codtipoemp` = `tp`.`codtipoemp`))) order by `a`.`descripcion` ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `actividadvsproduccionvsempleado`
--
ALTER TABLE `actividadvsproduccionvsempleado`
  ADD CONSTRAINT `actividadvsproduccion_ibfk_1` FOREIGN KEY (`codactiv`) REFERENCES `actividad` (`codactiv`),
  ADD CONSTRAINT `actividadvsproduccion_ibfk_2` FOREIGN KEY (`codproduccion`) REFERENCES `produccion` (`codproduccion`),
  ADD CONSTRAINT `actividadvsproduccion_ibfk_3` FOREIGN KEY (`codemp`) REFERENCES `empleado` (`codemp`);

--
-- Constraints for table `actividadvstipoempleado`
--
ALTER TABLE `actividadvstipoempleado`
  ADD CONSTRAINT `actividadvstipoempleado_ibfk_1` FOREIGN KEY (`codacti`) REFERENCES `actividad` (`codactiv`),
  ADD CONSTRAINT `actividadvstipoempleado_ibfk_2` FOREIGN KEY (`codtipoemp`) REFERENCES `tipo_de_empleado` (`codtipoemp`);

--
-- Constraints for table `calle`
--
ALTER TABLE `calle`
  ADD CONSTRAINT `calle_ibfk_1` FOREIGN KEY (`codsec`) REFERENCES `sector` (`codsec`);

--
-- Constraints for table `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`codper`) REFERENCES `persona` (`codper`),
  ADD CONSTRAINT `cliente_ibfk_2` FOREIGN KEY (`codtel`) REFERENCES `telefono` (`codtel`);

--
-- Constraints for table `composicion_producto`
--
ALTER TABLE `composicion_producto`
  ADD CONSTRAINT `composicion_producto_ibfk_1` FOREIGN KEY (`codproduccion`) REFERENCES `produccion` (`codproduccion`),
  ADD CONSTRAINT `fk_composicion_materiaprima` FOREIGN KEY (`codmateriap`) REFERENCES `materia_prima` (`codmateriap`),
  ADD CONSTRAINT `fk_composicion_unidad` FOREIGN KEY (`coduni`) REFERENCES `unidad` (`coduni`);

--
-- Constraints for table `cuota`
--
ALTER TABLE `cuota`
  ADD CONSTRAINT `cuota_ibfk_1` FOREIGN KEY (`numfact`) REFERENCES `factura` (`numfact`);

--
-- Constraints for table `detalle_factura`
--
ALTER TABLE `detalle_factura`
  ADD CONSTRAINT `fk_detallefac_factura` FOREIGN KEY (`numfact`) REFERENCES `factura` (`numfact`),
  ADD CONSTRAINT `fk_detallefac_producto` FOREIGN KEY (`codprod`) REFERENCES `producto` (`codproducto`),
  ADD CONSTRAINT `fk_detallefac_unidad` FOREIGN KEY (`coduni`) REFERENCES `unidad` (`coduni`);

--
-- Constraints for table `direccion`
--
ALTER TABLE `direccion`
  ADD CONSTRAINT `direccion_ibfk_1` FOREIGN KEY (`codreg`) REFERENCES `region` (`codreg`),
  ADD CONSTRAINT `direccion_ibfk_2` FOREIGN KEY (`codprovi`) REFERENCES `provincia` (`codprovi`),
  ADD CONSTRAINT `direccion_ibfk_3` FOREIGN KEY (`codmuni`) REFERENCES `municipio` (`codmuni`),
  ADD CONSTRAINT `direccion_ibfk_4` FOREIGN KEY (`codsec`) REFERENCES `sector` (`codsec`),
  ADD CONSTRAINT `direccion_ibfk_5` FOREIGN KEY (`codcalle`) REFERENCES `calle` (`codcalle`);

--
-- Constraints for table `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`codper`) REFERENCES `persona` (`codper`),
  ADD CONSTRAINT `fk_empleado_horario` FOREIGN KEY (`horario`) REFERENCES `horario` (`codhorario`),
  ADD CONSTRAINT `fk_empleado_telefono` FOREIGN KEY (`codtel`) REFERENCES `telefono` (`codtel`),
  ADD CONSTRAINT `fk_empleado_tipemp` FOREIGN KEY (`codtipoemp`) REFERENCES `tipo_de_empleado` (`codtipoemp`),
  ADD CONSTRAINT `fk_empleado_usuario` FOREIGN KEY (`codusuario`) REFERENCES `usuario` (`codusuario`);

--
-- Constraints for table `especie`
--
ALTER TABLE `especie`
  ADD CONSTRAINT `fk_planta_especie` FOREIGN KEY (`codplant`) REFERENCES `planta` (`codplant`);

--
-- Constraints for table `especievsenfermedad`
--
ALTER TABLE `especievsenfermedad`
  ADD CONSTRAINT `fk_especievsenfer_enfer` FOREIGN KEY (`codenfer`) REFERENCES `enfermedad` (`codenfer`),
  ADD CONSTRAINT `fk_especievsenfer_especie` FOREIGN KEY (`codespecie`) REFERENCES `especie` (`codespecie`);

--
-- Constraints for table `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `fk_factura_cliente` FOREIGN KEY (`codcli`) REFERENCES `cliente` (`codclie`);

--
-- Constraints for table `horario`
--
ALTER TABLE `horario`
  ADD CONSTRAINT `horario_ibfk_1` FOREIGN KEY (`tipo_horario`) REFERENCES `tipo_horario` (`codtipohor`);

--
-- Constraints for table `materiaprimavsunidad`
--
ALTER TABLE `materiaprimavsunidad`
  ADD CONSTRAINT `fk_materiapvsuni_materia` FOREIGN KEY (`codmateria`) REFERENCES `materia_prima` (`codmateriap`),
  ADD CONSTRAINT `fk_materiapvsuni_unidad` FOREIGN KEY (`coduni`) REFERENCES `unidad` (`coduni`);

--
-- Constraints for table `materia_prima`
--
ALTER TABLE `materia_prima`
  ADD CONSTRAINT `fk_materiaprima_proveedor` FOREIGN KEY (`codprov`) REFERENCES `proveedor` (`codproveedor`);

--
-- Constraints for table `municipio`
--
ALTER TABLE `municipio`
  ADD CONSTRAINT `municipio_ibfk_1` FOREIGN KEY (`codprovi`) REFERENCES `provincia` (`codprovi`);

--
-- Constraints for table `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `fk_pedido_direccion` FOREIGN KEY (`coddir`) REFERENCES `direccion` (`coddir`),
  ADD CONSTRAINT `fk_pedido_empleado` FOREIGN KEY (`codemp`) REFERENCES `empleado` (`codemp`),
  ADD CONSTRAINT `fk_pedido_factura` FOREIGN KEY (`numfact`) REFERENCES `factura` (`numfact`),
  ADD CONSTRAINT `fk_pedido_vehiculo` FOREIGN KEY (`codvehiculo`) REFERENCES `vehiculo` (`codvehiculo`);

--
-- Constraints for table `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `persona_ibfk_2` FOREIGN KEY (`coddocu`) REFERENCES `documento` (`coddocu`),
  ADD CONSTRAINT `persona_ibfk_3` FOREIGN KEY (`coddir`) REFERENCES `direccion` (`coddir`);

--
-- Constraints for table `produccion`
--
ALTER TABLE `produccion`
  ADD CONSTRAINT `fk_producto_produccion` FOREIGN KEY (`codprod`) REFERENCES `producto` (`codproducto`),
  ADD CONSTRAINT `fk_uni_pro` FOREIGN KEY (`cod_uni`) REFERENCES `unidad` (`coduni`);

--
-- Constraints for table `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fk_producto_proveedor` FOREIGN KEY (`codprov`) REFERENCES `proveedor` (`codproveedor`),
  ADD CONSTRAINT `fk_producto_tipoprod` FOREIGN KEY (`tipoprod`) REFERENCES `tipo_de_producto` (`codtipopro`);

--
-- Constraints for table `productovsefermedad`
--
ALTER TABLE `productovsefermedad`
  ADD CONSTRAINT `fk_prodvsenfer_enfermedad` FOREIGN KEY (`codenfer`) REFERENCES `enfermedad` (`codenfer`),
  ADD CONSTRAINT `fk_prodvsenfer_especie` FOREIGN KEY (`codespecie`) REFERENCES `especie` (`codespecie`),
  ADD CONSTRAINT `fk_prodvsenfer_planta` FOREIGN KEY (`codplant`) REFERENCES `planta` (`codplant`),
  ADD CONSTRAINT `fk_prodvsenfer_producto` FOREIGN KEY (`codprod`) REFERENCES `producto` (`codproducto`),
  ADD CONSTRAINT `fk_prodvsenfer_tipsuelo` FOREIGN KEY (`codsuelo`) REFERENCES `tipo_de_suelo` (`codsuelo`),
  ADD CONSTRAINT `fk_prodvsenfer_unidad` FOREIGN KEY (`coduni`) REFERENCES `unidad` (`coduni`);

--
-- Constraints for table `productovsunidad`
--
ALTER TABLE `productovsunidad`
  ADD CONSTRAINT `fk_prodvsuni_producto` FOREIGN KEY (`codproducto`) REFERENCES `producto` (`codproducto`),
  ADD CONSTRAINT `fk_prodvsuni_unidad` FOREIGN KEY (`coduni`) REFERENCES `unidad` (`coduni`);

--
-- Constraints for table `proveedor`
--
ALTER TABLE `proveedor`
  ADD CONSTRAINT `fk_proveedor_persona` FOREIGN KEY (`codper`) REFERENCES `persona` (`codper`),
  ADD CONSTRAINT `fk_proveedor_telefono` FOREIGN KEY (`codtelefono`) REFERENCES `telefono` (`codtel`);

--
-- Constraints for table `provincia`
--
ALTER TABLE `provincia`
  ADD CONSTRAINT `provincia_ibfk_1` FOREIGN KEY (`codreg`) REFERENCES `region` (`codreg`);

--
-- Constraints for table `recibo`
--
ALTER TABLE `recibo`
  ADD CONSTRAINT `recibo_ibfk_1` FOREIGN KEY (`numfact`) REFERENCES `factura` (`numfact`);

--
-- Constraints for table `sector`
--
ALTER TABLE `sector`
  ADD CONSTRAINT `sector_ibfk_1` FOREIGN KEY (`codmuni`) REFERENCES `municipio` (`codmuni`);

--
-- Constraints for table `telefono`
--
ALTER TABLE `telefono`
  ADD CONSTRAINT `telefono_ibfk_1` FOREIGN KEY (`codtipotel`) REFERENCES `tipo_telefono` (`cod_tipo_tel`);

--
-- Constraints for table `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD CONSTRAINT `fk_vehiculo_tipvehi` FOREIGN KEY (`tipovehiculo`) REFERENCES `tipo_de_vehiculo` (`codtipvehiculo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
