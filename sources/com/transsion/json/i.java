package com.transsion.json;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private final Map f46127a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map f46128b = new HashMap();

    private m a() {
        m mVar = new m();
        for (Class cls : this.f46127a.keySet()) {
            mVar.b(cls, (o) this.f46127a.get(cls));
        }
        for (q qVar : this.f46128b.keySet()) {
            mVar.a(qVar, (o) this.f46128b.get(qVar));
        }
        return mVar;
    }

    public Object b(String str, Class cls) {
        return a().j(new l(str).j(), cls);
    }
}
