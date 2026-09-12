package org.jsoup.nodes;

import org.jsoup.select.Elements;

/* loaded from: classes7.dex */
public class h extends Element {

    /* renamed from: j, reason: collision with root package name */
    private final Elements f71882j;

    public h(org.jsoup.parser.f fVar, String str, b bVar) {
        super(fVar, str, bVar);
        this.f71882j = new Elements();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.nodes.j
    public void N(j jVar) {
        super.N(jVar);
        this.f71882j.remove(jVar);
    }

    public h d1(Element element) {
        this.f71882j.add(element);
        return this;
    }
}
