package org.jsoup.parser;

/* loaded from: classes7.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    public static final d f71954c = new d(false, false);

    /* renamed from: d, reason: collision with root package name */
    public static final d f71955d = new d(true, true);

    /* renamed from: a, reason: collision with root package name */
    private final boolean f71956a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f71957b;

    public d(boolean z10, boolean z11) {
        this.f71956a = z10;
        this.f71957b = z11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public org.jsoup.nodes.b a(org.jsoup.nodes.b bVar) {
        if (!this.f71957b) {
            bVar.v();
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b(String str) {
        String trim = str.trim();
        return !this.f71956a ? e10.b.a(trim) : trim;
    }
}
