package o3;

import android.text.Layout;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.b1;
import androidx.media3.common.util.k;
import androidx.media3.common.util.m;
import androidx.media3.common.util.u;
import androidx.media3.extractor.text.SubtitleDecoderException;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.gslb.Utils;
import i3.i;
import i3.r;
import i3.s;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes2.dex */
public final class d implements s {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f70800b = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f70801c = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f70802d = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: e, reason: collision with root package name */
    static final Pattern f70803e = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* renamed from: f, reason: collision with root package name */
    static final Pattern f70804f = Pattern.compile("^([-+]?\\d+\\.?\\d*?)% ([-+]?\\d+\\.?\\d*?)%$");

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f70805g = Pattern.compile("^([-+]?\\d+\\.?\\d*?)px ([-+]?\\d+\\.?\\d*?)px$");

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f70806h = Pattern.compile("^(\\d+) (\\d+)$");

    /* renamed from: i, reason: collision with root package name */
    private static final a f70807i = new a(30.0f, 1, 1);

    /* renamed from: a, reason: collision with root package name */
    private final XmlPullParserFactory f70808a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final float f70809a;

        /* renamed from: b, reason: collision with root package name */
        final int f70810b;

        /* renamed from: c, reason: collision with root package name */
        final int f70811c;

        a(float f11, int i11, int i12) {
            this.f70809a = f11;
            this.f70810b = i11;
            this.f70811c = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final int f70812a;

        /* renamed from: b, reason: collision with root package name */
        final int f70813b;

        b(int i11, int i12) {
            this.f70812a = i11;
            this.f70813b = i12;
        }
    }

    public d() {
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.f70808a = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e11) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e11);
        }
    }

    private static g d(g gVar) {
        return gVar == null ? new g() : gVar;
    }

    private static boolean e(String str) {
        return str.equals(TtmlNode.TAG_TT) || str.equals(TtmlNode.TAG_HEAD) || str.equals(TtmlNode.TAG_BODY) || str.equals(TtmlNode.TAG_DIV) || str.equals(TtmlNode.TAG_P) || str.equals(TtmlNode.TAG_SPAN) || str.equals(TtmlNode.TAG_BR) || str.equals(TtmlNode.TAG_STYLE) || str.equals(TtmlNode.TAG_STYLING) || str.equals(TtmlNode.TAG_LAYOUT) || str.equals(TtmlNode.TAG_REGION) || str.equals(TtmlNode.TAG_METADATA) || str.equals("image") || str.equals("data") || str.equals("information");
    }

    private static Layout.Alignment f(String str) {
        String e11 = com.google.common.base.a.e(str);
        e11.hashCode();
        char c11 = 65535;
        switch (e11.hashCode()) {
            case -1364013995:
                if (e11.equals(TtmlNode.CENTER)) {
                    c11 = 0;
                    break;
                }
                break;
            case 100571:
                if (e11.equals(TtmlNode.END)) {
                    c11 = 1;
                    break;
                }
                break;
            case 3317767:
                if (e11.equals(TtmlNode.LEFT)) {
                    c11 = 2;
                    break;
                }
                break;
            case 108511772:
                if (e11.equals(TtmlNode.RIGHT)) {
                    c11 = 3;
                    break;
                }
                break;
            case 109757538:
                if (e11.equals("start")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return Layout.Alignment.ALIGN_CENTER;
            case 1:
            case 3:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 2:
            case 4:
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    private static int g(XmlPullParser xmlPullParser, int i11) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return i11;
        }
        Matcher matcher = f70806h.matcher(attributeValue);
        if (!matcher.matches()) {
            u.h("TtmlParser", "Ignoring malformed cell resolution: " + attributeValue);
            return i11;
        }
        boolean z10 = true;
        try {
            int parseInt = Integer.parseInt((String) androidx.media3.common.util.a.e(matcher.group(1)));
            int parseInt2 = Integer.parseInt((String) androidx.media3.common.util.a.e(matcher.group(2)));
            if (parseInt == 0 || parseInt2 == 0) {
                z10 = false;
            }
            androidx.media3.common.util.a.b(z10, "Invalid cell resolution " + parseInt + " " + parseInt2);
            return parseInt2;
        } catch (NumberFormatException unused) {
            u.h("TtmlParser", "Ignoring malformed cell resolution: " + attributeValue);
            return i11;
        }
    }

    private static void h(String str, g gVar) {
        Matcher matcher;
        String[] o12 = a1.o1(str, "\\s+");
        if (o12.length == 1) {
            matcher = f70802d.matcher(str);
        } else {
            if (o12.length != 2) {
                throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + o12.length + ".");
            }
            matcher = f70802d.matcher(o12[1]);
            u.h("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
        }
        String str2 = (String) androidx.media3.common.util.a.e(matcher.group(3));
        str2.hashCode();
        char c11 = 65535;
        switch (str2.hashCode()) {
            case 37:
                if (str2.equals("%")) {
                    c11 = 0;
                    break;
                }
                break;
            case 3240:
                if (str2.equals("em")) {
                    c11 = 1;
                    break;
                }
                break;
            case 3592:
                if (str2.equals("px")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                gVar.C(3);
                break;
            case 1:
                gVar.C(2);
                break;
            case 2:
                gVar.C(1);
                break;
            default:
                throw new SubtitleDecoderException("Invalid unit for fontSize: '" + str2 + "'.");
        }
        gVar.B(Float.parseFloat((String) androidx.media3.common.util.a.e(matcher.group(1))));
    }

    private static a i(XmlPullParser xmlPullParser) {
        float f11;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            androidx.media3.common.util.a.b(a1.o1(attributeValue2, " ").length == 2, "frameRateMultiplier doesn't have 2 parts");
            f11 = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        } else {
            f11 = 1.0f;
        }
        a aVar = f70807i;
        int i11 = aVar.f70810b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i11 = Integer.parseInt(attributeValue3);
        }
        int i12 = aVar.f70811c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i12 = Integer.parseInt(attributeValue4);
        }
        return new a(parseInt * f11, i11, i12);
    }

    private static Map j(XmlPullParser xmlPullParser, Map map, int i11, b bVar, Map map2, Map map3) {
        do {
            xmlPullParser.next();
            if (b1.f(xmlPullParser, TtmlNode.TAG_STYLE)) {
                String a11 = b1.a(xmlPullParser, TtmlNode.TAG_STYLE);
                g o11 = o(xmlPullParser, new g());
                if (a11 != null) {
                    for (String str : p(a11)) {
                        o11.a((g) map.get(str));
                    }
                }
                String h11 = o11.h();
                if (h11 != null) {
                    map.put(h11, o11);
                }
            } else if (b1.f(xmlPullParser, TtmlNode.TAG_REGION)) {
                e m11 = m(xmlPullParser, i11, bVar, map);
                if (m11 != null) {
                    map2.put(m11.f70814a, m11);
                }
            } else if (b1.f(xmlPullParser, TtmlNode.TAG_METADATA)) {
                k(xmlPullParser, map3);
            }
        } while (!b1.d(xmlPullParser, TtmlNode.TAG_HEAD));
        return map;
    }

    private static void k(XmlPullParser xmlPullParser, Map map) {
        String a11;
        do {
            xmlPullParser.next();
            if (b1.f(xmlPullParser, "image") && (a11 = b1.a(xmlPullParser, "id")) != null) {
                map.put(a11, xmlPullParser.nextText());
            }
        } while (!b1.d(xmlPullParser, TtmlNode.TAG_METADATA));
    }

    private static c l(XmlPullParser xmlPullParser, c cVar, Map map, a aVar) {
        long j11;
        long j12;
        char c11;
        int attributeCount = xmlPullParser.getAttributeCount();
        g o11 = o(xmlPullParser, null);
        String str = null;
        String str2 = "";
        long j13 = C.TIME_UNSET;
        long j14 = C.TIME_UNSET;
        long j15 = C.TIME_UNSET;
        String[] strArr = null;
        for (int i11 = 0; i11 < attributeCount; i11++) {
            String attributeName = xmlPullParser.getAttributeName(i11);
            String attributeValue = xmlPullParser.getAttributeValue(i11);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -934795532:
                    if (attributeName.equals(TtmlNode.TAG_REGION)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 99841:
                    if (attributeName.equals("dur")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 100571:
                    if (attributeName.equals(TtmlNode.END)) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 93616297:
                    if (attributeName.equals("begin")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 109780401:
                    if (attributeName.equals(TtmlNode.TAG_STYLE)) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 1292595405:
                    if (attributeName.equals("backgroundImage")) {
                        c11 = 5;
                        break;
                    }
                    break;
            }
            c11 = 65535;
            switch (c11) {
                case 0:
                    if (!map.containsKey(attributeValue)) {
                        break;
                    } else {
                        str2 = attributeValue;
                        continue;
                    }
                case 1:
                    j15 = q(attributeValue, aVar);
                    break;
                case 2:
                    j14 = q(attributeValue, aVar);
                    break;
                case 3:
                    j13 = q(attributeValue, aVar);
                    break;
                case 4:
                    String[] p11 = p(attributeValue);
                    if (p11.length > 0) {
                        strArr = p11;
                        break;
                    }
                    break;
                case 5:
                    if (attributeValue.startsWith(Utils.SEPARATOR)) {
                        str = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
        }
        if (cVar != null) {
            long j16 = cVar.f70790d;
            j11 = C.TIME_UNSET;
            if (j16 != C.TIME_UNSET) {
                if (j13 != C.TIME_UNSET) {
                    j13 += j16;
                }
                if (j14 != C.TIME_UNSET) {
                    j14 += j16;
                }
            }
        } else {
            j11 = C.TIME_UNSET;
        }
        long j17 = j13;
        if (j14 == j11) {
            if (j15 != j11) {
                j12 = j17 + j15;
            } else if (cVar != null) {
                long j18 = cVar.f70791e;
                if (j18 != j11) {
                    j12 = j18;
                }
            }
            return c.c(xmlPullParser.getName(), j17, j12, o11, strArr, str2, str, cVar);
        }
        j12 = j14;
        return c.c(xmlPullParser.getName(), j17, j12, o11, strArr, str2, str, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x01ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static o3.e m(org.xmlpull.v1.XmlPullParser r18, int r19, o3.d.b r20, java.util.Map r21) {
        /*
            Method dump skipped, instructions count: 610
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.d.m(org.xmlpull.v1.XmlPullParser, int, o3.d$b, java.util.Map):o3.e");
    }

    private static float n(String str) {
        Matcher matcher = f70803e.matcher(str);
        if (!matcher.matches()) {
            u.h("TtmlParser", "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) androidx.media3.common.util.a.e(matcher.group(1)))));
        } catch (NumberFormatException e11) {
            u.i("TtmlParser", "Failed to parse shear: " + str, e11);
            return Float.MAX_VALUE;
        }
    }

    private static g o(XmlPullParser xmlPullParser, g gVar) {
        char c11;
        boolean z10;
        boolean z11;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            String attributeValue = xmlPullParser.getAttributeValue(i11);
            String attributeName = xmlPullParser.getAttributeName(i11);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_STYLE)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1289044182:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_EXTENT)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1224696685:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_FAMILY)) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -1065511464:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_TEXT_ALIGN)) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -1008619738:
                    if (attributeName.equals("origin")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -879295043:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_TEXT_DECORATION)) {
                        c11 = 5;
                        break;
                    }
                    break;
                case -734428249:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_WEIGHT)) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 3511770:
                    if (attributeName.equals("ruby")) {
                        c11 = '\b';
                        break;
                    }
                    break;
                case 94842723:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_COLOR)) {
                        c11 = '\t';
                        break;
                    }
                    break;
                case 109403361:
                    if (attributeName.equals("shear")) {
                        c11 = '\n';
                        break;
                    }
                    break;
                case 110138194:
                    if (attributeName.equals("textCombine")) {
                        c11 = 11;
                        break;
                    }
                    break;
                case 365601008:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_SIZE)) {
                        c11 = '\f';
                        break;
                    }
                    break;
                case 921125321:
                    if (attributeName.equals("textEmphasis")) {
                        c11 = '\r';
                        break;
                    }
                    break;
                case 1115953443:
                    if (attributeName.equals("rubyPosition")) {
                        c11 = 14;
                        break;
                    }
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        c11 = 15;
                        break;
                    }
                    break;
                case 1754920356:
                    if (attributeName.equals("multiRowAlign")) {
                        c11 = 16;
                        break;
                    }
                    break;
            }
            c11 = 65535;
            switch (c11) {
                case 0:
                    gVar = d(gVar).E(TtmlNode.ITALIC.equalsIgnoreCase(attributeValue));
                    break;
                case 1:
                    gVar = d(gVar).y(attributeValue);
                    break;
                case 2:
                    gVar = d(gVar).A(attributeValue);
                    break;
                case 3:
                    gVar = d(gVar).L(f(attributeValue));
                    break;
                case 4:
                    gVar = d(gVar).H(attributeValue);
                    break;
                case 5:
                    String e11 = com.google.common.base.a.e(attributeValue);
                    e11.hashCode();
                    switch (e11.hashCode()) {
                        case -1461280213:
                            if (e11.equals(TtmlNode.NO_UNDERLINE)) {
                                z10 = false;
                                break;
                            }
                            break;
                        case -1026963764:
                            if (e11.equals(TtmlNode.UNDERLINE)) {
                                z10 = true;
                                break;
                            }
                            break;
                        case 913457136:
                            if (e11.equals(TtmlNode.NO_LINETHROUGH)) {
                                z10 = 2;
                                break;
                            }
                            break;
                        case 1679736913:
                            if (e11.equals(TtmlNode.LINETHROUGH)) {
                                z10 = 3;
                                break;
                            }
                            break;
                    }
                    z10 = -1;
                    switch (z10) {
                        case false:
                            gVar = d(gVar).O(false);
                            break;
                        case true:
                            gVar = d(gVar).O(true);
                            break;
                        case true:
                            gVar = d(gVar).F(false);
                            break;
                        case true:
                            gVar = d(gVar).F(true);
                            break;
                    }
                case 6:
                    gVar = d(gVar).x(TtmlNode.BOLD.equalsIgnoreCase(attributeValue));
                    break;
                case 7:
                    if (TtmlNode.TAG_STYLE.equals(xmlPullParser.getName())) {
                        gVar = d(gVar).D(attributeValue);
                        break;
                    } else {
                        break;
                    }
                case '\b':
                    String e12 = com.google.common.base.a.e(attributeValue);
                    e12.hashCode();
                    switch (e12.hashCode()) {
                        case -618561360:
                            if (e12.equals("baseContainer")) {
                                z11 = false;
                                break;
                            }
                            break;
                        case -410956671:
                            if (e12.equals("container")) {
                                z11 = true;
                                break;
                            }
                            break;
                        case -250518009:
                            if (e12.equals(RequestParameters.DELIMITER)) {
                                z11 = 2;
                                break;
                            }
                            break;
                        case -136074796:
                            if (e12.equals("textContainer")) {
                                z11 = 3;
                                break;
                            }
                            break;
                        case 3016401:
                            if (e12.equals("base")) {
                                z11 = 4;
                                break;
                            }
                            break;
                        case 3556653:
                            if (e12.equals(MimeTypes.BASE_TYPE_TEXT)) {
                                z11 = 5;
                                break;
                            }
                            break;
                    }
                    z11 = -1;
                    switch (z11) {
                        case false:
                        case true:
                            gVar = d(gVar).J(2);
                            break;
                        case true:
                            gVar = d(gVar).J(1);
                            break;
                        case true:
                            gVar = d(gVar).J(4);
                            break;
                        case true:
                        case true:
                            gVar = d(gVar).J(3);
                            break;
                    }
                case '\t':
                    gVar = d(gVar);
                    try {
                        gVar.z(k.c(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused) {
                        u.h("TtmlParser", "Failed parsing color value: " + attributeValue);
                        break;
                    }
                case '\n':
                    gVar = d(gVar).K(n(attributeValue));
                    break;
                case 11:
                    String e13 = com.google.common.base.a.e(attributeValue);
                    e13.hashCode();
                    if (e13.equals(IntegrationConstants.NAVIGATION_BAR_ALL_ACTION)) {
                        gVar = d(gVar).M(true);
                        break;
                    } else if (e13.equals("none")) {
                        gVar = d(gVar).M(false);
                        break;
                    } else {
                        break;
                    }
                case '\f':
                    try {
                        gVar = d(gVar);
                        h(attributeValue, gVar);
                        break;
                    } catch (SubtitleDecoderException unused2) {
                        u.h("TtmlParser", "Failed parsing fontSize value: " + attributeValue);
                        break;
                    }
                case '\r':
                    gVar = d(gVar).N(o3.b.a(attributeValue));
                    break;
                case 14:
                    String e14 = com.google.common.base.a.e(attributeValue);
                    e14.hashCode();
                    if (e14.equals("before")) {
                        gVar = d(gVar).I(1);
                        break;
                    } else if (e14.equals("after")) {
                        gVar = d(gVar).I(2);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    gVar = d(gVar);
                    try {
                        gVar.w(k.c(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused3) {
                        u.h("TtmlParser", "Failed parsing background value: " + attributeValue);
                        break;
                    }
                case 16:
                    gVar = d(gVar).G(f(attributeValue));
                    break;
            }
        }
        return gVar;
    }

    private static String[] p(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : a1.o1(trim, "\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bb, code lost:
    
        if (r13.equals("ms") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long q(java.lang.String r13, o3.d.a r14) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.d.q(java.lang.String, o3.d$a):long");
    }

    private static b r(XmlPullParser xmlPullParser) {
        String a11 = b1.a(xmlPullParser, TtmlNode.ATTR_TTS_EXTENT);
        if (a11 == null) {
            return null;
        }
        Matcher matcher = f70805g.matcher(a11);
        if (!matcher.matches()) {
            u.h("TtmlParser", "Ignoring non-pixel tts extent: " + a11);
            return null;
        }
        try {
            return new b(Integer.parseInt((String) androidx.media3.common.util.a.e(matcher.group(1))), Integer.parseInt((String) androidx.media3.common.util.a.e(matcher.group(2))));
        } catch (NumberFormatException unused) {
            u.h("TtmlParser", "Ignoring malformed tts extent: " + a11);
            return null;
        }
    }

    @Override // i3.s
    public void a(byte[] bArr, int i11, int i12, s.b bVar, m mVar) {
        i.c(b(bArr, i11, i12), bVar, mVar);
    }

    @Override // i3.s
    public i3.k b(byte[] bArr, int i11, int i12) {
        char c11;
        a aVar;
        try {
            XmlPullParser newPullParser = this.f70808a.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new e(""));
            b bVar = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, i11, i12), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            a aVar2 = f70807i;
            h hVar = null;
            int i13 = 0;
            int i14 = 15;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                c cVar = (c) arrayDeque.peek();
                if (i13 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if (TtmlNode.TAG_TT.equals(name)) {
                            aVar2 = i(newPullParser);
                            c11 = 15;
                            i14 = g(newPullParser, 15);
                            bVar = r(newPullParser);
                        } else {
                            c11 = 15;
                        }
                        b bVar2 = bVar;
                        a aVar3 = aVar2;
                        int i15 = i14;
                        if (e(name)) {
                            if (TtmlNode.TAG_HEAD.equals(name)) {
                                aVar = aVar3;
                                j(newPullParser, hashMap, i15, bVar2, hashMap2, hashMap3);
                            } else {
                                aVar = aVar3;
                                try {
                                    c l11 = l(newPullParser, cVar, hashMap2, aVar);
                                    arrayDeque.push(l11);
                                    if (cVar != null) {
                                        cVar.a(l11);
                                    }
                                } catch (SubtitleDecoderException e11) {
                                    u.i("TtmlParser", "Suppressing parser error", e11);
                                    i13++;
                                }
                            }
                            aVar2 = aVar;
                            bVar = bVar2;
                            i14 = i15;
                        } else {
                            u.f("TtmlParser", "Ignoring unsupported tag: " + newPullParser.getName());
                            i13++;
                            aVar2 = aVar3;
                            bVar = bVar2;
                            i14 = i15;
                        }
                    } else if (eventType == 4) {
                        ((c) androidx.media3.common.util.a.e(cVar)).a(c.d(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals(TtmlNode.TAG_TT)) {
                            hVar = new h((c) androidx.media3.common.util.a.e((c) arrayDeque.peek()), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i13++;
                } else if (eventType == 3) {
                    i13--;
                }
                newPullParser.next();
            }
            return (i3.k) androidx.media3.common.util.a.e(hVar);
        } catch (IOException e12) {
            throw new IllegalStateException("Unexpected error when reading input.", e12);
        } catch (XmlPullParserException e13) {
            throw new IllegalStateException("Unable to decode source", e13);
        }
    }

    @Override // i3.s
    public int c() {
        return 1;
    }

    @Override // i3.s
    public /* synthetic */ void reset() {
        r.b(this);
    }
}
