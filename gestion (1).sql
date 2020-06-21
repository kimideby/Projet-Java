-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  Dim 01 mars 2020 à 19:00
-- Version du serveur :  10.1.26-MariaDB
-- Version de PHP :  7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestion`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(100) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `age` int(100) NOT NULL,
  `date_naiss` varchar(100) NOT NULL,
  `lieu_naiss` varchar(100) NOT NULL,
  `genre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id_admin`, `nom`, `prenom`, `age`, `date_naiss`, `lieu_naiss`, `genre`) VALUES
(1, 'admin', 'admin', 30, '2010-01-26', 'pointe-noire', 'masculin'),
(2, 'ITHEM', 'Leo', 21, '12/05/1999', 'cap vert', 'masculin');

-- --------------------------------------------------------

--
-- Structure de la table `bus`
--

CREATE TABLE `bus` (
  `id_bus` int(100) NOT NULL,
  `id_trajet` int(11) NOT NULL,
  `matriculation` varchar(100) NOT NULL,
  `ligne_bus` int(100) NOT NULL,
  `nom_parking` varchar(100) NOT NULL,
  `etat_bus` varchar(50) NOT NULL,
  `telephone` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `bus`
--

INSERT INTO `bus` (`id_bus`, `id_trajet`, `matriculation`, `ligne_bus`, `nom_parking`, `etat_bus`, `telephone`) VALUES
(1, 1, 'dxfbkj86874646', 45, 'liberté 6', 'en reparation', ''),
(2, 1, '4685DK', 34, 'Terminus', 'en fonctionnement', ''),
(3, 1, '7896TH', 42, 'Pikine', 'En fonctionnement', ''),
(4, 1, 'A2ZA', 23, 'FASS', 'En fonctionnement', ''),
(6, 2, 'TH209', 12, 'Thies', 'En reparation', ''),
(7, 3, '7896KL', 69, 'Guedio', 'En reparation', ''),
(8, 2, '78532KD', 74, 'Blaise Diagne', 'En fonctionnement', '');

-- --------------------------------------------------------

--
-- Structure de la table `chauffeur`
--

CREATE TABLE `chauffeur` (
  `idChauf` int(11) NOT NULL,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `chauffeur`
--

INSERT INTO `chauffeur` (`idChauf`, `nom`, `prenom`, `adresse`, `email`, `telephone`) VALUES
(3, 'Ka', 'Mamadou', 'Point E', 'mams@ka.com', '774562389'),
(4, 'Diop', 'Issa', 'Dakar', 'issa@icloud.com', ''),
(5, 'Ba', 'Amadou', 'Scat Urbam', 'ba@amadu.sn', ''),
(6, 'Gaye', 'Moustapha', 'Thiaroye', 'moustapha@gmail.com', '774552318');

-- --------------------------------------------------------

--
-- Structure de la table `recette`
--

CREATE TABLE `recette` (
  `id` int(11) NOT NULL,
  `montant` varchar(200) NOT NULL,
  `date` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `recette`
--

INSERT INTO `recette` (`id`, `montant`, `date`) VALUES
(3, '14650', '26/01/19'),
(4, '100', '29/02/2020'),
(5, '4800', '16/12/19'),
(6, '16500', '17/04/19'),
(7, '4500', '14/20/19'),
(8, '1450', '10/12/19'),
(9, '45000', '25/juin/2019'),
(10, '45522', '02/04/1999');

-- --------------------------------------------------------

--
-- Structure de la table `trajet`
--

CREATE TABLE `trajet` (
  `id_trajet` int(11) NOT NULL,
  `source` varchar(100) NOT NULL,
  `destination` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `trajet`
--

INSERT INTO `trajet` (`id_trajet`, `source`, `destination`) VALUES
(1, 'Nord Foire', 'Nord Foire'),
(2, 'thies', 'dakar'),
(3, 'Pikine', 'Rufisque'),
(4, 'Ouest Foire', 'Point E '),
(6, 'Liberte 6', 'Sandaga');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `idUser` int(100) NOT NULL,
  `login` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`idUser`, `login`, `password`, `role`) VALUES
(1, 'admin', 'admin', 'admin'),
(3, 'kiminou', '1234', 'chauffeur'),
(4, 'aquila1', 'aquila', 'chauffeur'),
(5, 'telima', 'telima', 'chauffeur'),
(6, 'Julio', 'julio', 'chauffeur');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Index pour la table `bus`
--
ALTER TABLE `bus`
  ADD PRIMARY KEY (`id_bus`),
  ADD KEY `id_trajet` (`id_trajet`);

--
-- Index pour la table `chauffeur`
--
ALTER TABLE `chauffeur`
  ADD PRIMARY KEY (`idChauf`);

--
-- Index pour la table `recette`
--
ALTER TABLE `recette`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `trajet`
--
ALTER TABLE `trajet`
  ADD PRIMARY KEY (`id_trajet`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `bus`
--
ALTER TABLE `bus`
  MODIFY `id_bus` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `chauffeur`
--
ALTER TABLE `chauffeur`
  MODIFY `idChauf` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `recette`
--
ALTER TABLE `recette`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `trajet`
--
ALTER TABLE `trajet`
  MODIFY `id_trajet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `bus`
--
ALTER TABLE `bus`
  ADD CONSTRAINT `fk_idTrajet` FOREIGN KEY (`id_trajet`) REFERENCES `trajet` (`id_trajet`);

--
-- Contraintes pour la table `trajet`
--
ALTER TABLE `trajet`
  ADD CONSTRAINT `trajet_ibfk_1` FOREIGN KEY (`id_trajet`) REFERENCES `bus` (`id_bus`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
