package net.sf.bioutils.proteomics;

import net.sf.kerner.utils.math.DoubleUnit;
import net.sf.kerner.utils.math.PrefixableDouble;

public enum MassUnit implements PrefixableDouble {

	NANODALTON {
		@Override
		protected DoubleUnit getUnit() {
			return DoubleUnit.NANO;
		}

		@Override
		public double convert(double mass, MassUnit unit) {
			return unit.toNanos(mass);
		}
	},
	MICRODALTON {
		@Override
		protected DoubleUnit getUnit() {
			return DoubleUnit.MICRO;
		}

		@Override
		public double convert(double mass, MassUnit unit) {
			return unit.toMicros(mass);
		}
	},
	MILLIDALTON {
		@Override
		protected DoubleUnit getUnit() {
			return DoubleUnit.MILLI;
		}

		@Override
		public double convert(double mass, MassUnit unit) {
			return unit.toMillis(mass);
		}
	},
	DALTON {
		@Override
		protected DoubleUnit getUnit() {
			return DoubleUnit.UNIT;
		}

		@Override
		public double convert(double mass, MassUnit unit) {
			return unit.toUnits(mass);
		}
	},
	KILODALTON {
		@Override
		protected DoubleUnit getUnit() {
			return DoubleUnit.KILO;
		}

		@Override
		public double convert(double mass, MassUnit unit) {
			return unit.toKilos(mass);
		}
	};

	protected DoubleUnit getUnit() {
		throw new AbstractMethodError();
	}

	public double toPicos(double mass) {
		return getUnit().toPicos(mass);
	}

	public double toNanos(double mass) {
		return getUnit().toNanos(mass);
	}

	public double toMicros(double mass) {
		return getUnit().toMicros(mass);
	}

	public double toMillis(double mass) {
		return getUnit().toMillis(mass);
	}

	public double toUnits(double mass) {
		return getUnit().toUnits(mass);
	}

	public double toKilos(double mass) {
		return getUnit().toKilos(mass);
	}

	public double toMegas(double mass) {
		return getUnit().toMegas(mass);
	}

	public double toGigas(double mass) {
		return getUnit().toGigas(mass);
	}

	public double toTeras(double mass) {
		return getUnit().toTeras(mass);
	}

	public double convert(double mass, MassUnit unit) {
		throw new AbstractMethodError();
	}

}
