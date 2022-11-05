/*
* 상속
* 도메인 개념에 있는 is-a 관계 ('자동차는 교통수단이다') 와 같이 A 는 B의 일종이라는 관계를 표현하기 위해 대부분의 객체 지향 언어는
* 상속이라는 개념을 사용한다.
* 클래스A의 하위 클래스나 파생 클래스가 클래스B나 기반 클래스를 상속하면 A의 모든 인스턴스는 자동으로 B의 인스턴스로 간주된다.
* 이로 인해 클래스 A는 B에 정의된 모든 멤버와 확장을 자동으로 얻는다.
* 이 관계는 추이적이다.
* 즉 클래스 B가 C 클래스를 상속하면 A는 C의 간접적인 하위 클래스가 된다.
* 자바와 마찬가지로 코틀린 클래스는 단일 상속만을 지원한다.
* 이 말은 어떤 클래스의 상위클래스가 최대 하나뿐이라는 뜻이다. 어떤 크래스의 상위 클래스를 명시하지 않으면 커파일러는 자동으로
* 이 클래스가 내장 클래스인 Any를 상속하는것으로 가정한다.
* 따라서 프로그램의 모든 클래스는 잘 정의된 상속 트리를 구성하게 된다. 이런 트리를 클래스 계층이라고 부른다.
* 다음 절부터는 코틀린의 상속에 대한 기본적인 내용을 다룬다. 하위 클래스를 정의하는 방법, 상위 클래스의 멤버를 상속하고 오버라이드 하는 방법,
* Any 클래스를 통해 모든 클래스에 제공되는 공통 메서드 등을 다룬다.
*
* */

// 하위 클래스를 선언하는 방법 => 주생성자 뒤에 :을 넣고 그 뒤에 상위 클래스가 될 클래스의 이름을 넣으면 된다.
// 코틀린은 extends 나 implements 를 사용하지 않고 항상 콜론(:)을 사용한다.
// open으로 연 클래스는 어떤 클래스의 상위 클래스가 될 수 있다는 뜻이다. 즉 상속에 열려있다
// 반면 open이 안붙은 클래스 (Aircraft) 는 상위 클래스로 지정하는 순간 컴파일러 오류가 발생한다.
open class Vehicle {
    var currentSpeed = 0
    fun start() {
        println("moving")
    }

    fun stop() {
        println("stopped")
    }
}

open class FlyingVehicle : Vehicle() {
    fun takeOff() {
        println("taking off")
    }

    fun land() {
        println(" landing")
    }
}

class Aircraft(val seats: Int) : FlyingVehicle()

// 상속이 제공하는 강력한 기능은 임의 다형성이다. 임의 다형성은 상위 클래스 멤버의 여러 다른 구현을 하위 클래스에서 제공하고
// 런타임에 실제 인스턴스가 속한 클래스에 따라 구현을 선택해주는 기능을 말한다.
// 코틀린에서는 상위 클래스의 멤버를 오버라이드해서 임의 다형성을 달성할 수 있다.

open class Vehicle2 {
    open fun start() {
        println("starting")
    }
}

class Car : Vehicle2() {
    override fun start() {
        println("i'm riding")
    }
}

class Boat : Vehicle2() {
    override fun start() {
        println("i'm sailing")
    }
}

// open 으로 열린 함수를 만들면 오버라이딩이 가능하게 만들어진다.
fun start(vehicle: Vehicle2) {
    vehicle.start()
}

fun main() {
    start(Car())
    start(Boat())
    Student("test", 25, "MIT")
}

// 프로퍼티도 오버라이드 할 수 있다. 하위 클래스 본문에 구현을 넣는 방법 외에 주생성자 파라미터로 오버라이드 할 수도 있다.
open class Entity {
    open val name: String get() = ""
}

class Person2() : Entity() {
    override var name: String = "" // 불변 프로퍼티를 가변 프로퍼티로 받을 수 있다.
}

open class Person3(val name: String, val age: Int)

// 상속에서 하위 클래스의 데이터를 상위로 넘겨야 할 때는? 위임 패턴 사용
class Student(name: String, age: Int, val university: String) : Person3(name, age)

// 부생성자를 통한 호출
class Student2 : Person3 {
    val university: String

    constructor(name: String, age: Int, university: String) : super(name, age) {
        this.university = university
    }
}

class `kotlin08-inheritance`


















