package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class r1 {

    /* renamed from: a, reason: collision with root package name */
    private final List f3955a;

    /* JADX WARN: Multi-variable type inference failed */
    public r1() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public r1(List list) {
        this.f3955a = list;
    }

    public /* synthetic */ r1(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new ArrayList() : list);
    }

    public final void a(int i11) {
        if (!this.f3955a.isEmpty()) {
            if (((Number) this.f3955a.get(0)).intValue() == i11) {
                return;
            }
            if (((Number) this.f3955a.get(r0.size() - 1)).intValue() == i11) {
                return;
            }
        }
        int size = this.f3955a.size();
        this.f3955a.add(Integer.valueOf(i11));
        while (size > 0) {
            int i12 = ((size + 1) >>> 1) - 1;
            int intValue = ((Number) this.f3955a.get(i12)).intValue();
            if (i11 <= intValue) {
                break;
            }
            this.f3955a.set(size, Integer.valueOf(intValue));
            size = i12;
        }
        this.f3955a.set(size, Integer.valueOf(i11));
    }

    public final boolean b() {
        return !this.f3955a.isEmpty();
    }

    public final int c() {
        return ((Number) CollectionsKt.i0(this.f3955a)).intValue();
    }

    public final int d() {
        int intValue;
        if (!(this.f3955a.size() > 0)) {
            k.r("Set is empty");
        }
        int intValue2 = ((Number) this.f3955a.get(0)).intValue();
        while (!this.f3955a.isEmpty() && ((Number) this.f3955a.get(0)).intValue() == intValue2) {
            List list = this.f3955a;
            list.set(0, CollectionsKt.u0(list));
            List list2 = this.f3955a;
            list2.remove(list2.size() - 1);
            int size = this.f3955a.size();
            int size2 = this.f3955a.size() >>> 1;
            int i11 = 0;
            while (i11 < size2) {
                int intValue3 = ((Number) this.f3955a.get(i11)).intValue();
                int i12 = (i11 + 1) * 2;
                int i13 = i12 - 1;
                int intValue4 = ((Number) this.f3955a.get(i13)).intValue();
                if (i12 >= size || (intValue = ((Number) this.f3955a.get(i12)).intValue()) <= intValue4) {
                    if (intValue4 > intValue3) {
                        this.f3955a.set(i11, Integer.valueOf(intValue4));
                        this.f3955a.set(i13, Integer.valueOf(intValue3));
                        i11 = i13;
                    }
                } else if (intValue > intValue3) {
                    this.f3955a.set(i11, Integer.valueOf(intValue));
                    this.f3955a.set(i12, Integer.valueOf(intValue3));
                    i11 = i12;
                }
            }
        }
        return intValue2;
    }
}
