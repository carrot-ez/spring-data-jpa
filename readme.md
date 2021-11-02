# Spring data jpa

jpa 관련 공부 정리 레포입니다.

## 복합키 매핑

### `@IdClass`

- Entity내에서 `@Id` 어노테이션을 여러 번 사용하여 나타낸다.
- 개인적으로 한눈에 보기가 편하고, 타 엔티티의 FK를 복합키로 사용할때 직관적이어서 `@EmbeddedId` 방식보다 좋다고 생각된다. 

> ```java
> @Entity
> @IdClass(EmployeeId.class)
> public class Employee {
>     @Id
>     @Column(name = "emp_id")
>     private Long empId;
> 
>     @Id
>     @ManyToOne(fetch = FetchType.LAZY)
>     @JoinColumn(name = "dep_id", updatable = false, insertable = false)
>     private DepartmentEntity depId;
> }
> ```

### `@EmbeddedId`

- `@IdClass` 보다 객체지향적인 방법이라고 설명되어있다.
- `@MapsId`를 이용하여 `@EmbeddedId` 내의 pk와 fk를 연결한다.

> ```java
> @Entity
> public class Employee {
>     @EmbeddedId
>     private EmployeeId empId;
>     
>     @MapsId("depId") // EmployeeId의 필드값과 동일한 이름이어야 한다.
>     @ManyToOne(fetch = FetchType.LAZY)
>     @JoinColumn(name = "dep_id", updatable = false, insertable = false)
>     private DepartmentEntity department;
> }
> ```

### 공통

- 두 방식 모두 ID 클래스를 구현하고, `Serializable`을 구현해야한다. 
- `equasl`, `hashcode`를 구현하기를 권장한다. 

> ```java
> @EqaulsAndHashCode
> @Embeddable // if use @EmbeddedId
> public class EmployeeId implements Serializable {
>     private static final long serialVersionUID = 1L;
> 
>     private Long empId;
>     private Long depId;
> }
> ```

## `@Column`, `@JoinColumn`

### `@Column`

- DB 컬럼에 대한 정보를 설정할 수 있음

### `@JoinColumn`

- FK를 정의할때 사용
- **`@Column`과 함께 쓸 수 없음.**
- `name` 속성은 컬럼의 이름을 지정하는 컬럼임. 조인해야하는 대상 컬럼을 지정하는것이 아님을 주의
- `referencedColumnName` 속성은 조인할 대상 컬럼을 명시하는 컬럼임. 기본값은 대상 테이블의 기본키
- `foreignKey` 속성은 외래키 제약조건을 수정할때 사용, 기본값으로는 Provider의 기본전략을 따름.