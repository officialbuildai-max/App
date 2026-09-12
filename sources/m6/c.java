package m6;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.j;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final BaseQuickAdapter f69447a;

    /* renamed from: b, reason: collision with root package name */
    private final d f69448b;

    /* renamed from: c, reason: collision with root package name */
    private final j f69449c;

    /* renamed from: d, reason: collision with root package name */
    private Executor f69450d;

    /* renamed from: e, reason: collision with root package name */
    private final Executor f69451e;

    /* renamed from: f, reason: collision with root package name */
    private final List f69452f;

    /* renamed from: g, reason: collision with root package name */
    private int f69453g;

    /* loaded from: classes3.dex */
    private static final class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f69454a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            Intrinsics.h(command, "command");
            this.f69454a.post(command);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends DiffUtil.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f69455a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f69456b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f69457c;

        b(List list, List list2, c cVar) {
            this.f69455a = list;
            this.f69456b = list2;
            this.f69457c = cVar;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.a
        public boolean a(int i11, int i12) {
            Object obj = this.f69455a.get(i11);
            Object obj2 = this.f69456b.get(i12);
            if (obj != null && obj2 != null) {
                return this.f69457c.f69448b.b().areContentsTheSame(obj, obj2);
            }
            if (obj == null && obj2 == null) {
                return true;
            }
            throw new AssertionError();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.a
        public boolean b(int i11, int i12) {
            Object obj = this.f69455a.get(i11);
            Object obj2 = this.f69456b.get(i12);
            return (obj == null || obj2 == null) ? obj == null && obj2 == null : this.f69457c.f69448b.b().areItemsTheSame(obj, obj2);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.a
        public Object c(int i11, int i12) {
            Object obj = this.f69455a.get(i11);
            Object obj2 = this.f69456b.get(i12);
            if (obj == null || obj2 == null) {
                throw new AssertionError();
            }
            return this.f69457c.f69448b.b().getChangePayload(obj, obj2);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.a
        public int d() {
            return this.f69456b.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.a
        public int e() {
            return this.f69455a.size();
        }
    }

    public c(BaseQuickAdapter adapter, d config) {
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(config, "config");
        this.f69447a = adapter;
        this.f69448b = config;
        this.f69449c = new e(adapter);
        Executor aVar = new a();
        this.f69451e = aVar;
        Executor c11 = config.c();
        this.f69450d = c11 != null ? c11 : aVar;
        this.f69452f = new CopyOnWriteArrayList();
    }

    private final void d(List list, DiffUtil.d dVar, Runnable runnable) {
        List<Object> data = this.f69447a.getData();
        this.f69447a.Q0(list);
        dVar.b(this.f69449c);
        e(data, runnable);
    }

    private final void e(List list, Runnable runnable) {
        Iterator it = this.f69452f.iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.c.a(it.next());
            this.f69447a.getData();
            throw null;
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final c this$0, List oldList, final List list, final int i11, final Runnable runnable) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(oldList, "$oldList");
        final DiffUtil.d b11 = DiffUtil.b(new b(oldList, list, this$0));
        Intrinsics.g(b11, "@JvmOverloads\n    fun su…        }\n        }\n    }");
        this$0.f69450d.execute(new Runnable() { // from class: m6.b
            @Override // java.lang.Runnable
            public final void run() {
                c.h(c.this, i11, list, b11, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(c this$0, int i11, List list, DiffUtil.d result, Runnable runnable) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(result, "$result");
        if (this$0.f69453g == i11) {
            this$0.d(list, result, runnable);
        }
    }

    public final void f(final List list, final Runnable runnable) {
        final int i11 = this.f69453g + 1;
        this.f69453g = i11;
        if (list == this.f69447a.getData()) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        final List<Object> data = this.f69447a.getData();
        if (list == null) {
            int size = this.f69447a.getData().size();
            this.f69447a.Q0(new ArrayList());
            this.f69449c.onRemoved(0, size);
            e(data, runnable);
            return;
        }
        if (!this.f69447a.getData().isEmpty()) {
            this.f69448b.a().execute(new Runnable() { // from class: m6.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.g(c.this, data, list, i11, runnable);
                }
            });
            return;
        }
        this.f69447a.Q0(list);
        this.f69449c.onInserted(0, list.size());
        e(data, runnable);
    }
}
