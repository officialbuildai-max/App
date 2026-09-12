package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.DiffUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class AsyncListDiffer {

    /* renamed from: h, reason: collision with root package name */
    private static final Executor f14161h = new b();

    /* renamed from: a, reason: collision with root package name */
    private final j f14162a;

    /* renamed from: b, reason: collision with root package name */
    final c f14163b;

    /* renamed from: c, reason: collision with root package name */
    Executor f14164c;

    /* renamed from: e, reason: collision with root package name */
    private List f14166e;

    /* renamed from: g, reason: collision with root package name */
    int f14168g;

    /* renamed from: d, reason: collision with root package name */
    private final List f14165d = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    private List f14167f = Collections.emptyList();

    /* loaded from: classes2.dex */
    public interface a {
        void a(List list, List list2);
    }

    /* loaded from: classes2.dex */
    private static class b implements Executor {

        /* renamed from: a, reason: collision with root package name */
        final Handler f14170a = new Handler(Looper.getMainLooper());

        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f14170a.post(runnable);
        }
    }

    public AsyncListDiffer(j jVar, c cVar) {
        this.f14162a = jVar;
        this.f14163b = cVar;
        if (cVar.c() != null) {
            this.f14164c = cVar.c();
        } else {
            this.f14164c = f14161h;
        }
    }

    private void d(List list, Runnable runnable) {
        Iterator it = this.f14165d.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(list, this.f14167f);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void a(a aVar) {
        this.f14165d.add(aVar);
    }

    public List b() {
        return this.f14167f;
    }

    void c(List list, DiffUtil.d dVar, Runnable runnable) {
        List list2 = this.f14167f;
        this.f14166e = list;
        this.f14167f = Collections.unmodifiableList(list);
        dVar.b(this.f14162a);
        d(list2, runnable);
    }

    public void e(List list) {
        f(list, null);
    }

    public void f(final List list, final Runnable runnable) {
        final int i11 = this.f14168g + 1;
        this.f14168g = i11;
        final List list2 = this.f14166e;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        List list3 = this.f14167f;
        if (list == null) {
            int size = list2.size();
            this.f14166e = null;
            this.f14167f = Collections.emptyList();
            this.f14162a.onRemoved(0, size);
            d(list3, runnable);
            return;
        }
        if (list2 != null) {
            this.f14163b.a().execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1

                /* renamed from: androidx.recyclerview.widget.AsyncListDiffer$1$a */
                /* loaded from: classes2.dex */
                class a extends DiffUtil.a {
                    a() {
                    }

                    @Override // androidx.recyclerview.widget.DiffUtil.a
                    public boolean a(int i11, int i12) {
                        Object obj = list2.get(i11);
                        Object obj2 = list.get(i12);
                        if (obj != null && obj2 != null) {
                            return AsyncListDiffer.this.f14163b.b().areContentsTheSame(obj, obj2);
                        }
                        if (obj == null && obj2 == null) {
                            return true;
                        }
                        throw new AssertionError();
                    }

                    @Override // androidx.recyclerview.widget.DiffUtil.a
                    public boolean b(int i11, int i12) {
                        Object obj = list2.get(i11);
                        Object obj2 = list.get(i12);
                        return (obj == null || obj2 == null) ? obj == null && obj2 == null : AsyncListDiffer.this.f14163b.b().areItemsTheSame(obj, obj2);
                    }

                    @Override // androidx.recyclerview.widget.DiffUtil.a
                    public Object c(int i11, int i12) {
                        Object obj = list2.get(i11);
                        Object obj2 = list.get(i12);
                        if (obj == null || obj2 == null) {
                            throw new AssertionError();
                        }
                        return AsyncListDiffer.this.f14163b.b().getChangePayload(obj, obj2);
                    }

                    @Override // androidx.recyclerview.widget.DiffUtil.a
                    public int d() {
                        return list.size();
                    }

                    @Override // androidx.recyclerview.widget.DiffUtil.a
                    public int e() {
                        return list2.size();
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    final DiffUtil.d b11 = DiffUtil.b(new a());
                    AsyncListDiffer.this.f14164c.execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                            if (asyncListDiffer.f14168g == i11) {
                                asyncListDiffer.c(list, b11, runnable);
                            }
                        }
                    });
                }
            });
            return;
        }
        this.f14166e = list;
        this.f14167f = Collections.unmodifiableList(list);
        this.f14162a.onInserted(0, list.size());
        d(list3, runnable);
    }
}
