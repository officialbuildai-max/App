package com.cloud.tmc.miniapp.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.BidiFormatter;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.net.UrlKt;
import com.cloud.tmc.integration.utils.ext.SpannableExtKt;
import com.cloud.tmc.integration.utils.ext.TextViewExtKt;
import com.cloud.tmc.kernel.bridge.extension.BridgeCallback;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.bridge.PermissionScopeBridge;
import com.cloud.tmc.miniapp.dialog.OooO0O0;
import com.cloud.tmc.miniapp.ui.WebViewActivity;
import com.cloud.tmc.miniutils.util.StringUtils;
import com.google.gson.JsonObject;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.gslb.Utils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class o00oO0o extends OooO0O0.OooO00o<o00oO0o> {
    public final String OooO;
    public final String OooO00o;
    public BridgeCallback OooO0O0;
    public final Lazy OooO0OO;
    public final Lazy OooO0Oo;
    public final Lazy OooO0o;
    public final Lazy OooO0o0;
    public final Lazy OooO0oO;
    public String OooO0oo;
    public final String OooOO0;
    public final String OooOO0O;
    public final String OooOO0o;
    public final String OooOOO;
    public final String OooOOO0;
    public final String OooOOOO;
    public final String OooOOOo;
    public final String OooOOo0;

    /* loaded from: classes3.dex */
    public static final class OooO extends Lambda implements Function0<TextView> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (TextView) o00oO0o.this.findViewById(R.id.tv_btn_one);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO00o implements OooO0O0.OooOo00 {
        public OooO00o() {
        }

        @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.OooOo00
        public void onDismiss(com.cloud.tmc.miniapp.dialog.OooO0O0 oooO0O0) {
            o00oO0o o00oo0o = o00oO0o.this;
            TmcLogger.d(o00oo0o.OooO00o, "MiniDevUserAgreementDialog.onDismiss->" + o00oo0o.OooO0oo);
            o00oO0o o00oo0o2 = o00oO0o.this;
            o00oo0o2.OooO0O0 = null;
            if (o00oo0o2.OooO0oo.length() > 0) {
                PermissionScopeBridge.Companion.getClass();
                PermissionScopeBridge.OooO00o.remove(o00oO0o.this.OooO0oo);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0O0 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ o00oO0o OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0O0(String str, o00oO0o o00oo0o) {
            super(1);
            this.OooO00o = str;
            this.OooO0O0 = o00oo0o;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            View it = (View) obj;
            Intrinsics.h(it, "it");
            WebViewActivity.Companion.launch$default(WebViewActivity.Companion, this.OooO0O0.getContext(), UrlKt.appendCommonParamUrl(TextUtils.isEmpty(this.OooO00o) ? UrlKt.PRIVACY_URL : this.OooO00o, this.OooO0O0.getContext()), null, null, 12, null);
            return Unit.f67184a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0OO extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ String OooO00o;
        public final /* synthetic */ o00oO0o OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0OO(String str, o00oO0o o00oo0o) {
            super(1);
            this.OooO00o = str;
            this.OooO0O0 = o00oo0o;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            View it = (View) obj;
            Intrinsics.h(it, "it");
            WebViewActivity.Companion.launch$default(WebViewActivity.Companion, this.OooO0O0.getContext(), UrlKt.appendCommonParamUrl(TextUtils.isEmpty(this.OooO00o) ? UrlKt.AGREEMENT_URL : this.OooO00o, this.OooO0O0.getContext()), null, null, 12, null);
            return Unit.f67184a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0o extends Lambda implements Function0<TextView> {
        public OooO0o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (TextView) o00oO0o.this.findViewById(R.id.tv_agree_content);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOO0 extends Lambda implements Function0<TextView> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (TextView) o00oO0o.this.findViewById(R.id.tv_btn_two);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOO0O extends Lambda implements Function0<TextView> {
        public OooOO0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (TextView) o00oO0o.this.findViewById(R.id.tv_content);
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooOOO0 extends Lambda implements Function0<TextView> {
        public OooOOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Object invoke() {
            return (TextView) o00oO0o.this.findViewById(R.id.tv_title);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o00oO0o(Context context) {
        super(context);
        Intrinsics.h(context, "context");
        this.OooO00o = "MiniDevUserAgreementDialog";
        this.OooO0OO = LazyKt.b(new OooOOO0());
        this.OooO0Oo = LazyKt.b(new OooO0o());
        this.OooO0o0 = LazyKt.b(new OooOO0O());
        this.OooO0o = LazyKt.b(new OooO());
        this.OooO0oO = LazyKt.b(new OooOO0());
        this.OooO0oo = "";
        setContentView(R.layout.mini_dialog_layout_dua);
        setAnimStyle(-1);
        setBackgroundDimEnabled(true);
        setOnClickListener(OooO0O0(), OooO0OO());
        addOnDismissListener(new OooO00o());
        setCancelable(false);
        this.OooO = "mode";
        this.OooOO0 = MimeTypes.BASE_TYPE_TEXT;
        this.OooOO0O = NotificationCompat.CATEGORY_STATUS;
        this.OooOO0o = "1";
        this.OooOOO0 = "2";
        this.OooOOO = "1";
        this.OooOOOO = "2";
        this.OooOOOo = "agreeClick";
        this.OooOOo0 = "cancelClick";
    }

    public final TextView OooO00o() {
        return (TextView) this.OooO0Oo.getValue();
    }

    public final o00oO0o OooO00o(String str, String str2) {
        if (str != null && str.length() > 0) {
            TmcLogger.d(this.OooO00o, "btnBgColor = " + str);
            try {
                TextView OooO0O02 = OooO0O0();
                Drawable background = OooO0O02 != null ? OooO0O02.getBackground() : null;
                GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
                if (gradientDrawable != null) {
                    gradientDrawable.setColor(Color.parseColor(str));
                }
            } catch (Throwable th2) {
                TmcLogger.d(this.OooO00o, "setAgreeBtn:" + th2.getMessage());
            }
        }
        TextView OooO0O03 = OooO0O0();
        if (OooO0O03 != null) {
            if (str2 == null || str2.length() <= 0) {
                str2 = getString(R.string.mini_text_agree);
            }
            OooO0O03.setText(str2);
        }
        return this;
    }

    public final o00oO0o OooO00o(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int color;
        if (str2 != null) {
            try {
            } catch (Throwable th2) {
                TmcLogger.d(this.OooO00o, "setAgreeText:" + th2.getMessage());
            }
            if (str2.length() > 0) {
                TextView OooO00o2 = OooO00o();
                if (OooO00o2 != null) {
                    OooO00o2.setText(str2);
                }
                return this;
            }
        }
        String dauAgreeContent = StringUtils.format(getString(R.string.mini_dau_agree_content), str);
        String string = (str3 == null || str3.length() <= 0) ? getString(R.string.mini_privacy_privacy_policy) : str3;
        String string2 = (str4 == null || str4.length() <= 0) ? getString(R.string.mini_user_agreement) : str4;
        String str8 = (str5 == null || str5.length() <= 0) ? UrlKt.PRIVACY_URL : str5;
        String str9 = (str6 == null || str6.length() <= 0) ? UrlKt.AGREEMENT_URL : str6;
        Intrinsics.g(dauAgreeContent, "dauAgreeContent");
        int o02 = StringsKt.o0(dauAgreeContent, Utils.SEPARATOR, 0, false, 6, null);
        int v02 = StringsKt.v0(dauAgreeContent, Utils.SEPARATOR, 0, false, 6, null);
        int o03 = StringsKt.o0(dauAgreeContent, "*", 0, false, 6, null);
        int v03 = StringsKt.v0(dauAgreeContent, "*", 0, false, 6, null);
        if (str7 == null || str7.length() <= 0) {
            color = getColor(R.color.mini_color_primary);
        } else {
            try {
                color = Color.parseColor(str7);
            } catch (Throwable unused) {
                color = getColor(R.color.mini_color_primary);
            }
        }
        TextView OooO00o3 = OooO00o();
        if (OooO00o3 != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(dauAgreeContent.subSequence(0, o02));
            SpannableExtKt.appendClickable(spannableStringBuilder, (CharSequence) BidiFormatter.getInstance().unicodeWrap(string), Integer.valueOf(color), true, (Function1<? super View, Unit>) new OooO0O0(str8, this));
            spannableStringBuilder.append(dauAgreeContent.subSequence(v02 + 1, o03));
            SpannableExtKt.appendClickable(spannableStringBuilder, (CharSequence) BidiFormatter.getInstance().unicodeWrap(string2), Integer.valueOf(color), true, (Function1<? super View, Unit>) new OooO0OO(str9, this));
            spannableStringBuilder.append(dauAgreeContent.subSequence(v03 + 1, dauAgreeContent.length()));
            OooO00o3.setText(new SpannedString(spannableStringBuilder));
        }
        TextView OooO00o4 = OooO00o();
        if (OooO00o4 != null) {
            OooO00o4.setMovementMethod(LinkMovementMethod.getInstance());
        }
        TextView OooO00o5 = OooO00o();
        if (OooO00o5 != null) {
            TextViewExtKt.transparentHighlightColor(OooO00o5);
        }
        return this;
    }

    public final void OooO00o(String str) {
        TmcLogger.d(this.OooO00o, "sendClickResponse status = " + str);
        BridgeCallback bridgeCallback = this.OooO0O0;
        if (bridgeCallback != null) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(this.OooOO0O, str);
            bridgeCallback.sendSuccessResponse(jsonObject);
        }
        BridgeCallback bridgeCallback2 = this.OooO0O0;
        if (bridgeCallback2 != null) {
            bridgeCallback2.close();
        }
        dismiss();
    }

    public final TextView OooO0O0() {
        return (TextView) this.OooO0o.getValue();
    }

    public final TextView OooO0OO() {
        return (TextView) this.OooO0oO.getValue();
    }

    public final TextView OooO0Oo() {
        return (TextView) this.OooO0o0.getValue();
    }

    @Override // com.cloud.tmc.miniapp.dialog.OooO0O0.OooO00o, com.cloud.tmc.miniapp.action.ClickAction, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.h(view, "view");
        super.onClick(view);
        int id2 = view.getId();
        if (id2 == R.id.tv_btn_one) {
            OooO00o(this.OooOOOo);
        } else if (id2 == R.id.tv_btn_two) {
            OooO00o(this.OooOOo0);
        }
    }
}
