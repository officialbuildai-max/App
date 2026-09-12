package yf;

import a.TheRouterServiceProvideInjecter;
import android.content.Context;
import com.therouter.TheRouterKt;
import com.therouter.TheRouterThreadPool;
import com.therouter.inject.DebugOnlyKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f79123e;

    /* renamed from: a, reason: collision with root package name */
    private final HashMap f79119a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap f79120b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final CopyOnWriteArrayList f79121c = new CopyOnWriteArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArrayList f79122d = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final List f79124f = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(b this$0) {
        Intrinsics.h(this$0, "this$0");
        TheRouterKt.f("init", "TheRouter.init() method do @FlowTask init", null, 4, null);
        this$0.j();
        TheRouterKt.f("init", "TheRouter.init() method do @FlowTask schedule", null, 4, null);
        f.a();
    }

    private final void f(d dVar) {
        boolean d11;
        String c11;
        if (dVar.e()) {
            return;
        }
        Set g11 = g(dVar);
        d11 = c.d(g11);
        if (!d11) {
            if (this.f79121c.contains(dVar)) {
                return;
            }
            this.f79121c.add(dVar);
        } else {
            if (this.f79124f.contains(dVar)) {
                c11 = c.c(this.f79124f, dVar);
                throw new IllegalArgumentException("TheRouter::Digraph::Cyclic dependency " + c11);
            }
            this.f79124f.add(dVar);
            Iterator it = g11.iterator();
            while (it.hasNext()) {
                f((d) it.next());
            }
            this.f79124f.remove(dVar);
            if (this.f79121c.contains(dVar)) {
                return;
            }
            this.f79121c.add(dVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final e k(String str) {
        e eVar;
        int hashCode = str.hashCode();
        if (hashCode != -570693157) {
            if (hashCode != -136502702) {
                if (hashCode == 1312134309 && str.equals("TheRouter_Initialization")) {
                    return new e("TheRouter_Initialization", "TheRouter_Before_Initialization");
                }
            } else if (str.equals("TheRouter_activity_splash")) {
                return new e("TheRouter_activity_splash", "TheRouter_Initialization");
            }
        } else if (str.equals("TheRouter_Before_Initialization")) {
            eVar = new e(str, null, 2, 0 == true ? 1 : 0);
            return eVar;
        }
        eVar = new e(str, "TheRouter_Initialization");
        return eVar;
    }

    public final boolean b(Runnable r11) {
        Intrinsics.h(r11, "r");
        return this.f79122d.add(r11);
    }

    public final void c(Context context) {
        TheRouterServiceProvideInjecter.a(context, this);
        TheRouterKt.f("init", "TheRouter.init() method do @FlowTask before task", null, 4, null);
        if (!TheRouterServiceProvideInjecter.asm) {
            DebugOnlyKt.a(context);
            if (context != null) {
                Iterator it = DebugOnlyKt.d().iterator();
                while (it.hasNext()) {
                    ((com.therouter.inject.b) it.next()).initFlowTask(context, this);
                }
            }
        }
        e();
        TheRouterThreadPool.f(new Runnable() { // from class: yf.a
            @Override // java.lang.Runnable
            public final void run() {
                b.d(b.this);
            }
        });
    }

    public final void e() {
        e i11 = i("TheRouter_Before_Initialization");
        this.f79120b.put("TheRouter_Before_Initialization", i11);
        i11.g();
        Collection<d> values = this.f79119a.values();
        Intrinsics.g(values, "<get-values>(...)");
        for (d dVar : values) {
            if (!dVar.a() && dVar.b().size() == 1 && dVar.b().contains("TheRouter_Before_Initialization")) {
                dVar.g();
            }
        }
    }

    public final Set g(d root) {
        Intrinsics.h(root, "root");
        HashSet hashSet = new HashSet();
        Iterator it = root.b().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            d dVar = (d) this.f79119a.get(str);
            if (dVar == null) {
                HashMap hashMap = this.f79120b;
                Intrinsics.e(str);
                hashMap.put(str, k(str));
            } else {
                hashSet.add(dVar);
            }
        }
        return hashSet;
    }

    public final boolean h() {
        return this.f79123e;
    }

    public final e i(String name) {
        Intrinsics.h(name, "name");
        e eVar = (e) this.f79120b.get(name);
        if (eVar == null) {
            eVar = k(name);
            this.f79120b.put(name, eVar);
        }
        Intrinsics.e(eVar);
        return eVar;
    }

    public final void j() {
        for (d dVar : this.f79119a.values()) {
            Intrinsics.e(dVar);
            f(dVar);
        }
        this.f79123e = true;
        Iterator it = this.f79122d.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    public final void l(String name) {
        Intrinsics.h(name, "name");
        Collection<e> values = this.f79120b.values();
        Intrinsics.g(values, "<get-values>(...)");
        for (e eVar : values) {
            if (eVar.b().contains(name)) {
                eVar.j();
            }
        }
    }

    public final void m() {
        Iterator it = this.f79121c.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f()) {
                boolean z10 = true;
                for (String str : dVar.b()) {
                    d dVar2 = (d) this.f79119a.get(str);
                    if (dVar2 == null) {
                        dVar2 = (d) this.f79120b.get(str);
                    }
                    if (dVar2 != null && !dVar2.e()) {
                        z10 = false;
                    }
                }
                if (z10) {
                    dVar.g();
                }
            }
        }
    }
}
