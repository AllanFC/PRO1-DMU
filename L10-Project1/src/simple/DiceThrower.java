package simple;

public class DiceThrower {
	// 2 dice with face count of 6 each
	private Die die1, die2;

	// TODO: Add fields.
	// Fields:
	// 1. The roll count.
	private int rollCount;
	// 2. The total of all face values rolled.
	private int totalSum;
	// 3. The count of face value 6.
	private int sixCount;
	// 4. The count of same face value on both dice.
	private int sameValueCount;
	// 5. The maximum sum of the face values in one roll.
	private int maxValueRolled;
	// Remember to update fields, when the dice are rolled.


	/**
	 * Creates a DiceThrower object.
	 */
	// TODO: Make a constructor that initialises all fields.
	public DiceThrower(){
		die1 = new Die();
		die2 = new Die();
		rollCount = 0;
		totalSum = 0;
		sixCount = 0;
		sameValueCount = 0;
		maxValueRolled = 0;
	}
	// TODO: Add get methods for the fields.

	public int getSixCount() {
		return sixCount;
	}

	public int getMaxValueRolled() {
		return maxValueRolled;
	}

	public int getRollCount() {
		return rollCount;
	}

	public int getSameValueCount() {
		return sameValueCount;
	}

	public int getTotalSum() {
		return totalSum;
	}

	/**
	 * Rolls the 2 dice.
	 */
	public void roll() {
		// TODO: Roll the 2 dice.
		die1.roll();
		die2.roll();
		totalSum += sum();
		rollCount += 1;
		if(die1.getFaceValue() == 6 || die2.getFaceValue() == 6) {
			sixCount += 1;
		} else if(die1.getFaceValue() == 6 && die2.getFaceValue() == 6) {
			sixCount += 2;
		}
		if(die1.getFaceValue() == die2.getFaceValue()){
			sameValueCount += 1;
		}
		if(sum() > maxValueRolled) {
			maxValueRolled = sum();
		}

	}

	/**
	 * Returns the sum of the face values in a roll.
	 */
	public int sum() {
		// TODO
		return die1.getFaceValue() + die2.getFaceValue();
	}

	/**
	 * Returns a textual description of the roll of the 2 dice.
	 * Example: Returns "(4,5)" for a roll of 4 and 5.
	 */
	public String rollDescription() {
		// TODO: Use the method: String.format().
		return String.format("(%d, %d)", die1.getFaceValue(), die2.getFaceValue());
	}
}
