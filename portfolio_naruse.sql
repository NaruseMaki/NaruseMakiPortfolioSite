-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: 2018 年 4 朁E12 日 14:36
-- サーバのバージョン： 5.6.34-log
-- PHP Version: 7.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `portfolio`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `account`
--

CREATE TABLE `account` (
  `id` bigint(255) NOT NULL,
  `loginid` varchar(10) NOT NULL,
  `name` varchar(10) NOT NULL,
  `pass` varchar(150) NOT NULL,
  `address` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `account`
--

INSERT INTO `account` (`id`, `loginid`, `name`, `pass`, `address`) VALUES
(1, 'makimaki', 'makimaki', 'cf388c499ca3b298ee053c4caa3f511f8270a3a44c8858bb04468fb0581428736172111710798bb9', '大阪府東大阪市石切町 3-13-3'),
(2, 'モジバケ', 'もじばけ', '6131b346904cdb65e341102f31ba95d4951f48725a91363bfcdcad09346f7ae79ea2207fb69ee1d3', '大阪'),
(3, 'narusemaki', 'なるせまき', 'b001c08b1c1e135da77e4c7977a14ac1050fb911bfb756fc2034e1c08a7a1e1213b9143ecfc1b2c5', '大阪府柏原市大平寺'),
(4, 'naruru', 'naruru', 'ff2cb6e8bc47017f194def8a3b85bf372f7dc66e0a3551a4553fe313b8348494ac098d28d7426fa3', '奈良県生駒郡'),
(5, 'makki', 'マッキー', '454cdc7877db2a08a80b42647a66c771e96c50ac84341a82756b2d2ceebce446b5807ba8d93df480', '大阪府東大阪市'),
(6, 'naruse3', 'なるせ３', 'fce835759f5ba0ca866dea6e91c7e0537670b24026fe6665759e958a41610fbe1997a2e26646a9a3', '大阪府北区'),
(7, 'naruse4', 'なるせ４', '69b7cc5daf4ce7d28aa6cc33dc43123f21732bfb35e4930257e4fadb68be4b0495a29a320aa49040', '奈良県生駒市'),
(8, 'naruse5', 'なるせ５', '330ea52ae6b9caf87b3c5c2885fb632c4a80d0158534349f13756f5667db9f904007939486d4b0fd', '奈良県大和郡山市'),
(9, 'naruse6', 'なるせ６', '8a0bb021c35d59414fef72273a6a4b9fc34907d25ec05471cf8a2abc2ed5ab2eaa932b314473e96f', '奈良県北葛城郡');



-- --------------------------------------------------------

--
-- テーブルの構造 `cart`
--

CREATE TABLE `cart` (
  `accountid` bigint(255) NOT NULL,
  `productsid` bigint(255) NOT NULL,
  `cartid` bigint(255) NOT NULL,
  `name` varchar(20) NOT NULL,
  `price` int(11) NOT NULL,
  `maker` varchar(10) NOT NULL,
  `category` varchar(10) NOT NULL,
  `count` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `cart`
--

INSERT INTO `cart` (`accountid`, `productsid`, `cartid`, `name`, `price`, `maker`, `category`, `count`) VALUES
(1, 1, 1, 'ドラえもん①', 400, '小学館', '本', 1),
(1, 3, 2, 'ドラえもん②', 400, '小学館', '本', 1),
(1, 10, 3, '名探偵コナン①', 400, '小学館', '本', 2),
(4, 1, 4, 'ドラえもん①', 400, '小学館', '本', 7),
(4, 3, 5, 'ドラえもん②', 400, '小学館', '本', 1),
(4, 1, 6, 'ドラえもん①', 400, '小学館', '本', 1),
(4, 1, 7, 'ドラえもん①', 400, '小学館', '本', 1),
(4, 2, 8, '冷蔵庫', 100000, '東芝', '家電', 1),
(4, 2, 9, '冷蔵庫', 100000, '東芝', '家電', 1),
(5, 1, 10, 'ドラえもん①', 400, '小学館', '本', 1),
(5, 2, 11, '冷蔵庫', 100000, '東芝', '家電', 1),
(5, 2, 12, '冷蔵庫', 100000, '東芝', '家電', 1),
(6, 1, 13, 'ドラえもん①', 400, '小学館', '本', 1),
(6, 2, 14, '冷蔵庫', 100000, '東芝', '家電', 1),
(6, 3, 15, 'ドラえもん②', 400, '小学館', '本', 1),
(6, 4, 16, 'ドラゴンボール①', 400, '集英社', '本', 1),
(6, 6, 17, 'アンパンマン①', 400, 'フレーベル館', '本', 1),
(6, 7, 18, 'アンパンマン②', 400, 'フレーベル館', '本', 1),
(6, 8, 19, '北斗の拳①', 400, '集英社', '本', 1),
(6, 9, 20, '北斗の拳②', 400, '集英社', '本', 1),
(6, 10, 21, '名探偵コナン①', 400, '小学館', '本', 1),
(6, 12, 22, '掃除機', 60000, 'SHARP', '家電', 2),
(6, 20, 23, 'ファイナルファンタジー1', 1500, 'スクウェアエニックス', 'ゲーム', 2);



-- --------------------------------------------------------

--
-- テーブルの構造 `products`
--

CREATE TABLE `products` (
  `id` bigint(255) NOT NULL,
  `name` varchar(20) NOT NULL,
  `price` int(11) NOT NULL,
  `maker` varchar(10) NOT NULL,
  `category` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `products`
--

INSERT INTO `products` (`id`, `name`, `price`, `maker`, `category`) VALUES
(1, 'ドラえもん①', 400, '小学館', '本'),
(2, '冷蔵庫', 100000, '東芝', '家電'),
(3, 'ドラえもん②', 400, '小学館', '本'),
(4, 'ドラゴンボール①', 400, '集英社', '本'),
(5, 'ドラゴンボール②', 400, '集英社', '本'),
(6, 'アンパンマン①', 400, 'フレーベル館', '本'),
(7, 'アンパンマン②', 400, 'フレーベル館', '本'),
(8, '北斗の拳①', 400, '集英社', '本'),
(9, '北斗の拳②', 400, '集英社', '本'),
(10, '名探偵コナン①', 400, '小学館', '本'),
(11, '冷蔵庫', 80000, '三菱', '家電'),
(12, '掃除機', 60000, 'SHARP', '家電'),
(13, '空気清浄機', 25000, 'パナソニック', '家電'),
(14, '掃除機', 30000, '日立', '家電'),
(15, 'テレビ', 80000, 'ソニー', '家電'),
(16, 'テレビ', 60000, '東芝', '家電'),
(17, '空気清浄機', 20000, 'DAIKIN', '家電'),
(18, '掃除機', 20000, '東芝', '家電'),
(19, 'パソコン', 100000, 'ソニー', '家電'),
(20, 'ファイナルファンタジー1', 1500, 'スクウェアエニックス', 'ゲーム'),
(21, 'ファイナルファンタジー2', 3000, 'スクウェアエニックス', 'ゲーム'),
(22, 'ドラゴンクエスト1', 1000, 'スクウェアエニックス', 'ゲーム'),
(23, 'ドラゴンクエスト2', 2000, 'スクウェアエニックス', 'ゲーム'),
(24, 'ストリートファイター', 1200, 'カプコン', 'ゲーム'),
(25, 'マリオカート', 5000, '任天堂', 'ゲーム'),
(26, '星のカービィ', 3500, '任天堂', 'ゲーム'),
(27, '龍が如く', 4500, 'セガ', 'ゲーム'),
(28, 'メタルギアソリッド', 4500, 'コナミ', 'ゲーム'),
(29, 'ツインビー', 2500, 'コナミ', 'ゲーム'),
(30, 'レトルトカレー', 200, 'ハウス', '食品'),
(31, 'レトルトカレー辛口', 200, 'ハウス', '食品'),
(32, '味噌', 250, 'マルコメ', '食品'),
(33, 'オリーブオイル', 500, '日清', '食品'),
(34, 'カップラーメン', 150, '日清', '食品'),
(35, 'カップ焼きそば', 250, 'エースコック', '食品'),
(36, 'ポッキー', 120, 'グリコ', '食品'),
(37, 'チョコレート', 100, '明治', '食品'),
(38, 'ポテトチップス', 130, 'カルビー', '食品'),
(39, 'ポテトチップス', 130, '湖池屋', '食品'),
(40, '攻略本', 1200, '講談社', '本'),
(41, '洗濯機', 60000, '日立', '家電'),
(42, 'モンスターハンター', 5000, 'カプコン', 'ゲーム'),
(43, 'エリーゼ', 200, 'ブルボン', '食品'),
(44, '七つの大罪', 400, '小学館', '本');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cartid`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` bigint(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `cartid` bigint(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` bigint(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
