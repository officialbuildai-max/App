package com.bykv.vk.openvk.preload.b;

import com.bykv.vk.openvk.preload.b.i;
import com.bykv.vk.openvk.preload.b.l;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class j<IN, OUT> extends l<IN, OUT> {

    /* renamed from: d, reason: collision with root package name */
    private String f20642d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bykv.vk.openvk.preload.b.d
    public final Object a(b<OUT> bVar, IN in2) throws Throwable {
        new m(bVar);
        this.f20642d = a((j<IN, OUT>) in2);
        l.a aVar = a().get(this.f20642d);
        while (aVar != null) {
            List<h> list = aVar.f20645a;
            try {
                Object a11 = c.a(list, bVar.f20638a, this).a((b) in2);
                return !l.a(list) ? a11 : bVar.a((b<OUT>) a11);
            } catch (i.a e11) {
                Throwable cause = e11.getCause();
                new m(bVar);
                this.f20642d = a(in2, cause, this.f20642d);
                aVar = a().get(this.f20642d);
            } catch (Throwable th2) {
                new m(bVar);
                this.f20642d = a(in2, th2, this.f20642d);
                aVar = a().get(this.f20642d);
            }
        }
        throw new IllegalArgumentException("can not found branch，branch name is：" + this.f20642d);
    }

    protected abstract String a(IN in2);

    protected abstract String a(IN in2, Throwable th2, String str);
}
