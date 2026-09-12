package com.cloud.hisavana.sdk.common.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.VastClick;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.bean.VastIcon;
import com.cloud.hisavana.sdk.common.bean.VastMedia;
import com.cloud.hisavana.sdk.common.bean.VastTracking;
import com.cloud.hisavana.sdk.common.bean.VideoMask;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.AdsProtocolBean;
import com.cloud.hisavana.sdk.e4;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.ByteArrayInputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilderFactory;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes3.dex */
public final class VastDomParseUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f22228a = new Companion(null);

    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(String str, String str2, VastData vastData) {
            VastTracking vastTrack;
            if (str != null) {
                switch (str.hashCode()) {
                    case -1638835128:
                        if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT)) {
                            vastTrack = vastData != null ? vastData.getVastTrack() : null;
                            if (vastTrack == null) {
                                return;
                            }
                            vastTrack.setMidpoint(str2);
                            return;
                        }
                        return;
                    case -1337830390:
                        if (str.equals("thirdQuartile")) {
                            vastTrack = vastData != null ? vastData.getVastTrack() : null;
                            if (vastTrack == null) {
                                return;
                            }
                            vastTrack.setThirdQuarter(str2);
                            return;
                        }
                        return;
                    case -599445191:
                        if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE)) {
                            vastTrack = vastData != null ? vastData.getVastTrack() : null;
                            if (vastTrack == null) {
                                return;
                            }
                            vastTrack.setComplete(str2);
                            return;
                        }
                        return;
                    case 109757538:
                        if (str.equals("start")) {
                            vastTrack = vastData != null ? vastData.getVastTrack() : null;
                            if (vastTrack == null) {
                                return;
                            }
                            vastTrack.setStartTrack(str2);
                            return;
                        }
                        return;
                    case 560220243:
                        if (str.equals("firstQuartile")) {
                            vastTrack = vastData != null ? vastData.getVastTrack() : null;
                            if (vastTrack == null) {
                                return;
                            }
                            vastTrack.setQuarter(str2);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        private final String b(String str) {
            String str2;
            if (str == null) {
                return str;
            }
            String str3 = null;
            if (StringsKt.W(str, "{", false, 2, null) && StringsKt.G(str, "}", false, 2, null)) {
                str3 = str;
            }
            if (str3 == null) {
                return str;
            }
            try {
                Set entrySet = ((HashMap) GsonUtil.b(str, HashMap.class)).entrySet();
                Intrinsics.g(entrySet, "<get-entries>(...)");
                str2 = CollectionsKt.s0(entrySet, UrlUtils.AND_MARK, null, null, 0, null, new Function1<Map.Entry<String, String>, CharSequence>() { // from class: com.cloud.hisavana.sdk.common.util.VastDomParseUtil$Companion$jsonToURLQuery$2$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public final CharSequence invoke(Map.Entry<String, String> entry) {
                        Intrinsics.h(entry, "<name for destructuring parameter 0>");
                        String key = entry.getKey();
                        String value = entry.getValue();
                        StringBuilder sb2 = new StringBuilder();
                        Intrinsics.e(key);
                        sb2.append(URLEncoder.encode(StringsKt.p1(key, '\"'), "UTF-8"));
                        sb2.append('=');
                        Intrinsics.e(value);
                        sb2.append(URLEncoder.encode(StringsKt.p1(StringsKt.n1(value).toString(), '\"'), "UTF-8"));
                        return sb2.toString();
                    }
                }, 30, null);
            } catch (Exception e11) {
                e4.b().e("VastDomParseUtil", "parse error: " + ExceptionsKt.b(e11));
                str2 = str;
            }
            return str2 == null ? str : str2;
        }

        private final void c(VastData vastData, Node node) {
            NodeList childNodes;
            int length;
            if (node == null || (length = (childNodes = node.getChildNodes()).getLength()) < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node item = childNodes.item(i11);
                if (item != null && item.getNodeType() == 1) {
                    String nodeName = item.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    } else {
                        Intrinsics.e(nodeName);
                    }
                    if (Intrinsics.c(nodeName, "InLine")) {
                        VastDomParseUtil.f22228a.k(vastData, item);
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        private final void d(VastData vastData, Node node) {
            List<AdsProtocolBean.OmIdData> adVerifications;
            String nodeName;
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length >= 0) {
                int i11 = 0;
                while (true) {
                    Node item = childNodes.item(i11);
                    if (item != null && item.getNodeType() == 1 && (nodeName = item.getNodeName()) != null) {
                        if (!Intrinsics.c(nodeName, "Verification")) {
                            nodeName = null;
                        }
                        if (nodeName != null) {
                            try {
                                VastDomParseUtil.f22228a.p(vastData, item);
                            } catch (Exception unused) {
                            }
                        }
                    }
                    if (i11 == length) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            if (vastData == null || (adVerifications = vastData.getAdVerifications()) == null) {
                return;
            }
            CollectionsKt.I(adVerifications, new Function1<AdsProtocolBean.OmIdData, Boolean>() { // from class: com.cloud.hisavana.sdk.common.util.VastDomParseUtil$Companion$parseAdVerifications$3
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(AdsProtocolBean.OmIdData it) {
                    Intrinsics.h(it, "it");
                    String str = it.url;
                    return Boolean.valueOf(str == null || str.length() == 0);
                }
            });
        }

        private final void e(VastData vastData, Node node) {
            Node namedItem;
            Node namedItem2;
            NamedNodeMap attributes = node.getAttributes();
            String str = null;
            String s11 = s((attributes == null || (namedItem2 = attributes.getNamedItem("id")) == null) ? null : namedItem2.getNodeValue());
            NamedNodeMap attributes2 = node.getAttributes();
            if (attributes2 != null && (namedItem = attributes2.getNamedItem("skipoffset")) != null) {
                str = namedItem.getNodeValue();
            }
            String s12 = s(str);
            if (vastData != null) {
                vastData.setSkipOffSet(Integer.valueOf(l0.a(s12)));
            }
            if (vastData != null) {
                if (TextUtils.isEmpty(s11) && (s11 = vastData.getId()) == null) {
                    s11 = "";
                }
                vastData.setId(s11);
            }
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node item = childNodes.item(i11);
                if (item != null && item.getNodeType() == 1) {
                    String nodeName = item.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    }
                    if (Intrinsics.c(nodeName, "Linear")) {
                        l(vastData, item);
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        private final void f(VastData vastData, Node node) {
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node item = childNodes.item(i11);
                if (item != null && item.getNodeType() == 1) {
                    String nodeName = item.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    }
                    if (Intrinsics.c(nodeName, "Creative")) {
                        e(vastData, item);
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        private final void g(VastData vastData, Node node) {
            Node namedItem;
            NodeList childNodes = node.getChildNodes();
            try {
                int length = childNodes.getLength();
                if (length < 0) {
                    return;
                }
                int i11 = 0;
                while (true) {
                    Node item = childNodes.item(i11);
                    if (item != null && item.getNodeType() == 1) {
                        String nodeName = item.getNodeName();
                        if (nodeName == null) {
                            nodeName = "";
                        }
                        if (Intrinsics.c(nodeName, "CreativeExtension")) {
                            NamedNodeMap attributes = item.getAttributes();
                            String s11 = s((attributes == null || (namedItem = attributes.getNamedItem(NativeComponentConstants.KEY_COMPONENT_TYPE)) == null) ? null : namedItem.getNodeValue());
                            if (Intrinsics.c("cover", s11)) {
                                if (vastData != null) {
                                    Node firstChild = item.getFirstChild();
                                    vastData.setVideoMask(new VideoMask(s(firstChild != null ? firstChild.getNodeValue() : null)));
                                }
                            } else if (Intrinsics.c("buttonText", s11) && vastData != null) {
                                Node firstChild2 = item.getFirstChild();
                                vastData.setButtonTxt(s(firstChild2 != null ? firstChild2.getNodeValue() : null));
                            }
                        }
                    }
                    return;
                    i11++;
                }
            } catch (Exception e11) {
                e4.b().e("VastDomParseUtil", "parseExtensions " + Log.getStackTraceString(e11));
            }
        }

        private final void h(VastData vastData, Node node) {
            VastIcon vastIcon;
            Node namedItem;
            Node namedItem2;
            Node namedItem3;
            Node namedItem4;
            Node namedItem5;
            Node namedItem6;
            Node namedItem7;
            String str = "0";
            VastIcon vastIcon2 = new VastIcon(null, null, null, null, null, null, null, null, null, null, 1023, null);
            if (vastData == null) {
                vastIcon = vastIcon2;
            } else {
                vastIcon = vastIcon2;
                vastData.setIcon(vastIcon);
            }
            NamedNodeMap attributes = node.getAttributes();
            vastIcon.setProgram((attributes == null || (namedItem7 = attributes.getNamedItem("program")) == null) ? null : namedItem7.getNodeValue());
            try {
                NamedNodeMap attributes2 = node.getAttributes();
                String nodeValue = (attributes2 == null || (namedItem6 = attributes2.getNamedItem("width")) == null) ? null : namedItem6.getNodeValue();
                if (nodeValue == null) {
                    nodeValue = "0";
                }
                vastIcon.setWidth(Integer.valueOf(Integer.parseInt(nodeValue)));
            } catch (Exception e11) {
                e4.b().e("VastDomParseUtil", "parseIcon " + Log.getStackTraceString(e11));
            }
            try {
                NamedNodeMap attributes3 = node.getAttributes();
                String nodeValue2 = (attributes3 == null || (namedItem5 = attributes3.getNamedItem("height")) == null) ? null : namedItem5.getNodeValue();
                if (nodeValue2 == null) {
                    nodeValue2 = "0";
                }
                vastIcon.setHeight(Integer.valueOf(Integer.parseInt(nodeValue2)));
            } catch (Exception e12) {
                e4.b().e("VastDomParseUtil", "parseIcon " + Log.getStackTraceString(e12));
            }
            try {
                NamedNodeMap attributes4 = node.getAttributes();
                String nodeValue3 = (attributes4 == null || (namedItem4 = attributes4.getNamedItem("xPosition")) == null) ? null : namedItem4.getNodeValue();
                if (nodeValue3 == null) {
                    nodeValue3 = "0";
                }
                vastIcon.setXPosition(Integer.valueOf(Integer.parseInt(nodeValue3)));
            } catch (Exception e13) {
                e4.b().e("VastDomParseUtil", "parseIcon " + Log.getStackTraceString(e13));
            }
            try {
                NamedNodeMap attributes5 = node.getAttributes();
                String nodeValue4 = (attributes5 == null || (namedItem3 = attributes5.getNamedItem("yPosition")) == null) ? null : namedItem3.getNodeValue();
                if (nodeValue4 != null) {
                    str = nodeValue4;
                }
                vastIcon.setYPosition(Integer.valueOf(Integer.parseInt(str)));
            } catch (Exception e14) {
                e4.b().e("VastDomParseUtil", "parseIcon " + Log.getStackTraceString(e14));
            }
            NamedNodeMap attributes6 = node.getAttributes();
            vastIcon.setOffset((attributes6 == null || (namedItem2 = attributes6.getNamedItem("offset")) == null) ? null : namedItem2.getNodeValue());
            NamedNodeMap attributes7 = node.getAttributes();
            vastIcon.setDuration(Integer.valueOf(l0.a((attributes7 == null || (namedItem = attributes7.getNamedItem("program")) == null) ? null : namedItem.getNodeValue())));
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node item = childNodes.item(i11);
                if (item != null && item.getNodeType() == 1) {
                    String nodeName = item.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    }
                    if (Intrinsics.c(nodeName, "IconClicks")) {
                        i(vastData, item);
                    } else if (Intrinsics.c(nodeName, "StaticResource")) {
                        Node firstChild = item.getFirstChild();
                        vastIcon.setIconResource(s(firstChild != null ? firstChild.getNodeValue() : null));
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        private final void i(VastData vastData, Node node) {
            VastIcon icon;
            List<String> iconClickTracking;
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node item = childNodes.item(i11);
                if (item != null && item.getNodeType() == 1) {
                    String nodeName = item.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    }
                    if (Intrinsics.c(nodeName, "IconClickThrough")) {
                        VastIcon icon2 = vastData != null ? vastData.getIcon() : null;
                        if (icon2 != null) {
                            Node firstChild = item.getFirstChild();
                            icon2.setIconClick(s(firstChild != null ? firstChild.getNodeValue() : null));
                        }
                    } else if (Intrinsics.c(nodeName, "IconClickTracking")) {
                        Node firstChild2 = item.getFirstChild();
                        String s11 = s(firstChild2 != null ? firstChild2.getNodeValue() : null);
                        if (s11 != null && vastData != null && (icon = vastData.getIcon()) != null && (iconClickTracking = icon.getIconClickTracking()) != null) {
                            iconClickTracking.add(s11);
                        }
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        private final void j(VastData vastData, Node node) {
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node item = childNodes.item(i11);
                if (item != null && item.getNodeType() == 1) {
                    String nodeName = item.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    }
                    if (Intrinsics.c(nodeName, "Icon")) {
                        h(vastData, item);
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        private final void k(VastData vastData, Node node) {
            List<String> impression;
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node item = childNodes.item(i11);
                if (item != null && item.getNodeType() == 1) {
                    String nodeName = item.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    }
                    switch (nodeName.hashCode()) {
                        case -2077435339:
                            if (nodeName.equals("AdVerifications")) {
                                d(vastData, item);
                                break;
                            }
                            break;
                        case -1692490108:
                            if (nodeName.equals("Creatives")) {
                                f(vastData, item);
                                break;
                            }
                            break;
                        case -56677412:
                            if (nodeName.equals("Description") && vastData != null) {
                                Node firstChild = item.getFirstChild();
                                vastData.setDescription(s(firstChild != null ? firstChild.getNodeValue() : null));
                                break;
                            }
                            break;
                        case 501930965:
                            if (nodeName.equals("AdTitle") && vastData != null) {
                                Node firstChild2 = item.getFirstChild();
                                vastData.setTitle(s(firstChild2 != null ? firstChild2.getNodeValue() : null));
                                break;
                            }
                            break;
                        case 2114088489:
                            if (nodeName.equals("Impression")) {
                                Node firstChild3 = item.getFirstChild();
                                String s11 = s(firstChild3 != null ? firstChild3.getNodeValue() : null);
                                if (s11 != null && vastData != null && (impression = vastData.getImpression()) != null) {
                                    impression.add(s11);
                                    break;
                                }
                            }
                            break;
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        private final void l(VastData vastData, Node node) {
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node item = childNodes.item(i11);
                if (item != null && item.getNodeType() == 1) {
                    String nodeName = item.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    }
                    switch (nodeName.hashCode()) {
                        case -2049897434:
                            if (nodeName.equals("VideoClicks")) {
                                q(vastData, item);
                                break;
                            }
                            break;
                        case -1927368268:
                            if (nodeName.equals("Duration")) {
                                Node firstChild = item.getFirstChild();
                                String s11 = s(firstChild != null ? firstChild.getNodeValue() : null);
                                if (vastData != null) {
                                    vastData.setDuration(Integer.valueOf(l0.a(s11)));
                                    break;
                                }
                            }
                            break;
                        case -385055469:
                            if (nodeName.equals("MediaFiles")) {
                                m(vastData, item);
                                break;
                            }
                            break;
                        case -371923645:
                            if (nodeName.equals("CreativeExtensions")) {
                                g(vastData, item);
                                break;
                            }
                            break;
                        case 70476538:
                            if (nodeName.equals("Icons")) {
                                j(vastData, item);
                                break;
                            }
                            break;
                        case 611554000:
                            if (nodeName.equals("TrackingEvents")) {
                                n(vastData, item);
                                break;
                            }
                            break;
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        private final void m(VastData vastData, Node node) {
            Node namedItem;
            Node namedItem2;
            String type;
            VastMedia mainAd;
            VastMedia mainAd2;
            Node namedItem3;
            Node namedItem4;
            NodeList childNodes = node.getChildNodes();
            try {
                int length = childNodes.getLength();
                if (length < 0) {
                    return;
                }
                int i11 = 0;
                while (true) {
                    Node item = childNodes.item(i11);
                    if (item != null && item.getNodeType() == 1) {
                        String nodeName = item.getNodeName();
                        if (nodeName == null) {
                            nodeName = "";
                        }
                        if (Intrinsics.c(nodeName, "MediaFile")) {
                            if (vastData != null) {
                                vastData.setMainAd(new VastMedia(null, null, null, 0, 0, 31, null));
                            }
                            String str = null;
                            VastMedia mainAd3 = vastData != null ? vastData.getMainAd() : null;
                            if (mainAd3 != null) {
                                Node firstChild = item.getFirstChild();
                                mainAd3.setMediaResource(s(firstChild != null ? firstChild.getNodeValue() : null));
                            }
                            VastMedia mainAd4 = vastData != null ? vastData.getMainAd() : null;
                            if (mainAd4 != null) {
                                NamedNodeMap attributes = item.getAttributes();
                                mainAd4.setDelivery(s((attributes == null || (namedItem = attributes.getNamedItem("delivery")) == null) ? null : namedItem.getNodeValue()));
                            }
                            VastMedia mainAd5 = vastData != null ? vastData.getMainAd() : null;
                            if (mainAd5 != null) {
                                NamedNodeMap attributes2 = item.getAttributes();
                                mainAd5.setType(s((attributes2 == null || (namedItem2 = attributes2.getNamedItem(NativeComponentConstants.KEY_COMPONENT_TYPE)) == null) ? null : namedItem2.getNodeValue()));
                            }
                            if (vastData != null) {
                                VastMedia mainAd6 = vastData.getMainAd();
                                vastData.setVideoType((mainAd6 == null || (type = mainAd6.getType()) == null) ? null : Boolean.valueOf(StringsKt.W(type, "video", false, 2, null)));
                            }
                            String str2 = "0";
                            if (vastData != null) {
                                try {
                                    mainAd = vastData.getMainAd();
                                } catch (Exception e11) {
                                    e4.b().e("VastDomParseUtil", "parseMediaFiles width " + Log.getStackTraceString(e11));
                                }
                            } else {
                                mainAd = null;
                            }
                            if (mainAd != null) {
                                NamedNodeMap attributes3 = item.getAttributes();
                                String s11 = s((attributes3 == null || (namedItem4 = attributes3.getNamedItem("width")) == null) ? null : namedItem4.getNodeValue());
                                if (s11 == null) {
                                    s11 = "0";
                                }
                                mainAd.setWidth(Integer.parseInt(s11));
                            }
                            if (vastData != null) {
                                try {
                                    mainAd2 = vastData.getMainAd();
                                } catch (Exception e12) {
                                    e4.b().e("VastDomParseUtil", "parseMediaFiles height " + Log.getStackTraceString(e12));
                                    return;
                                }
                            } else {
                                mainAd2 = null;
                            }
                            if (mainAd2 != null) {
                                NamedNodeMap attributes4 = item.getAttributes();
                                if (attributes4 != null && (namedItem3 = attributes4.getNamedItem("height")) != null) {
                                    str = namedItem3.getNodeValue();
                                }
                                String s12 = s(str);
                                if (s12 != null) {
                                    str2 = s12;
                                }
                                mainAd2.setHeight(Integer.parseInt(str2));
                            }
                        }
                    }
                    return;
                    i11++;
                }
            } catch (Exception e13) {
                e4.b().e("VastDomParseUtil", "parseMediaFiles " + Log.getStackTraceString(e13));
            }
        }

        private final void n(VastData vastData, Node node) {
            Node namedItem;
            if (vastData != null) {
                vastData.setVastTrack(new VastTracking(null, null, null, null, null, 31, null));
            }
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node item = childNodes.item(i11);
                if (item != null && item.getNodeType() == 1) {
                    String nodeName = item.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    }
                    if (Intrinsics.c(nodeName, "Tracking")) {
                        NamedNodeMap attributes = item.getAttributes();
                        String s11 = s((attributes == null || (namedItem = attributes.getNamedItem(NotificationCompat.CATEGORY_EVENT)) == null) ? null : namedItem.getNodeValue());
                        Node firstChild = item.getFirstChild();
                        String nodeValue = firstChild != null ? firstChild.getNodeValue() : null;
                        if (nodeValue == null) {
                            nodeValue = "";
                        }
                        String s12 = s(nodeValue);
                        a(s11, s12 != null ? s12 : "", vastData);
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        private final void p(VastData vastData, Node node) {
            List<AdsProtocolBean.OmIdData> adVerifications;
            Node namedItem;
            AdsProtocolBean.OmIdData omIdData = new AdsProtocolBean.OmIdData();
            NamedNodeMap attributes = node.getAttributes();
            omIdData.vendorKey = (attributes == null || (namedItem = attributes.getNamedItem("vender")) == null) ? null : namedItem.getNodeValue();
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length >= 0) {
                int i11 = 0;
                while (true) {
                    Node item = childNodes.item(i11);
                    if (item != null && item.getNodeType() == 1) {
                        String nodeName = item.getNodeName();
                        if (nodeName == null) {
                            nodeName = "";
                        }
                        if (Intrinsics.c(nodeName, "JavaScriptResource")) {
                            Node firstChild = item.getFirstChild();
                            omIdData.url = s(firstChild != null ? firstChild.getNodeValue() : null);
                        } else if (Intrinsics.c(nodeName, "VerificationParameters")) {
                            Node firstChild2 = item.getFirstChild();
                            omIdData.verification_parameters = b(s(firstChild2 != null ? firstChild2.getNodeValue() : null));
                        }
                    }
                    if (i11 == length) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            if (vastData == null || (adVerifications = vastData.getAdVerifications()) == null) {
                return;
            }
            adVerifications.add(omIdData);
        }

        private final void q(VastData vastData, Node node) {
            VastClick vastClick = new VastClick(null, null, 3, null);
            if (vastData != null) {
                vastData.setVastClick(vastClick);
            }
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            if (length < 0) {
                return;
            }
            int i11 = 0;
            while (true) {
                Node item = childNodes.item(i11);
                if (item != null && item.getNodeType() == 1) {
                    String nodeName = item.getNodeName();
                    if (nodeName == null) {
                        nodeName = "";
                    }
                    if (Intrinsics.c(nodeName, "ClickThrough")) {
                        Node firstChild = item.getFirstChild();
                        vastClick.setVideoClick(s(firstChild != null ? firstChild.getNodeValue() : null));
                    } else if (Intrinsics.c(nodeName, "ClickTracking")) {
                        Node firstChild2 = item.getFirstChild();
                        String s11 = s(firstChild2 != null ? firstChild2.getNodeValue() : null);
                        if (s11 != null) {
                            vastClick.getClickTrack().add(s11);
                        }
                    }
                }
                if (i11 == length) {
                    return;
                } else {
                    i11++;
                }
            }
        }

        private final String r(String str) {
            return str != null ? StringsKt.Q(StringsKt.Q(str, "\\", "", false, 4, null), "\\\"", "\"", false, 4, null) : "";
        }

        private final String s(String str) {
            String Q;
            String Q2;
            if (str == null || (Q = StringsKt.Q(str, "<![CDATA[", "", false, 4, null)) == null || (Q2 = StringsKt.Q(Q, "]]>", "", false, 4, null)) == null) {
                return null;
            }
            return StringsKt.Q(Q2, "&amp;", UrlUtils.AND_MARK, false, 4, null);
        }

        public final VastData o(String data, AdsDTO adsDTO) {
            Intrinsics.h(data, "data");
            if (!TextUtils.isEmpty(data) && adsDTO != null) {
                AthenaTracker.k0(adsDTO, null, 1, "");
                DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
                Intrinsics.g(newInstance, "newInstance(...)");
                VastData vastData = new VastData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
                try {
                    try {
                        byte[] bytes = r(StringsKt.Q(data, UrlUtils.AND_MARK, "&amp;", false, 4, null)).getBytes(Charsets.UTF_8);
                        Intrinsics.g(bytes, "getBytes(...)");
                        Element documentElement = newInstance.newDocumentBuilder().parse(new ByteArrayInputStream(bytes)).getDocumentElement();
                        if (!TextUtils.equals("VAST", documentElement.getTagName())) {
                            return vastData;
                        }
                        vastData.setVersion(VastDomParseUtil.f22228a.s(documentElement.getAttribute("version")));
                        NodeList childNodes = documentElement.getChildNodes();
                        int length = childNodes.getLength();
                        if (length >= 0) {
                            int i11 = 0;
                            while (true) {
                                Node item = childNodes.item(i11);
                                if (item != null && item.getNodeType() == 1) {
                                    String nodeName = item.getNodeName();
                                    if (nodeName == null) {
                                        nodeName = "";
                                    } else {
                                        Intrinsics.e(nodeName);
                                    }
                                    if (Intrinsics.c(nodeName, "Ad")) {
                                        VastDomParseUtil.f22228a.c(vastData, item);
                                    }
                                }
                                i11++;
                            }
                        }
                        e4.b().d("VastDomParseUtil", "parseVast " + vastData);
                        return vastData;
                    } catch (Exception e11) {
                        e = e11;
                        e4.b().e("VastDomParseUtil", Log.getStackTraceString(e));
                        return null;
                    }
                } catch (Exception e12) {
                    e = e12;
                }
            }
            return null;
        }
    }
}
