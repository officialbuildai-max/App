package com.transsion.shorttv.ui.activity;

import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.activity.u;
import androidx.core.os.d;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.therouter.TheRouter;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.base.activity.BaseNewActivity;
import com.transsion.shorttv.ui.fragment.ShortTVFavoriteFragment;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;
import ms.l;
import yr.b;

@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\b\u0005*\u0001\u001c\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0018\u0010\u0004R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/transsion/shorttv/ui/activity/ShortTVFavoriteActivity;", "Lcom/transsion/shorttv/base/activity/BaseNewActivity;", "Lms/l;", "<init>", "()V", "o0", "()Lms/l;", "", "Y", "()Ljava/lang/String;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "e0", "j0", "", "isTranslucent", "()Z", "isStatusDark", "f0", "d0", "i0", "retryLoadData", j.f35620b, "Ljava/lang/String;", "ops", "com/transsion/shorttv/ui/activity/ShortTVFavoriteActivity$a", CampaignEx.JSON_KEY_AD_K, "Lcom/transsion/shorttv/ui/activity/ShortTVFavoriteActivity$a;", "onBackPress", "shortTvLib_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class ShortTVFavoriteActivity extends BaseNewActivity<l> {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public String ops;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final a onBackPress = new a();

    /* loaded from: classes6.dex */
    public static final class a extends u {
        a() {
            super(true);
        }

        @Override // androidx.activity.u
        public void handleOnBackPressed() {
            a.C0856a.g(lg.a.f68962a, "ShortTVFavoriteActivity --> onBackPress --> handleOnBackPressed() --> setResult(RESULT_OK)", false, 2, null);
            ShortTVFavoriteActivity.this.finish();
        }
    }

    @Override // com.transsion.shorttv.base.activity.BaseNewActivity
    public String Y() {
        return "";
    }

    @Override // com.transsion.shorttv.base.activity.BaseNewActivity
    public void d0() {
    }

    @Override // com.transsion.shorttv.base.activity.BaseNewActivity
    public void e0() {
        FrameLayout root = ((l) getMViewBinding()).getRoot();
        Intrinsics.g(root, "getRoot(...)");
        b.a(root);
        l0();
    }

    @Override // com.transsion.shorttv.base.activity.BaseNewActivity
    public void f0() {
        getOnBackPressedDispatcher().i(this, this.onBackPress);
    }

    @Override // com.transsion.shorttv.base.activity.BaseNewActivity
    public void i0() {
    }

    @Override // com.transsion.shorttv.base.activity.BaseNewActivity
    public boolean isStatusDark() {
        return false;
    }

    @Override // com.transsion.shorttv.base.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.shorttv.base.activity.BaseNewActivity
    public void j0() {
        super.j0();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        w p11 = supportFragmentManager.p();
        Intrinsics.g(p11, "beginTransaction()");
        ShortTVFavoriteFragment a11 = ShortTVFavoriteFragment.INSTANCE.a();
        a11.setArguments(d.b(TuplesKt.a("ops", this.ops)));
        p11.t(R$id.flContent, a11, "ShortTVFavoriteFragment");
        p11.j();
    }

    @Override // com.transsion.shorttv.base.activity.BaseCommonActivity
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public l getViewBinding() {
        l c11 = l.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.shorttv.base.activity.BaseNewActivity, com.transsion.shorttv.base.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        TheRouter.l(this);
        super.onCreate(savedInstanceState);
    }

    @Override // com.transsion.shorttv.base.activity.BaseNewActivity
    public void retryLoadData() {
    }
}
