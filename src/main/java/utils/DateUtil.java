package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	Date date;
	SimpleDateFormat simpleDateFormat;

	private static DateUtil dateUtil;

	private DateUtil() {
	}

	public static DateUtil getDateUtilObj() {
		if (dateUtil == null)
			dateUtil = new DateUtil();
		return dateUtil;
	}

	public DateUtil setDatePattern(String pattern) {
		this.date = new Date();
		this.simpleDateFormat = new SimpleDateFormat(pattern);
		return this;
	}

	public String getDateInString() {
		return simpleDateFormat.format(date);
	}

}
