package androidx.media3.common;

import androidx.media3.common.util.a1;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class g0 {

    /* renamed from: c, reason: collision with root package name */
    private static final String f10059c = a1.C0(0);

    /* renamed from: d, reason: collision with root package name */
    private static final String f10060d = a1.C0(1);

    /* renamed from: a, reason: collision with root package name */
    public final f0 f10061a;

    /* renamed from: b, reason: collision with root package name */
    public final ImmutableList f10062b;

    public g0(f0 f0Var, int i11) {
        this(f0Var, ImmutableList.of(Integer.valueOf(i11)));
    }

    public g0(f0 f0Var, List list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= f0Var.f10053a)) {
            throw new IndexOutOfBoundsException();
        }
        this.f10061a = f0Var;
        this.f10062b = ImmutableList.copyOf((Collection) list);
    }

    public int a() {
        return this.f10061a.f10055c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g0.class != obj.getClass()) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return this.f10061a.equals(g0Var.f10061a) && this.f10062b.equals(g0Var.f10062b);
    }

    public int hashCode() {
        return this.f10061a.hashCode() + (this.f10062b.hashCode() * 31);
    }
}
