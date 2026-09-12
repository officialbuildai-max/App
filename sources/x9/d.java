package x9;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.util.n0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.q0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.w;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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
import x9.k;

/* loaded from: classes4.dex */
public class d extends DefaultHandler implements b0.a {

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f78197b = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f78198c = Pattern.compile("CC([1-4])=.*");

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f78199d = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f78200e = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};

    /* renamed from: a, reason: collision with root package name */
    private final XmlPullParserFactory f78201a;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final o1 f78202a;

        /* renamed from: b, reason: collision with root package name */
        public final ImmutableList f78203b;

        /* renamed from: c, reason: collision with root package name */
        public final k f78204c;

        /* renamed from: d, reason: collision with root package name */
        public final String f78205d;

        /* renamed from: e, reason: collision with root package name */
        public final ArrayList f78206e;

        /* renamed from: f, reason: collision with root package name */
        public final ArrayList f78207f;

        /* renamed from: g, reason: collision with root package name */
        public final long f78208g;

        /* renamed from: h, reason: collision with root package name */
        public final List f78209h;

        /* renamed from: i, reason: collision with root package name */
        public final List f78210i;

        public a(o1 o1Var, List list, k kVar, String str, ArrayList arrayList, ArrayList arrayList2, List list2, List list3, long j11) {
            this.f78202a = o1Var;
            this.f78203b = ImmutableList.copyOf((Collection) list);
            this.f78204c = kVar;
            this.f78205d = str;
            this.f78206e = arrayList;
            this.f78207f = arrayList2;
            this.f78209h = list2;
            this.f78210i = list3;
            this.f78208g = j11;
        }
    }

    public d() {
        try {
            this.f78201a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e11) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e11);
        }
    }

    protected static int B(List list) {
        String str;
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = (e) list.get(i11);
            if ("urn:scte:dash:cc:cea-608:2015".equals(eVar.f78211a) && (str = eVar.f78212b) != null) {
                Matcher matcher = f78198c.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                String valueOf = String.valueOf(eVar.f78212b);
                s.i("MpdParser", valueOf.length() != 0 ? "Unable to parse CEA-608 channel number from: ".concat(valueOf) : new String("Unable to parse CEA-608 channel number from: "));
            }
        }
        return -1;
    }

    protected static int C(List list) {
        String str;
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = (e) list.get(i11);
            if ("urn:scte:dash:cc:cea-708:2015".equals(eVar.f78211a) && (str = eVar.f78212b) != null) {
                Matcher matcher = f78199d.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                String valueOf = String.valueOf(eVar.f78212b);
                s.i("MpdParser", valueOf.length() != 0 ? "Unable to parse CEA-708 service block number from: ".concat(valueOf) : new String("Unable to parse CEA-708 service block number from: "));
            }
        }
        return -1;
    }

    protected static long F(XmlPullParser xmlPullParser, String str, long j11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j11 : p0.I0(attributeValue);
    }

    protected static e G(XmlPullParser xmlPullParser, String str) {
        String n02 = n0(xmlPullParser, "schemeIdUri", "");
        String n03 = n0(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, null);
        String n04 = n0(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!q0.d(xmlPullParser, str));
        return new e(n02, n03, n04);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected static int H(XmlPullParser xmlPullParser) {
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
            case 3094035:
                if (e11.equals("f801")) {
                    c11 = 2;
                    break;
                }
                c11 = 65535;
                break;
            case 3133436:
                if (e11.equals("fa01")) {
                    c11 = 3;
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
                return 6;
            case 3:
                return 8;
            default:
                return -1;
        }
    }

    protected static long I(XmlPullParser xmlPullParser, String str, long j11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j11 : p0.J0(attributeValue);
    }

    protected static String J(List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = (e) list.get(i11);
            String str = eVar.f78211a;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(eVar.f78212b)) {
                return MimeTypes.AUDIO_E_AC3_JOC;
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && "ec+3".equals(eVar.f78212b)) {
                return MimeTypes.AUDIO_E_AC3_JOC;
            }
        }
        return MimeTypes.AUDIO_E_AC3;
    }

    protected static float N(XmlPullParser xmlPullParser, String str, float f11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? f11 : Float.parseFloat(attributeValue);
    }

    protected static float O(XmlPullParser xmlPullParser, float f11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f11;
        }
        Matcher matcher = f78197b.matcher(attributeValue);
        if (!matcher.matches()) {
            return f11;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        return !TextUtils.isEmpty(matcher.group(2)) ? parseInt / Integer.parseInt(r2) : parseInt;
    }

    protected static int Q(XmlPullParser xmlPullParser, String str, int i11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i11 : Integer.parseInt(attributeValue);
    }

    protected static long S(List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            e eVar = (e) list.get(i11);
            if (com.google.common.base.a.a("http://dashif.org/guidelines/last-segment-number", eVar.f78211a)) {
                return Long.parseLong(eVar.f78212b);
            }
        }
        return -1L;
    }

    protected static long T(XmlPullParser xmlPullParser, String str, long j11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j11 : Long.parseLong(attributeValue);
    }

    protected static int V(XmlPullParser xmlPullParser) {
        int Q = Q(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, -1);
        if (Q < 0) {
            return -1;
        }
        int[] iArr = f78200e;
        if (Q < iArr.length) {
            return iArr[Q];
        }
        return -1;
    }

    private long a(List list, long j11, long j12, int i11, long j13) {
        int m11 = i11 >= 0 ? i11 + 1 : (int) p0.m(j13 - j11, j12);
        for (int i12 = 0; i12 < m11; i12++) {
            list.add(l(j11, j12));
            j11 += j12;
        }
        return j11;
    }

    protected static String n0(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    private static int o(int i11, int i12) {
        if (i11 == -1) {
            return i12;
        }
        if (i12 == -1) {
            return i11;
        }
        com.google.android.exoplayer2.util.a.g(i11 == i12);
        return i11;
    }

    protected static String o0(XmlPullParser xmlPullParser, String str) {
        String str2 = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                str2 = xmlPullParser.getText();
            } else {
                u(xmlPullParser);
            }
        } while (!q0.d(xmlPullParser, str));
        return str2;
    }

    private static String p(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        com.google.android.exoplayer2.util.a.g(str.equals(str2));
        return str;
    }

    private static void q(ArrayList arrayList) {
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

    private static long r(long j11, long j12) {
        if (j12 != C.TIME_UNSET) {
            j11 = j12;
        }
        return j11 == Long.MAX_VALUE ? C.TIME_UNSET : j11;
    }

    private static String s(String str, String str2) {
        if (w.p(str)) {
            return w.c(str2);
        }
        if (w.t(str)) {
            return w.o(str2);
        }
        if (w.s(str)) {
            return MimeTypes.APPLICATION_RAWCC.equals(str) ? w.j(str2) : str;
        }
        if (w.q(str)) {
            return str;
        }
        if (!MimeTypes.APPLICATION_MP4.equals(str)) {
            return null;
        }
        String g11 = w.g(str2);
        return MimeTypes.TEXT_VTT.equals(g11) ? MimeTypes.APPLICATION_MP4VTT : g11;
    }

    private boolean t(String[] strArr) {
        for (String str : strArr) {
            if (str.startsWith("urn:dvb:dash:profile:dvb-dash:")) {
                return true;
            }
        }
        return false;
    }

    public static void u(XmlPullParser xmlPullParser) {
        if (q0.e(xmlPullParser)) {
            int i11 = 1;
            while (i11 != 0) {
                xmlPullParser.next();
                if (q0.e(xmlPullParser)) {
                    i11++;
                } else if (q0.c(xmlPullParser)) {
                    i11--;
                }
            }
        }
    }

    protected List A(XmlPullParser xmlPullParser, List list, boolean z10) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "dvb:priority");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : z10 ? 1 : Integer.MIN_VALUE;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "dvb:weight");
        int parseInt2 = attributeValue2 != null ? Integer.parseInt(attributeValue2) : 1;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "serviceLocation");
        String o02 = o0(xmlPullParser, "BaseURL");
        if (n0.b(o02)) {
            if (attributeValue3 == null) {
                attributeValue3 = o02;
            }
            return Lists.l(new b(o02, attributeValue3, parseInt, parseInt2));
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            b bVar = (b) list.get(i11);
            String d11 = n0.d(bVar.f78180a, o02);
            String str = attributeValue3 == null ? d11 : attributeValue3;
            if (z10) {
                parseInt = bVar.f78182c;
                parseInt2 = bVar.f78183d;
                str = bVar.f78181b;
            }
            arrayList.add(new b(d11, str, parseInt, parseInt2));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0099  */
    /* JADX WARN: Type inference failed for: r4v10, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected android.util.Pair D(org.xmlpull.v1.XmlPullParser r11) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x9.d.D(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    protected int E(XmlPullParser xmlPullParser) {
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
        return MimeTypes.BASE_TYPE_TEXT.equals(attributeValue) ? 3 : -1;
    }

    protected Pair K(XmlPullParser xmlPullParser, String str, String str2, long j11, ByteArrayOutputStream byteArrayOutputStream) {
        long T = T(xmlPullParser, "id", 0L);
        long T2 = T(xmlPullParser, "duration", C.TIME_UNSET);
        long T3 = T(xmlPullParser, "presentationTime", 0L);
        long N0 = p0.N0(T2, 1000L, j11);
        long N02 = p0.N0(T3, 1000000L, j11);
        String n02 = n0(xmlPullParser, "messageData", null);
        byte[] L = L(xmlPullParser, byteArrayOutputStream);
        Long valueOf = Long.valueOf(N02);
        if (n02 != null) {
            L = p0.n0(n02);
        }
        return Pair.create(valueOf, c(str, str2, T, N0, L));
    }

    protected byte[] L(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.reset();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(byteArrayOutputStream, com.google.common.base.c.f30282c.name());
        xmlPullParser.nextToken();
        while (!q0.d(xmlPullParser, "Event")) {
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

    protected f M(XmlPullParser xmlPullParser) {
        String n02 = n0(xmlPullParser, "schemeIdUri", "");
        String n03 = n0(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, "");
        long T = T(xmlPullParser, "timescale", 1L);
        ArrayList arrayList = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        do {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "Event")) {
                arrayList.add(K(xmlPullParser, n02, n03, T, byteArrayOutputStream));
            } else {
                u(xmlPullParser);
            }
        } while (!q0.d(xmlPullParser, "EventStream"));
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            Pair pair = (Pair) arrayList.get(i11);
            jArr[i11] = ((Long) pair.first).longValue();
            eventMessageArr[i11] = (EventMessage) pair.second;
        }
        return d(n02, n03, T, jArr, eventMessageArr);
    }

    protected i P(XmlPullParser xmlPullParser) {
        return Z(xmlPullParser, "sourceURL", "range");
    }

    protected String R(XmlPullParser xmlPullParser) {
        return o0(xmlPullParser, "Label");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x01de A[LOOP:0: B:18:0x00a0->B:26:0x01de, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0199 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected x9.c U(org.xmlpull.v1.XmlPullParser r47, android.net.Uri r48) {
        /*
            Method dump skipped, instructions count: 491
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x9.d.U(org.xmlpull.v1.XmlPullParser, android.net.Uri):x9.c");
    }

    protected Pair W(XmlPullParser xmlPullParser, List list, long j11, long j12, long j13, long j14, boolean z10) {
        long j15;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Object obj;
        long j16;
        k h02;
        d dVar = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        Object obj2 = null;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "id");
        long I = I(xmlPullParser2, "start", j11);
        long j17 = C.TIME_UNSET;
        long j18 = j13 != C.TIME_UNSET ? j13 + I : -9223372036854775807L;
        long I2 = I(xmlPullParser2, "duration", C.TIME_UNSET);
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
            if (q0.f(xmlPullParser2, "BaseURL")) {
                if (!z11) {
                    j19 = dVar.z(xmlPullParser2, j19);
                    z11 = true;
                }
                arrayList6.addAll(dVar.A(xmlPullParser2, list, z10));
                arrayList3 = arrayList5;
                arrayList = arrayList6;
                j16 = j17;
                obj = obj2;
                arrayList2 = arrayList4;
            } else {
                if (q0.f(xmlPullParser2, "AdaptationSet")) {
                    j15 = j19;
                    arrayList = arrayList6;
                    arrayList2 = arrayList4;
                    arrayList2.add(w(xmlPullParser, !arrayList6.isEmpty() ? arrayList6 : list, kVar, I2, j19, j20, j18, j14, z10));
                    xmlPullParser2 = xmlPullParser;
                    arrayList3 = arrayList5;
                } else {
                    j15 = j19;
                    ArrayList arrayList7 = arrayList5;
                    arrayList = arrayList6;
                    arrayList2 = arrayList4;
                    xmlPullParser2 = xmlPullParser;
                    if (q0.f(xmlPullParser2, "EventStream")) {
                        arrayList7.add(M(xmlPullParser));
                        arrayList3 = arrayList7;
                    } else if (q0.f(xmlPullParser2, "SegmentBase")) {
                        arrayList3 = arrayList7;
                        kVar = f0(xmlPullParser2, null);
                        obj = null;
                        j19 = j15;
                        j16 = C.TIME_UNSET;
                    } else {
                        arrayList3 = arrayList7;
                        if (q0.f(xmlPullParser2, "SegmentList")) {
                            long z12 = z(xmlPullParser2, C.TIME_UNSET);
                            obj = null;
                            h02 = g0(xmlPullParser, null, j18, I2, j15, z12, j14);
                            j20 = z12;
                            j19 = j15;
                            j16 = C.TIME_UNSET;
                        } else {
                            obj = null;
                            if (q0.f(xmlPullParser2, "SegmentTemplate")) {
                                long z13 = z(xmlPullParser2, C.TIME_UNSET);
                                j16 = -9223372036854775807L;
                                h02 = h0(xmlPullParser, null, ImmutableList.of(), j18, I2, j15, z13, j14);
                                j20 = z13;
                                j19 = j15;
                            } else {
                                j16 = C.TIME_UNSET;
                                if (q0.f(xmlPullParser2, "AssetIdentifier")) {
                                    eVar = G(xmlPullParser2, "AssetIdentifier");
                                } else {
                                    u(xmlPullParser);
                                }
                                j19 = j15;
                            }
                        }
                        kVar = h02;
                    }
                }
                obj = null;
                j16 = C.TIME_UNSET;
                j19 = j15;
            }
            if (q0.d(xmlPullParser2, "Period")) {
                return Pair.create(g(attributeValue, I, arrayList2, arrayList3, eVar), Long.valueOf(I2));
            }
            arrayList4 = arrayList2;
            arrayList6 = arrayList;
            obj2 = obj;
            arrayList5 = arrayList3;
            j17 = j16;
            dVar = this;
        }
    }

    protected String[] X(XmlPullParser xmlPullParser, String str, String[] strArr) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? strArr : attributeValue.split(",");
    }

    protected h Y(XmlPullParser xmlPullParser) {
        String str = null;
        String n02 = n0(xmlPullParser, "moreInformationURL", null);
        String n03 = n0(xmlPullParser, "lang", null);
        String str2 = null;
        String str3 = null;
        while (true) {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "Title")) {
                str = xmlPullParser.nextText();
            } else if (q0.f(xmlPullParser, "Source")) {
                str2 = xmlPullParser.nextText();
            } else if (q0.f(xmlPullParser, "Copyright")) {
                str3 = xmlPullParser.nextText();
            } else {
                u(xmlPullParser);
            }
            String str4 = str3;
            if (q0.d(xmlPullParser, "ProgramInformation")) {
                return new h(str, str2, str4, n02, n03);
            }
            str3 = str4;
        }
    }

    protected i Z(XmlPullParser xmlPullParser, String str, String str2) {
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

    /* JADX WARN: Removed duplicated region for block: B:11:0x01ee A[LOOP:0: B:2:0x006a->B:11:0x01ee, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0198 A[EDGE_INSN: B:12:0x0198->B:13:0x0198 BREAK  A[LOOP:0: B:2:0x006a->B:11:0x01ee], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected x9.d.a a0(org.xmlpull.v1.XmlPullParser r36, java.util.List r37, java.lang.String r38, java.lang.String r39, int r40, int r41, float r42, int r43, int r44, java.lang.String r45, java.util.List r46, java.util.List r47, java.util.List r48, java.util.List r49, x9.k r50, long r51, long r53, long r55, long r57, long r59, boolean r61) {
        /*
            Method dump skipped, instructions count: 509
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x9.d.a0(org.xmlpull.v1.XmlPullParser, java.util.List, java.lang.String, java.lang.String, int, int, float, int, int, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, x9.k, long, long, long, long, long, boolean):x9.d$a");
    }

    protected x9.a b(int i11, int i12, List list, List list2, List list3, List list4) {
        return new x9.a(i11, i12, list, list2, list3, list4);
    }

    protected int b0(List list) {
        int p02;
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            e eVar = (e) list.get(i12);
            if (com.google.common.base.a.a("urn:mpeg:dash:role:2011", eVar.f78211a)) {
                p02 = c0(eVar.f78212b);
            } else if (com.google.common.base.a.a("urn:tva:metadata:cs:AudioPurposeCS:2007", eVar.f78211a)) {
                p02 = p0(eVar.f78212b);
            }
            i11 |= p02;
        }
        return i11;
    }

    protected EventMessage c(String str, String str2, long j11, long j12, byte[] bArr) {
        return new EventMessage(str, str2, j12, j11, bArr);
    }

    protected int c0(String str) {
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

    protected f d(String str, String str2, long j11, long[] jArr, EventMessage[] eventMessageArr) {
        return new f(str, str2, j11, jArr, eventMessageArr);
    }

    protected int d0(List list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            if (com.google.common.base.a.a("http://dashif.org/guidelines/trickmode", ((e) list.get(i12)).f78211a)) {
                i11 = 16384;
            }
        }
        return i11;
    }

    protected o1 e(String str, String str2, int i11, int i12, float f11, int i13, int i14, int i15, String str3, List list, List list2, String str4, List list3, List list4) {
        String str5 = str4;
        String s11 = s(str2, str5);
        if (MimeTypes.AUDIO_E_AC3.equals(s11)) {
            s11 = J(list4);
            if (MimeTypes.AUDIO_E_AC3_JOC.equals(s11)) {
                str5 = "ec+3";
            }
        }
        o1.b V = new o1.b().S(str).K(str2).e0(s11).I(str5).Z(i15).g0(l0(list)).c0(e0(list) | b0(list2) | d0(list3) | d0(list4)).V(str3);
        if (w.t(s11)) {
            V.j0(i11).Q(i12).P(f11);
        } else if (w.p(s11)) {
            V.H(i13).f0(i14);
        } else if (w.s(s11)) {
            V.F(MimeTypes.APPLICATION_CEA608.equals(s11) ? B(list2) : MimeTypes.APPLICATION_CEA708.equals(s11) ? C(list2) : -1);
        } else if (w.q(s11)) {
            V.j0(i11).Q(i12);
        }
        return V.E();
    }

    protected int e0(List list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            e eVar = (e) list.get(i12);
            if (com.google.common.base.a.a("urn:mpeg:dash:role:2011", eVar.f78211a)) {
                i11 |= c0(eVar.f78212b);
            }
        }
        return i11;
    }

    protected c f(long j11, long j12, long j13, boolean z10, long j14, long j15, long j16, long j17, h hVar, o oVar, l lVar, Uri uri, List list) {
        return new c(j11, j12, j13, z10, j14, j15, j16, j17, hVar, oVar, lVar, uri, list);
    }

    protected k.e f0(XmlPullParser xmlPullParser, k.e eVar) {
        long j11;
        long j12;
        long T = T(xmlPullParser, "timescale", eVar != null ? eVar.f78248b : 1L);
        long T2 = T(xmlPullParser, "presentationTimeOffset", eVar != null ? eVar.f78249c : 0L);
        long j13 = eVar != null ? eVar.f78262d : 0L;
        long j14 = eVar != null ? eVar.f78263e : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            j12 = Long.parseLong(split[0]);
            j11 = (Long.parseLong(split[1]) - j12) + 1;
        } else {
            j11 = j14;
            j12 = j13;
        }
        i iVar = eVar != null ? eVar.f78247a : null;
        do {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "Initialization")) {
                iVar = P(xmlPullParser);
            } else {
                u(xmlPullParser);
            }
        } while (!q0.d(xmlPullParser, "SegmentBase"));
        return m(iVar, T, T2, j12, j11);
    }

    protected g g(String str, long j11, List list, List list2, e eVar) {
        return new g(str, j11, list, list2, eVar);
    }

    protected k.b g0(XmlPullParser xmlPullParser, k.b bVar, long j11, long j12, long j13, long j14, long j15) {
        long T = T(xmlPullParser, "timescale", bVar != null ? bVar.f78248b : 1L);
        long T2 = T(xmlPullParser, "presentationTimeOffset", bVar != null ? bVar.f78249c : 0L);
        long T3 = T(xmlPullParser, "duration", bVar != null ? bVar.f78251e : C.TIME_UNSET);
        long T4 = T(xmlPullParser, "startNumber", bVar != null ? bVar.f78250d : 1L);
        long r11 = r(j13, j14);
        List list = null;
        List list2 = null;
        i iVar = null;
        do {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "Initialization")) {
                iVar = P(xmlPullParser);
            } else if (q0.f(xmlPullParser, "SegmentTimeline")) {
                list = i0(xmlPullParser, T, j12);
            } else if (q0.f(xmlPullParser, "SegmentURL")) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(j0(xmlPullParser));
            } else {
                u(xmlPullParser);
            }
        } while (!q0.d(xmlPullParser, "SegmentList"));
        if (bVar != null) {
            if (iVar == null) {
                iVar = bVar.f78247a;
            }
            if (list == null) {
                list = bVar.f78252f;
            }
            if (list2 == null) {
                list2 = bVar.f78256j;
            }
        }
        return j(iVar, T, T2, T4, T3, list, r11, list2, j15, j11);
    }

    protected i h(String str, long j11, long j12) {
        return new i(str, j11, j12);
    }

    protected k.c h0(XmlPullParser xmlPullParser, k.c cVar, List list, long j11, long j12, long j13, long j14, long j15) {
        long T = T(xmlPullParser, "timescale", cVar != null ? cVar.f78248b : 1L);
        long T2 = T(xmlPullParser, "presentationTimeOffset", cVar != null ? cVar.f78249c : 0L);
        long T3 = T(xmlPullParser, "duration", cVar != null ? cVar.f78251e : C.TIME_UNSET);
        long T4 = T(xmlPullParser, "startNumber", cVar != null ? cVar.f78250d : 1L);
        long S = S(list);
        long r11 = r(j13, j14);
        List list2 = null;
        n q02 = q0(xmlPullParser, "media", cVar != null ? cVar.f78258k : null);
        n q03 = q0(xmlPullParser, "initialization", cVar != null ? cVar.f78257j : null);
        i iVar = null;
        do {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "Initialization")) {
                iVar = P(xmlPullParser);
            } else if (q0.f(xmlPullParser, "SegmentTimeline")) {
                list2 = i0(xmlPullParser, T, j12);
            } else {
                u(xmlPullParser);
            }
        } while (!q0.d(xmlPullParser, "SegmentTemplate"));
        if (cVar != null) {
            if (iVar == null) {
                iVar = cVar.f78247a;
            }
            if (list2 == null) {
                list2 = cVar.f78252f;
            }
        }
        return k(iVar, T, T2, T4, S, T3, list2, r11, q03, q02, j15, j11);
    }

    protected j i(a aVar, String str, String str2, ArrayList arrayList, ArrayList arrayList2) {
        o1.b b11 = aVar.f78202a.b();
        if (str != null) {
            b11.U(str);
        }
        String str3 = aVar.f78205d;
        if (str3 != null) {
            str2 = str3;
        }
        ArrayList arrayList3 = aVar.f78206e;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            q(arrayList3);
            b11.M(new DrmInitData(str2, arrayList3));
        }
        ArrayList arrayList4 = aVar.f78207f;
        arrayList4.addAll(arrayList2);
        return j.n(aVar.f78208g, b11.E(), aVar.f78203b, aVar.f78204c, arrayList4, aVar.f78209h, aVar.f78210i, null);
    }

    protected List i0(XmlPullParser xmlPullParser, long j11, long j12) {
        ArrayList arrayList = new ArrayList();
        long j13 = 0;
        long j14 = -9223372036854775807L;
        boolean z10 = false;
        int i11 = 0;
        do {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "S")) {
                long T = T(xmlPullParser, "t", C.TIME_UNSET);
                if (z10) {
                    j13 = a(arrayList, j13, j14, i11, T);
                }
                if (T == C.TIME_UNSET) {
                    T = j13;
                }
                j14 = T(xmlPullParser, "d", C.TIME_UNSET);
                i11 = Q(xmlPullParser, CampaignEx.JSON_KEY_AD_R, 0);
                z10 = true;
                j13 = T;
            } else {
                u(xmlPullParser);
            }
        } while (!q0.d(xmlPullParser, "SegmentTimeline"));
        if (z10) {
            a(arrayList, j13, j14, i11, p0.N0(j12, j11, 1000L));
        }
        return arrayList;
    }

    protected k.b j(i iVar, long j11, long j12, long j13, long j14, List list, long j15, List list2, long j16, long j17) {
        return new k.b(iVar, j11, j12, j13, j14, list, j15, list2, p0.B0(j16), p0.B0(j17));
    }

    protected i j0(XmlPullParser xmlPullParser) {
        return Z(xmlPullParser, "media", "mediaRange");
    }

    protected k.c k(i iVar, long j11, long j12, long j13, long j14, long j15, List list, long j16, n nVar, n nVar2, long j17, long j18) {
        return new k.c(iVar, j11, j12, j13, j14, j15, list, j16, nVar, nVar2, p0.B0(j17), p0.B0(j18));
    }

    protected int k0(String str) {
        if (str == null) {
            return 0;
        }
        return (str.equals("forced_subtitle") || str.equals("forced-subtitle")) ? 2 : 0;
    }

    protected k.d l(long j11, long j12) {
        return new k.d(j11, j12);
    }

    protected int l0(List list) {
        int i11 = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            e eVar = (e) list.get(i12);
            if (com.google.common.base.a.a("urn:mpeg:dash:role:2011", eVar.f78211a)) {
                i11 |= k0(eVar.f78212b);
            }
        }
        return i11;
    }

    protected k.e m(i iVar, long j11, long j12, long j13, long j14) {
        return new k.e(iVar, j11, j12, j13, j14);
    }

    protected l m0(XmlPullParser xmlPullParser) {
        long j11 = -9223372036854775807L;
        long j12 = -9223372036854775807L;
        long j13 = -9223372036854775807L;
        float f11 = -3.4028235E38f;
        float f12 = -3.4028235E38f;
        while (true) {
            xmlPullParser.next();
            if (q0.f(xmlPullParser, "Latency")) {
                j11 = T(xmlPullParser, "target", C.TIME_UNSET);
                j12 = T(xmlPullParser, "min", C.TIME_UNSET);
                j13 = T(xmlPullParser, "max", C.TIME_UNSET);
            } else if (q0.f(xmlPullParser, "PlaybackRate")) {
                f11 = N(xmlPullParser, "min", -3.4028235E38f);
                f12 = N(xmlPullParser, "max", -3.4028235E38f);
            }
            long j14 = j11;
            long j15 = j12;
            long j16 = j13;
            float f13 = f11;
            float f14 = f12;
            if (q0.d(xmlPullParser, "ServiceDescription")) {
                return new l(j14, j15, j16, f13, f14);
            }
            j11 = j14;
            j12 = j15;
            j13 = j16;
            f11 = f13;
            f12 = f14;
        }
    }

    protected o n(String str, String str2) {
        return new o(str, str2);
    }

    protected int p0(String str) {
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

    protected n q0(XmlPullParser xmlPullParser, String str, n nVar) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? n.b(attributeValue) : nVar;
    }

    protected o r0(XmlPullParser xmlPullParser) {
        return n(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, AppMeasurementSdk.ConditionalUserProperty.VALUE));
    }

    @Override // com.google.android.exoplayer2.upstream.b0.a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public c parse(Uri uri, InputStream inputStream) {
        try {
            XmlPullParser newPullParser = this.f78201a.newPullParser();
            newPullParser.setInput(inputStream, null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return U(newPullParser, uri);
            }
            throw ParserException.createForMalformedManifest("inputStream does not contain a valid media presentation description", null);
        } catch (XmlPullParserException e11) {
            throw ParserException.createForMalformedManifest(null, e11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x030e A[LOOP:0: B:2:0x007c->B:10:0x030e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x02ce A[EDGE_INSN: B:11:0x02ce->B:12:0x02ce BREAK  A[LOOP:0: B:2:0x007c->B:10:0x030e], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected x9.a w(org.xmlpull.v1.XmlPullParser r55, java.util.List r56, x9.k r57, long r58, long r60, long r62, long r64, long r66, boolean r68) {
        /*
            Method dump skipped, instructions count: 810
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x9.d.w(org.xmlpull.v1.XmlPullParser, java.util.List, x9.k, long, long, long, long, long, boolean):x9.a");
    }

    protected void x(XmlPullParser xmlPullParser) {
        u(xmlPullParser);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected int y(XmlPullParser xmlPullParser) {
        char c11;
        String n02 = n0(xmlPullParser, "schemeIdUri", null);
        n02.hashCode();
        int i11 = -1;
        switch (n02.hashCode()) {
            case -1352850286:
                if (n02.equals("urn:mpeg:dash:23003:3:audio_channel_configuration:2011")) {
                    c11 = 0;
                    break;
                }
                c11 = 65535;
                break;
            case -1138141449:
                if (n02.equals("tag:dolby.com,2014:dash:audio_channel_configuration:2011")) {
                    c11 = 1;
                    break;
                }
                c11 = 65535;
                break;
            case -986633423:
                if (n02.equals("urn:mpeg:mpegB:cicp:ChannelConfiguration")) {
                    c11 = 2;
                    break;
                }
                c11 = 65535;
                break;
            case 2036691300:
                if (n02.equals("urn:dolby:dash:audio_channel_configuration:2011")) {
                    c11 = 3;
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
                i11 = Q(xmlPullParser, AppMeasurementSdk.ConditionalUserProperty.VALUE, -1);
                break;
            case 1:
            case 3:
                i11 = H(xmlPullParser);
                break;
            case 2:
                i11 = V(xmlPullParser);
                break;
        }
        do {
            xmlPullParser.next();
        } while (!q0.d(xmlPullParser, "AudioChannelConfiguration"));
        return i11;
    }

    protected long z(XmlPullParser xmlPullParser, long j11) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j11;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return Float.parseFloat(attributeValue) * 1000000.0f;
    }
}
