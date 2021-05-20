CREATE TABLE `argent` (
  `idArgent` int(11) NOT NULL COMMENT 'L''id de l''argent',
  `valeurArgente` double NOT NULL COMMENT 'La valeur de l''argent'
);

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

CREATE TABLE `commandes` (
  `idCommande` int(11) NOT NULL COMMENT 'L''id de la commande',
  `heureCommande` date NOT NULL COMMENT 'L''heure de la commande'
);

CREATE TABLE `contenucommande` (
  `idCommande` int(11) NOT NULL COMMENT 'L''id référencant la commande',
  `idProduit` int(11) NOT NULL COMMENT 'L''id référencant le produit',
  `nombreProduit` int(11) NOT NULL COMMENT 'Le nombre de fois que le produit a été acheté'
);

CREATE TABLE `contenusortie` (
  `idSortie` int(11) NOT NULL COMMENT 'L''id référencant la sortie',
  `idArgent` int(11) NOT NULL COMMENT 'L''id référencant l''argent',
  `nombreArgent` int(11) NOT NULL COMMENT 'Le nombre d''argent sortie'
);

CREATE TABLE `produits` (
  `idProduit` int(11) NOT NULL COMMENT 'L''id du produit',
  `visibleProduit` int(11) NOT NULL COMMENT 'Si le bouton est visible ou non',
  `prixUnitaireProduit` double NOT NULL COMMENT 'Le prix unitaire du produit',
  `couleurRProduit` int(11) NOT NULL COMMENT 'L''attribut R de la couleur de la touche',
  `couleurGProduit` int(11) NOT NULL COMMENT 'L''attribut G de la couleur de la touche',
  `couleurBProduit` int(11) NOT NULL COMMENT 'L''attribut B de la couleur de la touche',
  `descriptionProduit` varchar(20) NOT NULL COMMENT 'La description du produit'
);

INSERT INTO `produits` (`idProduit`, `visibleProduit`, `prixUnitaireProduit`, `couleurRProduit`, `couleurGProduit`, `couleurBProduit`, `descriptionProduit`) VALUES
(11, 1, 1.5, 255, 0, 0, 'Ticket rouge'),
(21, 0, 0, 0, 0, 0, ''),
(31, 1, 2, 0, 0, 255, 'Ticket Bleu'),
(41, 1, 3, 255, 165, 0, 'Ticket orange'),
(51, 1, 2.5, 0, 255, 255, 'Ticket jaune'),
(61, 0, 0, 0, 0, 0, ''),
(12, 1, 1.5, 255, 0, 0, 'Eau plate'),
(22, 1, 2, 0, 0, 255, 'Ice tea'),
(32, 1, 2, 0, 0, 255, 'Kriek'),
(42, 1, 3, 255, 165, 0, 'Chimay bleue'),
(52, 1, 2.5, 0, 255, 255, 'Petit déjeuner'),
(62, 1, 1.5, 255, 0, 0, 'Café'),
(13, 1, 1.5, 255, 0, 0, 'Eau pétillante'),
(23, 0, 0, 0, 0, 0, ''),
(33, 1, 2, 0, 0, 255, 'Blanche'),
(43, 0, 0, 0, 0, 0, ''),
(53, 1, 2.5, 0, 255, 255, 'Sandwich'),
(63, 1, 1.5, 255, 0, 0, 'Chocolat chaud'),
(14, 1, 1.5, 255, 0, 0, 'Coca cola'),
(24, 0, 0, 0, 0, 0, ''),
(34, 1, 2, 0, 0, 255, 'Vin au verre'),
(44, 0, 0, 0, 0, 0, ''),
(54, 1, 2.5, 0, 255, 255, 'Hot Dog'),
(64, 1, 1.5, 255, 0, 0, 'Couque'),
(15, 1, 1.5, 255, 0, 0, 'Coca light'),
(25, 0, 0, 0, 0, 0, ''),
(35, 1, 1.5, 255, 0, 0, 'Pils'),
(45, 0, 0, 0, 0, 0, ''),
(55, 0, 0, 0, 0, 0, ''),
(65, 1, 1.5, 255, 0, 0, 'Chips'),
(16, 1, 1.5, 255, 0, 0, 'Limonade'),
(26, 1, 1.5, 255, 0, 0, 'Jus de fruits'),
(36, 1, 2.5, 0, 255, 255, 'Gouyasse'),
(46, 0, 0, 0, 0, 0, ''),
(56, 0, 0, 0, 0, 0, ''),
(66, 1, 1.5, 255, 0, 0, 'Bonbons');

CREATE TABLE `sorties` (
  `idSortie` int(11) NOT NULL COMMENT 'L''id de la sortie',
  `heureSortie` date NOT NULL COMMENT 'L''heure de la sortie',
  `responsables` text NOT NULL COMMENT 'Le nom des personnes responsables de la sortie'
);


ALTER TABLE `argent`
  ADD PRIMARY KEY (`idArgent`),
  ADD KEY `idArgent` (`idArgent`);

ALTER TABLE `commandes`
  ADD PRIMARY KEY (`idCommande`),
  ADD KEY `idCommande` (`idCommande`);

ALTER TABLE `contenucommande`
  ADD KEY `IdDeCommande` (`idCommande`),
  ADD KEY `IdDuProduit` (`idProduit`);

ALTER TABLE `contenusortie`
  ADD KEY `idDeArgent` (`idArgent`),
  ADD KEY `idDeSortie` (`idSortie`);

ALTER TABLE `produits`
  ADD PRIMARY KEY (`idProduit`);

ALTER TABLE `sorties`
  ADD PRIMARY KEY (`idSortie`),
  ADD KEY `idSortie` (`idSortie`);

ALTER TABLE `commandes`
  MODIFY `idCommande` int(11) NOT NULL AUTO_INCREMENT COMMENT 'L''id de la commande';

ALTER TABLE `produits`
  MODIFY `idProduit` int(11) NOT NULL AUTO_INCREMENT COMMENT 'L''id du produit', AUTO_INCREMENT=67;

ALTER TABLE `sorties`
  MODIFY `idSortie` int(11) NOT NULL AUTO_INCREMENT COMMENT 'L''id de la sortie';

ALTER TABLE `contenucommande`
  ADD CONSTRAINT `IdDeCommande` FOREIGN KEY (`idCommande`) REFERENCES `commandes` (`idCommande`),
  ADD CONSTRAINT `IdDuProduit` FOREIGN KEY (`idProduit`) REFERENCES `produits` (`idProduit`);

ALTER TABLE `contenusortie`
  ADD CONSTRAINT `idDeArgent` FOREIGN KEY (`idArgent`) REFERENCES `argent` (`idArgent`),
  ADD CONSTRAINT `idDeSortie` FOREIGN KEY (`idSortie`) REFERENCES `sorties` (`idSortie`);