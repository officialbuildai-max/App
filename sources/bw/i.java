package bw;

import android.content.Context;
import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public static final h f17023b = new h();

    /* renamed from: c, reason: collision with root package name */
    public static volatile i f17024c;

    /* renamed from: a, reason: collision with root package name */
    public final MMKV f17025a;

    public i(Context context) {
        try {
            MMKV.C(context);
            this.f17025a = MMKV.o();
        } catch (Throwable unused) {
        }
    }

    public final String a(String key, String defaultValue) {
        Intrinsics.h(key, "key");
        Intrinsics.h(defaultValue, "defaultValue");
        MMKV mmkv = this.f17025a;
        String l11 = mmkv != null ? mmkv.l(key, defaultValue) : null;
        return l11 == null ? defaultValue : l11;
    }

    public final void b(String key, String value) {
        Intrinsics.h(key, "key");
        Intrinsics.h(value, "value");
        MMKV mmkv = this.f17025a;
        if (mmkv != null) {
            mmkv.v(key, value);
        }
    }
}
