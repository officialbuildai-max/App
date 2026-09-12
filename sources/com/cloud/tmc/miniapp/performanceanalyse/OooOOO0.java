package com.cloud.tmc.miniapp.performanceanalyse;

import com.cloud.tmc.kernel.proxy.performanceanalyse.RenderAnalyseType;

/* loaded from: classes3.dex */
public final class OooOOO0 {
    public long OooO00o;

    /* loaded from: classes3.dex */
    public /* synthetic */ class OooO00o {
        public static final /* synthetic */ int[] OooO00o;

        static {
            int[] iArr = new int[RenderAnalyseType.values().length];
            try {
                iArr[RenderAnalyseType.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RenderAnalyseType.CREATE_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RenderAnalyseType.CREATE_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RenderAnalyseType.LOAD_URL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RenderAnalyseType.LOAD_FINISH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RenderAnalyseType.LOAD_FAIL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[RenderAnalyseType.ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[RenderAnalyseType.CONSOLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            OooO00o = iArr;
        }
    }

    public OooOOO0() {
        RenderAnalyseType renderAnalyseType = RenderAnalyseType.INIT;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void OooO00o(java.lang.String r7, com.cloud.tmc.kernel.proxy.performanceanalyse.RenderAnalyseType r8, java.lang.String r9) {
        /*
            r6 = this;
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.h(r8, r0)
            int[] r0 = com.cloud.tmc.miniapp.performanceanalyse.OooOOO0.OooO00o.OooO00o
            int r1 = r8.ordinal()
            r0 = r0[r1]
            r1 = 3
            r2 = 0
            if (r0 == r1) goto L1f
            r1 = 5
            if (r0 == r1) goto L17
            r0 = r2
            goto L26
        L17:
            long r0 = java.lang.System.currentTimeMillis()
            long r4 = r6.OooO00o
        L1d:
            long r0 = r0 - r4
            goto L26
        L1f:
            long r0 = java.lang.System.currentTimeMillis()
            long r4 = r6.OooO00o
            goto L1d
        L26:
            if (r9 == 0) goto L3a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "-信息:"
            r4.append(r5)
            r4.append(r9)
            java.lang.String r9 = r4.toString()
            goto L3c
        L3a:
            java.lang.String r9 = ""
        L3c:
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L89
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "-耗时:"
            r3.append(r4)
            r3.append(r0)
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            java.lang.Class<com.cloud.tmc.integration.proxy.ReportProxy> r0 = com.cloud.tmc.integration.proxy.ReportProxy.class
            java.lang.Object r0 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r0)
            com.cloud.tmc.integration.proxy.ReportProxy r0 = (com.cloud.tmc.integration.proxy.ReportProxy) r0
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.lang.Class<com.cloud.tmc.kernel.proxy.performanceanalyse.RenderAnalyseType> r3 = com.cloud.tmc.kernel.proxy.performanceanalyse.RenderAnalyseType.class
            java.lang.String r3 = r3.getSimpleName()
            java.lang.String r4 = r8.name()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            java.lang.String r3 = "."
            r5.append(r3)
            r5.append(r4)
            java.lang.String r3 = r5.toString()
            r1.putString(r3, r9)
            kotlin.Unit r3 = kotlin.Unit.f67184a
            java.lang.String r3 = "render"
            r0.report(r7, r3, r1)
        L89:
            if (r7 == 0) goto Lac
            java.lang.String r0 = r8.getDes()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "["
            r1.append(r3)
            r1.append(r7)
            java.lang.String r7 = "]:"
            r1.append(r7)
            r1.append(r0)
            r1.append(r9)
            java.lang.String r7 = r1.toString()
            goto Lbf
        Lac:
            java.lang.String r7 = r8.getDes()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r9)
            java.lang.String r7 = r0.toString()
        Lbf:
            com.cloud.tmc.kernel.proxy.performanceanalyse.RenderAnalyseType r9 = com.cloud.tmc.kernel.proxy.performanceanalyse.RenderAnalyseType.ERROR
            r0 = 0
            r1 = 1
            java.lang.String r3 = "TmcPerferenceRender"
            if (r8 != r9) goto Lce
            if (r2 == 0) goto Lca
            r0 = r1
        Lca:
            com.cloud.tmc.kernel.utils.TraceLog.e(r3, r7, r0)
            goto Ld4
        Lce:
            if (r2 == 0) goto Ld1
            r0 = r1
        Ld1:
            com.cloud.tmc.kernel.utils.TraceLog.d(r3, r7, r0)
        Ld4:
            com.cloud.tmc.kernel.proxy.performanceanalyse.a.a(r8, r7)
            long r7 = java.lang.System.currentTimeMillis()
            r6.OooO00o = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.performanceanalyse.OooOOO0.OooO00o(java.lang.String, com.cloud.tmc.kernel.proxy.performanceanalyse.RenderAnalyseType, java.lang.String):void");
    }
}
