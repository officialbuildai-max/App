package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.util.m;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    private final e f27696a;

    /* renamed from: b, reason: collision with root package name */
    private final o f27697b;

    /* renamed from: c, reason: collision with root package name */
    private final b f27698c;

    /* renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArraySet f27699d;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayDeque f27700e;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayDeque f27701f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f27702g;

    /* loaded from: classes3.dex */
    public interface a {
        void invoke(Object obj);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(Object obj, m mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final Object f27703a;

        /* renamed from: b, reason: collision with root package name */
        private m.b f27704b = new m.b();

        /* renamed from: c, reason: collision with root package name */
        private boolean f27705c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f27706d;

        public c(Object obj) {
            this.f27703a = obj;
        }

        public void a(int i11, a aVar) {
            if (this.f27706d) {
                return;
            }
            if (i11 != -1) {
                this.f27704b.a(i11);
            }
            this.f27705c = true;
            aVar.invoke(this.f27703a);
        }

        public void b(b bVar) {
            if (this.f27706d || !this.f27705c) {
                return;
            }
            m e11 = this.f27704b.e();
            this.f27704b = new m.b();
            this.f27705c = false;
            bVar.a(this.f27703a, e11);
        }

        public void c(b bVar) {
            this.f27706d = true;
            if (this.f27705c) {
                bVar.a(this.f27703a, this.f27704b.e());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.f27703a.equals(((c) obj).f27703a);
        }

        public int hashCode() {
            return this.f27703a.hashCode();
        }
    }

    public r(Looper looper, e eVar, b bVar) {
        this(new CopyOnWriteArraySet(), looper, eVar, bVar);
    }

    private r(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, e eVar, b bVar) {
        this.f27696a = eVar;
        this.f27699d = copyOnWriteArraySet;
        this.f27698c = bVar;
        this.f27700e = new ArrayDeque();
        this.f27701f = new ArrayDeque();
        this.f27697b = eVar.createHandler(looper, new Handler.Callback() { // from class: com.google.android.exoplayer2.util.q
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean g11;
                g11 = r.this.g(message);
                return g11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(Message message) {
        Iterator it = this.f27699d.iterator();
        while (it.hasNext()) {
            ((c) it.next()).b(this.f27698c);
            if (this.f27697b.a(0)) {
                return true;
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

    public void c(Object obj) {
        if (this.f27702g) {
            return;
        }
        com.google.android.exoplayer2.util.a.e(obj);
        this.f27699d.add(new c(obj));
    }

    public r d(Looper looper, e eVar, b bVar) {
        return new r(this.f27699d, looper, eVar, bVar);
    }

    public r e(Looper looper, b bVar) {
        return d(looper, this.f27696a, bVar);
    }

    public void f() {
        if (this.f27701f.isEmpty()) {
            return;
        }
        if (!this.f27697b.a(0)) {
            o oVar = this.f27697b;
            oVar.b(oVar.obtainMessage(0));
        }
        boolean isEmpty = this.f27700e.isEmpty();
        this.f27700e.addAll(this.f27701f);
        this.f27701f.clear();
        if (isEmpty) {
            while (!this.f27700e.isEmpty()) {
                ((Runnable) this.f27700e.peekFirst()).run();
                this.f27700e.removeFirst();
            }
        }
    }

    public void i(final int i11, final a aVar) {
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f27699d);
        this.f27701f.add(new Runnable() { // from class: com.google.android.exoplayer2.util.p
            @Override // java.lang.Runnable
            public final void run() {
                r.h(copyOnWriteArraySet, i11, aVar);
            }
        });
    }

    public void j() {
        Iterator it = this.f27699d.iterator();
        while (it.hasNext()) {
            ((c) it.next()).c(this.f27698c);
        }
        this.f27699d.clear();
        this.f27702g = true;
    }

    public void k(Object obj) {
        Iterator it = this.f27699d.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.f27703a.equals(obj)) {
                cVar.c(this.f27698c);
                this.f27699d.remove(cVar);
            }
        }
    }

    public void l(int i11, a aVar) {
        i(i11, aVar);
        f();
    }
}
