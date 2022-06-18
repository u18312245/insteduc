-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-06-2022 a las 05:41:03
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `insteduc`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `idAdmin` varchar(12) NOT NULL,
  `nombres` varchar(30) NOT NULL,
  `ApePaterno` varchar(30) NOT NULL,
  `ApeMaterno` varchar(30) NOT NULL,
  `FechaNac` date NOT NULL,
  `Celular` int(11) NOT NULL,
  `Correo` varchar(30) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Sexo` varchar(30) NOT NULL,
  `Departamento` varchar(30) NOT NULL,
  `Distrito` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`idAdmin`, `nombres`, `ApePaterno`, `ApeMaterno`, `FechaNac`, `Celular`, `Correo`, `Direccion`, `Sexo`, `Departamento`, `Distrito`) VALUES
('0', '0', '0', '0', '0000-00-00', 0, '0', '0', '0', '0', '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrativo`
--

CREATE TABLE `administrativo` (
  `idAdministrativo` varchar(12) NOT NULL,
  `nombres` varchar(30) NOT NULL,
  `ApePaterno` varchar(30) NOT NULL,
  `ApeMaterno` varchar(30) NOT NULL,
  `FechaNac` date NOT NULL,
  `Celular` int(11) NOT NULL,
  `Correo` varchar(30) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Sexo` varchar(10) NOT NULL,
  `Departamento` varchar(30) NOT NULL,
  `Distrito` varchar(30) NOT NULL,
  `Cargo` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `administrativo`
--

INSERT INTO `administrativo` (`idAdministrativo`, `nombres`, `ApePaterno`, `ApeMaterno`, `FechaNac`, `Celular`, `Correo`, `Direccion`, `Sexo`, `Departamento`, `Distrito`, `Cargo`) VALUES
('1', 'WALTER', 'GUEVARA', 'NAJARRO', '1984-04-17', 987203237, 'wrguevara@gmail.com', 'AV. LAS FLORES DE PRIMAVERA 1711', 'MASCULINO', 'LIMA', 'LIMA', 'DIRECTOR');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--

CREATE TABLE `asistencia` (
  `idAsistencia` varchar(12) NOT NULL,
  `idDocente` varchar(12) NOT NULL,
  `idAdministrativo` varchar(12) NOT NULL,
  `idCurso` varchar(12) NOT NULL,
  `idGrado` varchar(12) NOT NULL,
  `fecha` date NOT NULL,
  `hora` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciclo`
--

CREATE TABLE `ciclo` (
  `idCiclo` varchar(12) NOT NULL,
  `Ciclo` varchar(12) NOT NULL,
  `Descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ciclo`
--

INSERT INTO `ciclo` (`idCiclo`, `Ciclo`, `Descripcion`) VALUES
('1', 'I', 'Ciclo I');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `idCurso` varchar(12) NOT NULL,
  `nomCurso` varchar(30) NOT NULL,
  `descripCurso` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`idCurso`, `nomCurso`, `descripCurso`) VALUES
('1', 'PERSONAL SOCIAL', ''),
('2', 'COMUNICACION', 'CURSO DE LETRAS'),
('3', 'LOGICO MATEMATICO', 'NUMEROS'),
('4', 'CIENCIA Y AMBIENTE', 'CIENCIA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso_competencia`
--

CREATE TABLE `curso_competencia` (
  `idCursoCompe` varchar(12) NOT NULL,
  `idCurso` varchar(12) NOT NULL,
  `competencia` varchar(200) NOT NULL,
  `detalle_competencia` varchar(200) DEFAULT NULL,
  `idCiclo` varchar(12) DEFAULT NULL,
  `idGrado` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `curso_competencia`
--

INSERT INTO `curso_competencia` (`idCursoCompe`, `idCurso`, `competencia`, `detalle_competencia`, `idCiclo`, `idGrado`) VALUES
('1', '1', 'Construye su identidad', 'Se valora a sí mismo', '1', '1'),
('2', '1', 'Construye su identidad', 'Autorregula sus emociones', '1', '1'),
('3', '1', 'Construye su identidad', 'Reflexiona y argumenta éticamente', '1', '1'),
('4', '1', 'Construye su identidad', 'Vive su sexualidad de manera plena y responsable', '1', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso_docente`
--

CREATE TABLE `curso_docente` (
  `idDetCurso` varchar(12) NOT NULL,
  `idCurso` varchar(12) NOT NULL,
  `idDocente` varchar(12) NOT NULL,
  `idGrado` varchar(12) NOT NULL,
  `idSeccion` varchar(12) NOT NULL,
  `idPeriodo` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `curso_docente`
--

INSERT INTO `curso_docente` (`idDetCurso`, `idCurso`, `idDocente`, `idGrado`, `idSeccion`, `idPeriodo`) VALUES
('1', '1', '1', '1', '1', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso_estudiante`
--

CREATE TABLE `curso_estudiante` (
  `idCursoEst` varchar(12) NOT NULL,
  `idCurso` varchar(12) NOT NULL,
  `idEstudiante` varchar(12) NOT NULL,
  `idGrado` varchar(12) NOT NULL,
  `idSeccion` varchar(12) NOT NULL,
  `idPeriodo` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `curso_estudiante`
--

INSERT INTO `curso_estudiante` (`idCursoEst`, `idCurso`, `idEstudiante`, `idGrado`, `idSeccion`, `idPeriodo`) VALUES
('1', '1', '1', '1', '1', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_evaluacion`
--

CREATE TABLE `detalle_evaluacion` (
  `idDetEva` varchar(12) NOT NULL,
  `idGrado` varchar(12) NOT NULL,
  `idSeccion` varchar(12) NOT NULL,
  `idDocente` varchar(12) NOT NULL,
  `idEstudiante` varchar(12) NOT NULL,
  `idPeriodo` varchar(12) NOT NULL,
  `idCursoCompe` varchar(12) NOT NULL,
  `idCurso` varchar(12) NOT NULL,
  `Nota` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalle_evaluacion`
--

INSERT INTO `detalle_evaluacion` (`idDetEva`, `idGrado`, `idSeccion`, `idDocente`, `idEstudiante`, `idPeriodo`, `idCursoCompe`, `idCurso`, `Nota`) VALUES
('1', '1', '1', '1', '1', '1', '1', '1', 'A'),
('2', '1', '1', '1', '1', '1', '2', '1', 'B');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docente`
--

CREATE TABLE `docente` (
  `idDcoente` varchar(12) NOT NULL,
  `nombres` varchar(30) NOT NULL,
  `ApePaterno` varchar(30) NOT NULL,
  `ApeMaterno` varchar(30) NOT NULL,
  `FechaNac` date NOT NULL,
  `Celular` int(11) NOT NULL,
  `Correo` varchar(30) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Sexo` varchar(10) NOT NULL,
  `Departamento` varchar(30) NOT NULL,
  `Distrito` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `docente`
--

INSERT INTO `docente` (`idDcoente`, `nombres`, `ApePaterno`, `ApeMaterno`, `FechaNac`, `Celular`, `Correo`, `Direccion`, `Sexo`, `Departamento`, `Distrito`) VALUES
('1', 'JAIME DOCENTE 1', 'QUISPE', 'MAMANI', '1970-01-01', 999666333, 'DOCENTE1@GMAIL.COM', 'TANGAMANDAPIO 1', 'MASCULINO', 'APURIMAC', 'ANCO HUALLO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE `estudiante` (
  `idEstudiante` varchar(12) NOT NULL,
  `nombres` varchar(30) NOT NULL,
  `ApePaterno` varchar(30) NOT NULL,
  `ApeMaterno` varchar(30) NOT NULL,
  `FechaNac` date NOT NULL,
  `Celular` int(11) NOT NULL,
  `Correo` varchar(30) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Sexo` varchar(10) NOT NULL,
  `Departamento` varchar(30) NOT NULL,
  `Distrito` varchar(30) NOT NULL,
  `TipoDocumento` varchar(10) NOT NULL,
  `NroDocIdent` varchar(12) NOT NULL,
  `DniPadre` int(12) NOT NULL,
  `nombrePadre` varchar(30) NOT NULL,
  `apellidosPadre` varchar(30) NOT NULL,
  `CeluPadre` int(11) NOT NULL,
  `DniMadre` int(12) NOT NULL,
  `nombreMadre` varchar(30) NOT NULL,
  `apellidosMadre` varchar(30) NOT NULL,
  `CeluMadre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`idEstudiante`, `nombres`, `ApePaterno`, `ApeMaterno`, `FechaNac`, `Celular`, `Correo`, `Direccion`, `Sexo`, `Departamento`, `Distrito`, `TipoDocumento`, `NroDocIdent`, `DniPadre`, `nombrePadre`, `apellidosPadre`, `CeluPadre`, `DniMadre`, `nombreMadre`, `apellidosMadre`, `CeluMadre`) VALUES
('1', 'JONATHAN', 'MAICELO', 'CANEVO', '2009-07-07', 999666333, '', 'AV. EL PORVENIR 1555', 'MASCULINO', 'APURIMAC', 'ANCO HUALLO', 'DNI', '12345678', 11223344, 'EUSIBIO', 'MAICELO GRADOS', 998877665, 42222226, 'URSULA', 'QUISPE MORE', 996633214);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grado`
--

CREATE TABLE `grado` (
  `idGrado` varchar(12) NOT NULL,
  `NombreGrado` varchar(20) NOT NULL,
  `DescrpGrado` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `grado`
--

INSERT INTO `grado` (`idGrado`, `NombreGrado`, `DescrpGrado`) VALUES
('1', '1', 'PRIMER GRADO'),
('2', '2', 'SEGUNDO GRADO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inst_educativa`
--

CREATE TABLE `inst_educativa` (
  `CodModular` int(12) NOT NULL,
  `NombreIE` varchar(40) NOT NULL,
  `Departamento` varchar(30) NOT NULL,
  `Distrito` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matricula`
--

CREATE TABLE `matricula` (
  `idMatricula` varchar(12) NOT NULL,
  `idEstudiante` varchar(12) NOT NULL,
  `IdGrado` varchar(12) NOT NULL,
  `idSeccion` varchar(12) NOT NULL,
  `idPeriodo` varchar(12) NOT NULL,
  `FechaMatricula` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `matricula`
--

INSERT INTO `matricula` (`idMatricula`, `idEstudiante`, `IdGrado`, `idSeccion`, `idPeriodo`, `FechaMatricula`) VALUES
('1', '1', '1', '1', '1', '2022-05-31');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `periodo`
--

CREATE TABLE `periodo` (
  `idPeriodo` varchar(12) NOT NULL,
  `TipoPeriodo` varchar(30) NOT NULL,
  `Anio` int(12) NOT NULL,
  `descripcion` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `periodo`
--

INSERT INTO `periodo` (`idPeriodo`, `TipoPeriodo`, `Anio`, `descripcion`) VALUES
('1', '2022-1', 2022, 'BIMESTRE 1'),
('2', '2022-2', 2022, 'BIMESTRE 2'),
('3', '2022-3', 2022, 'BIMESTRE 3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seccion`
--

CREATE TABLE `seccion` (
  `idSeccion` varchar(12) NOT NULL,
  `NombreSec` varchar(20) NOT NULL,
  `Descripcion` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `seccion`
--

INSERT INTO `seccion` (`idSeccion`, `NombreSec`, `Descripcion`) VALUES
('1', 'A', 'PRIMERA SECCION');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_documento`
--

CREATE TABLE `tipo_documento` (
  `idTipoDoc` int(12) NOT NULL,
  `NombreDocumento` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_documento`
--

INSERT INTO `tipo_documento` (`idTipoDoc`, `NombreDocumento`) VALUES
(1, 'DNI'),
(2, 'Pasaporte');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrativo`
--
ALTER TABLE `administrativo`
  ADD PRIMARY KEY (`idAdministrativo`);

--
-- Indices de la tabla `ciclo`
--
ALTER TABLE `ciclo`
  ADD PRIMARY KEY (`idCiclo`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`idCurso`);

--
-- Indices de la tabla `curso_competencia`
--
ALTER TABLE `curso_competencia`
  ADD PRIMARY KEY (`idCursoCompe`);

--
-- Indices de la tabla `curso_docente`
--
ALTER TABLE `curso_docente`
  ADD PRIMARY KEY (`idDetCurso`);

--
-- Indices de la tabla `curso_estudiante`
--
ALTER TABLE `curso_estudiante`
  ADD PRIMARY KEY (`idCursoEst`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`idEstudiante`);

--
-- Indices de la tabla `grado`
--
ALTER TABLE `grado`
  ADD PRIMARY KEY (`idGrado`);

--
-- Indices de la tabla `periodo`
--
ALTER TABLE `periodo`
  ADD PRIMARY KEY (`idPeriodo`);

--
-- Indices de la tabla `seccion`
--
ALTER TABLE `seccion`
  ADD PRIMARY KEY (`idSeccion`);

--
-- Indices de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  ADD PRIMARY KEY (`idTipoDoc`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
