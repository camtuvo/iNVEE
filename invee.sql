-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Apr 11, 2022 at 01:00 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `saturdayhigh2`
--

-- --------------------------------------------------------

--
-- Table structure for table `orderdetail`
--

CREATE TABLE `orderdetail` (
  `ID` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `orderid` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `productid` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sizeid` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `totalprice` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `orderdetail`
--

INSERT INTO `orderdetail` (`ID`, `orderid`, `productid`, `sizeid`, `price`, `quantity`, `totalprice`) VALUES
('ODT0000000', 'ORD0000001', 'PRO0000001', 'SIZ0000001', 7200000, 1, 7200000),
('ODT0000001', 'ORD0000002', 'PRO0000001', 'SIZ0000002', 7200000, 1, 7200000);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `ID` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `userid` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ordernumber` char(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(65) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `note` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `deliverto` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `totalprice` double DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `modifiedby` char(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`ID`, `userid`, `ordernumber`, `email`, `phone`, `note`, `deliverto`, `totalprice`, `status`, `createddate`, `modifieddate`, `modifiedby`) VALUES
('ORD0000001', 'USR0000003', '', 'tii1133@gmail.com', '0931000727', 'Giao sau 8h sáng', '695 xô viết nghệ tĩnh', 7230000, 0, '2022-03-30 16:33:07', NULL, NULL),
('ORD0000002', 'USR0000007', '', 'nq@gmail.com', '0938473774', '', '23 Le Lai Q1', 7230000, 0, '2022-04-04 10:24:39', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ID` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `brandid` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `categoryid` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `importprice` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `photo` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `createdby` char(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `modifiedby` char(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ID`, `brandid`, `categoryid`, `name`, `importprice`, `price`, `description`, `photo`, `status`, `createddate`, `createdby`, `modifieddate`, `modifiedby`) VALUES
('PRO0000001', 'BRD0000008', 'CAT0000001', 'VÒNG MẮT HỔ VÀNG TÂM', 5000000, 1220000, 'MẠNG PHÙ HỢP: KIM - THỦY', 'kim-1.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),
('PRO0000002', 'BRD0000004', 'CAT0000001', 'VÒNG MOONSTONE', 5000000, 2760000, 'MẠNG PHÙ HỢP: KIM - THỦY', 'kim-2.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),
('PRO0000003', 'BRD0000004', 'CAT0000001', 'VÒNG MOONSTONE', 5000000, 2760000, 'MẠNG PHÙ HỢP: KIM - THỦY', 'kim-2.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),
('PRO0000004', 'BRD0000004', 'CAT0000001', 'VÒNG MOONSTONE', 5000000, 2760000, 'MẠNG PHÙ HỢP: KIM - THỦY', 'kim-2.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),
('PRO0000005', 'BRD0000004', 'CAT0000001', 'VÒNG MOONSTONE', 5000000, 2760000, 'MẠNG PHÙ HỢP: KIM - THỦY', 'kim-2.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),
('PRO0000006', 'BRD0000004', 'CAT0000001', 'VÒNG MOONSTONE', 5000000, 2760000, 'MẠNG PHÙ HỢP: KIM - THỦY', 'kim-2.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),

('PRO0000007', 'BRD0000003', 'CAT0000002', 'VÒNG AQUAMARINE', 5000000, 1780000, 'MẠNG PHÙ HỢP: MỘC - THỦY', 'thuy-1.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),
('PRO0000008', 'BRD0000003', 'CAT0000002', 'VÒNG AQUAMARINE', 5000000, 1780000, 'MẠNG PHÙ HỢP: MỘC - THỦY', 'thuy-1.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),
('PRO0000009', 'BRD0000010', 'CAT0000002', 'VÒNG JASPERE', 5000000, 925000, 'MẠNG PHÙ HỢP: MỘC - THỦY', 'thuy-2.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),
('PRO0000010', 'BRD0000010', 'CAT0000002','VÒNG JASPERE', 5000000, 1456000, 'MẠNG PHÙ HỢP: MỘC - THỦY', 'thuy-3.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),

('PRO0000011', 'BRD0000008', 'CAT0000003','VÒNG MẮT HỔ VÀNG NÂU', 5000000, 1456000, 'MẠNG PHÙ HỢP: KIM - THỔ', 'moc-1.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),
('PRO0000012', 'BRD0000008', 'CAT0000003', 'VÒNG MẮT HỔ VÀNG NÂU', 5000000, 1456000, 'MẠNG PHÙ HỢP: KIM - THỔ', 'moc-1.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),
('PRO0000013', 'BRD0000008', 'CAT0000003', 'VÒNG MẮT HỔ VÀNG NÂU', 5000000, 1456000, 'MẠNG PHÙ HỢP: KIM - THỔ', 'moc-1.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),

('PRO0000014', 'BRD0000002', 'CAT0000004', 'VÒNG THẠCH ANH HỒNG - KID', 5000000, 1456000, 'MẠNG PHÙ HỢP: HỎA - THỔ', 'hoa-1.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),
('PRO0000015', 'BRD0000006', 'CAT0000004', 'VÒNG GARNET SAO', 5000000, 2285000, 'MẠNG PHÙ HỢP: HỎA - THỔ', 'hoa-2.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),

('PRO0000016', 'BRD0000008', 'CAT0000005', 'VÒNG GARNET SAO', 5000000, 2285000, 'MẠNG PHÙ HỢP: HỎA - THỔ', 'hoa-2.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),
('PRO0000017', 'BRD0000008', 'CAT0000005', 'VÒNG MẮT HỔ VÀNG NÂU', 5000000, 1456000, 'MẠNG PHÙ HỢP: KIM - THỔ', 'moc-1.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),
('PRO0000018', 'BRD0000008', 'CAT0000005', 'VÒNG MẮT HỔ VÀNG NÂU', 5000000, 1456000, 'MẠNG PHÙ HỢP: KIM - THỔ', 'moc-1.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),
('PRO0000019', 'BRD0000008', 'CAT0000005', 'VÒNG MẮT HỔ VÀNG NÂU', 5000000, 1456000, 'MẠNG PHÙ HỢP: KIM - THỔ', 'moc-1.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),

('PRO0000020', 'BRD0000003', 'CAT0000003', 'VÒNG AQUAMARINE', 5000000, 1780000, 'MẠNG PHÙ HỢP: MỘC - THỦY', 'thuy-1.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),
('PRO0000021', 'BRD0000003', 'CAT0000003', 'VÒNG AQUAMARINE', 5000000, 1780000, 'MẠNG PHÙ HỢP: MỘC - THỦY', 'thuy-1.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),
('PRO0000022', 'BRD0000010', 'CAT0000003', 'VÒNG JASPERE', 5000000, 925000, 'MẠNG PHÙ HỢP: MỘC - THỦY', 'thuy-2.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001'),
('PRO0000023', 'BRD0000010', 'CAT0000003', 'VÒNG JASPERE', 5000000, 1456000, 'MẠNG PHÙ HỢP: MỘC - THỦY', 'thuy-3.jpg', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-30 00:00:00', 'USR0000001');

-- --------------------CAT0000003------------------------------------

--
-- Table structure for table `productbrand`
--

CREATE TABLE `productbrand` (
  `ID` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `photo` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `createdby` char(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `modifiedby` char(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `productbrand`
--

INSERT INTO `productbrand` (`ID`, `name`, `photo`, `description`, `status`, `createddate`, `createdby`, `modifieddate`, `modifiedby`) VALUES
('BRD0000001', 'Thạch Anh', 'BRD_1.jpg', '', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-31 00:00:00', 'USR0000001'),
('BRD0000002', 'Cẩm Thạch', 'BRD_2.jpg', '', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-31 00:00:00', 'USR0000001'),
('BRD0000003', 'AQUAMARINE', 'BRD_3.jpg', '', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-31 00:00:00', 'USR0000001'),
('BRD0000004', 'MOONSTONE', 'BRD_4.jpg', '', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-31 00:00:00', 'USR0000001'),
('BRD0000005', 'MẮT DIỀU HÂU', 'BRD_5.jpg', '', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-31 00:00:00', 'USR0000001'),
('BRD0000006', 'GARNET', 'BRD_6.jpg', '', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-31 00:00:00', 'USR0000001'),
('BRD0000007', 'SAN HÔ', 'BRD_7.jpg', '', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-31 00:00:00', 'USR0000001'),
('BRD0000008', 'MẮT HỔ', 'BRD_8.jpg', '', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-31 00:00:00', 'USR0000001'),
('BRD0000009', 'SUNSTONE', 'BRD_9.jpg', '', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-31 17:07:22', 'USR0000001'),
('BRD0000010', 'JASPERE', 'BRD_10.jpg', '', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-31 17:15:24', 'USR0000001');

-- --------------------------------------------------------

--
-- Table structure for table `productcategory`
--

CREATE TABLE `productcategory` (
  `ID` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `createdby` char(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `modifiedby` char(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `productcategory`
--

INSERT INTO `productcategory` (`ID`, `name`, `description`, `status`, `createddate`, `createdby`, `modifieddate`, `modifiedby`) VALUES
('CAT0000001', 'Kim', '', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-31 00:00:00', 'USR0000001'),
('CAT0000002', 'Thủy', '', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-31 00:00:00', 'USR0000001'),
('CAT0000003', 'Mộc', '', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-31 00:00:00', 'USR0000001'),
('CAT0000004', 'Hỏa', '', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-31 00:00:00', 'USR0000001'),
('CAT0000005', 'Thổ', '', 1, '2022-03-30 00:00:00', 'USR0000001', '2022-03-31 23:12:48', 'USR0000001');

-- --------------------------------------------------------

--
-- Table structure for table `settinghomeimage`
--

CREATE TABLE `settinghomeimage` (
  `ID` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `caption` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `content` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `photo` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `createdby` char(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `modifiedby` char(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `settinghomeimage`
--

INSERT INTO `settinghomeimage` (`ID`, `caption`, `content`, `photo`, `status`, `createddate`, `createdby`, `modifieddate`, `modifiedby`) VALUES
('HOM0000001', 'Trending', NULL, 'bg-1.jpg', 1, '2022-04-01 00:00:00', 'USR0000001', NULL, NULL),
('HOM0000002', 'New', NULL, 'bg-2.jpg', 1, '2022-04-01 00:00:00', 'USR0000001', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `size`
--

CREATE TABLE `size` (
  `ID` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `size`
--

INSERT INTO `size` (`ID`, `name`) VALUES
('SIZ0000001', 'XS'),
('SIZ0000002', 'S'),
('SIZ0000003', 'M'),
('SIZ0000004', 'L'),
('SIZ0000005', 'XL'),
('SIZ0000006', 'XXL'),
('SIZ0000007', '28'),
('SIZ0000008', '30'),
('SIZ0000009', '32'),
('SIZ0000010', '36'),
('SIZ0000011', 'OS');

-- --------------------------------------------------------

--
-- Table structure for table `sizedetail`
--

CREATE TABLE `sizedetail` (
  `ID` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `productid` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `sizeid` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `createdby` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `modifiedby` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `totalsale` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sizedetail`
--

INSERT INTO `sizedetail` (`ID`, `productid`, `sizeid`, `quantity`, `createddate`, `createdby`, `modifieddate`, `modifiedby`, `totalsale`) VALUES
('SDT0000001', 'PRO0000001', 'SIZ0000001', 10, '2022-03-30 11:14:51', 'USR0000001', '2022-03-31 11:14:51', 'USR0000001', 11),
('SDT0000002', 'PRO0000001', 'SIZ0000002', 10, '2022-03-30 11:14:51', 'USR0000001', '2022-03-31 11:14:51', 'USR0000001', 5),
('SDT0000003', 'PRO0000001', 'SIZ0000003', 10, '2022-03-30 11:14:51', 'USR0000001', '2022-03-31 11:14:51', 'USR0000001', 2),
('SDT0000004', 'PRO0000001', 'SIZ0000004', 10, '2022-03-30 11:14:51', 'USR0000001', '2022-03-31 11:14:51', 'USR0000001', 0),
('SDT0000005', 'PRO0000002', 'SIZ0000001', 10, '2022-03-30 11:14:51', 'USR0000001', '2022-03-31 11:14:51', 'USR0000001', 0),
('SDT0000006', 'PRO0000002', 'SIZ0000002', 10, '2022-03-30 11:14:51', 'USR0000001', '2022-03-31 11:14:51', 'USR0000001', 10),
('SDT0000007', 'PRO0000002', 'SIZ0000003', 10, '2022-03-30 11:14:51', 'USR0000001', '2022-03-31 11:14:51', 'USR0000001', 1),
('SDT0000009', 'PRO0000002', 'SIZ0000004', 10, '2022-03-30 00:09:10', 'USR0000001', '2022-03-31 21:43:16', 'USR0000001', 0),
('SDT0000010', 'PRO0000003', 'SIZ0000001', 10, '2021-06-18 21:51:44', '', NULL, NULL, NULL),
('SDT0000011', 'PRO0000003', 'SIZ0000002', 10, '2021-06-18 21:52:08', '', NULL, NULL, NULL),
('SDT0000012', 'PRO0000004', 'SIZ0000001', 10, '2021-06-18 21:54:05', '', NULL, NULL, NULL),
('SDT0000013', 'PRO0000004', 'SIZ0000003', 20, '2021-06-18 21:54:13', '', NULL, NULL, NULL),
('SDT0000014', 'PRO0000011', 'SIZ0000011', 10, '2021-06-18 22:00:03', '', NULL, NULL, NULL),
('SDT0000015', 'PRO0000012', 'SIZ0000011', 10, '2021-06-18 22:00:22', '', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `useraccount`
--

CREATE TABLE `useraccount` (
  `ID` char(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `photo` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(65) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `username` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `isadmin` tinyint(1) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `createdby` char(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifieddate` datetime DEFAULT NULL,
  `modifiedby` char(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `useraccount`
--

INSERT INTO `useraccount` (`ID`, `photo`, `name`, `email`, `phone`, `address`, `birthday`, `gender`, `username`, `password`, `status`, `isadmin`, `createddate`, `createdby`, `modifieddate`, `modifiedby`) VALUES
('USR0000001', 'null', 'John Pham', 'john@gmail.com', '0123456787', '81 Lê lợi P26 Binh Thanh', '2019-09-13', 0, 'superadmin', '$2a$12$KwJFI5pmrlrE52ZRathshefuFTWHOUMNn5cJk9yUp2Y942T4zwQRq', 1, 2, '2022-04-06 13:21:00', 'USR0000001', NULL, NULL),
('USR0000002', '', 'Jack Nguyen', 'jack@gmail.com', '0623456788', '71 Trương Định', '2019-09-17', 0, 'admin', '$2a$12$KwJFI5pmrlrE52ZRathshefuFTWHOUMNn5cJk9yUp2Y942T4zwQRq', 1, 1, '2022-04-06 23:11:49', 'USR0000001', '2022-04-06 20:23:20', 'USR0000001'),
('USR0000003', 'null', 'Phan Minh Hùng', 'tii1133@gmail.com', '0931000727', '695 xô viết nghệ tĩnh', '2021-05-31', 0, 'custoemr4', '$2a$12$EkC1tbJrRSGO6pZB8ld9QeYH3qpYWVCVIcI1kgK.MREXppVlGzcee', 1, 0, '2022-03-30 00:40:01', 'USR0000001', NULL, NULL),
('USR0000004', 'null', 'Lê Bảo', 'ssss@gmail.com', '0989939339', '31 Hồ Hải', '2021-05-31', 0, 'custoemr2', '$2a$12$KwJFI5pmrlrE52ZRathshefuFTWHOUMNn5cJk9yUp2Y942T4zwQRq', 1, 0, '2022-03-31 00:41:15', 'USR0000001', NULL, NULL),
('USR0000005', 'null', 'Hải Tú', 'sssq@gmail.com', '0977766545', '695 xô viết nghệ tĩnh', '2021-06-02', 1, 'customer1', '$2a$12$jUBghCKDmqcRcjkE3pDdSel6hOVrZvd7CvI7FkETt6DKpf6kNHaGu', 1, 0, '2022-04-01 22:46:26', 'USR0000001', NULL, NULL),
('USR0000006', 'null', 'Lê Bảo Bình', 'db@gmail.com', '0877766878', '81 Lê Duẩn', '2021-06-02', 2, 'custoemr3', '$2a$12$ly8jR/vmQsKoHMjvlYMYX.KLcR.2KpNsum.VV4tIaBoGZpaTjLQbS', 1, 0, '2022-04-01 22:50:58', 'USR0000001', NULL, NULL),
('USR0000007', '', 'Nhu Quynh Hien', 'nqs@gmail.com', '0938423774', '23 Le Lai Q1 HCM', '2000-01-02', 1, 'nhuquynh', '$2a$12$MhINO341CHoHcC.8cifGHuYjkd.DyjbmhyQ3HBcX5BMdZi0p2zDyq', 1, 0, '2022-04-03 18:56:51', NULL, '2022-04-06 20:23:52', 'USR0000001');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_4` (`orderid`),
  ADD KEY `fk_5` (`productid`),
  ADD KEY `fk_13` (`sizeid`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_3` (`userid`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_1` (`brandid`),
  ADD KEY `fk_2` (`categoryid`);

--
-- Indexes for table `productbrand`
--
ALTER TABLE `productbrand`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `productcategory`
--
ALTER TABLE `productcategory`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `settinghomeimage`
--
ALTER TABLE `settinghomeimage`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `size`
--
ALTER TABLE `size`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sizedetail`
--
ALTER TABLE `sizedetail`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_9` (`productid`),
  ADD KEY `fk_10` (`sizeid`);

--
-- Indexes for table `useraccount`
--
ALTER TABLE `useraccount`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `unique_username` (`username`),
  ADD UNIQUE KEY `unique_phone` (`phone`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD CONSTRAINT `fk_13` FOREIGN KEY (`sizeid`) REFERENCES `size` (`ID`),
  ADD CONSTRAINT `fk_4` FOREIGN KEY (`orderid`) REFERENCES `orders` (`ID`),
  ADD CONSTRAINT `fk_5` FOREIGN KEY (`productid`) REFERENCES `product` (`ID`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_3` FOREIGN KEY (`userid`) REFERENCES `useraccount` (`ID`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `fk_1` FOREIGN KEY (`brandid`) REFERENCES `productbrand` (`ID`),
  ADD CONSTRAINT `fk_2` FOREIGN KEY (`categoryid`) REFERENCES `productcategory` (`ID`);

--
-- Constraints for table `sizedetail`
--
ALTER TABLE `sizedetail`
  ADD CONSTRAINT `fk_10` FOREIGN KEY (`sizeid`) REFERENCES `size` (`ID`),
  ADD CONSTRAINT `fk_9` FOREIGN KEY (`productid`) REFERENCES `product` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
