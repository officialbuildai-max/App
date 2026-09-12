package com.transsion.moviedetail.staff;

import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.t0;
import com.cloud.tmc.integration.event.EventConstants;
import com.google.gson.JsonObject;
import com.transsion.moviedetail.staff.a;
import com.transsion.moviedetail.staff.bean.MovieStaffList;
import com.transsion.moviedetail.staff.bean.MovieStaffSubjectList;
import com.transsion.moviedetailapi.bean.Staff;
import com.transsion.postdetail.bean.Pager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: classes6.dex */
public final class y extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f47406a = new b0();

    /* renamed from: b, reason: collision with root package name */
    private final b0 f47407b = new b0();

    /* renamed from: c, reason: collision with root package name */
    private final b0 f47408c = new b0();

    /* renamed from: d, reason: collision with root package name */
    private final b0 f47409d = new b0();

    /* renamed from: e, reason: collision with root package name */
    private final b0 f47410e = new b0();

    /* renamed from: f, reason: collision with root package name */
    private final Lazy f47411f = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.staff.x
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            a x10;
            x10 = y.x();
            return x10;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    private int f47412g = 1;

    /* renamed from: h, reason: collision with root package name */
    private boolean f47413h = true;

    /* renamed from: i, reason: collision with root package name */
    private io.reactivex.rxjava3.disposables.c f47414i;

    /* loaded from: classes6.dex */
    public static final class a extends sg.a {
        a() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            y.this.f47410e.q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MovieStaffList movieStaffList) {
            super.c(movieStaffList);
            y.this.f47410e.q(movieStaffList);
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends sg.a {
        b() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            y.this.f47406a.q(null);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(Staff staff) {
            super.c(staff);
            y.this.f47406a.q(staff);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends sg.a {
        c() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            io.reactivex.rxjava3.disposables.c cVar;
            y.this.f47408c.q(null);
            io.reactivex.rxjava3.disposables.c cVar2 = y.this.f47414i;
            if (cVar2 == null || cVar2.isDisposed() || (cVar = y.this.f47414i) == null) {
                return;
            }
            cVar.dispose();
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(MovieStaffSubjectList movieStaffSubjectList) {
            io.reactivex.rxjava3.disposables.c cVar;
            Pager pager;
            Boolean hasMore;
            super.c(movieStaffSubjectList);
            if (movieStaffSubjectList != null && (pager = movieStaffSubjectList.getPager()) != null && (hasMore = pager.getHasMore()) != null) {
                y.this.f47413h = hasMore.booleanValue();
            }
            y.this.f47408c.q(movieStaffSubjectList);
            if (movieStaffSubjectList != null) {
                y yVar = y.this;
                List list = (List) yVar.f47407b.f();
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(movieStaffSubjectList);
                yVar.f47407b.q(list);
            }
            y.this.f47412g++;
            io.reactivex.rxjava3.disposables.c cVar2 = y.this.f47414i;
            if (cVar2 == null || cVar2.isDisposed() || (cVar = y.this.f47414i) == null) {
                return;
            }
            cVar.dispose();
        }

        @Override // sg.a, io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c d11) {
            Intrinsics.h(d11, "d");
            super.onSubscribe(d11);
            y.this.f47414i = d11;
        }
    }

    /* loaded from: classes6.dex */
    static final class d implements lz.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JsonObject f47418a;

        d(JsonObject jsonObject) {
            this.f47418a = jsonObject;
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final RequestBody apply(JsonObject it) {
            Intrinsics.h(it, "it");
            RequestBody.Companion companion = RequestBody.INSTANCE;
            String jsonElement = this.f47418a.toString();
            Intrinsics.g(jsonElement, "toString(...)");
            return companion.create(jsonElement, MediaType.INSTANCE.parse("application/json"));
        }
    }

    /* loaded from: classes6.dex */
    static final class e implements lz.h {
        e() {
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final io.reactivex.rxjava3.core.m apply(RequestBody it) {
            Intrinsics.h(it, "it");
            return a.C0634a.d(y.this.r(), it, null, 2, null);
        }
    }

    /* loaded from: classes6.dex */
    public static final class f extends sg.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f47421e;

        f(int i11) {
            this.f47421e = i11;
        }

        @Override // sg.a
        public void a(String str, String str2) {
            y.this.f47409d.q(-1);
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(String str) {
            super.c(str);
            y.this.f47409d.q(Integer.valueOf(this.f47421e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.moviedetail.staff.a r() {
        return (com.transsion.moviedetail.staff.a) this.f47411f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsion.moviedetail.staff.a x() {
        return (com.transsion.moviedetail.staff.a) zg.c.f79537e.a().h(com.transsion.moviedetail.staff.a.class);
    }

    public final void n() {
        this.f47408c.q(null);
    }

    public final void o(String str) {
        if (str == null) {
            return;
        }
        a.C0634a.b(r(), str, null, 2, null).f(sg.d.f75472a.c()).subscribe(new a());
    }

    public final void p(String str) {
        if (str == null) {
            return;
        }
        a.C0634a.a(r(), str, null, 2, null).f(sg.d.f75472a.c()).subscribe(new b());
    }

    public final void q(String str, int i11) {
        if (str == null || !this.f47413h) {
            return;
        }
        io.reactivex.rxjava3.disposables.c cVar = this.f47414i;
        if (cVar == null || cVar.isDisposed()) {
            int i12 = this.f47412g;
            int i13 = 1;
            if (i12 > 1) {
                i13 = i11 + 1 + ((i12 - 2) * 60);
                i11 = i13 + 59;
            }
            a.C0634a.c(r(), str, i13, i11, 1, null, 16, null).f(sg.d.f75472a.c()).subscribe(new c());
        }
    }

    public final LiveData s() {
        return this.f47410e;
    }

    public final LiveData t() {
        return this.f47406a;
    }

    public final LiveData u() {
        return this.f47407b;
    }

    public final LiveData v() {
        return this.f47408c;
    }

    public final LiveData w() {
        return this.f47409d;
    }

    public final void y(String str, int i11) {
        if (str == null) {
            return;
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("staffId", str);
        jsonObject.addProperty(EventConstants.KEY_ACTION, Integer.valueOf(i11));
        io.reactivex.rxjava3.core.j.t(jsonObject).u(new d(jsonObject)).n(new e()).f(sg.d.f75472a.c()).subscribe(new f(i11));
    }
}
