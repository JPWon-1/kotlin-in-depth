/*
* 이넘 클래스는 미리 정의된 상수들로 이뤄진 제한된 집합을 표현하는 특별한 클래스다.
* */

// 가장 단순한 형태의 이넘 클래스는 본문에 상수를 모아둔 형태다.
enum class WeekDay {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

fun WeekDay.isWorkDay() = this == WeekDay.SATURDAY || this == WeekDay.SUNDAY

//fun main() {
//    println(WeekDay.MONDAY.isWorkDay())
//    println(WeekDay.SUNDAY.isWorkDay())
//}

// enum with when
// enum을 사용하면 when식에서 모든 enum값을 다 다룰 경우 else를 생략해도 된다.
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

fun rotateClockWise(direction:Direction) = when(direction) {
    Direction.EAST -> Direction.SOUTH
    Direction.NORTH -> Direction.EAST
    Direction.SOUTH -> Direction.WEST
    Direction.WEST -> Direction.NORTH
}

// custom enum class
// enum 클래스에 확장함수나 프로퍼티를 붙일 수 있다.
// 이 때 이넘 상수 뒤에 세미콜론(;)로 끝남을 정의해야하고, 확장함수나 프로퍼티 등의 요소들은 상수 뒤에 와야한다.

enum class WeekDay2 {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    val lowerCaseName get() = name.lowercase()
    fun isWorkDay() = this == SATURDAY||this==SUNDAY
}


// 이넘 클래스에 생성자가 있으면 각 이넘 상수정의 뒤에도 적절한 생성자 호출을 추가해야 한다.
enum class RainbowColor(val isCold:Boolean) {
    RED(false), ORAGEN(false), BLUE(true), BLACK(true);
    val isWarm get() = !isCold
}

// 모든 이넘값에는 ordinal 과 name이라는 한 쌍의 프로퍼티가 들어있다.
// ordinal은 이넘 클래스에 정의된 이넘 값의 순서에 따른 인덱스이고
// name은 이넘 값의 이름이다.

class kotlin06 {

}

fun main() {
    println(WeekDay2.MONDAY.isWorkDay())
    println(WeekDay2.MONDAY.lowerCaseName)

    println(RainbowColor.BLACK.isCold)
    println(RainbowColor.RED.isCold)

    println(WeekDay.MONDAY.ordinal)
    println(WeekDay.MONDAY.name)
}
