package com.transsion.home.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.blankj.utilcode.util.a0;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.therouter.TheRouter;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.home.R$id;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.preload.MainXMLPreloadControlImp;
import com.transsion.home.preload.a;
import com.transsion.home.preload.b;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import gl.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oh.h;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0018\u0010\u0005J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010$¨\u0006&"}, d2 = {"Lcom/transsion/home/activity/OperateActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lgl/d;", "Lcom/transsion/home/preload/a;", "<init>", "()V", "", "g0", "f0", "()Lgl/d;", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/os/Bundle;)V", "", "e0", "()I", "", "isTranslucent", "()Z", "isStatusDark", "", "getPageName", "()Ljava/lang/String;", "onDestroy", "Lcom/transsion/home/preload/b;", "d", "()Lcom/transsion/home/preload/b;", "a", "I", "tabId", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "tabCode", "c", CampaignEx.JSON_KEY_TITLE, "Lcom/transsion/home/preload/b;", "xmlPreload", "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class OperateActivity extends BaseActivity<d> implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int tabId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public String tabCode = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public String title = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private b xmlPreload;

    /* JADX WARN: Multi-variable type inference failed */
    private final void g0() {
        TitleLayout titleLayout = ((d) getMViewBinding()).f63794c;
        titleLayout.setTitleText(this.title);
        h hVar = h.f71144a;
        Context context = titleLayout.getContext();
        Intrinsics.g(context, "getContext(...)");
        titleLayout.setPadding(0, hVar.d(context), 0, 0);
        titleLayout.setBackgroundColor(com.blankj.utilcode.util.h.a(R$color.transparent));
        titleLayout.setViewLineVisible(false);
    }

    @Override // com.transsion.home.preload.a
    public b d() {
        if (this.xmlPreload == null && Build.VERSION.SDK_INT > 28) {
            this.xmlPreload = new MainXMLPreloadControlImp(this);
        }
        return this.xmlPreload;
    }

    public final int e0() {
        h hVar = h.f71144a;
        Context applicationContext = getApplicationContext();
        Intrinsics.g(applicationContext, "getApplicationContext(...)");
        return hVar.d(applicationContext) + a0.a(44.0f);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public d getViewBinding() {
        TheRouter.l(this);
        d c11 = d.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return SubTabFragment.INSTANCE.a(this.tabId);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle savedInstanceState) {
        g0();
        getSupportFragmentManager().p().s(R$id.operate_page_container, SubTabFragment.INSTANCE.b(this.tabId, this.tabCode)).j();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b bVar = this.xmlPreload;
        if (bVar != null) {
            bVar.reset();
        }
        this.xmlPreload = null;
    }
}
