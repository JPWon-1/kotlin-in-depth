import kotlin.math.PI

fun main() {
    CircleFromShape(10.0).print()
    RectancleFromShape(20.0,20.0).print()
}

/*
* 구체적인 개념이 아닌 추상적인 개념의 클래스를 인스턴스화 하는것은 의미가 없다.
* 코틀린에서는 자바와 같이
* abstract class는 인스턴스화 할 수 없고 다른 클래스의 상위 클래스 역할만 할 수 있다.
*
* */

abstract class AbstractEntity(val name: String)
class PersonFromEntity(name: String, val age: Int) : AbstractEntity(name)
//val entity = AbstractEntity("Unknown") // cannot create instance of an abstract class

// 추상클래스의 생성자는 오직 하위 클래스의 생성자에서 위임 호출할수만 있다.
class PersonFromEntity2 : AbstractEntity {
    constructor(name: String) : super(name)
    constructor(
        firstName: String,
        familyName: String
    ) : super("$firstName $familyName")
}

// 추상클래스의 또 달느 특징은 추상 멤버를 정의할 수 있다는 것이다.
// 추상 멤버는 타입, 파라미터, 반환 타입 등 함수나 프로퍼티의 기본적인 모습을 정의하지만, 세부구현을 생략한 멤버다.
// 따라서 이런 멤버를 상속할 때는 구현체가 반드시 구현해야한다.

abstract class Shape {
    abstract val width: Double
    abstract val height: Double
    abstract fun area(): Double
}

class CircleFromShape(val radius: Double) : Shape() {
    val diameter get() = 2 * radius

    override val width: Double get() = diameter
    override val height: Double get() = diameter
    override fun area() = PI * radius * radius
}

class RectancleFromShape(
    override val width: Double, override val height: Double
) : Shape() {
    override fun area() = width * height
}

fun Shape.print() {
    println("Bounds: $width*$height, area: ${area()}")
}



/*
* 인터페이스
* 인터페이스는 자바의 인터페이스와 매우 비슷하다.
*
* 추상클래스와 다른점은
* 생성자를 가질 수 없다.
* 상태를 정의할 수 없다.
* 인터페이스에서 상태를 정의할 수 없거나 생성자를 가질 수 없게 한 이유는 다중 상속을 지원하기 위한것이다.
* */