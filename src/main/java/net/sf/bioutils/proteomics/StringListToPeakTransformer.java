package net.sf.bioutils.proteomics;

import java.util.List;

import net.sf.kerner.utils.transformer.Transformer;

/**
 * 
 * {@link Transformer} to parse a {@link Peak} from a {@link List} of Strings.
 * 
 * <p>
 * <b>Example:</b><br>
 * 
 * </p>
 * <p>
 * 
 * <pre>
 * TODO example
 * </pre>
 * 
 * </p>
 * 
 * @author <a href="mailto:alex.kerner.24@googlemail.com">Alexander Kerner</a>
 * @version 2011-0-08
 * 
 * @see Transformer
 * @see Peak
 * 
 * @param <P> type of {@link Peak}
 */
public interface StringListToPeakTransformer<P extends Peak> extends
		Transformer<List<? extends String>, P> {

	/**
	 * @return newly parsed {@code Peak} or null, if parsing failed
	 */
	public P transform(List<? extends String> element);

}
