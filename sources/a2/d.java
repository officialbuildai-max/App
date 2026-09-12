package a2;

import a2.k;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.ParserException;
import androidx.media3.common.r;
import androidx.media3.common.s;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.b1;
import androidx.media3.common.util.r0;
import androidx.media3.common.util.u;
import androidx.media3.common.y;
import androidx.media3.exoplayer.upstream.q;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: classes.dex */
public class d extends DefaultHandler implements q.a {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f133b = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f134c = Pattern.compile("CC([1-4])=.*");

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f135d = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f136e = {2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 1, 1, 1, 2, 1, 1, 2, 2, 2};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f137f = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};

    /* renamed from: a, reason: collision with root package name */
    private final XmlPullParserFactory f138a;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final r f139a;

        /* renamed from: b, reason: collision with root package name */
        public final ImmutableList f140b;

        /* renamed from: c, reason: collision with root package name */
        public final k f141c;

        /* renamed from: d, reason: collision with root package name */
        public final String f142d;

        /* renamed from: e, reason: collision with root package name */
        public final ArrayList f143e;

        /* renamed from: f, reason: collision with root package name */
        public final ArrayList f144f;

        /* renamed from: g, reason: collision with root package name */
        public final long f145g;

        /* renamed from: h, reason: collision with root package name */
        public final List f146h;

        /* renamed from: i, reason: collision with root package name */
        public final List f147i;

        public a(r rVar, List list, k kVar, String str, ArrayList arrayList, ArrayList arrayList2, List list2, List list3, long j11) {
            this.f139a = rVar;
            this.f140b = ImmutableList.copyOf((Collection) list);
            this.f141c = kVar;
            this.f142d = str;
            this.f143e = arrayList;
            this.f144f = arrayList2;
            this.f146h = list2;
            this.f147i = list3;
            this.f145g = j11;
        }
    }

    public d() {
        try {
            this.f138a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e11) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e11);
        }
    }

    protected static int C(List list) {
        String str;
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = (e) list.get(i11);
            if ("urn:scte:dash:cc:cea-608:2015".equals(eVar.f148a) && (str = eVar.f149b) != null) {
                Matcher matcher = f134c.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                u.h("MpdParser", "Unable to parse CEA-608 channel number from: " + eVar.f149b);
            }
        }
        return -1;
    }

    protected static int D(List list) {
        String str;
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = (e) list.get(i11);
            if ("urn:scte:dash:cc:cea-708:2015".equals(eVar.f148a) && (str = eVar.f149b) != null) {
                Matcher matcher = f135d.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                u.h("MpdParser", "Unable to parse CEA-708 service block number from: " + eVar.f149b);
            }
        }
        return -1;
    }

    protected static long G(XmlPullParser xmlPullParser, String str, long j11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j11 : a1.Z0(attributeValue);
    }

    protected static e H(XmlPullParser xmlPullParser, String str) {
        String t02 = t0(xmlPullParser, "schemeIdUri", "");
        String t03 = t0(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, null);
        String t04 = t0(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!b1.d(xmlPullParser, str));
        return new e(t02, t03, t04);
    }

    protected static int I(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        if (attributeValue == null || attributeValue.length() != 6) {
            return -1;
        }
        int parseInt = Integer.parseInt(attributeValue, 16);
        return (8388608 & parseInt) != 0 ? K(str) : J(parseInt);
    }

    private static int J(int i11) {
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int[] iArr = f136e;
            if (i12 >= iArr.length) {
                break;
            }
            i13 += ((i11 >> i12) & 1) * iArr[i12];
            i12++;
        }
        if (i13 == 0) {
            return -1;
        }
        return i13;
    }

    private static int K(String str) {
        String[] q12 = a1.q1(str);
        if (q12.length == 0) {
            return -1;
        }
        List i11 = com.google.common.base.o.f('.').i(com.google.common.base.a.e(q12[0].trim()));
        if (i11.size() != 4 || !((String) i11.get(0)).equals("ac-4")) {
            return -1;
        }
        String str2 = (String) i11.get(3);
        str2.hashCode();
        if (str2.equals("03")) {
            return 18;
        }
        return !str2.equals("04") ? -1 : 21;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected static int L(XmlPullParser xmlPullParser) {
        char c11;
        String attributeValue = xmlPullParser.getAttributeValue(null, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        if (attributeValue == null) {
            return -1;
        }
        String e11 = com.google.common.base.a.e(attributeValue);
        e11.hashCode();
        switch (e11.hashCode()) {
            case 1596796:
                if (e11.equals("4000")) {
                    c11 = 0;
                    break;
                }
                c11 = 65535;
                break;
            case 2937391:
                if (e11.equals("a000")) {
                    c11 = 1;
                    break;
                }
                c11 = 65535;
                break;
            case 3094034:
                if (e11.equals("f800")) {
                    c11 = 2;
                    break;
                }
                c11 = 65535;
                break;
            case 3094035:
                if (e11.equals("f801")) {
                    c11 = 3;
                    break;
                }
                c11 = 65535;
                break;
            case 3133436:
                if (e11.equals("fa01")) {
                    c11 = 4;
                    break;
                }
                c11 = 65535;
                break;
            default:
                c11 = 65535;
                break;
        }
        switch (c11) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 5;
            case 3:
                return 6;
            case 4:
                return 8;
            default:
                return -1;
        }
    }

    protected static int M(XmlPullParser xmlPullParser) {
        int W = W(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, -1);
        if (W <= 0 || W >= 33) {
            return -1;
        }
        return W;
    }

    protected static int N(XmlPullParser xmlPullParser) {
        int bitCount;
        String attributeValue = xmlPullParser.getAttributeValue(null, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        if (attributeValue == null || (bitCount = Integer.bitCount(Integer.parseInt(attributeValue, 16))) == 0) {
            return -1;
        }
        return bitCount;
    }

    protected static long O(XmlPullParser xmlPullParser, String str, long j11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j11 : a1.a1(attributeValue);
    }

    protected static String P(List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = (e) list.get(i11);
            String str = eVar.f148a;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(eVar.f149b)) {
                return MimeTypes.AUDIO_E_AC3_JOC;
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && "ec+3".equals(eVar.f149b)) {
                return MimeTypes.AUDIO_E_AC3_JOC;
            }
        }
        return MimeTypes.AUDIO_E_AC3;
    }

    protected static float T(XmlPullParser xmlPullParser, String str, float f11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? f11 : Float.parseFloat(attributeValue);
    }

    protected static float U(XmlPullParser xmlPullParser, float f11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f11;
        }
        Matcher matcher = f133b.matcher(attributeValue);
        if (!matcher.matches()) {
            return f11;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        return !TextUtils.isEmpty(matcher.group(2)) ? parseInt / Integer.parseInt(r2) : parseInt;
    }

    protected static int W(XmlPullParser xmlPullParser, String str, int i11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i11 : Integer.parseInt(attributeValue);
    }

    protected static long Y(List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = (e) list.get(i11);
            if (com.google.common.base.a.a("http://dashif.org/guidelines/last-segment-number", eVar.f148a)) {
                return Long.parseLong(eVar.f149b);
            }
        }
        return -1L;
    }

    protected static long Z(XmlPullParser xmlPullParser, String str, long j11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j11 : Long.parseLong(attributeValue);
    }

    private long a(List list, long j11, long j12, int i11, long j13) {
        int l11 = i11 >= 0 ? i11 + 1 : (int) a1.l(j13 - j11, j12);
        for (int i12 = 0; i12 < l11; i12++) {
            list.add(l(j11, j12));
            j11 += j12;
        }
        return j11;
    }

    protected static int b0(XmlPullParser xmlPullParser) {
        int W = W(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, -1);
        if (W < 0) {
            return -1;
        }
        int[] iArr = f137f;
        if (W < iArr.length) {
            return iArr[W];
        }
        return -1;
    }

    private static int o(int i11, int i12) {
        if (i11 == -1) {
            return i12;
        }
        if (i12 == -1) {
            return i11;
        }
        androidx.media3.common.util.a.g(i11 == i12);
        return i11;
    }

    private static String p(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        androidx.media3.common.util.a.g(str.equals(str2));
        return str;
    }

    private static void q(ArrayList arrayList) {
        String str;
        int i11 = 0;
        while (true) {
            if (i11 >= arrayList.size()) {
                str = null;
                break;
            }
            DrmInitData.SchemeData schemeData = (DrmInitData.SchemeData) arrayList.get(i11);
            if (androidx.media3.common.h.f10065c.equals(schemeData.uuid) && (str = schemeData.licenseServerUrl) != null) {
                arrayList.remove(i11);
                break;
            }
            i11++;
        }
        if (str == null) {
            return;
        }
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            DrmInitData.SchemeData schemeData2 = (DrmInitData.SchemeData) arrayList.get(i12);
            if (androidx.media3.common.h.f10064b.equals(schemeData2.uuid) && schemeData2.licenseServerUrl == null) {
                arrayList.set(i12, new DrmInitData.SchemeData(androidx.media3.common.h.f10065c, str, schemeData2.mimeType, schemeData2.data));
            }
        }
    }

    private static void r(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = (DrmInitData.SchemeData) arrayList.get(size);
            if (!schemeData.hasData()) {
                int i11 = 0;
                while (true) {
                    if (i11 >= arrayList.size()) {
                        break;
                    }
                    if (((DrmInitData.SchemeData) arrayList.get(i11)).canReplace(schemeData)) {
                        arrayList.remove(size);
                        break;
                    }
                    i11++;
                }
            }
        }
    }

    private static long s(long j11, long j12) {
        if (j12 != C.TIME_UNSET) {
            j11 = j12;
        }
        return j11 == Long.MAX_VALUE ? C.TIME_UNSET : j11;
    }

    private static String t(String str, String str2) {
        if (y.o(str)) {
            return y.c(str2);
        }
        if (y.t(str)) {
            return y.n(str2);
        }
        if (y.s(str) || y.q(str)) {
            return str;
        }
        if (!MimeTypes.APPLICATION_MP4.equals(str)) {
            return null;
        }
        String g11 = y.g(str2);
        return MimeTypes.TEXT_VTT.equals(g11) ? MimeTypes.APPLICATION_MP4VTT : g11;
    }

    protected static String t0(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    private boolean u(String[] strArr) {
        for (String str : strArr) {
            if (str.startsWith("urn:dvb:dash:profile:dvb-dash:")) {
                return true;
            }
        }
        return false;
    }

    protected static String u0(XmlPullParser xmlPullParser, String str) {
        String str2 = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                str2 = xmlPullParser.getText();
            } else {
                v(xmlPullParser);
            }
        } while (!b1.d(xmlPullParser, str));
        return str2;
    }

    public static void v(XmlPullParser xmlPullParser) {
        if (b1.e(xmlPullParser)) {
            int i11 = 1;
            while (i11 != 0) {
                xmlPullParser.next();
                if (b1.e(xmlPullParser)) {
                    i11++;
                } else if (b1.c(xmlPullParser)) {
                    i11--;
                }
            }
        }
    }

    protected long A(XmlPullParser xmlPullParser, long j11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j11;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return Float.parseFloat(attributeValue) * 1000000.0f;
    }

    protected List B(XmlPullParser xmlPullParser, List list, boolean z10) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "dvb:priority");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : z10 ? 1 : Integer.MIN_VALUE;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "dvb:weight");
        int parseInt2 = attributeValue2 != null ? Integer.parseInt(attributeValue2) : 1;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "serviceLocation");
        String u02 = u0(xmlPullParser, "BaseURL");
        if (r0.c(u02)) {
            if (attributeValue3 == null) {
                attributeValue3 = u02;
            }
            return Lists.l(new b(u02, attributeValue3, parseInt, parseInt2));
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            b bVar = (b) list.get(i11);
            String e11 = r0.e(bVar.f116a, u02);
            String str = attributeValue3 == null ? e11 : attributeValue3;
            if (z10) {
                parseInt = bVar.f118c;
                parseInt2 = bVar.f119d;
                str = bVar.f117b;
            }
            arrayList.add(new b(e11, str, parseInt, parseInt2));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0126  */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected android.util.Pair E(org.xmlpull.v1.XmlPullParser r12) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.d.E(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    protected int F(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if (MimeTypes.BASE_TYPE_AUDIO.equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        if (MimeTypes.BASE_TYPE_TEXT.equals(attributeValue)) {
            return 3;
        }
        return "image".equals(attributeValue) ? 4 : -1;
    }

    protected Pair Q(XmlPullParser xmlPullParser, String str, String str2, long j11, long j12, ByteArrayOutputStream byteArrayOutputStream) {
        long Z = Z(xmlPullParser, "id", 0L);
        long Z2 = Z(xmlPullParser, "duration", C.TIME_UNSET);
        long Z3 = Z(xmlPullParser, "presentationTime", 0L);
        long e12 = a1.e1(Z2, 1000L, j11);
        long e13 = a1.e1(Z3 - j12, 1000000L, j11);
        String t02 = t0(xmlPullParser, "messageData", null);
        byte[] R = R(xmlPullParser, byteArrayOutputStream);
        Long valueOf = Long.valueOf(e13);
        if (t02 != null) {
            R = a1.u0(t02);
        }
        return Pair.create(valueOf, c(str, str2, Z, e12, R));
    }

    protected byte[] R(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.reset();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(byteArrayOutputStream, StandardCharsets.UTF_8.name());
        xmlPullParser.nextToken();
        while (!b1.d(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    newSerializer.startDocument(null, Boolean.FALSE);
                    break;
                case 1:
                    newSerializer.endDocument();
                    break;
                case 2:
                    newSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i11 = 0; i11 < xmlPullParser.getAttributeCount(); i11++) {
                        newSerializer.attribute(xmlPullParser.getAttributeNamespace(i11), xmlPullParser.getAttributeName(i11), xmlPullParser.getAttributeValue(i11));
                    }
                    break;
                case 3:
                    newSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    newSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    newSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    newSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    newSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    newSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    newSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    newSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        newSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    protected f S(XmlPullParser xmlPullParser) {
        ByteArrayOutputStream byteArrayOutputStream;
        long j11;
        ArrayList arrayList;
        String t02 = t0(xmlPullParser, "schemeIdUri", "");
        String t03 = t0(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, "");
        long Z = Z(xmlPullParser, "timescale", 1L);
        long Z2 = Z(xmlPullParser, "presentationTimeOffset", 0L);
        ArrayList arrayList2 = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(512);
        while (true) {
            xmlPullParser.next();
            if (b1.f(xmlPullParser, "Event")) {
                byteArrayOutputStream = byteArrayOutputStream2;
                long j12 = Z2;
                j11 = Z2;
                arrayList = arrayList2;
                arrayList.add(Q(xmlPullParser, t02, t03, Z, j12, byteArrayOutputStream));
            } else {
                byteArrayOutputStream = byteArrayOutputStream2;
                j11 = Z2;
                arrayList = arrayList2;
                v(xmlPullParser);
            }
            if (b1.d(xmlPullParser, "EventStream")) {
                break;
            }
            arrayList2 = arrayList;
            byteArrayOutputStream2 = byteArrayOutputStream;
            Z2 = j11;
        }
        long[] jArr = new long[arrayList.size()];
        w2.a[] aVarArr = new w2.a[arrayList.size()];
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            Pair pair = (Pair) arrayList.get(i11);
            jArr[i11] = ((Long) pair.first).longValue();
            aVarArr[i11] = (w2.a) pair.second;
        }
        return d(t02, t03, Z, jArr, aVarArr);
    }

    protected i V(XmlPullParser xmlPullParser) {
        return f0(xmlPullParser, "sourceURL", "range");
    }

    protected s X(XmlPullParser xmlPullParser) {
        return new s(xmlPullParser.getAttributeValue(null, "lang"), u0(xmlPullParser, "Label"));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x01dc A[LOOP:0: B:18:0x00a0->B:26:0x01dc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0197 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected a2.c a0(org.xmlpull.v1.XmlPullParser r47, android.net.Uri r48) {
        /*
            Method dump skipped, instructions count: 489
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.d.a0(org.xmlpull.v1.XmlPullParser, android.net.Uri):a2.c");
    }

    protected a2.a b(long j11, int i11, List list, List list2, List list3, List list4) {
        return new a2.a(j11, i11, list, list2, list3, list4);
    }

    protected w2.a c(String str, String str2, long j11, long j12, byte[] bArr) {
        return new w2.a(str, str2, j12, j11, bArr);
    }

    protected Pair c0(XmlPullParser xmlPullParser, List list, long j11, long j12, long j13, long j14, boolean z10) {
        long j15;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Object obj;
        long j16;
        k n02;
        d dVar = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        Object obj2 = null;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "id");
        long O = O(xmlPullParser2, "start", j11);
        long j17 = C.TIME_UNSET;
        long j18 = j13 != C.TIME_UNSET ? j13 + O : -9223372036854775807L;
        long O2 = O(xmlPullParser2, "duration", C.TIME_UNSET);
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        long j19 = j12;
        boolean z11 = false;
        long j20 = -9223372036854775807L;
        k kVar = null;
        e eVar = null;
        while (true) {
            xmlPullParser.next();
            if (b1.f(xmlPullParser2, "BaseURL")) {
                if (!z11) {
                    j19 = dVar.A(xmlPullParser2, j19);
                    z11 = true;
                }
                arrayList6.addAll(dVar.B(xmlPullParser2, list, z10));
                arrayList3 = arrayList5;
                arrayList = arrayList6;
                j16 = j17;
                obj = obj2;
                arrayList2 = arrayList4;
            } else {
                if (b1.f(xmlPullParser2, "AdaptationSet")) {
                    j15 = j19;
                    arrayList = arrayList6;
                    arrayList2 = arrayList4;
                    arrayList2.add(x(xmlPullParser, !arrayList6.isEmpty() ? arrayList6 : list, kVar, O2, j19, j20, j18, j14, z10));
                    xmlPullParser2 = xmlPullParser;
                    arrayList3 = arrayList5;
                } else {
                    j15 = j19;
                    ArrayList arrayList7 = arrayList5;
                    arrayList = arrayList6;
                    arrayList2 = arrayList4;
                    xmlPullParser2 = xmlPullParser;
                    if (b1.f(xmlPullParser2, "EventStream")) {
                        arrayList7.add(S(xmlPullParser));
                        arrayList3 = arrayList7;
                    } else if (b1.f(xmlPullParser2, "SegmentBase")) {
                        arrayList3 = arrayList7;
                        kVar = l0(xmlPullParser2, null);
                        obj = null;
                        j19 = j15;
                        j16 = C.TIME_UNSET;
                    } else {
                        arrayList3 = arrayList7;
                        if (b1.f(xmlPullParser2, "SegmentList")) {
                            long A = A(xmlPullParser2, C.TIME_UNSET);
                            obj = null;
                            n02 = m0(xmlPullParser, null, j18, O2, j15, A, j14);
                            j20 = A;
                            j19 = j15;
                            j16 = C.TIME_UNSET;
                        } else {
                            obj = null;
                            if (b1.f(xmlPullParser2, "SegmentTemplate")) {
                                long A2 = A(xmlPullParser2, C.TIME_UNSET);
                                j16 = -9223372036854775807L;
                                n02 = n0(xmlPullParser, null, ImmutableList.of(), j18, O2, j15, A2, j14);
                                j20 = A2;
                                j19 = j15;
                            } else {
                                j16 = C.TIME_UNSET;
                                if (b1.f(xmlPullParser2, "AssetIdentifier")) {
                                    eVar = H(xmlPullParser2, "AssetIdentifier");
                                } else {
                                    v(xmlPullParser);
                                }
                                j19 = j15;
                            }
                        }
                        kVar = n02;
                    }
                }
                obj = null;
                j16 = C.TIME_UNSET;
                j19 = j15;
            }
            if (b1.d(xmlPullParser2, "Period")) {
                return Pair.create(g(attributeValue, O, arrayList2, arrayList3, eVar), Long.valueOf(O2));
            }
            arrayList4 = arrayList2;
            arrayList6 = arrayList;
            obj2 = obj;
            arrayList5 = arrayList3;
            j17 = j16;
            dVar = this;
        }
    }

    protected f d(String str, String str2, long j11, long[] jArr, w2.a[] aVarArr) {
        return new f(str, str2, j11, jArr, aVarArr);
    }

    protected String[] d0(XmlPullParser xmlPullParser, String str, String[] strArr) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? strArr : attributeValue.split(",");
    }

    protected r e(String str, String str2, int i11, int i12, float f11, int i13, int i14, int i15, String str3, List list, List list2, String str4, String str5, String str6, List list3, List list4) {
        String str7 = str5;
        String str8 = str4;
        String t11 = t(str2, str8);
        if (MimeTypes.AUDIO_E_AC3.equals(t11)) {
            t11 = P(list4);
            if (MimeTypes.AUDIO_E_AC3_JOC.equals(t11)) {
                str8 = "ec+3";
            }
        }
        if (y.p(str8, str7)) {
            if (str7 == null) {
                str7 = str8;
            }
            t11 = "video/dolby-vision";
            str8 = str7;
        }
        int r02 = r0(list);
        int k02 = k0(list) | h0(list2) | j0(list3) | j0(list4);
        Pair v02 = v0(list3);
        r.b j02 = new r.b().f0(str).U(str2).u0(t11).S(str8).p0(i15).w0(r02).s0(k02).j0(str3);
        int i16 = -1;
        r.b A0 = j02.z0(v02 != null ? ((Integer) v02.first).intValue() : -1).A0(v02 != null ? ((Integer) v02.second).intValue() : -1);
        if (y.t(t11)) {
            A0.B0(i11).d0(i12).b0(f11);
        } else if (y.o(t11)) {
            A0.R(i13).v0(i14);
        } else if (y.s(t11)) {
            if (MimeTypes.APPLICATION_CEA608.equals(t11)) {
                i16 = C(list2);
            } else if (MimeTypes.APPLICATION_CEA708.equals(t11)) {
                i16 = D(list2);
            }
            A0.O(i16);
        } else if (y.q(t11)) {
            A0.B0(i11).d0(i12);
        }
        return A0.N();
    }

    protected h e0(XmlPullParser xmlPullParser) {
        String str = null;
        String t02 = t0(xmlPullParser, "moreInformationURL", null);
        String t03 = t0(xmlPullParser, "lang", null);
        String str2 = null;
        String str3 = null;
        while (true) {
            xmlPullParser.next();
            if (b1.f(xmlPullParser, "Title")) {
                str = xmlPullParser.nextText();
            } else if (b1.f(xmlPullParser, "Source")) {
                str2 = xmlPullParser.nextText();
            } else if (b1.f(xmlPullParser, "Copyright")) {
                str3 = xmlPullParser.nextText();
            } else {
                v(xmlPullParser);
            }
            String str4 = str3;
            if (b1.d(xmlPullParser, "ProgramInformation")) {
                return new h(str, str2, str4, t02, t03);
            }
            str3 = str4;
        }
    }

    protected c f(long j11, long j12, long j13, boolean z10, long j14, long j15, long j16, long j17, h hVar, o oVar, l lVar, Uri uri, List list) {
        return new c(j11, j12, j13, z10, j14, j15, j16, j17, hVar, oVar, lVar, uri, list);
    }

    protected i f0(XmlPullParser xmlPullParser, String str, String str2) {
        long j11;
        long j12;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j11 = Long.parseLong(split[0]);
            if (split.length == 2) {
                j12 = (Long.parseLong(split[1]) - j11) + 1;
                return h(attributeValue, j11, j12);
            }
        } else {
            j11 = 0;
        }
        j12 = -1;
        return h(attributeValue, j11, j12);
    }

    protected g g(String str, long j11, List list, List list2, e eVar) {
        return new g(str, j11, list, list2, eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x021c A[LOOP:0: B:2:0x007a->B:11:0x021c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x01c0 A[EDGE_INSN: B:12:0x01c0->B:13:0x01c0 BREAK  A[LOOP:0: B:2:0x007a->B:11:0x021c], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected a2.d.a g0(org.xmlpull.v1.XmlPullParser r39, java.util.List r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, int r45, int r46, float r47, int r48, int r49, java.lang.String r50, java.util.List r51, java.util.List r52, java.util.List r53, java.util.List r54, a2.k r55, long r56, long r58, long r60, long r62, long r64, boolean r66) {
        /*
            Method dump skipped, instructions count: 556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.d.g0(org.xmlpull.v1.XmlPullParser, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, float, int, int, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, a2.k, long, long, long, long, long, boolean):a2.d$a");
    }

    protected i h(String str, long j11, long j12) {
        return new i(str, j11, j12);
    }

    protected int h0(List list) {
        int w02;
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            e eVar = (e) list.get(i12);
            if (com.google.common.base.a.a("urn:mpeg:dash:role:2011", eVar.f148a)) {
                w02 = i0(eVar.f149b);
            } else if (com.google.common.base.a.a("urn:tva:metadata:cs:AudioPurposeCS:2007", eVar.f148a)) {
                w02 = w0(eVar.f149b);
            }
            i11 |= w02;
        }
        return i11;
    }

    protected j i(a aVar, String str, List list, String str2, ArrayList arrayList, ArrayList arrayList2) {
        r.b b11 = aVar.f139a.b();
        if (str == null || !list.isEmpty()) {
            b11.i0(list);
        } else {
            b11.h0(str);
        }
        String str3 = aVar.f142d;
        if (str3 == null) {
            str3 = str2;
        }
        ArrayList arrayList3 = aVar.f143e;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            q(arrayList3);
            r(arrayList3);
            b11.Y(new DrmInitData(str3, arrayList3));
        }
        ArrayList arrayList4 = aVar.f144f;
        arrayList4.addAll(arrayList2);
        return j.n(aVar.f145g, b11.N(), aVar.f140b, aVar.f141c, arrayList4, aVar.f146h, aVar.f147i, null);
    }

    protected int i0(String str) {
        if (str == null) {
            return 0;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case -2060497896:
                if (str.equals("subtitle")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1724546052:
                if (str.equals(TrackingKey.DESCRIPTION)) {
                    c11 = 1;
                    break;
                }
                break;
            case -1580883024:
                if (str.equals("enhanced-audio-intelligibility")) {
                    c11 = 2;
                    break;
                }
                break;
            case -1574842690:
                if (str.equals("forced_subtitle")) {
                    c11 = 3;
                    break;
                }
                break;
            case -1408024454:
                if (str.equals("alternate")) {
                    c11 = 4;
                    break;
                }
                break;
            case -1396432756:
                if (str.equals("forced-subtitle")) {
                    c11 = 5;
                    break;
                }
                break;
            case 99825:
                if (str.equals("dub")) {
                    c11 = 6;
                    break;
                }
                break;
            case 3343801:
                if (str.equals("main")) {
                    c11 = 7;
                    break;
                }
                break;
            case 3530173:
                if (str.equals(TmcConstants.EXTRA_APP_DEV_TOKEN)) {
                    c11 = '\b';
                    break;
                }
                break;
            case 552573414:
                if (str.equals("caption")) {
                    c11 = '\t';
                    break;
                }
                break;
            case 899152809:
                if (str.equals("commentary")) {
                    c11 = '\n';
                    break;
                }
                break;
            case 1629013393:
                if (str.equals("emergency")) {
                    c11 = 11;
                    break;
                }
                break;
            case 1855372047:
                if (str.equals("supplementary")) {
                    c11 = '\f';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 3:
            case 5:
                return 128;
            case 1:
                return 512;
            case 2:
                return 2048;
            case 4:
                return 2;
            case 6:
                return 16;
            case 7:
                return 1;
            case '\b':
                return 256;
            case '\t':
                return 64;
            case '\n':
                return 8;
            case 11:
                return 32;
            case '\f':
                return 4;
            default:
                return 0;
        }
    }

    protected k.b j(i iVar, long j11, long j12, long j13, long j14, List list, long j15, List list2, long j16, long j17) {
        return new k.b(iVar, j11, j12, j13, j14, list, j15, list2, a1.R0(j16), a1.R0(j17));
    }

    protected int j0(List list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (com.google.common.base.a.a("http://dashif.org/guidelines/trickmode", ((e) list.get(i12)).f148a)) {
                i11 = 16384;
            }
        }
        return i11;
    }

    protected k.c k(i iVar, long j11, long j12, long j13, long j14, long j15, List list, long j16, n nVar, n nVar2, long j17, long j18) {
        return new k.c(iVar, j11, j12, j13, j14, j15, list, j16, nVar, nVar2, a1.R0(j17), a1.R0(j18));
    }

    protected int k0(List list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            e eVar = (e) list.get(i12);
            if (com.google.common.base.a.a("urn:mpeg:dash:role:2011", eVar.f148a)) {
                i11 |= i0(eVar.f149b);
            }
        }
        return i11;
    }

    protected k.d l(long j11, long j12) {
        return new k.d(j11, j12);
    }

    protected k.e l0(XmlPullParser xmlPullParser, k.e eVar) {
        long j11;
        long j12;
        long Z = Z(xmlPullParser, "timescale", eVar != null ? eVar.f185b : 1L);
        long Z2 = Z(xmlPullParser, "presentationTimeOffset", eVar != null ? eVar.f186c : 0L);
        long j13 = eVar != null ? eVar.f199d : 0L;
        long j14 = eVar != null ? eVar.f200e : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            j12 = Long.parseLong(split[0]);
            j11 = (Long.parseLong(split[1]) - j12) + 1;
        } else {
            j11 = j14;
            j12 = j13;
        }
        i iVar = eVar != null ? eVar.f184a : null;
        do {
            xmlPullParser.next();
            if (b1.f(xmlPullParser, "Initialization")) {
                iVar = V(xmlPullParser);
            } else {
                v(xmlPullParser);
            }
        } while (!b1.d(xmlPullParser, "SegmentBase"));
        return m(iVar, Z, Z2, j12, j11);
    }

    protected k.e m(i iVar, long j11, long j12, long j13, long j14) {
        return new k.e(iVar, j11, j12, j13, j14);
    }

    protected k.b m0(XmlPullParser xmlPullParser, k.b bVar, long j11, long j12, long j13, long j14, long j15) {
        long Z = Z(xmlPullParser, "timescale", bVar != null ? bVar.f185b : 1L);
        long Z2 = Z(xmlPullParser, "presentationTimeOffset", bVar != null ? bVar.f186c : 0L);
        long Z3 = Z(xmlPullParser, "duration", bVar != null ? bVar.f188e : C.TIME_UNSET);
        long Z4 = Z(xmlPullParser, "startNumber", bVar != null ? bVar.f187d : 1L);
        long s11 = s(j13, j14);
        List list = null;
        List list2 = null;
        i iVar = null;
        do {
            xmlPullParser.next();
            if (b1.f(xmlPullParser, "Initialization")) {
                iVar = V(xmlPullParser);
            } else if (b1.f(xmlPullParser, "SegmentTimeline")) {
                list = o0(xmlPullParser, Z, j12);
            } else if (b1.f(xmlPullParser, "SegmentURL")) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(p0(xmlPullParser));
            } else {
                v(xmlPullParser);
            }
        } while (!b1.d(xmlPullParser, "SegmentList"));
        if (bVar != null) {
            if (iVar == null) {
                iVar = bVar.f184a;
            }
            if (list == null) {
                list = bVar.f189f;
            }
            if (list2 == null) {
                list2 = bVar.f193j;
            }
        }
        return j(iVar, Z, Z2, Z4, Z3, list, s11, list2, j15, j11);
    }

    protected o n(String str, String str2) {
        return new o(str, str2);
    }

    protected k.c n0(XmlPullParser xmlPullParser, k.c cVar, List list, long j11, long j12, long j13, long j14, long j15) {
        long Z = Z(xmlPullParser, "timescale", cVar != null ? cVar.f185b : 1L);
        long Z2 = Z(xmlPullParser, "presentationTimeOffset", cVar != null ? cVar.f186c : 0L);
        long Z3 = Z(xmlPullParser, "duration", cVar != null ? cVar.f188e : C.TIME_UNSET);
        long Z4 = Z(xmlPullParser, "startNumber", cVar != null ? cVar.f187d : 1L);
        long Y = Y(list);
        long s11 = s(j13, j14);
        List list2 = null;
        n x02 = x0(xmlPullParser, "media", cVar != null ? cVar.f195k : null);
        n x03 = x0(xmlPullParser, "initialization", cVar != null ? cVar.f194j : null);
        i iVar = null;
        do {
            xmlPullParser.next();
            if (b1.f(xmlPullParser, "Initialization")) {
                iVar = V(xmlPullParser);
            } else if (b1.f(xmlPullParser, "SegmentTimeline")) {
                list2 = o0(xmlPullParser, Z, j12);
            } else {
                v(xmlPullParser);
            }
        } while (!b1.d(xmlPullParser, "SegmentTemplate"));
        if (cVar != null) {
            if (iVar == null) {
                iVar = cVar.f184a;
            }
            if (list2 == null) {
                list2 = cVar.f189f;
            }
        }
        return k(iVar, Z, Z2, Z4, Y, Z3, list2, s11, x03, x02, j15, j11);
    }

    protected List o0(XmlPullParser xmlPullParser, long j11, long j12) {
        ArrayList arrayList = new ArrayList();
        long j13 = 0;
        long j14 = -9223372036854775807L;
        boolean z10 = false;
        int i11 = 0;
        do {
            xmlPullParser.next();
            if (b1.f(xmlPullParser, "S")) {
                long Z = Z(xmlPullParser, "t", C.TIME_UNSET);
                if (z10) {
                    j13 = a(arrayList, j13, j14, i11, Z);
                }
                if (Z == C.TIME_UNSET) {
                    Z = j13;
                }
                j14 = Z(xmlPullParser, "d", C.TIME_UNSET);
                i11 = W(xmlPullParser, CampaignEx.JSON_KEY_AD_R, 0);
                z10 = true;
                j13 = Z;
            } else {
                v(xmlPullParser);
            }
        } while (!b1.d(xmlPullParser, "SegmentTimeline"));
        if (z10) {
            a(arrayList, j13, j14, i11, a1.e1(j12, j11, 1000L));
        }
        return arrayList;
    }

    protected i p0(XmlPullParser xmlPullParser) {
        return f0(xmlPullParser, "media", "mediaRange");
    }

    protected int q0(String str) {
        if (str == null) {
            return 0;
        }
        return (str.equals("forced_subtitle") || str.equals("forced-subtitle")) ? 2 : 0;
    }

    protected int r0(List list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            e eVar = (e) list.get(i12);
            if (com.google.common.base.a.a("urn:mpeg:dash:role:2011", eVar.f148a)) {
                i11 |= q0(eVar.f149b);
            }
        }
        return i11;
    }

    protected l s0(XmlPullParser xmlPullParser) {
        long j11 = -9223372036854775807L;
        long j12 = -9223372036854775807L;
        long j13 = -9223372036854775807L;
        float f11 = -3.4028235E38f;
        float f12 = -3.4028235E38f;
        while (true) {
            xmlPullParser.next();
            if (b1.f(xmlPullParser, "Latency")) {
                j11 = Z(xmlPullParser, "target", C.TIME_UNSET);
                j12 = Z(xmlPullParser, "min", C.TIME_UNSET);
                j13 = Z(xmlPullParser, "max", C.TIME_UNSET);
            } else if (b1.f(xmlPullParser, "PlaybackRate")) {
                f11 = T(xmlPullParser, "min", -3.4028235E38f);
                f12 = T(xmlPullParser, "max", -3.4028235E38f);
            }
            long j14 = j11;
            long j15 = j12;
            long j16 = j13;
            float f13 = f11;
            float f14 = f12;
            if (b1.d(xmlPullParser, "ServiceDescription")) {
                return new l(j14, j15, j16, f13, f14);
            }
            j11 = j14;
            j12 = j15;
            j13 = j16;
            f11 = f13;
            f12 = f14;
        }
    }

    protected Pair v0(List list) {
        String str;
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = (e) list.get(i11);
            if ((com.google.common.base.a.a("http://dashif.org/thumbnail_tile", eVar.f148a) || com.google.common.base.a.a("http://dashif.org/guidelines/thumbnail_tile", eVar.f148a)) && (str = eVar.f149b) != null) {
                String[] o12 = a1.o1(str, "x");
                if (o12.length == 2) {
                    try {
                        return Pair.create(Integer.valueOf(Integer.parseInt(o12[0])), Integer.valueOf(Integer.parseInt(o12[1])));
                    } catch (NumberFormatException unused) {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    @Override // androidx.media3.exoplayer.upstream.q.a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public c parse(Uri uri, InputStream inputStream) {
        try {
            XmlPullParser newPullParser = this.f138a.newPullParser();
            newPullParser.setInput(inputStream, null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return a0(newPullParser, uri);
            }
            throw ParserException.createForMalformedManifest("inputStream does not contain a valid media presentation description", null);
        } catch (XmlPullParserException e11) {
            throw ParserException.createForMalformedManifest(null, e11);
        }
    }

    protected int w0(String str) {
        if (str == null) {
            return 0;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                if (str.equals("1")) {
                    c11 = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c11 = 1;
                    break;
                }
                break;
            case AD_REWARD_USER_VALUE:
                if (str.equals("3")) {
                    c11 = 2;
                    break;
                }
                break;
            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                if (str.equals("4")) {
                    c11 = 3;
                    break;
                }
                break;
            case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                if (str.equals(PrepareException.ERROR_NO_URL)) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 512;
            case 1:
                return 2048;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0361 A[LOOP:0: B:2:0x008c->B:11:0x0361, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x031f A[EDGE_INSN: B:12:0x031f->B:13:0x031f BREAK  A[LOOP:0: B:2:0x008c->B:11:0x0361], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected a2.a x(org.xmlpull.v1.XmlPullParser r61, java.util.List r62, a2.k r63, long r64, long r66, long r68, long r70, long r72, boolean r74) {
        /*
            Method dump skipped, instructions count: 891
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.d.x(org.xmlpull.v1.XmlPullParser, java.util.List, a2.k, long, long, long, long, long, boolean):a2.a");
    }

    protected n x0(XmlPullParser xmlPullParser, String str, n nVar) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? n.b(attributeValue) : nVar;
    }

    protected void y(XmlPullParser xmlPullParser) {
        v(xmlPullParser);
    }

    protected o y0(XmlPullParser xmlPullParser) {
        return n(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, AppMeasurementSdk.ConditionalUserProperty.VALUE));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected int z(XmlPullParser xmlPullParser, String str) {
        char c11;
        String t02 = t0(xmlPullParser, "schemeIdUri", null);
        t02.hashCode();
        int i11 = -1;
        switch (t02.hashCode()) {
            case -2128649360:
                if (t02.equals("urn:dts:dash:audio_channel_configuration:2012")) {
                    c11 = 0;
                    break;
                }
                c11 = 65535;
                break;
            case -2060825028:
                if (t02.equals("tag:dolby.com,2015:dash:audio_channel_configuration:2015")) {
                    c11 = 1;
                    break;
                }
                c11 = 65535;
                break;
            case -1352850286:
                if (t02.equals("urn:mpeg:dash:23003:3:audio_channel_configuration:2011")) {
                    c11 = 2;
                    break;
                }
                c11 = 65535;
                break;
            case -1138141449:
                if (t02.equals("tag:dolby.com,2014:dash:audio_channel_configuration:2011")) {
                    c11 = 3;
                    break;
                }
                c11 = 65535;
                break;
            case -986633423:
                if (t02.equals("urn:mpeg:mpegB:cicp:ChannelConfiguration")) {
                    c11 = 4;
                    break;
                }
                c11 = 65535;
                break;
            case -79006963:
                if (t02.equals("tag:dts.com,2014:dash:audio_channel_configuration:2012")) {
                    c11 = 5;
                    break;
                }
                c11 = 65535;
                break;
            case 312179081:
                if (t02.equals("tag:dts.com,2018:uhd:audio_channel_configuration")) {
                    c11 = 6;
                    break;
                }
                c11 = 65535;
                break;
            case 2036691300:
                if (t02.equals("urn:dolby:dash:audio_channel_configuration:2011")) {
                    c11 = 7;
                    break;
                }
                c11 = 65535;
                break;
            default:
                c11 = 65535;
                break;
        }
        switch (c11) {
            case 0:
            case 5:
                i11 = M(xmlPullParser);
                break;
            case 1:
                i11 = I(xmlPullParser, str);
                break;
            case 2:
                i11 = W(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, -1);
                break;
            case 3:
            case 7:
                i11 = L(xmlPullParser);
                break;
            case 4:
                i11 = b0(xmlPullParser);
                break;
            case 6:
                i11 = N(xmlPullParser);
                break;
        }
        do {
            xmlPullParser.next();
        } while (!b1.d(xmlPullParser, "AudioChannelConfiguration"));
        return i11;
    }
}
