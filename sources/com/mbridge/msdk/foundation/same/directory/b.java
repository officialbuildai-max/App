package com.mbridge.msdk.foundation.same.directory;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected a f35433a;

    public b(String str) {
        a aVar = new a();
        aVar.a(str);
        aVar.a(c.AD_ROOT);
        List<a> b11 = b();
        if (b11 != null && b11.size() > 0) {
            aVar.a(b11);
        }
        this.f35433a = aVar;
    }

    public a a() {
        return this.f35433a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a a(ArrayList<a> arrayList, c cVar, String str) {
        a aVar = new a();
        aVar.a(cVar);
        aVar.a(str);
        arrayList.add(aVar);
        return aVar;
    }

    protected abstract List<a> b();
}
