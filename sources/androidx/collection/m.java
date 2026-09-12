package androidx.collection;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public int[] f2373a;

    /* renamed from: b, reason: collision with root package name */
    public int f2374b;

    private m(int i11) {
        this.f2373a = i11 == 0 ? r.a() : new int[i11];
    }

    public /* synthetic */ m(int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11);
    }

    public static /* synthetic */ String d(m mVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i12 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i12 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i12 & 4) == 0 ? charSequence3 : "";
        if ((i12 & 8) != 0) {
            i11 = -1;
        }
        int i13 = i11;
        if ((i12 & 16) != 0) {
            charSequence4 = "...";
        }
        return mVar.c(charSequence, charSequence5, charSequence6, i13, charSequence4);
    }

    public final int a(int i11) {
        if (i11 >= 0 && i11 < this.f2374b) {
            return this.f2373a[i11];
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Index ");
        sb2.append(i11);
        sb2.append(" must be in 0..");
        sb2.append(this.f2374b - 1);
        throw new IndexOutOfBoundsException(sb2.toString());
    }

    public final int b() {
        return this.f2374b;
    }

    public final String c(CharSequence separator, CharSequence prefix, CharSequence postfix, int i11, CharSequence truncated) {
        Intrinsics.h(separator, "separator");
        Intrinsics.h(prefix, "prefix");
        Intrinsics.h(postfix, "postfix");
        Intrinsics.h(truncated, "truncated");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(prefix);
        int[] iArr = this.f2373a;
        int i12 = this.f2374b;
        int i13 = 0;
        while (true) {
            if (i13 >= i12) {
                sb2.append(postfix);
                break;
            }
            int i14 = iArr[i13];
            if (i13 == i11) {
                sb2.append(truncated);
                break;
            }
            if (i13 != 0) {
                sb2.append(separator);
            }
            sb2.append(i14);
            i13++;
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public boolean equals(Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            int i11 = mVar.f2374b;
            int i12 = this.f2374b;
            if (i11 == i12) {
                int[] iArr = this.f2373a;
                int[] iArr2 = mVar.f2373a;
                IntRange t11 = RangesKt.t(0, i12);
                int first = t11.getFirst();
                int last = t11.getLast();
                if (first > last) {
                    return true;
                }
                while (iArr[first] == iArr2[first]) {
                    if (first == last) {
                        return true;
                    }
                    first++;
                }
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.f2373a;
        int i11 = this.f2374b;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i12 += iArr[i13] * 31;
        }
        return i12;
    }

    public String toString() {
        return d(this, null, "[", "]", 0, null, 25, null);
    }
}
