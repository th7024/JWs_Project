# SQL문 정리 

- #검색
  Select Name, Population from city; 


  Select Name
  from city
  where Population >= 800000; #조건

  desc city; #테이블 정보보기(칼럼만 나옴)

  Select *
  from city
  where CountryCode='KOR'
  and Population >=1000000;

  #Like 
  검색할때 사용
  문자 뒤에 _ , % 사용함
  _ : 한글자만 매치 (ko_ => KOR)
  % : 무엇이든 허용 글자수 관계 X(Tel % => Tel Aviv-jaffa)

  1.select * 
  From city
  where CountryCode = ( 2.select CountryCode
                                   from city
                                   where Name = 'Seoul');
  해석 city테이블에서countrycode가 서울인 것을 찾을것이다.(2) ->KOR
  city 테이블에서 KOR이라는(2번 출력) 컨트리 코드를 가진 모든 데이터를 출력한다.(1)

  #order by : 결과가 출력되는 순서 조절
  select * 
  From city
  order by Population (desc오름차순), (ASC내림차순) 

  select * 
  From city
  where CountryCode='KOR'
  order by Population desc;

  select * 
  from country
  order by SurfaceArea Desc;

  #DISTINCT 중복제거

  #LIMIT 출력개수 제한

  #group by 그룹으로 묶어주는 역할
  AVG : 평균값
  MIN : 최소값
  MAX : 최대값
  AS '별칭' 

  #Rollup : 총합 또는 중간합계가 필요한 경우 사용
  select countryCode, Name, SUM(Population)
  From city
  group by countryCode, Name With rollup

  #Join 두개의 테이블을 합칠 때 사용
  조건이 필요함 (ON)
  select *
  From city
  Join country ON city.CountryCode = Country.Code

  #concat(문자열)
  괄호안에 있는 문자열들을 합쳐 하나로 만들어줌
  NULL이 있으면 NULL로 합침

  #locate(문자열1, 문자열2)
  문자열1이 문자열2의 어느 위치에 있는지 찾는 방법
  찾는 문자열이 없으면 0을 반환, mysql에서는 시작 인덱스가 1로 시작됨

  #left, right(문자열, 숫자)
  지정된 숫자만큼 문자열에서 잘라 보여줌

  #LOWER, UPPER(문자열)
  문자열을 대소문자로 변경해줌

  #REPLACE(문자열1, 문자열2, 문자열3)
  문자열1에서 문자열2를 찾아 문자열3으로 바꾸어줌

  #TRIM(문자열)
  문자열 앞 뒤 공백 제거
  select trim(Leading '*' From '**asd*asdasd**') 앞 문자 제거
  select trim(TRAILING '*' From '**asd*asdasd**') 뒷문자 제거

  #format(숫자1,숫자2)
  숫자1을 숫자2만큼의 간격으로 자름

  #ABS(숫자)절대값 반환

  #ADD : 테이블 안에 컬럼 추가

  #MODIFY : 테이블안에 있는 컬럼 수정
