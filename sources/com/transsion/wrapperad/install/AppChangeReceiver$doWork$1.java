package com.transsion.wrapperad.install;

import android.content.Context;
import android.os.Build;
import com.transsion.ad.ps.installed.AppInstallManager;
import com.transsion.wrapperad.install.appinfo.AppChangeInfo;
import com.transsion.wrapperad.install.open.ChangeType;
import gy.c;
import hj.i;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.wrapperad.install.AppChangeReceiver$doWork$1", f = "AppChangeReceiver.kt", l = {86}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class AppChangeReceiver$doWork$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChangeType $changeType;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $packageName;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ AppChangeReceiver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppChangeReceiver$doWork$1(Context context, String str, ChangeType changeType, AppChangeReceiver appChangeReceiver, Continuation<? super AppChangeReceiver$doWork$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$packageName = str;
        this.$changeType = changeType;
        this.this$0 = appChangeReceiver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AppChangeReceiver$doWork$1 appChangeReceiver$doWork$1 = new AppChangeReceiver$doWork$1(this.$context, this.$packageName, this.$changeType, this.this$0, continuation);
        appChangeReceiver$doWork$1.L$0 = obj;
        return appChangeReceiver$doWork$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((AppChangeReceiver$doWork$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Context context;
        String str;
        AppChangeReceiver appChangeReceiver;
        AppChangeInfo appChangeInfo;
        ChangeType changeType;
        String c11;
        String c12;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                context = this.$context;
                str = this.$packageName;
                ChangeType changeType2 = this.$changeType;
                appChangeReceiver = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                AppChangeInfo a11 = c.f64158a.a(context, str, changeType2);
                AppInstallManager appInstallManager = AppInstallManager.f42250a;
                String packageName = a11.getPackageName();
                this.L$0 = context;
                this.L$1 = str;
                this.L$2 = changeType2;
                this.L$3 = appChangeReceiver;
                this.L$4 = a11;
                this.label = 1;
                Object d11 = appInstallManager.d(context, packageName, this);
                if (d11 == f11) {
                    return f11;
                }
                appChangeInfo = a11;
                changeType = changeType2;
                obj = d11;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                appChangeInfo = (AppChangeInfo) this.L$4;
                appChangeReceiver = (AppChangeReceiver) this.L$3;
                changeType = (ChangeType) this.L$2;
                str = (String) this.L$1;
                context = (Context) this.L$0;
                ResultKt.b(obj);
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (!((Boolean) obj).booleanValue()) {
            a aVar = a.f58297a;
            c12 = appChangeReceiver.c();
            aVar.a(c12 + " --> doWork() --> 拦截安装应用,他不是MB触发下载的 --> pkg = " + str);
            return Unit.f67184a;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("package_name", str);
        i.f64628a.s("AppChangeReceiver", "broadcast", hashMap);
        a aVar2 = a.f58297a;
        c11 = appChangeReceiver.c();
        aVar2.a(c11 + " --> doWork() --> pkg = " + changeType + " -- type = " + changeType + " -- info = " + appChangeInfo);
        if (changeType == ChangeType.INSTALLED) {
            if (Build.VERSION.SDK_INT < 29) {
                hy.c.f64968a.a(context, appChangeInfo);
            } else if (hy.b.f64967a.a(context)) {
                hy.c.f64968a.a(context, appChangeInfo);
            }
        }
        Result.m1185constructorimpl(Unit.f67184a);
        return Unit.f67184a;
    }
}
