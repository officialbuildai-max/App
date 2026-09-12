package com.cloud.tmc.miniapp.performanceanalyse;

import com.cloud.tmc.kernel.proxy.performanceanalyse.V8AnalyseType;

/* loaded from: classes3.dex */
public final class OooOOO {
    public long OooO00o;

    /* loaded from: classes3.dex */
    public /* synthetic */ class OooO00o {
        public static final /* synthetic */ int[] OooO00o;

        static {
            int[] iArr = new int[V8AnalyseType.values().length];
            try {
                iArr[V8AnalyseType.CHECK_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[V8AnalyseType.CHECK_EXIST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[V8AnalyseType.CHECK_UN_EXIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[V8AnalyseType.DOWNLOAD_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[V8AnalyseType.DOWNLOAD_SUCCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[V8AnalyseType.DOWNLOAD_FAIL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[V8AnalyseType.UNZIP_START.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[V8AnalyseType.UNZIP_SUCCESS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[V8AnalyseType.UNZIP_FAIL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            OooO00o = iArr;
        }
    }

    public OooOOO() {
        V8AnalyseType v8AnalyseType = V8AnalyseType.CHECK_START;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void OooO00o(java.lang.String r7, com.cloud.tmc.kernel.proxy.performanceanalyse.V8AnalyseType r8, java.lang.String r9) {
        /*
            r6 = this;
            java.lang.String r0 = "target"
            kotlin.jvm.internal.Intrinsics.h(r8, r0)
            int[] r0 = com.cloud.tmc.miniapp.performanceanalyse.OooOOO.OooO00o.OooO00o
            int r1 = r8.ordinal()
            r0 = r0[r1]
            r1 = 5
            r2 = 0
            if (r0 == r1) goto L20
            r1 = 8
            if (r0 == r1) goto L18
            r0 = r2
            goto L27
        L18:
            long r0 = java.lang.System.currentTimeMillis()
            long r4 = r6.OooO00o
        L1e:
            long r0 = r0 - r4
            goto L27
        L20:
            long r0 = java.lang.System.currentTimeMillis()
            long r4 = r6.OooO00o
            goto L1e
        L27:
            if (r9 == 0) goto L3b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "-信息:"
            r4.append(r5)
            r4.append(r9)
            java.lang.String r9 = r4.toString()
            goto L3d
        L3b:
            java.lang.String r9 = ""
        L3d:
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L8a
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
            java.lang.Class<com.cloud.tmc.kernel.proxy.performanceanalyse.V8AnalyseType> r3 = com.cloud.tmc.kernel.proxy.performanceanalyse.V8AnalyseType.class
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
            java.lang.String r3 = "v8"
            r0.report(r7, r3, r1)
        L8a:
            if (r7 == 0) goto Lad
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
            goto Lc0
        Lad:
            java.lang.String r7 = r8.getDes()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r9)
            java.lang.String r7 = r0.toString()
        Lc0:
            com.cloud.tmc.kernel.proxy.performanceanalyse.V8AnalyseType r9 = com.cloud.tmc.kernel.proxy.performanceanalyse.V8AnalyseType.DOWNLOAD_FAIL
            r0 = 0
            r1 = 1
            java.lang.String r3 = "TmcPerferenceV8"
            if (r8 == r9) goto Ld4
            com.cloud.tmc.kernel.proxy.performanceanalyse.V8AnalyseType r9 = com.cloud.tmc.kernel.proxy.performanceanalyse.V8AnalyseType.UNZIP_FAIL
            if (r8 != r9) goto Lcd
            goto Ld4
        Lcd:
            if (r2 == 0) goto Ld0
            r0 = r1
        Ld0:
            com.cloud.tmc.kernel.utils.TraceLog.d(r3, r7, r0)
            goto Lda
        Ld4:
            if (r2 == 0) goto Ld7
            r0 = r1
        Ld7:
            com.cloud.tmc.kernel.utils.TraceLog.e(r3, r7, r0)
        Lda:
            com.cloud.tmc.kernel.proxy.performanceanalyse.a.a(r8, r7)
            long r7 = java.lang.System.currentTimeMillis()
            r6.OooO00o = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.performanceanalyse.OooOOO.OooO00o(java.lang.String, com.cloud.tmc.kernel.proxy.performanceanalyse.V8AnalyseType, java.lang.String):void");
    }
}
