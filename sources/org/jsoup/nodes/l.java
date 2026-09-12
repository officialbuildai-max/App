package org.jsoup.nodes;

import org.jsoup.nodes.Document;

/* loaded from: classes7.dex */
public class l extends i {
    public l(String str) {
        this.f71884c = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e0(StringBuilder sb2) {
        return sb2.length() != 0 && sb2.charAt(sb2.length() - 1) == ' ';
    }

    @Override // org.jsoup.nodes.j
    public String B() {
        return "#text";
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        if (d0() == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003a, code lost:
    
        z(r7, r8, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        if (d0() == false) goto L18;
     */
    @Override // org.jsoup.nodes.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void F(java.lang.Appendable r7, int r8, org.jsoup.nodes.Document.OutputSettings r9) {
        /*
            r6 = this;
            boolean r0 = r9.l()
            if (r0 == 0) goto L3d
            int r0 = r6.V()
            if (r0 != 0) goto L24
            org.jsoup.nodes.j r0 = r6.f71885a
            boolean r1 = r0 instanceof org.jsoup.nodes.Element
            if (r1 == 0) goto L24
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            org.jsoup.parser.f r0 = r0.T0()
            boolean r0 = r0.a()
            if (r0 == 0) goto L24
            boolean r0 = r6.d0()
            if (r0 == 0) goto L3a
        L24:
            boolean r0 = r9.j()
            if (r0 == 0) goto L3d
            java.util.List r0 = r6.W()
            int r0 = r0.size()
            if (r0 <= 0) goto L3d
            boolean r0 = r6.d0()
            if (r0 != 0) goto L3d
        L3a:
            r6.z(r7, r8, r9)
        L3d:
            boolean r8 = r9.l()
            if (r8 == 0) goto L58
            org.jsoup.nodes.j r8 = r6.I()
            boolean r8 = r8 instanceof org.jsoup.nodes.Element
            if (r8 == 0) goto L58
            org.jsoup.nodes.j r8 = r6.I()
            boolean r8 = org.jsoup.nodes.Element.O0(r8)
            if (r8 != 0) goto L58
            r8 = 1
        L56:
            r4 = r8
            goto L5a
        L58:
            r8 = 0
            goto L56
        L5a:
            java.lang.String r1 = r6.a0()
            r3 = 0
            r5 = 0
            r0 = r7
            r2 = r9
            org.jsoup.nodes.Entities.e(r0, r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.l.F(java.lang.Appendable, int, org.jsoup.nodes.Document$OutputSettings):void");
    }

    @Override // org.jsoup.nodes.j
    void G(Appendable appendable, int i11, Document.OutputSettings outputSettings) {
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ String a(String str) {
        return super.a(str);
    }

    public String c0() {
        return a0();
    }

    public boolean d0() {
        return org.jsoup.helper.c.e(a0());
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ String f(String str) {
        return super.f(str);
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ String j() {
        return super.j();
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ int n() {
        return super.n();
    }

    @Override // org.jsoup.nodes.j
    public String toString() {
        return D();
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.j
    public /* bridge */ /* synthetic */ boolean w(String str) {
        return super.w(str);
    }
}
