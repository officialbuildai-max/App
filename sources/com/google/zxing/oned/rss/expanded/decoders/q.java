package com.google.zxing.oned.rss.expanded.decoders;

import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.zxing.NotFoundException;
import com.transsion.mpush.core.config.MsgShowStatus;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
abstract class q {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f32993a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map f32994b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map f32995c;

    /* renamed from: d, reason: collision with root package name */
    private static final Map f32996d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final boolean f32997a;

        /* renamed from: b, reason: collision with root package name */
        final int f32998b;

        private a(boolean z10, int i11) {
            this.f32997a = z10;
            this.f32998b = i11;
        }

        static a a(int i11) {
            return new a(false, i11);
        }

        static a b(int i11) {
            return new a(true, i11);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f32993a = hashMap;
        hashMap.put("00", a.a(18));
        hashMap.put("01", a.a(14));
        hashMap.put("02", a.a(14));
        hashMap.put("10", a.b(20));
        hashMap.put(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY, a.a(6));
        hashMap.put("12", a.a(6));
        hashMap.put(PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION, a.a(6));
        hashMap.put(PrepareException.ERROR_FILE2VURL_MINIAPP_FILE_EXCEPTION, a.a(6));
        hashMap.put("17", a.a(6));
        hashMap.put("20", a.a(2));
        hashMap.put(ChainPoint.ROUTE_PAGE, a.b(20));
        hashMap.put("22", a.b(29));
        hashMap.put("30", a.b(8));
        hashMap.put("37", a.b(8));
        for (int i11 = 90; i11 <= 99; i11++) {
            f32993a.put(String.valueOf(i11), a.b(30));
        }
        HashMap hashMap2 = new HashMap();
        f32994b = hashMap2;
        hashMap2.put("240", a.b(30));
        hashMap2.put("241", a.b(30));
        hashMap2.put("242", a.b(6));
        hashMap2.put("250", a.b(30));
        hashMap2.put("251", a.b(30));
        hashMap2.put("253", a.b(17));
        hashMap2.put("254", a.b(20));
        hashMap2.put("400", a.b(30));
        hashMap2.put(MsgShowStatus.STATUS_NOTIFY_CLOSE, a.b(30));
        hashMap2.put(MsgShowStatus.STATUS_APP_ERROR, a.a(17));
        hashMap2.put("403", a.b(30));
        hashMap2.put("410", a.a(13));
        hashMap2.put("411", a.a(13));
        hashMap2.put("412", a.a(13));
        hashMap2.put("413", a.a(13));
        hashMap2.put("414", a.a(13));
        hashMap2.put("420", a.b(20));
        hashMap2.put("421", a.b(15));
        hashMap2.put("422", a.a(3));
        hashMap2.put("423", a.b(15));
        hashMap2.put("424", a.a(3));
        hashMap2.put("425", a.a(3));
        hashMap2.put("426", a.a(3));
        f32995c = new HashMap();
        for (int i12 = Sdk$SDKError.Reason.AD_HTML_FAILED_TO_LOAD_VALUE; i12 <= 316; i12++) {
            f32995c.put(String.valueOf(i12), a.a(6));
        }
        for (int i13 = Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE; i13 <= 336; i13++) {
            f32995c.put(String.valueOf(i13), a.a(6));
        }
        for (int i14 = 340; i14 <= 357; i14++) {
            f32995c.put(String.valueOf(i14), a.a(6));
        }
        for (int i15 = 360; i15 <= 369; i15++) {
            f32995c.put(String.valueOf(i15), a.a(6));
        }
        Map map = f32995c;
        map.put("390", a.b(15));
        map.put("391", a.b(18));
        map.put("392", a.b(15));
        map.put("393", a.b(18));
        map.put("703", a.b(30));
        HashMap hashMap3 = new HashMap();
        f32996d = hashMap3;
        hashMap3.put("7001", a.a(13));
        hashMap3.put("7002", a.b(30));
        hashMap3.put("7003", a.a(10));
        hashMap3.put("8001", a.a(14));
        hashMap3.put("8002", a.b(20));
        hashMap3.put("8003", a.b(30));
        hashMap3.put("8004", a.b(30));
        hashMap3.put("8005", a.a(6));
        hashMap3.put("8006", a.a(18));
        hashMap3.put("8007", a.b(30));
        hashMap3.put("8008", a.b(12));
        hashMap3.put("8018", a.a(18));
        hashMap3.put("8020", a.b(25));
        hashMap3.put("8100", a.a(6));
        hashMap3.put("8101", a.a(10));
        hashMap3.put("8102", a.a(2));
        hashMap3.put("8110", a.b(70));
        hashMap3.put("8200", a.b(70));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        if (str.isEmpty()) {
            return null;
        }
        if (str.length() < 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        a aVar = (a) f32993a.get(str.substring(0, 2));
        if (aVar != null) {
            return aVar.f32997a ? c(2, aVar.f32998b, str) : b(2, aVar.f32998b, str);
        }
        if (str.length() < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        String substring = str.substring(0, 3);
        a aVar2 = (a) f32994b.get(substring);
        if (aVar2 != null) {
            return aVar2.f32997a ? c(3, aVar2.f32998b, str) : b(3, aVar2.f32998b, str);
        }
        if (str.length() < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        a aVar3 = (a) f32995c.get(substring);
        if (aVar3 != null) {
            return aVar3.f32997a ? c(4, aVar3.f32998b, str) : b(4, aVar3.f32998b, str);
        }
        a aVar4 = (a) f32996d.get(str.substring(0, 4));
        if (aVar4 != null) {
            return aVar4.f32997a ? c(4, aVar4.f32998b, str) : b(4, aVar4.f32998b, str);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static String b(int i11, int i12, String str) {
        if (str.length() < i11) {
            throw NotFoundException.getNotFoundInstance();
        }
        String substring = str.substring(0, i11);
        int i13 = i12 + i11;
        if (str.length() < i13) {
            throw NotFoundException.getNotFoundInstance();
        }
        String substring2 = str.substring(i11, i13);
        String str2 = '(' + substring + ')' + substring2;
        String a11 = a(str.substring(i13));
        if (a11 == null) {
            return str2;
        }
        return str2 + a11;
    }

    private static String c(int i11, int i12, String str) {
        String substring = str.substring(0, i11);
        int min = Math.min(str.length(), i12 + i11);
        String substring2 = str.substring(i11, min);
        String str2 = '(' + substring + ')' + substring2;
        String a11 = a(str.substring(min));
        if (a11 == null) {
            return str2;
        }
        return str2 + a11;
    }
}
