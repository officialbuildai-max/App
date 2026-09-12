package com.transsion.subroom.premium;

/* renamed from: com.transsion.subroom.premium.⁣⁣⁣⁣⁣⁠⁣⁤⁠⁠⁠⁣⁣⁣⁣⁣⁤, reason: contains not printable characters */
/* loaded from: classes7.dex */
public class C0693 {

    /* renamed from: ⁣⁤⁠⁠⁠⁤⁠⁤⁠⁠⁣⁣, reason: not valid java name and contains not printable characters */
    public static boolean f53 = true;

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0033, code lost:
    
        return r3;
     */
    /* renamed from: ⁣⁣⁣⁣⁣⁠⁠⁠⁠⁣⁣⁠, reason: not valid java name and contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int m921() {
        /*
            r1 = 0
            java.lang.String r0 = "۬ۛۤ"
            r2 = r1
            r3 = r1
            r4 = r1
        L6:
            int r0 = com.transsion.subroom.premium.C0677.m901(r0)
            switch(r0) {
                case 1738407: goto L2e;
                case 1743640: goto L26;
                case 1744167: goto L33;
                case 1751547: goto L12;
                case 1754663: goto L20;
                case 1759061: goto L17;
                default: goto Ld;
            }
        Ld:
            r3 = r1 | r2
            java.lang.String r0 = "ۜ۫ۖ"
            goto L6
        L12:
            r1 = r3 & r4
            java.lang.String r0 = "۬ۗۚ"
            goto L6
        L17:
            java.lang.String r0 = "ۚۨۙ"
            int r4 = com.transsion.subroom.premium.C0677.m901(r0)
            java.lang.String r0 = "ۖ۫ۜ"
            goto L6
        L20:
            r3 = 1742091(0x1a950b, float:2.44119E-39)
            java.lang.String r0 = "ۤۡۘ"
            goto L6
        L26:
            r0 = -1742092(0xffffffffffe56af4, float:NaN)
            r2 = r3 & r0
            java.lang.String r0 = "ۧۨۨ"
            goto L6
        L2e:
            r3 = r4 ^ (-1)
            java.lang.String r0 = "ۜۚۖ"
            goto L6
        L33:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.premium.C0693.m921():int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x0036. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000a. Please report as an issue. */
    /* renamed from: ⁣⁣⁣⁣⁣⁠⁣⁤⁣⁠⁣⁤⁠⁠⁠⁠⁣⁣⁣, reason: not valid java name and contains not printable characters */
    public static String m922(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        int i14 = 0;
        while (true) {
            int i15 = 1602766;
            while (true) {
                i15 ^= 1602783;
                switch (i15) {
                    case 17:
                        i15 = i14 < i12 ? 1602859 : 1602828;
                    case 50:
                    case 467:
                        break;
                    case 500:
                        short s11 = sArr[i11 - (0 - i14)];
                        cArr[i14] = (char) ((s11 & (i13 ^ (-1))) | ((s11 ^ (-1)) & i13));
                        i14 = (i14 - 10) + 1 + 10;
                        int i16 = 1602890;
                        while (true) {
                            i16 ^= 1602907;
                            switch (i16) {
                                case 17:
                                    i16 = 1603572;
                                case 687:
                                    break;
                            }
                        }
                        break;
                }
                return new String(cArr);
            }
        }
    }
}
