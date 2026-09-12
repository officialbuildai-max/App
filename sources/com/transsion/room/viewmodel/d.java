package com.transsion.room.viewmodel;

import androidx.view.LiveData;
import androidx.view.b0;
import com.transsion.moviedetailapi.bean.RoomNet;
import com.transsion.room.bean.CheckNameBean;
import com.transsion.room.bean.CreateRoomRequestEntity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: classes6.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name */
    public static final a f51910d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f51911a = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 m11;
            m11 = d.m();
            return m11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f51912b = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 f11;
            f11 = d.f();
            return f11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f51913c = LazyKt.b(new Function0() { // from class: com.transsion.room.viewmodel.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            eq.a n11;
            n11 = d.n();
            return n11;
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
            d.this.h().q(null);
            a.C0856a.f(lg.a.f68962a, "RoomModel", "onFailure message.." + str2, false, 4, null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(CheckNameBean checkNameBean) {
            d.this.h().q(checkNameBean);
            a.C0856a.f(lg.a.f68962a, "RoomModel", "onSuccess groupId.." + (checkNameBean != null ? checkNameBean.getGroupId() : null), false, 4, null);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends sg.a {
        c() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            d.this.k().q(null);
            a.C0856a.f(lg.a.f68962a, "RoomModel", "onFailure message.." + str2, false, 4, null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomNet roomNet) {
            d.this.k().q(roomNet);
            a.C0856a.f(lg.a.f68962a, "RoomModel", "onSuccess groupId.." + (roomNet != null ? roomNet.getGroupId() : null), false, 4, null);
        }
    }

    /* renamed from: com.transsion.room.viewmodel.d$d, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0649d extends sg.a {
        C0649d() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            d.this.k().q(null);
            a.C0856a.f(lg.a.f68962a, "RoomModel", "onFailure message.." + str2, false, 4, null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(RoomNet roomNet) {
            d.this.k().q(new RoomNet("update"));
            a.C0856a.f(lg.a.f68962a, "RoomModel", "onSuccess groupId.." + (roomNet != null ? roomNet.getGroupId() : null), false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 f() {
        return new b0();
    }

    private final RequestBody i(String str) {
        return RequestBody.INSTANCE.create(str, MediaType.INSTANCE.parse("application/json"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b0 k() {
        return (b0) this.f51911a.getValue();
    }

    private final eq.a l() {
        return (eq.a) this.f51913c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 m() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final eq.a n() {
        return (eq.a) zg.c.f79537e.a().h(eq.a.class);
    }

    public final void e(String name) {
        Intrinsics.h(name, "name");
        l().e(vg.a.f77447a.a(), name).f(sg.d.f75472a.c()).subscribe(new b());
    }

    public final void g(String name, String avator, String desc, String str) {
        Intrinsics.h(name, "name");
        Intrinsics.h(avator, "avator");
        Intrinsics.h(desc, "desc");
        CreateRoomRequestEntity createRoomRequestEntity = new CreateRoomRequestEntity("", name, avator, desc, str);
        eq.a l11 = l();
        String a11 = vg.a.f77447a.a();
        String j11 = com.blankj.utilcode.util.o.j(createRoomRequestEntity);
        Intrinsics.g(j11, "toJson(...)");
        l11.g(a11, i(j11)).f(sg.d.f75472a.c()).subscribe(new c());
    }

    public final b0 h() {
        return (b0) this.f51912b.getValue();
    }

    public final LiveData j() {
        return k();
    }

    public final void o(String groupId, String name, String avator, String desc, String str) {
        Intrinsics.h(groupId, "groupId");
        Intrinsics.h(name, "name");
        Intrinsics.h(avator, "avator");
        Intrinsics.h(desc, "desc");
        CreateRoomRequestEntity createRoomRequestEntity = new CreateRoomRequestEntity(groupId, name, avator, desc, str);
        eq.a l11 = l();
        String a11 = vg.a.f77447a.a();
        String j11 = com.blankj.utilcode.util.o.j(createRoomRequestEntity);
        Intrinsics.g(j11, "toJson(...)");
        l11.b(a11, i(j11)).f(sg.d.f75472a.c()).subscribe(new C0649d());
    }
}
