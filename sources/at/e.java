package at;

import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f16206a = new e();

    /* renamed from: b, reason: collision with root package name */
    private static final Set f16207b = new LinkedHashSet();

    private e() {
    }

    public final void a(String str) {
        if (str != null) {
            f16207b.remove(str);
        }
    }

    public final void b(String str) {
        if (str != null) {
            f16207b.add(str);
        }
    }
}
