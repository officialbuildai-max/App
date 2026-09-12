package com.wecloud.load.lib;

import android.util.Log;
import com.google.gson.Gson;
import com.transsion.mb.config.manager.ConfigBean;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f60971a = new l();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f60972b = LazyKt.b(new Function0() { // from class: com.wecloud.load.lib.k
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Gson c11;
            c11 = l.c();
            return c11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static volatile Boolean f60973c;

    private l() {
    }

    private final Gson b() {
        return (Gson) f60972b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson c() {
        return new Gson();
    }

    private final String e() {
        try {
            ConfigBean d11 = sm.f.d(sm.f.f75530c.a(), "network_probe", false, 2, null);
            String value = d11 != null ? d11.getValue() : null;
            if (value != null && value.length() != 0) {
                int length = value.length();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("got network_probe remote config JSON from ConfigManager, key=network_probe, length=");
                sb2.append(length);
                sb2.append(", value=");
                sb2.append(value);
                return value;
            }
            return null;
        } catch (Exception e11) {
            Log.w("NativeProbeCfgLoader", "load network_probe config from ConfigManager failed: " + e11.getMessage(), e11);
            return null;
        }
    }

    public final boolean d() {
        Object m1185constructorimpl;
        NativeProbeRemoteConfig nativeProbeRemoteConfig;
        Boolean enableOnlineProbe;
        Boolean bool = f60973c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            String e11 = e();
            boolean z10 = false;
            if (e11 != null) {
                String obj = StringsKt.n1(e11).toString();
                if (StringsKt.W(obj, "\"", false, 2, null) && StringsKt.G(obj, "\"", false, 2, null)) {
                    try {
                        String str = (String) b().fromJson(obj, String.class);
                        String obj2 = str != null ? StringsKt.n1(str).toString() : null;
                        obj = obj2 == null ? "" : obj2;
                    } catch (Exception unused) {
                    }
                }
                String lowerCase = obj.toLowerCase(Locale.ROOT);
                Intrinsics.g(lowerCase, "toLowerCase(...)");
                if (Intrinsics.c(lowerCase, "true")) {
                    z10 = true;
                } else if (!Intrinsics.c(lowerCase, "false") && (nativeProbeRemoteConfig = (NativeProbeRemoteConfig) b().fromJson(obj, NativeProbeRemoteConfig.class)) != null && (enableOnlineProbe = nativeProbeRemoteConfig.getEnableOnlineProbe()) != null) {
                    z10 = enableOnlineProbe.booleanValue();
                }
            }
            m1185constructorimpl = Result.m1185constructorimpl(Boolean.valueOf(z10));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            Log.w("NativeProbeCfgLoader", "parse network_probe remote config failed: " + m1188exceptionOrNullimpl.getMessage(), m1188exceptionOrNullimpl);
        }
        Boolean bool2 = Boolean.FALSE;
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = bool2;
        }
        Boolean bool3 = (Boolean) m1185constructorimpl;
        boolean booleanValue = bool3.booleanValue();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("network_probe remote config parsed successfully: enabled=");
        sb2.append(booleanValue);
        f60973c = bool3;
        return booleanValue;
    }
}
