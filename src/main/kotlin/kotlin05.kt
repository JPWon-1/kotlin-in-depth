/*
* 람다
* 익명함수
* 호출 가능 참조를 사용해 함수값을 만드는 방법
* 인라인 함수를 통해 런타임 부가 비용을 들이지 않으며 함수형 프로그래밍을 하는 방법 등 코틀린에는 함수를 사용하는 방법이 다양하다.
* */

//아래의 람다는 주어진 인덱스에 따라 배열 원소값을 계산한다.
val squares = IntArray(5) { n -> n * n } // 0 , 1 , 4 , 9 , 16

fun aggregate(numbers: IntArray, op: (Int, Int) -> Int): Int {
    var result = numbers.firstOrNull() ?: throw IllegalArgumentException("empty array")
    for (i in 1..numbers.lastIndex) result = op(result, numbers[i])
    return result
}

fun sum(numbers: IntArray) = aggregate(numbers, { result, op -> result + op })
fun max(numbers: IntArray) = aggregate(numbers, { result, op -> if (op > result) op else result })

//fun main(){
//    println(sum(intArrayOf(1,2,3)))
//    println(max(intArrayOf(1,2,3)))
//}


fun interface StringConsumer {
    fun accept(s: String)
}

//fun main() {
//    val consume = StringConsumer { s -> println(s) }
//    consume.accept("hello")
//}

fun measureTime(action: (() -> Unit)?): Long {
    val start = System.nanoTime()
    action?.invoke()
    return System.nanoTime() - start
}

// lambda 식을 만들어보았다.
fun sumtest(numbers: IntArray) = aggregate(numbers, {
    //파라미터 목록 : result, op
        result, op ->
    // 몸통(반환값) : result + op
    result + op
})

//fun main() {
//    println(sumtest(intArrayOf(1, 2, 3)))
//}

fun checkLambda(s: String, condition: (Int, Char) -> Boolean): Boolean {
    for (i in s.indices) {
        if (!condition(i, s[i])) return false
    }
    return true
}

//fun main() {
//    // 안쓰이는 파라미터를 밑줄 (_) 로 지정할 수 있다.
//    println(checkLambda("Hello") { _, c ->
//        c.isLetter()
//    })
//    println(checkLambda("Hello") { i, c ->
//        i == 0 || c.isLowerCase()
//    })
//}

/*
* 익명함수의 문법은 일반 함수와 며착지 차이만 빼고 거의 똑같은데
* 1. 익명함수에는 이름을 지정하지 않는다. 따라서 fun 키워드 다음에 바로 파라미터 목록이 온다
* 2. 람다와 마찬가지로 문맥에서 파라미터 타입을 추론할 수 있으면 파라미터 타입을 지정하지 않아도 된다.
* 3. 함수 정의와 달리, 익명 함수는 식이기 때문에 인자로 함수에 넘기거나 변수에 대입하는 일반 값처럼 쓸 수 있다
* */

// lambda
//fun sum(numbers: IntArray) = aggregate(numbers, { result, op -> result + op })

// 익명함수
fun sumAnonymous(numbers: IntArray) = aggregate(numbers, fun(result, op): Int { return result + op })


//호출 가능 참조
fun evalAtZero(f: (Int) -> Int) = f(0)
fun inc(n: Int) = n + 1
fun dec(n: Int) = n - 1

//fun main() {
//    println(evalAtZero(::inc))
//    println(evalAtZero(::dec))
//}

// 멤버 함수와 확장 함수
class Person(val firstName: String, private val lastName: String) {
    fun fullName() {
        println("$firstName $lastName")
    }
}

fun Person.fullName() {
//    println("$firstName $lastName")//error : lastname은 private 이기 때문에 확장함수에서 접근할 수 없음
}

val person = Person("hi", "there").fullName() // 멤버 함수를 우선적으로 호출함!!


/*
* 영역 함수
* run, let, with, apply, also 라는 다섯가지 표준 영역함수가 존재한다.
* 모든 영역 함수는 인라인 함수이기 때문에 런타임 부가 비용이 없다.
* */

// 1. run()
// run() 함수는 확장 람다를 받는 확장 함수이며, 람다의 결과를 돌려준다.
// 기본적인 사용 패턴은 객체 상태를 설정한 다음, 이 객체를 대상으로 어떤 결과를 만들어내는 람다를 호출하는 것이다.
class Address {
    constructor()
    constructor(
        city: String,
        street: String,
        house: String
    ){
        this.city = city
        this.street = street
        this.house = house
    }

    var zipCode: Int = 0
    var city: String = ""
    var street: String = ""
    var house: String = ""

    fun post(message: String): Boolean {
        "Meesage for {$zipCode, $city, $street, $house}"
        return readLine() == "OK"
    }
}

//fun main() {
//
//    val isReceived = Address().run {
//        // Addresss 인스턴스를 this로 사용할 수 있다.
//        zipCode = 123456
//        city = "London"
//        street = "Baker Street"
//        house = "221b"
//        post("HELLO~")//반환값
//    }
//    if (!isReceived) {
//        println("message is not delivered")
//    }
//
//    // with()
//    // with는 run 함수와 상당히 비슷하다. 유일한 차이는 with()가 확장 함수 타입이 아니므로 문맥 식을 with의 첫 번째 인자로 전달해야 한다는 점이다.
//    val message = with(Address("London", "Baker St", "221b")) {
//        "Address: $city, $street, $house"
//        println(this.city)
//    }
//    println(message)
//}

// let()
// let은 run과 비슷하지만 확장 함수 타입의 람다를 받지 않고 인자가 하나뿐인 함수 타입의 람다를 받는다!
val a = Address(city="London", "Baker St", "221b")
fun main(){
//    val address = run {
//        val city = readLine()?:return
//        val street = readLine()?:return
//        val house = readLine()?:return
//        Address(city,street,house)
//    }
//    println(address.city)
//    a.let { println("city: ${it.city}") }


    val run = Address().run {
        city = "London"
        street = "Baker St"
        house = "221b"
        post("run")
    }

    val with = with(Address()) {
        this.city = "London"
        this.street = "Baker St"
        this.house = "221b"
        this.post("with!")
    }

    val let = Address().let {
        it.city = "London"
        it.street = "Baker St"
        it.house = "221b"
        it.post("안녕ㅁㅁ")
    }
    // apply, also
    // apply() 함수는 확장 람다를 받는 확장 함수이며 자신의 수신 객체를 반환한다.
    // 이 함수는 일반적으로 run()과 달리 반환값을 만들어내지 않고 객체의 상태를 설정하는 경우에 사용한다.
    val apply = Address().apply {
        city = "London"
        street = "Baker St"
        house = "221b"
    }.post("안녕")

    // apply와 비슷한 함수로 also()가 있는데, apply()와 달리 인자가 하나 있는 람다를 파라미터로 받는다.
    val also = Address().also {
        it.city = "London"
        it.street = "Baker Street"
        it.house = "221b"
    }.post("여기도 안녕")

    println(run)
    println(with)
    println(let)
    println(apply)
    println(also)

}



















