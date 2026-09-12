package pg;

import com.tencent.mmkv.MMKV;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f72578a = new c();

    /* renamed from: b, reason: collision with root package name */
    private static MMKV f72579b;

    private c() {
    }

    public final String a(String key, String defaultValue) {
        String string;
        Intrinsics.h(key, "key");
        Intrinsics.h(defaultValue, "defaultValue");
        if (f72579b == null) {
            f72579b = MMKV.I("mmkv_net");
        }
        MMKV mmkv = f72579b;
        return (mmkv == null || (string = mmkv.getString(key, defaultValue)) == null) ? defaultValue : string;
    }

    public final void b(String key, String value) {
        Intrinsics.h(key, "key");
        Intrinsics.h(value, "value");
        if (f72579b == null) {
            f72579b = MMKV.I("mmkv_net");
        }
        MMKV mmkv = f72579b;
        if (mmkv != null) {
            mmkv.putString(key, value);
        }
    }
}
