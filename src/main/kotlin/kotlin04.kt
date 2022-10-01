import java.lang.IllegalArgumentException

/**
 * 클래스에서 배우는 내용
 * 1. 클래스 저으이와 멤버
 * 2. 생성자
 * 3. 멤버 가시성
 * 4. 내포된 클래스와 지역 클래스
 * 5. 널이 될 수 있는 타입
 * 6. 단순하지 않은 프로퍼티를 사용하는 방법
 * 7. 객체와 동반 객체
 *
 * 목표 : 클래스와 객체를 사용하는 코틀린 객체지향 프로그래밍의 기본을 익히고, 널이 될 수 있는 값을 처리하는 법을 배운다.
 * 또한 여러 유형의 프로퍼티를 사용하는 방법을 이해한다.
 */
class kotlin04 {
    // 01. 클래스 정의하기
    // 기본적으로 클래스 선언은 참조 타입을 정의한다. 즉 이런 참조 타입의 값은 특정 클래스 인스턴스의 실제 데이터 위치를 가리키는 참조다.
    // 자바는 new 를 통해 명시적으로 특별한 생성자 호출을 통해 생성하였고 가비지 컬렉터에 의해 해제하는 식으로 사용을 했다.
    // 코틀린은 인라인 클래스를 사용한다.
    // 인라인 클래스를 사용하면 참조 타입이 아닌 타입을 정의할 수 있다.
    class Person {
        var firstName: String = ""
        var familyName: String = ""
        var age: Int = 0

        fun fullname() = "$firstName $familyName"
        fun showAge(p: Person) = println(p.age)
        fun readAge(p: Person) {
            p.age = readLine()!!.toInt()
        }

        fun showMe() {
            println("${fullname()}: $age")
        }
    }
    // 클래스 프로퍼티는 지역 변수와 마찬가지로 불변일 수 있다. (val)
    // 이럴 경우 생성자를 사용하여 초기화하여서 값을 변경할 수 있게 해주어야 한다.

    // 02 생성자
    class Person2(firstName: String, familyName: String) {
        var age: Int = 0
        val fullname = "$firstName $familyName"
        fun showAge(p: Person) = println(p.age)
        fun readAge(p: Person) {
            p.age = readLine()!!.toInt()
        }

        fun showMe() {
            println("$fullname}: $age")
        }

        // 초기화 블록
        // return문이 들어가지는 못함.
        init {
            println("Created new Person2 Instance")
        }
    }

    class Person3(firstName: String, familyName: String) {
        val firstName = firstName
        val fullname = "$firstName $familyName"
        fun printFirstname() {
            println(firstName)
        }
    }

    // Person3 처럼 멤버 프로퍼티에 값을 넣는 방법도 있지만 코틀린에서는 생성자 파라미터를 통해 멤버 프로퍼티를 만들 수 있는
    // 간단한 방법을 제공한다.
    class Person4(val firstName: String, val familyName: String) {
        val fullName = "$firstName $familyName"
        fun printFirstName() {
            println(firstName)
        }
    }
    /*
    * 기본적으로 생성자 파라미터 앞에 val, var 키워드를 덧붙이면, 자동으로 해당 생성자 파라미터로 초기화되는 프로퍼티를 정의한다.
    * 이때 파라미터 이름을 프로퍼티 초기화나 init 블록 안에서 참조하면 생성자 파라미터를 가리키고, 다른위치에서 참조하면 프로퍼티를 가리키게 된다.
    * */

    // 함수와 마찬가지로 디폴트 값과 vararg를 생성자 파라미터에 사용할 수 있다.
    class Room(vararg val persons: Person) {
        fun showNames() {
            for (person in persons) println(person.fullname())
        }
    }

    // 생성자를 사용해 클래스 인스턴스를 서로 다른방법으로 초기화하고 싶을 때도 있다.
    // 이러한 경우도 대부분은 디폴트 파라미터를 사용하는 주생성자로 해결할 수 있지만, 경우에 따라 주생성자만으로는 충분하지 않을 수 있다.
    // 이러한 문제를 코틀린에서는 부생성자를 사용해 해결할 수 있다.
    // 문법은 constructor 키워드를 사용한다.
    class Person5 {
        val firstName: String
        val familyName: String

        constructor(firstName: String, familyName: String) {
            this.firstName = firstName
            this.familyName = familyName
        }

        constructor(fullName: String) {
            val names = fullName.split(" ")
            if (names.size != 2) {
                throw IllegalArgumentException("invalid name")
            }
            firstName = names[0]
            familyName = names[1]
        }
    }

    // 부생성자는 반환 타입을 지정할 수 없지만 기본적으로 Unit타입값을 반환하는 함수와 마찬가지 형태다.
    // 부생성자 안에는 return 을 사용할 수 있다.

    // 생성자 위임호출을 사용해 다른 부생성자를 호출한다.
    class Person6 {
        val fullName: String

        constructor(firstName: String, familyName: String) : this("$firstName $familyName")
        constructor(fullName: String) {
            this.fullName = fullName
        }
    }

    // 멤버 가시성
    /*
    * public, internal, protected, private
    *
    * public : 멤버를 어디서나 볼 수 있다.
    * internal : 멤버를 멤버가 속한 클래스가 포함된 컴파일 모듈 내부에서만 볼 수 있다.
    * protected : 멤버를 멤버가 속한 클래스와 멤버가 속한 클래스의 모든 하위 클래스 안에서 볼 수 있다.
    * private : 멤버를 멤버가 속한 클래스 내부에서만 볼 수 있다.
    * */


}


// nested class
class Person7(val id: Id, val age: Int) {
    class Id(val firstName: String, val familyName: String)

    fun showMe() = println("${id.firstName}, ${id.familyName}")
}

class privatePerson7(private val id: Id, private val age: Int) {
    class Id(
        private val firstName: String,
        private val familyName: String
    ) {
        // 내포된 클래스도 자신을 둘러싼 클래스의 멤버이므로 자신을 포함하는 클래스의 비공개 선언에 접근할 수 있다.
        fun nameSake(person: privatePerson7) = person.id.firstName == firstName
    }

}

fun main() {
    val id = Person7.Id("John", "Doe")
    val person = Person7(id, 25)
    person.showMe()


    val person2 = Person8("john", "doe")
    val wallet = person2.Possesion("wallet")
    wallet.showOwner()
}

// inner class
// inner 클래스는 그 클래스의 외부 인스턴스에 접근할 수 있다.
class Person8(val firstName: String, val familyName: String) {
    inner class Possesion(val description: String) {
        fun showOwner() = println(fullName())
    }

    private fun fullName() = "$firstName $familyName"

}






















