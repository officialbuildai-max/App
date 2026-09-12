package com.transsion.search_pugc.activity;

import ak.x;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import androidx.view.v0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.j;
import com.therouter.TheRouter;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.search.R$id;
import com.transsion.search_pugc.fragment.SearchSubjectFragment;
import com.transsion.search_pugc.g;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import gr.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import nh.m;
import rq.a;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\tR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010\u001e¨\u0006)"}, d2 = {"Lcom/transsion/search_pugc/activity/SearchManagerActivity;", "Lcom/transsion/baseui/activity/BaseNewActivity;", "Lrq/a;", "<init>", "()V", "", "G0", "", "i0", "()Ljava/lang/String;", "F0", "()Lrq/a;", "o0", "p0", "n0", "s0", "t0", "retryLoadData", "", "q0", "()Z", "isTranslucent", "isStatusDark", "isChangeStatusBar", "getPageName", "Landroidx/fragment/app/Fragment;", "i", "Landroidx/fragment/app/Fragment;", "mFragment", j.f35620b, "Ljava/lang/String;", "keyWord", "", CampaignEx.JSON_KEY_AD_K, "I", "searchType", "l", "Z", "backExitSearch", "m", "fromUGCVideoId", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class SearchManagerActivity extends BaseNewActivity<a> {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Fragment mFragment;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public String keyWord;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public int searchType = 3;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public boolean backExitSearch;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public String fromUGCVideoId;

    private final void G0() {
        if (this.mFragment != null) {
            return;
        }
        String stringExtra = getIntent().getStringExtra("hot_search_word");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        w p11 = supportFragmentManager.p();
        Intrinsics.g(p11, "beginTransaction()");
        SearchSubjectFragment a11 = SearchSubjectFragment.INSTANCE.a(stringExtra, this.keyWord, this.backExitSearch, this.fromUGCVideoId);
        this.mFragment = a11;
        int i11 = R$id.fl_content;
        Intrinsics.e(a11);
        p11.s(i11, a11);
        p11.j();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public a getViewBinding() {
        a c11 = a.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "searchpage";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String i0() {
        return "";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isChangeStatusBar() {
        return !x.f733a.a();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isStatusDark() {
        return !x.f733a.a();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void n0() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void o0() {
        TheRouter.l(this);
        g.f52532h.d(this).F(((c) new v0(this).a(c.class)).g());
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void p0() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean q0() {
        return this.searchType != 1;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
        z0();
        if (!m.f70597a.e()) {
            B0();
        } else {
            x0();
            G0();
        }
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void s0() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void t0() {
        super.t0();
        G0();
    }
}
