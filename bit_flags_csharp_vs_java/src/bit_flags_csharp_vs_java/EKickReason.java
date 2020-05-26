package bit_flags_csharp_vs_java;

import java.util.EnumSet;

public enum EKickReason {

	Inactivity(1),
	ToxicBehavior(2),
	AbusiveChat(4),
	Cheating(8);
	
	private int flag;
	
	public static final EnumSet<EKickReason> All = EnumSet.allOf(EKickReason.class);
	
	EKickReason(int flag) {
		this.flag = flag;
	}

	public boolean is(int value) {
		return (value & getFlag()) == getFlag();
	}
	
	public int getFlag() {
		return flag;
	}
	
	public static int getFlag(EnumSet<EKickReason> values) {
		int result = 0;
		
		for (EKickReason value : values) {
			result = result | value.getFlag();
		}
		
		return result;
	}
}
