package com.transsion.room.viewmodel;

import android.app.Application;
import android.content.Context;
import android.location.Address;
import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.moviedetailapi.bean.RoomBean;
import com.transsion.moviedetailapi.bean.RoomTabBean;
import java.io.InputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.y0;
import okio.Okio;

/* loaded from: classes6.dex */
public final class RoomViewModel extends androidx.view.b {

    /* renamed from: l */
    public static final a f51888l = new a(null);

    /* renamed from: b */
    private final Lazy f51889b;

    /* renamed from: c */
    private final Lazy f51890c;

    /* renamed from: d */
    private final b0 f51891d;

    /* renamed from: e */
    private final b0 f51892e;

    /* renamed from: f */
    private final Lazy f51893f;

    /* renamed from: g */
    private final b0 f51894g;

    /* renamed from: h */
    private final b0 f51895h;

    /* renamed from: i */
    private final b0 f51896i;

    /* renamed from: j */
    private final b0 f51897j;

    /* renamed from: k */
    private final Lazy f51898k;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends sg.a {
        b() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            RoomViewModel.this.y().q(null);
        }

        @Override // sg.a
        /* renamed from: e */
        public void c(RoomBean roomBean) {
            RoomViewModel.this.y().q(roomBean);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends sg.a {
        c() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            RoomViewModel.this.D().q(null);
        }

        @Override // sg.a
        /* renamed from: e */
        public void c(RoomBean roomBean) {
            RoomViewModel.this.D().q(roomBean);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f51889b = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 L;
                L = RoomViewModel.L();
                return L;
            }
        });
        this.f51890c = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                b0 O;
                O = RoomViewModel.O();
                return O;
            }
        });
        this.f51891d = new b0();
        this.f51892e = new b0();
        this.f51893f = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                mq.a r11;
                r11 = RoomViewModel.r();
                return r11;
            }
        });
        this.f51894g = new b0();
        this.f51895h = new b0();
        this.f51896i = new b0();
        this.f51897j = new b0();
        this.f51898k = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                eq.a Q;
                Q = RoomViewModel.Q();
                return Q;
            }
        });
    }

    public final b0 D() {
        return (b0) this.f51890c.getValue();
    }

    public final eq.a K() {
        return (eq.a) this.f51898k.getValue();
    }

    public static final b0 L() {
        return new b0();
    }

    public final String M() {
        try {
            InputStream open = Utils.a().getAssets().open("room_top_tab.json");
            Intrinsics.e(open);
            return Okio.buffer(Okio.source(open)).readUtf8();
        } catch (Exception unused) {
            return null;
        }
    }

    private final void N() {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new RoomViewModel$loadRoomTabCache$1(this, null), 2, null);
    }

    public static final b0 O() {
        return new b0();
    }

    public final void P(RoomTabBean roomTabBean) {
        try {
            Result.Companion companion = Result.INSTANCE;
            com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
            bVar.b().putString("k_room_tab_cache_version", roomTabBean.getVersion());
            Result.m1185constructorimpl(bVar.b().putString("k_room_tab_cache", com.blankj.utilcode.util.o.j(roomTabBean)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public static final eq.a Q() {
        return (eq.a) zg.c.f79537e.a().h(eq.a.class);
    }

    public static final mq.a r() {
        return new mq.a();
    }

    public final mq.a s() {
        return (mq.a) this.f51893f.getValue();
    }

    public static /* synthetic */ void u(RoomViewModel roomViewModel, Context context, String str, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            str = "1";
        }
        if ((i12 & 4) != 0) {
            i11 = 16;
        }
        roomViewModel.t(context, str, i11);
    }

    public final b0 y() {
        return (b0) this.f51889b.getValue();
    }

    public final b0 A() {
        return this.f51892e;
    }

    public final void B(String page, int i11, String str) {
        Intrinsics.h(page, "page");
        if (str != null) {
            K().o(vg.a.f77447a.a(), page, i11, str).f(sg.d.f75472a.c()).subscribe(new c());
        }
    }

    public final LiveData C() {
        return D();
    }

    public final void E() {
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RoomViewModel$getRoomFilterTabList$1(this, null), 3, null);
    }

    public final void F(boolean z10, int i11, String page, int i12, Double d11, Double d12, Address address) {
        Intrinsics.h(page, "page");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RoomViewModel$getRoomList$1(d12, d11, address, page, i12, i11, this, z10, null), 3, null);
    }

    public final b0 G() {
        return this.f51891d;
    }

    public final void H() {
        N();
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RoomViewModel$getRoomTabs$1(this, null), 3, null);
    }

    public final b0 I() {
        return this.f51895h;
    }

    public final b0 J() {
        return this.f51896i;
    }

    public final void t(Context context, String page, int i11) {
        Intrinsics.h(context, "context");
        Intrinsics.h(page, "page");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RoomViewModel$getCommunityRooms$1(this, context, page, i11, null), 3, null);
    }

    public final b0 v() {
        return this.f51897j;
    }

    public final void w(String page, int i11) {
        Intrinsics.h(page, "page");
        K().f(vg.a.f77447a.a(), page, i11).f(sg.d.f75472a.c()).subscribe(new b());
    }

    public final LiveData x() {
        return y();
    }

    public final void z(boolean z10, String str, int i11, String str2) {
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RoomViewModel$getMyRooms$1(this, str, i11, str2, z10, null), 3, null);
    }
}
