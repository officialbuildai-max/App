package com.alibaba.fastjson.asm;

/* loaded from: classes2.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    int f18183a;

    /* renamed from: b, reason: collision with root package name */
    int f18184b;

    /* renamed from: c, reason: collision with root package name */
    int f18185c;

    /* renamed from: d, reason: collision with root package name */
    long f18186d;

    /* renamed from: e, reason: collision with root package name */
    String f18187e;

    /* renamed from: f, reason: collision with root package name */
    String f18188f;

    /* renamed from: g, reason: collision with root package name */
    String f18189g;

    /* renamed from: h, reason: collision with root package name */
    int f18190h;

    /* renamed from: i, reason: collision with root package name */
    e f18191i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i11, e eVar) {
        this.f18183a = i11;
        this.f18184b = eVar.f18184b;
        this.f18185c = eVar.f18185c;
        this.f18186d = eVar.f18186d;
        this.f18187e = eVar.f18187e;
        this.f18188f = eVar.f18188f;
        this.f18189g = eVar.f18189g;
        this.f18190h = eVar.f18190h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(e eVar) {
        int i11 = this.f18184b;
        if (i11 != 1) {
            if (i11 != 15) {
                if (i11 == 12) {
                    return eVar.f18187e.equals(this.f18187e) && eVar.f18188f.equals(this.f18188f);
                }
                if (i11 != 13) {
                    switch (i11) {
                        case 3:
                        case 4:
                            return eVar.f18185c == this.f18185c;
                        case 5:
                        case 6:
                            break;
                        case 7:
                        case 8:
                            break;
                        default:
                            return eVar.f18187e.equals(this.f18187e) && eVar.f18188f.equals(this.f18188f) && eVar.f18189g.equals(this.f18189g);
                    }
                }
            }
            return eVar.f18186d == this.f18186d;
        }
        return eVar.f18187e.equals(this.f18187e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i11) {
        this.f18184b = 3;
        this.f18185c = i11;
        this.f18190h = (3 + i11) & Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i11, String str, String str2, String str3) {
        this.f18184b = i11;
        this.f18187e = str;
        this.f18188f = str2;
        this.f18189g = str3;
        if (i11 != 1 && i11 != 7 && i11 != 8) {
            if (i11 == 12) {
                this.f18190h = (i11 + (str.hashCode() * str2.hashCode())) & Integer.MAX_VALUE;
                return;
            } else if (i11 != 13) {
                this.f18190h = (i11 + (str.hashCode() * str2.hashCode() * str3.hashCode())) & Integer.MAX_VALUE;
                return;
            }
        }
        this.f18190h = (i11 + str.hashCode()) & Integer.MAX_VALUE;
    }
}
