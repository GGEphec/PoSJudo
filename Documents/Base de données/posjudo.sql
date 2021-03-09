-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 09 mars 2021 à 10:20
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `posjudo`
--

-- --------------------------------------------------------

--
-- Structure de la table `argent`
--

CREATE TABLE `argent` (
  `idArgent` int(11) NOT NULL COMMENT 'L''id de l''argent',
  `valeurArgente` double NOT NULL COMMENT 'La valeur de l''argent'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `argent`
--

INSERT INTO `argent` (`idArgent`, `valeurArgente`) VALUES
(1, 0.01),
(2, 0.02),
(5, 0.05),
(10, 0.1),
(20, 0.2),
(50, 0.5),
(100, 1),
(200, 2),
(500, 5),
(1000, 10),
(2000, 20),
(5000, 50),
(10000, 100),
(20000, 200);

-- --------------------------------------------------------

--
-- Structure de la table `commandes`
--

CREATE TABLE `commandes` (
  `idCommande` int(11) NOT NULL COMMENT 'L''id de la commande',
  `heureCommande` date NOT NULL COMMENT 'L''heure de la commande'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `contenucommande`
--

CREATE TABLE `contenucommande` (
  `idCommande` int(11) NOT NULL COMMENT 'L''id référencant la commande',
  `idProduit` int(11) NOT NULL COMMENT 'L''id référencant le produit',
  `nombreProduit` int(11) NOT NULL COMMENT 'Le nombre de fois que le produit a été acheté'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `contenusortie`
--

CREATE TABLE `contenusortie` (
  `idSortie` int(11) NOT NULL COMMENT 'L''id référencant la sortie',
  `idArgent` int(11) NOT NULL COMMENT 'L''id référencant l''argent',
  `nombreArgent` int(11) NOT NULL COMMENT 'Le nombre d''argent sortie'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

CREATE TABLE `produits` (
  `idProduit` int(11) NOT NULL COMMENT 'L''id du produit',
  `prixUnitaireProduit` double NOT NULL COMMENT 'Le prix unitaire du produit',
  `couleurRProduit` int(11) NOT NULL COMMENT 'L''attribut R de la couleur de la touche',
  `couleurGProduit` int(11) NOT NULL COMMENT 'L''attribut G de la couleur de la touche',
  `couleurBProduit` int(11) NOT NULL COMMENT 'L''attribut B de la couleur de la touche',
  `descriptionProduit` varchar(20) NOT NULL COMMENT 'La description du produit'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `produits`
--

INSERT INTO `produits` (`idProduit`, `prixUnitaireProduit`, `couleurRProduit`, `couleurGProduit`, `couleurBProduit`, `descriptionProduit`) VALUES
(11, 1.5, 255, 0, 0, 'Ticket rouge'),
(12, 0, 0, 0, 0, ''),
(13, 2, 0, 0, 255, 'Ticket Bleu'),
(14, 3, 255, 165, 0, 'Ticket orange'),
(15, 2.5, 0, 255, 255, 'Ticket jaune'),
(16, 0, 0, 0, 0, ''),
(21, 1.5, 255, 0, 0, 'Eau plate'),
(22, 2, 0, 0, 255, 'Ice tea'),
(23, 2, 0, 0, 255, 'Kriek'),
(24, 3, 255, 165, 0, 'Chimay bleue'),
(25, 2.5, 0, 255, 255, 'Petit déjeuner'),
(26, 1.5, 255, 0, 0, 'Café'),
(31, 1.5, 255, 0, 0, 'Eau pétillante'),
(32, 0, 0, 0, 0, ''),
(33, 2, 0, 0, 255, 'Blanche'),
(34, 0, 0, 0, 0, ''),
(35, 2.5, 0, 255, 255, 'Sandwich'),
(36, 1.5, 255, 0, 0, 'Chocolat chaud'),
(41, 1.5, 255, 0, 0, 'Coca cola'),
(42, 0, 0, 0, 0, ''),
(43, 2, 0, 0, 255, 'Vin au verre'),
(44, 0, 0, 0, 0, ''),
(45, 2.5, 0, 255, 255, 'Hot Dog'),
(46, 1.5, 255, 0, 0, 'Couque'),
(51, 1.5, 255, 0, 0, 'Coca light'),
(52, 0, 0, 0, 0, ''),
(53, 1.5, 255, 0, 0, 'Pils'),
(54, 0, 0, 0, 0, ''),
(55, 0, 0, 0, 0, ''),
(56, 1.5, 255, 0, 0, 'Chips'),
(61, 1.5, 255, 0, 0, 'Limonade'),
(62, 1.5, 255, 0, 0, 'Jus de fruits'),
(63, 2.5, 0, 255, 255, 'Gouyasse'),
(64, 0, 0, 0, 0, ''),
(65, 0, 0, 0, 0, ''),
(66, 1.5, 255, 0, 0, 'Bonbons');

-- --------------------------------------------------------

--
-- Structure de la table `sorties`
--

CREATE TABLE `sorties` (
  `idSortie` int(11) NOT NULL COMMENT 'L''id de la sortie',
  `heureSortie` date NOT NULL COMMENT 'L''heure de la sortie',
  `responsables` text NOT NULL COMMENT 'Le nom des personnes responsables de la sortie'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `argent`
--
ALTER TABLE `argent`
  ADD PRIMARY KEY (`idArgent`),
  ADD KEY `idArgent` (`idArgent`);

--
-- Index pour la table `commandes`
--
ALTER TABLE `commandes`
  ADD PRIMARY KEY (`idCommande`),
  ADD KEY `idCommande` (`idCommande`);

--
-- Index pour la table `contenucommande`
--
ALTER TABLE `contenucommande`
  ADD KEY `IdDeCommande` (`idCommande`),
  ADD KEY `IdDuProduit` (`idProduit`);

--
-- Index pour la table `contenusortie`
--
ALTER TABLE `contenusortie`
  ADD KEY `idDeArgent` (`idArgent`),
  ADD KEY `idDeSortie` (`idSortie`);

--
-- Index pour la table `produits`
--
ALTER TABLE `produits`
  ADD PRIMARY KEY (`idProduit`);

--
-- Index pour la table `sorties`
--
ALTER TABLE `sorties`
  ADD PRIMARY KEY (`idSortie`),
  ADD KEY `idSortie` (`idSortie`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `commandes`
--
ALTER TABLE `commandes`
  MODIFY `idCommande` int(11) NOT NULL AUTO_INCREMENT COMMENT 'L''id de la commande';

--
-- AUTO_INCREMENT pour la table `produits`
--
ALTER TABLE `produits`
  MODIFY `idProduit` int(11) NOT NULL AUTO_INCREMENT COMMENT 'L''id du produit', AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT pour la table `sorties`
--
ALTER TABLE `sorties`
  MODIFY `idSortie` int(11) NOT NULL AUTO_INCREMENT COMMENT 'L''id de la sortie';

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `contenucommande`
--
ALTER TABLE `contenucommande`
  ADD CONSTRAINT `IdDeCommande` FOREIGN KEY (`idCommande`) REFERENCES `commandes` (`idCommande`),
  ADD CONSTRAINT `IdDuProduit` FOREIGN KEY (`idProduit`) REFERENCES `produits` (`idProduit`);

--
-- Contraintes pour la table `contenusortie`
--
ALTER TABLE `contenusortie`
  ADD CONSTRAINT `idDeArgent` FOREIGN KEY (`idArgent`) REFERENCES `argent` (`idArgent`),
  ADD CONSTRAINT `idDeSortie` FOREIGN KEY (`idSortie`) REFERENCES `sorties` (`idSortie`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
