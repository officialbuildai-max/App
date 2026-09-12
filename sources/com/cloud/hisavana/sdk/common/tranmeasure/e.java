package com.cloud.hisavana.sdk.common.tranmeasure;

import android.view.View;
import com.cloud.hisavana.sdk.common.tranmeasure.d;
import com.cloud.hisavana.sdk.e4;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList f22202a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final int f22203b = 10;

    /* loaded from: classes3.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f22204a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f22205b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.b f22206c;

        a(Object obj, View view, d.b bVar) {
            this.f22204a = obj;
            this.f22205b = view;
            this.f22206c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.c().b(this.f22204a).b(this.f22205b, this.f22206c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final e f22208a = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d b(Object obj) {
        Iterator it = this.f22202a.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar != null && dVar.d(obj)) {
                e4.b().d("ssp_measure", "MeasureSessionManager have existed session");
                return dVar;
            }
        }
        e4.b().d("ssp_measure", "MeasureSession create new session");
        return new d(obj);
    }

    public static e c() {
        return b.f22208a;
    }

    private boolean h() {
        return this.f22202a.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(d dVar) {
        e4.b().d("ssp_measure", "registerSession(注册一个 需要监控的 Session)");
        if (dVar == null || this.f22202a.contains(dVar)) {
            return;
        }
        this.f22202a.add(dVar);
        if (this.f22202a.size() > 10) {
            this.f22202a.remove(0);
        }
        if (h()) {
            Monitor.getInstance().start();
        }
    }

    public void e(Object obj, View view, d.b bVar) {
        if (obj == null || view == null || bVar == null) {
            e4.b().e("ssp_measure", "registerView: key or adView or listener is null");
        } else {
            HSScopeHelper.f23249a.e(new a(obj, view, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(d dVar) {
        e4.b().d("ssp_measure", "unregisterSession(注销监控)");
        if (dVar != null) {
            this.f22202a.remove(dVar);
        }
        if (h()) {
            return;
        }
        Monitor.getInstance().end();
    }

    public void g(Object obj) {
        if (obj == null) {
            return;
        }
        Iterator it = this.f22202a.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar != null && dVar.d(obj)) {
                e4.b().d("ssp_measure", "got existed session");
                dVar.a();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        Iterator it = this.f22202a.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar != null) {
                dVar.j();
            }
        }
    }
}
