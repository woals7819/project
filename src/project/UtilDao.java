package project;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDao {
	public static String getCurrentDate() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy.MM.dd HH:ss");
		Date time = new Date();
		String time1 = date.format(time);

		return time1;
	}

}
