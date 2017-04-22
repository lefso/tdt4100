package encapsulation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Person {

	private String name, email;
	private Date birthday;
	private char gender;
	private String ssn;

	public void setName(String name) {
		String[] nameList = name.split(" ");
		
		for (int i = 0; i < name.length(); i++) {
			if (!Character.isAlphabetic(name.charAt(i)) && name.charAt(i) != ' ') {
				throw new IllegalArgumentException();
			}
		}
		
		if (nameList.length != 2) {
			throw new IllegalArgumentException();
		}
		
		if (nameList[0].length() < 2 || nameList[1].length() < 2) {
			throw new IllegalArgumentException();
		}
		
		this.name = name;
	}

	public void setEmail(String email) {
		String[] countryCodes = {"ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi",
				"bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu",
				"cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", 
				"ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", 
				"io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls",
				"lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz",
				"na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py",
				"qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz",
				"tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi",
				"vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};
		
		if (email == null) {
			this.email = email;
			return;
		}
		
		
		if (!email.startsWith(name.split(" ")[0].toLowerCase() + "." + name.split(" ")[1].toLowerCase())) {
			throw new IllegalArgumentException();
		}
		
		boolean correctCode = false;
		for (String code : countryCodes) {
			if (email.endsWith("." + code)) {
				correctCode = true;
			}
		}
		if (correctCode == false) {
			throw new IllegalArgumentException();
		}
		
		if (!email.contains(name.split(" ")[1].toLowerCase() + "@")) {
			throw new IllegalArgumentException();
		}
		
		
		this.email = email;
	}

	public void setBirthday(Date birthday) {
		Date timeNow = new Date();
		
		if (birthday.after(timeNow)) {
			throw new IllegalArgumentException();
		}
		this.birthday = birthday;
	}

	public void setGender(char gender) {
		if (gender != 'M' && gender != 'F' && gender != '\0') {
			throw new IllegalArgumentException();
		}
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public char getGender() {
		return gender;
	}

	public String getSSN() {
		return ssn;
	}
	
	public Calendar toCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public void setSSN(String ssn) {
		if (birthday == null || gender == '\0') {
			throw new IllegalArgumentException();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.getBirthday());
		
		SimpleDateFormat ddmmyy = new SimpleDateFormat("ddMMyy");
		
		String formattedDate = ddmmyy.format(cal.getTime());
		System.out.println(formattedDate);
		
		if (!formattedDate.equals(ssn.substring(0, 6))) {
			throw new IllegalArgumentException();
		}
		
		if (this.getGender() == 'M' && ssn.charAt(8) % 2 == 0) {
			System.out.println(ssn.charAt(8) % 2 != 0);
			throw new IllegalArgumentException();
		} else if (this.getGender() == 'F' && ssn.charAt(8) % 2 != 0) {
			throw new IllegalArgumentException();
		}
		
		int[] fNumbers = {3, 7, 6, 1, 8, 9, 4, 5, 2};
		int[] gNumbers = {5, 4, 3, 2, 7, 6, 5, 4, 3, 2};
		int vsK1 = 0;
		int vsK2 = 0;
		
		for (int i = 0; i < fNumbers.length; i++) {
			vsK1 += (int) (ssn.charAt(i) - 48) * fNumbers[i];
		}
		vsK2 = vsK1;
		vsK2 += (int) (ssn.charAt(ssn.length() - 2) - 48) * gNumbers[9];
		
		if ((int) (ssn.charAt(ssn.length() - 2) - 48) != 11 - (vsK1 % 11) ||
				(int) (ssn.charAt(ssn.length() - 1) - 48) != 11 - (vsK2 % 11)) {
			throw new IllegalArgumentException();
		}
		
		this.ssn = ssn;
	}
}
