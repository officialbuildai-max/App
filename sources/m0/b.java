package m0;

import androidx.compose.ui.text.platform.o;
import androidx.compose.ui.text.platform.p;
import java.util.HashMap;
import java.util.LinkedHashSet;
import kotlin.Unit;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final p f69204a = o.a();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap f69205b;

    /* renamed from: c, reason: collision with root package name */
    private final LinkedHashSet f69206c;

    /* renamed from: d, reason: collision with root package name */
    private int f69207d;

    /* renamed from: e, reason: collision with root package name */
    private int f69208e;

    /* renamed from: f, reason: collision with root package name */
    private int f69209f;

    /* renamed from: g, reason: collision with root package name */
    private int f69210g;

    /* renamed from: h, reason: collision with root package name */
    private int f69211h;

    /* renamed from: i, reason: collision with root package name */
    private int f69212i;

    /* renamed from: j, reason: collision with root package name */
    private int f69213j;

    public b(int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f69208e = i11;
        this.f69205b = new HashMap(0, 0.75f);
        this.f69206c = new LinkedHashSet();
    }

    private final int g(Object obj, Object obj2) {
        int i11 = i(obj, obj2);
        if (i11 >= 0) {
            return i11;
        }
        throw new IllegalStateException(("Negative size: " + obj + '=' + obj2).toString());
    }

    protected Object b(Object obj) {
        return null;
    }

    protected void c(boolean z10, Object obj, Object obj2, Object obj3) {
    }

    public final Object d(Object obj) {
        synchronized (this.f69204a) {
            Object obj2 = this.f69205b.get(obj);
            if (obj2 != null) {
                this.f69206c.remove(obj);
                this.f69206c.add(obj);
                this.f69212i++;
                return obj2;
            }
            this.f69213j++;
            Object b11 = b(obj);
            if (b11 == null) {
                return null;
            }
            synchronized (this.f69204a) {
                try {
                    this.f69210g++;
                    Object put = this.f69205b.put(obj, b11);
                    this.f69206c.remove(obj);
                    this.f69206c.add(obj);
                    if (put != null) {
                        this.f69205b.put(obj, put);
                        obj2 = put;
                    } else {
                        this.f69207d = h() + g(obj, b11);
                    }
                    Unit unit = Unit.f67184a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (obj2 != null) {
                c(false, obj, b11, obj2);
                return obj2;
            }
            j(this.f69208e);
            return b11;
        }
    }

    public final Object e(Object obj, Object obj2) {
        Object put;
        if (obj == null || obj2 == null) {
            throw null;
        }
        synchronized (this.f69204a) {
            try {
                this.f69209f++;
                this.f69207d = h() + g(obj, obj2);
                put = this.f69205b.put(obj, obj2);
                if (put != null) {
                    this.f69207d = h() - g(obj, put);
                }
                if (this.f69206c.contains(obj)) {
                    this.f69206c.remove(obj);
                }
                this.f69206c.add(obj);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (put != null) {
            c(false, obj, put, obj2);
        }
        j(this.f69208e);
        return put;
    }

    public final Object f(Object obj) {
        Object remove;
        obj.getClass();
        synchronized (this.f69204a) {
            try {
                remove = this.f69205b.remove(obj);
                this.f69206c.remove(obj);
                if (remove != null) {
                    this.f69207d = h() - g(obj, remove);
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (remove != null) {
            c(false, obj, remove, null);
        }
        return remove;
    }

    public final int h() {
        int i11;
        synchronized (this.f69204a) {
            i11 = this.f69207d;
        }
        return i11;
    }

    protected int i(Object obj, Object obj2) {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0094, code lost:
    
        throw new java.lang.IllegalStateException("map/keySet size inconsistency");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j(int r8) {
        /*
            r7 = this;
        L0:
            androidx.compose.ui.text.platform.p r0 = r7.f69204a
            monitor-enter(r0)
            int r1 = r7.h()     // Catch: java.lang.Throwable -> L18
            if (r1 < 0) goto L8d
            java.util.HashMap r1 = r7.f69205b     // Catch: java.lang.Throwable -> L18
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L18
            if (r1 == 0) goto L1b
            int r1 = r7.h()     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L8d
            goto L1b
        L18:
            r8 = move-exception
            goto L95
        L1b:
            java.util.HashMap r1 = r7.f69205b     // Catch: java.lang.Throwable -> L18
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L18
            java.util.LinkedHashSet r2 = r7.f69206c     // Catch: java.lang.Throwable -> L18
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L18
            if (r1 != r2) goto L8d
            int r1 = r7.h()     // Catch: java.lang.Throwable -> L18
            r2 = 1
            r3 = 0
            if (r1 <= r8) goto L78
            java.util.HashMap r1 = r7.f69205b     // Catch: java.lang.Throwable -> L18
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L78
            java.util.LinkedHashSet r1 = r7.f69206c     // Catch: java.lang.Throwable -> L18
            java.lang.Object r1 = kotlin.collections.CollectionsKt.h0(r1)     // Catch: java.lang.Throwable -> L18
            java.util.HashMap r4 = r7.f69205b     // Catch: java.lang.Throwable -> L18
            java.lang.Object r4 = r4.get(r1)     // Catch: java.lang.Throwable -> L18
            if (r4 == 0) goto L70
            java.util.HashMap r5 = r7.f69205b     // Catch: java.lang.Throwable -> L18
            java.util.Map r5 = kotlin.jvm.internal.TypeIntrinsics.d(r5)     // Catch: java.lang.Throwable -> L18
            r5.remove(r1)     // Catch: java.lang.Throwable -> L18
            java.util.LinkedHashSet r5 = r7.f69206c     // Catch: java.lang.Throwable -> L18
            java.util.Collection r5 = kotlin.jvm.internal.TypeIntrinsics.a(r5)     // Catch: java.lang.Throwable -> L18
            r5.remove(r1)     // Catch: java.lang.Throwable -> L18
            int r5 = r7.h()     // Catch: java.lang.Throwable -> L18
            kotlin.jvm.internal.Intrinsics.e(r1)     // Catch: java.lang.Throwable -> L18
            kotlin.jvm.internal.Intrinsics.e(r4)     // Catch: java.lang.Throwable -> L18
            int r6 = r7.g(r1, r4)     // Catch: java.lang.Throwable -> L18
            int r5 = r5 - r6
            r7.f69207d = r5     // Catch: java.lang.Throwable -> L18
            int r5 = r7.f69211h     // Catch: java.lang.Throwable -> L18
            int r5 = r5 + r2
            r7.f69211h = r5     // Catch: java.lang.Throwable -> L18
            goto L7a
        L70:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = "inconsistent state"
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L18
            throw r8     // Catch: java.lang.Throwable -> L18
        L78:
            r1 = r3
            r4 = r1
        L7a:
            kotlin.Unit r5 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L18
            monitor-exit(r0)
            if (r1 != 0) goto L82
            if (r4 != 0) goto L82
            return
        L82:
            kotlin.jvm.internal.Intrinsics.e(r1)
            kotlin.jvm.internal.Intrinsics.e(r4)
            r7.c(r2, r1, r4, r3)
            goto L0
        L8d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L18
            java.lang.String r1 = "map/keySet size inconsistency"
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L18
            throw r8     // Catch: java.lang.Throwable -> L18
        L95:
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.b.j(int):void");
    }

    public String toString() {
        String str;
        synchronized (this.f69204a) {
            try {
                int i11 = this.f69212i;
                int i12 = this.f69213j + i11;
                str = "LruCache[maxSize=" + this.f69208e + ",hits=" + this.f69212i + ",misses=" + this.f69213j + ",hitRate=" + (i12 != 0 ? (i11 * 100) / i12 : 0) + "%]";
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return str;
    }
}
