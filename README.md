# Java_Core

### 1. Компиляция и интерпретация кода
Разработать приложение.

Создать проект из трёх классов (основной с точкой входа и два класса в другом пакете),
которые вместе должны составлять одну программу, позволяющую
производить четыре основных математических действия и осуществлять форматированный
вывод результатов пользователю (ИЛИ ЛЮБОЕ ДРУГОЕ ПРИЛОЖЕНИЕ НА ВАШ ВЫБОР, которое просто демонстрирует работу некоторого механизма).

Необходимо установить Docker Desktop.

Создать Dockerfile, позволяющий откопировать исходный код вашего приложения в образ для демонстрации работы вашего приложения при создании соответствующего контейнера.

### 2. Данные и функции
1. Полностью разобраться с кодом программы разработанной на семинаре, переписать программу.

2. *Переработать метод проверки победы, логика проверки победы должна работать для поля 5х5 и
количества фишек 4. Очень желательно не делать это просто набором условий для каждой из
возможных ситуаций! Используйте вспомогательные методы, используйте циклы!

3. ****Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.

## 3. Классы и объекты
Построить три класса (базовый и 2 потомка), описывающих некоторых работников с почасовой оплатой (один из потомков - Freelancer) и фиксированной оплатой (второй потомок -Worker).

а) Описать в базовом классе абстрактный метод для расчёта среднемесячной заработной платы.
Для «повременщиков» формула для расчета такова: «среднемесячная заработная плата = 20.8 * 8 * почасовая ставка», для работников с фиксированной оплатой «среднемесячная заработная плата = фиксированная месячная оплата».

б) Создать на базе абстрактного класса массив/коллекцию сотрудников и заполнить его.

в) ** Реализовать интерфейсы для возможности сортировки массива/коллекции (обратите ваше внимание на интерфейсы Comparator, Comparable), добавьте новое состояние на урове базового типа и создайте свой уникальный компаратор.

г) ** Создать класс, содержащий массив или коллекцию сотрудников (как Worker так и Freelancer), и реализовать возможность вывода данных с использованием foreach (подсказка: вам потребуется поработать с интерфейсом Iterable).