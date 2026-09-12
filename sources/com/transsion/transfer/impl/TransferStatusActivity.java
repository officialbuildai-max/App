package com.transsion.transfer.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.view.v0;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.therouter.TheRouter;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.downloadapi.IDownloadApiProvider;
import com.transsion.transfer.R$id;
import com.transsion.transfer.R$mipmap;
import com.transsion.transfer.R$string;
import com.transsion.transfer.impl.TransferStatusActivity;
import com.transsion.transfer.impl.client.TransferClient;
import com.transsion.transfer.impl.view.TabTitleView;
import com.transsion.transfer.wifi.connect.WifiConnectionManager;
import com.transsion.transfer.wifi.create.WifiCreateManager;
import com.transsion.transfer.wifi.ui.TransferDisconnectTipsDialog;
import com.transsion.transfer.wifi.util.WifiUtils;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005*\u00014\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u001f\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0004J\u0019\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0006\u0010\u0018R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010+R\u001d\u00103\u001a\u0004\u0018\u00010&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00100\u001a\u0004\b6\u00107R\u001b\u0010=\u001a\u0002098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u00100\u001a\u0004\b;\u0010<R\u001b\u0010B\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u00100\u001a\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020C0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006L"}, d2 = {"Lcom/transsion/transfer/impl/TransferStatusActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lgv/b;", "<init>", "()V", "", "initView", "q1", "m1", "N0", "initData", "a1", "W0", "", "connected", "", "deviceName", "P0", "(ZLjava/lang/String;)V", "s1", "V0", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "isTranslucent", "()Z", "isStatusDark", "U0", "()Lgv/b;", "Lcom/transsion/transfer/impl/TransferReceivedFragment;", "a", "Lcom/transsion/transfer/impl/TransferReceivedFragment;", "receivedFragment", "Lcom/transsion/transfer/impl/TransferSentFragment;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/transfer/impl/TransferSentFragment;", "sentFragment", "Lhv/a;", "c", "Lhv/a;", "selectFragment", "d", "Z", "isSelectFragmentShown", "e", "needServerAsClientFetchList", "f", "Lkotlin/Lazy;", "T0", "()Lhv/a;", "transferSelectFragment", "com/transsion/transfer/impl/TransferStatusActivity$g", be.g.f16474b, "R0", "()Lcom/transsion/transfer/impl/TransferStatusActivity$g;", "serverFileHandler", "Lcom/transsion/transfer/impl/k;", "h", "S0", "()Lcom/transsion/transfer/impl/k;", "serverViewModel", "Lcom/transsion/transfer/impl/ClientViewModel;", "i", "Q0", "()Lcom/transsion/transfer/impl/ClientViewModel;", "clientViewModel", "", com.mbridge.msdk.foundation.same.report.j.f35620b, "I", "selectTabIndex", "", CampaignEx.JSON_KEY_AD_K, "[Ljava/lang/Integer;", "tabs", "l", "Transfer_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class TransferStatusActivity extends BaseActivity<gv.b> {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    private static final String f55758m;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f55759n;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private TransferReceivedFragment receivedFragment;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private TransferSentFragment sentFragment;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private hv.a selectFragment;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isSelectFragmentShown;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needServerAsClientFetchList;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int selectTabIndex;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy transferSelectFragment = LazyKt.b(new Function0() { // from class: com.transsion.transfer.impl.l0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            hv.a t12;
            t12 = TransferStatusActivity.t1();
            return t12;
        }
    });

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy serverFileHandler = LazyKt.b(new Function0() { // from class: com.transsion.transfer.impl.m0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            TransferStatusActivity.g o12;
            o12 = TransferStatusActivity.o1(TransferStatusActivity.this);
            return o12;
        }
    });

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy serverViewModel = LazyKt.b(new Function0() { // from class: com.transsion.transfer.impl.n0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            k p12;
            p12 = TransferStatusActivity.p1(TransferStatusActivity.this);
            return p12;
        }
    });

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy clientViewModel = LazyKt.b(new Function0() { // from class: com.transsion.transfer.impl.o0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ClientViewModel O0;
            O0 = TransferStatusActivity.O0(TransferStatusActivity.this);
            return O0;
        }
    });

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final Integer[] tabs = {Integer.valueOf(R$string.transfer_tab_received), Integer.valueOf(R$string.transfer_tab_sent)};

    /* renamed from: com.transsion.transfer.impl.TransferStatusActivity$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return TransferStatusActivity.f55758m;
        }

        public final void b(Context context) {
            Intrinsics.h(context, "context");
            TransferStatusActivity.f55759n = false;
            context.startActivity(new Intent(context, (Class<?>) TransferStatusActivity.class));
        }

        public final void c(Context context) {
            Intrinsics.h(context, "context");
            Intent intent = new Intent(context, (Class<?>) TransferStatusActivity.class);
            TransferStatusActivity.f55759n = true;
            context.startActivity(intent);
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            super.onPageScrollStateChanged(i11);
            ((gv.b) TransferStatusActivity.this.getMViewBinding()).f64087f.onPageScrollStateChanged(i11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            super.onPageScrolled(i11, f11, i12);
            ((gv.b) TransferStatusActivity.this.getMViewBinding()).f64087f.onPageScrolled(i11, f11, i12);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            ((gv.b) TransferStatusActivity.this.getMViewBinding()).f64087f.onPageSelected(i11);
            TransferStatusActivity.this.selectTabIndex = i11;
            if (i11 == 0) {
                TransferReceivedFragment transferReceivedFragment = TransferStatusActivity.this.receivedFragment;
                if (transferReceivedFragment != null) {
                    transferReceivedFragment.u0();
                    return;
                }
                return;
            }
            TransferSentFragment transferSentFragment = TransferStatusActivity.this.sentFragment;
            if (transferSentFragment != null) {
                transferSentFragment.p0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends j00.a {

        /* loaded from: classes6.dex */
        public static final class a extends com.transsion.baseui.util.f {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ TransferStatusActivity f55773e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f55774f;

            a(TransferStatusActivity transferStatusActivity, int i11) {
                this.f55773e = transferStatusActivity;
                this.f55774f = i11;
            }

            @Override // com.transsion.baseui.util.f
            public void c(View view) {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.transsion.baseui.util.f
            public void d(View view) {
                ((gv.b) this.f55773e.getMViewBinding()).f64094m.setCurrentItem(this.f55774f, true);
            }
        }

        c() {
        }

        @Override // j00.a
        public int a() {
            return TransferStatusActivity.this.tabs.length;
        }

        @Override // j00.a
        public j00.c b(Context context) {
            Intrinsics.h(context, "context");
            GradientLinePagerIndicator gradientLinePagerIndicator = new GradientLinePagerIndicator(context);
            gradientLinePagerIndicator.setMode(2);
            gradientLinePagerIndicator.setLineHeight(com.blankj.utilcode.util.i.e(3.0f));
            gradientLinePagerIndicator.setLineWidth(com.blankj.utilcode.util.i.e(24.0f));
            gradientLinePagerIndicator.setRoundRadius(com.blankj.utilcode.util.i.e(2.0f));
            gradientLinePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
            gradientLinePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
            gradientLinePagerIndicator.setColors(androidx.core.content.b.getColor(context, R$color.main_gradient_start), androidx.core.content.b.getColor(context, R$color.main_gradient_center), androidx.core.content.b.getColor(context, R$color.main_gradient_end));
            return gradientLinePagerIndicator;
        }

        @Override // j00.a
        public j00.d c(Context context, int i11) {
            Intrinsics.h(context, "context");
            TabTitleView tabTitleView = new TabTitleView(context);
            TransferStatusActivity transferStatusActivity = TransferStatusActivity.this;
            tabTitleView.setTextById(transferStatusActivity.tabs[i11].intValue());
            tabTitleView.setOnClickListener(new a(transferStatusActivity, i11));
            return tabTitleView;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends FragmentStateAdapter {
        d() {
            super(TransferStatusActivity.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            if (i11 == 0) {
                TransferReceivedFragment a11 = TransferReceivedFragment.INSTANCE.a();
                TransferStatusActivity.this.receivedFragment = a11;
                return a11;
            }
            if (i11 != 1) {
                TransferSentFragment a12 = TransferSentFragment.INSTANCE.a();
                TransferStatusActivity.this.sentFragment = a12;
                return a12;
            }
            TransferSentFragment a13 = TransferSentFragment.INSTANCE.a();
            TransferStatusActivity.this.sentFragment = a13;
            return a13;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return TransferStatusActivity.this.tabs.length;
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends androidx.activity.u {
        e() {
            super(true);
        }

        @Override // androidx.activity.u
        public void handleOnBackPressed() {
            if (TransferStatusActivity.this.isSelectFragmentShown) {
                TransferStatusActivity.this.V0();
            } else if (TransferStatusActivity.this.S0().j() || TransferStatusActivity.this.Q0().x()) {
                TransferStatusActivity.this.q1();
            } else {
                TransferStatusActivity.this.m1();
                TransferStatusActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class f implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f55777a;

        f(Function1 function) {
            Intrinsics.h(function, "function");
            this.f55777a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f55777a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.view.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f55777a.invoke(obj);
        }
    }

    /* loaded from: classes6.dex */
    public static final class g implements com.transsion.transfer.impl.g {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(TransferStatusActivity transferStatusActivity, String str) {
            TransferStatusActivity.INSTANCE.a();
            transferStatusActivity.P0(true, str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.transsion.transfer.impl.g
        public void a(String clientIp, final String clientDeviceName) {
            Intrinsics.h(clientIp, "clientIp");
            Intrinsics.h(clientDeviceName, "clientDeviceName");
            ConstraintLayout root = ((gv.b) TransferStatusActivity.this.getMViewBinding()).getRoot();
            final TransferStatusActivity transferStatusActivity = TransferStatusActivity.this;
            root.post(new Runnable() { // from class: com.transsion.transfer.impl.t0
                @Override // java.lang.Runnable
                public final void run() {
                    TransferStatusActivity.g.d(TransferStatusActivity.this, clientDeviceName);
                }
            });
        }

        @Override // com.transsion.transfer.impl.g
        public String b() {
            String MODEL = Build.MODEL;
            Intrinsics.g(MODEL, "MODEL");
            return MODEL;
        }
    }

    /* loaded from: classes6.dex */
    public static final class h implements hv.b {
        h() {
        }

        @Override // hv.b
        public void a() {
            TransferStatusActivity.this.V0();
            TransferSentFragment transferSentFragment = TransferStatusActivity.this.sentFragment;
            if (transferSentFragment != null) {
                transferSentFragment.p0();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // hv.b
        public void b() {
            TransferStatusActivity.this.V0();
            TransferStatusActivity.this.S0().z(1);
            ((gv.b) TransferStatusActivity.this.getMViewBinding()).f64094m.setCurrentItem(1, true);
            TransferSentFragment transferSentFragment = TransferStatusActivity.this.sentFragment;
            if (transferSentFragment != null) {
                transferSentFragment.p0();
            }
        }

        @Override // hv.b
        public void c() {
            TransferStatusActivity.this.q1();
        }
    }

    static {
        String name = TransferStatusActivity.class.getName();
        Intrinsics.g(name, "getName(...)");
        f55758m = name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void N0() {
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setFollowTouch(true);
        commonNavigator.setAdapter(new c());
        ((gv.b) getMViewBinding()).f64087f.setNavigator(commonNavigator);
        ((gv.b) getMViewBinding()).f64094m.registerOnPageChangeCallback(new b());
        ((gv.b) getMViewBinding()).f64094m.setCurrentItem(this.selectTabIndex, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClientViewModel O0(TransferStatusActivity transferStatusActivity) {
        return (ClientViewModel) new v0(transferStatusActivity).a(ClientViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void P0(boolean connected, String deviceName) {
        if (connected) {
            hv.a aVar = this.selectFragment;
            if (aVar != null) {
                aVar.L();
            }
            ((gv.b) getMViewBinding()).f64092k.setImageResource(R$mipmap.transfer_ic_link);
            ((gv.b) getMViewBinding()).f64090i.setText(getString(R$string.transfer_disconnect));
            ((gv.b) getMViewBinding()).f64091j.setText(getString(R$string.transfer_state_connect_tips, ((gv.b) getMViewBinding()).f64091j.getTag() == null ? deviceName : ((gv.b) getMViewBinding()).f64091j.getTag().toString()));
            if (deviceName.length() > 0) {
                ((gv.b) getMViewBinding()).f64091j.setTag(deviceName);
                return;
            }
            return;
        }
        hv.a aVar2 = this.selectFragment;
        if (aVar2 != null) {
            aVar2.c();
        }
        ((gv.b) getMViewBinding()).f64092k.setImageResource(R$mipmap.transfer_ic_unlink);
        ((gv.b) getMViewBinding()).f64090i.setText("");
        ((gv.b) getMViewBinding()).f64091j.setText(getString(R$string.transfer_state_disconnect_tips, ((gv.b) getMViewBinding()).f64091j.getTag() == null ? deviceName : ((gv.b) getMViewBinding()).f64091j.getTag().toString()));
        if (deviceName.length() > 0) {
            ((gv.b) getMViewBinding()).f64091j.setTag(deviceName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClientViewModel Q0() {
        return (ClientViewModel) this.clientViewModel.getValue();
    }

    private final g R0() {
        return (g) this.serverFileHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k S0() {
        return (k) this.serverViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0() {
        Object obj = this.selectFragment;
        if (obj != null) {
            this.isSelectFragmentShown = false;
            getSupportFragmentManager().p().p((Fragment) obj).l();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void W0() {
        if (!Q0().x() || Q0().p() == null) {
            if (!f55759n) {
                String p11 = Q0().p();
                P0(false, p11 != null ? p11 : "");
            }
            Q0().q().j(this, new f(new Function1() { // from class: com.transsion.transfer.impl.r0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit X0;
                    X0 = TransferStatusActivity.X0(TransferStatusActivity.this, (String) obj);
                    return X0;
                }
            }));
        } else {
            ((gv.b) getMViewBinding()).f64091j.setText(Q0().p());
            hv.a aVar = this.selectFragment;
            if (aVar != null) {
                String p12 = Q0().p();
                if (p12 == null) {
                    p12 = "";
                }
                aVar.C(p12);
            }
            String p13 = Q0().p();
            P0(true, p13 != null ? p13 : "");
        }
        Q0().o().j(this, new f(new Function1() { // from class: com.transsion.transfer.impl.s0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Y0;
                Y0 = TransferStatusActivity.Y0(TransferStatusActivity.this, (Boolean) obj);
                return Y0;
            }
        }));
        Q0().n().j(this, new f(new Function1() { // from class: com.transsion.transfer.impl.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Z0;
                Z0 = TransferStatusActivity.Z0(TransferStatusActivity.this, (Integer) obj);
                return Z0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit X0(TransferStatusActivity transferStatusActivity, String str) {
        if (str == null) {
            return Unit.f67184a;
        }
        ((gv.b) transferStatusActivity.getMViewBinding()).f64091j.setText(str);
        hv.a aVar = transferStatusActivity.selectFragment;
        if (aVar != null) {
            String p11 = transferStatusActivity.Q0().p();
            if (p11 == null) {
                p11 = "";
            }
            aVar.C(p11);
        }
        String p12 = transferStatusActivity.Q0().p();
        transferStatusActivity.P0(true, p12 != null ? p12 : "");
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(TransferStatusActivity transferStatusActivity, Boolean bool) {
        boolean z10 = bool.booleanValue() || transferStatusActivity.S0().j();
        String p11 = transferStatusActivity.Q0().p();
        if (p11 == null) {
            p11 = "";
        }
        transferStatusActivity.P0(z10, p11);
        if (bool.booleanValue()) {
            transferStatusActivity.Q0().s(true);
        } else {
            TransferReceivedFragment transferReceivedFragment = transferStatusActivity.receivedFragment;
            if (transferReceivedFragment != null) {
                transferReceivedFragment.t0();
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit Z0(TransferStatusActivity transferStatusActivity, Integer num) {
        if (num != null && num.intValue() == 1) {
            ((gv.b) transferStatusActivity.getMViewBinding()).f64094m.setCurrentItem(0, true);
            kv.b.f68518a.k(TransferClient.f55788t.k());
            TransferReceivedFragment transferReceivedFragment = transferStatusActivity.receivedFragment;
            if (transferReceivedFragment != null) {
                transferReceivedFragment.m0();
            }
        }
        return Unit.f67184a;
    }

    private final void a1() {
        if (f55759n) {
            String p11 = S0().p();
            boolean z10 = !(p11 == null || p11.length() == 0);
            hv.a aVar = this.selectFragment;
            if (aVar != null) {
                String p12 = S0().p();
                if (p12 == null) {
                    p12 = "";
                }
                aVar.C(p12);
            }
            String p13 = S0().p();
            P0(z10, p13 != null ? p13 : "");
        }
        S0().k().j(this, new f(new Function1() { // from class: com.transsion.transfer.impl.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit b12;
                b12 = TransferStatusActivity.b1(TransferStatusActivity.this, (String) obj);
                return b12;
            }
        }));
        S0().o().j(this, new f(new Function1() { // from class: com.transsion.transfer.impl.c0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit c12;
                c12 = TransferStatusActivity.c1(TransferStatusActivity.this, (Pair) obj);
                return c12;
            }
        }));
        S0().n().j(this, new f(new Function1() { // from class: com.transsion.transfer.impl.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit d12;
                d12 = TransferStatusActivity.d1(TransferStatusActivity.this, (String) obj);
                return d12;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit b1(TransferStatusActivity transferStatusActivity, String str) {
        ((gv.b) transferStatusActivity.getMViewBinding()).f64091j.setText(str);
        hv.a aVar = transferStatusActivity.selectFragment;
        if (aVar != null) {
            aVar.C(str == null ? "" : str);
        }
        Intrinsics.e(str);
        transferStatusActivity.P0(true, str);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(TransferStatusActivity transferStatusActivity, Pair pair) {
        boolean booleanValue = ((Boolean) pair.getSecond()).booleanValue();
        String p11 = transferStatusActivity.S0().p();
        if (p11 == null) {
            p11 = "";
        }
        transferStatusActivity.P0(booleanValue, p11);
        if (transferStatusActivity.needServerAsClientFetchList) {
            transferStatusActivity.needServerAsClientFetchList = false;
            if (((Boolean) pair.getSecond()).booleanValue()) {
                transferStatusActivity.s1();
            } else {
                transferStatusActivity.m1();
                transferStatusActivity.finish();
            }
        } else if (!((Boolean) pair.getSecond()).booleanValue()) {
            TransferReceivedFragment transferReceivedFragment = transferStatusActivity.receivedFragment;
            if (transferReceivedFragment != null) {
                transferReceivedFragment.t0();
            }
            TransferReceivedFragment transferReceivedFragment2 = transferStatusActivity.receivedFragment;
            if (transferReceivedFragment2 != null) {
                transferReceivedFragment2.t0();
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(final TransferStatusActivity transferStatusActivity, String str) {
        TransferClient.a aVar = TransferClient.f55788t;
        Intrinsics.e(str);
        TransferClient.a.m(aVar, str, WifiUtils.f56083a.l(), null, new Function0() { // from class: com.transsion.transfer.impl.f0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit e12;
                e12 = TransferStatusActivity.e1(TransferStatusActivity.this);
                return e12;
            }
        }, 4, null);
        kv.b.f68518a.t(aVar.k());
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit e1(final TransferStatusActivity transferStatusActivity) {
        ((gv.b) transferStatusActivity.getMViewBinding()).getRoot().post(new Runnable() { // from class: com.transsion.transfer.impl.h0
            @Override // java.lang.Runnable
            public final void run() {
                TransferStatusActivity.f1(TransferStatusActivity.this);
            }
        });
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(final TransferStatusActivity transferStatusActivity) {
        transferStatusActivity.W0();
        transferStatusActivity.Q0().k(new Function2() { // from class: com.transsion.transfer.impl.i0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit g12;
                g12 = TransferStatusActivity.g1(TransferStatusActivity.this, ((Boolean) obj).booleanValue(), (String) obj2);
                return g12;
            }
        });
        transferStatusActivity.Q0().s(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(TransferStatusActivity transferStatusActivity, boolean z10, String error) {
        Intrinsics.h(error, "error");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("initServerVM: getClientOpenServerEventSource connect res:");
        sb2.append(z10);
        if (!z10) {
            transferStatusActivity.Q0().k(new Function2() { // from class: com.transsion.transfer.impl.j0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit h12;
                    h12 = TransferStatusActivity.h1(((Boolean) obj).booleanValue(), (String) obj2);
                    return h12;
                }
            });
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(boolean z10, String autoError) {
        Intrinsics.h(autoError, "autoError");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("initServerVM: getClientOpenServerEventSource auto retry connect res:");
        sb2.append(z10);
        sb2.append(", autoError:");
        sb2.append(autoError);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(final TransferStatusActivity transferStatusActivity, View view) {
        if (f55759n) {
            if (transferStatusActivity.S0().j()) {
                kv.b.f68518a.u(transferStatusActivity.S0().t());
                transferStatusActivity.s1();
                return;
            } else {
                transferStatusActivity.m1();
                transferStatusActivity.finish();
                return;
            }
        }
        if (!transferStatusActivity.Q0().x()) {
            transferStatusActivity.m1();
            transferStatusActivity.finish();
            return;
        }
        if (!transferStatusActivity.S0().y()) {
            transferStatusActivity.S0().A();
        }
        if (transferStatusActivity.S0().m().isEmpty()) {
            transferStatusActivity.Q0().z(new Function1() { // from class: com.transsion.transfer.impl.p0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit j12;
                    j12 = TransferStatusActivity.j1(TransferStatusActivity.this, ((Boolean) obj).booleanValue());
                    return j12;
                }
            });
        } else {
            transferStatusActivity.s1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initData() {
        a1();
        W0();
        ((gv.b) getMViewBinding()).f64094m.setCurrentItem(f55759n ? 1 : 0);
        if (f55759n) {
            List l11 = S0().l();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("initData: clientIps:");
            sb2.append(l11);
            List m11 = S0().m();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("initData: clientNames:");
            sb3.append(m11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        ((gv.b) getMViewBinding()).f64094m.setAdapter(new d());
        N0();
        ((gv.b) getMViewBinding()).f64088g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.transfer.impl.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferStatusActivity.i1(TransferStatusActivity.this, view);
            }
        });
        ((gv.b) getMViewBinding()).f64090i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.transfer.impl.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TransferStatusActivity.l1(TransferStatusActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit j1(final TransferStatusActivity transferStatusActivity, boolean z10) {
        kv.b.f68518a.l(TransferClient.f55788t.k());
        if (transferStatusActivity.S0().m().isEmpty()) {
            transferStatusActivity.needServerAsClientFetchList = true;
        } else {
            ((gv.b) transferStatusActivity.getMViewBinding()).getRoot().post(new Runnable() { // from class: com.transsion.transfer.impl.g0
                @Override // java.lang.Runnable
                public final void run() {
                    TransferStatusActivity.k1(TransferStatusActivity.this);
                }
            });
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(TransferStatusActivity transferStatusActivity) {
        transferStatusActivity.s1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(TransferStatusActivity transferStatusActivity, View view) {
        transferStatusActivity.q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m1() {
        mv.b.f70138a.b();
        mv.a.f70136a.b();
        S0().C();
        iv.h.f65759s.a();
        av.c cVar = av.c.f16229a;
        cVar.j();
        cVar.i();
        Q0().B(new Function0() { // from class: com.transsion.transfer.impl.q0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit n12;
                n12 = TransferStatusActivity.n1();
                return n12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1() {
        WifiCreateManager.f56005a.j();
        av.c cVar = av.c.f16229a;
        cVar.f();
        WifiConnectionManager.f55955a.s();
        cVar.e();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g o1(TransferStatusActivity transferStatusActivity) {
        return new g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k p1(TransferStatusActivity transferStatusActivity) {
        k kVar = (k) new v0(transferStatusActivity).a(k.class);
        kVar.B(transferStatusActivity.R0());
        kVar.z(1);
        return kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1() {
        TransferDisconnectTipsDialog transferDisconnectTipsDialog = new TransferDisconnectTipsDialog();
        transferDisconnectTipsDialog.r0(new Function1() { // from class: com.transsion.transfer.impl.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit r12;
                r12 = TransferStatusActivity.r1(TransferStatusActivity.this, ((Boolean) obj).booleanValue());
                return r12;
            }
        });
        transferDisconnectTipsDialog.k0(this, "transfer_disconnect_tips_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(TransferStatusActivity transferStatusActivity, boolean z10) {
        if (z10) {
            if (f55759n) {
                kv.b.f68518a.p(transferStatusActivity.S0().t());
            } else {
                kv.b.f68518a.f(TransferClient.f55788t.k());
            }
            transferStatusActivity.m1();
            transferStatusActivity.finish();
        }
        return Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s1() {
        Fragment k02 = getSupportFragmentManager().k0("TransferSelectFragment");
        if (k02 == null) {
            hv.a T0 = T0();
            if (T0 != 0) {
                T0.v(new h());
            }
            Intrinsics.f(T0, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            k02 = (Fragment) T0;
        }
        hv.a aVar = (hv.a) k02;
        this.selectFragment = aVar;
        if (aVar != null) {
            aVar.N(Q0().w() + S0().w(), Q0().r() + S0().s());
        }
        this.isSelectFragmentShown = true;
        if (k02.isAdded()) {
            getSupportFragmentManager().p().y(k02).l();
        } else {
            getSupportFragmentManager().p().c(R$id.fl_select_page_container, k02, "TransferSelectFragment").l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final hv.a t1() {
        IDownloadApiProvider iDownloadApiProvider = (IDownloadApiProvider) TheRouter.d(IDownloadApiProvider.class, new Object[0]);
        Object a11 = iDownloadApiProvider != null ? iDownloadApiProvider.a() : null;
        Intrinsics.f(a11, "null cannot be cast to non-null type com.transsion.transfer.impl.listener.ITransferSelectView");
        return (hv.a) a11;
    }

    public final hv.a T0() {
        return (hv.a) this.transferSelectFragment.getValue();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public gv.b getViewBinding() {
        gv.b c11 = gv.b.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        initView();
        initData();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return !ak.x.f733a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String l11 = WifiUtils.f56083a.l();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onCreate: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        sb2.append(l11);
        ImageView vTopBg = ((gv.b) getMViewBinding()).f64093l;
        Intrinsics.g(vTopBg, "vTopBg");
        jg.c.e(vTopBg);
        getWindow().addFlags(128);
        getOnBackPressedDispatcher().i(this, new e());
    }
}
