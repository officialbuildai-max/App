package com.transsion.subroom.activity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.C0078;
import androidx.core.C0079;
import androidx.core.appcompat.C0066;
import androidx.view.LifecycleCoroutineScope;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.home.viewmodel.TrendingUGCViewModel;
import com.transsion.home.viewmodel.preload.PreloadTrendingData;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.startup.pref.consume.AppStartReport;
import com.transsion.subroom.premium.C0669;
import com.transsion.subroom.premium.C0670;
import com.transsion.subroom.premium.C0672;
import com.transsion.subroom.premium.C0673;
import com.transsion.subroom.premium.C0675;
import com.transsion.subroom.premium.C0676;
import com.transsion.subroom.premium.C0678;
import com.transsion.subroom.premium.C0684;
import com.transsion.subroom.premium.C0686;
import com.transsion.subroom.premium.C0688;
import com.transsion.subroom.premium.C0689;
import com.transsion.subroom.premium.C0690;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import gt.md.C0799;
import java.io.PrintStream;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J!\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u0019\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0019\u0010\u0011J\u000f\u0010\u001a\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001b\u0010\u0003J\u000f\u0010\u001c\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001c\u0010\u0003R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\nR\u0016\u0010*\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\nR\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/transsion/subroom/activity/SplashActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "", "d0", "", "state", "Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;", "maxEcpmObject", "Z", "(Ljava/lang/String;Lcom/transsion/ad/bidding/base/BiddingIntermediateMaterialBean;)V", "c0", "X", "", "isSplashAdLoaded", "e0", "(Z)V", "setStatusBar", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "hasFocus", "onWindowFocusChanged", "onResume", "onPause", "onDestroy", "Lcom/transsion/ad/bidding/splash/b;", "a", "Lcom/transsion/ad/bidding/splash/b;", "splashManager", "Landroid/os/Handler;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lkotlin/Lazy;", "Y", "()Landroid/os/Handler;", "mHandler", "c", "isBackups", "d", "isAdLoadStarted", "", "e", "J", "startTime", "f", "app_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SuppressLint({"CustomSplashScreen"})
/* loaded from: classes7.dex */
public final class SplashActivity extends AppCompatActivity {

    /* renamed from: short, reason: not valid java name */
    private static final short[] f48short;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.transsion.ad.bidding.splash.b splashManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy mHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isBackups;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isAdLoadStarted;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long startTime;

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003a, code lost:
    
        return;
     */
    static {
        /*
            java.lang.String r0 = "ۣ۟ۨ"
        L2:
            int r1 = gt.md.C0799.m1158(r0)
            r2 = 1751585(0x1aba21, float:2.454493E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 253: goto Le;
                case 3117: goto L1a;
                case 7640: goto L3a;
                case 31718: goto L26;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            int r0 = androidx.core.C0079.m394()
            if (r0 < 0) goto L37
            com.transsion.subroom.activity.C0667.m874()
            java.lang.String r0 = "ۨۨۧ"
            goto L2
        L1a:
            r0 = 288(0x120, float:4.04E-43)
            short[] r0 = new short[r0]
            r0 = {x004e: FILL_ARRAY_DATA , data: [1889, 1904, 1904, 1887, 1891, 1903, 1902, 1894, 1897, 1895, 1887, 1894, 1893, 1908, 1891, 1896, 1887, 1908, 1897, 1901, 1893, 2731, 2734, 2709, 2744, 2735, 2724, 2734, 2735, 2744, 2723, 2724, 2733, 3255, 3249, 3239, 3239, 3233, 3255, 3255, 684, 689, 693, 701, 647, 695, 685, 684, 23172, 22987, 23547, 20942, 22308, -29959, -30719, 24690, 2161, 2162, 2158, 2147, 2161, 2154, 2141, 2145, 2157, 2156, 2148, 2155, 2149, 1100, 1106, 1103, 1107, 1108, 1102, 1103, 1124, 1114, 1119, 1099, 1102, 1141, 1103, 1092, 1102, 297, 308, 304, 312, 258, 306, 296, 297, 2091, 2089, 2104, 2061, 2108, 2108, 2080, 2085, 2095, 2093, 2104, 2085, 2083, 2082, 2148, 2146, 2146, 2146, 2149, 860, 838, 870, 837, 857, 852, 838, 861, 884, 849, 889, 858, 852, 849, 848, 849, 1224, 1227, 1239, 1242, 1224, 1235, 1252, 1224, 1231, 1242, 1225, 1231, 2258, 2257, 2253, 2240, 2258, 2249, 2302, 2258, 2242, 2259, 2244, 2244, 2255, 1360, 1348, 1369, 1371, 2280, 2281, 2281, 2300, 2272, 2277, 2274, 2279, 2603, 2568, 2580, 2585, 2571, 2576, 2617, 2587, 2572, 2577, 2574, 2577, 2572, 2561, 3047, 3048, 3055, 3048, 3058, 3049, 2977, 3047, 3059, 3054, 3052, 2977, 3029, 3040, 3058, 3050, 3027, 3054, 3054, 3061, 410, 405, 398, 399, 392, 419, 399, 392, 413, 398, 392, 419, 402, 403, 392, 419, 399, 404, 403, 395, 419, 415, 403, 400, 408, 419, 413, 408, 1079, 1071, 1069, 1076, 2138, 2143, 2148, 2135, 2132, 2138, 2143, 2130, 2133, 2140, 3264, 3267, 3295, 3282, 3264, 3291, 3308, 3282, 3287, 3308, 3295, 3292, 3282, 3287, 3308, 3281, 3286, 3284, 3290, 3293, 1682, 1726, 1725, 1717, 1666, 1701, 1712, 1699, 1701, 1666, 1714, 1716, 1727, 1716, 1152, 1155, 1183, 1170, 1152, 1179, 1196, 1153, 1174, 1152, 1158, 1182, 1174} // fill-array
            com.transsion.subroom.activity.SplashActivity.f48short = r0
            java.lang.String r0 = "ۦۣۤ"
            goto L2
        L26:
            com.transsion.subroom.activity.SplashActivity$a r1 = new com.transsion.subroom.activity.SplashActivity$a
            r2 = 0
            r1.<init>(r2)
            com.transsion.subroom.activity.SplashActivity.INSTANCE = r1
            int r1 = androidx.core.C0078.m391()
            if (r1 >= 0) goto L2
            java.lang.String r0 = "۟ۧۡ"
            goto L2
        L37:
            java.lang.String r0 = "ۣ۟ۨ"
            goto L2
        L3a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.SplashActivity.<clinit>():void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0013. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00a4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SplashActivity() {
        /*
            r9 = this;
            r8 = 0
            r7 = 1
            r6 = 0
            r9.<init>()
            r2 = 0
            java.lang.String r0 = "ۢۧ۟"
            r1 = r0
        Lb:
            int r0 = gt.md.C0799.m1158(r1)
            r4 = 1751647(0x1aba5f, float:2.45458E-39)
            r0 = r0 ^ r4
            switch(r0) {
                case 1976: goto L17;
                case 2405: goto L3c;
                case 3097: goto L5e;
                case 3292: goto La9;
                case 4418: goto Lb4;
                case 7488: goto L78;
                case 30745: goto L21;
                default: goto L16;
            }
        L16:
            goto Lb
        L17:
            int r0 = androidx.core.C0078.m391()
            if (r0 < 0) goto La4
            androidx.core.C0079.m394()
            goto Lb
        L21:
            r0 = 96887(0x17a77, float:1.35768E-40)
            java.lang.Object[] r4 = new java.lang.Object[r6]
            java.lang.Object r0 = com.transsion.subroom.premium.C0678.n(r0, r8, r4)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r0 > 0) goto L17
            int r0 = androidx.core.appcompat.C0066.m207()
            if (r0 != 0) goto Lb
            java.lang.String r0 = "۟۠۠"
            r1 = r0
            goto Lb
        L3c:
            r0 = 97982(0x17ebe, float:1.37302E-40)
            java.lang.Object[] r1 = new java.lang.Object[r7]
            com.transsion.subroom.activity.k0 r4 = new com.transsion.subroom.activity.k0
            r4.<init>()
            r1[r6] = r4
            java.lang.Object r0 = com.transsion.subroom.premium.C0675.n(r0, r8, r1)
            kotlin.Lazy r0 = (kotlin.Lazy) r0
            r9.mHandler = r0
            int r0 = androidx.core.C0079.m394()
            if (r0 < 0) goto L5a
            java.lang.String r0 = "ۨۤۥ"
            r1 = r0
            goto Lb
        L5a:
            java.lang.String r0 = "ۦۧۧ"
            r1 = r0
            goto Lb
        L5e:
            r1 = 15189(0x3b55, float:2.1284E-41)
            r0 = 82094(0x140ae, float:1.15038E-40)
            java.lang.Object r0 = com.transsion.subroom.premium.C0678.n(r0)
            java.io.PrintStream r0 = (java.io.PrintStream) r0
            java.lang.Object[] r4 = new java.lang.Object[r7]
            java.lang.Double r5 = java.lang.Double.valueOf(r2)
            r4[r6] = r5
            com.transsion.subroom.premium.C0684.n(r1, r0, r4)
            java.lang.String r0 = "۠ۢ۟"
            r1 = r0
            goto Lb
        L78:
            r1 = 99156(0x18354, float:1.38947E-40)
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r3 = 35573(0x8af5, float:4.9848E-41)
            java.lang.Object[] r4 = new java.lang.Object[r7]
            r0 = 56525(0xdccd, float:7.9208E-41)
            java.lang.Object r0 = com.transsion.subroom.premium.C0673.n(r0)
            java.lang.String r0 = (java.lang.String) r0
            r4[r6] = r0
            java.lang.Object r0 = com.transsion.subroom.premium.C0680.n(r3, r8, r4)
            java.lang.String r0 = (java.lang.String) r0
            r2[r6] = r0
            java.lang.Object r0 = com.transsion.subroom.premium.C0684.n(r1, r8, r2)
            java.lang.Double r0 = (java.lang.Double) r0
            double r2 = r0.doubleValue()
            java.lang.String r0 = "ۣۡۤ"
            r1 = r0
            goto Lb
        La4:
            java.lang.String r0 = "۠ۢ۟"
            r1 = r0
            goto Lb
        La9:
            int r0 = androidx.core.appcompat.C0066.m207()
            if (r0 != 0) goto Lb
            java.lang.String r0 = "ۢۧ۟"
            r1 = r0
            goto Lb
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.SplashActivity.<init>():void");
    }

    public static /* synthetic */ Handler R() {
        return (Handler) C0673.n(49242, null, new Object[0]);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
    public static /* synthetic */ void T(SplashActivity splashActivity) {
        String str = "۟ۨ۠";
        Double d11 = null;
        while (true) {
            switch (C0799.m1158((Object) str) ^ 1752460) {
                case 74:
                    if (C0079.m394() >= 0) {
                        C0066.m207();
                        str = "۠ۥۢ";
                    } else {
                        str = "۟ۨ۠";
                    }
                case 5531:
                    C0673.n(57342, null, new Object[]{splashActivity});
                    if (C0079.m394() < 0) {
                        str = "ۧۧۡ";
                    }
                case 5957:
                    Double d12 = (Double) C0678.n(68544, null, new Object[]{(String) C0678.n(6352, null, new Object[]{(String) C0673.n(14820)})});
                    if (C0078.m391() >= 0) {
                        C0066.m207();
                        d11 = d12;
                        str = "۟ۦ";
                    } else {
                        d11 = d12;
                        str = "ۤۡ";
                    }
                case 6768:
                case 31629:
                    str = ((Integer) C0678.n(46727, null, new Object[0])).intValue() >= 0 ? "۠۟ۨ" : "ۦۨۨ";
                case 32746:
                    break;
                case 1729009:
                    C0678.n(5185, (PrintStream) C0678.n(82094), new Object[]{d11});
                    if (C0799.m1162() <= 0) {
                        C0799.m1162();
                        str = "ۣۤۥ";
                    } else {
                        str = "ۦۨۨ";
                    }
            }
            return;
        }
    }

    public static final /* synthetic */ com.transsion.ad.bidding.splash.b U(SplashActivity splashActivity) {
        return (com.transsion.ad.bidding.splash.b) C0673.n(19634, splashActivity);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0007 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void V(com.transsion.subroom.activity.SplashActivity r8, java.lang.String r9, com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean r10) {
        /*
            r7 = 1
            r3 = 0
            r6 = 0
            java.lang.String r0 = "ۦ۟ۡ"
            r1 = r0
            r2 = r3
        L7:
            int r0 = gt.md.C0799.m1158(r1)
            r4 = 1748862(0x1aaf7e, float:2.450678E-39)
            r0 = r0 ^ r4
            switch(r0) {
                case 7449: goto L13;
                case 26550: goto L32;
                case 27933: goto L55;
                case 28214: goto L4e;
                case 28381: goto L7b;
                case 1733405: goto L7f;
                case 1733629: goto L8a;
                default: goto L12;
            }
        L12:
            goto L7
        L13:
            r0 = 46727(0xb687, float:6.5478E-41)
            java.lang.Object[] r4 = new java.lang.Object[r6]
            java.lang.Object r0 = com.transsion.subroom.premium.C0678.n(r0, r3, r4)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r0 < 0) goto L7f
            int r0 = androidx.core.C0079.m394()
            if (r0 < 0) goto L2e
            androidx.core.appcompat.C0066.m207()
            goto L7
        L2e:
            java.lang.String r0 = "ۦۨۥ"
            r1 = r0
            goto L7
        L32:
            r4 = 5185(0x1441, float:7.266E-42)
            r0 = 82094(0x140ae, float:1.15038E-40)
            java.lang.Object r0 = com.transsion.subroom.premium.C0678.n(r0)
            java.io.PrintStream r0 = (java.io.PrintStream) r0
            java.lang.Object[] r5 = new java.lang.Object[r7]
            r5[r6] = r2
            com.transsion.subroom.premium.C0678.n(r4, r0, r5)
            int r0 = androidx.core.C0078.m391()
            if (r0 >= 0) goto L7
            java.lang.String r0 = "ۤۧ"
            r1 = r0
            goto L7
        L4e:
            r8.Z(r9, r10)
            java.lang.String r0 = "ۢ۠ۥ"
            r1 = r0
            goto L7
        L55:
            r1 = 58394(0xe41a, float:8.1827E-41)
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r4 = 15699(0x3d53, float:2.1999E-41)
            java.lang.Object[] r5 = new java.lang.Object[r7]
            r0 = 96654(0x1798e, float:1.35441E-40)
            java.lang.Object r0 = com.transsion.subroom.premium.C0673.n(r0)
            java.lang.String r0 = (java.lang.String) r0
            r5[r6] = r0
            java.lang.Object r0 = com.transsion.subroom.premium.C0678.n(r4, r3, r5)
            java.lang.String r0 = (java.lang.String) r0
            r2[r6] = r0
            java.lang.Object r0 = com.transsion.subroom.premium.C0678.n(r1, r3, r2)
            java.lang.Long r0 = (java.lang.Long) r0
            java.lang.String r1 = "ۨ۟۟"
            r2 = r0
            goto L7
        L7b:
            java.lang.String r0 = "ۦ۟ۡ"
            r1 = r0
            goto L7
        L7f:
            int r0 = gt.md.C0799.m1162()
            if (r0 <= 0) goto L7
            java.lang.String r0 = "ۤۧ"
            r1 = r0
            goto L7
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.SplashActivity.V(com.transsion.subroom.activity.SplashActivity, java.lang.String, com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0010. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x00aa A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void W(com.transsion.subroom.activity.SplashActivity r10, com.transsion.ad.bidding.splash.b r11) {
        /*
            r9 = 0
            r8 = 1
            r7 = 0
            r2 = 0
            java.lang.String r0 = "ۤۡۨ"
            r1 = r0
        L8:
            int r0 = gt.md.C0799.m1158(r1)
            r4 = 1750751(0x1ab6df, float:2.453325E-39)
            r0 = r0 ^ r4
            switch(r0) {
                case 2934: goto L14;
                case 3160: goto L9a;
                case 3230: goto Laf;
                case 3284: goto L88;
                case 4479: goto L68;
                case 6653: goto L49;
                case 29557: goto L1e;
                default: goto L13;
            }
        L13:
            goto L8
        L14:
            int r0 = gt.md.C0799.m1162()
            if (r0 > 0) goto Laa
            androidx.core.C0079.m394()
            goto L8
        L1e:
            r1 = 99156(0x18354, float:1.38947E-40)
            java.lang.Object[] r2 = new java.lang.Object[r8]
            r3 = 35573(0x8af5, float:4.9848E-41)
            java.lang.Object[] r4 = new java.lang.Object[r8]
            r0 = 81701(0x13f25, float:1.14487E-40)
            java.lang.Object r0 = com.transsion.subroom.premium.C0673.n(r0)
            java.lang.String r0 = (java.lang.String) r0
            r4[r7] = r0
            java.lang.Object r0 = com.transsion.subroom.premium.C0680.n(r3, r9, r4)
            java.lang.String r0 = (java.lang.String) r0
            r2[r7] = r0
            java.lang.Object r0 = com.transsion.subroom.premium.C0684.n(r1, r9, r2)
            java.lang.Double r0 = (java.lang.Double) r0
            double r2 = r0.doubleValue()
            java.lang.String r0 = "۟ۤۥ"
            r1 = r0
            goto L8
        L49:
            r0 = 78728(0x13388, float:1.10321E-40)
            java.lang.Object[] r4 = new java.lang.Object[r7]
            java.lang.Object r0 = com.transsion.subroom.premium.C0678.n(r0, r9, r4)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r0 < 0) goto L14
            int r0 = gt.md.C0799.m1162()
            if (r0 > 0) goto L64
            androidx.core.C0078.m391()
            goto L8
        L64:
            java.lang.String r0 = "ۧۤۧ"
            r1 = r0
            goto L8
        L68:
            r4 = 15189(0x3b55, float:2.1284E-41)
            r0 = 82094(0x140ae, float:1.15038E-40)
            java.lang.Object r0 = com.transsion.subroom.premium.C0678.n(r0)
            java.io.PrintStream r0 = (java.io.PrintStream) r0
            java.lang.Object[] r5 = new java.lang.Object[r8]
            java.lang.Double r6 = java.lang.Double.valueOf(r2)
            r5[r7] = r6
            com.transsion.subroom.premium.C0684.n(r4, r0, r5)
            int r0 = androidx.core.appcompat.C0066.m207()
            if (r0 != 0) goto L8
            java.lang.String r0 = "ۣۤ۠"
            r1 = r0
            goto L8
        L88:
            r10.splashManager = r11
            int r0 = gt.md.C0799.m1162()
            if (r0 > 0) goto L95
            androidx.core.C0078.m391()
            goto L8
        L95:
            java.lang.String r0 = "ۡۤۥ"
            r1 = r0
            goto L8
        L9a:
            int r0 = androidx.core.C0078.m391()
            if (r0 < 0) goto La5
            java.lang.String r0 = "۟ۢۢ"
            r1 = r0
            goto L8
        La5:
            java.lang.String r0 = "ۤۡۨ"
            r1 = r0
            goto L8
        Laa:
            java.lang.String r0 = "ۣۤ۠"
            r1 = r0
            goto L8
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.SplashActivity.W(com.transsion.subroom.activity.SplashActivity, com.transsion.ad.bidding.splash.b):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x003f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:30:0x03ee A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void X() {
        /*
            Method dump skipped, instructions count: 1122
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.SplashActivity.X():void");
    }

    private final Handler Y() {
        return (Handler) C0689.n(43812, (Lazy) C0673.n(67654, this), new Object[0]);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0076. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0a8c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0a77 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0a72 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0a5c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0a57 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0a67 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x006e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void Z(java.lang.String r49, com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean r50) {
        /*
            Method dump skipped, instructions count: 2896
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.SplashActivity.Z(java.lang.String, com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean):void");
    }

    private static final Handler a0() {
        return new Handler((Looper) C0673.n(19172, null, new Object[0]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void b0(com.transsion.subroom.activity.SplashActivity r12) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.SplashActivity.b0(com.transsion.subroom.activity.SplashActivity):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001d. Please report as an issue. */
    private final void c0() {
        Object[] objArr = null;
        PreloadTrendingData.a aVar = null;
        TrendingUGCViewModel.a aVar2 = null;
        Application application = null;
        short[] sArr = null;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        TrendingUGCViewModel trendingUGCViewModel = null;
        String str = "۠ۧۦ";
        while (true) {
            switch (C0799.m1158((Object) str) ^ 56537) {
                case 25:
                    if (C0079.m394() < 0) {
                        str = "ۨۨۨ";
                    }
                case 32:
                    if (!((Boolean) C0673.n(42904, (ak.g) C0672.n(64685), new Object[0])).booleanValue()) {
                        str = "۟۟ۥ";
                    } else if (C0799.m1162() <= 0) {
                        C0079.m394();
                    } else {
                        str = "ۨۢۥ";
                    }
                case 37:
                    i12 = ((Integer) C0678.n(99165, (Integer) objArr[1], new Object[0])).intValue();
                    if (C0667.m874() >= 0) {
                        C0066.m207();
                    } else {
                        str = "ۣ۟ۢ";
                    }
                case 228:
                    C0690.n(79438, (PreloadTrendingData) C0675.n(24039, aVar, new Object[0]), new Object[0]);
                    if (C0066.m207() == 0) {
                        str = "۟ۧۥ";
                    }
                case 1709340:
                    objArr[0] = new Integer(575224);
                    if (C0799.m1162() > 0) {
                        str = "ۧ۠ۦ";
                    }
                case 1709361:
                    PreloadTrendingData.a aVar3 = (PreloadTrendingData.a) C0675.n(18040);
                    if (C0066.m207() != 0) {
                        C0667.m874();
                        aVar = aVar3;
                    } else {
                        str = "ۨۢ۠";
                        aVar = aVar3;
                    }
                case 1709554:
                    TrendingUGCViewModel.a aVar4 = (TrendingUGCViewModel.a) C0673.n(12692);
                    if (C0799.m1162() <= 0) {
                        aVar2 = aVar4;
                    } else {
                        str = "ۢۨ۟";
                        aVar2 = aVar4;
                    }
                case 1709567:
                    C0690.n(25296, (PreloadTrendingData) C0675.n(24039, aVar, new Object[0]), new Object[0]);
                    str = "ۨۡ";
                case 1710578:
                    short[] sArr2 = (short[]) C0673.n(46421);
                    if (C0079.m394() >= 0) {
                        C0066.m207();
                        sArr = sArr2;
                    } else {
                        str = "ۣۥۡ";
                        sArr = sArr2;
                    }
                case 1710580:
                    objArr[1] = new Integer(7527945);
                    str = "ۥۣۤ";
                case 1711518:
                    str = "۟۟ۥ";
                case 1728817:
                    C0672.n(99333, null, new Object[]{application, (String) C0684.n(75978, null, new Object[]{sArr, Integer.valueOf(((i12 ^ (-1)) & 7528020) | ((-7528021) & i12)), Integer.valueOf(((i13 ^ (-1)) & 8864947) | ((-8864948) & i13)), Integer.valueOf(((i11 ^ (-1)) & 577204) | ((-577205) & i11))})});
                    str = "ۣۣۣ";
                case 1728863:
                    if (trendingUGCViewModel == null) {
                        str = "ۢ۟";
                    } else if (C0078.m391() >= 0) {
                        C0667.m874();
                    } else {
                        str = "۠ۤ۠";
                    }
                case 1729247:
                    objArr[2] = new Integer(8864928);
                    str = C0066.m207() != 0 ? "۠ۢۢ" : "ۦۦ";
                case 1731099:
                case 1733597:
                    str = "ۢ۟";
                case 1731162:
                    TrendingUGCViewModel trendingUGCViewModel2 = (TrendingUGCViewModel) C0673.n(47424, aVar2, new Object[]{application});
                    if (C0078.m391() >= 0) {
                        trendingUGCViewModel = trendingUGCViewModel2;
                    } else {
                        str = "ۥ۟۠";
                        trendingUGCViewModel = trendingUGCViewModel2;
                    }
                case 1731174:
                    i11 = ((Integer) C0678.n(99165, (Integer) objArr[0], new Object[0])).intValue();
                    if (C0799.m1162() > 0) {
                        str = "ۨۤ";
                    }
                case 1732480:
                    str = "ۧ۠ۤ";
                    application = (Application) C0673.n(14588, this, new Object[0]);
                case 1733233:
                    if (C0079.m394() >= 0) {
                        C0799.m1162();
                    } else {
                        str = "ۣۥۤ";
                    }
                case 1734502:
                    objArr = new Object[3];
                    if (C0079.m394() >= 0) {
                        C0799.m1162();
                    } else {
                        str = "ۨۧۤ";
                    }
                case 1734533:
                    C0673.n(76015, trendingUGCViewModel, new Object[]{this});
                    if (C0799.m1162() > 0) {
                        str = "ۡ۠ۧ";
                    }
                case 1735460:
                    break;
                case 1735461:
                    if (C0066.m207() != 0) {
                        C0066.m207();
                        str = "۟ۦ۟";
                    } else {
                        str = "۠ۧۦ";
                    }
                case 1735591:
                    i13 = ((Integer) C0678.n(99165, (Integer) objArr[2], new Object[0])).intValue();
                    if (C0667.m874() < 0) {
                        str = "ۥۢۥ";
                    }
                case 1735644:
                    C0673.n(83017, (PreloadTrendingData) C0675.n(24039, aVar, new Object[0]), new Object[]{this});
                    if (C0799.m1162() <= 0) {
                        C0079.m394();
                    } else {
                        str = "ۢ۟";
                    }
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0012. Please report as an issue. */
    private final void d0() {
        String str = "ۣ۠ۡ";
        int i11 = 0;
        SplashActivity$startSplashAdLoad$1 splashActivity$startSplashAdLoad$1 = null;
        LifecycleCoroutineScope lifecycleCoroutineScope = null;
        Integer num = null;
        while (true) {
            switch (C0799.m1158((Object) str) ^ 1752702) {
                case 1084:
                case 30655:
                    break;
                case 2265:
                    LifecycleCoroutineScope lifecycleCoroutineScope2 = (LifecycleCoroutineScope) C0672.n(9293, null, new Object[]{this});
                    if (C0079.m394() >= 0) {
                        lifecycleCoroutineScope = lifecycleCoroutineScope2;
                    } else {
                        str = "۠ۥۦ";
                        lifecycleCoroutineScope = lifecycleCoroutineScope2;
                    }
                case 5413:
                    i11 = ((Integer) C0678.n(99165, (Integer) new Object[]{num}[0], new Object[0])).intValue();
                    str = "ۣ۟ۨ";
                case 5441:
                case 5500:
                    num = new Integer(3445021);
                    if (C0066.m207() == 0) {
                        str = "ۧۦ۟";
                    }
                case 5631:
                    splashActivity$startSplashAdLoad$1 = new SplashActivity$startSplashAdLoad$1(this, null);
                    if (C0078.m391() >= 0) {
                        C0066.m207();
                    } else {
                        str = "۠ۤ۟";
                    }
                case 6650:
                    str = "ۨۧ۠";
                case 31646:
                    str = ((Boolean) C0673.n(4751, this)).booleanValue() ? "ۣۤۡ" : "۠ۦ";
                case 32726:
                    if (C0066.m207() != 0) {
                        C0799.m1162();
                        str = "ۧۥ";
                    } else {
                        str = "ۣ۠ۡ";
                    }
                case 1729144:
                    this.isAdLoadStarted = true;
                    if (C0078.m391() < 0) {
                        str = "ۣۤۨ";
                    }
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001f. Please report as an issue. */
    private final void e0(boolean isSplashAdLoaded) {
        Object[] objArr = null;
        Intent intent = null;
        short[] sArr = null;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        n0 n0Var = null;
        SplashActivity$toMain$1 splashActivity$toMain$1 = null;
        int i14 = 0;
        float f11 = 0.0f;
        String str = "۠ۢ";
        while (true) {
            switch (C0799.m1158((Object) str) ^ 1747867) {
                case 5:
                    intent = new Intent(this, (Class<?>) MainActivity.class);
                    str = "۠ۤۡ";
                case 185:
                    if (C0078.m391() < 0) {
                        str = "۠ۢ";
                    }
                case 198:
                    short[] sArr2 = (short[]) C0673.n(46421);
                    if (C0667.m874() >= 0) {
                        C0667.m874();
                        sArr = sArr2;
                    } else {
                        str = "۠۟ۡ";
                        sArr = sArr2;
                    }
                case 251:
                case 345:
                    int intValue = ((Integer) C0678.n(99165, (Integer) objArr[2], new Object[0])).intValue();
                    if (C0079.m394() >= 0) {
                        i11 = intValue;
                        str = "ۤۦۣ";
                    } else {
                        i11 = intValue;
                        str = "ۥ۠ۨ";
                    }
                case 381:
                    objArr[1] = new Integer(5154734);
                    if (C0799.m1162() <= 0) {
                        C0066.m207();
                        str = "ۧۢۤ";
                    } else {
                        str = "ۢۤۧ";
                    }
                case 1220:
                    C0684.n(39581, this, new Object[]{intent});
                    if (C0078.m391() < 0) {
                        str = "ۥۥۡ";
                    }
                case 1310:
                    objArr[0] = new Integer(854017);
                    if (C0079.m394() >= 0) {
                        C0079.m394();
                        str = "ۣۧۡ";
                    } else {
                        str = "ۥۤۢ";
                    }
                case 3268:
                    str = "ۡۦۤ";
                case 3288:
                    C0673.n(67754, this, new Object[]{0, 0});
                    if (C0079.m394() >= 0) {
                        C0066.m207();
                    } else {
                        str = "ۣۡۨ";
                    }
                case 4411:
                    C0669.n(76004, (PrintStream) C0678.n(82094), new Object[]{Float.valueOf(f11)});
                    str = "ۨۥۦ";
                case 5560:
                    objArr[3] = new Integer(1018108);
                    str = "۠۠ۦ";
                case 5594:
                    str = "ۧۦ۟";
                    n0Var = (n0) C0686.n(10923, null, new Object[]{(kotlinx.coroutines.i0) C0673.n(14554, null, new Object[0])});
                case 5653:
                    if (C0079.m394() < 0) {
                        str = "۠ۦۤ";
                    }
                case 5686:
                    i12 = ((Integer) C0678.n(99165, (Integer) objArr[0], new Object[0])).intValue();
                    str = "ۨۦۥ";
                case 6526:
                    if (C0078.m391() >= 0) {
                        C0066.m207();
                        str = "۠ۥۥ";
                    } else {
                        str = "ۥ۟ۨ";
                    }
                case 7327:
                    f11 = ((Float) C0669.n(92531, null, new Object[]{(String) C0678.n(66211, null, new Object[]{(String) C0673.n(46931)})})).floatValue();
                    str = "ۤۦۢ";
                case 7633:
                    C0673.n(28351, this, new Object[0]);
                    if (C0066.m207() != 0) {
                        C0078.m391();
                        str = "۠۠ۨ";
                    } else {
                        str = "ۨۥ۟";
                    }
                case 25106:
                    break;
                case 25113:
                    str = ((Integer) C0678.n(46727, null, new Object[0])).intValue() >= 0 ? C0078.m391() >= 0 ? "ۤۨۧ" : "ۣۧۨ" : "ۨۥۦ";
                case 25146:
                    i14 = ((Integer) C0678.n(99165, (Integer) objArr[1], new Object[0])).intValue();
                    if (C0066.m207() != 0) {
                        C0066.m207();
                    } else {
                        str = "ۨۤۦ";
                    }
                case 25148:
                    i13 = ((Integer) C0678.n(99165, (Integer) objArr[3], new Object[0])).intValue();
                    str = "۟ۢۢ";
                case 25329:
                    str = C0799.m1162() <= 0 ? "ۢۢ۟" : "۟ۡۥ";
                case 27345:
                    objArr[2] = new Integer(1467444);
                    if (C0078.m391() < 0) {
                        str = "ۣۡ۟";
                    }
                case 28283:
                    splashActivity$toMain$1 = new SplashActivity$toMain$1(this, null);
                    str = "ۨۦ۟";
                case 1734553:
                    objArr = new Object[4];
                    if (C0667.m874() < 0) {
                        str = "ۦۣ۟";
                    }
            }
            return;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0210 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x020b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void setStatusBar() {
        /*
            Method dump skipped, instructions count: 632
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.SplashActivity.setStatusBar():void");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x00b2. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0ee4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0ee0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0eb2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0eab A[SYNTHETIC] */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r65) {
        /*
            Method dump skipped, instructions count: 3994
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.SplashActivity.onCreate(android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0011. Please report as an issue. */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        String str = "۠ۥۢ";
        com.transsion.ad.bidding.splash.b bVar = null;
        int i11 = 0;
        Integer num = null;
        while (true) {
            switch (C0799.m1158((Object) str) ^ 1748771) {
                case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                    C0670.n(26032, null, new Object[]{null, this, Integer.valueOf(((i11 ^ (-1)) & 8329738) | ((-8329739) & i11)), null});
                    if (C0799.m1162() <= 0) {
                        C0079.m394();
                    } else {
                        str = "۠ۤ۠";
                    }
                case 1054:
                    i11 = ((Integer) C0678.n(99165, (Integer) new Object[]{num}[0], new Object[0])).intValue();
                    if (C0667.m874() >= 0) {
                        C0799.m1162();
                    } else {
                        str = "ۡۧ۠";
                    }
                case 1118:
                    num = new Integer(8329739);
                    str = "ۤۡ";
                case 1151:
                    com.transsion.ad.bidding.splash.b bVar2 = (com.transsion.ad.bidding.splash.b) C0673.n(19634, this);
                    if (C0799.m1162() <= 0) {
                        C0066.m207();
                        bVar = bVar2;
                    } else {
                        str = "ۢ۟ۧ";
                        bVar = bVar2;
                    }
                case 5532:
                    break;
                case 7529:
                    str = bVar != null ? C0066.m207() != 0 ? "ۣۦۧ" : "ۣۧ۠" : "ۤۧۢ";
                case 26180:
                case 26914:
                    str = "۠ۥۢ";
                case 27145:
                    if (C0079.m394() < 0) {
                        str = "ۤۧۢ";
                    }
                case 1733470:
                    super.onDestroy();
                    if (C0066.m207() != 0) {
                        C0079.m394();
                    } else {
                        str = "ۣ۠۠";
                    }
            }
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0011. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b A[SYNTHETIC] */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onPause() {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.SplashActivity.onPause():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0011. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0106 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0009 A[SYNTHETIC] */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onResume() {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subroom.activity.SplashActivity.onResume():void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001e. Please report as an issue. */
    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        String str = null;
        short[] sArr = null;
        int i11 = 0;
        AppStartReport appStartReport = null;
        Object[] objArr = null;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        long j11 = 0;
        String str2 = "ۢۧۦ";
        while (true) {
            switch (C0799.m1158((Object) str2) ^ 1754442) {
                case 1261:
                    objArr[0] = new Integer(8410177);
                    str2 = "۠ۥۢ";
                case 1835:
                    int intValue = ((Integer) C0678.n(99165, (Integer) objArr[1], new Object[0])).intValue();
                    if (C0799.m1162() <= 0) {
                        i12 = intValue;
                    } else {
                        str2 = "۟۟ۧ";
                        i12 = intValue;
                    }
                case 25099:
                    objArr[2] = new Integer(8910376);
                    if (C0079.m394() >= 0) {
                        C0799.m1162();
                        str2 = "ۣۥۡ";
                    } else {
                        str2 = "ۥۨۢ";
                    }
                case 25165:
                    int intValue2 = ((Integer) C0678.n(99165, (Integer) objArr[2], new Object[0])).intValue();
                    if (C0066.m207() != 0) {
                        i14 = intValue2;
                    } else {
                        str2 = "۠ۡۧ";
                        i14 = intValue2;
                    }
                case 25207:
                    String str3 = (String) C0675.n(18203, null, new Object[]{sArr, Integer.valueOf(((i14 ^ (-1)) & 8910651) | ((-8910652) & i14)), Integer.valueOf(((i13 ^ (-1)) & 1895675) | ((-1895676) & i13)), Integer.valueOf(((i12 ^ (-1)) & 7673965) | ((-7673966) & i12))});
                    if (C0667.m874() >= 0) {
                        str = str3;
                    } else {
                        str2 = "ۢۥ۟";
                        str = str3;
                    }
                case 25264:
                    int intValue3 = ((Integer) C0678.n(99165, (Integer) objArr[0], new Object[0])).intValue();
                    if (C0799.m1162() <= 0) {
                        i11 = intValue3;
                    } else {
                        str2 = "ۢۡۤ";
                        i11 = intValue3;
                    }
                case 28214:
                    C0676.n(61936, appStartReport, new Object[]{new AppStartDotState(str, (((-1) ^ j11) & 8784074) | ((8784074 ^ (-1)) & j11), ((i11 ^ (-1)) & 8410179) | ((-8410180) & i11), null)});
                    if (C0799.m1162() <= 0) {
                        C0079.m394();
                        str2 = "ۧۢۢ";
                    } else {
                        str2 = "ۤۤ";
                    }
                case 28215:
                    objArr[1] = new Integer(7675038);
                    str2 = "ۣ۟ۡ";
                case 28236:
                    int intValue4 = ((Integer) C0678.n(99165, (Integer) objArr[3], new Object[0])).intValue();
                    if (C0079.m394() >= 0) {
                        i13 = intValue4;
                        str2 = "۟۟۟";
                    } else {
                        i13 = intValue4;
                        str2 = "۟ۡ۟";
                    }
                case 28392:
                    if (!hasFocus) {
                        str2 = "ۤۤ";
                    } else if (C0667.m874() >= 0) {
                        C0079.m394();
                    } else {
                        str2 = "ۤ۟ۧ";
                    }
                case 29516:
                    str2 = "ۢۧۦ";
                case 30219:
                    objArr = new Object[5];
                    str2 = "ۦۣۢ";
                case 30225:
                    objArr[4] = new Long(8784074L);
                    str2 = "ۤۦۣ";
                case 30646:
                    long longValue = ((Long) C0688.n(54510, (Long) objArr[4], new Object[0])).longValue();
                    if (C0078.m391() >= 0) {
                        C0066.m207();
                        j11 = longValue;
                    } else {
                        str2 = "۠ۥۡ";
                        j11 = longValue;
                    }
                case 30668:
                    str2 = "ۤۤ";
                case 30671:
                    short[] sArr2 = (short[]) C0673.n(46421);
                    if (C0079.m394() >= 0) {
                        str2 = "ۤۥۦ";
                        sArr = sArr2;
                    } else {
                        str2 = "ۦۣۨ";
                        sArr = sArr2;
                    }
                case 31497:
                    str2 = C0079.m394() >= 0 ? "ۤۥۦ" : "۠ۦۨ";
                case 31701:
                    objArr[3] = new Integer(1895670);
                    if (C0799.m1162() > 0) {
                        str2 = "ۢۨۡ";
                    }
                case 31878:
                    AppStartReport appStartReport2 = (AppStartReport) C0676.n(44710);
                    if (C0079.m394() >= 0) {
                        appStartReport = appStartReport2;
                    } else {
                        str2 = "۟ۧۢ";
                        appStartReport = appStartReport2;
                    }
                case 32747:
                    if (C0066.m207() != 0) {
                        C0799.m1162();
                    } else {
                        str2 = "ۥۥۣ";
                    }
                case 1710538:
                    break;
            }
            return;
        }
    }
}
