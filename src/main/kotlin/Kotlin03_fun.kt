import kotlin.math.PI

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
    fun mul(a: Int, b: Int) :Int = a * b
    fun mul(a: Long, b: Int) : Long = a * b
    fun main3(){
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
    fun change(vararg items: IntArray){
        items.iterator().forEach {
            println(it.contentToString())
        }
        items[0][1] = 100
    }
}


fun main(){
    val kotlin03Fun = Kotlin03_fun()
    kotlin03Fun.printSorted(6,2,10,1)
    val numbers = intArrayOf(6,2,10,1)
    kotlin03Fun.printSorted(*numbers)

    val a= intArrayOf(1,2,3,)
    val b = intArrayOf(4,5,6)

    kotlin03Fun.change(a,b)
    println(a.contentToString())
    println(b.contentToString())

    /*
    * 둘 이상을 vararg 파라미터로 선언하는 것은 금지된다.
    * 하지만 vararg 파라미터에 콤마로 여러 인자와 스프레드를 섞어서 전달하는 것은 괜찮다.
    * 호출 시 이러한 호출은 원래의 순서가 유지되는 단일 배열로 합쳐진다.
    * */
    println(kotlin03Fun.printSorted(6,1,*intArrayOf(1,2,3,4),2))//6,1,1,2,3,4,2
    //=> [1,1,2,2,4,6]

}













