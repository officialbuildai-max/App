package com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj.HiB;
import com.bytedance.sdk.openadsdk.core.Ym.TKC.Sj;
import com.bytedance.sdk.openadsdk.core.Ym.sP.TKC;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class TKC {
    /* JADX WARN: Failed to find 'out' block for switch in B:44:0x00f2. Please report as an issue. */
    public static com.bytedance.sdk.openadsdk.core.Ym.sP Sj(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String str;
        String str2;
        String str3;
        com.bytedance.sdk.openadsdk.core.Ym.sP sPVar;
        String str4;
        String str5;
        int i11;
        com.bytedance.sdk.openadsdk.core.Ym.sP sPVar2;
        String str6;
        String str7;
        String str8;
        int i12;
        String str9;
        String str10;
        String str11 = "HTMLResource";
        String str12 = "IconClicks";
        String str13 = "StaticResource";
        String str14 = "IFrameResource";
        String str15 = "IconViewTracking";
        int i13 = 2;
        int i14 = 3;
        com.bytedance.sdk.openadsdk.core.Ym.sP sPVar3 = null;
        while (true) {
            if (xmlPullParser.getEventType() == i14 && xmlPullParser.getName().equals("Icons")) {
                return sPVar3;
            }
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == i13 && xmlPullParser.getName().equals("Icon")) {
                String str16 = HiB.Jcg;
                int sP = HiB.sP(xmlPullParser.getAttributeValue(str16, "width"));
                int sP2 = HiB.sP(xmlPullParser.getAttributeValue(str16, "height"));
                if (sP <= 0 || sP > 300 || sP2 <= 0 || sP2 > 300) {
                    str = str11;
                    str2 = str14;
                    str3 = str15;
                    sPVar = sPVar3;
                    str4 = str12;
                    HiB.Sj(xmlPullParser);
                } else {
                    int Sj = com.bytedance.sdk.openadsdk.core.Ym.sP.Sj.Sj(xmlPullParser.getAttributeValue(str16, "offset"));
                    int Sj2 = com.bytedance.sdk.openadsdk.core.Ym.sP.Sj.Sj(xmlPullParser.getAttributeValue(str16, "duration"));
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    String str17 = str14;
                    String str18 = str15;
                    HiB.Sj sj2 = null;
                    String str19 = null;
                    while (true) {
                        if (xmlPullParser.next() == i14 && xmlPullParser.getName().equals("Icon")) {
                            if (sj2 == null || !(sPVar3 == null || TextUtils.isEmpty(sPVar3.vS()))) {
                                str9 = str12;
                                str10 = str13;
                            } else {
                                str9 = str12;
                                str10 = str13;
                                com.bytedance.sdk.openadsdk.core.Ym.sP sPVar4 = new com.bytedance.sdk.openadsdk.core.Ym.sP(sP, sP2, Sj, Sj2, sj2.sP, sj2.TKC, sj2.Sj, arrayList, arrayList2, str19);
                                HiB.Sj(xmlPullParser, "Icons", i14);
                                sPVar3 = sPVar4;
                            }
                            str15 = str18;
                            str14 = str17;
                            str12 = str9;
                            str13 = str10;
                            i13 = 2;
                        } else {
                            String str20 = str12;
                            String str21 = str13;
                            if (xmlPullParser.getEventType() == 2) {
                                String name = xmlPullParser.getName();
                                name.hashCode();
                                switch (name.hashCode()) {
                                    case -1044238411:
                                        i11 = Sj2;
                                        str6 = str18;
                                        str7 = str17;
                                        str8 = str20;
                                        str13 = str21;
                                        if (name.equals(str6)) {
                                            i12 = 0;
                                            break;
                                        }
                                        i12 = -1;
                                        break;
                                    case -375340334:
                                        str7 = str17;
                                        str8 = str20;
                                        str13 = str21;
                                        if (!name.equals(str7)) {
                                            i11 = Sj2;
                                            str6 = str18;
                                            i12 = -1;
                                            break;
                                        } else {
                                            i12 = 1;
                                            i11 = Sj2;
                                            str6 = str18;
                                            break;
                                        }
                                    case 676623548:
                                        str8 = str20;
                                        str13 = str21;
                                        i11 = Sj2;
                                        str6 = str18;
                                        str7 = str17;
                                        if (name.equals(str13)) {
                                            i12 = 2;
                                            break;
                                        }
                                        i12 = -1;
                                        break;
                                    case 1030746596:
                                        str8 = str20;
                                        if (!name.equals(str8)) {
                                            i11 = Sj2;
                                            str6 = str18;
                                            str7 = str17;
                                            str13 = str21;
                                            i12 = -1;
                                            break;
                                        } else {
                                            i12 = i14;
                                            i11 = Sj2;
                                            str6 = str18;
                                            str7 = str17;
                                            str13 = str21;
                                            break;
                                        }
                                    case 1928285401:
                                        if (name.equals(str11)) {
                                            i12 = 4;
                                            i11 = Sj2;
                                            str6 = str18;
                                            str7 = str17;
                                            str8 = str20;
                                            str13 = str21;
                                            break;
                                        }
                                    default:
                                        i11 = Sj2;
                                        str6 = str18;
                                        str7 = str17;
                                        str8 = str20;
                                        str13 = str21;
                                        i12 = -1;
                                        break;
                                }
                                switch (i12) {
                                    case 0:
                                        str5 = str11;
                                        sPVar2 = sPVar3;
                                        arrayList2.add(new TKC.Sj(HiB.sP(xmlPullParser, str6)).Sj());
                                        break;
                                    case 1:
                                        str5 = str11;
                                        sPVar2 = sPVar3;
                                        if (sj2 == null) {
                                            sj2 = new HiB.Sj(HiB.sP(xmlPullParser, str7), Sj.EnumC0275Sj.NONE, Sj.sP.IFRAME_RESOURCE);
                                            break;
                                        }
                                        break;
                                    case 2:
                                        str5 = str11;
                                        sPVar2 = sPVar3;
                                        Sj.EnumC0275Sj enumC0275Sj = Sj.EnumC0275Sj.NONE;
                                        String lowerCase = xmlPullParser.getAttributeValue(HiB.Jcg, "creativeType").toLowerCase();
                                        Set<String> set = com.bytedance.sdk.openadsdk.core.Ym.TKC.Sj.Sj;
                                        sj2 = new HiB.Sj((set.contains(lowerCase) || com.bytedance.sdk.openadsdk.core.Ym.TKC.Sj.sP.contains(lowerCase)) ? HiB.sP(xmlPullParser, str13) : null, set.contains(lowerCase) ? Sj.EnumC0275Sj.IMAGE : Sj.EnumC0275Sj.JAVASCRIPT, Sj.sP.STATIC_RESOURCE);
                                        break;
                                    case 3:
                                        str5 = str11;
                                        sPVar2 = sPVar3;
                                        while (true) {
                                            if (xmlPullParser.next() != 3 || !xmlPullParser.getName().equals(str8)) {
                                                if (xmlPullParser.getEventType() == 2) {
                                                    if (xmlPullParser.getName().equals("IconClickThrough")) {
                                                        str19 = HiB.sP(xmlPullParser, "IconClickThrough");
                                                    } else if (xmlPullParser.getName().equals("IconClickTracking")) {
                                                        arrayList.add(new TKC.Sj(HiB.sP(xmlPullParser, "IconClickTracking")).Sj());
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case 4:
                                        if (sj2 != null) {
                                            sPVar2 = sPVar3;
                                            if (sj2.TKC != Sj.sP.IFRAME_RESOURCE) {
                                                str5 = str11;
                                                break;
                                            }
                                        } else {
                                            sPVar2 = sPVar3;
                                        }
                                        str5 = str11;
                                        sj2 = new HiB.Sj(HiB.sP(xmlPullParser, str11), Sj.EnumC0275Sj.NONE, Sj.sP.HTML_RESOURCE);
                                        break;
                                    default:
                                        str5 = str11;
                                        sPVar2 = sPVar3;
                                        break;
                                }
                                HiB.Sj(xmlPullParser);
                            } else {
                                str5 = str11;
                                i11 = Sj2;
                                sPVar2 = sPVar3;
                                str6 = str18;
                                str7 = str17;
                                str8 = str20;
                                str13 = str21;
                            }
                            str12 = str8;
                            str17 = str7;
                            str18 = str6;
                            sPVar3 = sPVar2;
                            Sj2 = i11;
                            str11 = str5;
                            i14 = 3;
                        }
                    }
                }
            } else {
                str = str11;
                str2 = str14;
                str3 = str15;
                sPVar = sPVar3;
                str4 = str12;
            }
            str12 = str4;
            str14 = str2;
            str15 = str3;
            sPVar3 = sPVar;
            str11 = str;
            i13 = 2;
            i14 = 3;
        }
    }

    private static String Sj(XmlPullParser xmlPullParser, int i11, double d11, com.bytedance.sdk.openadsdk.core.Ym.Sj sj2) throws IOException, XmlPullParserException {
        double d12 = Double.NEGATIVE_INFINITY;
        String str = null;
        int i12 = Integer.MIN_VALUE;
        int i13 = Integer.MIN_VALUE;
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("MediaFiles")) {
                break;
            }
            if (xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals("MediaFile")) {
                String str2 = HiB.Jcg;
                String attributeValue = xmlPullParser.getAttributeValue(str2, NativeComponentConstants.KEY_COMPONENT_TYPE);
                int sP = HiB.sP(xmlPullParser.getAttributeValue(str2, "width"));
                int sP2 = HiB.sP(xmlPullParser.getAttributeValue(str2, "height"));
                int sP3 = HiB.sP(xmlPullParser.getAttributeValue(str2, "bitrate"));
                String sP4 = HiB.sP(xmlPullParser, "MediaFile");
                if (sP > 0 && sP2 > 0 && com.bytedance.sdk.openadsdk.core.Ym.TKC.EjP.Sj.contains(attributeValue) && !TextUtils.isEmpty(sP4)) {
                    double Sj = com.bytedance.sdk.openadsdk.core.Ym.TKC.EjP.Sj(i11, d11, sP, sP2, sP3, attributeValue);
                    if (Sj > d12) {
                        str = sP4;
                        d12 = Sj;
                        i12 = sP;
                        i13 = sP2;
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(str)) {
            sj2.EjP(str);
            sj2.Sj(i12);
            sj2.sP(i13);
        }
        return str;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0043. Please report as an issue. */
    public static void Sj(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.Ym.EjP ejP) throws IOException, XmlPullParserException {
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("TrackingEvents")) {
                return;
            }
            if (xmlPullParser.getEventType() == 2) {
                if ("Tracking".equals(xmlPullParser.getName())) {
                    String attributeValue = xmlPullParser.getAttributeValue(HiB.Jcg, NotificationCompat.CATEGORY_EVENT);
                    if (!TextUtils.isEmpty(attributeValue)) {
                        attributeValue.hashCode();
                        char c11 = 65535;
                        switch (attributeValue.hashCode()) {
                            case -1638835128:
                                if (attributeValue.equals(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT)) {
                                    c11 = 0;
                                    break;
                                }
                                break;
                            case -1337830390:
                                if (attributeValue.equals("thirdQuartile")) {
                                    c11 = 1;
                                    break;
                                }
                                break;
                            case -934426579:
                                if (attributeValue.equals(CampaignEx.JSON_NATIVE_VIDEO_RESUME)) {
                                    c11 = 2;
                                    break;
                                }
                                break;
                            case -840405966:
                                if (attributeValue.equals(CampaignEx.JSON_NATIVE_VIDEO_UNMUTE)) {
                                    c11 = 3;
                                    break;
                                }
                                break;
                            case -599445191:
                                if (attributeValue.equals(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE)) {
                                    c11 = 4;
                                    break;
                                }
                                break;
                            case 3363353:
                                if (attributeValue.equals(CampaignEx.JSON_NATIVE_VIDEO_MUTE)) {
                                    c11 = 5;
                                    break;
                                }
                                break;
                            case 3532159:
                                if (attributeValue.equals("skip")) {
                                    c11 = 6;
                                    break;
                                }
                                break;
                            case 94756344:
                                if (attributeValue.equals("close")) {
                                    c11 = 7;
                                    break;
                                }
                                break;
                            case 106440182:
                                if (attributeValue.equals("pause")) {
                                    c11 = '\b';
                                    break;
                                }
                                break;
                            case 109757538:
                                if (attributeValue.equals("start")) {
                                    c11 = '\t';
                                    break;
                                }
                                break;
                            case 560220243:
                                if (attributeValue.equals("firstQuartile")) {
                                    c11 = '\n';
                                    break;
                                }
                                break;
                            case 1778167540:
                                if (attributeValue.equals("creativeView")) {
                                    c11 = 11;
                                    break;
                                }
                                break;
                        }
                        switch (c11) {
                            case 0:
                                ejP.Sj(HiB.sP(xmlPullParser, "Tracking"), 0.5f);
                                break;
                            case 1:
                                ejP.Sj(HiB.sP(xmlPullParser, "Tracking"), 0.75f);
                                break;
                            case 2:
                                ejP.TKC(TKC(xmlPullParser));
                                break;
                            case 3:
                                ejP.aa(TKC(xmlPullParser));
                                break;
                            case 4:
                                ejP.EjP(TKC(xmlPullParser));
                                break;
                            case 5:
                                ejP.Ym(TKC(xmlPullParser));
                                break;
                            case 6:
                                ejP.vS(TKC(xmlPullParser));
                                break;
                            case 7:
                                ejP.HiB(TKC(xmlPullParser));
                                break;
                            case '\b':
                                ejP.sP(TKC(xmlPullParser));
                                break;
                            case '\t':
                            case 11:
                                ejP.Sj(HiB.sP(xmlPullParser, "Tracking"), 0L);
                                break;
                            case '\n':
                                ejP.Sj(HiB.sP(xmlPullParser, "Tracking"), 0.25f);
                                break;
                        }
                    } else {
                        HiB.Sj(xmlPullParser, "Tracking", 3);
                    }
                } else if (xmlPullParser.getEventType() == 4) {
                    xmlPullParser.nextTag();
                } else {
                    HiB.Sj(xmlPullParser);
                }
            }
        }
    }

    private static void Sj(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.Ym.Sj sj2) throws IOException, XmlPullParserException {
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getName().equals("VideoClicks")) {
                return;
            }
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                if (name.equals("ClickThrough")) {
                    sj2.TKC(HiB.sP(xmlPullParser, "ClickThrough"));
                } else if (name.equals("ClickTracking")) {
                    sj2.Sj().Jcg(HiB.Sj(xmlPullParser, "ClickTracking"));
                } else {
                    HiB.Sj(xmlPullParser);
                }
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x003a. Please report as an issue. */
    public static void Sj(XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.Ym.Sj sj2, int i11, double d11) throws IOException, XmlPullParserException {
        boolean z10 = false;
        while (true) {
            if (xmlPullParser.next() != 3 || !xmlPullParser.getName().equals("Linear")) {
                if (xmlPullParser.getEventType() == 2) {
                    if (z10 && TextUtils.isEmpty(sj2.Jcg())) {
                        HiB.Sj(xmlPullParser);
                    }
                    String name = xmlPullParser.getName();
                    name.hashCode();
                    char c11 = 65535;
                    switch (name.hashCode()) {
                        case -2049897434:
                            if (name.equals("VideoClicks")) {
                                c11 = 0;
                                break;
                            }
                            break;
                        case -1927368268:
                            if (name.equals("Duration")) {
                                c11 = 1;
                                break;
                            }
                            break;
                        case -385055469:
                            if (name.equals("MediaFiles")) {
                                c11 = 2;
                                break;
                            }
                            break;
                        case 70476538:
                            if (name.equals("Icons")) {
                                c11 = 3;
                                break;
                            }
                            break;
                        case 611554000:
                            if (name.equals("TrackingEvents")) {
                                c11 = 4;
                                break;
                            }
                            break;
                    }
                    switch (c11) {
                        case 0:
                            Sj(xmlPullParser, sj2);
                            break;
                        case 1:
                            sj2.Sj(sP(xmlPullParser));
                            break;
                        case 2:
                            Sj(xmlPullParser, i11, d11, sj2);
                            z10 = true;
                            break;
                        case 3:
                            com.bytedance.sdk.openadsdk.core.Ym.sP Sj = Sj(xmlPullParser);
                            if (Sj != null && sj2.sP() == null) {
                                sj2.Sj(Sj);
                                break;
                            }
                            break;
                        case 4:
                            Sj(xmlPullParser, sj2.Sj());
                            break;
                        default:
                            HiB.Sj(xmlPullParser);
                            break;
                    }
                }
            } else {
                return;
            }
        }
    }

    private static List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> TKC(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        return HiB.Sj(xmlPullParser, "Tracking");
    }

    public static double sP(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (HiB.sP(xmlPullParser, "Duration").split(":").length != 3) {
            return 0.0d;
        }
        try {
            return (Integer.parseInt(r2[0].trim()) * 3600) + (Integer.parseInt(r2[1].trim()) * 60) + Float.parseFloat(r2[2].trim());
        } catch (Exception unused) {
            return 0.0d;
        }
    }
}
