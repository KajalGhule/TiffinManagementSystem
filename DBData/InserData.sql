
use projectdb;

INSERT INTO t_delivery_address (delivery_area, city, pincode)
VALUES ('Nanded City', 'Pune', 411001);
INSERT INTO t_delivery_address (delivery_area, city, pincode)
VALUES ('FC Road', 'Pune', 411002);
INSERT INTO t_delivery_address (delivery_area, city, pincode)
VALUES ('Warje', 'Pune', 411003);
INSERT INTO t_delivery_address (delivery_area, city, pincode)
VALUES ('Narhe', 'Pune', 411004);
INSERT INTO t_delivery_address (delivery_area, city, pincode)
VALUES ('Katraj', 'Pune', 411001);
INSERT INTO t_delivery_address (delivery_area, city, pincode)
VALUES ('MG Road', 'Pune', 411001);



INSERT INTO t_tiffin_details (tiffin_name, tiffin_image, tiffin_price, description)
VALUES ('Basic Veg Tiffin', 'chapatiBhaji.jpg', 150, 'Includes rice, dal, sabzi, roti');
INSERT INTO t_tiffin_details (tiffin_name, tiffin_image, tiffin_price, description)
VALUES ('Basic Veg Tiffin', 'halka.png', 150, 'Includes rice, dal, sabzi, roti');


INSERT INTO t_user (user_name, email, password, mobile_no, adhar_no, role)
VALUES ('Omkar Ghule', 'omkar@example.com', 'pass123', '9876543210', '123456789012', 'ROLE_ADMIN');
INSERT INTO t_user (user_name, email, password, mobile_no, adhar_no, role)
VALUES ('Kajal Ghule', 'kajal@example.com', 'pass123', '9876543210', '123456789012', 'ROLE_USER');
INSERT INTO t_user (user_name, email, password, mobile_no, adhar_no, role)
VALUES ('Varun', 'varun@example.com', 'pass123', '9876543210', '123456789012', 'ROLE_DELIVERYBOY');
INSERT INTO t_user (user_name, email, password, mobile_no, adhar_no, role)
VALUES ('Om', 'om@example.com', 'pass123', '9876543210', '123456789012', 'ROLE_USER');

INSERT INTO t_user_address (user_id, address_line1, location_id)
VALUES (1, '123 Green Street', 1);


UPDATE t_user 
SET user_address_id = 1 
WHERE user_id = 1;


INSERT INTO t_orders (start_date, end_date, total_days, total_amount, user_id, tiffin_id)
VALUES (NOW(), DATE_ADD(NOW(), INTERVAL 30 DAY), 30, 4500, 1, 1);


INSERT INTO t_payment (order_id, payment_type, total_payment, payment_status, payment_time)
VALUES (1, 'UPI', 4500, 'PAID', NOW());

UPDATE t_orders 
SET order_id = 1 
WHERE order_id = 1;


INSERT INTO t_daywise_order (order_id, date, requirenment, status, delivery_boy_id, sesssion)
VALUES (1, NOW(), 1, 'PENDING', 1, 'lunch');

