/*
* Collection
* 컬렉션은 엘리먼트들로 이뤄진 그룹을 저장하기 위해 설계된 객체다.
* 같은 타입에 속하는 개수가 정해진 여러 원소를 함께 저장하는 배열이 바로 이런 컬렉션 객체였다.
* 하지만 코틀린 표준 라이브러리는 더 강력한 기능을 가진 API를 제공하며 이는 집계, 변환, 순서 지정 등의 데이터 조작을 가능하게 해준다.
*
* 컬렉션을 조작하는 모든 연산이 인라인 함수라는 점에 주목하자. 따라서 이런 연산을 사용해도 함수 호출이나 람다 호출에 따른 비용이 들지 않는다.
*
* 코틀린 컬렉션 타입은 기본적으로 네가지로 분류할 수 있다.
* 1. 배열
* 2. 이터러블
* 3. 시퀀스
* 4. 맵
*
* */

/*
* 이터러블
* 이터러블은 Iterable<T> 타입으로 표현되며, 일반적으로 즉시 계산되는 상태가 있는 컬렉션을 표현한다.
* 상태가 있다는 말은 컬렉션이 원소를 필요할 때 생성하는 제너레이터 함수를 유지하지 않고 원소를 저장한다는 뜻이다.
* 즉시 계산이라는 말은 나중에 어떤 시점에 원소가 초기화되지 않고 컬렉션을 최초로 생성할 때 초기화된다는 뜻이다.
*
* 자바와 비교할 때 코틀린 이터러블의 중요한 특징은 불변 컬렉션과 가변 컬렉션을 구분한다는 점이다.
* 불변 컬렉션은 생성한 다음에 내용을 바꿀 수 없지만, 가변 컬렉션은 언제든지 원소를 추가하거나 삭제할 수 있다.
* 컬렉션의 변경 가능성은 컬렉션 인스턴스에 대한 참조를 저장하는 변수의 변경 가능성과 아무런 관계가 없다는 점에 유의해야한다.
* 가변 변수가 뜻하는 것은 변수가 가리키는 참조를 다른 참조로 바꿀 수 있다는 것뿐이다.
* 예를 들어 가변 컬렉션을 불변 변수에 저장할 수 있다.
* 이런 경우 이 변수가 다른 컬렉션을 가리키게 변경할 수는 없지만, 변수가 가리키는 컬렉션에 원소를 추가하거나 삭제할 수 있다.
*
* val list = ArrayList<String>()
* list.add("abc")
* list = ArrayList<String>() // error: val cannot be reassigned
* */
class kotlin07 {
}