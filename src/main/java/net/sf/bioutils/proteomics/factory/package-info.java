/**
 * This package contains factory interfaces to build instances of:
 * <ul>
 * <li>{@link Sample}</li>
 * <li>{@link Fraction}</li>
 * <li>{@link Peak}</li>
 * <li>{@link Standard}</li>
 * </ul>
 * </p>
 * Building a sample should be performed in the following order:
 * <ol>
 * <li>
 * Building a sample using {@link FactorySample}. Sample name could be for example directory name which contains peak files.
 * </li>
 * <li>
 * Building fractions using {@link FactoryFraction}, providing previously build sample as parameter.
 * </li>
 * <li>
 * Building peaks using {@link FactoryPeak}, providing previously build fraction as parameter.
 * </li>
 * </ol>
 * In order to prevent NPEs, enforcing this strategy may be helpful.
 * This can easily be achieved by using implementations for {@link Fraction} which require a non-{@code null} {@link Sample} as constructor argument
 * and implementations for {@link Peak} which require a non-{@code null} {@link Fraction} as constructor argument.
 * 
 * @see net.sf.kerner.utils.Factory
 * @see Sample
 * @see Fraction
 * @see Peak
 * @see Standard
 */
package net.sf.bioutils.proteomics.factory;

