package com.transsion.usercenter.setting.labelsfeedback.sender;

import ak.a0;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.view.LiveData;
import androidx.view.c0;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.f;
import androidx.work.v;
import com.blankj.utilcode.util.o;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.tencent.mmkv.MMKV;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.setting.labelsfeedback.model.FbDataModel;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import nh.m;

/* loaded from: classes.dex */
public final class FBSender {

    /* renamed from: a, reason: collision with root package name */
    public static final FBSender f57582a = new FBSender();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f57583b = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.setting.labelsfeedback.sender.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV i11;
            i11 = FBSender.i();
            return i11;
        }
    });

    /* loaded from: classes7.dex */
    public static final class a implements c0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LiveData f57584a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FBSender f57585b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f57586c;

        /* renamed from: com.transsion.usercenter.setting.labelsfeedback.sender.FBSender$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public /* synthetic */ class C0712a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f57587a;

            static {
                int[] iArr = new int[WorkInfo.State.values().length];
                try {
                    iArr[WorkInfo.State.SUCCEEDED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[WorkInfo.State.FAILED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[WorkInfo.State.CANCELLED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f57587a = iArr;
            }
        }

        a(LiveData liveData, FBSender fBSender, String str) {
            this.f57584a = liveData;
            this.f57585b = fBSender;
            this.f57586c = str;
        }

        @Override // androidx.view.c0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(WorkInfo workInfo) {
            WorkInfo.State a11 = workInfo != null ? workInfo.a() : null;
            int i11 = a11 == null ? -1 : C0712a.f57587a[a11.ordinal()];
            if (i11 == 1) {
                uh.b.f76876a.d(R$string.feedback_tips_suceess);
                this.f57584a.o(this);
                this.f57585b.n(null);
            } else if (i11 == 2 || i11 == 3) {
                uh.b.f76876a.d(R$string.feedback_tips_failed);
                this.f57584a.o(this);
                this.f57585b.n(this.f57586c);
            }
        }
    }

    private FBSender() {
    }

    private final String e() {
        return g().k("key_failed_json");
    }

    private final MMKV g() {
        return (MMKV) f57583b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String str, Throwable th2) {
        if (th2 != null) {
            a0.f702a.g(th2);
            lg.a.f68962a.x("FBSender", "Failed to schedule feedback work: " + th2.getMessage(), false);
        }
        n(str);
        uh.b.f76876a.d(R$string.upload_failed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV i() {
        MMKV I = MMKV.I("feedback_mmkv");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(String str, Application application) {
        Object m1185constructorimpl;
        t1 d11;
        if (!a0.f702a.a(application)) {
            h(str, null);
            return;
        }
        v.a aVar = new v.a(FbSenderWorker.class);
        Pair[] pairArr = {TuplesKt.a("key_work_data", str)};
        f.a aVar2 = new f.a();
        Pair pair = pairArr[0];
        aVar2.b((String) pair.getFirst(), pair.getSecond());
        aVar.l(aVar2.a());
        v vVar = (v) aVar.b();
        Context createDeviceProtectedStorageContext = Build.VERSION.SDK_INT >= 24 ? application.createDeviceProtectedStorageContext() : application;
        try {
            Result.Companion companion = Result.INSTANCE;
            WorkManager.a aVar3 = WorkManager.f15481a;
            Intrinsics.e(createDeviceProtectedStorageContext);
            WorkManager a11 = aVar3.a(createDeviceProtectedStorageContext);
            LiveData g11 = a11.g(vVar.a());
            d11 = k.d(o0.a(y0.c()), null, null, new FBSender$sendJson$1$1(g11, new a(g11, this, str), a11, vVar, application, new AtomicBoolean(false), this, str, null), 3, null);
            m1185constructorimpl = Result.m1185constructorimpl(d11);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            f57582a.h(str, m1188exceptionOrNullimpl);
        }
    }

    private final void m(String str) {
        if (str == null) {
            g().remove("key_failed_json");
        } else {
            g().v("key_failed_json", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String str) {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m(str);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            lg.a.f68962a.x("FBSender", "Failed to update feedback retry data: " + m1188exceptionOrNullimpl.getMessage(), false);
        }
    }

    public final FbDataModel f() {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(e());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = null;
        }
        String str = (String) m1185constructorimpl;
        if (str != null) {
            try {
                return (FbDataModel) o.d(str, FbDataModel.class);
            } catch (Exception e11) {
                String message = e11.getMessage();
                if (message == null) {
                    message = "unable to parse json";
                }
                Log.e(TmcConstants.MENU_KEY_FEEDBACK, message);
            }
        }
        return null;
    }

    public final void j(Application application) {
        Object m1185constructorimpl;
        Intrinsics.h(application, "application");
        if (m.f70597a.e()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(e());
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            if (Result.m1191isFailureimpl(m1185constructorimpl)) {
                m1185constructorimpl = null;
            }
            String str = (String) m1185constructorimpl;
            if (str != null) {
                f57582a.l(str, application);
            }
        }
    }

    public final void k(FbDataModel model, Application application) {
        Intrinsics.h(model, "model");
        Intrinsics.h(application, "application");
        k.d(o0.a(y0.b()), null, null, new FBSender$send$1(model, application, null), 3, null);
    }
}
