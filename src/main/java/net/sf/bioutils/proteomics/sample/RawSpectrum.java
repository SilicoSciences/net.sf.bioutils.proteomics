package net.sf.bioutils.proteomics.sample;

import java.util.Arrays;

import net.sf.kerner.utils.UtilArray;

public class RawSpectrum implements Comparable<RawSpectrum> {

	public synchronized int getPrecursorChargeState() {
		return precursorChargeState;
	}

	public synchronized void setPrecursorChargeState(int precursorChargeState) {
		this.precursorChargeState = precursorChargeState;
	}

	public synchronized RawSpectrum getPrecursorSpectrum() {
		return precursorSpectrum;
	}

	public synchronized void setPrecursorSpectrum(RawSpectrum precursorSpectrum) {
		this.precursorSpectrum = precursorSpectrum;
	}

	public int getLength() {
		return numbersInt.length;
	}

	private RawSpectrum precursorSpectrum;

	public synchronized double getPrecursorMz() {
		return precursorMz;
	}

	public synchronized void setPrecursorMz(double precursorMz) {
		this.precursorMz = precursorMz;
	}

	public synchronized double getPrecursorInt() {
		return precursorInt;
	}

	public synchronized void setPrecursorInt(double precursorInt) {
		this.precursorInt = precursorInt;
	}

	public synchronized int getMsLevel() {
		return msLevel;
	}

	public synchronized void setMsLevel(int msLevel) {
		this.msLevel = msLevel;
	}

	private double precursorMz;

	private double precursorInt;

	private int precursorChargeState;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + Arrays.hashCode(numbersInt);
		result = prime * result + Arrays.hashCode(numbersMz);
		return result;
	}

	@Override
	public String toString() {
		return "Index:" + getIndex() + ", signals:" + numbersInt.length;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof RawSpectrum)) {
			return false;
		}
		RawSpectrum other = (RawSpectrum) obj;
		if (index != other.index) {
			return false;
		}
		if (!Arrays.equals(numbersInt, other.numbersInt)) {
			return false;
		}
		if (!Arrays.equals(numbersMz, other.numbersMz)) {
			return false;
		}
		return true;
	}

	private final Number[] numbersMz;
	private final Number[] numbersInt;
	private final int index;
	private final String id;

	public RawSpectrum(String id, int index, Number[] numbersMz,
			Number[] numbersInt) {
		super();
		this.id = id;
		this.index = index;
		this.numbersMz = numbersMz;
		this.numbersInt = numbersInt;
		if (numbersInt.length != numbersMz.length) {
			throw new IllegalArgumentException("Array length differs "
					+ numbersInt.length + " " + numbersMz.length);
		}
	}

	public String getId() {
		return id;
	}

	public Number[] getNumbersMz() {
		return numbersMz;
	}

	public Number[] getNumbersInt() {
		return numbersInt;
	}

	public double[] getMz() {
		return UtilArray.toPrimitive(getNumbersMz());
	}

	public double[] getInt() {
		return UtilArray.toPrimitive(getNumbersInt());
	}

	public int getIndex() {
		return index;
	}

	@Override
	public int compareTo(RawSpectrum o) {
		return Integer.valueOf(getIndex()).compareTo(o.getIndex());
	}

	private int msLevel;

}
