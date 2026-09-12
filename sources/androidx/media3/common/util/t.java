package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.p;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private final i f10529a;

    /* renamed from: b, reason: collision with root package name */
    private final p f10530b;

    /* renamed from: c, reason: collision with root package name */
    private final b f10531c;

    /* renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArraySet f10532d;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayDeque f10533e;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayDeque f10534f;

    /* renamed from: g, reason: collision with root package name */
    private final Object f10535g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f10536h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f10537i;

    /* loaded from: classes2.dex */
    public interface a {
        void invoke(Object obj);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(Object obj, androidx.media3.common.p pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final Object f10538a;

        /* renamed from: b, reason: collision with root package name */
        private p.b f10539b = new p.b();

        /* renamed from: c, reason: collision with root package name */
        private boolean f10540c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f10541d;

        public c(Object obj) {
            this.f10538a = obj;
        }

        public void a(int i11, a aVar) {
            if (this.f10541d) {
                return;
            }
            if (i11 != -1) {
                this.f10539b.a(i11);
            }
            this.f10540c = true;
            aVar.invoke(this.f10538a);
        }

        public void b(b bVar) {
            if (this.f10541d || !this.f10540c) {
                return;
            }
            androidx.media3.common.p e11 = this.f10539b.e();
            this.f10539b = new p.b();
            this.f10540c = false;
            bVar.a(this.f10538a, e11);
        }

        public void c(b bVar) {
            this.f10541d = true;
            if (this.f10540c) {
                this.f10540c = false;
                bVar.a(this.f10538a, this.f10539b.e());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.f10538a.equals(((c) obj).f10538a);
        }

        public int hashCode() {
            return this.f10538a.hashCode();
        }
    }

    public t(Looper looper, i iVar, b bVar) {
        this(new CopyOnWriteArraySet(), looper, iVar, bVar, true);
    }

    private t(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, i iVar, b bVar, boolean z10) {
        this.f10529a = iVar;
        this.f10532d = copyOnWriteArraySet;
        this.f10531c = bVar;
        this.f10535g = new Object();
        this.f10533e = new ArrayDeque();
        this.f10534f = new ArrayDeque();
        this.f10530b = iVar.createHandler(looper, new Handler.Callback() { // from class: androidx.media3.common.util.r
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean g11;
                g11 = t.this.g(message);
                return g11;
            }
        });
        this.f10537i = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(Message message) {
        Iterator it = this.f10532d.iterator();
        while (it.hasNext()) {
            ((c) it.next()).b(this.f10531c);
            if (this.f10530b.a(1)) {
                break;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(CopyOnWriteArraySet copyOnWriteArraySet, int i11, a aVar) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(i11, aVar);
        }
    }

    private void m() {
        if (this.f10537i) {
            androidx.media3.common.util.a.g(Thread.currentThread() == this.f10530b.getLooper().getThread());
        }
    }

    public void c(Object obj) {
        androidx.media3.common.util.a.e(obj);
        synchronized (this.f10535g) {
            try {
                if (this.f10536h) {
                    return;
                }
                this.f10532d.add(new c(obj));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public t d(Looper looper, i iVar, b bVar) {
        return new t(this.f10532d, looper, iVar, bVar, this.f10537i);
    }

    public t e(Looper looper, b bVar) {
        return d(looper, this.f10529a, bVar);
    }

    public void f() {
        m();
        if (this.f10534f.isEmpty()) {
            return;
        }
        if (!this.f10530b.a(1)) {
            p pVar = this.f10530b;
            pVar.b(pVar.obtainMessage(1));
        }
        boolean isEmpty = this.f10533e.isEmpty();
        this.f10533e.addAll(this.f10534f);
        this.f10534f.clear();
        if (isEmpty) {
            while (!this.f10533e.isEmpty()) {
                ((Runnable) this.f10533e.peekFirst()).run();
                this.f10533e.removeFirst();
            }
        }
    }

    public void i(final int i11, final a aVar) {
        m();
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f10532d);
        this.f10534f.add(new Runnable() { // from class: androidx.media3.common.util.s
            @Override // java.lang.Runnable
            public final void run() {
                t.h(copyOnWriteArraySet, i11, aVar);
            }
        });
    }

    public void j() {
        m();
        synchronized (this.f10535g) {
            this.f10536h = true;
        }
        Iterator it = this.f10532d.iterator();
        while (it.hasNext()) {
            ((c) it.next()).c(this.f10531c);
        }
        this.f10532d.clear();
    }

    public void k(Object obj) {
        m();
        Iterator it = this.f10532d.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.f10538a.equals(obj)) {
                cVar.c(this.f10531c);
                this.f10532d.remove(cVar);
            }
        }
    }

    public void l(int i11, a aVar) {
        i(i11, aVar);
        f();
    }
}
