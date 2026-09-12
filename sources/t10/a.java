package t10;

import s10.c;

/* loaded from: classes7.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f76112a;

    public a(StringBuilder sb2) {
        this.f76112a = sb2;
    }

    @Override // s10.c
    public c append(CharSequence charSequence) {
        this.f76112a.append(charSequence);
        return this;
    }

    public String toString() {
        return this.f76112a.toString();
    }
}
