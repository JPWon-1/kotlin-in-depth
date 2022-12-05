fun main() {
    val student4 = Student4("jp", 10, "abcd")
    println(student4)
    //타입 검사
    // 코틀린은 is 연산자를 통해 타입 검사를 할 수 있다.
    val obj = arrayOf("1", 2, "3", 4)
    for (o in obj) {
        println(o is String)
    }
    /*
    * is 연산자는 자바의 instanceof 와 매우 비슷하지만 다른점이 있다면
    * instanceof 는 null에 대해 항상 false 를 리턴하지만
    * is의 결과는 비교대상자가 null이 될 수 있는지 여부에 따라 결과가 달라진다.
    * */
    val o: Any by lazy { 123 }
    if (o is Int) {
//        println(o*2) // custom 접근 제어자 (getter) 가 정의된 변수에 대해서는 스마트 캐스트를 쓸 수 없다. 후에 변수의 타입이 바뀌지 않는다는 보장이 없기 때문이다.
    }

    /*
    * as 연산자를 통해 타입 캐스팅을 할 수 있다.
    * 자바에서는 캐스팅을 해도 항상 널은 널로 남지만,
    * 코틀린에서는 대상 타입의 널 가능성에 따라 예외가 발생할 수도 있고 널이 될수도 있다.
    * */
    val num: Any = 123
    val s1 = num as? String // null
    val s2 = num as String? // ClassCastException
    println(s1)
    println(s2)
}














