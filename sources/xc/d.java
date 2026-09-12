package xc;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private static volatile d f78316b;

    /* renamed from: a, reason: collision with root package name */
    private final Set f78317a = new HashSet();

    d() {
    }

    public static d a() {
        d dVar = f78316b;
        if (dVar == null) {
            synchronized (d.class) {
                try {
                    dVar = f78316b;
                    if (dVar == null) {
                        dVar = new d();
                        f78316b = dVar;
                    }
                } finally {
                }
            }
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set b() {
        Set unmodifiableSet;
        synchronized (this.f78317a) {
            unmodifiableSet = Collections.unmodifiableSet(this.f78317a);
        }
        return unmodifiableSet;
    }
}
