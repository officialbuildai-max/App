package com.tn.tranpay.helper;

import com.google.gson.Gson;
import com.tencent.mmkv.MMKV;
import com.tn.tranpay.bean.CurrencyInfoBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes4.dex */
public final class PaymentMMKV {

    /* renamed from: a, reason: collision with root package name */
    public static final PaymentMMKV f41698a = new PaymentMMKV();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f41699b = LazyKt.b(new Function0<MMKV>() { // from class: com.tn.tranpay.helper.PaymentMMKV$mmkv$2
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.I("tran_pay");
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final Gson f41700c = new Gson();

    /* renamed from: d, reason: collision with root package name */
    private static final SimpleDateFormat f41701d = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());

    private PaymentMMKV() {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(5:5|6|(1:(1:9)(2:31|32))(2:33|(1:35)(1:36))|10|(5:23|24|25|26|27)(5:14|15|16|17|18)))|37|6|(0)(0)|10|(1:12)|23|24|25|26|27) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0111, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0112, code lost:
    
        ai.a.e(ai.a.f694a, "缓存货币信息失败: " + r10.getMessage(), null, 2, null);
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(com.tn.tranpay.bean.CurrencyInfoBean r10, kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tn.tranpay.helper.PaymentMMKV.a(com.tn.tranpay.bean.CurrencyInfoBean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void b(String region, CurrencyInfoBean currencyInfo) {
        Intrinsics.h(region, "region");
        Intrinsics.h(currencyInfo, "currencyInfo");
        String str = "k_currency_info_cache_" + region;
        String str2 = "k_currency_info_cache_time_" + region;
        try {
            h().putString(str, f41700c.toJson(currencyInfo));
            h().putLong(str2, System.currentTimeMillis());
        } catch (Exception e11) {
            ai.a.e(ai.a.f694a, "缓存region货币信息失败: " + e11.getMessage(), null, 2, null);
        }
    }

    public final void c() {
        d();
        e();
    }

    public final void d() {
        int v02;
        String format = f41701d.format(new Date());
        String[] a11 = h().a();
        if (a11 != null) {
            for (String key : a11) {
                Intrinsics.g(key, "key");
                if (StringsKt.W(key, "k_currency_info_ip_cache_", false, 2, null) && (v02 = StringsKt.v0(key, "_", 0, false, 6, null)) != -1 && v02 < key.length() - 1) {
                    String substring = key.substring(v02 + 1);
                    Intrinsics.g(substring, "substring(...)");
                    if (!Intrinsics.c(substring, format)) {
                        f41698a.h().M(key);
                        ai.a.g(ai.a.f694a, "清除过期IP缓存: " + key, null, 2, null);
                    }
                }
            }
        }
    }

    public final void e() {
        long currentTimeMillis = System.currentTimeMillis();
        String[] a11 = h().a();
        if (a11 != null) {
            for (String key : a11) {
                Intrinsics.g(key, "key");
                if (StringsKt.W(key, "k_currency_info_cache_time_", false, 2, null)) {
                    PaymentMMKV paymentMMKV = f41698a;
                    long j11 = paymentMMKV.h().getLong(key, 0L);
                    if (j11 > 0 && currentTimeMillis - j11 > 2592000000L) {
                        paymentMMKV.h().M("k_currency_info_cache_" + StringsKt.I0(key, "k_currency_info_cache_time_"));
                        paymentMMKV.h().M(key);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(kotlin.coroutines.Continuation r11) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tn.tranpay.helper.PaymentMMKV.f(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final CurrencyInfoBean g(String region) {
        Intrinsics.h(region, "region");
        String str = "k_currency_info_cache_" + region;
        String str2 = "k_currency_info_cache_time_" + region;
        long j11 = h().getLong(str2, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (j11 == 0 || currentTimeMillis - j11 > 2592000000L) {
            h().M(str);
            h().M(str2);
            return null;
        }
        String string = h().getString(str, "");
        if (string == null || string.length() == 0) {
            return null;
        }
        try {
            return (CurrencyInfoBean) f41700c.fromJson(string, CurrencyInfoBean.class);
        } catch (Exception e11) {
            ai.a.e(ai.a.f694a, "解析region缓存失败: " + e11.getMessage(), null, 2, null);
            h().M(str);
            h().M(str2);
            return null;
        }
    }

    public final MMKV h() {
        Object value = f41699b.getValue();
        Intrinsics.g(value, "<get-mmkv>(...)");
        return (MMKV) value;
    }
}
