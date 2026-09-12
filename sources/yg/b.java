package yg;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import bh.a;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.net.UrlKt;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.meituan.android.walle.WalleChannelReader;
import com.tencent.mmkv.MMKV;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import nh.m;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f79132a = new a(0 == true ? 1 : 0);

    /* renamed from: b, reason: collision with root package name */
    private static final String f79133b;

    /* renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap f79134c;

    /* renamed from: d, reason: collision with root package name */
    private static String f79135d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile Boolean f79136e;

    /* renamed from: f, reason: collision with root package name */
    private static String f79137f;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String i(String str) {
            return StringsKt.n1(new Regex("[\\r\\n]").replace(new Regex("\\s+").replace(new Regex("[\\p{C}]").replace(str, ""), " "), "")).toString();
        }

        public final void a(Bundle bundle) {
            Intrinsics.h(bundle, "bundle");
            bundle.putString("session_id", h());
            bundle.putString("device_id", ih.b.f65364a.h());
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            bundle.putString("install_store", e(a11));
            a.C0156a c0156a = bh.a.f16551a;
            String a12 = c0156a.a();
            if (!TextUtils.isEmpty(a12)) {
                bundle.putString("install_ch", a12);
            }
            String b11 = c0156a.b();
            if (!TextUtils.isEmpty(b11)) {
                bundle.putString("install_id", b11);
            }
            String d11 = c0156a.d();
            if (!TextUtils.isEmpty(d11)) {
                bundle.putString("install_share_uid", d11);
            }
            bundle.putString("net_state", String.valueOf(m.f70597a.b()));
        }

        public final synchronized void b(String key, String value) {
            Intrinsics.h(key, "key");
            Intrinsics.h(value, "value");
            b.f79134c.put(key, value);
        }

        public final String c() {
            String str;
            String string;
            pg.b b11 = pg.a.f72569a.b();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                linkedHashMap.put("package_name", com.blankj.utilcode.util.c.e());
                String b12 = b11 != null ? b11.b() : null;
                String str2 = "";
                if (!TextUtils.isEmpty(b12)) {
                    if (b12 == null) {
                        b12 = "";
                    }
                    linkedHashMap.put("version_name", b12);
                }
                int f11 = com.blankj.utilcode.util.c.f();
                if (f11 > 0) {
                    linkedHashMap.put("version_code", Integer.valueOf(f11));
                }
                linkedHashMap.put("os", "android");
                ih.b bVar = ih.b.f65364a;
                linkedHashMap.put("os_version", bVar.n());
                a.C0156a c0156a = bh.a.f16551a;
                if (!TextUtils.isEmpty(c0156a.a())) {
                    linkedHashMap.put("install_ch", c0156a.a());
                }
                linkedHashMap.put("device_id", bVar.h());
                Application a11 = Utils.a();
                Intrinsics.g(a11, "getApp(...)");
                linkedHashMap.put("install_store", String.valueOf(e(a11)));
                String i11 = bVar.i();
                if (!TextUtils.isEmpty(i11)) {
                    linkedHashMap.put(UrlKt.KEY_MINI_GAID, i11);
                }
                MMKV c11 = c0156a.c();
                if (c11 == null || (str = c11.getString("phone_brand", "")) == null) {
                    str = "";
                }
                if (TextUtils.isEmpty(str)) {
                    str = bVar.d();
                }
                if (!TextUtils.isEmpty(str)) {
                    linkedHashMap.put("brand", str);
                }
                linkedHashMap.put("model", bVar.l());
                String g11 = g();
                if (g11 == null) {
                    g11 = Locale.getDefault().getLanguage();
                }
                linkedHashMap.put("system_language", g11);
                linkedHashMap.put("net", m.f70597a.d());
                linkedHashMap.put(TtmlNode.TAG_REGION, Locale.getDefault().getCountry());
                linkedHashMap.put("timezone", TimeZone.getDefault().getID());
                MMKV c12 = c0156a.c();
                if (c12 != null && (string = c12.getString("sp_code", "")) != null) {
                    str2 = string;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = bVar.o();
                }
                linkedHashMap.put("sp_code", str2);
                if (!b.f79134c.isEmpty()) {
                    linkedHashMap.putAll(b.f79134c);
                }
                String jSONString = com.alibaba.fastjson.a.toJSONString(linkedHashMap);
                Intrinsics.g(jSONString, "toJSONString(...)");
                return i(jSONString);
            } catch (Exception unused) {
                String jSONString2 = com.alibaba.fastjson.a.toJSONString(linkedHashMap, SerializerFeature.BrowserCompatible);
                Intrinsics.g(jSONString2, "toJSONString(...)");
                return jSONString2;
            }
        }

        public final Boolean d() {
            return b.f79136e;
        }

        public final String e(Context context) {
            Intrinsics.h(context, "context");
            MMKV c11 = bh.a.f16551a.c();
            String string = c11 != null ? c11.getString("install_store", "") : null;
            if (TextUtils.isEmpty(string)) {
                if (TextUtils.isEmpty(b.f79137f)) {
                    String channel = WalleChannelReader.getChannel(context);
                    if (TextUtils.isEmpty(channel)) {
                        channel = "gp";
                    }
                    b.f79137f = channel;
                }
                string = b.f79137f;
            }
            b.f79137f = string;
            return b.f79137f;
        }

        public final synchronized Map f() {
            return MapsKt.u(b.f79134c);
        }

        public final String g() {
            return b.f79135d;
        }

        public final String h() {
            return b.f79133b;
        }

        public final void j(Boolean bool) {
            b.f79136e = bool;
        }

        public final void k(String channel) {
            Intrinsics.h(channel, "channel");
            MMKV c11 = bh.a.f16551a.c();
            if (c11 != null) {
                c11.putString("install_store", channel);
            }
        }

        public final void l(String str) {
            b.f79135d = str;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.g(uuid, "toString(...)");
        f79133b = uuid;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f79134c = concurrentHashMap;
        f79136e = Boolean.TRUE;
        MMKV c11 = bh.a.f16551a.c();
        String string = c11 != null ? c11.getString("x-md-global-color", "") : null;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        concurrentHashMap.put("x-md-global-color", String.valueOf(string));
    }
}
