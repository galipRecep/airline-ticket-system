

INSERT INTO AIRPORT  VALUES (SEQ_AIRPORT.nextval,'Kastamonu','KST','TR','Kastamonu Hava Limanı');
INSERT INTO AIRPORT  VALUES (SEQ_AIRPORT.nextval,'İstanbul','İST1','TR','İstanbul Hava Limanı');

INSERT INTO AIR_CARRIER  VALUES (SEQ_AIR_CARRIER.nextval,'İstanbul Arnavutköy','Türk Hava Yolları','+902125635556');
INSERT INTO AIR_CARRIER  VALUES (SEQ_AIR_CARRIER.nextval,'İstanbul Pendik','Pegasus','+902125631111');

INSERT INTO ROUTE  VALUES (SEQ_ROUTE.nextval,'IK01','İstanbul-Kastamonu',2,1,2);
INSERT INTO ROUTE  VALUES (SEQ_ROUTE.nextval,'KI01','Kastamonu-İstanbul',2,2,1);


INSERT INTO FLIGHT  VALUES (SEQ_FLIGHT.nextval,'2021-04-25 20:00:00',200,'KI001',1,200,'2021-04-25 18:00:00','Kastamonu-İstanbul',20,2,1);
INSERT INTO TICKET VALUES (SEQ_TICKET.nextval,'2021-04-25 20:00:00',12,2022,'RECEP GALİP','1235658985623214','Recep','Çelik','a6546asdasda6465',100,1);


