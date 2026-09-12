package com.transsion.baseui.util;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.R$mipmap;
import com.transsion.web.api.WebPageIdentity;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public abstract class l {

    /* renamed from: a */
    private static final Pattern f43577a = Pattern.compile("(?i:http|https|rtsp|ftp)://");

    /* loaded from: classes5.dex */
    public static final class a extends ClickableSpan {

        /* renamed from: a */
        final /* synthetic */ Function2 f43578a;

        /* renamed from: b */
        final /* synthetic */ String f43579b;

        /* renamed from: c */
        final /* synthetic */ boolean f43580c;

        /* renamed from: d */
        final /* synthetic */ int f43581d;

        a(Function2 function2, String str, boolean z10, int i11) {
            this.f43578a = function2;
            this.f43579b = str;
            this.f43580c = z10;
            this.f43581d = i11;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.h(widget, "widget");
            Function2 function2 = this.f43578a;
            if (function2 != null) {
                String str = this.f43579b;
                if (str == null) {
                    str = "";
                }
                function2.invoke(widget, str);
            }
            if (this.f43580c) {
                l.d(this.f43579b);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds2) {
            Intrinsics.h(ds2, "ds");
            super.updateDrawState(ds2);
            ds2.setColor(this.f43581d);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: a */
        final /* synthetic */ Function2 f43582a;

        /* renamed from: b */
        final /* synthetic */ String f43583b;

        /* renamed from: c */
        final /* synthetic */ boolean f43584c;

        /* renamed from: d */
        final /* synthetic */ int f43585d;

        b(Function2 function2, String str, boolean z10, int i11) {
            this.f43582a = function2;
            this.f43583b = str;
            this.f43584c = z10;
            this.f43585d = i11;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.h(widget, "widget");
            Function2 function2 = this.f43582a;
            if (function2 != null) {
                String str = this.f43583b;
                if (str == null) {
                    str = "";
                }
                function2.invoke(widget, str);
            }
            if (this.f43584c) {
                l.d(this.f43583b);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds2) {
            Intrinsics.h(ds2, "ds");
            super.updateDrawState(ds2);
            ds2.setColor(this.f43585d);
        }
    }

    public static final SpannableString b(TextView textView, CharSequence charSequence, boolean z10, g gVar, Function2 function2) {
        boolean z11;
        int i11;
        Object obj = null;
        if (textView != null) {
            textView.setOnTouchListener(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            return new SpannableString("");
        }
        ArrayList<UrlContent> arrayList = new ArrayList();
        Matcher matcher = Patterns.WEB_URL.matcher(charSequence);
        int color = androidx.core.content.b.getColor(Utils.a(), R$color.color_0ba7ff);
        CharSequence charSequence2 = charSequence;
        while (matcher.find()) {
            String group = matcher.group();
            Intrinsics.e(group);
            int i12 = 0;
            if (StringsKt.G(group, ")", false, 2, obj)) {
                Intrinsics.e(group);
                group = StringsKt.Q(group, ")", "", false, 4, null);
            }
            if (charSequence2 != null) {
                Intrinsics.e(group);
                z11 = false;
                i12 = StringsKt.o0(charSequence2, group, 0, false, 6, null);
            } else {
                z11 = false;
            }
            Intrinsics.e(group);
            boolean z12 = z11;
            String Q = StringsKt.Q(group, "%20", " ", false, 4, null);
            Matcher matcher2 = f43577a.matcher(Q);
            if (matcher2.find()) {
                String group2 = matcher2.group();
                Intrinsics.g(group2, "group(...)");
                String Q2 = StringsKt.Q(Q, group2, "", false, 4, null);
                Matcher matcher3 = Patterns.DOMAIN_NAME.matcher(Q2);
                if (matcher3.find()) {
                    String group3 = matcher3.group();
                    Intrinsics.e(group3);
                    i11 = 2;
                    if (StringsKt.c0(group3, ".", z12, 2, obj)) {
                        List S0 = StringsKt.S0(group3, new String[]{"."}, false, 0, 6, null);
                        if (S0.size() > 2) {
                            Q2 = StringsKt.Q(Q2, S0.get(z12 ? 1 : 0) + ".", "", false, 4, null);
                        }
                    }
                } else {
                    i11 = 2;
                }
                if (Q2.length() > 24) {
                    Q2 = StringsKt.M0(Q2, 24, Q2.length(), "...").toString();
                }
                String str = "-" + Q2;
                String valueOf = String.valueOf(charSequence2);
                Intrinsics.e(group);
                charSequence2 = StringsKt.S(valueOf, group, str, false, 4, null);
                Drawable drawable = androidx.core.content.b.getDrawable(Utils.a(), R$mipmap.base_ic_url_link);
                if (drawable != null) {
                    drawable.setBounds(z12 ? 1 : 0, z12 ? 1 : 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                }
                arrayList.add(new UrlContent(new a(function2, Q, z10, color), drawable != null ? new com.transsion.baseui.widget.d(drawable, i11) : null, group, str, i12));
                obj = null;
            }
        }
        if (arrayList.isEmpty()) {
            return new SpannableString(charSequence);
        }
        SpannableString spannableString = new SpannableString(charSequence2);
        for (UrlContent urlContent : arrayList) {
            spannableString.setSpan(urlContent.getIconSpan(), urlContent.getIndexOfUrl(), urlContent.getIndexOfUrl() + 1, 33);
            spannableString.setSpan(urlContent.getClickableSpan(), urlContent.getIndexOfUrl(), urlContent.getIndexOfUrl() + urlContent.getUrl().length(), 33);
        }
        if (gVar != null) {
            gVar.a(arrayList);
        }
        if (textView != null) {
            textView.setOnTouchListener(new hk.a(spannableString));
        }
        if (textView != null) {
            textView.setHighlightColor(androidx.core.content.b.getColor(Utils.a(), R$color.cl17));
        }
        return spannableString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v22 */
    public static final SpannableStringBuilder c(TextView textView, CharSequence charSequence, boolean z10, int i11, g gVar, Function2 function2) {
        SpannableStringBuilder spannableStringBuilder;
        Matcher matcher;
        ?? r52;
        int i12;
        Object obj = null;
        if (textView != null) {
            textView.setOnTouchListener(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            return new SpannableStringBuilder("");
        }
        ArrayList<UrlContent> arrayList = new ArrayList();
        Matcher matcher2 = Patterns.WEB_URL.matcher(charSequence);
        int color = androidx.core.content.b.getColor(Utils.a(), R$color.color_0ba7ff);
        CharSequence charSequence2 = charSequence;
        while (true) {
            int i13 = 0;
            if (!matcher2.find()) {
                break;
            }
            String group = matcher2.group();
            Intrinsics.e(group);
            if (StringsKt.G(group, ")", false, 2, obj)) {
                Intrinsics.e(group);
                group = StringsKt.Q(group, ")", "", false, 4, null);
            }
            String str = group;
            if (charSequence2 != null) {
                Intrinsics.e(str);
                matcher = matcher2;
                r52 = 0;
                i13 = StringsKt.o0(charSequence2, str, 0, false, 6, null);
            } else {
                matcher = matcher2;
                r52 = 0;
            }
            Intrinsics.e(str);
            String Q = StringsKt.Q(str, "%20", " ", false, 4, null);
            Matcher matcher3 = f43577a.matcher(Q);
            if (matcher3.find()) {
                String group2 = matcher3.group();
                Intrinsics.g(group2, "group(...)");
                String Q2 = StringsKt.Q(Q, group2, "", false, 4, null);
                Matcher matcher4 = Patterns.DOMAIN_NAME.matcher(Q2);
                if (matcher4.find()) {
                    String group3 = matcher4.group();
                    Intrinsics.e(group3);
                    i12 = 2;
                    if (StringsKt.c0(group3, ".", r52, 2, obj)) {
                        List S0 = StringsKt.S0(group3, new String[]{"."}, false, 0, 6, null);
                        if (S0.size() > 2) {
                            Q2 = StringsKt.Q(Q2, S0.get(r52) + ".", "", false, 4, null);
                        }
                    }
                } else {
                    i12 = 2;
                }
                if (Q2.length() > 24) {
                    Q2 = StringsKt.M0(Q2, 24, Q2.length(), "...").toString();
                }
                String str2 = "-" + Q2;
                String valueOf = String.valueOf(charSequence2);
                Intrinsics.e(str);
                charSequence2 = StringsKt.S(valueOf, str, str2, false, 4, null);
                Drawable drawable = androidx.core.content.b.getDrawable(Utils.a(), R$mipmap.base_ic_url_link);
                if (drawable != 0) {
                    drawable.setBounds(r52, r52, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                }
                arrayList.add(new UrlContent(new b(function2, Q, z10, color), drawable != 0 ? new com.transsion.baseui.widget.d(drawable, i12) : null, str, str2, i13));
                matcher2 = matcher;
                obj = null;
            } else {
                matcher2 = matcher;
            }
        }
        StaticLayout staticLayout = new StaticLayout(charSequence, textView != null ? textView.getPaint() : null, textView != null ? textView.getWidth() : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        if (i11 < staticLayout.getLineCount()) {
            int lineEnd = staticLayout.getLineEnd(i11 - 1) - 13;
            if ((charSequence2 != null ? charSequence2.length() : 0) > 30 && lineEnd > 0) {
                if (lineEnd < (charSequence2 != null ? charSequence2.length() : 0)) {
                    charSequence2 = charSequence2 != null ? charSequence2.subSequence(0, lineEnd).toString() : null;
                }
            }
            spannableStringBuilder = new SpannableStringBuilder(charSequence2);
            for (UrlContent urlContent : arrayList) {
                if (urlContent.getIndexOfUrl() + urlContent.getUrl().length() < spannableStringBuilder.length()) {
                    spannableStringBuilder.setSpan(urlContent.getIconSpan(), urlContent.getIndexOfUrl(), urlContent.getIndexOfUrl() + 1, 33);
                    spannableStringBuilder.setSpan(urlContent.getClickableSpan(), urlContent.getIndexOfUrl(), urlContent.getIndexOfUrl() + urlContent.getUrl().length(), 33);
                }
            }
            spannableStringBuilder.append((CharSequence) "...");
            spannableStringBuilder.append((CharSequence) " More");
            int length = spannableStringBuilder.length() - 5;
            int length2 = spannableStringBuilder.length();
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            spannableStringBuilder.setSpan(new ph.a(jg.a.c(a11)), length, length2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Utils.a().getResources().getColor(R$color.brand_new_50)), length, length2, 33);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(charSequence2);
            for (UrlContent urlContent2 : arrayList) {
                spannableStringBuilder.setSpan(urlContent2.getIconSpan(), urlContent2.getIndexOfUrl(), urlContent2.getIndexOfUrl() + 1, 33);
                spannableStringBuilder.setSpan(urlContent2.getClickableSpan(), urlContent2.getIndexOfUrl(), urlContent2.getIndexOfUrl() + urlContent2.getUrl().length(), 33);
            }
        }
        if (gVar != null) {
            gVar.a(arrayList);
        }
        if (textView != null) {
            textView.setOnTouchListener(new hk.a(spannableStringBuilder));
        }
        if (textView != null) {
            textView.setHighlightColor(androidx.core.content.b.getColor(Utils.a(), R$color.cl17));
        }
        return spannableStringBuilder;
    }

    public static final void d(String str) {
        Navigator.x(TheRouter.c(WebPageIdentity.WEB_VIEW).K("url", str), null, null, 3, null);
    }

    public static final void e(TextView textView, CharSequence charSequence, Function2 function2) {
        Intrinsics.h(textView, "<this>");
        textView.setText(b(textView, charSequence, true, null, function2));
    }

    public static final void f(TextView textView, CharSequence charSequence, boolean z10, Function2 function2) {
        Intrinsics.h(textView, "<this>");
        textView.setText(b(textView, charSequence, z10, null, function2));
    }

    public static final void g(TextView textView, CharSequence charSequence, int i11, Function2 function2) {
        Intrinsics.h(textView, "<this>");
        textView.setText(c(textView, charSequence, true, i11, null, function2));
    }

    public static /* synthetic */ void h(TextView textView, CharSequence charSequence, int i11, Function2 function2, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 10;
        }
        if ((i12 & 4) != 0) {
            function2 = null;
        }
        g(textView, charSequence, i11, function2);
    }
}
