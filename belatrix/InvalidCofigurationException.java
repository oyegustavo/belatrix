package belatrix;

public class InvalidCofigurationException extends Exception{
	/**
	 * InvalidCofigurationException
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCofigurationException(String errorMessage) {
        super(errorMessage);
    }
}
