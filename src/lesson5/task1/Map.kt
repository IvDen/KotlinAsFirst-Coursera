@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson5.task1

import java.lang.Integer.max
import java.util.ArrayList

/**
 * Пример
 *
 * Для заданного списка покупок `shoppingList` посчитать его общую стоимость
 * на основе цен из `costs`. В случае неизвестной цены считать, что товар
 * игнорируется.
 */
fun shoppingListCost(
        shoppingList: List<String>,
        costs: Map<String, Double>): Double {
    var totalCost = 0.0

    for (item in shoppingList) {
        val itemCost = costs[item]
        if (itemCost != null) {
            totalCost += itemCost
        }
    }

    return totalCost
}

/**
 * Пример
 *
 * Для набора "имя"-"номер телефона" `phoneBook` оставить только такие пары,
 * для которых телефон начинается с заданного кода страны `countryCode`
 */
fun filterByCountryCode(
        phoneBook: MutableMap<String, String>,
        countryCode: String) {
    val namesToRemove = mutableListOf<String>()

    for ((name, phone) in phoneBook) {
        if (!phone.startsWith(countryCode)) {
            namesToRemove.add(name)
        }
    }

    for (name in namesToRemove) {
        phoneBook.remove(name)
    }
}

/**
 * Пример
 *
 * Для заданного текста `text` убрать заданные слова-паразиты `fillerWords`
 * и вернуть отфильтрованный текст
 */
fun removeFillerWords(
        text: List<String>,
        vararg fillerWords: String): List<String> {
    val fillerWordSet = setOf(*fillerWords)

    val res = mutableListOf<String>()
    for (word in text) {
        if (word !in fillerWordSet) {
            res += word
        }
    }
    return res
}

/**
 * Пример
 *
 * Для заданного текста `text` построить множество встречающихся в нем слов
 */
fun buildWordSet(text: List<String>): MutableSet<String> {
    val res = mutableSetOf<String>()
    for (word in text) res.add(word)
    return res
}

/**
 * Средняя
 *
 * Объединить два ассоциативных массива `mapA` и `mapB` с парами
 * "имя"-"номер телефона" в итоговый ассоциативный массив, склеивая
 * значения для повторяющихся ключей через запятую.
 * В случае повторяющихся *ключей* значение из mapA должно быть
 * перед значением из mapB.
 *
 * Повторяющиеся *значения* следует добавлять только один раз.
 *
 * Например:
 *   mergePhoneBooks(
 *     mapOf("Emergency" to "112", "Police" to "02"),
 *     mapOf("Emergency" to "911", "Police" to "02")
 *   ) -> mapOf("Emergency" to "112, 911", "Police" to "02")
 */
fun mergePhoneBooks(mapA: Map<String, String>, mapB: Map<String, String>): Map<String, String> = TODO()

/**
 * Простая
 *
 * По заданному ассоциативному массиву "студент"-"оценка за экзамен" построить
 * обратный массив "оценка за экзамен"-"список студентов с этой оценкой".
 *
 * Например:
 *   buildGrades(mapOf("Марат" to 3, "Семён" to 5, "Михаил" to 5))
 *     -> mapOf(5 to listOf("Семён", "Михаил"), 3 to listOf("Марат"))
 */
fun buildGrades(grades: Map<String, Int>): Map<Int, List<String>> = TODO()

/**
 * Простая
 *
 * Определить, входит ли ассоциативный массив a в ассоциативный массив b;
 * это выполняется, если все ключи из a содержатся в b с такими же значениями.
 *
 * Например:
 *   containsIn(mapOf("a" to "z"), mapOf("a" to "z", "b" to "sweet")) -> true
 *   containsIn(mapOf("a" to "z"), mapOf("a" to "zee", "b" to "sweet")) -> false
 */
fun containsIn(a: Map<String, String>, b: Map<String, String>): Boolean = TODO()

/**
 * Средняя
 *
 * Для заданного списка пар "акция"-"стоимость" вернуть ассоциативный массив,
 * содержащий для каждой акции ее усредненную стоимость.
 *
 * Например:
 *   averageStockPrice(listOf("MSFT" to 100.0, "MSFT" to 200.0, "NFLX" to 40.0))
 *     -> mapOf("MSFT" to 150.0, "NFLX" to 40.0)
 */
fun averageStockPrice(stockPrices: List<Pair<String, Double>>): Map<String, Double> = TODO()

/**
 * Средняя
 *
 * Входными данными является ассоциативный массив
 * "название товара"-"пара (тип товара, цена товара)"
 * и тип интересующего нас товара.
 * Необходимо вернуть название товара заданного типа с минимальной стоимостью
 * или null в случае, если товаров такого типа нет.
 *
 * Например:
 *   findCheapestStuff(
 *     mapOf("Мария" to ("печенье" to 20.0), "Орео" to ("печенье" to 100.0)),
 *     "печенье"
 *   ) -> "Мария"
 */
fun findCheapestStuff(stuff: Map<String, Pair<String, Double>>, kind: String): String? = TODO()

/**
 * Сложная
 *
 * Для заданного ассоциативного массива знакомых через одно рукопожатие `friends`
 * необходимо построить его максимальное расширение по рукопожатиям, то есть,
 * для каждого человека найти всех людей, с которыми он знаком через любое
 * количество рукопожатий.
 * Считать, что все имена людей являются уникальными, а также что рукопожатия
 * являются направленными, то есть, если Марат знает Свету, то это не означает,
 * что Света знает Марата.
 *
 * Например:
 *   propagateHandshakes(
 *     mapOf(
 *       "Marat" to setOf("Mikhail", "Sveta"),
 *       "Sveta" to setOf("Marat"),
 *       "Mikhail" to setOf("Sveta")
 *     )
 *   ) -> mapOf(
 *          "Marat" to setOf("Mikhail", "Sveta"),
 *          "Sveta" to setOf("Marat", "Mikhail"),
 *          "Mikhail" to setOf("Sveta", "Marat")
 *        )
 */
fun propagateHandshakes(friends: Map<String, Set<String>>): Map<String, Set<String>> = TODO()

/**
 * Простая
 *
 * Удалить из изменяемого ассоциативного массива все записи,
 * которые встречаются в заданном ассоциативном массиве.
 * Записи считать одинаковыми, если и ключи, и значения совпадают.
 *
 * ВАЖНО: необходимо изменить переданный в качестве аргумента
 *        изменяемый ассоциативный массив
 *
 * Например:
 *   subtractOf(a = mutableMapOf("a" to "z"), mapOf("a" to "z"))
 *     -> a changes to mutableMapOf() aka becomes empty
 */
fun subtractOf(a: MutableMap<String, String>, b: Map<String, String>): Unit = TODO()

/**
 * Простая
 *
 * Для двух списков людей найти людей, встречающихся в обоих списках.
 * В выходном списке не должно быть повторяюихся элементов,
 * т. е. whoAreInBoth(listOf("Марат", "Семён, "Марат"), listOf("Марат", "Марат")) == listOf("Марат")
 */
fun whoAreInBoth(a: List<String>, b: List<String>): List<String> = TODO()

/**
 * Средняя
 *
 * Для заданного набора символов определить, можно ли составить из него
 * указанное слово (регистр символов игнорируется)
 *
 * Например:
 *   canBuildFrom(listOf('a', 'b', 'o'), "baobab") -> true
 */
fun canBuildFrom(chars: List<Char>, word: String): Boolean = TODO()

/**
 * Средняя
 *
 * Найти в заданном списке повторяющиеся элементы и вернуть
 * ассоциативный массив с информацией о числе повторений
 * для каждого повторяющегося элемента.
 * Если элемент встречается только один раз, включать его в результат
 * не следует.
 *
 * Например:
 *   extractRepeats(listOf("a", "b", "a")) -> mapOf("a" to 2)
 */
fun extractRepeats(list: List<String>): Map<String, Int> = TODO()

/**
 * Средняя
 *
 * Для заданного списка слов определить, содержит ли он анаграммы
 * (два слова являются анаграммами, если одно можно составить из второго)
 *
 * Например:
 *   hasAnagrams(listOf("тор", "свет", "рот")) -> true
 */
fun hasAnagrams(words: List<String>): Boolean = TODO()

/**
 * Сложная
 *
 * Для заданного списка неотрицательных чисел и числа определить,
 * есть ли в списке пара чисел таких, что их сумма равна заданному числу.
 * Если да, верните их индексы в виде Pair<Int, Int>;
 * если нет, верните пару Pair(-1, -1).
 *
 * Индексы в результате должны следовать в порядке (меньший, больший).
 *
 * Постарайтесь сделать ваше решение как можно более эффективным,
 * используя то, что вы узнали в данном уроке.
 *
 * Например:
 *   findSumOfTwo(listOf(1, 2, 3), 4) -> Pair(0, 2)
 *   findSumOfTwo(listOf(1, 2, 3), 6) -> Pair(-1, -1)
 */
fun findSumOfTwo(list: List<Int>, number: Int): Pair<Int, Int> = TODO()

/**
 * Очень сложная
 *
 * Входными данными является ассоциативный массив
 * "название сокровища"-"пара (вес сокровища, цена сокровища)"
 * и вместимость вашего рюкзака.
 * Необходимо вернуть множество сокровищ с максимальной суммарной стоимостью,
 * которые вы можете унести в рюкзаке.
 *
 * Например:
 *   bagPacking(
 *     mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
 *     850
 *   ) -> setOf("Кубок")
 *   bagPacking(
 *     mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
 *     450
 *   ) -> emptySet()
 */
fun bagPacking(treasures: Map<String, Pair<Int, Int>>, capacity: Int): Set<String> {
    var filteredTreasures = treasures.filter { it.value.first <= capacity || it.value.second == 0} //отбросить слишком большие или с нулевой ценностью
    var  paretoMap = mapOf<String, Pair<Int, Int>>();
    var result = arrayOf<Set<String>>();
    var count:Int = 0;
    for (itemTr in filteredTreasures){
        var news = mutableMapOf<String, Pair<Int, Int>>();
        for (itemPar in paretoMap){
            if (itemPar.value.first + itemTr.value.first <= capacity){
                news.put(itemTr.key+itemPar.key, Pair(itemPar.value.first + itemTr.value.first,itemPar.value.second + itemTr.value.second));
            }
        }
        paretoMap = paretoMap + news;
    }
    return emptySet();
}

fun maxVal(treasures: Map<String, Pair<Int, Int>>, capacity: Int):Int {
    var value: Array<Array<Int>> = Array(treasures.size+1) { Array(capacity+1) { -1 } };
    var weight: Array<Int> = Array(treasures.size) { 0 };
    var valueAr: Array<Int> = Array(treasures.size) { 0 };
    var keyAr: Array<String> = Array(treasures.size) {""};
    var counter: Int = 0;
    for (item in treasures) {
        weight[counter] = item.value.first;
        valueAr[counter] = item.value.second;
        keyAr[counter] = item.key;
        counter++;
    }
    var nodes = arrayListOf<Int>();
    var nodesToDel = arrayListOf<Int>();
    var deletedNodes = arrayListOf<Int>();


    fun testMaxVal(i: Int, j: Int): Int {

        if (j <= 0 || i == 0) {
            //if(j <= 0 && i != 0) testList.add(i);

            return 0;
        }

        if (value[i - 1][j] == -1) {
            value[i - 1][j] = testMaxVal(i - 1, j)
        }
        if (i==9) {
        }
        nodes.add(i)
        nodesToDel.add(0)
        if (weight[i-1] > j) {
            value[i][j] = value[i - 1][j]
        } else {
            if (value[i - 1][j - weight[i-1]] == -1) {
                value[i - 1][j - weight[i-1]] = testMaxVal(i - 1, j - weight[i-1])
            }
            value[i][j] = max(value[i - 1][j], value[i - 1][j - weight[i-1]] + valueAr[i-1])
            //nodes.add(i)
            //nodesToDel.add(0)
            if (value[i - 1][j] < (value[i - 1][j - weight[i-1]] + valueAr[i-1])){
                //if (i!=1) leftBranchCutter(i,nodes);
            } else{
                nodesToDel[nodesToDel.size-1] = i
                deletedNodes.add(i)

            }
        }

        return value[i][j];
    }

    var result = testMaxVal(treasures.size,capacity)

    for (item in 0 until nodes.size){
        //if (nodesToDel[item] != 0) nodes[item] = 0
    }
    nodes.removeAll(listOf(0));

    println("res: " + nodes)
    println("del: " + deletedNodes)
    println("ind: " + nodesToDel)

    println("res $result")
    println();
    return result
}

fun leftBranchCutter(element:Int, source:ArrayList<Int>) {
    var arrMinusLast:List<Int> = source.dropLast(1);
    var pointer = 0;
    var leftElder = 0
    var arrMinusTail:List<Int> = emptyList();
    //println(source)
   //println(arrMinusLast)
    //println(arrMinusTail)
    if (arrMinusLast.contains(element)){
        arrMinusTail = arrMinusLast.dropLastWhile {it < element}; //в кейсе когда мы запускаем из узла, который на данный момент общий корень то обнуляет массив
        leftElder = arrMinusTail.size-1
        if (leftElder != -1) pointer = leftElder+1

    }
   // println(element)
    //println(leftElder)
    //println(pointer)
    exit@ while (source[pointer] <= element-1){
        var buffer = source[pointer]
        source[pointer] = 0
        if (buffer == element-1) break@exit
        pointer++
    }

    println(source)
    println()




    /*
    for (i in leftElder+1 until source.size){
        if (i >= key){

            break;
        }
            source[i] = 0;
    }

    var lParent = source.lastIndexOf(element+1)
    var lSibling = arrMinusLast.lastIndexOf(element)
    var elIndex = source.lastIndexOf(element)
    if (lParent == -1){
        for (i in lSibling+1 until elIndex){
            source[i] = 0;
        }
    } else{
        for (i in lParent+1 until elIndex){
            source[i] = 0;

        }
    }

    /*
    var parent = source.lastIndexOf(element+1)
    var child = source.lastIndexOf(element)

    if (parent==-1) parent=child

    if (parent < child){
        //range  = source.indexOf(element-1);
        for (i in parent+1 until child){
            source[i] = 0;
        }
    }else{
        for (i in 0 .. source.indexOf(element-1)){
            source[i] = 0;
        }
    }*/
*/
}

