package androidx.room;

import androidx.room.InvalidationTracker;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private final InvalidationTracker.b f14800a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f14801b;

    /* renamed from: c, reason: collision with root package name */
    private final String[] f14802c;

    /* renamed from: d, reason: collision with root package name */
    private final Set f14803d;

    public o(InvalidationTracker.b observer, int[] tableIds, String[] tableNames) {
        Intrinsics.h(observer, "observer");
        Intrinsics.h(tableIds, "tableIds");
        Intrinsics.h(tableNames, "tableNames");
        this.f14800a = observer;
        this.f14801b = tableIds;
        this.f14802c = tableNames;
        if (tableIds.length != tableNames.length) {
            throw new IllegalStateException("Check failed.");
        }
        this.f14803d = !(tableNames.length == 0) ? SetsKt.d(tableNames[0]) : SetsKt.f();
    }

    public final InvalidationTracker.b a() {
        return this.f14800a;
    }

    public final int[] b() {
        return this.f14801b;
    }

    public final void c(Set invalidatedTablesIds) {
        Set f11;
        Intrinsics.h(invalidatedTablesIds, "invalidatedTablesIds");
        int[] iArr = this.f14801b;
        int length = iArr.length;
        if (length != 0) {
            int i11 = 0;
            if (length != 1) {
                Set b11 = SetsKt.b();
                int[] iArr2 = this.f14801b;
                int length2 = iArr2.length;
                int i12 = 0;
                while (i11 < length2) {
                    int i13 = i12 + 1;
                    if (invalidatedTablesIds.contains(Integer.valueOf(iArr2[i11]))) {
                        b11.add(this.f14802c[i12]);
                    }
                    i11++;
                    i12 = i13;
                }
                f11 = SetsKt.a(b11);
            } else {
                f11 = invalidatedTablesIds.contains(Integer.valueOf(iArr[0])) ? this.f14803d : SetsKt.f();
            }
        } else {
            f11 = SetsKt.f();
        }
        if (f11.isEmpty()) {
            return;
        }
        this.f14800a.c(f11);
    }

    public final void d(Set invalidatedTablesNames) {
        Set f11;
        Intrinsics.h(invalidatedTablesNames, "invalidatedTablesNames");
        int length = this.f14802c.length;
        if (length == 0) {
            f11 = SetsKt.f();
        } else if (length != 1) {
            Set b11 = SetsKt.b();
            Iterator it = invalidatedTablesNames.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                String[] strArr = this.f14802c;
                int length2 = strArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 < length2) {
                        String str2 = strArr[i11];
                        if (StringsKt.H(str2, str, true)) {
                            b11.add(str2);
                            break;
                        }
                        i11++;
                    }
                }
            }
            f11 = SetsKt.a(b11);
        } else {
            Set set = invalidatedTablesNames;
            if (!(set instanceof Collection) || !set.isEmpty()) {
                Iterator it2 = set.iterator();
                while (it2.hasNext()) {
                    if (StringsKt.H((String) it2.next(), this.f14802c[0], true)) {
                        f11 = this.f14803d;
                        break;
                    }
                }
            }
            f11 = SetsKt.f();
        }
        if (f11.isEmpty()) {
            return;
        }
        this.f14800a.c(f11);
    }
}
