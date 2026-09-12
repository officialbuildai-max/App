package com.mbridge.msdk.foundation.same.task;

import android.annotation.SuppressLint;
import android.content.Context;
import com.mbridge.msdk.foundation.same.task.a;
import com.mbridge.msdk.foundation.tools.q0;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    ThreadPoolExecutor f35688a;

    /* renamed from: b, reason: collision with root package name */
    HashMap<Long, com.mbridge.msdk.foundation.same.task.a> f35689b;

    /* renamed from: c, reason: collision with root package name */
    WeakReference<Context> f35690c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements a.InterfaceC0493a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.foundation.same.task.a f35691a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a.InterfaceC0493a f35692b;

        a(com.mbridge.msdk.foundation.same.task.a aVar, a.InterfaceC0493a interfaceC0493a) {
            this.f35691a = aVar;
            this.f35692b = interfaceC0493a;
        }

        @Override // com.mbridge.msdk.foundation.same.task.a.InterfaceC0493a
        public void a(a.b bVar) {
            if (bVar == a.b.CANCEL) {
                b.this.f35689b.remove(Long.valueOf(this.f35691a.getId()));
            } else if (bVar == a.b.FINISH) {
                b.this.f35689b.remove(Long.valueOf(this.f35691a.getId()));
            } else if (bVar == a.b.RUNNING && b.this.f35690c.get() == null) {
                b.this.a();
            }
            a.InterfaceC0493a interfaceC0493a = this.f35692b;
            if (interfaceC0493a != null) {
                interfaceC0493a.a(bVar);
            }
        }
    }

    @SuppressLint({"UseSparseArrays"})
    public b(Context context) {
        if (q0.a().a("c_t_l_t_p", true)) {
            this.f35688a = c.b();
        } else {
            if (q0.a().a("c_t_p_t_l", true)) {
                int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
                this.f35688a = new ThreadPoolExecutor(availableProcessors, availableProcessors, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            } else {
                this.f35688a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            }
            this.f35688a.allowCoreThreadTimeOut(true);
        }
        this.f35689b = new HashMap<>();
        this.f35690c = new WeakReference<>(context);
    }

    @SuppressLint({"UseSparseArrays"})
    public b(Context context, int i11) {
        if (q0.a().a("c_t_l_t_p", true)) {
            this.f35688a = c.b();
        } else {
            if (i11 == 0) {
                this.f35688a = new ThreadPoolExecutor(1, 5, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            } else {
                this.f35688a = new ThreadPoolExecutor(i11, (i11 * 2) + 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            }
            this.f35688a.allowCoreThreadTimeOut(true);
        }
        this.f35689b = new HashMap<>();
        this.f35690c = new WeakReference<>(context);
    }

    private synchronized void a(com.mbridge.msdk.foundation.same.task.a aVar, a.InterfaceC0493a interfaceC0493a) {
        this.f35689b.put(Long.valueOf(aVar.getId()), aVar);
        aVar.setOnStateChangeListener(new a(aVar, interfaceC0493a));
    }

    public synchronized void a() {
        try {
            Iterator<Map.Entry<Long, com.mbridge.msdk.foundation.same.task.a>> it = this.f35689b.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().cancel();
            }
            this.f35689b.clear();
        } catch (Exception unused) {
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void a(com.mbridge.msdk.foundation.same.task.a aVar) {
        a(aVar, null);
        this.f35688a.execute(aVar);
    }

    public void b(com.mbridge.msdk.foundation.same.task.a aVar, a.InterfaceC0493a interfaceC0493a) {
        a(aVar, interfaceC0493a);
        this.f35688a.execute(aVar);
    }
}
