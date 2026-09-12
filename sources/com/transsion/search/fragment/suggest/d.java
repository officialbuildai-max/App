package com.transsion.search.fragment.suggest;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.transsion.search.bean.SuggestEntity;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000e\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/transsion/search/fragment/suggest/d;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/transsion/search/bean/SuggestEntity;", "<init>", "()V", "", "keyWord", "", "R1", "(Ljava/lang/String;)V", "", "data", "", RequestParameters.POSITION, "N1", "(Ljava/util/List;I)I", "G", "Ljava/lang/String;", "Q1", "()Ljava/lang/String;", "S1", "mKeyWord", "H", "a", "Search_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class d extends BaseProviderMultiAdapter<SuggestEntity> {

    /* renamed from: H, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int I = 3;
    public static final int J = 2;
    public static final int K = 1;
    public static final int L = 0;

    /* renamed from: G, reason: from kotlin metadata */
    private String mKeyWord;

    /* renamed from: com.transsion.search.fragment.suggest.d$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.CharSequence a(java.lang.String r12, java.lang.String r13) {
            /*
                r11 = this;
                r0 = -1
                r1 = 1
                java.lang.String r2 = ""
                java.lang.String r3 = "toUpperCase(...)"
                java.lang.String r4 = "mKeyWord"
                kotlin.jvm.internal.Intrinsics.h(r12, r4)
                kotlin.Result$Companion r4 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L24
                java.util.Locale r4 = java.util.Locale.ROOT     // Catch: java.lang.Throwable -> L24
                java.lang.String r12 = r12.toUpperCase(r4)     // Catch: java.lang.Throwable -> L24
                kotlin.jvm.internal.Intrinsics.g(r12, r3)     // Catch: java.lang.Throwable -> L24
                if (r13 == 0) goto L27
                java.lang.String r4 = r13.toUpperCase(r4)     // Catch: java.lang.Throwable -> L24
                kotlin.jvm.internal.Intrinsics.g(r4, r3)     // Catch: java.lang.Throwable -> L24
                if (r4 != 0) goto L22
                goto L27
            L22:
                r5 = r4
                goto L28
            L24:
                r12 = move-exception
                goto L97
            L27:
                r5 = r2
            L28:
                int r3 = r12.length()     // Catch: java.lang.Throwable -> L24
                int r3 = r3 - r1
                r4 = 0
                r6 = r4
                r7 = r6
            L30:
                if (r6 > r3) goto L53
                if (r7 != 0) goto L36
                r8 = r6
                goto L37
            L36:
                r8 = r3
            L37:
                char r8 = r12.charAt(r8)     // Catch: java.lang.Throwable -> L24
                r9 = 32
                int r8 = kotlin.jvm.internal.Intrinsics.j(r8, r9)     // Catch: java.lang.Throwable -> L24
                if (r8 > 0) goto L45
                r8 = r1
                goto L46
            L45:
                r8 = r4
            L46:
                if (r7 != 0) goto L4e
                if (r8 != 0) goto L4c
                r7 = r1
                goto L30
            L4c:
                int r6 = r6 + r1
                goto L30
            L4e:
                if (r8 != 0) goto L51
                goto L53
            L51:
                int r3 = r3 + r0
                goto L30
            L53:
                int r3 = r3 + r1
                java.lang.CharSequence r1 = r12.subSequence(r6, r3)     // Catch: java.lang.Throwable -> L24
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L24
                int r1 = r1.length()     // Catch: java.lang.Throwable -> L24
                if (r1 != 0) goto L63
                return r13
            L63:
                r1 = 2
                r3 = 0
                boolean r1 = kotlin.text.StringsKt.c0(r5, r12, r4, r1, r3)     // Catch: java.lang.Throwable -> L24
                if (r1 != 0) goto L6c
                return r13
            L6c:
                r9 = 6
                r10 = 0
                r7 = 0
                r8 = 0
                r6 = r12
                int r1 = kotlin.text.StringsKt.o0(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L24
                int r12 = r12.length()     // Catch: java.lang.Throwable -> L24
                int r12 = r12 + r1
                android.text.SpannableStringBuilder r3 = new android.text.SpannableStringBuilder     // Catch: java.lang.Throwable -> L24
                r3.<init>()     // Catch: java.lang.Throwable -> L24
                r3.append(r13)     // Catch: java.lang.Throwable -> L24
                if (r12 == 0) goto L96
                if (r1 == r0) goto L96
                android.text.style.ForegroundColorSpan r13 = new android.text.style.ForegroundColorSpan     // Catch: java.lang.Throwable -> L24
                java.lang.String r0 = "#10A84D"
                int r0 = android.graphics.Color.parseColor(r0)     // Catch: java.lang.Throwable -> L24
                r13.<init>(r0)     // Catch: java.lang.Throwable -> L24
                r0 = 33
                r3.setSpan(r13, r1, r12, r0)     // Catch: java.lang.Throwable -> L24
            L96:
                return r3
            L97:
                kotlin.Result$Companion r13 = kotlin.Result.INSTANCE
                java.lang.Object r12 = kotlin.ResultKt.a(r12)
                kotlin.Result.m1185constructorimpl(r12)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.search.fragment.suggest.d.Companion.a(java.lang.String, java.lang.String):java.lang.CharSequence");
        }
    }

    public d() {
        super(null, 1, null);
        F1(new wq.d());
        F1(new wq.b());
        F1(new wq.c());
        F1(new wq.a());
        this.mKeyWord = "";
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    protected int N1(List<? extends SuggestEntity> data, int position) {
        Intrinsics.h(data, "data");
        Integer type = data.get(position).getType();
        if (type != null && type.intValue() == 2) {
            return 2;
        }
        if (type != null && type.intValue() == 1) {
            return 1;
        }
        return ((type != null && type.intValue() == 0) || type == null || type.intValue() != 3) ? 0 : 3;
    }

    /* renamed from: Q1, reason: from getter */
    public final String getMKeyWord() {
        return this.mKeyWord;
    }

    public final void R1(String keyWord) {
        Intrinsics.h(keyWord, "keyWord");
        this.mKeyWord = keyWord;
    }

    public final void S1(String str) {
        Intrinsics.h(str, "<set-?>");
        this.mKeyWord = str;
    }
}
