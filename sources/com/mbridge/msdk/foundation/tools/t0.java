package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.MBDownloadConfig;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper;
import com.mbridge.msdk.foundation.download.resource.ResourceConfig;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class t0 extends w {

    /* renamed from: a, reason: collision with root package name */
    private static int f35866a = 1;

    /* renamed from: b, reason: collision with root package name */
    private static volatile Boolean f35867b;

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f35868c = Pattern.compile("[一-龥]");

    /* renamed from: d, reason: collision with root package name */
    private static Map<String, String> f35869d;

    /* renamed from: e, reason: collision with root package name */
    private static Map<String, String> f35870e;

    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f35871a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f35872b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.foundation.feedback.a f35873c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f35874d;

        a(ImageView imageView, CampaignEx campaignEx, com.mbridge.msdk.foundation.feedback.a aVar, int i11) {
            this.f35871a = imageView;
            this.f35872b = campaignEx;
            this.f35873c = aVar;
            this.f35874d = i11;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                t0.a(this.f35872b, this.f35873c, this.f35874d, (String) this.f35871a.getTag());
            } catch (Exception e11) {
                o0.b("SameTools", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements IDatabaseOpenHelper {
        b() {
        }

        @Override // com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper
        public SQLiteDatabase getReadableDatabase() {
            return com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()).c();
        }

        @Override // com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            return com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()).d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements ILogger {
        c() {
        }

        @Override // com.mbridge.msdk.foundation.download.utils.ILogger
        public void log(String str, Exception exc) {
            o0.a(str, exc.getMessage());
        }

        @Override // com.mbridge.msdk.foundation.download.utils.ILogger
        public void log(String str, String str2) {
            o0.a(str, str2);
        }
    }

    public static double a(Double d11) {
        try {
            String format = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US)).format(d11);
            if (y0.b(format)) {
                return Double.parseDouble(format);
            }
            return 0.0d;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0.0d;
        }
    }

    public static final int a() {
        if (f35867b == null) {
            try {
                f35867b = MIMManager.b().e();
            } catch (Exception e11) {
                o0.b("SameTools", e11.getMessage());
            }
        }
        if (f35867b != null) {
            return f35867b.booleanValue() ? 1 : 0;
        }
        return -1;
    }

    public static int a(int i11) {
        if ((i11 > 100 && i11 < 199) || i11 == 2) {
            return 1;
        }
        if ((i11 <= 200 || i11 >= 299) && i11 != 4) {
            return (i11 <= 500 || i11 >= 599) ? -1 : 5;
        }
        return 2;
    }

    public static int a(Context context, float f11) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f11 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static int a(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof String) {
                    return Integer.parseInt((String) obj);
                }
            } catch (Throwable th2) {
                o0.b("SameTools", th2.getMessage(), th2);
            }
        }
        return 0;
    }

    public static int a(String str, String str2, int i11) {
        if (TextUtils.isEmpty(str)) {
            return i11;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(str2);
                return TextUtils.isEmpty(queryParameter) ? i11 : (int) Math.round(Double.valueOf(String.valueOf(queryParameter)).doubleValue());
            }
        } catch (Exception e11) {
            o0.b("SameTools", e11.getMessage());
        }
        return i11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0028, code lost:
    
        if (r2 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001f, code lost:
    
        if (r2 != null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long a(java.io.File r4) throws java.lang.Exception {
        /*
            r0 = 0
            r2 = 0
            boolean r3 = r4.exists()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L28
            if (r3 == 0) goto L1c
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L28
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L28
            int r4 = r3.available()     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L18
            long r0 = (long) r4
            r2 = r3
            goto L1f
        L15:
            r4 = move-exception
            r2 = r3
            goto L22
        L18:
            r2 = r3
            goto L28
        L1a:
            r4 = move-exception
            goto L22
        L1c:
            r4.createNewFile()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L28
        L1f:
            if (r2 == 0) goto L2d
            goto L2a
        L22:
            if (r2 == 0) goto L27
            r2.close()     // Catch: java.lang.Exception -> L27
        L27:
            throw r4
        L28:
            if (r2 == 0) goto L2d
        L2a:
            r2.close()     // Catch: java.lang.Exception -> L2d
        L2d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.t0.a(java.io.File):long");
    }

    public static ImageView a(ImageView imageView, BitmapDrawable bitmapDrawable, DisplayMetrics displayMetrics) {
        try {
            bitmapDrawable.setTargetDensity(displayMetrics);
            imageView.setBackground(bitmapDrawable);
            imageView.setClickable(false);
            imageView.setFocusable(false);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return imageView;
    }

    public static String a(Context context, String str) {
        String str2;
        str2 = "";
        try {
            JSONArray b11 = b(context, str);
            str2 = b11.length() > 0 ? a(b11) : "";
            o0.c("SameTools", "get excludes:" + str2);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return str2;
    }

    public static synchronized String a(Context context, String str, String str2) {
        String sb2;
        synchronized (t0.class) {
            StringBuilder sb3 = new StringBuilder(str2);
            try {
                sb3.append(a(str2, context, str));
            } catch (Exception unused) {
            }
            sb2 = sb3.toString();
        }
        return sb2;
    }

    public static String a(CampaignEx campaignEx) {
        com.mbridge.msdk.setting.g d11;
        CampaignEx.a adchoice;
        String str = "";
        if (campaignEx != null) {
            try {
                str = campaignEx.getPrivacyUrl();
            } catch (Exception e11) {
                o0.b("SameTools", e11.getMessage());
                return "";
            }
        }
        if (TextUtils.isEmpty(str) && campaignEx != null && (adchoice = campaignEx.getAdchoice()) != null) {
            str = adchoice.c();
        }
        if (TextUtils.isEmpty(str) && (d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b())) != null) {
            str = d11.c();
        }
        return TextUtils.isEmpty(str) ? com.mbridge.msdk.foundation.same.net.utils.d.h().f35528g : str;
    }

    public static String a(String str) {
        try {
            return y0.b(str) ? URLEncoder.encode(str, "utf-8") : "";
        } catch (Throwable th2) {
            o0.b("SameTools", th2.getMessage(), th2);
            return "";
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:13:0x0025
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v3, types: [boolean] */
    private static synchronized java.lang.String a(java.lang.String r2, android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.Class<com.mbridge.msdk.foundation.tools.t0> r0 = com.mbridge.msdk.foundation.tools.t0.class
            monitor-enter(r0)
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            java.util.Set r2 = r2.getQueryParameterNames()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            if (r2 == 0) goto L1d
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            if (r2 <= 0) goto L1d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            java.lang.String r1 = "&rtins_type="
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            goto L2c
        L1b:
            r2 = move-exception
            goto L46
        L1d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            java.lang.String r1 = "?rtins_type="
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L25
            goto L2c
        L25:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1b
            java.lang.String r1 = "&rtins_type="
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L1b
        L2c:
            boolean r3 = a(r4, r3)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L3c
            if (r3 == 0) goto L37
            r3 = 1
            r2.append(r3)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L3c
            goto L40
        L37:
            r3 = 2
            r2.append(r3)     // Catch: java.lang.Throwable -> L1b java.lang.Exception -> L3c
            goto L40
        L3c:
            r3 = 0
            r2.append(r3)     // Catch: java.lang.Throwable -> L1b
        L40:
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L1b
            monitor-exit(r0)
            return r2
        L46:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1b
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.t0.a(java.lang.String, android.content.Context, java.lang.String):java.lang.String");
    }

    public static String a(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                HashMap hashMap = new HashMap();
                hashMap.put(str2, str3);
                return a(str, hashMap);
            }
            return str;
        } catch (Exception e11) {
            o0.b("SameTools", e11.getMessage());
            return str;
        }
    }

    public static String a(String str, Map<String, String> map) {
        try {
            if (!TextUtils.isEmpty(str) && map != null) {
                StringBuilder sb2 = new StringBuilder(str);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null && !TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        String value = entry.getValue();
                        if (str.contains(entry.getKey())) {
                            sb2 = value.equals("0") ? new StringBuilder(str.replaceAll("(" + entry.getKey() + "[^&]*)", "")) : new StringBuilder(str.replaceAll("(" + entry.getKey() + "[^&]*)", entry.getKey() + entry.getValue()));
                        } else if (!value.equals("0")) {
                            sb2.append(entry.getKey() + entry.getValue());
                        }
                    }
                }
                return sb2.toString();
            }
            return str;
        } catch (Exception e11) {
            o0.b("SameTools", e11.getMessage());
            return str;
        }
    }

    public static String a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return "";
        }
        com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (d11 == null) {
            d11 = com.mbridge.msdk.setting.h.b().a();
        }
        int W = d11.W();
        if (jSONArray.length() <= W) {
            return jSONArray.toString();
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i11 = 0; i11 < W; i11++) {
            try {
                jSONArray2.put(jSONArray.get(i11));
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
        return jSONArray2.toString();
    }

    public static List<String> a(StackTraceElement[] stackTraceElementArr) {
        ArrayList arrayList = new ArrayList();
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                arrayList.add(stackTraceElement.getClassName());
            }
        }
        return arrayList;
    }

    public static final void a(int i11, ImageView imageView, CampaignEx campaignEx, Context context, boolean z10, com.mbridge.msdk.foundation.feedback.a aVar) {
        if (imageView == null || campaignEx == null) {
            return;
        }
        o0.a("configPrivacyButton", "configPrivacyButton");
        boolean z11 = campaignEx.getPrivacyButtonTemplateVisibility() == 0;
        o0.a("configPrivacyButton", "privacyButtonVisibilityGone: " + z11 + " isIgnoreCampaignPrivacyConfig: " + z10);
        if (!z10 && z11) {
            try {
                imageView.setVisibility(8);
                return;
            } catch (Exception e11) {
                o0.b("SameTools", e11.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(a(campaignEx))) {
            try {
                imageView.setVisibility(8);
                return;
            } catch (Exception e12) {
                o0.b("SameTools", e12.getMessage());
                return;
            }
        }
        try {
            imageView.setVisibility(0);
        } catch (Exception e13) {
            o0.b("SameTools", e13.getMessage());
        }
        imageView.setOnClickListener(new a(imageView, campaignEx, aVar, i11));
    }

    public static void a(View view) {
        if (view == null) {
            return;
        }
        try {
            view.setSystemUiVisibility(4102);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        try {
            imageView.setImageResource(0);
            imageView.setImageDrawable(null);
            imageView.setImageURI(null);
            imageView.setImageBitmap(null);
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                th2.printStackTrace();
            }
        }
    }

    public static void a(CampaignEx campaignEx, com.mbridge.msdk.foundation.feedback.a aVar, int i11, String str) {
        if (campaignEx == null) {
            return;
        }
        try {
            String str2 = campaignEx.getCampaignUnitId() + "_" + i11;
            com.mbridge.msdk.foundation.feedback.b.b().d(str2);
            com.mbridge.msdk.foundation.feedback.b.b().a(str2, campaignEx);
            com.mbridge.msdk.foundation.feedback.b.b().a(str2, aVar);
            com.mbridge.msdk.foundation.feedback.b.b().a(str2, i11);
            com.mbridge.msdk.foundation.feedback.b.b().a(str2, str);
            com.mbridge.msdk.foundation.feedback.b.b().b(str2).p();
        } catch (Throwable th2) {
            o0.b("SameTools", "feedback error", th2);
        }
    }

    public static void a(String str, CampaignEx campaignEx, int i11) {
        try {
            if (TextUtils.isEmpty(str) || campaignEx == null || com.mbridge.msdk.foundation.controller.c.m().d() == null) {
                return;
            }
            com.mbridge.msdk.foundation.db.i a11 = com.mbridge.msdk.foundation.db.i.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
            com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
            fVar.a(System.currentTimeMillis());
            fVar.b(str);
            fVar.a(campaignEx.getId());
            fVar.a(i11);
            a11.a(fVar);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("SameTools", e11.getMessage());
            }
        }
    }

    private static boolean a(long j11, long j12) {
        long currentTimeMillis = System.currentTimeMillis();
        if (j11 > 0) {
            return j12 + (j11 * 1000) >= currentTimeMillis;
        }
        com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (d11 == null) {
            d11 = com.mbridge.msdk.setting.h.b().a();
        }
        return j12 + (d11.a0() * 1000) >= currentTimeMillis;
    }

    static boolean a(String str, Context context) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    return false;
                }
                if (packageManager.getPackageInfo(str, 1) != null) {
                    return true;
                }
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    o0.a("SameTools", th2.getMessage());
                }
            }
        }
        return false;
    }

    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                try {
                    Uri parse = Uri.parse(str2);
                    if (parse != null) {
                        return !TextUtils.isEmpty(parse.getQueryParameter(str));
                    }
                    return false;
                } catch (Exception e11) {
                    o0.b("SameTools", e11.getMessage());
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0 || jSONObject.optInt("v", -1) != -1) ? false : true;
    }

    public static int b() {
        int i11 = f35866a;
        f35866a = i11 + 1;
        return i11;
    }

    public static int b(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            PackageInfo currentWebViewPackage = Build.VERSION.SDK_INT >= 26 ? WebView.getCurrentWebViewPackage() : context.getPackageManager().getPackageInfo("com.google.android.webview", 1);
            com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d11 == null) {
                d11 = com.mbridge.msdk.setting.h.b().a();
            }
            if (currentWebViewPackage == null || TextUtils.isEmpty(currentWebViewPackage.versionName) || !currentWebViewPackage.versionName.equals("77.0.3865.92")) {
                return d11.z0();
            }
            return 5;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int b(Context context, float f11) {
        float f12 = 2.5f;
        if (context != null) {
            try {
                float f13 = context.getResources().getDisplayMetrics().density;
                if (f13 != 0.0f) {
                    f12 = f13;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return (int) ((f11 / f12) + 0.5f);
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return -1;
            }
            String queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW);
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            }
            if (TextUtils.isEmpty(queryParameter)) {
                return -1;
            }
            try {
                return Integer.parseInt(queryParameter);
            } catch (Exception unused) {
                return -1;
            }
        } catch (Exception e11) {
            o0.b("SameTools", e11.getMessage());
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0041 A[Catch: Exception -> 0x001b, LOOP:0: B:17:0x003f->B:18:0x0041, LOOP_END, TryCatch #0 {Exception -> 0x001b, blocks: (B:2:0x0000, B:4:0x0012, B:5:0x001d, B:7:0x0024, B:9:0x002b, B:11:0x0035, B:15:0x003b, B:18:0x0041, B:21:0x0049, B:23:0x004f), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(int r4) {
        /*
            com.mbridge.msdk.setting.h r0 = com.mbridge.msdk.setting.h.b()     // Catch: java.lang.Exception -> L1b
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Exception -> L1b
            java.lang.String r1 = r1.b()     // Catch: java.lang.Exception -> L1b
            com.mbridge.msdk.setting.g r0 = r0.d(r1)     // Catch: java.lang.Exception -> L1b
            if (r0 != 0) goto L1d
            com.mbridge.msdk.setting.h r0 = com.mbridge.msdk.setting.h.b()     // Catch: java.lang.Exception -> L1b
            com.mbridge.msdk.setting.g r0 = r0.a()     // Catch: java.lang.Exception -> L1b
            goto L1d
        L1b:
            r4 = move-exception
            goto L54
        L1d:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Exception -> L1b
            r1.<init>()     // Catch: java.lang.Exception -> L1b
            if (r0 == 0) goto L49
            int r0 = r0.m()     // Catch: java.lang.Exception -> L1b
            r2 = 1
            if (r0 != r2) goto L49
            com.mbridge.msdk.foundation.db.middle.a r0 = com.mbridge.msdk.foundation.db.middle.a.b()     // Catch: java.lang.Exception -> L1b
            java.lang.String[] r0 = r0.a()     // Catch: java.lang.Exception -> L1b
            if (r0 == 0) goto L49
            int r2 = r0.length     // Catch: java.lang.Exception -> L1b
            if (r2 <= r4) goto L3e
            if (r4 != 0) goto L3b
            goto L3e
        L3b:
            int r4 = r2 - r4
            goto L3f
        L3e:
            r4 = 0
        L3f:
            if (r4 >= r2) goto L49
            r3 = r0[r4]     // Catch: java.lang.Exception -> L1b
            r1.put(r3)     // Catch: java.lang.Exception -> L1b
            int r4 = r4 + 1
            goto L3f
        L49:
            int r4 = r1.length()     // Catch: java.lang.Exception -> L1b
            if (r4 <= 0) goto L57
            java.lang.String r4 = a(r1)     // Catch: java.lang.Exception -> L1b
            goto L59
        L54:
            r4.printStackTrace()
        L57:
            java.lang.String r4 = ""
        L59:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.t0.b(int):java.lang.String");
    }

    public static String b(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.getJSONObject("device");
                if (jSONObject2 == null) {
                    return str;
                }
                if (jSONObject2.has(str2)) {
                    if (str3.equals("0")) {
                        jSONObject2.remove(str2);
                    } else {
                        jSONObject2.put(str2, str3);
                    }
                } else {
                    if (str3.equals("0")) {
                        return str;
                    }
                    jSONObject2.put(str2, str3);
                }
                return jSONObject.toString();
            } catch (Exception e11) {
                o0.b("SameTools", e11.getMessage());
            }
        }
        return str;
    }

    public static List<String> b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                String optString = jSONArray.optString(i11);
                if (y0.b(optString)) {
                    arrayList.add(optString);
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            o0.b("SameTools", th2.getMessage(), th2);
            return null;
        }
    }

    public static JSONArray b(Context context, String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d11 == null) {
                d11 = com.mbridge.msdk.setting.h.b().a();
            }
            if (d11 != null && d11.m() == 1) {
                o0.c("SameTools", "fqci cfc:" + d11.m());
                String[] a11 = com.mbridge.msdk.foundation.db.middle.a.b().a();
                if (a11 != null) {
                    for (String str2 : a11) {
                        o0.c("SameTools", "cfc campaignIds:" + a11);
                        jSONArray.put(str2);
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return jSONArray;
    }

    public static synchronized void b(String str, String str2) {
        synchronized (t0.class) {
            try {
                if (f35870e == null) {
                    f35870e = new HashMap();
                }
                f35870e.put(com.mbridge.msdk.foundation.controller.c.m().b() + "_" + str, str2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            return !TextUtils.isEmpty(campaignEx.getDeepLinkURL());
        }
        return false;
    }

    public static boolean b(String str, Context context) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int c(Context context) {
        if (context != null) {
            return 0;
        }
        try {
            if (context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") != 0) {
                return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return 0;
    }

    public static int c(String str, String str2) {
        return a(str, str2, 0);
    }

    public static final String c() {
        return MIMManager.b().d();
    }

    public static String c(String str) {
        ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> c11;
        List<String> c12;
        if (TextUtils.isEmpty(str) || (c11 = com.mbridge.msdk.foundation.same.buffer.b.c(str)) == null || c11.size() <= 0) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (com.mbridge.msdk.foundation.entity.c cVar : c11.values()) {
            if (cVar != null && a(cVar.e(), cVar.f()) && (c12 = cVar.c()) != null && c12.size() > 0) {
                arrayList.addAll(c12);
            }
        }
        if (arrayList.size() <= 0) {
            return "";
        }
        HashSet hashSet = new HashSet(arrayList);
        arrayList.clear();
        arrayList.addAll(hashSet);
        return arrayList.toString();
    }

    public static synchronized boolean c(Context context, String str) {
        synchronized (t0.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    return a(str, context);
                }
            }
            return false;
        }
    }

    public static boolean c(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                return campaignEx.getRetarget_offer() == 1;
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return false;
    }

    public static float d(Context context) {
        if (context == null) {
            return 2.5f;
        }
        try {
            float f11 = context.getResources().getDisplayMetrics().density;
            if (f11 == 0.0f) {
                return 2.5f;
            }
            return f11;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 2.5f;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized int d(Context context, String str) {
        int i11;
        synchronized (t0.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        i11 = a(str, context);
                    } catch (Exception unused) {
                        i11 = 3;
                    }
                }
            }
            i11 = context == null ? 5 : TextUtils.isEmpty(str) ? 2 : 4;
        }
        return i11;
    }

    public static String d() {
        String str;
        try {
            str = UUID.randomUUID().toString() + System.currentTimeMillis();
        } catch (Throwable th2) {
            th2.printStackTrace();
            str = "";
        }
        if (!y0.a(str)) {
            return str;
        }
        return System.currentTimeMillis() + "";
    }

    public static synchronized String d(String str) {
        synchronized (t0.class) {
            String str2 = com.mbridge.msdk.foundation.controller.c.m().b() + "_" + str;
            Map<String, String> map = f35870e;
            if (map == null || !map.containsKey(str2)) {
                return null;
            }
            return f35870e.get(str2);
        }
    }

    public static int e() {
        try {
            return ((Integer) Class.forName("com.tencent.mm.opensdk.constants.Build").getField("SDK_INT").get(null)).intValue();
        } catch (Throwable th2) {
            o0.b("SameTools", th2.getMessage());
            return 0;
        }
    }

    public static DisplayMetrics e(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return context.getResources().getDisplayMetrics();
        }
    }

    public static final synchronized String e(String str) {
        String str2;
        int i11;
        boolean z10;
        int i12;
        boolean z11;
        JSONObject jSONObject;
        Map<String, String> map;
        synchronized (t0.class) {
            try {
                str2 = com.mbridge.msdk.foundation.controller.c.m().b() + "_" + str;
                com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                if (d11 != null) {
                    z10 = d11.A0();
                    z11 = d11.H0();
                    i12 = Math.max(0, d11.b0());
                } else {
                    z10 = true;
                    i12 = 3;
                    z11 = false;
                }
            } catch (Exception e11) {
                o0.b("SameTools", e11.getMessage());
            } finally {
            }
            if (z11 && i12 != 0) {
                if (z10 && (map = f35869d) != null && map.containsKey(str2)) {
                    return f35869d.get(str2);
                }
                StringBuilder sb2 = new StringBuilder("");
                StackTraceElement[] stackTrace = new Exception().getStackTrace();
                if (stackTrace != null && stackTrace.length > 0) {
                    List<String> a11 = a(stackTrace);
                    Collections.reverse(a11);
                    ArrayList arrayList = new ArrayList();
                    for (String str3 : a11) {
                        if (!str3.startsWith(MBridgeConstans.APPLICATION_STACK_COM_ANDROID) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_OS) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_APP) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_REFLECT_METHOD) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_VIEW) && !arrayList.contains(str3)) {
                            arrayList.add(str3);
                        }
                    }
                    int min = Math.min(arrayList.size(), i12);
                    if (min > 0) {
                        for (i11 = 0; i11 < min; i11++) {
                            sb2.append((String) arrayList.get(i11));
                            if (i11 < min - 1) {
                                sb2.append("|");
                            }
                        }
                    }
                    if (TextUtils.isEmpty(sb2.toString())) {
                        jSONObject = null;
                    } else {
                        jSONObject = new JSONObject();
                        jSONObject.put("1", sb2.toString());
                    }
                    if (jSONObject == null || jSONObject.length() <= 0) {
                        return "";
                    }
                    String b11 = com.mbridge.msdk.foundation.tools.a.b(jSONObject.toString());
                    if (z10 && !TextUtils.isEmpty(b11)) {
                        if (f35869d == null) {
                            f35869d = new HashMap();
                        }
                        f35869d.put(str2, b11);
                    }
                    return b11;
                }
                return "";
            }
            return "";
        }
    }

    public static int f(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return e(context).heightPixels;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static int f(String str) {
        try {
            return ((Integer) Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("getWXAppSupportAPI", null).invoke(k0.d(str), null)).intValue();
        } catch (Throwable th2) {
            o0.b("SameTools", th2.getMessage());
            return 0;
        }
    }

    public static void f() {
        try {
            HandlerThread handlerThread = new HandlerThread("mb_db_thread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            MBDownloadConfig.Builder builder = new MBDownloadConfig.Builder();
            builder.setDatabaseHandler(handler);
            builder.setDatabaseOpenHelper(new b());
            builder.setLogger(new c());
            MBDownloadManager.getInstance().initialize(com.mbridge.msdk.foundation.controller.c.m().d(), builder.build(), new ResourceConfig.Builder().setMaxStorageSpace(100L).setMaxStorageTime(TmcConstants.MINIAPP_TIME_DIFF).build());
        } catch (Throwable th2) {
            o0.b("SameTools", th2.getMessage());
        }
    }

    public static int g(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return e(context).widthPixels;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static Object g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory").getMethod("createWXAPI", Context.class, String.class).invoke(null, com.mbridge.msdk.foundation.controller.c.m().d(), str);
        } catch (ClassNotFoundException e11) {
            o0.b("SameTools", e11.getMessage());
            return null;
        } catch (IllegalAccessException e12) {
            o0.b("SameTools", e12.getMessage());
            return null;
        } catch (NoSuchMethodException e13) {
            o0.b("SameTools", e13.getMessage());
            return null;
        } catch (InvocationTargetException e14) {
            o0.b("SameTools", e14.getMessage());
            return null;
        }
    }

    public static boolean g() {
        if (TextUtils.isEmpty(com.mbridge.msdk.foundation.controller.c.m().i())) {
            return false;
        }
        try {
            Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
            Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram");
            return true;
        } catch (ClassNotFoundException e11) {
            o0.b("SameTools", e11.getMessage());
            return false;
        }
    }

    public static int h(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static boolean h() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return false;
            }
            String queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_CAN_ANIM);
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            return queryParameter.equals("1");
        } catch (Exception e11) {
            o0.b("SameTools", e11.getMessage());
            return false;
        }
    }

    public static int i(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static boolean i() {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager a11 = f0.a();
            if (a11 != null && (networkInfo = a11.getNetworkInfo(17)) != null) {
                return networkInfo.isConnected();
            }
            return false;
        } catch (Exception e11) {
            o0.b("SameTools", e11.getMessage());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean i(java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L49
            if (r4 == 0) goto L3f
            java.lang.String r0 = "dyview"
            java.lang.String r0 = r4.getQueryParameter(r0)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L49
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L49
            r3 = 1
            if (r2 != 0) goto L2a
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L20 java.lang.Throwable -> L49
            goto L21
        L20:
            r0 = -1
        L21:
            int r0 = r0 % 2
            if (r0 != 0) goto L2a
            r0 = r3
            goto L2b
        L27:
            r4 = move-exception
            r0 = r1
            goto L40
        L2a:
            r0 = r1
        L2b:
            java.lang.String r2 = "natmp"
            java.lang.String r4 = r4.getQueryParameter(r2)     // Catch: java.lang.Exception -> L3b java.lang.Throwable -> L3d
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L3b java.lang.Throwable -> L3d
            if (r4 != 0) goto L39
            r1 = r3
            goto L3f
        L39:
            r1 = r0
            goto L3f
        L3b:
            r4 = move-exception
            goto L40
        L3d:
            r1 = r0
            goto L49
        L3f:
            return r1
        L40:
            java.lang.String r2 = "SameTools"
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> L3d
            com.mbridge.msdk.foundation.tools.o0.b(r2, r4)     // Catch: java.lang.Throwable -> L3d
        L49:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.t0.i(java.lang.String):boolean");
    }

    public static float j(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static boolean j() {
        try {
            if (com.mbridge.msdk.foundation.controller.c.m().d() == null) {
                return false;
            }
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = TmcConstants.COLD_OPEN_TYPE;
            }
            int parseInt = Integer.parseInt(property2);
            o0.a("address = ", property + "~");
            o0.a("port = ", parseInt + "~");
            return (TextUtils.isEmpty(property) || parseInt == -1) ? false : true;
        } catch (Throwable th2) {
            o0.b("SameTools", th2.getMessage());
            return false;
        }
    }

    public static <T extends String> boolean j(T t11) {
        return t11 != null && t11.length() > 0;
    }

    public static int k(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static <T extends String> boolean k(T t11) {
        return t11 == null || t11.length() == 0;
    }

    public static boolean l(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return false;
            }
            String queryParameter = parse.getQueryParameter(MBridgeConstans.ENDCARD_URL_IS_PLAYABLE);
            if (TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            return queryParameter.equals("0");
        } catch (Exception e11) {
            o0.b("SameTools", e11.getMessage());
            return false;
        }
    }

    public static double m(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Double.parseDouble(str);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return 0.0d;
    }

    public static boolean m(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("SameTools", "isNetworkAvailable", e11);
            }
            return false;
        }
    }

    public static BitmapDrawable n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            if (decodeByteArray != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(decodeByteArray);
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                bitmapDrawable.setTileModeXY(tileMode, tileMode);
                return bitmapDrawable;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return null;
    }

    public static boolean n(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return "wifi".equals(activeNetworkInfo.getTypeName().toLowerCase(Locale.US));
            }
            return false;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }
}
