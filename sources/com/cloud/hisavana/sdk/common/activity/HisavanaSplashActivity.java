package com.cloud.hisavana.sdk.common.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.R$style;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.widget.CountTimeView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.i1;
import com.cloud.hisavana.sdk.r4;
import com.cloud.tmc.kernel.constants.TmcConstants;
import org.mvel2.ast.ASTNode;

/* loaded from: classes3.dex */
public class HisavanaSplashActivity extends AppCompatActivity {

    /* renamed from: f, reason: collision with root package name */
    private static boolean f21856f;

    /* renamed from: b, reason: collision with root package name */
    private i1 f21858b;

    /* renamed from: c, reason: collision with root package name */
    private long f21859c;

    /* renamed from: e, reason: collision with root package name */
    private String f21861e;

    /* renamed from: a, reason: collision with root package name */
    private final String f21857a = "HisavanaSplashActivity";

    /* renamed from: d, reason: collision with root package name */
    private boolean f21860d = false;

    private void R() {
        CountTimeView J;
        i1 i1Var = this.f21858b;
        if (i1Var == null || (J = i1Var.J()) == null) {
            return;
        }
        J.setStartTime((int) this.f21859c);
        J.start();
    }

    public static void T(Context context, String str, boolean z10) {
        f21856f = z10;
        Intent intent = new Intent(context, (Class<?>) HisavanaSplashActivity.class);
        intent.setFlags(ASTNode.DEOP);
        intent.putExtra("uniqueID", str);
        context.startActivity(intent);
    }

    private void U() {
        this.f21861e = getIntent().getStringExtra("uniqueID");
        i1 a11 = r4.b().a(this.f21861e);
        this.f21858b = a11;
        if (a11 == null || a11.r() != 0) {
            finish();
            i1 i1Var = this.f21858b;
            if (i1Var != null) {
                i1Var.e0(TaErrorCode.ERROR_SHOW_INNER_INVALID);
                return;
            }
            return;
        }
        setContentView(R$layout.activity_hisavana_splash);
        if (f21856f) {
            com.cloud.hisavana.sdk.common.util.a.a(this);
        }
        this.f21858b.l0((RelativeLayout) findViewById(R$id.splash_ad));
        this.f21858b.j0(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setTitle((CharSequence) null);
        if (f21856f) {
            setTheme(R$style.InterstitialFullscreenStyle);
        }
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        U();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        i1 i1Var = this.f21858b;
        if (i1Var != null) {
            i1Var.m();
            this.f21858b = null;
        }
        r4.b().d(this.f21861e);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        i1 i1Var;
        CountTimeView J;
        if (i11 == 4 && (i1Var = this.f21858b) != null && (J = i1Var.J()) != null) {
            long supposeFinishTime = J.getSupposeFinishTime();
            if (supposeFinishTime > 0 && supposeFinishTime > System.currentTimeMillis()) {
                return true;
            }
        }
        return super.onKeyDown(i11, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        i1 i1Var = this.f21858b;
        if (i1Var != null) {
            CountTimeView J = i1Var.J();
            if (J != null) {
                this.f21859c = J.getRemainder() / 1000;
                J.cancel();
            }
            this.f21858b.R();
        }
        this.f21860d = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        e4.b().d("HisavanaSplashActivity", "onResume");
        super.onResume();
        i1 i1Var = this.f21858b;
        if (i1Var != null && i1Var.L()) {
            AdsDTO T = this.f21858b.T();
            if (T != null && !T.isInteractiveAd()) {
                R();
            }
            this.f21858b.C0();
            this.f21858b.I();
            this.f21860d = false;
            return;
        }
        i1 i1Var2 = this.f21858b;
        if (i1Var2 != null && i1Var2.L() && this.f21858b.M()) {
            R();
            this.f21860d = false;
            return;
        }
        i1 i1Var3 = this.f21858b;
        if (i1Var3 == null || !i1Var3.M()) {
            if (this.f21860d) {
                R();
            }
            this.f21860d = true;
        } else {
            e4.b().d("HisavanaSplashActivity", "close ad");
            finish();
            this.f21858b.P();
            this.f21860d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        e4.b().d("HisavanaSplashActivity", TmcConstants.NAVIGATION_ON_START);
    }
}
