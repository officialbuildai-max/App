package z2;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class d extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f79298b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f79299c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f79300d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f79301e;

    /* renamed from: f, reason: collision with root package name */
    private final i[] f79302f;

    public d(String str, boolean z10, boolean z11, String[] strArr, i[] iVarArr) {
        super("CTOC");
        this.f79298b = str;
        this.f79299c = z10;
        this.f79300d = z11;
        this.f79301e = strArr;
        this.f79302f = iVarArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f79299c == dVar.f79299c && this.f79300d == dVar.f79300d && Objects.equals(this.f79298b, dVar.f79298b) && Arrays.equals(this.f79301e, dVar.f79301e) && Arrays.equals(this.f79302f, dVar.f79302f);
    }

    public int hashCode() {
        int i11 = (((527 + (this.f79299c ? 1 : 0)) * 31) + (this.f79300d ? 1 : 0)) * 31;
        String str = this.f79298b;
        return i11 + (str != null ? str.hashCode() : 0);
    }
}
