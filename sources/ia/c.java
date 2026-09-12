package ia;

import android.text.Layout;
import ba.i;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.q0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.gslb.Utils;
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

/* loaded from: classes4.dex */
public final class c extends ba.h {

    /* renamed from: p, reason: collision with root package name */
    private static final Pattern f65210p = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: q, reason: collision with root package name */
    private static final Pattern f65211q = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: r, reason: collision with root package name */
    private static final Pattern f65212r = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: s, reason: collision with root package name */
    static final Pattern f65213s = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* renamed from: t, reason: collision with root package name */
    static final Pattern f65214t = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* renamed from: u, reason: collision with root package name */
    private static final Pattern f65215u = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* renamed from: v, reason: collision with root package name */
    private static final Pattern f65216v = Pattern.compile("^(\\d+) (\\d+)$");

    /* renamed from: w, reason: collision with root package name */
    private static final b f65217w = new b(30.0f, 1, 1);

    /* renamed from: x, reason: collision with root package name */
    private static final a f65218x = new a(32, 15);

    /* renamed from: o, reason: collision with root package name */
    private final XmlPullParserFactory f65219o;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final int f65220a;

        /* renamed from: b, reason: collision with root package name */
        final int f65221b;

        a(int i11, int i12) {
            this.f65220a = i11;
            this.f65221b = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final float f65222a;

        /* renamed from: b, reason: collision with root package name */
        final int f65223b;

        /* renamed from: c, reason: collision with root package name */
        final int f65224c;

        b(float f11, int i11, int i12) {
            this.f65222a = f11;
            this.f65223b = i11;
            this.f65224c = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ia.c$c, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0816c {

        /* renamed from: a, reason: collision with root package name */
        final int f65225a;

        /* renamed from: b, reason: collision with root package name */
        final int f65226b;

        C0816c(int i11, int i12) {
            this.f65225a = i11;
            this.f65226b = i12;
        }
    }

    public c() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.f65219o = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e11) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e11);
        }
    }

    private static a A(XmlPullParser xmlPullParser, a aVar) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = f65216v.matcher(attributeValue);
        if (!matcher.matches()) {
            s.i("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
        try {
            int parseInt = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
            int parseInt2 = Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(2)));
            if (parseInt != 0 && parseInt2 != 0) {
                return new a(parseInt, parseInt2);
            }
            throw new SubtitleDecoderException("Invalid cell resolution " + parseInt + " " + parseInt2);
        } catch (NumberFormatException unused) {
            s.i("TtmlDecoder", "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
    }

    private static void B(String str, g gVar) {
        Matcher matcher;
        String[] S0 = p0.S0(str, "\\s+");
        if (S0.length == 1) {
            matcher = f65212r.matcher(str);
        } else {
            if (S0.length != 2) {
                throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + S0.length + ".");
            }
            matcher = f65212r.matcher(S0[1]);
            s.i("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
        }
        String str2 = (String) com.google.android.exoplayer2.util.a.e(matcher.group(3));
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
                gVar.z(3);
                break;
            case 1:
                gVar.z(2);
                break;
            case 2:
                gVar.z(1);
                break;
            default:
                throw new SubtitleDecoderException("Invalid unit for fontSize: '" + str2 + "'.");
        }
        gVar.y(Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))));
    }

    private static b C(XmlPullParser xmlPullParser) {
        float f11;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (p0.S0(attributeValue2, " ").length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f11 = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        } else {
            f11 = 1.0f;
        }
        b bVar = f65217w;
        int i11 = bVar.f65223b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i11 = Integer.parseInt(attributeValue3);
        }
        int i12 = bVar.f65224c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i12 = Integer.parseInt(attributeValue4);
        }
        return new b(parseInt * f11, i11, i12);
    }

    private static Map D(XmlPullParser xmlPullParser, Map map, a aVar, C0816c c0816c, Map map2, Map map3) {
        do {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, TtmlNode.TAG_STYLE)) {
                String a11 = q0.a(xmlPullParser, TtmlNode.TAG_STYLE);
                g I = I(xmlPullParser, new g());
                if (a11 != null) {
                    for (String str : J(a11)) {
                        I.a((g) map.get(str));
                    }
                }
                String g11 = I.g();
                if (g11 != null) {
                    map.put(g11, I);
                }
            } else if (q0.f(xmlPullParser, TtmlNode.TAG_REGION)) {
                e G = G(xmlPullParser, aVar, c0816c);
                if (G != null) {
                    map2.put(G.f65240a, G);
                }
            } else if (q0.f(xmlPullParser, TtmlNode.TAG_METADATA)) {
                E(xmlPullParser, map3);
            }
        } while (!q0.d(xmlPullParser, TtmlNode.TAG_HEAD));
        return map;
    }

    private static void E(XmlPullParser xmlPullParser, Map map) {
        String a11;
        do {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "image") && (a11 = q0.a(xmlPullParser, "id")) != null) {
                map.put(a11, xmlPullParser.nextText());
            }
        } while (!q0.d(xmlPullParser, TtmlNode.TAG_METADATA));
    }

    private static d F(XmlPullParser xmlPullParser, d dVar, Map map, b bVar) {
        long j11;
        long j12;
        char c11;
        int attributeCount = xmlPullParser.getAttributeCount();
        g I = I(xmlPullParser, null);
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
                    j15 = K(attributeValue, bVar);
                    break;
                case 2:
                    j14 = K(attributeValue, bVar);
                    break;
                case 3:
                    j13 = K(attributeValue, bVar);
                    break;
                case 4:
                    String[] J = J(attributeValue);
                    if (J.length > 0) {
                        strArr = J;
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
        if (dVar != null) {
            long j16 = dVar.f65230d;
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
            } else if (dVar != null) {
                long j18 = dVar.f65231e;
                if (j18 != j11) {
                    j12 = j18;
                }
            }
            return d.c(xmlPullParser.getName(), j17, j12, I, strArr, str2, str, dVar);
        }
        j12 = j14;
        return d.c(xmlPullParser.getName(), j17, j12, I, strArr, str2, str, dVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01ac, code lost:
    
        if (r0.equals("tb") == false) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static ia.e G(org.xmlpull.v1.XmlPullParser r18, ia.c.a r19, ia.c.C0816c r20) {
        /*
            Method dump skipped, instructions count: 572
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ia.c.G(org.xmlpull.v1.XmlPullParser, ia.c$a, ia.c$c):ia.e");
    }

    private static float H(String str) {
        Matcher matcher = f65213s.matcher(str);
        if (!matcher.matches()) {
            s.i("TtmlDecoder", "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)))));
        } catch (NumberFormatException e11) {
            s.j("TtmlDecoder", "Failed to parse shear: " + str, e11);
            return Float.MAX_VALUE;
        }
    }

    private static g I(XmlPullParser xmlPullParser, g gVar) {
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
                case -1224696685:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_FAMILY)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1065511464:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_TEXT_ALIGN)) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -879295043:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_TEXT_DECORATION)) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -734428249:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_WEIGHT)) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 3511770:
                    if (attributeName.equals("ruby")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 94842723:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_COLOR)) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 109403361:
                    if (attributeName.equals("shear")) {
                        c11 = '\b';
                        break;
                    }
                    break;
                case 110138194:
                    if (attributeName.equals("textCombine")) {
                        c11 = '\t';
                        break;
                    }
                    break;
                case 365601008:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_FONT_SIZE)) {
                        c11 = '\n';
                        break;
                    }
                    break;
                case 921125321:
                    if (attributeName.equals("textEmphasis")) {
                        c11 = 11;
                        break;
                    }
                    break;
                case 1115953443:
                    if (attributeName.equals("rubyPosition")) {
                        c11 = '\f';
                        break;
                    }
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        c11 = '\r';
                        break;
                    }
                    break;
                case 1754920356:
                    if (attributeName.equals("multiRowAlign")) {
                        c11 = 14;
                        break;
                    }
                    break;
            }
            c11 = 65535;
            switch (c11) {
                case 0:
                    gVar = x(gVar).B(TtmlNode.ITALIC.equalsIgnoreCase(attributeValue));
                    break;
                case 1:
                    gVar = x(gVar).x(attributeValue);
                    break;
                case 2:
                    gVar = x(gVar).H(z(attributeValue));
                    break;
                case 3:
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
                            gVar = x(gVar).K(false);
                            break;
                        case true:
                            gVar = x(gVar).K(true);
                            break;
                        case true:
                            gVar = x(gVar).C(false);
                            break;
                        case true:
                            gVar = x(gVar).C(true);
                            break;
                    }
                case 4:
                    gVar = x(gVar).v(TtmlNode.BOLD.equalsIgnoreCase(attributeValue));
                    break;
                case 5:
                    if (TtmlNode.TAG_STYLE.equals(xmlPullParser.getName())) {
                        gVar = x(gVar).A(attributeValue);
                        break;
                    } else {
                        break;
                    }
                case 6:
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
                            gVar = x(gVar).F(2);
                            break;
                        case true:
                            gVar = x(gVar).F(1);
                            break;
                        case true:
                            gVar = x(gVar).F(4);
                            break;
                        case true:
                        case true:
                            gVar = x(gVar).F(3);
                            break;
                    }
                case 7:
                    gVar = x(gVar);
                    try {
                        gVar.w(com.google.android.exoplayer2.util.g.c(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused) {
                        s.i("TtmlDecoder", "Failed parsing color value: " + attributeValue);
                        break;
                    }
                case '\b':
                    gVar = x(gVar).G(H(attributeValue));
                    break;
                case '\t':
                    String e13 = com.google.common.base.a.e(attributeValue);
                    e13.hashCode();
                    if (e13.equals(IntegrationConstants.NAVIGATION_BAR_ALL_ACTION)) {
                        gVar = x(gVar).I(true);
                        break;
                    } else if (e13.equals("none")) {
                        gVar = x(gVar).I(false);
                        break;
                    } else {
                        break;
                    }
                case '\n':
                    try {
                        gVar = x(gVar);
                        B(attributeValue, gVar);
                        break;
                    } catch (SubtitleDecoderException unused2) {
                        s.i("TtmlDecoder", "Failed parsing fontSize value: " + attributeValue);
                        break;
                    }
                case 11:
                    gVar = x(gVar).J(ia.b.a(attributeValue));
                    break;
                case '\f':
                    String e14 = com.google.common.base.a.e(attributeValue);
                    e14.hashCode();
                    if (e14.equals("before")) {
                        gVar = x(gVar).E(1);
                        break;
                    } else if (e14.equals("after")) {
                        gVar = x(gVar).E(2);
                        break;
                    } else {
                        break;
                    }
                case '\r':
                    gVar = x(gVar);
                    try {
                        gVar.u(com.google.android.exoplayer2.util.g.c(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused3) {
                        s.i("TtmlDecoder", "Failed parsing background value: " + attributeValue);
                        break;
                    }
                case 14:
                    gVar = x(gVar).D(z(attributeValue));
                    break;
            }
        }
        return gVar;
    }

    private static String[] J(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : p0.S0(trim, "\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bb, code lost:
    
        if (r13.equals("ms") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long K(java.lang.String r13, ia.c.b r14) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ia.c.K(java.lang.String, ia.c$b):long");
    }

    private static C0816c L(XmlPullParser xmlPullParser) {
        String a11 = q0.a(xmlPullParser, TtmlNode.ATTR_TTS_EXTENT);
        if (a11 == null) {
            return null;
        }
        Matcher matcher = f65215u.matcher(a11);
        if (!matcher.matches()) {
            s.i("TtmlDecoder", "Ignoring non-pixel tts extent: " + a11);
            return null;
        }
        try {
            return new C0816c(Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))), Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))));
        } catch (NumberFormatException unused) {
            s.i("TtmlDecoder", "Ignoring malformed tts extent: " + a11);
            return null;
        }
    }

    private static g x(g gVar) {
        return gVar == null ? new g() : gVar;
    }

    private static boolean y(String str) {
        return str.equals(TtmlNode.TAG_TT) || str.equals(TtmlNode.TAG_HEAD) || str.equals(TtmlNode.TAG_BODY) || str.equals(TtmlNode.TAG_DIV) || str.equals(TtmlNode.TAG_P) || str.equals(TtmlNode.TAG_SPAN) || str.equals(TtmlNode.TAG_BR) || str.equals(TtmlNode.TAG_STYLE) || str.equals(TtmlNode.TAG_STYLING) || str.equals(TtmlNode.TAG_LAYOUT) || str.equals(TtmlNode.TAG_REGION) || str.equals(TtmlNode.TAG_METADATA) || str.equals("image") || str.equals("data") || str.equals("information");
    }

    private static Layout.Alignment z(String str) {
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

    @Override // ba.h
    protected i v(byte[] bArr, int i11, boolean z10) {
        b bVar;
        try {
            XmlPullParser newPullParser = this.f65219o.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new e(""));
            C0816c c0816c = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i11), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVar2 = f65217w;
            a aVar = f65218x;
            int i12 = 0;
            h hVar = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                d dVar = (d) arrayDeque.peek();
                if (i12 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if (TtmlNode.TAG_TT.equals(name)) {
                            bVar2 = C(newPullParser);
                            aVar = A(newPullParser, f65218x);
                            c0816c = L(newPullParser);
                        }
                        C0816c c0816c2 = c0816c;
                        b bVar3 = bVar2;
                        a aVar2 = aVar;
                        if (y(name)) {
                            if (TtmlNode.TAG_HEAD.equals(name)) {
                                bVar = bVar3;
                                D(newPullParser, hashMap, aVar2, c0816c2, hashMap2, hashMap3);
                            } else {
                                bVar = bVar3;
                                try {
                                    d F = F(newPullParser, dVar, hashMap2, bVar);
                                    arrayDeque.push(F);
                                    if (dVar != null) {
                                        dVar.a(F);
                                    }
                                } catch (SubtitleDecoderException e11) {
                                    s.j("TtmlDecoder", "Suppressing parser error", e11);
                                    i12++;
                                }
                            }
                            bVar2 = bVar;
                        } else {
                            s.f("TtmlDecoder", "Ignoring unsupported tag: " + newPullParser.getName());
                            i12++;
                            bVar2 = bVar3;
                        }
                        c0816c = c0816c2;
                        aVar = aVar2;
                    } else if (eventType == 4) {
                        ((d) com.google.android.exoplayer2.util.a.e(dVar)).a(d.d(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals(TtmlNode.TAG_TT)) {
                            hVar = new h((d) com.google.android.exoplayer2.util.a.e((d) arrayDeque.peek()), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i12++;
                } else if (eventType == 3) {
                    i12--;
                }
                newPullParser.next();
            }
            if (hVar != null) {
                return hVar;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (IOException e12) {
            throw new IllegalStateException("Unexpected error when reading input.", e12);
        } catch (XmlPullParserException e13) {
            throw new SubtitleDecoderException("Unable to decode source", e13);
        }
    }
}
