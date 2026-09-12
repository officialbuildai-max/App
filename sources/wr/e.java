package wr;

import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f78064a = new e();

    /* renamed from: b, reason: collision with root package name */
    private static final Set f78065b = new LinkedHashSet();

    private e() {
    }

    public final void a(String str) {
        if (str != null) {
            f78065b.remove(str);
        }
    }

    public final void b(String str) {
        if (str != null) {
            f78065b.add(str);
        }
    }
}
