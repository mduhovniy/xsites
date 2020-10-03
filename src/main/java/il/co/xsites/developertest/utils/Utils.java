package il.co.xsites.developertest.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Utils {

	private static final Log log = LogFactory.getLog(Utils.class);

	private Utils() {
		throw new UnsupportedOperationException();
	}

	public static void validatePizzaPrices(Double minPrice, Double maxPrice) throws Exception {
		if(minPrice < 0) {
			throw new Exception("Parameter minPrice couldn't be negative");
		}
		if(maxPrice < 0) {
			throw new Exception("Parameter maxPrice couldn't be negative");
		}
		if(maxPrice < minPrice) {
			throw new Exception("Parameter maxPrice couldn't be less than minPrice");
		}
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
	public static String extractQueryString(Object source, Class<? extends Annotation> annotation) {

		StringBuilder queryStringBuilder = new StringBuilder();
		boolean isFirstAnnotatedField = true;

		try {
			for (Field field : source.getClass().getDeclaredFields()) {
				if (field.isAnnotationPresent(annotation)) {
					field.setAccessible(true);
					if (!isFirstAnnotatedField) {
						queryStringBuilder.append("&");
					}
					queryStringBuilder.append(field.getName())
							.append("=")
							.append(field.get(source).toString());
					isFirstAnnotatedField = false;
				}
			}
		} catch (IllegalAccessException e) {
			log.error(e);
		}

		return queryStringBuilder.toString();
	}
}
