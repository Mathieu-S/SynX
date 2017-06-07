-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mer 07 Juin 2017 à 16:06
-- Version du serveur :  5.7.14
-- Version de PHP :  7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `synx`
--

-- --------------------------------------------------------

--
-- Structure de la table `t_incidents`
--

CREATE TABLE `t_incidents` (
  `id` int(11) NOT NULL,
  `id_materiel` int(11) NOT NULL,
  `titre` varchar(50) NOT NULL,
  `description` text NOT NULL,
  `date_debut` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_fin` datetime DEFAULT NULL,
  `status` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `t_materiel`
--

CREATE TABLE `t_materiel` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `type` varchar(10) NOT NULL,
  `nb_serie` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `t_users`
--

CREATE TABLE `t_users` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mdp` varchar(255) NOT NULL,
  `role` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `t_users`
--

INSERT INTO `t_users` (`id`, `nom`, `prenom`, `email`, `mdp`, `role`) VALUES
(1, 'SUPER', 'Admin', 'admin@synx.com', 'FijDhnxcWyl3zuOiVO5TBehRjEsjCHW6sz2JPTxylOvEs0ZHYpD3QtxN9mxhHCEh', 'Admin');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `t_incidents`
--
ALTER TABLE `t_incidents`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idMateriel` (`id_materiel`);

--
-- Index pour la table `t_materiel`
--
ALTER TABLE `t_materiel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idUser` (`id_user`);

--
-- Index pour la table `t_users`
--
ALTER TABLE `t_users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `t_users_email_uindex` (`email`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `t_incidents`
--
ALTER TABLE `t_incidents`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `t_materiel`
--
ALTER TABLE `t_materiel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `t_users`
--
ALTER TABLE `t_users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `t_incidents`
--
ALTER TABLE `t_incidents`
  ADD CONSTRAINT `t_incidents_ibfk_1` FOREIGN KEY (`id_materiel`) REFERENCES `t_materiel` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `t_materiel`
--
ALTER TABLE `t_materiel`
  ADD CONSTRAINT `t_materiel_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `t_users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
