import kotlin.math.PI
import kotlin.random.Random

class Kotlin03_fun {
    fun circleArea(radius: Double): Double {
        return PI * radius * radius
    }

    fun circleArea2(radius: Double): Double = PI * radius * radius
    fun circleArea3(radius: Double) = PI * radius * radius

    fun main() {
        println("Enter radius: ")
        val radius = readLine()!!.toDouble()
        println("Circle area : ${circleArea(radius)}")
    }


    /*
    * 위치 기반 인자와 이름 붙은 인자
    * 기본적으로 첫번째 인자는 첫번째 파라미터, 두번째 인자는 두번째 파라미터 식으로 들어가는 것을
    * 위치 기반 인자라고 한다.
    *
    * 코틀린은 위치기반 인자 방식 뿐 아니라 named 인자 방식도 제공한다.
    * */
    fun rectangleArea(width: Double, height: Double): Double {
        return width * height
    }

    fun main2() {
        val w = readLine()!!.toDouble()
        val h = readLine()!!.toDouble()
        val rectangle1 = rectangleArea(w, h)
        val rectangle2 = rectangleArea(height = h, width = w)
    }

    /*
    * 오버로딩과 디폴트 값
    * */
    fun mul(a: Int, b: Int): Int = a * b
    fun mul(a: Long, b: Int): Long = a * b
    fun main3() {
        val mul1 = mul(1, 2)
        val mul2 = mul(1L, 2)
        println(mul1)
        println(mul2)
    }

    /*
    * varargs
    * 인자의 개수가 정해지지 않은 arrayOf()같은 함수를 파라미터 정의 앞에 붙여서 함수에 쓸 수 있다.
    * */
    fun printSorted(vararg items: Int) {
        items.sort()
        println(items.contentToString())
    }

    /*
    * 스프레드 연산자인 *를 사용해서 가변 인자 대신 넘길 수 있다.
    * val numbers = intArrayOf(6,2,10,1)
    * printSorted(*numbers)
    *
    * 하지만 이 때 얇은 복사가 이루어진다.
    * 따라서 파라미터 배열의 내용을 바꿔도 원본 원소에는 영향을 미치지 않는다.
    * 그런데 배열 내부에 참조가 들어있을 경우에는 참조가 복사되기 때문에 참조가 가리키는 데이터가 호출하는 쪽과 함수 내부 배열에서 공유된다.
    * */
    fun change(vararg items: IntArray) {
        items.iterator().forEach {
            println(it.contentToString())
        }
        items[0][1] = 100
    }


}


fun main() {
    val kotlin03Fun = Kotlin03_fun()
    kotlin03Fun.printSorted(6, 2, 10, 1)
    val numbers = intArrayOf(6, 2, 10, 1)
    kotlin03Fun.printSorted(*numbers)

    val a = intArrayOf(1, 2, 3)
    val b = intArrayOf(4, 5, 6)

    kotlin03Fun.change(a, b)
    println(a.contentToString())
    println(b.contentToString())

    /*
    * 둘 이상을 vararg 파라미터로 선언하는 것은 금지된다.
    * 하지만 vararg 파라미터에 콤마로 여러 인자와 스프레드를 섞어서 전달하는 것은 괜찮다.
    * 호출 시 이러한 호출은 원래의 순서가 유지되는 단일 배열로 합쳐진다.
    * */
    println(kotlin03Fun.printSorted(6, 1, *intArrayOf(1, 2, 3, 4), 2))//6,1,1,2,3,4,2
    //=> [1,1,2,2,4,6]

    /*
   * 범위, 진행, 연산
   * 범위를 만드는 방법 중 가장 간단한 방법은 .. 연산자를 사용하는 것이다.
   * val chars = 'a'..'h'
   * val nums = 1..9
   * val zeroToOne = 0.0..1.0
   *
   * in 연산자를 사용하면 어떤 값이 범위 안에 들어가있는지 알 수 있다.
   * val num = readLine()!!.toInt()
   * num in 10..99 // num>=10 && num <= 99
   * 이와 반대인 not in  연산자도 있다.
   * !in 10..99 // num<10 && num>99
   * in연산자는 숫자뿐만 아니라 문자열이나 배열도 지원한다.
   * val numbers = intArrayOf(1,2,3,4,5,6,7)
   * 2 in numbers // true
   * 9 !in numbers // true
   *
   * val text = "Hello!"
   * 'a' in text // true
   * 'H' in text // true
   * 'h' !in text // true
   *
   * ..연산에 의해 만들어지는 범위는 닫혀있다. 끝값이 범위에 포함된다는 의미이다. ( <=, >= )
   *
   * 반만 닫힌 범위를 만드는 연산자도 있다.
   * until 을 쓰면 경계값은 포함하지 않는다.
   * val twoDigits = 10 until 100 // 10..99
   * */
    println(5 in 5..5) // true
    println(5 in 5 until 5)//false
    println(5 in 10..1)//false

    // 범위를 반대로 진행할 수 있다.
    5 in 10 downTo 1//true
    5 in 1 downTo 10//false

    // 진행의 간격을 지정할 수 있다.
    1..10 step 3 // 1, 4, 7 , 10
    15 downTo 9 step 2 // 15, 13 , 11 , 9
    //step은 양수여야 한다.

    /*
    * when
    * if문은 두가지 가능성 중 하나를 선택하게 해주는 반면, when은 if문을 연쇄적으로 사용하여 순차적으로
    * 대상 조건을 검사하여 그 중 하나를 선택할 수 있게 해주는 조건절이다.
    * */
    fun hexDigit(n: Int): Char {
        if(n in 0..9) return '0'+n
        else if (n in 10..15) return 'A' + n - 10
        else return '?'
    }

    fun hexDigit2(n: Int): Char {
        when {
            n in 0..9 -> return '0' +n
            n in 10..15 -> return 'A' + n - 10
            else -> return '?'
        }
    }

    fun hexDigit3(n: Int) = when {
        n in 0..9 -> '0'+n
        n in 10..15 -> 'A' + n - 10
        else -> '?'
    }

    fun numberDescription(n:Int): String = when {
        n == 0 -> "Zero"
        n == 1 || n == 2 || n ==3 -> "Small"
        n in 4..9 -> "Medium"
        n in 10..100 -> "Large"
        n !in Int.MIN_VALUE until 0 -> "Negative"
        else -> "Huge"
    }

    fun numberDescription2(n:Int): String = when (n) {
        0 -> "Zero"
        1, 2, 3 -> "Small"
        in 4..9 -> "Medium"
        in 10..100 -> "Large"
        !in Int.MIN_VALUE until 0 -> "Negative"
        else -> "Huge"
    }
    /*
    * 루프
    * 코틀린에서 모든 루프는 식이 아니고 문이기 때문에 어떤 값을 평가되지 않으며 부수 효과를 발생시킬 수 만 있다.
    * */
    var sum = 0
    var num = 0

    do {
        num = readLine()!!.toInt()
        sum += num
    } while (num != 0)

    val randomInt = Random.nextInt(1,101)
    var guess = 0

    while(guess!=num) {
        guess = readLine()!!.toInt()
        if(guess<num) println("Too small")
        else if (guess > num) println("Too big")
    }

    // 레이블 붙이기
    fun indexOf(subarray : IntArray, array:IntArray) : Int {
        outerLoop@ for (i in array.indices) {
            for(j in subarray.indices) {
                if(subarray[j] != array[i+j]) continue@outerLoop
            }
            return i
        }
        return -1
    }

    //코틀린에서 꼬리재귀 함수 앞에 tailrec을 붙히면 비재귀로 동작한다.
    tailrec fun sum(a:Int, b:Int) {
        return sum(a,b)
    }
}













