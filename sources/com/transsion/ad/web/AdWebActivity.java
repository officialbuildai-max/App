package com.transsion.ad.web;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.R$anim;
import com.transsion.ad.R$id;
import com.transsion.ad.strategy.AdOverridePendingTransitionManager;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.mvel2.ast.ASTNode;
import ti.i;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/transsion/ad/web/AdWebActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "a", "lib_ad_gpRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes5.dex */
public final class AdWebActivity extends AppCompatActivity {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: com.transsion.ad.web.AdWebActivity$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* renamed from: com.transsion.ad.web.AdWebActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public /* synthetic */ class C0601a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f42495a;

            static {
                int[] iArr = new int[AdOverridePendingTransitionManager.AdOverridePendingTransitionEnum.values().length];
                try {
                    iArr[AdOverridePendingTransitionManager.AdOverridePendingTransitionEnum.OVERRIDE_PENDING_TRANSITION_1.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                f42495a = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(String str, AdOverridePendingTransitionManager.AdOverridePendingTransitionEnum adOverridePendingTransitionEnum, String str2) {
            Activity b11 = com.blankj.utilcode.util.a.b();
            if (b11 == null) {
                return;
            }
            Intent intent = new Intent(b11, (Class<?>) AdWebActivity.class);
            intent.putExtra("url", str);
            intent.putExtra("web_activity_extra_log_tag_key", str2);
            intent.addFlags(ASTNode.DEOP);
            Utils.a().startActivity(intent);
            if ((adOverridePendingTransitionEnum == null ? -1 : C0601a.f42495a[adOverridePendingTransitionEnum.ordinal()]) == 1) {
                b11.overridePendingTransition(R$anim.slide_in_from_top, R$anim.no_anim);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        String str;
        super.onCreate(savedInstanceState);
        ji.a c11 = ji.a.c(getLayoutInflater());
        Intrinsics.g(c11, "inflate(...)");
        setContentView(c11.getRoot());
        AdWebFragment adWebFragment = new AdWebFragment();
        Bundle bundle = new Bundle();
        Intent intent = getIntent();
        bundle.putString("url", intent != null ? intent.getStringExtra("url") : null);
        Intent intent2 = getIntent();
        bundle.putString("web_activity_extra_log_tag_key", intent2 != null ? intent2.getStringExtra("web_activity_extra_log_tag_key") : null);
        adWebFragment.setArguments(bundle);
        i iVar = i.f76383a;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
        i.b(iVar, supportFragmentManager, R$id.flContain, adWebFragment, false, null, 24, null);
        oi.a aVar = oi.a.f71145a;
        Intent intent3 = getIntent();
        if (intent3 == null || (str = intent3.getStringExtra("web_activity_extra_log_tag_key")) == null) {
            str = "ad_";
        }
        oi.a.o(aVar, str, "AdWebActivity --> onCreate() --> 内置WebView处理广告落地页", 0, false, 12, null);
    }
}
