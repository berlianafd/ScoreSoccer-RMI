-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 31 Okt 2019 pada 00.54
-- Versi Server: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_soccer`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `soccerscore`
--

CREATE TABLE `soccerscore` (
  `teamName` varchar(25) NOT NULL,
  `P` int(11) NOT NULL DEFAULT '0',
  `W` int(11) NOT NULL DEFAULT '0',
  `D` int(11) NOT NULL DEFAULT '0',
  `L` int(11) NOT NULL DEFAULT '0',
  `F` int(11) NOT NULL DEFAULT '0',
  `A` int(11) NOT NULL DEFAULT '0',
  `GD` int(11) NOT NULL DEFAULT '0',
  `PTS` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `soccerscore`
--

INSERT INTO `soccerscore` (`teamName`, `P`, `W`, `D`, `L`, `F`, `A`, `GD`, `PTS`) VALUES
('Persib', 0, 0, 0, 0, 0, 0, 0, 0),
('Arema', 0, 0, 0, 0, 0, 0, 0, 0),
('Bali United', 1, 0, 0, 1, 2, 1, 1, 0),
('Madura United', 0, 0, 0, 0, 0, 0, 0, 0),
('Persela', 0, 0, 0, 0, 0, 0, 0, 0),
('PSIS', 0, 0, 0, 0, 0, 0, 0, 0),
('PSM', 0, 0, 0, 0, 0, 0, 0, 0),
('PSMS', 0, 0, 0, 0, 0, 0, 0, 0),
('Sriwijaya', 0, 0, 0, 0, 0, 0, 0, 0),
('Mitra Kukar', 1, 0, 0, 1, 3, 2, 1, 0),
('Persipura', 0, 0, 0, 0, 0, 0, 0, 0),
('Persebaya', 2, 2, 0, 0, 3, 5, -2, 6),
('Persija', 0, 0, 0, 0, 0, 0, 0, 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
