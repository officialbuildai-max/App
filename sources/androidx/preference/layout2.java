package androidx.preference;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.C0078;
import androidx.core.C0079;
import androidx.core.appcompat.C0066;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.subroom.activity.C0667;
import com.transsion.subroom.premium.C0669;
import com.transsion.subroom.premium.C0682;
import com.transsion.subroom.premium.C0684;
import com.transsion.subroom.premium.C0685;
import gt.md.C0799;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class layout2 extends Activity {
    private static final String DialogCreatedBy;
    public static String atx;
    private static final String lizalovv;

    /* renamed from: short */
    private static final short[] f19short;
    Context context;

    /* renamed from: androidx.preference.layout2$0 */
    /* loaded from: classes7.dex */
    public class AnonymousClass0 implements View.OnTouchListener {
        private final layout2$ this$0;
        private final Button val$button1;
        private final GradientDrawable val$button1Background;

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:47:0x007e A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0007 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public AnonymousClass0(androidx.preference.layout2$ r6, android.graphics.drawable.GradientDrawable r7, android.widget.Button r8) {
            /*
                r5 = this;
                r5.<init>()
                r2 = 0
                java.lang.String r0 = "ۣ۟ۤ"
            L7:
                int r1 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r4 = 1754471(0x1ac567, float:2.458538E-39)
                r1 = r1 ^ r4
                switch(r1) {
                    case 47: goto L13;
                    case 77: goto L78;
                    case 1798: goto L81;
                    case 3201: goto L35;
                    case 29551: goto L66;
                    case 31576: goto L24;
                    case 32609: goto L4b;
                    case 32612: goto L75;
                    case 32677: goto L5d;
                    default: goto L12;
                }
            L12:
                goto L7
            L13:
                r5.val$button1Background = r7
                int r0 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r0 < 0) goto L21
                androidx.preference.layout2.AnonymousClass5.m553()
                java.lang.String r0 = "ۣۤۡ"
                goto L7
            L21:
                java.lang.String r0 = "ۥۥ۟"
                goto L7
            L24:
                r5.val$button1 = r8
                int r0 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r0 > 0) goto L32
                androidx.preference.layout2.AnonymousClass6.m569()
                java.lang.String r0 = "ۨۨۦ"
                goto L7
            L32:
                java.lang.String r0 = "ۤۧۥ"
                goto L7
            L35:
                java.lang.String r0 = "cpHOQfmL14HBK8tMhnXVyUMkVH"
                java.lang.String r0 = androidx.preference.layout2.AnonymousClass8.m617(r0)
                long r2 = java.lang.Long.parseLong(r0)
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 < 0) goto L48
                java.lang.String r0 = "ۤۡ۠"
                goto L7
            L48:
                java.lang.String r0 = "ۣۤۡ"
                goto L7
            L4b:
                java.io.PrintStream r1 = java.lang.System.out
                r1.println(r2)
                int r1 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r1 < 0) goto L5a
                androidx.preference.layout2.AnonymousClass6.m569()
                goto L7
            L5a:
                java.lang.String r0 = "ۦۣۨ"
                goto L7
            L5d:
                int r1 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r1 < 0) goto L78
                java.lang.String r0 = "ۨۨۦ"
                goto L7
            L66:
                r5.this$0 = r6
                int r1 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r1 < 0) goto L72
                androidx.preference.layout2.AnonymousClass9.m639()
                goto L7
            L72:
                java.lang.String r0 = "ۧۡۢ"
                goto L7
            L75:
                java.lang.String r0 = "ۣ۟ۤ"
                goto L7
            L78:
                int r1 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r1 >= 0) goto L7
                java.lang.String r0 = "ۦۣۨ"
                goto L7
            L81:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass0.<init>(androidx.preference.layout2$, android.graphics.drawable.GradientDrawable, android.widget.Button):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0055 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0005 A[SYNTHETIC] */
        /* renamed from: ۥ۠۠ۦ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static android.widget.Button m508(java.lang.Object r6) {
            /*
                r2 = 0
                java.lang.String r0 = "ۢۥ۠"
                r1 = r2
                r3 = r2
            L5:
                int r4 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r5 = 1750749(0x1ab6dd, float:2.453322E-39)
                r4 = r4 ^ r5
                switch(r4) {
                    case 1056: goto L11;
                    case 3134: goto L4c;
                    case 3167: goto L67;
                    case 3257: goto L3b;
                    case 4540: goto L1d;
                    case 7609: goto L4f;
                    case 29468: goto L29;
                    case 32633: goto L1a;
                    case 32636: goto L58;
                    case 32723: goto L58;
                    case 1731138: goto L38;
                    default: goto L10;
                }
            L10:
                goto L5
            L11:
                int r4 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r4 >= 0) goto L4f
                java.lang.String r0 = "ۤۤۤ"
                goto L5
            L1a:
                java.lang.String r0 = "ۨۦ۟"
                goto L5
            L1d:
                int r1 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r1 < 0) goto L25
                r1 = r3
                goto L5
            L25:
                java.lang.String r0 = "ۤۥۣ"
                r1 = r3
                goto L5
            L29:
                int r1 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r1 < 0) goto L34
                androidx.preference.layout2.AnonymousClass5.m553()
                r1 = r2
                goto L5
            L34:
                java.lang.String r0 = "ۨۦۢ"
                r1 = r2
                goto L5
            L38:
                java.lang.String r0 = "ۧۥ۟"
                goto L5
            L3b:
                r0 = r6
                androidx.preference.layout2$0 r0 = (androidx.preference.layout2.AnonymousClass0) r0
                android.widget.Button r3 = r0.val$button1
                int r0 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r0 > 0) goto L49
                java.lang.String r0 = "ۤۤۤ"
                goto L5
            L49:
                java.lang.String r0 = "۟ۢۤ"
                goto L5
            L4c:
                java.lang.String r0 = "ۢۥ۠"
                goto L5
            L4f:
                int r4 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "ۥۤ"
                goto L5
            L58:
                int r0 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r0 > 0) goto L64
                androidx.preference.layout2.AnonymousClass9.m639()
                java.lang.String r0 = "ۤۧۥ"
                goto L5
            L64:
                java.lang.String r0 = "ۤۥۣ"
                goto L5
            L67:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass0.m508(java.lang.Object):android.widget.Button");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:47:0x008c A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0085 A[SYNTHETIC] */
        /* renamed from: ۧۢۥ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static android.graphics.drawable.GradientDrawable m509(java.lang.Object r6) {
            /*
                r2 = 0
                java.lang.String r0 = "ۣۢۢ"
                r1 = r2
                r3 = r2
            L5:
                int r4 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r5 = 1748708(0x1aaee4, float:2.450462E-39)
                r4 = r4 ^ r5
                switch(r4) {
                    case 324: goto L11;
                    case 4327: goto L70;
                    case 5126: goto L67;
                    case 7168: goto L2c;
                    case 7205: goto L49;
                    case 7331: goto L90;
                    case 26850: goto L7f;
                    case 27808: goto L1c;
                    case 27846: goto L58;
                    case 28480: goto L70;
                    case 1733346: goto L3d;
                    default: goto L10;
                }
            L10:
                goto L5
            L11:
                int r1 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r1 > 0) goto L28
                androidx.preference.layout2.AnonymousClass8.m616()
                r1 = r2
                goto L5
            L1c:
                int r0 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r0 > 0) goto L25
                java.lang.String r0 = "ۥۥ۟"
                goto L5
            L25:
                java.lang.String r0 = "ۦۢ۠"
                goto L5
            L28:
                java.lang.String r0 = "ۦۧۥ"
                r1 = r2
                goto L5
            L2c:
                r0 = r6
                androidx.preference.layout2$0 r0 = (androidx.preference.layout2.AnonymousClass0) r0
                android.graphics.drawable.GradientDrawable r3 = r0.val$button1Background
                int r0 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r0 < 0) goto L3a
                java.lang.String r0 = "ۣۧ۠"
                goto L5
            L3a:
                java.lang.String r0 = "۠ۦ"
                goto L5
            L3d:
                int r1 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r1 < 0) goto L45
                r1 = r3
                goto L5
            L45:
                java.lang.String r0 = "ۢ۟ۤ"
                r1 = r3
                goto L5
            L49:
                int r4 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r4 >= 0) goto L7f
                int r4 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r4 <= 0) goto L5
                java.lang.String r0 = "ۢۤۦ"
                goto L5
            L58:
                int r0 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r0 < 0) goto L64
                androidx.preference.layout2.AnonymousClass6.m569()
                java.lang.String r0 = "ۨۦ۟"
                goto L5
            L64:
                java.lang.String r0 = "ۡۨۧ"
                goto L5
            L67:
                int r4 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "ۣۢۢ"
                goto L5
            L70:
                int r0 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r0 < 0) goto L7c
                androidx.preference.layout2.AnonymousClass9.m639()
                java.lang.String r0 = "ۨۡۧ"
                goto L5
            L7c:
                java.lang.String r0 = "ۢ۟ۤ"
                goto L5
            L7f:
                int r0 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r0 < 0) goto L8c
                androidx.preference.layout2.AnonymousClass6.m569()
                java.lang.String r0 = "ۥۤ"
                goto L5
            L8c:
                java.lang.String r0 = "ۦۦۢ"
                goto L5
            L90:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass0.m509(java.lang.Object):android.graphics.drawable.GradientDrawable");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0077 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0006 A[SYNTHETIC] */
        /* renamed from: ۨۦۥ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static androidx.preference.layout2$ m510(java.lang.Object r6) {
            /*
                r3 = 0
                java.lang.String r0 = "ۦۡۦ"
                r1 = r0
                r2 = r3
                r4 = r3
            L6:
                int r0 = androidx.preference.layout2.AnonymousClass5.m528(r1)
                r5 = 1748735(0x1aaeff, float:2.4505E-39)
                r0 = r0 ^ r5
                switch(r0) {
                    case 352: goto L12;
                    case 446: goto L61;
                    case 1407: goto L4f;
                    case 1408: goto L7b;
                    case 2432: goto L8a;
                    case 2460: goto L71;
                    case 4195: goto L7b;
                    case 7649: goto L85;
                    case 26458: goto L2c;
                    case 26581: goto L3f;
                    case 28532: goto L1c;
                    default: goto L11;
                }
            L11:
                goto L6
            L12:
                int r0 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r0 < 0) goto L5d
                androidx.preference.layout2.AnonymousClass6.m569()
                goto L6
            L1c:
                int r0 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r0 > 0) goto L71
                int r0 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r0 >= 0) goto L6
                java.lang.String r0 = "ۨۦۣ"
                r1 = r0
                goto L6
            L2c:
                r0 = r6
                androidx.preference.layout2$0 r0 = (androidx.preference.layout2.AnonymousClass0) r0
                androidx.preference.layout2$ r4 = r0.this$0
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 < 0) goto L3b
                androidx.preference.layout2.AnonymousClass8.m616()
                goto L6
            L3b:
                java.lang.String r0 = "ۨۢۤ"
                r1 = r0
                goto L6
            L3f:
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 < 0) goto L4a
                androidx.preference.layout2.AnonymousClass9.m639()
                r2 = r4
                goto L6
            L4a:
                java.lang.String r0 = "ۣۣ۟"
                r1 = r0
                r2 = r4
                goto L6
            L4f:
                int r0 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r0 < 0) goto L59
                java.lang.String r0 = "ۦۦۢ"
                r1 = r0
                goto L6
            L59:
                java.lang.String r0 = "ۥۨ۟"
                r1 = r0
                goto L6
            L5d:
                java.lang.String r0 = "ۡۥۥ"
                r1 = r0
                goto L6
            L61:
                int r0 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r0 < 0) goto L6c
                androidx.preference.layout2.AnonymousClass7.m603()
                r2 = r3
                goto L6
            L6c:
                java.lang.String r0 = "۠ۥۥ"
                r1 = r0
                r2 = r3
                goto L6
            L71:
                int r0 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r0 >= 0) goto L6
                java.lang.String r0 = "ۡۨۦ"
                r1 = r0
                goto L6
            L7b:
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 >= 0) goto L6
                java.lang.String r0 = "ۣۣ۟"
                r1 = r0
                goto L6
            L85:
                java.lang.String r0 = "ۦۡۦ"
                r1 = r0
                goto L6
            L8a:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass0.m510(java.lang.Object):androidx.preference.layout2$");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000a. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:10:0x007b A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0078 A[SYNTHETIC] */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
            /*
                r3 = this;
                java.lang.String r0 = "ۨۧۨ"
            L2:
                int r1 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r2 = 1755468(0x1ac94c, float:2.459935E-39)
                r1 = r1 ^ r2
                switch(r1) {
                    case 133: goto Le;
                    case 3918: goto L7e;
                    case 25128: goto L88;
                    case 25293: goto L5a;
                    case 26159: goto L47;
                    case 26160: goto L88;
                    case 26515: goto L2f;
                    case 26536: goto L72;
                    case 30533: goto L3d;
                    case 30536: goto L4c;
                    case 32749: goto L49;
                    case 1709391: goto L17;
                    default: goto Ld;
                }
            Ld:
                goto L2
            Le:
                int r0 = androidx.preference.layout2.AnonymousClass5.m545(r5)
                if (r0 != 0) goto L72
                java.lang.String r0 = "۠ۥۦ"
                goto L2
            L17:
                android.widget.Button r1 = m508(r3)
                android.graphics.drawable.GradientDrawable r2 = m509(r3)
                androidx.preference.layout2.AnonymousClass6.m579(r1, r2)
                int r1 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r1 < 0) goto L2c
                androidx.preference.layout2.AnonymousClass6.m569()
                goto L2
            L2c:
                java.lang.String r0 = "ۣۤۢ"
                goto L2
            L2f:
                android.widget.Button r0 = m508(r3)
                android.graphics.drawable.GradientDrawable r1 = m509(r3)
                androidx.preference.layout2.AnonymousClass6.m579(r0, r1)
                java.lang.String r0 = "ۡۦۨ"
                goto L2
            L3d:
                int r0 = androidx.preference.layout2.AnonymousClass5.m545(r5)
                r1 = 1
                if (r0 != r1) goto L88
                java.lang.String r0 = "ۥۣۢ"
                goto L2
            L47:
                r0 = 0
                return r0
            L49:
                java.lang.String r0 = "ۡۧۢ"
                goto L2
            L4c:
                android.graphics.drawable.GradientDrawable r0 = m509(r3)
                int r1 = androidx.preference.layout2.AnonymousClass9.m635()
                androidx.preference.layout2.AnonymousClass5.m547(r0, r1)
                java.lang.String r0 = "ۣ۠"
                goto L2
            L5a:
                android.graphics.drawable.GradientDrawable r1 = m509(r3)
                int r2 = androidx.preference.layout2.AnonymousClass7.m614()
                androidx.preference.layout2.AnonymousClass5.m547(r1, r2)
                int r1 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r1 < 0) goto L6f
                androidx.preference.layout2.AnonymousClass7.m603()
                goto L2
            L6f:
                java.lang.String r0 = "ۡۢ۠"
                goto L2
            L72:
                int r0 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r0 > 0) goto L7b
                java.lang.String r0 = "ۣ۟ۤ"
                goto L2
            L7b:
                java.lang.String r0 = "ۥۣۧ"
                goto L2
            L7e:
                int r1 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r1 >= 0) goto L2
                java.lang.String r0 = "ۨۧۨ"
                goto L2
            L88:
                java.lang.String r0 = "ۡۦۨ"
                goto L2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass0.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    /* renamed from: androidx.preference.layout2$1 */
    /* loaded from: classes7.dex */
    public class AnonymousClass1 implements View.OnTouchListener {
        private final layout2$ this$0;
        private final Button val$button2;
        private final GradientDrawable val$button2Background;

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006c A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0068 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public AnonymousClass1(androidx.preference.layout2$ r5, android.graphics.drawable.GradientDrawable r6, android.widget.Button r7) {
            /*
                r4 = this;
                r4.<init>()
                r1 = 0
                java.lang.String r0 = "ۣ۠ۡ"
            L6:
                int r2 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r3 = 1749696(0x1ab2c0, float:2.451846E-39)
                r2 = r2 ^ r3
                switch(r2) {
                    case 67: goto L12;
                    case 1505: goto L1a;
                    case 3239: goto L23;
                    case 6654: goto L54;
                    case 6874: goto L6f;
                    case 7200: goto L43;
                    case 28807: goto L62;
                    case 31593: goto L2e;
                    case 1732253: goto L59;
                    default: goto L11;
                }
            L11:
                goto L6
            L12:
                java.io.PrintStream r0 = java.lang.System.out
                r0.println(r1)
                java.lang.String r0 = "ۣ۟ۨ"
                goto L6
            L1a:
                java.lang.String r0 = "RTwaoXm3c23wiltRcjYaKrYBy0MU"
                java.lang.String r1 = androidx.preference.layout2.AnonymousClass8.m617(r0)
                java.lang.String r0 = "ۢۡۢ"
                goto L6
            L23:
                r4.val$button2 = r7
                int r2 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r2 >= 0) goto L6
                java.lang.String r0 = "ۨۦۧ"
                goto L6
            L2e:
                int r2 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r2 < 0) goto L62
                int r0 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r0 > 0) goto L40
                androidx.preference.layout2.AnonymousClass6.m569()
                java.lang.String r0 = "ۨۢۤ"
                goto L6
            L40:
                java.lang.String r0 = "ۣۨۦ"
                goto L6
            L43:
                r4.val$button2Background = r6
                int r0 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r0 < 0) goto L51
                androidx.preference.layout2.AnonymousClass8.m616()
                java.lang.String r0 = "ۥۨ۟"
                goto L6
            L51:
                java.lang.String r0 = "ۥۦۨ"
                goto L6
            L54:
                r4.this$0 = r5
                java.lang.String r0 = "ۡۢۡ"
                goto L6
            L59:
                int r2 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r2 >= 0) goto L6
                java.lang.String r0 = "ۣ۠ۡ"
                goto L6
            L62:
                int r2 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r2 < 0) goto L6c
                androidx.preference.layout2.AnonymousClass6.m569()
                goto L6
            L6c:
                java.lang.String r0 = "ۣ۟ۨ"
                goto L6
            L6f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass1.<init>(androidx.preference.layout2$, android.graphics.drawable.GradientDrawable, android.widget.Button):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        /* renamed from: ۟۟ۧۥۧ */
        public static layout2$ m511(Object obj) {
            String str = "۠ۥۧ";
            layout2$ layout2_ = null;
            layout2$ layout2_2 = null;
            while (true) {
                switch (AnonymousClass5.m528(str) ^ 1750593) {
                    case 2952:
                        break;
                    case 3973:
                        str = AnonymousClass7.m603() >= 0 ? "ۢۤۦ" : "۟ۨ۟";
                    case 4387:
                        str = "ۥۡۥ";
                        layout2_ = layout2_2;
                    case 6431:
                    case 6432:
                        if (AnonymousClass6.m569() >= 0) {
                            AnonymousClass9.m639();
                        } else {
                            str = "ۥۡۥ";
                        }
                    case 7328:
                        str = "ۡۦۦ";
                    case 7619:
                        str = AnonymousClass6.m569() < 0 ? "۟ۨۥ" : "ۤ۟۟";
                    case 7767:
                        if (AnonymousClass9.m639() <= 0) {
                            layout2_ = null;
                        } else {
                            str = "۠۠ۡ";
                            layout2_ = null;
                        }
                    case 7773:
                        layout2_2 = ((AnonymousClass1) obj).this$0;
                        if (AnonymousClass6.m569() < 0) {
                            str = "۟ۢۥ";
                        }
                    case 32744:
                        if (AnonymousClass9.m639() <= 0) {
                            AnonymousClass5.m553();
                        } else {
                            str = "۠ۥۧ";
                        }
                    case 1731225:
                }
                return layout2_;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0074 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0005 A[SYNTHETIC] */
        /* renamed from: ۣ۟ۢۤۧ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static android.widget.Button m512(java.lang.Object r6) {
            /*
                r2 = 0
                java.lang.String r0 = "ۥۣۡ"
                r1 = r2
                r3 = r2
            L5:
                int r4 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r5 = 1748857(0x1aaf79, float:2.45067E-39)
                r4 = r4 ^ r5
                switch(r4) {
                    case 1273: goto L11;
                    case 2106: goto L23;
                    case 2141: goto L37;
                    case 2209: goto L80;
                    case 4474: goto L4f;
                    case 6406: goto L77;
                    case 6630: goto L62;
                    case 26226: goto L11;
                    case 27223: goto L6e;
                    case 28006: goto L43;
                    case 1733380: goto L14;
                    default: goto L10;
                }
            L10:
                goto L5
            L11:
                java.lang.String r0 = "۟ۦ۟"
                goto L5
            L14:
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 < 0) goto L20
                androidx.preference.layout2.AnonymousClass9.m639()
                java.lang.String r0 = "ۤ۟۟"
                goto L5
            L20:
                java.lang.String r0 = "ۨۡۤ"
                goto L5
            L23:
                r0 = r6
                androidx.preference.layout2$1 r0 = (androidx.preference.layout2.AnonymousClass1) r0
                android.widget.Button r3 = r0.val$button2
                int r0 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r0 > 0) goto L34
                androidx.preference.layout2.AnonymousClass6.m569()
                java.lang.String r0 = "۟ۡۥ"
                goto L5
            L34:
                java.lang.String r0 = "ۦۦ۟"
                goto L5
            L37:
                int r0 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r0 > 0) goto L40
                java.lang.String r0 = "ۧ۟"
                goto L5
            L40:
                java.lang.String r0 = "ۣۤ۠"
                goto L5
            L43:
                int r1 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r1 < 0) goto L4b
                r1 = r3
                goto L5
            L4b:
                java.lang.String r0 = "۟ۦ۟"
                r1 = r3
                goto L5
            L4f:
                int r4 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r4 > 0) goto L6e
                int r4 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r4 < 0) goto L5f
                androidx.preference.layout2.AnonymousClass5.m553()
                goto L5
            L5f:
                java.lang.String r0 = "۟ۡۥ"
                goto L5
            L62:
                int r1 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r1 < 0) goto L6a
                r1 = r2
                goto L5
            L6a:
                java.lang.String r0 = "ۤۡ"
                r1 = r2
                goto L5
            L6e:
                int r4 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "۟۠ۥ"
                goto L5
            L77:
                int r4 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "ۥۣۡ"
                goto L5
            L80:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass1.m512(java.lang.Object):android.widget.Button");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0061 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x005b A[SYNTHETIC] */
        /* renamed from: ۢ۟ۢ۠ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static android.graphics.drawable.GradientDrawable m513(java.lang.Object r6) {
            /*
                r2 = 0
                java.lang.String r0 = "ۨۡ۟"
                r1 = r2
                r3 = r2
            L5:
                int r4 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r5 = 56294(0xdbe6, float:7.8885E-41)
                r4 = r4 ^ r5
                switch(r4) {
                    case 1954: goto L11;
                    case 1708768: goto L2e;
                    case 1710723: goto L37;
                    case 1711616: goto L55;
                    case 1711653: goto L6d;
                    case 1711779: goto L6d;
                    case 1728772: goto L48;
                    case 1729976: goto L1a;
                    case 1730050: goto L7a;
                    case 1730147: goto L64;
                    case 1730724: goto L22;
                    default: goto L10;
                }
            L10:
                goto L5
            L11:
                int r4 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "ۦ۠۟"
                goto L5
            L1a:
                r0 = r6
                androidx.preference.layout2$1 r0 = (androidx.preference.layout2.AnonymousClass1) r0
                android.graphics.drawable.GradientDrawable r3 = r0.val$button2Background
                java.lang.String r0 = "ۢۧۧ"
                goto L5
            L22:
                int r1 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r1 < 0) goto L2a
                r1 = r3
                goto L5
            L2a:
                java.lang.String r0 = "ۥۢۡ"
                r1 = r3
                goto L5
            L2e:
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 > 0) goto L55
                java.lang.String r0 = "ۥۦ۟"
                goto L5
            L37:
                int r0 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r0 < 0) goto L44
                androidx.preference.layout2.AnonymousClass5.m553()
                java.lang.String r0 = "ۢۧۧ"
                r1 = r2
                goto L5
            L44:
                java.lang.String r0 = "ۤۨۦ"
                r1 = r2
                goto L5
            L48:
                int r4 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r4 < 0) goto L52
                androidx.preference.layout2.AnonymousClass7.m603()
                goto L5
            L52:
                java.lang.String r0 = "ۧۡ۟"
                goto L5
            L55:
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 < 0) goto L61
                androidx.preference.layout2.AnonymousClass6.m569()
                java.lang.String r0 = "ۢۦۢ"
                goto L5
            L61:
                java.lang.String r0 = "ۢۦ"
                goto L5
            L64:
                int r4 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "ۨۡ۟"
                goto L5
            L6d:
                int r4 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r4 < 0) goto L77
                androidx.preference.layout2.AnonymousClass8.m616()
                goto L5
            L77:
                java.lang.String r0 = "ۥۢۡ"
                goto L5
            L7a:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass1.m513(java.lang.Object):android.graphics.drawable.GradientDrawable");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000a. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:47:0x008a A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0083 A[SYNTHETIC] */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
            /*
                r3 = this;
                java.lang.String r0 = "ۥۥ۟"
            L2:
                int r1 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r2 = 56417(0xdc61, float:7.9057E-41)
                r1 = r1 ^ r2
                switch(r1) {
                    case 251: goto Le;
                    case 353: goto L10;
                    case 1709325: goto L9f;
                    case 1709547: goto L1e;
                    case 1710343: goto L2b;
                    case 1729001: goto L43;
                    case 1729118: goto L5d;
                    case 1729931: goto L8e;
                    case 1732321: goto L7d;
                    case 1732444: goto L39;
                    case 1733344: goto L9f;
                    case 1735583: goto L66;
                    default: goto Ld;
                }
            Ld:
                goto L2
            Le:
                r0 = 0
                return r0
            L10:
                android.graphics.drawable.GradientDrawable r0 = m513(r3)
                int r1 = androidx.preference.layout2.AnonymousClass7.m606()
                androidx.preference.layout2.AnonymousClass5.m547(r0, r1)
                java.lang.String r0 = "ۥ۟ۢ"
                goto L2
            L1e:
                int r1 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r1 < 0) goto L28
                androidx.preference.layout2.AnonymousClass7.m603()
                goto L2
            L28:
                java.lang.String r0 = "ۡ۟۟"
                goto L2
            L2b:
                android.widget.Button r0 = m512(r3)
                android.graphics.drawable.GradientDrawable r1 = m513(r3)
                androidx.preference.layout2.AnonymousClass6.m579(r0, r1)
                java.lang.String r0 = "ۨۥۧ"
                goto L2
            L39:
                int r0 = androidx.preference.layout2.AnonymousClass5.m545(r5)
                r1 = 1
                if (r0 != r1) goto L9f
                java.lang.String r0 = "۟ۧۦ"
                goto L2
            L43:
                android.widget.Button r0 = m512(r3)
                android.graphics.drawable.GradientDrawable r1 = m513(r3)
                androidx.preference.layout2.AnonymousClass6.m579(r0, r1)
                int r0 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r0 > 0) goto L5a
                androidx.preference.layout2.AnonymousClass7.m603()
                java.lang.String r0 = "ۡۦۦ"
                goto L2
            L5a:
                java.lang.String r0 = "ۥ۟"
                goto L2
            L5d:
                int r0 = androidx.preference.layout2.AnonymousClass5.m545(r5)
                if (r0 != 0) goto L7d
                java.lang.String r0 = "ۨۨ"
                goto L2
            L66:
                android.graphics.drawable.GradientDrawable r0 = m513(r3)
                int r1 = androidx.preference.layout2.AnonymousClass7.m614()
                androidx.preference.layout2.AnonymousClass5.m547(r0, r1)
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 < 0) goto L7a
                java.lang.String r0 = "ۧۢۡ"
                goto L2
            L7a:
                java.lang.String r0 = "ۧۢۡ"
                goto L2
            L7d:
                int r0 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r0 < 0) goto L8a
                androidx.preference.layout2.AnonymousClass7.m603()
                java.lang.String r0 = "ۨۨۦ"
                goto L2
            L8a:
                java.lang.String r0 = "ۢۧۢ"
                goto L2
            L8e:
                int r0 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r0 < 0) goto L9b
                androidx.preference.layout2.AnonymousClass8.m616()
                java.lang.String r0 = "ۧۦۥ"
                goto L2
            L9b:
                java.lang.String r0 = "ۥۥ۟"
                goto L2
            L9f:
                java.lang.String r0 = "ۥ۟"
                goto L2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass1.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    /* renamed from: androidx.preference.layout2$2 */
    /* loaded from: classes7.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        private final layout2$ this$0;
        private final Dialog val$dialog;

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0006 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0018 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public AnonymousClass2(androidx.preference.layout2$ r5, android.app.Dialog r6) {
            /*
                r4 = this;
                r4.<init>()
                r1 = 0
                java.lang.String r0 = "ۦ۠۠"
            L6:
                int r2 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r3 = 1749758(0x1ab2fe, float:2.451933E-39)
                r2 = r2 ^ r3
                switch(r2) {
                    case 93: goto L12;
                    case 152: goto L4e;
                    case 1082: goto L1b;
                    case 6533: goto L64;
                    case 29592: goto L26;
                    case 31279: goto L34;
                    case 31510: goto L67;
                    case 1732096: goto L45;
                    default: goto L11;
                }
            L11:
                goto L6
            L12:
                int r2 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r2 >= 0) goto L6
                java.lang.String r0 = "ۨۨۨ"
                goto L6
            L1b:
                r4.val$dialog = r6
                int r2 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r2 >= 0) goto L6
                java.lang.String r0 = "ۨۦ"
                goto L6
            L26:
                r4.this$0 = r5
                int r0 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r0 < 0) goto L31
                java.lang.String r0 = "ۥۡۥ"
                goto L6
            L31:
                java.lang.String r0 = "ۣۥۦ"
                goto L6
            L34:
                java.io.PrintStream r0 = java.lang.System.out
                r0.println(r1)
                int r0 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r0 > 0) goto L42
                java.lang.String r0 = "ۨۨۦ"
                goto L6
            L42:
                java.lang.String r0 = "ۨۨۨ"
                goto L6
            L45:
                int r2 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r2 < 0) goto L12
                java.lang.String r0 = "ۢ۠ۤ"
                goto L6
            L4e:
                java.lang.String r0 = "jLfBaohkYqCcwjaK"
                java.lang.String r0 = androidx.preference.layout2.AnonymousClass6.m576(r0)
                java.lang.Integer r1 = java.lang.Integer.decode(r0)
                int r0 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r0 < 0) goto L61
                java.lang.String r0 = "ۥۥ۟"
                goto L6
            L61:
                java.lang.String r0 = "ۨ۟ۨ"
                goto L6
            L64:
                java.lang.String r0 = "ۦ۠۠"
                goto L6
            L67:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass2.<init>(androidx.preference.layout2$, android.app.Dialog):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        /* renamed from: ۟ۦۢۥۨ */
        public static layout2$ m514(Object obj) {
            String str = "ۧۧۢ";
            layout2$ layout2_ = null;
            layout2$ layout2_2 = null;
            while (true) {
                switch (AnonymousClass5.m528(str) ^ 1748797) {
                    case 3:
                    case 6530:
                        if (AnonymousClass9.m639() <= 0) {
                            AnonymousClass8.m616();
                        } else {
                            str = "ۣۧۥ";
                        }
                    case 71:
                        if (AnonymousClass6.m569() >= 0) {
                            AnonymousClass6.m569();
                            layout2_ = null;
                        } else {
                            str = "ۡۨۨ";
                            layout2_ = null;
                        }
                    case 92:
                    case 156:
                        if (AnonymousClass8.m616() >= 0) {
                            AnonymousClass7.m603();
                            str = "ۡۨۧ";
                        } else {
                            str = "ۣۥۡ";
                        }
                    case 5433:
                        layout2_2 = ((AnonymousClass2) obj).this$0;
                        if (AnonymousClass8.m616() >= 0) {
                            AnonymousClass5.m553();
                        } else {
                            str = "ۢۥۧ";
                        }
                    case 5465:
                        if (AnonymousClass7.m603() < 0) {
                            str = "ۡۧ۠";
                        }
                    case 7225:
                        if (AnonymousClass5.m553() >= 0) {
                            layout2_ = layout2_2;
                        } else {
                            str = "ۣۧۥ";
                            layout2_ = layout2_2;
                        }
                    case 7618:
                        if (AnonymousClass6.m569() >= 0) {
                            AnonymousClass5.m553();
                        } else {
                            str = "ۧۧۢ";
                        }
                    case 26943:
                        str = AnonymousClass7.m603() <= 0 ? "ۤۡۡ" : "ۤۤۤ";
                    case 27316:
                        break;
                }
                return layout2_;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0081 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0006 A[SYNTHETIC] */
        /* renamed from: ۢۤۧ۟ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static android.app.Dialog m515(java.lang.Object r6) {
            /*
                r3 = 0
                java.lang.String r0 = "ۨۨ۠"
                r1 = r0
                r2 = r3
                r4 = r3
            L6:
                int r0 = androidx.preference.layout2.AnonymousClass5.m528(r1)
                r5 = 1750567(0x1ab627, float:2.453067E-39)
                r0 = r0 ^ r5
                switch(r0) {
                    case 2211: goto L12;
                    case 3118: goto L43;
                    case 4384: goto L5f;
                    case 4391: goto L85;
                    case 6521: goto L77;
                    case 30636: goto L69;
                    case 32494: goto L1c;
                    case 32609: goto L69;
                    case 32676: goto L50;
                    case 32704: goto L7b;
                    case 32711: goto L2c;
                    default: goto L11;
                }
            L11:
                goto L6
            L12:
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 >= 0) goto L6
                java.lang.String r0 = "ۣۨۡ"
                r1 = r0
                goto L6
            L1c:
                int r0 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r0 < 0) goto L27
                androidx.preference.layout2.AnonymousClass6.m569()
                r2 = r4
                goto L6
            L27:
                java.lang.String r0 = "۟۟۠"
                r1 = r0
                r2 = r4
                goto L6
            L2c:
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 > 0) goto L7b
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 < 0) goto L3f
                androidx.preference.layout2.AnonymousClass5.m553()
                java.lang.String r0 = "۟ۢۤ"
                r1 = r0
                goto L6
            L3f:
                java.lang.String r0 = "ۨۥ۠"
                r1 = r0
                goto L6
            L43:
                int r0 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r0 < 0) goto L4b
                r2 = r3
                goto L6
            L4b:
                java.lang.String r0 = "ۥۧۦ"
                r1 = r0
                r2 = r3
                goto L6
            L50:
                r0 = r6
                androidx.preference.layout2$2 r0 = (androidx.preference.layout2.AnonymousClass2) r0
                android.app.Dialog r4 = r0.val$dialog
                int r0 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r0 >= 0) goto L6
                java.lang.String r0 = "ۨ۟۠"
                r1 = r0
                goto L6
            L5f:
                int r0 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r0 <= 0) goto L6
                java.lang.String r0 = "ۤۡۦ"
                r1 = r0
                goto L6
            L69:
                int r0 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r0 < 0) goto L73
                java.lang.String r0 = "ۧۧۢ"
                r1 = r0
                goto L6
            L73:
                java.lang.String r0 = "۟۟۠"
                r1 = r0
                goto L6
            L77:
                java.lang.String r0 = "ۨۨ۠"
                r1 = r0
                goto L6
            L7b:
                int r0 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r0 >= 0) goto L6
                java.lang.String r0 = "۟۟ۧ"
                r1 = r0
                goto L6
            L85:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass2.m515(java.lang.Object):android.app.Dialog");
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0025, code lost:
        
            return;
         */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onClick(android.view.View r4) {
            /*
                r3 = this;
                java.lang.String r0 = "ۦ۟۠"
            L2:
                int r1 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r2 = 1748735(0x1aaeff, float:2.4505E-39)
                r1 = r1 ^ r2
                switch(r1) {
                    case 57: goto Le;
                    case 5209: goto L25;
                    case 28600: goto L18;
                    default: goto Ld;
                }
            Ld:
                goto L2
            Le:
                int r1 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r1 > 0) goto L22
                androidx.preference.layout2.AnonymousClass5.m553()
                goto L2
            L18:
                android.app.Dialog r0 = m515(r3)
                androidx.preference.layout2.AnonymousClass6.m572(r0)
                java.lang.String r0 = "ۤۦۨ"
                goto L2
            L22:
                java.lang.String r0 = "ۦ۟۠"
                goto L2
            L25:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass2.onClick(android.view.View):void");
        }
    }

    /* renamed from: androidx.preference.layout2$3 */
    /* loaded from: classes7.dex */
    public class AnonymousClass3 implements View.OnClickListener {

        /* renamed from: short */
        private static final short[] f21short = {656, 671, 661, 643, 670, 664, 661, 735, 664, 671, 645, 660, 671, 645, 735, 656, 658, 645, 664, 670, 671, 735, 679, 696, 692, 678};
        private final layout2$ this$0;
        private final String val$downloadLink;

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        public AnonymousClass3(layout2$ layout2_, String str) {
            Double d11 = null;
            String str2 = "۠ۧۢ";
            while (true) {
                switch (AnonymousClass5.m528((Object) str2) ^ 1749700) {
                    case 2049:
                        System.out.println(d11);
                        str2 = "ۨۨۡ";
                    case 2240:
                    case 3945:
                        str2 = AnonymousClass9.m639() <= 0 ? "ۧ۠ۤ" : "ۨۨۡ";
                    case 6527:
                        this.this$0 = layout2_;
                        if (AnonymousClass5.m553() < 0) {
                            str2 = "ۦۥ۠";
                        }
                    case 28869:
                        this.val$downloadLink = str;
                        str2 = AnonymousClass6.m569() >= 0 ? "ۨۨۡ" : "ۥ۠ۨ";
                    case 28896:
                        str2 = AnonymousClass7.m603() >= 0 ? "ۥۣۢ" : "۠ۧۢ";
                    case 30703:
                        d11 = Double.decode(AnonymousClass7.m598("wc6IIUnrhcRCft02p"));
                        if (AnonymousClass7.m603() >= 0) {
                            AnonymousClass5.m553();
                            str2 = "ۡۧ۠";
                        } else {
                            str2 = "ۤۧۨ";
                        }
                    case 31525:
                        break;
                }
                return;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
        /* renamed from: ۟ۦ۟۠ۦ */
        public static String m516(Object obj) {
            String str = "ۢۥۨ";
            String str2 = null;
            String str3 = null;
            while (true) {
                switch (AnonymousClass5.m528((Object) str) ^ 1750787) {
                    case 1030:
                        str = AnonymousClass6.m569() <= 0 ? "ۧۥۢ" : "ۧ۠ۤ";
                    case 1476:
                    case 2372:
                        if (AnonymousClass7.m603() < 0) {
                            str = "ۨۤۦ";
                        }
                    case 6149:
                        str = "ۢۥۨ";
                    case 29224:
                        if (AnonymousClass5.m553() >= 0) {
                            AnonymousClass5.m553();
                        } else {
                            str = "ۤ۟";
                        }
                    case 29383:
                        str3 = ((AnonymousClass3) obj).val$downloadLink;
                        str = AnonymousClass9.m639() <= 0 ? "ۧ۟" : "ۣۨ";
                    case 30044:
                    case 32361:
                        break;
                    case 1731425:
                        str = "ۥۥۧ";
                    case 1731430:
                        if (AnonymousClass7.m603() >= 0) {
                            AnonymousClass9.m639();
                            str2 = str3;
                        } else {
                            str = "ۨۤۦ";
                            str2 = str3;
                        }
                    case 1731448:
                        if (AnonymousClass9.m639() <= 0) {
                            AnonymousClass8.m616();
                            str2 = null;
                        } else {
                            str = "ۣۥ";
                            str2 = null;
                        }
                }
                return str2;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0082 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0005 A[SYNTHETIC] */
        /* renamed from: ۢ۟ۦۡ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static android.content.Context m517(java.lang.Object r6) {
            /*
                r2 = 0
                java.lang.String r0 = "ۣۧۢ"
                r1 = r2
                r3 = r2
            L5:
                int r4 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r5 = 1754472(0x1ac568, float:2.458539E-39)
                r4 = r4 ^ r5
                switch(r4) {
                    case 79: goto L11;
                    case 238: goto L3d;
                    case 1261: goto L5e;
                    case 25238: goto L4f;
                    case 25303: goto L46;
                    case 27566: goto L30;
                    case 30325: goto L6d;
                    case 30880: goto L85;
                    case 31873: goto L11;
                    case 32724: goto L7c;
                    case 1710517: goto L1a;
                    default: goto L10;
                }
            L10:
                goto L5
            L11:
                int r4 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r4 <= 0) goto L5
                java.lang.String r0 = "ۥۡۤ"
                goto L5
            L1a:
                r0 = r6
                androidx.preference.layout2$ r0 = (androidx.preference.layout2$) r0
                android.content.Context r3 = androidx.preference.layout2$.access$L1000003(r0)
                int r0 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r0 < 0) goto L2d
                androidx.preference.layout2.AnonymousClass9.m639()
                java.lang.String r0 = "ۧۦۥ"
                goto L5
            L2d:
                java.lang.String r0 = "۟ۧۦ"
                goto L5
            L30:
                int r4 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r4 < 0) goto L3a
                androidx.preference.layout2.AnonymousClass8.m616()
                goto L5
            L3a:
                java.lang.String r0 = "ۦۡ۠"
                goto L5
            L3d:
                int r4 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r4 > 0) goto L7c
                java.lang.String r0 = "ۧۤ"
                goto L5
            L46:
                int r4 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "ۤ۠ۥ"
                goto L5
            L4f:
                int r1 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r1 < 0) goto L5a
                androidx.preference.layout2.AnonymousClass6.m569()
                r1 = r3
                goto L5
            L5a:
                java.lang.String r0 = "ۥۡۤ"
                r1 = r3
                goto L5
            L5e:
                int r1 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r1 > 0) goto L69
                androidx.preference.layout2.AnonymousClass6.m569()
                r1 = r2
                goto L5
            L69:
                java.lang.String r0 = "۟ۥۥ"
                r1 = r2
                goto L5
            L6d:
                int r0 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r0 < 0) goto L79
                androidx.preference.layout2.AnonymousClass7.m603()
                java.lang.String r0 = "ۦ۠۠"
                goto L5
            L79:
                java.lang.String r0 = "ۣۧۢ"
                goto L5
            L7c:
                int r4 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "ۡۡۦ"
                goto L5
            L85:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass3.m517(java.lang.Object):android.content.Context");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0017 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x005f A[SYNTHETIC] */
        /* renamed from: ۥۨۢۡ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static androidx.preference.layout2$ m518(java.lang.Object r6) {
            /*
                r2 = 0
                java.lang.String r0 = "ۦۦۧ"
                r1 = r2
                r3 = r2
            L5:
                int r4 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r5 = 56296(0xdbe8, float:7.8887E-41)
                r4 = r4 ^ r5
                switch(r4) {
                    case 1906: goto L11;
                    case 1933: goto L62;
                    case 2007: goto L6b;
                    case 1708587: goto L1e;
                    case 1708684: goto L2a;
                    case 1710543: goto L33;
                    case 1710568: goto L4e;
                    case 1711725: goto L45;
                    case 1728974: goto L56;
                    case 1731826: goto L56;
                    case 1731881: goto L1a;
                    default: goto L10;
                }
            L10:
                goto L5
            L11:
                int r0 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r0 < 0) goto L5f
                java.lang.String r0 = "ۤۡ"
                goto L5
            L1a:
                java.lang.String r0 = "ۢۡ"
                r1 = r3
                goto L5
            L1e:
                int r1 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r1 < 0) goto L26
                r1 = r2
                goto L5
            L26:
                java.lang.String r0 = "ۨۤ۠"
                r1 = r2
                goto L5
            L2a:
                int r4 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "ۤۢۤ"
                goto L5
            L33:
                int r0 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r0 >= 0) goto L11
                int r0 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r0 < 0) goto L42
                java.lang.String r0 = "ۦۣۨ"
                goto L5
            L42:
                java.lang.String r0 = "ۦۥ۟"
                goto L5
            L45:
                int r4 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "ۨۧۢ"
                goto L5
            L4e:
                r0 = r6
                androidx.preference.layout2$3 r0 = (androidx.preference.layout2.AnonymousClass3) r0
                androidx.preference.layout2$ r3 = r0.this$0
                java.lang.String r0 = "ۣۥۣ"
                goto L5
            L56:
                int r4 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "ۢۡ"
                goto L5
            L5f:
                java.lang.String r0 = "ۣۧۡ"
                goto L5
            L62:
                int r4 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "ۦۦۧ"
                goto L5
            L6b:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass3.m518(java.lang.Object):androidx.preference.layout2$");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0005 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0017 A[SYNTHETIC] */
        /* renamed from: ۧۨۢ۠ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static short[] m519() {
            /*
                r2 = 0
                java.lang.String r0 = "ۥۥۦ"
                r1 = r2
                r3 = r2
            L5:
                int r4 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r5 = 1747932(0x1aabdc, float:2.449374E-39)
                r4 = r4 ^ r5
                switch(r4) {
                    case 1219: goto L11;
                    case 1336: goto L48;
                    case 3171: goto L2a;
                    case 3230: goto L66;
                    case 4477: goto L27;
                    case 5530: goto L35;
                    case 27314: goto L4c;
                    case 28240: goto L1a;
                    case 28315: goto L59;
                    case 28342: goto L44;
                    case 1734502: goto L4c;
                    default: goto L10;
                }
            L10:
                goto L5
            L11:
                int r4 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "ۣۧۨ"
                goto L5
            L1a:
                int r4 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r4 < 0) goto L24
                androidx.preference.layout2.AnonymousClass5.m553()
                goto L5
            L24:
                java.lang.String r0 = "ۡۢۥ"
                goto L5
            L27:
                java.lang.String r0 = "ۦ۠"
                goto L5
            L2a:
                short[] r3 = androidx.preference.layout2.AnonymousClass3.f21short
                int r4 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r4 <= 0) goto L5
                java.lang.String r0 = "ۧۢۥ"
                goto L5
            L35:
                int r4 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r4 >= 0) goto L11
                int r4 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "۟ۥۥ"
                goto L5
            L44:
                java.lang.String r0 = "۟ۡۤ"
                r1 = r3
                goto L5
            L48:
                java.lang.String r0 = "ۤۦۣ"
                r1 = r2
                goto L5
            L4c:
                int r4 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r4 < 0) goto L56
                androidx.preference.layout2.AnonymousClass7.m603()
                goto L5
            L56:
                java.lang.String r0 = "۟ۡۤ"
                goto L5
            L59:
                int r4 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r4 < 0) goto L63
                androidx.preference.layout2.AnonymousClass6.m569()
                goto L5
            L63:
                java.lang.String r0 = "ۥۥۦ"
                goto L5
            L66:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass3.m519():short[]");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0013. Please report as an issue. */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Long l11 = null;
            String str = "۟ۢ۟";
            Intent intent = null;
            int i11 = 0;
            int i12 = 0;
            short[] sArr = null;
            String str2 = null;
            Object[] objArr = null;
            while (true) {
                switch (AnonymousClass5.m528((Object) str) ^ 1752740) {
                    case 194:
                        l11 = Long.decode(AnonymousClass8.m617("7STaYChQLW"));
                        str = AnonymousClass7.m603() >= 0 ? "ۤ۠ۦ" : "ۤۨ۟";
                    case 844:
                        str = AnonymousClass9.m639() <= 0 ? AnonymousClass7.m603() >= 0 ? "ۣۨ۟" : "ۥۦۧ" : "ۦ۠ۥ";
                    case 1151:
                        System.out.println(l11);
                        str = "ۦ۠ۥ";
                    case 3073:
                        objArr[0] = new Integer(7151036);
                        if (AnonymousClass8.m616() >= 0) {
                            AnonymousClass8.m616();
                        } else {
                            str = "ۦۣ";
                        }
                    case 3078:
                        if (AnonymousClass5.m553() < 0) {
                            str = "ۢ۠ۥ";
                        }
                    case 3194:
                        i11 = ((Integer) objArr[1]).intValue();
                        if (AnonymousClass9.m639() <= 0) {
                            AnonymousClass7.m603();
                            str = "ۢۦ";
                        } else {
                            str = "۟ۨۦ";
                        }
                    case 3195:
                        i12 = ((Integer) objArr[0]).intValue();
                        if (AnonymousClass8.m616() >= 0) {
                            AnonymousClass6.m569();
                            str = "ۡۨۦ";
                        } else {
                            str = "ۢۤ۠";
                        }
                    case 3267:
                        str = "ۣۨۧ";
                    case 4142:
                        sArr = m519();
                        str = "ۢۤۡ";
                    case 5817:
                        intent = new Intent(AnonymousClass9.m633(sArr, 0, ((i11 ^ (-1)) & 2157593) | ((-2157594) & i11), ((i12 ^ (-1)) & 7151437) | ((-7151438) & i12)));
                        if (AnonymousClass7.m603() >= 0) {
                            AnonymousClass9.m639();
                        } else {
                            str = "ۣ۟ۤ";
                        }
                    case 6458:
                        AnonymousClass6.m563(intent, AnonymousClass7.m596(str2));
                        str = "۟ۦ۠";
                    case 6525:
                        AnonymousClass5.m557(m517(m518(this)), intent);
                        if (AnonymousClass6.m569() < 0) {
                            str = "ۥۢۥ";
                        }
                    case 6648:
                        objArr = new Object[2];
                        str = "ۢۢۥ";
                    case 30560:
                        str2 = m516(this);
                        if (AnonymousClass6.m569() < 0) {
                            str = "ۡ۟ۨ";
                        }
                    case 31489:
                    case 32719:
                        break;
                    case 1729049:
                        objArr[1] = new Integer(2157571);
                        str = "ۢۢۢ";
                    case 1729092:
                        if (AnonymousClass8.m616() >= 0) {
                            AnonymousClass8.m616();
                            str = "ۥۥۦ";
                        } else {
                            str = "۟ۢ۟";
                        }
                }
                return;
            }
        }
    }

    /* renamed from: androidx.preference.layout2$4 */
    /* loaded from: classes7.dex */
    public static class AnonymousClass4 {
        private String changeLogMessage;
        private String changelogTitle;
        private String downloadLink;
        private String message;
        private String negativebtn;
        private String positivebtn;
        private String title;
        private String version;

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        public AnonymousClass4() {
            String str = null;
            String str2 = "۟ۧۡ";
            while (true) {
                switch (AnonymousClass5.m528((Object) str2) ^ 1754535) {
                    case 43:
                        if (AnonymousClass5.m553() >= 0) {
                            AnonymousClass7.m603();
                        } else {
                            str2 = "۟ۧۡ";
                        }
                    case 3400:
                        break;
                    case 3447:
                        str = AnonymousClass8.m617("RzXlLokMGQ0nyq");
                        str2 = "ۢۥۥ";
                    case 25182:
                        if (AnonymousClass8.m616() < 0) {
                            str2 = "ۨ۠ۧ";
                        } else if (AnonymousClass9.m639() <= 0) {
                            AnonymousClass6.m569();
                        } else {
                            str2 = "ۨ۟ۧ";
                        }
                    case 29665:
                        str2 = "ۨ۠ۧ";
                    case 30373:
                        System.out.println(str);
                        str2 = "ۨ۠ۧ";
                }
                return;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0052 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004e A[SYNTHETIC] */
        /* renamed from: ۟۟ۨۨ۠ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.String m520(java.lang.Object r6) {
            /*
                r2 = 0
                java.lang.String r0 = "ۢ۠ۧ"
                r1 = r2
                r3 = r2
            L5:
                int r4 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r5 = 1748863(0x1aaf7f, float:2.450679E-39)
                r4 = r4 ^ r5
                switch(r4) {
                    case 2106: goto L11;
                    case 4441: goto L26;
                    case 4791: goto L22;
                    case 6424: goto L33;
                    case 6454: goto L2f;
                    case 7291: goto L55;
                    case 7446: goto L19;
                    case 26232: goto L48;
                    case 26265: goto L55;
                    case 28177: goto L3c;
                    case 28183: goto L58;
                    default: goto L10;
                }
            L10:
                goto L5
            L11:
                r0 = r6
                androidx.preference.layout2$4 r0 = (androidx.preference.layout2.AnonymousClass4) r0
                java.lang.String r3 = r0.changeLogMessage
                java.lang.String r0 = "ۣۡۧ"
                goto L5
            L19:
                int r4 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r4 >= 0) goto L48
                java.lang.String r0 = "۟ۡۧ"
                goto L5
            L22:
                java.lang.String r0 = "ۣۢۦ"
                r1 = r2
                goto L5
            L26:
                int r4 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "ۥۡۤ"
                goto L5
            L2f:
                java.lang.String r0 = "ۦ۠ۢ"
                r1 = r3
                goto L5
            L33:
                int r4 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "ۢۥۧ"
                goto L5
            L3c:
                int r0 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r0 < 0) goto L45
                java.lang.String r0 = "ۣۨۦ"
                goto L5
            L45:
                java.lang.String r0 = "ۢ۠ۧ"
                goto L5
            L48:
                int r4 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r4 < 0) goto L52
                androidx.preference.layout2.AnonymousClass7.m603()
                goto L5
            L52:
                java.lang.String r0 = "ۥۤۥ"
                goto L5
            L55:
                java.lang.String r0 = "ۦ۠ۢ"
                goto L5
            L58:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass4.m520(java.lang.Object):java.lang.String");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:36:0x005a A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0057 A[SYNTHETIC] */
        /* renamed from: ۟ۢۤۥۧ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.String m521(java.lang.Object r6) {
            /*
                r2 = 0
                java.lang.String r0 = "ۣۨۦ"
                r1 = r2
                r3 = r2
            L5:
                int r4 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r5 = 1750658(0x1ab682, float:2.453194E-39)
                r4 = r4 ^ r5
                switch(r4) {
                    case 135: goto L11;
                    case 2215: goto L5d;
                    case 2913: goto L23;
                    case 4416: goto L14;
                    case 6183: goto L51;
                    case 7232: goto L2a;
                    case 7458: goto L4e;
                    case 29547: goto L26;
                    case 29586: goto L46;
                    case 32684: goto L4e;
                    case 32713: goto L33;
                    default: goto L10;
                }
            L10:
                goto L5
            L11:
                java.lang.String r0 = "ۣۨۦ"
                goto L5
            L14:
                int r1 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r1 < 0) goto L1f
                androidx.preference.layout2.AnonymousClass5.m553()
                r1 = r3
                goto L5
            L1f:
                java.lang.String r0 = "ۥۤۤ"
                r1 = r3
                goto L5
            L23:
                java.lang.String r0 = "ۧۦۨ"
                goto L5
            L26:
                java.lang.String r0 = "۠۟ۡ"
                r1 = r2
                goto L5
            L2a:
                int r4 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r4 <= 0) goto L5
                java.lang.String r0 = "ۨۢۨ"
                goto L5
            L33:
                int r4 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r4 >= 0) goto L51
                int r4 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r4 < 0) goto L43
                androidx.preference.layout2.AnonymousClass7.m603()
                goto L5
            L43:
                java.lang.String r0 = "ۧ۟ۨ"
                goto L5
            L46:
                r0 = r6
                androidx.preference.layout2$4 r0 = (androidx.preference.layout2.AnonymousClass4) r0
                java.lang.String r3 = r0.positivebtn
                java.lang.String r0 = "۟ۥۨ"
                goto L5
            L4e:
                java.lang.String r0 = "ۥۤۤ"
                goto L5
            L51:
                int r0 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r0 < 0) goto L5a
                java.lang.String r0 = "ۦۦ۟"
                goto L5
            L5a:
                java.lang.String r0 = "ۥۢ۠"
                goto L5
            L5d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass4.m521(java.lang.Object):java.lang.String");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:14:0x005c A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0006 A[SYNTHETIC] */
        /* renamed from: ۟ۢۥۣۣ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.String m522(java.lang.Object r6) {
            /*
                r3 = 0
                java.lang.String r0 = "ۥ۠ۨ"
                r1 = r0
                r2 = r3
                r4 = r3
            L6:
                int r0 = androidx.preference.layout2.AnonymousClass5.m528(r1)
                r5 = 1749787(0x1ab31b, float:2.451974E-39)
                r0 = r0 ^ r5
                switch(r0) {
                    case 1028: goto L12;
                    case 1375: goto L2e;
                    case 1404: goto L6e;
                    case 1508: goto L3e;
                    case 3766: goto L16;
                    case 5146: goto L60;
                    case 7173: goto L56;
                    case 7270: goto L60;
                    case 30451: goto L43;
                    case 31480: goto L64;
                    case 1732380: goto L20;
                    default: goto L11;
                }
            L11:
                goto L6
            L12:
                java.lang.String r0 = "ۣۡۧ"
                r1 = r0
                goto L6
            L16:
                int r0 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r0 > 0) goto L56
                java.lang.String r0 = "ۧۦۧ"
                r1 = r0
                goto L6
            L20:
                int r0 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r0 > 0) goto L2a
                androidx.preference.layout2.AnonymousClass6.m569()
                goto L6
            L2a:
                java.lang.String r0 = "ۣۡۢ"
                r1 = r0
                goto L6
            L2e:
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 < 0) goto L39
                java.lang.String r0 = "ۥ۟"
                r1 = r0
                r2 = r3
                goto L6
            L39:
                java.lang.String r0 = "ۣۨۤ"
                r1 = r0
                r2 = r3
                goto L6
            L3e:
                java.lang.String r0 = "ۣۢۦ"
                r1 = r0
                r2 = r4
                goto L6
            L43:
                r0 = r6
                androidx.preference.layout2$4 r0 = (androidx.preference.layout2.AnonymousClass4) r0
                java.lang.String r4 = r0.changelogTitle
                int r0 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r0 < 0) goto L52
                androidx.preference.layout2.AnonymousClass9.m639()
                goto L6
            L52:
                java.lang.String r0 = "ۣۣۧ"
                r1 = r0
                goto L6
            L56:
                int r0 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r0 <= 0) goto L6
                java.lang.String r0 = "۠ۧ"
                r1 = r0
                goto L6
            L60:
                java.lang.String r0 = "ۣۢۦ"
                r1 = r0
                goto L6
            L64:
                int r0 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r0 >= 0) goto L6
                java.lang.String r0 = "ۥ۠ۨ"
                r1 = r0
                goto L6
            L6e:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass4.m522(java.lang.Object):java.lang.String");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        /* renamed from: ۣ۟ۨۧۨ */
        public static String m523(Object obj) {
            String str = "ۧۤۦ";
            String str2 = null;
            String str3 = null;
            while (true) {
                switch (AnonymousClass5.m528(str) ^ 1750693) {
                    case 1414:
                    case 4446:
                        str = AnonymousClass5.m553() >= 0 ? "۟ۧۡ" : "۟ۢ۠";
                    case 4600:
                        break;
                    case 6209:
                        str = "ۢۦۧ";
                    case 6246:
                        if (AnonymousClass5.m553() >= 0) {
                            str2 = str3;
                        } else {
                            str = "۟ۢ۠";
                            str2 = str3;
                        }
                    case 7869:
                        str = "ۧۤۦ";
                    case 29452:
                        str = AnonymousClass6.m569() <= 0 ? "ۣۨۦ" : "۟۟";
                    case 29676:
                    case 32750:
                        str3 = ((AnonymousClass4) obj).downloadLink;
                        if (AnonymousClass9.m639() > 0) {
                            str = "ۣۡۡ";
                        }
                    case 1731909:
                        if (AnonymousClass6.m569() >= 0) {
                            AnonymousClass7.m603();
                            str = "ۤۤۤ";
                        } else {
                            str = "۠۟";
                        }
                    case 1731930:
                        if (AnonymousClass5.m553() >= 0) {
                            str = "۟ۨۥ";
                            str2 = null;
                        } else {
                            str = "ۡۢۥ";
                            str2 = null;
                        }
                }
                return str2;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0064 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0005 A[SYNTHETIC] */
        /* renamed from: ۟ۧۡۤۢ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.String m524(java.lang.Object r6) {
            /*
                r2 = 0
                java.lang.String r0 = "ۦ۠ۧ"
                r1 = r2
                r3 = r2
            L5:
                int r4 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r5 = 1747712(0x1aab00, float:2.449066E-39)
                r4 = r4 ^ r5
                switch(r4) {
                    case 5: goto L11;
                    case 1027: goto L5e;
                    case 1061: goto L4f;
                    case 3196: goto L67;
                    case 6177: goto L4c;
                    case 7496: goto L4f;
                    case 7585: goto L1a;
                    case 25255: goto L28;
                    case 26914: goto L39;
                    case 27245: goto L3d;
                    case 28230: goto L6a;
                    default: goto L10;
                }
            L10:
                goto L5
            L11:
                int r4 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "ۣۡۦ"
                goto L5
            L1a:
                int r0 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r0 < 0) goto L24
                java.lang.String r0 = "ۡۤۨ"
                r1 = r2
                goto L5
            L24:
                java.lang.String r0 = "۠ۡۦ"
                r1 = r2
                goto L5
            L28:
                r0 = r6
                androidx.preference.layout2$4 r0 = (androidx.preference.layout2.AnonymousClass4) r0
                java.lang.String r3 = r0.version
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 < 0) goto L36
                java.lang.String r0 = "ۨۢۨ"
                goto L5
            L36:
                java.lang.String r0 = "ۦۦۢ"
                goto L5
            L39:
                java.lang.String r0 = "ۧۡ۠"
                r1 = r3
                goto L5
            L3d:
                int r4 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r4 >= 0) goto L5e
                int r4 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "ۨۦۥ"
                goto L5
            L4c:
                java.lang.String r0 = "ۣۤۢ"
                goto L5
            L4f:
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 < 0) goto L5b
                androidx.preference.layout2.AnonymousClass9.m639()
                java.lang.String r0 = "۟ۡۤ"
                goto L5
            L5b:
                java.lang.String r0 = "ۧۡ۠"
                goto L5
            L5e:
                int r4 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r4 <= 0) goto L5
                java.lang.String r0 = "ۢۦۥ"
                goto L5
            L67:
                java.lang.String r0 = "ۦ۠ۧ"
                goto L5
            L6a:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass4.m524(java.lang.Object):java.lang.String");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        /* renamed from: ۟ۨۨ */
        public static String m525(Object obj) {
            Object obj2 = "ۦ۠";
            String str = null;
            String str2 = null;
            while (true) {
                switch (AnonymousClass5.m528(obj2) ^ 1746690) {
                    case 67:
                        obj2 = "ۧۢۨ";
                    case 2502:
                        if (AnonymousClass9.m639() <= 0) {
                            AnonymousClass7.m603();
                        } else {
                            obj2 = "۟ۨۤ";
                        }
                    case 3135:
                        if (AnonymousClass5.m553() >= 0) {
                            AnonymousClass7.m603();
                        } else {
                            obj2 = "ۦ۠";
                        }
                    case 3865:
                        if (AnonymousClass5.m553() >= 0) {
                            AnonymousClass6.m569();
                            str = null;
                        } else {
                            obj2 = "ۣ۟ۡ";
                            str = null;
                        }
                    case 5153:
                        str2 = ((AnonymousClass4) obj).negativebtn;
                        if (AnonymousClass9.m639() > 0) {
                            obj2 = "ۨۢۥ";
                        }
                    case 6823:
                        obj2 = "ۡۡۤ";
                    case 6831:
                    case 25199:
                        if (AnonymousClass7.m603() < 0) {
                            obj2 = "ۣۧۤ";
                        }
                    case 25252:
                        break;
                    case 28201:
                        if (AnonymousClass9.m639() <= 0) {
                            AnonymousClass7.m603();
                            obj2 = "ۦۡۦ";
                            str = str2;
                        } else {
                            obj2 = "ۣۧۤ";
                            str = str2;
                        }
                    case 1735608:
                        if (AnonymousClass8.m616() > 0) {
                            obj2 = "ۡۡۤ";
                        } else if (AnonymousClass5.m553() >= 0) {
                            AnonymousClass7.m603();
                            obj2 = "ۣۥۣ";
                        } else {
                            obj2 = "ۢۦۧ";
                        }
                }
                return str;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:35:0x006d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0006 A[SYNTHETIC] */
        /* renamed from: ۥۡۥ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.String m526(java.lang.Object r6) {
            /*
                r3 = 0
                java.lang.String r0 = "ۢۢۨ"
                r1 = r0
                r2 = r3
                r4 = r3
            L6:
                int r0 = androidx.preference.layout2.AnonymousClass5.m528(r1)
                r5 = 1746844(0x1aa79c, float:2.44785E-39)
                r0 = r0 ^ r5
                switch(r0) {
                    case 3134: goto L12;
                    case 3202: goto L75;
                    case 5428: goto L3c;
                    case 5629: goto L63;
                    case 6648: goto L53;
                    case 7673: goto L2e;
                    case 25145: goto L16;
                    case 25172: goto L29;
                    case 25300: goto L71;
                    case 28250: goto L63;
                    case 1735673: goto L67;
                    default: goto L11;
                }
            L11:
                goto L6
            L12:
                java.lang.String r0 = "ۥۦۥ"
                r1 = r0
                goto L6
            L16:
                r0 = r6
                androidx.preference.layout2$4 r0 = (androidx.preference.layout2.AnonymousClass4) r0
                java.lang.String r4 = r0.title
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 < 0) goto L25
                androidx.preference.layout2.AnonymousClass6.m569()
                goto L6
            L25:
                java.lang.String r0 = "ۧۥۦ"
                r1 = r0
                goto L6
            L29:
                java.lang.String r0 = "۠ۢ۠"
                r1 = r0
                r2 = r4
                goto L6
            L2e:
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 < 0) goto L38
                androidx.preference.layout2.AnonymousClass8.m616()
                goto L6
            L38:
                java.lang.String r0 = "ۢ۠۟"
                r1 = r0
                goto L6
            L3c:
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 > 0) goto L67
                int r0 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r0 > 0) goto L4f
                androidx.preference.layout2.AnonymousClass8.m616()
                java.lang.String r0 = "ۥ۠۠"
                r1 = r0
                goto L6
            L4f:
                java.lang.String r0 = "ۧۤۢ"
                r1 = r0
                goto L6
            L53:
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 < 0) goto L5e
                java.lang.String r0 = "ۣۡۢ"
                r1 = r0
                r2 = r3
                goto L6
            L5e:
                java.lang.String r0 = "ۤۤۥ"
                r1 = r0
                r2 = r3
                goto L6
            L63:
                java.lang.String r0 = "۠ۢ۠"
                r1 = r0
                goto L6
            L67:
                int r0 = androidx.preference.layout2.AnonymousClass7.m603()
                if (r0 >= 0) goto L6
                java.lang.String r0 = "۠ۦۨ"
                r1 = r0
                goto L6
            L71:
                java.lang.String r0 = "ۢۢۨ"
                r1 = r0
                goto L6
            L75:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass4.m526(java.lang.Object):java.lang.String");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:44:0x006f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x006b A[SYNTHETIC] */
        /* renamed from: ۧ۠ۡۦ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.String m527(java.lang.Object r6) {
            /*
                r2 = 0
                java.lang.String r0 = "ۣۤۨ"
                r1 = r2
                r3 = r2
            L5:
                int r4 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r5 = 1755499(0x1ac96b, float:2.459978E-39)
                r4 = r4 ^ r5
                switch(r4) {
                    case 170: goto L11;
                    case 180: goto L56;
                    case 390: goto L52;
                    case 2185: goto L75;
                    case 3170: goto L65;
                    case 3245: goto L1d;
                    case 29620: goto L43;
                    case 30539: goto L11;
                    case 30540: goto L37;
                    case 30702: goto L2a;
                    case 32545: goto L3b;
                    default: goto L10;
                }
            L10:
                goto L5
            L11:
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 < 0) goto L72
                androidx.preference.layout2.AnonymousClass7.m603()
                java.lang.String r0 = "ۦ۠"
                goto L5
            L1d:
                int r4 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r4 < 0) goto L27
                androidx.preference.layout2.AnonymousClass6.m569()
                goto L5
            L27:
                java.lang.String r0 = "ۥۤ۟"
                goto L5
            L2a:
                int r4 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r4 > 0) goto L34
                androidx.preference.layout2.AnonymousClass8.m616()
                goto L5
            L34:
                java.lang.String r0 = "ۨ۠ۥ"
                goto L5
            L37:
                java.lang.String r0 = "ۦۤ۠"
                r1 = r3
                goto L5
            L3b:
                r0 = r6
                androidx.preference.layout2$4 r0 = (androidx.preference.layout2.AnonymousClass4) r0
                java.lang.String r3 = r0.message
                java.lang.String r0 = "ۥۤۦ"
                goto L5
            L43:
                int r4 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r4 > 0) goto L65
                int r4 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r4 >= 0) goto L5
                java.lang.String r0 = "ۣۡۨ"
                goto L5
            L52:
                java.lang.String r0 = "ۧۥۤ"
                r1 = r2
                goto L5
            L56:
                int r0 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r0 > 0) goto L62
                androidx.preference.layout2.AnonymousClass9.m639()
                java.lang.String r0 = "۠ۧۢ"
                goto L5
            L62:
                java.lang.String r0 = "ۣۤۨ"
                goto L5
            L65:
                int r4 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r4 < 0) goto L6f
                androidx.preference.layout2.AnonymousClass8.m616()
                goto L5
            L6f:
                java.lang.String r0 = "ۥۧۧ"
                goto L5
            L72:
                java.lang.String r0 = "ۦۤ۠"
                goto L5
            L75:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass4.m527(java.lang.Object):java.lang.String");
        }

        public String getDownloadLink() {
            return m523(this);
        }

        public String getMessage() {
            return m527(this);
        }

        public String getTitle() {
            return m526(this);
        }

        public String getVersion() {
            return m524(this);
        }

        public String getchangeLogMessage() {
            return m520(this);
        }

        public String getchangelogTitle() {
            return m522(this);
        }

        public String getnegativebtn() {
            return m525(this);
        }

        public String getpositivebtn() {
            return m521(this);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000b. Please report as an issue. */
        public void setChangeLogMessage(String str) {
            Long l11 = null;
            String str2 = "ۦۣۨ";
            while (true) {
                switch (AnonymousClass5.m528((Object) str2) ^ 1752741) {
                    case 1152:
                        l11 = Long.decode(AnonymousClass7.m598("RXyZLJxaUK29WLaQ9plwoTSes9A"));
                        str2 = "ۢۧۡ";
                    case 3072:
                        str2 = "ۣۧۧ";
                    case 3481:
                        System.out.println(l11);
                        if (AnonymousClass5.m553() < 0) {
                            str2 = "ۣۧۧ";
                        }
                    case 30852:
                        str2 = AnonymousClass5.m553() >= 0 ? "۟ۡۥ" : "ۦۣۨ";
                    case 31534:
                        break;
                    case 32552:
                        if (AnonymousClass6.m569() < 0) {
                            str2 = "ۣۧۧ";
                        } else if (AnonymousClass7.m603() < 0) {
                            str2 = "ۣۤۢ";
                        }
                    case 32622:
                        this.changeLogMessage = str;
                        if (AnonymousClass9.m639() > 0) {
                            str2 = "ۦۡۨ";
                        }
                }
                return;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void setChangelogTitle(java.lang.String r4) {
            /*
                r3 = this;
                java.lang.String r0 = "ۥۨۤ"
            L2:
                int r1 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r2 = 1755562(0x1ac9aa, float:2.460066E-39)
                r1 = r1 ^ r2
                switch(r1) {
                    case 25320: goto Le;
                    case 26165: goto L1e;
                    case 30475: goto Lf;
                    default: goto Ld;
                }
            Ld:
                goto L2
            Le:
                return
            Lf:
                r3.changelogTitle = r4
                int r1 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r1 > 0) goto L1b
                androidx.preference.layout2.AnonymousClass6.m569()
                goto L2
            L1b:
                java.lang.String r0 = "ۣ۠ۥ"
                goto L2
            L1e:
                int r1 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r1 < 0) goto L28
                androidx.preference.layout2.AnonymousClass9.m639()
                goto L2
            L28:
                java.lang.String r0 = "ۥۨۤ"
                goto L2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass4.setChangelogTitle(java.lang.String):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000b. Please report as an issue. */
        public void setDownloadLink(String str) {
            Long l11 = null;
            String str2 = "ۨۤ۟";
            while (true) {
                switch (AnonymousClass5.m528((Object) str2) ^ 1748647) {
                    case DownloadException.EXCEPTION_IO_MALFORMED_URL /* 508 */:
                        if (AnonymousClass6.m569() < 0) {
                            str2 = "ۣۣ۠";
                        } else if (AnonymousClass7.m603() >= 0) {
                            AnonymousClass5.m553();
                        } else {
                            str2 = "ۣۡۢ";
                        }
                    case 1401:
                        System.out.println(l11);
                        if (AnonymousClass9.m639() <= 0) {
                            AnonymousClass8.m616();
                        } else {
                            str2 = "ۣۣ۠";
                        }
                    case 2532:
                        str2 = "ۣۣ۠";
                    case 6183:
                        break;
                    case 6371:
                        l11 = Long.valueOf(AnonymousClass7.m598("WJkUoPbQ7ePiHMm"));
                        if (AnonymousClass6.m569() >= 0) {
                            AnonymousClass5.m553();
                            str2 = "ۧۥۤ";
                        } else {
                            str2 = "۠ۨۦ";
                        }
                    case 26564:
                        this.downloadLink = str;
                        if (AnonymousClass6.m569() >= 0) {
                            AnonymousClass9.m639();
                            str2 = "ۧۦۥ";
                        } else {
                            str2 = "ۡۦ۠";
                        }
                    case 27598:
                        if (AnonymousClass9.m639() <= 0) {
                            AnonymousClass7.m603();
                            str2 = "ۣ۟۠";
                        } else {
                            str2 = "ۨۤ۟";
                        }
                }
                return;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x002a, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void setMessage(java.lang.String r4) {
            /*
                r3 = this;
                java.lang.String r0 = "ۣۦۥ"
            L2:
                int r1 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r2 = 1748890(0x1aaf9a, float:2.450717E-39)
                r1 = r1 ^ r2
                switch(r1) {
                    case 2204: goto Le;
                    case 6520: goto L18;
                    case 7301: goto L2a;
                    default: goto Ld;
                }
            Ld:
                goto L2
            Le:
                int r1 = androidx.preference.layout2.AnonymousClass9.m639()
                if (r1 > 0) goto L27
                androidx.preference.layout2.AnonymousClass5.m553()
                goto L2
            L18:
                r3.message = r4
                int r1 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r1 < 0) goto L24
                androidx.preference.layout2.AnonymousClass9.m639()
                goto L2
            L24:
                java.lang.String r0 = "ۢۦۣ"
                goto L2
            L27:
                java.lang.String r0 = "ۣۦۥ"
                goto L2
            L2a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass4.setMessage(java.lang.String):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void setNegativeBtn(java.lang.String r4) {
            /*
                r3 = this;
                java.lang.String r0 = "ۥ۠ۡ"
            L2:
                int r1 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r2 = 1747741(0x1aab1d, float:2.449107E-39)
                r1 = r1 ^ r2
                switch(r1) {
                    case 3136: goto Le;
                    case 4605: goto L1a;
                    case 5819: goto Lf;
                    default: goto Ld;
                }
            Ld:
                goto L2
            Le:
                return
            Lf:
                r3.negativebtn = r4
                int r1 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r1 >= 0) goto L2
                java.lang.String r0 = "۟ۢ۠"
                goto L2
            L1a:
                int r1 = androidx.preference.layout2.AnonymousClass5.m553()
                if (r1 < 0) goto L24
                androidx.preference.layout2.AnonymousClass8.m616()
                goto L2
            L24:
                java.lang.String r0 = "ۥ۠ۡ"
                goto L2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass4.setNegativeBtn(java.lang.String):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0029, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void setPositiveBtn(java.lang.String r4) {
            /*
                r3 = this;
                java.lang.String r0 = "ۣۤۧ"
            L2:
                int r1 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r2 = 1751679(0x1aba7f, float:2.454625E-39)
                r1 = r1 ^ r2
                switch(r1) {
                    case 3289: goto Le;
                    case 4606: goto L1d;
                    case 5605: goto L29;
                    default: goto Ld;
                }
            Ld:
                goto L2
            Le:
                r3.positivebtn = r4
                int r1 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r1 < 0) goto L1a
                androidx.preference.layout2.AnonymousClass6.m569()
                goto L2
            L1a:
                java.lang.String r0 = "ۡۨۡ"
                goto L2
            L1d:
                int r0 = androidx.preference.layout2.AnonymousClass6.m569()
                if (r0 < 0) goto L26
                java.lang.String r0 = "ۣۢۢ"
                goto L2
            L26:
                java.lang.String r0 = "ۣۤۧ"
                goto L2
            L29:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass4.setPositiveBtn(java.lang.String):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0016, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void setTitle(java.lang.String r4) {
            /*
                r3 = this;
                java.lang.String r0 = "ۣ۟ۡ"
            L2:
                int r1 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r2 = 1752462(0x1abd8e, float:2.455722E-39)
                r1 = r1 ^ r2
                switch(r1) {
                    case 6863: goto Le;
                    case 30951: goto L16;
                    case 32747: goto L13;
                    default: goto Ld;
                }
            Ld:
                goto L2
            Le:
                r3.title = r4
                java.lang.String r0 = "ۧۢۤ"
                goto L2
            L13:
                java.lang.String r0 = "ۣ۟ۡ"
                goto L2
            L16:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass4.setTitle(java.lang.String):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void setVersion(java.lang.String r4) {
            /*
                r3 = this;
                java.lang.String r0 = "ۣۣۧ"
            L2:
                int r1 = androidx.preference.layout2.AnonymousClass5.m528(r0)
                r2 = 1750656(0x1ab680, float:2.453192E-39)
                r1 = r1 ^ r2
                switch(r1) {
                    case 1441: goto Le;
                    case 2274: goto L20;
                    case 29447: goto Lf;
                    default: goto Ld;
                }
            Ld:
                goto L2
            Le:
                return
            Lf:
                r3.version = r4
                int r0 = androidx.preference.layout2.AnonymousClass8.m616()
                if (r0 < 0) goto L1d
                androidx.preference.layout2.AnonymousClass9.m639()
                java.lang.String r0 = "ۨۨ"
                goto L2
            L1d:
                java.lang.String r0 = "ۢۦۥ"
                goto L2
            L20:
                java.lang.String r0 = "ۣۣۧ"
                goto L2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass4.setVersion(java.lang.String):void");
        }
    }

    /* renamed from: androidx.preference.layout2$5 */
    /* loaded from: classes7.dex */
    public class AnonymousClass5 {

        /* renamed from: short */
        private static final short[] f22short = {2780, 2784, 2779};

        /* renamed from: ۟ۦۣۢ۟ */
        public static boolean f23 = true;

        /* renamed from: ۣ۟۟ۨۦ */
        public static int m528(Object obj) {
            return ((Integer) C0685.n(8036, obj, new Object[0])).intValue();
        }

        /* renamed from: ۣ۟۟ۨۦ */
        public static Class<?> m529(String str) throws ClassNotFoundException {
            return Class.forName(str);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0010. Please report as an issue. */
        /* renamed from: ۣ۟۟ۨۦ */
        public static String m530(short[] sArr, int i11, int i12, int i13) {
            String str = "ۥۧۢ";
            short s11 = 0;
            int i14 = 0;
            char[] cArr = null;
            int i15 = 0;
            while (true) {
                switch (C0799.m1158((Object) str) ^ 1747873) {
                    case 127:
                        str = "ۧ۟ۥ";
                    case 1344:
                        s11 = sArr[((i11 + 3) + i14) - 3];
                        if (C0079.m394() >= 0) {
                            C0079.m394();
                        } else {
                            str = "ۥۡۦ";
                        }
                    case 3237:
                        str = "ۢۢۥ";
                    case 4583:
                        i15 = 0 - ((0 - i14) - 1);
                        if (C0079.m394() >= 0) {
                            C0079.m394();
                        } else {
                            str = "ۦۥۦ";
                        }
                    case 4685:
                        if (i14 >= i12) {
                            str = "ۧ۟ۥ";
                        } else if (C0799.m1162() > 0) {
                            str = "ۡۢۢ";
                        }
                    case 5409:
                        cArr = new char[i12];
                        str = "۟۟ۤ";
                    case 5739:
                        cArr[i14] = (char) (((s11 ^ (-1)) & i13) | ((i13 ^ (-1)) & s11));
                        str = C0079.m394() >= 0 ? "ۨۢۡ" : "ۣۤۥ";
                    case 6404:
                        str = "ۤ۠ۨ";
                        i14 = 0;
                    case 7298:
                    case 28258:
                        if (C0667.m874() < 0) {
                            str = "ۤ۠ۨ";
                        }
                    case 27046:
                        if (C0066.m207() != 0) {
                            C0066.m207();
                            i14 = i15;
                        } else {
                            str = "ۦۤۡ";
                            i14 = i15;
                        }
                    case 27202:
                        if (C0078.m391() < 0) {
                            str = "ۧۥۡ";
                        }
                    case 28332:
                        break;
                    case 1734628:
                        str = C0667.m874() >= 0 ? "ۣۡ" : "ۥۧۢ";
                }
                return new String(cArr);
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0082 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x007e A[SYNTHETIC] */
        /* renamed from: ۟۟ۥۨ۟ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int m531() {
            /*
                r6 = 0
                r3 = 0
                java.lang.String r0 = "ۢۢۤ"
                r1 = r0
                r2 = r3
                r4 = r3
            L7:
                int r0 = gt.md.C0799.m1158(r1)
                r5 = 1747901(0x1aabbd, float:2.449331E-39)
                r0 = r0 ^ r5
                switch(r0) {
                    case 222: goto L13;
                    case 253: goto L3a;
                    case 255: goto L96;
                    case 1279: goto L1d;
                    case 6297: goto L13;
                    case 6306: goto L35;
                    case 6425: goto L47;
                    case 6465: goto L86;
                    case 27131: goto L78;
                    case 28182: goto L2b;
                    case 28373: goto L5c;
                    default: goto L12;
                }
            L12:
                goto L7
            L13:
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 >= 0) goto L7
                java.lang.String r0 = "ۣ۠ۥ"
                r1 = r0
                goto L7
            L1d:
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 < 0) goto L27
                androidx.core.appcompat.C0066.m207()
                goto L7
            L27:
                java.lang.String r0 = "ۢۦۣ"
                r1 = r0
                goto L7
            L2b:
                int r0 = androidx.core.C0078.m391()
                if (r0 >= 0) goto L7
                java.lang.String r0 = "ۢۦۨ"
                r1 = r0
                goto L7
            L35:
                java.lang.String r0 = "ۧۤۨ"
                r1 = r0
                r2 = r3
                goto L7
            L3a:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L42
                r2 = r4
                goto L7
            L42:
                java.lang.String r0 = "ۣ۠ۥ"
                r1 = r0
                r2 = r4
                goto L7
            L47:
                r0 = 75667(0x12793, float:1.06032E-40)
                java.lang.Object[] r5 = new java.lang.Object[r3]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r6, r5)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 > 0) goto L78
                java.lang.String r0 = "ۣۧۢ"
                r1 = r0
                goto L7
            L5c:
                r0 = 30877(0x789d, float:4.3268E-41)
                java.lang.Object[] r4 = new java.lang.Object[r3]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r6, r4)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r4 = r0.intValue()
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L74
                gt.md.C0799.m1162()
                goto L7
            L74:
                java.lang.String r0 = "ۣۣ۠"
                r1 = r0
                goto L7
            L78:
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L82
                com.transsion.subroom.activity.C0667.m874()
                goto L7
            L82:
                java.lang.String r0 = "ۡۥۦ"
                r1 = r0
                goto L7
            L86:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L91
                androidx.core.C0079.m394()
                goto L7
            L91:
                java.lang.String r0 = "ۢۢۤ"
                r1 = r0
                goto L7
            L96:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m531():int");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0018 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0083 A[SYNTHETIC] */
        /* renamed from: ۟۠ۥۡ۟ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.String m532(java.lang.Object r8) {
            /*
                r6 = 0
                r3 = 0
                java.lang.String r0 = "ۢۦۧ"
                r2 = r3
                r1 = r3
            L6:
                int r4 = gt.md.C0799.m1158(r0)
                r5 = 1754410(0x1ac52a, float:2.458452E-39)
                r4 = r4 ^ r5
                switch(r4) {
                    case 71: goto L12;
                    case 1100: goto L40;
                    case 3309: goto L71;
                    case 29536: goto L3d;
                    case 30217: goto L4d;
                    case 31561: goto L1b;
                    case 31631: goto L61;
                    case 32650: goto L7a;
                    case 32695: goto L71;
                    case 1710415: goto L86;
                    case 1710580: goto L65;
                    default: goto L11;
                }
            L11:
                goto L6
            L12:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L83
                java.lang.String r0 = "ۤۧۡ"
                goto L6
            L1b:
                r1 = 21900(0x558c, float:3.0688E-41)
                r0 = r8
                java.lang.StringBuffer r0 = (java.lang.StringBuffer) r0
                java.lang.Object[] r4 = new java.lang.Object[r6]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r1, r0, r4)
                java.lang.String r0 = (java.lang.String) r0
                int r1 = com.transsion.subroom.activity.C0667.m874()
                if (r1 < 0) goto L37
                com.transsion.subroom.activity.C0667.m874()
                java.lang.String r1 = "ۣۧۤ"
                r7 = r1
                r1 = r0
                r0 = r7
                goto L6
            L37:
                java.lang.String r1 = "ۧۥ"
                r7 = r1
                r1 = r0
                r0 = r7
                goto L6
            L3d:
                java.lang.String r0 = "ۤۦ۟"
                goto L6
            L40:
                int r4 = androidx.core.C0078.m391()
                if (r4 < 0) goto L4a
                com.transsion.subroom.activity.C0667.m874()
                goto L6
            L4a:
                java.lang.String r0 = "ۥۨۨ"
                goto L6
            L4d:
                r0 = 98787(0x181e3, float:1.3843E-40)
                java.lang.Object[] r4 = new java.lang.Object[r6]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r3, r4)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 >= 0) goto L12
                java.lang.String r0 = "ۥۦۤ"
                goto L6
            L61:
                java.lang.String r0 = "ۣۡۨ"
                r2 = r3
                goto L6
            L65:
                int r2 = androidx.core.appcompat.C0066.m207()
                if (r2 == 0) goto L6d
                r2 = r1
                goto L6
            L6d:
                java.lang.String r0 = "ۣۨ"
                r2 = r1
                goto L6
            L71:
                int r4 = gt.md.C0799.m1162()
                if (r4 <= 0) goto L6
                java.lang.String r0 = "ۣۨ"
                goto L6
            L7a:
                int r4 = androidx.core.C0079.m394()
                if (r4 >= 0) goto L6
                java.lang.String r0 = "ۢۦۧ"
                goto L6
            L83:
                java.lang.String r0 = "ۦ۠۠"
                goto L6
            L86:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m532(java.lang.Object):java.lang.String");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:42:0x007e A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0077 A[SYNTHETIC] */
        /* renamed from: ۣ۟ۡ۠۟ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int m533() {
            /*
                r6 = 0
                r3 = 0
                java.lang.String r0 = "ۡۢ۠"
                r1 = r0
                r2 = r3
                r4 = r3
            L7:
                int r0 = gt.md.C0799.m1158(r1)
                r5 = 1747812(0x1aab64, float:2.449206E-39)
                r0 = r0 ^ r5
                switch(r0) {
                    case 187: goto L13;
                    case 1467: goto L56;
                    case 1505: goto L26;
                    case 3300: goto L71;
                    case 4737: goto L4d;
                    case 5441: goto L82;
                    case 6433: goto La5;
                    case 27138: goto L95;
                    case 27970: goto L3f;
                    case 1732749: goto L82;
                    case 1734439: goto L21;
                    default: goto L12;
                }
            L12:
                goto L7
            L13:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L51
                androidx.core.appcompat.C0066.m207()
                java.lang.String r0 = "ۦۣ۠"
                r1 = r0
                r2 = r3
                goto L7
            L21:
                java.lang.String r0 = "ۢ۟ۢ"
                r1 = r0
                r2 = r4
                goto L7
            L26:
                r0 = 97211(0x17bbb, float:1.36222E-40)
                java.lang.Object[] r4 = new java.lang.Object[r3]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r6, r4)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r4 = r0.intValue()
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 != 0) goto L7
                java.lang.String r0 = "ۢۥ"
                r1 = r0
                goto L7
            L3f:
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L49
                gt.md.C0799.m1162()
                goto L7
            L49:
                java.lang.String r0 = "۠ۨۧ"
                r1 = r0
                goto L7
            L4d:
                java.lang.String r0 = "ۥۤۤ"
                r1 = r0
                goto L7
            L51:
                java.lang.String r0 = "ۤ۠ۡ"
                r1 = r0
                r2 = r3
                goto L7
            L56:
                r0 = 98787(0x181e3, float:1.3843E-40)
                java.lang.Object[] r5 = new java.lang.Object[r3]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r6, r5)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 > 0) goto L71
                int r0 = androidx.core.C0078.m391()
                if (r0 >= 0) goto L7
                java.lang.String r0 = "ۣۡ۟"
                r1 = r0
                goto L7
            L71:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L7e
                androidx.core.C0078.m391()
                java.lang.String r0 = "ۥۦ۟"
                r1 = r0
                goto L7
            L7e:
                java.lang.String r0 = "ۧۨۧ"
                r1 = r0
                goto L7
            L82:
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L90
                androidx.core.appcompat.C0066.m207()
                java.lang.String r0 = "۠ۨ"
                r1 = r0
                goto L7
            L90:
                java.lang.String r0 = "ۢ۟ۢ"
                r1 = r0
                goto L7
            L95:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto La0
                androidx.core.C0079.m394()
                goto L7
            La0:
                java.lang.String r0 = "ۡۢ۠"
                r1 = r0
                goto L7
            La5:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m533():int");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0004 A[SYNTHETIC] */
        /* renamed from: ۟ۢ۟ۦ۠ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m534(java.lang.Object r5, java.lang.Object r6) {
            /*
                r4 = 0
                java.lang.String r0 = "۠۟ۤ"
                r1 = r0
            L4:
                int r0 = gt.md.C0799.m1158(r1)
                r2 = 56480(0xdca0, float:7.9145E-41)
                r0 = r0 ^ r2
                switch(r0) {
                    case 36: goto L10;
                    case 1863: goto L71;
                    case 1731301: goto L67;
                    case 1733126: goto L63;
                    case 1733217: goto L2b;
                    case 1733540: goto L67;
                    case 1734212: goto L59;
                    case 1734245: goto L3d;
                    default: goto Lf;
                }
            Lf:
                goto L4
            L10:
                r2 = 35571(0x8af3, float:4.9846E-41)
                r0 = r5
                android.widget.Button r0 = (android.widget.Button) r0
                r1 = 1
                java.lang.Object[] r3 = new java.lang.Object[r1]
                r1 = r6
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r3[r4] = r1
                com.transsion.subroom.premium.C0685.n(r2, r0, r3)
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L39
                java.lang.String r0 = "ۥ۠۟"
                r1 = r0
                goto L4
            L2b:
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L35
                java.lang.String r0 = "ۡ۠ۤ"
                r1 = r0
                goto L4
            L35:
                java.lang.String r0 = "ۣۣۡ"
                r1 = r0
                goto L4
            L39:
                java.lang.String r0 = "۟ۦ"
                r1 = r0
                goto L4
            L3d:
                r0 = 42203(0xa4db, float:5.9139E-41)
                r2 = 0
                java.lang.Object[] r3 = new java.lang.Object[r4]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r2, r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 > 0) goto L59
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 != 0) goto L4
                java.lang.String r0 = "ۤۨ"
                r1 = r0
                goto L4
            L59:
                int r0 = androidx.core.C0078.m391()
                if (r0 >= 0) goto L4
                java.lang.String r0 = "ۡۡۡ"
                r1 = r0
                goto L4
            L63:
                java.lang.String r0 = "۠۟ۤ"
                r1 = r0
                goto L4
            L67:
                int r0 = gt.md.C0799.m1162()
                if (r0 <= 0) goto L4
                java.lang.String r0 = "۟ۦ"
                r1 = r0
                goto L4
            L71:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m534(java.lang.Object, java.lang.Object):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0093 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0007 A[SYNTHETIC] */
        /* renamed from: ۟ۢۤ۟ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.StringBuffer m535(java.lang.Object r7, int r8) {
            /*
                r6 = 0
                r3 = 0
                java.lang.String r0 = "ۣۡ۠"
                r1 = r0
                r2 = r3
                r4 = r3
            L7:
                int r0 = gt.md.C0799.m1158(r1)
                r5 = 1753540(0x1ac1c4, float:2.457233E-39)
                r0 = r0 ^ r5
                switch(r0) {
                    case 966: goto L13;
                    case 2087: goto L76;
                    case 2215: goto L13;
                    case 2281: goto L8d;
                    case 27332: goto L6d;
                    case 28474: goto L53;
                    case 29582: goto L46;
                    case 30501: goto L7a;
                    case 30527: goto L20;
                    case 31848: goto L71;
                    case 32666: goto L98;
                    default: goto L12;
                }
            L12:
                goto L7
            L13:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L88
                androidx.core.C0078.m391()
                java.lang.String r0 = "ۣ۟۟"
                r1 = r0
                goto L7
            L20:
                r1 = 87633(0x15651, float:1.228E-40)
                r0 = r7
                java.lang.StringBuffer r0 = (java.lang.StringBuffer) r0
                r4 = 1
                java.lang.Object[] r4 = new java.lang.Object[r4]
                java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
                r4[r6] = r5
                java.lang.Object r0 = com.transsion.subroom.premium.C0684.n(r1, r0, r4)
                java.lang.StringBuffer r0 = (java.lang.StringBuffer) r0
                int r1 = gt.md.C0799.m1162()
                if (r1 > 0) goto L42
                gt.md.C0799.m1162()
                java.lang.String r1 = "ۣۦۨ"
                r4 = r0
                goto L7
            L42:
                java.lang.String r1 = "ۥ۠ۧ"
                r4 = r0
                goto L7
            L46:
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L4e
                r2 = r3
                goto L7
            L4e:
                java.lang.String r0 = "ۣۨۨ"
                r1 = r0
                r2 = r3
                goto L7
            L53:
                r0 = 21970(0x55d2, float:3.0787E-41)
                java.lang.Object[] r5 = new java.lang.Object[r6]
                java.lang.Object r0 = com.transsion.subroom.premium.C0684.n(r0, r3, r5)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 >= 0) goto L8d
                int r0 = androidx.core.C0078.m391()
                if (r0 >= 0) goto L7
                java.lang.String r0 = "ۣۧ۟"
                r1 = r0
                goto L7
            L6d:
                java.lang.String r0 = "ۢ۟ۧ"
                r1 = r0
                goto L7
            L71:
                java.lang.String r0 = "ۥۦ۟"
                r1 = r0
                r2 = r4
                goto L7
            L76:
                java.lang.String r0 = "ۨۤ۟"
                r1 = r0
                goto L7
            L7a:
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L84
                androidx.core.C0079.m394()
                goto L7
            L84:
                java.lang.String r0 = "ۣۡ۠"
                r1 = r0
                goto L7
            L88:
                java.lang.String r0 = "ۥۦ۟"
                r1 = r0
                goto L7
            L8d:
                int r0 = androidx.core.C0078.m391()
                if (r0 >= 0) goto L7
                java.lang.String r0 = "۠ۡۡ"
                r1 = r0
                goto L7
            L98:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m535(java.lang.Object, int):java.lang.StringBuffer");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0082 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0007 A[SYNTHETIC] */
        /* renamed from: ۟ۢۨۡۥ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.String m536(java.lang.Object r7) {
            /*
                r6 = 0
                r3 = 0
                java.lang.String r0 = "ۡۡۦ"
                r1 = r0
                r2 = r3
                r4 = r3
            L7:
                int r0 = gt.md.C0799.m1158(r1)
                r5 = 1750780(0x1ab6fc, float:2.453365E-39)
                r0 = r0 ^ r5
                switch(r0) {
                    case 29: goto L13;
                    case 1118: goto L7c;
                    case 1214: goto L33;
                    case 2141: goto L86;
                    case 2236: goto L6e;
                    case 4537: goto L18;
                    case 6201: goto L86;
                    case 6202: goto L46;
                    case 7525: goto L41;
                    case 28916: goto L61;
                    case 29498: goto L14;
                    default: goto L12;
                }
            L12:
                goto L7
            L13:
                return r2
            L14:
                java.lang.String r0 = "ۥۨۤ"
                r1 = r0
                goto L7
            L18:
                r1 = 5610(0x15ea, float:7.861E-42)
                r0 = r7
                java.io.BufferedReader r0 = (java.io.BufferedReader) r0
                java.lang.Object[] r4 = new java.lang.Object[r6]
                java.lang.Object r0 = com.transsion.subroom.premium.C0684.n(r1, r0, r4)
                java.lang.String r0 = (java.lang.String) r0
                int r1 = androidx.core.C0079.m394()
                if (r1 < 0) goto L2f
                java.lang.String r1 = "ۢ۠ۤ"
                r4 = r0
                goto L7
            L2f:
                java.lang.String r1 = "۠ۦ۟"
                r4 = r0
                goto L7
            L33:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L3d
                gt.md.C0799.m1162()
                goto L7
            L3d:
                java.lang.String r0 = "ۧۧۨ"
                r1 = r0
                goto L7
            L41:
                java.lang.String r0 = "ۣۦۤ"
                r1 = r0
                r2 = r4
                goto L7
            L46:
                r0 = 42203(0xa4db, float:5.9139E-41)
                java.lang.Object[] r5 = new java.lang.Object[r6]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r3, r5)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 > 0) goto L7c
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 >= 0) goto L7
                java.lang.String r0 = "۟ۡۧ"
                r1 = r0
                goto L7
            L61:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L69
                r2 = r3
                goto L7
            L69:
                java.lang.String r0 = "ۧۥۤ"
                r1 = r0
                r2 = r3
                goto L7
            L6e:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L78
                androidx.core.C0079.m394()
                goto L7
            L78:
                java.lang.String r0 = "ۡۡۦ"
                r1 = r0
                goto L7
            L7c:
                int r0 = gt.md.C0799.m1162()
                if (r0 <= 0) goto L7
                java.lang.String r0 = "ۢ۟۟"
                r1 = r0
                goto L7
            L86:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L94
                androidx.core.appcompat.C0066.m207()
                java.lang.String r0 = "۠۠ۧ"
                r1 = r0
                goto L7
            L94:
                java.lang.String r0 = "ۣۦۤ"
                r1 = r0
                goto L7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m536(java.lang.Object):java.lang.String");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:23:0x007a A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0076 A[SYNTHETIC] */
        /* renamed from: ۣ۟۠ۡۤ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m537(java.lang.Object r6, int r7) {
            /*
                r5 = 0
                java.lang.String r0 = "۟ۥۢ"
                r1 = r0
            L4:
                int r0 = gt.md.C0799.m1158(r1)
                r2 = 1749758(0x1ab2fe, float:2.451933E-39)
                r0 = r0 ^ r2
                switch(r0) {
                    case 1211: goto L10;
                    case 2170: goto L7e;
                    case 3292: goto L70;
                    case 5442: goto L31;
                    case 6653: goto L7e;
                    case 7197: goto L62;
                    case 29463: goto L11;
                    case 31580: goto L54;
                    default: goto Lf;
                }
            Lf:
                goto L4
            L10:
                return
            L11:
                r2 = 48630(0xbdf6, float:6.8145E-41)
                r0 = r6
                android.widget.Button r0 = (android.widget.Button) r0
                r3 = 1
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
                r3[r5] = r4
                com.transsion.subroom.premium.C0684.n(r2, r0, r3)
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L2d
                gt.md.C0799.m1162()
                goto L4
            L2d:
                java.lang.String r0 = "ۣۣۡ"
                r1 = r0
                goto L4
            L31:
                r0 = 42203(0xa4db, float:5.9139E-41)
                r1 = 0
                java.lang.Object[] r2 = new java.lang.Object[r5]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r1, r2)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 > 0) goto L70
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L50
                com.transsion.subroom.activity.C0667.m874()
                java.lang.String r0 = "ۣۧۢ"
                r1 = r0
                goto L4
            L50:
                java.lang.String r0 = "ۦۤۧ"
                r1 = r0
                goto L4
            L54:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L5e
                com.transsion.subroom.activity.C0667.m874()
                goto L4
            L5e:
                java.lang.String r0 = "ۤۥۥ"
                r1 = r0
                goto L4
            L62:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L6c
                com.transsion.subroom.activity.C0667.m874()
                goto L4
            L6c:
                java.lang.String r0 = "۟ۥۢ"
                r1 = r0
                goto L4
            L70:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L7a
                java.lang.String r0 = "ۣ۟۟"
                r1 = r0
                goto L4
            L7a:
                java.lang.String r0 = "ۨۦ۠"
                r1 = r0
                goto L4
            L7e:
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L89
                androidx.core.appcompat.C0066.m207()
                goto L4
            L89:
                java.lang.String r0 = "ۣۣۡ"
                r1 = r0
                goto L4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m537(java.lang.Object, int):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0079 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0007 A[SYNTHETIC] */
        /* renamed from: ۣ۟ۡ۟ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.String m538(java.lang.Object r7) {
            /*
                r6 = 0
                r3 = 0
                java.lang.String r0 = "۟۟ۤ"
                r1 = r0
                r2 = r3
                r4 = r3
            L7:
                int r0 = gt.md.C0799.m1158(r1)
                r5 = 1749663(0x1ab29f, float:2.4518E-39)
                r0 = r0 ^ r5
                switch(r0) {
                    case 1173: goto L13;
                    case 1275: goto L7d;
                    case 2939: goto L73;
                    case 5531: goto L3b;
                    case 5599: goto L63;
                    case 5630: goto L50;
                    case 6654: goto L17;
                    case 7654: goto L7d;
                    case 31613: goto L81;
                    case 31739: goto L8c;
                    case 1732320: goto L21;
                    default: goto L12;
                }
            L12:
                goto L7
            L13:
                java.lang.String r0 = "۟ۢۤ"
                r1 = r0
                goto L7
            L17:
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 >= 0) goto L7
                java.lang.String r0 = "ۣۣۢ"
                r1 = r0
                goto L7
            L21:
                r4 = 71837(0x1189d, float:1.00665E-40)
                r0 = r7
                android.content.Context r0 = (android.content.Context) r0
                java.lang.Object[] r5 = new java.lang.Object[r6]
                java.lang.Object r0 = com.transsion.subroom.premium.C0684.n(r4, r0, r5)
                java.lang.String r0 = (java.lang.String) r0
                int r4 = com.transsion.subroom.activity.C0667.m874()
                if (r4 < 0) goto L37
                r4 = r0
                goto L7
            L37:
                java.lang.String r1 = "۟ۡۢ"
                r4 = r0
                goto L7
            L3b:
                r0 = 75667(0x12793, float:1.06032E-40)
                java.lang.Object[] r5 = new java.lang.Object[r6]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r3, r5)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 >= 0) goto L73
                java.lang.String r0 = "ۣۤ"
                r1 = r0
                goto L7
            L50:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L5e
                com.transsion.subroom.activity.C0667.m874()
                java.lang.String r0 = "ۣۣ"
                r1 = r0
                r2 = r3
                goto L7
            L5e:
                java.lang.String r0 = "۠ۤۥ"
                r1 = r0
                r2 = r3
                goto L7
            L63:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L6e
                gt.md.C0799.m1162()
                r2 = r4
                goto L7
            L6e:
                java.lang.String r0 = "ۨۤ۠"
                r1 = r0
                r2 = r4
                goto L7
            L73:
                int r0 = gt.md.C0799.m1162()
                if (r0 <= 0) goto L7
                java.lang.String r0 = "ۣ۟ۦ"
                r1 = r0
                goto L7
            L7d:
                java.lang.String r0 = "ۨۤ۠"
                r1 = r0
                goto L7
            L81:
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 >= 0) goto L7
                java.lang.String r0 = "۟۟ۤ"
                r1 = r0
                goto L7
            L8c:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m538(java.lang.Object):java.lang.String");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0045. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0448 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0443 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0419 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0414 A[SYNTHETIC] */
        /* renamed from: ۟ۦۡۦۣ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.String m539(java.lang.String r34) {
            /*
                Method dump skipped, instructions count: 1248
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m539(java.lang.String):java.lang.String");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        /* renamed from: ۟ۦۤۢۤ */
        public static String m540() {
            String str = "۟ۢۦ";
            String str2 = null;
            String str3 = null;
            while (true) {
                switch (C0799.m1158((Object) str) ^ 1748741) {
                    case 1:
                        str = "ۣ۟۠";
                        str2 = null;
                    case AD_VISIBILITY_VALUE:
                        break;
                    case 385:
                        str = "۟ۢۦ";
                    case 1506:
                        str = "ۧۧۡ";
                    case 2150:
                        if (((Integer) C0685.n(98787, null, new Object[0])).intValue() > 0) {
                            str = "ۧۧۡ";
                        } else if (C0066.m207() != 0) {
                            C0667.m874();
                            str = "ۦۢۨ";
                        } else {
                            str = "ۥ۟ۨ";
                        }
                    case 2169:
                        str = "ۣ۠ۤ";
                    case 2180:
                        if (C0079.m394() >= 0) {
                            str2 = str3;
                        } else {
                            str = "ۡۥۡ";
                            str2 = str3;
                        }
                    case 4747:
                        String str4 = (String) C0684.n(92864);
                        if (C0667.m874() >= 0) {
                            C0078.m391();
                            str3 = str4;
                        } else {
                            str = "ۣ۟ۥ";
                            str3 = str4;
                        }
                    case 6434:
                    case 26208:
                        if (C0667.m874() >= 0) {
                            C0079.m394();
                            str = "ۦ۟";
                        } else {
                            str = "ۡۥۡ";
                        }
                    case 26884:
                        str = "ۣۡۦ";
                }
                return str2;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0098 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0090 A[SYNTHETIC] */
        /* renamed from: ۟ۦۣۧۡ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int m541() {
            /*
                r6 = 0
                r3 = 0
                java.lang.String r0 = "ۥۦۧ"
                r1 = r0
                r2 = r3
                r4 = r3
            L7:
                int r0 = gt.md.C0799.m1158(r1)
                r5 = 1746845(0x1aa79d, float:2.447851E-39)
                r0 = r0 ^ r5
                switch(r0) {
                    case 2335: goto L13;
                    case 3266: goto L36;
                    case 4565: goto L1e;
                    case 5248: goto L44;
                    case 5625: goto L71;
                    case 6651: goto L5c;
                    case 7549: goto L57;
                    case 7636: goto L7b;
                    case 25306: goto L9d;
                    case 25332: goto L8a;
                    case 1735618: goto L7b;
                    default: goto L12;
                }
            L12:
                goto L7
            L13:
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 < 0) goto L52
                com.transsion.subroom.activity.C0667.m874()
                r2 = r3
                goto L7
            L1e:
                r0 = 1566(0x61e, float:2.194E-42)
                java.lang.Object[] r4 = new java.lang.Object[r3]
                java.lang.Object r0 = com.transsion.subroom.premium.C0684.n(r0, r6, r4)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r4 = r0.intValue()
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 >= 0) goto L7
                java.lang.String r0 = "ۤۨۤ"
                r1 = r0
                goto L7
            L36:
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L40
                gt.md.C0799.m1162()
                goto L7
            L40:
                java.lang.String r0 = "ۣۢ"
                r1 = r0
                goto L7
            L44:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L4e
                androidx.core.C0078.m391()
                goto L7
            L4e:
                java.lang.String r0 = "ۡ۟۠"
                r1 = r0
                goto L7
            L52:
                java.lang.String r0 = "ۣ۠ۤ"
                r1 = r0
                r2 = r3
                goto L7
            L57:
                java.lang.String r0 = "ۧۡۡ"
                r1 = r0
                r2 = r4
                goto L7
            L5c:
                r0 = 98787(0x181e3, float:1.3843E-40)
                java.lang.Object[] r1 = new java.lang.Object[r3]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r6, r1)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 >= 0) goto L8a
                java.lang.String r0 = "ۣۡۦ"
                r1 = r0
                goto L7
            L71:
                int r0 = androidx.core.C0078.m391()
                if (r0 >= 0) goto L7
                java.lang.String r0 = "ۥۦۧ"
                r1 = r0
                goto L7
            L7b:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L85
                com.transsion.subroom.activity.C0667.m874()
                goto L7
            L85:
                java.lang.String r0 = "ۧۡۡ"
                r1 = r0
                goto L7
            L8a:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L98
                gt.md.C0799.m1162()
                java.lang.String r0 = "ۣۤۤ"
                r1 = r0
                goto L7
            L98:
                java.lang.String r0 = "ۢۦۡ"
                r1 = r0
                goto L7
            L9d:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m541():int");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:23:0x009d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0098 A[SYNTHETIC] */
        /* renamed from: ۟ۧۥۣۢ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.String m542(java.lang.Object r7) {
            /*
                r6 = 0
                r3 = 0
                java.lang.String r0 = "ۡۤۧ"
                r1 = r0
                r2 = r3
                r4 = r3
            L7:
                int r0 = gt.md.C0799.m1158(r1)
                r5 = 1746813(0x1aa77d, float:2.447806E-39)
                r0 = r0 ^ r5
                switch(r0) {
                    case 249: goto L13;
                    case 2050: goto La2;
                    case 2137: goto L2a;
                    case 3199: goto L63;
                    case 5597: goto L17;
                    case 5629: goto L70;
                    case 25144: goto L59;
                    case 26293: goto L48;
                    case 28190: goto L8d;
                    case 28596: goto L92;
                    case 1735833: goto L8d;
                    default: goto L12;
                }
            L12:
                goto L7
            L13:
                java.lang.String r0 = "ۡۤۧ"
                r1 = r0
                goto L7
            L17:
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L25
                androidx.core.C0078.m391()
                java.lang.String r0 = "ۧۤ۠"
                r1 = r0
                r2 = r4
                goto L7
            L25:
                java.lang.String r0 = "ۡۧۥ"
                r1 = r0
                r2 = r4
                goto L7
            L2a:
                r0 = 21970(0x55d2, float:3.0787E-41)
                java.lang.Object[] r5 = new java.lang.Object[r6]
                java.lang.Object r0 = com.transsion.subroom.premium.C0684.n(r0, r3, r5)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 >= 0) goto L92
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L44
                java.lang.String r0 = "ۤۨۦ"
                r1 = r0
                goto L7
            L44:
                java.lang.String r0 = "ۢۡ۟"
                r1 = r0
                goto L7
            L48:
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 < 0) goto L55
                androidx.core.C0079.m394()
                java.lang.String r0 = "ۣۡۤ"
                r1 = r0
                goto L7
            L55:
                java.lang.String r0 = "ۣ۠ۡ"
                r1 = r0
                goto L7
            L59:
                int r0 = androidx.core.C0079.m394()
                if (r0 >= 0) goto L7
                java.lang.String r0 = "ۨۤ۟"
                r1 = r0
                goto L7
            L63:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L6b
                r2 = r3
                goto L7
            L6b:
                java.lang.String r0 = "ۧۡ۟"
                r1 = r0
                r2 = r3
                goto L7
            L70:
                r1 = 41324(0xa16c, float:5.7907E-41)
                r0 = r7
                java.lang.StringBuilder r0 = (java.lang.StringBuilder) r0
                java.lang.Object[] r4 = new java.lang.Object[r6]
                java.lang.Object r0 = com.transsion.subroom.premium.C0684.n(r1, r0, r4)
                java.lang.String r0 = (java.lang.String) r0
                int r1 = androidx.core.C0079.m394()
                if (r1 < 0) goto L88
                java.lang.String r1 = "ۢۡ۟"
                r4 = r0
                goto L7
            L88:
                java.lang.String r1 = "ۢۢ۠"
                r4 = r0
                goto L7
            L8d:
                java.lang.String r0 = "ۡۧۥ"
                r1 = r0
                goto L7
            L92:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L9d
                gt.md.C0799.m1162()
                goto L7
            L9d:
                java.lang.String r0 = "ۦۣۥ"
                r1 = r0
                goto L7
            La2:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m542(java.lang.Object):java.lang.String");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
        /* renamed from: ۠ۤۤ */
        public static StringBuffer m543(Object obj, Object obj2) {
            String str = "ۨۡ";
            StringBuffer stringBuffer = null;
            StringBuffer stringBuffer2 = null;
            while (true) {
                switch (C0799.m1158(str) ^ 1746789) {
                    case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                        if (C0799.m1162() <= 0) {
                            C0066.m207();
                            stringBuffer = stringBuffer2;
                        } else {
                            str = "ۥ۠ۦ";
                            stringBuffer = stringBuffer2;
                        }
                    case INVALID_ADS_ENDPOINT_VALUE:
                        str = C0066.m207() != 0 ? "ۥۣ۠" : "۟ۨۨ";
                    case 3962:
                        if (C0079.m394() >= 0) {
                            stringBuffer = null;
                        } else {
                            str = "ۢۨ";
                            stringBuffer = null;
                        }
                    case 6445:
                        if (C0078.m391() >= 0) {
                            C0066.m207();
                            str = "ۣۢۢ";
                        } else {
                            str = "ۨۡ";
                        }
                    case 6862:
                        break;
                    case 7495:
                    case 7501:
                        if (C0079.m394() < 0) {
                            str = "ۥ۠ۦ";
                        }
                    case 26243:
                        StringBuffer stringBuffer3 = (StringBuffer) C0684.n(78658, (StringBuffer) obj, new Object[]{(String) obj2});
                        if (C0066.m207() != 0) {
                            C0799.m1162();
                            stringBuffer2 = stringBuffer3;
                        } else {
                            str = "۟۠ۥ";
                            stringBuffer2 = stringBuffer3;
                        }
                    case 1735459:
                        if (C0078.m391() < 0) {
                            str = "ۤۢ۠";
                        }
                    case 1735490:
                        str = "۟۠۠";
                    case 1735580:
                        if (((Integer) C0685.n(42203, null, new Object[0])).intValue() > 0) {
                            str = "۟۠۠";
                        } else if (C0079.m394() >= 0) {
                            C0078.m391();
                        } else {
                            str = "ۦۤۤ";
                        }
                }
                return stringBuffer;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:26:0x006b A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0067 A[SYNTHETIC] */
        /* renamed from: ۠ۦۢ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m544(java.lang.Object r6, int r7) {
            /*
                r5 = 0
                java.lang.String r0 = "ۨۥ۠"
                r1 = r0
            L4:
                int r0 = gt.md.C0799.m1158(r1)
                r2 = 1748795(0x1aaf3b, float:2.450584E-39)
                r0 = r0 ^ r2
                switch(r0) {
                    case 454: goto L10;
                    case 2136: goto L34;
                    case 4413: goto L6f;
                    case 6462: goto L61;
                    case 6552: goto L53;
                    case 26195: goto L14;
                    case 26236: goto L53;
                    case 26296: goto L38;
                    default: goto Lf;
                }
            Lf:
                goto L4
            L10:
                java.lang.String r0 = "ۨۥ۠"
                r1 = r0
                goto L4
            L14:
                r2 = 96983(0x17ad7, float:1.35902E-40)
                r0 = r6
                android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
                r3 = 1
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
                r3[r5] = r4
                com.transsion.subroom.premium.C0684.n(r2, r0, r3)
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L30
                androidx.core.C0078.m391()
                goto L4
            L30:
                java.lang.String r0 = "ۥۣۤ"
                r1 = r0
                goto L4
            L34:
                java.lang.String r0 = "ۣۤۤ"
                r1 = r0
                goto L4
            L38:
                r0 = 21970(0x55d2, float:3.0787E-41)
                r2 = 0
                java.lang.Object[] r3 = new java.lang.Object[r5]
                java.lang.Object r0 = com.transsion.subroom.premium.C0684.n(r0, r2, r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 >= 0) goto L61
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 != 0) goto L4
                java.lang.String r0 = "ۨۤۤ"
                r1 = r0
                goto L4
            L53:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L5d
                androidx.core.appcompat.C0066.m207()
                goto L4
            L5d:
                java.lang.String r0 = "ۥۣۤ"
                r1 = r0
                goto L4
            L61:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L6b
                gt.md.C0799.m1162()
                goto L4
            L6b:
                java.lang.String r0 = "۟ۢۦ"
                r1 = r0
                goto L4
            L6f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m544(java.lang.Object, int):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0018 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x008b A[SYNTHETIC] */
        /* renamed from: ۢ۠۠۟ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int m545(java.lang.Object r7) {
            /*
                r3 = 0
                java.lang.String r0 = "ۡۤ۟"
                r1 = r0
                r2 = r3
                r4 = r3
            L6:
                int r0 = gt.md.C0799.m1158(r1)
                r5 = 56383(0xdc3f, float:7.901E-41)
                r0 = r0 ^ r5
                switch(r0) {
                    case 2013: goto L12;
                    case 1709527: goto L2c;
                    case 1729014: goto La0;
                    case 1730101: goto L1c;
                    case 1731167: goto L30;
                    case 1732279: goto L90;
                    case 1732316: goto L40;
                    case 1732413: goto L90;
                    case 1732453: goto L95;
                    case 1733411: goto L4a;
                    case 1734462: goto L6a;
                    default: goto L11;
                }
            L11:
                goto L6
            L12:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L8b
                androidx.core.C0079.m394()
                goto L6
            L1c:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L27
                androidx.core.C0079.m394()
                r2 = r4
                goto L6
            L27:
                java.lang.String r0 = "ۥۡۥ"
                r1 = r0
                r2 = r4
                goto L6
            L2c:
                java.lang.String r0 = "ۣۢ۟"
                r1 = r0
                goto L6
            L30:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L3b
                androidx.core.appcompat.C0066.m207()
                r2 = r3
                goto L6
            L3b:
                java.lang.String r0 = "ۢۤۥ"
                r1 = r0
                r2 = r3
                goto L6
            L40:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 != 0) goto L6
                java.lang.String r0 = "ۢۡۧ"
                r1 = r0
                goto L6
            L4a:
                r0 = 75667(0x12793, float:1.06032E-40)
                r5 = 0
                java.lang.Object[] r6 = new java.lang.Object[r3]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r5, r6)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 >= 0) goto L12
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L66
                androidx.core.C0078.m391()
                goto L6
            L66:
                java.lang.String r0 = "۠ۡۢ"
                r1 = r0
                goto L6
            L6a:
                r4 = 93270(0x16c56, float:1.30699E-40)
                r0 = r7
                android.view.MotionEvent r0 = (android.view.MotionEvent) r0
                java.lang.Object[] r5 = new java.lang.Object[r3]
                java.lang.Object r0 = com.transsion.subroom.premium.C0684.n(r4, r0, r5)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r4 = r0.intValue()
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L86
                androidx.core.C0078.m391()
                goto L6
            L86:
                java.lang.String r0 = "ۤۡۧ"
                r1 = r0
                goto L6
            L8b:
                java.lang.String r0 = "ۨۨۨ"
                r1 = r0
                goto L6
            L90:
                java.lang.String r0 = "ۥۡۥ"
                r1 = r0
                goto L6
            L95:
                int r0 = androidx.core.C0079.m394()
                if (r0 >= 0) goto L6
                java.lang.String r0 = "ۡۤ۟"
                r1 = r0
                goto L6
            La0:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m545(java.lang.Object):int");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* renamed from: ۢۡ۟ۡ */
        public static void m546(Object obj, Object obj2) {
            String str = "ۥۤ";
            while (true) {
                switch (C0799.m1158(str) ^ 1754598) {
                    case 76:
                        str = "ۥۤ";
                    case 78:
                    case 966:
                        str = C0066.m207() != 0 ? "ۨۢۤ" : "ۧ۠ۥ";
                    case AD_CONSUMED_VALUE:
                        break;
                    case 2018:
                        if (C0079.m394() < 0) {
                            str = "ۧۨۡ";
                        }
                    case 27490:
                    case 30786:
                        C0684.n(30043, (LinearLayout) obj, new Object[]{(View) obj2});
                        if (C0667.m874() >= 0) {
                            C0078.m391();
                        } else {
                            str = "ۧ۠ۥ";
                        }
                    case 1710457:
                        str = ((Integer) C0685.n(75667, null, new Object[0])).intValue() <= 0 ? "ۥ۠۟" : "ۦۥۣ";
                }
                return;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0079 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0075 A[SYNTHETIC] */
        /* renamed from: ۢۨۧۧ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m547(java.lang.Object r5, int r6) {
            /*
                r4 = 0
                java.lang.String r0 = "۟ۨۡ"
                r1 = r0
            L4:
                int r0 = gt.md.C0799.m1158(r1)
                r2 = 1751647(0x1aba5f, float:2.45458E-39)
                r0 = r0 ^ r2
                switch(r0) {
                    case 227: goto L10;
                    case 3193: goto L57;
                    case 4511: goto L57;
                    case 4673: goto L61;
                    case 4679: goto L34;
                    case 5380: goto L7d;
                    case 29365: goto L30;
                    case 32592: goto L6f;
                    default: goto Lf;
                }
            Lf:
                goto L4
            L10:
                r1 = 98012(0x17edc, float:1.37344E-40)
                r0 = r5
                android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
                r2 = 1
                java.lang.Object[] r2 = new java.lang.Object[r2]
                java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
                r2[r4] = r3
                com.transsion.subroom.premium.C0684.n(r1, r0, r2)
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L2c
                java.lang.String r0 = "ۥۣۡ"
                r1 = r0
                goto L4
            L2c:
                java.lang.String r0 = "ۡۦ۠"
                r1 = r0
                goto L4
            L30:
                java.lang.String r0 = "ۣۣ۠"
                r1 = r0
                goto L4
            L34:
                r0 = 42203(0xa4db, float:5.9139E-41)
                r2 = 0
                java.lang.Object[] r3 = new java.lang.Object[r4]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r2, r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 >= 0) goto L6f
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L53
                androidx.core.appcompat.C0066.m207()
                java.lang.String r0 = "۟ۧۦ"
                r1 = r0
                goto L4
            L53:
                java.lang.String r0 = "ۤۧ۟"
                r1 = r0
                goto L4
            L57:
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 >= 0) goto L4
                java.lang.String r0 = "ۡۦ۠"
                r1 = r0
                goto L4
            L61:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L6b
                com.transsion.subroom.activity.C0667.m874()
                goto L4
            L6b:
                java.lang.String r0 = "۟ۨۡ"
                r1 = r0
                goto L4
            L6f:
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 < 0) goto L79
                androidx.core.C0078.m391()
                goto L4
            L79:
                java.lang.String r0 = "ۨ۠ۢ"
                r1 = r0
                goto L4
            L7d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m547(java.lang.Object, int):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:10:0x005d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0059 A[SYNTHETIC] */
        /* renamed from: ۣۡۢۤ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m548(java.lang.Object r6, int r7) {
            /*
                r5 = 0
                java.lang.String r0 = "ۦۣۢ"
                r1 = r0
            L4:
                int r0 = gt.md.C0799.m1158(r1)
                r2 = 1754568(0x1ac5c8, float:2.458673E-39)
                r0 = r0 ^ r2
                switch(r0) {
                    case 1037: goto L10;
                    case 27306: goto L53;
                    case 27414: goto L4f;
                    case 28311: goto L65;
                    case 30354: goto L4f;
                    case 30509: goto L61;
                    case 31663: goto L34;
                    case 1710384: goto L2c;
                    default: goto Lf;
                }
            Lf:
                goto L4
            L10:
                r0 = 98787(0x181e3, float:1.3843E-40)
                r2 = 0
                java.lang.Object[] r3 = new java.lang.Object[r5]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r2, r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 > 0) goto L53
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L30
                com.transsion.subroom.activity.C0667.m874()
                goto L4
            L2c:
                java.lang.String r0 = "ۢۨ۠"
                r1 = r0
                goto L4
            L30:
                java.lang.String r0 = "ۥۦۨ"
                r1 = r0
                goto L4
            L34:
                r2 = 13212(0x339c, float:1.8514E-41)
                r0 = r6
                android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
                r3 = 1
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
                r3[r5] = r4
                com.transsion.subroom.premium.C0684.n(r2, r0, r3)
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 >= 0) goto L4
                java.lang.String r0 = "ۣ۠ۤ"
                r1 = r0
                goto L4
            L4f:
                java.lang.String r0 = "ۣ۠ۤ"
                r1 = r0
                goto L4
            L53:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L5d
                java.lang.String r0 = "ۣۦۤ"
                r1 = r0
                goto L4
            L5d:
                java.lang.String r0 = "ۨ۠"
                r1 = r0
                goto L4
            L61:
                java.lang.String r0 = "ۦۣۢ"
                r1 = r0
                goto L4
            L65:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m548(java.lang.Object, int):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0010. Please report as an issue. */
        /* renamed from: ۣۤ۟۠ */
        public static String m549(short[] sArr, int i11, int i12, int i13) {
            String str = "ۡۤۦ";
            short s11 = 0;
            int i14 = 0;
            char[] cArr = null;
            int i15 = 0;
            while (true) {
                switch (C0799.m1158((Object) str) ^ 56355) {
                    case 160:
                        s11 = sArr[i11 - (0 - i14)];
                        if (C0066.m207() == 0) {
                            str = "ۡۡۤ";
                        }
                    case 1710502:
                        break;
                    case 1710631:
                        if (C0079.m394() >= 0) {
                            C0078.m391();
                        } else {
                            str = "ۡۤۦ";
                        }
                    case 1711529:
                    case 1728996:
                        if (C0078.m391() < 0) {
                            str = "ۤۤۢ";
                        }
                    case 1730113:
                        str = i14 < i12 ? "ۤۧ" : "ۣۧۡ";
                    case 1730155:
                        str = "ۦۡۥ";
                    case 1731073:
                        i15 = (i14 - 26) + 1 + 26;
                        if (C0066.m207() == 0) {
                            str = "ۣۤۨ";
                        }
                    case 1731204:
                        if (C0079.m394() >= 0) {
                            C0079.m394();
                            i14 = i15;
                        } else {
                            str = "ۣۤۧ";
                            i14 = i15;
                        }
                    case 1731288:
                        if (C0078.m391() < 0) {
                            str = "۠ۦۡ";
                        }
                    case 1733351:
                        cArr[i14] = (char) (((s11 ^ (-1)) & i13) | ((i13 ^ (-1)) & s11));
                        str = "ۣ۠۟";
                    case 1733376:
                        cArr = new char[i12];
                        str = "ۣۧ۟";
                    case 1733469:
                    case 1734584:
                        if (C0667.m874() >= 0) {
                            C0667.m874();
                            str = "۟ۨۧ";
                            i14 = 0;
                        } else {
                            str = "ۤۤۢ";
                            i14 = 0;
                        }
                }
                return new String(cArr);
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0011. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00e3 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0009 A[SYNTHETIC] */
        /* renamed from: ۤۦۡۧ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m550(java.lang.Object r10, java.lang.Object r11) {
            /*
                Method dump skipped, instructions count: 288
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m550(java.lang.Object, java.lang.Object):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0071 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x006d A[SYNTHETIC] */
        /* renamed from: ۦۣۣۤ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m551(java.lang.Object r5) {
            /*
                r4 = 0
                r3 = 0
                java.lang.String r0 = "ۣۢۢ"
                r1 = r0
            L5:
                int r0 = gt.md.C0799.m1158(r1)
                r2 = 1754439(0x1ac547, float:2.458493E-39)
                r0 = r0 ^ r2
                switch(r0) {
                    case 226: goto L11;
                    case 3497: goto L11;
                    case 25112: goto L1b;
                    case 25113: goto L67;
                    case 30598: goto L3a;
                    case 32728: goto L59;
                    case 1710341: goto L75;
                    case 1711779: goto L7f;
                    default: goto L10;
                }
            L10:
                goto L5
            L11:
                int r0 = androidx.core.C0079.m394()
                if (r0 >= 0) goto L5
                java.lang.String r0 = "ۣ۟"
                r1 = r0
                goto L5
            L1b:
                r1 = 57501(0xe09d, float:8.0576E-41)
                r0 = 1
                java.lang.Object[] r2 = new java.lang.Object[r0]
                r0 = r5
                android.content.Context r0 = (android.content.Context) r0
                r2[r3] = r0
                com.transsion.subroom.premium.C0684.n(r1, r4, r2)
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L36
                com.transsion.subroom.activity.C0667.m874()
                java.lang.String r0 = "ۤۦ"
                r1 = r0
                goto L5
            L36:
                java.lang.String r0 = "ۣ۟"
                r1 = r0
                goto L5
            L3a:
                r0 = 42203(0xa4db, float:5.9139E-41)
                java.lang.Object[] r2 = new java.lang.Object[r3]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r4, r2)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 > 0) goto L67
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L55
                androidx.core.C0078.m391()
                goto L5
            L55:
                java.lang.String r0 = "۟ۢۢ"
                r1 = r0
                goto L5
            L59:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L63
                gt.md.C0799.m1162()
                goto L5
            L63:
                java.lang.String r0 = "ۧۤۢ"
                r1 = r0
                goto L5
            L67:
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L71
                com.transsion.subroom.activity.C0667.m874()
                goto L5
            L71:
                java.lang.String r0 = "ۤۦۡ"
                r1 = r0
                goto L5
            L75:
                int r0 = androidx.core.C0079.m394()
                if (r0 >= 0) goto L5
                java.lang.String r0 = "ۣۢۢ"
                r1 = r0
                goto L5
            L7f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m551(java.lang.Object):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0085 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0007 A[SYNTHETIC] */
        /* renamed from: ۧ۠ۤ۟ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static android.widget.Toast m552(java.lang.Object r7, java.lang.Object r8, int r9) {
            /*
                r6 = 0
                r3 = 0
                java.lang.String r0 = "۠۠ۦ"
                r1 = r0
                r2 = r3
                r4 = r3
            L7:
                int r0 = gt.md.C0799.m1158(r1)
                r5 = 1754504(0x1ac588, float:2.458584E-39)
                r0 = r0 ^ r5
                switch(r0) {
                    case 104: goto L13;
                    case 1262: goto L17;
                    case 3147: goto L5b;
                    case 28241: goto L9a;
                    case 28340: goto L3a;
                    case 28396: goto L7f;
                    case 28488: goto L65;
                    case 28526: goto L1b;
                    case 29335: goto L8a;
                    case 29672: goto L72;
                    case 32712: goto L13;
                    default: goto L12;
                }
            L12:
                goto L7
            L13:
                java.lang.String r0 = "۠ۨۡ"
                r1 = r0
                goto L7
            L17:
                java.lang.String r0 = "ۧۦ۟"
                r1 = r0
                goto L7
            L1b:
                r0 = 75667(0x12793, float:1.06032E-40)
                java.lang.Object[] r5 = new java.lang.Object[r6]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r3, r5)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 > 0) goto L7f
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L36
                java.lang.String r0 = "ۤۢ۟"
                r1 = r0
                goto L7
            L36:
                java.lang.String r0 = "ۣ۠۟"
                r1 = r0
                goto L7
            L3a:
                r1 = 10848(0x2a60, float:1.5201E-41)
                r0 = 3
                java.lang.Object[] r4 = new java.lang.Object[r0]
                r0 = r7
                android.content.Context r0 = (android.content.Context) r0
                r4[r6] = r0
                r5 = 1
                r0 = r8
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r4[r5] = r0
                r0 = 2
                java.lang.Integer r5 = java.lang.Integer.valueOf(r9)
                r4[r0] = r5
                java.lang.Object r0 = com.transsion.subroom.premium.C0684.n(r1, r3, r4)
                android.widget.Toast r0 = (android.widget.Toast) r0
                java.lang.String r1 = "۠۟۟"
                r4 = r0
                goto L7
            L5b:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 != 0) goto L7
                java.lang.String r0 = "ۣۢ۟"
                r1 = r0
                goto L7
            L65:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L6d
                r2 = r4
                goto L7
            L6d:
                java.lang.String r0 = "۠ۨۡ"
                r1 = r0
                r2 = r4
                goto L7
            L72:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L7a
                r2 = r3
                goto L7
            L7a:
                java.lang.String r0 = "ۦ۠۠"
                r1 = r0
                r2 = r3
                goto L7
            L7f:
                int r0 = androidx.core.C0079.m394()
                if (r0 >= 0) goto L7
                java.lang.String r0 = "ۨۧۢ"
                r1 = r0
                goto L7
            L8a:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L95
                com.transsion.subroom.activity.C0667.m874()
                goto L7
            L95:
                java.lang.String r0 = "۠۠ۦ"
                r1 = r0
                goto L7
            L9a:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m552(java.lang.Object, java.lang.Object, int):android.widget.Toast");
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0025, code lost:
        
            return (1750607 & r2) | ((r2 ^ (-1)) & (-1750608));
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object[]] */
        /* renamed from: ۨۤ۟ۢ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int m553() {
            /*
                Method dump skipped, instructions count: 292
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m553():int");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* renamed from: ۨۥۢ۠ */
        public static void m554(Object obj, Object obj2) {
            Object obj3 = "ۤۧۧ";
            while (true) {
                switch (C0799.m1158(obj3) ^ 1747905) {
                    case 265:
                        break;
                    case 1154:
                        C0684.n(50444, (Window) obj, new Object[]{(Drawable) obj2});
                        obj3 = "۠۟ۧ";
                    case 3134:
                    case 7485:
                        obj3 = "۠۟ۧ";
                    case 4357:
                        if (((Integer) C0685.n(42203, null, new Object[0])).intValue() > 0) {
                            obj3 = "ۣ۟۠";
                        } else if (C0799.m1162() > 0) {
                            obj3 = "ۡۥۧ";
                        }
                    case 7487:
                        if (C0078.m391() < 0) {
                            obj3 = "ۤۧۧ";
                        }
                    case 7621:
                        if (C0079.m394() >= 0) {
                            C0079.m394();
                        } else {
                            obj3 = "۟ۧۧ";
                        }
                    case 27104:
                        obj3 = "ۣ۟۠";
                }
                return;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0066 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0062 A[SYNTHETIC] */
        /* renamed from: ۨۥۨۤ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m555(java.lang.Object r5, java.lang.Object r6) {
            /*
                r4 = 0
                java.lang.String r0 = "ۨۢ"
                r1 = r0
            L4:
                int r0 = gt.md.C0799.m1158(r1)
                r2 = 1751531(0x1ab9eb, float:2.454418E-39)
                r0 = r0 ^ r2
                switch(r0) {
                    case 2768: goto L10;
                    case 3916: goto L78;
                    case 4619: goto L78;
                    case 28744: goto L6a;
                    case 31694: goto L5c;
                    case 31937: goto L8a;
                    case 1729809: goto L3c;
                    case 1729813: goto L1a;
                    default: goto Lf;
                }
            Lf:
                goto L4
            L10:
                int r0 = androidx.core.C0079.m394()
                if (r0 >= 0) goto L4
                java.lang.String r0 = "ۣۤۨ"
                r1 = r0
                goto L4
            L1a:
                r2 = 51721(0xca09, float:7.2477E-41)
                r0 = r5
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
                r1 = 1
                java.lang.Object[] r3 = new java.lang.Object[r1]
                r1 = r6
                java.lang.String r1 = (java.lang.String) r1
                r3[r4] = r1
                com.transsion.subroom.premium.C0684.n(r2, r0, r3)
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L38
                androidx.core.C0078.m391()
                java.lang.String r0 = "ۡۦۨ"
                r1 = r0
                goto L4
            L38:
                java.lang.String r0 = "ۣۧ۠"
                r1 = r0
                goto L4
            L3c:
                r0 = 75667(0x12793, float:1.06032E-40)
                r2 = 0
                java.lang.Object[] r3 = new java.lang.Object[r4]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r2, r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 >= 0) goto L5c
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L58
                gt.md.C0799.m1162()
                goto L4
            L58:
                java.lang.String r0 = "ۨۦ"
                r1 = r0
                goto L4
            L5c:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L66
                androidx.core.appcompat.C0066.m207()
                goto L4
            L66:
                java.lang.String r0 = "ۢۧ۠"
                r1 = r0
                goto L4
            L6a:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L74
                androidx.core.C0078.m391()
                goto L4
            L74:
                java.lang.String r0 = "ۨۢ"
                r1 = r0
                goto L4
            L78:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L85
                gt.md.C0799.m1162()
                java.lang.String r0 = "ۡۤۧ"
                r1 = r0
                goto L4
            L85:
                java.lang.String r0 = "ۣۧ۠"
                r1 = r0
                goto L4
            L8a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass5.m555(java.lang.Object, java.lang.Object):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        /* renamed from: ۨۦۡ */
        public static PackageManager m556(Object obj) {
            String str = "ۢ۠ۦ";
            PackageManager packageManager = null;
            PackageManager packageManager2 = null;
            while (true) {
                switch (C0799.m1158((Object) str) ^ 1749666) {
                    case 35:
                        if (C0799.m1162() <= 0) {
                            C0078.m391();
                        } else {
                            str = "ۢ۠ۦ";
                        }
                    case 92:
                        str = "۠ۡ۠";
                    case AD_CONSUMED_VALUE:
                        str = ((Integer) C0685.n(98787, null, new Object[0])).intValue() <= 0 ? "ۦ۠ۧ" : "ۧۦ۟";
                    case 1189:
                    case 6237:
                        if (C0799.m1162() > 0) {
                            str = "۟ۧۨ";
                        }
                    case 2082:
                    case 6434:
                        if (C0799.m1162() <= 0) {
                            C0078.m391();
                            packageManager = null;
                        } else {
                            str = "ۢۥۡ";
                            packageManager = null;
                        }
                    case 6818:
                        break;
                    case 29647:
                        PackageManager packageManager3 = (PackageManager) C0684.n(92169, (Context) obj, new Object[0]);
                        if (C0667.m874() >= 0) {
                            packageManager2 = packageManager3;
                            str = "۟ۡۦ";
                        } else {
                            packageManager2 = packageManager3;
                            str = "ۨ۟ۤ";
                        }
                    case 30530:
                        str = "۠ۥۥ";
                    case 31343:
                        if (C0078.m391() >= 0) {
                            C0066.m207();
                            str = "ۨۢۧ";
                            packageManager = packageManager2;
                        } else {
                            str = "۟ۧۨ";
                            packageManager = packageManager2;
                        }
                }
                return packageManager;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* renamed from: ۨۧۤ */
        public static void m557(Object obj, Object obj2) {
            String str = "ۥۨۨ";
            while (true) {
                switch (C0799.m1158(str) ^ 1752581) {
                    case 6:
                        C0684.n(39581, (Context) obj, new Object[]{(Intent) obj2});
                        if (C0078.m391() >= 0) {
                            C0078.m391();
                        } else {
                            str = "ۡۢۡ";
                        }
                    case 160:
                        if (((Integer) C0685.n(42203, null, new Object[0])).intValue() >= 0) {
                            str = "ۨ۟ۥ";
                        } else if (C0066.m207() != 0) {
                            C0799.m1162();
                        } else {
                            str = "ۥۣۡ";
                        }
                    case 1026:
                    case 1059:
                        str = "ۡۢۡ";
                    case 3387:
                        str = "ۥۨۨ";
                    case 4325:
                        break;
                    case 30411:
                        str = C0066.m207() != 0 ? "ۨۦۧ" : "ۤۡۤ";
                    case 32585:
                        str = "ۨ۟ۥ";
                }
                return;
            }
        }
    }

    /* renamed from: androidx.preference.layout2$6 */
    /* loaded from: classes7.dex */
    public class AnonymousClass6 {

        /* renamed from: short */
        private static final short[] f24short = {784, 794, 813};

        /* renamed from: ۣ۠۟۠ */
        public static int f25 = -54;

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0057 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0053 A[SYNTHETIC] */
        /* renamed from: ۟۟۟ۦ۠ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m558(java.lang.Object r5) {
            /*
                r4 = 0
                java.lang.String r0 = "۠ۦۤ"
                r1 = r0
            L4:
                int r0 = gt.md.C0799.m1158(r1)
                r2 = 1753544(0x1ac1c8, float:2.457239E-39)
                r0 = r0 ^ r2
                switch(r0) {
                    case 128: goto L10;
                    case 2189: goto L77;
                    case 2241: goto L69;
                    case 27222: goto L2d;
                    case 28372: goto L5b;
                    case 29396: goto L5b;
                    case 31604: goto L4d;
                    case 31787: goto L29;
                    default: goto Lf;
                }
            Lf:
                goto L4
            L10:
                r2 = 91109(0x163e5, float:1.27671E-40)
                r0 = r5
                java.io.BufferedReader r0 = (java.io.BufferedReader) r0
                java.lang.Object[] r3 = new java.lang.Object[r4]
                com.transsion.subroom.premium.C0684.n(r2, r0, r3)
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L25
                com.transsion.subroom.activity.C0667.m874()
                goto L4
            L25:
                java.lang.String r0 = "ۣۨ۠"
                r1 = r0
                goto L4
            L29:
                java.lang.String r0 = "ۢۦ۠"
                r1 = r0
                goto L4
            L2d:
                r0 = 75667(0x12793, float:1.06032E-40)
                r1 = 0
                java.lang.Object[] r2 = new java.lang.Object[r4]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r1, r2)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 >= 0) goto L4d
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 < 0) goto L49
                java.lang.String r0 = "ۨۡۢ"
                r1 = r0
                goto L4
            L49:
                java.lang.String r0 = "ۦ۟ۡ"
                r1 = r0
                goto L4
            L4d:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L57
                java.lang.String r0 = "ۣۦۥ"
                r1 = r0
                goto L4
            L57:
                java.lang.String r0 = "ۥۢ۠"
                r1 = r0
                goto L4
            L5b:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L65
                androidx.core.appcompat.C0066.m207()
                goto L4
            L65:
                java.lang.String r0 = "ۣۨ۠"
                r1 = r0
                goto L4
            L69:
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L73
                androidx.core.C0079.m394()
                goto L4
            L73:
                java.lang.String r0 = "۠ۦۤ"
                r1 = r0
                goto L4
            L77:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m558(java.lang.Object):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
        /* renamed from: ۣ۟۟ۦ۠ */
        public static PackageInfo m559(Object obj, Object obj2, int i11) {
            Object obj3 = "۠ۡۤ";
            PackageInfo packageInfo = null;
            PackageInfo packageInfo2 = null;
            while (true) {
                switch (C0799.m1158(obj3) ^ 1750782) {
                    case 97:
                    case 6175:
                        if (C0079.m394() >= 0) {
                            C0066.m207();
                            obj3 = "۠ۢ۠";
                        } else {
                            obj3 = "ۧۤۥ";
                        }
                    case DownloadException.EXCEPTION_IO_MALFORMED_URL /* 508 */:
                        obj3 = "ۧۤۥ";
                        packageInfo = packageInfo2;
                    case 2898:
                        obj3 = "ۣۧ۠";
                    case 3319:
                        obj3 = "۠ۡۤ";
                    case 3890:
                        if (C0078.m391() >= 0) {
                            C0799.m1162();
                            packageInfo = null;
                        } else {
                            obj3 = "۠ۧۡ";
                            packageInfo = null;
                        }
                    case 7222:
                        PackageInfo packageInfo3 = (PackageInfo) C0684.n(98806, (PackageManager) obj, new Object[]{(String) obj2, Integer.valueOf(i11)});
                        if (C0066.m207() != 0) {
                            C0667.m874();
                            packageInfo2 = packageInfo3;
                        } else {
                            obj3 = "ۣۧۦ";
                            packageInfo2 = packageInfo3;
                        }
                    case 7492:
                        if (C0079.m394() >= 0) {
                            C0066.m207();
                        } else {
                            obj3 = "ۡۢۢ";
                        }
                    case 7677:
                        if (((Integer) C0685.n(42203, null, new Object[0])).intValue() > 0) {
                            obj3 = "ۣۧ۠";
                        } else if (C0078.m391() < 0) {
                            obj3 = "۠۟ۧ";
                        }
                    case 29526:
                        break;
                    case 29652:
                        if (C0799.m1162() > 0) {
                            obj3 = "ۤ۟ۧ";
                        }
                }
                return packageInfo;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0060 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0004 A[SYNTHETIC] */
        /* renamed from: ۟۠ۡۥۧ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m560(java.lang.Object r5, java.lang.Object r6) {
            /*
                r4 = 0
                java.lang.String r0 = "ۦۨۨ"
                r1 = r0
            L4:
                int r0 = gt.md.C0799.m1158(r1)
                r2 = 1747716(0x1aab04, float:2.449072E-39)
                r0 = r0 ^ r2
                switch(r0) {
                    case 153: goto L10;
                    case 1150: goto L64;
                    case 5511: goto L4c;
                    case 7520: goto L5a;
                    case 7552: goto L4c;
                    case 25155: goto L6e;
                    case 26978: goto L36;
                    case 1734629: goto L25;
                    default: goto Lf;
                }
            Lf:
                goto L4
            L10:
                r2 = 38317(0x95ad, float:5.3694E-41)
                r0 = r5
                android.widget.TextView r0 = (android.widget.TextView) r0
                r1 = 1
                java.lang.Object[] r3 = new java.lang.Object[r1]
                r1 = r6
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r3[r4] = r1
                com.transsion.subroom.premium.C0684.n(r2, r0, r3)
                java.lang.String r0 = "ۣۨۢ"
                r1 = r0
                goto L4
            L25:
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L32
                androidx.core.C0079.m394()
                java.lang.String r0 = "ۢۧ۟"
                r1 = r0
                goto L4
            L32:
                java.lang.String r0 = "ۥۧۥ"
                r1 = r0
                goto L4
            L36:
                r0 = 75667(0x12793, float:1.06032E-40)
                r2 = 0
                java.lang.Object[] r3 = new java.lang.Object[r4]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r2, r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 > 0) goto L5a
                java.lang.String r0 = "۠ۦۣ"
                r1 = r0
                goto L4
            L4c:
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 < 0) goto L56
                androidx.core.appcompat.C0066.m207()
                goto L4
            L56:
                java.lang.String r0 = "ۣۨۢ"
                r1 = r0
                goto L4
            L5a:
                int r0 = gt.md.C0799.m1162()
                if (r0 <= 0) goto L4
                java.lang.String r0 = "ۧۨ"
                r1 = r0
                goto L4
            L64:
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 >= 0) goto L4
                java.lang.String r0 = "ۦۨۨ"
                r1 = r0
                goto L4
            L6e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m560(java.lang.Object, java.lang.Object):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0063 A[SYNTHETIC] */
        /* renamed from: ۟ۡۧۡۤ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m561(java.lang.Object r5, java.lang.Object r6) {
            /*
                r4 = 0
                java.lang.String r0 = "ۣۧ۠"
                r1 = r0
            L4:
                int r0 = gt.md.C0799.m1158(r1)
                r2 = 1747688(0x1aaae8, float:2.449033E-39)
                r0 = r0 ^ r2
                switch(r0) {
                    case 428: goto L10;
                    case 1517: goto L5f;
                    case 3400: goto L32;
                    case 3444: goto L6b;
                    case 5953: goto L67;
                    case 6283: goto L5f;
                    case 26825: goto L1d;
                    case 28524: goto L40;
                    default: goto Lf;
                }
            Lf:
                goto L4
            L10:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L63
                com.transsion.subroom.activity.C0667.m874()
                java.lang.String r0 = "ۤۦۣ"
                r1 = r0
                goto L4
            L1d:
                r2 = 63704(0xf8d8, float:8.9268E-41)
                r0 = r5
                android.widget.ImageView r0 = (android.widget.ImageView) r0
                r1 = 1
                java.lang.Object[] r3 = new java.lang.Object[r1]
                r1 = r6
                android.view.ViewGroup$LayoutParams r1 = (android.view.ViewGroup.LayoutParams) r1
                r3[r4] = r1
                com.transsion.subroom.premium.C0684.n(r2, r0, r3)
                java.lang.String r0 = "۟ۤۡ"
                r1 = r0
                goto L4
            L32:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L3c
                androidx.core.C0078.m391()
                goto L4
            L3c:
                java.lang.String r0 = "ۣۡۧ"
                r1 = r0
                goto L4
            L40:
                r0 = 21970(0x55d2, float:3.0787E-41)
                r2 = 0
                java.lang.Object[] r3 = new java.lang.Object[r4]
                java.lang.Object r0 = com.transsion.subroom.premium.C0684.n(r0, r2, r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 > 0) goto L10
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L5b
                androidx.core.C0078.m391()
                goto L4
            L5b:
                java.lang.String r0 = "ۦۦۡ"
                r1 = r0
                goto L4
            L5f:
                java.lang.String r0 = "۟ۤۡ"
                r1 = r0
                goto L4
            L63:
                java.lang.String r0 = "۟ۤۥ"
                r1 = r0
                goto L4
            L67:
                java.lang.String r0 = "ۣۧ۠"
                r1 = r0
                goto L4
            L6b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m561(java.lang.Object, java.lang.Object):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0010. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d1 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00cc A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00e4 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00dc A[SYNTHETIC] */
        /* renamed from: ۟ۢ۠ۦ۟ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m562(java.lang.Object r9, java.lang.Object r10) {
            /*
                Method dump skipped, instructions count: 300
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m562(java.lang.Object, java.lang.Object):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:39:0x008b A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0084 A[SYNTHETIC] */
        /* renamed from: ۟ۢۡ۠ۤ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static android.content.Intent m563(java.lang.Object r8, java.lang.Object r9) {
            /*
                r6 = 0
                r3 = 0
                java.lang.String r0 = "ۡۧ"
                r2 = r3
                r1 = r3
            L6:
                int r4 = gt.md.C0799.m1158(r0)
                r5 = 1747872(0x1aaba0, float:2.44929E-39)
                r4 = r4 ^ r5
                switch(r4) {
                    case 24: goto L12;
                    case 64: goto L1b;
                    case 224: goto L8f;
                    case 6630: goto L12;
                    case 7359: goto L7b;
                    case 7657: goto L28;
                    case 25193: goto L7e;
                    case 27046: goto L34;
                    case 28333: goto L61;
                    case 1734428: goto L58;
                    case 1734534: goto L38;
                    default: goto L11;
                }
            L11:
                goto L6
            L12:
                int r4 = androidx.core.appcompat.C0066.m207()
                if (r4 != 0) goto L6
                java.lang.String r0 = "ۣۣ۠"
                goto L6
            L1b:
                int r4 = androidx.core.C0079.m394()
                if (r4 < 0) goto L25
                gt.md.C0799.m1162()
                goto L6
            L25:
                java.lang.String r0 = "ۦۥۥ"
                goto L6
            L28:
                int r2 = com.transsion.subroom.activity.C0667.m874()
                if (r2 < 0) goto L30
                r2 = r1
                goto L6
            L30:
                java.lang.String r0 = "ۣۣ۠"
                r2 = r1
                goto L6
            L34:
                java.lang.String r0 = "ۦۢ"
                r2 = r3
                goto L6
            L38:
                r0 = 42203(0xa4db, float:5.9139E-41)
                java.lang.Object[] r4 = new java.lang.Object[r6]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r3, r4)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 >= 0) goto L7e
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L55
                androidx.core.C0079.m394()
                java.lang.String r0 = "ۡۧۢ"
                goto L6
            L55:
                java.lang.String r0 = "ۧ۟ۥ"
                goto L6
            L58:
                int r4 = androidx.core.C0079.m394()
                if (r4 >= 0) goto L6
                java.lang.String r0 = "۠ۧ۟"
                goto L6
            L61:
                r4 = 87695(0x1568f, float:1.22887E-40)
                r0 = r8
                android.content.Intent r0 = (android.content.Intent) r0
                r1 = 1
                java.lang.Object[] r5 = new java.lang.Object[r1]
                r1 = r9
                android.net.Uri r1 = (android.net.Uri) r1
                r5[r6] = r1
                java.lang.Object r0 = com.transsion.subroom.premium.C0669.n(r4, r0, r5)
                android.content.Intent r0 = (android.content.Intent) r0
                java.lang.String r1 = "ۣۡۧ"
                r7 = r1
                r1 = r0
                r0 = r7
                goto L6
            L7b:
                java.lang.String r0 = "ۡۧ"
                goto L6
            L7e:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L8b
                androidx.core.C0078.m391()
                java.lang.String r0 = "ۧۧۧ"
                goto L6
            L8b:
                java.lang.String r0 = "۠ۨۨ"
                goto L6
            L8f:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m563(java.lang.Object, java.lang.Object):android.content.Intent");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0010. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0099 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0008 A[SYNTHETIC] */
        /* renamed from: ۟ۢۢۤۨ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static float m564() {
            /*
                r7 = 0
                r6 = 0
                r3 = 0
                java.lang.String r0 = "ۢۧۦ"
                r1 = r0
                r2 = r3
                r4 = r3
            L8:
                int r0 = gt.md.C0799.m1158(r1)
                r5 = 1753508(0x1ac1a4, float:2.457188E-39)
                r0 = r0 ^ r5
                switch(r0) {
                    case 1039: goto L14;
                    case 1093: goto Lae;
                    case 1959: goto L9e;
                    case 2054: goto L1e;
                    case 2156: goto L9e;
                    case 27491: goto L70;
                    case 28377: goto L4d;
                    case 28484: goto L3a;
                    case 28486: goto L80;
                    case 29413: goto L5b;
                    case 1710656: goto L93;
                    default: goto L13;
                }
            L13:
                goto L8
            L14:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L57
                java.lang.String r0 = "ۨۦۡ"
                r1 = r0
                goto L8
            L1e:
                r0 = 26920(0x6928, float:3.7723E-41)
                java.lang.Object[] r4 = new java.lang.Object[r6]
                java.lang.Object r0 = com.transsion.subroom.premium.C0669.n(r0, r7, r4)
                java.lang.Float r0 = (java.lang.Float) r0
                float r4 = r0.floatValue()
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L36
                androidx.core.C0078.m391()
                goto L8
            L36:
                java.lang.String r0 = "۠۟ۦ"
                r1 = r0
                goto L8
            L3a:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L48
                androidx.core.C0078.m391()
                java.lang.String r0 = "ۡۨ۠"
                r1 = r0
                r2 = r3
                goto L8
            L48:
                java.lang.String r0 = "ۣۡۧ"
                r1 = r0
                r2 = r3
                goto L8
            L4d:
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 >= 0) goto L8
                java.lang.String r0 = "ۨۧۧ"
                r1 = r0
                goto L8
            L57:
                java.lang.String r0 = "ۡۢۡ"
                r1 = r0
                goto L8
            L5b:
                r0 = 75667(0x12793, float:1.06032E-40)
                java.lang.Object[] r5 = new java.lang.Object[r6]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r7, r5)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 > 0) goto L93
                java.lang.String r0 = "ۨۦ۠"
                r1 = r0
                goto L8
            L70:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L7b
                java.lang.String r0 = "۠ۨۥ"
                r1 = r0
                r2 = r4
                goto L8
            L7b:
                java.lang.String r0 = "ۧۦ۠"
                r1 = r0
                r2 = r4
                goto L8
            L80:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L8e
                gt.md.C0799.m1162()
                java.lang.String r0 = "ۤۡۢ"
                r1 = r0
                goto L8
            L8e:
                java.lang.String r0 = "ۢۧۦ"
                r1 = r0
                goto L8
            L93:
                int r0 = androidx.core.C0078.m391()
                if (r0 >= 0) goto L8
                java.lang.String r0 = "ۧۤۨ"
                r1 = r0
                goto L8
            L9e:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto La9
                java.lang.String r0 = "۠ۨ۠"
                r1 = r0
                goto L8
            La9:
                java.lang.String r0 = "ۧۦ۠"
                r1 = r0
                goto L8
            Lae:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m564():float");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0010. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:64:0x00ab A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x00a4 A[SYNTHETIC] */
        /* renamed from: ۣۣ۟ۢۢ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.String m565(short[] r8, int r9, int r10, int r11) {
            /*
                r2 = 0
                r1 = 0
                java.lang.String r0 = "ۡۤ۟"
                r3 = r2
                r4 = r2
                r5 = r1
                r1 = r2
            L8:
                int r6 = gt.md.C0799.m1158(r0)
                r7 = 1753546(0x1ac1ca, float:2.457241E-39)
                r6 = r6 ^ r7
                switch(r6) {
                    case 35: goto L14;
                    case 1218: goto L42;
                    case 26349: goto L24;
                    case 27274: goto L7a;
                    case 27374: goto L28;
                    case 27405: goto L6a;
                    case 28296: goto L6d;
                    case 28374: goto L59;
                    case 29323: goto L49;
                    case 29334: goto L9a;
                    case 29453: goto L64;
                    case 29556: goto L9e;
                    case 30633: goto L89;
                    case 32749: goto L89;
                    default: goto L13;
                }
            L13:
                goto L8
            L14:
                int r1 = 0 - r4
                int r1 = r1 + (-1)
                int r1 = 0 - r1
                int r6 = androidx.core.C0079.m394()
                if (r6 < 0) goto L46
                gt.md.C0799.m1162()
                goto L8
            L24:
                java.lang.String r0 = "ۣۣ۠"
                r4 = r2
                goto L8
            L28:
                r0 = r3 ^ (-1)
                r0 = r0 & r11
                r6 = r11 ^ (-1)
                r6 = r6 & r3
                r0 = r0 | r6
                char r0 = (char) r0
                char r0 = (char) r0
                r5[r4] = r0
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L3f
                androidx.core.appcompat.C0066.m207()
                java.lang.String r0 = "ۣۣۨ"
                goto L8
            L3f:
                java.lang.String r0 = "ۦۤۧ"
                goto L8
            L42:
                java.lang.String r0 = "۠۟ۦ"
                r4 = r1
                goto L8
            L46:
                java.lang.String r0 = "ۧ۟۠"
                goto L8
            L49:
                int r3 = r9 + 19
                int r3 = r3 + r4
                int r3 = r3 + (-19)
                short r3 = r8[r3]
                int r6 = com.transsion.subroom.activity.C0667.m874()
                if (r6 >= 0) goto L8
                java.lang.String r0 = "۠ۢۦ"
                goto L8
            L59:
                char[] r5 = new char[r10]
                int r6 = gt.md.C0799.m1162()
                if (r6 <= 0) goto L8
                java.lang.String r0 = "ۡۥۦ"
                goto L8
            L64:
                java.lang.String r0 = new java.lang.String
                r0.<init>(r5)
                return r0
            L6a:
                java.lang.String r0 = "ۣۢۢ"
                goto L8
            L6d:
                int r6 = androidx.core.C0079.m394()
                if (r6 < 0) goto L77
                androidx.core.appcompat.C0066.m207()
                goto L8
            L77:
                java.lang.String r0 = "۟۠ۨ"
                goto L8
            L7a:
                if (r4 >= r10) goto L9e
                int r6 = androidx.core.appcompat.C0066.m207()
                if (r6 == 0) goto L86
                com.transsion.subroom.activity.C0667.m874()
                goto L8
            L86:
                java.lang.String r0 = "ۢۧۦ"
                goto L8
            L89:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L96
                androidx.core.appcompat.C0066.m207()
                java.lang.String r0 = "ۦ۠ۡ"
                goto L8
            L96:
                java.lang.String r0 = "ۣۣ۠"
                goto L8
            L9a:
                java.lang.String r0 = "ۡۤ۟"
                goto L8
            L9e:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto Lab
                androidx.core.C0078.m391()
                java.lang.String r0 = "ۤۡۦ"
                goto L8
            Lab:
                java.lang.String r0 = "ۣۢۨ"
                goto L8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m565(short[], int, int, int):java.lang.String");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0067 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0004 A[SYNTHETIC] */
        /* renamed from: ۟ۢۥۤ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m566(java.lang.Object r6, int r7) {
            /*
                r5 = 0
                java.lang.String r0 = "ۤۦۤ"
                r1 = r0
            L4:
                int r0 = gt.md.C0799.m1158(r1)
                r2 = 56381(0xdc3d, float:7.9007E-41)
                r0 = r0 ^ r2
                switch(r0) {
                    case 162: goto L10;
                    case 225: goto L14;
                    case 1728980: goto L61;
                    case 1729123: goto L6b;
                    case 1730207: goto L22;
                    case 1730296: goto L5d;
                    case 1734430: goto L5d;
                    case 1735518: goto L42;
                    default: goto Lf;
                }
            Lf:
                goto L4
            L10:
                java.lang.String r0 = "ۤۦۤ"
                r1 = r0
                goto L4
            L14:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L1e
                java.lang.String r0 = "ۨۦ۠"
                r1 = r0
                goto L4
            L1e:
                java.lang.String r0 = "۠ۢۥ"
                r1 = r0
                goto L4
            L22:
                r0 = 42203(0xa4db, float:5.9139E-41)
                r2 = 0
                java.lang.Object[] r3 = new java.lang.Object[r5]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r2, r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 >= 0) goto L61
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L3e
                androidx.core.C0078.m391()
                goto L4
            L3e:
                java.lang.String r0 = "۟ۢۦ"
                r1 = r0
                goto L4
            L42:
                r2 = 31678(0x7bbe, float:4.439E-41)
                r0 = r6
                androidx.preference.layout2 r0 = (androidx.preference.layout2) r0
                r3 = 1
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
                r3[r5] = r4
                com.transsion.subroom.premium.C0669.n(r2, r0, r3)
                int r0 = androidx.core.C0078.m391()
                if (r0 >= 0) goto L4
                java.lang.String r0 = "ۥۦ۟"
                r1 = r0
                goto L4
            L5d:
                java.lang.String r0 = "ۥۦ۟"
                r1 = r0
                goto L4
            L61:
                int r0 = androidx.core.C0079.m394()
                if (r0 >= 0) goto L4
                java.lang.String r0 = "ۣۧ"
                r1 = r0
                goto L4
            L6b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m566(java.lang.Object, int):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* renamed from: ۣ۟۠ۥۧ */
        public static void m567(Object obj) {
            String str = "ۦ۟ۡ";
            while (true) {
                switch (C0799.m1158(str) ^ 1748866) {
                    case 1052:
                        break;
                    case 1347:
                        str = "ۦ۟ۡ";
                    case 4381:
                    case 7548:
                        str = "۠ۦۤ";
                    case 5569:
                        if (C0667.m874() >= 0) {
                            C0066.m207();
                        } else {
                            str = "ۥۨۢ";
                        }
                    case 5606:
                        C0669.n(1053, (Toast) obj, new Object[0]);
                        if (C0079.m394() < 0) {
                            str = "۠ۦۤ";
                        }
                    case 6400:
                    case 28362:
                        str = ((Integer) C0684.n(21970, null, new Object[0])).intValue() <= 0 ? "ۤۤۤ" : "ۣۤۢ";
                }
                return;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:14:0x00be A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00b9 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00e1 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00dc A[SYNTHETIC] */
        /* renamed from: ۟ۥ۟ۨۨ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m568(java.lang.Object r8, boolean r9) {
            /*
                Method dump skipped, instructions count: 282
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m568(java.lang.Object, boolean):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x006d, code lost:
        
            return (1749766 & r2) | ((r2 ^ (-1)) & (-1749767));
         */
        /* renamed from: ۟ۥۡ۠ۡ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int m569() {
            /*
                Method dump skipped, instructions count: 286
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m569():int");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0010. Please report as an issue. */
        /* renamed from: ۟ۥۢۡۦ */
        public static float m570() {
            String str = "ۣۡۥ";
            float f11 = 0.0f;
            float f12 = 0.0f;
            while (true) {
                switch (C0799.m1158(str) ^ 56351) {
                    case 1711704:
                        break;
                    case 1729081:
                        if (C0066.m207() != 0) {
                            C0078.m391();
                            str = "ۣ۟ۤ";
                        } else {
                            str = "ۣۡۥ";
                        }
                    case 1729114:
                        if (C0078.m391() >= 0) {
                            C0079.m394();
                        } else {
                            str = "ۢۡۦ";
                        }
                    case 1730207:
                        if (C0667.m874() >= 0) {
                            C0078.m391();
                            str = "ۥۣۡ";
                            f11 = f12;
                        } else {
                            str = "ۦۧۨ";
                            f11 = f12;
                        }
                    case 1731160:
                        if (((Integer) C0685.n(75667, null, new Object[0])).intValue() > 0) {
                            str = "ۥۥۥ";
                        } else if (C0066.m207() != 0) {
                            C0078.m391();
                        } else {
                            str = "ۢۡۤ";
                        }
                    case 1732219:
                    case 1734527:
                        str = C0799.m1162() <= 0 ? "ۥۢۡ" : "ۦۧۨ";
                    case 1732248:
                        str = "ۣ۟۠";
                        f11 = 0.0f;
                    case 1732250:
                        f12 = ((Float) C0669.n(91027, null, new Object[0])).floatValue();
                        if (C0667.m874() < 0) {
                            str = "ۤۥۡ";
                        }
                    case 1732380:
                        str = "ۥۥۥ";
                    case 1735523:
                        if (C0799.m1162() > 0) {
                            str = "۠ۤۤ";
                        }
                }
                return f11;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* renamed from: ۟ۥۣۢۧ */
        public static void m571(Object obj, int i11, int i12, int i13, int i14) {
            String str = "ۤ۟ۨ";
            while (true) {
                switch (C0799.m1158(str) ^ 1749703) {
                    case 79:
                        if (C0078.m391() >= 0) {
                            C0078.m391();
                        } else {
                            str = "ۤ۟ۨ";
                        }
                    case 161:
                    case 2819:
                        str = "ۧۥۤ";
                    case 2151:
                        str = C0078.m391() >= 0 ? "ۣۡۥ" : "ۢ۠ۤ";
                    case 2826:
                        if (((Integer) C0685.n(42203, null, new Object[0])).intValue() > 0) {
                            str = "ۤۦۢ";
                        } else if (C0078.m391() >= 0) {
                            C0079.m394();
                        } else {
                            str = "ۡۨۡ";
                        }
                    case 7517:
                        C0669.n(90631, (LinearLayout.LayoutParams) obj, new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)});
                        if (C0066.m207() == 0) {
                            str = "ۧۥۤ";
                        }
                    case 30465:
                        break;
                    case 1732323:
                        str = "ۤۦۢ";
                }
                return;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* renamed from: ۟ۦۦۥۤ */
        public static void m572(Object obj) {
            String str = "ۡۢ۠";
            while (true) {
                switch (C0799.m1158(str) ^ 1752608) {
                    case 906:
                    case 1001:
                    case 30757:
                        str = C0799.m1162() <= 0 ? "ۥۨۥ" : "ۧۢۨ";
                    case 1089:
                        C0669.n(85916, (Dialog) obj, new Object[0]);
                        if (C0667.m874() >= 0) {
                            C0079.m394();
                        } else {
                            str = "ۧۢۨ";
                        }
                    case 2363:
                        str = "ۥۡۥ";
                    case 4351:
                        str = ((Integer) C0685.n(98787, null, new Object[0])).intValue() < 0 ? C0667.m874() >= 0 ? "ۢ۟۟" : "ۤۤۡ" : "ۣۨ۠";
                    case 31565:
                        break;
                    case 1729121:
                        if (C0667.m874() < 0) {
                            str = "ۡۢ۠";
                        }
                }
                return;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0010. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00f1 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00ec A[SYNTHETIC] */
        /* renamed from: ۟ۧۧۧۨ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m573(java.lang.Object r9) {
            /*
                Method dump skipped, instructions count: 298
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m573(java.lang.Object):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0060 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x005c A[SYNTHETIC] */
        /* renamed from: ۠۟ۥۥ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m574(java.lang.Object r6, float r7) {
            /*
                r5 = 0
                java.lang.String r0 = "ۦۧۥ"
                r1 = r0
            L4:
                int r0 = gt.md.C0799.m1158(r1)
                r2 = 1753538(0x1ac1c2, float:2.45723E-39)
                r0 = r0 ^ r2
                switch(r0) {
                    case 902: goto L10;
                    case 996: goto L3a;
                    case 1059: goto L2c;
                    case 26365: goto L75;
                    case 27258: goto L56;
                    case 28381: goto L75;
                    case 30530: goto L83;
                    case 1711589: goto L64;
                    default: goto Lf;
                }
            Lf:
                goto L4
            L10:
                r0 = 75667(0x12793, float:1.06032E-40)
                r2 = 0
                java.lang.Object[] r3 = new java.lang.Object[r5]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r2, r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 > 0) goto L56
                int r0 = androidx.core.C0078.m391()
                if (r0 >= 0) goto L4
                java.lang.String r0 = "ۦۦۦ"
                r1 = r0
                goto L4
            L2c:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L36
                gt.md.C0799.m1162()
                goto L4
            L36:
                java.lang.String r0 = "ۡۤۢ"
                r1 = r0
                goto L4
            L3a:
                r2 = 47730(0xba72, float:6.6884E-41)
                r0 = r6
                android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
                r3 = 1
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.Float r4 = java.lang.Float.valueOf(r7)
                r3[r5] = r4
                com.transsion.subroom.premium.C0669.n(r2, r0, r3)
                int r0 = gt.md.C0799.m1162()
                if (r0 <= 0) goto L4
                java.lang.String r0 = "ۣۣ۠"
                r1 = r0
                goto L4
            L56:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L60
                androidx.core.C0079.m394()
                goto L4
            L60:
                java.lang.String r0 = "ۧۦ۠"
                r1 = r0
                goto L4
            L64:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L71
                androidx.core.appcompat.C0066.m207()
                java.lang.String r0 = "۟ۧۧ"
                r1 = r0
                goto L4
            L71:
                java.lang.String r0 = "ۦۧۥ"
                r1 = r0
                goto L4
            L75:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L7f
                androidx.core.appcompat.C0066.m207()
                goto L4
            L7f:
                java.lang.String r0 = "ۣۣ۠"
                r1 = r0
                goto L4
            L83:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m574(java.lang.Object, float):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:32:0x008d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0088 A[SYNTHETIC] */
        /* renamed from: ۣ۠۠ۨ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int m575(java.lang.Object r7, java.lang.Object r8) {
            /*
                r3 = 0
                java.lang.String r0 = "۟ۧۤ"
                r1 = r0
                r2 = r3
                r4 = r3
            L6:
                int r0 = gt.md.C0799.m1158(r1)
                r5 = 56443(0xdc7b, float:7.9093E-41)
                r0 = r0 ^ r5
                switch(r0) {
                    case 163: goto L12;
                    case 1947: goto L75;
                    case 1710359: goto L92;
                    case 1710682: goto L7e;
                    case 1729082: goto L1a;
                    case 1731076: goto L67;
                    case 1731132: goto L7e;
                    case 1732254: goto La5;
                    case 1733342: goto L82;
                    case 1735559: goto L48;
                    case 1735564: goto L1f;
                    default: goto L11;
                }
            L11:
                goto L6
            L12:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L79
                r2 = r3
                goto L6
            L1a:
                java.lang.String r0 = "ۢۤۧ"
                r1 = r0
                r2 = r4
                goto L6
            L1f:
                r4 = 93518(0x16d4e, float:1.31047E-40)
                r0 = r7
                android.view.WindowManager$LayoutParams r0 = (android.view.WindowManager.LayoutParams) r0
                r1 = 1
                java.lang.Object[] r5 = new java.lang.Object[r1]
                r1 = r8
                android.view.WindowManager$LayoutParams r1 = (android.view.WindowManager.LayoutParams) r1
                r5[r3] = r1
                java.lang.Object r0 = com.transsion.subroom.premium.C0669.n(r4, r0, r5)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r4 = r0.intValue()
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L44
                androidx.core.C0079.m394()
                java.lang.String r0 = "ۨۢۦ"
                r1 = r0
                goto L6
            L44:
                java.lang.String r0 = "ۥۥۡ"
                r1 = r0
                goto L6
            L48:
                r0 = 21970(0x55d2, float:3.0787E-41)
                r5 = 0
                java.lang.Object[] r6 = new java.lang.Object[r3]
                java.lang.Object r0 = com.transsion.subroom.premium.C0684.n(r0, r5, r6)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 > 0) goto L82
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L63
                com.transsion.subroom.activity.C0667.m874()
                goto L6
            L63:
                java.lang.String r0 = "۟ۧ۟"
                r1 = r0
                goto L6
            L67:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L71
                gt.md.C0799.m1162()
                goto L6
            L71:
                java.lang.String r0 = "ۣۡۥ"
                r1 = r0
                goto L6
            L75:
                java.lang.String r0 = "ۧ۟"
                r1 = r0
                goto L6
            L79:
                java.lang.String r0 = "ۣۣ۟"
                r1 = r0
                r2 = r3
                goto L6
            L7e:
                java.lang.String r0 = "ۢۤۧ"
                r1 = r0
                goto L6
            L82:
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 < 0) goto L8d
                java.lang.String r0 = "ۡ۠ۥ"
                r1 = r0
                goto L6
            L8d:
                java.lang.String r0 = "۟۟"
                r1 = r0
                goto L6
            L92:
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto La0
                com.transsion.subroom.activity.C0667.m874()
                java.lang.String r0 = "ۧ۠ۥ"
                r1 = r0
                goto L6
            La0:
                java.lang.String r0 = "۟ۧۤ"
                r1 = r0
                goto L6
            La5:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m575(java.lang.Object, java.lang.Object):int");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0045. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:163:0x0459 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:166:0x0454 A[SYNTHETIC] */
        /* renamed from: ۡۤۤۢ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.String m576(java.lang.String r34) {
            /*
                Method dump skipped, instructions count: 1264
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m576(java.lang.String):java.lang.String");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:29:0x009f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0097 A[SYNTHETIC] */
        /* renamed from: ۣۢ۠ۨ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int m577(java.lang.Object r7) {
            /*
                r3 = 0
                java.lang.String r0 = "ۥۤۨ"
                r1 = r0
                r2 = r3
                r4 = r3
            L6:
                int r0 = gt.md.C0799.m1158(r1)
                r5 = 1751713(0x1abaa1, float:2.454673E-39)
                r0 = r0 ^ r5
                switch(r0) {
                    case 196: goto L12;
                    case 1160: goto L2e;
                    case 1835: goto L1d;
                    case 2530: goto La4;
                    case 4546: goto L91;
                    case 7559: goto L86;
                    case 29475: goto La9;
                    case 29513: goto L53;
                    case 30882: goto La4;
                    case 31586: goto L5d;
                    case 1730050: goto L73;
                    default: goto L11;
                }
            L11:
                goto L6
            L12:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L4e
                androidx.core.C0079.m394()
                r2 = r4
                goto L6
            L1d:
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L2a
                androidx.core.C0078.m391()
                java.lang.String r0 = "ۤۥۢ"
                r1 = r0
                goto L6
            L2a:
                java.lang.String r0 = "ۥۨ"
                r1 = r0
                goto L6
            L2e:
                r0 = 75667(0x12793, float:1.06032E-40)
                r5 = 0
                java.lang.Object[] r6 = new java.lang.Object[r3]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r5, r6)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 >= 0) goto L91
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L4a
                androidx.core.C0078.m391()
                goto L6
            L4a:
                java.lang.String r0 = "ۦۣ۠"
                r1 = r0
                goto L6
            L4e:
                java.lang.String r0 = "ۨۥ۟"
                r1 = r0
                r2 = r4
                goto L6
            L53:
                int r0 = androidx.core.C0079.m394()
                if (r0 >= 0) goto L6
                java.lang.String r0 = "ۦۥۢ"
                r1 = r0
                goto L6
            L5d:
                r1 = 65441(0xffa1, float:9.1702E-41)
                r0 = r7
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
                java.lang.Object[] r4 = new java.lang.Object[r3]
                java.lang.Object r0 = com.transsion.subroom.premium.C0669.n(r1, r0, r4)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r4 = r0.intValue()
                java.lang.String r0 = "ۤۤۥ"
                r1 = r0
                goto L6
            L73:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L81
                gt.md.C0799.m1162()
                java.lang.String r0 = "ۣۡۤ"
                r1 = r0
                r2 = r3
                goto L6
            L81:
                java.lang.String r0 = "ۨۨۨ"
                r1 = r0
                r2 = r3
                goto L6
            L86:
                int r0 = androidx.core.C0079.m394()
                if (r0 >= 0) goto L6
                java.lang.String r0 = "ۥۤۨ"
                r1 = r0
                goto L6
            L91:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L9f
                androidx.core.C0079.m394()
                java.lang.String r0 = "ۧۥۥ"
                r1 = r0
                goto L6
            L9f:
                java.lang.String r0 = "ۥ۟ۤ"
                r1 = r0
                goto L6
            La4:
                java.lang.String r0 = "ۨۥ۟"
                r1 = r0
                goto L6
            La9:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m577(java.lang.Object):int");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
        /* renamed from: ۣ۠ۦ۟ */
        public static int m578() {
            String str = "ۡۦ";
            int i11 = 0;
            int i12 = 0;
            while (true) {
                switch (C0799.m1158(str) ^ 1753447) {
                    case 804:
                        str = "ۣۨ";
                        i11 = 0;
                    case 1185:
                    case 1260:
                        i12 = ((Integer) C0669.n(37727, null, new Object[0])).intValue();
                        if (C0667.m874() < 0) {
                            str = "ۣۣۤ";
                        }
                    case 26170:
                        break;
                    case 27322:
                        if (C0799.m1162() <= 0) {
                            C0066.m207();
                        } else {
                            str = "ۡۦ";
                        }
                    case 28645:
                    case 30625:
                        str = C0078.m391() >= 0 ? "ۥۢ۠" : "۟ۢ۠";
                    case 30661:
                        if (C0667.m874() >= 0) {
                            C0066.m207();
                            i11 = i12;
                        } else {
                            str = "۟ۢ۠";
                            i11 = i12;
                        }
                    case 31555:
                        if (C0667.m874() >= 0) {
                            C0078.m391();
                        } else {
                            str = "ۦۧۤ";
                        }
                    case 1711426:
                        str = ((Integer) C0685.n(75667, null, new Object[0])).intValue() <= 0 ? C0066.m207() != 0 ? "ۡۡۥ" : "ۣۧۧ" : "ۤۢۢ";
                    case 1711516:
                        if (C0799.m1162() > 0) {
                            str = "ۡ۟۠";
                        }
                }
                return i11;
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0073 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006c A[SYNTHETIC] */
        /* renamed from: ۣۧۨ۠ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m579(java.lang.Object r5, java.lang.Object r6) {
            /*
                r4 = 0
                java.lang.String r0 = "ۨۧ۠"
                r1 = r0
            L4:
                int r0 = gt.md.C0799.m1158(r1)
                r2 = 1752578(0x1abe02, float:2.455885E-39)
                r0 = r0 ^ r2
                switch(r0) {
                    case 2275: goto L10;
                    case 4505: goto L66;
                    case 5502: goto L77;
                    case 6591: goto L4a;
                    case 30659: goto L2f;
                    case 31754: goto L58;
                    case 1729087: goto L4a;
                    case 1729243: goto L25;
                    default: goto Lf;
                }
            Lf:
                goto L4
            L10:
                r2 = 47020(0xb7ac, float:6.5889E-41)
                r0 = r5
                android.widget.Button r0 = (android.widget.Button) r0
                r1 = 1
                java.lang.Object[] r3 = new java.lang.Object[r1]
                r1 = r6
                android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1
                r3[r4] = r1
                com.transsion.subroom.premium.C0669.n(r2, r0, r3)
                java.lang.String r0 = "۠ۥۡ"
                r1 = r0
                goto L4
            L25:
                int r0 = androidx.core.C0079.m394()
                if (r0 >= 0) goto L4
                java.lang.String r0 = "۟ۥۣ"
                r1 = r0
                goto L4
            L2f:
                r0 = 21970(0x55d2, float:3.0787E-41)
                r2 = 0
                java.lang.Object[] r3 = new java.lang.Object[r4]
                java.lang.Object r0 = com.transsion.subroom.premium.C0684.n(r0, r2, r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 > 0) goto L66
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 != 0) goto L4
                java.lang.String r0 = "ۣۦۤ"
                r1 = r0
                goto L4
            L4a:
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 < 0) goto L54
                com.transsion.subroom.activity.C0667.m874()
                goto L4
            L54:
                java.lang.String r0 = "۠ۥۡ"
                r1 = r0
                goto L4
            L58:
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L62
                androidx.core.C0079.m394()
                goto L4
            L62:
                java.lang.String r0 = "ۨۧ۠"
                r1 = r0
                goto L4
            L66:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L73
                gt.md.C0799.m1162()
                java.lang.String r0 = "ۥۣ۠"
                r1 = r0
                goto L4
            L73:
                java.lang.String r0 = "ۧ۠"
                r1 = r0
                goto L4
            L77:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m579(java.lang.Object, java.lang.Object):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00de A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00d6 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00cb A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0007 A[SYNTHETIC] */
        /* renamed from: ۣۤۨۤ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m580(java.lang.Object r8, boolean r9) {
            /*
                Method dump skipped, instructions count: 278
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m580(java.lang.Object, boolean):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000b. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0075 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0072 A[SYNTHETIC] */
        /* renamed from: ۤۨ۟۟ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m581(java.lang.Object r5, java.lang.Object r6) {
            /*
                r4 = 0
                java.lang.String r0 = "ۣۣ۠"
            L3:
                int r1 = gt.md.C0799.m1158(r0)
                r2 = 1747683(0x1aaae3, float:2.449026E-39)
                r1 = r1 ^ r2
                switch(r1) {
                    case 3388: goto Lf;
                    case 5350: goto L5f;
                    case 5897: goto L10;
                    case 7267: goto L2f;
                    case 25097: goto L6c;
                    case 25350: goto L50;
                    case 25513: goto L5f;
                    case 28650: goto L1c;
                    default: goto Le;
                }
            Le:
                goto L3
            Lf:
                return
            L10:
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L19
                java.lang.String r0 = "ۧ۠ۥ"
                goto L3
            L19:
                java.lang.String r0 = "ۣۨۥ"
                goto L3
            L1c:
                r2 = 10556(0x293c, float:1.4792E-41)
                r0 = r5
                android.widget.Button r0 = (android.widget.Button) r0
                r1 = 1
                java.lang.Object[] r3 = new java.lang.Object[r1]
                r1 = r6
                android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
                r3[r4] = r1
                com.transsion.subroom.premium.C0669.n(r2, r0, r3)
                java.lang.String r0 = "۟ۦۦ"
                goto L3
            L2f:
                r0 = 42203(0xa4db, float:5.9139E-41)
                r1 = 0
                java.lang.Object[] r2 = new java.lang.Object[r4]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r1, r2)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 >= 0) goto L6c
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 < 0) goto L4d
                androidx.core.appcompat.C0066.m207()
                java.lang.String r0 = "ۡۡۦ"
                goto L3
            L4d:
                java.lang.String r0 = "ۧ۟ۡ"
                goto L3
            L50:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L5c
                gt.md.C0799.m1162()
                java.lang.String r0 = "ۡ۠ۦ"
                goto L3
            L5c:
                java.lang.String r0 = "ۣۣ۠"
                goto L3
            L5f:
                int r1 = com.transsion.subroom.activity.C0667.m874()
                if (r1 < 0) goto L69
                androidx.core.appcompat.C0066.m207()
                goto L3
            L69:
                java.lang.String r0 = "۟ۦۦ"
                goto L3
            L6c:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L75
                java.lang.String r0 = "ۣۡۦ"
                goto L3
            L75:
                java.lang.String r0 = "ۥۢۧ"
                goto L3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m581(java.lang.Object, java.lang.Object):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0010. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00e2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0008 A[SYNTHETIC] */
        /* renamed from: ۥۢۡ۟ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m582(java.lang.Object r9, int r10) {
            /*
                Method dump skipped, instructions count: 282
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m582(java.lang.Object, int):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0058 A[SYNTHETIC] */
        /* renamed from: ۦۡۥۢ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m583(java.lang.Object r6, float r7) {
            /*
                r5 = 0
                java.lang.String r0 = "ۤ۟ۢ"
                r1 = r0
            L4:
                int r0 = gt.md.C0799.m1158(r1)
                r2 = 1754564(0x1ac5c4, float:2.458668E-39)
                r0 = r0 ^ r2
                switch(r0) {
                    case 98: goto L10;
                    case 25319: goto L6d;
                    case 28120: goto L63;
                    case 28355: goto L2b;
                    case 29632: goto L52;
                    case 30829: goto L77;
                    case 31653: goto L6d;
                    case 31747: goto L39;
                    default: goto Lf;
                }
            Lf:
                goto L4
            L10:
                r2 = 28761(0x7059, float:4.0303E-41)
                r0 = r6
                android.widget.Button r0 = (android.widget.Button) r0
                r3 = 1
                java.lang.Object[] r3 = new java.lang.Object[r3]
                java.lang.Float r4 = java.lang.Float.valueOf(r7)
                r3[r5] = r4
                com.transsion.subroom.premium.C0669.n(r2, r0, r3)
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 < 0) goto L4e
                androidx.core.appcompat.C0066.m207()
                goto L4
            L2b:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L35
                java.lang.String r0 = "ۤۤ۟"
                r1 = r0
                goto L4
            L35:
                java.lang.String r0 = "ۥۦۢ"
                r1 = r0
                goto L4
            L39:
                r0 = 21970(0x55d2, float:3.0787E-41)
                r1 = 0
                java.lang.Object[] r2 = new java.lang.Object[r5]
                java.lang.Object r0 = com.transsion.subroom.premium.C0684.n(r0, r1, r2)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 >= 0) goto L52
                java.lang.String r0 = "ۣۧۤ"
                r1 = r0
                goto L4
            L4e:
                java.lang.String r0 = "ۥ۠ۤ"
                r1 = r0
                goto L4
            L52:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L5f
                androidx.core.appcompat.C0066.m207()
                java.lang.String r0 = "۟ۡۨ"
                r1 = r0
                goto L4
            L5f:
                java.lang.String r0 = "۠ۡۨ"
                r1 = r0
                goto L4
            L63:
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 >= 0) goto L4
                java.lang.String r0 = "ۤ۟ۢ"
                r1 = r0
                goto L4
            L6d:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 != 0) goto L4
                java.lang.String r0 = "ۥ۠ۤ"
                r1 = r0
                goto L4
            L77:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m583(java.lang.Object, float):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000c. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0067 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0063 A[SYNTHETIC] */
        /* renamed from: ۦۥۨۦ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void m584(java.lang.Object r5, java.lang.Object r6) {
            /*
                r4 = 0
                java.lang.String r0 = "ۣۦۢ"
                r1 = r0
            L4:
                int r0 = gt.md.C0799.m1158(r1)
                r2 = 1749725(0x1ab2dd, float:2.451887E-39)
                r0 = r0 ^ r2
                switch(r0) {
                    case 125: goto L10;
                    case 188: goto L5d;
                    case 1026: goto L2f;
                    case 2173: goto L6f;
                    case 3289: goto L7d;
                    case 6859: goto L10;
                    case 31639: goto L1a;
                    case 1732573: goto L4f;
                    default: goto Lf;
                }
            Lf:
                goto L4
            L10:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L6b
                androidx.core.C0078.m391()
                goto L4
            L1a:
                r2 = 53711(0xd1cf, float:7.5265E-41)
                r0 = r5
                android.widget.ImageView r0 = (android.widget.ImageView) r0
                r1 = 1
                java.lang.Object[] r3 = new java.lang.Object[r1]
                r1 = r6
                android.graphics.Bitmap r1 = (android.graphics.Bitmap) r1
                r3[r4] = r1
                com.transsion.subroom.premium.C0669.n(r2, r0, r3)
                java.lang.String r0 = "ۥۣۢ"
                r1 = r0
                goto L4
            L2f:
                r0 = 98787(0x181e3, float:1.3843E-40)
                r2 = 0
                java.lang.Object[] r3 = new java.lang.Object[r4]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r2, r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 >= 0) goto L5d
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L4b
                androidx.core.appcompat.C0066.m207()
                goto L4
            L4b:
                java.lang.String r0 = "ۣۨۥ"
                r1 = r0
                goto L4
            L4f:
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 < 0) goto L59
                com.transsion.subroom.activity.C0667.m874()
                goto L4
            L59:
                java.lang.String r0 = "۟ۨ۟"
                r1 = r0
                goto L4
            L5d:
                int r0 = androidx.core.appcompat.C0066.m207()
                if (r0 == 0) goto L67
                java.lang.String r0 = "ۣۢ"
                r1 = r0
                goto L4
            L67:
                java.lang.String r0 = "ۨۨ"
                r1 = r0
                goto L4
            L6b:
                java.lang.String r0 = "ۥۣۢ"
                r1 = r0
                goto L4
            L6f:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L79
                androidx.core.C0079.m394()
                goto L4
            L79:
                java.lang.String r0 = "ۣۦۢ"
                r1 = r0
                goto L4
            L7d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m584(java.lang.Object, java.lang.Object):void");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:14:0x007b A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0006 A[SYNTHETIC] */
        /* renamed from: ۣۧۢۨ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.String m585() {
            /*
                r3 = 0
                java.lang.String r0 = "ۨ۠۠"
                r1 = r0
                r2 = r3
                r4 = r3
            L6:
                int r0 = gt.md.C0799.m1158(r1)
                r5 = 1746909(0x1aa7dd, float:2.447941E-39)
                r0 = r0 ^ r5
                switch(r0) {
                    case 2240: goto L12;
                    case 3139: goto L75;
                    case 4034: goto L36;
                    case 4472: goto L46;
                    case 6588: goto L6d;
                    case 6719: goto L71;
                    case 7522: goto L4a;
                    case 28276: goto L7f;
                    case 28405: goto L71;
                    case 28469: goto L17;
                    case 1735455: goto L5f;
                    default: goto L11;
                }
            L11:
                goto L6
            L12:
                java.lang.String r0 = "ۨۦۧ"
                r1 = r0
                r2 = r4
                goto L6
            L17:
                r0 = 21970(0x55d2, float:3.0787E-41)
                r5 = 0
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.Object r0 = com.transsion.subroom.premium.C0684.n(r0, r3, r5)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 >= 0) goto L75
                int r0 = com.transsion.subroom.activity.C0667.m874()
                if (r0 < 0) goto L32
                gt.md.C0799.m1162()
                goto L6
            L32:
                java.lang.String r0 = "ۤۧۢ"
                r1 = r0
                goto L6
            L36:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L41
                java.lang.String r0 = "ۣۣ۟"
                r1 = r0
                r2 = r3
                goto L6
            L41:
                java.lang.String r0 = "ۦۨ"
                r1 = r0
                r2 = r3
                goto L6
            L46:
                java.lang.String r0 = "۟ۨۨ"
                r1 = r0
                goto L6
            L4a:
                r0 = 37754(0x937a, float:5.2905E-41)
                java.lang.Object r0 = com.transsion.subroom.premium.C0669.n(r0)
                java.lang.String r0 = (java.lang.String) r0
                int r4 = gt.md.C0799.m1162()
                if (r4 > 0) goto L5b
                r4 = r0
                goto L6
            L5b:
                java.lang.String r1 = "ۡۤ۠"
                r4 = r0
                goto L6
            L5f:
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L69
                androidx.core.C0078.m391()
                goto L6
            L69:
                java.lang.String r0 = "ۨۢۢ"
                r1 = r0
                goto L6
            L6d:
                java.lang.String r0 = "ۨ۠۠"
                r1 = r0
                goto L6
            L71:
                java.lang.String r0 = "ۨۦۧ"
                r1 = r0
                goto L6
            L75:
                int r0 = gt.md.C0799.m1162()
                if (r0 <= 0) goto L6
                java.lang.String r0 = "ۣۤۦ"
                r1 = r0
                goto L6
            L7f:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m585():java.lang.String");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0080 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x007c A[SYNTHETIC] */
        /* renamed from: ۣۧۨۤ */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.StringBuilder m586(java.lang.Object r8, java.lang.Object r9) {
            /*
                r7 = 0
                r4 = 0
                java.lang.String r0 = "ۧۧۦ"
                r2 = r0
                r3 = r4
                r1 = r4
            L7:
                int r0 = gt.md.C0799.m1158(r2)
                r5 = 1749606(0x1ab266, float:2.45172E-39)
                r0 = r0 ^ r5
                switch(r0) {
                    case 1031: goto L13;
                    case 3171: goto L84;
                    case 4046: goto L36;
                    case 6436: goto L5f;
                    case 6437: goto L2e;
                    case 6599: goto L6c;
                    case 29792: goto L40;
                    case 29806: goto L94;
                    case 30510: goto L84;
                    case 1732128: goto L76;
                    case 1732216: goto L32;
                    default: goto L12;
                }
            L12:
                goto L7
            L13:
                r5 = 8918(0x22d6, float:1.2497E-41)
                r0 = r8
                java.lang.StringBuilder r0 = (java.lang.StringBuilder) r0
                r1 = 1
                java.lang.Object[] r6 = new java.lang.Object[r1]
                r1 = r9
                java.lang.String r1 = (java.lang.String) r1
                r6[r7] = r1
                java.lang.Object r0 = com.transsion.subroom.premium.C0669.n(r5, r0, r6)
                java.lang.StringBuilder r0 = (java.lang.StringBuilder) r0
                int r1 = androidx.core.appcompat.C0066.m207()
                if (r1 == 0) goto L3b
                r1 = r0
                goto L7
            L2e:
                java.lang.String r0 = "ۥۣ۠"
                r2 = r0
                goto L7
            L32:
                java.lang.String r0 = "ۥۣۣ"
                r2 = r0
                goto L7
            L36:
                java.lang.String r0 = "ۡ۟"
                r2 = r0
                r3 = r4
                goto L7
            L3b:
                java.lang.String r1 = "ۣ۠ۥ"
                r2 = r1
                r1 = r0
                goto L7
            L40:
                r0 = 98787(0x181e3, float:1.3843E-40)
                java.lang.Object[] r5 = new java.lang.Object[r7]
                java.lang.Object r0 = com.transsion.subroom.premium.C0685.n(r0, r4, r5)
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                if (r0 >= 0) goto L76
                int r0 = androidx.core.C0079.m394()
                if (r0 < 0) goto L5b
                java.lang.String r0 = "ۥۢۦ"
                r2 = r0
                goto L7
            L5b:
                java.lang.String r0 = "ۣۢ۠"
                r2 = r0
                goto L7
            L5f:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L67
                r3 = r1
                goto L7
            L67:
                java.lang.String r0 = "ۧۧۨ"
                r2 = r0
                r3 = r1
                goto L7
            L6c:
                int r0 = androidx.core.C0078.m391()
                if (r0 >= 0) goto L7
                java.lang.String r0 = "ۧۧۦ"
                r2 = r0
                goto L7
            L76:
                int r0 = gt.md.C0799.m1162()
                if (r0 > 0) goto L80
                com.transsion.subroom.activity.C0667.m874()
                goto L7
            L80:
                java.lang.String r0 = "ۣ۠ۦ"
                r2 = r0
                goto L7
            L84:
                int r0 = androidx.core.C0078.m391()
                if (r0 < 0) goto L8f
                gt.md.C0799.m1162()
                goto L7
            L8f:
                java.lang.String r0 = "ۧۧۨ"
                r2 = r0
                goto L7
            L94:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.AnonymousClass6.m586(java.lang.Object, java.lang.Object):java.lang.StringBuilder");
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0010. Please report as an issue. */
        /* renamed from: ۨۤۦۡ */
        public static float m587() {
            Object obj = "ۣۨ۟";
            float f11 = 0.0f;
            float f12 = 0.0f;
            while (true) {
                switch (C0799.m1158(obj) ^ 1751525) {
                    case 47:
                        if (C0066.m207() == 0) {
                            obj = "ۣۨ۟";
                        }
                    case 2789:
                        if (C0078.m391() < 0) {
                            obj = "ۧۥ۠";
                        }
                    case 3879:
                        f12 = ((Float) C0669.n(71770, null, new Object[0])).floatValue();
                        if (C0667.m874() >= 0) {
                            C0667.m874();
                        } else {
                            obj = "ۡ۠ۤ";
                        }
                    case 4732:
                    case 31783:
                        if (C0799.m1162() <= 0) {
                            C0667.m874();
                        } else {
                            obj = "ۣۧ۟";
                        }
                    case 4868:
                        obj = "ۦۥۣ";
                    case 5952:
                        obj = "ۣۧ۟";
                        f11 = f12;
                    case 28969:
                        if (((Integer) C0685.n(42203, null, new Object[0])).intValue() >= 0) {
                            obj = "۠۠ۡ";
                        } else if (C0066.m207() == 0) {
                            obj = "ۣۥۤ";
                        }
                    case 31713:
                        if (C0667.m874() >= 0) {
                            C0667.m874();
                            f11 = 0.0f;
                        } else {
                            obj = "ۢۥۣ";
                            f11 = 0.0f;
                        }
                    case 31982:
                        break;
                    case 1729987:
                        obj = "۠۠ۡ";
                }
                return f11;
            }
        }
    }

    /* renamed from: androidx.preference.layout2$7 */
    /* loaded from: classes7.dex */
    public class AnonymousClass7 {

        /* renamed from: ۠ۧۤۨ */
        public static int f26 = 62;

        /* renamed from: ۟۟۟ۧۢ */
        public static int m588() {
            if (AnonymousClass6.m569() <= 0) {
                return preferencesd.getDialogRadius();
            }
            return 0;
        }

        /* renamed from: ۟۟ۡۥۤ */
        public static float m589() {
            if (m603() < 0) {
                return preferencesd.getChangelogTextSize();
            }
            return 0.0f;
        }

        /* renamed from: ۟۠ۨۥۢ */
        public static Typeface m590() {
            if (AnonymousClass5.m553() <= 0) {
                return Typeface.DEFAULT_BOLD;
            }
            return null;
        }

        /* renamed from: ۟ۢۢۤ۠ */
        public static void m591(Object obj, Object obj2) {
            if (AnonymousClass5.m553() <= 0) {
                ((TextView) obj).setLayoutParams((ViewGroup.LayoutParams) obj2);
            }
        }

        /* renamed from: ۣ۟ۨ۠ۥ */
        public static int m592() {
            if (AnonymousClass5.m553() <= 0) {
                return preferencesd.getbtn1Color();
            }
            return 0;
        }

        /* renamed from: ۣ۟ۤۤۡ */
        public static String m593(short[] sArr, int i11, int i12, int i13) {
            char[] cArr = new char[i12];
            for (int i14 = 0; i14 < i12; i14++) {
                cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
            }
            return new String(cArr);
        }

        /* renamed from: ۣ۟ۤۧۡ */
        public static void m594(Object obj, float f11) {
            if (AnonymousClass8.m616() < 0) {
                ((TextView) obj).setTextSize(f11);
            }
        }

        /* renamed from: ۟ۥ۟ۡ۠ */
        public static void m595(Object obj, int i11) {
            if (AnonymousClass8.m616() <= 0) {
                ((TextView) obj).setGravity(i11);
            }
        }

        /* renamed from: ۟ۦۢۡۦ */
        public static Uri m596(Object obj) {
            if (AnonymousClass6.m569() <= 0) {
                return Uri.parse((String) obj);
            }
            return null;
        }

        /* renamed from: ۣ۟ۧۦ۟ */
        public static boolean m597(Object obj, Object obj2) {
            if (AnonymousClass5.m553() < 0) {
                return ((String) obj).equals(obj2);
            }
            return false;
        }

        /* renamed from: ۟ۨۤۧ */
        public static String m598(String str) {
            String str2 = "";
            String str3 = "";
            for (int i11 = 0; i11 < 15; i11++) {
                str2 = new StringBuffer().append(str2).append(Integer.toHexString(i11)).toString();
                str3 = new StringBuffer().append(str3).append(((int) (Math.random() * 10)) ^ i11).toString();
            }
            do {
            } while (str2.length() > 0);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / 2);
            for (int i12 = 0; i12 < str.length(); i12 += 2) {
                byteArrayOutputStream.write((str2.indexOf(str.charAt(i12)) << 4) | str2.indexOf(str.charAt(i12 + 1)));
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            int length = byteArray.length;
            int length2 = str3.length();
            for (int i13 = 0; i13 < length; i13++) {
                byteArray[i13] = (byte) (byteArray[i13] ^ str3.charAt(i13 % length2));
            }
            return new String(byteArray);
        }

        /* renamed from: ۠۟ۥۡ */
        public static String m599() {
            if (m603() <= 0) {
                return preferencesd.getImage();
            }
            return null;
        }

        /* renamed from: ۠۟ۦۢ */
        public static void m600(Object obj, int i11) {
            if (AnonymousClass8.m616() <= 0) {
                ((TextView) obj).setTextColor(i11);
            }
        }

        /* renamed from: ۠۠۠۟ */
        public static WindowManager.LayoutParams m601(Object obj) {
            if (AnonymousClass6.m569() <= 0) {
                return ((Window) obj).getAttributes();
            }
            return null;
        }

        /* renamed from: ۣ۠۠ۤ */
        public static String m602() {
            if (m603() <= 0) {
                return "۠ۢ۠";
            }
            return null;
        }

        /* renamed from: ۠۠ۦۨ */
        public static int m603() {
            return (-1747948) ^ AnonymousClass5.m528((Object) "۠ۧ۟");
        }

        /* renamed from: ۣ۠۟ۤ */
        public static float m604() {
            if (AnonymousClass6.m569() <= 0) {
                return preferencesd.getChangelogTitleTextSize();
            }
            return 0.0f;
        }

        /* renamed from: ۠ۨ۠ۥ */
        public static void m605(Object obj, Object obj2) {
            if (AnonymousClass6.m569() <= 0) {
                ((Window) obj).setAttributes((WindowManager.LayoutParams) obj2);
            }
        }

        /* renamed from: ۡ۟۠۟ */
        public static int m606() {
            if (m603() < 0) {
                return preferencesd.getBtn2HoverColor();
            }
            return 0;
        }

        /* renamed from: ۡۢۢۨ */
        public static Resources m607(Object obj) {
            if (m603() <= 0) {
                return ((Context) obj).getResources();
            }
            return null;
        }

        /* renamed from: ۤۧۢۡ */
        public static byte[] m608(Object obj, int i11) {
            if (m603() < 0) {
                return Base64.decode((String) obj, i11);
            }
            return null;
        }

        /* renamed from: ۥۦۧۧ */
        public static DisplayMetrics m609(Object obj) {
            if (AnonymousClass5.m553() <= 0) {
                return ((Resources) obj).getDisplayMetrics();
            }
            return null;
        }

        /* renamed from: ۦۣۣۢ */
        public static int m610() {
            if (AnonymousClass5.m553() < 0) {
                return preferencesd.getChangelogTitleColor();
            }
            return 0;
        }

        /* renamed from: ۧۤۥۥ */
        public static InputStream m611(Object obj) {
            if (AnonymousClass8.m616() <= 0) {
                return ((HttpURLConnection) obj).getInputStream();
            }
            return null;
        }

        /* renamed from: ۧۧۢۧ */
        public static void m612(Object obj, Object obj2) {
            if (m603() <= 0) {
                ((Button) obj).setLayoutParams((ViewGroup.LayoutParams) obj2);
            }
        }

        /* renamed from: ۨۤ۟ۥ */
        public static int m613(Object obj) {
            if (m603() <= 0) {
                return ((DisplayMetrics) obj).widthPixels;
            }
            return 0;
        }

        /* renamed from: ۨۤۢ */
        public static int m614() {
            if (m603() < 0) {
                return preferencesd.getbtn2BackColor();
            }
            return 0;
        }
    }

    /* renamed from: androidx.preference.layout2$8 */
    /* loaded from: classes7.dex */
    public class AnonymousClass8 {

        /* renamed from: ۟ۤۤ۟ۨ */
        public static boolean f27 = true;

        /* renamed from: ۟ۢۤۡ۟ */
        public static String m615(short[] sArr, int i11, int i12, int i13) {
            char[] cArr = new char[i12];
            for (int i14 = 0; i14 < i12; i14++) {
                cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
            }
            return new String(cArr);
        }

        /* renamed from: ۟ۤ۟۟۠ */
        public static int m616() {
            return (-1753671) ^ AnonymousClass5.m528((Object) "ۦۨۧ");
        }

        /* renamed from: ۢۥۣ۠ */
        public static String m617(String str) {
            String str2 = "";
            String str3 = "";
            for (int i11 = 0; i11 < 15; i11++) {
                str2 = new StringBuffer().append(str2).append(Integer.toHexString(i11)).toString();
                str3 = new StringBuffer().append(str3).append(((int) (Math.random() * 10)) ^ i11).toString();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / 2);
            while (str.length() > 0) {
                byteArrayOutputStream.write((str2.indexOf(str.charAt(-2)) << 4) | str2.indexOf(str.charAt(-1)));
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            int length = byteArray.length;
            int length2 = str3.length();
            for (int i12 = 0; i12 < length; i12++) {
                byteArray[i12] = (byte) (byteArray[i12] ^ str3.charAt(i12 % length2));
            }
            return new String(byteArray);
        }
    }

    /* renamed from: androidx.preference.layout2$9 */
    /* loaded from: classes7.dex */
    public class AnonymousClass9 {

        /* renamed from: ۟۠ۡۨ۟ */
        public static boolean f28 = true;

        /* renamed from: ۟۟ۧ۟ۥ */
        public static String m618(Object obj, Object obj2) {
            if (AnonymousClass7.m603() <= 0) {
                return ((JSONObject) obj).getString((String) obj2);
            }
            return null;
        }

        /* renamed from: ۣ۟۟ۨۢ */
        public static int m619() {
            if (AnonymousClass7.m603() < 0) {
                return preferencesd.getVersionTextColor();
            }
            return 0;
        }

        /* renamed from: ۣ۟۠۟ۤ */
        public static Bitmap m620(Object obj, int i11, int i12) {
            if (AnonymousClass6.m569() <= 0) {
                return BitmapFactory.decodeByteArray((byte[]) obj, i11, i12);
            }
            return null;
        }

        /* renamed from: ۟۠۟ۨ۠ */
        public static String[] m621(Object obj, Object obj2) {
            if (AnonymousClass8.m616() < 0) {
                return ((String) obj).split((String) obj2);
            }
            return null;
        }

        /* renamed from: ۟۠ۢۤۤ */
        public static void m622(Object obj, int i11) {
            if (AnonymousClass5.m553() <= 0) {
                ((Button) obj).setTextColor(i11);
            }
        }

        /* renamed from: ۣ۟۠ۨ۠ */
        public static float m623() {
            if (AnonymousClass6.m569() < 0) {
                return preferencesd.getTitleTextSize();
            }
            return 0.0f;
        }

        /* renamed from: ۣ۟۠ۧۨ */
        public static String m624() {
            if (AnonymousClass8.m616() <= 0) {
                return preferencesd.GetApi();
            }
            return null;
        }

        /* renamed from: ۣ۟ۤۤۢ */
        public static boolean m625(Object obj, int i11) {
            if (AnonymousClass7.m603() < 0) {
                return ((Dialog) obj).requestWindowFeature(i11);
            }
            return false;
        }

        /* renamed from: ۣ۟ۤۦۥ */
        public static void m626(Object obj, Object obj2) {
            if (AnonymousClass5.m553() <= 0) {
                ((Button) obj).setOnTouchListener((View.OnTouchListener) obj2);
            }
        }

        /* renamed from: ۣ۟ۤۦۨ */
        public static int m627() {
            if (AnonymousClass6.m569() <= 0) {
                return preferencesd.getDialogBackgroundColor();
            }
            return 0;
        }

        /* renamed from: ۣ۟ۥۦۣ */
        public static void m628(Object obj, int i11) {
            if (AnonymousClass6.m569() < 0) {
                ((LinearLayout) obj).setOrientation(i11);
            }
        }

        /* renamed from: ۣ۟ۧۦۥ */
        public static void m629(Object obj) {
            if (AnonymousClass5.m553() < 0) {
                ((Exception) obj).printStackTrace();
            }
        }

        /* renamed from: ۣ۟ۨ۠۟ */
        public static Window m630(Object obj) {
            if (AnonymousClass5.m553() < 0) {
                return ((Dialog) obj).getWindow();
            }
            return null;
        }

        /* renamed from: ۟ۤۢۧۥ */
        public static int m631() {
            if (AnonymousClass8.m616() <= 0) {
                return preferencesd.getChangelogColor();
            }
            return 0;
        }

        /* renamed from: ۟ۤۤۥۡ */
        public static void m632(Object obj, int i11) {
            if (AnonymousClass6.m569() <= 0) {
                ((Button) obj).setHeight(i11);
            }
        }

        /* renamed from: ۠۠ۥۥ */
        public static String m633(short[] sArr, int i11, int i12, int i13) {
            char[] cArr = new char[i12];
            for (int i14 = 0; i14 < i12; i14++) {
                cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
            }
            return new String(cArr);
        }

        /* renamed from: ۤۤۢ۠ */
        public static int m634() {
            if (AnonymousClass7.m603() < 0) {
                return preferencesd.getTopBackgroundColor();
            }
            return 0;
        }

        /* renamed from: ۤۤۧۤ */
        public static int m635() {
            if (AnonymousClass8.m616() < 0) {
                return preferencesd.getbtn1BackColor();
            }
            return 0;
        }

        /* renamed from: ۥۡۢ */
        public static String m636(String str) {
            String str2 = "";
            String str3 = "";
            for (int i11 = 0; i11 < 15; i11++) {
                str2 = new StringBuffer().append(str2).append(Integer.toHexString(i11)).toString();
                str3 = new StringBuffer().append(str3).append(((int) (Math.random() * 10)) ^ i11).toString();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / 2);
            while (str.length() > 0) {
                byteArrayOutputStream.write((str2.indexOf(str.charAt(-2)) << 4) | str2.indexOf(str.charAt(-1)));
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            int length = byteArray.length;
            int length2 = str3.length();
            for (int i12 = 0; i12 < length; i12++) {
                byteArray[i12] = (byte) (byteArray[i12] ^ str3.charAt(i12 % length2));
            }
            return new String(byteArray);
        }

        /* renamed from: ۥۢۤ۟ */
        public static String m637(Object obj) {
            if (AnonymousClass8.m616() < 0) {
                return ((PackageInfo) obj).versionName;
            }
            return null;
        }

        /* renamed from: ۦۣۣۣ */
        public static void m638(Object obj, Object obj2) {
            if (AnonymousClass6.m569() < 0) {
                ((TextView) obj).setTypeface((Typeface) obj2);
            }
        }

        /* renamed from: ۧۡۤ۟ */
        public static int m639() {
            return 1748632 ^ AnonymousClass5.m528((Object) "ۡۢ۟");
        }

        /* renamed from: ۧۤۤۦ */
        public static void m640(Object obj) {
            if (AnonymousClass5.m553() < 0) {
                ((Dialog) obj).show();
            }
        }

        /* renamed from: ۨۤ۠ۦ */
        public static URLConnection m641(Object obj) {
            if (AnonymousClass8.m616() <= 0) {
                return ((URL) obj).openConnection();
            }
            return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 485
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:64)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    static {
        /*
            Method dump skipped, instructions count: 3150
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.<clinit>():void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:154:0x01bf. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0394 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x038e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0013 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0322 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x031d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0332 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0013 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0372 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x036a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0382 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x037d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x035a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0352 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0312 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x030d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public layout2() {
        /*
            Method dump skipped, instructions count: 1170
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.<init>():void");
    }

    public static /* synthetic */ String access$1000002(Context context) {
        return (String) C0682.n(64736, null, new Object[]{context});
    }

    public static /* synthetic */ String access$1000008(String str) throws IOException {
        return (String) C0682.n(17232, null, new Object[]{str});
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0018. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:53:0x0081. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x008a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0102 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ androidx.preference.layout2.AnonymousClass4 access$1000009(java.lang.String r12, java.lang.String r13) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.access$1000009(java.lang.String, java.lang.String):androidx.preference.layout2$4");
    }

    public static /* synthetic */ String access$L1000000() {
        return (String) C0682.n(68501, null, new Object[0]);
    }

    public static /* synthetic */ String access$L1000001() {
        return (String) C0682.n(38896, null, new Object[0]);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x0041. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0017. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:118:0x013e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0156 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x014e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ void access$S1000000(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.access$S1000000(java.lang.String):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:174:0x01ed. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0013 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0013 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0290 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x028b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02cb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02e8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02e0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x030e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0306 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x02fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x02f3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02b6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ void access$S1000001(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 1016
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.access$S1000001(java.lang.String):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 600
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:64)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private static java.lang.String fetchRawContent(java.lang.String r68) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 4118
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.fetchRawContent(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0025. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:51:0x0096. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0463 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x045e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0497 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0492 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x039e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x03c3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x03be A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0448 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x001c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0453 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x001c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0482 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x047d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x009f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x001c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String getCurrentVersion(android.content.Context r29) {
        /*
            Method dump skipped, instructions count: 1486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.getCurrentVersion(android.content.Context):java.lang.String");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 724
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:64)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private static androidx.preference.layout2.AnonymousClass4 parseUpdateInfo(java.lang.String r122, java.lang.String r123) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 7166
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.parseUpdateInfo(java.lang.String, java.lang.String):androidx.preference.layout2$4");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0019. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:83:0x00f5. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:106:0x028f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x028a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x024f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x024a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x023f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x023a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x025a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0011 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x026a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0011 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x027a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0275 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void userInfo(android.content.Context r18) {
        /*
            Method dump skipped, instructions count: 846
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.userInfo(android.content.Context):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0047. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0027. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0534 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x052f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0499 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0491 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0471 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x04a4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0469 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:309:0x04c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x04b9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0481 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:382:0x04fc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:385:0x04f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x047c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x04d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x04cc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x04dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x001e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x04ec A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x04e7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x050f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0507 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x051f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x001e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0486 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0050 A[SYNTHETIC] */
    /* renamed from: ۟۟ۡۡۤ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int m474(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 1698
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.m474(java.lang.Object):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:254:0x02c8. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0018. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03f0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03da A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x03d5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x02d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:265:0x03e5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0403 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x041e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0419 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0429 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0439 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0434 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:309:0x046c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0494 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x048f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:325:0x04a4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x049f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x04bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x04ba A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:351:0x040e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x04af A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0461 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0459 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x047f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0477 A[SYNTHETIC] */
    /* renamed from: ۟۟ۨۨ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m475(java.lang.Object r15, java.lang.Object r16) {
        /*
            Method dump skipped, instructions count: 1566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.m475(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0049. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0017. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0257 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0021 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0207 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0217 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0212 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0227 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0222 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x023c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0237 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x024c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0247 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x01f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x025c A[SYNTHETIC] */
    /* renamed from: ۟۠ۤۧۡ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m476(java.lang.Object r14, java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 836
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.m476(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x003a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0017. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:114:0x037b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0370 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x036b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x02d7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x032d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0328 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x02cf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0360 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:303:0x035b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0302 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x02fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0312 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x030d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x031d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0340 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0338 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0350 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x034b A[SYNTHETIC] */
    /* renamed from: ۟ۤۡۥۢ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m477(java.lang.Object r14, java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 1162
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.m477(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:108:0x0140. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0018. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:112:0x029e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0149 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0022 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0289 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0299 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02a9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02be A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02b9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02ce A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02c9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x02d8 A[SYNTHETIC] */
    /* renamed from: ۟ۥ۠ۧۥ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m478(java.lang.Object r12, java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 978
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.m478(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:308:0x030c. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x040b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0406 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0351 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:315:0x034c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:321:0x035c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x037c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0377 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0396 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:346:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:350:0x03d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:353:0x03c9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x03eb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:365:0x03e6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:371:0x03fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:374:0x03f6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:380:0x0315 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:394:0x03ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:397:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x03be A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x03b6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027 A[SYNTHETIC] */
    /* renamed from: ۟ۦۨۨۢ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m479(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 1402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.m479(java.lang.Object):java.lang.String");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x004f. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0018. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01f2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01ed A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01c7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01d2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0202 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x021a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0212 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0022 A[SYNTHETIC] */
    /* renamed from: ۟ۧۡۦۧ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m480(java.lang.Object r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 742
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.m480(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:34:0x0061. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0023. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0442 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x001b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0452 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x001b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0407 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0402 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0437 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0432 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:308:0x041c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x001b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x03b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x03ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x03c3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x03bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x03d3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x001b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x03f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x03f2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0427 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x001b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x006a A[SYNTHETIC] */
    /* renamed from: ۟ۧۤۢ۟ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m481(java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 1456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.m481(java.lang.Object):java.lang.String");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:179:0x019f. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0017. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0021 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02e7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02f2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0284 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x01a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0297 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x028f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0302 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x030d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x031d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0318 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x02b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x02ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x02bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02cd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x02d2 A[SYNTHETIC] */
    /* renamed from: ۠ۤۤ۠ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m482(java.lang.Object r14, java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 1060
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.m482(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:170:0x01a5. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0017. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0290 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x028b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0206 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0211 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x023c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0237 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0252 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x025d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0270 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0268 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0280 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x027b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0247 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x000f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x021c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x000f A[SYNTHETIC] */
    /* renamed from: ۠ۦۣ۠ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m483(java.lang.Object r13, java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 886
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.m483(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:200:0x01f4. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0295 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0290 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0285 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x01fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0280 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0014 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x02e9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x02bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x02f9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x02f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0014 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x02de A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x02d9 A[SYNTHETIC] */
    /* renamed from: ۡۦۤ۠ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m484() {
        /*
            Method dump skipped, instructions count: 1056
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.m484():java.lang.String");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0020. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:63:0x00b5. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0018 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x039b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0349 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00be A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0018 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0344 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x033f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03a6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x03d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:340:0x0018 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x038b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0383 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x032f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0018 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0359 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0354 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x03b6 A[SYNTHETIC] */
    /* renamed from: ۣۢ۠۟ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static short[] m485() {
        /*
            Method dump skipped, instructions count: 1328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.m485():short[]");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:192:0x01c4. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x02f8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0328 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x01cd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0014 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02ed A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02e5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0308 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0303 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0323 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0014 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x033b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0333 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0355 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0350 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0317 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0314 A[SYNTHETIC] */
    /* renamed from: ۣ۟۟۟ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m486() {
        /*
            Method dump skipped, instructions count: 1176
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.m486():java.lang.String");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:285:0x0297. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0019. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02e5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02dd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x02f5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x02f0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x02c8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:292:0x02a0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0305 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0300 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x033d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0338 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:325:0x034d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0348 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x032d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0328 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0318 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0310 A[SYNTHETIC] */
    /* renamed from: ۣۤۡ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m487(java.lang.Object r13, java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 1120
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.m487(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:246:0x027a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0356 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x034e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03ec A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03e7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x035b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0283 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x032d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0017 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0343 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0017 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x036b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0366 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0376 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0017 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0386 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0381 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x03b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0017 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x03dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:314:0x03d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0396 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:346:0x0017 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x03a6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x03a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0338 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0017 A[SYNTHETIC] */
    /* renamed from: ۣۨۦۡ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.os.AsyncTask m488(java.lang.Object r15, java.lang.Object r16) {
        /*
            Method dump skipped, instructions count: 1334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.m488(java.lang.Object, java.lang.Object):android.os.AsyncTask");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:215:0x0214. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x001c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0362 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0014 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0026 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03c9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03c4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0352 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x034d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x021d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0014 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0372 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x036d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0392 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x038d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x03b4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x03ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:265:0x03dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0382 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x037d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0397 A[SYNTHETIC] */
    /* renamed from: ۥۣۨۢ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.preference.layout2.AnonymousClass4 m489(java.lang.Object r14, java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 1338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.m489(java.lang.Object, java.lang.Object):androidx.preference.layout2$4");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0018. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:90:0x011a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0269 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0284 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x027c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x028f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x02b4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0010 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x029f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x029a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0271 A[SYNTHETIC] */
    /* renamed from: ۦۨۥۦ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m490(java.lang.Object r16, java.lang.Object r17) {
        /*
            Method dump skipped, instructions count: 954
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.m490(java.lang.Object, java.lang.Object):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 520
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:64)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle r47) {
        /*
            Method dump skipped, instructions count: 3162
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2.onCreate(android.os.Bundle):void");
    }
}
