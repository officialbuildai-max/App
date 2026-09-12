package com.cloud.hisavana.sdk.common.util;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.WebView;
import com.cloud.hisavana.sdk.N0;
import com.cloud.hisavana.sdk.R$string;
import com.cloud.hisavana.sdk.c1;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.PslinkInfo;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.NativeBean;
import com.cloud.hisavana.sdk.e4;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f22275a = new r();

    private r() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(r this_runCatching, final View view, final GradientDrawable drawable) {
        Intrinsics.h(this_runCatching, "$this_runCatching");
        Intrinsics.h(drawable, "$drawable");
        try {
            Result.Companion companion = Result.INSTANCE;
            final ArgbEvaluator argbEvaluator = new ArgbEvaluator();
            final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(600L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cloud.hisavana.sdk.common.util.q
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    r.r(ofFloat, view, drawable, argbEvaluator, valueAnimator);
                }
            });
            ofFloat.start();
            Result.m1185constructorimpl(ofFloat);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(ValueAnimator valueAnimator, View view, GradientDrawable drawable, ArgbEvaluator evaluator, ValueAnimator it) {
        Intrinsics.h(drawable, "$drawable");
        Intrinsics.h(evaluator, "$evaluator");
        Intrinsics.h(it, "it");
        try {
            Result.Companion companion = Result.INSTANCE;
            float animatedFraction = it.getAnimatedFraction();
            if (animatedFraction == 0.0f && view != null) {
                view.setVisibility(0);
            }
            Object evaluate = evaluator.evaluate(animatedFraction, Integer.valueOf(Color.parseColor("#00336FFF")), Integer.valueOf(Color.parseColor("#FF336FFF")));
            Intrinsics.f(evaluate, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) evaluate).intValue();
            Object evaluate2 = evaluator.evaluate(animatedFraction, Integer.valueOf(Color.parseColor("#003752FF")), Integer.valueOf(Color.parseColor("#FF3752FF")));
            Intrinsics.f(evaluate2, "null cannot be cast to non-null type kotlin.Int");
            drawable.setColors(new int[]{intValue, ((Integer) evaluate2).intValue()});
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public final boolean c(AdsDTO adsDTO) {
        String str = null;
        if ((adsDTO != null ? Integer.valueOf(adsDTO.getDownloadArea()) : null) == null || adsDTO.getDownloadArea() == 0) {
            if (adsDTO != null) {
                try {
                    str = adsDTO.getHalfScreenType();
                } catch (Throwable unused) {
                }
            }
            return TextUtils.equals(str, "Z");
        }
        if (adsDTO.getDownloadArea() == 2) {
            return true;
        }
        return false;
    }

    public final int d(AdsDTO adsDTO) {
        Integer pullNewestLive = adsDTO != null ? adsDTO.getPullNewestLive() : null;
        if (pullNewestLive != null && pullNewestLive.intValue() == 2) {
            return 2;
        }
        if (pullNewestLive == null || pullNewestLive.intValue() != 3) {
            Integer valueOf = adsDTO != null ? Integer.valueOf(adsDTO.getInstallApk()) : null;
            if (valueOf == null || valueOf.intValue() != 2) {
                return (valueOf != null && valueOf.intValue() == 3) ? 2 : 1;
            }
        }
        return 3;
    }

    public final boolean e(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public final void f(AdsDTO adsDTO) {
        PslinkInfo pslinkInfo;
        String score;
        PslinkInfo pslinkInfo2;
        PslinkInfo pslinkInfo3;
        PslinkInfo pslinkInfo4;
        try {
            NativeBean nativeBean = new NativeBean();
            Integer num = null;
            NativeBean.TitleDTO titleDTO = new NativeBean.TitleDTO((adsDTO == null || (pslinkInfo4 = adsDTO.getPslinkInfo()) == null) ? null : pslinkInfo4.getName());
            NativeBean.DescriptDTO descriptDTO = new NativeBean.DescriptDTO((adsDTO == null || (pslinkInfo3 = adsDTO.getPslinkInfo()) == null) ? null : pslinkInfo3.getSimpleDescription());
            NativeBean.LogoDTO logoDTO = new NativeBean.LogoDTO((adsDTO == null || (pslinkInfo2 = adsDTO.getPslinkInfo()) == null) ? null : pslinkInfo2.getIconUrl());
            nativeBean.setTitle(titleDTO);
            nativeBean.setDescript(descriptDTO);
            nativeBean.setLogo(logoDTO);
            if (adsDTO != null && (pslinkInfo = adsDTO.getPslinkInfo()) != null && (score = pslinkInfo.getScore()) != null) {
                num = StringsKt.v(score);
            }
            if (num == null) {
                num = 0;
            }
            nativeBean.setRating(num);
            if (adsDTO != null) {
                adsDTO.setNativeObject(nativeBean);
            }
        } catch (Throwable unused) {
        }
    }

    public final ObjectAnimator g(View view) {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 1.0f, 0.85f, 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 1.0f, 0.85f, 1.0f));
            ofPropertyValuesHolder.setDuration(1000L);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setInterpolator(new AccelerateDecelerateInterpolator());
            m1185constructorimpl = Result.m1185constructorimpl(ofPropertyValuesHolder);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = null;
        }
        return (ObjectAnimator) m1185constructorimpl;
    }

    public final String h(String encryptedContent, String base64Key) {
        Intrinsics.h(encryptedContent, "encryptedContent");
        Intrinsics.h(base64Key, "base64Key");
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(base64Key, 2), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, secretKeySpec);
            if (StringsKt.c0(encryptedContent, " ", false, 2, null)) {
                encryptedContent = StringsKt.Q(encryptedContent, " ", "+", false, 4, null);
            }
            byte[] doFinal = cipher.doFinal(Base64.decode(encryptedContent, 2));
            if (doFinal.length < 2) {
                return null;
            }
            try {
                int i11 = ((doFinal[0] & 255) << 8) | (doFinal[1] & 255);
                if (i11 + 2 > doFinal.length) {
                    return null;
                }
                Intrinsics.e(doFinal);
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.g(UTF_8, "UTF_8");
                return new String(doFinal, 2, i11, UTF_8);
            } catch (Exception e11) {
                e4.b().e("HSCommonUtils", "decryptOptimized length parse error: " + e11.getMessage());
                return null;
            }
        } catch (Exception e12) {
            e4.b().e("HSCommonUtils", "decryptOptimized error: " + e12.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001f A[Catch: all -> 0x0066, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0066, blocks: (B:17:0x0004, B:19:0x000a, B:6:0x001f, B:12:0x003d, B:14:0x0051), top: B:16:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String i(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 0
            r1 = 1
            if (r10 == 0) goto Lf
            java.lang.Long r10 = kotlin.text.StringsKt.x(r10)     // Catch: java.lang.Throwable -> L66
            if (r10 == 0) goto Lf
            long r2 = r10.longValue()     // Catch: java.lang.Throwable -> L66
            goto L11
        Lf:
            r2 = 0
        L11:
            r10 = 1024(0x400, float:1.435E-42)
            double r4 = (double) r10
            r6 = 4652218415073722368(0x4090000000000000, double:1024.0)
            double r6 = r6 * r4
            double r4 = r4 * r6
            double r2 = (double) r2
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            java.lang.String r8 = "format(...)"
            if (r10 < 0) goto L36
            java.lang.String r10 = "%.1f GB"
            double r2 = r2 / r4
            java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch: java.lang.Throwable -> L66
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L66
            r3[r0] = r2     // Catch: java.lang.Throwable -> L66
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r3, r1)     // Catch: java.lang.Throwable -> L66
            java.lang.String r10 = java.lang.String.format(r10, r0)     // Catch: java.lang.Throwable -> L66
            kotlin.jvm.internal.Intrinsics.g(r10, r8)     // Catch: java.lang.Throwable -> L66
            goto L65
        L36:
            int r10 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            java.lang.String r4 = "%.1f MB"
            if (r10 < 0) goto L51
            double r2 = r2 / r6
            java.lang.Double r10 = java.lang.Double.valueOf(r2)     // Catch: java.lang.Throwable -> L66
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L66
            r2[r0] = r10     // Catch: java.lang.Throwable -> L66
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r2, r1)     // Catch: java.lang.Throwable -> L66
            java.lang.String r10 = java.lang.String.format(r4, r10)     // Catch: java.lang.Throwable -> L66
            kotlin.jvm.internal.Intrinsics.g(r10, r8)     // Catch: java.lang.Throwable -> L66
            goto L65
        L51:
            double r2 = r2 / r6
            java.lang.Double r10 = java.lang.Double.valueOf(r2)     // Catch: java.lang.Throwable -> L66
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L66
            r2[r0] = r10     // Catch: java.lang.Throwable -> L66
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r2, r1)     // Catch: java.lang.Throwable -> L66
            java.lang.String r10 = java.lang.String.format(r4, r10)     // Catch: java.lang.Throwable -> L66
            kotlin.jvm.internal.Intrinsics.g(r10, r8)     // Catch: java.lang.Throwable -> L66
        L65:
            return r10
        L66:
            java.lang.String r10 = ""
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.common.util.r.i(java.lang.String):java.lang.String");
    }

    public final String j() {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(com.cloud.sdk.commonutil.util.e.a().getString(R$string.hs_i1107_default_btn));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = "Learn More";
        }
        return (String) m1185constructorimpl;
    }

    public final String k(AdsDTO adsDTO) {
        String sourceSize;
        Long x10;
        if (adsDTO != null && adsDTO.getShowSourceSize()) {
            try {
                PslinkInfo pslinkInfo = adsDTO.getPslinkInfo();
                if (((pslinkInfo == null || (sourceSize = pslinkInfo.getSourceSize()) == null || (x10 = StringsKt.x(sourceSize)) == null) ? 0L : x10.longValue()) > 0 && d(adsDTO) == 2) {
                    PslinkInfo pslinkInfo2 = adsDTO.getPslinkInfo();
                    return i(pslinkInfo2 != null ? pslinkInfo2.getSourceSize() : null);
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public final String l(String str, String str2) {
        Uri parse;
        if (str == null || str.length() == 0 || str2 == null) {
            return null;
        }
        if (str2.length() != 0) {
            try {
                parse = Uri.parse(str);
                Intrinsics.g(parse, "parse(this)");
            } catch (Exception unused) {
                return null;
            }
        }
        return parse.getQueryParameter(str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        if (r2.intValue() != 2) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
    
        r3 = r1.e0();
        r1 = r1.g0();
        r4 = new com.google.gson.JsonObject();
        r4.addProperty("k1", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005b, code lost:
    
        if (r1 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0064, code lost:
    
        r4.addProperty("k2", r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
    
        if (r3 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:
    
        r4.addProperty("k3", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007b, code lost:
    
        r1 = r8 + "&sspParams=" + java.net.URLEncoder.encode(r4.toString(), "UTF-8");
        com.cloud.hisavana.sdk.e4.b().d("HSCommonUtils", "TrackingManager --> landingUrlAppendABTestData --> 处理后的 url = " + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b1, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        if (r3.longValue() == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0062, code lost:
    
        if (r1.intValue() == 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x003d, code lost:
    
        if (r2.intValue() != 1) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "HSCommonUtils"
            com.cloud.hisavana.sdk.e4 r1 = com.cloud.hisavana.sdk.e4.b()     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
            r2.<init>()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r3 = "TrackingManager --> landingUrlAppendABTestData --> 处理前 url = "
            r2.append(r3)     // Catch: java.lang.Throwable -> Lb2
            r2.append(r8)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lb2
            r1.d(r0, r2)     // Catch: java.lang.Throwable -> Lb2
            com.cloud.hisavana.sdk.data.bean.response.ccofig.CustomTabConfigDTO r1 = com.cloud.hisavana.sdk.data.bean.response.ccofig.CustomConfigManager.getCustomTabData()     // Catch: java.lang.Throwable -> Lb2
            if (r1 == 0) goto L25
            java.lang.Boolean r1 = r1.getEnableSpliceParam()     // Catch: java.lang.Throwable -> Lb2
            goto L26
        L25:
            r1 = 0
        L26:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> Lb2
            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r1, r2)     // Catch: java.lang.Throwable -> Lb2
            if (r1 != 0) goto L2f
            return r8
        L2f:
            com.cloud.hisavana.sdk.manager.a r1 = com.cloud.hisavana.sdk.manager.a.f22735a     // Catch: java.lang.Throwable -> Lb2
            java.lang.Integer r2 = r1.h0()     // Catch: java.lang.Throwable -> Lb2
            if (r2 != 0) goto L38
            goto L3f
        L38:
            int r3 = r2.intValue()     // Catch: java.lang.Throwable -> Lb2
            r4 = 1
            if (r3 == r4) goto L49
        L3f:
            if (r2 != 0) goto L42
            goto Lb2
        L42:
            int r3 = r2.intValue()     // Catch: java.lang.Throwable -> Lb2
            r4 = 2
            if (r3 != r4) goto Lb2
        L49:
            java.lang.Long r3 = r1.e0()     // Catch: java.lang.Throwable -> Lb2
            java.lang.Integer r1 = r1.g0()     // Catch: java.lang.Throwable -> Lb2
            com.google.gson.JsonObject r4 = new com.google.gson.JsonObject     // Catch: java.lang.Throwable -> Lb2
            r4.<init>()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r5 = "k1"
            r4.addProperty(r5, r2)     // Catch: java.lang.Throwable -> Lb2
            if (r1 != 0) goto L5e
            goto L64
        L5e:
            int r2 = r1.intValue()     // Catch: java.lang.Throwable -> Lb2
            if (r2 == 0) goto L69
        L64:
            java.lang.String r2 = "k2"
            r4.addProperty(r2, r1)     // Catch: java.lang.Throwable -> Lb2
        L69:
            if (r3 != 0) goto L6c
            goto L76
        L6c:
            long r1 = r3.longValue()     // Catch: java.lang.Throwable -> Lb2
            r5 = 0
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 == 0) goto L7b
        L76:
            java.lang.String r1 = "k3"
            r4.addProperty(r1, r3)     // Catch: java.lang.Throwable -> Lb2
        L7b:
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = "UTF-8"
            java.lang.String r1 = java.net.URLEncoder.encode(r1, r2)     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
            r2.<init>()     // Catch: java.lang.Throwable -> Lb2
            r2.append(r8)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r3 = "&sspParams="
            r2.append(r3)     // Catch: java.lang.Throwable -> Lb2
            r2.append(r1)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Throwable -> Lb2
            com.cloud.hisavana.sdk.e4 r2 = com.cloud.hisavana.sdk.e4.b()     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
            r3.<init>()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = "TrackingManager --> landingUrlAppendABTestData --> 处理后的 url = "
            r3.append(r4)     // Catch: java.lang.Throwable -> Lb2
            r3.append(r1)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lb2
            r2.d(r0, r3)     // Catch: java.lang.Throwable -> Lb2
            return r1
        Lb2:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.common.util.r.m(java.lang.String):java.lang.String");
    }

    public final void n(View view, Runnable runnable) {
        try {
            Result.Companion companion = Result.INSTANCE;
            Result.m1185constructorimpl(view != null ? Boolean.valueOf(view.removeCallbacks(runnable)) : null);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public final void o(AdsDTO adsDTO, DownUpPointBean downUpPointBean) {
        boolean z10;
        if (adsDTO != null) {
            boolean z11 = true;
            try {
                adsDTO.setTrackUserClickArea(1);
                AthenaTracker.X(adsDTO, Boolean.TRUE);
                Integer trackType = adsDTO.getTrackType();
                if (trackType != null && trackType.intValue() == 0) {
                    z10 = true;
                    boolean h11 = i0.h(com.cloud.sdk.commonutil.util.e.a());
                    if (z10 || !h11) {
                        N0.U(adsDTO);
                        z11 = false;
                    }
                    c1.h(downUpPointBean, adsDTO, Boolean.valueOf(z11));
                }
                z10 = false;
                boolean h112 = i0.h(com.cloud.sdk.commonutil.util.e.a());
                if (z10) {
                }
                N0.U(adsDTO);
                z11 = false;
                c1.h(downUpPointBean, adsDTO, Boolean.valueOf(z11));
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Runnable] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.Runnable, com.cloud.hisavana.sdk.common.util.p] */
    public final Runnable p(View view, final View view2, String startColor) {
        Context context;
        Resources resources;
        DisplayMetrics displayMetrics;
        Intrinsics.h(startColor, "startColor");
        Boolean bool = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            final GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor(startColor), Color.parseColor(startColor)});
            gradientDrawable.setCornerRadius(4 * ((view == 0 || (context = view.getContext()) == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? 1.0f : displayMetrics.density));
            if (view != 0) {
                view.setBackground(gradientDrawable);
            }
            ?? r72 = new Runnable() { // from class: com.cloud.hisavana.sdk.common.util.p
                @Override // java.lang.Runnable
                public final void run() {
                    r.q(r.this, view2, gradientDrawable);
                }
            };
            if (view != 0) {
                try {
                    bool = Boolean.valueOf(view.postDelayed(r72, 500L));
                } catch (Throwable th2) {
                    th = th2;
                    bool = r72;
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m1185constructorimpl(ResultKt.a(th));
                    return bool;
                }
            }
            Result.m1185constructorimpl(bool);
            return r72;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final void s(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            webView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredWidth = webView.getMeasuredWidth();
            int measuredHeight = webView.getMeasuredHeight();
            e4.b().d("HSCommonUtils", "simulateClickByCoordinate->height: " + measuredHeight + ", width: " + measuredWidth);
            float f11 = (float) (measuredWidth / 2);
            float f12 = (float) (measuredHeight / 2);
            MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, f11, f12, 0);
            webView.dispatchTouchEvent(obtain);
            long j11 = (long) 100;
            MotionEvent obtain2 = MotionEvent.obtain(SystemClock.uptimeMillis() + j11, SystemClock.uptimeMillis() + j11, 1, f11, f12, 0);
            webView.dispatchTouchEvent(obtain2);
            obtain.recycle();
            obtain2.recycle();
        } catch (Throwable unused) {
        }
    }
}
