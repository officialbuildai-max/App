package com.tn.lib.net.dns.or;

import android.text.TextUtils;
import com.blankj.utilcode.util.o;
import com.google.gson.reflect.TypeToken;
import com.tencent.mmkv.MMKV;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class CacheIpPool {

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList f40880b;

    /* renamed from: a, reason: collision with root package name */
    public static final CacheIpPool f40879a = new CacheIpPool();

    /* renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap f40881c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private static volatile String f40882d = "";

    /* renamed from: e, reason: collision with root package name */
    private static volatile String f40883e = "api6.aoneroom.com";

    /* renamed from: f, reason: collision with root package name */
    private static volatile String f40884f = "test-mse-api.aoneroom.com";

    /* renamed from: g, reason: collision with root package name */
    private static volatile String f40885g = "https";

    /* renamed from: h, reason: collision with root package name */
    private static final Lazy f40886h = LazyKt.b(new Function0() { // from class: com.tn.lib.net.dns.or.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String e11;
            e11 = CacheIpPool.e();
            return e11;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    private static final Lazy f40887i = LazyKt.b(new Function0() { // from class: com.tn.lib.net.dns.or.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String f11;
            f11 = CacheIpPool.f();
            return f11;
        }
    });

    /* renamed from: j, reason: collision with root package name */
    private static final Lazy f40888j = LazyKt.b(new Function0() { // from class: com.tn.lib.net.dns.or.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            String d11;
            d11 = CacheIpPool.d();
            return d11;
        }
    });

    private CacheIpPool() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String d() {
        if (pg.a.f72569a.d()) {
            return "https://" + f40884f;
        }
        return "https://" + f40883e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String e() {
        return "[\n{\n\"host\": \"" + f40883e + "\",\n\"ip\": \"\",\n\"scheme\": \"https\"\n}\n]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f() {
        return "[{\n    \"host\": \"" + f40884f + "\",\n    \"ip\": \"8.219.92.106\",\n    \"scheme\": \"https\"\n}]";
    }

    private final String i() {
        return (String) f40888j.getValue();
    }

    private final String j() {
        return (String) f40886h.getValue();
    }

    private final String k() {
        return (String) f40887i.getValue();
    }

    public final String g() {
        if (TextUtils.isEmpty(f40882d)) {
            f40882d = i();
        }
        return f40882d;
    }

    public final void h() {
        String str;
        AddressItem addressItem;
        AddressItem addressItem2;
        try {
            ArrayList<AddressItem> arrayList = (ArrayList) o.e(pg.c.f72578a.a("key_ip_list", pg.a.f72569a.d() ? k() : j()), new TypeToken<ArrayList<AddressItem>>() { // from class: com.tn.lib.net.dns.or.CacheIpPool$getCacheUrlList$type$1
            }.getType());
            f40880b = arrayList;
            if (arrayList != null) {
                for (AddressItem addressItem3 : arrayList) {
                    String host = addressItem3.getHost();
                    if (host != null && host.length() > 0) {
                        addressItem3.setIpEnable(true);
                        f40881c.put(addressItem3.getHost(), addressItem3);
                    }
                }
            }
            if (f40880b == null || !(!r0.isEmpty())) {
                str = f40882d;
            } else {
                ArrayList arrayList2 = f40880b;
                String str2 = null;
                f40885g = String.valueOf((arrayList2 == null || (addressItem2 = (AddressItem) arrayList2.get(0)) == null) ? null : addressItem2.getScheme());
                ArrayList arrayList3 = f40880b;
                if (arrayList3 != null && (addressItem = (AddressItem) arrayList3.get(0)) != null) {
                    str2 = addressItem.getHost();
                }
                f40883e = String.valueOf(str2);
                str = f40885g + "://" + f40883e;
            }
            f40882d = str;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final String l() {
        MMKV c11 = bh.a.f16551a.c();
        String string = c11 != null ? c11.getString("mock_host_key", "") : null;
        if (!TextUtils.isEmpty(string)) {
            f40883e = String.valueOf(string);
        }
        return f40883e;
    }

    public final String m() {
        return f40885g;
    }

    public final void n(String str) {
        if (!TextUtils.isEmpty(str)) {
            pg.c.f72578a.b("key_ip_list", String.valueOf(str));
        }
        h();
    }

    public final void o(String host) {
        Intrinsics.h(host, "host");
        f40883e = host;
    }
}
