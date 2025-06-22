create
    definer = root@localhost procedure findProductsByPrice(IN minPrice decimal(10, 2), IN maxPrice decimal(10, 2))
BEGIN
    SELECT id , name , description , category_id from product
    where price between minPrice and maxPrice
    ORDER BY name;
END;

