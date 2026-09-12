package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.integration.proxy.ReportFactoryProxy;

/* loaded from: classes3.dex */
public final class ReportFactory implements ReportFactoryProxy {

    /* loaded from: classes3.dex */
    public enum ReportType {
        ATHENA(0),
        FIREBASE(1);

        private final int type;

        ReportType(int i11) {
            this.type = i11;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // com.cloud.tmc.integration.proxy.ReportFactoryProxy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void report(java.lang.String r3, java.lang.String r4, android.os.Bundle r5, java.lang.Integer r6, java.lang.Integer r7) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L7
            return
        L7:
            if (r6 == 0) goto L36
            com.cloud.tmc.miniapp.defaultimpl.ReportFactory$ReportType r0 = com.cloud.tmc.miniapp.defaultimpl.ReportFactory.ReportType.ATHENA
            int r0 = r0.getType()
            int r1 = r6.intValue()
            if (r1 != r0) goto L16
            goto L36
        L16:
            com.cloud.tmc.miniapp.defaultimpl.ReportFactory$ReportType r0 = com.cloud.tmc.miniapp.defaultimpl.ReportFactory.ReportType.FIREBASE
            int r0 = r0.getType()
            int r1 = r6.intValue()
            if (r1 != r0) goto L2e
            java.lang.Class<com.cloud.tmc.integration.proxy.LauncherReportProxy> r0 = com.cloud.tmc.integration.proxy.LauncherReportProxy.class
            java.lang.Object r0 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r0)
            com.cloud.tmc.integration.proxy.LauncherReportProxy r0 = (com.cloud.tmc.integration.proxy.LauncherReportProxy) r0
            r0.report(r4, r5)
            goto L41
        L2e:
            java.lang.String r0 = "report"
            java.lang.String r1 = "上报类型不支持"
            com.cloud.tmc.kernel.log.TmcLogger.e(r0, r1)
            goto L41
        L36:
            java.lang.Class<com.cloud.tmc.integration.proxy.ReportProxy> r0 = com.cloud.tmc.integration.proxy.ReportProxy.class
            java.lang.Object r0 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r0)
            com.cloud.tmc.integration.proxy.ReportProxy r0 = (com.cloud.tmc.integration.proxy.ReportProxy) r0
            r0.report(r3, r4, r5, r7)
        L41:
            boolean r0 = com.cloud.tmc.kernel.utils.AppDynamicBuildConfig.isAppDebugAble()
            if (r0 == 0) goto L7d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "[埋点上报-"
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = "]: tag: "
            r0.append(r3)
            r0.append(r4)
            java.lang.String r3 = " reportType: "
            r0.append(r3)
            r0.append(r6)
            java.lang.String r3 = " athenaAppId: "
            r0.append(r3)
            r0.append(r7)
            java.lang.String r3 = " reportData: "
            r0.append(r3)
            r0.append(r5)
            java.lang.String r3 = r0.toString()
            com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType r4 = com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType.CONSOLE
            com.cloud.tmc.kernel.proxy.performanceanalyse.a.a(r4, r3)
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.defaultimpl.ReportFactory.report(java.lang.String, java.lang.String, android.os.Bundle, java.lang.Integer, java.lang.Integer):void");
    }
}
