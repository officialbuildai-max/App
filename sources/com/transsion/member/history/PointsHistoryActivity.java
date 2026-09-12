package com.transsion.member.history;

import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import androidx.view.ViewModelLazy;
import androidx.view.c0;
import androidx.view.v0;
import androidx.view.x0;
import com.gyf.immersionbar.ImmersionBar;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.member.R$id;
import com.transsion.member.R$string;
import com.transsion.member.bean.PointsHistoryData;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0004R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/transsion/member/history/PointsHistoryActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Lwm/b;", "<init>", "()V", "", "i0", "()Ljava/lang/String;", "", "isTranslucent", "()Z", "r0", "", "o0", "p0", "n0", "s0", "retryLoadData", "I0", "()Lwm/b;", "t0", "Lcom/transsion/member/history/PointsHistoryViewModel;", "i", "Lkotlin/Lazy;", "H0", "()Lcom/transsion/member/history/PointsHistoryViewModel;", "mViewModel", "Member_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class PointsHistoryActivity extends BaseNewActivity<wm.b> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy mViewModel;

    /* loaded from: classes5.dex */
    static final class a implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f46619a;

        a(Function1 function) {
            Intrinsics.h(function, "function");
            this.f46619a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f46619a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f46619a.invoke(obj);
        }
    }

    public PointsHistoryActivity() {
        final Function0 function0 = null;
        this.mViewModel = new ViewModelLazy(Reflection.b(PointsHistoryViewModel.class), new Function0<x0>() { // from class: com.transsion.member.history.PointsHistoryActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                return ComponentActivity.this.getViewModelStore();
            }
        }, new Function0<v0.c>() { // from class: com.transsion.member.history.PointsHistoryActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                return ComponentActivity.this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<p1.a>() { // from class: com.transsion.member.history.PointsHistoryActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final p1.a invoke() {
                p1.a aVar;
                Function0 function02 = Function0.this;
                return (function02 == null || (aVar = (p1.a) function02.invoke()) == null) ? this.getDefaultViewModelCreationExtras() : aVar;
            }
        });
    }

    private final PointsHistoryViewModel H0() {
        return (PointsHistoryViewModel) this.mViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(PointsHistoryActivity pointsHistoryActivity, View view) {
        pointsHistoryActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit K0(PointsHistoryActivity pointsHistoryActivity, PointsHistoryData pointsHistoryData) {
        String str;
        AppCompatTextView appCompatTextView = ((wm.b) pointsHistoryActivity.getMViewBinding()).f77837d;
        if (pointsHistoryData == null || (str = pointsHistoryData.getCoinBalance()) == null) {
            str = "0";
        }
        appCompatTextView.setText(str);
        return Unit.f67184a;
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public wm.b getViewBinding() {
        wm.b c11 = wm.b.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String i0() {
        return "";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void n0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void o0() {
        ((wm.b) getMViewBinding()).f77836c.f77976c.setText(getString(R$string.points_history_title));
        ((wm.b) getMViewBinding()).f77836c.f77975b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.history.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PointsHistoryActivity.J0(PointsHistoryActivity.this, view);
            }
        });
        LinearLayoutCompat root = ((wm.b) getMViewBinding()).getRoot();
        Intrinsics.g(root, "getRoot(...)");
        jg.c.e(root);
        v0();
        ImmersionBar.with(this).statusBarDarkFont(false).init();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void p0() {
        H0().e().j(this, new a(new Function1() { // from class: com.transsion.member.history.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit K0;
                K0 = PointsHistoryActivity.K0(PointsHistoryActivity.this, (PointsHistoryData) obj);
                return K0;
            }
        }));
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean r0() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void s0() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void t0() {
        super.t0();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        w p11 = supportFragmentManager.p();
        Intrinsics.g(p11, "beginTransaction()");
        p11.s(R$id.container, PointsHistoryFragment.INSTANCE.a());
        p11.j();
    }
}
