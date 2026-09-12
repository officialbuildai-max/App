package mb;

import ic.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class z implements ic.b, ic.a {

    /* renamed from: c, reason: collision with root package name */
    private static final a.InterfaceC0817a f69627c = new a.InterfaceC0817a() { // from class: mb.w
        @Override // ic.a.InterfaceC0817a
        public final void a(ic.b bVar) {
            z.f(bVar);
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private static final ic.b f69628d = new ic.b() { // from class: mb.x
        @Override // ic.b
        public final Object get() {
            Object g11;
            g11 = z.g();
            return g11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private a.InterfaceC0817a f69629a;

    /* renamed from: b, reason: collision with root package name */
    private volatile ic.b f69630b;

    private z(a.InterfaceC0817a interfaceC0817a, ic.b bVar) {
        this.f69629a = interfaceC0817a;
        this.f69630b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static z e() {
        return new z(f69627c, f69628d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(ic.b bVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object g() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(a.InterfaceC0817a interfaceC0817a, a.InterfaceC0817a interfaceC0817a2, ic.b bVar) {
        interfaceC0817a.a(bVar);
        interfaceC0817a2.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static z i(ic.b bVar) {
        return new z(null, bVar);
    }

    @Override // ic.a
    public void a(final a.InterfaceC0817a interfaceC0817a) {
        ic.b bVar;
        ic.b bVar2;
        ic.b bVar3 = this.f69630b;
        ic.b bVar4 = f69628d;
        if (bVar3 != bVar4) {
            interfaceC0817a.a(bVar3);
            return;
        }
        synchronized (this) {
            bVar = this.f69630b;
            if (bVar != bVar4) {
                bVar2 = bVar;
            } else {
                final a.InterfaceC0817a interfaceC0817a2 = this.f69629a;
                this.f69629a = new a.InterfaceC0817a() { // from class: mb.y
                    @Override // ic.a.InterfaceC0817a
                    public final void a(ic.b bVar5) {
                        z.h(a.InterfaceC0817a.this, interfaceC0817a, bVar5);
                    }
                };
                bVar2 = null;
            }
        }
        if (bVar2 != null) {
            interfaceC0817a.a(bVar);
        }
    }

    @Override // ic.b
    public Object get() {
        return this.f69630b.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(ic.b bVar) {
        a.InterfaceC0817a interfaceC0817a;
        if (this.f69630b != f69628d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            interfaceC0817a = this.f69629a;
            this.f69629a = null;
            this.f69630b = bVar;
        }
        interfaceC0817a.a(bVar);
    }
}
