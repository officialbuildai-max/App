package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f14431a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f14432b;

    /* renamed from: c, reason: collision with root package name */
    private final DiffUtil.e f14433c;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: d, reason: collision with root package name */
        private static final Object f14434d = new Object();

        /* renamed from: e, reason: collision with root package name */
        private static Executor f14435e;

        /* renamed from: a, reason: collision with root package name */
        private Executor f14436a;

        /* renamed from: b, reason: collision with root package name */
        private Executor f14437b;

        /* renamed from: c, reason: collision with root package name */
        private final DiffUtil.e f14438c;

        public a(DiffUtil.e eVar) {
            this.f14438c = eVar;
        }

        public c a() {
            if (this.f14437b == null) {
                synchronized (f14434d) {
                    try {
                        if (f14435e == null) {
                            f14435e = Executors.newFixedThreadPool(2);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                this.f14437b = f14435e;
            }
            return new c(this.f14436a, this.f14437b, this.f14438c);
        }
    }

    c(Executor executor, Executor executor2, DiffUtil.e eVar) {
        this.f14431a = executor;
        this.f14432b = executor2;
        this.f14433c = eVar;
    }

    public Executor a() {
        return this.f14432b;
    }

    public DiffUtil.e b() {
        return this.f14433c;
    }

    public Executor c() {
        return this.f14431a;
    }
}
