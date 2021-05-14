-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 14, 2021 at 04:21 PM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paf_rest_api`
--

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `project_id` int(20) NOT NULL,
  `projectName` varchar(250) NOT NULL,
  `projectDesc` varchar(250) NOT NULL,
  `projectType` varchar(250) NOT NULL,
  `manager_id` int(20) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`project_id`, `projectName`, `projectDesc`, `projectType`, `manager_id`, `startDate`, `endDate`) VALUES
(1, 'linux', 'any language', '1', 1, '2021-10-05', '2021-12-05'),
(5, 'New+Chrome+Engine', 'Java+language', '2', 2, '2021-05-07', '2021-06-07'),
(45, 'test', 'test', '1', 1, '2021-05-14', '2021-05-12'),
(46, 'PHP Application', 'Laravel Framework', '1', 1, '2021-05-14', '2021-05-22');

-- --------------------------------------------------------

--
-- Table structure for table `projectmanager`
--

CREATE TABLE `projectmanager` (
  `manager_id` int(20) NOT NULL,
  `managerName` varchar(250) NOT NULL,
  `email` varchar(250) DEFAULT NULL,
  `managerType` varchar(250) NOT NULL,
  `mobile` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `projectmanager`
--

INSERT INTO `projectmanager` (`manager_id`, `managerName`, `email`, `managerType`, `mobile`) VALUES
(1, 'Mr.silva', 'silva@example.com', 'fulltime', 178958541),
(2, 'Mr.Saman', NULL, '', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`project_id`);

--
-- Indexes for table `projectmanager`
--
ALTER TABLE `projectmanager`
  ADD PRIMARY KEY (`manager_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `project_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `projectmanager`
--
ALTER TABLE `projectmanager`
  MODIFY `manager_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
