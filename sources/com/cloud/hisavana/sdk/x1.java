package com.cloud.hisavana.sdk;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import com.cloud.hisavana.sdk.common.bean.PslinkInfo;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.common.util.HSChronometer;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdsProtocolBean;
import com.cloud.hisavana.sdk.data.bean.response.NativeBean;
import com.cloud.hisavana.sdk.v2;
import com.cloud.sdk.commonutil.util.HSToastUtil;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes3.dex */
public final class x1 extends o0 {

    /* renamed from: d, reason: collision with root package name */
    private boolean f23158d;

    /* renamed from: e, reason: collision with root package name */
    private int f23159e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f23160f;

    /* renamed from: g, reason: collision with root package name */
    private int f23161g;

    /* renamed from: h, reason: collision with root package name */
    private long f23162h;

    /* renamed from: i, reason: collision with root package name */
    private int f23163i;

    /* renamed from: j, reason: collision with root package name */
    private int f23164j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x1(Activity activity, View rootView, g4 helper) {
        super(activity, rootView, helper);
        Intrinsics.h(activity, "activity");
        Intrinsics.h(rootView, "rootView");
        Intrinsics.h(helper, "helper");
        this.f23163i = -1;
        this.f23164j = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(x1 this$0, View view) {
        Intrinsics.h(this$0, "this$0");
        this$0.p(null, true);
    }

    private final void q(AdsDTO adsDTO) {
        String str;
        StoreMarkView storeMarkView;
        NativeBean nativeObject;
        PslinkInfo pslinkInfo;
        NativeBean nativeObject2;
        AdsProtocolBean.Ext ext;
        NativeBean nativeObject3;
        try {
            TextView textView = (TextView) g().findViewById(R$id.ad_btn);
            String str2 = null;
            r3 = null;
            String str3 = null;
            r3 = null;
            Integer num = null;
            str2 = null;
            if (textView != null) {
                if (adsDTO != null) {
                    int installApk = adsDTO.getInstallApk();
                    NativeBean nativeObject4 = adsDTO.getNativeObject();
                    if (nativeObject4 != null) {
                        str = nativeObject4.getButtonTxt(installApk);
                        textView.setText(str);
                    }
                }
                str = null;
                textView.setText(str);
            }
            if (textView != null) {
                CharSequence text = textView.getText();
                textView.setVisibility((text == null || text.length() <= 0) ? 8 : 0);
            }
            TextView textView2 = (TextView) g().findViewById(R$id.tv_reward_tips);
            ImageView imageView = (ImageView) g().findViewById(R$id.iv_download_app_score);
            TextView textView3 = (TextView) g().findViewById(R$id.ad_description);
            ConstraintLayout constraintLayout = (ConstraintLayout) g().findViewById(R$id.ad_float_container);
            if (textView != null) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.w1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        x1.n(x1.this, view);
                    }
                });
            }
            try {
                storeMarkView = (StoreMarkView) g().findViewById(R$id.ps_mark_view);
            } catch (Throwable unused) {
                storeMarkView = null;
            }
            int i11 = this.f23159e;
            if (i11 == 2) {
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                if (textView3 != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(com.cloud.hisavana.sdk.common.util.r.f22275a.i((adsDTO == null || (pslinkInfo = adsDTO.getPslinkInfo()) == null) ? null : pslinkInfo.getSourceSize()));
                    sb2.append(" · ");
                    if (adsDTO != null && (nativeObject = adsDTO.getNativeObject()) != null) {
                        str2 = nativeObject.getDescriptionTxt();
                    }
                    sb2.append(str2);
                    textView3.setText(sb2.toString());
                }
                if (textView2 == null) {
                    return;
                }
                textView2.setText(com.cloud.sdk.commonutil.util.e.a().getResources().getString(R$string.hs_download_reward_pull_new));
                return;
            }
            if (i11 != 3) {
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                if (textView3 != null) {
                    StringBuilder sb3 = new StringBuilder();
                    v2.a aVar = v2.f23109a;
                    sb3.append(aVar.b(aVar.j(adsDTO)));
                    sb3.append(" · ");
                    if (adsDTO != null && (nativeObject3 = adsDTO.getNativeObject()) != null) {
                        str3 = nativeObject3.getDescriptionTxt();
                    }
                    sb3.append(str3);
                    textView3.setText(sb3.toString());
                }
                if (textView2 == null) {
                    return;
                }
                textView2.setText(com.cloud.sdk.commonutil.util.e.a().getResources().getString(R$string.hs_download_reward_pull_new));
                return;
            }
            if (storeMarkView != null) {
                storeMarkView.setVisibility(8);
            }
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (!f().getIsLandscape()) {
                androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
                bVar.q(constraintLayout);
                bVar.o(R$id.ad_btn, 4);
                bVar.t(R$id.ad_btn, 4, R$id.iv_reward_download_bg, 4);
                bVar.Z(R$id.ad_btn, 0.5f);
                bVar.X(R$id.ad_btn, 3, 0);
                bVar.i(constraintLayout);
            }
            if (textView3 != null) {
                StringBuilder sb4 = new StringBuilder();
                v2.a aVar2 = v2.f23109a;
                sb4.append(aVar2.b(aVar2.j(adsDTO)));
                sb4.append(" · ");
                sb4.append((adsDTO == null || (nativeObject2 = adsDTO.getNativeObject()) == null) ? null : nativeObject2.getDescriptionTxt());
                textView3.setText(sb4.toString());
            }
            if (adsDTO != null && (ext = adsDTO.getExt()) != null) {
                num = ext.getDwellTime();
            }
            int intValue = num == null ? 0 : num.intValue();
            this.f23161g = intValue;
            if (intValue <= 0) {
                if (textView2 == null) {
                    return;
                }
                textView2.setText(com.cloud.sdk.commonutil.util.e.a().getResources().getString(R$string.hs_download_reward_pull_live_no_time));
            } else {
                if (textView2 == null) {
                    return;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
                Locale locale = Locale.getDefault();
                String string = com.cloud.sdk.commonutil.util.e.a().getResources().getString(R$string.hs_download_reward_pull_live);
                Intrinsics.g(string, "getString(...)");
                String format = String.format(locale, string, Arrays.copyOf(new Object[]{Integer.valueOf(this.f23161g)}, 1));
                Intrinsics.g(format, "format(...)");
                textView2.setText(format);
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // com.cloud.hisavana.sdk.o0
    public void b(ImageView imageView, float f11) {
        if (imageView != null) {
            imageView.setImageResource(0.0f == f11 ? R$drawable.hisavana_volume_close : R$drawable.hisavana_volume_open);
        }
    }

    @Override // com.cloud.hisavana.sdk.o0
    public void c(HSChronometer hSChronometer) {
        if (hSChronometer != null) {
            hSChronometer.setTickStringFormat(hSChronometer.getResources().getString(R$string.reward_before_tip_r02));
            hSChronometer.setFinishedString(hSChronometer.getResources().getString(R$string.reward_after_tip_r02));
        }
    }

    @Override // com.cloud.hisavana.sdk.o0
    public void d(AdsDTO adsDTO) {
        com.cloud.hisavana.sdk.common.util.r rVar = com.cloud.hisavana.sdk.common.util.r.f22275a;
        this.f23159e = rVar.d(adsDTO);
        this.f23158d = rVar.c(adsDTO);
        q(adsDTO);
        f().b();
    }

    @Override // com.cloud.hisavana.sdk.o0
    public void e(boolean z10, DownUpPointBean downUpPointBean, View view) {
        if (view != null) {
            o(downUpPointBean, view);
        }
        p(downUpPointBean, false);
    }

    @Override // com.cloud.hisavana.sdk.o0
    public void h() {
        this.f23162h = System.currentTimeMillis();
    }

    @Override // com.cloud.hisavana.sdk.o0
    public void i() {
        if (this.f23160f) {
            this.f23160f = false;
            long currentTimeMillis = this.f23161g - ((System.currentTimeMillis() - this.f23162h) / 1000);
            if (currentTimeMillis <= 0) {
                f().a();
                return;
            }
            this.f23161g = (int) currentTimeMillis;
            TextView textView = (TextView) g().findViewById(R$id.tv_reward_tips);
            if (textView == null) {
                return;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            Locale locale = Locale.getDefault();
            String string = com.cloud.sdk.commonutil.util.e.a().getResources().getString(R$string.hs_download_reward_pull_live);
            Intrinsics.g(string, "getString(...)");
            String format = String.format(locale, string, Arrays.copyOf(new Object[]{Integer.valueOf(this.f23161g)}, 1));
            Intrinsics.g(format, "format(...)");
            textView.setText(format);
        }
    }

    @Override // com.cloud.hisavana.sdk.o0
    public void j() {
        try {
            View findViewById = g().findViewById(R$id.iv_reward_gift);
            Intrinsics.g(findViewById, "findViewById(...)");
            ((ImageView) findViewById).setImageResource(R$drawable.ad_reward_time_gift_done);
        } catch (Throwable unused) {
        }
    }

    @Override // com.cloud.hisavana.sdk.o0
    public void k() {
        Unit unit;
        if (!f().getIsLandscape()) {
            a().setContentView(R$layout.activity_rewarded_r02);
            return;
        }
        AdsDTO adBean = f().getAdBean();
        if (adBean != null) {
            if (Intrinsics.c(adBean.getScale(), "9:16")) {
                a().setContentView(R$layout.activity_rewarded_r02_916);
            } else {
                a().setContentView(R$layout.activity_rewarded_r02);
            }
            unit = Unit.f67184a;
        } else {
            unit = null;
        }
        if (unit == null) {
            a().setContentView(R$layout.activity_rewarded_r02);
        }
    }

    @Override // com.cloud.hisavana.sdk.o0
    public void l() {
        Object obj;
        String str;
        Object obj2;
        if (a7.c.j()) {
            int i11 = this.f23159e;
            if (i11 == 2) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    obj = Result.m1185constructorimpl(com.cloud.sdk.commonutil.util.e.a().getString(R$string.hs_reward_claimed_download));
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    obj = Result.m1185constructorimpl(ResultKt.a(th2));
                }
                str = Result.m1191isFailureimpl(obj) ? "" : obj;
                Intrinsics.g(str, "getOrDefault(...)");
                HSToastUtil.f((String) str);
                return;
            }
            if (i11 != 3) {
                return;
            }
            try {
                Result.Companion companion3 = Result.INSTANCE;
                obj2 = Result.m1185constructorimpl(com.cloud.sdk.commonutil.util.e.a().getString(R$string.hs_reward_claimed_toast));
            } catch (Throwable th3) {
                Result.Companion companion4 = Result.INSTANCE;
                obj2 = Result.m1185constructorimpl(ResultKt.a(th3));
            }
            str = Result.m1191isFailureimpl(obj2) ? "" : obj2;
            Intrinsics.g(str, "getOrDefault(...)");
            HSToastUtil.f((String) str);
        }
    }

    public final void o(DownUpPointBean downUpPointBean, View view) {
        Intrinsics.h(view, "view");
        if (downUpPointBean != null) {
            try {
                if (this.f23163i != -1) {
                    if (this.f23164j == -1) {
                    }
                    if (this.f23163i != -1 || this.f23164j == -1) {
                    }
                    downUpPointBean.setDownX(downUpPointBean.getDownX() + this.f23163i);
                    downUpPointBean.setDownY(downUpPointBean.getDownY() + this.f23164j);
                    return;
                }
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                this.f23163i = iArr[0];
                this.f23164j = iArr[1];
                if (this.f23163i != -1) {
                }
            } catch (Throwable th2) {
                e4.b().w("RewardR02SytleImpl", "calculateLocation error: " + th2.getMessage());
            }
        }
    }

    public final void p(DownUpPointBean downUpPointBean, boolean z10) {
        int i11 = this.f23159e;
        if (i11 != 2) {
            if (i11 != 3) {
                f().b(false, downUpPointBean);
                return;
            } else {
                this.f23160f = true;
                f().b(false, downUpPointBean);
                return;
            }
        }
        if (!this.f23158d && !z10) {
            f().a(downUpPointBean);
            return;
        }
        f().d();
        if (z10) {
            f().a(2);
        } else {
            f().a(1);
        }
        f().b(false, downUpPointBean);
        f().e();
    }
}
