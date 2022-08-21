class Kotlin02 {
    // 2-1 기본 문법
    /*
    * 불변 변수
    * val 변수명 앞에 타입이 val 이며 이는 value의 약자이다.
    * 변할수 없는 불변(immutable) 성질을 가지고 있다.
    * 이는 자바의 final 과 비슷하다.
    * */

    /*
    * 식별자
    * 식별자는 변수나 함수 등 프로글매에 정의된 대상에 붙은 이름이다.
    * 식별자는 오직 문자, 숫자, _ 만 포함되고, 숫자로 시작할 수 없다.
    * 일반적으로 영어 단어와 일반 숫자를 사용하는 쪽이 더 좋은 관습으로 여겨진다.
    * */

    /*
    * 가변 변수
    * 가변의 성질을 가지고 있는 변수이다.(mutable)
    * var로 선언하고 이는 variable의 약자이며
    * 처음 변수에 값을 대입할 때 추론된 변수 타입은 변수가 불변이든 그렇지 않든 계속 유지된다.
    * 결국 잘못된 타입의 값을 대입하면 컴파일 오류가 발생한다.
    * */

    // 2-2 기본 타입
    /*
    * 자바에서는 원시 타입과 클래스 기반의 참조타입이 존재하고 명확한 구분이 있었다.
    * 코틀린에서는 똑같은 타입이 문맥에 따라 원시타입인지 참조타입인지를 가리키기 때문에 이런 구분이 약간 모호하다.
    * 자바에서는 원시 타입을 감싸는 박싱 타입이 있지만, 코틀린은 필요할 때 암시적으로 박싱을 수행한다.
    *
    * 코틀린 타입은 근본적으로 어떤 클래스 정의를 기반으로 만들어진다.
    * 이 말은 원시 타입과 비슷한 타입들도 메서드와 프로퍼티를 제공한다는 뜻이다.
    * ex) 1.5.toInt() 라는 식으로 1.5에 대해 Double 타입에 정의 된 toInt() 메서드를 호출할 수 있다.
    * */

    /*
    * 정수 타입
    * Byte 크기 : 1 바이트, 범위 : -128~127
    * Short 크기 : 2바이트, 범위 : -32768~32767
    * Int 크기 : 4바이트, 범위 : -2^31 ~ 2^31-1
    * Long 크기 : 8바이트, 범위 : -2^63 ~ 2^63-1
    * */

    /*
    * 부동소수점 수
    * 자바와 마찬가지로 Float, Double 을 제공한다.
    * 자바에서는 D나 d를 부동소수점 리터럴 뒤에 붙여서 강제로 double 타입으로 만들 수 있다.
    * 하지만 코틀린에서는 이런 접미사를 허용하지 않으며, 기본 타입은 Double이다.
    * val pi : Double = 3.14f // Error 발생!
    * */

    /*
    * 산술 연산
    * 각 이항 산술 연산마다 모든 가능한 수 타입 간의 연산을 지원하기 위한 변종이 함께 제공한다.
    * 수 타입이 6가지가 있으므로 각 연산마다 6*6 = 36 가지 버젼이 있다는 뜻이다.
    * 이러한 산술 여산의 결과는 인자 중 더 큰 의미를 지니는 타입이 된다
    * Double > Float > Long > Int > Short > Byte
    *
    * byte + byte = Byte
    * int + byte = Int
    * int + int = Int
    * int + long = Long
    * long + double = Double
    * float + double = Double
    * float + int = Float
    * long + double = Double
    * */

    /*
    * 비트 연산
    * Int와 Long은 비트 수준의 연산을 지원한다.
    * shl - 왼쪽 쉬프트 ( 자바 : << )
    * shr - 오른쪽 쉬프트 ( 자바 : >> )
    * ushr - 부호없는 오른쪽 쉬프트 ( 자바 : >>> )
    * and - 비트 곱 ( 자바 : & )
    * or - 비트 합 ( 자바 : : )
    * xor - 비트 배타합 ( 지바 : ^ )
    * inv - 비트 반전 ( 자바 : ~ )
    * */

    /*
    * 문자 타입 Char
    * Char타입은 유니코드 한 글자를 표현하며 16비트이다.
    * 작은 따옴표(') 사이에 문자를 넣으면 된다
    * val z = 'z'
    * val alpha = 'a'
    *
    * 문자를 증가시키거나 감소시킬 수 있다
    * var a = 'a'
    * println(++a) // b , a의 다음 글자
    * var c = 'c'
    * println(c-a) // 2 , c와 a간의 거리
    * */

    /*
    * 수 변환
    * 수의 변환은 큰거에서 작은거로는 가능하지만 작은거에서 큰거로는 변환할 수 없다.
    * val n = 100
    * val l : Long = n // Error : can't assign Int to Long
    * 이는 자바에서도 마찬가지이다.
    * Integer n = 100;
    * Long l = n; // Error : can't assign Integer to Long
    * 이렇게 하면 안되는 이유는 암시적인 박싱 때문이다. Int가 꼭 원시 타입의 값으로 표현된다는 보장이 없다.
    * 따라서 위의 타입으로 변환하느 경우 다른 박싱한 타입의 값을 만들어 낼 수 있는 가능성이 생기고,
    * 이로 인해 동등성 요구 조건을 만족시키지 못하게 되면서 미묘한 오류를 발생시킬 수 있다.
    *
    * 부동 소수점 수 타입과 관련된 변환의 경우, 일반적으로 대상 타입과 무관하게 정밀도를 잃을 수 있다.
    * 예를 들어 Long을 Float으로 변환하면 LSB 쪽 (2진수로 표현했을 때 하위 비트 쪽) 을 잃어버릴 수 있다.
    * 부동소수점 수를 정수로 변환하는 연산은 기본적으로 0 쪽으로 어림하는 연산이다
    * println(2.5.toInt()) // 2
    * println((-2.5).toInt()) // -2
    * println(1_000_000_000_000.toFloat().toLong()) // 999999995904
    * >어림?
    * 실수를 정수로 만들 때 수직선상에서 0쪽으로 값이 이동한다고 생각하면 된다.
    * 즉 절대값이 감소하는 방향으로 변환이 이뤄진다. 예를 들어 1.5는 1로, -1,5는 -1로 바뀐다.
    * 한편 여기서 얼미 계산은 10진수에서 벌어지지 않고 2진수에서 벌어진다.
    * 따라서 1_000_000_000_000.toFloat().toLong() 이 999_999_995_904 가 나오게 되는 것이다.
    * */

    /*
    * 불 타입과 논리 연산
    * ! : 논리 부정
    * or, and , xor : 즉시 계산 방식의 논리합, 논리곱, 논리배타합
    * || , && : 지연 계산 방식의 논리합, 논리곱
    * 지연 계산 방식은 자바와 동일한 의미를 제공한다.
    * 즉시 계산 방식은 지연 계산 방식보다 더 우선해 계산된다.
    * a || b and c or d && e  는
    * a || ( (b and c) or d ) && e ) 를 의미한다.
    * */

    /*
    * 비교와 동등성
    * ==
    * !=
    * <
    * <=
    * >
    * >=
    *
    * NaN 은 어떤것과도 같지 않다.
    * Nan == Nan 이 무조건 false인 이유는
    * NaN을 표현하는 비트 패턴이 다양하기 때문이다.
    * 따라서 어떤 값이 NaN인지 알아내려면 isNaN() 함수를 사용해야 한다.
    * */

    /*
    * 문자열
    * 자바와 마찬가지로 코틀린 문자열도 불변이다.
    * 따라서 String 객체를 만들고 나면 그 안의 문자를 변경할 수 없고 문자열을 읽기만 할 수 있으며, 문자를 바꾸고 싶으면
    * 기존 문자열을 바탕으로 새로운 문자열을 만들어야 한다.
    *
    * 문자열에 특수문자가 들어가려면 이스케이프 시퀀스를 사용해야 한다. ( \n \t 등..)
    * 이를 사용하지 않고 사용하려면 큰따옴표 세개로 둘러싸은 로우 문자열(raw String)을 사용하면 된다.
    * val message = """
    *   hello, $name!
    *   today is ${Date()}
    * """.trimIndent()
    * */

    /*
    * 기본 문자열 연산
    * 자바의 == 와 != 연산자는 참조 동등성(referential equality)를 비교하기 때문에
    * 실제 문자 내용을 비교하려면 equals()메서드를 사용해야 한다.
    * 코틀린에서는 == 와 != 연산자가 equals()를 호출한다.
    * 따라서 참조 동등성을 비교하고 싶다면 === , !== 연산자를 사용해야 한다.
    * */


    /*
    * 배열
    * 코틀린 배열은 개념적으로 자바 배열과 비슷하며, 실제로 코틀린/JVM 애플리케이션에서는
    * 자바 배열로 코틀린 배열을 표현한다.
    *
    * val a = emptyArray<String>()
    * val b = arrayOf("hello","world")
    * val c = arrayOf(1,4,9)
    *
    * val size = readLine()!!.toInt()
    * val squares = Array(size){(it+1)*(it+1)}
    * 중괄호 안에 들어있는 언어 요소를 람다라고 부르는데, 람다는 인덱스를 기반으로 값을 계산하는 식을 정의한다.
    * 이때 인덱스를 표현하는 변수로 자동으로 선언되는 it를 사용한다.
    * it 는 0부터 시작이기 때문에 1을 넣었을 경우 1
    * 3을 넣었을 경우 1, 4, 9 등의 값이 들어간다.
    *
    * Array<Int>를 사용하는 배열은 모든 수를 박싱하기 때문에 그다지 실용적이지 못한 해법이다.
    * 따라서 코틀린은 더 효율적인
    * ByteArray, ShortArray, IntArray, LongArray, FloatArray, DoubleArray, CharArray, BooleanArray 를 제공한다.
    * */

    /*
    * 배열 사용하기
    * 배열 타입은 문자열 타입과 꽤 비슷하다.
    * size, lastIndex 프로퍼티가 있다는 점과 인득스로 원소에 접근할 수 있다는 점이 비슷하다.
    *
    * 다른점은, 배열에서는 원소를 변경할 수 있다.
    * val squares = arrayOf(1,4,9,16)
    * squares[2] = 100 // 1, 4, 100, 16
    * squares[3]+= 9 // 1 , 4, 100 , 25
    * squares[0]-- // 0 , 4 , 100 , 25
    *
    * 자바에서는 상위 타입의 배열에 하위 타입의 배열을 대입할 수 있다.
    * Object[] objects = new String[]{"one","two"};
    * objects[0] = mew Object() ; // ArrayStoreException 예외 발생
    * 위의 이유로 코틀린에서는 자신과 같은 타입을 제외한 모든 다른 배열 타입과 서로 하위 타입관계가 성립하지 않는다고 간주한다.
    * String은 Any의 하위 타입이지만 Array<String> 은 Array<Any>의 하위 타입이 아니다.
    * val strings = arrayOf("one","two")
    * val objects: Array<Any> = strings // 예외 발생
    *
    * 배열의 내용을 비교하려면 == 나 != 가 아닌 contentEquals() 함수를 사용해야 한다.
    * ===, !== 를 사용하면 contentEquals()로 바꾸라는 경고가 표시된다(인텔리제이)
    *
    *  * */
}


















