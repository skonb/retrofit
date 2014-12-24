package retrofit.http;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static retrofit.mime.MultipartTypedOutput.DEFAULT_TRANSFER_ENCODING;

/**
 * Denotes multiple parts of same name in a multi-part request.
 * <p>
 * Values of the array on which this annotation exists will be processed in one of three ways:
 * <ul>
 * <li>If the type implements {@link retrofit.mime.TypedOutput TypedOutput} the headers and
 * body will be used directly.</li>
 * <li>If the type is {@link String} the value will also be used directly with a {@code text/plain}
 * content type.</li>
 * <li>Other object types will be converted to an appropriate representation by calling {@link
 * retrofit.converter.Converter#toBody(Object)}.</li>
 * </ul>
 * <p>
 * Values may be {@code null} which will omit them from the request body.
 * <p>
 * <pre>
 * &#64;Multipart
 * &#64;POST("/")
 * void example(&#64;PartArray("comments[]") List<String> comments,
 *              &#64;Part("image") TypedFile image,
 *              ...
 * );
 * </pre>
 * <p>
 * Part parameters may not be {@code null}.
 */
@Documented
@Target(PARAMETER)
@Retention(RUNTIME)
public @interface PartArray {
    /** The {@code Content-Transfer-Encoding} of this part. */
    String encoding() default DEFAULT_TRANSFER_ENCODING;
}
