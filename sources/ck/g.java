package ck;

import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f17322a = new g();

    /* renamed from: b, reason: collision with root package name */
    private static final Set f17323b = new LinkedHashSet();

    private g() {
    }

    public final void a(String str) {
        if (str != null) {
            f17323b.remove(str);
        }
    }

    public final void b(String str) {
        if (str != null) {
            f17323b.add(str);
        }
    }
}
