package z2;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class c extends i {

    /* renamed from: b, reason: collision with root package name */
    public final String f79292b;

    /* renamed from: c, reason: collision with root package name */
    public final int f79293c;

    /* renamed from: d, reason: collision with root package name */
    public final int f79294d;

    /* renamed from: e, reason: collision with root package name */
    public final long f79295e;

    /* renamed from: f, reason: collision with root package name */
    public final long f79296f;

    /* renamed from: g, reason: collision with root package name */
    private final i[] f79297g;

    public c(String str, int i11, int i12, long j11, long j12, i[] iVarArr) {
        super("CHAP");
        this.f79292b = str;
        this.f79293c = i11;
        this.f79294d = i12;
        this.f79295e = j11;
        this.f79296f = j12;
        this.f79297g = iVarArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f79293c == cVar.f79293c && this.f79294d == cVar.f79294d && this.f79295e == cVar.f79295e && this.f79296f == cVar.f79296f && Objects.equals(this.f79292b, cVar.f79292b) && Arrays.equals(this.f79297g, cVar.f79297g);
    }

    public int hashCode() {
        int i11 = (((((((527 + this.f79293c) * 31) + this.f79294d) * 31) + ((int) this.f79295e)) * 31) + ((int) this.f79296f)) * 31;
        String str = this.f79292b;
        return i11 + (str != null ? str.hashCode() : 0);
    }
}
