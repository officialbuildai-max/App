package dj;

/* loaded from: classes6.dex */
public abstract class a {
    public static String a(long j11) {
        long j12;
        long j13;
        Object valueOf;
        Object valueOf2;
        String str;
        long j14 = j11 / 1000;
        try {
            long j15 = j14 % 3600;
            if (j14 > 3600) {
                j13 = j14 / 3600;
                if (j15 == 0) {
                    j12 = 0;
                    j15 = 0;
                } else if (j15 > 60) {
                    j12 = j15 / 60;
                    j15 = j15 % 60 != 0 ? j15 % 60 : 0L;
                } else {
                    j12 = 0;
                }
            } else {
                j12 = j14 / 60;
                if (j14 % 60 != 0) {
                    j15 = j14 % 60;
                    j13 = 0;
                } else {
                    j13 = 0;
                    j15 = 0;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            if (j13 < 10) {
                valueOf = "0" + j13;
            } else {
                valueOf = Long.valueOf(j13);
            }
            sb2.append(valueOf);
            sb2.append(":");
            String sb3 = sb2.toString();
            StringBuilder sb4 = new StringBuilder();
            if (j12 < 10) {
                valueOf2 = "0" + j12;
            } else {
                valueOf2 = Long.valueOf(j12);
            }
            sb4.append(valueOf2);
            sb4.append(":");
            String sb5 = sb4.toString();
            if (j15 < 10) {
                str = "0" + j15;
            } else {
                str = j15 + "";
            }
            if (j13 == 0) {
                sb3 = "";
            }
            if (j13 == 0 && j12 == 60) {
                sb3 = "01:";
                sb5 = "00:";
            }
            return sb3 + sb5 + str;
        } catch (Exception unused) {
            return "";
        }
    }
}
