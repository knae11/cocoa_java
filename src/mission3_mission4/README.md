# Cocoa Java Mission 3 , 4

## 기간
- 2020.11.09~11.10
- 2020.11.11~11.12

## 미션목록
- 가계부 구현하기
```
- 간단한 가계부를 구현한다.
- 키보드를 통해 데이터 입력을 받고 화면에 내용을 출력한다.
- 사용자 등록: 사용자 이름 및 비밀번호를 입력받는다.
- 데이터 입력: 날짜, 적요, 수입, 지출을 입력받는다.
- 데이터 삭제: 특정 순번의 데이터를 삭제한다.
- 데이터 수정: 특정 순번의 데이터를 수정할 수 있다.
- 화면에 출력: 해당 월의 지출내역을 순번, 적요, 수입, 지출, 잔액으로 화면에 출력한다.
```
- 가계부 확장
```
- 자동 저장 기능을 추가한다. 프로그램 종료 후 다시 시작해도 데이터가 보존되도록 구현해 보자.
- 소비 유형을 추가한다. (현금 / 카드)
- 검색 기능을 구현한다. 적요, 날짜, 금액, 수입, 지출, 소비 유형별로 검색을 하고 결과를 표시할 수 있어야 한다.
- 정렬해서 보여주기 기능을 추가한다. 날짜 또는 금액의 오름차순 또는 내림차순으로 정렬해서 화면에 출력할 수 있어야 한다.
```

## 학습

### MISSION 3
- nextLine과 next, nextInt 등으로 입력값을 받는데 생기는 차이, println으로 인해 발생하는 문제점!!!
> 입력조건이 일정하지 않다면 nextLine() 을 사용하도록 하자.
> trim()을 사용하여 공백제거
- class로 나눠보기! 
> 메인 데이터를 다루는 곳은 어디가 될 것 인지, 메서드에서 return 받고 값을 넘겨주기
- hashMap을 사용한 데이터 관리
> - 원하는 대로 입력받지 못하면 오류가 발생할 가능성이 높다.     
> : 어떻게 하면 원하는 대로 안전하게 데이터를 받을 수 있을지 고민해야할 문제!!
> - 어떤 자료구조를 사용하여 어떤 방식으로 담는 것이 추후 데이터 처리에 손쉬운지 생각해보자.     
> : 지금 생각으로는 다중 hashMap과 배열로 접근하게 하는 방식(JSON처럼..?)이 좋을 것 같은데 아직 하나의 hashMap 사용   
> : 계속 돌리면서 자료를 parsing하고 조건에 맞는 데이터만 가져오는 방식을 사용하였다.

### MISSION 4

- hashMap, arrayList
- file I/O




## 기타학습 및 개인회고
- [6일차](https://www.notion.so/6-b14b745c8f3448a49d4168b88a6a0a6c)
- [7일차](https://www.notion.so/7-c922612244514d91b7f25b30c5721dd4)
- [8일차](https://www.notion.so/8-2172c95506d04f02be62ee63e536ebb6)