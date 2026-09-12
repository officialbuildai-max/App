package com.transsion.json;

/* loaded from: classes.dex */
public class s implements p {

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f46153a;

    public s(StringBuilder sb2) {
        this.f46153a = sb2;
    }

    @Override // com.transsion.json.p
    public int a(String str, int i11, int i12) {
        this.f46153a.append((CharSequence) str, i11, i12);
        return i12;
    }

    @Override // com.transsion.json.p
    public p a(String str) {
        this.f46153a.append(str);
        return this;
    }

    @Override // com.transsion.json.p
    public int b(String str, int i11, int i12, String str2) {
        this.f46153a.append((CharSequence) str, i11, i12);
        this.f46153a.append(str2);
        return i12 + 1;
    }

    public String toString() {
        return this.f46153a.toString();
    }
}
