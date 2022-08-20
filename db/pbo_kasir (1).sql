-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 20 Agu 2022 pada 10.59
-- Versi server: 10.4.19-MariaDB
-- Versi PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo_kasir`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `code` varchar(10) NOT NULL,
  `title` varchar(100) NOT NULL,
  `price` decimal(20,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `products`
--

INSERT INTO `products` (`id`, `code`, `title`, `price`) VALUES
(1, 'A001', 'Kecap', '1000'),
(2, 'A002', 'Saus', '750'),
(5, 'A003', 'mayonaiss', '1500');

-- --------------------------------------------------------

--
-- Struktur dari tabel `stocks`
--

CREATE TABLE `stocks` (
  `id` int(11) NOT NULL,
  `type` enum('in','out') NOT NULL DEFAULT 'in',
  `code` varchar(10) NOT NULL,
  `qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `stocks`
--

INSERT INTO `stocks` (`id`, `type`, `code`, `qty`) VALUES
(1, 'in', 'A001', 10),
(3, 'in', 'A002', 10),
(17, 'in', 'A001', 1),
(18, 'in', 'A001', 7),
(19, 'in', 'A002', 5),
(20, 'out', 'A001', 5),
(21, 'out', 'A002', 7),
(22, 'in', 'A002', 5),
(23, 'out', 'A001', 5),
(24, 'out', 'A002', 5);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `code_transaction` varchar(10) NOT NULL,
  `total_belanja` decimal(20,0) NOT NULL,
  `bayar` decimal(20,0) NOT NULL,
  `kembalian` decimal(20,0) NOT NULL,
  `tgl` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transaction`
--

INSERT INTO `transaction` (`id`, `code_transaction`, `total_belanja`, `bayar`, `kembalian`, `tgl`) VALUES
(1, 'TR814', '10250', '11000', '750', '2022-08-20'),
(2, 'TR565', '8750', '10000', '1250', '2022-08-20');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaction_item`
--

CREATE TABLE `transaction_item` (
  `id` int(11) NOT NULL,
  `code_transaction` varchar(10) NOT NULL,
  `code` varchar(10) NOT NULL,
  `qty` decimal(20,0) NOT NULL,
  `total` decimal(20,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transaction_item`
--

INSERT INTO `transaction_item` (`id`, `code_transaction`, `code`, `qty`, `total`) VALUES
(16, 'TR814', 'A001', '5', '5000'),
(17, 'TR814', 'A002', '7', '5250'),
(18, 'TR565', 'A001', '5', '5000'),
(19, 'TR565', 'A002', '5', '3750');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaction_temp`
--

CREATE TABLE `transaction_temp` (
  `id` int(11) NOT NULL,
  `code` varchar(10) NOT NULL,
  `qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'marcel', '123456'),
(4, 'desti', '1234'),
(5, 'safitri', '22222');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `code` (`code`);

--
-- Indeks untuk tabel `stocks`
--
ALTER TABLE `stocks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `code` (`code`);

--
-- Indeks untuk tabel `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `code_transaction` (`code_transaction`);

--
-- Indeks untuk tabel `transaction_item`
--
ALTER TABLE `transaction_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `code` (`code`);

--
-- Indeks untuk tabel `transaction_temp`
--
ALTER TABLE `transaction_temp`
  ADD PRIMARY KEY (`id`),
  ADD KEY `code` (`code`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `stocks`
--
ALTER TABLE `stocks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT untuk tabel `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `transaction_item`
--
ALTER TABLE `transaction_item`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT untuk tabel `transaction_temp`
--
ALTER TABLE `transaction_temp`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `stocks`
--
ALTER TABLE `stocks`
  ADD CONSTRAINT `stocks_ibfk_1` FOREIGN KEY (`code`) REFERENCES `products` (`code`);

--
-- Ketidakleluasaan untuk tabel `transaction_item`
--
ALTER TABLE `transaction_item`
  ADD CONSTRAINT `transaction_item_ibfk_1` FOREIGN KEY (`code`) REFERENCES `products` (`code`),
  ADD CONSTRAINT `transaction_item_ibfk_2` FOREIGN KEY (`code`) REFERENCES `products` (`code`);

--
-- Ketidakleluasaan untuk tabel `transaction_temp`
--
ALTER TABLE `transaction_temp`
  ADD CONSTRAINT `transaction_temp_ibfk_1` FOREIGN KEY (`code`) REFERENCES `products` (`code`),
  ADD CONSTRAINT `transaction_temp_ibfk_2` FOREIGN KEY (`code`) REFERENCES `products` (`code`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
