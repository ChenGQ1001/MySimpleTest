package test.quartz;

import java.text.ParseException;

import org.quartz.CronExpression;

public class CronExpToChinese {

	public static String getTypeByCron(String expression) {
		String type = "";
		if (expression.indexOf(" * * ?") != -1) {// 每日
			type = "* * ?";
		} else if (expression.indexOf(" ? * ") != -1) {// 每周
			type = "? *";
		} else if (expression.indexOf(" * ?") != -1) {// 每月
			type = "* ?";
		} else {// 指定日期
			type = "year";
		}
		return type;
	}

	public static String getWeekByCron(String expression) {
		String[] expressionArray = expression.split(" ");
		String week = expressionArray[5];
		week = week == "?" ? "1" : week;
		return week;
	}

	public static String getDayByCron(String expression) {
		String[] expressionArray = expression.split(" ");
		return expressionArray[3];
	}

	public static String getMonthByCron(String expression) {
		String[] expressionArray = expression.split(" ");
		return expressionArray[4];
	}

	public static String getMByCron(String expression) {
		String[] expressionArray = expression.split(" ");
		if (Integer.parseInt(expressionArray[1]) < 10) {
			return '0' + expressionArray[1];
		}
		return expressionArray[1];
	}

	public static String getHByCron(String expression) {
		String[] expressionArray = expression.split(" ");
		if (Integer.parseInt(expressionArray[2]) < 10) {
			return '0' + expressionArray[2];
		}
		return expressionArray[2];
	}

	public static String getYearByCron(String expression) {
		String[] expressionArray = expression.split(" ");
		return expressionArray[6];
	}

	public static String getDesByCron(String expression) {
		CronExpression exp = null;
		try {
			exp = new CronExpression(expression);
		} catch (ParseException e) {
			return "corn表达式不正确";
		}
		String des = "";
		String desHeader = "";
		String type = getTypeByCron(expression);
		String h = getHByCron(expression);
		String m = getMByCron(expression);
		if (type == "* * ?") {
			des = "每日 " + h + ":" + m;
		} else if (type == "? *") {
			des = "每周  ";
			String week = getWeekByCron(expression);
			String[] weekArray = week.split(",");
			for (int i = 0; i < weekArray.length; i++) {
				if ("2".equals(weekArray[i])) {
					des += "周一 ";
				} else if ("3".equals(weekArray[i])) {
					des += "周二 ";
				} else if ("4".equals(weekArray[i])) {
					des += "周三 ";
				} else if ("5".equals(weekArray[i])) {
					des += "周四 ";
				} else if ("6".equals(weekArray[i])) {
					des += "周五 ";
				} else if ("7".equals(weekArray[i])) {
					des += "周六 ";
				} else if ("1".equals(weekArray[i])) {
					des += "周日 ";
				}
			}
			des += h + ":" + m;
		} else if (type == "* ?") {
			des = "每月 ";
			String day = getDayByCron(expression);
			String[] dayArray = day.split(",");
			for (int i = 0; i < dayArray.length; i++) {
				des += dayArray[i];
			}
			des += "日 ";
			// des += dayArray.join("、") + " 日 ";
			des += h + ":" + m;
		} else {
			String year = getYearByCron(expression);
			String day = getDayByCron(expression);
			String month = getMonthByCron(expression);
			des = year + "/" + month + "/" + day + " " + h + ":" + m;
		}
		return des;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String CRON_EXPRESSION = "0 41 13 1 * ?";
		System.out.println(getDesByCron(CRON_EXPRESSION));

	}

}
