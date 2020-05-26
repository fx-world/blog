package bit_flags_csharp_vs_java;

import java.util.EnumSet;

public interface IFlags {

	public int getFlag();
	
	public default boolean is(int value) {
		return (value & getFlag()) == getFlag();
	}
	
	public static int getFlag(EnumSet<? extends IFlags> values) {
		int result = 0;
		
		for (IFlags value : values) {
			result = result | value.getFlag();
		}
		
		return result;
	}
}
