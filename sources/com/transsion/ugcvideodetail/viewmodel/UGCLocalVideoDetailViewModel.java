package com.transsion.ugcvideodetail.viewmodel;

import android.app.Application;
import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.UGCVideoDetailPlayDao;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;

/* loaded from: classes6.dex */
public final class UGCLocalVideoDetailViewModel extends t0 {

    /* renamed from: g, reason: collision with root package name */
    public static final a f56553g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f56554a = LazyKt.b(new Function0() { // from class: com.transsion.ugcvideodetail.viewmodel.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            UGCVideoDetailPlayDao l11;
            l11 = UGCLocalVideoDetailViewModel.l();
            return l11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final b0 f56555b = new b0();

    /* renamed from: c, reason: collision with root package name */
    private final b0 f56556c = new b0();

    /* renamed from: d, reason: collision with root package name */
    private final b0 f56557d = new b0();

    /* renamed from: e, reason: collision with root package name */
    private final b0 f56558e;

    /* renamed from: f, reason: collision with root package name */
    private final LiveData f56559f;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UGCLocalVideoDetailViewModel() {
        b0 b0Var = new b0();
        this.f56558e = b0Var;
        this.f56559f = b0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UGCVideoDetailPlayDao g() {
        return (UGCVideoDetailPlayDao) this.f56554a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UGCVideoDetailPlayDao l() {
        AppDatabase.Companion companion = AppDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).C1();
    }

    public final b0 e() {
        return this.f56556c;
    }

    public final b0 f() {
        return this.f56555b;
    }

    public final void h(String resourceId) {
        Intrinsics.h(resourceId, "resourceId");
        k.d(u0.a(this), null, null, new UGCLocalVideoDetailViewModel$getPlayInfo$1(resourceId, this, null), 3, null);
    }

    public final b0 i() {
        return this.f56557d;
    }

    public final void j(String resourceId) {
        Intrinsics.h(resourceId, "resourceId");
        k.d(u0.a(this), null, null, new UGCLocalVideoDetailViewModel$getPlayList$1(resourceId, this, null), 3, null);
    }

    public final LiveData k() {
        return this.f56559f;
    }
}
