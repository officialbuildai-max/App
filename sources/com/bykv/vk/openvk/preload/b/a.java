package com.bykv.vk.openvk.preload.b;

import com.bykv.vk.openvk.preload.b.l;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class a<IN, OUT> extends l<IN, OUT> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bykv.vk.openvk.preload.b.d
    public final Object a(b<OUT> bVar, IN in2) throws Throwable {
        new m(bVar);
        String a11 = a((a<IN, OUT>) in2);
        l.a aVar = a().get(a11);
        if (aVar == null) {
            throw new IllegalArgumentException("can not found branch, branch name is：".concat(String.valueOf(a11)));
        }
        List<h> list = aVar.f20645a;
        Object a12 = c.a(list, ((i) bVar).f20638a, this).a((b) in2);
        return !l.a(list) ? a12 : bVar.a((b<OUT>) a12);
    }

    protected abstract String a(IN in2);
}
