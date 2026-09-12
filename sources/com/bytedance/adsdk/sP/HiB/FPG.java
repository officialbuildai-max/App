package com.bytedance.adsdk.sP.HiB;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class FPG {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0066 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0070 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0075 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0062 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.bytedance.adsdk.sP.TKC.sP.Zq Sj(android.util.JsonReader r11, com.bytedance.adsdk.sP.Jcg r12) throws java.io.IOException {
        /*
            r0 = 0
            r1 = 0
            r2 = 1
            r4 = r0
            r7 = r4
            r5 = r1
            r9 = r5
            r3 = r2
        L8:
            boolean r6 = r11.hasNext()
            if (r6 == 0) goto L84
            java.lang.String r6 = r11.nextName()
            r6.hashCode()
            r8 = -1
            int r10 = r6.hashCode()
            switch(r10) {
                case -396065730: goto L55;
                case 99: goto L4a;
                case 111: goto L3f;
                case 114: goto L34;
                case 3324: goto L29;
                case 3519: goto L1e;
                default: goto L1d;
            }
        L1d:
            goto L5f
        L1e:
            java.lang.String r10 = "nm"
            boolean r6 = r6.equals(r10)
            if (r6 != 0) goto L27
            goto L5f
        L27:
            r8 = 5
            goto L5f
        L29:
            java.lang.String r10 = "hd"
            boolean r6 = r6.equals(r10)
            if (r6 != 0) goto L32
            goto L5f
        L32:
            r8 = 4
            goto L5f
        L34:
            java.lang.String r10 = "r"
            boolean r6 = r6.equals(r10)
            if (r6 != 0) goto L3d
            goto L5f
        L3d:
            r8 = 3
            goto L5f
        L3f:
            java.lang.String r10 = "o"
            boolean r6 = r6.equals(r10)
            if (r6 != 0) goto L48
            goto L5f
        L48:
            r8 = 2
            goto L5f
        L4a:
            java.lang.String r10 = "c"
            boolean r6 = r6.equals(r10)
            if (r6 != 0) goto L53
            goto L5f
        L53:
            r8 = r2
            goto L5f
        L55:
            java.lang.String r10 = "fillEnabled"
            boolean r6 = r6.equals(r10)
            if (r6 != 0) goto L5e
            goto L5f
        L5e:
            r8 = r1
        L5f:
            switch(r8) {
                case 0: goto L7f;
                case 1: goto L7a;
                case 2: goto L75;
                case 3: goto L70;
                case 4: goto L6b;
                case 5: goto L66;
                default: goto L62;
            }
        L62:
            r11.skipValue()
            goto L8
        L66:
            java.lang.String r4 = r11.nextString()
            goto L8
        L6b:
            boolean r9 = r11.nextBoolean()
            goto L8
        L70:
            int r3 = r11.nextInt()
            goto L8
        L75:
            com.bytedance.adsdk.sP.TKC.Sj.EjP r0 = com.bytedance.adsdk.sP.HiB.EjP.sP(r11, r12)
            goto L8
        L7a:
            com.bytedance.adsdk.sP.TKC.Sj.Sj r7 = com.bytedance.adsdk.sP.HiB.EjP.Jcg(r11, r12)
            goto L8
        L7f:
            boolean r5 = r11.nextBoolean()
            goto L8
        L84:
            if (r0 != 0) goto L9a
            com.bytedance.adsdk.sP.TKC.Sj.EjP r0 = new com.bytedance.adsdk.sP.TKC.Sj.EjP
            com.bytedance.adsdk.sP.Jcg.Sj r11 = new com.bytedance.adsdk.sP.Jcg.Sj
            r12 = 100
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            r11.<init>(r12)
            java.util.List r11 = java.util.Collections.singletonList(r11)
            r0.<init>(r11)
        L9a:
            r8 = r0
            if (r3 != r2) goto La1
            android.graphics.Path$FillType r11 = android.graphics.Path.FillType.WINDING
        L9f:
            r6 = r11
            goto La4
        La1:
            android.graphics.Path$FillType r11 = android.graphics.Path.FillType.EVEN_ODD
            goto L9f
        La4:
            com.bytedance.adsdk.sP.TKC.sP.Zq r11 = new com.bytedance.adsdk.sP.TKC.sP.Zq
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.sP.HiB.FPG.Sj(android.util.JsonReader, com.bytedance.adsdk.sP.Jcg):com.bytedance.adsdk.sP.TKC.sP.Zq");
    }
}
