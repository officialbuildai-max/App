package com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.HiB;
import com.bytedance.sdk.openadsdk.core.Ym.TKC.Sj;
import java.io.IOException;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class Sj {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:66:0x013a. Please report as an issue. */
    public static com.bytedance.sdk.openadsdk.core.Ym.TKC Sj(Context context, XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String str;
        int i11;
        int i12;
        int i13;
        XmlPullParser xmlPullParser2;
        Context context2;
        int i14;
        String str2;
        Context context3;
        String str3;
        HiB.Sj sj2;
        String str4;
        String str5;
        char c11;
        int i15;
        int i16;
        Context context4 = context;
        XmlPullParser xmlPullParser3 = xmlPullParser;
        String str6 = "HTMLResource";
        String str7 = "IFrameResource";
        int i17 = 2;
        int i18 = 3;
        if (context4 == null) {
            HiB.Sj(xmlPullParser);
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i19 = displayMetrics.widthPixels;
        int i20 = displayMetrics.heightPixels;
        float f11 = displayMetrics.density;
        int i21 = (int) (i19 / f11);
        int i22 = (int) (i20 / f11);
        float f12 = Float.MIN_VALUE;
        com.bytedance.sdk.openadsdk.core.Ym.TKC tkc = null;
        while (true) {
            if (xmlPullParser.getEventType() == i18 && xmlPullParser.getName().equals("CompanionAds")) {
                return tkc;
            }
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == i17) {
                String str8 = "Companion";
                if (xmlPullParser.getName().equals("Companion")) {
                    String str9 = HiB.Jcg;
                    int sP = HiB.sP(xmlPullParser3.getAttributeValue(str9, "width"));
                    int sP2 = HiB.sP(xmlPullParser3.getAttributeValue(str9, "height"));
                    if (sP < 300 || sP2 < 250) {
                        str = str6;
                        i12 = i22;
                        i13 = i21;
                        i11 = 2;
                        xmlPullParser2 = xmlPullParser3;
                        context2 = context4;
                        i14 = i18;
                        str2 = str7;
                        HiB.Sj(xmlPullParser);
                        i17 = i11;
                        str7 = str2;
                        str6 = str;
                        i21 = i13;
                        i18 = i14;
                        context4 = context2;
                        xmlPullParser3 = xmlPullParser2;
                        i22 = i12;
                    } else {
                        HiB.Sj sj3 = new HiB.Sj();
                        while (true) {
                            if (xmlPullParser.getEventType() == i18 && xmlPullParser.getName().equals(str8)) {
                                if (TextUtils.isEmpty(sj3.Sj) || sj3.Jcg < f12) {
                                    i15 = i22;
                                    i16 = i21;
                                } else {
                                    i15 = i22;
                                    i16 = i21;
                                    com.bytedance.sdk.openadsdk.core.Ym.TKC tkc2 = new com.bytedance.sdk.openadsdk.core.Ym.TKC(sP, sP2, sj3.sP, sj3.TKC, sj3.Sj, sj3.HiB, sj3.vS, sj3.EjP);
                                    f12 = sj3.Jcg;
                                    tkc = tkc2;
                                }
                                context4 = context;
                                xmlPullParser3 = xmlPullParser;
                                i22 = i15;
                                i21 = i16;
                                i17 = 2;
                                i18 = 3;
                            } else {
                                int i23 = i22;
                                int i24 = i21;
                                xmlPullParser.next();
                                if (xmlPullParser.getEventType() == 2) {
                                    String name = xmlPullParser.getName();
                                    name.hashCode();
                                    char c12 = 65535;
                                    switch (name.hashCode()) {
                                        case -375340334:
                                            if (name.equals(str7)) {
                                                c11 = 0;
                                                break;
                                            }
                                            break;
                                        case -348198615:
                                            if (name.equals("CompanionClickThrough")) {
                                                c11 = 1;
                                                break;
                                            }
                                            break;
                                        case 611554000:
                                            if (name.equals("TrackingEvents")) {
                                                c12 = 2;
                                                break;
                                            }
                                            break;
                                        case 676623548:
                                            if (name.equals("StaticResource")) {
                                                c12 = 3;
                                                break;
                                            }
                                            break;
                                        case 1877773523:
                                            if (name.equals("CompanionClickTracking")) {
                                                c11 = 4;
                                                break;
                                            }
                                            break;
                                        case 1928285401:
                                            if (name.equals(str6)) {
                                                c11 = 5;
                                                break;
                                            }
                                            break;
                                    }
                                    c12 = c11;
                                    switch (c12) {
                                        case 0:
                                            str5 = str6;
                                            String str10 = str7;
                                            HiB.Sj sj4 = sj3;
                                            str4 = str8;
                                            Point Sj = com.bytedance.sdk.openadsdk.core.Ym.TKC.Sj.Sj(context, sP, sP2, Sj.sP.HTML_RESOURCE);
                                            int i25 = Sj.x;
                                            int i26 = Sj.y;
                                            Sj.sP sPVar = Sj.sP.IFRAME_RESOURCE;
                                            Sj.EnumC0275Sj enumC0275Sj = Sj.EnumC0275Sj.NONE;
                                            float Sj2 = com.bytedance.sdk.openadsdk.core.Ym.TKC.Sj(i24, i23, i25, i26, sPVar, enumC0275Sj);
                                            String sP3 = HiB.sP(xmlPullParser, str10);
                                            if (!TextUtils.isEmpty(sP3) && Sj2 > sj4.Jcg && Sj2 > f12) {
                                                sj4.Jcg = Sj2;
                                                sj4.Sj(sP3, enumC0275Sj, sPVar);
                                                sj3 = sj4;
                                                str7 = str10;
                                                str8 = str4;
                                                str6 = str5;
                                                break;
                                            } else {
                                                HiB.Sj(xmlPullParser, str10, 3);
                                                sj3 = sj4;
                                                str7 = str10;
                                                str8 = str4;
                                                str6 = str5;
                                                i22 = i23;
                                                i21 = i24;
                                                i18 = 3;
                                                break;
                                            }
                                            break;
                                        case 1:
                                            str5 = str6;
                                            sj3.EjP = HiB.sP(xmlPullParser, "CompanionClickThrough");
                                            str7 = str7;
                                            str6 = str5;
                                            break;
                                        case 2:
                                            context3 = context;
                                            str5 = str6;
                                            str3 = str7;
                                            sj2 = sj3;
                                            str4 = str8;
                                            while (true) {
                                                if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("TrackingEvents")) {
                                                    sj3 = sj2;
                                                    str7 = str3;
                                                    str8 = str4;
                                                    str6 = str5;
                                                    break;
                                                } else if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("Tracking")) {
                                                    sj2.sP(HiB.sP(xmlPullParser, "Tracking"));
                                                }
                                            }
                                            break;
                                        case 3:
                                            context3 = context;
                                            str3 = str7;
                                            sj2 = sj3;
                                            str4 = str8;
                                            Sj.EnumC0275Sj enumC0275Sj2 = Sj.EnumC0275Sj.NONE;
                                            String lowerCase = xmlPullParser.getAttributeValue(HiB.Jcg, "creativeType").toLowerCase();
                                            Set<String> set = com.bytedance.sdk.openadsdk.core.Ym.TKC.Sj.Sj;
                                            Sj.EnumC0275Sj enumC0275Sj3 = set.contains(lowerCase) ? Sj.EnumC0275Sj.IMAGE : Sj.EnumC0275Sj.JAVASCRIPT;
                                            Sj.sP sPVar2 = Sj.sP.STATIC_RESOURCE;
                                            Point Sj3 = com.bytedance.sdk.openadsdk.core.Ym.TKC.Sj.Sj(context3, sP, sP2, sPVar2);
                                            str5 = str6;
                                            float Sj4 = com.bytedance.sdk.openadsdk.core.Ym.TKC.Sj(i24, i23, Sj3.x, Sj3.y, sPVar2, enumC0275Sj3);
                                            String sP4 = (set.contains(lowerCase) || com.bytedance.sdk.openadsdk.core.Ym.TKC.Sj.sP.contains(lowerCase)) ? HiB.sP(xmlPullParser, "StaticResource") : null;
                                            if (Sj4 >= sj2.Jcg && Sj4 > f12 && !TextUtils.isEmpty(sP4)) {
                                                sj2.Jcg = Sj4;
                                                sj2.Sj(sP4, enumC0275Sj3, sPVar2);
                                                sj3 = sj2;
                                                str7 = str3;
                                                str8 = str4;
                                                str6 = str5;
                                                break;
                                            } else {
                                                HiB.Sj(xmlPullParser, "StaticResource", 3);
                                                i18 = 3;
                                                sj3 = sj2;
                                                str7 = str3;
                                                str8 = str4;
                                                str6 = str5;
                                                i22 = i23;
                                                i21 = i24;
                                                break;
                                            }
                                            break;
                                        case 4:
                                            sj3.Sj(HiB.sP(xmlPullParser, "CompanionClickTracking"));
                                            str7 = str7;
                                            break;
                                        case 5:
                                            Sj.sP sPVar3 = Sj.sP.HTML_RESOURCE;
                                            Point Sj5 = com.bytedance.sdk.openadsdk.core.Ym.TKC.Sj.Sj(context, sP, sP2, sPVar3);
                                            int i27 = Sj5.x;
                                            int i28 = Sj5.y;
                                            Sj.EnumC0275Sj enumC0275Sj4 = Sj.EnumC0275Sj.NONE;
                                            String str11 = str7;
                                            HiB.Sj sj5 = sj3;
                                            String str12 = str8;
                                            float Sj6 = com.bytedance.sdk.openadsdk.core.Ym.TKC.Sj(i24, i23, i27, i28, sPVar3, enumC0275Sj4);
                                            String sP5 = HiB.sP(xmlPullParser, str6);
                                            if (!TextUtils.isEmpty(sP5) && Sj6 > sj5.Jcg && Sj6 > f12) {
                                                sj5.Jcg = Sj6;
                                                sj5.Sj(sP5, enumC0275Sj4, sPVar3);
                                                sj3 = sj5;
                                                str7 = str11;
                                                str8 = str12;
                                                break;
                                            } else {
                                                HiB.Sj(xmlPullParser, str6, 3);
                                                i18 = 3;
                                                sj3 = sj5;
                                                str7 = str11;
                                                str8 = str12;
                                                i22 = i23;
                                                i21 = i24;
                                                break;
                                            }
                                        default:
                                            HiB.Sj(xmlPullParser);
                                            context3 = context;
                                            str5 = str6;
                                            str3 = str7;
                                            sj2 = sj3;
                                            str4 = str8;
                                            sj3 = sj2;
                                            str7 = str3;
                                            str8 = str4;
                                            str6 = str5;
                                            break;
                                    }
                                }
                                i22 = i23;
                                i21 = i24;
                                i18 = 3;
                            }
                        }
                    }
                }
            }
            str = str6;
            i11 = i17;
            i12 = i22;
            i13 = i21;
            xmlPullParser2 = xmlPullParser3;
            context2 = context4;
            i14 = i18;
            str2 = str7;
            i17 = i11;
            str7 = str2;
            str6 = str;
            i21 = i13;
            i18 = i14;
            context4 = context2;
            xmlPullParser3 = xmlPullParser2;
            i22 = i12;
        }
    }
}
