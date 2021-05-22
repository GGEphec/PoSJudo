CREATE TABLE "argent" (
  "idArgent" INTEGER IDENTITY,
  "valeurArgente" DOUBLE NOT NULL);

CREATE TABLE "commandes" (
  "idCommande" INTEGER NOT NULL IDENTITY,
  "heureCommande" datetime NOT NULL);
  
CREATE TABLE "produits" (
  "idProduit" INTEGER NOT NULL IDENTITY,
  "visibleProduit" INTEGER NOT NULL,
  "prixUnitaireProduit" DOUBLE NOT NULL,
  "couleurRProduit" INTEGER NOT NULL,
  "couleurGProduit" INTEGER NOT NULL,
  "couleurBProduit" INTEGER NOT NULL,
  "descriptionProduit" varchar(20) NOT NULL);

CREATE TABLE "contenucommande" (
  "idCommande" INTEGER NOT NULL,
  "idProduit" INTEGER NOT NULL,
  "nombreProduit" INTEGER NOT NULL,
  PRIMARY KEY ("idCommande", "idProduit"),
  FOREIGN KEY("idCommande") REFERENCES "commandes",
  FOREIGN KEY("idProduit") REFERENCES "produits");

CREATE TABLE "sorties" (
  "idSortie" INTEGER NOT NULL IDENTITY,
  "heureSortie" datetime NOT NULL,
  "responsables" VARCHAR(50) NOT NULL);

CREATE TABLE "contenusortie" (
  "idSortie" INTEGER NOT NULL,
  "idArgent" INTEGER NOT NULL,
  "nombreArgent" INTEGER NOT NULL,
  PRIMARY KEY ("idSortie", "idArgent"),
  FOREIGN KEY("idSortie") REFERENCES "sorties",
  FOREIGN KEY("idArgent") REFERENCES "argent");

CREATE TABLE "memoire" (
  "argentcaisse" DOUBLE NOT NULL);





INSERT INTO "argent" ("idArgent", "valeurArgente") VALUES (1, 0.01);
INSERT INTO "argent" ("idArgent", "valeurArgente") VALUES (2, 0.02);
INSERT INTO "argent" ("idArgent", "valeurArgente") VALUES (5, 0.05);
INSERT INTO "argent" ("idArgent", "valeurArgente") VALUES (10, 0.1);
INSERT INTO "argent" ("idArgent", "valeurArgente") VALUES (20, 0.2);
INSERT INTO "argent" ("idArgent", "valeurArgente") VALUES (50, 0.5);
INSERT INTO "argent" ("idArgent", "valeurArgente") VALUES (100, 1);
INSERT INTO "argent" ("idArgent", "valeurArgente") VALUES (200, 2);
INSERT INTO "argent" ("idArgent", "valeurArgente") VALUES (500, 5);
INSERT INTO "argent" ("idArgent", "valeurArgente") VALUES (1000, 10);
INSERT INTO "argent" ("idArgent", "valeurArgente") VALUES (2000, 20);
INSERT INTO "argent" ("idArgent", "valeurArgente") VALUES (5000, 50);
INSERT INTO "argent" ("idArgent", "valeurArgente") VALUES (10000, 100);
INSERT INTO "argent" ("idArgent", "valeurArgente") VALUES (20000, 200);

INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (11, 1, 1.5, 255, 0, 0, 'Ticket rouge');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (21, 0, 0, 0, 0, 0, '');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (31, 1, 2, 0, 0, 255, 'Ticket Bleu');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (41, 1, 3, 255, 165, 0, 'Ticket orange');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (51, 1, 2.5, 0, 255, 255, 'Ticket jaune');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (61, 0, 0, 0, 0, 0, '');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (12, 1, 1.5, 255, 0, 0, 'Eau plate');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (22, 1, 2, 0, 0, 255, 'Ice tea');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (32, 1, 2, 0, 0, 255, 'Kriek');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (42, 1, 3, 255, 165, 0, 'Chimay bleue');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (52, 1, 2.5, 0, 255, 255, 'Petit déjeuner');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (62, 1, 1.5, 255, 0, 0, 'Café');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (13, 1, 1.5, 255, 0, 0, 'Eau pétillante');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (23, 0, 0, 0, 0, 0, '');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (33, 1, 2, 0, 0, 255, 'Blanche');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (43, 0, 0, 0, 0, 0, '');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (53, 1, 2.5, 0, 255, 255, 'Sandwich');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (63, 1, 1.5, 255, 0, 0, 'Chocolat chaud');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (14, 1, 1.5, 255, 0, 0, 'Coca cola');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (24, 0, 0, 0, 0, 0, '');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (34, 1, 2, 0, 0, 255, 'Vin au verre');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (44, 0, 0, 0, 0, 0, '');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (54, 1, 2.5, 0, 255, 255, 'Hot Dog');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (64, 1, 1.5, 255, 0, 0, 'Couque');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (15, 1, 1.5, 255, 0, 0, 'Coca light');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (25, 0, 0, 0, 0, 0, '');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (35, 1, 1.5, 255, 0, 0, 'Pils');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (45, 0, 0, 0, 0, 0, '');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (55, 0, 0, 0, 0, 0, '');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (65, 1, 1.5, 255, 0, 0, 'Chips');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (16, 1, 1.5, 255, 0, 0, 'Limonade');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (26, 1, 1.5, 255, 0, 0, 'Jus de fruits');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (36, 1, 2.5, 0, 255, 255, 'Gouyasse');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (46, 0, 0, 0, 0, 0, '');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (56, 0, 0, 0, 0, 0, '');
INSERT INTO "produits" ("idProduit", "visibleProduit", "prixUnitaireProduit", "couleurRProduit", "couleurGProduit", "couleurBProduit", "descriptionProduit") VALUES (66, 1, 1.5, 255, 0, 0, 'Bonbons');

INSERT INTO "memoire" ("argentcaisse") VALUES (0);