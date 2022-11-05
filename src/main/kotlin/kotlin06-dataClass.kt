/*
* 코틀린은 데이터를 저장하기 위한 목적으로 주로 쓰이는 클래스를 선언하는 유용한 기능을 제공한다.
* 이런 기능을 데이터 클래스라고 부르며, 이 기능을 사용하면 컴파일러가 동등성을 비교하거나 String으로 변환하는 등의
* 기본 연산에 대한 구현을 자동으로 생성해준다.
* 그리고 구조분해 선언을 활용할 수 있다.
* 구조 분해를 사용하면 클래스의 프로퍼티를 간단한 한 가지 언어 구성 요소를 사용해 여러 변수에 나눠 넣을 수 있다.
* */

class PersonClass(val firstName: String, val familyName: String, val age: Int)
/*
* 예를 들어 위의 클래스의 인스턴스가 동등한지 비교하려면 어떻게 해야할까?
* 객체의 동등성 비교를 할 때에는 메모리의 주소값을 비교한다.
* 인스턴스의 필드값이 같은지 같은거는 고려 대상이 아니다.
* 클래스에 커스텀 동등성 비교가 필요하다면 보통 equals() , hashCode() 메서드를 구현한다.
* 데이터 클래스는 프로퍼티 목록을 기반으로 이러한 메서드를 자동으로 생성해준다.
* */

fun equalsTest() {
    val person1 = PersonClass("1", "2", 3)
    val person2 = PersonClass("1", "2", 3)
    val person3 = person1
    person1 == person2 // false
    person1 == person3 // true
}


data class PersonData(val name: String, val age: Int)

fun dataClassEqualsTest() {
    val person1 = PersonData("1", 1)
    val person2 = PersonData("1", 1)
    val person3 = person1
    person1 == person2 // true
    person2 == person3 // true
}

/*
* 데이터 클래스는 equals(), hashCode() 외에 toString()도 구현해준다.
* 이 메서드는 클래스 인스턴스를 문자열로 변환해준다.
* */

/*
* 또한 모든 데이터 클래스는 암시적으로 copy()를 제공한다.
*
* */
class `kotlin06-dataClass` {
}