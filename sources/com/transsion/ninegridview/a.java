package com.transsion.ninegridview;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.recyclerview.widget.RecyclerView;
import com.aliyun.player.bean.ErrorCode;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.player.config.RenderType;
import com.transsion.player.orplayer.g;
import com.transsion.player.p007enum.ScaleMode;
import com.transsion.player.ui.ORPlayerView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import nh.m;
import nh.n;
import pn.d;

/* loaded from: classes6.dex */
public final class a implements d {

    /* renamed from: h, reason: collision with root package name */
    public static final C0637a f47724h = new C0637a(null);

    /* renamed from: i, reason: collision with root package name */
    private static final bo.d f47725i = new bo.d(RenderType.TEXTURE_VIEW, false, 0, 1000, 1000, 200, 10, 0, 0, 0, 0, false, false, false, false, false, null, 130950, null);

    /* renamed from: a, reason: collision with root package name */
    private g f47726a;

    /* renamed from: b, reason: collision with root package name */
    private qn.a f47727b;

    /* renamed from: c, reason: collision with root package name */
    private pn.c f47728c;

    /* renamed from: d, reason: collision with root package name */
    private n f47729d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f47730e;

    /* renamed from: f, reason: collision with root package name */
    private pn.a f47731f;

    /* renamed from: g, reason: collision with root package name */
    private Context f47732g;

    /* renamed from: com.transsion.ninegridview.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0637a {
        private C0637a() {
        }

        public /* synthetic */ C0637a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final bo.d a() {
            return a.f47725i;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements n {
        b() {
        }

        @Override // nh.n
        public void onConnected() {
            n.a.a(this);
        }

        @Override // nh.n
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            pn.a aVar = a.this.f47731f;
            if (aVar != null) {
                int a11 = aVar.a();
                a aVar2 = a.this;
                if (aVar2.f47730e && a11 == ErrorCode.ERROR_LOADING_TIMEOUT.getValue()) {
                    qn.a g11 = aVar2.g();
                    if (g11 != null) {
                        g11.w();
                    }
                    aVar2.f47730e = false;
                }
            }
        }

        @Override // nh.n
        public void onDisconnected() {
            a.this.f47730e = true;
        }
    }

    @Override // pn.d
    public void a() {
        Context context = this.f47732g;
        if (context != null) {
            j(context);
        }
    }

    public final void f() {
        g gVar = this.f47726a;
        if (gVar != null) {
            gVar.release();
        }
        this.f47726a = null;
        qn.a aVar = this.f47727b;
        if (aVar != null) {
            aVar.a();
        }
        this.f47727b = null;
        pn.c cVar = this.f47728c;
        if (cVar != null) {
            cVar.e();
        }
        this.f47728c = null;
        m.f70597a.m(this.f47729d);
        this.f47729d = null;
    }

    public final qn.a g() {
        return this.f47727b;
    }

    public final void h() {
        if (this.f47728c == null) {
            this.f47728c = new pn.c();
        }
        pn.c cVar = this.f47728c;
        if (cVar != null) {
            cVar.e();
        }
    }

    public final void i() {
        if (this.f47729d == null) {
            b bVar = new b();
            this.f47729d = bVar;
            m.f70597a.l(bVar);
        }
    }

    public final void j(Context context) {
        Intrinsics.h(context, "context");
        if (this.f47726a == null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.g(applicationContext, "getApplicationContext(...)");
            ORPlayerView oRPlayerView = new ORPlayerView(applicationContext, RenderType.TEXTURE_VIEW);
            Context applicationContext2 = context.getApplicationContext();
            Intrinsics.g(applicationContext2, "getApplicationContext(...)");
            g a11 = new g.a(applicationContext2).a();
            a11.setPlayerConfig(f47725i);
            a11.setTextureView(oRPlayerView.getTextureView());
            a11.setScaleMode(ScaleMode.SCALE_ASPECT_FILL);
            a11.setMute(true);
            this.f47727b = new qn.a(a11, oRPlayerView);
            pn.a aVar = new pn.a();
            aVar.b(this.f47727b);
            a11.setPlayerListener(aVar);
            this.f47731f = aVar;
            this.f47726a = a11;
            pn.c cVar = this.f47728c;
            if (cVar != null) {
                cVar.k(this.f47727b);
            }
            i();
            a.C0856a.f(lg.a.f68962a, "GifPlayerManager", "initPlayer", false, 4, null);
        }
    }

    public final void k() {
        g gVar = this.f47726a;
        if (gVar != null) {
            gVar.pause();
        }
    }

    public final void l() {
        g gVar = this.f47726a;
        if (gVar != null) {
            gVar.play();
        }
    }

    public final void m() {
        qn.a aVar = this.f47727b;
        if (aVar != null) {
            aVar.x(-1);
        }
    }

    public final void n(RecyclerView recyclerView, BaseQuickAdapter baseQuickAdapter) {
        Intrinsics.h(recyclerView, "recyclerView");
        this.f47732g = recyclerView.getContext();
        h();
        pn.c cVar = this.f47728c;
        if (cVar != null) {
            cVar.j(baseQuickAdapter);
            recyclerView.addOnScrollListener(cVar);
        }
        pn.c cVar2 = this.f47728c;
        if (cVar2 != null) {
            cVar2.l(this);
        }
    }
}
