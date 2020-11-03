package com.test.datatype;

public class Ex02_Variable_question_01 {
	
	public static void main(String[] args) {
		
		//문제) 9개 자료형을 이용하여 주변의 데이터를 검색하여 자료형을 선택해 변수를 생성하여 값을 대입해 문장으로 출력 X 각 10회
		
		//ex) 몸무게 70kg (가용 범위 : 45 ~ 130.xx) -> double 선택, 변수 생성하기
		double weight;
		weight = 70.5; 
		System.out.println("몸무게는 " + weight + "kg 입니다.");
		
		
		
		//1. byte
		byte score_math = 100;
		System.out.println("수학 점수는 " + score_math + "점 입니다.");
		
		byte possibility_rain = 80;
		System.out.println("오늘의 강수 확률은 " + possibility_rain + "% 입니다.");
		
		byte rate_vote = 75;
		System.out.println("이번 선거의 투표율은 " + rate_vote + "% 입니다.");
		
		byte amount_water = 2;
		System.out.println("하루에 물을 " + amount_water + "L 마십니다.");
		
		byte amount_stockChange = -5;
		System.out.println("오늘 주식의 등락률은 " + amount_stockChange + "% 입니다.");
		
		byte times_class = 8;
		System.out.println("하루에 총 " + times_class + "회의 수업이 진행됩니다.");
		
		byte amount_sleep = 7;
		System.out.println("하루 수면 시간은 " + amount_sleep + "시간입니다.");
		
		byte times_workout = 3;
		System.out.println("일주일에 " + times_workout + "회 운동합니다.");
		
		byte time_left = 8;
		System.out.println("내일까지 " + time_left + "시간 남았습니다.");
		
		byte day = 8;
		System.out.println("오늘은 " + day + "일 입니다.");
		
		
		//2. short
		short amount_walk = 10000 ; 
		System.out.println("하루에 " + amount_walk + "보를 걷습니다.");
		
		short score_toeic = 940 ; 
		System.out.println("토익 점수는 " + score_toeic + "점 입니다.");
		
		short d_day = 180 ; 
		System.out.println("시험까지 " + d_day + "일 남았습니다.");
		
		short size_foot = 240 ; 
		System.out.println("발 사이즈는 " + size_foot + "입니다.");
		
		short currency = 1124 ; 
		System.out.println("오늘의 달러 환율은 " + currency + "원 입니다.");
		
		short price_water = 1000 ; 
		System.out.println("물 한병의 값은 " + price_water + "원 입니다.");
		
		short storage_computer = 1000 ; 
		System.out.println("이 컴퓨터의 저장 용량은 " + storage_computer + "G 입니다.");
		
		short year = 2020 ; 
		System.out.println("올해는 " + year + "년 입니다.");
		
		short minimum_wage = 8000 ; 
		System.out.println("최저 시급은 " + minimum_wage + "원 입니다.");
		
		short speed_plane = 1000 ; 
		System.out.println("비행기의 속도는 " + speed_plane + "km/s 입니다.");
		
		
		//3. int
		int median_apartment = 800000000;
		System.out.println("서울의 아파트 중위값은 " + median_apartment + "원 입니다." );
		
		int average_wage = 3400000;
		System.out.println("직장인 평균 월급은 " + average_wage + "원 입니다." );
		
		int price_laptop = 1500000;
		System.out.println("이 노트북은 " + price_laptop + "원 입니다." );
		
		int area_usa = 983151000;
		System.out.println("미국의 넓이는 " + area_usa + "ha 입니다." );
		
		int population_kor = 50000000;
		System.out.println("대한민국의 인구는 " + population_kor + "명 입니다." );
		
		int population_seoul = 10000000;
		System.out.println("서울의 인구는 " + population_seoul + "명 입니다." );
		
		int average_saving = 8500000;
		System.out.println("직장인 연간 평균 저축액은 " + average_saving + "원 입니다." );
		
		int amount_books = 4500000;
		System.out.println("도서관에는 " + amount_books + "권의 책이 있습니다." );
		
		int amount_words = 40000;
		System.out.println("이 책은 " + amount_words + "단어가 사용되었습니다." );
		
		int amount_short = 65536;
		System.out.println("자바의 변수형 중 short는 " + amount_short + "가지의 정수를 표현할 수 있습니다." );
				
		
		//4. long
		long budget_kor = 54000000000000L;
		System.out.println("대한민국의 1년 예산은 " + budget_kor + "원 입니다.");
		
		long budget_usa = 453200000000000L;
		System.out.println("미국의 1년 예산은 " + budget_usa + "원 입니다.");
		
		long maximum_lotto = 40722950000L;
		System.out.println("역대 로또 최고 당첨금은 " + maximum_lotto + "원 입니다.");
		
		long price_building = 100000000000L;
		System.out.println("강남의 빌딩 한 채의 값은 " + price_building + "원 입니다.");
		
		long size_universe = 46500000000L;
		System.out.println("관측 가능한 우주의 크기는 " + size_universe + "광년 입니다.");
		
		long population_earth = 7000000000L;
		System.out.println("지구의 인구는 약 " + population_earth + "명 입니다.");
		
		long amount_lacto = 3000000000L;
		System.out.println("이 캡슐에는 약 " + amount_lacto + "개의 유산균이 들어있습니다.");
		
		long age_earth = 4600000000L;
		System.out.println("지구의 나이는 약 " + age_earth + "살 입니다.");
		
		long age_sun = 4700000000L;
		System.out.println("태양의 나이는 약 " + age_sun + "살 입니다.");
		
		long age_univverse = 13798000000L;
		System.out.println("우주의 나이는 약 " + age_univverse + "광년 입니다.");
		
		
		
		//5. float
		float value_onethird = 0.333333333333333333F;
		System.out.println("1/3은 소수로 " + value_onethird + "입니다.");
				
		float value_twothird = 0.666666666666666666F;
		System.out.println("2/3은 소수로 " + value_twothird + "입니다.");
		
		float height = 167.2F;
		System.out.println("제 키는 " + height + "cm 입니다.");
		
		float average_height_female = 162.6F;
		System.out.println("여성 평균 신장은 " + average_height_female + "cm 입니다.");
		
		float average_height_male = 175.8F;
		System.out.println("남성 평균 신장은 " + average_height_male + "cm 입니다.");
		
		float average_weight_female = 55.4F;
		System.out.println("여성 평균 몸무게는 " + average_weight_female + "kg 입니다.");
		
		float average_weight_male = 75.6F;
		System.out.println("남성 평균 몸무게는 " + average_weight_male + "kg 입니다.");
		
		float rate_interest_kor = 0.75F;
		System.out.println("한국의 기준금리는 " + rate_interest_kor + "% 입니다.");
		
		float rate_interest_usa = 0.25F;
		System.out.println("미국의 기준금리는 " + rate_interest_usa + "% 입니다.");
		
		float rate_return = -5.3F;
		System.out.println("이 펀드의 평균 수익률은 " + rate_return + "% 입니다.");
				
		
		//6. double
		double pi = 3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679;
		System.out.println("원주율의 값은 " + pi + "입니다.");
		
		double root_2 = 1.41421356237;
		System.out.println("루트 2의 값은 " + root_2 + "입니다.");
	
		double root_3 = 1.73205080757;
		System.out.println("루트 3의 값은 " + root_3 + "입니다.");
		
		double goldenRatio = 1.618;
		System.out.println("황금비의 값은 " + goldenRatio + "입니다.");
		
		double average_rainfall = 68.8;
		System.out.println("이번 달 평균 강수량은 " + average_rainfall + "mm 입니다.");
		
		double average_temperature = 36.5;
		System.out.println("사람의 평균 체온은 " + average_temperature + "도 입니다.");
			
		double slope_pisa = 5.5;
		System.out.println("피사의 사탑은 " + slope_pisa + "도 기울어져 있습니다.");
				
		double eyesight = 0.8;
		System.out.println("시력은 " + eyesight + "입니다.");
				
		double size_room = 9.9;
		System.out.println("이 방의 크기는 " + size_room + "평방미터 입니다.");
				
		double size_monitor = 15.6;
		System.out.println("이 모니터는 " + size_monitor + "인치 입니다.");
		
		
				
		//7. char
		char first_eng = 'a';
		System.out.println("영어의 첫 문자는 " + first_eng + " 입니다.");
		
		char last_eng = 'z';
		System.out.println("영어의 마지막 문자는 " + last_eng + " 입니다.");
		
		char first_consonant_kor = 'ㄱ';
		System.out.println("한글의 첫번째 자음은 " + first_consonant_kor + " 입니다.");
		
		char last_consonant_kor = 'ㅎ';
		System.out.println("한글의 마지막 자음은 " + last_consonant_kor + " 입니다.");
		
		char sign_dollar = '$';
		System.out.println("달러의 기호는 " + sign_dollar + " 입니다.");
		
		char sign_plus = '+';
		System.out.println("더하기 기호는 " + sign_plus + " 입니다.");
		
		char sign_minus = '-';
		System.out.println("빼기 기호는 " + sign_minus + " 입니다.");
		
		char sign_multiply = '*';
		System.out.println("곱하기 기호는 " + sign_multiply + " 입니다.");
		
		char sign_divide = '/';
		System.out.println("나누기 기호는 " + sign_divide + " 입니다.");
		
		char sign_percentage = '%';
		System.out.println("퍼센트 기호는 " + sign_percentage + " 입니다.");
		
		

		//8. String
		String charactor_kor = "한글";
		System.out.println("한국어는 " + charactor_kor + "로 쓸 수 있습니다.");
				
		String charactor_usa = "알파벳";
		System.out.println("영어는 " + charactor_usa + "로 쓸 수 있습니다.");
		
		String capital_kor = "서울";
		System.out.println("한국의 수도는  " + capital_kor + "입니다.");
		
		String capital_usa = "워싱턴";
		System.out.println("미국의 수도는  " + capital_usa + "입니다.");
		
		String name_president = "문재인";
		System.out.println("한국의 대통령은  " + name_president + "입니다.");
		
		String weather_today = "맑음";
		System.out.println("오늘의 날씨는  " + weather_today + "입니다.");
		
		String favorite_food = "떡볶이";
		System.out.println("가장 좋아하는 음식은  " + favorite_food + "입니다.");
		
		String favorite_fruit = "딸기";
		System.out.println("가장 좋아하는 과일은  " + favorite_fruit + "입니다.");
		
		String favorite_place = "한강";
		System.out.println("가장 좋아하는 장소는  " + favorite_place + "입니다.");
				
		String name = "이도윤";
		System.out.println("저의 이름은  " + name + "입니다.");
		
		
		
		
		//9. boolean
		boolean plus = true;
		System.out.println("1 + 1 = 2 입니다. : " + plus );
		
		boolean greater = false;
		System.out.println("1은 2보다 큰 수입니다. : " + greater );
		
		boolean type_boolean = true;
		System.out.println("boolean자료형은 true와 false 둘 중 하나의 값을 가집니다. : " + type_boolean );
		
		boolean preference_rice = true;
		System.out.println("저는 밥을 좋아합니다. : " + preference_rice );
		
		boolean days = true;
		System.out.println("1년은 365일 입니다. : " + days );
		
		boolean hours = true;
		System.out.println("하루는 24시간 입니다. : " + hours );
		
		boolean level_coding = false;
		System.out.println("코딩은 쉽습니다. : " + level_coding );
		
		boolean amount_friends = true;
		System.out.println("나는 친구가 많습니다. : " + amount_friends );
		
		boolean preference_cat = true;
		System.out.println("나는 고양이를 좋아합니다. : " + preference_cat );
		
		boolean career = true;
		System.out.println("나는 직장을 다닌 경험이 있습니다. : " + career );
		
		
	}

}
