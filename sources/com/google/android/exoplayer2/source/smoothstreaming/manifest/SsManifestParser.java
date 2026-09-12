package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.util.f;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import o9.l;
import o9.p;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes3.dex */
public class SsManifestParser implements b0.a {

    /* renamed from: a, reason: collision with root package name */
    private final XmlPullParserFactory f26631a;

    /* loaded from: classes3.dex */
    public static class MissingFieldException extends ParserException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public MissingFieldException(java.lang.String r4) {
            /*
                r3 = this;
                java.lang.String r4 = java.lang.String.valueOf(r4)
                int r0 = r4.length()
                java.lang.String r1 = "Missing required field: "
                if (r0 == 0) goto L11
                java.lang.String r4 = r1.concat(r4)
                goto L16
            L11:
                java.lang.String r4 = new java.lang.String
                r4.<init>(r1)
            L16:
                r0 = 1
                r1 = 4
                r2 = 0
                r3.<init>(r4, r2, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.MissingFieldException.<init>(java.lang.String):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f26632a;

        /* renamed from: b, reason: collision with root package name */
        private final String f26633b;

        /* renamed from: c, reason: collision with root package name */
        private final a f26634c;

        /* renamed from: d, reason: collision with root package name */
        private final List f26635d = new LinkedList();

        public a(a aVar, String str, String str2) {
            this.f26634c = aVar;
            this.f26632a = str;
            this.f26633b = str2;
        }

        private a e(a aVar, String str, String str2) {
            if ("QualityLevel".equals(str)) {
                return new c(aVar, str2);
            }
            if ("Protection".equals(str)) {
                return new b(aVar, str2);
            }
            if ("StreamIndex".equals(str)) {
                return new e(aVar, str2);
            }
            return null;
        }

        protected void a(Object obj) {
        }

        protected abstract Object b();

        protected final Object c(String str) {
            for (int i11 = 0; i11 < this.f26635d.size(); i11++) {
                Pair pair = (Pair) this.f26635d.get(i11);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
            }
            a aVar = this.f26634c;
            if (aVar == null) {
                return null;
            }
            return aVar.c(str);
        }

        protected boolean d(String str) {
            return false;
        }

        public final Object f(XmlPullParser xmlPullParser) {
            boolean z10 = false;
            int i11 = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (this.f26633b.equals(name)) {
                        n(xmlPullParser);
                        z10 = true;
                    } else if (z10) {
                        if (i11 > 0) {
                            i11++;
                        } else if (d(name)) {
                            n(xmlPullParser);
                        } else {
                            a e11 = e(this, name, this.f26632a);
                            if (e11 == null) {
                                i11 = 1;
                            } else {
                                a(e11.f(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z10 && i11 == 0) {
                        o(xmlPullParser);
                    }
                } else if (!z10) {
                    continue;
                } else if (i11 > 0) {
                    i11--;
                } else {
                    String name2 = xmlPullParser.getName();
                    h(xmlPullParser);
                    if (!d(name2)) {
                        return b();
                    }
                }
                xmlPullParser.next();
            }
        }

        protected final boolean g(XmlPullParser xmlPullParser, String str, boolean z10) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue != null ? Boolean.parseBoolean(attributeValue) : z10;
        }

        protected void h(XmlPullParser xmlPullParser) {
        }

        protected final int i(XmlPullParser xmlPullParser, String str, int i11) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return i11;
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e11) {
                throw ParserException.createForMalformedManifest(null, e11);
            }
        }

        protected final long j(XmlPullParser xmlPullParser, String str, long j11) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return j11;
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e11) {
                throw ParserException.createForMalformedManifest(null, e11);
            }
        }

        protected final int k(XmlPullParser xmlPullParser, String str) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                throw new MissingFieldException(str);
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e11) {
                throw ParserException.createForMalformedManifest(null, e11);
            }
        }

        protected final long l(XmlPullParser xmlPullParser, String str) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                throw new MissingFieldException(str);
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e11) {
                throw ParserException.createForMalformedManifest(null, e11);
            }
        }

        protected final String m(XmlPullParser xmlPullParser, String str) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new MissingFieldException(str);
        }

        protected abstract void n(XmlPullParser xmlPullParser);

        protected void o(XmlPullParser xmlPullParser) {
        }

        protected final void p(String str, Object obj) {
            this.f26635d.add(Pair.create(str, obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b extends a {

        /* renamed from: e, reason: collision with root package name */
        private boolean f26636e;

        /* renamed from: f, reason: collision with root package name */
        private UUID f26637f;

        /* renamed from: g, reason: collision with root package name */
        private byte[] f26638g;

        public b(a aVar, String str) {
            super(aVar, str, "Protection");
        }

        private static p[] q(byte[] bArr) {
            return new p[]{new p(true, null, 8, r(bArr), 0, 0, null)};
        }

        private static byte[] r(byte[] bArr) {
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < bArr.length; i11 += 2) {
                sb2.append((char) bArr[i11]);
            }
            String sb3 = sb2.toString();
            byte[] decode = Base64.decode(sb3.substring(sb3.indexOf("<KID>") + 5, sb3.indexOf("</KID>")), 0);
            t(decode, 0, 3);
            t(decode, 1, 2);
            t(decode, 4, 5);
            t(decode, 6, 7);
            return decode;
        }

        private static String s(String str) {
            return (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') ? str.substring(1, str.length() - 1) : str;
        }

        private static void t(byte[] bArr, int i11, int i12) {
            byte b11 = bArr[i11];
            bArr[i11] = bArr[i12];
            bArr[i12] = b11;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            UUID uuid = this.f26637f;
            return new a.C0378a(uuid, l.a(uuid, this.f26638g), q(this.f26638g));
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean d(String str) {
            return "ProtectionHeader".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void h(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f26636e = false;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) {
            if ("ProtectionHeader".equals(xmlPullParser.getName())) {
                this.f26636e = true;
                this.f26637f = UUID.fromString(s(xmlPullParser.getAttributeValue(null, "SystemID")));
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void o(XmlPullParser xmlPullParser) {
            if (this.f26636e) {
                this.f26638g = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c extends a {

        /* renamed from: e, reason: collision with root package name */
        private o1 f26639e;

        public c(a aVar, String str) {
            super(aVar, str, "QualityLevel");
        }

        private static List q(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] J = p0.J(str);
                byte[][] i11 = f.i(J);
                if (i11 == null) {
                    arrayList.add(J);
                } else {
                    Collections.addAll(arrayList, i11);
                }
            }
            return arrayList;
        }

        private static String r(String str) {
            if (str.equalsIgnoreCase("H264") || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1") || str.equalsIgnoreCase("DAVC")) {
                return MimeTypes.VIDEO_H264;
            }
            if (str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH") || str.equalsIgnoreCase("AACP")) {
                return MimeTypes.AUDIO_AAC;
            }
            if (str.equalsIgnoreCase("TTML") || str.equalsIgnoreCase("DFXP")) {
                return MimeTypes.APPLICATION_TTML;
            }
            if (str.equalsIgnoreCase("ac-3") || str.equalsIgnoreCase("dac3")) {
                return MimeTypes.AUDIO_AC3;
            }
            if (str.equalsIgnoreCase("ec-3") || str.equalsIgnoreCase("dec3")) {
                return MimeTypes.AUDIO_E_AC3;
            }
            if (str.equalsIgnoreCase("dtsc")) {
                return MimeTypes.AUDIO_DTS;
            }
            if (str.equalsIgnoreCase("dtsh") || str.equalsIgnoreCase("dtsl")) {
                return MimeTypes.AUDIO_DTS_HD;
            }
            if (str.equalsIgnoreCase("dtse")) {
                return MimeTypes.AUDIO_DTS_EXPRESS;
            }
            if (str.equalsIgnoreCase("opus")) {
                return MimeTypes.AUDIO_OPUS;
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            return this.f26639e;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) {
            int i11;
            o1.b bVar = new o1.b();
            String r11 = r(m(xmlPullParser, "FourCC"));
            int intValue = ((Integer) c("Type")).intValue();
            if (intValue == 2) {
                bVar.K(MimeTypes.VIDEO_MP4).j0(k(xmlPullParser, "MaxWidth")).Q(k(xmlPullParser, "MaxHeight")).T(q(xmlPullParser.getAttributeValue(null, "CodecPrivateData")));
            } else if (intValue == 1) {
                if (r11 == null) {
                    r11 = MimeTypes.AUDIO_AAC;
                }
                int k11 = k(xmlPullParser, "Channels");
                int k12 = k(xmlPullParser, "SamplingRate");
                List q11 = q(xmlPullParser.getAttributeValue(null, "CodecPrivateData"));
                if (q11.isEmpty() && MimeTypes.AUDIO_AAC.equals(r11)) {
                    q11 = Collections.singletonList(com.google.android.exoplayer2.audio.a.a(k12, k11));
                }
                bVar.K(MimeTypes.AUDIO_MP4).H(k11).f0(k12).T(q11);
            } else if (intValue == 3) {
                String str = (String) c("Subtype");
                if (str != null) {
                    if (str.equals("CAPT")) {
                        i11 = 64;
                    } else if (str.equals("DESC")) {
                        i11 = 1024;
                    }
                    bVar.K(MimeTypes.APPLICATION_MP4).c0(i11);
                }
                i11 = 0;
                bVar.K(MimeTypes.APPLICATION_MP4).c0(i11);
            } else {
                bVar.K(MimeTypes.APPLICATION_MP4);
            }
            this.f26639e = bVar.S(xmlPullParser.getAttributeValue(null, "Index")).U((String) c("Name")).e0(r11).G(k(xmlPullParser, "Bitrate")).V((String) c("Language")).E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class d extends a {

        /* renamed from: e, reason: collision with root package name */
        private final List f26640e;

        /* renamed from: f, reason: collision with root package name */
        private int f26641f;

        /* renamed from: g, reason: collision with root package name */
        private int f26642g;

        /* renamed from: h, reason: collision with root package name */
        private long f26643h;

        /* renamed from: i, reason: collision with root package name */
        private long f26644i;

        /* renamed from: j, reason: collision with root package name */
        private long f26645j;

        /* renamed from: k, reason: collision with root package name */
        private int f26646k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f26647l;

        /* renamed from: m, reason: collision with root package name */
        private a.C0378a f26648m;

        public d(a aVar, String str) {
            super(aVar, str, "SmoothStreamingMedia");
            this.f26646k = -1;
            this.f26648m = null;
            this.f26640e = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void a(Object obj) {
            if (obj instanceof a.b) {
                this.f26640e.add((a.b) obj);
            } else if (obj instanceof a.C0378a) {
                com.google.android.exoplayer2.util.a.g(this.f26648m == null);
                this.f26648m = (a.C0378a) obj;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            int size = this.f26640e.size();
            a.b[] bVarArr = new a.b[size];
            this.f26640e.toArray(bVarArr);
            if (this.f26648m != null) {
                a.C0378a c0378a = this.f26648m;
                DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(c0378a.f26671a, MimeTypes.VIDEO_MP4, c0378a.f26672b));
                for (int i11 = 0; i11 < size; i11++) {
                    a.b bVar = bVarArr[i11];
                    int i12 = bVar.f26674a;
                    if (i12 == 2 || i12 == 1) {
                        o1[] o1VarArr = bVar.f26683j;
                        for (int i13 = 0; i13 < o1VarArr.length; i13++) {
                            o1VarArr[i13] = o1VarArr[i13].b().M(drmInitData).E();
                        }
                    }
                }
            }
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.a(this.f26641f, this.f26642g, this.f26643h, this.f26644i, this.f26645j, this.f26646k, this.f26647l, this.f26648m, bVarArr);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) {
            this.f26641f = k(xmlPullParser, "MajorVersion");
            this.f26642g = k(xmlPullParser, "MinorVersion");
            this.f26643h = j(xmlPullParser, "TimeScale", 10000000L);
            this.f26644i = l(xmlPullParser, "Duration");
            this.f26645j = j(xmlPullParser, "DVRWindowLength", 0L);
            this.f26646k = i(xmlPullParser, "LookaheadCount", -1);
            this.f26647l = g(xmlPullParser, "IsLive", false);
            p("TimeScale", Long.valueOf(this.f26643h));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class e extends a {

        /* renamed from: e, reason: collision with root package name */
        private final String f26649e;

        /* renamed from: f, reason: collision with root package name */
        private final List f26650f;

        /* renamed from: g, reason: collision with root package name */
        private int f26651g;

        /* renamed from: h, reason: collision with root package name */
        private String f26652h;

        /* renamed from: i, reason: collision with root package name */
        private long f26653i;

        /* renamed from: j, reason: collision with root package name */
        private String f26654j;

        /* renamed from: k, reason: collision with root package name */
        private String f26655k;

        /* renamed from: l, reason: collision with root package name */
        private int f26656l;

        /* renamed from: m, reason: collision with root package name */
        private int f26657m;

        /* renamed from: n, reason: collision with root package name */
        private int f26658n;

        /* renamed from: o, reason: collision with root package name */
        private int f26659o;

        /* renamed from: p, reason: collision with root package name */
        private String f26660p;

        /* renamed from: q, reason: collision with root package name */
        private ArrayList f26661q;

        /* renamed from: r, reason: collision with root package name */
        private long f26662r;

        public e(a aVar, String str) {
            super(aVar, str, "StreamIndex");
            this.f26649e = str;
            this.f26650f = new LinkedList();
        }

        private void q(XmlPullParser xmlPullParser) {
            int s11 = s(xmlPullParser);
            this.f26651g = s11;
            p("Type", Integer.valueOf(s11));
            if (this.f26651g == 3) {
                this.f26652h = m(xmlPullParser, "Subtype");
            } else {
                this.f26652h = xmlPullParser.getAttributeValue(null, "Subtype");
            }
            p("Subtype", this.f26652h);
            String attributeValue = xmlPullParser.getAttributeValue(null, "Name");
            this.f26654j = attributeValue;
            p("Name", attributeValue);
            this.f26655k = m(xmlPullParser, "Url");
            this.f26656l = i(xmlPullParser, "MaxWidth", -1);
            this.f26657m = i(xmlPullParser, "MaxHeight", -1);
            this.f26658n = i(xmlPullParser, "DisplayWidth", -1);
            this.f26659o = i(xmlPullParser, "DisplayHeight", -1);
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "Language");
            this.f26660p = attributeValue2;
            p("Language", attributeValue2);
            long i11 = i(xmlPullParser, "TimeScale", -1);
            this.f26653i = i11;
            if (i11 == -1) {
                this.f26653i = ((Long) c("TimeScale")).longValue();
            }
            this.f26661q = new ArrayList();
        }

        private void r(XmlPullParser xmlPullParser) {
            int size = this.f26661q.size();
            long j11 = j(xmlPullParser, "t", C.TIME_UNSET);
            int i11 = 1;
            if (j11 == C.TIME_UNSET) {
                if (size == 0) {
                    j11 = 0;
                } else {
                    if (this.f26662r == -1) {
                        throw ParserException.createForMalformedManifest("Unable to infer start time", null);
                    }
                    j11 = this.f26662r + ((Long) this.f26661q.get(size - 1)).longValue();
                }
            }
            this.f26661q.add(Long.valueOf(j11));
            this.f26662r = j(xmlPullParser, "d", C.TIME_UNSET);
            long j12 = j(xmlPullParser, CampaignEx.JSON_KEY_AD_R, 1L);
            if (j12 > 1 && this.f26662r == C.TIME_UNSET) {
                throw ParserException.createForMalformedManifest("Repeated chunk with unspecified duration", null);
            }
            while (true) {
                long j13 = i11;
                if (j13 >= j12) {
                    return;
                }
                this.f26661q.add(Long.valueOf((this.f26662r * j13) + j11));
                i11++;
            }
        }

        private int s(XmlPullParser xmlPullParser) {
            String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
            if (attributeValue == null) {
                throw new MissingFieldException("Type");
            }
            if (MimeTypes.BASE_TYPE_AUDIO.equalsIgnoreCase(attributeValue)) {
                return 1;
            }
            if ("video".equalsIgnoreCase(attributeValue)) {
                return 2;
            }
            if (MimeTypes.BASE_TYPE_TEXT.equalsIgnoreCase(attributeValue)) {
                return 3;
            }
            StringBuilder sb2 = new StringBuilder(attributeValue.length() + 19);
            sb2.append("Invalid key value[");
            sb2.append(attributeValue);
            sb2.append("]");
            throw ParserException.createForMalformedManifest(sb2.toString(), null);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void a(Object obj) {
            if (obj instanceof o1) {
                this.f26650f.add((o1) obj);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            o1[] o1VarArr = new o1[this.f26650f.size()];
            this.f26650f.toArray(o1VarArr);
            return new a.b(this.f26649e, this.f26655k, this.f26651g, this.f26652h, this.f26653i, this.f26654j, this.f26656l, this.f26657m, this.f26658n, this.f26659o, this.f26660p, o1VarArr, this.f26661q, this.f26662r);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean d(String str) {
            return "c".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) {
            if ("c".equals(xmlPullParser.getName())) {
                r(xmlPullParser);
            } else {
                q(xmlPullParser);
            }
        }
    }

    public SsManifestParser() {
        try {
            this.f26631a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e11) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e11);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.b0.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a parse(Uri uri, InputStream inputStream) {
        try {
            XmlPullParser newPullParser = this.f26631a.newPullParser();
            newPullParser.setInput(inputStream, null);
            return (com.google.android.exoplayer2.source.smoothstreaming.manifest.a) new d(null, uri.toString()).f(newPullParser);
        } catch (XmlPullParserException e11) {
            throw ParserException.createForMalformedManifest(null, e11);
        }
    }
}
