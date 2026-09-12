package androidx.compose.ui.text.style;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    public static final a f6484b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final i f6485c = new i(0);

    /* renamed from: d, reason: collision with root package name */
    private static final i f6486d = new i(1);

    /* renamed from: e, reason: collision with root package name */
    private static final i f6487e = new i(2);

    /* renamed from: a, reason: collision with root package name */
    private final int f6488a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i a(List list) {
            Integer num = 0;
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                num = Integer.valueOf(num.intValue() | ((i) list.get(i11)).e());
            }
            return new i(num.intValue());
        }

        public final i b() {
            return i.f6487e;
        }

        public final i c() {
            return i.f6485c;
        }

        public final i d() {
            return i.f6486d;
        }
    }

    public i(int i11) {
        this.f6488a = i11;
    }

    public final boolean d(i iVar) {
        int i11 = this.f6488a;
        return (iVar.f6488a | i11) == i11;
    }

    public final int e() {
        return this.f6488a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f6488a == ((i) obj).f6488a;
    }

    public int hashCode() {
        return this.f6488a;
    }

    public String toString() {
        if (this.f6488a == 0) {
            return "TextDecoration.None";
        }
        ArrayList arrayList = new ArrayList();
        if ((this.f6488a & f6486d.f6488a) != 0) {
            arrayList.add("Underline");
        }
        if ((this.f6488a & f6487e.f6488a) != 0) {
            arrayList.add("LineThrough");
        }
        if (arrayList.size() == 1) {
            return "TextDecoration." + ((String) arrayList.get(0));
        }
        return "TextDecoration[" + q0.a.d(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
