package com.transsion.postdetail.layer.local;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.SubtitleBean;
import com.transsion.baseui.R$drawable;
import com.transsion.baseui.R$string;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.player.longvideo.ui.LongVodPlayerView;
import com.transsion.player.longvideo.ui.dialog.PlayerSettingDialog;
import com.transsion.player.p007enum.ScaleMode;
import com.transsion.postdetail.layer.SystemTimeManager;
import com.transsion.postdetail.layer.listener.LayerFlag;
import com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment;
import com.transsion.postdetail.ui.view.ImmScaleView;
import com.transsion.postdetail.ui.view.ImmSpeedView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes6.dex */
public final class u0 extends a0 {

    /* renamed from: b0, reason: collision with root package name */
    private final Fragment f49161b0;

    /* renamed from: c0, reason: collision with root package name */
    private so.z f49162c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f49163d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f49164e0;

    /* renamed from: f0, reason: collision with root package name */
    private final int f49165f0;

    /* renamed from: g0, reason: collision with root package name */
    private final int f49166g0;

    /* renamed from: h0, reason: collision with root package name */
    private final int f49167h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f49168i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f49169j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f49170k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f49171l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f49172m0;

    /* renamed from: n0, reason: collision with root package name */
    private float f49173n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f49174o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f49175p0;

    /* renamed from: q0, reason: collision with root package name */
    private float f49176q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f49177r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f49178s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f49179t0;

    /* renamed from: u0, reason: collision with root package name */
    private View f49180u0;

    /* renamed from: v0, reason: collision with root package name */
    private long f49181v0;

    /* renamed from: w0, reason: collision with root package name */
    private final Lazy f49182w0;

    /* renamed from: x0, reason: collision with root package name */
    private k0 f49183x0;

    /* renamed from: y0, reason: collision with root package name */
    private int f49184y0;

    /* renamed from: z0, reason: collision with root package name */
    private int f49185z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(Fragment fragment) {
        super(fragment);
        Intrinsics.h(fragment, "fragment");
        this.f49161b0 = fragment;
        this.f49165f0 = com.blankj.utilcode.util.a0.a(24.0f);
        this.f49166g0 = com.blankj.utilcode.util.a0.a(16.0f);
        this.f49167h0 = com.blankj.utilcode.util.a0.a(20.0f);
        this.f49176q0 = 1.0f;
        this.f49179t0 = true;
        this.f49182w0 = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.layer.local.t0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean S3;
                S3 = u0.S3();
                return Boolean.valueOf(S3);
            }
        });
        this.f49184y0 = -1;
    }

    private final void A3(boolean z10, boolean z11) {
        k0 C3;
        Fragment fragment = this.f49161b0;
        LocalVideoDetailFragment localVideoDetailFragment = fragment instanceof LocalVideoDetailFragment ? (LocalVideoDetailFragment) fragment : null;
        if (localVideoDetailFragment != null) {
            localVideoDetailFragment.d2();
        }
        if (z11 && (C3 = C3()) != null) {
            C3.d(z10);
        }
        long j11 = z10 ? RangesKt.j(this.f49181v0 + 10000, n1()) : RangesKt.g(this.f49181v0 - 10000, 0L);
        this.f49181v0 = j11;
        com.transsion.player.orplayer.g H = H();
        if (H != null) {
            H.seekTo(j11);
        }
    }

    static /* synthetic */ void B3(u0 u0Var, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        u0Var.A3(z10, z11);
    }

    private final k0 C3() {
        so.z zVar;
        ViewStub viewStub;
        View inflate;
        if (this.f49183x0 == null && (zVar = this.f49162c0) != null && (viewStub = zVar.S) != null && (inflate = viewStub.inflate()) != null) {
            so.a0 a11 = so.a0.a(inflate);
            Intrinsics.g(a11, "bind(...)");
            this.f49183x0 = new k0(a11);
        }
        return this.f49183x0;
    }

    private final boolean D3() {
        return ((Boolean) this.f49182w0.getValue()).booleanValue();
    }

    private final Map E3(String str) {
        Pair pair = new Pair("module_name", str);
        Pair pair2 = new Pair("subject_id", k1());
        DownloadBean S0 = S0();
        return MapsKt.l(pair, pair2, new Pair("ops", S0 != null ? S0.getOps() : null), new Pair("resource_id", i1()));
    }

    private final void F3() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            if (!D3()) {
                zVar.f75918h.setText((CharSequence) null);
                TextView tvPlayScale = zVar.f75932v;
                Intrinsics.g(tvPlayScale, "tvPlayScale");
                jg.c.g(tvPlayScale);
                zVar.f75930t.setText((CharSequence) null);
            }
            zVar.f75933w.updateSpeed(com.transsion.baselib.helper.d.f43319a.d(), true);
        }
    }

    private final void G3() {
        this.f49176q0 = 0.7222222f;
        int i11 = this.f49163d0;
        int i12 = (int) (i11 * 0.7222222f);
        this.f49169j0 = i12;
        this.f49168i0 = (i11 - i12) / 2;
        int i13 = this.f49165f0;
        this.f49172m0 = i12 + (i13 * 2);
        int i14 = (int) (((r2 * 9) * 1.0f) / 16);
        this.f49171l0 = i14;
        int i15 = this.f49164e0;
        int i16 = (int) (i15 * 0.7222222f);
        this.f49170k0 = i16;
        int i17 = (((i15 - i16) - (i13 / 3)) - i14) / 2;
        this.f49175p0 = i17;
        this.f49174o0 = (i13 / 3) + i14 + i17;
        this.f49173n0 = (((i15 - i16) * 1.0f) / 2) - i17;
        a.C0856a c0856a = lg.a.f68962a;
        String m12 = m1();
        Intrinsics.g(m12, "<get-TAG>(...)");
        a.C0856a.f(c0856a, m12, "initAdHW ,playerStartSpace = " + this.f49175p0 + ", playerEndSpace = " + this.f49174o0, false, 4, null);
    }

    private final void H3(int i11) {
        ViewGroup.LayoutParams bVar;
        ViewGroup.LayoutParams bVar2;
        View view;
        View view2;
        View view3;
        View view4;
        Log.e(m1(), "initSpace rotation:" + i11);
        if (this.f49184y0 == i11) {
            return;
        }
        this.f49184y0 = i11;
        if (this.f49185z0 == 0) {
            this.f49185z0 = com.blankj.utilcode.util.d.c();
        }
        so.z zVar = this.f49162c0;
        if (zVar == null || (view4 = zVar.E) == null || (bVar = view4.getLayoutParams()) == null) {
            bVar = new ConstraintLayout.b(-2, -2);
        }
        bVar.width = i11 == 1 ? this.f49185z0 : 0;
        so.z zVar2 = this.f49162c0;
        if (zVar2 != null && (view3 = zVar2.E) != null) {
            view3.setLayoutParams(bVar);
        }
        so.z zVar3 = this.f49162c0;
        if (zVar3 == null || (view2 = zVar3.D) == null || (bVar2 = view2.getLayoutParams()) == null) {
            bVar2 = new ConstraintLayout.b(-2, -2);
        }
        bVar2.width = i11 == 3 ? this.f49185z0 : 0;
        so.z zVar4 = this.f49162c0;
        if (zVar4 == null || (view = zVar4.D) == null) {
            return;
        }
        view.setLayoutParams(bVar2);
    }

    private final void I3(String str, boolean z10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J3(u0 u0Var, String str, LocalVideoDetailFragment localVideoDetailFragment, View view) {
        so.z zVar;
        AppCompatTextView appCompatTextView;
        view.setSelected(!view.isSelected());
        if (view.isSelected()) {
            u0Var.v1(true);
            Intrinsics.e(view);
            jg.c.k(view);
            Context context = view.getContext();
            Intrinsics.f(context, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context).setRequestedOrientation(11);
        } else {
            Context context2 = view.getContext();
            Intrinsics.f(context2, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context2).setRequestedOrientation(6);
            u0Var.A2(true);
        }
        hj.i iVar = hj.i.f64628a;
        Pair pair = new Pair("module_name", "lock");
        Pair pair2 = new Pair("subject_id", u0Var.k1());
        DownloadBean S0 = u0Var.S0();
        iVar.p(str, MapsKt.m(pair, pair2, new Pair("ops", S0 != null ? S0.getOps() : null), new Pair(NativeComponentConstants.KEY_COMPONENT_TYPE, view.isSelected() ? "1" : "0")));
        localVideoDetailFragment.a3(view.isSelected());
        u0Var.W0().l(!view.isSelected());
        if (!u0Var.D3() || (zVar = u0Var.f49162c0) == null || (appCompatTextView = zVar.f75918h) == null) {
            return;
        }
        appCompatTextView.setText(view.isSelected() ? u0Var.f49161b0.getString(R$string.play_tap_unlock) : u0Var.f49161b0.getString(R$string.play_tap_lock));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K3(u0 u0Var, View view) {
        ImmScaleView immScaleView;
        so.z zVar = u0Var.f49162c0;
        if (zVar == null || (immScaleView = zVar.f75919i) == null) {
            return;
        }
        immScaleView.performClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L3(u0 u0Var, ScaleMode scaleMode, String name) {
        TextView textView;
        Intrinsics.h(scaleMode, "scaleMode");
        Intrinsics.h(name, "name");
        com.transsion.player.orplayer.g H = u0Var.H();
        if (H != null) {
            H.setScaleMode(scaleMode);
        }
        so.z zVar = u0Var.f49162c0;
        if (zVar != null && (textView = zVar.f75932v) != null) {
            textView.setText(name);
        }
        a0.B2(u0Var, false, 1, null);
        a.C0856a c0856a = lg.a.f68962a;
        String m12 = u0Var.m1();
        Intrinsics.g(m12, "<get-TAG>(...)");
        a.C0856a.f(c0856a, m12, "scaleMode:" + scaleMode, false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M3(u0 u0Var, View view) {
        hj.i.f64628a.p("local_video_detail", u0Var.E3(ToolBar.FORWARD));
        u0Var.v1(false);
        u0Var.A3(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N3(u0 u0Var, View view) {
        hj.i.f64628a.p("local_video_detail", u0Var.E3(ToolBar.BACKWARD));
        u0Var.v1(false);
        u0Var.A3(false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O3(u0 u0Var, View view) {
        bo.c cVar = bo.c.f16723a;
        String k12 = u0Var.k1();
        DownloadBean S0 = u0Var.S0();
        cVar.a("local_video_detail", k12, S0 != null ? S0.getOps() : null, true);
        a0.e2(u0Var, null, false, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P3(u0 u0Var, String str, View view) {
        new PlayerSettingDialog().l0(u0Var.f49161b0, "PlayerSettingDialog");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DownloadBean S0 = u0Var.S0();
        linkedHashMap.put("subject_id", S0 != null ? S0.getSubjectId() : null);
        DownloadBean S02 = u0Var.S0();
        linkedHashMap.put("subject_ops", S02 != null ? S02.getOps() : null);
        DownloadBean S03 = u0Var.S0();
        linkedHashMap.put("ops", S03 != null ? S03.getOps() : null);
        DownloadBean S04 = u0Var.S0();
        linkedHashMap.put("subject_name", S04 != null ? S04.getSubjectName() : null);
        DownloadBean S05 = u0Var.S0();
        linkedHashMap.put("title_name", S05 != null ? S05.getTitleName() : null);
        DownloadBean S06 = u0Var.S0();
        linkedHashMap.put("subject_type", S06 != null ? Integer.valueOf(S06.getSubjectType()).toString() : null);
        linkedHashMap.put("module_name", "video_setting");
        hj.i.f64628a.p(str, linkedHashMap);
    }

    private final void Q3() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R3(u0 u0Var) {
        a.C0856a c0856a = lg.a.f68962a;
        String m12 = u0Var.m1();
        Intrinsics.g(m12, "<get-TAG>(...)");
        a.C0856a.f(c0856a, m12, "land onBackPressed", false, 4, null);
        u0Var.x3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean S3() {
        ConfigBean d11 = sm.f.d(sm.f.f75530c.a(), LongVodPlayerView.PK_NEW_PLAYER_UI_KEY, false, 2, null);
        String value = d11 != null ? d11.getValue() : null;
        return value == null || value.length() == 0;
    }

    private final void x3() {
        FragmentActivity activity = this.f49161b0.getActivity();
        if (activity != null) {
            ImmersionBar.with(activity).hideBar(BarHide.FLAG_SHOW_BAR).init();
            activity.setRequestedOrientation(7);
        }
        F(LayerFlag.LOCAL_UI_CHANGED, LocalUiType.MIDDLE);
    }

    private final void y3() {
        DownloadBean S0 = S0();
        List<SubtitleBean> subtitleList = S0 != null ? S0.getSubtitleList() : null;
        if ((subtitleList == null || subtitleList.isEmpty()) && this.f49179t0) {
            com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
            if (bVar.b().getBoolean("subtitle_is_search_downloaded", false)) {
                this.f49179t0 = false;
                bVar.b().putBoolean("subtitle_land_guide", false);
            } else {
                this.f49179t0 = false;
                bVar.b().putBoolean("subtitle_land_guide", false);
                A2(false);
            }
        }
    }

    private final void z3(int i11, int i12) {
        if ((i11 <= 0 || p1() == i11) && (i12 <= 0 || Y0() == i12)) {
            return;
        }
        z2(i11);
        t2(i12);
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View A0() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.K;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void B(int i11) {
        super.B(i11);
        H3(i11);
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public boolean C0() {
        return false;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ViewGroup D0() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.I;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ViewGroup E0() {
        bk.e eVar;
        so.z zVar = this.f49162c0;
        if (zVar == null || (eVar = zVar.f75912b) == null) {
            return null;
        }
        return eVar.getRoot();
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View F0() {
        bk.e eVar;
        so.z zVar = this.f49162c0;
        if (zVar == null || (eVar = zVar.f75912b) == null) {
            return null;
        }
        return eVar.f16679f;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView G0() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView H0() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView I0() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.J;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    protected void J2(boolean z10) {
        bk.e eVar;
        AppCompatImageView appCompatImageView;
        super.J2(z10);
        so.z zVar = this.f49162c0;
        if (zVar == null || (eVar = zVar.f75912b) == null || (appCompatImageView = eVar.f16677d) == null) {
            return;
        }
        View F0 = F0();
        appCompatImageView.setVisibility((F0 == null || F0.getVisibility() != 0) ? 0 : 4);
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public boolean M1() {
        return this.f49178s0;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ViewGroup N2() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.f75914d;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ImageView O0() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.f75917g;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ImageView O2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View P1() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ProgressBar P2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View Q0() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.C;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView Q2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView R2() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.f75930t;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public SimpleSubtitleView S2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public SimpleSubtitleView T2() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.F;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ViewGroup U2() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.f75915e;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public void V1() {
        x3();
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public SimpleSubtitleView V2() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.G;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public void W1(boolean z10) {
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView W2() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.O;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView X2() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.A;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public void Y1() {
        V1();
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView Y2() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.B;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public void Z1() {
        super.Z1();
        this.f49178s0 = false;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public Group Z2() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.L;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void a(LocalUiType uiType) {
        WindowManager windowManager;
        Display defaultDisplay;
        so.p0 p0Var;
        LinearLayout root;
        Intrinsics.h(uiType, "uiType");
        LocalUiType localUiType = LocalUiType.LAND;
        if (uiType == localUiType) {
            this.f49177r0 = true;
            com.transsion.player.orplayer.g H = H();
            int videoWidth = H != null ? H.getVideoWidth() : 0;
            com.transsion.player.orplayer.g H2 = H();
            z3(videoWidth, H2 != null ? H2.getVideoHeight() : 0);
            a.C0856a c0856a = lg.a.f68962a;
            String m12 = m1();
            Intrinsics.g(m12, "<get-TAG>(...)");
            a.C0856a.f(c0856a, m12, "onLocalUiChanged 2 land", false, 4, null);
            FragmentActivity activity = this.f49161b0.getActivity();
            if (activity != null) {
                ImmersionBar.with(activity).hideBar(BarHide.FLAG_HIDE_BAR).init();
            }
            z0();
            v1(false);
            SystemTimeManager l12 = l1();
            if (l12 != null) {
                l12.d();
            }
            so.z zVar = this.f49162c0;
            if (zVar != null && (p0Var = zVar.H) != null && (root = p0Var.getRoot()) != null) {
                jg.c.g(root);
            }
            y3();
            FragmentActivity activity2 = this.f49161b0.getActivity();
            if (activity2 != null && (windowManager = activity2.getWindowManager()) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
                B(defaultDisplay.getRotation());
            }
        } else if (this.f49178s0) {
            K0();
        }
        lg.a.f68962a.c("long_video_play", "land, onLocalUiChanged uiType = " + uiType, true);
        T1(uiType == localUiType);
        super.a(uiType);
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public void a2(View view) {
        Intrinsics.h(view, "view");
        super.a2(view);
        View view2 = this.f49180u0;
        if (view2 != null) {
            jg.c.g(view2);
        }
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public LocalUiType a3() {
        return LocalUiType.LAND;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View b1() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.f75918h;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void c() {
        super.c();
        this.f49177r0 = false;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ImageView f2() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.M;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ViewGroup g2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView h2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView h3() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.P;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View i2() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.f75931u;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public void i3() {
        super.i3();
    }

    @Override // com.transsion.postdetail.layer.local.a0, com.transsion.player.orplayer.f
    public void initPlayer() {
        super.initPlayer();
        this.f49178s0 = false;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View j1() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.f75935y;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public FrameLayout j3() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.R;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void k(DownloadBean downloadBean, String pageFrom, boolean z10) {
        String url;
        ImmScaleView immScaleView;
        ImmSpeedView immSpeedView;
        String path;
        Intrinsics.h(pageFrom, "pageFrom");
        super.k(downloadBean, pageFrom, z10);
        if (downloadBean == null || (url = downloadBean.getResourceId()) == null) {
            url = downloadBean != null ? downloadBean.getUrl() : "";
        }
        I3(url, downloadBean != null ? downloadBean.isSeries() : false);
        if (downloadBean != null && downloadBean.getType() == 6 && (path = downloadBean.getPath()) != null && StringsKt.c0(path, ".mp3", false, 2, null)) {
            s2(downloadBean.getCover());
        }
        so.z zVar = this.f49162c0;
        if (zVar != null && (immSpeedView = zVar.f75933w) != null) {
            immSpeedView.setOps(downloadBean != null ? downloadBean.getOps() : null);
        }
        so.z zVar2 = this.f49162c0;
        if (zVar2 == null || (immScaleView = zVar2.f75919i) == null) {
            return;
        }
        immScaleView.setOps(downloadBean != null ? downloadBean.getOps() : null);
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View k2() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.f75934x;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView k3() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.Q;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void m(LocalUiType newConfig) {
        Intrinsics.h(newConfig, "newConfig");
        super.m(newConfig);
        if (newConfig == LocalUiType.MIDDLE) {
            x3();
        }
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ViewStub m3() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.U;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ConstraintLayout n2() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.f75922l;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ViewStub n3() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.V;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void o(float f11) {
        ImmSpeedView immSpeedView;
        super.o(f11);
        so.z zVar = this.f49162c0;
        if (zVar == null || (immSpeedView = zVar.f75933w) == null) {
            return;
        }
        ImmSpeedView.updateSpeed$default(immSpeedView, f11, false, 2, null);
    }

    @Override // vo.d
    public void onBackPressed() {
        ConstraintLayout constraintLayout;
        so.z zVar = this.f49162c0;
        if (zVar == null || (constraintLayout = zVar.f75922l) == null) {
            return;
        }
        constraintLayout.postDelayed(new Runnable() { // from class: com.transsion.postdetail.layer.local.s0
            @Override // java.lang.Runnable
            public final void run() {
                u0.R3(u0.this);
            }
        }, 30L);
    }

    @Override // com.transsion.postdetail.layer.local.a0, com.transsion.player.orplayer.f
    public void onCompletion(ao.e eVar) {
        super.onCompletion(eVar);
    }

    @Override // com.transsion.postdetail.layer.local.a0, com.transsion.player.orplayer.f
    public void onProgress(long j11, ao.e eVar) {
        super.onProgress(j11, eVar);
        if (isVisible()) {
            this.f49181v0 = j11;
        }
    }

    @Override // com.transsion.postdetail.layer.local.a0, com.transsion.player.orplayer.f
    public void onVideoPause(ao.e eVar) {
        super.onVideoPause(eVar);
        isVisible();
    }

    @Override // com.transsion.postdetail.layer.local.a0, com.transsion.player.orplayer.f
    public void onVideoSizeChanged(int i11, int i12) {
        z3(i11, i12);
        super.onVideoSizeChanged(i11, i12);
        a.C0856a c0856a = lg.a.f68962a;
        String m12 = m1();
        Intrinsics.g(m12, "<get-TAG>(...)");
        c0856a.c(m12, "onVideoSizeChanged, width = " + i11 + ", height = " + i12, true);
    }

    @Override // com.transsion.postdetail.layer.local.a0, com.transsion.player.orplayer.f
    public void onVideoStart(ao.e eVar) {
        super.onVideoStart(eVar);
        isVisible();
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void p(String resourceId, String subjectId, String postId, boolean z10, boolean z11) {
        String str;
        ImmScaleView immScaleView;
        ImmSpeedView immSpeedView;
        Intrinsics.h(resourceId, "resourceId");
        Intrinsics.h(subjectId, "subjectId");
        Intrinsics.h(postId, "postId");
        super.p(resourceId, subjectId, postId, z10, z11);
        v2(subjectId);
        Fragment fragment = this.f49161b0;
        Intrinsics.f(fragment, "null cannot be cast to non-null type com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment");
        hj.b logViewConfig = ((LocalVideoDetailFragment) fragment).getLogViewConfig();
        if (logViewConfig == null || (str = logViewConfig.f()) == null) {
            str = "";
        }
        so.z zVar = this.f49162c0;
        if (zVar != null && (immSpeedView = zVar.f75933w) != null) {
            immSpeedView.setPageParams(str, subjectId);
        }
        so.z zVar2 = this.f49162c0;
        if (zVar2 != null && (immScaleView = zVar2.f75919i) != null) {
            immScaleView.setPageParams(str, subjectId);
        }
        I3(resourceId, z11);
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View p2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void q(int i11, int i12) {
        super.q(i11, i12);
        a.C0856a c0856a = lg.a.f68962a;
        String m12 = m1();
        Intrinsics.g(m12, "<get-TAG>(...)");
        a.C0856a.f(c0856a, m12, "addSurface, width = " + i11 + ", height = " + i12, false, 4, null);
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View q1() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.f75924n;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public SecondariesSeekBar q2() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.N;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void r(View rootView, LocalUiType uiType) {
        final String str;
        AppCompatTextView appCompatTextView;
        bk.e eVar;
        ImmScaleView immScaleView;
        LinearLayout linearLayout;
        AppCompatTextView appCompatTextView2;
        Intrinsics.h(rootView, "rootView");
        Intrinsics.h(uiType, "uiType");
        if (uiType != LocalUiType.LAND) {
            return;
        }
        this.f49162c0 = so.z.a(rootView);
        super.r(rootView, uiType);
        this.f49163d0 = com.blankj.utilcode.util.y.c();
        int e11 = com.blankj.utilcode.util.y.e();
        this.f49164e0 = e11;
        int i11 = this.f49163d0;
        if (e11 < i11) {
            this.f49164e0 = i11;
            this.f49163d0 = e11;
        }
        int a11 = com.blankj.utilcode.util.d.a();
        if (a11 > 10) {
            this.f49164e0 -= a11;
        }
        Fragment fragment = this.f49161b0;
        Intrinsics.f(fragment, "null cannot be cast to non-null type com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment");
        final LocalVideoDetailFragment localVideoDetailFragment = (LocalVideoDetailFragment) fragment;
        hj.b logViewConfig = localVideoDetailFragment.getLogViewConfig();
        if (logViewConfig == null || (str = logViewConfig.f()) == null) {
            str = "";
        }
        so.z zVar = this.f49162c0;
        if (zVar != null && (appCompatTextView2 = zVar.f75918h) != null) {
            appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.l0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u0.J3(u0.this, str, localVideoDetailFragment, view);
                }
            });
        }
        this.f49179t0 = com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("subtitle_land_guide", true);
        G3();
        Q3();
        so.z zVar2 = this.f49162c0;
        if (zVar2 != null && (linearLayout = zVar2.f75927q) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.m0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u0.K3(u0.this, view);
                }
            });
        }
        so.z zVar3 = this.f49162c0;
        if (zVar3 != null && (immScaleView = zVar3.f75919i) != null) {
            immScaleView.setOnModelChangeListener(new ImmScaleView.a() { // from class: com.transsion.postdetail.layer.local.n0
                @Override // com.transsion.postdetail.ui.view.ImmScaleView.a
                public final void a(ScaleMode scaleMode, String str2) {
                    u0.L3(u0.this, scaleMode, str2);
                }
            });
        }
        so.z zVar4 = this.f49162c0;
        if (zVar4 != null && (eVar = zVar4.f75912b) != null) {
            eVar.f16678e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.o0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u0.M3(u0.this, view);
                }
            });
            eVar.f16676c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.p0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u0.N3(u0.this, view);
                }
            });
            eVar.f16677d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.q0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u0.O3(u0.this, view);
                }
            });
        }
        so.z zVar5 = this.f49162c0;
        if (zVar5 != null && (appCompatTextView = zVar5.f75936z) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.r0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u0.P3(u0.this, str, view);
                }
            });
        }
        F3();
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View r1() {
        so.z zVar = this.f49162c0;
        if (zVar != null) {
            return zVar.f75923m;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public void s1(MotionEvent motionEvent, boolean z10) {
        if (!z10 || motionEvent == null) {
            super.s1(motionEvent, false);
            return;
        }
        int e11 = com.blankj.utilcode.util.y.e() / 3;
        int rawX = (int) motionEvent.getRawX();
        if (rawX >= 0 && rawX <= e11) {
            B3(this, false, false, 2, null);
        } else if (rawX > e11 * 2) {
            B3(this, true, false, 2, null);
        } else {
            super.s1(motionEvent, false);
        }
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public void u2(boolean z10) {
        bk.e eVar;
        AppCompatImageView appCompatImageView;
        super.u2(z10);
        so.z zVar = this.f49162c0;
        if (zVar == null || (eVar = zVar.f75912b) == null || (appCompatImageView = eVar.f16677d) == null) {
            return;
        }
        appCompatImageView.setImageResource(z10 ? R$drawable.ic_player_pause : R$drawable.ic_player_play);
    }
}
