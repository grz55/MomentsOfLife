package com.grz55.MomentsOfLife;

import com.grz55.MomentsOfLife.utils.DifferenceDatesCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;

@SpringBootTest
class MomentsOfLifeApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void calculatingYearsDifference(){
		assertEquals(0, DifferenceDatesCalculator.getDifferenceYears("2019-05-10","2020-05-09"));
		assertEquals(1, DifferenceDatesCalculator.getDifferenceYears("2019-05-10","2020-05-10"));
		assertEquals(25, DifferenceDatesCalculator.getDifferenceYears("1994-06-03","2020-05-10"));
		assertEquals(26, DifferenceDatesCalculator.getDifferenceYears("1994-06-03","2020-06-03"));
	}

	@Test
	void calculatingMonthsDifference(){
		assertEquals(1, DifferenceDatesCalculator.getDifferenceMonths("2020-02-10","2020-04-09"));
		assertEquals(2, DifferenceDatesCalculator.getDifferenceMonths("2020-02-10","2020-04-10"));
		assertEquals(400, DifferenceDatesCalculator.getDifferenceMonths("1994-06-03","2027-10-03"));
	}

	@Test
	void calculatingWeeksDifference(){
		assertEquals(0, DifferenceDatesCalculator.getDifferenceWeeks("2020-02-10","2020-02-16"));
		assertEquals(1, DifferenceDatesCalculator.getDifferenceWeeks("2020-02-10","2020-02-17"));
		assertEquals(1400, DifferenceDatesCalculator.getDifferenceWeeks("1994-06-03","2021-04-02"));
	}

	@Test
	void calculatingDaysDifference(){
		assertEquals(1, DifferenceDatesCalculator.getDifferenceDays("2020-05-09","2020-05-10"));
		assertEquals(2, DifferenceDatesCalculator.getDifferenceDays("2020-05-09","2020-05-11"));
		assertEquals(9999, DifferenceDatesCalculator.getDifferenceDays("1994-06-03","2021-10-18"));
		assertEquals(10000, DifferenceDatesCalculator.getDifferenceDays("1994-06-03","2021-10-19"));
	}

	@Test
	void calculatingHoursDifference(){
		assertEquals(24, DifferenceDatesCalculator.getDifferenceHours("2020-05-09","2020-05-10"));
		assertEquals(24, DifferenceDatesCalculator.getDifferenceHours("2020-05-09","2020-05-10"));
		assertEquals(48, DifferenceDatesCalculator.getDifferenceHours("2020-05-09","2020-05-11"));
		assertTrue(DifferenceDatesCalculator.getDifferenceHours("1994-06-10","1994-06-14")<100);
		assertTrue(DifferenceDatesCalculator.getDifferenceHours("1994-06-10","1994-06-15")>100);
		assertEquals(300000, DifferenceDatesCalculator.getDifferenceHours("1994-06-03","2028-08-23"));
		assertTrue(DifferenceDatesCalculator.getDifferenceHours("1994-06-03","2028-08-23")<=300000);
		assertTrue(DifferenceDatesCalculator.getDifferenceHours("1994-06-03","2028-08-24")>300000);
	}

	@Test
	void calculatingMinutesDifference(){
		assertEquals(1440, DifferenceDatesCalculator.getDifferenceMinutes("2020-05-09","2020-05-10"));
		assertEquals(2880, DifferenceDatesCalculator.getDifferenceMinutes("2020-05-09","2020-05-11"));
		assertTrue(DifferenceDatesCalculator.getDifferenceMinutes("1994-06-03","2021-01-14")<14000000);
		assertTrue(DifferenceDatesCalculator.getDifferenceMinutes("1994-06-03","2021-01-15")>14000000);
	}

	@Test
	void calculatingSecondsDifference(){
		assertEquals(86400, DifferenceDatesCalculator.getDifferenceSeconds("2020-05-09","2020-05-10"));
		assertEquals(172800, DifferenceDatesCalculator.getDifferenceSeconds("2020-05-09","2020-05-11"));
		assertTrue(DifferenceDatesCalculator.getDifferenceSeconds("1994-06-03","2026-02-09")<1000000000);
		assertTrue(DifferenceDatesCalculator.getDifferenceSeconds("1994-06-03","2026-02-10")>1000000000);
	}

}
