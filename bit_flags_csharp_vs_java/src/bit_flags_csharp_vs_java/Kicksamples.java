package bit_flags_csharp_vs_java;

import java.util.EnumSet;

public class Kicksamples {

	public static void main(String[] args) {

		int reason1 = EKickReason.Inactivity.getFlag() | EKickReason.ToxicBehavior.getFlag();
		
		EnumSet<EKickReason> resons2 = EnumSet.of(EKickReason.Inactivity, EKickReason.ToxicBehavior);
		
		int resons3 = EKickReason.getFlag(resons2);
		
	}

}
