package il.co.xsites.developertest.utils;

public class Utils {

	private Utils() {
		throw new UnsupportedOperationException();
	}

	/**
	 * A generic method that extracts a query string (e.g. fieldName=fieldValue&fieldName2=fieldValue2)
	 * from every field on `source` which is annotated with the given `annotation`.
	 * Should work with any object & any annotation.
	 *
	 * @param source
	 * @param annotation
	 * @return
	 */
	public static String extractQueryString(Object source, Class annotation) {
		return null;
	}
}
