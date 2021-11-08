import Media.*;
import Stream.*;
import java.time.LocalDate;

/* *********** Pledge of Honor ************************************************

*

* I hereby certify that I have completed this lab assignment on my own

* without any help from anyone else. I understand that the only sources of authorized

* information in this lab assignment are (1) the course textbook, (2) the

* materials  posted at the course website and (3) any study notes handwritten by myself.

*

* I have not used, accessed or received any information from any other unauthorized

* source in taking this lab assignment. The effort in the assignment thus belongs

* completely to me.

*

*  READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID

*  SIGNATURE:   <Ilham Aydazada, 0074562>

* 

********************************************************************************/

public class Main {

	public static void main(String[] args) {

		StreamingService ss = new StreamingService("Netflix");

		User u1 = new User("Alex");
		User u1Same = new User("Alex");
		User u2 = new User("Bill");
		User u3 = new User("Taylor");

		ss.addUser(u1);
		ss.addUser(u2);
		ss.addUser(u3);
		System.out.println("\nTest with existing user: ");
		ss.addUser(u1Same);

		Film m1 = new Film("The Shining", "drama", "Stanley Kubrick");
		Film m2 = new Film("A Clockwork Orange", "drama", "Stanley Kubrick");
		Film m3 = new Film("Full Metal Jacket", "drama", "Stanley Kubrick");

		Film m4 = new Film("Tenet", "Sci-Fi", "Christopher Nolan");
		Film m5 = new Film("Interstellar", "Sci-Fi", "Christopher Nolan");
		Film m6 = new Film("Inception", "Sci-Fi", "Christopher Nolan");
		Film m7 = new Film("Arrival", "Sci-Fi", "Denis Villeneuve");
		Series s1 = new Series("Succession", "drama", 3, 30);

		ss.addMedia(m1);
		ss.addMedia(m2);
		ss.addMedia(m3);
		ss.addMedia(m4);
		ss.addMedia(m5);
		ss.addMedia(m6);
		ss.addMedia(m7);
		ss.addMedia(s1);

		u1.watch(m1, true);
		u1.watch(m2, true);
		u1.watch(m3, false);
		u1.watch(m4, true);
		u1.watch(m5, false);
		u1.watch(s1, true);

		u2.watch(m1, true);
		u2.watch(m2, true);
		u2.watch(m3, true);
		u2.watch(m5, true);
		u2.watch(m6, true);

		u3.watch(m1, true);
		u3.watch(m2, false);
		u3.watch(m3, false);
		u3.watch(m4, true);
		u3.watch(m5, true);
		u3.watch(m6, true);

		System.out.println("\nTest recommending movie by similar user: ");
		System.out.println(ss.recommendFilmBySimilarUser(u1).getName());

		System.out.println("\nTest recommending movie by genre: ");
		System.out.println(ss.recommendByGenre(u3).getName());

		///////// IN LAB /////////

		User premium1 = new PremiumUser("Chuck", LocalDate.parse("2021-09-03"), 12.5, true);
		User premium2 = new PremiumUser("Wendy", LocalDate.parse("2018-10-03"), 130, false);
		premium1.watch(m1, true);
		premium1.watch(m2, false);
		premium1.watch(m3, false);
		premium1.watch(m4, true);
		premium1.watch(m5, true);
		premium1.watch(m6, true);
		System.out.println("\nTest fee calculation: ");
		System.out.println(((PremiumUser) premium1).calculateTotalFee());
		System.out.println(((PremiumUser) premium2).calculateTotalFee());
		System.out.println("\nTest similarity score calculation: ");
		System.out.println(u1.measureSimilarityWith(premium1));
		System.out.println(premium1.measureSimilarityWith(u1));
		// Same film/series statistics
		System.out.println(premium1.measureSimilarityWith(u3));
		System.out.println(u3.measureSimilarityWith(premium1));

	}
}
