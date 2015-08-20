CREATE DATABASE rpg

-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 20-Ago-2015 às 02:08
-- Versão do servidor: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `rpg`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `armaduras`
--

CREATE TABLE IF NOT EXISTS `armaduras` (
  `codigo_armadura` int(5) NOT NULL,
  `nome_armadura` varchar(30) DEFAULT NULL,
  `tipo_armadura` int(1) DEFAULT NULL,
  `preco_armadura` double DEFAULT NULL,
  `bonus_maximo_armadura` double DEFAULT NULL,
  `penalidade_destreza_armadura` int(3) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `armaduras`
--

INSERT INTO `armaduras` (`codigo_armadura`, `nome_armadura`, `tipo_armadura`, `preco_armadura`, `bonus_maximo_armadura`, `penalidade_destreza_armadura`) VALUES
(1, 'Casaco de Pano', 0, 2, 2, 2),
(2, 'Daedra Armor', 1, 10, 110, 110),
(3, 'Dragon Armor', 1, 10, 110, 110),
(4, 'Jaqueta de Couro', 1, 5, 5, 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `armadurasnpcs`
--

CREATE TABLE IF NOT EXISTS `armadurasnpcs` (
  `codigo_armadura` int(5) NOT NULL,
  `codigo_npc` int(5) NOT NULL,
  `quantidade_armadura` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `armas`
--

CREATE TABLE IF NOT EXISTS `armas` (
  `codigo_arma` int(5) NOT NULL,
  `nome_arma` varchar(30) DEFAULT NULL,
  `tipo_arma` int(1) DEFAULT NULL,
  `preco_arma` double DEFAULT NULL,
  `quantidade_dado_arma` int(1) DEFAULT NULL,
  `tipo_do_dado_arma` int(2) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `armas`
--

INSERT INTO `armas` (`codigo_arma`, `nome_arma`, `tipo_arma`, `preco_arma`, `quantidade_dado_arma`, `tipo_do_dado_arma`) VALUES
(1, 'Espada de Ferro', 1, 1, 13, 12),
(2, 'Espada Longa', 2, 10, 10, 10),
(3, 'Adaga', 1, 5, 5, 5),
(4, 'Cajado', 0, 6, 6, 6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `armasnpcs`
--

CREATE TABLE IF NOT EXISTS `armasnpcs` (
  `codigo_arma` int(5) NOT NULL,
  `codigo_npc` int(5) NOT NULL,
  `quantidade_arma` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `armasnpcs`
--

INSERT INTO `armasnpcs` (`codigo_arma`, `codigo_npc`, `quantidade_arma`) VALUES
(1, 3, 2),
(1, 4, 8),
(1, 5, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `caminhos`
--

CREATE TABLE IF NOT EXISTS `caminhos` (
  `codigo_caminho` int(5) NOT NULL,
  `nome_caminho` varchar(30) DEFAULT NULL,
  `codigo_campanha` int(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `caminhos`
--

INSERT INTO `caminhos` (`codigo_caminho`, `nome_caminho`, `codigo_campanha`) VALUES
(1, 'O Caminho do Jiraya Azul', 3),
(2, 'Caminho', 4),
(3, 'adriel', 1),
(4, 'felipe', 1),
(5, 'CaminhoTeste', 5),
(7, '1', 1),
(8, 'azsdf', 6),
(9, 'asdzxc', 6),
(10, '1111', 6),
(11, 'Estrada das sombras', 7),
(12, 'Floresta de Muria', 7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `campanhas`
--

CREATE TABLE IF NOT EXISTS `campanhas` (
  `codigo_campanha` int(5) NOT NULL,
  `nome_campanha` varchar(30) NOT NULL,
  `tam_x_campanha` int(5) NOT NULL,
  `tam_y_campanha` int(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `campanhas`
--

INSERT INTO `campanhas` (`codigo_campanha`, `nome_campanha`, `tam_x_campanha`, `tam_y_campanha`) VALUES
(1, 'olá mundo', 13, 13),
(2, 'Hello world', 10, 10),
(3, 'jirado no vyrai', 33, 33),
(4, 'Campanha', 10, 10),
(5, 'CampanhaTeste', 20, 20),
(6, '1', 3, 3),
(7, 'Encontre o principe ', 10, 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `classes`
--

CREATE TABLE IF NOT EXISTS `classes` (
  `codigo_classe` int(5) NOT NULL,
  `descricao_classe` varchar(2000) DEFAULT NULL,
  `nome_classe` varchar(30) NOT NULL,
  `dado_vida_classe` int(5) NOT NULL,
  `usar_armaduras_classe` int(5) DEFAULT NULL,
  `usar_armas_classe` int(5) DEFAULT NULL,
  `quantidade_pericias_classe` int(5) DEFAULT NULL,
  `codigo_armadura` int(5) NOT NULL,
  `dinheiro_classe` double DEFAULT NULL,
  `codigo_arma` int(5) NOT NULL,
  `codigo_escudo` int(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `classes`
--

INSERT INTO `classes` (`codigo_classe`, `descricao_classe`, `nome_classe`, `dado_vida_classe`, `usar_armaduras_classe`, `usar_armas_classe`, `quantidade_pericias_classe`, `codigo_armadura`, `dinheiro_classe`, `codigo_arma`, `codigo_escudo`) VALUES
(1, 'teste', 'teste', 5, 5, 5, 5, 2, 200, 1, 1),
(2, '', 'Guerreiro', 10, 1, 1, 1, 3, 400, 3, 1),
(4, '', 'Mago', 4, 0, 0, 0, 1, 500, 4, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `consumiveis`
--

CREATE TABLE IF NOT EXISTS `consumiveis` (
  `codigo_consumivel` int(5) NOT NULL,
  `nome_consumivel` varchar(30) DEFAULT NULL,
  `preco_consumivel` double DEFAULT NULL,
  `quantidade_dados_consumivel` int(1) DEFAULT NULL,
  `tipo_dado_consumivel` int(2) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `consumiveis`
--

INSERT INTO `consumiveis` (`codigo_consumivel`, `nome_consumivel`, `preco_consumivel`, `quantidade_dados_consumivel`, `tipo_dado_consumivel`) VALUES
(1, 'Poção de Vida', 5, 5, 5),
(2, 'Carne', 2, 2, 2),
(3, 'Agua', 1, 2, 6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `consumiveisnpcs`
--

CREATE TABLE IF NOT EXISTS `consumiveisnpcs` (
  `codigo_consumivel` int(5) NOT NULL,
  `codigo_npc` int(5) NOT NULL,
  `quantidade_consumivel` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `consumiveisnpcs`
--

INSERT INTO `consumiveisnpcs` (`codigo_consumivel`, `codigo_npc`, `quantidade_consumivel`) VALUES
(1, 13, 8);

-- --------------------------------------------------------

--
-- Estrutura da tabela `escudos`
--

CREATE TABLE IF NOT EXISTS `escudos` (
  `codigo_escudo` int(5) NOT NULL,
  `nome_escudo` varchar(45) DEFAULT NULL,
  `preco_escudo` double DEFAULT NULL,
  `bonus_maximo_escudo` double DEFAULT NULL,
  `penalidade_destreza_escudo` int(3) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `escudos`
--

INSERT INTO `escudos` (`codigo_escudo`, `nome_escudo`, `preco_escudo`, `bonus_maximo_escudo`, `penalidade_destreza_escudo`) VALUES
(1, 'Escudo de Daedra', 10, 20, 20),
(2, 'Escudo de Madeira', 5, 5, 5),
(3, 'Escudo de Metal', 10, 10, 10),
(4, 'Escudo de Aço', 15, 15, 15);

-- --------------------------------------------------------

--
-- Estrutura da tabela `escudosnpcs`
--

CREATE TABLE IF NOT EXISTS `escudosnpcs` (
  `codigo_npc` int(5) NOT NULL,
  `codigo_escudo` int(5) NOT NULL,
  `quantidade_escudos` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `escudosnpcs`
--

INSERT INTO `escudosnpcs` (`codigo_npc`, `codigo_escudo`, `quantidade_escudos`) VALUES
(3, 1, 1),
(4, 1, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `falas`
--

CREATE TABLE IF NOT EXISTS `falas` (
  `codigo_fala` int(5) NOT NULL,
  `descricao_fala` varchar(1000) DEFAULT NULL,
  `resposta_negativo_fala` varchar(1000) DEFAULT NULL,
  `resposta_positivo_fala` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `falas`
--

INSERT INTO `falas` (`codigo_fala`, `descricao_fala`, `resposta_negativo_fala`, `resposta_positivo_fala`) VALUES
(1, 'Teste', 'Teste', 'Teste'),
(2, 'dasa', 'dasd', 'fasd'),
(3, 'Vendo feijão, quer comprar?', 'Se fuder, veio aqui para que?', 'Ta beleza, show de bola.'),
(4, 'wwe', 'ewwe', 'ewew'),
(5, 'Teste', 'Negativa', 'Positiva'),
(6, 'Teste', 'Teste', 'Teste'),
(7, 'Teste', 'Teste', 'Teste'),
(8, 'Teste', 'Teste', 'Teste'),
(9, 'Teste', 'Negativa', 'Positiva'),
(10, 'Viajante, acho que você está perdido, vou ajudar-lhe a se localizar! HAHAHA', 'HAAAAAAAAAAAAAAAAAAAAAAAAA', 'Minha espada irá destruir você!'),
(11, 'HODOOOOOOOOOOOOOOOOOOOOOR', 'HODOR!!!!', 'HODOR? HODOR!'),
(12, 'Por favor, me ajude!', '....', 'Muito obrigado por ter me salvado, muitas riquezas lhe aguardam no castelo real!'),
(13, 'Eu vi dois homens, pareciam cavaleiros eles estavam carregando um garoto, que vestia uma roupa da corte, rapidamente me escondi, eles seguiram em frente.', 'Não sei quem eles eram, sinto muito.', 'Sim, eles seguiram esse caminho a pouco tempo!'),
(14, 'HAAAAAAAAAAAAA vamos batalhar!', 'HAAAA', 'HAAAAAAA'),
(15, 'Olá viajante, tenho poções para manter sua vida!', 'Poções de vida a preço de banana, volte sempre!', 'Poções de vida a preço de banana, volte sempre!');

-- --------------------------------------------------------

--
-- Estrutura da tabela `jogadores`
--

CREATE TABLE IF NOT EXISTS `jogadores` (
  `codigo_jogador` int(5) NOT NULL,
  `nome_jogador` varchar(45) DEFAULT NULL,
  `senha_jogador` varchar(45) DEFAULT NULL,
  `mestre_jogador` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `jogadores`
--

INSERT INTO `jogadores` (`codigo_jogador`, `nome_jogador`, `senha_jogador`, `mestre_jogador`) VALUES
(1, 'Eduardo', '123', 0),
(2, 'alex', '123', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `jogadorespersonagens`
--

CREATE TABLE IF NOT EXISTS `jogadorespersonagens` (
  `codigo_jogador` int(5) NOT NULL,
  `codigo_personagem` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `jogadorespersonagens`
--

INSERT INTO `jogadorespersonagens` (`codigo_jogador`, `codigo_personagem`) VALUES
(1, 1),
(1, 2),
(2, 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `npcs`
--

CREATE TABLE IF NOT EXISTS `npcs` (
  `codigo_npc` int(5) NOT NULL,
  `nome_npc` varchar(100) DEFAULT NULL,
  `descricao_npc` varchar(500) DEFAULT NULL,
  `tipo_npc` varchar(12) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `npcs`
--

INSERT INTO `npcs` (`codigo_npc`, `nome_npc`, `descricao_npc`, `tipo_npc`) VALUES
(2, 'joao', 'ewe', 'Combatente'),
(3, 'Thor', 'Homi dos raio.', 'Combatente'),
(4, 'Kalindor', 'Vendedor de Whey.', 'Comerciante'),
(5, 'Caixa Antiga', 'Caixa muito louca, cheia de pó mágico..', 'Coletável'),
(6, 'Aucides', 'Guia antigo da cidade, conhece cada canto e boatos informam que é o unico que sabe como encontrar a espada de Daedra..', 'Guia'),
(7, 'Filz', 'Bravo lutador, mas contrariado pela povo de sua terra natal..', 'Missão'),
(8, 'Cavaleiro Zord', 'Um cavaleiro negro que carrega uma longa espada de duas mãos.', 'Combatente'),
(9, 'Cavaleiro Hodor', 'Um humano gigantesco, aparentemente fedido e parece ter surgido de Game of Thrones, ele carrega consigo uma espada longa. ', 'Combatente'),
(10, 'Principe Joao das Neves', 'O principe que havia sido raptado, ele parece estar sem comer há dias.', 'Guia'),
(11, 'Idoso estranho', 'Um idoso que aparenta morar na região.	', 'Guia'),
(12, 'Gnomo enfurecido', 'Um gnomo que aparenta ser um ladrão.', 'Combatente'),
(13, 'Vendedor de poções', 'Um vendedor de poções, caso sua vida esteja baixa fale com ele!', 'Comerciante');

-- --------------------------------------------------------

--
-- Estrutura da tabela `npcscombatentes`
--

CREATE TABLE IF NOT EXISTS `npcscombatentes` (
  `codigo_npc_combatente` int(5) NOT NULL,
  `codigo_npc` int(5) NOT NULL,
  `codigo_personagem` int(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `npcscombatentes`
--

INSERT INTO `npcscombatentes` (`codigo_npc_combatente`, `codigo_npc`, `codigo_personagem`) VALUES
(2, 3, 4),
(3, 8, 5),
(4, 9, 6),
(5, 12, 7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `npcsfalas`
--

CREATE TABLE IF NOT EXISTS `npcsfalas` (
  `codigo_npc` int(5) NOT NULL,
  `codigo_fala` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `npcsfalas`
--

INSERT INTO `npcsfalas` (`codigo_npc`, `codigo_fala`) VALUES
(3, 5),
(4, 6),
(5, 7),
(6, 8),
(7, 9),
(8, 10),
(9, 11),
(10, 12),
(11, 13),
(12, 14),
(13, 15);

-- --------------------------------------------------------

--
-- Estrutura da tabela `periciapersonagem`
--

CREATE TABLE IF NOT EXISTS `periciapersonagem` (
  `pontos_de_pericia` int(11) DEFAULT NULL,
  `codigo_pericia` int(11) NOT NULL,
  `codigo_personagem` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pericias`
--

CREATE TABLE IF NOT EXISTS `pericias` (
  `codigo_pericia` int(5) NOT NULL,
  `nome_pericia` varchar(60) DEFAULT NULL,
  `descricao_pericia` varchar(45) DEFAULT NULL,
  `atributo_principal_pericia` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `periciasclasses`
--

CREATE TABLE IF NOT EXISTS `periciasclasses` (
  `codigo_classe` int(11) NOT NULL,
  `codigo_pericia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `periciasposicoes`
--

CREATE TABLE IF NOT EXISTS `periciasposicoes` (
  `codigo_pericia` int(5) NOT NULL,
  `codigo_posicao` int(5) NOT NULL,
  `dificuldade_pericia` int(2) NOT NULL,
  `descricao_pericia_sucesso` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `periciasracas`
--

CREATE TABLE IF NOT EXISTS `periciasracas` (
  `codigo_pericia` int(5) NOT NULL,
  `codigo_raca` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `personagemclasse`
--

CREATE TABLE IF NOT EXISTS `personagemclasse` (
  `nivel_personagem_classe` int(5) DEFAULT NULL,
  `codigo_classe` int(5) NOT NULL,
  `codigo_personagem` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `personagens`
--

CREATE TABLE IF NOT EXISTS `personagens` (
  `codigo_personagem` int(5) NOT NULL,
  `nome_personagem` varchar(45) DEFAULT NULL,
  `idade_personagem` int(5) DEFAULT NULL,
  `peso_personagem` int(5) DEFAULT NULL,
  `altura_personagem` double DEFAULT NULL,
  `forca_personagem` int(5) DEFAULT NULL,
  `destreza_personagem` int(5) DEFAULT NULL,
  `contituicao_personagem` int(5) DEFAULT NULL,
  `inteligencia_personagem` int(5) DEFAULT NULL,
  `sabedoria_personagem` int(5) DEFAULT NULL,
  `carisma_personagem` int(5) DEFAULT NULL,
  `fortitude_personagem` int(5) DEFAULT NULL,
  `reflexos_personagem` int(5) DEFAULT NULL,
  `vontade_personagem` int(5) DEFAULT NULL,
  `classe_armadura_personagem` int(5) DEFAULT NULL,
  `pontos_vida_personagem` int(5) DEFAULT NULL,
  `iniciativa_personagem` int(5) DEFAULT NULL,
  `base_ataque_personagem` int(5) DEFAULT NULL,
  `codigo_raca` int(5) DEFAULT NULL,
  `codigo_classe` int(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `personagens`
--

INSERT INTO `personagens` (`codigo_personagem`, `nome_personagem`, `idade_personagem`, `peso_personagem`, `altura_personagem`, `forca_personagem`, `destreza_personagem`, `contituicao_personagem`, `inteligencia_personagem`, `sabedoria_personagem`, `carisma_personagem`, `fortitude_personagem`, `reflexos_personagem`, `vontade_personagem`, `classe_armadura_personagem`, `pontos_vida_personagem`, `iniciativa_personagem`, `base_ataque_personagem`, `codigo_raca`, `codigo_classe`) VALUES
(1, 'wq', 3, 3, 4, 2, 6, 4, 4, 4, 4, 4, 4, 4, 5, 5, 4, 5, 8, 1),
(2, 'João', 0, 0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 4, 1),
(3, 'joao', 0, 0, 0, 6, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 4, 1),
(4, 'Thor', 0, 0, 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 4, 1),
(5, 'Cavaleiro Zord', 0, 0, 0, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 4, 1),
(6, 'Cavaleiro Hodor', 0, 0, 0, 12, 10, 16, 4, 4, 10, 12, 10, 10, 5, 14, 10, 12, 4, 1),
(7, 'Gnomo enfurecido', 0, 0, 0, 4, 16, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 7, 1),
(8, 'kasldnklan', 2, 11, 11, 11, 11, 13, 11, 1, 13, 1, 1, 1, 1, 1, 1, 1, 5, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `personagensarmaduras`
--

CREATE TABLE IF NOT EXISTS `personagensarmaduras` (
  `codigo_armadura` int(5) DEFAULT NULL,
  `quantidade_armadura` int(2) DEFAULT NULL,
  `codigo_personagem` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `personagensarmas`
--

CREATE TABLE IF NOT EXISTS `personagensarmas` (
  `codigo_arma` int(5) NOT NULL,
  `quantidade_arma` int(2) DEFAULT NULL,
  `codigo_personagem` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `personagensconsumiveis`
--

CREATE TABLE IF NOT EXISTS `personagensconsumiveis` (
  `codigo_consumivel` int(5) DEFAULT NULL,
  `quantidade_consumivel` int(2) DEFAULT NULL,
  `codigo_personagem` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `personagensconsumiveis`
--

INSERT INTO `personagensconsumiveis` (`codigo_consumivel`, `quantidade_consumivel`, `codigo_personagem`) VALUES
(1, 7, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `personagensescudos`
--

CREATE TABLE IF NOT EXISTS `personagensescudos` (
  `codigo_escudo` int(5) DEFAULT NULL,
  `quantidade_escudo` int(2) DEFAULT NULL,
  `codigo_personagem` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `posicoes`
--

CREATE TABLE IF NOT EXISTS `posicoes` (
  `codigo_posicao` int(5) NOT NULL,
  `descricao_posicao` varchar(900) DEFAULT NULL,
  `coordenadaX_posicao` int(5) DEFAULT NULL,
  `coordenadaY_posicao` int(5) DEFAULT NULL,
  `codigo_caminho` int(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `posicoes`
--

INSERT INTO `posicoes` (`codigo_posicao`, `descricao_posicao`, `coordenadaX_posicao`, `coordenadaY_posicao`, `codigo_caminho`) VALUES
(1, 'Por onde pessoas passavam desde a idade da preda, o caminho do jiraya azul recebeu esse nome por causa de uma nobre guerreiro de espada curta e torta que derrotou o temível chefão Rosca Negra', 22, 22, 1),
(2, 'blablabla', 1, 1, 1),
(3, 'c', 1, 2, 1),
(4, 'v', 1, 3, 1),
(5, 'caminho longo', 1, 1, 1),
(6, 'll', 2, 2, 1),
(7, 'll', 3, 3, 1),
(8, 'oo', 4, 4, 1),
(9, 'pp', 5, 5, 1),
(10, 'oo', 6, 6, 1),
(11, 'uu', 7, 7, 1),
(12, 'y', 8, 8, 1),
(13, 'tt', 9, 9, 1),
(14, 'f', 1, 1, 3),
(15, 'f', 1, 2, 3),
(16, 'j', 1, 3, 3),
(17, 'j', 1, 3, 3),
(18, 'k', 1, 4, 3),
(19, 'l', 1, 5, 3),
(20, 'Teste', 1, 1, 5),
(21, 'Teste2', 2, 2, 5),
(22, 'Teste3', 3, 3, 5),
(23, 'Teste4', 4, 4, 5),
(28, 'sr', 5, 1, 5),
(29, 'çç', 5, 2, 5),
(30, 'kk', 5, 3, 5),
(31, 'jkhkl', 5, 4, 5),
(32, 'jklçjlkç', 5, 5, 5),
(33, '5', 5, 6, 5),
(38, 'jklçjkçl', 12, 12, 5),
(39, 'ghjkghjk', 12, 13, 5),
(40, 'gjkghjk', 12, 14, 5),
(41, 'jhk', 12, 15, 5),
(42, 'fgjhfj', 12, 16, 5),
(43, 'fgjhfg', 12, 17, 5),
(47, 'hdg', 20, 20, 1),
(48, 'h', 20, 19, 1),
(49, 'kçl', 20, 18, 1),
(50, '~lç', 20, 17, 1),
(51, 'klç~lk', 20, 16, 1),
(52, 'jklçj', 20, 15, 1),
(53, 'jkl', 21, 20, 1),
(54, 'ç~]k', 21, 22, 1),
(55, 'kçl21', 21, 23, 1),
(56, 'kç', 21, 24, 1),
(57, 'hjk', 20, 19, 1),
(58, 'ghjkg', 20, 17, 1),
(59, 'fjh', 2, 3, 2),
(60, 'hgkghjkghjk', 2, 4, 2),
(61, 'jhkl', 2, 5, 2),
(62, 'ghjk', 2, 6, 2),
(63, 'jklç', 2, 7, 2),
(64, 'f', 2, 8, 2),
(65, 'fgjhf', 2, 9, 2),
(66, 'fh', 3, 9, 1),
(67, 'khj', 4, 9, 1),
(68, 'ghjkhgj', 5, 9, 1),
(69, '6', 6, 9, 1),
(70, 'hjkgh', 7, 9, 1),
(71, 'ghjk', 8, 9, 1),
(72, 'jkl', 3, 9, 2),
(73, 'hjkl', 4, 9, 2),
(74, 'ghjkhgjk', 5, 9, 2),
(75, 'gh', 6, 9, 2),
(76, 'gh', 7, 9, 2),
(77, 'fh', 8, 9, 2),
(78, 'fhj', 9, 9, 2),
(79, 'hjkhgj', 9, 8, 2),
(80, 'jklç', 9, 7, 2),
(81, 'hj', 9, 6, 2),
(82, 'gh', 9, 5, 2),
(83, 'jklçj', 9, 5, 2),
(84, 'hjklh', 9, 4, 2),
(85, 'j', 9, 3, 2),
(86, 'jklç', 10, 3, 2),
(87, 'jklç', 10, 2, 2),
(88, 'ç~k', 10, 1, 2),
(91, 'ASDD', 1, 1, 7),
(92, 'azsdfggvd', 1, 1, 8),
(93, '2', 2, 2, 8),
(94, '3', 3, 3, 8),
(95, '2', 2, 2, 10),
(96, '3', 3, 3, 10),
(97, 'Existem muitos boatos aterrorizantes sobre a Estrada que terás que percorrer...Muitos talvez sejam inventados para que os andarilhos tomem outro rumo e não passem por lá, talvez estão escondendo alguma riqueza de outro mundo...Existem historias sobre tal tesouro...Mas ao final, poderás me contar melhor sobre isso, caso haja!\r\nIndícios que o Príncipe fora levado por dois cavaleiros negros, quase  imperceptíveis a luz do luar...A unica coisa certa que se sabe sobre tais homens, é que todos que tentaram para-los conheceram a fúria de suas espadas. Todos que morreram por elas, estavam queimados. Como se elas fossem feitas do fogo, mas não um fogo qualquer como vemos nas lareiras, mas sim  fogo árduo, que de tão poderoso, aparenta conversar com os inimigos da espada, assim os manipulando, e levando os ao chão.\r\nMas, são apenas boatos...Agora...Vá a sua jornada. A estrada Sombria lhe espera! ', 1, 1, 11),
(98, 'Você está andando muito devagar, homem! Acelere os passos!\r\n\r\nOpa... mas, espere! \r\nCom sua cautela para andar devagar, você avistou uma carruagem  ao lado oeste, tombada, no meio de um milharal.  Quando chegou ao lado dela, achou um  corpo com sua cabeça arrancada...\r\n\r\nNão há mais nada aqui, e  tome seu rumo João!  ', 2, 1, 11),
(99, 'Então você segue adiante e escuta uivos de lobos por todos os lados, parecem assombrar este local.', 3, 1, 11),
(100, 'Adiante você ouve uivos de lobos e sons de animais desconhecidos, este local parece estar cheio deles.', 4, 1, 11),
(101, 'Os sons de animais continuam ecoando.', 5, 1, 11),
(102, 'Você encontra o que parece ser uma casa abandonada, e nela parece haver um idoso sentado, ele aparenta estar assustado com algo.', 6, 1, 11),
(103, 'Ao avançar mais, você encontra pegadas, parecem ser de dois homens muito grandes, talvez meio-orcs.', 7, 1, 11),
(104, 'O que é isso, parece que você caiu em uma armadilha, você estava caminhando e um gnomo pulou, ele quer lhe roubar...', 8, 1, 11),
(105, 'Ufa, aquele gnomo parecia assustador, os sons de animais continual ecoando.', 9, 1, 11),
(106, 'As pegadas parecem estar frescas.', 10, 1, 11),
(107, 'Você escontra um dos cavaleiros que raptaram o principe, ele parecia estar esperando por você!', 10, 2, 11),
(108, 'Zord parecia ser muito forte, entretanto onde está o principe? Continue em frente', 10, 3, 11),
(109, 'Você encontra outro gnomo ladrão, parece que este local esta cheio de gnomos...', 10, 4, 11),
(110, 'Parece que há uma vila por aqui.', 10, 5, 11),
(111, 'Parece que nesta vilá há algumas pessoas, você avista um vendedor...', 10, 6, 11),
(112, 'Esta vila é muito pouco populada, parece estar vazia...', 10, 7, 11),
(113, 'Há corpos de anões no chão, aparentemente foram mortos a pouco tempo, talvez seja o cavaleiro que sequestrou o principe joao das neves...', 10, 8, 11),
(114, 'Você está saindo da pequena vila, pare estar enchergando um ser gigantesco a frente carregando alguem...', 10, 9, 11),
(115, 'Enfim você encontra o cavaleiro que está com o principe, ele parece ser gigantesco, nem parece um humano comum...', 10, 10, 11),
(116, '...', 10, 10, 11);

-- --------------------------------------------------------

--
-- Estrutura da tabela `posicoesnpcs`
--

CREATE TABLE IF NOT EXISTS `posicoesnpcs` (
  `codigo_posicao` int(5) NOT NULL,
  `codigo_npc` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `posicoesnpcs`
--

INSERT INTO `posicoesnpcs` (`codigo_posicao`, `codigo_npc`) VALUES
(91, 2),
(92, 2),
(95, 2),
(93, 3),
(96, 3),
(94, 4),
(107, 8),
(115, 9),
(116, 10),
(102, 11),
(104, 12),
(109, 12),
(111, 13);

-- --------------------------------------------------------

--
-- Estrutura da tabela `progressaotalento`
--

CREATE TABLE IF NOT EXISTS `progressaotalento` (
  `codigo_progressao` int(5) NOT NULL,
  `codigo_talento` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `progressoes`
--

CREATE TABLE IF NOT EXISTS `progressoes` (
  `codigo_progressao` int(5) NOT NULL,
  `nivel_progressao` int(5) DEFAULT NULL,
  `bonus_base_progressao` int(5) DEFAULT NULL,
  `fortitude_progressao` int(5) DEFAULT NULL,
  `reflexos_progressao` int(5) DEFAULT NULL,
  `vontade_progressao` int(5) DEFAULT NULL,
  `pericia_progressao` int(5) DEFAULT NULL,
  `quantidade_dado_progressao` int(5) DEFAULT NULL,
  `tipo_dado_progressao` int(5) DEFAULT NULL,
  `bonus_ca_progressao` int(5) DEFAULT NULL,
  `classes_codigo_classe` int(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `progressoes`
--

INSERT INTO `progressoes` (`codigo_progressao`, `nivel_progressao`, `bonus_base_progressao`, `fortitude_progressao`, `reflexos_progressao`, `vontade_progressao`, `pericia_progressao`, `quantidade_dado_progressao`, `tipo_dado_progressao`, `bonus_ca_progressao`, `classes_codigo_classe`) VALUES
(1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2),
(2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 2),
(3, 3, 3, 0, 1, 0, 0, 0, 0, 0, 2),
(4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 2),
(5, 5, 2, 0, 0, 0, 0, 0, 0, 0, 2),
(6, 6, 1, 0, 0, 0, 0, 0, 0, 0, 2),
(7, 7, 0, 2, 1, 0, 0, 0, 0, 0, 2),
(8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 2),
(9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 2),
(10, 10, 1, 0, 0, 0, 0, 0, 0, 0, 2),
(11, 11, 0, 0, 0, 0, 0, 0, 0, 0, 2),
(12, 12, 0, 0, 3, 0, 0, 0, 0, 0, 2),
(13, 13, 2, 1, 0, 1, 0, 0, 0, 0, 2),
(14, 14, 0, 0, 0, 0, 0, 0, 0, 0, 2),
(15, 15, 0, 0, 0, 0, 0, 0, 0, 0, 2),
(16, 16, 1, 0, 0, 1, 0, 0, 0, 0, 2),
(17, 17, 0, 0, 0, 0, 0, 0, 0, 0, 2),
(18, 18, 0, 0, 0, 0, 0, 0, 0, 0, 2),
(19, 19, 0, 0, 0, 1, 0, 0, 0, 0, 2),
(20, 20, 1, 0, 0, 0, 0, 0, 0, 0, 2),
(21, 1, 1, 0, 0, 0, 0, 0, 0, 0, 4),
(22, 2, 0, 1, 1, 1, 0, 0, 0, 0, 4),
(23, 3, 1, 0, 1, 0, 0, 0, 0, 0, 4),
(24, 4, 0, 0, 0, 0, 0, 0, 0, 0, 4),
(25, 5, 1, 1, 0, 0, 0, 0, 0, 0, 4),
(26, 6, 1, 0, 0, 1, 0, 0, 0, 0, 4),
(27, 7, 0, 0, 0, 0, 0, 0, 0, 0, 4),
(28, 8, 1, 1, 1, 1, 0, 0, 0, 0, 4),
(29, 9, 0, 1, 0, 0, 0, 0, 0, 0, 4),
(30, 10, 1, 0, 0, 0, 0, 0, 0, 0, 4),
(31, 11, 0, 0, 0, 0, 0, 0, 0, 0, 4),
(32, 12, 1, 0, 0, 0, 0, 0, 0, 0, 4),
(33, 13, 1, 1, 1, 0, 1, 0, 0, 0, 4),
(34, 14, 0, 0, 0, 1, 0, 0, 0, 0, 4),
(35, 15, 0, 0, 0, 0, 0, 0, 0, 0, 4),
(36, 16, 1, 0, 0, 0, 0, 0, 0, 0, 4),
(37, 17, 0, 0, 0, 1, 0, 0, 0, 0, 4),
(38, 18, 1, 1, 0, 0, 0, 0, 0, 0, 4),
(39, 19, 1, 0, 0, 0, 0, 0, 0, 0, 4),
(40, 20, 0, 0, 0, 0, 0, 0, 0, 0, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `raca`
--

CREATE TABLE IF NOT EXISTS `raca` (
  `codigo_raca` int(5) NOT NULL,
  `nome_raca` varchar(45) DEFAULT NULL,
  `descricao_raca` varchar(1000) DEFAULT NULL,
  `forca_raca` int(5) DEFAULT NULL,
  `destreza_raca` int(5) DEFAULT NULL,
  `constituicao_raca` int(5) DEFAULT NULL,
  `inteligencia_raca` int(5) DEFAULT NULL,
  `sabedoria_raca` int(5) DEFAULT NULL,
  `carisma_raca` int(5) DEFAULT NULL,
  `qtd_talen_raca_adc` int(5) DEFAULT NULL,
  `uso_arma_raca` int(1) DEFAULT NULL,
  `uso_escudo_raca` tinyint(1) DEFAULT NULL,
  `uso_armadura_raca` int(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `raca`
--

INSERT INTO `raca` (`codigo_raca`, `nome_raca`, `descricao_raca`, `forca_raca`, `destreza_raca`, `constituicao_raca`, `inteligencia_raca`, `sabedoria_raca`, `carisma_raca`, `qtd_talen_raca_adc`, `uso_arma_raca`, `uso_escudo_raca`, `uso_armadura_raca`) VALUES
(4, 'Humano', 'A raça humana é a mais adaptável, flexível e ambiciosa dentre\ntodas as raças comuns. Suas preferências, moral, costumes e hábitos variam muito.\nEm geral, os humanos têm entre 1,60 m e 1,90 m de altura\ne pesam entre 60 e 80 quilos; os homens são visivelmente mais altos e pesados que\nas mulheres. Graças á sua tendência de viajar e conquistar, e sua curta expectativa de\nvida, os humanos apresentam uma diversidade física mais abrangente que as outras\nraças.\nOs humanos quase sempre são orgulhosos e extravagantes em sua\naparência e vestimentas, ostentando estilos de cabelo incomuns, roupas coloridas,\ntatuagens, brincos e ornamentos similares.', 0, 0, 0, 0, 0, 0, 1, 0, 0, 0),
(5, 'Anões', 'Os anões hesitam em sorrir ou celebrar e suspeitam muito de\nestranhos, mas são generosos com os poucos indivíduos que adquirem sua confiança.\nEles não combatem de forma\nrecatada ou temerária, mas com coragem, tenacidade e cautela. A raça possui um forte\nsenso de justiça, que pode se transformar em uma sede de vingança infindável\nOs anões têm entre 1,30 m e 1,50 m de altura, mas seus\ncorpos são muito largos e compactos; em geral, eles pesam o mesmo que os seres\nhumanos.\nOs\nanões valorizam bastante suas barbas e cuidam bem delas. Eles preferem estilos\nsimples para seus cabelos, barbas e roupas. Atingem a fase adulta por volta dos 40\nanos e podem viver mais de 400 anos.', 0, 0, 2, 0, 0, 2, 0, 0, 1, 0),
(6, 'Elfos', 'Os elfos preferem a serenidade à agitação e a raça costuma ceder\nmais à curiosidade do que à cobiça. Em função de sua longevidade, eles tendem\na desenvolver uma perspectiva mais ampla dos eventos, tornando-se distantes e\nindiferentes às casualidades sem importância.\nOs elfos hesitam em criar vínculos de amizade\nou inimizade, mas são ainda mais reticentes em esquecê-los.\nOs elfos são baixos e esbeltos. Sua altura varia entre 1,40\nm e 1,70 m e seu peso entre 40 e 65 quilos. As elfas são ligeiramente mais\nleves que os elfos.', 0, 2, -2, 0, 0, 0, 0, 0, 0, 0),
(7, 'Gnomos', 'Os gnomos são bemvindos em todos os lugares como técnicos, alquimistas\ne inventores.\nApesar da demanda por suas habilidades, a maioria prefere viver entre a própria raça, em confortáveis  buracos sob as colinas,\nem meio à natureza e os  animais.\nA altura dos gnomos varia entre 1,00 m e 1,20 m e seu peso\nentre 20 e 23 quilos. A cor da pele varia do moreno claro ao marrom escuro, os\ncabelos são claros e os olhos apresentam diversas tonalidades de azul.\n', -2, 0, 2, 0, 0, 0, 0, 0, 0, 0),
(8, 'Meio- Elfos', 'A vida de um meio-elfo pode ser árdua. Caso seja criado entre os parentes elfos,\ncrescerá numa velocidade estonteante, atingindo a maturidade em duas décadas.\nA maioria dos meio-elfos possui a curiosidade, a inventividade e\na ambição de seu parente humano, aliadas aos sentidos refinados, o amor à natureza\ne os gostos artísticos de sua herança élfica.\nPara os humanos, os meio-elfos parecem elfos. Para os elfos,\neles parecem humanos. Na verdade, os elfos os chamam de “meio-humanos”. A\naltura dos meio-elfos varia entre 1,50 m e 1,80 m e seu peso varia entre 45 e 90\nquilos.\n', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(9, 'Meio - Orcs', 'Os meio-orcs costumam apresentar um temperamento inquieto e  serem mal-humorados. Eles preferem agir a pensar e lutar em vez de discutir.\nContudo, os meio-orcs destinados a obter  sucesso são os indivíduos que desenvolveram autocontrole suficiente para viver nas terras\ncivilizadas, não os insanos.\nA altura dos meio-orcs  varia entre 1,80 m e 2,10 m e seu peso varia entre 90 e 125 quilos. Eles são facilmente  reconhecíveis por sua pele acinzentada, testas \navantajadas, mandíbulas grandes com dentes  proeminentes e uma enorme quantidade de\npêlos no corpo.', 2, 0, 0, -2, 0, 0, 0, 0, 0, 0),
(10, 'Halfling', 'Os halflings são espertos, competentes e oportunistas. Os indivíduos e os clãs\ndesta raça encontram seu espaço em qualquer lugar. Muitas vezes, eles são viajantes\ne peregrinos, e os nativos os observam com desconfiança ou curiosidade.\nMuitos halflings preferem uma encrenca ao tédio. Eles são\nnotavelmente curiosos, mas confiam em suas habilidades para sobreviver e escapar\ndo perigo, e demonstram uma coragem que raros indivíduos maiores são capazes\nde superar.\nA altura dos halflings raramente ultrapassa 90 centímetros e\nseu peso varia entre 15 e 18 quilos. Sua pele é rosada e seus cabelos são pretos e lisos.\nEles possuem olhos castanhos ou negros.\nUm halfling atinge a idade adulta com\ncerca de vinte anos e vive pouco mais de 150 anos.\n', -2, 2, 0, 0, 0, 0, 0, 0, 1, 0),
(11, 'Mago', 'Escudo de fogo mágico', 12, 7, 4, 8, 2, 1, 2, 0, 1, 1),
(12, 'fdsfds', 'fdsfsd', 5, 5, 5, 5, 5, 5, 5, 0, 1, 1),
(13, 'teste', 'gfdgdf', 7, 7, 7, 7, 7, 7, 0, 0, 1, 1),
(14, 'testesss', 'fxdgfsdgfd', 6, 6, 6, 6, 6, 6, 6, 0, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `talentos`
--

CREATE TABLE IF NOT EXISTS `talentos` (
  `codigo_talento` int(5) NOT NULL,
  `nome_talento` varchar(60) DEFAULT NULL,
  `descricao_talento` varchar(45) DEFAULT NULL,
  `requisito_talento` varchar(45) DEFAULT NULL,
  `bonus_talento` varchar(45) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `talentos`
--

INSERT INTO `talentos` (`codigo_talento`, `nome_talento`, `descricao_talento`, `requisito_talento`, `bonus_talento`) VALUES
(2, 'Vitalidade', 'Aumenta o pontos de vida em  +3', 'Personagens;pontos_vida_personagem;3', 'Personagens;pontos_vida_personagem;1'),
(3, 'Saque rapido', 'Aumenta a base da ataque do personagem em +3', 'Personagens;base_ataque_personagem;3', 'Personagens;base_ataque_personagem;1'),
(4, 'Ataque poderoso', 'adiciona +5 de forca', 'Personagens;forca_personagem;13', 'Personagens;forca_personagem;5');

-- --------------------------------------------------------

--
-- Estrutura da tabela `talentospersonagem`
--

CREATE TABLE IF NOT EXISTS `talentospersonagem` (
  `bonus_talento_personagem` int(5) DEFAULT NULL,
  `codigo_personagem` int(5) NOT NULL,
  `codigo_talento` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `temporario`
--

CREATE TABLE IF NOT EXISTS `temporario` (
  `codigo_temporario` int(5) NOT NULL,
  `pontos_vida_temporaio` int(5) DEFAULT NULL,
  `dinheiro_classe` int(5) DEFAULT NULL,
  `codigo_personagem` int(5) NOT NULL,
  `iniciativa_personagem` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Stand-in structure for view `vwposicoes`
--
CREATE TABLE IF NOT EXISTS `vwposicoes` (
`codigo_posicao` int(5)
,`descricao_posicao` varchar(900)
,`coordenadaX_posicao` int(5)
,`coordenadaY_posicao` int(5)
,`codigo_caminho` int(5)
,`codigo_npc` int(5)
,`nome_npc` varchar(100)
,`descricao_npc` varchar(500)
,`tipo_npc` varchar(12)
,`codigo_pericia` int(5)
,`nome_pericia` varchar(60)
,`descricao_pericia` varchar(45)
,`atributo_principal_pericia` varchar(45)
);

-- --------------------------------------------------------

--
-- Structure for view `vwposicoes`
--
DROP TABLE IF EXISTS `vwposicoes`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vwposicoes` AS select `po`.`codigo_posicao` AS `codigo_posicao`,`po`.`descricao_posicao` AS `descricao_posicao`,`po`.`coordenadaX_posicao` AS `coordenadaX_posicao`,`po`.`coordenadaY_posicao` AS `coordenadaY_posicao`,`po`.`codigo_caminho` AS `codigo_caminho`,`n`.`codigo_npc` AS `codigo_npc`,`n`.`nome_npc` AS `nome_npc`,`n`.`descricao_npc` AS `descricao_npc`,`n`.`tipo_npc` AS `tipo_npc`,`p`.`codigo_pericia` AS `codigo_pericia`,`p`.`nome_pericia` AS `nome_pericia`,`p`.`descricao_pericia` AS `descricao_pericia`,`p`.`atributo_principal_pericia` AS `atributo_principal_pericia` from ((((`posicoes` `po` left join `posicoesnpcs` `pn` on((`pn`.`codigo_posicao` = `po`.`codigo_posicao`))) left join `periciasposicoes` `pp` on((`pp`.`codigo_posicao` = `po`.`codigo_posicao`))) left join `npcs` `n` on((`n`.`codigo_npc` = `pn`.`codigo_npc`))) left join `pericias` `p` on((`p`.`codigo_pericia` = `pp`.`codigo_pericia`))) order by `po`.`codigo_posicao`;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `armaduras`
--
ALTER TABLE `armaduras`
  ADD PRIMARY KEY (`codigo_armadura`);

--
-- Indexes for table `armadurasnpcs`
--
ALTER TABLE `armadurasnpcs`
  ADD PRIMARY KEY (`codigo_armadura`,`codigo_npc`), ADD KEY `fk_Armaduras_has_Npcs_Npcs1_idx` (`codigo_npc`), ADD KEY `fk_Armaduras_has_Npcs_Armaduras1_idx` (`codigo_armadura`);

--
-- Indexes for table `armas`
--
ALTER TABLE `armas`
  ADD PRIMARY KEY (`codigo_arma`);

--
-- Indexes for table `armasnpcs`
--
ALTER TABLE `armasnpcs`
  ADD PRIMARY KEY (`codigo_arma`,`codigo_npc`), ADD KEY `fk_Armas_has_Npcs_Npcs1_idx` (`codigo_npc`), ADD KEY `fk_Armas_has_Npcs_Armas1_idx` (`codigo_arma`);

--
-- Indexes for table `caminhos`
--
ALTER TABLE `caminhos`
  ADD PRIMARY KEY (`codigo_caminho`), ADD KEY `fk_Caminhos_Campanhas1_idx` (`codigo_campanha`);

--
-- Indexes for table `campanhas`
--
ALTER TABLE `campanhas`
  ADD PRIMARY KEY (`codigo_campanha`);

--
-- Indexes for table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`codigo_classe`), ADD KEY `fk_classes_Armaduras1_idx` (`codigo_armadura`), ADD KEY `fk_Classes_Armas1_idx` (`codigo_arma`), ADD KEY `fk_Classes_Escudos1_idx` (`codigo_escudo`);

--
-- Indexes for table `consumiveis`
--
ALTER TABLE `consumiveis`
  ADD PRIMARY KEY (`codigo_consumivel`);

--
-- Indexes for table `consumiveisnpcs`
--
ALTER TABLE `consumiveisnpcs`
  ADD PRIMARY KEY (`codigo_consumivel`,`codigo_npc`), ADD KEY `fk_Consumiveis_has_Npcs_Npcs1_idx` (`codigo_npc`), ADD KEY `fk_Consumiveis_has_Npcs_Consumiveis1_idx` (`codigo_consumivel`);

--
-- Indexes for table `escudos`
--
ALTER TABLE `escudos`
  ADD PRIMARY KEY (`codigo_escudo`);

--
-- Indexes for table `escudosnpcs`
--
ALTER TABLE `escudosnpcs`
  ADD PRIMARY KEY (`codigo_npc`,`codigo_escudo`), ADD KEY `fk_Npcs_has_Escudos_Escudos1_idx` (`codigo_escudo`), ADD KEY `fk_Npcs_has_Escudos_Npcs1_idx` (`codigo_npc`);

--
-- Indexes for table `falas`
--
ALTER TABLE `falas`
  ADD PRIMARY KEY (`codigo_fala`);

--
-- Indexes for table `jogadores`
--
ALTER TABLE `jogadores`
  ADD PRIMARY KEY (`codigo_jogador`);

--
-- Indexes for table `jogadorespersonagens`
--
ALTER TABLE `jogadorespersonagens`
  ADD KEY `fk_Jogadores_Personagens_Jogadores1_idx` (`codigo_jogador`), ADD KEY `fk_Jogadores_Personagens_Personagens1_idx` (`codigo_personagem`);

--
-- Indexes for table `npcs`
--
ALTER TABLE `npcs`
  ADD PRIMARY KEY (`codigo_npc`);

--
-- Indexes for table `npcscombatentes`
--
ALTER TABLE `npcscombatentes`
  ADD PRIMARY KEY (`codigo_npc_combatente`), ADD KEY `fk_Npc_combatentes_Npcs1_idx` (`codigo_npc`), ADD KEY `fk_Npc_combatentes_Personagens1_idx` (`codigo_personagem`);

--
-- Indexes for table `npcsfalas`
--
ALTER TABLE `npcsfalas`
  ADD PRIMARY KEY (`codigo_npc`,`codigo_fala`), ADD KEY `fk_Npcs_has_Falas_Falas1_idx` (`codigo_fala`), ADD KEY `fk_Npcs_has_Falas_Npcs1_idx` (`codigo_npc`);

--
-- Indexes for table `periciapersonagem`
--
ALTER TABLE `periciapersonagem`
  ADD KEY `fk_Pericia_Personagem_Pericias1_idx` (`codigo_pericia`), ADD KEY `fk_Pericia_Personagem_Personagens1_idx` (`codigo_personagem`);

--
-- Indexes for table `pericias`
--
ALTER TABLE `pericias`
  ADD PRIMARY KEY (`codigo_pericia`);

--
-- Indexes for table `periciasclasses`
--
ALTER TABLE `periciasclasses`
  ADD KEY `fk_pericias_classe_classes1_idx` (`codigo_classe`), ADD KEY `fk_pericias_classe_Pericias1_idx` (`codigo_pericia`);

--
-- Indexes for table `periciasposicoes`
--
ALTER TABLE `periciasposicoes`
  ADD PRIMARY KEY (`codigo_pericia`,`codigo_posicao`), ADD KEY `fk_Pericias_has_Posicoes_Posicoes1_idx` (`codigo_posicao`), ADD KEY `fk_Pericias_has_Posicoes_Pericias1_idx` (`codigo_pericia`);

--
-- Indexes for table `periciasracas`
--
ALTER TABLE `periciasracas`
  ADD PRIMARY KEY (`codigo_pericia`,`codigo_raca`), ADD KEY `fk_Pericias_has_Raca_Raca1_idx` (`codigo_raca`), ADD KEY `fk_Pericias_has_Raca_Pericias1_idx` (`codigo_pericia`);

--
-- Indexes for table `personagemclasse`
--
ALTER TABLE `personagemclasse`
  ADD KEY `fk_personagem_classe_classes_idx` (`codigo_classe`), ADD KEY `fk_personagem_classe_Personagens1_idx` (`codigo_personagem`);

--
-- Indexes for table `personagens`
--
ALTER TABLE `personagens`
  ADD PRIMARY KEY (`codigo_personagem`), ADD KEY `fk_Personagens_Raca1_idx` (`codigo_raca`), ADD KEY `fk_Personagens_Classes1_idx` (`codigo_classe`);

--
-- Indexes for table `personagensarmaduras`
--
ALTER TABLE `personagensarmaduras`
  ADD KEY `fk_Itens_Armaduras_Armaduras1_idx` (`codigo_armadura`), ADD KEY `fk_Itens_Armaduras_Personagens1_idx` (`codigo_personagem`);

--
-- Indexes for table `personagensarmas`
--
ALTER TABLE `personagensarmas`
  ADD KEY `fk_Itens_Armas_Armas1_idx` (`codigo_arma`), ADD KEY `fk_Itens_Armas_Personagens1_idx` (`codigo_personagem`);

--
-- Indexes for table `personagensconsumiveis`
--
ALTER TABLE `personagensconsumiveis`
  ADD KEY `fk_Itens_Consumiveis_Consumiveis1_idx` (`codigo_consumivel`), ADD KEY `fk_Itens_Consumiveis_Personagens1_idx` (`codigo_personagem`);

--
-- Indexes for table `personagensescudos`
--
ALTER TABLE `personagensescudos`
  ADD KEY `fk_Itens_Escudos_Escudos1_idx` (`codigo_escudo`), ADD KEY `fk_Itens_Escudos_Personagens1_idx` (`codigo_personagem`);

--
-- Indexes for table `posicoes`
--
ALTER TABLE `posicoes`
  ADD PRIMARY KEY (`codigo_posicao`), ADD KEY `fk_Posicoes_Caminhos1_idx` (`codigo_caminho`);

--
-- Indexes for table `posicoesnpcs`
--
ALTER TABLE `posicoesnpcs`
  ADD PRIMARY KEY (`codigo_posicao`,`codigo_npc`), ADD KEY `fk_Posicoes_has_Npcs_Npcs1_idx` (`codigo_npc`), ADD KEY `fk_Posicoes_has_Npcs_Posicoes1_idx` (`codigo_posicao`);

--
-- Indexes for table `progressaotalento`
--
ALTER TABLE `progressaotalento`
  ADD KEY `fk_progressao_talento_tabela_progressao1_idx` (`codigo_progressao`), ADD KEY `fk_progressao_talento_Talentos1_idx` (`codigo_talento`);

--
-- Indexes for table `progressoes`
--
ALTER TABLE `progressoes`
  ADD PRIMARY KEY (`codigo_progressao`), ADD KEY `fk_tabela_progressao_classes1_idx` (`classes_codigo_classe`);

--
-- Indexes for table `raca`
--
ALTER TABLE `raca`
  ADD PRIMARY KEY (`codigo_raca`);

--
-- Indexes for table `talentos`
--
ALTER TABLE `talentos`
  ADD PRIMARY KEY (`codigo_talento`);

--
-- Indexes for table `talentospersonagem`
--
ALTER TABLE `talentospersonagem`
  ADD KEY `fk_talentos_personagem_Personagens1_idx` (`codigo_personagem`), ADD KEY `fk_talentos_personagem_Talentos1_idx` (`codigo_talento`);

--
-- Indexes for table `temporario`
--
ALTER TABLE `temporario`
  ADD PRIMARY KEY (`codigo_temporario`), ADD KEY `fk_Temporario_Personagens1_idx` (`codigo_personagem`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `armaduras`
--
ALTER TABLE `armaduras`
  MODIFY `codigo_armadura` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `armas`
--
ALTER TABLE `armas`
  MODIFY `codigo_arma` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `caminhos`
--
ALTER TABLE `caminhos`
  MODIFY `codigo_caminho` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `campanhas`
--
ALTER TABLE `campanhas`
  MODIFY `codigo_campanha` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `classes`
--
ALTER TABLE `classes`
  MODIFY `codigo_classe` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `consumiveis`
--
ALTER TABLE `consumiveis`
  MODIFY `codigo_consumivel` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `escudos`
--
ALTER TABLE `escudos`
  MODIFY `codigo_escudo` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `falas`
--
ALTER TABLE `falas`
  MODIFY `codigo_fala` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `jogadores`
--
ALTER TABLE `jogadores`
  MODIFY `codigo_jogador` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `npcs`
--
ALTER TABLE `npcs`
  MODIFY `codigo_npc` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `npcscombatentes`
--
ALTER TABLE `npcscombatentes`
  MODIFY `codigo_npc_combatente` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `pericias`
--
ALTER TABLE `pericias`
  MODIFY `codigo_pericia` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `personagens`
--
ALTER TABLE `personagens`
  MODIFY `codigo_personagem` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `posicoes`
--
ALTER TABLE `posicoes`
  MODIFY `codigo_posicao` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=117;
--
-- AUTO_INCREMENT for table `progressoes`
--
ALTER TABLE `progressoes`
  MODIFY `codigo_progressao` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT for table `raca`
--
ALTER TABLE `raca`
  MODIFY `codigo_raca` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `talentos`
--
ALTER TABLE `talentos`
  MODIFY `codigo_talento` int(5) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `armadurasnpcs`
--
ALTER TABLE `armadurasnpcs`
ADD CONSTRAINT `fk_Armaduras_has_Npcs_Armaduras1` FOREIGN KEY (`codigo_armadura`) REFERENCES `armaduras` (`codigo_armadura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Armaduras_has_Npcs_Npcs1` FOREIGN KEY (`codigo_npc`) REFERENCES `npcs` (`codigo_npc`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `armasnpcs`
--
ALTER TABLE `armasnpcs`
ADD CONSTRAINT `fk_Armas_has_Npcs_Armas1` FOREIGN KEY (`codigo_arma`) REFERENCES `armas` (`codigo_arma`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Armas_has_Npcs_Npcs1` FOREIGN KEY (`codigo_npc`) REFERENCES `npcs` (`codigo_npc`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `caminhos`
--
ALTER TABLE `caminhos`
ADD CONSTRAINT `fk_Caminhos_Campanhas1` FOREIGN KEY (`codigo_campanha`) REFERENCES `campanhas` (`codigo_campanha`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `classes`
--
ALTER TABLE `classes`
ADD CONSTRAINT `fk_Classes_Armas1` FOREIGN KEY (`codigo_arma`) REFERENCES `armas` (`codigo_arma`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Classes_Escudos1` FOREIGN KEY (`codigo_escudo`) REFERENCES `escudos` (`codigo_escudo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_classes_Armaduras1` FOREIGN KEY (`codigo_armadura`) REFERENCES `armaduras` (`codigo_armadura`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `consumiveisnpcs`
--
ALTER TABLE `consumiveisnpcs`
ADD CONSTRAINT `fk_Consumiveis_has_Npcs_Consumiveis1` FOREIGN KEY (`codigo_consumivel`) REFERENCES `consumiveis` (`codigo_consumivel`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Consumiveis_has_Npcs_Npcs1` FOREIGN KEY (`codigo_npc`) REFERENCES `npcs` (`codigo_npc`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `escudosnpcs`
--
ALTER TABLE `escudosnpcs`
ADD CONSTRAINT `fk_Npcs_has_Escudos_Escudos1` FOREIGN KEY (`codigo_escudo`) REFERENCES `escudos` (`codigo_escudo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Npcs_has_Escudos_Npcs1` FOREIGN KEY (`codigo_npc`) REFERENCES `npcs` (`codigo_npc`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `jogadorespersonagens`
--
ALTER TABLE `jogadorespersonagens`
ADD CONSTRAINT `fk_Jogadores_Personagens_Jogadores1` FOREIGN KEY (`codigo_jogador`) REFERENCES `jogadores` (`codigo_jogador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Jogadores_Personagens_Personagens1` FOREIGN KEY (`codigo_personagem`) REFERENCES `personagens` (`codigo_personagem`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `npcscombatentes`
--
ALTER TABLE `npcscombatentes`
ADD CONSTRAINT `fk_Npc_combatentes_Npcs1` FOREIGN KEY (`codigo_npc`) REFERENCES `npcs` (`codigo_npc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Npc_combatentes_Personagens1` FOREIGN KEY (`codigo_personagem`) REFERENCES `personagens` (`codigo_personagem`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `npcsfalas`
--
ALTER TABLE `npcsfalas`
ADD CONSTRAINT `fk_Npcs_has_Falas_Falas1` FOREIGN KEY (`codigo_fala`) REFERENCES `falas` (`codigo_fala`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Npcs_has_Falas_Npcs1` FOREIGN KEY (`codigo_npc`) REFERENCES `npcs` (`codigo_npc`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `periciapersonagem`
--
ALTER TABLE `periciapersonagem`
ADD CONSTRAINT `fk_Pericia_Personagem_Pericias1` FOREIGN KEY (`codigo_pericia`) REFERENCES `pericias` (`codigo_pericia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Pericia_Personagem_Personagens1` FOREIGN KEY (`codigo_personagem`) REFERENCES `personagens` (`codigo_personagem`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `periciasclasses`
--
ALTER TABLE `periciasclasses`
ADD CONSTRAINT `fk_pericias_classe_Pericias1` FOREIGN KEY (`codigo_pericia`) REFERENCES `pericias` (`codigo_pericia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_pericias_classe_classes1` FOREIGN KEY (`codigo_classe`) REFERENCES `classes` (`codigo_classe`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `periciasposicoes`
--
ALTER TABLE `periciasposicoes`
ADD CONSTRAINT `fk_Pericias_has_Posicoes_Pericias1` FOREIGN KEY (`codigo_pericia`) REFERENCES `pericias` (`codigo_pericia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Pericias_has_Posicoes_Posicoes1` FOREIGN KEY (`codigo_posicao`) REFERENCES `posicoes` (`codigo_posicao`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `periciasracas`
--
ALTER TABLE `periciasracas`
ADD CONSTRAINT `fk_Pericias_has_Raca_Pericias1` FOREIGN KEY (`codigo_pericia`) REFERENCES `pericias` (`codigo_pericia`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Pericias_has_Raca_Raca1` FOREIGN KEY (`codigo_raca`) REFERENCES `raca` (`codigo_raca`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `personagemclasse`
--
ALTER TABLE `personagemclasse`
ADD CONSTRAINT `fk_personagem_classe_Personagens1` FOREIGN KEY (`codigo_personagem`) REFERENCES `personagens` (`codigo_personagem`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_personagem_classe_classes` FOREIGN KEY (`codigo_classe`) REFERENCES `classes` (`codigo_classe`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `personagens`
--
ALTER TABLE `personagens`
ADD CONSTRAINT `fk_Personagens_Classes1` FOREIGN KEY (`codigo_classe`) REFERENCES `classes` (`codigo_classe`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Personagens_Raca1` FOREIGN KEY (`codigo_raca`) REFERENCES `raca` (`codigo_raca`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `personagensarmaduras`
--
ALTER TABLE `personagensarmaduras`
ADD CONSTRAINT `fk_Itens_Armaduras_Armaduras1` FOREIGN KEY (`codigo_armadura`) REFERENCES `armaduras` (`codigo_armadura`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Itens_Armaduras_Personagens1` FOREIGN KEY (`codigo_personagem`) REFERENCES `personagens` (`codigo_personagem`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `personagensarmas`
--
ALTER TABLE `personagensarmas`
ADD CONSTRAINT `fk_Itens_Armas_Armas1` FOREIGN KEY (`codigo_arma`) REFERENCES `armas` (`codigo_arma`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Itens_Armas_Personagens1` FOREIGN KEY (`codigo_personagem`) REFERENCES `personagens` (`codigo_personagem`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `personagensconsumiveis`
--
ALTER TABLE `personagensconsumiveis`
ADD CONSTRAINT `fk_Itens_Consumiveis_Consumiveis1` FOREIGN KEY (`codigo_consumivel`) REFERENCES `consumiveis` (`codigo_consumivel`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Itens_Consumiveis_Personagens1` FOREIGN KEY (`codigo_personagem`) REFERENCES `personagens` (`codigo_personagem`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `personagensescudos`
--
ALTER TABLE `personagensescudos`
ADD CONSTRAINT `fk_Itens_Escudos_Escudos1` FOREIGN KEY (`codigo_escudo`) REFERENCES `escudos` (`codigo_escudo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Itens_Escudos_Personagens1` FOREIGN KEY (`codigo_personagem`) REFERENCES `personagens` (`codigo_personagem`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `posicoes`
--
ALTER TABLE `posicoes`
ADD CONSTRAINT `fk_Posicoes_Caminhos1` FOREIGN KEY (`codigo_caminho`) REFERENCES `caminhos` (`codigo_caminho`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `posicoesnpcs`
--
ALTER TABLE `posicoesnpcs`
ADD CONSTRAINT `fk_Posicoes_has_Npcs_Npcs1` FOREIGN KEY (`codigo_npc`) REFERENCES `npcs` (`codigo_npc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Posicoes_has_Npcs_Posicoes1` FOREIGN KEY (`codigo_posicao`) REFERENCES `posicoes` (`codigo_posicao`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `progressaotalento`
--
ALTER TABLE `progressaotalento`
ADD CONSTRAINT `fk_progressao_talento_Talentos1` FOREIGN KEY (`codigo_talento`) REFERENCES `talentos` (`codigo_talento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_progressao_talento_tabela_progressao1` FOREIGN KEY (`codigo_progressao`) REFERENCES `progressoes` (`codigo_progressao`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `progressoes`
--
ALTER TABLE `progressoes`
ADD CONSTRAINT `fk_tabela_progressao_classes1` FOREIGN KEY (`classes_codigo_classe`) REFERENCES `classes` (`codigo_classe`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `talentospersonagem`
--
ALTER TABLE `talentospersonagem`
ADD CONSTRAINT `fk_talentos_personagem_Personagens1` FOREIGN KEY (`codigo_personagem`) REFERENCES `personagens` (`codigo_personagem`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_talentos_personagem_Talentos1` FOREIGN KEY (`codigo_talento`) REFERENCES `talentos` (`codigo_talento`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `temporario`
--
ALTER TABLE `temporario`
ADD CONSTRAINT `fk_Temporario_Personagens1` FOREIGN KEY (`codigo_personagem`) REFERENCES `personagens` (`codigo_personagem`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
