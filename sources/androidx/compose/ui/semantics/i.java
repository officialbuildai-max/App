package androidx.compose.ui.semantics;

import androidx.compose.ui.platform.c1;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
public final class i implements n, Iterable, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    private final Map f6077a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    private boolean f6078b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6079c;

    @Override // androidx.compose.ui.semantics.n
    public void a(SemanticsPropertyKey semanticsPropertyKey, Object obj) {
        if (!(obj instanceof a) || !e(semanticsPropertyKey)) {
            this.f6077a.put(semanticsPropertyKey, obj);
            return;
        }
        Object obj2 = this.f6077a.get(semanticsPropertyKey);
        Intrinsics.f(obj2, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
        a aVar = (a) obj2;
        Map map = this.f6077a;
        a aVar2 = (a) obj;
        String b11 = aVar2.b();
        if (b11 == null) {
            b11 = aVar.b();
        }
        Function a11 = aVar2.a();
        if (a11 == null) {
            a11 = aVar.a();
        }
        map.put(semanticsPropertyKey, new a(b11, a11));
    }

    public final void c(i iVar) {
        if (iVar.f6078b) {
            this.f6078b = true;
        }
        if (iVar.f6079c) {
            this.f6079c = true;
        }
        for (Map.Entry entry : iVar.f6077a.entrySet()) {
            SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) entry.getKey();
            Object value = entry.getValue();
            if (!this.f6077a.containsKey(semanticsPropertyKey)) {
                this.f6077a.put(semanticsPropertyKey, value);
            } else if (value instanceof a) {
                Object obj = this.f6077a.get(semanticsPropertyKey);
                Intrinsics.f(obj, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                a aVar = (a) obj;
                Map map = this.f6077a;
                String b11 = aVar.b();
                if (b11 == null) {
                    b11 = ((a) value).b();
                }
                Function a11 = aVar.a();
                if (a11 == null) {
                    a11 = ((a) value).a();
                }
                map.put(semanticsPropertyKey, new a(b11, a11));
            }
        }
    }

    public final boolean e(SemanticsPropertyKey semanticsPropertyKey) {
        return this.f6077a.containsKey(semanticsPropertyKey);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return Intrinsics.c(this.f6077a, iVar.f6077a) && this.f6078b == iVar.f6078b && this.f6079c == iVar.f6079c;
    }

    public final boolean f() {
        Set keySet = this.f6077a.keySet();
        if ((keySet instanceof Collection) && keySet.isEmpty()) {
            return false;
        }
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            if (((SemanticsPropertyKey) it.next()).b()) {
                return true;
            }
        }
        return false;
    }

    public final i h() {
        i iVar = new i();
        iVar.f6078b = this.f6078b;
        iVar.f6079c = this.f6079c;
        iVar.f6077a.putAll(this.f6077a);
        return iVar;
    }

    public int hashCode() {
        return (((this.f6077a.hashCode() * 31) + androidx.compose.foundation.e.a(this.f6078b)) * 31) + androidx.compose.foundation.e.a(this.f6079c);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f6077a.entrySet().iterator();
    }

    public final Object j(SemanticsPropertyKey semanticsPropertyKey) {
        Object obj = this.f6077a.get(semanticsPropertyKey);
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException("Key not present: " + semanticsPropertyKey + " - consider getOrElse or getOrNull");
    }

    public final Object l(SemanticsPropertyKey semanticsPropertyKey, Function0 function0) {
        Object obj = this.f6077a.get(semanticsPropertyKey);
        return obj == null ? function0.invoke() : obj;
    }

    public final Object m(SemanticsPropertyKey semanticsPropertyKey, Function0 function0) {
        Object obj = this.f6077a.get(semanticsPropertyKey);
        return obj == null ? function0.invoke() : obj;
    }

    public final boolean n() {
        return this.f6079c;
    }

    public final boolean o() {
        return this.f6078b;
    }

    public final void p(i iVar) {
        for (Map.Entry entry : iVar.f6077a.entrySet()) {
            SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) entry.getKey();
            Object value = entry.getValue();
            Object obj = this.f6077a.get(semanticsPropertyKey);
            Intrinsics.f(semanticsPropertyKey, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsPropertyKey<kotlin.Any?>");
            Object c11 = semanticsPropertyKey.c(obj, value);
            if (c11 != null) {
                this.f6077a.put(semanticsPropertyKey, c11);
            }
        }
    }

    public final void q(boolean z10) {
        this.f6079c = z10;
    }

    public final void r(boolean z10) {
        this.f6078b = z10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        String str = "";
        if (this.f6078b) {
            sb2.append("");
            sb2.append("mergeDescendants=true");
            str = ", ";
        }
        if (this.f6079c) {
            sb2.append(str);
            sb2.append("isClearingSemantics=true");
            str = ", ";
        }
        for (Map.Entry entry : this.f6077a.entrySet()) {
            SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) entry.getKey();
            Object value = entry.getValue();
            sb2.append(str);
            sb2.append(semanticsPropertyKey.a());
            sb2.append(" : ");
            sb2.append(value);
            str = ", ";
        }
        return c1.a(this, null) + "{ " + ((Object) sb2) + " }";
    }
}
