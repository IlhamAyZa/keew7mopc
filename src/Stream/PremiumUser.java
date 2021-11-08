package Stream;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import Media.*;

public class PremiumUser extends User {
	
	private LocalDate startDate;
	private double fee;
	private boolean monthly; //indicates if subscription is monthly or yearly
	
	public PremiumUser(String username, LocalDate startDate, double fee, boolean monthly) {
		super(username);
		this.startDate = startDate;
		this.fee = fee;
		this.monthly = monthly;
	}
	
	public double calculateTotalFee() {
		LocalDate today = LocalDate.now();

		//System.out.println(today.compareTo(startDate));

		if (monthly) {
			return ChronoUnit.MONTHS.between(startDate, today) * fee;
		} else {
			return ChronoUnit.YEARS.between(startDate, today) * fee;
		}
	}
	
	public double measureSimilarityWith(User u) {
		ArrayList<Media> bothWatched = new ArrayList<>();
		for (Media m : u.getWatched()) {
			if(super.getWatched().contains(m)) {
				bothWatched.add(m);
			}
		}
		
		//number of films/series both u1 and u2 liked
		int a = 0;
		//number of films/series u1 liked and u2 did not
		int b = 0;
		//number of films/series u1 did not like and u2 liked
		int c = 0;
		
		for (Media m : bothWatched) {
			if (u.getLiked().contains(m)) {
				a++;
				b++;
			}
			else {
				c++;
			}
			
			if(super.getLiked().contains(m)) {
				a++;
				c++;
			}
			else {
				b++;
			}
		}
		
		return a / (a+b+c);	
	}
}
