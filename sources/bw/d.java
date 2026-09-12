package bw;

/* loaded from: classes6.dex */
public abstract class d {
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a5, code lost:
    
        if (r4.getInteger(r6) == 2) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.view.Window r10, android.content.Context r11) {
        /*
            java.lang.String r0 = "window"
            kotlin.jvm.internal.Intrinsics.h(r10, r0)
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.h(r11, r1)
            r2 = 17170445(0x106000d, float:2.461195E-38)
            r10.setBackgroundDrawableResource(r2)
            kotlin.jvm.internal.Intrinsics.h(r11, r1)
            android.content.res.Resources r2 = r11.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            float r2 = r2.density
            r3 = 1098907648(0x41800000, float:16.0)
            float r2 = r2 * r3
            r4 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r4
            int r2 = (int) r2
            java.lang.Object r0 = r11.getSystemService(r0)
            java.lang.String r5 = "null cannot be cast to non-null type android.view.WindowManager"
            kotlin.jvm.internal.Intrinsics.f(r0, r5)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.util.DisplayMetrics r5 = new android.util.DisplayMetrics
            r5.<init>()
            r0.getRealMetrics(r5)
            int r0 = r5.widthPixels
            r5 = 2
            int r2 = r2 * r5
            int r0 = r0 - r2
            android.view.WindowManager$LayoutParams r2 = r10.getAttributes()
            r2.width = r0
            r0 = -2
            r2.height = r0
            r0 = 81
            r2.gravity = r0
            kotlin.jvm.internal.Intrinsics.h(r11, r1)
            android.content.res.Resources r0 = r11.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            float r0 = r0.density
            r6 = 1105199104(0x41e00000, float:28.0)
            float r0 = r0 * r6
            float r0 = r0 + r4
            int r0 = (int) r0
            kotlin.jvm.internal.Intrinsics.h(r11, r1)
            android.content.res.Resources r6 = r11.getResources()
            java.lang.String r7 = "navigation_bar_height"
            java.lang.String r8 = "dimen"
            java.lang.String r9 = "android"
            int r7 = r6.getIdentifier(r7, r8, r9)
            if (r7 <= 0) goto L77
            int r6 = r6.getDimensionPixelSize(r7)
            goto L78
        L77:
            r6 = 0
        L78:
            if (r6 <= 0) goto L80
            int r6 = r0 - r6
            if (r6 <= 0) goto L80
            r0 = r6
            goto La9
        L80:
            kotlin.jvm.internal.Intrinsics.h(r11, r1)
            android.content.res.Resources r6 = r11.getResources()
            android.util.DisplayMetrics r6 = r6.getDisplayMetrics()
            float r6 = r6.density
            float r6 = r6 * r3
            float r6 = r6 + r4
            int r3 = (int) r6
            kotlin.jvm.internal.Intrinsics.h(r11, r1)
            android.content.res.Resources r4 = r11.getResources()     // Catch: java.lang.Exception -> La8
            java.lang.String r6 = "config_navBarInteractionMode"
            java.lang.String r7 = "integer"
            int r6 = r4.getIdentifier(r6, r7, r9)     // Catch: java.lang.Exception -> La8
            if (r6 <= 0) goto La8
            int r4 = r4.getInteger(r6)     // Catch: java.lang.Exception -> La8
            if (r4 != r5) goto La8
            goto La9
        La8:
            r0 = r3
        La9:
            r2.y = r0
            kotlin.jvm.internal.Intrinsics.h(r11, r1)
            android.content.res.Resources r11 = r11.getResources()
            android.content.res.Configuration r11 = r11.getConfiguration()
            int r11 = r11.uiMode
            r11 = r11 & 48
            r0 = 32
            if (r11 != r0) goto Lc2
            r11 = 1059481190(0x3f266666, float:0.65)
            goto Lc5
        Lc2:
            r11 = 1045220557(0x3e4ccccd, float:0.2)
        Lc5:
            r2.dimAmount = r11
            r10.addFlags(r5)
            r10.setAttributes(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bw.d.a(android.view.Window, android.content.Context):void");
    }
}
