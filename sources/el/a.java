package el;

import com.transsion.home.bean.HomePreferencesConfig;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f62040a;

    /* renamed from: b, reason: collision with root package name */
    private final HomePreferencesConfig f62041b;

    public a(int i11, HomePreferencesConfig config) {
        Intrinsics.h(config, "config");
        this.f62040a = i11;
        this.f62041b = config;
    }

    public final HomePreferencesConfig a() {
        return this.f62041b;
    }

    public final int b() {
        return this.f62040a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f62040a == aVar.f62040a && Intrinsics.c(this.f62041b, aVar.f62041b);
    }

    public int hashCode() {
        return (this.f62040a * 31) + this.f62041b.hashCode();
    }

    public String toString() {
        return "HomePreferencesInsertInstruction(position=" + this.f62040a + ", config=" + this.f62041b + ")";
    }
}
