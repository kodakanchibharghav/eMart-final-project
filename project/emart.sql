-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 13, 2020 at 01:30 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `emart`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill_details_table`
--

CREATE TABLE `bill_details_table` (
  `bill_details_id` int(20) NOT NULL,
  `bill_id` int(20) NOT NULL,
  `item_id` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill_details_table`
--

INSERT INTO `bill_details_table` (`bill_details_id`, `bill_id`, `item_id`) VALUES
(601, 701, 201),
(603, 703, 201),
(611, 716, 203),
(612, 717, 201),
(613, 717, 202),
(614, 718, 201),
(615, 718, 203),
(616, 718, 202),
(617, 719, 201),
(618, 720, 201),
(619, 721, 201),
(620, 722, 202),
(621, 722, 201),
(622, 723, 202),
(623, 724, 202),
(624, 725, 203),
(625, 726, 201),
(626, 727, 201),
(627, 728, 201),
(628, 729, 201),
(629, 730, 202),
(630, 731, 215),
(631, 732, 203),
(632, 733, 201),
(633, 734, 206),
(634, 735, 203),
(635, 736, 202),
(636, 737, 214);

-- --------------------------------------------------------

--
-- Table structure for table `bill_table`
--

CREATE TABLE `bill_table` (
  `bill_id` int(20) NOT NULL,
  `buyer_id` int(20) NOT NULL,
  `bill_type` varchar(50) NOT NULL,
  `bill_date` date NOT NULL,
  `bill_remarks` varchar(200) NOT NULL,
  `bill_amount` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill_table`
--

INSERT INTO `bill_table` (`bill_id`, `buyer_id`, `bill_type`, `bill_date`, `bill_remarks`, `bill_amount`) VALUES
(701, 1, 'debit', '2020-02-28', 'good', 2000),
(703, 1, 'debit', '2020-02-28', 'dcgfvf', 2000),
(716, 1, 'Debit', '2020-03-05', 'paid', 89900),
(717, 1, 'Debit', '2020-03-05', 'paid', 55000),
(718, 1, 'Debit', '2020-03-05', 'paid', 144900),
(719, 1, 'Debit', '2020-03-05', 'paid', 50000),
(720, 1, 'Debit', '2020-03-05', 'paid', 50000),
(721, 1, 'Debit', '2020-03-05', 'paid', 50000),
(722, 1, 'Debit', '2020-03-05', 'paid', 55000),
(723, 1, 'Debit', '2020-03-05', 'paid', 5000),
(724, 1, 'Debit', '2020-03-06', 'paid', 5000),
(725, 1, 'Debit', '2020-03-06', 'paid', 89900),
(726, 1, 'Debit', '2020-03-06', 'paid', 50000),
(727, 1, 'debit', '2020-02-28', 'dcgfvf', 2000),
(728, 1, 'debit', '2020-02-28', 'dcgfvf', 2000),
(729, 1, 'debit', '2020-02-28', 'dcgfvf', 2000),
(730, 1, 'Debit', '2020-03-10', 'paid', 5000),
(731, 7, 'Debit', '2020-03-11', 'paid', 3800),
(732, 7, 'Debit', '2020-03-11', 'paid', 89900),
(733, 9, 'Debit', '2020-03-12', 'paid', 300000),
(734, 7, 'Debit', '2020-03-13', 'paid', 2300),
(735, 7, 'Debit', '2020-03-13', 'paid', 89900),
(736, 7, 'Debit', '2020-03-13', 'paid', 5000),
(737, 7, 'Debit', '2020-03-13', 'paid', 1900);

-- --------------------------------------------------------

--
-- Table structure for table `buyer_signup_table`
--

CREATE TABLE `buyer_signup_table` (
  `buyer_id` int(20) NOT NULL,
  `buyer_username` varchar(50) NOT NULL,
  `buyer_password` varchar(10) NOT NULL,
  `buyer_email` varchar(20) NOT NULL,
  `buyer_mobile` bigint(10) NOT NULL,
  `buyer_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buyer_signup_table`
--

INSERT INTO `buyer_signup_table` (`buyer_id`, `buyer_username`, `buyer_password`, `buyer_email`, `buyer_mobile`, `buyer_date`) VALUES
(1, 'john', '1234', 'john@gmail.com', 1234567821, '2020-03-01'),
(2, 'bharghav', '12345', '12345@gmail.com', 123456789, '2020-01-02'),
(3, 'bharghav', '12345', '12345@gmail.com', 123456789, '2020-01-02'),
(4, 'vani', '123456', '123456@gmail.com', 123456789, '2020-01-02'),
(5, 'vani', '123456', '123456@gmail.com', 123456789, '2020-01-02'),
(6, 'test', 'test', 'test@jhf.com', 2222222222, '2020-03-10'),
(7, 'ram', '0911', '0911@gmail.com', 9515585052, '2020-03-10'),
(8, 'gnty', 'gj', '', 0, '2020-03-12'),
(9, 'pinky', '9515', 'pinky@gmail.com', 9515585052, '2020-03-12'),
(10, 'vinay', '0066', 'vinay@gmail.com', 9441601450, '2020-03-13');

-- --------------------------------------------------------

--
-- Table structure for table `category_table`
--

CREATE TABLE `category_table` (
  `category_id` int(20) NOT NULL,
  `category_name` varchar(50) NOT NULL,
  `category_brief` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category_table`
--

INSERT INTO `category_table` (`category_id`, `category_name`, `category_brief`) VALUES
(302, 'clothing', 'all types'),
(501, 'Electronics', 'Varieties of electronics like TV,Washing Machine'),
(502, 'Mobiles', 'Varieties of SmartPhones'),
(503, 'clothes', 'varieties of clothes'),
(504, 'footwear', 'varieties of footwear');

-- --------------------------------------------------------

--
-- Table structure for table `item_table`
--

CREATE TABLE `item_table` (
  `item_id` int(20) NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `item_image` varchar(200) NOT NULL,
  `item_price` int(40) NOT NULL,
  `item_stock` int(20) NOT NULL,
  `item_description` varchar(200) NOT NULL,
  `subcategory_id` int(10) NOT NULL,
  `item_remarks` varchar(400) NOT NULL,
  `seller_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item_table`
--

INSERT INTO `item_table` (`item_id`, `item_name`, `item_image`, `item_price`, `item_stock`, `item_description`, `subcategory_id`, `item_remarks`, `seller_id`) VALUES
(201, ' SamsungQ LED TV', 'https://images-na.ssl-images-amazon.com/images/I/71nxdM4AwpL._SY355_.jpg', 300000, 5, 'Samsung QLED samrt UltraHd with crystal display', 101, 'good product with all android features. INTERNET inside.!', 401),
(202, 'Headphones', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcS3RwvfeMVgJpOQJCXXXuEPoebWcbHqjrJXd2RzY9JoveKIRUxO', 5000, 5, 'Sony wireless head phones with Noise Cancellation', 102, 'good product with high quality sound\r\n', 401),
(203, 'iphonexs', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQcMnraCcsNYw57YXEGNLhh_X_K-oIUH9S9zqsELD6CZtQhoD0vbKldLlnVNl5GuvPyIN3v3jg&usqp=CAc', 89900, 5, 'Apple iphone11 midnight black', 102, 'Fast as light', 401),
(204, 'LG Qhd Smart TV', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR7EXdSm7waZ2SR4uGS8-EaIQVqwh-GGEVQBujy-Vtb60sKmnSt', 350000, 3, 'Smart Tv with Wifi connection ', 101, 'Crystal display with dolbby atmos', 401),
(205, 'samsung M30s', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQuGOZ7wG54B5j5v5zNjXvL63jIIUVSJSXB9RFiOlV1K239c2RVWugBy1Ge6-rWsnZg9XSJCG0&usqp=CAc', 15000, 5, 'Super Hd display ', 104, 'Experience The Speed', 401),
(206, 'Puma Sports Shoe', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSIkDoSn9Rb6SEEjs4Ct8wFoslzQcoPXosSNkf1MDO-0ZVjEatj', 2300, 3, 'Sports shoe with top lace', 105, 'milatary green with bottom Sole', 401),
(207, 'roadstar casual shoes', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRJewq7yEes6b5lJJKcEKrQjun2b6-ObAXLCwdPbJQmXW7JoOJLyS2nWYThBQ&usqp=CAc', 2800, 4, 'Casual sole shoe', 105, 'casual shoe with smooth sole ', 401),
(208, 'Nike Sliders', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQjpTPLpz7Yez73XWoF4a9GbyL4slaHIrbV2iL7cu4kni7X8NKf', 1800, 6, 'Smooth sliders with comfort sole', 106, 'feel the comfort', 401),
(209, 'Crocs', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ1BuPtRCbbk0Oh0P7aKxkSw4ZGqjZrSP91CMCNOBIj2nBwxrfn', 3200, 2, 'Comfort and smooth', 106, 'Good Product', 401),
(210, ' Sony Bluetooth ', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTLnqpkb4CHLwmr2JQbWT1NdrjmAKaKNNRD_z1lsHh3vdkzE2wH', 3900, 5, 'Wc-400 with nsr', 102, 'good battery life and comfort to use', 401),
(211, 'checks Shirt', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQSwoT1U91ODG4cdP9q2WsEpBbU-L9BYiZpckl2d_pCqKTX78bc', 1800, 4, 'Smooth cotton', 107, 'comfort smooth cotton', 401),
(212, 'Floural shirts', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQg4xX599a5vNH1D8UdKEIfElpzEBCcNps-kSu8mw-6kFqOTkjC', 1300, 6, 'Printed floral shirt', 107, 'Flower print', 401),
(213, 'Toned Jeans', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRKN22_MA6o7U4vDbu9cSV8GoqsUf5CiYdXM2l9VRT9qLe5oqRy', 2600, 7, 'Blue toned denim jeans', 108, 'Ankle length and comfort', 401),
(214, 'casula jeans', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQSwVvZqQbDDkLm7KGaoz_QmuwVhjMpayCb3q_4KpkxRapB0I9r-LFHd3bNGlz9VAP3fl9xYTkF&usqp=CAc', 1900, 4, 'Dark blue denim', 108, 'Streach cotton', 401),
(215, 'Full Top', 'https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRwIjl-35T0w6VLA8G9rNPwdtJvzQGR_boeX2V9Z3AkYrc8hZ2L1jRe8vTblVQJEJEimhCslhk&usqp=CAc', 3800, 4, 'Yellow with gold borders', 109, 'Ethical and stylish\r\n', 401);

-- --------------------------------------------------------

--
-- Table structure for table `seller_signup_table`
--

CREATE TABLE `seller_signup_table` (
  `seller_id` int(20) NOT NULL,
  `seller_username` varchar(50) NOT NULL,
  `seller_password` varchar(10) NOT NULL,
  `seller_company` varchar(100) NOT NULL,
  `seller_brief` varchar(200) NOT NULL,
  `seller_gst` int(20) NOT NULL,
  `seller_address` varchar(100) NOT NULL,
  `seller_email` varchar(60) NOT NULL,
  `seller_contact` bigint(10) NOT NULL,
  `seller_website` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `seller_signup_table`
--

INSERT INTO `seller_signup_table` (`seller_id`, `seller_username`, `seller_password`, `seller_company`, `seller_brief`, `seller_gst`, `seller_address`, `seller_email`, `seller_contact`, `seller_website`) VALUES
(401, 'manik', '1234', 'zosh', 'ajhjkjhlj', 10, 'ramnagar', 'manik@gmail.com', 12345678, 'www.abc.com'),
(402, 'vani', '123456', 'abc', 'qwe', 12, 'sdfg', '123456@gmail.com', 1234567, 'www.com'),
(403, 'vani', '123456', 'abc', 'qwe', 12, 'sdfg', '123456@gmail.com', 1234567, 'www.com'),
(404, 'a', 'a', 'a', 'sas', 2, '101', 'fsd', 245244, 'fse'),
(405, 'c', 'c', 'c', 'cc', 2, '11', 'raghu@gmail.com', 8985890140, 'c.www.com'),
(406, 'q', 'q', 'q', 'q', 3, '12', 'q.gmail.com', 8985890105, 'www.com');

-- --------------------------------------------------------

--
-- Table structure for table `sub_category_table`
--

CREATE TABLE `sub_category_table` (
  `subcategory_id` int(20) NOT NULL,
  `subcategory_name` varchar(50) NOT NULL,
  `category_id` int(200) NOT NULL,
  `subcategory_brief` varchar(200) NOT NULL,
  `subcategory_gst` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sub_category_table`
--

INSERT INTO `sub_category_table` (`subcategory_id`, `subcategory_name`, `category_id`, `subcategory_brief`, `subcategory_gst`) VALUES
(101, 'LED', 501, 'Led 50 inches', 5),
(102, 'Headphones', 501, 'Sony', 5),
(103, 'iphonexs', 502, 'iphone', 5),
(104, 'Samsung M30s', 502, 'samsung', 5),
(105, 'Shoes', 504, 'Sports Shoe', 2),
(106, 'Flipflops', 504, 'flipflops andn sliders', 2),
(107, 'Casual shirt', 503, 'cotton casuals', 3),
(108, 'Jeans BottomWear', 503, 'Denim jeans', 13),
(109, 'WomenWear', 302, 'Women top wear', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill_details_table`
--
ALTER TABLE `bill_details_table`
  ADD PRIMARY KEY (`bill_details_id`),
  ADD KEY `bill_id` (`bill_id`),
  ADD KEY `item_id` (`item_id`);

--
-- Indexes for table `bill_table`
--
ALTER TABLE `bill_table`
  ADD PRIMARY KEY (`bill_id`),
  ADD KEY `buyer_id` (`buyer_id`);

--
-- Indexes for table `buyer_signup_table`
--
ALTER TABLE `buyer_signup_table`
  ADD PRIMARY KEY (`buyer_id`);

--
-- Indexes for table `category_table`
--
ALTER TABLE `category_table`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `item_table`
--
ALTER TABLE `item_table`
  ADD PRIMARY KEY (`item_id`),
  ADD KEY `subcategory_id` (`subcategory_id`),
  ADD KEY `seller_id` (`seller_id`);

--
-- Indexes for table `seller_signup_table`
--
ALTER TABLE `seller_signup_table`
  ADD PRIMARY KEY (`seller_id`);

--
-- Indexes for table `sub_category_table`
--
ALTER TABLE `sub_category_table`
  ADD PRIMARY KEY (`subcategory_id`),
  ADD KEY `sub_category_table_ibfk_1` (`category_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill_details_table`
--
ALTER TABLE `bill_details_table`
  MODIFY `bill_details_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=637;

--
-- AUTO_INCREMENT for table `bill_table`
--
ALTER TABLE `bill_table`
  MODIFY `bill_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=738;

--
-- AUTO_INCREMENT for table `buyer_signup_table`
--
ALTER TABLE `buyer_signup_table`
  MODIFY `buyer_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `category_table`
--
ALTER TABLE `category_table`
  MODIFY `category_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=505;

--
-- AUTO_INCREMENT for table `item_table`
--
ALTER TABLE `item_table`
  MODIFY `item_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=502;

--
-- AUTO_INCREMENT for table `seller_signup_table`
--
ALTER TABLE `seller_signup_table`
  MODIFY `seller_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=407;

--
-- AUTO_INCREMENT for table `sub_category_table`
--
ALTER TABLE `sub_category_table`
  MODIFY `subcategory_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=402;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill_details_table`
--
ALTER TABLE `bill_details_table`
  ADD CONSTRAINT `bill_details_table_ibfk_1` FOREIGN KEY (`bill_id`) REFERENCES `bill_table` (`bill_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bill_details_table_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `item_table` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `bill_table`
--
ALTER TABLE `bill_table`
  ADD CONSTRAINT `bill_table_ibfk_1` FOREIGN KEY (`buyer_id`) REFERENCES `buyer_signup_table` (`buyer_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `item_table`
--
ALTER TABLE `item_table`
  ADD CONSTRAINT `item_table_ibfk_1` FOREIGN KEY (`subcategory_id`) REFERENCES `sub_category_table` (`subcategory_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `item_table_ibfk_2` FOREIGN KEY (`seller_id`) REFERENCES `seller_signup_table` (`seller_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `sub_category_table`
--
ALTER TABLE `sub_category_table`
  ADD CONSTRAINT `sub_category_table_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category_table` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
