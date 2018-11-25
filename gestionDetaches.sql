-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 23, 2018 at 03:44 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestionDetaches`
--

-- --------------------------------------------------------

--
-- Table structure for table `assignation`
--

CREATE TABLE `assignation` (
  `idTache` int(11) NOT NULL,
  `idMembre` int(11) NOT NULL,
  `dateAssigne` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `assignation`
--

INSERT INTO `assignation` (`idTache`, `idMembre`, `dateAssigne`) VALUES
(1, 2, '2018-11-19'),
(2, 2, '2018-11-20'),
(3, 3, '2018-11-20'),
(4, 4, '2018-11-20'),
(7, 7, '2018-11-20');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `idMembre` int(11) NOT NULL,
  `login` varchar(25) NOT NULL,
  `motDePasse` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`idMembre`, `login`, `motDePasse`) VALUES
(1, 'admin', '123456'),
(2, 'espoir@hotmail.fr', '123456'),
(3, 'fiston@hotmail.fr', '123456'),
(4, 'gaston@hotmail.fr', '123456'),
(5, 'christian@hotmail.com', '123456'),
(6, 'bafunyembaka@hotmail.com', '123456'),
(7, 'magnifique@hotmail.com', '123456'),
(8, 'mireille@hotmail.fr', '123456'),
(9, 'batumike@gmail.com', '123456'),
(10, 'gaspard@hotmail.com', '123456'),
(11, 'edg@hotmail.fr', '123456'),
(12, 'ema@hotmail.fr', '123456'),
(13, 'essai@hotmail.fr', '123456'),
(14, 'gustava@gmail.com', '123456'),
(15, 'emmanuel@hotmail.com', '123456'),
(16, 'gustave', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `membre`
--

CREATE TABLE `membre` (
  `id` int(11) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `tel` varchar(50) NOT NULL,
  `email` varchar(25) NOT NULL,
  `type` varchar(25) NOT NULL,
  `etat` int(11) NOT NULL DEFAULT '1',
  `lastEdit` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `membre`
--

INSERT INTO `membre` (`id`, `nom`, `prenom`, `adresse`, `tel`, `email`, `type`, `etat`, `lastEdit`) VALUES
(1, 'Admin', 'Admin', 'My Dinh II, KTX DN 1 FLOOR 19 Room 1910', '+84356554309', 'admin@hotmail', 'Chef d\'Equipe', 1, '2018-11-12 20:14:00'),
(2, 'Espoir', 'Espoir', 'KTX METRE ', '+84125785241', 'espoir@hotmail.fr', 'Membre', 1, '2018-11-18 08:58:17'),
(3, 'Fiston', 'Fiston', 'Hanoi', '+8452416385', 'fiston@hotmail.fr', 'Membre', 1, '2018-11-17 14:43:49'),
(4, 'Gaston', 'Gaston', 'Ha noi', '+857451263', 'gaston@hotmail.fr', 'Membre', 1, '2018-11-15 10:49:04'),
(5, 'Christian', 'Christian', 'Hanoi', '+8451275411', 'christian@hotmail.com', 'Membre', 1, '2018-11-15 10:54:44'),
(6, 'BAFUNYEMBAKA', 'CRISPIN CRISPIN', 'KTX MY DINH II', '+25478411447785', 'bafunyembaka@hotmail.com', 'Membre', 1, '2018-11-20 18:26:07'),
(7, 'MAGNIFIQUE', 'ANTOINETTE', 'KTX MY DINH', '+874521963250', 'magnifique@hotmail.com', 'Membre', 0, '2018-11-17 14:44:02'),
(8, 'MIRIELLE', 'MIRIELLE', 'KTX ME TRI', '+84751263', 'mireille@hotmail.fr', 'Chef d\'Equipe', 0, '2018-11-20 18:26:40'),
(9, 'BATUMIKE', 'BATUMIKE', 'Hoch Minh City', '+8452758965332', 'batumike@gmail.com', 'Administrateur', 1, '2018-11-17 20:41:18'),
(10, 'GASPARD', 'GERARD', 'KTX MY DINH', '+8475126395', 'gaspard@hotmail.com', 'Membre', 1, '2018-11-20 18:25:52'),
(11, 'Edgar', 'Benoit', 'KTX MY DINH', '+8475126395', 'edg@hotmail.fr', 'Chef d\'Equipe', 1, '2018-11-20 18:25:30'),
(12, 'FABIEN', 'EMMANUEL', 'KTX MY DINH', '+854715263214', 'ema@hotmail.fr', 'Chef d\'Equipe', 1, '2018-11-20 18:27:12'),
(13, 'ESSAI', 'BELLEVUE', 'KTX METRI', '+84517485', 'essai@hotmail.fr', 'Membre', 1, '2018-11-20 18:02:05'),
(14, 'GUSTAVE', 'GUSTAVE', 'KTX MY DINH', '+84254784512', 'gustava@gmail.com', 'Chef d\'Equipe', 1, '2018-11-20 18:46:50'),
(15, 'Emmanuel', 'Saulu', 'KTX METRI', '+841257485412', 'emmanuel@hotmail.com', 'Membre', 1, '2018-11-23 21:14:39'),
(16, 'Kayembe', 'Gustave', 'KTX METRI', '+845217', 'gustave@hotmail.fr', 'Chef d\'Equipe', 1, '2018-11-23 21:19:20');

-- --------------------------------------------------------

--
-- Table structure for table `tache`
--

CREATE TABLE `tache` (
  `id` int(11) NOT NULL,
  `designation` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `etat` varchar(50) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tache`
--

INSERT INTO `tache` (`id`, `designation`, `description`, `dateDebut`, `dateFin`, `etat`) VALUES
(1, 'Mise en oeuvre d\'un projet', 'La mise en oeuvre d\'un projet, va consisté première de la recolte de données en suit le tri et enfin l\'utilisation de ces données dans les projets de la socité', '2018-11-18', '2018-11-18', 'Initial'),
(2, 'Humaniste', 'Intervention sur le terre en cas de problème', '2018-11-18', '2018-11-18', 'Initial'),
(3, 'Cadastre', 'la cadastre', '2018-11-18', '2018-11-18', 'Initial'),
(4, 'Analyste Programmeur', 'Recherche des données, analyse, conception et implementation ', '2018-11-18', '2018-11-18', 'Initial'),
(5, 'Dispenser le cours', 'Mise en place du programme, constition de la matiere et enseigner l es étudiant', '2018-11-18', '2018-11-18', 'Initial'),
(6, 'Contructeur', 'Conception de plan et leur mis en place', '2018-11-18', '2018-11-18', 'DEL'),
(7, 'Architectes', 'Mise en place de plac', '2018-11-18', '2018-11-23', 'Initial');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assignation`
--
ALTER TABLE `assignation`
  ADD PRIMARY KEY (`idTache`),
  ADD KEY `fk_assignation_membre` (`idMembre`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`idMembre`);

--
-- Indexes for table `membre`
--
ALTER TABLE `membre`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tache`
--
ALTER TABLE `tache`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_tache_etat` (`etat`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `assignation`
--
ALTER TABLE `assignation`
  ADD CONSTRAINT `fk_assignation_membre` FOREIGN KEY (`idMembre`) REFERENCES `membre` (`id`),
  ADD CONSTRAINT `fk_assignation_tache` FOREIGN KEY (`idTache`) REFERENCES `tache` (`id`);

--
-- Constraints for table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `fk_login_membre` FOREIGN KEY (`idMembre`) REFERENCES `membre` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
