package cf;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    private d f17295a;

    /* renamed from: b, reason: collision with root package name */
    private d f17296b;

    public final void a(d task) {
        Intrinsics.h(task, "task");
        if (this.f17295a == null) {
            this.f17295a = task;
        }
        d dVar = this.f17296b;
        if (dVar != null) {
            dVar.f17229c = task;
        }
        this.f17296b = task;
    }

    public final void b() {
        d dVar = this.f17295a;
        if (dVar != null) {
            dVar.request();
        }
    }
}
