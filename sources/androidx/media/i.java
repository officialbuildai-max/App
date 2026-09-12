package androidx.media;

import android.text.TextUtils;

/* loaded from: classes.dex */
class i implements c {

    /* renamed from: a, reason: collision with root package name */
    private String f9858a;

    /* renamed from: b, reason: collision with root package name */
    private int f9859b;

    /* renamed from: c, reason: collision with root package name */
    private int f9860c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str, int i11, int i12) {
        this.f9858a = str;
        this.f9859b = i11;
        this.f9860c = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return (this.f9859b < 0 || iVar.f9859b < 0) ? TextUtils.equals(this.f9858a, iVar.f9858a) && this.f9860c == iVar.f9860c : TextUtils.equals(this.f9858a, iVar.f9858a) && this.f9859b == iVar.f9859b && this.f9860c == iVar.f9860c;
    }

    public int hashCode() {
        return androidx.core.util.d.b(this.f9858a, Integer.valueOf(this.f9860c));
    }
}
