package k5;

import com.cloud.tmc.miniutils.constant.TimeConstants;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f66777a;

    public c(String str, String str2) {
        int parseInt;
        int i11;
        int i12;
        int i13;
        if (str.equalsIgnoreCase("hh:mm:ss,ms")) {
            int parseInt2 = Integer.parseInt(str2.substring(0, 2));
            this.f66777a = Integer.parseInt(str2.substring(9, 12)) + (Integer.parseInt(str2.substring(6, 8)) * 1000) + (Integer.parseInt(str2.substring(3, 5)) * 60000) + (parseInt2 * TimeConstants.HOUR);
            return;
        }
        if (!str.equalsIgnoreCase("h:mm:ss.cs")) {
            if (str.equalsIgnoreCase("h:m:s:f/fps")) {
                String[] split = str2.split("/");
                float parseFloat = Float.parseFloat(split[1]);
                String[] split2 = split[0].split(":");
                int parseInt3 = Integer.parseInt(split2[0]);
                this.f66777a = ((int) ((Integer.parseInt(split2[3]) * 1000) / parseFloat)) + (Integer.parseInt(split2[2]) * 1000) + (Integer.parseInt(split2[1]) * 60000) + (parseInt3 * TimeConstants.HOUR);
                return;
            }
            return;
        }
        String[] split3 = str2.split(":");
        if (split3.length == 4) {
            i12 = Integer.parseInt(split3[0]);
            parseInt = Integer.parseInt(split3[1]);
            i11 = Integer.parseInt(split3[2]);
            i13 = Integer.parseInt(split3[3]);
        } else {
            int parseInt4 = Integer.parseInt(str2.substring(0, 1));
            parseInt = Integer.parseInt(str2.substring(2, 4));
            int parseInt5 = Integer.parseInt(str2.substring(5, 7));
            int parseInt6 = Integer.parseInt(str2.substring(8, 10));
            i11 = parseInt5;
            i12 = parseInt4;
            i13 = parseInt6;
        }
        this.f66777a = (i13 * 10) + (i11 * 1000) + (parseInt * 60000) + (i12 * TimeConstants.HOUR);
    }
}
