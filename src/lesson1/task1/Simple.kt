@file:Suppress("Artem Denisov")

package lesson1.task1

import kotlin.math.*

// Урок 1: простые функции
// Максимальное количество баллов = 5
// Рекомендуемое количество баллов = 4

/**
 * Пример
 *
 * Вычисление квадрата целого числа
 */
fun sqr(x: Int) = x * x

/**
 * Пример
 *
 * Вычисление квадрата вещественного числа
 */
fun sqr(x: Double) = x * x

/**
 * Пример
 *
 * Вычисление дискриминанта квадратного уравнения
 */
fun discriminant(a: Double, b: Double, c: Double) = sqr(b) - 4 * a * c

/**
 * Пример
 *
 * Поиск одного из корней квадратного уравнения
 */
fun quadraticEquationRoot(a: Double, b: Double, c: Double) =
    (-b + sqrt(discriminant(a, b, c))) / (2 * a)

/**
 * Пример
 *
 * Поиск произведения корней квадратного уравнения
 */
fun quadraticRootProduct(a: Double, b: Double, c: Double): Double {
    val sd = sqrt(discriminant(a, b, c))
    val x1 = (-b + sd) / (2 * a)
    val x2 = (-b - sd) / (2 * a)
    return x1 * x2 // Результат
}

/**
 * Тривиальная (3 балла).
 *
 * Задача имеет повышенную стоимость как первая в списке.
 *
 * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
 * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
 */
fun seconds(hours: Int, minutes: Int, seconds: Int): Int = hours * 3600 + minutes * 60 + seconds

/**
 * Тривиальная (1 балл)
 *
 * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
 * Определить длину того же отрезка в метрах (в данном случае 18.98).
 * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
 */
fun lengthInMeters(sagenes: Int, arshins: Int, vershoks: Int): Double =
    ((sagenes * 3 + arshins) * 16 + vershoks) * 4.445 / 100

/**
 * Тривиальная (1 балл)
 *
 * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
 * Вывести значение того же угла в радианах (например, 0.63256).
 */
fun angleInRadian(deg: Int, min: Int, sec: Int): Double = (deg * 3600 + min * 60.0 + sec) * PI / 648000

/**
 * Тривиальная (1 балл)
 *
 * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
 * Например, расстояние между (3, 0) и (0, 4) равно 5
 */
fun trackLength(x1: Double, y1: Double, x2: Double, y2: Double): Double = sqrt(sqr(x1 - x2) + sqr(y1 - y2))

/**
 * Простая (2 балла)
 *
 * Пользователь задает целое число, большее 100 (например, 3801).
 * Определить третью цифру справа в этом числе (в данном случае 8).
 */
fun thirdDigit(number: Int): Int = (number % 1000) / 100

/**
 * Простая (2 балла)
 *
 * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
 * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
 * Определите время поезда в пути в минутах (в данном случае 216).
 */
fun travelMinutes(hoursDepart: Int, minutesDepart: Int, hoursArrive: Int, minutesArrive: Int): Int =
    (hoursArrive * 60 + minutesArrive) - (hoursDepart * 60 + minutesDepart)

/**
 * Простая (2 балла)
 *
 * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
 * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
 * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
 */
fun accountInThreeYears(initial: Int, percent: Int): Double {
    val coolPersent = (percent / 100.0) + 1
    return initial * coolPersent.pow(3)
}

/**
 * Простая (2 балла)
 *
 * Пользователь задает целое трехзначное число (например, 478).
 * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
 */
fun numberRevert(number: Int): Int = (number % 10) * 100 + ((number % 100) / 10) * 10 + (number / 100)



/**

 * На доске 8х8 клеток стоят фишки.
 * Их координаты заданы строкой chipCoords вида
 * “42 44 57 67 77 53 33 23 43 78”,

 * где каждое двузначное число соответствует одной фишке,
 * первая цифра соответствует X-координате (столбцу),
 * вторая Y-координате (строке).
 * Все координаты должны быть в диапазоне от 1 до 8.

 *

 * ------ф-

 * ----ффф-

 * --------

 * --------

 * ---ф----

 * -фффф---

 * ---ф----

 * --------

 *
 * Найти самую длинную вертикальную последовательность фишек
 * (в примере -- 42, 43, 44). Фишки в последовательности должны
 * располагаться в одном столбце и идти подряд.
 *
 * Имя и тип результата функции предложить самостоятельно.

 *

 * Если входные аргументы являются некорректными,

 * бросить IllegalArgumentException

 *

 * Кроме функции, следует написать тесты,

 * подтверждающие её работоспособность.

 */
fun maxColumnRow(chipCoords: String): Set<Int> {
    val reg = Regex("([1-8]{2}\\s)*[1-8]{2}")
    if (!reg.matches(chipCoords)) {
        throw IllegalArgumentException()
    }
    val coords = mutableListOf<Int>()
    for (i in chipCoords.split(" ")) {
        if (i.toInt() !in coords) {
            coords.add(i.toInt())
        }
    }
    coords.sort()
    var localRet = mutableSetOf(coords[0])
    var ret = setOf<Int>()
    for (i in 1 until coords.size) {
        if (coords[i - 1] == coords[i] - 1) {
            localRet.add(coords[i - 1])
            localRet.add(coords[i])
        } else {
            if (ret.size <= localRet.size) {
                ret = localRet
            }
            localRet = mutableSetOf()
        }
        if (ret.size <= localRet.size) {
            ret = localRet
        }
    }
    return ret
}

/**

 * В виде списка строк phones заданы номера телефонов, например:
 * “4628091 Иванов”,
 * “4631794 Петров”,
 * “6409045 Волкова”,
 * “7081356 Кошкина”
 *
 * Номера могут состоять только из цифр.
 *
 * Также задан префикс prefix номера, который начал набирать
 * владелец телефона, например “46”.
 *
 * Вернуть фамилии, соответствующие этому префиксу
 * (в данном случае — Иванов, Петров, их номера начинаются с 46).
 *
 * Имя и тип результата функции предложить самостоятельно.

 *

 * Если входные аргументы являются некорректными,

 * бросить IllegalArgumentException

 *

 * Кроме функции, следует написать тесты,

 * подтверждающие её работоспособность.

 */

fun phoneNumber(prefix: String, number: List<String>): Set<String> {
    val reg = Regex("^\\d+ [А-Яа-яё]+\$")
    for (line in number) {
        if (!reg.matches(line)) {
            throw IllegalArgumentException()
        }
    }
    val prefix = prefix.split("").drop(1).dropLast(1)
    val res = mutableSetOf<String>()
    for (numbers in number) {
        var flag = true
        val spNums = numbers.split(" ")
        val firstPair = spNums[0].split("").drop(1).dropLast(1)
        for ((index, value) in prefix.withIndex()) {
            if (value == firstPair[index]) continue
            flag = false
            break
        }
        if (flag) res.add(spNums[1])
    }
    return res
}

fun main() {
    print(phoneNumber("46", listOf("4628091 Иванов", "4631794 Петров", "6409045 Волкова", "7081356 Кошкина")))
}