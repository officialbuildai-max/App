package com.transsion.subtitle.helper;

import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.download.DownloadBean;
import java.io.InputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import okio.Okio;

/* loaded from: classes.dex */
public final class SubtitleSearchHelper {

    /* renamed from: c, reason: collision with root package name */
    public static final a f55013c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final String f55014d = com.transsion.baselib.report.a.f43394a.a();

    /* renamed from: e, reason: collision with root package name */
    private static final Lazy f55015e = LazyKt.b(new Function0() { // from class: com.transsion.subtitle.helper.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SubtitleSearchHelper h11;
            h11 = SubtitleSearchHelper.h();
            return h11;
        }
    });

    /* renamed from: a, reason: collision with root package name */
    private boolean f55016a = true;

    /* renamed from: b, reason: collision with root package name */
    private boolean f55017b;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SubtitleSearchHelper a() {
            return (SubtitleSearchHelper) SubtitleSearchHelper.f55015e.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(kotlin.coroutines.Continuation r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.transsion.subtitle.helper.SubtitleSearchHelper$initLocalLanguage$1
            if (r0 == 0) goto L13
            r0 = r11
            com.transsion.subtitle.helper.SubtitleSearchHelper$initLocalLanguage$1 r0 = (com.transsion.subtitle.helper.SubtitleSearchHelper$initLocalLanguage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.subtitle.helper.SubtitleSearchHelper$initLocalLanguage$1 r0 = new com.transsion.subtitle.helper.SubtitleSearchHelper$initLocalLanguage$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r2 = r0.L$1
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$0
            lj.d1 r4 = (lj.d1) r4
            kotlin.ResultKt.b(r11)
            goto Lb8
        L35:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L3d:
            java.lang.Object r2 = r0.L$0
            lj.d1 r2 = (lj.d1) r2
            kotlin.ResultKt.b(r11)
            goto L66
        L45:
            kotlin.ResultKt.b(r11)
            com.transsion.baselib.db.AppDatabase$g1 r11 = com.transsion.baselib.db.AppDatabase.INSTANCE
            android.app.Application r2 = com.blankj.utilcode.util.Utils.a()
            java.lang.String r5 = "getApp(...)"
            kotlin.jvm.internal.Intrinsics.g(r2, r5)
            com.transsion.baselib.db.AppDatabase r11 = r11.b(r2)
            lj.d1 r2 = r11.A1()
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r11 = r2.a(r0)
            if (r11 != r1) goto L66
            return r1
        L66:
            java.util.List r11 = (java.util.List) r11
            java.util.Collection r11 = (java.util.Collection) r11
            if (r11 == 0) goto L72
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto Ld1
        L72:
            com.transsion.subtitle.helper.SubtitleSearchHelper$initLocalLanguage$type$1 r11 = new com.transsion.subtitle.helper.SubtitleSearchHelper$initLocalLanguage$type$1
            r11.<init>()
            java.lang.reflect.Type r11 = r11.getType()
            java.lang.String r4 = r10.i()
            java.lang.Object r11 = com.blankj.utilcode.util.o.e(r4, r11)
            java.util.List r11 = (java.util.List) r11
            lg.a$a r4 = lg.a.f68962a
            java.lang.String r5 = com.transsion.subtitle.helper.SubtitleSearchHelper.f55014d
            int r6 = r11.size()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "initLocalLanguage, localListSize:"
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = ", insert "
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String[] r6 = new java.lang.String[]{r6}
            r8 = 4
            r9 = 0
            r7 = 0
            lg.a.C0856a.r(r4, r5, r6, r7, r8, r9)
            kotlin.jvm.internal.Intrinsics.e(r11)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
            r4 = r2
            r2 = r11
        Lb8:
            boolean r11 = r2.hasNext()
            if (r11 == 0) goto Ld1
            java.lang.Object r11 = r2.next()
            com.transsion.baselib.db.download.SubtitleLanguageMapBean r11 = (com.transsion.baselib.db.download.SubtitleLanguageMapBean) r11
            r0.L$0 = r4
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r11 = r4.c(r11, r0)
            if (r11 != r1) goto Lb8
            return r1
        Ld1:
            kotlin.Unit r11 = kotlin.Unit.f67184a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subtitle.helper.SubtitleSearchHelper.f(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:3|(4:5|6|7|8))|142|6|7|8) */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x003d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02be, code lost:
    
        r4 = kotlin.Result.INSTANCE;
        r0 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r0));
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0028. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x014d A[Catch: all -> 0x003d, TryCatch #0 {all -> 0x003d, blocks: (B:15:0x0038, B:16:0x02b7, B:23:0x0054, B:25:0x0221, B:27:0x0227, B:30:0x0245, B:32:0x0249, B:35:0x0260, B:40:0x024f, B:42:0x0253, B:48:0x006d, B:49:0x01ee, B:50:0x0072, B:51:0x029e, B:54:0x007f, B:56:0x00fb, B:58:0x0102, B:61:0x010a, B:63:0x0138, B:65:0x015d, B:66:0x0165, B:68:0x016b, B:70:0x0177, B:71:0x0179, B:73:0x0187, B:74:0x018b, B:81:0x0199, B:83:0x019d, B:85:0x01d4, B:88:0x01da, B:91:0x01a3, B:92:0x01aa, B:94:0x01b0, B:96:0x01c4, B:97:0x01c8, B:106:0x014d, B:107:0x0279, B:109:0x027d, B:111:0x0283, B:126:0x00a8, B:128:0x00b8, B:130:0x00c0, B:132:0x00c6, B:136:0x02a1), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x029d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038 A[Catch: all -> 0x003d, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x003d, blocks: (B:15:0x0038, B:16:0x02b7, B:23:0x0054, B:25:0x0221, B:27:0x0227, B:30:0x0245, B:32:0x0249, B:35:0x0260, B:40:0x024f, B:42:0x0253, B:48:0x006d, B:49:0x01ee, B:50:0x0072, B:51:0x029e, B:54:0x007f, B:56:0x00fb, B:58:0x0102, B:61:0x010a, B:63:0x0138, B:65:0x015d, B:66:0x0165, B:68:0x016b, B:70:0x0177, B:71:0x0179, B:73:0x0187, B:74:0x018b, B:81:0x0199, B:83:0x019d, B:85:0x01d4, B:88:0x01da, B:91:0x01a3, B:92:0x01aa, B:94:0x01b0, B:96:0x01c4, B:97:0x01c8, B:106:0x014d, B:107:0x0279, B:109:0x027d, B:111:0x0283, B:126:0x00a8, B:128:0x00b8, B:130:0x00c0, B:132:0x00c6, B:136:0x02a1), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0227 A[Catch: all -> 0x003d, TryCatch #0 {all -> 0x003d, blocks: (B:15:0x0038, B:16:0x02b7, B:23:0x0054, B:25:0x0221, B:27:0x0227, B:30:0x0245, B:32:0x0249, B:35:0x0260, B:40:0x024f, B:42:0x0253, B:48:0x006d, B:49:0x01ee, B:50:0x0072, B:51:0x029e, B:54:0x007f, B:56:0x00fb, B:58:0x0102, B:61:0x010a, B:63:0x0138, B:65:0x015d, B:66:0x0165, B:68:0x016b, B:70:0x0177, B:71:0x0179, B:73:0x0187, B:74:0x018b, B:81:0x0199, B:83:0x019d, B:85:0x01d4, B:88:0x01da, B:91:0x01a3, B:92:0x01aa, B:94:0x01b0, B:96:0x01c4, B:97:0x01c8, B:106:0x014d, B:107:0x0279, B:109:0x027d, B:111:0x0283, B:126:0x00a8, B:128:0x00b8, B:130:0x00c0, B:132:0x00c6, B:136:0x02a1), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0072 A[Catch: all -> 0x003d, TRY_LEAVE, TryCatch #0 {all -> 0x003d, blocks: (B:15:0x0038, B:16:0x02b7, B:23:0x0054, B:25:0x0221, B:27:0x0227, B:30:0x0245, B:32:0x0249, B:35:0x0260, B:40:0x024f, B:42:0x0253, B:48:0x006d, B:49:0x01ee, B:50:0x0072, B:51:0x029e, B:54:0x007f, B:56:0x00fb, B:58:0x0102, B:61:0x010a, B:63:0x0138, B:65:0x015d, B:66:0x0165, B:68:0x016b, B:70:0x0177, B:71:0x0179, B:73:0x0187, B:74:0x018b, B:81:0x0199, B:83:0x019d, B:85:0x01d4, B:88:0x01da, B:91:0x01a3, B:92:0x01aa, B:94:0x01b0, B:96:0x01c4, B:97:0x01c8, B:106:0x014d, B:107:0x0279, B:109:0x027d, B:111:0x0283, B:126:0x00a8, B:128:0x00b8, B:130:0x00c0, B:132:0x00c6, B:136:0x02a1), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0138 A[Catch: all -> 0x003d, TryCatch #0 {all -> 0x003d, blocks: (B:15:0x0038, B:16:0x02b7, B:23:0x0054, B:25:0x0221, B:27:0x0227, B:30:0x0245, B:32:0x0249, B:35:0x0260, B:40:0x024f, B:42:0x0253, B:48:0x006d, B:49:0x01ee, B:50:0x0072, B:51:0x029e, B:54:0x007f, B:56:0x00fb, B:58:0x0102, B:61:0x010a, B:63:0x0138, B:65:0x015d, B:66:0x0165, B:68:0x016b, B:70:0x0177, B:71:0x0179, B:73:0x0187, B:74:0x018b, B:81:0x0199, B:83:0x019d, B:85:0x01d4, B:88:0x01da, B:91:0x01a3, B:92:0x01aa, B:94:0x01b0, B:96:0x01c4, B:97:0x01c8, B:106:0x014d, B:107:0x0279, B:109:0x027d, B:111:0x0283, B:126:0x00a8, B:128:0x00b8, B:130:0x00c0, B:132:0x00c6, B:136:0x02a1), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015d A[Catch: all -> 0x003d, TryCatch #0 {all -> 0x003d, blocks: (B:15:0x0038, B:16:0x02b7, B:23:0x0054, B:25:0x0221, B:27:0x0227, B:30:0x0245, B:32:0x0249, B:35:0x0260, B:40:0x024f, B:42:0x0253, B:48:0x006d, B:49:0x01ee, B:50:0x0072, B:51:0x029e, B:54:0x007f, B:56:0x00fb, B:58:0x0102, B:61:0x010a, B:63:0x0138, B:65:0x015d, B:66:0x0165, B:68:0x016b, B:70:0x0177, B:71:0x0179, B:73:0x0187, B:74:0x018b, B:81:0x0199, B:83:0x019d, B:85:0x01d4, B:88:0x01da, B:91:0x01a3, B:92:0x01aa, B:94:0x01b0, B:96:0x01c4, B:97:0x01c8, B:106:0x014d, B:107:0x0279, B:109:0x027d, B:111:0x0283, B:126:0x00a8, B:128:0x00b8, B:130:0x00c0, B:132:0x00c6, B:136:0x02a1), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01b0 A[Catch: all -> 0x003d, TryCatch #0 {all -> 0x003d, blocks: (B:15:0x0038, B:16:0x02b7, B:23:0x0054, B:25:0x0221, B:27:0x0227, B:30:0x0245, B:32:0x0249, B:35:0x0260, B:40:0x024f, B:42:0x0253, B:48:0x006d, B:49:0x01ee, B:50:0x0072, B:51:0x029e, B:54:0x007f, B:56:0x00fb, B:58:0x0102, B:61:0x010a, B:63:0x0138, B:65:0x015d, B:66:0x0165, B:68:0x016b, B:70:0x0177, B:71:0x0179, B:73:0x0187, B:74:0x018b, B:81:0x0199, B:83:0x019d, B:85:0x01d4, B:88:0x01da, B:91:0x01a3, B:92:0x01aa, B:94:0x01b0, B:96:0x01c4, B:97:0x01c8, B:106:0x014d, B:107:0x0279, B:109:0x027d, B:111:0x0283, B:126:0x00a8, B:128:0x00b8, B:130:0x00c0, B:132:0x00c6, B:136:0x02a1), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(kotlin.coroutines.Continuation r24) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subtitle.helper.SubtitleSearchHelper.g(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SubtitleSearchHelper h() {
        return new SubtitleSearchHelper();
    }

    private final String i() {
        try {
            InputStream open = Utils.a().getResources().getAssets().open("sub_def_la.json");
            Intrinsics.e(open);
            return Okio.buffer(Okio.source(open)).readUtf8();
        } catch (Exception unused) {
            return null;
        }
    }

    public final String e(DownloadBean downloadBean) {
        String name;
        if (downloadBean == null || (name = downloadBean.getTitleName()) == null) {
            name = downloadBean != null ? downloadBean.getName() : null;
            if (name == null) {
                name = "";
            }
        }
        String str = name;
        String str2 = (downloadBean != null ? Integer.valueOf(downloadBean.getResolution()) : null) + "P";
        if (StringsKt.c0(str, (downloadBean != null ? Integer.valueOf(downloadBean.getResolution()) : null) + "P", false, 2, null)) {
            str = StringsKt.Q(str, str2, "", false, 4, null);
        }
        return new Regex("[\\\\/:#*?\"<>|&]_-").replace(str, " ");
    }

    public final void j() {
        k.d(o0.a(y0.b()), null, null, new SubtitleSearchHelper$updateLanguageList$1(this, null), 3, null);
    }
}
