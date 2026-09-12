package com.cloud.hisavana.sdk.common.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$layout;
import com.cloud.hisavana.sdk.common.bean.MiniAppInfo;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.e4;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.ad.db.pslink.AppInstalledBean;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import org.mvel2.ast.ASTNode;

/* loaded from: classes3.dex */
public class MiniAppPopUpActivity extends AppCompatActivity {

    /* renamed from: c, reason: collision with root package name */
    private static a f21862c;

    /* renamed from: a, reason: collision with root package name */
    private MiniAppInfo f21863a;

    /* renamed from: b, reason: collision with root package name */
    private int f21864b = 1;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    private SpannableString V(String str) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableString("");
        }
        int a02 = a0(str);
        SpannableString spannableString = new SpannableString(str);
        try {
            spannableString.setSpan(new AbsoluteSizeSpan(com.cloud.sdk.commonutil.util.h.i(16.0f)), 0, a02, 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0F1A2F")), 0, a02, 33);
            spannableString.setSpan(new AbsoluteSizeSpan(com.cloud.sdk.commonutil.util.h.i(12.0f)), a02, str.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#6F7682")), a02, str.length(), 33);
        } catch (Exception unused) {
        }
        return spannableString;
    }

    private String W(long j11) {
        try {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
            if (j11 > 1073741824) {
                return decimalFormat.format(((float) j11) / 1.07374182E9f) + "GB";
            }
            return decimalFormat.format(Math.max(0.01d, ((float) j11) / 1048576.0f)) + AppInstalledBean.APP_INSTALLED_BEAN_SOURCE_MB;
        } catch (Exception unused) {
            return "";
        }
    }

    private void X() {
        if (this.f21863a == null) {
            return;
        }
        DownLoadRequest.o(this.f21863a.getIconUrl(), null, 13, null, (ImageView) findViewById(R$id.icon));
        ((TextView) findViewById(R$id.name)).setText(this.f21863a.getName());
        ImageView imageView = (ImageView) findViewById(R$id.category_icon);
        if (TextUtils.isEmpty(this.f21863a.getCategoryIconUrl())) {
            imageView.setVisibility(8);
        } else {
            DownLoadRequest.o(this.f21863a.getCategoryIconUrl(), null, 13, null, imageView);
        }
        ((TextView) findViewById(R$id.category)).setText(this.f21863a.getCategory());
        ((TextView) findViewById(R$id.ratings)).setText(String.valueOf(this.f21863a.getRatings()));
        ((TextView) findViewById(R$id.users)).setText(V(b0(this.f21863a.getUsers())));
        ((TextView) findViewById(R$id.size)).setText(V(W(this.f21863a.getSize())));
        ((TextView) findViewById(R$id.description)).setText(String.valueOf(this.f21863a.getDescription()));
        Button button = (Button) findViewById(R$id.action_button);
        button.setText(this.f21863a.getActionName());
        button.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniAppPopUpActivity.this.Z(view);
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniAppPopUpActivity.this.d0(view);
            }
        };
        boolean z10 = this.f21864b == 1;
        ImageView imageView2 = (ImageView) findViewById(R$id.cancel_button);
        imageView2.setVisibility(z10 ? 0 : 8);
        imageView2.setOnClickListener(onClickListener);
        View findViewById = findViewById(R$id.cancel_button_bottom);
        findViewById.setVisibility(z10 ? 8 : 0);
        findViewById.setOnClickListener(onClickListener);
        View findViewById2 = findViewById(R$id.skip_button);
        findViewById2.setVisibility(z10 ? 8 : 0);
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.cloud.hisavana.sdk.common.activity.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniAppPopUpActivity.this.e0(view);
            }
        });
    }

    public static void Y(Context context, MiniAppInfo miniAppInfo, int i11, a aVar) {
        if (context == null || miniAppInfo == null) {
            return;
        }
        try {
            f21862c = aVar;
            Intent intent = new Intent(context, (Class<?>) MiniAppPopUpActivity.class);
            intent.addFlags(ASTNode.DEOP);
            Bundle bundle = new Bundle();
            bundle.putParcelable("mini_app_info_key", miniAppInfo);
            intent.putExtras(bundle);
            intent.putExtra(TtmlNode.TAG_STYLE, i11);
            context.startActivity(intent);
        } catch (Exception unused) {
            e4.b().e(TmcConstants.DIR_BYTEAPP, "Failed to start mini app guide.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(View view) {
        a aVar = f21862c;
        if (aVar != null) {
            aVar.b();
            f21862c = null;
        }
        finish();
    }

    private int a0(String str) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            try {
                char charAt = str.charAt(i11);
                if (!Character.isDigit(charAt) && charAt != '.') {
                    return i11;
                }
            } catch (Exception unused) {
            }
        }
        return str.length();
    }

    private String b0(long j11) {
        try {
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
            if (j11 < 1000) {
                return String.valueOf(j11);
            }
            if (j11 < 1000000) {
                return decimalFormat.format(((float) j11) / 1000.0f) + "K";
            }
            return decimalFormat.format(((float) j11) / 1000000.0f) + "M";
        } catch (Exception unused) {
            return "";
        }
    }

    private void c0() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("mini_app_info_key");
        if (parcelableExtra instanceof MiniAppInfo) {
            this.f21863a = (MiniAppInfo) parcelableExtra;
            this.f21864b = intent.getIntExtra(TtmlNode.TAG_STYLE, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(View view) {
        a aVar = f21862c;
        if (aVar != null) {
            aVar.c();
            f21862c = null;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(View view) {
        a aVar = f21862c;
        if (aVar != null) {
            aVar.a();
            f21862c = null;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_mini_app_popup);
        c0();
        X();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        a aVar = f21862c;
        if (aVar != null) {
            aVar.c();
            f21862c = null;
        }
        super.onDestroy();
    }
}
