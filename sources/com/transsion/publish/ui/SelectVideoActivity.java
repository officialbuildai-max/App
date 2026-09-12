package com.transsion.publish.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import com.blankj.utilcode.util.PermissionUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.publish.R$id;
import com.transsion.publish.R$string;
import com.transsion.publish.api.VsMediaInfo;
import com.transsion.publish.bean.PreviewMediaConfirmEvent;
import com.transsion.publish.bean.PreviewVideoBean;
import com.transsion.publish.view.CustomHeader;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import lg.a;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u0019\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010.R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0017\u0010<\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b9\u00107\u001a\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006E"}, d2 = {"Lcom/transsion/publish/ui/SelectVideoActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lhp/k;", "<init>", "()V", "", "initData", "D0", "initView", "t0", "B0", "showLoading", "v0", "", "size", "s0", "(I)V", "", "isTranslucent", "()Z", "isStatusDark", "isChangeStatusBar", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "u0", "()Lhp/k;", "onDestroy", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "videoRecycler", "Lcom/transsion/publish/adapter/k0;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/publish/adapter/k0;", "videoAdapter", "Ljp/c;", "c", "Ljp/c;", "selectVideoManager", "Landroid/widget/LinearLayout;", "d", "Landroid/widget/LinearLayout;", "noContentView", "e", "lockView", "Landroid/widget/ProgressBar;", "f", "Landroid/widget/ProgressBar;", "selectVideoLoading", be.g.f16474b, "I", "maxLimit", "h", "getScreenWidth", "()I", "screenWidth", "Lio/reactivex/rxjava3/disposables/c;", "i", "Lio/reactivex/rxjava3/disposables/c;", "disposable", "", com.mbridge.msdk.foundation.same.report.j.f35620b, "J", "showDuration", "Publish_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class SelectVideoActivity extends BaseActivity<hp.k> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private RecyclerView videoRecycler;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.transsion.publish.adapter.k0 videoAdapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private jp.c selectVideoManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayout noContentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LinearLayout lockView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ProgressBar selectVideoLoading;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int maxLimit = 1;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int screenWidth = com.blankj.utilcode.util.y.e();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private io.reactivex.rxjava3.disposables.c disposable;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long showDuration;

    /* loaded from: classes6.dex */
    public static final class a implements io.reactivex.rxjava3.core.o {
        a() {
        }

        @Override // io.reactivex.rxjava3.core.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List t11) {
            Intrinsics.h(t11, "t");
            if (t11.isEmpty()) {
                LinearLayout linearLayout = SelectVideoActivity.this.noContentView;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
            } else {
                com.transsion.publish.adapter.k0 k0Var = SelectVideoActivity.this.videoAdapter;
                if (k0Var != null) {
                    k0Var.addData(t11);
                }
            }
            SelectVideoActivity.this.v0();
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onComplete() {
            LinearLayout linearLayout;
            com.transsion.publish.adapter.k0 k0Var;
            io.reactivex.rxjava3.disposables.c cVar = SelectVideoActivity.this.disposable;
            if (cVar != null) {
                cVar.dispose();
            }
            SelectVideoActivity.this.v0();
            if ((SelectVideoActivity.this.videoAdapter == null || ((k0Var = SelectVideoActivity.this.videoAdapter) != null && k0Var.getItemCount() == 0)) && (linearLayout = SelectVideoActivity.this.noContentView) != null) {
                linearLayout.setVisibility(0);
            }
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onError(Throwable e11) {
            Intrinsics.h(e11, "e");
            a.C0856a.f(lg.a.f68962a, "SelectVideoManager", "onError e:" + e11, false, 4, null);
        }

        @Override // io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c d11) {
            Intrinsics.h(d11, "d");
            SelectVideoActivity.this.disposable = d11;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements PermissionUtils.b {
        b() {
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onDenied() {
            LinearLayout linearLayout = SelectVideoActivity.this.lockView;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
            LinearLayout linearLayout = SelectVideoActivity.this.lockView;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            SelectVideoActivity.this.B0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(SelectVideoActivity selectVideoActivity, PreviewVideoBean it) {
        Intrinsics.h(it, "it");
        VsMediaInfo select = it.getSelect();
        if (select == null) {
            return Unit.f67184a;
        }
        com.transsion.publish.adapter.k0 k0Var = selectVideoActivity.videoAdapter;
        if (k0Var != null) {
            k0Var.x(select);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B0() {
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        showLoading();
        this.selectVideoManager = new jp.c(this);
        io.reactivex.rxjava3.core.j.g(new io.reactivex.rxjava3.core.l() { // from class: com.transsion.publish.ui.f1
            @Override // io.reactivex.rxjava3.core.l
            public final void a(io.reactivex.rxjava3.core.k kVar) {
                SelectVideoActivity.C0(SelectVideoActivity.this, kVar);
            }
        }).b(12).v(io.reactivex.rxjava3.android.schedulers.b.c()).E(qz.a.c()).subscribe(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(SelectVideoActivity selectVideoActivity, io.reactivex.rxjava3.core.k emitter) {
        Intrinsics.h(emitter, "emitter");
        a.C0856a.f(lg.a.f68962a, "SelectVideoManager", "loadLocalVideo success", false, 4, null);
        jp.c cVar = selectVideoActivity.selectVideoManager;
        if (cVar != null) {
            cVar.a(emitter);
        }
        if (emitter.isDisposed()) {
            return;
        }
        emitter.onComplete();
    }

    private final void D0() {
        if (PermissionUtils.s("android.permission.READ_EXTERNAL_STORAGE")) {
            B0();
        } else {
            PermissionUtils.x("android.permission.READ_EXTERNAL_STORAGE").m(new b()).y();
        }
    }

    private final void initData() {
        Function1 function1 = new Function1() { // from class: com.transsion.publish.ui.e1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit w02;
                w02 = SelectVideoActivity.w0(SelectVideoActivity.this, (PreviewMediaConfirmEvent) obj);
                return w02;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PreviewMediaConfirmEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        ((CustomHeader) findViewById(R$id.sv_title_bar)).setOnBackClick(new View.OnClickListener() { // from class: com.transsion.publish.ui.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectVideoActivity.x0(SelectVideoActivity.this, view);
            }
        });
        s0(0);
        TextView confirmTV = ((hp.k) getMViewBinding()).f64934b;
        Intrinsics.g(confirmTV, "confirmTV");
        jg.c.c(confirmTV, 0L, new Function1() { // from class: com.transsion.publish.ui.h1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit y02;
                y02 = SelectVideoActivity.y0(SelectVideoActivity.this, (View) obj);
                return y02;
            }
        }, 1, null);
        this.selectVideoLoading = (ProgressBar) findViewById(R$id.select_video_loading);
        this.noContentView = (LinearLayout) findViewById(R$id.sv_no_content_view);
        this.lockView = (LinearLayout) findViewById(R$id.sv_lock_view);
        TextView textView = (TextView) findViewById(R$id.sv_tv_grant);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.ui.i1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SelectVideoActivity.z0(view);
                }
            });
        }
        this.videoRecycler = (RecyclerView) findViewById(R$id.select_video_recycler);
        this.videoAdapter = new com.transsion.publish.adapter.k0(new SelectVideoActivity$initView$4(this));
        RecyclerView recyclerView = this.videoRecycler;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager((Context) this, 4, 1, false));
        }
        RecyclerView recyclerView2 = this.videoRecycler;
        if (recyclerView2 != null) {
            recyclerView2.addItemDecoration(new mp.f(com.blankj.utilcode.util.a0.a(2.0f)));
        }
        RecyclerView recyclerView3 = this.videoRecycler;
        if (recyclerView3 != null) {
            recyclerView3.setAdapter(this.videoAdapter);
        }
        Function1 function1 = new Function1() { // from class: com.transsion.publish.ui.j1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit A0;
                A0 = SelectVideoActivity.A0(SelectVideoActivity.this, (PreviewVideoBean) obj);
                return A0;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PreviewVideoBean.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void s0(int size) {
        int f11 = RangesKt.f(size, 0);
        TextView selectNumTV = ((hp.k) getMViewBinding()).f64935c;
        Intrinsics.g(selectNumTV, "selectNumTV");
        selectNumTV.setVisibility(f11 > 0 ? 0 : 8);
        ((hp.k) getMViewBinding()).f64935c.setText(getString(R$string.video_select_num_tips, Integer.valueOf(f11), Integer.valueOf(this.maxLimit)));
    }

    private final void showLoading() {
        ProgressBar progressBar = this.selectVideoLoading;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    private final void t0() {
        List m11;
        com.transsion.publish.adapter.k0 k0Var = this.videoAdapter;
        VsMediaInfo vsMediaInfo = (k0Var == null || (m11 = k0Var.m()) == null) ? null : (VsMediaInfo) CollectionsKt.k0(m11);
        if (vsMediaInfo != null) {
            fp.a aVar = new fp.a();
            aVar.o(1);
            aVar.n(1);
            aVar.u(vsMediaInfo);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = fp.a.class.getName();
            Intrinsics.g(name, "getName(...)");
            flowEventBus.postEvent(name, aVar, 0L);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0() {
        ProgressBar progressBar = this.selectVideoLoading;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(SelectVideoActivity selectVideoActivity, PreviewMediaConfirmEvent it) {
        Intrinsics.h(it, "it");
        selectVideoActivity.t0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(SelectVideoActivity selectVideoActivity, View view) {
        selectVideoActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(SelectVideoActivity selectVideoActivity, View it) {
        Intrinsics.h(it, "it");
        selectVideoActivity.t0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(View view) {
        PermissionUtils.v();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public hj.b newLogViewConfig() {
        return new hj.b("select_video", false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.showDuration = System.currentTimeMillis();
        initView();
        initData();
        D0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        io.reactivex.rxjava3.disposables.c cVar = this.disposable;
        if (cVar != null) {
            cVar.dispose();
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public hp.k getViewBinding() {
        hp.k c11 = hp.k.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }
}
