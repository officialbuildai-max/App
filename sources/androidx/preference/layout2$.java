package androidx.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.preference.layout2;
import com.cloud.tmc.integration.net.UrlKt;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: classes7.dex */
public class layout2$ extends AsyncTask<String, Void, layout2.AnonymousClass4> {

    /* renamed from: short, reason: not valid java name */
    private static final short[] f20short = {1264, 1219, 1237, 1245, 1174, 1251, 1174, 1274, 1235, 1239, 1237, 1246, 1235, 1220, 1178, 1174, 1266, 1247, 1239, 1242, 1241, 1233, 1174, 1250, 1235, 1220, 1239, 1174, 1268, 1239, 1239, 1222, 1174, 1277, 1239, 1174, 1250, 1246, 1241, 1234, 1247, 1174, 1246, 1239, 1247, 1240, 3204};
    private Context context;

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
    public layout2$(Context context) {
        Integer num = null;
        String str = "۠ۧۡ";
        while (true) {
            switch (layout2.AnonymousClass5.m528((Object) str) ^ 1752461) {
                case 2926:
                    num = Integer.valueOf(layout2.AnonymousClass8.m617("Frk4OYjasHmJE"));
                    str = layout2.AnonymousClass5.m553() >= 0 ? "ۡ۟ۨ" : "ۢ۟ۥ";
                case 4037:
                    System.out.println(num);
                    if (layout2.AnonymousClass6.m569() < 0) {
                        str = "ۦۣۥ";
                    }
                case 4970:
                case 5687:
                    this.context = context;
                    if (layout2.AnonymousClass8.m616() < 0) {
                        str = "ۧۧۤ";
                    }
                case 31625:
                    str = layout2.AnonymousClass5.m553() >= 0 ? layout2.AnonymousClass7.m603() >= 0 ? "ۣۨۦ" : "ۣۦۦ" : "ۦۣۥ";
                case 31813:
                    break;
                case 1730155:
                    if (layout2.AnonymousClass5.m553() >= 0) {
                        layout2.AnonymousClass5.m553();
                    } else {
                        str = "۠ۧۡ";
                    }
            }
            return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0029, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ void access$S1000003(androidx.preference.layout2$ r3, android.content.Context r4) {
        /*
            java.lang.String r0 = "ۥۨۨ"
        L2:
            int r1 = androidx.preference.layout2.AnonymousClass5.m528(r0)
            r2 = 1747715(0x1aab03, float:2.44907E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 5542: goto Le;
                case 5835: goto L1c;
                case 25315: goto L29;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            r3.context = r4
            int r0 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r0 < 0) goto L19
            java.lang.String r0 = "ۨۨ"
            goto L2
        L19:
            java.lang.String r0 = "ۨۨ۠"
            goto L2
        L1c:
            int r1 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r1 < 0) goto L26
            androidx.preference.layout2.AnonymousClass9.m639()
            goto L2
        L26:
            java.lang.String r0 = "ۥۨۨ"
            goto L2
        L29:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2$.access$S1000003(androidx.preference.layout2$, android.content.Context):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
    /* renamed from: ۟۠ۧ, reason: not valid java name and contains not printable characters */
    public static String m491(Object obj) {
        String str = "۟ۢۧ";
        String str2 = null;
        String str3 = null;
        while (true) {
            switch (layout2.AnonymousClass5.m528((Object) str) ^ 1748614) {
                case 2428:
                    break;
                case 2530:
                    if (layout2.AnonymousClass7.m603() > 0) {
                        str = "ۢ۠ۡ";
                    } else if (layout2.AnonymousClass8.m616() >= 0) {
                        layout2.AnonymousClass5.m553();
                    } else {
                        str = "ۣۥۤ";
                    }
                case 4238:
                    if (layout2.AnonymousClass9.m639() <= 0) {
                        layout2.AnonymousClass9.m639();
                        str = "ۣ۟ۡ";
                    } else {
                        str = "۟ۢۧ";
                    }
                case 4872:
                    str = "ۤ۟۠";
                    str2 = null;
                case 5955:
                    str = "ۢۥۦ";
                case 6212:
                    str3 = layout2.access$1000002((Context) obj);
                    str = "ۨ۠ۤ";
                case 7397:
                    if (layout2.AnonymousClass7.m603() >= 0) {
                        layout2.AnonymousClass8.m616();
                    } else {
                        str = "ۥ۟ۨ";
                    }
                case 7557:
                case 28418:
                    str = "۟ۧۢ";
                case 26218:
                    str = "۟ۧۢ";
                    str2 = str3;
                case 1733304:
                    str = "ۢ۠ۡ";
            }
            return str2;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
    /* renamed from: ۟ۡۡۨۥ, reason: not valid java name and contains not printable characters */
    public static Context m492(Object obj) {
        Object obj2 = "۟ۤۥ";
        Context context = null;
        Context context2 = null;
        while (true) {
            switch (layout2.AnonymousClass5.m528(obj2) ^ 1748734) {
                case 2398:
                    if (layout2.AnonymousClass8.m616() > 0) {
                        obj2 = "ۣۢۤ";
                    } else if (layout2.AnonymousClass6.m569() < 0) {
                        obj2 = "ۧ۟۟";
                    }
                case 2554:
                    if (layout2.AnonymousClass8.m616() >= 0) {
                        layout2.AnonymousClass5.m553();
                        obj2 = "ۥۨۨ";
                    } else {
                        obj2 = "ۨۦ۟";
                    }
                case 4923:
                case 26463:
                    if (layout2.AnonymousClass9.m639() > 0) {
                        obj2 = "ۤ۟ۧ";
                    }
                case 5938:
                    break;
                case 7229:
                    if (layout2.AnonymousClass6.m569() >= 0) {
                        layout2.AnonymousClass6.m569();
                        obj2 = "۟ۢ۠";
                    } else {
                        obj2 = "ۢۡ۟";
                    }
                case 7294:
                    obj2 = "۟۟ۤ";
                    context = null;
                case 7295:
                    obj2 = "ۣۢۤ";
                case 7674:
                    obj2 = "ۤ۟ۧ";
                    context = context2;
                case 27641:
                    context2 = ((layout2$) obj).context;
                    if (layout2.AnonymousClass7.m603() < 0) {
                        obj2 = "ۢۥۧ";
                    }
                case 27902:
                    obj2 = "۟ۤۥ";
            }
            return context;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069 A[SYNTHETIC] */
    /* renamed from: ۟ۢۤۡۦ, reason: not valid java name and contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m493(java.lang.Object r6) {
        /*
            r3 = 0
            java.lang.String r0 = "ۣۨ۠"
            r1 = r0
            r2 = r3
            r4 = r3
        L6:
            int r0 = androidx.preference.layout2.AnonymousClass5.m528(r1)
            r5 = 1749604(0x1ab264, float:2.451717E-39)
            r0 = r0 ^ r5
            switch(r0) {
                case 196: goto L12;
                case 1221: goto L55;
                case 1407: goto L3e;
                case 4040: goto L30;
                case 5562: goto L16;
                case 6771: goto L48;
                case 7334: goto L1b;
                case 7372: goto L82;
                case 7483: goto L63;
                case 31715: goto L71;
                case 1732350: goto L71;
                default: goto L11;
            }
        L11:
            goto L6
        L12:
            java.lang.String r0 = "ۨۥۤ"
            r1 = r0
            goto L6
        L16:
            java.lang.String r0 = "ۢۢ۠"
            r1 = r0
            r2 = r3
            goto L6
        L1b:
            r0 = r6
            androidx.preference.layout2$4 r0 = (androidx.preference.layout2.AnonymousClass4) r0
            java.lang.String r4 = r0.getpositivebtn()
            int r0 = androidx.preference.layout2.AnonymousClass8.m616()
            if (r0 < 0) goto L2c
            androidx.preference.layout2.AnonymousClass7.m603()
            goto L6
        L2c:
            java.lang.String r0 = "۟ۨ۠"
            r1 = r0
            goto L6
        L30:
            int r0 = androidx.preference.layout2.AnonymousClass8.m616()
            if (r0 < 0) goto L3a
            androidx.preference.layout2.AnonymousClass7.m603()
            goto L6
        L3a:
            java.lang.String r0 = "۟ۦۥ"
            r1 = r0
            goto L6
        L3e:
            int r0 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r0 > 0) goto L63
            java.lang.String r0 = "ۡۡۢ"
            r1 = r0
            goto L6
        L48:
            int r0 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r0 < 0) goto L50
            r2 = r4
            goto L6
        L50:
            java.lang.String r0 = "ۡ۠ۧ"
            r1 = r0
            r2 = r4
            goto L6
        L55:
            int r0 = androidx.preference.layout2.AnonymousClass9.m639()
            if (r0 > 0) goto L5f
            androidx.preference.layout2.AnonymousClass8.m616()
            goto L6
        L5f:
            java.lang.String r0 = "ۣۨ۠"
            r1 = r0
            goto L6
        L63:
            int r0 = androidx.preference.layout2.AnonymousClass8.m616()
            if (r0 < 0) goto L6d
            androidx.preference.layout2.AnonymousClass9.m639()
            goto L6
        L6d:
            java.lang.String r0 = "ۥ۠ۧ"
            r1 = r0
            goto L6
        L71:
            int r0 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r0 < 0) goto L7e
            androidx.preference.layout2.AnonymousClass6.m569()
            java.lang.String r0 = "۟۟ۦ"
            r1 = r0
            goto L6
        L7e:
            java.lang.String r0 = "ۡ۠ۧ"
            r1 = r0
            goto L6
        L82:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2$.m493(java.lang.Object):java.lang.String");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0070 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006c A[SYNTHETIC] */
    /* renamed from: ۣ۟ۢۨ۠, reason: not valid java name and contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.preference.layout2.AnonymousClass4 m494(java.lang.Object r6, java.lang.Object r7) {
        /*
            r3 = 0
            java.lang.String r0 = "ۣۤۧ"
            r2 = r3
            r1 = r3
        L5:
            int r4 = androidx.preference.layout2.AnonymousClass5.m528(r0)
            r5 = 56536(0xdcd8, float:7.9224E-41)
            r4 = r4 ^ r5
            switch(r4) {
                case 100: goto L11;
                case 164: goto L66;
                case 1709064: goto L59;
                case 1709468: goto L4d;
                case 1710591: goto L31;
                case 1729092: goto L76;
                case 1730192: goto L1e;
                case 1731524: goto L49;
                case 1733497: goto L40;
                case 1735480: goto L73;
                case 1735673: goto L59;
                default: goto L10;
            }
        L10:
            goto L5
        L11:
            r0 = r6
            androidx.preference.layout2$ r0 = (androidx.preference.layout2$) r0
            r1 = r7
            java.lang.String[] r1 = (java.lang.String[]) r1
            androidx.preference.layout2$4 r1 = r0.doInBackground2(r1)
            java.lang.String r0 = "ۧ۠۠"
            goto L5
        L1e:
            int r4 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r4 >= 0) goto L66
            int r4 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r4 < 0) goto L2e
            androidx.preference.layout2.AnonymousClass7.m603()
            goto L5
        L2e:
            java.lang.String r0 = "ۦۢ"
            goto L5
        L31:
            int r2 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r2 < 0) goto L3c
            androidx.preference.layout2.AnonymousClass9.m639()
            r2 = r1
            goto L5
        L3c:
            java.lang.String r0 = "ۥۨ۟"
            r2 = r1
            goto L5
        L40:
            int r4 = androidx.preference.layout2.AnonymousClass8.m616()
            if (r4 >= 0) goto L5
            java.lang.String r0 = "ۨ۟ۧ"
            goto L5
        L49:
            java.lang.String r0 = "ۡۨۨ"
            r2 = r3
            goto L5
        L4d:
            int r0 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r0 < 0) goto L56
            java.lang.String r0 = "ۧۡ۟"
            goto L5
        L56:
            java.lang.String r0 = "ۣۨۡ"
            goto L5
        L59:
            int r4 = androidx.preference.layout2.AnonymousClass9.m639()
            if (r4 > 0) goto L63
            androidx.preference.layout2.AnonymousClass8.m616()
            goto L5
        L63:
            java.lang.String r0 = "ۥۨ۟"
            goto L5
        L66:
            int r4 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r4 < 0) goto L70
            androidx.preference.layout2.AnonymousClass7.m603()
            goto L5
        L70:
            java.lang.String r0 = "ۣۨ۟"
            goto L5
        L73:
            java.lang.String r0 = "ۣۤۧ"
            goto L5
        L76:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2$.m494(java.lang.Object, java.lang.Object):androidx.preference.layout2$4");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0066 A[SYNTHETIC] */
    /* renamed from: ۟ۥ۟ۢۤ, reason: not valid java name and contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m495(java.lang.Object r6) {
        /*
            r2 = 0
            java.lang.String r0 = "ۥۢۧ"
            r1 = r2
            r3 = r2
        L5:
            int r4 = androidx.preference.layout2.AnonymousClass5.m528(r0)
            r5 = 1753538(0x1ac1c2, float:2.45723E-39)
            r4 = r4 ^ r5
            switch(r4) {
                case 32: goto L11;
                case 1098: goto L7c;
                case 1253: goto L48;
                case 2058: goto L6f;
                case 26341: goto L60;
                case 28383: goto L3c;
                case 28515: goto L1a;
                case 31590: goto L26;
                case 31784: goto L33;
                case 32608: goto L54;
                case 1710626: goto L6f;
                default: goto L10;
            }
        L10:
            goto L5
        L11:
            int r0 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r0 < 0) goto L30
            java.lang.String r0 = "ۨۤۨ"
            goto L5
        L1a:
            int r0 = androidx.preference.layout2.AnonymousClass8.m616()
            if (r0 < 0) goto L23
            java.lang.String r0 = "ۢۤۡ"
            goto L5
        L23:
            java.lang.String r0 = "ۡۤ۠"
            goto L5
        L26:
            r0 = r6
            androidx.preference.layout2$4 r0 = (androidx.preference.layout2.AnonymousClass4) r0
            java.lang.String r3 = r0.getTitle()
            java.lang.String r0 = "ۧ۠۠"
            goto L5
        L30:
            java.lang.String r0 = "ۨۧۧ"
            goto L5
        L33:
            int r0 = androidx.preference.layout2.AnonymousClass8.m616()
            if (r0 > 0) goto L60
            java.lang.String r0 = "ۤۦۦ"
            goto L5
        L3c:
            int r1 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r1 < 0) goto L44
            r1 = r2
            goto L5
        L44:
            java.lang.String r0 = "ۦۤ۠"
            r1 = r2
            goto L5
        L48:
            int r1 = androidx.preference.layout2.AnonymousClass8.m616()
            if (r1 < 0) goto L50
            r1 = r3
            goto L5
        L50:
            java.lang.String r0 = "ۣۧۤ"
            r1 = r3
            goto L5
        L54:
            int r0 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r0 < 0) goto L5d
            java.lang.String r0 = "ۨۦ۟"
            goto L5
        L5d:
            java.lang.String r0 = "ۥۢۧ"
            goto L5
        L60:
            int r0 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r0 < 0) goto L6c
            androidx.preference.layout2.AnonymousClass6.m569()
            java.lang.String r0 = "ۣۧۡ"
            goto L5
        L6c:
            java.lang.String r0 = "ۡ۠۠"
            goto L5
        L6f:
            int r4 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r4 < 0) goto L79
            androidx.preference.layout2.AnonymousClass6.m569()
            goto L5
        L79:
            java.lang.String r0 = "ۣۧۤ"
            goto L5
        L7c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2$.m495(java.lang.Object):java.lang.String");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
    /* renamed from: ۟ۦۢۦ, reason: not valid java name and contains not printable characters */
    public static String m496(Object obj) {
        String str = "۠ۡۤ";
        String str2 = null;
        String str3 = null;
        while (true) {
            switch (layout2.AnonymousClass5.m528((Object) str) ^ 56290) {
                case 1711654:
                    str = layout2.AnonymousClass8.m616() >= 0 ? "ۦ۠ۨ" : "ۧ۟ۢ";
                case 1711818:
                case 1711848:
                case 1735737:
                    str = "ۡۡۨ";
                case 1730777:
                    str = "۠ۡۤ";
                case 1732075:
                    str3 = ((layout2.AnonymousClass4) obj).getVersion();
                    str = "۠ۡۧ";
                case 1732702:
                    if (layout2.AnonymousClass9.m639() <= 0) {
                        layout2.AnonymousClass5.m553();
                        str2 = null;
                    } else {
                        str = "ۧۥۢ";
                        str2 = null;
                    }
                case 1732806:
                    str = layout2.AnonymousClass7.m603() >= 0 ? "ۨۤ۠" : "ۣ۠ۧ";
                case 1732833:
                    str = layout2.AnonymousClass6.m569() < 0 ? layout2.AnonymousClass5.m553() >= 0 ? "ۣۤۧ" : "ۣ۟ۥ" : "۠ۢۦ";
                case 1732836:
                    if (layout2.AnonymousClass8.m616() >= 0) {
                        str2 = str3;
                    } else {
                        str = "ۡۡۨ";
                        str2 = str3;
                    }
                case 1733930:
                    break;
            }
            return str2;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
    /* renamed from: ۟ۧۤۡۦ, reason: not valid java name and contains not printable characters */
    public static String m497(Object obj) {
        Object obj2 = "ۣۨۢ";
        String str = null;
        String str2 = null;
        while (true) {
            switch (layout2.AnonymousClass5.m528(obj2) ^ 1749794) {
                case 33:
                    break;
                case StatusLine.HTTP_MISDIRECTED_REQUEST /* 421 */:
                case 7232:
                    if (layout2.AnonymousClass7.m603() < 0) {
                        obj2 = "ۢۥۦ";
                    }
                case 422:
                    if (layout2.AnonymousClass5.m553() >= 0) {
                        layout2.AnonymousClass8.m616();
                        obj2 = "ۨۤۨ";
                    } else {
                        obj2 = "ۣۨۢ";
                    }
                case 480:
                    if (layout2.AnonymousClass8.m616() >= 0) {
                        obj2 = "ۢۡۢ";
                        str = null;
                    } else {
                        obj2 = "۟۟ۦ";
                        str = null;
                    }
                case 1087:
                    if (layout2.AnonymousClass6.m569() >= 0) {
                        obj2 = "۠ۡۦ";
                    } else if (layout2.AnonymousClass5.m553() >= 0) {
                        layout2.AnonymousClass6.m569();
                        obj2 = "ۦۧۨ";
                    } else {
                        obj2 = "ۤۢۤ";
                    }
                case 2308:
                    str2 = ((layout2.AnonymousClass4) obj).getchangelogTitle();
                    if (layout2.AnonymousClass6.m569() < 0) {
                        obj2 = "ۥ۠ۢ";
                    }
                case 3717:
                    obj2 = "ۢۥۦ";
                    str = str2;
                case 5156:
                    obj2 = "ۢۡۦ";
                case 6183:
                    if (layout2.AnonymousClass9.m639() <= 0) {
                        layout2.AnonymousClass9.m639();
                    } else {
                        obj2 = "ۣۣۢ";
                    }
                case 30258:
                    obj2 = "۠ۡۦ";
            }
            return str;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
    /* renamed from: ۠ۢۡۥ, reason: not valid java name and contains not printable characters */
    public static String m498(Object obj) {
        String str = "۟ۧۧ";
        String str2 = null;
        String str3 = null;
        while (true) {
            switch (layout2.AnonymousClass5.m528((Object) str) ^ 1752674) {
                case 104:
                    str3 = ((layout2.AnonymousClass4) obj).getMessage();
                    if (layout2.AnonymousClass5.m553() >= 0) {
                        layout2.AnonymousClass7.m603();
                        str = "ۣۤۧ";
                    } else {
                        str = "ۥۡ۠";
                    }
                case 934:
                    str = "ۣۤ۠";
                    str2 = str3;
                case 1059:
                    break;
                case 4413:
                    str = "ۡۡ";
                    str2 = null;
                case 6557:
                    if (layout2.AnonymousClass8.m616() > 0) {
                        str = "ۣۧۧ";
                    } else if (layout2.AnonymousClass8.m616() >= 0) {
                        layout2.AnonymousClass6.m569();
                    } else {
                        str = "ۥۣۨ";
                    }
                case 30502:
                    str = "ۣۧۧ";
                case 31684:
                    str = "۟ۧۧ";
                case 31721:
                    str = "ۡۦۤ";
                case 1729088:
                case 1729116:
                    if (layout2.AnonymousClass9.m639() <= 0) {
                        layout2.AnonymousClass6.m569();
                    } else {
                        str = "ۣۤ۠";
                    }
                case 1729090:
                    if (layout2.AnonymousClass5.m553() >= 0) {
                        layout2.AnonymousClass6.m569();
                        str = "ۨۦۥ";
                    } else {
                        str = "ۢ۠";
                    }
            }
            return str2;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
    /* renamed from: ۡۦۢۡ, reason: not valid java name and contains not printable characters */
    public static short[] m499() {
        String str = "ۤۢ۟";
        short[] sArr = null;
        short[] sArr2 = null;
        while (true) {
            switch (layout2.AnonymousClass5.m528((Object) str) ^ 1751588) {
                case 5:
                    if (layout2.AnonymousClass8.m616() > 0) {
                        str = "ۣۢ۠";
                    } else if (layout2.AnonymousClass9.m639() <= 0) {
                        layout2.AnonymousClass9.m639();
                        str = "ۣۡۡ";
                    } else {
                        str = "ۦۣ۟";
                    }
                case 1068:
                    str = "ۣۢ۠";
                case 1985:
                    str = "ۤۢ۟";
                case 2180:
                    if (layout2.AnonymousClass5.m553() >= 0) {
                        str = "ۣۥۦ";
                        sArr = null;
                    } else {
                        str = "ۨۤۨ";
                        sArr = null;
                    }
                case 2203:
                    if (layout2.AnonymousClass9.m639() > 0) {
                        str = "ۢۢ۠";
                    }
                case 5249:
                    str = "ۣۡ";
                    sArr = sArr2;
                case 29512:
                    if (layout2.AnonymousClass8.m616() >= 0) {
                        layout2.AnonymousClass9.m639();
                    } else {
                        str = "ۧۧۢ";
                    }
                case 31598:
                    sArr2 = f20short;
                    if (layout2.AnonymousClass5.m553() < 0) {
                        str = "ۡ۠ۤ";
                    }
                case 31782:
                case 32739:
                    if (layout2.AnonymousClass6.m569() < 0) {
                        str = "ۣۡ";
                    }
                case 1730054:
                    break;
            }
            return sArr;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0005 A[SYNTHETIC] */
    /* renamed from: ۣۢۧۤ, reason: not valid java name and contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m500() {
        /*
            r2 = 0
            java.lang.String r0 = "ۧۢۧ"
            r1 = r2
            r3 = r2
        L5:
            int r4 = androidx.preference.layout2.AnonymousClass5.m528(r0)
            r5 = 1747806(0x1aab5e, float:2.449198E-39)
            r4 = r4 ^ r5
            switch(r4) {
                case 1050: goto L11;
                case 3135: goto L4b;
                case 4436: goto L4f;
                case 7294: goto L6e;
                case 7457: goto L7a;
                case 7610: goto L1f;
                case 28030: goto L1b;
                case 28210: goto L2c;
                case 28242: goto L3e;
                case 28347: goto L6e;
                case 1734427: goto L65;
                default: goto L10;
            }
        L10:
            goto L5
        L11:
            int r4 = androidx.preference.layout2.AnonymousClass9.m639()
            if (r4 > 0) goto L62
            androidx.preference.layout2.AnonymousClass6.m569()
            goto L5
        L1b:
            java.lang.String r0 = "ۣۦۧ"
            r1 = r2
            goto L5
        L1f:
            int r4 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r4 < 0) goto L29
            androidx.preference.layout2.AnonymousClass6.m569()
            goto L5
        L29:
            java.lang.String r0 = "ۣۨۥ"
            goto L5
        L2c:
            int r4 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r4 >= 0) goto L65
            int r0 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r0 < 0) goto L3b
            java.lang.String r0 = "ۢۧ"
            goto L5
        L3b:
            java.lang.String r0 = "ۤۡۧ"
            goto L5
        L3e:
            int r4 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r4 < 0) goto L48
            androidx.preference.layout2.AnonymousClass7.m603()
            goto L5
        L48:
            java.lang.String r0 = "ۧۨۡ"
            goto L5
        L4b:
            java.lang.String r0 = "ۣۣ۟"
            r1 = r3
            goto L5
        L4f:
            java.lang.String r3 = androidx.preference.layout2.access$L1000001()
            int r0 = androidx.preference.layout2.AnonymousClass8.m616()
            if (r0 < 0) goto L5f
            androidx.preference.layout2.AnonymousClass7.m603()
            java.lang.String r0 = "ۨۦۣ"
            goto L5
        L5f:
            java.lang.String r0 = "۟ۢۤ"
            goto L5
        L62:
            java.lang.String r0 = "ۧۢۧ"
            goto L5
        L65:
            int r4 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r4 >= 0) goto L5
            java.lang.String r0 = "ۧ۟ۤ"
            goto L5
        L6e:
            int r0 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r0 < 0) goto L77
            java.lang.String r0 = "ۦ۠ۢ"
            goto L5
        L77:
            java.lang.String r0 = "ۣۣ۟"
            goto L5
        L7a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2$.m500():java.lang.String");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x004b A[SYNTHETIC] */
    /* renamed from: ۣۣۤۧ, reason: not valid java name and contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m501(java.lang.Object r6) {
        /*
            r2 = 0
            java.lang.String r0 = "ۢۡ"
            r1 = r2
            r3 = r2
        L5:
            int r4 = androidx.preference.layout2.AnonymousClass5.m528(r0)
            r5 = 1751713(0x1abaa1, float:2.454673E-39)
            r4 = r4 ^ r5
            switch(r4) {
                case 843: goto L11;
                case 2248: goto L62;
                case 2530: goto L26;
                case 3203: goto L2f;
                case 4198: goto L39;
                case 5376: goto L52;
                case 7548: goto L5f;
                case 7648: goto L15;
                case 1730179: goto L52;
                case 1730206: goto L3c;
                case 1730212: goto L45;
                default: goto L10;
            }
        L10:
            goto L5
        L11:
            java.lang.String r0 = "ۢۧۨ"
            r1 = r2
            goto L5
        L15:
            int r0 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r0 < 0) goto L22
            androidx.preference.layout2.AnonymousClass5.m553()
            java.lang.String r0 = "ۣۡۨ"
            r1 = r3
            goto L5
        L22:
            java.lang.String r0 = "ۢ۠ۧ"
            r1 = r3
            goto L5
        L26:
            int r4 = androidx.preference.layout2.AnonymousClass8.m616()
            if (r4 >= 0) goto L5
            java.lang.String r0 = "ۣۡ"
            goto L5
        L2f:
            r0 = r6
            androidx.preference.layout2$4 r0 = (androidx.preference.layout2.AnonymousClass4) r0
            java.lang.String r3 = r0.getchangeLogMessage()
            java.lang.String r0 = "ۣ۟ۡ"
            goto L5
        L39:
            java.lang.String r0 = "ۤ۠ۦ"
            goto L5
        L3c:
            int r4 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r4 > 0) goto L45
            java.lang.String r0 = "ۣ۠۟"
            goto L5
        L45:
            int r4 = androidx.preference.layout2.AnonymousClass8.m616()
            if (r4 < 0) goto L4f
            androidx.preference.layout2.AnonymousClass5.m553()
            goto L5
        L4f:
            java.lang.String r0 = "۠۟ۦ"
            goto L5
        L52:
            int r4 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r4 < 0) goto L5c
            androidx.preference.layout2.AnonymousClass6.m569()
            goto L5
        L5c:
            java.lang.String r0 = "ۢ۠ۧ"
            goto L5
        L5f:
            java.lang.String r0 = "ۢۡ"
            goto L5
        L62:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2$.m501(java.lang.Object):java.lang.String");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0006 A[SYNTHETIC] */
    /* renamed from: ۤ۟ۡۤ, reason: not valid java name and contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m502(java.lang.Object r6) {
        /*
            r3 = 0
            java.lang.String r0 = "ۧ۟ۡ"
            r1 = r0
            r2 = r3
            r4 = r3
        L6:
            int r0 = androidx.preference.layout2.AnonymousClass5.m528(r1)
            r5 = 1753640(0x1ac228, float:2.457373E-39)
            r0 = r0 ^ r5
            switch(r0) {
                case 1824: goto L12;
                case 1825: goto L21;
                case 2849: goto L84;
                case 26893: goto L12;
                case 26996: goto L68;
                case 27854: goto L1c;
                case 27950: goto L8f;
                case 28770: goto L53;
                case 29000: goto L43;
                case 30720: goto L35;
                case 30828: goto L76;
                default: goto L11;
            }
        L11:
            goto L6
        L12:
            int r0 = androidx.preference.layout2.AnonymousClass8.m616()
            if (r0 < 0) goto L72
            androidx.preference.layout2.AnonymousClass8.m616()
            goto L6
        L1c:
            java.lang.String r0 = "ۣۡۨ"
            r1 = r0
            r2 = r4
            goto L6
        L21:
            int r0 = androidx.preference.layout2.AnonymousClass8.m616()
            if (r0 > 0) goto L84
            int r0 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r0 < 0) goto L31
            androidx.preference.layout2.AnonymousClass7.m603()
            goto L6
        L31:
            java.lang.String r0 = "ۢ۟ۧ"
            r1 = r0
            goto L6
        L35:
            int r0 = androidx.preference.layout2.AnonymousClass8.m616()
            if (r0 < 0) goto L3f
            androidx.preference.layout2.AnonymousClass7.m603()
            goto L6
        L3f:
            java.lang.String r0 = "ۧ۟۠"
            r1 = r0
            goto L6
        L43:
            int r0 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r0 < 0) goto L4e
            java.lang.String r0 = "ۨۤۨ"
            r1 = r0
            r2 = r3
            goto L6
        L4e:
            java.lang.String r0 = "ۤۢۦ"
            r1 = r0
            r2 = r3
            goto L6
        L53:
            r0 = r6
            androidx.preference.layout2$4 r0 = (androidx.preference.layout2.AnonymousClass4) r0
            java.lang.String r4 = r0.getnegativebtn()
            int r0 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r0 < 0) goto L64
            androidx.preference.layout2.AnonymousClass9.m639()
            goto L6
        L64:
            java.lang.String r0 = "ۡۢۧ"
            r1 = r0
            goto L6
        L68:
            int r0 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r0 >= 0) goto L6
            java.lang.String r0 = "ۢۨۦ"
            r1 = r0
            goto L6
        L72:
            java.lang.String r0 = "ۣۡۨ"
            r1 = r0
            goto L6
        L76:
            int r0 = androidx.preference.layout2.AnonymousClass9.m639()
            if (r0 > 0) goto L80
            java.lang.String r0 = "۟ۨۡ"
            r1 = r0
            goto L6
        L80:
            java.lang.String r0 = "ۧ۟ۡ"
            r1 = r0
            goto L6
        L84:
            int r0 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r0 >= 0) goto L6
            java.lang.String r0 = "۠ۤ۠"
            r1 = r0
            goto L6
        L8f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2$.m502(java.lang.Object):java.lang.String");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0077 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0070 A[SYNTHETIC] */
    /* renamed from: ۤۥۤۤ, reason: not valid java name and contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m503(java.lang.Object r6) {
        /*
            r3 = 0
            java.lang.String r0 = "۠ۥۢ"
            r1 = r0
            r2 = r3
            r4 = r3
        L6:
            int r0 = androidx.preference.layout2.AnonymousClass5.m528(r1)
            r5 = 1753515(0x1ac1ab, float:2.457198E-39)
            r0 = r0 ^ r5
            switch(r0) {
                case 67: goto L12;
                case 198: goto L59;
                case 229: goto L6a;
                case 1063: goto L7f;
                case 1128: goto L3e;
                case 2211: goto L1c;
                case 26313: goto L48;
                case 27350: goto L2f;
                case 28502: goto L12;
                case 29431: goto L39;
                case 31776: goto L8f;
                default: goto L11;
            }
        L11:
            goto L6
        L12:
            int r0 = androidx.preference.layout2.AnonymousClass9.m639()
            if (r0 > 0) goto L7b
            androidx.preference.layout2.AnonymousClass5.m553()
            goto L6
        L1c:
            int r0 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r0 < 0) goto L2a
            androidx.preference.layout2.AnonymousClass7.m603()
            java.lang.String r0 = "ۣۦۥ"
            r1 = r0
            r2 = r3
            goto L6
        L2a:
            java.lang.String r0 = "ۧۥۡ"
            r1 = r0
            r2 = r3
            goto L6
        L2f:
            int r0 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r0 > 0) goto L6a
            java.lang.String r0 = "۟ۢۥ"
            r1 = r0
            goto L6
        L39:
            java.lang.String r0 = "ۥ۟ۥ"
            r1 = r0
            r2 = r4
            goto L6
        L3e:
            int r0 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r0 >= 0) goto L6
            java.lang.String r0 = "ۣۡ۟"
            r1 = r0
            goto L6
        L48:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r4 = androidx.preference.layout2.access$1000008(r0)
            int r0 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r0 >= 0) goto L6
            java.lang.String r0 = "ۢۨۢ"
            r1 = r0
            goto L6
        L59:
            int r0 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r0 < 0) goto L66
            androidx.preference.layout2.AnonymousClass8.m616()
            java.lang.String r0 = "ۤۤۥ"
            r1 = r0
            goto L6
        L66:
            java.lang.String r0 = "ۨۡۡ"
            r1 = r0
            goto L6
        L6a:
            int r0 = androidx.preference.layout2.AnonymousClass9.m639()
            if (r0 > 0) goto L77
            androidx.preference.layout2.AnonymousClass5.m553()
            java.lang.String r0 = "ۡۦۧ"
            r1 = r0
            goto L6
        L77:
            java.lang.String r0 = "ۦ۠ۧ"
            r1 = r0
            goto L6
        L7b:
            java.lang.String r0 = "ۥ۟ۥ"
            r1 = r0
            goto L6
        L7f:
            int r0 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r0 < 0) goto L8a
            androidx.preference.layout2.AnonymousClass8.m616()
            goto L6
        L8a:
            java.lang.String r0 = "۠ۥۢ"
            r1 = r0
            goto L6
        L8f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2$.m503(java.lang.Object):java.lang.String");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0059 A[SYNTHETIC] */
    /* renamed from: ۥۦۦۥ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m504(java.lang.Object r3, java.lang.Object r4) {
        /*
            java.lang.String r0 = "ۣۨۤ"
        L2:
            int r1 = androidx.preference.layout2.AnonymousClass5.m528(r0)
            r2 = 1754445(0x1ac54d, float:2.458501E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 1869: goto Le;
                case 1903: goto Lf;
                case 3076: goto L1c;
                case 29551: goto L47;
                case 30948: goto L4a;
                case 31567: goto L53;
                case 31697: goto L2f;
                case 1710572: goto L4a;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            return
        Lf:
            int r1 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r1 < 0) goto L19
            androidx.preference.layout2.AnonymousClass8.m616()
            goto L2
        L19:
            java.lang.String r0 = "ۥ۠ۤ"
            goto L2
        L1c:
            int r1 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r1 > 0) goto L53
            int r1 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r1 < 0) goto L2c
            androidx.preference.layout2.AnonymousClass8.m616()
            goto L2
        L2c:
            java.lang.String r0 = "ۥۨ۟"
            goto L2
        L2f:
            r0 = r3
            androidx.preference.layout2$ r0 = (androidx.preference.layout2$) r0
            r1 = r4
            androidx.preference.layout2$4 r1 = (androidx.preference.layout2.AnonymousClass4) r1
            r0.onPostExecute2(r1)
            int r0 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r0 < 0) goto L44
            androidx.preference.layout2.AnonymousClass9.m639()
            java.lang.String r0 = "ۧۥۥ"
            goto L2
        L44:
            java.lang.String r0 = "ۦۥ۟"
            goto L2
        L47:
            java.lang.String r0 = "ۣۨۤ"
            goto L2
        L4a:
            int r1 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r1 >= 0) goto L2
            java.lang.String r0 = "ۦۥ۟"
            goto L2
        L53:
            int r1 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r1 < 0) goto L5d
            androidx.preference.layout2.AnonymousClass6.m569()
            goto L2
        L5d:
            java.lang.String r0 = "ۦۦۢ"
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2$.m504(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0061 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e A[SYNTHETIC] */
    /* renamed from: ۦۦۢۧ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.preference.layout2.AnonymousClass4 m505(java.lang.Object r6, java.lang.Object r7) {
        /*
            r3 = 0
            java.lang.String r0 = "ۥ۠ۦ"
            r2 = r3
            r1 = r3
        L5:
            int r4 = androidx.preference.layout2.AnonymousClass5.m528(r0)
            r5 = 1751523(0x1ab9e3, float:2.454406E-39)
            r4 = r4 ^ r5
            switch(r4) {
                case 1096: goto L11;
                case 1989: goto L64;
                case 3874: goto L23;
                case 3979: goto L46;
                case 4073: goto L1a;
                case 4837: goto L3f;
                case 31750: goto L42;
                case 31855: goto L32;
                case 32704: goto L58;
                case 1729952: goto L55;
                case 1729958: goto L55;
                default: goto L10;
            }
        L10:
            goto L5
        L11:
            int r0 = androidx.preference.layout2.AnonymousClass8.m616()
            if (r0 > 0) goto L58
            java.lang.String r0 = "ۣۧۨ"
            goto L5
        L1a:
            int r4 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r4 >= 0) goto L5
            java.lang.String r0 = "ۢۧ"
            goto L5
        L23:
            int r2 = androidx.preference.layout2.AnonymousClass9.m639()
            if (r2 > 0) goto L2e
            androidx.preference.layout2.AnonymousClass6.m569()
            r2 = r1
            goto L5
        L2e:
            java.lang.String r0 = "ۥۤۥ"
            r2 = r1
            goto L5
        L32:
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
            r1 = r7
            java.lang.String r1 = (java.lang.String) r1
            androidx.preference.layout2$4 r1 = androidx.preference.layout2.access$1000009(r0, r1)
            java.lang.String r0 = "ۣۥۣ"
            goto L5
        L3f:
            java.lang.String r0 = "ۧۦۤ"
            goto L5
        L42:
            java.lang.String r0 = "ۣ۟ۦ"
            r2 = r3
            goto L5
        L46:
            int r0 = androidx.preference.layout2.AnonymousClass9.m639()
            if (r0 > 0) goto L52
            androidx.preference.layout2.AnonymousClass5.m553()
            java.lang.String r0 = "ۣ۠"
            goto L5
        L52:
            java.lang.String r0 = "ۥ۠ۦ"
            goto L5
        L55:
            java.lang.String r0 = "ۥۤۥ"
            goto L5
        L58:
            int r0 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r0 < 0) goto L61
            java.lang.String r0 = "ۨۨۨ"
            goto L5
        L61:
            java.lang.String r0 = "۠ۡۧ"
            goto L5
        L64:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2$.m505(java.lang.Object, java.lang.Object):androidx.preference.layout2$4");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d A[SYNTHETIC] */
    /* renamed from: ۣۧ۠ۡ, reason: not valid java name and contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m506(java.lang.Object r6) {
        /*
            r3 = 0
            java.lang.String r0 = "ۥۣ"
            r1 = r0
            r2 = r3
            r4 = r3
        L6:
            int r0 = androidx.preference.layout2.AnonymousClass5.m528(r1)
            r5 = 1751678(0x1aba7e, float:2.454624E-39)
            r0 = r0 ^ r5
            switch(r0) {
                case 1145: goto L12;
                case 2365: goto L1c;
                case 7618: goto L54;
                case 29328: goto L77;
                case 29692: goto L62;
                case 30844: goto L40;
                case 31504: goto L85;
                case 31865: goto L9a;
                case 32697: goto L8a;
                case 1730137: goto L8a;
                case 1730272: goto L2c;
                default: goto L11;
            }
        L11:
            goto L6
        L12:
            int r0 = androidx.preference.layout2.AnonymousClass9.m639()
            if (r0 > 0) goto L50
            androidx.preference.layout2.AnonymousClass6.m569()
            goto L6
        L1c:
            int r0 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r0 < 0) goto L27
            androidx.preference.layout2.AnonymousClass9.m639()
            r2 = r4
            goto L6
        L27:
            java.lang.String r0 = "ۧۧۧ"
            r1 = r0
            r2 = r4
            goto L6
        L2c:
            int r0 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r0 >= 0) goto L77
            int r0 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r0 < 0) goto L3c
            java.lang.String r0 = "۠ۥۧ"
            r1 = r0
            goto L6
        L3c:
            java.lang.String r0 = "ۨۥ۟"
            r1 = r0
            goto L6
        L40:
            int r0 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r0 < 0) goto L4b
            java.lang.String r0 = "ۣۨ۟"
            r1 = r0
            r2 = r3
            goto L6
        L4b:
            java.lang.String r0 = "ۥۣۥ"
            r1 = r0
            r2 = r3
            goto L6
        L50:
            java.lang.String r0 = "ۧۥۥ"
            r1 = r0
            goto L6
        L54:
            int r0 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r0 < 0) goto L5e
            java.lang.String r0 = "ۢۧ"
            r1 = r0
            goto L6
        L5e:
            java.lang.String r0 = "ۦۥۡ"
            r1 = r0
            goto L6
        L62:
            r0 = r6
            androidx.preference.layout2$4 r0 = (androidx.preference.layout2.AnonymousClass4) r0
            java.lang.String r4 = r0.getDownloadLink()
            int r0 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r0 < 0) goto L73
            androidx.preference.layout2.AnonymousClass9.m639()
            goto L6
        L73:
            java.lang.String r0 = "ۢۧۨ"
            r1 = r0
            goto L6
        L77:
            int r0 = androidx.preference.layout2.AnonymousClass8.m616()
            if (r0 < 0) goto L81
            androidx.preference.layout2.AnonymousClass7.m603()
            goto L6
        L81:
            java.lang.String r0 = "۟ۥۢ"
            r1 = r0
            goto L6
        L85:
            java.lang.String r0 = "ۥۣ"
            r1 = r0
            goto L6
        L8a:
            int r0 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r0 < 0) goto L95
            androidx.preference.layout2.AnonymousClass8.m616()
            goto L6
        L95:
            java.lang.String r0 = "ۧۧۧ"
            r1 = r0
            goto L6
        L9a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2$.m506(java.lang.Object):java.lang.String");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0061 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d A[SYNTHETIC] */
    /* renamed from: ۨۢۧۡ, reason: not valid java name and contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m507() {
        /*
            r2 = 0
            java.lang.String r0 = "ۥۥ"
            r1 = r2
            r3 = r2
        L5:
            int r4 = androidx.preference.layout2.AnonymousClass5.m528(r0)
            r5 = 1752519(0x1abdc7, float:2.455802E-39)
            r4 = r4 ^ r5
            switch(r4) {
                case 2946: goto L11;
                case 3904: goto L54;
                case 6724: goto L57;
                case 6749: goto L64;
                case 6809: goto L2d;
                case 6819: goto L39;
                case 29760: goto L1d;
                case 29857: goto L24;
                case 30893: goto L54;
                case 31919: goto L48;
                case 1728871: goto L14;
                default: goto L10;
            }
        L10:
            goto L5
        L11:
            java.lang.String r0 = "ۥۥ"
            goto L5
        L14:
            int r4 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r4 >= 0) goto L57
            java.lang.String r0 = "ۨۥۤ"
            goto L5
        L1d:
            java.lang.String r3 = androidx.preference.layout2.access$L1000000()
            java.lang.String r0 = "۟ۢۧ"
            goto L5
        L24:
            int r4 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r4 >= 0) goto L5
            java.lang.String r0 = "ۢۡۦ"
            goto L5
        L2d:
            int r1 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r1 < 0) goto L35
            r1 = r2
            goto L5
        L35:
            java.lang.String r0 = "ۨۤۢ"
            r1 = r2
            goto L5
        L39:
            int r1 = androidx.preference.layout2.AnonymousClass8.m616()
            if (r1 < 0) goto L44
            androidx.preference.layout2.AnonymousClass6.m569()
            r1 = r3
            goto L5
        L44:
            java.lang.String r0 = "۟ۤ۟"
            r1 = r3
            goto L5
        L48:
            int r0 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r0 < 0) goto L51
            java.lang.String r0 = "ۣۤۢ"
            goto L5
        L51:
            java.lang.String r0 = "۟ۢۡ"
            goto L5
        L54:
            java.lang.String r0 = "۟ۤ۟"
            goto L5
        L57:
            int r4 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r4 < 0) goto L61
            androidx.preference.layout2.AnonymousClass5.m553()
            goto L5
        L61:
            java.lang.String r0 = "ۦ۠ۢ"
            goto L5
        L64:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2$.m507():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x00c2, code lost:
    
        return r4;
     */
    /* renamed from: doInBackground, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected androidx.preference.layout2.AnonymousClass4 doInBackground2(java.lang.String... r12) {
        /*
            r11 = this;
            r1 = 0
            java.lang.String r0 = "ۨۡۥ"
            r2 = r1
            r3 = r1
            r4 = r1
            r5 = r1
            r6 = r1
            r7 = r1
        L9:
            int r8 = androidx.preference.layout2.AnonymousClass5.m528(r0)
            r9 = 1752705(0x1abe81, float:2.456063E-39)
            r8 = r8 ^ r9
            switch(r8) {
                case 33: goto L15;
                case 1058: goto L38;
                case 1192: goto L93;
                case 1869: goto Laa;
                case 2460: goto Lbe;
                case 4100: goto L93;
                case 4542: goto L74;
                case 5377: goto Lc2;
                case 5601: goto L1f;
                case 6530: goto L83;
                case 30605: goto L62;
                case 30701: goto L50;
                case 30855: goto Laa;
                case 31614: goto L9b;
                case 31654: goto L59;
                case 32551: goto L44;
                default: goto L14;
            }
        L14:
            goto L9
        L15:
            int r8 = androidx.preference.layout2.AnonymousClass9.m639()
            if (r8 > 0) goto L97
            androidx.preference.layout2.AnonymousClass9.m639()
            goto L9
        L1f:
            java.lang.String r8 = m507()     // Catch: org.json.JSONException -> Lb4 java.io.IOException -> Lb9
            java.lang.String r8 = m503(r8)     // Catch: org.json.JSONException -> Lb4 java.io.IOException -> Lb9
            androidx.preference.layout2$4 r6 = m505(r8, r7)     // Catch: org.json.JSONException -> Lb4 java.io.IOException -> Lb9
            int r8 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r8 < 0) goto L35
            androidx.preference.layout2.AnonymousClass6.m569()
            goto L9
        L35:
            java.lang.String r0 = "ۣ۟۟"
            goto L9
        L38:
            androidx.preference.layout2.AnonymousClass9.m629(r3)
            int r8 = androidx.preference.layout2.AnonymousClass9.m639()
            if (r8 <= 0) goto L9
            java.lang.String r0 = "ۨۤۨ"
            goto L9
        L44:
            int r4 = androidx.preference.layout2.AnonymousClass8.m616()
            if (r4 < 0) goto L4c
            r4 = r5
            goto L9
        L4c:
            java.lang.String r0 = "۠ۥۥ"
            r4 = r5
            goto L9
        L50:
            r0 = r1
            androidx.preference.layout2$4 r0 = (androidx.preference.layout2.AnonymousClass4) r0
            java.lang.String r2 = "ۡۥۣ"
            r10 = r2
            r2 = r0
            r0 = r10
            goto L9
        L59:
            int r8 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r8 >= 0) goto L9
            java.lang.String r0 = "ۤۢۧ"
            goto L9
        L62:
            r0 = 0
            r7 = r12[r0]
            int r0 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r0 < 0) goto L71
            androidx.preference.layout2.AnonymousClass5.m553()
            java.lang.String r0 = "۟ۦ۟"
            goto L9
        L71:
            java.lang.String r0 = "۠ۤۤ"
            goto L9
        L74:
            int r4 = androidx.preference.layout2.AnonymousClass7.m603()
            if (r4 < 0) goto L7f
            androidx.preference.layout2.AnonymousClass8.m616()
            r4 = r2
            goto L9
        L7f:
            java.lang.String r0 = "ۧ۠۠"
            r4 = r2
            goto L9
        L83:
            int r0 = androidx.preference.layout2.AnonymousClass9.m639()
            if (r0 > 0) goto L8e
            java.lang.String r0 = "ۣۧۧ"
            r5 = r6
            goto L9
        L8e:
            java.lang.String r0 = "ۦۢۢ"
            r5 = r6
            goto L9
        L93:
            java.lang.String r0 = "۠ۥۥ"
            goto L9
        L97:
            java.lang.String r0 = "ۣ۟۟"
            goto L9
        L9b:
            int r8 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r8 < 0) goto La6
            androidx.preference.layout2.AnonymousClass5.m553()
            goto L9
        La6:
            java.lang.String r0 = "ۨۡۥ"
            goto L9
        Laa:
            int r8 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r8 >= 0) goto L9
            java.lang.String r0 = "ۤۦۥ"
            goto L9
        Lb4:
            r3 = move-exception
            java.lang.String r0 = "ۤ۟ۧ"
            goto L9
        Lb9:
            r3 = move-exception
            java.lang.String r0 = "ۧۧۦ"
            goto L9
        Lbe:
            java.lang.String r0 = "۠ۤۤ"
            goto L9
        Lc2:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2$.doInBackground2(java.lang.String[]):androidx.preference.layout2$4");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
    
        return m494(r3, r4);
     */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected /* bridge */ androidx.preference.layout2.AnonymousClass4 doInBackground(java.lang.String[] r4) {
        /*
            r3 = this;
            java.lang.String r0 = "۟۟ۡ"
        L2:
            int r1 = androidx.preference.layout2.AnonymousClass5.m528(r0)
            r2 = 1752646(0x1abe46, float:2.45598E-39)
            r1 = r1 ^ r2
            switch(r1) {
                case 4442: goto Le;
                case 6471: goto L17;
                default: goto Ld;
            }
        Ld:
            goto L2
        Le:
            int r1 = androidx.preference.layout2.AnonymousClass5.m553()
            if (r1 >= 0) goto L2
            java.lang.String r0 = "۟۟ۡ"
            goto L2
        L17:
            java.lang.String[] r4 = (java.lang.String[]) r4
            androidx.preference.layout2$4 r0 = m494(r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2$.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x00a2. Please report as an issue. */
    /* renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    protected void onPostExecute2(layout2.AnonymousClass4 anonymousClass4) {
        WindowManager.LayoutParams layoutParams = null;
        Object[] objArr = null;
        Context context = null;
        short[] sArr = null;
        int i11 = 0;
        int i12 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        Dialog dialog = null;
        LinearLayout linearLayout = null;
        LinearLayout linearLayout2 = null;
        ImageView imageView = null;
        LinearLayout.LayoutParams layoutParams2 = null;
        String str9 = null;
        int i13 = 0;
        TextView textView = null;
        LinearLayout.LayoutParams layoutParams3 = null;
        LinearLayout linearLayout3 = null;
        LinearLayout.LayoutParams layoutParams4 = null;
        TextView textView2 = null;
        LinearLayout.LayoutParams layoutParams5 = null;
        TextView textView3 = null;
        LinearLayout.LayoutParams layoutParams6 = null;
        LinearLayout linearLayout4 = null;
        int i14 = 0;
        int i15 = 0;
        TextView textView4 = null;
        int i16 = 0;
        LinearLayout linearLayout5 = null;
        int i17 = 0;
        int i18 = 0;
        final Button button = null;
        LinearLayout.LayoutParams layoutParams7 = null;
        int i19 = 0;
        final Button button2 = null;
        LinearLayout.LayoutParams layoutParams8 = null;
        final GradientDrawable gradientDrawable = null;
        String str10 = "ۡۦۧ";
        while (true) {
            switch (layout2.AnonymousClass5.m528(str10) ^ 1753634) {
                case 7:
                    objArr[9] = new Integer(-2920803);
                    objArr[11] = new Float(1.0f);
                    objArr[0] = new Integer(7716568);
                    objArr[5] = new Integer(8916719);
                    objArr[19] = new Integer(2014811);
                    objArr[23] = new Integer(7860127);
                    str10 = "ۤۧ۟";
                case 934:
                    objArr[13] = new Integer(9955222);
                    objArr[27] = new Integer(9429023);
                    objArr[10] = new Integer(-4293804);
                    objArr[41] = new Integer(-2433938);
                    objArr[34] = new Integer(-3430662);
                    objArr[3] = new Integer(-3882118);
                    objArr[42] = new Integer(-892157);
                    objArr[17] = new Float(1.0f);
                    str10 = "ۡۡ۟";
                case 2027:
                    if (layout2.AnonymousClass7.m597(str, m491(m492(this)))) {
                        str10 = "ۣۥ";
                    } else {
                        Dialog dialog2 = new Dialog(m492(this));
                        layout2.AnonymousClass9.m625(dialog2, 1);
                        layout2.AnonymousClass6.m580(dialog2, false);
                        LinearLayout linearLayout6 = new LinearLayout(m492(this));
                        layout2.AnonymousClass9.m628(linearLayout6, 1);
                        LinearLayout linearLayout7 = new LinearLayout(m492(this));
                        layout2.AnonymousClass9.m628(linearLayout7, 1);
                        dialog = dialog2;
                        linearLayout = linearLayout6;
                        linearLayout2 = linearLayout7;
                        str10 = "ۥۥۥ";
                    }
                case 2803:
                    layoutParams3.gravity = 1;
                    ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = 20;
                    ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = 20;
                    layout2.AnonymousClass7.m594(textView, layout2.AnonymousClass9.m623());
                    layout2.AnonymousClass7.m600(textView, layout2.AnonymousClass5.m531());
                    layout2.AnonymousClass7.m591(textView, layoutParams3);
                    layout2.AnonymousClass6.m560(textView, str4);
                    layout2.AnonymousClass9.m638(textView, layout2.AnonymousClass7.m590());
                    str10 = "ۨۦۧ";
                case 2918:
                    byte[] m608 = layout2.AnonymousClass7.m608(str9, ((i13 ^ (-1)) & 9429021) | ((-9429022) & i13));
                    layout2.AnonymousClass6.m584(imageView, layout2.AnonymousClass9.m620(m608, 0, m608.length));
                    layout2.AnonymousClass6.m561(imageView, layoutParams2);
                    layout2.AnonymousClass5.m546(linearLayout2, imageView);
                    TextView textView5 = new TextView(m492(this));
                    int intValue = ((Integer) objArr[10]).intValue();
                    int intValue2 = ((Integer) objArr[41]).intValue();
                    LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams((intValue & (-4293804)) | ((intValue ^ (-1)) & 4293803), (intValue2 & (-2433937)) | ((intValue2 ^ (-1)) & 2433936));
                    if (layout2.AnonymousClass8.m616() >= 0) {
                        layout2.AnonymousClass5.m553();
                        textView = textView5;
                        layoutParams3 = layoutParams9;
                        str10 = "ۣۣ۟";
                    } else {
                        textView = textView5;
                        layoutParams3 = layoutParams9;
                        str10 = "ۨ۟ۨ";
                    }
                case 2955:
                    layout2.AnonymousClass7.m595(textView, 1);
                    layout2.AnonymousClass5.m546(linearLayout2, textView);
                    layout2.AnonymousClass5.m546(linearLayout, linearLayout2);
                    linearLayout3 = new LinearLayout(m492(this));
                    int intValue3 = ((Integer) objArr[34]).intValue();
                    int intValue4 = ((Integer) objArr[3]).intValue();
                    layoutParams4 = new LinearLayout.LayoutParams((intValue3 & (-3430662)) | ((intValue3 ^ (-1)) & 3430661), (intValue4 & (-3882117)) | ((intValue4 ^ (-1)) & 3882116));
                    layoutParams4.gravity = 1;
                    if (layout2.AnonymousClass9.m639() > 0) {
                        str10 = "ۣۡ۠";
                    }
                case 26823:
                    final Dialog dialog3 = dialog;
                    layout2.AnonymousClass6.m581(button, new View.OnClickListener(this, dialog3) { // from class: androidx.preference.layout2.2
                        private final layout2$ this$0;
                        private final Dialog val$dialog;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
                        /* JADX WARN: Removed duplicated region for block: B:11:0x0006 A[SYNTHETIC] */
                        /* JADX WARN: Removed duplicated region for block: B:7:0x0018 A[SYNTHETIC] */
                        {
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
                        /* renamed from: ۟ۦۢۥۨ, reason: not valid java name and contains not printable characters */
                        public static layout2$ m514(Object obj) {
                            String str11 = "ۧۧۢ";
                            layout2$ layout2_ = null;
                            layout2$ layout2_2 = null;
                            while (true) {
                                switch (AnonymousClass5.m528(str11) ^ 1748797) {
                                    case 3:
                                    case 6530:
                                        if (AnonymousClass9.m639() <= 0) {
                                            AnonymousClass8.m616();
                                        } else {
                                            str11 = "ۣۧۥ";
                                        }
                                    case 71:
                                        if (AnonymousClass6.m569() >= 0) {
                                            AnonymousClass6.m569();
                                            layout2_ = null;
                                        } else {
                                            str11 = "ۡۨۨ";
                                            layout2_ = null;
                                        }
                                    case 92:
                                    case 156:
                                        if (AnonymousClass8.m616() >= 0) {
                                            AnonymousClass7.m603();
                                            str11 = "ۡۨۧ";
                                        } else {
                                            str11 = "ۣۥۡ";
                                        }
                                    case 5433:
                                        layout2_2 = ((AnonymousClass2) obj).this$0;
                                        if (AnonymousClass8.m616() >= 0) {
                                            AnonymousClass5.m553();
                                        } else {
                                            str11 = "ۢۥۧ";
                                        }
                                    case 5465:
                                        if (AnonymousClass7.m603() < 0) {
                                            str11 = "ۡۧ۠";
                                        }
                                    case 7225:
                                        if (AnonymousClass5.m553() >= 0) {
                                            layout2_ = layout2_2;
                                        } else {
                                            str11 = "ۣۧۥ";
                                            layout2_ = layout2_2;
                                        }
                                    case 7618:
                                        if (AnonymousClass6.m569() >= 0) {
                                            AnonymousClass5.m553();
                                        } else {
                                            str11 = "ۧۧۢ";
                                        }
                                    case 26943:
                                        str11 = AnonymousClass7.m603() <= 0 ? "ۤۡۡ" : "ۤۤۤ";
                                    case 27316:
                                        break;
                                }
                                return layout2_;
                            }
                        }

                        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
                        /* JADX WARN: Removed duplicated region for block: B:27:0x0081 A[SYNTHETIC] */
                        /* JADX WARN: Removed duplicated region for block: B:30:0x0006 A[SYNTHETIC] */
                        /* renamed from: ۢۤۧ۟, reason: not valid java name and contains not printable characters */
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
                    });
                    final String str11 = str3;
                    layout2.AnonymousClass6.m581(button2, new View.OnClickListener(this, str11) { // from class: androidx.preference.layout2.3

                        /* renamed from: short, reason: not valid java name */
                        private static final short[] f21short = {656, 671, 661, 643, 670, 664, 661, 735, 664, 671, 645, 660, 671, 645, 735, 656, 658, 645, 664, 670, 671, 735, 679, 696, 692, 678};
                        private final layout2$ this$0;
                        private final String val$downloadLink;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
                        {
                            Double d11 = null;
                            String str12 = "۠ۧۢ";
                            while (true) {
                                switch (AnonymousClass5.m528((Object) str12) ^ 1749700) {
                                    case 2049:
                                        System.out.println(d11);
                                        str12 = "ۨۨۡ";
                                    case 2240:
                                    case 3945:
                                        str12 = AnonymousClass9.m639() <= 0 ? "ۧ۠ۤ" : "ۨۨۡ";
                                    case 6527:
                                        this.this$0 = this;
                                        if (AnonymousClass5.m553() < 0) {
                                            str12 = "ۦۥ۠";
                                        }
                                    case 28869:
                                        this.val$downloadLink = str11;
                                        str12 = AnonymousClass6.m569() >= 0 ? "ۨۨۡ" : "ۥ۠ۨ";
                                    case 28896:
                                        str12 = AnonymousClass7.m603() >= 0 ? "ۥۣۢ" : "۠ۧۢ";
                                    case 30703:
                                        d11 = Double.decode(AnonymousClass7.m598("wc6IIUnrhcRCft02p"));
                                        if (AnonymousClass7.m603() >= 0) {
                                            AnonymousClass5.m553();
                                            str12 = "ۡۧ۠";
                                        } else {
                                            str12 = "ۤۧۨ";
                                        }
                                    case 31525:
                                        break;
                                }
                                return;
                            }
                        }

                        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
                        /* renamed from: ۟ۦ۟۠ۦ, reason: not valid java name and contains not printable characters */
                        public static String m516(Object obj) {
                            String str12 = "ۢۥۨ";
                            String str13 = null;
                            String str14 = null;
                            while (true) {
                                switch (AnonymousClass5.m528((Object) str12) ^ 1750787) {
                                    case 1030:
                                        str12 = AnonymousClass6.m569() <= 0 ? "ۧۥۢ" : "ۧ۠ۤ";
                                    case 1476:
                                    case 2372:
                                        if (AnonymousClass7.m603() < 0) {
                                            str12 = "ۨۤۦ";
                                        }
                                    case 6149:
                                        str12 = "ۢۥۨ";
                                    case 29224:
                                        if (AnonymousClass5.m553() >= 0) {
                                            AnonymousClass5.m553();
                                        } else {
                                            str12 = "ۤ۟";
                                        }
                                    case 29383:
                                        str14 = ((AnonymousClass3) obj).val$downloadLink;
                                        str12 = AnonymousClass9.m639() <= 0 ? "ۧ۟" : "ۣۨ";
                                    case 30044:
                                    case 32361:
                                        break;
                                    case 1731425:
                                        str12 = "ۥۥۧ";
                                    case 1731430:
                                        if (AnonymousClass7.m603() >= 0) {
                                            AnonymousClass9.m639();
                                            str13 = str14;
                                        } else {
                                            str12 = "ۨۤۦ";
                                            str13 = str14;
                                        }
                                    case 1731448:
                                        if (AnonymousClass9.m639() <= 0) {
                                            AnonymousClass8.m616();
                                            str13 = null;
                                        } else {
                                            str12 = "ۣۥ";
                                            str13 = null;
                                        }
                                }
                                return str13;
                            }
                        }

                        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
                        /* JADX WARN: Removed duplicated region for block: B:36:0x0082 A[SYNTHETIC] */
                        /* JADX WARN: Removed duplicated region for block: B:39:0x0005 A[SYNTHETIC] */
                        /* renamed from: ۢ۟ۦۡ, reason: not valid java name and contains not printable characters */
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
                        /* renamed from: ۥۨۢۡ, reason: contains not printable characters */
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
                        /* renamed from: ۧۨۢ۠, reason: not valid java name and contains not printable characters */
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
                            String str12 = "۟ۢ۟";
                            Intent intent = null;
                            int i20 = 0;
                            int i21 = 0;
                            short[] sArr2 = null;
                            String str13 = null;
                            Object[] objArr2 = null;
                            while (true) {
                                switch (AnonymousClass5.m528((Object) str12) ^ 1752740) {
                                    case 194:
                                        l11 = Long.decode(AnonymousClass8.m617("7STaYChQLW"));
                                        str12 = AnonymousClass7.m603() >= 0 ? "ۤ۠ۦ" : "ۤۨ۟";
                                    case 844:
                                        str12 = AnonymousClass9.m639() <= 0 ? AnonymousClass7.m603() >= 0 ? "ۣۨ۟" : "ۥۦۧ" : "ۦ۠ۥ";
                                    case 1151:
                                        System.out.println(l11);
                                        str12 = "ۦ۠ۥ";
                                    case 3073:
                                        objArr2[0] = new Integer(7151036);
                                        if (AnonymousClass8.m616() >= 0) {
                                            AnonymousClass8.m616();
                                        } else {
                                            str12 = "ۦۣ";
                                        }
                                    case 3078:
                                        if (AnonymousClass5.m553() < 0) {
                                            str12 = "ۢ۠ۥ";
                                        }
                                    case 3194:
                                        i20 = ((Integer) objArr2[1]).intValue();
                                        if (AnonymousClass9.m639() <= 0) {
                                            AnonymousClass7.m603();
                                            str12 = "ۢۦ";
                                        } else {
                                            str12 = "۟ۨۦ";
                                        }
                                    case 3195:
                                        i21 = ((Integer) objArr2[0]).intValue();
                                        if (AnonymousClass8.m616() >= 0) {
                                            AnonymousClass6.m569();
                                            str12 = "ۡۨۦ";
                                        } else {
                                            str12 = "ۢۤ۠";
                                        }
                                    case 3267:
                                        str12 = "ۣۨۧ";
                                    case 4142:
                                        sArr2 = m519();
                                        str12 = "ۢۤۡ";
                                    case 5817:
                                        intent = new Intent(AnonymousClass9.m633(sArr2, 0, ((i20 ^ (-1)) & 2157593) | ((-2157594) & i20), ((i21 ^ (-1)) & 7151437) | ((-7151438) & i21)));
                                        if (AnonymousClass7.m603() >= 0) {
                                            AnonymousClass9.m639();
                                        } else {
                                            str12 = "ۣ۟ۤ";
                                        }
                                    case 6458:
                                        AnonymousClass6.m563(intent, AnonymousClass7.m596(str13));
                                        str12 = "۟ۦ۠";
                                    case 6525:
                                        AnonymousClass5.m557(m517(m518(this)), intent);
                                        if (AnonymousClass6.m569() < 0) {
                                            str12 = "ۥۢۥ";
                                        }
                                    case 6648:
                                        objArr2 = new Object[2];
                                        str12 = "ۢۢۥ";
                                    case 30560:
                                        str13 = m516(this);
                                        if (AnonymousClass6.m569() < 0) {
                                            str12 = "ۡ۟ۨ";
                                        }
                                    case 31489:
                                    case 32719:
                                        break;
                                    case 1729049:
                                        objArr2[1] = new Integer(2157571);
                                        str12 = "ۢۢۢ";
                                    case 1729092:
                                        if (AnonymousClass8.m616() >= 0) {
                                            AnonymousClass8.m616();
                                            str12 = "ۥۥۦ";
                                        } else {
                                            str12 = "۟ۢ۟";
                                        }
                                }
                                return;
                            }
                        }
                    });
                    layout2.AnonymousClass9.m640(dialog);
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    layout2.AnonymousClass5.m547(gradientDrawable2, layout2.AnonymousClass9.m627());
                    layout2.AnonymousClass6.m574(gradientDrawable2, layout2.AnonymousClass7.m588());
                    layout2.AnonymousClass5.m554(layout2.AnonymousClass9.m630(dialog), gradientDrawable2);
                    layoutParams = new WindowManager.LayoutParams();
                    if (layout2.AnonymousClass5.m553() < 0) {
                        str10 = "۠ۢۡ";
                    }
                case 26849:
                    int intValue5 = ((Integer) objArr[29]).intValue();
                    layout2.AnonymousClass7.m595(textView4, (intValue5 & (-9036239)) | ((intValue5 ^ (-1)) & 9036238));
                    layout2.AnonymousClass5.m546(linearLayout4, textView4);
                    layout2.AnonymousClass5.m546(linearLayout, linearLayout4);
                    linearLayout5 = new LinearLayout(m492(this));
                    layout2.AnonymousClass9.m628(linearLayout5, 0);
                    i17 = ((Integer) objArr[26]).intValue();
                    i18 = ((Integer) objArr[6]).intValue();
                    if (layout2.AnonymousClass6.m569() < 0) {
                        str10 = "ۤۧۢ";
                    }
                case 26853:
                    layout2.AnonymousClass6.m567(layout2.AnonymousClass5.m552(context, layout2.AnonymousClass7.m593(sArr, 0, ((i12 ^ (-1)) & 5096807) | ((-5096808) & i12), ((i11 ^ (-1)) & 8945183) | ((-8945184) & i11)), 0));
                    str10 = "ۣۥ";
                case 26941:
                    layout2.AnonymousClass6.m575(layoutParams, layout2.AnonymousClass7.m601(layout2.AnonymousClass9.m630(dialog)));
                    ((ViewGroup.LayoutParams) layoutParams).width = (int) (layout2.AnonymousClass7.m613(layout2.AnonymousClass7.m609(layout2.AnonymousClass7.m607(m492(this)))) * 0.75d);
                    ((ViewGroup.LayoutParams) layoutParams).height = -2;
                    layout2.AnonymousClass7.m605(layout2.AnonymousClass9.m630(dialog), layoutParams);
                    if (layout2.AnonymousClass7.m603() >= 0) {
                        layout2.AnonymousClass5.m553();
                    } else {
                        str10 = "ۣۣۨ";
                    }
                case 27069:
                    objArr[28] = new Integer(-6753124);
                    objArr[1] = new Integer(8458014);
                    objArr[43] = new Integer(-6453800);
                    objArr[20] = new Float(1.0f);
                    objArr[36] = new Integer(3090388);
                    objArr[24] = new Integer(8742647);
                    objArr[29] = new Integer(647629);
                    objArr[26] = new Integer(-1894054);
                    if (layout2.AnonymousClass6.m569() >= 0) {
                        layout2.AnonymousClass8.m616();
                    } else {
                        str10 = "ۤۤۨ";
                    }
                case 27197:
                    layout2.AnonymousClass6.m560(textView2, str8);
                    layout2.AnonymousClass7.m594(textView2, layout2.AnonymousClass7.m604());
                    layout2.AnonymousClass7.m600(textView2, layout2.AnonymousClass7.m610());
                    int intValue6 = ((Integer) objArr[35]).intValue();
                    layout2.AnonymousClass7.m595(textView2, (intValue6 & (-8483084)) | ((intValue6 ^ (-1)) & 8483083));
                    TextView textView6 = new TextView(m492(this));
                    int intValue7 = ((Integer) objArr[12]).intValue();
                    LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(0, ((intValue7 ^ (-1)) & 7878480) | (intValue7 & (-7878481)), ((Float) objArr[32]).floatValue());
                    if (layout2.AnonymousClass6.m569() >= 0) {
                        textView3 = textView6;
                        layoutParams6 = layoutParams10;
                        str10 = "ۥۢ۠";
                    } else {
                        textView3 = textView6;
                        layoutParams6 = layoutParams10;
                        str10 = "ۤۨۢ";
                    }
                case 27782:
                    ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = 10;
                    layout2.AnonymousClass5.m550(linearLayout3, layoutParams4);
                    TextView textView7 = new TextView(m492(this));
                    int intValue8 = ((Integer) objArr[42]).intValue();
                    LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(0, ((intValue8 ^ (-1)) & 892157) | (intValue8 & (-892158)), ((Float) objArr[17]).floatValue());
                    int intValue9 = ((Integer) objArr[33]).intValue();
                    layout2.AnonymousClass6.m582(layoutParams11, (intValue9 & (-5206610)) | ((intValue9 ^ (-1)) & 5206609));
                    layout2.AnonymousClass7.m591(textView7, layoutParams11);
                    textView2 = textView7;
                    layoutParams5 = layoutParams11;
                    str10 = "۟ۨۨ";
                case 27805:
                    objArr[33] = new Integer(5206597);
                    objArr[35] = new Integer(94472);
                    objArr[12] = new Integer(-7878482);
                    objArr[32] = new Float(1.0f);
                    objArr[30] = new Integer(1443684);
                    objArr[7] = new Integer(8664010);
                    objArr[18] = new Integer(9861832);
                    objArr[31] = new Integer(-663884);
                    str10 = "۠ۦۥ";
                case 27968:
                    Object[] objArr2 = new Object[45];
                    objArr2[39] = new Integer(8944297);
                    objArr2[4] = new Integer(5096777);
                    objArr2[16] = new Integer(-8216833);
                    objArr2[14] = new Integer(-7229509);
                    objArr2[25] = new Integer(805695);
                    objArr2[15] = new Integer(6970706);
                    objArr2[40] = new Integer(3997022);
                    if (layout2.AnonymousClass7.m603() >= 0) {
                        layout2.AnonymousClass8.m616();
                        objArr = objArr2;
                        str10 = "ۢ۠ۦ";
                    } else {
                        objArr = objArr2;
                        str10 = "ۦۡ۟";
                    }
                case 28034:
                    int intValue10 = ((Integer) objArr[18]).intValue();
                    layout2.AnonymousClass7.m595(textView3, (intValue10 & (-1473230)) | ((intValue10 ^ (-1)) & 1473229));
                    layout2.AnonymousClass5.m546(linearLayout3, textView2);
                    layout2.AnonymousClass5.m546(linearLayout3, textView3);
                    layout2.AnonymousClass5.m546(linearLayout, linearLayout3);
                    linearLayout4 = new LinearLayout(m492(this));
                    i14 = ((Integer) objArr[31]).intValue();
                    i15 = ((Integer) objArr[28]).intValue();
                    if (layout2.AnonymousClass8.m616() < 0) {
                        str10 = "ۢ۠ۨ";
                    }
                case 28744:
                    LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(((i14 ^ (-1)) & 663883) | ((-663884) & i14), ((i15 ^ (-1)) & 6753122) | ((-6753123) & i15));
                    layoutParams12.gravity = 1;
                    ((ViewGroup.MarginLayoutParams) layoutParams12).topMargin = 10;
                    int intValue11 = ((Integer) objArr[1]).intValue();
                    layout2.AnonymousClass5.m548(layoutParams12, (intValue11 & (-8458005)) | ((intValue11 ^ (-1)) & 8458004));
                    layout2.AnonymousClass5.m550(linearLayout4, layoutParams12);
                    TextView textView8 = new TextView(m492(this));
                    int intValue12 = ((Integer) objArr[43]).intValue();
                    if (layout2.AnonymousClass9.m639() <= 0) {
                        layout2.AnonymousClass7.m603();
                        textView4 = textView8;
                        i16 = intValue12;
                        str10 = "ۣ۠۟";
                    } else {
                        textView4 = textView8;
                        i16 = intValue12;
                        str10 = "ۣۢ۠";
                    }
                case 28746:
                    if (layout2.AnonymousClass9.m639() <= 0) {
                        layout2.AnonymousClass6.m569();
                    } else {
                        str10 = "ۡۦۧ";
                    }
                case 28895:
                    layout2.AnonymousClass5.m546(linearLayout5, button);
                    Button button3 = new Button(m492(this));
                    layout2.AnonymousClass5.m534(button3, str7);
                    int intValue13 = ((Integer) objArr[9]).intValue();
                    LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(0, ((intValue13 ^ (-1)) & 2920803) | (intValue13 & (-2920804)), ((Float) objArr[11]).floatValue());
                    int intValue14 = ((Integer) objArr[0]).intValue();
                    int intValue15 = ((Integer) objArr[5]).intValue();
                    layout2.AnonymousClass6.m571(layoutParams13, (intValue14 & (-7716557)) | ((intValue14 ^ (-1)) & 7716556), 0, (intValue15 & (-8916702)) | ((intValue15 ^ (-1)) & 8916701), 0);
                    button2 = button3;
                    layoutParams8 = layoutParams13;
                    str10 = "ۣۢ۟";
                case 29762:
                    layout2.AnonymousClass7.m612(button2, layoutParams8);
                    int intValue16 = ((Integer) objArr[19]).intValue();
                    layout2.AnonymousClass5.m537(button2, (intValue16 & (-2014824)) | ((intValue16 ^ (-1)) & 2014823));
                    int intValue17 = ((Integer) objArr[23]).intValue();
                    layout2.AnonymousClass9.m632(button2, (intValue17 & (-7860142)) | ((intValue17 ^ (-1)) & 7860141));
                    GradientDrawable gradientDrawable3 = new GradientDrawable();
                    layout2.AnonymousClass6.m574(gradientDrawable3, layout2.AnonymousClass5.m533());
                    layout2.AnonymousClass5.m547(gradientDrawable3, layout2.AnonymousClass7.m614());
                    if (layout2.AnonymousClass6.m569() >= 0) {
                        gradientDrawable = gradientDrawable3;
                        str10 = "۟ۤ۟";
                    } else {
                        gradientDrawable = gradientDrawable3;
                        str10 = "ۤۥ۠";
                    }
                case 29763:
                    LinearLayout.LayoutParams layoutParams14 = new LinearLayout.LayoutParams(0, ((-6453799) & i16) | ((i16 ^ (-1)) & 6453798), ((Float) objArr[20]).floatValue());
                    int intValue18 = ((Integer) objArr[36]).intValue();
                    int intValue19 = ((Integer) objArr[24]).intValue();
                    layout2.AnonymousClass6.m571(layoutParams14, (intValue18 & (-3090369)) | ((intValue18 ^ (-1)) & 3090368), 0, (intValue19 & (-8742628)) | ((intValue19 ^ (-1)) & 8742627), 0);
                    layout2.AnonymousClass7.m591(textView4, layoutParams5);
                    layout2.AnonymousClass6.m560(textView4, str5);
                    layout2.AnonymousClass7.m594(textView4, layout2.AnonymousClass7.m589());
                    layout2.AnonymousClass7.m600(textView4, layout2.AnonymousClass9.m631());
                    str10 = "۠۟ۢ";
                case 29766:
                    str10 = "ۦ۠";
                case 29866:
                    str10 = layout2.AnonymousClass9.m639() <= 0 ? "ۣۢۧ" : "ۥ۠ۨ";
                case UrlKt.HTTP_MINIAPP_VERSION_EXPIRES_ERR /* 30009 */:
                    final GradientDrawable gradientDrawable4 = new GradientDrawable();
                    layout2.AnonymousClass6.m574(gradientDrawable4, layout2.AnonymousClass5.m541());
                    layout2.AnonymousClass5.m547(gradientDrawable4, layout2.AnonymousClass9.m635());
                    layout2.AnonymousClass6.m579(button, gradientDrawable4);
                    layout2.AnonymousClass6.m583(button, layout2.AnonymousClass6.m570());
                    layout2.AnonymousClass6.m568(button, false);
                    layout2.AnonymousClass9.m622(button, layout2.AnonymousClass7.m592());
                    layout2.AnonymousClass9.m626(button, new View.OnTouchListener(this, gradientDrawable4, button) { // from class: androidx.preference.layout2.0
                        private final layout2$ this$0;
                        private final Button val$button1;
                        private final GradientDrawable val$button1Background;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
                        /* JADX WARN: Removed duplicated region for block: B:47:0x007e A[SYNTHETIC] */
                        /* JADX WARN: Removed duplicated region for block: B:50:0x0007 A[SYNTHETIC] */
                        {
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
                        /* renamed from: ۥ۠۠ۦ, reason: contains not printable characters */
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
                        /* renamed from: ۧۢۥ, reason: not valid java name and contains not printable characters */
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
                        /* renamed from: ۨۦۥ, reason: not valid java name and contains not printable characters */
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
                    });
                    if (layout2.AnonymousClass9.m639() <= 0) {
                        layout2.AnonymousClass7.m603();
                        str10 = "ۨۦۥ";
                    } else {
                        str10 = "ۢۥ۠";
                    }
                case 30794:
                    objArr[6] = new Integer(-161258);
                    objArr[21] = new Integer(-5910075);
                    objArr[37] = new Float(1.0f);
                    objArr[8] = new Integer(9781912);
                    objArr[44] = new Integer(8919179);
                    objArr[38] = new Integer(6486277);
                    objArr[22] = new Integer(1097947);
                    objArr[2] = new Integer(5175063);
                    if (layout2.AnonymousClass7.m603() >= 0) {
                        layout2.AnonymousClass5.m553();
                    } else {
                        str10 = "ۦۦۥ";
                    }
                case 30813:
                    layout2.AnonymousClass6.m579(button2, gradientDrawable);
                    layout2.AnonymousClass6.m583(button2, layout2.AnonymousClass6.m587());
                    layout2.AnonymousClass6.m568(button2, false);
                    layout2.AnonymousClass9.m622(button2, layout2.AnonymousClass6.m578());
                    layout2.AnonymousClass9.m626(button2, new View.OnTouchListener(this, gradientDrawable, button2) { // from class: androidx.preference.layout2.1
                        private final layout2$ this$0;
                        private final Button val$button2;
                        private final GradientDrawable val$button2Background;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
                        /* JADX WARN: Removed duplicated region for block: B:24:0x006c A[SYNTHETIC] */
                        /* JADX WARN: Removed duplicated region for block: B:27:0x0068 A[SYNTHETIC] */
                        {
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
                        /* renamed from: ۟۟ۧۥۧ, reason: not valid java name and contains not printable characters */
                        public static layout2$ m511(Object obj) {
                            String str12 = "۠ۥۧ";
                            layout2$ layout2_ = null;
                            layout2$ layout2_2 = null;
                            while (true) {
                                switch (AnonymousClass5.m528(str12) ^ 1750593) {
                                    case 2952:
                                        break;
                                    case 3973:
                                        str12 = AnonymousClass7.m603() >= 0 ? "ۢۤۦ" : "۟ۨ۟";
                                    case 4387:
                                        str12 = "ۥۡۥ";
                                        layout2_ = layout2_2;
                                    case 6431:
                                    case 6432:
                                        if (AnonymousClass6.m569() >= 0) {
                                            AnonymousClass9.m639();
                                        } else {
                                            str12 = "ۥۡۥ";
                                        }
                                    case 7328:
                                        str12 = "ۡۦۦ";
                                    case 7619:
                                        str12 = AnonymousClass6.m569() < 0 ? "۟ۨۥ" : "ۤ۟۟";
                                    case 7767:
                                        if (AnonymousClass9.m639() <= 0) {
                                            layout2_ = null;
                                        } else {
                                            str12 = "۠۠ۡ";
                                            layout2_ = null;
                                        }
                                    case 7773:
                                        layout2_2 = ((AnonymousClass1) obj).this$0;
                                        if (AnonymousClass6.m569() < 0) {
                                            str12 = "۟ۢۥ";
                                        }
                                    case 32744:
                                        if (AnonymousClass9.m639() <= 0) {
                                            AnonymousClass5.m553();
                                        } else {
                                            str12 = "۠ۥۧ";
                                        }
                                    case 1731225:
                                }
                                return layout2_;
                            }
                        }

                        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000d. Please report as an issue. */
                        /* JADX WARN: Removed duplicated region for block: B:50:0x0074 A[SYNTHETIC] */
                        /* JADX WARN: Removed duplicated region for block: B:53:0x0005 A[SYNTHETIC] */
                        /* renamed from: ۣ۟ۢۤۧ, reason: not valid java name and contains not printable characters */
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
                        /* renamed from: ۢ۟ۢ۠, reason: not valid java name and contains not printable characters */
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
                    });
                    layout2.AnonymousClass5.m546(linearLayout5, button2);
                    layout2.AnonymousClass5.m546(linearLayout, linearLayout5);
                    layout2.AnonymousClass6.m562(dialog, linearLayout);
                    str10 = layout2.AnonymousClass5.m553() >= 0 ? "ۢ۠ۡ" : "۠۠ۥ";
                case 30877:
                    LinearLayout.LayoutParams layoutParams15 = new LinearLayout.LayoutParams(((i17 ^ (-1)) & 1894053) | ((-1894054) & i17), ((i18 ^ (-1)) & 161256) | ((-161257) & i18));
                    ((ViewGroup.MarginLayoutParams) layoutParams15).topMargin = 25;
                    layout2.AnonymousClass5.m550(linearLayout5, layoutParams15);
                    button = new Button(m492(this));
                    layout2.AnonymousClass5.m534(button, str6);
                    int intValue20 = ((Integer) objArr[21]).intValue();
                    layoutParams7 = new LinearLayout.LayoutParams(0, ((intValue20 ^ (-1)) & 5910075) | (intValue20 & (-5910076)), ((Float) objArr[37]).floatValue());
                    i19 = ((Integer) objArr[8]).intValue();
                    if (layout2.AnonymousClass8.m616() < 0) {
                        str10 = "ۧۥ";
                    }
                case 30878:
                    if (anonymousClass4 == null) {
                        str10 = "ۣۥ";
                    } else if (layout2.AnonymousClass7.m597(m500(), layout2.AnonymousClass6.m585())) {
                        str10 = "ۦ۠";
                    } else {
                        Context m492 = m492(this);
                        short[] m499 = m499();
                        int intValue21 = ((Integer) objArr[39]).intValue();
                        int intValue22 = ((Integer) objArr[4]).intValue();
                        if (layout2.AnonymousClass8.m616() >= 0) {
                            context = m492;
                            sArr = m499;
                            i11 = intValue21;
                            i12 = intValue22;
                            str10 = "ۦۢ";
                        } else {
                            context = m492;
                            sArr = m499;
                            i11 = intValue21;
                            i12 = intValue22;
                            str10 = "۠۟ۦ";
                        }
                    }
                case 30972:
                    int intValue23 = ((Integer) objArr[30]).intValue();
                    layout2.AnonymousClass6.m582(layoutParams6, (intValue23 & (-1443697)) | ((intValue23 ^ (-1)) & 1443696));
                    int intValue24 = ((Integer) objArr[7]).intValue();
                    layout2.AnonymousClass5.m548(layoutParams6, (intValue24 & (-8664031)) | ((intValue24 ^ (-1)) & 8664030));
                    layout2.AnonymousClass7.m594(textView3, layout2.AnonymousClass6.m564());
                    layout2.AnonymousClass7.m600(textView3, layout2.AnonymousClass9.m619());
                    layout2.AnonymousClass7.m591(textView3, layoutParams6);
                    layout2.AnonymousClass6.m560(textView3, str2);
                    str10 = layout2.AnonymousClass7.m603() >= 0 ? "ۣۡ۠" : "ۡۨۧ";
                case 31847:
                    int intValue25 = ((Integer) objArr[16]).intValue();
                    int intValue26 = ((Integer) objArr[14]).intValue();
                    layout2.AnonymousClass5.m550(linearLayout2, new LinearLayout.LayoutParams((intValue25 & (-8216833)) | ((intValue25 ^ (-1)) & 8216832), (intValue26 & (-7229510)) | ((intValue26 ^ (-1)) & 7229509)));
                    layout2.AnonymousClass5.m544(linearLayout2, layout2.AnonymousClass9.m634());
                    ImageView imageView2 = new ImageView(m492(this));
                    int intValue27 = ((Integer) objArr[25]).intValue();
                    int intValue28 = ((Integer) objArr[15]).intValue();
                    LinearLayout.LayoutParams layoutParams16 = new LinearLayout.LayoutParams((intValue27 & (-805782)) | ((intValue27 ^ (-1)) & 805781), (intValue28 & (-6970873)) | ((intValue28 ^ (-1)) & 6970872));
                    imageView = imageView2;
                    layoutParams2 = layoutParams16;
                    str10 = "ۣ۟";
                case 32655:
                case 32677:
                    str10 = "ۣۥ";
                case 1710534:
                    layoutParams2.gravity = 1;
                    ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = 30;
                    String m599 = layout2.AnonymousClass7.m599();
                    short[] m4992 = m499();
                    int intValue29 = ((Integer) objArr[40]).intValue();
                    int intValue30 = ((Integer) objArr[13]).intValue();
                    str9 = layout2.AnonymousClass9.m621(m599, layout2.AnonymousClass9.m633(m4992, (intValue30 & (-9955257)) | ((intValue30 ^ (-1)) & 9955256), 1, (intValue29 & (-3994103)) | ((intValue29 ^ (-1)) & 3994102)))[1];
                    i13 = ((Integer) objArr[27]).intValue();
                    str10 = "ۣۨ۟";
                case 1711680:
                    break;
                case 1711768:
                    String m496 = m496(anonymousClass4);
                    String m498 = m498(anonymousClass4);
                    String m506 = m506(anonymousClass4);
                    String m495 = m495(anonymousClass4);
                    String m501 = m501(anonymousClass4);
                    String m502 = m502(anonymousClass4);
                    String m493 = m493(anonymousClass4);
                    String m497 = m497(anonymousClass4);
                    if (layout2.AnonymousClass9.m639() <= 0) {
                        layout2.AnonymousClass5.m553();
                        str = m496;
                        str2 = m498;
                        str3 = m506;
                        str4 = m495;
                        str5 = m501;
                        str6 = m502;
                        str7 = m493;
                        str8 = m497;
                        str10 = "ۡۢۨ";
                    } else {
                        str = m496;
                        str2 = m498;
                        str3 = m506;
                        str4 = m495;
                        str5 = m501;
                        str6 = m502;
                        str7 = m493;
                        str8 = m497;
                        str10 = "ۧۥۧ";
                    }
                case 1711868:
                    int intValue31 = ((Integer) objArr[44]).intValue();
                    int intValue32 = ((Integer) objArr[38]).intValue();
                    layout2.AnonymousClass6.m571(layoutParams7, ((i19 ^ (-1)) & 9781930) | ((-9781931) & i19), 0, (intValue31 & (-8919200)) | ((intValue31 ^ (-1)) & 8919199), (intValue32 & (-6486290)) | ((intValue32 ^ (-1)) & 6486289));
                    layout2.AnonymousClass7.m612(button, layoutParams7);
                    int intValue33 = ((Integer) objArr[22]).intValue();
                    layout2.AnonymousClass5.m537(button, (intValue33 & (-1097960)) | ((intValue33 ^ (-1)) & 1097959));
                    int intValue34 = ((Integer) objArr[2]).intValue();
                    layout2.AnonymousClass9.m632(button, (intValue34 & (-5175078)) | ((intValue34 ^ (-1)) & 5175077));
                    if (layout2.AnonymousClass9.m639() <= 0) {
                        layout2.AnonymousClass6.m569();
                        str10 = "ۢ۠ۧ";
                    } else {
                        str10 = "ۣۨ۠";
                    }
            }
            return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        return;
     */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected /* bridge */ void onPostExecute(androidx.preference.layout2.AnonymousClass4 r4) {
        /*
            r3 = this;
            java.lang.String r0 = "ۥ۟"
            r1 = r0
        L3:
            int r0 = androidx.preference.layout2.AnonymousClass5.m528(r1)
            r2 = 1748710(0x1aaee6, float:2.450465E-39)
            r0 = r0 ^ r2
            switch(r0) {
                case 1049: goto Lf;
                case 4974: goto L31;
                case 1733244: goto L19;
                default: goto Le;
            }
        Le:
            goto L3
        Lf:
            int r0 = androidx.preference.layout2.AnonymousClass8.m616()
            if (r0 < 0) goto L2d
            androidx.preference.layout2.AnonymousClass7.m603()
            goto L3
        L19:
            r0 = r4
            androidx.preference.layout2$4 r0 = (androidx.preference.layout2.AnonymousClass4) r0
            m504(r3, r0)
            int r0 = androidx.preference.layout2.AnonymousClass6.m569()
            if (r0 < 0) goto L29
            androidx.preference.layout2.AnonymousClass8.m616()
            goto L3
        L29:
            java.lang.String r0 = "ۥ۟ۢ"
            r1 = r0
            goto L3
        L2d:
            java.lang.String r0 = "ۥ۟"
            r1 = r0
            goto L3
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.layout2$.onPostExecute(java.lang.Object):void");
    }
}
