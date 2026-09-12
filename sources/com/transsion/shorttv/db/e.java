package com.transsion.shorttv.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private String f53077a;

    /* renamed from: b, reason: collision with root package name */
    private String f53078b;

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public e(String subjectId, String unlockedEps) {
        Intrinsics.h(subjectId, "subjectId");
        Intrinsics.h(unlockedEps, "unlockedEps");
        this.f53077a = subjectId;
        this.f53078b = unlockedEps;
    }

    public /* synthetic */ e(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2);
    }

    public final String a() {
        return this.f53077a;
    }

    public final String b() {
        return this.f53078b;
    }

    public final Set c() {
        if (StringsKt.q0(this.f53078b)) {
            return new LinkedHashSet();
        }
        List S0 = StringsKt.S0(this.f53078b, new String[]{","}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList();
        Iterator it = S0.iterator();
        while (it.hasNext()) {
            Integer v11 = StringsKt.v(StringsKt.n1((String) it.next()).toString());
            if (v11 != null) {
                arrayList.add(v11);
            }
        }
        return CollectionsKt.V0(arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.c(this.f53077a, eVar.f53077a) && Intrinsics.c(this.f53078b, eVar.f53078b);
    }

    public int hashCode() {
        return (this.f53077a.hashCode() * 31) + this.f53078b.hashCode();
    }

    public String toString() {
        return "ShortTvAdUnlockStateBean(subjectId=" + this.f53077a + ", unlockedEps=" + this.f53078b + ")";
    }
}
