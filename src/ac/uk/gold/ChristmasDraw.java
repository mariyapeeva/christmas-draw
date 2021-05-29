/**
 * 
 */
package ac.uk.gold;

/**
 * ChristmasDraw class generates draws of couples to exchange Christmas presents for this and next year.
 * Families are not drawn to buy presents to each other and this year's couples are excluded for next year.
 * 
 * @author mpeev001
 * @version 1.0
 *
 */
public class ChristmasDraw {
	
	// **********************************************
    // Fields
    // **********************************************
	private int numberCouples;
	private int numberMembers;
	private String[] drawingMembers;
	private String[] drawnMembers;
	private String[][] thisYearsDraw;
	private String[][] nextYearsDraw;
	private static int remainingMembers;
	
	/**
	 * @return numberCouples the number of couples
	 */
	public int getNumberCouples() {
		return this.numberCouples;
	}

	/**
	 * @param n the number of couples to set
	 */
	public void setNumberCouples(int n) {
		this.numberCouples = n;
	}
	
	/**
	 * @return numberMembers the number of members
	 */
	public int getNumberMembers() {
		return this.numberMembers;
	}

	/**
	 * @param n the number of members to set 
	 */
	public void setNumberMembers(int n) {
		this.numberMembers = n;
	}

	/**
	 * @return copy of drawingMembers the drawing members 
	 */
	public String[] getDrawingMembers() {
		String[] copy = new String[this.drawingMembers.length];
	    System.arraycopy(this.drawingMembers, 0, copy, 0, copy.length);
	    return copy;
	}

	/**
	 * @param drawing copy of drawingMembers the drawing members to set
	 */
	public void setDrawingMembers(String[] drawing) {
		this.drawingMembers = new String[drawing.length];
		System.arraycopy(drawing, 0, this.drawingMembers, 0, drawing.length);
	}

	/**
	 * @return copy of drawnMembers the drawn members
	 */
	public String[] getDrawnMembers() {
		String[] copy = new String[this.drawnMembers.length];
	    System.arraycopy(this.drawnMembers, 0, copy, 0, copy.length);
	    return copy;
	}

	/**
	 * @param drawn copy of drawnMembers the drawn members to set
	 */
	public void setDrawnMembers(String[] drawn) {
		this.drawnMembers = new String[drawn.length];
		System.arraycopy(drawn, 0, this.drawnMembers, 0, drawn.length);
	}

	/**
	 * @return copy of thisYearsDraw couples in this year's draw
	 */
	public String[][] getThisYearsDraw() {
		int length = this.thisYearsDraw.length;
		String[][] copy = new String[length][this.thisYearsDraw[0].length];
		for(int i = 0; i < length; i++) {
			System.arraycopy(thisYearsDraw[i], 0, copy[i], 0, copy[i].length);
		}
	    return copy;
	}

	/**
	 * @param thisYears copy of thisYearsDraw couples in this year's draw to set
	 */
	public void setThisYearsDraw(String[][] thisYears) {
		int length = thisYears.length;
		this.thisYearsDraw = new String[length][thisYears[0].length];
		for(int i = 0; i < length; i++) {
			System.arraycopy(thisYears[i], 0, this.thisYearsDraw[i], 0, thisYears[i].length);
		}
	}

	/**
	 * @return copy of nextYearsDraw couples in next year's draw
	 */
	public String[][] getNextYearsDraw() {
		int length = this.nextYearsDraw.length;
		String[][] copy = new String[length][this.nextYearsDraw[0].length];
		for(int i = 0; i < length; i++) {
			System.arraycopy(nextYearsDraw[i], 0, copy[i], 0, copy[i].length);
		}
	    return copy;
	}

	/**
	 * @param nextYears copy of nextYearsDraw couples in next year's draw to set
	 */
	public void setNextYearsDraw(String[][] nextYears) {
		int length = nextYears.length;
		this.nextYearsDraw = new String[length][nextYears[0].length];
		for(int i = 0; i < length; i++) {
			System.arraycopy(nextYears[i], 0, this.nextYearsDraw[i], 0, nextYears[i].length);
		}
	}
	
	// **********************************************
    // Constructors
    // **********************************************
	/**
	 * Default constructor creates a new instance of ChristmasDraw for n number of couples
	 * @param n number of couples
	 */
	public ChristmasDraw(int n) {
		this.setNumberCouples(n);
	}
	
	/**
	 * @param args not used
	 */
	public static void main(String[] args) {
		
		ChristmasDraw app = new ChristmasDraw(5); // create a new instance of ChristmasDraw for 5 couples
		
		int numberCouples = app.getNumberCouples(); // set number of couples
		
		app.setNumberMembers(numberCouples*2); // set the number of members
		int numberMembers = app.getNumberMembers(); // get the number of members
		
		app.setDrawingMembers(new String[numberMembers]); // set the array of drawing members
		String[] drawingMembers = app.getDrawingMembers(); // get the array of drawing members
		
		app.setDrawnMembers(new String[numberMembers]); // set the array of drawn members
		String[] drawnMembers = app.getDrawnMembers(); // get the array of drawn members
		
		app.setThisYearsDraw(new String[numberMembers][2]); // set the array with couples for this year's draw
		String[][] thisYearsDraw = app.getThisYearsDraw(); // get the array with couples for this year's draw
		
		app.setNextYearsDraw(new String[numberMembers][2]); // set the array with couples for next year's draw
		String[][] nextYearsDraw = app.getNextYearsDraw(); // get the array with couples for next year's draw
		
		setRemainingMembers(numberMembers); // set the number of remaining members
		int remainingMembers = getRemainingMembers(); // get the number of remaining members
		
		drawThisYear(remainingMembers, numberMembers, drawingMembers, drawnMembers, thisYearsDraw); // draw this year
		drawNextYear(remainingMembers, numberMembers, drawingMembers, drawnMembers, thisYearsDraw, nextYearsDraw); // draw next year
		
		printDrawThisYear(thisYearsDraw); // print this year's draw
		printDrawNextYear(nextYearsDraw); // print next year's draw
		
	}
	
	// **********************************************
    // Public static methods
    // **********************************************

	/** Get the number of remaining members
	 * @return remainingMembers the number of remaining members
	 */
	public static int getRemainingMembers() {
		return remainingMembers;
	}
	/** Set the number of remaining members
	 * @param n the number of remaining members to set
	 */
	public static void setRemainingMembers(int n) {
		remainingMembers = n;
	}
	/**
	 * Builds pools of drawing and drawn members and sets remainingMembers
	 * @param remainingMembers the remaining members
	 * @param numberMembers the number of members
	 * @param drawingMembers the drawing members
	 * @param drawnMembers the drawn members
	 */
	public static void buildPools(int remainingMembers, int numberMembers, String[] drawingMembers, String[] drawnMembers) {
		String x;
		String y;
		for(int i = 0; i < drawingMembers.length; i+=2) { // traverse drawingMembers
			// generate x and y values for each couple
			x = "x"+((int)(i/2) + 1); 
			y = "y"+((int)(i/2) + 1); 
			// add x and y value to drawingMembers
			drawingMembers[i] = x;
			drawingMembers[i+1] = y; 
			// add x and y values to drawnMembers
			drawnMembers[i] = x; 
			drawnMembers[i+1] = y;
		}
		setRemainingMembers(numberMembers); // set or re-set number of remaining members
	}
	/**
	 * Generates a random member from the remaining members
	 * @param remainingMembers the remaining members
	 * @return randomDrawingMember a random member
	 */
	public static int generateRandomMember(int remainingMembers) {
		int randomDrawingMember = (int)(Math.random() * remainingMembers); // generate a random number between 0 and the number of remaining members
		return randomDrawingMember;
	}
	/**
	 * Generates a random member ID to draw next from the pool of remaining members to draw
	 * @param remainingMembers the remaining members
	 * @param drawingMembers the drawing members
	 * @return randomDrawingMemberId a random member ID to draw
	 */
	public static int generateRandomDrawingMemberId(int remainingMembers, String[] drawingMembers) {
		int randomDrawingMemberId = generateRandomMember(remainingMembers); // generate a random number between 0 and the number of remaining members
		int count = 0;
		for(int i = 0; i < drawingMembers.length; i++) { // traverse drawingMembers
			if(drawingMembers[i] != null) { // skip member ID if they the member has already drawn
				if(count == randomDrawingMemberId) { // find the random member ID corresponding to the generated random number 
					randomDrawingMemberId = i; // assign the index of the random member to randomDrawingMemberId
					break;
				}
				count++;
			}
		}
		return randomDrawingMemberId;
	}
	/**
	 * Generates a random member ID to draw next from the pool of remaining members to be drawn
	 * @param remainingMembers the number of remaining members
	 * @param drawnMembers the remaining drawing members
	 * @return randomDrawnMemberId a random member ID to be drawn
	 */
	public static int generateRandomDrawnMemberId(int remainingMembers, String[] drawnMembers) {
		int randomDrawnMemberId = generateRandomMember(remainingMembers); // generate a random number between 0 and the number of remaining members
		int count = 0;
		for(int i = 0; i < drawnMembers.length; i++) { // traverse drawnMembers
			if(drawnMembers[i] != null) { // skip member ID if they the member has already been drawn
				if(count == randomDrawnMemberId) { // find the random member ID corresponding to the generated random number
					randomDrawnMemberId = i; // assign the index of the random member to randomDrawingMemberId
					break;
				}
				count++;
			}
		}
		return randomDrawnMemberId;
	}
	/**
	 * Returns the couple ID of a member
	 * @param memberId the member ID
	 * @return coupleId the couple ID of the member
	 */
	public static int getCoupleId(int memberId) {
		int coupleId = (int)(memberId/2); // calculate couple ID
		return coupleId;
	}
	/**
	 * Returns the drawing member
	 * @param drawingMembers the remaining drawing members
	 * @param memberId the member ID of the drawing member
	 * @return drawingMember the drawing member 
	 */
	public static String getDrawingMember(String[] drawingMembers, int memberId) {
		String drawingMember = drawingMembers[memberId]; // get drawing member
		return drawingMember;
	}
	/**
	 * Returns the drawn member
	 * @param drawnMembers the remaining members to be drawn
	 * @param memberId the member ID of the drawn member
	 * @return drawnMember the drawing member 
	 */
	public static String getDrawnMember(String[] drawnMembers, int memberId) {
		String drawnMember = drawnMembers[memberId]; // get drawn member
		return drawnMember;
	}
	/**
	 * Checks if two member IDs are the same
	 * @param memberId0 first member ID to compare
	 * @param memberId1 second member ID to compare
	 * @return true if the member IDs are the same or false otherwise
	 */
	public static boolean sameMember(int memberId0, int memberId1) {
		if(memberId0 == memberId1) { // compare two memberIds
			return true; // IDs match
		}
		return false; // IDs do not match
	}
	/**
	 * Checks if two couple IDs are the same
	 * @param memberId0 first member ID to compare
	 * @param memberId1 second member ID to compare
	 * @return true if the couple IDs of the two members are the same or false otherwise
	 */
	public static boolean inCouple(int memberId0, int memberId1) {
		int couple0 = getCoupleId(memberId0); // get coupleId
		int couple1 = getCoupleId(memberId1); // get coupleId
		if(couple0 == couple1) { // compare couple IDs
			return true; // IDs match
		}
		return false; // IDs do not match
	}
	/**
	 * Returns couple ID of a member
	 * @param drawingMembers the remaining drawing members
	 * @param memberId the member ID from an unknown couple
	 * @return coupleId the couple ID of the member
	 */
	public static char getCoupleId(String[] drawingMembers, int memberId) {
		char coupleId = drawingMembers[memberId].charAt(1); // extract couple ID
		return coupleId;
	}
	/**
	 * Returns the couple ID of the member that a drawing member has drawn in this year's draw
	 * @param drawingMembers the remaining drawing members
	 * @param drawThisYear the couples drawn this year
	 * @param memberId the member ID of the drawing member
	 * @return coupleId the couple ID of the member that the drawing member has drawn in this year's draw
	 */
	public static char getCoupleIdThisYear(String[] drawingMembers, String[][] drawThisYear, int memberId) {
		char coupleId = 0;
		for(int i = 0; i < drawThisYear.length; i++) { // traverse drawThisYear
			if(drawThisYear[i][0].equals(drawingMembers[memberId])) { // find the drawing member in this year's draw
				coupleId = drawThisYear[i][1].charAt(1); // get the couple ID of the member that the drawing member has drawn
			} 
		}
		return coupleId;
	}
	/**
	 * Returns a couple of drawing and drawn members
	 * @param drawingMembers the remaining drawing members
	 * @param drawnMembers the remaining members to be drawn
	 * @param memberId0 the drawing member ID
	 * @param memberId1 the drawn member ID
	 * @return couple a couple of drawing and drawn members
	 */
	public static String[] getCouple(String[] drawingMembers, String[] drawnMembers, int memberId0, int memberId1) {
		String[] couple = new String[2]; // create a new array
		couple[0] = getDrawingMember(drawingMembers, memberId0); // add the drawing member
		couple[1] = getDrawnMember(drawingMembers, memberId1); // add the drawn member
		return couple;
	}
	/**
	 * Checks whether a member has already drawn a member from a couple in this year's draw
	 * @param drawingMembers the remaining drawing members
	 * @param drawnMembers the remaining members to be drawn
	 * @param draw the year's draw
	 * @param memberId0 the drawing member ID
	 * @param memberId1 the drawn member ID
	 * @return true if member with ID memberId0 has drawn a member from the couple of member with ID memberId1 in the specified draw
	 */
	public static boolean coupleInDraw(String[] drawingMembers, String[] drawnMembers, String[][] draw, int memberId0, int memberId1) {
		Character drawingCoupleThisYear = getCoupleIdThisYear(drawingMembers, draw, memberId0); // get the couple ID of the drawing member has drawn in this year's draw
		Character coupleId = getCoupleId(drawnMembers, memberId1); // get the couple ID of the drawn member
		if(drawingCoupleThisYear.equals(coupleId)) { // compare the couple IDs
			return true; // IDs match
		}
		return false; // IDs do not match
	}
	/**
	 * Generate two random IDs for a drawing member and a drawn member
	 * @param remainingMembers the remaining members
	 * @param drawingMembers the remaining drawing members
	 * @param drawnMembers the remaining members to be drawn
	 * @return randomIds the two generated random IDs
	 */
	public static int[] generateRandomIds(int remainingMembers, String[] drawingMembers, String[] drawnMembers) {
		int[] randomIds = new int[2]; // create a new array
		// generate 2 random IDs
		int randomId0 = generateRandomDrawingMemberId(remainingMembers, drawingMembers);
		int randomId1 = generateRandomDrawnMemberId(remainingMembers, drawnMembers);
		randomIds[0] = randomId0;
		randomIds[1] = randomId1;
		return randomIds;
	}
	/**
	 * Draw once for this year
	 * @param remainingMembers the remaining members
	 * @param numberMembers the number of members
	 * @param drawingMembers the remaining drawing members
	 * @param drawnMembers the remaining members to be drawn
	 * @param thisYearsDraw the couples drawn in this year's draw
	 */
	public static void drawOnceThisYear(int remainingMembers, int numberMembers, String[] drawingMembers, String[] drawnMembers, String[][] thisYearsDraw) {
		buildPools(remainingMembers, numberMembers, drawingMembers, drawnMembers); // build or re-build pools
		int[] randomIds;
		int count;
		for(int i = 0; i < numberMembers; i++) { // repeat for all members
			count = 0;
			do {
				count++;
				randomIds = generateRandomIds(remainingMembers, drawingMembers, drawnMembers); // generate 2 random IDs
			} while(count < 20 && 
				   (sameMember(randomIds[0], randomIds[1]) ||
					inCouple(randomIds[0], randomIds[1]))); // less than 20 times and if the random drawing and drawn members are not the same member or from the same couple
			if(count == 20) {
				break; 
			}
			thisYearsDraw[i][0] = getDrawingMember(drawingMembers, randomIds[0]); // add the drawing member to thisYearsDraw
			thisYearsDraw[i][1] = getDrawnMember(drawnMembers, randomIds[1]); // add the drawn member to thisYearsDraw
			drawingMembers[randomIds[0]] = null; // remove the drawing member from the pool of drawing members
			drawnMembers[randomIds[1]] = null; // remove the drawn member from the pool of drawn members
			setRemainingMembers(remainingMembers--); // reduce the number of remaining members by 1
		}
	}
	/**
	 * Draw once for next year
	 * @param remainingMembers the remaining members
	 * @param numberMembers the remaining members
	 * @param drawingMembers the remaining drawing members
	 * @param drawnMembers the remaining members to be drawn
	 * @param thisYearsDraw the couples drawn in this year's draw
	 * @param nextYearsDraw the couples drawn in next year's draw
	 */
	public static void drawOnceNextYear(int remainingMembers, int numberMembers, String[] drawingMembers, String[] drawnMembers, String[][] thisYearsDraw, String[][] nextYearsDraw) {
		buildPools(remainingMembers, numberMembers, drawingMembers, drawnMembers); // build or re-build pools
		int[] randomIds;
		int count;
		for(int i = 0; i < numberMembers; i++) { // repeat for all members
			count = 0;
			do {
				count++;
				randomIds = generateRandomIds(remainingMembers, drawingMembers, drawnMembers); // generate 2 random IDs 
			} while (count < 20 && 
					(sameMember(randomIds[0], randomIds[1]) ||
					 inCouple(randomIds[0], randomIds[1]) ||
					 coupleInDraw(drawingMembers, drawnMembers, thisYearsDraw, randomIds[0], randomIds[1]))); // less than 20 times and if the random drawing and drawn members are not the same member or from the same couple or the drawing member has drawn a member of the same couple in this year's draw
			if(count == 20) {
				break;
			} 
			nextYearsDraw[i][0] = getDrawingMember(drawingMembers, randomIds[0]); // add the drawing member to nextYearsDraw 
			nextYearsDraw[i][1] = getDrawnMember(drawnMembers, randomIds[1]); // add the drawn member to thisYearsDraw
			drawingMembers[randomIds[0]] = null; // remove the drawing member from the pool of drawing members
			drawnMembers[randomIds[1]] = null; // remove the drawn member from the pool of drawn members
			setRemainingMembers(remainingMembers--); // reduce the number of remaining members by 1
		}
	}
	
	/**
	 * Draw multiple times this year until a valid result is produced
	 * @param remainingMembers the remaining members
	 * @param numberMembers the number of members
	 * @param drawingMembers the remaining drawing members
	 * @param drawnMembers the remaining members to be drawn
	 * @param thisYearsDraw the couples drawn in this year's draw
	 */
	public static void drawThisYear(int remainingMembers, int numberMembers, String[] drawingMembers, String[] drawnMembers, String[][] thisYearsDraw) {
		int drawsThisYear = 0; // set draw counter to 0
		do {
			drawsThisYear++; // increment draw counter
			drawOnceThisYear(remainingMembers, numberMembers, drawingMembers, drawnMembers, thisYearsDraw); // draw once for this year
		} while(drawsThisYear < 20 && thisYearsDraw[thisYearsDraw.length-1][0] == null); // draw again if there are not enough appropriate couples but less than 20 times
	}
	/**
	 * Draw multiple times for next year until a valid result is produced
	 * @param remainingMembers the remaining members
	 * @param numberMembers the number of members
	 * @param drawingMembers the remaining drawing members
	 * @param drawnMembers the remaining members to be drawn
	 * @param thisYearsDraw the couples drawn in this year's draw
	 * @param nextYearsDraw the couples drawn in next year's draw
	 */
	public static void drawNextYear(int remainingMembers, int numberMembers, String[] drawingMembers, String[] drawnMembers, String[][] thisYearsDraw, String[][] nextYearsDraw) {
		int drawsNextYear = 0; // set draw counter to 0
		do {
			drawsNextYear++; // increment draw counter
			drawOnceNextYear(remainingMembers, numberMembers, drawingMembers, drawnMembers, thisYearsDraw, nextYearsDraw); // draw once for next year
		} while(drawsNextYear < 20 && nextYearsDraw[nextYearsDraw.length-1][0] == null); // draw again if there are not enough appropriate couples but less than 20 times
	}
	/**
	 * Print the results of a draw
	 * @param draw the current year's draw
	 * @param message the current year's draw message
	 */
	public static void printDraw(String[][] draw, String message) {
		System.out.println(message); // print this year's draw message
		for(int i = 0; i < draw.length; i++) { // traverse the array of drawn couples
			System.out.println(draw[i][0] + " buys for " + draw[i][1]); // print drawn couples
		}
	}
	/**
	 * Print the results of this year's draw
	 * @param thisYearsDraw the couples drawn in this year's draw
	 */
	public static void printDrawThisYear(String[][] thisYearsDraw) {
		String message = "This Year's Draw:"; // message for this year's draw
		printDraw(thisYearsDraw, message); // print draw
	}
	/**
	 * Print the results of next year's draw
	 * @param nextYearsDraw the couples drawn in next year's draw
	 */
	public static void printDrawNextYear(String[][] nextYearsDraw) {
		String message = "\nNext Year's Draw:"; // message for next year's draw
		printDraw(nextYearsDraw, message); // print draw
	}

}
