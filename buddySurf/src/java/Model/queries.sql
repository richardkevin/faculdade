CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(10) NOT NULL,
  `age` int(11) NOT NULL,
  `address` varchar(50) NOT NULL,
  `allow_guest` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `rate` (
  `rate_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL,
  `description` text NOT NULL,
  `stars` int(11) NOT NULL,
  `receiver_user_id` int(11) DEFAULT NULL,
  `sender_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`rate_id`),
  KEY `fk_receiver` (`receiver_user_id`),
  KEY `fk_sender` (`sender_user_id`),
  CONSTRAINT `fk_receiver` FOREIGN KEY (`receiver_user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `fk_sender` FOREIGN KEY (`sender_user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `accommodation` (
  `accommodation_id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL,
  `owner_id` int(11) NOT NULL,
  `dt_start` varchar(10) NOT NULL,
  `dt_end` varchar(10) NOT NULL,
  `max_guests` int(11) NOT NULL DEFAULT '0',
  `guest_price` int(11) NOT NULL DEFAULT '100',
  PRIMARY KEY (`accommodation_id`),
  KEY `fk_owner` (`owner_id`),
  CONSTRAINT `fk_owner` FOREIGN KEY (`owner_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `booking` (
  `booking_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `accommodation_id` int(11) NOT NULL,
  `guest_qty` int(11) NOT NULL,
  `dt_checkin` varchar(10) NOT NULL,
  `dt_checkout` varchar(10) NOT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `fk_accommodation_idx` (`accommodation_id`),
  KEY `fk_user_idx` (`user_id`),
  CONSTRAINT `fk_accommodation` FOREIGN KEY (`accommodation_id`) REFERENCES `accommodation` (`accommodation_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;