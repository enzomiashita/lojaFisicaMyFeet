-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 04/07/2023 às 00:12
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `my_feet`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbcarrinho`
--

CREATE TABLE `tbcarrinho` (
  `id_produto_carrinho` int(11) NOT NULL,
  `nome_produto` varchar(50) DEFAULT NULL,
  `preco_produto` float DEFAULT NULL,
  `tamanho_produto` varchar(100) DEFAULT NULL,
  `id_produto` int(11) DEFAULT NULL,
  `quantidade_produto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbcliente`
--

CREATE TABLE `tbcliente` (
  `id_cliente` int(11) NOT NULL,
  `nome_cliente` varchar(50) DEFAULT NULL,
  `endereco_cliente` text DEFAULT NULL,
  `telefoneFixo_cliente` varchar(50) DEFAULT NULL,
  `email_cliente` varchar(50) DEFAULT NULL,
  `sexo_cliente` varchar(50) DEFAULT NULL,
  `cpf_cliente` varchar(100) NOT NULL,
  `data_nascimento_cliente` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbfornecedor`
--

CREATE TABLE `tbfornecedor` (
  `id_fornecedor` int(11) NOT NULL,
  `cnpj` varchar(50) NOT NULL,
  `razao_social` varchar(50) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `endereco` text NOT NULL,
  `telefoneFixo` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbpedido`
--

CREATE TABLE `tbpedido` (
  `numero_pedido` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `data_pedido` varchar(10) NOT NULL,
  `ind_pedido_finalizado` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbproduto`
--

CREATE TABLE `tbproduto` (
  `id_produto` int(11) NOT NULL,
  `nome_produto` varchar(50) DEFAULT NULL,
  `preco_produto` float DEFAULT NULL,
  `tamanho_produto` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tbproduto`
--

INSERT INTO `tbproduto` (`id_produto`, `nome_produto`, `preco_produto`, `tamanho_produto`) VALUES
(1, 'Tenis addidas', 699.99, '35 a 40'),
(2, 'Tenis Nike', 799.99, '34, 35, 36, 37, 38, 39, 40, 41, 42');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tbprodutopedido`
--

CREATE TABLE `tbprodutopedido` (
  `numero_pedido` int(11) NOT NULL,
  `id_produto` int(11) NOT NULL,
  `nome_produto` varchar(45) NOT NULL,
  `quantidade_produto` int(11) NOT NULL,
  `preco_produto` float NOT NULL,
  `tamanho_produto` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `tbcarrinho`
--
ALTER TABLE `tbcarrinho`
  ADD PRIMARY KEY (`id_produto_carrinho`);

--
-- Índices de tabela `tbcliente`
--
ALTER TABLE `tbcliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Índices de tabela `tbfornecedor`
--
ALTER TABLE `tbfornecedor`
  ADD PRIMARY KEY (`id_fornecedor`);

--
-- Índices de tabela `tbpedido`
--
ALTER TABLE `tbpedido`
  ADD PRIMARY KEY (`numero_pedido`);

--
-- Índices de tabela `tbproduto`
--
ALTER TABLE `tbproduto`
  ADD PRIMARY KEY (`id_produto`);

--
-- Índices de tabela `tbprodutopedido`
--
ALTER TABLE `tbprodutopedido`
  ADD PRIMARY KEY (`numero_pedido`,`id_produto`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tbcarrinho`
--
ALTER TABLE `tbcarrinho`
  MODIFY `id_produto_carrinho` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de tabela `tbcliente`
--
ALTER TABLE `tbcliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de tabela `tbfornecedor`
--
ALTER TABLE `tbfornecedor`
  MODIFY `id_fornecedor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbpedido`
--
ALTER TABLE `tbpedido`
  MODIFY `numero_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de tabela `tbproduto`
--
ALTER TABLE `tbproduto`
  MODIFY `id_produto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `tbprodutopedido`
--
ALTER TABLE `tbprodutopedido`
  MODIFY `numero_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
