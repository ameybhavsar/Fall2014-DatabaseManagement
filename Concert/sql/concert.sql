-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 05, 2014 at 06:21 AM
-- Server version: 5.5.39
-- PHP Version: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `concert_test`
--

-- --------------------------------------------------------

--
-- Table structure for table `Artist`
--

CREATE TABLE IF NOT EXISTS `Artist` (
  `artist_id` varchar(15) NOT NULL,
  `apassword` varchar(20) DEFAULT NULL,
  `artist_name` varchar(25) DEFAULT NULL,
  `profile` varchar(300) DEFAULT NULL,
  `artist_detailslink` varchar(75) DEFAULT NULL,
  `date_joined` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Artist`
--

INSERT INTO `Artist` (`artist_id`, `apassword`, `artist_name`, `profile`, `artist_detailslink`, `date_joined`) VALUES
('ax3', 'missshm', 'Axwell', 'Axwell-Check for updates here', 'www.axwell.art', '2014-11-28 16:28:43'),
('metallicaacc', 'metrocks', 'Metallica', 'This is Metallica official page', 'www.metallica.com', '2014-11-18 13:20:23'),
('pitbull', 'timberkesha', 'Pitbull', 'Hey yo!This is Pitbull', 'www.pitbullartist.com', '2014-11-22 04:28:23'),
('shm2014', 'axingseb', 'SwedishHouseMafia', 'The best EDM Band', 'www.shm.swe', '2014-11-22 04:20:23'),
('slash_ro', 'slashrock', 'Slash', 'Rule the skies', 'www.slashconcerts.net', '2014-09-08 08:22:23');

-- --------------------------------------------------------

--
-- Table structure for table `artist_plays`
--

CREATE TABLE IF NOT EXISTS `artist_plays` (
  `artist_id` varchar(15) NOT NULL DEFAULT '',
  `category` varchar(20) NOT NULL DEFAULT '',
  `subcategory` varchar(20) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artist_plays`
--

INSERT INTO `artist_plays` (`artist_id`, `category`, `subcategory`) VALUES
('ax3', 'EDM', 'House'),
('ax3', 'EDM', 'Trance'),
('metallicaacc', 'Rock', 'Rock Punk'),
('pitbull', 'Pop', 'Country Pop'),
('slash_ro', 'Rock', 'Acid Rock');

-- --------------------------------------------------------

--
-- Table structure for table `Concert`
--

CREATE TABLE IF NOT EXISTS `Concert` (
  `concert_id` varchar(6) NOT NULL,
  `artist_id` varchar(15) DEFAULT NULL,
  `concert_time` datetime DEFAULT NULL,
  `venue_name` varchar(20) DEFAULT NULL,
  `venue_city` varchar(20) DEFAULT NULL,
  `TicketRange` int(4) DEFAULT NULL,
  `availablity` int(4) DEFAULT NULL,
  `ticket_book_link` varchar(75) DEFAULT NULL,
  `post_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Concert`
--

INSERT INTO `Concert` (`concert_id`, `artist_id`, `concert_time`, `venue_name`, `venue_city`, `TicketRange`, `availablity`, `ticket_book_link`, `post_time`) VALUES
('c001', 'metallicaacc', '2014-12-08 18:00:00', 'Barclays Center', 'Brooklyn', 100, 670, 'www.metallica.com', '2014-12-05 05:09:03'),
('c102', 'pitbull', '2014-11-20 17:00:00', 'Madison Square', 'New York', 60, 1000, NULL, '2014-11-19 19:00:00'),
('c103', 'ax3', '2015-01-20 17:15:00', 'Dodger Stadium', 'Los Angeles', 90, 200, 'ticketgoose.com', '2014-11-23 19:33:00'),
('c104', 'ax3', '2015-01-21 17:15:00', 'Bader Field', 'Jersey City', 90, 100, 'ticketgoose.com', '2014-11-23 19:35:00');

-- --------------------------------------------------------

--
-- Table structure for table `fan_of`
--

CREATE TABLE IF NOT EXISTS `fan_of` (
  `user_id` varchar(15) NOT NULL DEFAULT '',
  `artist_id` varchar(15) NOT NULL DEFAULT '',
  `fan_join_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fan_of`
--

INSERT INTO `fan_of` (`user_id`, `artist_id`, `fan_join_date`) VALUES
('raghavrav4', 'ax3', '2014-11-24 03:20:23'),
('saisha92', 'metallicaacc', '2014-11-22 17:21:53'),
('saisha92', 'shm2014', '2014-11-22 18:15:03'),
('vijayasu', 'pitbull', '2014-11-24 01:50:53');

-- --------------------------------------------------------

--
-- Table structure for table `Music`
--

CREATE TABLE IF NOT EXISTS `Music` (
  `category` varchar(20) NOT NULL DEFAULT '',
  `subcategory` varchar(20) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Music`
--

INSERT INTO `Music` (`category`, `subcategory`) VALUES
('EDM', 'Dubstep'),
('EDM', 'House'),
('EDM', 'Trance'),
('Pop', 'C-Pop'),
('Pop', 'Country Pop'),
('Pop', 'Dance Pop'),
('Rock', 'Acid Rock'),
('Rock', 'Afro Punk'),
('Rock', 'Art Punk'),
('Rock', 'Death Metal');

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `user_id` varchar(15) NOT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `trustscore` int(2) DEFAULT NULL,
  `email_id` varchar(30) DEFAULT NULL,
  `upassword` varchar(20) DEFAULT NULL,
  `profile_details` varchar(200) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `last_access_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `date_joined` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`user_id`, `user_name`, `DOB`, `trustscore`, `email_id`, `upassword`, `profile_details`, `city`, `last_access_time`, `date_joined`) VALUES
('david', 'reddragon', '1990-12-24', 6, 'yike123@yahoo.com', 'hello123', NULL, 'Rochester', '2014-11-21 04:22:23', '2014-11-18 13:20:23'),
('lucy87', 'Lucy', '1988-01-04', 5, 'lucyneil@gmail.com', 'myconcertp', 'Everything about music fascinates me', 'San Diego', '2014-11-19 03:10:04', '2014-11-20 14:51:23'),
('marymusic', 'Martin', '1986-11-11', 2, 'martin.delo@gmail.com', 'doll123', 'A pop fan', 'San Diego', '2014-11-22 17:00:00', '2014-11-20 15:50:00'),
('raghavrav4', 'Raghav', '1992-10-22', 10, 'raghavrav4@hotmail.com', 'raghavabc', 'New Yorker who loves EDM', 'New York', '2014-12-05 05:09:03', '2014-12-05 05:09:03'),
('saisha92', 'Sai', '1991-01-11', 4, 'saisha.peace@gmail.com', 'saisu', 'Concerts are my thing', 'Los Angeles', '2014-12-05 05:09:03', '2014-11-22 15:00:00'),
('vijayasu', 'Vijay', '1993-02-14', 1, 'vijaysrr@yahoo.com', 'mynameiss', 'weird musics are my thing', 'Brooklyn', '2014-12-05 05:09:03', '2014-11-21 04:22:23');

-- --------------------------------------------------------

--
-- Table structure for table `user_AttendsorPlans`
--

CREATE TABLE IF NOT EXISTS `user_AttendsorPlans` (
  `user_id` varchar(15) NOT NULL DEFAULT '',
  `concert_id` varchar(15) NOT NULL DEFAULT '',
  `rating` int(2) DEFAULT NULL,
  `rating_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `rating_details` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_AttendsorPlans`
--

INSERT INTO `user_AttendsorPlans` (`user_id`, `concert_id`, `rating`, `rating_time`, `rating_details`) VALUES
('lucy87', 'c102', 2, '2014-11-24 01:50:53', 'Terrible Speakers'),
('raghavrav4', 'c103', 5, '2014-12-05 05:09:03', 'Amazing set to be played by Axwell :)'),
('saisha', 'c001', NULL, '2014-12-24 01:50:53', NULL),
('vijayasu', 'c102', 5, '2014-11-23 18:45:58', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_comments`
--

CREATE TABLE IF NOT EXISTS `user_comments` (
  `user_id` varchar(15) NOT NULL DEFAULT '',
  `concert_id` varchar(15) NOT NULL DEFAULT '',
  `comment_text` varchar(100) DEFAULT NULL,
  `comment_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_comments`
--

INSERT INTO `user_comments` (`user_id`, `concert_id`, `comment_text`, `comment_time`) VALUES
('lucy87', 'c102', 'Not worth the price', '2014-11-22 16:31:53'),
('marymusic', 'c001', 'This is going to be best concert of decade', '2014-11-12 14:31:53'),
('raghavrav4', 'c103', 'OMG!cannot wait toa see axwell', '2014-12-08 17:45:30'),
('raghavrav4', 'c103', 'He is playing a 3 hour set', '2014-12-08 17:46:32');

-- --------------------------------------------------------

--
-- Table structure for table `user_follows`
--

CREATE TABLE IF NOT EXISTS `user_follows` (
  `user_id` varchar(15) NOT NULL DEFAULT '',
  `follow_id` varchar(15) NOT NULL DEFAULT '',
  `follow_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_follows`
--

INSERT INTO `user_follows` (`user_id`, `follow_id`, `follow_time`) VALUES
('raghavrav', 'saisha92', '2014-12-05 05:09:03'),
('saisha92', 'raghavrav4', '2014-12-05 05:09:03'),
('vijayasu', 'lucy87', '2014-11-24 03:20:23');

-- --------------------------------------------------------

--
-- Table structure for table `user_likes`
--

CREATE TABLE IF NOT EXISTS `user_likes` (
  `user_id` varchar(15) NOT NULL DEFAULT '',
  `category` varchar(20) NOT NULL DEFAULT '',
  `subcategory` varchar(20) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_likes`
--

INSERT INTO `user_likes` (`user_id`, `category`, `subcategory`) VALUES
('david', 'Pop', 'Country Pop'),
('marymusic', 'Rock', 'Death Metal'),
('raghavrav4', 'EDM', 'Dubstep'),
('raghavrav4', 'EDM', 'House'),
('raghavrav4', 'EDM', 'Trance'),
('saisha92', 'Rock', 'Country'),
('vijayasu', 'Pop', 'Country Pop'),
('vijayasu', 'Pop', 'Dance Pop');

-- --------------------------------------------------------

--
-- Table structure for table `user_recommends`
--

CREATE TABLE IF NOT EXISTS `user_recommends` (
  `user_id` varchar(15) NOT NULL DEFAULT '',
  `list_name` varchar(25) NOT NULL DEFAULT '',
  `concert_id` varchar(15) NOT NULL DEFAULT '',
  `time_recommended` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_recommends`
--

INSERT INTO `user_recommends` (`user_id`, `list_name`, `concert_id`, `time_recommended`) VALUES
('raghavrav4', 'Axwell Jan Concerts', 'c103', '2014-11-23 19:50:53'),
('raghavrav4', 'Axwell Jan Concerts', 'c104', '2014-11-23 19:51:53'),
('saisha', 'my rock concerts', 'c001', '2014-11-24 03:20:23');

-- --------------------------------------------------------

--
-- Table structure for table `Venue`
--

CREATE TABLE IF NOT EXISTS `Venue` (
  `v_name` varchar(20) NOT NULL DEFAULT '',
  `v_city` varchar(20) NOT NULL DEFAULT '',
  `address` varchar(30) DEFAULT NULL,
  `capacity` int(5) DEFAULT NULL,
  `v_detail_link` varchar(75) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Venue`
--

INSERT INTO `Venue` (`v_name`, `v_city`, `address`, `capacity`, `v_detail_link`) VALUES
('Bader Field', 'Jersey City', 'Atlantic County 1228', 1098, 'bdrfld.com'),
('Barclays Center', 'Brooklyn', '620 Brooklyn NY 11217', 3500, 'www.barclayscenter.com'),
('Dodger Stadium', 'Los Angeles', '1000 Elysian Park 90012', 2324, 'losangeles.dodgers.mlb.com'),
('Madison Square', 'New York', ' Pennsylvania Plaza 11201', 10000, 'www.thegarden.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Artist`
--
ALTER TABLE `Artist`
 ADD PRIMARY KEY (`artist_id`);

--
-- Indexes for table `artist_plays`
--
ALTER TABLE `artist_plays`
 ADD PRIMARY KEY (`artist_id`,`category`,`subcategory`);

--
-- Indexes for table `Concert`
--
ALTER TABLE `Concert`
 ADD PRIMARY KEY (`concert_id`);

--
-- Indexes for table `fan_of`
--
ALTER TABLE `fan_of`
 ADD PRIMARY KEY (`user_id`,`artist_id`);

--
-- Indexes for table `Music`
--
ALTER TABLE `Music`
 ADD PRIMARY KEY (`category`,`subcategory`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
 ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_AttendsorPlans`
--
ALTER TABLE `user_AttendsorPlans`
 ADD PRIMARY KEY (`user_id`,`concert_id`);

--
-- Indexes for table `user_comments`
--
ALTER TABLE `user_comments`
 ADD PRIMARY KEY (`user_id`,`concert_id`,`comment_time`);

--
-- Indexes for table `user_follows`
--
ALTER TABLE `user_follows`
 ADD PRIMARY KEY (`user_id`,`follow_id`);

--
-- Indexes for table `user_likes`
--
ALTER TABLE `user_likes`
 ADD PRIMARY KEY (`user_id`,`category`,`subcategory`);

--
-- Indexes for table `user_recommends`
--
ALTER TABLE `user_recommends`
 ADD PRIMARY KEY (`user_id`,`list_name`,`concert_id`);

--
-- Indexes for table `Venue`
--
ALTER TABLE `Venue`
 ADD PRIMARY KEY (`v_name`,`v_city`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
