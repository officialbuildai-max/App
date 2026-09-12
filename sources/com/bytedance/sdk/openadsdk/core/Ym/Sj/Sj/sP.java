package com.bytedance.sdk.openadsdk.core.Ym.Sj.Sj;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class sP {
    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0040. Please report as an issue. */
    public static com.bytedance.sdk.openadsdk.core.Ym.Sj Sj(Context context, XmlPullParser xmlPullParser, List<com.bytedance.sdk.openadsdk.core.Ym.sP.TKC> list, int i11, double d11) throws IOException, XmlPullParserException {
        xmlPullParser.require(2, HiB.Jcg, "InLine");
        com.bytedance.sdk.openadsdk.core.Ym.Sj sj2 = new com.bytedance.sdk.openadsdk.core.Ym.Sj();
        while (true) {
            if (xmlPullParser.next() == 3 && "InLine".equals(xmlPullParser.getName())) {
                sj2.Sj().TEQ(list);
                return sj2;
            }
            if (xmlPullParser.getEventType() == 2) {
                String name = xmlPullParser.getName();
                name.hashCode();
                char c11 = 65535;
                switch (name.hashCode()) {
                    case -2077435339:
                        if (name.equals("AdVerifications")) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case -1692490108:
                        if (name.equals("Creatives")) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case -56677412:
                        if (name.equals("Description")) {
                            c11 = 2;
                            break;
                        }
                        break;
                    case 67232232:
                        if (name.equals("Error")) {
                            c11 = 3;
                            break;
                        }
                        break;
                    case 184043572:
                        if (name.equals("Extensions")) {
                            c11 = 4;
                            break;
                        }
                        break;
                    case 501930965:
                        if (name.equals("AdTitle")) {
                            c11 = 5;
                            break;
                        }
                        break;
                    case 2114088489:
                        if (name.equals("Impression")) {
                            c11 = 6;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                        sj2.Sj(EjP.Sj(xmlPullParser));
                        continue;
                    case 1:
                        if (!TextUtils.isEmpty(sj2.Jcg()) && sj2.TKC() != null) {
                            break;
                        } else {
                            while (xmlPullParser.next() != 3) {
                                if (xmlPullParser.getEventType() == 2) {
                                    if ("Creative".equals(xmlPullParser.getName())) {
                                        Sj(context, xmlPullParser, sj2, i11, d11);
                                    } else {
                                        HiB.Sj(xmlPullParser);
                                    }
                                }
                            }
                            break;
                        }
                        break;
                    case 2:
                        sj2.sP(HiB.sP(xmlPullParser, name));
                        continue;
                    case 3:
                        list.addAll(HiB.Sj(xmlPullParser, name));
                        continue;
                    case 4:
                        while (true) {
                            if (xmlPullParser.getEventType() == 3 && "Extensions".equals(xmlPullParser.getName())) {
                                continue;
                            } else {
                                xmlPullParser.next();
                                if (xmlPullParser.getEventType() == 2 && "AdVerifications".equals(xmlPullParser.getName())) {
                                    sj2.Sj(EjP.Sj(xmlPullParser));
                                }
                            }
                        }
                        break;
                    case 5:
                        sj2.Sj(HiB.sP(xmlPullParser, name));
                        continue;
                    case 6:
                        sj2.Sj().Sj(HiB.Sj(xmlPullParser, name));
                        continue;
                }
                HiB.Sj(xmlPullParser);
            }
        }
    }

    public static void Sj(Context context, XmlPullParser xmlPullParser, com.bytedance.sdk.openadsdk.core.Ym.Sj sj2, int i11, double d11) throws IOException, XmlPullParserException {
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if ("Linear".equals(xmlPullParser.getName()) && TextUtils.isEmpty(sj2.Jcg())) {
                    TKC.Sj(xmlPullParser, sj2, i11, d11);
                } else if ("CompanionAds".equals(xmlPullParser.getName()) && sj2.TKC() == null) {
                    sj2.Sj(Sj.Sj(context, xmlPullParser));
                } else {
                    HiB.Sj(xmlPullParser);
                }
            }
        }
    }
}
