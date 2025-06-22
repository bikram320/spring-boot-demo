DELIMITER $$

CREATE PROCEDURE findProductsByPrice(
    minPrice Decimal(10,2),
    maxPrice Decimal(10,2)
)

BEGIN
    SELECT id , name , description,  price , category_id from product
    where price between minPrice and maxPrice
    ORDER BY name;
END $$

DELIMITER ;