package com.transsion.usercenter.setting;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.laboratory.LabPwdDialog;
import com.transsion.usercenter.laboratory.LaboratoryActivity;
import com.transsion.usercenter.laboratory.MccActivity;
import com.transsion.usercenter.laboratory.developer.AdDeveloperDialog;
import com.transsion.web.api.WebPageIdentity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import fw.g1;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00128\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/transsion/usercenter/setting/SettingAboutUsActivity;", "Lcom/transsion/baseui/activity/BaseActivity;", "Lfw/g1;", "<init>", "()V", "", "initView", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "isStatusDark", "()Z", "isTranslucent", "i0", "()Lfw/g1;", "onDestroy", "", "a", "I", "CLICK_COUNT", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "CLICK_TIME", "", "c", "J", "lastClickTime", "d", "clickCount", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class SettingAboutUsActivity extends BaseActivity<g1> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int CLICK_COUNT = 6;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int CLICK_TIME = 500;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int clickCount;

    /* loaded from: classes6.dex */
    public static final class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.h(widget, "widget");
            Navigator.x(TheRouter.c(WebPageIdentity.WEB_VIEW).K("url", "https://h5-static.aoneroom.com/spa/html/moviebox-privacy-policy.html"), SettingAboutUsActivity.this, null, 2, null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds2) {
            Intrinsics.h(ds2, "ds");
            super.updateDrawState(ds2);
            ds2.setColor(androidx.core.content.b.getColor(SettingAboutUsActivity.this, R$color.main));
            ds2.setUnderlineText(false);
            ds2.clearShadowLayer();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.h(widget, "widget");
            Navigator.x(TheRouter.c(WebPageIdentity.WEB_VIEW).K("url", "https://h5-static.aoneroom.com/spa/html/moviebox-terms-of-use.html"), SettingAboutUsActivity.this, null, 2, null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds2) {
            Intrinsics.h(ds2, "ds");
            super.updateDrawState(ds2);
            ds2.setColor(androidx.core.content.b.getColor(SettingAboutUsActivity.this, R$color.main));
            ds2.setUnderlineText(false);
            ds2.clearShadowLayer();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        TitleLayout titleLayout = ((g1) getMViewBinding()).f62794c;
        String string = getString(R$string.user_setting_About_us);
        Intrinsics.g(string, "getString(...)");
        titleLayout.setTitleText(string);
        String string2 = getString(R$string.login_sign_up_privacy);
        Intrinsics.g(string2, "getString(...)");
        String string3 = getString(R$string.login_privacy);
        Intrinsics.g(string3, "getString(...)");
        String string4 = getString(R$string.login_user_agreement);
        Intrinsics.g(string4, "getString(...)");
        SpannableString spannableString = new SpannableString(string2);
        a aVar = new a();
        b bVar = new b();
        int o02 = StringsKt.o0(string2, string3, 0, false, 6, null);
        int i11 = o02 != -1 ? o02 : 0;
        int o03 = StringsKt.o0(string2, string4, 0, false, 6, null);
        if (o03 == -1) {
            o03 = 0;
        }
        spannableString.setSpan(aVar, i11, string3.length() + i11, 33);
        spannableString.setSpan(bVar, o03, string4.length() + o03, 33);
        AppCompatTextView appCompatTextView = ((g1) getMViewBinding()).f62795d;
        appCompatTextView.setText(spannableString);
        appCompatTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ((g1) getMViewBinding()).f62796e.setText(com.blankj.utilcode.util.c.h());
        final boolean z10 = System.currentTimeMillis() - com.transsion.baselib.report.launch.b.f43424a.b().getLong("lab_enter_password_time", 0L) < TimeUnit.DAYS.toMillis(1L);
        ((g1) getMViewBinding()).f62796e.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingAboutUsActivity.j0(SettingAboutUsActivity.this, z10, view);
            }
        });
        ((g1) getMViewBinding()).f62793b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingAboutUsActivity.l0(SettingAboutUsActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(final SettingAboutUsActivity settingAboutUsActivity, boolean z10, View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - settingAboutUsActivity.lastClickTime < settingAboutUsActivity.CLICK_TIME) {
            settingAboutUsActivity.clickCount++;
        } else {
            settingAboutUsActivity.clickCount = 0;
        }
        settingAboutUsActivity.lastClickTime = currentTimeMillis;
        if (settingAboutUsActivity.clickCount == settingAboutUsActivity.CLICK_COUNT) {
            if (z10) {
                settingAboutUsActivity.startActivity(new Intent(settingAboutUsActivity, (Class<?>) LaboratoryActivity.class));
            } else {
                new LabPwdDialog().r0(new Function0() { // from class: com.transsion.usercenter.setting.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit k02;
                        k02 = SettingAboutUsActivity.k0(SettingAboutUsActivity.this);
                        return k02;
                    }
                }).k0(settingAboutUsActivity, "labPwd");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(SettingAboutUsActivity settingAboutUsActivity) {
        settingAboutUsActivity.startActivity(new Intent(settingAboutUsActivity, (Class<?>) LaboratoryActivity.class));
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(final SettingAboutUsActivity settingAboutUsActivity, View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - settingAboutUsActivity.lastClickTime < settingAboutUsActivity.CLICK_TIME) {
            settingAboutUsActivity.clickCount++;
        } else {
            settingAboutUsActivity.clickCount = 0;
        }
        settingAboutUsActivity.lastClickTime = currentTimeMillis;
        if (settingAboutUsActivity.clickCount == settingAboutUsActivity.CLICK_COUNT) {
            new AdDeveloperDialog().r0(new Function0() { // from class: com.transsion.usercenter.setting.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit m02;
                    m02 = SettingAboutUsActivity.m0(SettingAboutUsActivity.this);
                    return m02;
                }
            }).k0(settingAboutUsActivity, "AdDeveloperDialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(SettingAboutUsActivity settingAboutUsActivity) {
        settingAboutUsActivity.startActivity(new Intent(settingAboutUsActivity, (Class<?>) MccActivity.class));
        return Unit.f67184a;
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public g1 getViewBinding() {
        g1 c11 = g1.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.clickCount = 0;
    }
}
