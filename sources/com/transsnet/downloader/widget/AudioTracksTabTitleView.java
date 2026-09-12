package com.transsnet.downloader.widget;

import android.content.Context;
import android.graphics.Typeface;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.event.EventConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.widget.R$color;
import com.transsnet.downloader.R$drawable;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;
import ph.c;
import tj.a;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ\u000f\u0010\u0016\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u0019\u0010\u001e\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b \u0010\u001fJ!\u0010#\u001a\u00020\r2\u0010\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b*\u0010(R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/transsnet/downloader/widget/AudioTracksTabTitleView;", "Lnet/lucode/hackware/magicindicator/buildins/commonnavigator/titles/SimplePagerTitleView;", "Ltj/a;", "Landroid/content/Context;", "context", "", CampaignEx.JSON_KEY_TITLE, "subTitle", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "", "index", "totalCount", "", "onSelected", "(II)V", "", "isSelected", "Lph/c;", "getContent", "(Z)Lph/c;", "onDeselected", "changeLocal", "()V", "resId", "setTextById", "(I)V", "setHintById", "", "srt", "setHintWithString", "(Ljava/lang/CharSequence;)V", "setTextWithString", "Lkotlin/Function0;", EventConstants.KEY_ACTION, "setTextAction", "(Lkotlin/jvm/functions/Function0;)V", "c", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "d", "getSubTitle", "Ltj/c;", "e", "Ltj/c;", "textDelegate", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class AudioTracksTabTitleView extends SimplePagerTitleView implements tj.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String subTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final tj.c textDelegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioTracksTabTitleView(Context context, String title, String subTitle) {
        super(context);
        Intrinsics.h(context, "context");
        Intrinsics.h(title, "title");
        Intrinsics.h(subTitle, "subTitle");
        this.title = title;
        this.subTitle = subTitle;
        int a11 = com.blankj.utilcode.util.a0.a(8.0f);
        setSelectedColor(androidx.core.content.b.getColor(context, R$color.main));
        setNormalColor(androidx.core.content.b.getColor(context, R$color.text_02));
        setTextSize(16.0f);
        setGravity(17);
        setTypeface(jg.a.c(context));
        setPadding(a11, 0, a11, 0);
        this.textDelegate = new tj.c(this);
    }

    @Override // tj.a
    public void changeLocal() {
        this.textDelegate.changeLocal();
    }

    public final ph.c getContent(boolean isSelected) {
        if (this.subTitle.length() == 0) {
            ph.c b11 = ph.c.e().e(this.title).c(isSelected ? getSelectedColor() : getNormalColor()).b();
            Intrinsics.g(b11, "build(...)");
            return b11;
        }
        c.a e11 = ph.c.e().e(this.title);
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        ph.c b12 = e11.f(jg.a.c(context)).c(isSelected ? getSelectedColor() : getNormalColor()).e(" " + this.subTitle).d(14).f(Typeface.create(Typeface.DEFAULT, 0)).c(isSelected ? getSelectedColor() : androidx.core.content.b.getColor(Utils.a(), R$color.text_03)).b();
        Intrinsics.g(b12, "build(...)");
        return b12;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, j00.d
    public void onDeselected(int index, int totalCount) {
        super.onDeselected(index, totalCount);
        setText(getContent(false));
        setBackgroundColor(0);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, j00.d
    public void onSelected(int index, int totalCount) {
        super.onSelected(index, totalCount);
        setText(getContent(true));
        setBackgroundResource(R$drawable.bg_res_ep_tab);
    }

    public void setHintById(int resId) {
        this.textDelegate.b(resId);
    }

    public void setHintWithString(CharSequence srt) {
        this.textDelegate.c(srt);
    }

    public void setLocalChangeListener(Function0<Unit> function0) {
        a.C0953a.a(this, function0);
    }

    public void setTextAction(Function0<? extends CharSequence> action) {
        this.textDelegate.e(action);
    }

    public void setTextById(int resId) {
        this.textDelegate.f(resId);
    }

    public void setTextWithString(CharSequence srt) {
        this.textDelegate.g(srt);
    }
}
