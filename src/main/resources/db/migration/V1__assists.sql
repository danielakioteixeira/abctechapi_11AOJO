-- abc_tech.assistances definition

CREATE TABLE `assistances` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `description` varchar(255) NOT NULL,
    `name` varchar(150) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO
    abc_tech.assistances (name, description)
VALUES
    ("name_0", "description_0"),
    ("name_1", "description_1"),
    ("name_2", "description_2"),
    ("name_3", "description_3"),
    ("name_4", "description_4"),
    ("name_5", "description_5"),
    ("name_6", "description_6"),
    ("name_7", "description_7"),
    ("name_8", "description_8"),
    ("name_9", "description_9"),
    ("name_10", "description_10"),
    ("name_11", "description_11"),
    ("name_12", "description_12"),
    ("name_13", "description_13"),
    ("name_14", "description_14")
