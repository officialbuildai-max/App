package com.cloud.hisavana.sdk.manager;

import com.cloud.hisavana.sdk.R0;
import com.cloud.hisavana.sdk.c1;
import com.cloud.hisavana.sdk.common.bean.DiskTrackingBean;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.manager.g;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class g {

    /* renamed from: d, reason: collision with root package name */
    public static final a f22800d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private static final g f22801e = new g();

    /* renamed from: a, reason: collision with root package name */
    private final String f22802a = "RetryTrackingManager";

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f22803b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private final int f22804c = 2;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final g a() {
            return g.f22801e;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class b {
        public abstract void a();
    }

    /* loaded from: classes3.dex */
    public static abstract class c {
        public abstract void a(String str);

        public abstract void b(String str, int i11);
    }

    /* loaded from: classes3.dex */
    public static final class d extends b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DiskTrackingBean f22805a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f22806b;

        d(DiskTrackingBean diskTrackingBean, g gVar) {
            this.f22805a = diskTrackingBean;
            this.f22806b = gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(g this$0, DiskTrackingBean diskTrackingBean) {
            Intrinsics.h(this$0, "this$0");
            this$0.l(diskTrackingBean.getNext());
        }

        @Override // com.cloud.hisavana.sdk.manager.g.b
        public void a() {
            if (this.f22805a.getNext() == null) {
                this.f22806b.f22803b.set(false);
                return;
            }
            HSScopeHelper hSScopeHelper = HSScopeHelper.f23249a;
            final g gVar = this.f22806b;
            final DiskTrackingBean diskTrackingBean = this.f22805a;
            hSScopeHelper.j(new Runnable() { // from class: com.cloud.hisavana.sdk.manager.h
                @Override // java.lang.Runnable
                public final void run() {
                    g.d.c(g.this, diskTrackingBean);
                }
            }, this.f22806b.f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long f() {
        return (new SecureRandom().nextLong() % 2000) + 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(g this$0) {
        Intrinsics.h(this$0, "this$0");
        List<DiskTrackingBean> m11 = R0.f21617e.a().m();
        if (m11 == null || m11.isEmpty()) {
            this$0.f22803b.set(false);
            return;
        }
        DiskTrackingBean diskTrackingBean = (DiskTrackingBean) m11.get(0);
        DiskTrackingBean diskTrackingBean2 = diskTrackingBean;
        for (DiskTrackingBean diskTrackingBean3 : m11) {
            if (!Intrinsics.c(diskTrackingBean2, diskTrackingBean3)) {
                diskTrackingBean2.setNext(diskTrackingBean3);
                diskTrackingBean2 = diskTrackingBean3;
            }
        }
        this$0.l(diskTrackingBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(DiskTrackingBean diskTrackingBean) {
        e4.b().d(this.f22802a, "tracking " + diskTrackingBean);
        if (diskTrackingBean == null) {
            return;
        }
        if (diskTrackingBean.getRetryTimes().get() >= this.f22804c) {
            j(diskTrackingBean);
            l(diskTrackingBean.getNext());
        } else if (NetStateManager.checkNetworkState(true)) {
            c1.g(diskTrackingBean, new d(diskTrackingBean, this));
        } else {
            this.f22803b.set(false);
            e4.b().d(this.f22802a, "tracking,net is not ok");
        }
    }

    public final void d(DiskTrackingBean diskTrackingBean) {
        if (diskTrackingBean != null) {
            diskTrackingBean.getRetryTimes().addAndGet(1);
            if (diskTrackingBean.getRetryTimes().get() >= this.f22804c) {
                j(diskTrackingBean);
            } else {
                R0.f21617e.a().l(diskTrackingBean);
            }
        }
    }

    public final void h(DiskTrackingBean diskTrackingBean) {
        String str;
        e4.b().d(this.f22802a, "addTrackingBean " + diskTrackingBean);
        R0.a aVar = R0.f21617e;
        aVar.a().k();
        R0 a11 = aVar.a();
        if (diskTrackingBean == null || (str = diskTrackingBean.getUuid()) == null) {
            str = "";
        }
        if (a11.h(str) == null) {
            aVar.a().j(diskTrackingBean);
        }
    }

    public final void i() {
        if (this.f22803b.get()) {
            e4.b().d(this.f22802a, "startRetryTracking,is retrying");
        } else {
            this.f22803b.set(true);
            HSScopeHelper.f23249a.i(new Runnable() { // from class: com.cloud.hisavana.sdk.manager.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.k(g.this);
                }
            });
        }
    }

    public final void j(DiskTrackingBean diskTrackingBean) {
        if (diskTrackingBean != null) {
            R0.f21617e.a().f(diskTrackingBean.getUuid());
        }
    }
}
