package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenerCallQueue;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final ListenerCallQueue.a f31064a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final ListenerCallQueue.a f31065b = new C0418b();

    /* renamed from: c, reason: collision with root package name */
    private static final ListenerCallQueue.a f31066c;

    /* renamed from: d, reason: collision with root package name */
    private static final ListenerCallQueue.a f31067d;

    /* renamed from: e, reason: collision with root package name */
    private static final ListenerCallQueue.a f31068e;

    /* renamed from: f, reason: collision with root package name */
    private static final ListenerCallQueue.a f31069f;

    /* renamed from: g, reason: collision with root package name */
    private static final ListenerCallQueue.a f31070g;

    /* renamed from: h, reason: collision with root package name */
    private static final ListenerCallQueue.a f31071h;

    /* loaded from: classes4.dex */
    class a implements ListenerCallQueue.a {
        a() {
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(x xVar) {
            xVar.b();
        }

        public String toString() {
            return "starting()";
        }
    }

    /* renamed from: com.google.common.util.concurrent.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0418b implements ListenerCallQueue.a {
        C0418b() {
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(x xVar) {
            xVar.a();
        }

        public String toString() {
            return "running()";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements ListenerCallQueue.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Service$State f31072a;

        c(Service$State service$State) {
            this.f31072a = service$State;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(x xVar) {
            xVar.d(this.f31072a);
        }

        public String toString() {
            return "terminated({from = " + this.f31072a + "})";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d implements ListenerCallQueue.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Service$State f31073a;

        d(Service$State service$State) {
            this.f31073a = service$State;
        }

        @Override // com.google.common.util.concurrent.ListenerCallQueue.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(x xVar) {
            xVar.c(this.f31073a);
        }

        public String toString() {
            return "stopping({from = " + this.f31073a + "})";
        }
    }

    static {
        Service$State service$State = Service$State.STARTING;
        f31066c = a(service$State);
        Service$State service$State2 = Service$State.RUNNING;
        f31067d = a(service$State2);
        f31068e = b(Service$State.NEW);
        f31069f = b(service$State);
        f31070g = b(service$State2);
        f31071h = b(Service$State.STOPPING);
    }

    private static ListenerCallQueue.a a(Service$State service$State) {
        return new d(service$State);
    }

    private static ListenerCallQueue.a b(Service$State service$State) {
        return new c(service$State);
    }
}
