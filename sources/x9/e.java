package x9;

import com.google.android.exoplayer2.util.p0;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f78211a;

    /* renamed from: b, reason: collision with root package name */
    public final String f78212b;

    /* renamed from: c, reason: collision with root package name */
    public final String f78213c;

    public e(String str, String str2, String str3) {
        this.f78211a = str;
        this.f78212b = str2;
        this.f78213c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return p0.c(this.f78211a, eVar.f78211a) && p0.c(this.f78212b, eVar.f78212b) && p0.c(this.f78213c, eVar.f78213c);
    }

    public int hashCode() {
        int hashCode = this.f78211a.hashCode() * 31;
        String str = this.f78212b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f78213c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
