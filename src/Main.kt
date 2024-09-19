import kotlin.math.abs

fun findExponent(n: Int, x: Int): Int? {
    if (x == 0) return null

    var exponent = 0
    var value = 1

    while (value < abs(n)) {
        value *= abs(x)
        exponent++
    }

    if (value == abs(n)) {
        return if (n < 0 && x > 0) null
        else if (n < 0 && exponent % 2 == 0) null
        else exponent
    }

    return null
}

fun main() {
    println("Программа проверяет, существует ли целочисленный показатель степени y для уравнения x^y = n.")
    println("Введите два целых числа (n и x), разделённых пробелом:")

    while (true) {
        println("Введите целое число n и основание степени x (или введите 'exit' для выхода):")
        val input = readln().trim()

        if (input.equals("exit", ignoreCase = true)) {
            println("Выход из программы.")
            break
        }

        // Разделение строки на части
        val parts = input.split(" ")

        if (parts.size != 2) {
            println("Ошибка: необходимо ввести два целых числа, разделённых пробелом. Попробуйте снова.")
            continue
        }

        val n = try {
            parts[0].toInt()
        } catch (e: NumberFormatException) {
            println("Ошибка: первое число введено некорректно. Попробуйте снова.")
            continue
        }

        val x = try {
            parts[1].toInt()
        } catch (e: NumberFormatException) {
            println("Ошибка: второе число введено некорректно. Попробуйте снова.")
            continue
        }

        if (x == 0) {
            println("Ошибка: основание степени x не может быть равно 0. Попробуйте снова.")
            continue
        }

        val exponent = findExponent(n, x)

        if (exponent != null) {
            println("Целочисленный показатель степени для уравнения $x^$exponent = $n: y = $exponent")
        } else {
            println("Целочисленный показатель не существует для уравнения $x^y = $n.")
        }
    }
}