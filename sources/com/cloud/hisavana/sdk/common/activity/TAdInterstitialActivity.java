package com.cloud.hisavana.sdk.common.activity;

import android.R;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cloud.hisavana.sdk.N0;
import com.cloud.hisavana.sdk.P;
import com.cloud.hisavana.sdk.R$dimen;
import com.cloud.hisavana.sdk.R$drawable;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.R$string;
import com.cloud.hisavana.sdk.R$style;
import com.cloud.hisavana.sdk.Z;
import com.cloud.hisavana.sdk.api.view.AdBadgeView;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.AdDisclaimerView;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import com.cloud.hisavana.sdk.common.activity.TAdInterstitialActivity;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.common.util.i0;
import com.cloud.hisavana.sdk.common.util.v;
import com.cloud.hisavana.sdk.common.widget.InteractiveWebView;
import com.cloud.hisavana.sdk.common.widget.TadmWebView;
import com.cloud.hisavana.sdk.common.widget.video.InterstitialAdVideoView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.f4;
import com.cloud.hisavana.sdk.m0;
import com.cloud.hisavana.sdk.s3;
import com.cloud.hisavana.sdk.s4;
import com.cloud.hisavana.sdk.t2;
import com.cloud.hisavana.sdk.v2;
import com.cloud.sdk.commonutil.util.HSToastUtil;
import com.cloud.sdk.commonutil.widget.TranCircleImageView;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes3.dex */
public class TAdInterstitialActivity extends Activity {

    /* renamed from: c0, reason: collision with root package name */
    private static WeakReference f21883c0;
    private long A;
    private int B;
    private boolean C;
    private com.cloud.hisavana.sdk.r E;
    private com.cloud.hisavana.sdk.common.util.v F;
    private e7.e G;
    private e7.d Q;
    private int R;

    /* renamed from: a, reason: collision with root package name */
    private TadmWebView f21884a;

    /* renamed from: a0, reason: collision with root package name */
    private ObjectAnimator f21885a0;

    /* renamed from: b, reason: collision with root package name */
    private TranCircleImageView f21886b;

    /* renamed from: b0, reason: collision with root package name */
    private Runnable f21887b0;

    /* renamed from: c, reason: collision with root package name */
    private AdChoicesView f21888c;

    /* renamed from: d, reason: collision with root package name */
    private AdBadgeView f21889d;

    /* renamed from: e, reason: collision with root package name */
    private AdCloseView f21890e;

    /* renamed from: f, reason: collision with root package name */
    private StoreMarkView f21891f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f21892g;

    /* renamed from: h, reason: collision with root package name */
    private ViewGroup f21893h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f21894i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f21895j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f21896k;

    /* renamed from: l, reason: collision with root package name */
    private InteractiveWebView f21897l;

    /* renamed from: m, reason: collision with root package name */
    private ViewGroup f21898m;

    /* renamed from: n, reason: collision with root package name */
    private ImageView f21899n;

    /* renamed from: o, reason: collision with root package name */
    private InterstitialAdVideoView f21900o;

    /* renamed from: p, reason: collision with root package name */
    private AdDisclaimerView f21901p;

    /* renamed from: q, reason: collision with root package name */
    private AdsDTO f21902q = null;

    /* renamed from: r, reason: collision with root package name */
    private String f21903r = "";

    /* renamed from: s, reason: collision with root package name */
    private float f21904s = 0.0f;

    /* renamed from: t, reason: collision with root package name */
    private boolean f21905t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f21906u = false;

    /* renamed from: v, reason: collision with root package name */
    private boolean f21907v = false;

    /* renamed from: w, reason: collision with root package name */
    private float f21908w = -1.0f;

    /* renamed from: x, reason: collision with root package name */
    private float f21909x = -1.0f;

    /* renamed from: y, reason: collision with root package name */
    private float f21910y = -1.0f;

    /* renamed from: z, reason: collision with root package name */
    private float f21911z = -1.0f;
    private final l D = new l(this);
    private int H = -1;
    private boolean I = false;
    private boolean J = false;
    private boolean K = false;
    private int L = 0;
    private int M = 1;
    private boolean N = false;
    private int O = 0;
    boolean P = false;
    private boolean S = false;
    private boolean T = false;
    private boolean U = false;
    private boolean V = false;
    private int W = -1;
    private int X = -1;
    private int Y = -1;
    private int Z = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements v.a {
        a() {
        }

        @Override // com.cloud.hisavana.sdk.common.util.v.a
        public void a() {
        }

        @Override // com.cloud.hisavana.sdk.common.util.v.a
        public void b() {
        }

        @Override // com.cloud.hisavana.sdk.common.util.v.a
        public void c() {
            TAdInterstitialActivity.this.F.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f21913a;

        b(String str) {
            this.f21913a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.equals(this.f21913a, "I01")) {
                TAdInterstitialActivity.this.i0(view, false);
            } else if (!TAdInterstitialActivity.this.S) {
                TAdInterstitialActivity.this.U(view, false, true);
            } else {
                TAdInterstitialActivity.this.T = true;
                com.cloud.hisavana.sdk.common.util.r.f22275a.s(TAdInterstitialActivity.this.f21884a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends e7.e {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ProgressBar f21915f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ TextView f21916g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View f21917h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ View f21918i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ ImageView f21919j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(long j11, long j12, ProgressBar progressBar, TextView textView, View view, View view2, ImageView imageView) {
            super(j11, j12);
            this.f21915f = progressBar;
            this.f21916g = textView;
            this.f21917h = view;
            this.f21918i = view2;
            this.f21919j = imageView;
        }

        @Override // e7.e
        public void e() {
            TAdInterstitialActivity.this.G.d();
            this.f21917h.setVisibility(0);
            if (this.f21915f != null && TAdInterstitialActivity.this.I) {
                this.f21915f.setVisibility(4);
            } else if (TAdInterstitialActivity.this.f21902q.getMaterialStyle().equals("I01")) {
                this.f21918i.setVisibility(0);
                ImageView imageView = this.f21919j;
                if (imageView != null) {
                    imageView.setImageResource(R$drawable.ad_rewarded_time_rest_done);
                }
                this.f21916g.setText(TAdInterstitialActivity.this.getResources().getString(R$string.hs_download_t01_countdown_tv_done));
            } else {
                this.f21916g.setVisibility(4);
            }
            TAdInterstitialActivity.this.H = 0;
        }

        @Override // e7.e
        public void f(long j11) {
            TAdInterstitialActivity.this.H = (int) Math.ceil(((float) j11) / 1000.0f);
            if (this.f21915f != null && TAdInterstitialActivity.this.I) {
                ProgressBar progressBar = this.f21915f;
                progressBar.setProgress(progressBar.getMax() - TAdInterstitialActivity.this.H);
            } else {
                try {
                    if (TAdInterstitialActivity.this.f21902q.getMaterialStyle().equals("I01")) {
                        this.f21916g.setText(String.format(Locale.getDefault(), TAdInterstitialActivity.this.getResources().getString(R$string.hs_download_t01_countdown_tv), Integer.valueOf(TAdInterstitialActivity.this.H)));
                    } else {
                        this.f21916g.setText(String.valueOf(TAdInterstitialActivity.this.H));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d extends e7.e {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TextView f21921f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ View f21922g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ TextView f21923h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ View f21924i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j11, long j12, TextView textView, View view, TextView textView2, View view2) {
            super(j11, j12);
            this.f21921f = textView;
            this.f21922g = view;
            this.f21923h = textView2;
            this.f21924i = view2;
        }

        @Override // e7.e
        public void e() {
            TAdInterstitialActivity.this.G.d();
            this.f21922g.setEnabled(true);
            this.f21923h.setTextColor(Color.parseColor("#222222"));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f21923h.getLayoutParams();
            layoutParams.setMarginStart(0);
            this.f21923h.setLayoutParams(layoutParams);
            this.f21921f.setVisibility(8);
            this.f21924i.setVisibility(8);
            this.f21922g.requestLayout();
            TAdInterstitialActivity.this.H = 0;
        }

        @Override // e7.e
        public void f(long j11) {
            TAdInterstitialActivity.this.H = (int) Math.ceil(((float) j11) / 1000.0f);
            this.f21921f.setText(String.valueOf(TAdInterstitialActivity.this.H));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TAdInterstitialActivity.this.r(view, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                if (TAdInterstitialActivity.this.S) {
                    TAdInterstitialActivity.this.T = true;
                    TAdInterstitialActivity.this.U = true;
                    com.cloud.hisavana.sdk.common.util.r.f22275a.s(TAdInterstitialActivity.this.f21884a);
                } else {
                    TAdInterstitialActivity.this.r(view, false);
                }
                if (!TAdInterstitialActivity.this.S || TAdInterstitialActivity.this.V) {
                    TAdInterstitialActivity.this.L0();
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class g extends DrawableResponseListener {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(View view) {
            TAdInterstitialActivity.this.i0(view, false);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            if (taErrorCode != null) {
                TAdInterstitialActivity.this.C(taErrorCode.getErrorCode(), taErrorCode.getErrorMessage());
            }
            TAdInterstitialActivity.this.finish();
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (TAdInterstitialActivity.this.f21886b == null || TAdInterstitialActivity.this.f21902q.getMaterialStyle().equals("I01")) {
                return;
            }
            TAdInterstitialActivity.this.f21886b.setOnTouchListener(new m(TAdInterstitialActivity.this, null));
            TAdInterstitialActivity.this.f21886b.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TAdInterstitialActivity.g.this.j(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class h extends f4 {
        h(AdsDTO adsDTO) {
            super(adsDTO);
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void b() {
            if (!TAdInterstitialActivity.this.f21906u) {
                super.b();
            }
            TAdInterstitialActivity.this.f21906u = true;
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void c(long j11, long j12, int i11) {
            if (TAdInterstitialActivity.this.f21907v) {
                return;
            }
            super.c(j11, j12, i11);
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void onComplete() {
            if (!TAdInterstitialActivity.this.f21907v) {
                super.onComplete();
            }
            TAdInterstitialActivity.this.f21907v = true;
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void onVolumeChanged(float f11) {
            super.onVolumeChanged(f11);
            if (TAdInterstitialActivity.this.f21899n == null) {
                return;
            }
            TAdInterstitialActivity.this.f21904s = f11;
            TAdInterstitialActivity.this.B(f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class i extends DrawableResponseListener {
        i() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(View view) {
            TAdInterstitialActivity.this.i0(view, false);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            if (taErrorCode != null) {
                TAdInterstitialActivity.this.C(taErrorCode.getErrorCode(), taErrorCode.getErrorMessage());
            }
            TAdInterstitialActivity.this.finish();
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (adImage != null && adImage.isAdImageRecycled()) {
                TAdInterstitialActivity.this.C(i11, "bitmap is null");
                TAdInterstitialActivity.this.finish();
            } else {
                if (TAdInterstitialActivity.this.f21886b == null || TAdInterstitialActivity.this.f21902q.getMaterialStyle().equals("I01")) {
                    return;
                }
                TAdInterstitialActivity.this.f21886b.setOnTouchListener(new m(TAdInterstitialActivity.this, null));
                TAdInterstitialActivity.this.f21886b.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.e0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TAdInterstitialActivity.i.this.j(view);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class j implements s4 {
        j() {
        }

        @Override // com.cloud.hisavana.sdk.s4
        public void a() {
            TAdInterstitialActivity.this.V = true;
            if (TAdInterstitialActivity.this.U) {
                e4.b().d("TAdInterstitialActivity", "handleThePageClosingProcess closeAd");
                TAdInterstitialActivity.this.L0();
            }
        }

        @Override // com.cloud.hisavana.sdk.s4
        public void a(String str, int i11) {
            try {
                if (TAdInterstitialActivity.this.f21902q != null) {
                    String triggerId = TAdInterstitialActivity.this.f21902q.getTriggerId();
                    String codeSeatId = TAdInterstitialActivity.this.f21902q.getCodeSeatId();
                    Bundle bundle = new Bundle();
                    bundle.putString("s_err_code", i11 + "");
                    bundle.putString("error_url", str);
                    SSPTrackingHelper.f22035a.N(Integer.valueOf(TaErrorCode.ERROR_SHOW_ADM_LOAD_WEB_MATERIAL_ERROR.getErrorCode()), triggerId, codeSeatId, TAdInterstitialActivity.this.f21902q, bundle);
                }
            } catch (Throwable unused) {
            }
            TAdInterstitialActivity.this.L0();
        }

        @Override // com.cloud.hisavana.sdk.s4
        public int b(float f11, float f12, float f13, float f14, boolean z10) {
            if (TAdInterstitialActivity.this.S) {
                TAdInterstitialActivity tAdInterstitialActivity = TAdInterstitialActivity.this;
                tAdInterstitialActivity.D(tAdInterstitialActivity.f21884a, f11, f12, f13, f14);
            } else {
                TAdInterstitialActivity.this.f21908w = f11;
                TAdInterstitialActivity.this.f21909x = f12;
                TAdInterstitialActivity.this.f21910y = f13;
                TAdInterstitialActivity.this.f21911z = f14;
            }
            if (!TAdInterstitialActivity.this.S) {
                TAdInterstitialActivity tAdInterstitialActivity2 = TAdInterstitialActivity.this;
                return tAdInterstitialActivity2.h0(tAdInterstitialActivity2.f21884a);
            }
            boolean z11 = TAdInterstitialActivity.this.T;
            TAdInterstitialActivity.this.T = false;
            TAdInterstitialActivity tAdInterstitialActivity3 = TAdInterstitialActivity.this;
            return tAdInterstitialActivity3.V(tAdInterstitialActivity3.f21884a, false, z11, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class k implements InteractiveWebView.c {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference f21932a;

        public k(TAdInterstitialActivity tAdInterstitialActivity) {
            this.f21932a = new WeakReference(tAdInterstitialActivity);
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.c
        public void a(String str) {
            TAdInterstitialActivity tAdInterstitialActivity;
            WeakReference weakReference = this.f21932a;
            if (weakReference == null || (tAdInterstitialActivity = (TAdInterstitialActivity) weakReference.get()) == null) {
                return;
            }
            tAdInterstitialActivity.k0(str);
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.c
        public void b() {
            TAdInterstitialActivity tAdInterstitialActivity;
            WeakReference weakReference = this.f21932a;
            if (weakReference == null || (tAdInterstitialActivity = (TAdInterstitialActivity) weakReference.get()) == null) {
                return;
            }
            tAdInterstitialActivity.D(tAdInterstitialActivity.f21897l, tAdInterstitialActivity.f21908w, tAdInterstitialActivity.f21909x, tAdInterstitialActivity.f21910y, tAdInterstitialActivity.f21911z);
            tAdInterstitialActivity.H0();
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.c
        public void c() {
            e4.b().d("TAdInterstitialActivity", "timeoutShutdown");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class l extends com.cloud.hisavana.sdk.common.tranmeasure.a {

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference f21933b;

        public l(TAdInterstitialActivity tAdInterstitialActivity) {
            this.f21933b = new WeakReference(tAdInterstitialActivity);
        }

        @Override // com.cloud.hisavana.sdk.common.tranmeasure.a, com.cloud.hisavana.sdk.common.tranmeasure.d.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(AdsDTO adsDTO) {
            super.a(adsDTO);
            e4.b().d("TAdInterstitialActivity", "view has impression     track = onAdShow");
            TAdInterstitialActivity tAdInterstitialActivity = (TAdInterstitialActivity) this.f21933b.get();
            if (tAdInterstitialActivity == null) {
                return;
            }
            TAdInterstitialActivity.this.f21905t = true;
            TAdInterstitialActivity.this.x1();
            tAdInterstitialActivity.O("_show", new Intent());
            if (adsDTO == null || adsDTO.getImpBeanRequest() == null) {
                return;
            }
            P.g().k(adsDTO.getImpBeanRequest().pmid);
            if (adsDTO.getSource() == 4) {
                Z.f21623a.q(adsDTO.getAdCreativeId(), adsDTO.getCodeSeatId());
            } else if (adsDTO.isOfflineAd()) {
                adsDTO.setShowNum(Integer.valueOf(adsDTO.getShowNum().intValue() + 1));
                com.cloud.hisavana.sdk.c0.F().q(adsDTO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class m implements View.OnTouchListener {
        private m() {
        }

        /* synthetic */ m(TAdInterstitialActivity tAdInterstitialActivity, b bVar) {
            this();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                TAdInterstitialActivity.this.f21908w = motionEvent.getX();
                TAdInterstitialActivity.this.f21909x = motionEvent.getY();
                return false;
            }
            if (action != 1) {
                return false;
            }
            TAdInterstitialActivity.this.f21910y = motionEvent.getX();
            TAdInterstitialActivity.this.f21911z = motionEvent.getY();
            return false;
        }
    }

    private void A() {
        if (n0(this.f21902q)) {
            com.cloud.hisavana.sdk.common.util.a.a(this);
            return;
        }
        View childAt = ((ViewGroup) findViewById(R.id.content)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(true);
        }
        getWindow().setLayout(-1, -1);
        setFinishOnTouchOutside(false);
    }

    private void A1() {
        try {
            if (getIntent() != null) {
                this.f21903r = getIntent().getStringExtra("BroadCastPrefix");
                this.f21902q = (AdsDTO) getIntent().getParcelableExtra("mAdBean");
            }
            AdsDTO adsDTO = this.f21902q;
            if (adsDTO != null && adsDTO.getMaterialStyle() != null) {
                int b11 = com.cloud.hisavana.sdk.common.util.b.f22230a.b(this.f21902q);
                this.B = b11;
                if (b11 != -1) {
                    V0();
                    return;
                }
                e4.b().d("TAdInterstitialActivity", "TAdInterstitialActivity --> adMediaType == INVALID_TYPE");
                C(TaErrorCode.CODE_INVALID_TYPE, TaErrorCode.ERROR_INVALID_TYPE.getErrorMessage());
                finish();
                return;
            }
            e4.b().d("TAdInterstitialActivity", "TAdInterstitialActivity --> null == mAdBean || null == mAdBean.materialStyle");
            C(TaErrorCode.CODE_INTERSTITIAL_MISS_ELEMENT, TaErrorCode.ERROR_INTERSTITIAL_MISS_ELEMENT.getErrorMessage());
            finish();
        } catch (Exception e11) {
            e4.b().e("TAdInterstitialActivity", "start " + Log.getStackTraceString(e11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(float f11) {
        try {
            AdsDTO adsDTO = this.f21902q;
            if (adsDTO != null && adsDTO.getMaterialStyle().equals("I1107")) {
                this.f21899n.setImageResource(f11 == 0.0f ? R$drawable.hisavana_volume_close_i1107 : R$drawable.hisavana_volume_open_i1107);
                return;
            }
        } catch (Throwable unused) {
        }
        ImageView imageView = this.f21899n;
        if (imageView != null) {
            imageView.setImageResource(f11 == 0.0f ? R$drawable.hisavana_volume_close : R$drawable.hisavana_volume_open);
        }
    }

    private void B0() {
        if (!v2.o(this.f21902q)) {
            this.L = 3;
        } else if (v2.n(this.f21902q)) {
            this.L = 1;
        } else {
            this.L = 2;
        }
        this.f21902q.setEndCardType(this.L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(int i11, String str) {
        Intent intent = new Intent();
        intent.putExtra(OfflineConstantsKt.TRACK_KEY_PRE_ERROR_MSG, str);
        intent.putExtra("error_code", i11);
        O("_error", intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(View view) {
        r(view, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:4|5|(4:7|(1:9)|10|(2:19|21)(1:22))|24|25|26|10|(1:12)|15|17|19|21) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void D(android.view.View r6, float r7, float r8, float r9, float r10) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return
        L3:
            int r0 = r5.W     // Catch: java.lang.Throwable -> Ld
            r1 = -1
            if (r0 == r1) goto Lf
            int r0 = r5.X     // Catch: java.lang.Throwable -> Ld
            if (r0 != r1) goto L38
            goto Lf
        Ld:
            r6 = move-exception
            goto L5d
        Lf:
            r0 = 2
            int[] r2 = new int[r0]     // Catch: java.lang.Throwable -> Ld
            r6.getLocationOnScreen(r2)     // Catch: java.lang.Throwable -> L38
            r3 = 0
            r4 = r2[r3]     // Catch: java.lang.Throwable -> L38
            r5.W = r4     // Catch: java.lang.Throwable -> L38
            r4 = 1
            r2 = r2[r4]     // Catch: java.lang.Throwable -> L38
            r5.X = r2     // Catch: java.lang.Throwable -> L38
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r3)     // Catch: java.lang.Throwable -> L38
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r3)     // Catch: java.lang.Throwable -> L38
            r6.measure(r2, r3)     // Catch: java.lang.Throwable -> L38
            int r2 = r6.getMeasuredWidth()     // Catch: java.lang.Throwable -> L38
            int r2 = r2 / r0
            r5.Y = r2     // Catch: java.lang.Throwable -> L38
            int r6 = r6.getMeasuredHeight()     // Catch: java.lang.Throwable -> L38
            int r6 = r6 / r0
            r5.Z = r6     // Catch: java.lang.Throwable -> L38
        L38:
            int r6 = r5.Y     // Catch: java.lang.Throwable -> Ld
            float r6 = (float) r6     // Catch: java.lang.Throwable -> Ld
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 != 0) goto L46
            int r6 = r5.Z     // Catch: java.lang.Throwable -> Ld
            float r6 = (float) r6     // Catch: java.lang.Throwable -> Ld
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L7b
        L46:
            int r6 = r5.W     // Catch: java.lang.Throwable -> Ld
            if (r6 == r1) goto L7b
            int r0 = r5.X     // Catch: java.lang.Throwable -> Ld
            if (r0 == r1) goto L7b
            float r6 = (float) r6     // Catch: java.lang.Throwable -> Ld
            float r7 = r7 + r6
            r5.f21908w = r7     // Catch: java.lang.Throwable -> Ld
            float r7 = (float) r0     // Catch: java.lang.Throwable -> Ld
            float r8 = r8 + r7
            r5.f21909x = r8     // Catch: java.lang.Throwable -> Ld
            float r9 = r9 + r6
            r5.f21910y = r9     // Catch: java.lang.Throwable -> Ld
            float r10 = r10 + r7
            r5.f21911z = r10     // Catch: java.lang.Throwable -> Ld
            goto L7b
        L5d:
            com.cloud.hisavana.sdk.e4 r7 = com.cloud.hisavana.sdk.e4.b()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "setLocationInfo error:"
            r8.append(r9)
            java.lang.String r6 = r6.getMessage()
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            java.lang.String r8 = "TAdInterstitialActivity"
            r7.w(r8, r6)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.common.activity.TAdInterstitialActivity.D(android.view.View, float, float, float, float):void");
    }

    private void D0(final AdsDTO adsDTO) {
        final InteractiveWebView interactiveWebView;
        if (adsDTO == null || TextUtils.isEmpty(adsDTO.getIndexLocation())) {
            return;
        }
        h1();
        if (new File(adsDTO.getIndexLocation()).exists() && (interactiveWebView = this.f21897l) != null) {
            interactiveWebView.setVisibility(0);
            interactiveWebView.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.activity.a0
                @Override // java.lang.Runnable
                public final void run() {
                    TAdInterstitialActivity.K(InteractiveWebView.this, adsDTO);
                }
            });
        } else {
            C(3005, "interactive file not exists ");
            AthenaTracker.S(this.f21902q, 3);
            finish();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00cf -> B:47:0x00eb). Please report as a decompilation issue!!! */
    private void E(View view, int i11) {
        TextView textView;
        ImageView imageView;
        View view2;
        int i12;
        ImageView imageView2 = (ImageView) view.findViewById(R$id.close_view);
        if (this.f21902q.getMaterialStyle().equals("I01")) {
            textView = (TextView) findViewById(R$id.count_down_view);
            imageView = (ImageView) findViewById(R$id.iv_reward_rest);
            try {
                View findViewById = findViewById(R$id.ad_close_container);
                if (findViewById != null) {
                    findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.n
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            TAdInterstitialActivity.r0(view3);
                        }
                    });
                }
            } catch (Exception unused) {
            }
        } else {
            textView = (TextView) view.findViewById(R$id.count_down_view);
            imageView = null;
        }
        TextView textView2 = textView;
        ImageView imageView3 = imageView;
        View view3 = (TextView) view.findViewById(R$id.skip_view);
        if (imageView2 == null || textView2 == null || view3 == null) {
            return;
        }
        if (this.J) {
            view3.setVisibility(0);
            imageView2.setVisibility(8);
            view2 = view3;
        } else {
            view3.setVisibility(8);
            imageView2.setVisibility(0);
            view2 = imageView2;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                TAdInterstitialActivity.this.w0(view4);
            }
        });
        if (i11 <= 0 || (i12 = this.H) == 0) {
            if (!this.f21902q.getMaterialStyle().equals("I01")) {
                e4.b().d("TAdInterstitialActivity", "current close delay time is 0, do not count down.");
                view2.setVisibility(0);
                textView2.setVisibility(8);
                return;
            } else {
                view.setVisibility(0);
                View findViewById2 = findViewById(R$id.ad_close_container);
                if (findViewById2 != null) {
                    findViewById2.setVisibility(8);
                    return;
                }
                return;
            }
        }
        int min = i12 > 0 ? Math.min(i11, i12) : i11;
        textView2.setVisibility(0);
        view2.setVisibility(4);
        if (this.B == 1 || this.f21902q.getDefaultMaterialType() == 2) {
            try {
                if (getResources().getConfiguration().orientation == 1 && this.f21902q.getMaterialStyle() != null && this.f21902q.getMaterialStyle().equals("I91602")) {
                    this.I = true;
                    findViewById(R$id.new_ad_progress).setVisibility(0);
                    textView2.setVisibility(8);
                } else {
                    this.I = false;
                }
            } catch (Exception e11) {
                e4.b().w("TAdInterstitialActivity", "*----> TAdInterstitialActivity --> get screen orientation error:" + e11.getMessage());
            }
        }
        e7.e eVar = this.G;
        if (eVar != null) {
            eVar.d();
        }
        ProgressBar progressBar = (ProgressBar) findViewById(R$id.new_ad_progress);
        if (this.I && progressBar != null) {
            progressBar.setMax(min);
            if (this.H > 0) {
                progressBar.setProgress(progressBar.getMax() - this.H);
            }
        }
        c cVar = new c(1000 * min, 1000L, progressBar, textView2, view2, view, imageView3);
        this.G = cVar;
        cVar.g();
    }

    private void F(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        InteractiveWebView interactiveWebView = this.f21897l;
        if (interactiveWebView != null) {
            i0(interactiveWebView, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0(View view) {
        i0(view, false);
    }

    private void J0(AdsDTO adsDTO) {
        String k11 = v2.k(adsDTO);
        if (TextUtils.isEmpty(k11)) {
            TaErrorCode taErrorCode = TaErrorCode.NO_MAIN_VIDEO_DATA_ERROR;
            C(taErrorCode.getErrorCode(), taErrorCode.getErrorMessage());
            finish();
        } else {
            t1();
            a0(adsDTO);
            this.f21900o.setVolumeView(this.f21899n);
            b0(k11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K(InteractiveWebView interactiveWebView, AdsDTO adsDTO) {
        interactiveWebView.loadUrl(AdPayload.FILE_SCHEME + adsDTO.getIndexLocation());
    }

    private int K0(AdsDTO adsDTO) {
        int i11 = 0;
        if (adsDTO == null) {
            return 0;
        }
        try {
            i11 = getResources().getConfiguration().orientation;
        } catch (Exception e11) {
            e4.b().w("TAdInterstitialActivity", "*----> TAdInterstitialActivity --> get screen orientation error:" + e11.getMessage());
        }
        if (n0(adsDTO)) {
            setTheme(R$style.InterstitialFullscreenStyle);
        } else if (i11 == 2) {
            setTheme(R$style.AppCompatTranscutes);
        } else {
            setTheme(R$style.InterstitialStyle);
        }
        return i11;
    }

    private void L(AdsDTO adsDTO) {
        if (this.K) {
            return;
        }
        if (this.f21902q.getNativeObject() == null || TextUtils.isEmpty(this.f21902q.getNativeObject().getTitleTxt())) {
            this.J = false;
            return;
        }
        if (this.f21902q.getSource() == 4 && TextUtils.isEmpty(this.f21902q.getLogoUrl())) {
            this.J = false;
            return;
        }
        if (this.f21902q.getSource() != 4 && TextUtils.isEmpty(this.f21902q.getNativeObject().getLogoUrl())) {
            this.J = false;
            return;
        }
        this.J = false;
        this.L = 0;
        int retentionEndCardRatio = adsDTO.getRetentionEndCardRatio();
        if (retentionEndCardRatio == 0) {
            return;
        }
        if (retentionEndCardRatio < 0 || retentionEndCardRatio > 100) {
            e4.b().e("TAdInterstitialActivity", "getRetentionEndCardRatio error,value is " + retentionEndCardRatio);
            return;
        }
        if (retentionEndCardRatio == 100) {
            this.J = true;
            B0();
        } else if (new Random().nextInt(100) + 1 <= retentionEndCardRatio) {
            this.J = true;
            B0();
        }
    }

    public static void M(s3 s3Var) {
        f21883c0 = new WeakReference(s3Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0(View view) {
        if (this.S) {
            com.cloud.hisavana.sdk.common.util.r.f22275a.s(this.f21884a);
        } else {
            U(view, false, false);
        }
    }

    private void N(String str) {
        if (this.E == null) {
            this.E = new com.cloud.hisavana.sdk.r();
        }
        this.E.j(this.S);
        this.E.d(this.f21884a, this.f21902q, new j());
        this.f21884a.loadDataWithBaseURL(null, str, "text/html", "utf-8", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(String str, Intent intent) {
        if (intent == null) {
            try {
                intent = new Intent();
                intent.putExtra("mAdBean", this.f21902q);
            } catch (Throwable th2) {
                e4.b().e(Log.getStackTraceString(th2));
                return;
            }
        }
        intent.setAction(this.f21903r + str);
        e4.b().d("TAdInterstitialActivity", "sendBroadcast action: " + intent.getAction());
        sendBroadcast(intent);
    }

    private void P0() {
        AdsDTO adsDTO = this.f21902q;
        if (adsDTO == null) {
            return;
        }
        if (adsDTO.getSource() == 4) {
            DownLoadRequest.n(this.f21902q.getAdChoiceImageUrl(), this.f21902q, null, this.f21888c);
        } else {
            DownLoadRequest.o(this.f21902q.getAdChoiceImageUrl(), this.f21902q, 3, null, this.f21888c);
        }
        if (this.f21892g == null || this.f21902q.getNativeObject() == null) {
            return;
        }
        if (this.f21902q.getSource() == 4) {
            DownLoadRequest.n(this.f21902q.getLogoUrl(), this.f21902q, null, this.f21892g);
        } else {
            DownLoadRequest.o(this.f21902q.getNativeObject().getLogoUrl(), this.f21902q, 1, null, this.f21892g);
        }
        if (!this.f21902q.isVastTypeAd() || this.f21902q.getMaterialStyle().equals("I01")) {
            return;
        }
        this.f21892g.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TAdInterstitialActivity.this.I0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(View view) {
        N0.k(getApplicationContext(), this.f21902q);
    }

    private int[] S(View view) {
        f0 a11 = f0.a(this.M);
        if (a11 == null) {
            return null;
        }
        if (this.M == 1) {
            return new int[]{a11.f21991a, a11.f21992b};
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.findViewById(R$id.close_view).getLayoutParams();
        int i11 = a11.f21993c;
        layoutParams.height = i11;
        layoutParams.width = i11;
        int i12 = a11.f21994d;
        layoutParams.topMargin = i12;
        layoutParams.rightMargin = i12;
        ViewGroup.LayoutParams layoutParams2 = view.findViewById(R$id.ffIcon).getLayoutParams();
        int i13 = a11.f21995e;
        layoutParams2.height = i13;
        layoutParams2.width = i13;
        TextView textView = (TextView) view.findViewById(R$id.tvName);
        textView.setTextSize(a11.f21996f);
        ((LinearLayout.LayoutParams) textView.getLayoutParams()).topMargin = a11.f21997g;
        view.findViewById(R$id.score_icon1).getLayoutParams().width = a11.f21998h;
        view.findViewById(R$id.score_icon1).getLayoutParams().height = a11.f21998h;
        view.findViewById(R$id.score_icon2).getLayoutParams().width = a11.f21998h;
        view.findViewById(R$id.score_icon2).getLayoutParams().height = a11.f21998h;
        view.findViewById(R$id.score_icon3).getLayoutParams().width = a11.f21998h;
        view.findViewById(R$id.score_icon3).getLayoutParams().height = a11.f21998h;
        view.findViewById(R$id.score_icon4).getLayoutParams().width = a11.f21998h;
        view.findViewById(R$id.score_icon4).getLayoutParams().height = a11.f21998h;
        view.findViewById(R$id.score_icon5).getLayoutParams().width = a11.f21998h;
        view.findViewById(R$id.score_icon5).getLayoutParams().height = a11.f21998h;
        ((LinearLayout.LayoutParams) view.findViewById(R$id.score_area_view).getLayoutParams()).topMargin = a11.f21999i;
        view.findViewById(R$id.desc_area_view).getLayoutParams().width = a11.f22000j;
        view.findViewById(R$id.desc_area_view).getLayoutParams().height = a11.f22001k;
        ((LinearLayout.LayoutParams) view.findViewById(R$id.desc_area_view).getLayoutParams()).topMargin = a11.f22002l;
        view.findViewById(R$id.score_icon).getLayoutParams().width = a11.f22003m;
        view.findViewById(R$id.score_icon).getLayoutParams().height = a11.f22003m;
        view.findViewById(R$id.download_icon).getLayoutParams().width = a11.f22003m;
        view.findViewById(R$id.download_icon).getLayoutParams().height = a11.f22003m;
        ((TextView) view.findViewById(R$id.score_text)).setTextSize(a11.f22004n);
        ((TextView) view.findViewById(R$id.download_text)).setTextSize(a11.f22004n);
        ((TextView) view.findViewById(R$id.score_info)).setTextSize(a11.f22005o);
        ((TextView) view.findViewById(R$id.download_info)).setTextSize(a11.f22005o);
        view.findViewById(R$id.line_info).getLayoutParams().height = a11.f22006p;
        view.findViewById(R$id.ff_btn).getLayoutParams().width = a11.f22007q;
        view.findViewById(R$id.ff_btn).getLayoutParams().height = a11.f22008r;
        ((LinearLayout.LayoutParams) view.findViewById(R$id.ff_btn).getLayoutParams()).topMargin = a11.f22009s;
        ((LinearLayout.LayoutParams) view.findViewById(R$id.ff_ps_mark_view).getLayoutParams()).topMargin = a11.f22010t;
        return new int[]{a11.f21991a, a11.f21992b};
    }

    private void S0() {
        finish();
    }

    private int T(View view, boolean z10) {
        if (this.f21902q.getPslinkInfo() != null) {
            if (view.getId() == R$id.tvBtn || view.getId() == R$id.btn_pop_confirm || view.getId() == R$id.btn || z10) {
                this.f21902q.getPslinkInfo().setClickType(2);
                this.f21902q.setTrackUserClickArea(2);
                e4.b().d("TAdInterstitialActivity", "pslink half setClickType, click_install");
            } else {
                this.f21902q.setTrackUserClickArea(1);
                this.f21902q.getPslinkInfo().setClickType(1);
                e4.b().d("TAdInterstitialActivity", "pslink half setClickType, click_img");
            }
        }
        DownUpPointBean downUpPointBean = new DownUpPointBean(this.f21908w, this.f21909x, this.f21910y, this.f21911z, view.getMeasuredHeight(), view.getMeasuredWidth());
        boolean z11 = this.f21902q != null ? !r12.isAllowTrackingADClick() : false;
        O("_click", null);
        return N0.c(getApplicationContext(), this.f21902q, downUpPointBean, false, z11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T0(View view) {
        r(view, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int U(View view, boolean z10, boolean z11) {
        return V(view, z10, z11, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int V(View view, final boolean z10, boolean z11, boolean z12) {
        AdsDTO adsDTO = this.f21902q;
        if (adsDTO == null || !adsDTO.getMaterialStyle().equals("I01")) {
            return r(view, z10);
        }
        if (this.O != 2) {
            this.P = true;
            return t(view, z10, z11, z12);
        }
        if (this.N || z11) {
            if (a7.c.j()) {
                HSToastUtil.f(getString(R$string.hs_download_in_palm_store));
            }
            this.U = true;
            int s11 = s(view, z10, z11);
            if (this.S && !this.V) {
                return s11;
            }
            L0();
            return s11;
        }
        try {
            AdsDTO adsDTO2 = this.f21902q;
            if (adsDTO2 != null) {
                com.cloud.hisavana.sdk.common.util.r.f22275a.o(adsDTO2, new DownUpPointBean(this.f21908w, this.f21909x, this.f21910y, this.f21911z, view.getMeasuredHeight(), view.getMeasuredWidth()));
            }
            if (this.Q == null) {
                e7.d dVar = new e7.d(this, new Function0() { // from class: com.cloud.hisavana.sdk.common.activity.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit z13;
                        z13 = TAdInterstitialActivity.this.z(z10);
                        return z13;
                    }
                });
                this.Q = dVar;
                dVar.m(this.f21902q);
            }
            this.Q.show();
        } catch (Throwable unused) {
        }
        return -1;
    }

    private void V0() {
        if (this.f21902q == null) {
            TaErrorCode taErrorCode = TaErrorCode.ERROR_SHOW_ADBEAN_NULL;
            C(taErrorCode.getErrorCode(), taErrorCode.getErrorMessage());
            e4.b().d("TAdInterstitialActivity", "TAdInterstitialActivity --> null == mAdBean |");
            S0();
            return;
        }
        if (d0()) {
            return;
        }
        q1();
        w1();
        P0();
        j0();
        v0();
        e1();
        try {
            com.cloud.hisavana.sdk.manager.a.f22735a.s(getApplicationContext(), this.f21902q, false);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0(View view) {
        r(view, false);
    }

    private void X(View view) {
        if (this.f21898m == null || view == null) {
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.f21898m.removeAllViews();
        this.f21898m.addView(view, new ConstraintLayout.b(-1, -1));
    }

    private void Y(View view, int i11) {
        String str;
        int i12;
        TextView textView = (TextView) view.findViewById(R$id.close_view);
        TextView textView2 = (TextView) view.findViewById(R$id.count_down_view);
        View findViewById = view.findViewById(R$id.separator);
        if (textView == null || textView2 == null || findViewById == null) {
            return;
        }
        if (this.J) {
            try {
                str = getString(R$string.hs_btn_skip);
            } catch (Exception unused) {
                str = "SKIP";
            }
            textView.setText(str);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TAdInterstitialActivity.this.C0(view2);
            }
        });
        if (i11 <= 0 || (i12 = this.H) == 0) {
            e4.b().d("TAdInterstitialActivity", "current close delay time is 0, do not count down.");
            view.setEnabled(true);
            textView.setTextColor(Color.parseColor("#222222"));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.setMarginStart(0);
            textView.setLayoutParams(layoutParams);
            textView2.setVisibility(8);
            findViewById.setVisibility(8);
            view.requestLayout();
            return;
        }
        if (i12 > 0) {
            i11 = Math.min(i11, i12);
        }
        e7.e eVar = this.G;
        if (eVar != null) {
            eVar.d();
        }
        view.setEnabled(false);
        d dVar = new d(1000 * i11, 1000L, textView2, view, textView, findViewById);
        this.G = dVar;
        dVar.g();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    private void Y0() {
        char c11;
        Object obj;
        String str;
        boolean z10;
        char c12;
        ?? r52;
        String str2;
        ViewGroup viewGroup;
        try {
            if (n0(this.f21902q) && (viewGroup = (ViewGroup) findViewById(R$id.content_layout)) != null) {
                viewGroup.setOnTouchListener(new m(this, null));
                viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.z
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TAdInterstitialActivity.this.M0(view);
                    }
                });
            }
            this.f21893h = (ViewGroup) findViewById(R$id.llRoot);
            String materialStyle = this.f21902q.getMaterialStyle();
            ViewGroup viewGroup2 = this.f21893h;
            if (viewGroup2 != null) {
                viewGroup2.setOnClickListener(new b(materialStyle));
            }
        } catch (Throwable unused) {
        }
        this.f21892g = (ImageView) findViewById(R$id.ivIcon);
        this.f21894i = (TextView) findViewById(R$id.tvName);
        this.f21895j = (TextView) findViewById(R$id.tvDescription);
        TextView textView = (TextView) findViewById(R$id.tvSourceSize);
        this.f21896k = (TextView) findViewById(R$id.tvBtn);
        AdsDTO adsDTO = this.f21902q;
        if (adsDTO == null || adsDTO.getNativeObject() == null || TextUtils.isEmpty(this.f21902q.getMaterialStyle())) {
            return;
        }
        if (TextUtils.isEmpty(this.f21902q.getAdm()) || this.S) {
            com.cloud.hisavana.sdk.common.util.r rVar = com.cloud.hisavana.sdk.common.util.r.f22275a;
            String k11 = rVar.k(this.f21902q);
            String materialStyle2 = this.f21902q.getMaterialStyle();
            materialStyle2.hashCode();
            switch (materialStyle2.hashCode()) {
                case 71690:
                    if (materialStyle2.equals("I01")) {
                        c11 = 0;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 2149406:
                    if (materialStyle2.equals("FA14")) {
                        c11 = 1;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 68925418:
                    if (materialStyle2.equals("I1101")) {
                        c11 = 2;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 68925419:
                    if (materialStyle2.equals("I1102")) {
                        c11 = 3;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 68925420:
                    if (materialStyle2.equals("I1103")) {
                        c11 = 4;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 68925423:
                    if (materialStyle2.equals("I1106")) {
                        c11 = 5;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 68925424:
                    if (materialStyle2.equals("I1107")) {
                        c11 = 6;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 2136845580:
                    if (materialStyle2.equals("I16901")) {
                        c11 = 7;
                        break;
                    }
                    c11 = 65535;
                    break;
                case 2136845581:
                    if (materialStyle2.equals("I16902")) {
                        c11 = '\b';
                        break;
                    }
                    c11 = 65535;
                    break;
                case 2144081910:
                    if (materialStyle2.equals("I91601")) {
                        c11 = '\t';
                        break;
                    }
                    c11 = 65535;
                    break;
                case 2144081911:
                    if (materialStyle2.equals("I91602")) {
                        c11 = '\n';
                        break;
                    }
                    c11 = 65535;
                    break;
                default:
                    c11 = 65535;
                    break;
            }
            switch (c11) {
                case 0:
                case 2:
                case 4:
                case 6:
                case 7:
                case '\b':
                case '\t':
                case '\n':
                    obj = "FA14";
                    this.f21894i.setText(this.f21902q.getNativeObject().getTitleTxt());
                    this.f21895j.setText(this.f21902q.getNativeObject().getDescriptionTxt());
                    String buttonTxt = this.f21902q.getNativeObject().getButtonTxt(this.f21902q.getInstallApk());
                    if (TextUtils.isEmpty(buttonTxt)) {
                        buttonTxt = rVar.j();
                    }
                    this.f21896k.setText(buttonTxt);
                    TextPaint paint = this.f21894i.getPaint();
                    paint.setStrokeWidth(2.0f);
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                    if (this.f21886b != null && ((this.f21902q.getMaterialStyle().equals("I91601") || this.f21902q.getMaterialStyle().equals("I91602") || this.f21902q.getMaterialStyle().equals("I01")) && !TextUtils.isEmpty(this.f21902q.getScale()) && this.f21902q.getScale().equals("9:16"))) {
                        this.f21886b.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    }
                    if (this.f21902q.getMaterialStyle().equals("I16902") || this.f21902q.getMaterialStyle().equals("I91602")) {
                        c12 = 3;
                        View findViewById = findViewById(R$id.desc_area_view);
                        TextView textView2 = (TextView) findViewById(R$id.score_text);
                        if (textView2 == null) {
                            str2 = k11;
                            z10 = false;
                            if (textView != null) {
                                F(textView, str2);
                            }
                        } else if (v2.o(this.f21902q)) {
                            this.f21895j.setVisibility(8);
                            findViewById.setVisibility(0);
                            textView2.setText(v2.b(v2.i(this.f21902q)));
                            if (textView != null) {
                                if (TextUtils.isEmpty(k11)) {
                                    str = k11;
                                } else {
                                    str = k11 + " · ";
                                }
                                F(textView, str);
                                z10 = false;
                                z1();
                                break;
                            }
                            str2 = k11;
                            z10 = false;
                        } else {
                            str2 = k11;
                            findViewById.setVisibility(8);
                            z10 = false;
                            this.f21895j.setVisibility(0);
                            String descriptionTxt = this.f21902q.getNativeObject().getDescriptionTxt();
                            if (!TextUtils.isEmpty(str2)) {
                                descriptionTxt = str2 + " · " + descriptionTxt;
                            }
                            this.f21895j.setText(descriptionTxt);
                        }
                    } else if (this.f21902q.getMaterialStyle().equals("I01") || this.f21902q.getMaterialStyle().equals("I1107")) {
                        TextView textView3 = (TextView) findViewById(R$id.score_text);
                        ImageView imageView = (ImageView) findViewById(R$id.score_icon);
                        if (this.f21902q.getMaterialStyle().equals("I01")) {
                            TextView textView4 = this.f21896k;
                            if (textView4 != null) {
                                ObjectAnimator g11 = rVar.g(textView4);
                                this.f21885a0 = g11;
                                if (g11 != null) {
                                    g11.start();
                                }
                            }
                        } else if (this.f21902q.getMaterialStyle().equals("I1107") && this.f21896k != null) {
                            View findViewById2 = findViewById(R$id.view_animator_bg_color);
                            if (this.R == 2) {
                                this.f21887b0 = rVar.p(this.f21896k, findViewById2, "#260052E2");
                            } else {
                                this.f21887b0 = rVar.p(this.f21896k, findViewById2, "#4DFFFFFF");
                            }
                        }
                        int i11 = this.O;
                        c12 = 3;
                        if (i11 == 3) {
                            if (this.f21902q.getMaterialStyle().equals("I01")) {
                                this.f21896k.setText(getString(R$string.hs_download_t01_btn_pull_live));
                            }
                            if (imageView != null) {
                                try {
                                    imageView.setVisibility(0);
                                } catch (Throwable unused2) {
                                }
                            }
                            textView3.setText(v2.b(v2.i(this.f21902q)) + " · " + this.f21902q.getNativeObject().getDescriptionTxt());
                        } else if (i11 == 2) {
                            if (imageView != null) {
                                imageView.setVisibility(8);
                            }
                            if (textView3 != null) {
                                try {
                                    textView3.setText(rVar.i(this.f21902q.getPslinkInfo().getSourceSize()) + " · " + this.f21902q.getNativeObject().getDescriptionTxt());
                                } catch (Throwable unused3) {
                                }
                            }
                            if (this.f21902q.getMaterialStyle().equals("I01")) {
                                this.f21896k.setText(getString(R$string.hs_download_t01_btn_pull_new));
                            }
                        } else if (this.f21902q.getMaterialStyle().equals("I01")) {
                            this.f21896k.setText(getString(R$string.hs_download_t01_btn_pull_live));
                        }
                        str2 = k11;
                        z10 = false;
                    } else {
                        str2 = k11;
                        z10 = false;
                        c12 = 3;
                    }
                    str = str2;
                    z1();
                    break;
                case 1:
                case 5:
                    this.f21894i.setText(this.f21902q.getNativeObject().getTitleTxt());
                    this.f21895j.setText(this.f21902q.getNativeObject().getDescriptionTxt());
                    this.f21896k.setText(this.f21902q.getNativeObject().getButtonTxt(this.f21902q.getInstallApk()));
                    TextPaint paint2 = this.f21895j.getPaint();
                    paint2.setStrokeWidth(2.0f);
                    paint2.setStyle(Paint.Style.FILL_AND_STROKE);
                    z1();
                    obj = "FA14";
                    str = k11;
                    z10 = false;
                    c12 = 3;
                    break;
                case 3:
                    this.f21894i.setText(this.f21902q.getNativeObject().getTitleTxt());
                    this.f21896k.setText(this.f21902q.getNativeObject().getButtonTxt(this.f21902q.getInstallApk()));
                    TextPaint paint3 = this.f21894i.getPaint();
                    paint3.setStrokeWidth(2.0f);
                    paint3.setStyle(Paint.Style.FILL_AND_STROKE);
                    z1();
                    obj = "FA14";
                    str = k11;
                    z10 = false;
                    c12 = 3;
                    break;
                default:
                    obj = "FA14";
                    str = k11;
                    z10 = false;
                    c12 = 3;
                    break;
            }
            String materialStyle3 = this.f21902q.getMaterialStyle();
            materialStyle3.hashCode();
            switch (materialStyle3.hashCode()) {
                case 2149406:
                    if (materialStyle3.equals(obj)) {
                        r52 = z10;
                        break;
                    }
                    r52 = -1;
                    break;
                case 68925418:
                    if (materialStyle3.equals("I1101")) {
                        r52 = 1;
                        break;
                    }
                    r52 = -1;
                    break;
                case 68925419:
                    if (materialStyle3.equals("I1102")) {
                        r52 = 2;
                        break;
                    }
                    r52 = -1;
                    break;
                case 68925420:
                    if (materialStyle3.equals("I1103")) {
                        r52 = c12;
                        break;
                    }
                    r52 = -1;
                    break;
                case 68925423:
                    if (materialStyle3.equals("I1106")) {
                        r52 = 4;
                        break;
                    }
                    r52 = -1;
                    break;
                case 2136845580:
                    if (materialStyle3.equals("I16901")) {
                        r52 = 5;
                        break;
                    }
                    r52 = -1;
                    break;
                case 2144081910:
                    if (materialStyle3.equals("I91601")) {
                        r52 = 6;
                        break;
                    }
                    r52 = -1;
                    break;
                default:
                    r52 = -1;
                    break;
            }
            switch (r52) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    if (textView != null) {
                        F(textView, str);
                        return;
                    }
                    return;
                case 5:
                    if (this.R != 2) {
                        if (textView != null) {
                            F(textView, str);
                            return;
                        }
                        return;
                    } else {
                        if (this.f21895j != null) {
                            String descriptionTxt2 = this.f21902q.getNativeObject().getDescriptionTxt();
                            if (!TextUtils.isEmpty(str)) {
                                descriptionTxt2 = str + " · " + descriptionTxt2;
                            }
                            this.f21895j.setText(descriptionTxt2);
                            return;
                        }
                        return;
                    }
                case 6:
                    if (this.R == 2) {
                        if (textView != null) {
                            F(textView, str);
                            return;
                        }
                        return;
                    } else {
                        if (this.f21895j != null) {
                            String descriptionTxt3 = this.f21902q.getNativeObject().getDescriptionTxt();
                            if (!TextUtils.isEmpty(str)) {
                                descriptionTxt3 = str + " · " + descriptionTxt3;
                            }
                            this.f21895j.setText(descriptionTxt3);
                            return;
                        }
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Z0(View view) {
    }

    private void a0(AdsDTO adsDTO) {
        if ((this.B == 1 || adsDTO.getDefaultMaterialType() == 2) && this.f21900o == null) {
            InterstitialAdVideoView interstitialAdVideoView = new InterstitialAdVideoView(getApplicationContext());
            this.f21900o = interstitialAdVideoView;
            if (this.I) {
                interstitialAdVideoView.setProgressBarVisibility(8);
            }
            this.f21900o.setAutoReset(true);
            this.f21900o.setAdMediaPlayerListener(new h(adsDTO));
        }
    }

    private void b0(String str) {
        int i11;
        AdsDTO adsDTO;
        InterstitialAdVideoView interstitialAdVideoView;
        ViewGroup.LayoutParams layoutParams;
        e4.b().d("TAdInterstitialActivity", "setMediaData ");
        InterstitialAdVideoView interstitialAdVideoView2 = this.f21900o;
        if (interstitialAdVideoView2 == null) {
            return;
        }
        X(interstitialAdVideoView2);
        try {
            i11 = getResources().getConfiguration().orientation;
        } catch (Exception unused) {
            i11 = 0;
        }
        AdsDTO adsDTO2 = this.f21902q;
        if (adsDTO2 != null && i11 == 1 && adsDTO2.getMaterialStyle().equals("I91602") && v2.h(this.f21902q).equals("9:16") && (layoutParams = this.f21900o.getLayoutParams()) != null) {
            int m11 = v2.m(this.f21902q);
            int l11 = v2.l(this.f21902q);
            if (m11 <= 0 || l11 <= 0) {
                layoutParams.width = -1;
                layoutParams.height = -2;
            } else {
                layoutParams.width = com.cloud.sdk.commonutil.util.h.g();
                layoutParams.height = (int) (com.cloud.sdk.commonutil.util.h.g() * (l11 / m11));
            }
            this.f21900o.setLayoutParams(layoutParams);
        }
        if (this.f21907v && (interstitialAdVideoView = this.f21900o) != null) {
            interstitialAdVideoView.seekToPosition(interstitialAdVideoView.getDuration());
        }
        if (this.f21906u) {
            return;
        }
        if (this.f21900o != null && !TextUtils.isEmpty(str)) {
            e4.b().d("TAdInterstitialActivity", "setMediaData filePath " + str);
            this.f21900o.setMediaData(str, this.f21902q, this.f21904s == 0.0f, str.startsWith("http"));
            if (!this.f21902q.getMaterialStyle().equals("I01")) {
                this.f21900o.setOnTouchListener(new m(this, null));
                this.f21900o.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.w
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TAdInterstitialActivity.this.f1(view);
                    }
                });
            }
        }
        if (this.f21900o == null || (adsDTO = this.f21902q) == null || adsDTO.getVideoInfo() == null || this.f21902q.getVideoInfo().getVideoMask() == null) {
            return;
        }
        this.f21900o.setCompanionSize(this.f21902q.getVideoInfo().getVideoMask().getResource());
    }

    private void b1() {
        AdsDTO adsDTO;
        View findViewById = findViewById(R$id.ivCancel);
        if (findViewById == null || (adsDTO = this.f21902q) == null) {
            return;
        }
        int closeDelayTime = adsDTO.isVastTypeAd() ? (this.f21902q.getVideoInfo() == null || this.f21902q.getVideoInfo().getDuration() == null || this.f21902q.getVideoInfo().getDuration().intValue() <= 0) ? this.f21902q.getCloseDelayTime() : Math.min(this.f21902q.getCloseDelayTime(), this.f21902q.getVideoInfo().getDuration().intValue()) : this.f21902q.getCloseDelayTime();
        e4.b().d("TAdInterstitialActivity", "current close delay time is: " + closeDelayTime);
        if (findViewById.getTag() == null || !findViewById.getTag().equals("close_button")) {
            E(findViewById, closeDelayTime);
        } else {
            Y(findViewById, closeDelayTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public void P(String str, String str2, String str3) {
        if (this.F == null) {
            com.cloud.hisavana.sdk.common.util.v vVar = new com.cloud.hisavana.sdk.common.util.v(this, new a());
            this.F = vVar;
            vVar.k(str);
            this.F.h(str2);
            this.F.g(str3);
            this.F.j(true);
        }
        try {
            this.F.show();
        } catch (Exception e11) {
            e4.b().e("TAdInterstitialActivity", "showRuDialog error: " + e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c1(View view) {
        AthenaTracker.A(this.f21902q);
        com.cloud.hisavana.sdk.common.tranmeasure.e.c().e(this.f21902q, view, this.D);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0075, code lost:
    
        if (r5.equals("I1106") == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean d0() {
        /*
            Method dump skipped, instructions count: 576
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.common.activity.TAdInterstitialActivity.d0():boolean");
    }

    private void e1() {
        ViewGroup viewGroup;
        try {
            if (this.f21902q.getMaterialStyle().equals("I01") && this.R == 2 && (viewGroup = (ViewGroup) findViewById(R$id.content_layout)) != null) {
                viewGroup.setOnTouchListener(new m(this, null));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f1(View view) {
        i0(view, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h0(View view) {
        return T(view, false);
    }

    private void h1() {
        if (this.f21902q.isInteractiveAd()) {
            if (this.f21897l == null) {
                try {
                    this.f21897l = new InteractiveWebView(getApplicationContext());
                } catch (Throwable th2) {
                    e4.b().e("TAdInterstitialActivity", "create webview error: " + Log.getStackTraceString(th2));
                    this.f21897l = null;
                }
            }
            if (this.f21898m == null || this.f21897l == null) {
                L0();
                return;
            }
            j1();
            String materialStyle = this.f21902q.getMaterialStyle();
            if (!TextUtils.isEmpty(materialStyle) && (materialStyle.equals("I1107") || materialStyle.equals("I91601") || materialStyle.equals("I91602") || materialStyle.equals("I16902") || materialStyle.equals("I01") || (materialStyle.equals("I16901") && this.R == 2))) {
                String scale = this.f21902q.getScale();
                if (TextUtils.isEmpty(scale)) {
                    scale = (this.f21902q.getScales() == null || this.f21902q.getScales().isEmpty()) ? "" : this.f21902q.getScales().get(0);
                }
                ViewGroup.LayoutParams layoutParams = this.f21898m.getLayoutParams();
                if (layoutParams instanceof ConstraintLayout.b) {
                    ((ConstraintLayout.b) layoutParams).I = scale;
                }
            }
            X(this.f21897l);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i0(View view, boolean z10) {
        return V(view, z10, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i1(View view) {
        if (!this.S) {
            U(view, false, true);
        } else {
            this.T = true;
            com.cloud.hisavana.sdk.common.util.r.f22275a.s(this.f21884a);
        }
    }

    private void j0() {
        AdsDTO adsDTO = this.f21902q;
        if (adsDTO == null || adsDTO.getDisplayRule() != Constants.AdDisplayRule.RU || this.f21898m == null) {
            return;
        }
        if (this.f21901p == null) {
            AdDisclaimerView adDisclaimerView = new AdDisclaimerView(this);
            this.f21901p = adDisclaimerView;
            adDisclaimerView.setListener(new AdDisclaimerView.b() { // from class: com.cloud.hisavana.sdk.common.activity.p
                @Override // com.cloud.hisavana.sdk.api.view.AdDisclaimerView.b
                public final void a(String str, String str2, String str3) {
                    TAdInterstitialActivity.this.P(str, str2, str3);
                }
            });
        }
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, getResources().getDimensionPixelOffset(R$dimen.ad_disclaimer_height));
        bVar.f7775t = this.f21898m.getId();
        bVar.f7779v = this.f21898m.getId();
        bVar.f7759l = this.f21898m.getId();
        if (this.f21901p.getParent() != null) {
            ((ViewGroup) this.f21901p.getParent()).removeView(this.f21901p);
        }
        this.f21898m.addView(this.f21901p, bVar);
        this.f21898m.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.activity.q
            @Override // java.lang.Runnable
            public final void run() {
                TAdInterstitialActivity.this.v1();
            }
        });
        v0();
    }

    private void j1() {
        this.f21897l.setWebClientCallback(this.f21902q);
        this.f21897l.setOnTouchListener(new m(this, null));
        this.f21897l.setInteractiveListener(new k(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(String str) {
        AdsDTO adsDTO = this.f21902q;
        if (adsDTO != null) {
            AthenaTracker.y(adsDTO, str);
        }
    }

    private void k1(View view) {
        ViewParent parent;
        if (view == null || (parent = view.getParent()) == null || !(parent instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) parent).removeView(view);
    }

    private void m1() {
        AdChoicesView adChoicesView = (AdChoicesView) findViewById(R$id.ad_choices_view);
        this.f21888c = adChoicesView;
        if (adChoicesView != null) {
            adChoicesView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TAdInterstitialActivity.this.Q0(view);
                }
            });
        }
        AdBadgeView adBadgeView = (AdBadgeView) findViewById(R$id.ad_badge_view);
        this.f21889d = adBadgeView;
        if (adBadgeView != null) {
            adBadgeView.setDisplayStyle(this.f21902q.getDisplayRule(), com.cloud.hisavana.sdk.common.util.f0.c(this.f21902q));
        }
        AdCloseView adCloseView = (AdCloseView) findViewById(R$id.ad_close_view);
        this.f21890e = adCloseView;
        if (adCloseView != null) {
            adCloseView.setDisplayStyle(this.f21902q.getDisplayRule(), AdCloseView.CloseImageType.EXPAND);
            t2.p().f(this, this.f21890e, this, this.f21902q);
        }
        try {
            boolean a11 = i0.a(this.f21902q);
            StoreMarkView storeMarkView = (StoreMarkView) findViewById(R$id.ps_mark_view);
            this.f21891f = storeMarkView;
            if (storeMarkView != null) {
                storeMarkView.setVisibility(a11 ? 0 : 4);
                this.f21891f.setTextSize(6.0f);
                if (!this.f21902q.getMaterialStyle().equals("I1107") || this.R == 2) {
                    this.f21891f.setTextColor(-8882056);
                    this.f21891f.setTextSize(6.0f);
                } else {
                    this.f21891f.setTextColor(Color.parseColor("#FFFFFFFF"));
                    this.f21891f.setTextSize(8.0f);
                }
                this.f21891f.attachInfo(this.f21902q);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean n0(AdsDTO adsDTO) {
        if (adsDTO == null || adsDTO.getMaterialStyle() == null) {
            return false;
        }
        return adsDTO.getMaterialStyle().equals("I91601") || adsDTO.getMaterialStyle().equals("I16901") || adsDTO.getMaterialStyle().equals("I91602") || adsDTO.getMaterialStyle().equals("I16902") || adsDTO.getMaterialStyle().equals("I01");
    }

    private void p1() {
        b bVar = null;
        View inflate = LayoutInflater.from(this).inflate(R$layout.ad_interstitial_end_card_layout, (ViewGroup) null);
        int[] S = S(inflate);
        inflate.findViewById(R$id.close_view).setOnClickListener(new e());
        if (this.f21892g != null) {
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R$id.ffIcon);
            k1(this.f21892g);
            frameLayout.addView(this.f21892g, new FrameLayout.LayoutParams(-1, -1));
        } else if (this.f21902q.getSource() == 4 && !TextUtils.isEmpty(this.f21902q.getLogoUrl())) {
            TranCircleImageView tranCircleImageView = new TranCircleImageView(this);
            DownLoadRequest.n(this.f21902q.getLogoUrl(), this.f21902q, null, tranCircleImageView);
            tranCircleImageView.setRadius(com.cloud.sdk.commonutil.util.h.a(4.0f));
            ((FrameLayout) inflate.findViewById(R$id.ffIcon)).addView(tranCircleImageView, new FrameLayout.LayoutParams(-1, -1));
            if (this.f21902q.isVastTypeAd()) {
                tranCircleImageView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.b0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TAdInterstitialActivity.this.T0(view);
                    }
                });
            }
        } else if (this.f21902q.getNativeObject() == null || TextUtils.isEmpty(this.f21902q.getNativeObject().getLogoUrl())) {
            inflate.findViewById(R$id.ffIcon).setVisibility(8);
        } else {
            TranCircleImageView tranCircleImageView2 = new TranCircleImageView(this);
            DownLoadRequest.o(this.f21902q.getNativeObject().getLogoUrl(), this.f21902q, 1, null, tranCircleImageView2);
            tranCircleImageView2.setRadius(com.cloud.sdk.commonutil.util.h.a(4.0f));
            ((FrameLayout) inflate.findViewById(R$id.ffIcon)).addView(tranCircleImageView2, new FrameLayout.LayoutParams(-1, -1));
            if (this.f21902q.isVastTypeAd()) {
                tranCircleImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.c0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TAdInterstitialActivity.this.W0(view);
                    }
                });
            }
        }
        TextView textView = this.f21894i;
        if (textView != null && !TextUtils.isEmpty(textView.getText())) {
            ((TextView) inflate.findViewById(R$id.tvName)).setText(this.f21894i.getText());
        } else if (this.f21902q.getNativeObject() == null || TextUtils.isEmpty(this.f21902q.getNativeObject().getTitleTxt())) {
            inflate.findViewById(R$id.tvName).setVisibility(8);
        } else {
            ((TextView) inflate.findViewById(R$id.tvName)).setText(this.f21902q.getNativeObject().getTitleTxt());
        }
        if (this.f21902q.getNativeObject() == null || TextUtils.isEmpty(this.f21902q.getNativeObject().getButtonTxt(this.f21902q.getInstallApk()))) {
            inflate.findViewById(R$id.ff_btn).setVisibility(8);
        } else {
            TextView textView2 = (TextView) inflate.findViewById(R$id.btn);
            textView2.setText(this.f21902q.getNativeObject().getButtonTxt(this.f21902q.getInstallApk()));
            textView2.setOnClickListener(new f());
        }
        FrameLayout frameLayout2 = (FrameLayout) inflate.findViewById(R$id.ff_ps_mark_view);
        StoreMarkView storeMarkView = (StoreMarkView) findViewById(R$id.ps_mark_view);
        k1(storeMarkView);
        frameLayout2.addView(storeMarkView, new FrameLayout.LayoutParams(-1, -1));
        if (!v2.o(this.f21902q)) {
            inflate.findViewById(R$id.desc_area_view).setVisibility(8);
            this.L = 3;
        } else if (v2.n(this.f21902q)) {
            ((TextView) inflate.findViewById(R$id.score_text)).setText(v2.b(v2.i(this.f21902q)));
            ((TextView) inflate.findViewById(R$id.download_text)).setText(com.cloud.hisavana.sdk.common.util.c0.b(v2.e(this.f21902q)));
            this.L = 1;
        } else {
            inflate.findViewById(R$id.desc_area_view).setVisibility(8);
            inflate.findViewById(R$id.score_area_view).setVisibility(0);
            float i11 = v2.i(this.f21902q);
            if (i11 > 0.0f && i11 < 0.5f) {
                ((ImageView) inflate.findViewById(R$id.score_icon1)).setImageResource(R$drawable.hs_ad_nostar);
                ((ImageView) inflate.findViewById(R$id.score_icon2)).setImageResource(R$drawable.hs_ad_nostar);
                ((ImageView) inflate.findViewById(R$id.score_icon3)).setImageResource(R$drawable.hs_ad_nostar);
                ((ImageView) inflate.findViewById(R$id.score_icon4)).setImageResource(R$drawable.hs_ad_nostar);
                ((ImageView) inflate.findViewById(R$id.score_icon5)).setImageResource(R$drawable.hs_ad_nostar);
            } else if (i11 >= 0.5f && i11 < 1.0f) {
                ((ImageView) inflate.findViewById(R$id.score_icon1)).setImageResource(R$drawable.hs_ad_halfstar);
                ((ImageView) inflate.findViewById(R$id.score_icon2)).setImageResource(R$drawable.hs_ad_nostar);
                ((ImageView) inflate.findViewById(R$id.score_icon3)).setImageResource(R$drawable.hs_ad_nostar);
                ((ImageView) inflate.findViewById(R$id.score_icon4)).setImageResource(R$drawable.hs_ad_nostar);
                ((ImageView) inflate.findViewById(R$id.score_icon5)).setImageResource(R$drawable.hs_ad_nostar);
            } else if (i11 >= 1.0f && i11 < 1.5f) {
                ((ImageView) inflate.findViewById(R$id.score_icon2)).setImageResource(R$drawable.hs_ad_nostar);
                ((ImageView) inflate.findViewById(R$id.score_icon3)).setImageResource(R$drawable.hs_ad_nostar);
                ((ImageView) inflate.findViewById(R$id.score_icon4)).setImageResource(R$drawable.hs_ad_nostar);
                ((ImageView) inflate.findViewById(R$id.score_icon5)).setImageResource(R$drawable.hs_ad_nostar);
            } else if (i11 >= 1.5f && i11 < 2.0f) {
                ((ImageView) inflate.findViewById(R$id.score_icon2)).setImageResource(R$drawable.hs_ad_halfstar);
                ((ImageView) inflate.findViewById(R$id.score_icon3)).setImageResource(R$drawable.hs_ad_nostar);
                ((ImageView) inflate.findViewById(R$id.score_icon4)).setImageResource(R$drawable.hs_ad_nostar);
                ((ImageView) inflate.findViewById(R$id.score_icon5)).setImageResource(R$drawable.hs_ad_nostar);
            } else if (i11 >= 2.0f && i11 < 2.5f) {
                ((ImageView) inflate.findViewById(R$id.score_icon3)).setImageResource(R$drawable.hs_ad_nostar);
                ((ImageView) inflate.findViewById(R$id.score_icon4)).setImageResource(R$drawable.hs_ad_nostar);
                ((ImageView) inflate.findViewById(R$id.score_icon5)).setImageResource(R$drawable.hs_ad_nostar);
            } else if (i11 >= 2.5f && i11 < 3.0f) {
                ((ImageView) inflate.findViewById(R$id.score_icon3)).setImageResource(R$drawable.hs_ad_halfstar);
                ((ImageView) inflate.findViewById(R$id.score_icon4)).setImageResource(R$drawable.hs_ad_nostar);
                ((ImageView) inflate.findViewById(R$id.score_icon5)).setImageResource(R$drawable.hs_ad_nostar);
            } else if (i11 >= 3.0f && i11 < 3.5f) {
                ((ImageView) inflate.findViewById(R$id.score_icon4)).setImageResource(R$drawable.hs_ad_nostar);
                ((ImageView) inflate.findViewById(R$id.score_icon5)).setImageResource(R$drawable.hs_ad_nostar);
            } else if (i11 >= 3.5f && i11 < 4.0f) {
                ((ImageView) inflate.findViewById(R$id.score_icon4)).setImageResource(R$drawable.hs_ad_halfstar);
                ((ImageView) inflate.findViewById(R$id.score_icon5)).setImageResource(R$drawable.hs_ad_nostar);
            } else if (i11 >= 4.0f && i11 < 4.5f) {
                ((ImageView) inflate.findViewById(R$id.score_icon5)).setImageResource(R$drawable.hs_ad_nostar);
            } else if (i11 >= 4.5f && i11 < 5.0f) {
                ((ImageView) inflate.findViewById(R$id.score_icon5)).setImageResource(R$drawable.hs_ad_halfstar);
            }
            this.L = 2;
        }
        inflate.setOnTouchListener(new m(this, bVar));
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TAdInterstitialActivity.Z0(view);
            }
        });
        if (n0(this.f21902q)) {
            setContentView(inflate);
        } else {
            ViewGroup viewGroup = (ViewGroup) findViewById(R$id.content_layout);
            if (viewGroup instanceof ConstraintLayout) {
                ConstraintLayout.b bVar2 = (S == null || S.length != 2) ? new ConstraintLayout.b(-1, -1) : new ConstraintLayout.b(S[0], S[1]);
                bVar2.f7775t = viewGroup.getId();
                bVar2.f7779v = viewGroup.getId();
                bVar2.f7759l = viewGroup.getId();
                bVar2.f7753i = viewGroup.getId();
                viewGroup.removeAllViews();
                viewGroup.addView(inflate, bVar2);
            } else {
                viewGroup.removeAllViews();
                viewGroup.addView(inflate, new ViewGroup.LayoutParams(-1, -1));
            }
        }
        this.K = true;
        this.f21902q.setEndCardType(this.L);
    }

    private void q0() {
        AdsDTO adsDTO = this.f21902q;
        if (adsDTO == null) {
            e4.b().d("TAdInterstitialActivity", "attachAdmView adBean is null");
            S0();
            return;
        }
        String scale = adsDTO.getScale();
        if (TextUtils.isEmpty(scale)) {
            scale = (this.f21902q.getScales() == null || this.f21902q.getScales().isEmpty()) ? "" : this.f21902q.getScales().get(0);
        }
        if (TextUtils.isEmpty(scale)) {
            e4.b().e("TAdInterstitialActivity", "attachAdmView scale is empty,finish");
            S0();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f21898m.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).I = scale;
        }
        String str = this.f21902q.getAdm() + TadmWebView.JS_TEXT;
        if (this.f21884a == null) {
            try {
                this.f21884a = new TadmWebView(getApplicationContext());
            } catch (Throwable th2) {
                e4.b().e("TAdInterstitialActivity", "create webview error: " + Log.getStackTraceString(th2));
                this.f21884a = null;
                S0();
                return;
            }
        }
        N(str);
        X(this.f21884a);
    }

    private void q1() {
        this.f21898m = (ViewGroup) findViewById(R$id.main_layout);
        this.f21886b = (TranCircleImageView) findViewById(R$id.iv_main_image);
        Y0();
        L(this.f21902q);
        b1();
        m1();
        if (this.K) {
            p1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int r(View view, boolean z10) {
        return s(view, z10, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r0(View view) {
    }

    private int s(View view, boolean z10, boolean z11) {
        return t(view, z10, z11, false);
    }

    private void s0(AdsDTO adsDTO) {
        if (adsDTO == null) {
            return;
        }
        DownLoadRequest.n(adsDTO.getAdImgUrl(), adsDTO, new g(), this.f21886b);
        e4.b().d("TAdInterstitialActivity", "use image to show ad is:= " + this.f21902q.getAdImgUrl());
    }

    private int t(View view, boolean z10, boolean z11, boolean z12) {
        int i11 = 0;
        try {
            e4.b().d("TAdInterstitialActivity", "asyncAction");
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.A > 1000 || z12) {
                if (!z10) {
                    i11 = T(view, z11);
                } else if (!this.J || this.K) {
                    O("_close", null);
                    if (!isFinishing()) {
                        S0();
                    }
                } else {
                    p1();
                }
                this.A = currentTimeMillis;
            }
        } catch (Throwable th2) {
            e4.b().e(Log.getStackTraceString(th2));
        }
        return i11;
    }

    private void t1() {
        ImageView imageView = (ImageView) findViewById(R$id.im_volume);
        this.f21899n = imageView;
        if (imageView != null) {
            imageView.setVisibility(0);
            B(this.f21904s);
        }
    }

    private void v0() {
        View findViewById = findViewById(R$id.ad_flag);
        if (findViewById != null) {
            findViewById.bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v1() {
        this.f21901p.setDisplayStyle(this.f21902q.getDisplayRule(), com.cloud.hisavana.sdk.common.util.f0.f(this.f21902q), com.cloud.hisavana.sdk.common.util.f0.e(this.f21902q), this.f21898m.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(View view) {
        r(view, true);
    }

    private void w1() {
        AdsDTO adsDTO = this.f21902q;
        if (adsDTO == null) {
            L0();
            return;
        }
        if (!TextUtils.isEmpty(adsDTO.getAdm())) {
            q0();
        } else if (this.f21902q.isInteractiveAd()) {
            D0(this.f21902q);
        } else if (this.f21902q.isVastTypeAd()) {
            J0(this.f21902q);
        } else if (this.f21902q.getSource() != 4) {
            x0(this.f21902q);
        } else if (this.f21902q.getDefaultMaterialType() == 1) {
            s0(this.f21902q);
        } else {
            J0(this.f21902q);
        }
        y1();
    }

    private void x0(AdsDTO adsDTO) {
        if (adsDTO == null) {
            return;
        }
        DownLoadRequest.o(adsDTO.getAdImgUrl(), adsDTO, 2, new i(), this.f21886b);
        e4.b().d("TAdInterstitialActivity", "use image to show ad is:= " + this.f21902q.getAdImgUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1() {
        s3 s3Var;
        WeakReference weakReference = f21883c0;
        if (weakReference == null || (s3Var = (s3) weakReference.get()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f21901p);
        arrayList.add(this.f21890e);
        arrayList.add(this.f21891f);
        arrayList.add(this.f21888c);
        arrayList.add(this.f21889d);
        m0.a(s3Var.v(), this.f21902q, this.f21893h, arrayList);
    }

    private void y1() {
        ViewGroup viewGroup;
        final View childAt;
        if (this.f21902q == null || this.f21905t || (viewGroup = this.f21898m) == null || viewGroup.getChildCount() <= 0 || (childAt = this.f21898m.getChildAt(0)) == null) {
            return;
        }
        childAt.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.activity.y
            @Override // java.lang.Runnable
            public final void run() {
                TAdInterstitialActivity.this.c1(childAt);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit z(boolean z10) {
        if (a7.c.j()) {
            HSToastUtil.f(getString(R$string.hs_download_in_palm_store));
        }
        AdsDTO adsDTO = this.f21902q;
        if (adsDTO != null) {
            adsDTO.setAdClickTracking(false);
        }
        this.U = true;
        s(getWindow().getDecorView(), z10, true);
        if (!this.S || this.V) {
            L0();
        }
        return Unit.f67184a;
    }

    private void z1() {
        try {
            TextView textView = this.f21896k;
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.t
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TAdInterstitialActivity.this.i1(view);
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    public void L0() {
        O("_close", null);
        if (isFinishing()) {
            return;
        }
        S0();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        e4.b().d("TAdInterstitialActivity", "sendBroadcast(TAG_CLOSE);");
        AdsDTO adsDTO = this.f21902q;
        if (adsDTO == null || !adsDTO.isVastTypeAd()) {
            O("_close", null);
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.W = -1;
        this.X = -1;
        V0();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        setTitle((CharSequence) null);
        if (a7.c.n() == 1) {
            setRequestedOrientation(1);
        } else if (a7.c.n() == 0) {
            setRequestedOrientation(0);
        }
        try {
            if (getIntent() != null) {
                K0((AdsDTO) getIntent().getParcelableExtra("mAdBean"));
            }
        } catch (Exception unused) {
        }
        super.onCreate(bundle);
        if (com.cloud.sdk.commonutil.util.e.h()) {
            this.f21904s = a7.c.r() ? 0.0f : 1.0f;
            A1();
            this.C = true;
        } else {
            com.cloud.sdk.commonutil.util.e.g(getApplicationContext());
            C(TaErrorCode.CODE_INIT_ERROR, TaErrorCode.ERROR_SHOW_INIT_ERROR.getErrorMessage());
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        O("_close", null);
        O("_destroy", null);
        com.cloud.hisavana.sdk.common.tranmeasure.e.c().g(this.f21902q);
        com.cloud.sdk.commonutil.util.k.a(this.f21886b);
        com.cloud.sdk.commonutil.util.k.a(this.f21892g);
        com.cloud.sdk.commonutil.util.k.a(this.f21888c);
        ViewGroup viewGroup = this.f21893h;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.f21893h = null;
        }
        ViewGroup viewGroup2 = this.f21898m;
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
            this.f21898m = null;
        }
        TadmWebView tadmWebView = this.f21884a;
        if (tadmWebView != null) {
            tadmWebView.destroy();
            this.f21884a = null;
        }
        com.cloud.hisavana.sdk.r rVar = this.E;
        if (rVar != null) {
            rVar.c();
            this.E = null;
        }
        InteractiveWebView interactiveWebView = this.f21897l;
        if (interactiveWebView != null) {
            interactiveWebView.destroy();
            this.f21897l = null;
        }
        InterstitialAdVideoView interstitialAdVideoView = this.f21900o;
        if (interstitialAdVideoView != null) {
            interstitialAdVideoView.release();
            this.f21900o = null;
        }
        if (this.f21901p != null) {
            this.f21901p = null;
        }
        com.cloud.hisavana.sdk.common.util.v vVar = this.F;
        if (vVar != null) {
            vVar.dismiss();
            this.F = null;
        }
        e7.e eVar = this.G;
        if (eVar != null) {
            eVar.d();
            this.G = null;
        }
        f21883c0 = null;
        try {
            e7.d dVar = this.Q;
            if (dVar != null) {
                if (dVar.l()) {
                    this.Q.dismiss();
                }
                this.Q = null;
            }
        } catch (Throwable unused) {
        }
        try {
            ObjectAnimator objectAnimator = this.f21885a0;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.f21885a0 = null;
            }
            Runnable runnable = this.f21887b0;
            if (runnable != null) {
                com.cloud.hisavana.sdk.common.util.r.f22275a.n(this.f21896k, runnable);
            }
        } catch (Exception unused2) {
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        e4.b().d("TAdInterstitialActivity", "onNewIntent ----------------------->");
        if (this.C) {
            setIntent(intent);
            A1();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        try {
            e7.d dVar = this.Q;
            if (dVar == null || !dVar.l()) {
                return;
            }
            this.Q.dismiss();
        } catch (Throwable th2) {
            e4.b().w("TAdInterstitialActivity", "onPause dismiss bubble dialog failed: " + th2.getMessage());
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT <= 29) {
            A();
        }
        try {
            if (this.O == 3 && this.P) {
                this.P = false;
                if (a7.c.j()) {
                    HSToastUtil.f(getString(R$string.hs_interstitial_breadk_ended));
                }
                L0();
            }
        } catch (Throwable unused) {
        }
    }
}
