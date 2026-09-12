package com.transsion.room.viewmodel;

import android.app.Application;
import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.moviedetailapi.bean.RoomNet;
import com.transsion.room.R$string;
import com.transsion.room.bean.CheckInEntity;
import eq.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: classes6.dex */
public final class RoomDetailViewModel extends t0 {

    /* renamed from: f, reason: collision with root package name */
    public static final a f51870f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f51871a = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.room.viewmodel.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            eq.a D;
            D = RoomDetailViewModel.D();
            return D;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f51872b = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            rj.a A;
            A = RoomDetailViewModel.A();
            return A;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f51873c = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 B;
            B = RoomDetailViewModel.B();
            return B;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f51874d = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 y10;
            y10 = RoomDetailViewModel.y();
            return y10;
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f51875e = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.i
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 z10;
            z10 = RoomDetailViewModel.z();
            return z10;
        }
    });

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
            RoomDetailViewModel.this.r().q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomItem roomItem) {
            RoomDetailViewModel.this.r().q(roomItem);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends sg.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f51877d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RoomDetailViewModel f51878e;

        c(String str, RoomDetailViewModel roomDetailViewModel) {
            this.f51877d = str;
            this.f51878e = roomDetailViewModel;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            this.f51878e.m().q(null);
            uh.b.f76876a.d(R$string.join_room_fail);
            a.C0856a.f(lg.a.f68962a, "RoomModel", "onFailure message.." + str2, false, 4, null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomNet roomNet) {
            uh.b.f76876a.d(R$string.join_room_success);
            ty.b.f76540a.a().f(1, this.f51877d);
            this.f51878e.m().q(new RoomNet(NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS));
            a.C0856a.f(lg.a.f68962a, "RoomModel", "onSuccess groupId.." + (roomNet != null ? roomNet.getGroupId() : null), false, 4, null);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends sg.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f51879d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RoomDetailViewModel f51880e;

        d(String str, RoomDetailViewModel roomDetailViewModel) {
            this.f51879d = str;
            this.f51880e = roomDetailViewModel;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            this.f51880e.n().q(null);
            a.C0856a.f(lg.a.f68962a, "RoomModel", "checkOutRoom onFailure message.." + str2, false, 4, null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomNet roomNet) {
            ty.b.f76540a.a().f(0, this.f51879d);
            this.f51880e.n().q(new RoomNet(NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS));
            a.C0856a.f(lg.a.f68962a, "RoomModel", "checkOutRoom onSuccess groupId.." + (roomNet != null ? roomNet.getGroupId() : null), false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rj.a A() {
        Application a11 = Utils.a();
        if (a11 != null) {
            return AppDatabase.INSTANCE.b(a11).w1();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 B() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final eq.a D() {
        return (eq.a) zg.c.f79537e.a().h(eq.a.class);
    }

    private final RequestBody l(String str) {
        return RequestBody.INSTANCE.create(str, MediaType.INSTANCE.parse("application/json"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b0 m() {
        return (b0) this.f51874d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b0 n() {
        return (b0) this.f51875e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final rj.a o() {
        return (rj.a) this.f51872b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b0 r() {
        return (b0) this.f51873c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final eq.a u() {
        return (eq.a) this.f51871a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 y() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 z() {
        return new b0();
    }

    public final void C(String groupId) {
        Intrinsics.h(groupId, "groupId");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RoomDetailViewModel$roomVisit$1(groupId, this, null), 3, null);
    }

    public final void p(String groupId) {
        Intrinsics.h(groupId, "groupId");
        a.C0769a.b(u(), vg.a.f77447a.a(), groupId, 0, 4, null).f(sg.d.f75472a.c()).subscribe(new b());
    }

    public final LiveData q() {
        return r();
    }

    public final LiveData s() {
        return m();
    }

    public final LiveData t() {
        return n();
    }

    public final void v(RoomItem roomItem) {
        Intrinsics.h(roomItem, "roomItem");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RoomDetailViewModel$insertRecentlyRoom$1(roomItem, this, null), 3, null);
    }

    public final void w(String groupId) {
        Intrinsics.h(groupId, "groupId");
        eq.a u11 = u();
        String a11 = vg.a.f77447a.a();
        String j11 = com.blankj.utilcode.util.o.j(new CheckInEntity(groupId));
        Intrinsics.g(j11, "toJson(...)");
        u11.i(a11, l(j11)).f(sg.d.f75472a.c()).subscribe(new c(groupId, this));
    }

    public final void x(String groupId) {
        Intrinsics.h(groupId, "groupId");
        eq.a u11 = u();
        String a11 = vg.a.f77447a.a();
        String j11 = com.blankj.utilcode.util.o.j(new CheckInEntity(groupId));
        Intrinsics.g(j11, "toJson(...)");
        u11.k(a11, l(j11)).f(sg.d.f75472a.c()).subscribe(new d(groupId, this));
    }
}
