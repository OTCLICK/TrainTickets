# TrainTickets
Предметная область «ЖД билеты»

Сущности:
1.	ПОЕЗД
- ID поезда (PK)
- Номер поезда 
- Время отправления
- Время прибытия
- Маршрут
2.	ВАГОН
- ID вагона (PK)
- Номер вагона 
- ID поезда (FK) (ПОЕЗД 1 – М ВАГОН)
- Количество мест
- Тип вагона
3.	МЕСТО
- ID места (PK)
- Номер места 
- ID вагона (FK) (ВАГОН 1 – М МЕСТО)
- Статус бронирования
4.	ПАССАЖИР
- ID пассажира (PK)
- ФИО пассажира 
- Паспортные данные
- Электронная почта
5.	БИЛЕТ
- ID билета (PK)
- ID поезда (PK, FK) (ПОЕЗД М – 1 БИЛЕТ 1 – М ПАССАЖИР)
- ID вагона (PK, FK) (ВАГОН М – 1 БИЛЕТ 1 – М ПАССАЖИР)
- ID места (PK, FK) (МЕСТО 1 – 1 БИЛЕТ)
- ID пассажира (PK, FK) (ПАССАЖИР 1 – М БИЛЕТ)
- Стоимость билета

Сценарии использования:
1.	Пассажир может забронировать место, если оно не куплено или не забронировано, после чего должен оплатить билет в течение 15 минут, чтобы занять место.
2.	Система проверяет по ФИО и данным пассажира, является ли тот постоянным клиентом, и, если тот имеет N кол-во поездок за последнее время, делает скидку на стоимость билета.
3.	Пассажир может выбрать льготный билет и, когда система удостоверится, что человек действительно обладает льготами, этот пассажир получит скидку на билет и увеличенное время между бронированием места и покупкой билета.
