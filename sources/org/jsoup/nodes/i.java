package org.jsoup.nodes;

import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract class i extends j {

    /* renamed from: d, reason: collision with root package name */
    private static final List f71883d = Collections.emptyList();

    /* renamed from: c, reason: collision with root package name */
    Object f71884c;

    private void b0() {
        if (x()) {
            return;
        }
        Object obj = this.f71884c;
        b bVar = new b();
        this.f71884c = bVar;
        if (obj != null) {
            bVar.w(B(), (String) obj);
        }
    }

    @Override // org.jsoup.nodes.j
    public String a(String str) {
        b0();
        return super.a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a0() {
        return f(B());
    }

    @Override // org.jsoup.nodes.j
    public String f(String str) {
        org.jsoup.helper.d.j(str);
        return !x() ? str.equals(B()) ? (String) this.f71884c : "" : super.f(str);
    }

    @Override // org.jsoup.nodes.j
    public j g(String str, String str2) {
        if (x() || !str.equals(B())) {
            b0();
            super.g(str, str2);
        } else {
            this.f71884c = str2;
        }
        return this;
    }

    @Override // org.jsoup.nodes.j
    public final b i() {
        b0();
        return (b) this.f71884c;
    }

    @Override // org.jsoup.nodes.j
    public String j() {
        return y() ? I().j() : "";
    }

    @Override // org.jsoup.nodes.j
    public int n() {
        return 0;
    }

    @Override // org.jsoup.nodes.j
    protected void s(String str) {
    }

    @Override // org.jsoup.nodes.j
    protected List t() {
        return f71883d;
    }

    @Override // org.jsoup.nodes.j
    public boolean w(String str) {
        b0();
        return super.w(str);
    }

    @Override // org.jsoup.nodes.j
    protected final boolean x() {
        return this.f71884c instanceof b;
    }
}
